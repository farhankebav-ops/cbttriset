package androidx.camera.camera2.internal;

import android.content.Context;
import android.graphics.SurfaceTexture;
import android.hardware.camera2.CameraDevice;
import android.hardware.camera2.CameraManager;
import android.media.CamcorderProfile;
import android.os.Handler;
import android.os.SystemClock;
import android.text.TextUtils;
import android.util.Rational;
import android.util.Size;
import android.view.Surface;
import androidx.annotation.GuardedBy;
import androidx.annotation.OptIn;
import androidx.annotation.VisibleForTesting;
import androidx.camera.camera2.internal.SynchronizedCaptureSession;
import androidx.camera.camera2.internal.compat.ApiCompat;
import androidx.camera.camera2.internal.compat.CameraAccessExceptionCompat;
import androidx.camera.camera2.internal.compat.CameraCharacteristicsCompat;
import androidx.camera.camera2.internal.compat.CameraManagerCompat;
import androidx.camera.camera2.internal.compat.params.DynamicRangesCompat;
import androidx.camera.camera2.internal.compat.quirk.DeviceQuirks;
import androidx.camera.camera2.internal.compat.quirk.LegacyCameraSurfaceCleanupQuirk;
import androidx.camera.camera2.internal.compat.workaround.CloseCameraBeforeCreateNewSession;
import androidx.camera.camera2.interop.Camera2CaptureRequestConfigurator;
import androidx.camera.camera2.interop.Camera2CaptureRequestConfiguratorKt;
import androidx.camera.camera2.interop.ExperimentalCamera2Interop;
import androidx.camera.core.CameraControl;
import androidx.camera.core.CameraInfo;
import androidx.camera.core.CameraState;
import androidx.camera.core.CameraUnavailableException;
import androidx.camera.core.CameraXConfig;
import androidx.camera.core.Logger;
import androidx.camera.core.Preview;
import androidx.camera.core.UseCase;
import androidx.camera.core.concurrent.CameraCoordinator;
import androidx.camera.core.featuregroup.impl.FeatureCombinationQuery;
import androidx.camera.core.impl.AttachedSurfaceInfo;
import androidx.camera.core.impl.CameraConfig;
import androidx.camera.core.impl.CameraConfigs;
import androidx.camera.core.impl.CameraControlInternal;
import androidx.camera.core.impl.CameraInfoInternal;
import androidx.camera.core.impl.CameraInternal;
import androidx.camera.core.impl.CameraStateRegistry;
import androidx.camera.core.impl.CaptureConfig;
import androidx.camera.core.impl.DeferrableSurface;
import androidx.camera.core.impl.ImmediateSurface;
import androidx.camera.core.impl.LiveDataObservable;
import androidx.camera.core.impl.Observable;
import androidx.camera.core.impl.SessionConfig;
import androidx.camera.core.impl.SessionProcessor;
import androidx.camera.core.impl.StreamSpec;
import androidx.camera.core.impl.UseCaseAttachState;
import androidx.camera.core.impl.UseCaseConfig;
import androidx.camera.core.impl.UseCaseConfigFactory;
import androidx.camera.core.impl.utils.executor.CameraXExecutors;
import androidx.camera.core.impl.utils.futures.FutureCallback;
import androidx.camera.core.impl.utils.futures.FutureChain;
import androidx.camera.core.impl.utils.futures.Futures;
import androidx.camera.core.streamsharing.StreamSharing;
import androidx.concurrent.futures.CallbackToFutureAdapter;
import androidx.core.util.Preconditions;
import androidx.tracing.Trace;
import androidx.work.PeriodicWorkRequest;
import com.ironsource.C2300e4;
import com.unity3d.services.UnityAdsConstants;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Objects;
import java.util.Set;
import java.util.concurrent.CancellationException;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executor;
import java.util.concurrent.RejectedExecutionException;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes.dex */
final class Camera2CameraImpl implements CameraInternal {
    private static final int ERROR_NONE = 0;
    private static final String TAG = "Camera2CameraImpl";
    final CameraAvailability mCameraAvailability;
    private final CameraCharacteristicsCompat mCameraCharacteristicsCompat;
    private CameraConfig mCameraConfig;
    final CameraConfigureAvailable mCameraConfigureAvailable;
    private final Camera2CameraControlImpl mCameraControlInternal;
    final CameraCoordinator mCameraCoordinator;
    CameraDevice mCameraDevice;
    int mCameraDeviceError;
    final Camera2CameraInfoImpl mCameraInfoInternal;
    private final CameraManagerCompat mCameraManager;
    private final CameraStateMachine mCameraStateMachine;
    final CameraStateRegistry mCameraStateRegistry;
    private final CameraXConfig mCameraXConfig;
    CaptureSessionInterface mCaptureSession;
    private final SynchronizedCaptureSession.OpenerBuilder mCaptureSessionOpenerBuilder;
    private final CaptureSessionRepository mCaptureSessionRepository;
    private final boolean mConfigAndCloseQuirk;
    private final DisplayInfoManager mDisplayInfoManager;
    private final DynamicRangesCompat mDynamicRangesCompat;
    private final ErrorTimeoutReopenScheduler mErrorTimeoutReopenScheduler;
    private final Executor mExecutor;
    boolean mIsActiveResumingMode;
    private boolean mIsConfigAndCloseRequired;
    private boolean mIsConfiguringForClose;
    private boolean mIsPrimary;
    final Object mLock;
    private MeteringRepeatingSession mMeteringRepeatingSession;
    private final LiveDataObservable<CameraInternal.State> mObservableState;
    final AtomicInteger mReleaseRequestCount;
    final Map<CaptureSessionInterface, j2.q> mReleasedCaptureSessions;
    private final ScheduledExecutorService mScheduledExecutorService;

    @GuardedBy("mLock")
    private SessionProcessor mSessionProcessor;
    private final Set<String> mSessionStartNotifiedUseCases;
    private final boolean mShouldCloseCameraBeforeCreateNewSession;
    volatile InternalState mState = InternalState.INITIALIZED;
    private final StateCallback mStateCallback;
    private final SupportedSurfaceCombination mSupportedSurfaceCombination;
    private int mTraceStateErrorCount;
    private final UseCaseAttachState mUseCaseAttachState;
    j2.q mUserReleaseFuture;
    CallbackToFutureAdapter.Completer<Void> mUserReleaseNotifier;

    /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
    public final class CameraAvailability extends CameraManager.AvailabilityCallback implements CameraStateRegistry.OnOpenAvailableListener {
        private boolean mCameraAvailable = true;
        private final String mCameraId;

        public CameraAvailability(String str) {
            this.mCameraId = str;
        }

        public boolean isCameraAvailable() {
            return this.mCameraAvailable;
        }

        @Override // android.hardware.camera2.CameraManager.AvailabilityCallback
        public void onCameraAvailable(String str) {
            if (this.mCameraId.equals(str)) {
                this.mCameraAvailable = true;
                if (Camera2CameraImpl.this.mState == InternalState.PENDING_OPEN || Camera2CameraImpl.this.mState == InternalState.OPENING_WITH_ERROR) {
                    Camera2CameraImpl.this.tryOpenCameraDevice(false);
                }
            }
        }

        @Override // android.hardware.camera2.CameraManager.AvailabilityCallback
        public void onCameraUnavailable(String str) {
            if (this.mCameraId.equals(str)) {
                this.mCameraAvailable = false;
            }
        }

        @Override // androidx.camera.core.impl.CameraStateRegistry.OnOpenAvailableListener
        public void onOpenAvailable() {
            if (Camera2CameraImpl.this.mState == InternalState.PENDING_OPEN || Camera2CameraImpl.this.mState == InternalState.OPENING_WITH_ERROR) {
                Camera2CameraImpl.this.tryOpenCameraDevice(false);
            }
        }
    }

    /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
    public final class CameraConfigureAvailable implements CameraStateRegistry.OnConfigureAvailableListener {
        public CameraConfigureAvailable() {
        }

        @Override // androidx.camera.core.impl.CameraStateRegistry.OnConfigureAvailableListener
        public void onConfigureAvailable() {
            if (Camera2CameraImpl.this.mState == InternalState.OPENED) {
                Camera2CameraImpl.this.openCaptureSession();
            }
        }
    }

    /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
    public final class ControlUpdateListenerInternal implements CameraControlInternal.ControlUpdateCallback {
        public ControlUpdateListenerInternal() {
        }

        @Override // androidx.camera.core.impl.CameraControlInternal.ControlUpdateCallback
        public void onCameraControlCaptureRequests(List<CaptureConfig> list) {
            Camera2CameraImpl.this.submitCaptureRequests((List) Preconditions.checkNotNull(list));
        }

        @Override // androidx.camera.core.impl.CameraControlInternal.ControlUpdateCallback
        public void onCameraControlUpdateSessionConfig() {
            Camera2CameraImpl.this.updateCaptureSessionConfig();
        }
    }

    /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
    public class ErrorTimeoutReopenScheduler {
        private static final long ERROR_TIMEOUT_MILLIS = 2000;
        private ScheduleNode mScheduleNode;

        /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
        public class ScheduleNode {
            private final AtomicBoolean mIsDone = new AtomicBoolean(false);
            private final ScheduledFuture<?> mScheduledFuture;

            public ScheduleNode() {
                this.mScheduledFuture = Camera2CameraImpl.this.mScheduledExecutorService.schedule(new t(this, 0), ErrorTimeoutReopenScheduler.ERROR_TIMEOUT_MILLIS, TimeUnit.MILLISECONDS);
            }

            /* JADX INFO: Access modifiers changed from: private */
            public void execute() {
                if (this.mIsDone.getAndSet(true)) {
                    return;
                }
                Camera2CameraImpl.this.mExecutor.execute(new t(this, 1));
            }

            /* JADX INFO: Access modifiers changed from: private */
            public void executeInternal() {
                if (Camera2CameraImpl.this.mState == InternalState.OPENING) {
                    Camera2CameraImpl.this.debugLog("Camera onError timeout, reopen it.");
                    Camera2CameraImpl.this.setState(InternalState.REOPENING);
                    Camera2CameraImpl.this.mStateCallback.scheduleCameraReopen();
                } else {
                    Camera2CameraImpl.this.debugLog("Camera skip reopen at state: " + Camera2CameraImpl.this.mState);
                }
            }

            public void cancel() {
                this.mIsDone.set(true);
                this.mScheduledFuture.cancel(true);
            }

            public boolean isDone() {
                return this.mIsDone.get();
            }
        }

        private ErrorTimeoutReopenScheduler() {
            this.mScheduleNode = null;
        }

        public void cancel() {
            ScheduleNode scheduleNode = this.mScheduleNode;
            if (scheduleNode != null) {
                scheduleNode.cancel();
            }
            this.mScheduleNode = null;
        }

        public void deviceOnError() {
            Camera2CameraImpl.this.debugLog("Camera receive onErrorCallback");
            cancel();
        }

        public boolean isErrorHandling() {
            ScheduleNode scheduleNode = this.mScheduleNode;
            return (scheduleNode == null || scheduleNode.isDone()) ? false : true;
        }

        public void start() {
            if (Camera2CameraImpl.this.mState != InternalState.OPENING) {
                Camera2CameraImpl.this.debugLog("Don't need the onError timeout handler.");
                return;
            }
            Camera2CameraImpl.this.debugLog("Camera waiting for onError.");
            cancel();
            this.mScheduleNode = new ScheduleNode();
        }
    }

    /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
    public enum InternalState {
        RELEASED,
        RELEASING,
        INITIALIZED,
        PENDING_OPEN,
        OPENING_WITH_ERROR,
        CLOSING,
        REOPENING_QUIRK,
        REOPENING,
        OPENING,
        OPENED,
        CONFIGURED
    }

    /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
    public final class StateCallback extends CameraDevice.StateCallback {
        private final CameraReopenMonitor mCameraReopenMonitor;
        private final Executor mExecutor;
        ScheduledFuture<?> mScheduledReopenHandle;
        private ScheduledReopen mScheduledReopenRunnable;
        private final ScheduledExecutorService mScheduler;

        /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
        public class CameraReopenMonitor {
            static final int ACTIVE_REOPEN_DELAY_BASE_MS = 1000;
            static final int ACTIVE_REOPEN_LIMIT_MS = 1800000;
            static final int INVALID_TIME = -1;
            static final int REOPEN_DELAY_MS = 700;
            static final int REOPEN_LIMIT_MS = 10000;
            private final long mCameraOpenRetryMaxTimeoutInMs;
            private long mFirstReopenTime = -1;

            public CameraReopenMonitor(long j) {
                this.mCameraOpenRetryMaxTimeoutInMs = j;
            }

            public boolean canScheduleCameraReopen() {
                if (getElapsedTime() < getReopenLimitMs()) {
                    return true;
                }
                reset();
                return false;
            }

            public long getElapsedTime() {
                long jUptimeMillis = SystemClock.uptimeMillis();
                if (this.mFirstReopenTime == -1) {
                    this.mFirstReopenTime = jUptimeMillis;
                }
                return jUptimeMillis - this.mFirstReopenTime;
            }

            public int getReopenDelayMs() {
                if (!StateCallback.this.shouldActiveResume()) {
                    return 700;
                }
                long elapsedTime = getElapsedTime();
                if (elapsedTime <= UnityAdsConstants.Timeout.INIT_TIMEOUT_MS) {
                    return 1000;
                }
                return elapsedTime <= PeriodicWorkRequest.MIN_PERIODIC_FLEX_MILLIS ? 2000 : 4000;
            }

            public int getReopenLimitMs() {
                if (StateCallback.this.shouldActiveResume()) {
                    long j = this.mCameraOpenRetryMaxTimeoutInMs;
                    return j > 0 ? Math.min((int) j, ACTIVE_REOPEN_LIMIT_MS) : ACTIVE_REOPEN_LIMIT_MS;
                }
                long j3 = this.mCameraOpenRetryMaxTimeoutInMs;
                if (j3 > 0) {
                    return Math.min((int) j3, 10000);
                }
                return 10000;
            }

            public void reset() {
                this.mFirstReopenTime = -1L;
            }
        }

        /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
        public class ScheduledReopen implements Runnable {
            private boolean mCancelled = false;
            private Executor mExecutor;

            public ScheduledReopen(Executor executor) {
                this.mExecutor = executor;
            }

            /* JADX INFO: Access modifiers changed from: private */
            public /* synthetic */ void lambda$run$0() {
                if (this.mCancelled) {
                    return;
                }
                Preconditions.checkState(Camera2CameraImpl.this.mState == InternalState.REOPENING || Camera2CameraImpl.this.mState == InternalState.REOPENING_QUIRK);
                if (StateCallback.this.shouldActiveResume()) {
                    Camera2CameraImpl.this.tryForceOpenCameraDevice(true);
                } else {
                    Camera2CameraImpl.this.tryOpenCameraDevice(true);
                }
            }

            public void cancel() {
                this.mCancelled = true;
            }

            @Override // java.lang.Runnable
            public void run() {
                this.mExecutor.execute(new u(this, 0));
            }
        }

        public StateCallback(Executor executor, ScheduledExecutorService scheduledExecutorService, long j) {
            this.mExecutor = executor;
            this.mScheduler = scheduledExecutorService;
            this.mCameraReopenMonitor = new CameraReopenMonitor(j);
        }

        private void handleErrorOnOpen(CameraDevice cameraDevice, int i2) {
            Preconditions.checkState(Camera2CameraImpl.this.mState == InternalState.OPENING || Camera2CameraImpl.this.mState == InternalState.OPENED || Camera2CameraImpl.this.mState == InternalState.CONFIGURED || Camera2CameraImpl.this.mState == InternalState.REOPENING || Camera2CameraImpl.this.mState == InternalState.REOPENING_QUIRK, "Attempt to handle open error from non open state: " + Camera2CameraImpl.this.mState);
            if (i2 == 1 || i2 == 2 || i2 == 4) {
                Logger.d(Camera2CameraImpl.TAG, a1.a.o("Attempt to reopen camera[", cameraDevice.getId(), "] after error[", Camera2CameraImpl.getErrorMessage(i2), C2300e4.i.e));
                reopenCameraAfterError(i2);
                return;
            }
            Logger.e(Camera2CameraImpl.TAG, "Error observed on open (or opening) camera device " + cameraDevice.getId() + ": " + Camera2CameraImpl.getErrorMessage(i2) + " closing camera.");
            Camera2CameraImpl.this.setState(InternalState.CLOSING, CameraState.StateError.create(i2 == 3 ? 5 : 6));
            Camera2CameraImpl.this.closeCamera(false);
        }

        private void reopenCameraAfterError(int i2) {
            int i8 = 1;
            Preconditions.checkState(Camera2CameraImpl.this.mCameraDeviceError != 0, "Can only reopen camera device after error if the camera device is actually in an error state.");
            if (i2 == 1) {
                i8 = 2;
            } else if (i2 != 2) {
                i8 = 3;
            }
            Camera2CameraImpl.this.setState(InternalState.REOPENING, CameraState.StateError.create(i8));
            Camera2CameraImpl.this.closeCamera(false);
        }

        public boolean cancelScheduledReopen() {
            if (this.mScheduledReopenHandle == null) {
                return false;
            }
            Camera2CameraImpl.this.debugLog("Cancelling scheduled re-open: " + this.mScheduledReopenRunnable);
            this.mScheduledReopenRunnable.cancel();
            this.mScheduledReopenRunnable = null;
            this.mScheduledReopenHandle.cancel(false);
            this.mScheduledReopenHandle = null;
            return true;
        }

        @Override // android.hardware.camera2.CameraDevice.StateCallback
        public void onClosed(CameraDevice cameraDevice) {
            Camera2CameraImpl.this.debugLog("CameraDevice.onClosed()");
            Preconditions.checkState(Camera2CameraImpl.this.mCameraDevice == null, "Unexpected onClose callback on camera device: " + cameraDevice);
            int iOrdinal = Camera2CameraImpl.this.mState.ordinal();
            if (iOrdinal == 1 || iOrdinal == 5) {
                Preconditions.checkState(Camera2CameraImpl.this.isSessionCloseComplete());
                Camera2CameraImpl.this.configAndCloseIfNeeded();
                return;
            }
            if (iOrdinal != 6 && iOrdinal != 7) {
                throw new IllegalStateException("Camera closed while in state: " + Camera2CameraImpl.this.mState);
            }
            Camera2CameraImpl camera2CameraImpl = Camera2CameraImpl.this;
            if (camera2CameraImpl.mCameraDeviceError == 0) {
                camera2CameraImpl.tryOpenCameraDevice(false);
                return;
            }
            camera2CameraImpl.debugLog("Camera closed due to error: " + Camera2CameraImpl.getErrorMessage(Camera2CameraImpl.this.mCameraDeviceError));
            scheduleCameraReopen();
        }

        @Override // android.hardware.camera2.CameraDevice.StateCallback
        public void onDisconnected(CameraDevice cameraDevice) {
            Camera2CameraImpl.this.debugLog("CameraDevice.onDisconnected()");
            onError(cameraDevice, 1);
        }

        @Override // android.hardware.camera2.CameraDevice.StateCallback
        public void onError(CameraDevice cameraDevice, int i2) {
            Camera2CameraImpl camera2CameraImpl = Camera2CameraImpl.this;
            camera2CameraImpl.mCameraDevice = cameraDevice;
            camera2CameraImpl.mCameraDeviceError = i2;
            camera2CameraImpl.mErrorTimeoutReopenScheduler.deviceOnError();
            int iOrdinal = Camera2CameraImpl.this.mState.ordinal();
            if (iOrdinal != 1) {
                switch (iOrdinal) {
                    case 5:
                        break;
                    case 6:
                    case 7:
                    case 8:
                    case 9:
                    case 10:
                        String id = cameraDevice.getId();
                        String errorMessage = Camera2CameraImpl.getErrorMessage(i2);
                        String strName = Camera2CameraImpl.this.mState.name();
                        StringBuilder sbZ = a1.a.z("CameraDevice.onError(): ", id, " failed with ", errorMessage, " while in ");
                        sbZ.append(strName);
                        sbZ.append(" state. Will attempt recovering from error.");
                        Logger.d(Camera2CameraImpl.TAG, sbZ.toString());
                        handleErrorOnOpen(cameraDevice, i2);
                        return;
                    default:
                        throw new IllegalStateException("onError() should not be possible from state: " + Camera2CameraImpl.this.mState);
                }
            }
            String id2 = cameraDevice.getId();
            String errorMessage2 = Camera2CameraImpl.getErrorMessage(i2);
            String strName2 = Camera2CameraImpl.this.mState.name();
            StringBuilder sbZ2 = a1.a.z("CameraDevice.onError(): ", id2, " failed with ", errorMessage2, " while in ");
            sbZ2.append(strName2);
            sbZ2.append(" state. Will finish closing camera.");
            Logger.e(Camera2CameraImpl.TAG, sbZ2.toString());
            Camera2CameraImpl.this.closeCamera(false);
        }

        @Override // android.hardware.camera2.CameraDevice.StateCallback
        public void onOpened(CameraDevice cameraDevice) {
            Camera2CameraImpl.this.debugLog("CameraDevice.onOpened()");
            Camera2CameraImpl camera2CameraImpl = Camera2CameraImpl.this;
            camera2CameraImpl.mCameraDevice = cameraDevice;
            camera2CameraImpl.mCameraDeviceError = 0;
            resetReopenMonitor();
            int iOrdinal = Camera2CameraImpl.this.mState.ordinal();
            if (iOrdinal == 1 || iOrdinal == 5) {
                Preconditions.checkState(Camera2CameraImpl.this.isSessionCloseComplete());
                Camera2CameraImpl.this.mCameraDevice.close();
                Camera2CameraImpl.this.mCameraDevice = null;
            } else {
                if (iOrdinal != 6 && iOrdinal != 7 && iOrdinal != 8) {
                    throw new IllegalStateException("onOpened() should not be possible from state: " + Camera2CameraImpl.this.mState);
                }
                Camera2CameraImpl.this.setState(InternalState.OPENED);
                CameraStateRegistry cameraStateRegistry = Camera2CameraImpl.this.mCameraStateRegistry;
                String id = cameraDevice.getId();
                Camera2CameraImpl camera2CameraImpl2 = Camera2CameraImpl.this;
                if (cameraStateRegistry.tryOpenCaptureSession(id, camera2CameraImpl2.mCameraCoordinator.getPairedConcurrentCameraId(camera2CameraImpl2.mCameraDevice.getId()))) {
                    Camera2CameraImpl.this.openCaptureSession();
                }
            }
        }

        public void resetReopenMonitor() {
            this.mCameraReopenMonitor.reset();
        }

        public void scheduleCameraReopen() {
            Preconditions.checkState(this.mScheduledReopenRunnable == null);
            Preconditions.checkState(this.mScheduledReopenHandle == null);
            if (!this.mCameraReopenMonitor.canScheduleCameraReopen()) {
                Logger.e(Camera2CameraImpl.TAG, "Camera reopening attempted for " + this.mCameraReopenMonitor.getReopenLimitMs() + "ms without success.");
                Camera2CameraImpl.this.setState(InternalState.PENDING_OPEN, null, false);
                return;
            }
            this.mScheduledReopenRunnable = new ScheduledReopen(this.mExecutor);
            Camera2CameraImpl.this.debugLog("Attempting camera re-open in " + this.mCameraReopenMonitor.getReopenDelayMs() + "ms: " + this.mScheduledReopenRunnable + " activeResuming = " + Camera2CameraImpl.this.mIsActiveResumingMode);
            this.mScheduledReopenHandle = this.mScheduler.schedule(this.mScheduledReopenRunnable, (long) this.mCameraReopenMonitor.getReopenDelayMs(), TimeUnit.MILLISECONDS);
        }

        public boolean shouldActiveResume() {
            Camera2CameraImpl camera2CameraImpl = Camera2CameraImpl.this;
            if (!camera2CameraImpl.mIsActiveResumingMode) {
                return false;
            }
            int i2 = camera2CameraImpl.mCameraDeviceError;
            return i2 == 1 || i2 == 2;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
    public static abstract class UseCaseInfo {
        public static UseCaseInfo create(String str, Class<?> cls, SessionConfig sessionConfig, UseCaseConfig<?> useCaseConfig, Size size, StreamSpec streamSpec, List<UseCaseConfigFactory.CaptureType> list) {
            return new AutoValue_Camera2CameraImpl_UseCaseInfo(str, cls, sessionConfig, useCaseConfig, size, streamSpec, list);
        }

        public static UseCaseInfo from(UseCase useCase, boolean z2) {
            return create(Camera2CameraImpl.getUseCaseId(useCase), useCase.getClass(), z2 ? useCase.getSessionConfig() : useCase.getSecondarySessionConfig(), useCase.getCurrentConfig(), useCase.getAttachedSurfaceResolution(), useCase.getAttachedStreamSpec(), Camera2CameraImpl.getCaptureTypes(useCase));
        }

        public abstract List<UseCaseConfigFactory.CaptureType> getCaptureTypes();

        public abstract SessionConfig getSessionConfig();

        public abstract StreamSpec getStreamSpec();

        public abstract Size getSurfaceResolution();

        public abstract UseCaseConfig<?> getUseCaseConfig();

        public abstract String getUseCaseId();

        public abstract Class<?> getUseCaseType();
    }

    public Camera2CameraImpl(Context context, CameraManagerCompat cameraManagerCompat, String str, Camera2CameraInfoImpl camera2CameraInfoImpl, CameraCoordinator cameraCoordinator, CameraStateRegistry cameraStateRegistry, Executor executor, Handler handler, DisplayInfoManager displayInfoManager, long j, CameraXConfig cameraXConfig) throws CameraUnavailableException {
        LiveDataObservable<CameraInternal.State> liveDataObservable = new LiveDataObservable<>();
        this.mObservableState = liveDataObservable;
        this.mCameraDeviceError = 0;
        this.mReleaseRequestCount = new AtomicInteger(0);
        this.mReleasedCaptureSessions = new LinkedHashMap();
        this.mTraceStateErrorCount = 0;
        this.mIsConfigAndCloseRequired = false;
        this.mIsConfiguringForClose = false;
        this.mIsPrimary = true;
        this.mSessionStartNotifiedUseCases = new HashSet();
        this.mCameraConfig = CameraConfigs.defaultConfig();
        this.mLock = new Object();
        this.mIsActiveResumingMode = false;
        this.mErrorTimeoutReopenScheduler = new ErrorTimeoutReopenScheduler();
        this.mCameraManager = cameraManagerCompat;
        this.mCameraCoordinator = cameraCoordinator;
        this.mCameraStateRegistry = cameraStateRegistry;
        ScheduledExecutorService scheduledExecutorServiceNewHandlerExecutor = CameraXExecutors.newHandlerExecutor(handler);
        this.mScheduledExecutorService = scheduledExecutorServiceNewHandlerExecutor;
        Executor executorNewSequentialExecutor = CameraXExecutors.newSequentialExecutor(executor);
        this.mExecutor = executorNewSequentialExecutor;
        this.mStateCallback = new StateCallback(executorNewSequentialExecutor, scheduledExecutorServiceNewHandlerExecutor, j);
        this.mUseCaseAttachState = new UseCaseAttachState(str);
        liveDataObservable.postValue(CameraInternal.State.CLOSED);
        CameraStateMachine cameraStateMachine = new CameraStateMachine(cameraStateRegistry);
        this.mCameraStateMachine = cameraStateMachine;
        CaptureSessionRepository captureSessionRepository = new CaptureSessionRepository(executorNewSequentialExecutor);
        this.mCaptureSessionRepository = captureSessionRepository;
        this.mDisplayInfoManager = displayInfoManager;
        this.mCameraXConfig = cameraXConfig;
        try {
            CameraCharacteristicsCompat cameraCharacteristicsCompat = cameraManagerCompat.getCameraCharacteristicsCompat(str);
            this.mCameraCharacteristicsCompat = cameraCharacteristicsCompat;
            Camera2CameraControlImpl camera2CameraControlImpl = new Camera2CameraControlImpl(cameraCharacteristicsCompat, scheduledExecutorServiceNewHandlerExecutor, executorNewSequentialExecutor, new ControlUpdateListenerInternal(), camera2CameraInfoImpl.getCameraQuirks());
            this.mCameraControlInternal = camera2CameraControlImpl;
            this.mCameraInfoInternal = camera2CameraInfoImpl;
            camera2CameraInfoImpl.linkWithCameraControl(camera2CameraControlImpl);
            camera2CameraInfoImpl.setCameraStateSource(cameraStateMachine.getStateLiveData());
            this.mDynamicRangesCompat = DynamicRangesCompat.fromCameraCharacteristics(cameraCharacteristicsCompat);
            this.mCaptureSession = newCaptureSession();
            this.mCaptureSessionOpenerBuilder = new SynchronizedCaptureSession.OpenerBuilder(executorNewSequentialExecutor, scheduledExecutorServiceNewHandlerExecutor, handler, captureSessionRepository, camera2CameraInfoImpl.getCameraQuirks(), DeviceQuirks.getAll());
            this.mShouldCloseCameraBeforeCreateNewSession = CloseCameraBeforeCreateNewSession.shouldCloseCamera(camera2CameraInfoImpl.getCameraQuirks());
            this.mConfigAndCloseQuirk = camera2CameraInfoImpl.getCameraQuirks().contains(LegacyCameraSurfaceCleanupQuirk.class);
            CameraAvailability cameraAvailability = new CameraAvailability(str);
            this.mCameraAvailability = cameraAvailability;
            CameraConfigureAvailable cameraConfigureAvailable = new CameraConfigureAvailable();
            this.mCameraConfigureAvailable = cameraConfigureAvailable;
            cameraStateRegistry.registerCamera(this, executorNewSequentialExecutor, cameraConfigureAvailable, cameraAvailability);
            cameraManagerCompat.registerAvailabilityCallback(executorNewSequentialExecutor, cameraAvailability);
            this.mSupportedSurfaceCombination = new SupportedSurfaceCombination(context, str, cameraManagerCompat, new CamcorderProfileHelper() { // from class: androidx.camera.camera2.internal.Camera2CameraImpl.1
                @Override // androidx.camera.camera2.internal.CamcorderProfileHelper
                public CamcorderProfile get(int i2, int i8) {
                    return CamcorderProfile.get(i2, i8);
                }

                @Override // androidx.camera.camera2.internal.CamcorderProfileHelper
                public boolean hasProfile(int i2, int i8) {
                    return CamcorderProfile.hasProfile(i2, i8);
                }
            }, FeatureCombinationQuery.NO_OP_FEATURE_COMBINATION_QUERY);
        } catch (CameraAccessExceptionCompat e) {
            throw CameraUnavailableExceptionHelper.createFrom(e);
        }
    }

    private void addMeteringRepeating() {
        MeteringRepeatingSession meteringRepeatingSession = this.mMeteringRepeatingSession;
        if (meteringRepeatingSession != null) {
            String meteringRepeatingId = getMeteringRepeatingId(meteringRepeatingSession);
            UseCaseAttachState useCaseAttachState = this.mUseCaseAttachState;
            SessionConfig sessionConfig = this.mMeteringRepeatingSession.getSessionConfig();
            UseCaseConfig<?> useCaseConfig = this.mMeteringRepeatingSession.getUseCaseConfig();
            UseCaseConfigFactory.CaptureType captureType = UseCaseConfigFactory.CaptureType.METERING_REPEATING;
            useCaseAttachState.setUseCaseAttached(meteringRepeatingId, sessionConfig, useCaseConfig, null, Collections.singletonList(captureType));
            this.mUseCaseAttachState.setUseCaseActive(meteringRepeatingId, this.mMeteringRepeatingSession.getSessionConfig(), this.mMeteringRepeatingSession.getUseCaseConfig(), null, Collections.singletonList(captureType));
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:24:0x0067  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private void addOrRemoveMeteringRepeatingUseCase() {
        /*
            r7 = this;
            androidx.camera.core.impl.UseCaseAttachState r0 = r7.mUseCaseAttachState
            androidx.camera.core.impl.SessionConfig$ValidatingBuilder r0 = r0.getAttachedBuilder()
            androidx.camera.core.impl.SessionConfig r0 = r0.build()
            androidx.camera.core.impl.CaptureConfig r1 = r0.getRepeatingCaptureConfig()
            java.util.List r1 = r1.getSurfaces()
            int r1 = r1.size()
            java.util.List r0 = r0.getSurfaces()
            int r0 = r0.size()
            boolean r2 = r7.isMeteringRepeatingAttachedInternal()
            r3 = 0
            r4 = 1
            if (r2 == 0) goto L3e
            if (r1 != r4) goto L2d
            if (r0 != r4) goto L2b
            goto L2d
        L2b:
            r0 = r3
            goto L2e
        L2d:
            r0 = r4
        L2e:
            if (r0 != 0) goto L38
            androidx.camera.camera2.internal.MeteringRepeatingSession r1 = r7.mMeteringRepeatingSession
            boolean r1 = r7.isMeteringRepeatingRestricted(r1)
            if (r1 == 0) goto L67
        L38:
            r7.removeMeteringRepeating()
            if (r0 != 0) goto L67
            goto L68
        L3e:
            if (r1 != 0) goto L67
            if (r0 <= 0) goto L67
            androidx.camera.camera2.internal.MeteringRepeatingSession r0 = r7.mMeteringRepeatingSession
            if (r0 != 0) goto L5b
            androidx.camera.camera2.internal.MeteringRepeatingSession r0 = new androidx.camera.camera2.internal.MeteringRepeatingSession
            androidx.camera.camera2.internal.Camera2CameraInfoImpl r1 = r7.mCameraInfoInternal
            androidx.camera.camera2.internal.compat.CameraCharacteristicsCompat r1 = r1.getCameraCharacteristicsCompat()
            androidx.camera.camera2.internal.DisplayInfoManager r2 = r7.mDisplayInfoManager
            androidx.camera.camera2.internal.l r5 = new androidx.camera.camera2.internal.l
            r6 = 1
            r5.<init>(r7, r6)
            r0.<init>(r1, r2, r5)
            r7.mMeteringRepeatingSession = r0
        L5b:
            androidx.camera.camera2.internal.MeteringRepeatingSession r0 = r7.mMeteringRepeatingSession
            boolean r0 = r7.isMeteringRepeatingRestricted(r0)
            if (r0 == 0) goto L64
            goto L68
        L64:
            r7.addMeteringRepeating()
        L67:
            r3 = r4
        L68:
            androidx.camera.camera2.internal.Camera2CameraControlImpl r0 = r7.mCameraControlInternal
            r0.setIsRepeatingRequestAvailable(r3)
            if (r3 != 0) goto L76
            java.lang.String r0 = "Camera2CameraImpl"
            java.lang.String r1 = "The repeating surface is missing, CameraControl and ImageCapture may encounter issues due to the absence of repeating surface. Please add a UseCase (Preview or ImageAnalysis) that can provide a repeating surface for CameraControl and ImageCapture to function properly."
            androidx.camera.core.Logger.e(r0, r1)
        L76:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.camera.camera2.internal.Camera2CameraImpl.addOrRemoveMeteringRepeatingUseCase():void");
    }

    private boolean checkAndAttachRepeatingSurface(CaptureConfig.Builder builder) {
        if (!builder.getSurfaces().isEmpty()) {
            Logger.w(TAG, "The capture config builder already has surface inside.");
            return false;
        }
        Iterator<SessionConfig> it = this.mUseCaseAttachState.getActiveAndAttachedSessionConfigs().iterator();
        while (it.hasNext()) {
            CaptureConfig repeatingCaptureConfig = it.next().getRepeatingCaptureConfig();
            List<DeferrableSurface> surfaces = repeatingCaptureConfig.getSurfaces();
            if (!surfaces.isEmpty()) {
                if (repeatingCaptureConfig.getPreviewStabilizationMode() != 0) {
                    builder.setPreviewStabilization(repeatingCaptureConfig.getPreviewStabilizationMode());
                }
                if (repeatingCaptureConfig.getVideoStabilizationMode() != 0) {
                    builder.setVideoStabilization(repeatingCaptureConfig.getVideoStabilizationMode());
                }
                Iterator<DeferrableSurface> it2 = surfaces.iterator();
                while (it2.hasNext()) {
                    builder.addSurface(it2.next());
                }
            }
        }
        if (!builder.getSurfaces().isEmpty()) {
            return true;
        }
        Logger.w(TAG, "Unable to find a repeating surface to attach to CaptureConfig");
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void closeInternal() {
        debugLog("Closing camera.");
        switch (this.mState.ordinal()) {
            case 3:
            case 4:
                Preconditions.checkState(this.mCameraDevice == null);
                setState(InternalState.INITIALIZED);
                break;
            case 5:
            default:
                debugLog("close() ignored due to being in state: " + this.mState);
                break;
            case 6:
            case 7:
            case 8:
                if (!this.mStateCallback.cancelScheduledReopen() && !this.mErrorTimeoutReopenScheduler.isErrorHandling()) {
                    z = false;
                }
                this.mErrorTimeoutReopenScheduler.cancel();
                setState(InternalState.CLOSING);
                if (z) {
                    Preconditions.checkState(isSessionCloseComplete());
                    configAndCloseIfNeeded();
                }
                break;
            case 9:
            case 10:
                setState(InternalState.CLOSING);
                closeCamera(false);
                break;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public j2.q configAndClose(CameraDevice cameraDevice) {
        CaptureSession captureSession = new CaptureSession(this.mDynamicRangesCompat);
        SurfaceTexture surfaceTexture = new SurfaceTexture(0);
        surfaceTexture.setDefaultBufferSize(640, 480);
        Surface surface = new Surface(surfaceTexture);
        ImmediateSurface immediateSurface = new ImmediateSurface(surface);
        immediateSurface.getTerminationFuture().addListener(new j(3, surface, surfaceTexture), CameraXExecutors.directExecutor());
        SessionConfig.Builder builder = new SessionConfig.Builder();
        builder.addNonRepeatingSurface(immediateSurface);
        builder.setTemplateType(1);
        debugLog("Start configAndClose.");
        return FutureChain.from(Futures.transformAsyncOnCompletion(captureSession.open(builder.build(), cameraDevice, this.mCaptureSessionOpenerBuilder.build()))).transformAsync(new q(0, captureSession, immediateSurface), this.mExecutor);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void configAndCloseIfNeeded() {
        Preconditions.checkState(this.mState == InternalState.RELEASING || this.mState == InternalState.CLOSING);
        Preconditions.checkState(this.mReleasedCaptureSessions.isEmpty());
        if (!this.mIsConfigAndCloseRequired) {
            finishClose();
            return;
        }
        if (this.mIsConfiguringForClose) {
            debugLog("Ignored since configAndClose is processing");
            return;
        }
        if (!this.mCameraAvailability.isCameraAvailable()) {
            this.mIsConfigAndCloseRequired = false;
            finishClose();
            debugLog("Ignore configAndClose and finish the close flow directly since camera is unavailable.");
        } else {
            debugLog("Open camera to configAndClose");
            j2.q qVarOpenCameraConfigAndClose = openCameraConfigAndClose();
            this.mIsConfiguringForClose = true;
            qVarOpenCameraConfigAndClose.addListener(new r(this, 2), this.mExecutor);
        }
    }

    private CameraDevice.StateCallback createDeviceStateCallback() {
        ArrayList arrayList = new ArrayList(this.mUseCaseAttachState.getAttachedBuilder().build().getDeviceStateCallbacks());
        arrayList.add(this.mCaptureSessionRepository.getCameraStateCallback());
        arrayList.add(this.mStateCallback);
        return CameraDeviceStateCallbacks.createComboCallback(arrayList);
    }

    private int getCameraMode() {
        synchronized (this.mLock) {
            try {
                return this.mCameraCoordinator.getCameraOperatingMode() == 2 ? 1 : 0;
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public static List<UseCaseConfigFactory.CaptureType> getCaptureTypes(UseCase useCase) {
        if (useCase.getCamera() == null) {
            return null;
        }
        return StreamSharing.getCaptureTypes(useCase);
    }

    public static String getErrorMessage(int i2) {
        return i2 != 0 ? i2 != 1 ? i2 != 2 ? i2 != 3 ? i2 != 4 ? i2 != 5 ? "UNKNOWN ERROR" : "ERROR_CAMERA_SERVICE" : "ERROR_CAMERA_DEVICE" : "ERROR_CAMERA_DISABLED" : "ERROR_MAX_CAMERAS_IN_USE" : "ERROR_CAMERA_IN_USE" : "ERROR_NONE";
    }

    public static String getMeteringRepeatingId(MeteringRepeatingSession meteringRepeatingSession) {
        return meteringRepeatingSession.getName() + meteringRepeatingSession.hashCode();
    }

    private j2.q getOrCreateUserReleaseFuture() {
        if (this.mUserReleaseFuture == null) {
            if (this.mState != InternalState.RELEASED) {
                this.mUserReleaseFuture = CallbackToFutureAdapter.getFuture(new l(this, 2));
            } else {
                this.mUserReleaseFuture = Futures.immediateFuture(null);
            }
        }
        return this.mUserReleaseFuture;
    }

    public static String getUseCaseId(UseCase useCase) {
        return useCase.getName() + useCase.hashCode();
    }

    private boolean isMeteringRepeatingAttachedInternal() {
        MeteringRepeatingSession meteringRepeatingSession = this.mMeteringRepeatingSession;
        if (meteringRepeatingSession == null) {
            return false;
        }
        return this.mUseCaseAttachState.isUseCaseAttached(getMeteringRepeatingId(meteringRepeatingSession));
    }

    private boolean isMeteringRepeatingDisabled() {
        CameraXConfig cameraXConfig = this.mCameraXConfig;
        return (cameraXConfig == null || cameraXConfig.isRepeatingStreamForced()) ? false : true;
    }

    private boolean isMeteringRepeatingRestricted(MeteringRepeatingSession meteringRepeatingSession) {
        Preconditions.checkNotNull(meteringRepeatingSession);
        return !isSurfaceCombinationWithMeteringRepeatingSupported(meteringRepeatingSession) || isMeteringRepeatingDisabled();
    }

    private boolean isSurfaceCombinationWithMeteringRepeatingSupported(MeteringRepeatingSession meteringRepeatingSession) {
        ArrayList arrayList = new ArrayList();
        int cameraMode = getCameraMode();
        for (UseCaseAttachState.UseCaseAttachInfo useCaseAttachInfo : this.mUseCaseAttachState.getAttachedUseCaseInfo()) {
            if (useCaseAttachInfo.getCaptureTypes() == null || useCaseAttachInfo.getCaptureTypes().get(0) != UseCaseConfigFactory.CaptureType.METERING_REPEATING) {
                if (useCaseAttachInfo.getStreamSpec() == null || useCaseAttachInfo.getCaptureTypes() == null) {
                    Logger.w(TAG, "Invalid stream spec or capture types in " + useCaseAttachInfo);
                    return false;
                }
                SessionConfig sessionConfig = useCaseAttachInfo.getSessionConfig();
                UseCaseConfig<?> useCaseConfig = useCaseAttachInfo.getUseCaseConfig();
                for (DeferrableSurface deferrableSurface : sessionConfig.getSurfaces()) {
                    arrayList.add(AttachedSurfaceInfo.create(this.mSupportedSurfaceCombination.transformSurfaceConfig(cameraMode, useCaseConfig.getInputFormat(), deferrableSurface.getPrescribedSize(), useCaseConfig.getStreamUseCase()), useCaseConfig.getInputFormat(), deferrableSurface.getPrescribedSize(), useCaseAttachInfo.getStreamSpec().getDynamicRange(), useCaseAttachInfo.getCaptureTypes(), useCaseAttachInfo.getStreamSpec().getImplementationOptions(), useCaseAttachInfo.getStreamSpec().getSessionType(), useCaseAttachInfo.getStreamSpec().getExpectedFrameRateRange(), useCaseConfig.isStrictFrameRateRequired()));
                }
            }
        }
        Preconditions.checkNotNull(meteringRepeatingSession);
        HashMap map = new HashMap();
        map.put(meteringRepeatingSession.getUseCaseConfig(), Collections.singletonList(meteringRepeatingSession.getMeteringRepeatingSize()));
        try {
            this.mSupportedSurfaceCombination.getSuggestedStreamSpecifications(cameraMode, arrayList, map, false, false, false, false);
            debugLog("Surface combination with metering repeating supported!");
            return true;
        } catch (IllegalArgumentException e) {
            debugLog("Surface combination with metering repeating  not supported!", e);
            return false;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$addOrRemoveMeteringRepeatingUseCase$18() {
        if (isMeteringRepeatingAttached()) {
            resetUseCase(getMeteringRepeatingId(this.mMeteringRepeatingSession), this.mMeteringRepeatingSession.getSessionConfig(), this.mMeteringRepeatingSession.getUseCaseConfig(), null, Collections.singletonList(UseCaseConfigFactory.CaptureType.METERING_REPEATING));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$attachUseCases$15(List list) {
        try {
            tryAttachUseCases(list);
        } finally {
            this.mCameraControlInternal.decrementUseCount();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void lambda$configAndClose$2(Surface surface, SurfaceTexture surfaceTexture) {
        surface.release();
        surfaceTexture.release();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ j2.q lambda$configAndClose$3(CaptureSession captureSession, DeferrableSurface deferrableSurface, Void r22) throws Exception {
        captureSession.close();
        deferrableSurface.close();
        return captureSession.release(false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$configAndCloseIfNeeded$0() {
        this.mIsConfiguringForClose = false;
        this.mIsConfigAndCloseRequired = false;
        debugLog("OpenCameraConfigAndClose is done, state: " + this.mState);
        int iOrdinal = this.mState.ordinal();
        if (iOrdinal == 1 || iOrdinal == 5) {
            Preconditions.checkState(isSessionCloseComplete());
            finishClose();
            return;
        }
        if (iOrdinal != 7) {
            debugLog("OpenCameraConfigAndClose finished while in state: " + this.mState);
        } else {
            if (this.mCameraDeviceError == 0) {
                tryOpenCameraDevice(false);
                return;
            }
            debugLog("OpenCameraConfigAndClose in error: " + getErrorMessage(this.mCameraDeviceError));
            this.mStateCallback.scheduleCameraReopen();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ Object lambda$getOrCreateUserReleaseFuture$6(CallbackToFutureAdapter.Completer completer) throws Exception {
        Preconditions.checkState(this.mUserReleaseNotifier == null, "Camera can only be released once, so release completer should be null on creation.");
        this.mUserReleaseNotifier = completer;
        return "Release[camera=" + this + C2300e4.i.e;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$isMeteringRepeatingAttached$13(CallbackToFutureAdapter.Completer completer) {
        completer.set(Boolean.valueOf(isMeteringRepeatingAttachedInternal()));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ Object lambda$isMeteringRepeatingAttached$14(CallbackToFutureAdapter.Completer completer) throws Exception {
        try {
            this.mExecutor.execute(new p(this, completer, 1));
            return "isMeteringRepeatingAttached";
        } catch (RejectedExecutionException unused) {
            completer.setException(new RuntimeException("Unable to check if MeteringRepeating is attached. Camera executor shut down."));
            return "isMeteringRepeatingAttached";
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$isUseCaseAttached$11(CallbackToFutureAdapter.Completer completer, String str) {
        completer.set(Boolean.valueOf(this.mUseCaseAttachState.isUseCaseAttached(str)));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ Object lambda$isUseCaseAttached$12(String str, CallbackToFutureAdapter.Completer completer) throws Exception {
        try {
            this.mExecutor.execute(new s(this, completer, str, 0));
            return "isUseCaseAttached";
        } catch (RejectedExecutionException unused) {
            completer.setException(new RuntimeException("Unable to check if use case is attached. Camera executor shut down."));
            return "isUseCaseAttached";
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$onRemoved$16() {
        debugLog("Camera is removed. Updating state and cleaning up.");
        InternalState internalState = this.mState;
        InternalState internalState2 = InternalState.RELEASING;
        if (internalState == internalState2 || this.mState == InternalState.RELEASED) {
            return;
        }
        CameraState.StateError stateErrorCreate = CameraState.StateError.create(8);
        this.mCameraStateMachine.updateState(CameraInternal.State.CLOSED, stateErrorCreate);
        setState(internalState2, stateErrorCreate);
        this.mStateCallback.cancelScheduledReopen();
        this.mErrorTimeoutReopenScheduler.cancel();
        if (this.mCameraDevice != null) {
            closeCamera(false);
        } else {
            finishClose();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$onUseCaseActive$7(String str, SessionConfig sessionConfig, UseCaseConfig useCaseConfig, StreamSpec streamSpec, List list) {
        debugLog(a1.a.m("Use case ", str, " ACTIVE"));
        this.mUseCaseAttachState.setUseCaseActive(str, sessionConfig, useCaseConfig, streamSpec, list);
        this.mUseCaseAttachState.updateUseCase(str, sessionConfig, useCaseConfig, streamSpec, list);
        updateCaptureSessionConfig();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$onUseCaseInactive$8(String str) {
        debugLog(a1.a.m("Use case ", str, " INACTIVE"));
        this.mUseCaseAttachState.setUseCaseInactive(str);
        updateCaptureSessionConfig();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$onUseCaseUpdated$9(String str, SessionConfig sessionConfig, UseCaseConfig useCaseConfig, StreamSpec streamSpec, List list) {
        debugLog(a1.a.m("Use case ", str, " UPDATED"));
        this.mUseCaseAttachState.updateUseCase(str, sessionConfig, useCaseConfig, streamSpec, list);
        updateCaptureSessionConfig();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ Object lambda$openCameraConfigAndClose$1(final CallbackToFutureAdapter.Completer completer) throws Exception {
        try {
            ArrayList arrayList = new ArrayList(this.mUseCaseAttachState.getAttachedBuilder().build().getDeviceStateCallbacks());
            arrayList.add(this.mCaptureSessionRepository.getCameraStateCallback());
            arrayList.add(new CameraDevice.StateCallback() { // from class: androidx.camera.camera2.internal.Camera2CameraImpl.2
                @Override // android.hardware.camera2.CameraDevice.StateCallback
                public void onClosed(CameraDevice cameraDevice) {
                    Camera2CameraImpl.this.debugLog("openCameraConfigAndClose camera closed");
                    completer.set(null);
                }

                @Override // android.hardware.camera2.CameraDevice.StateCallback
                public void onDisconnected(CameraDevice cameraDevice) {
                    Camera2CameraImpl.this.debugLog("openCameraConfigAndClose camera disconnected");
                    completer.set(null);
                }

                @Override // android.hardware.camera2.CameraDevice.StateCallback
                public void onError(CameraDevice cameraDevice, int i2) {
                    Camera2CameraImpl.this.debugLog(a1.a.g(i2, "openCameraConfigAndClose camera error "));
                    completer.set(null);
                }

                @Override // android.hardware.camera2.CameraDevice.StateCallback
                public void onOpened(CameraDevice cameraDevice) {
                    Camera2CameraImpl.this.debugLog("openCameraConfigAndClose camera opened");
                    j2.q qVarConfigAndClose = Camera2CameraImpl.this.configAndClose(cameraDevice);
                    Objects.requireNonNull(cameraDevice);
                    qVarConfigAndClose.addListener(new u(cameraDevice, 9), Camera2CameraImpl.this.mExecutor);
                }
            });
            this.mCameraManager.openCamera(this.mCameraInfoInternal.getCameraId(), this.mExecutor, CameraDeviceStateCallbacks.createComboCallback(arrayList));
            return "configAndCloseTask";
        } catch (CameraAccessExceptionCompat | RuntimeException e) {
            debugLog(a1.a.j(e, new StringBuilder("Unable to open camera for configAndClose: ")), e);
            completer.setException(e);
            return "configAndCloseTask";
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void lambda$postSurfaceClosedError$20(SessionConfig.ErrorListener errorListener, SessionConfig sessionConfig) {
        errorListener.onError(sessionConfig, SessionConfig.SessionError.SESSION_ERROR_SURFACE_NEEDS_RESET);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$release$4(CallbackToFutureAdapter.Completer completer) {
        Futures.propagate(releaseInternal(), completer);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ Object lambda$release$5(CallbackToFutureAdapter.Completer completer) throws Exception {
        this.mExecutor.execute(new p(this, completer, 0));
        return "Release[request=" + this.mReleaseRequestCount.getAndIncrement() + C2300e4.i.e;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$resetUseCase$10(String str, SessionConfig sessionConfig, UseCaseConfig useCaseConfig, StreamSpec streamSpec, List list) {
        debugLog(a1.a.m("Use case ", str, " RESET"));
        this.mUseCaseAttachState.updateUseCase(str, sessionConfig, useCaseConfig, streamSpec, list);
        addOrRemoveMeteringRepeatingUseCase();
        resetCaptureSession(false);
        updateCaptureSessionConfig();
        if (this.mState == InternalState.OPENED) {
            openCaptureSession();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$setActiveResumingMode$19(boolean z2) {
        this.mIsActiveResumingMode = z2;
        if (z2) {
            if (this.mState == InternalState.PENDING_OPEN || this.mState == InternalState.OPENING_WITH_ERROR) {
                tryForceOpenCameraDevice(false);
            }
        }
    }

    private CaptureSessionInterface newCaptureSession() {
        synchronized (this.mLock) {
            try {
                CameraXConfig cameraXConfig = this.mCameraXConfig;
                Camera2CaptureRequestConfigurator camera2CaptureRequestConfigurator = cameraXConfig == null ? null : Camera2CaptureRequestConfiguratorKt.getCamera2CaptureRequestConfigurator(cameraXConfig);
                if (this.mSessionProcessor == null) {
                    return new CaptureSession(this.mDynamicRangesCompat, this.mCameraInfoInternal.getCameraQuirks(), camera2CaptureRequestConfigurator);
                }
                return new ProcessingCaptureSession(this.mSessionProcessor, this.mCameraInfoInternal, this.mDynamicRangesCompat, this.mExecutor, this.mScheduledExecutorService, camera2CaptureRequestConfigurator);
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    private void notifySessionStartedAndCameraControlReady(List<UseCase> list) {
        for (UseCase useCase : list) {
            String useCaseId = getUseCaseId(useCase);
            if (!this.mSessionStartNotifiedUseCases.contains(useCaseId)) {
                this.mSessionStartNotifiedUseCases.add(useCaseId);
                useCase.onSessionStart();
                useCase.onCameraControlReady();
            }
        }
    }

    private void notifySessionStoppedToUseCases(List<UseCase> list) {
        for (UseCase useCase : list) {
            String useCaseId = getUseCaseId(useCase);
            if (this.mSessionStartNotifiedUseCases.contains(useCaseId)) {
                useCase.onSessionStop();
                this.mSessionStartNotifiedUseCases.remove(useCaseId);
            }
        }
    }

    private j2.q openCameraConfigAndClose() {
        return CallbackToFutureAdapter.getFuture(new l(this, 3));
    }

    private void openCameraDevice(boolean z2) {
        if (!z2) {
            this.mStateCallback.resetReopenMonitor();
        }
        this.mStateCallback.cancelScheduledReopen();
        this.mErrorTimeoutReopenScheduler.cancel();
        debugLog("Opening camera.");
        setState(InternalState.OPENING);
        try {
            this.mCameraManager.openCamera(this.mCameraInfoInternal.getCameraId(), this.mExecutor, createDeviceStateCallback());
        } catch (CameraAccessExceptionCompat e) {
            debugLog("Unable to open camera due to " + e.getMessage());
            if (e.getReason() != 10001) {
                this.mErrorTimeoutReopenScheduler.start();
            } else {
                setState(InternalState.INITIALIZED, CameraState.StateError.create(7, e));
            }
        } catch (SecurityException e4) {
            debugLog("Unable to open camera due to " + e4.getMessage());
            setState(InternalState.REOPENING);
            this.mStateCallback.scheduleCameraReopen();
        } catch (RuntimeException e8) {
            debugLog("Unexpected error occurred when opening camera.", e8);
            setState(InternalState.OPENING_WITH_ERROR, CameraState.StateError.create(6));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void openInternal() {
        int iOrdinal = this.mState.ordinal();
        if (iOrdinal == 2 || iOrdinal == 3 || iOrdinal == 4) {
            tryForceOpenCameraDevice(false);
            return;
        }
        if (iOrdinal != 5) {
            debugLog("open() ignored due to being in state: " + this.mState);
            return;
        }
        setState(InternalState.REOPENING);
        if (isSessionCloseComplete() || this.mIsConfiguringForClose || this.mCameraDeviceError != 0) {
            return;
        }
        Preconditions.checkState(this.mCameraDevice != null, "Camera Device should be open if session close is not complete");
        setState(InternalState.OPENED);
        openCaptureSession();
    }

    private j2.q releaseInternal() {
        j2.q orCreateUserReleaseFuture = getOrCreateUserReleaseFuture();
        switch (this.mState.ordinal()) {
            case 1:
            case 5:
            case 6:
            case 7:
            case 8:
                if (!this.mStateCallback.cancelScheduledReopen() && !this.mErrorTimeoutReopenScheduler.isErrorHandling()) {
                    z = false;
                }
                this.mErrorTimeoutReopenScheduler.cancel();
                setState(InternalState.RELEASING);
                if (z) {
                    Preconditions.checkState(isSessionCloseComplete());
                    configAndCloseIfNeeded();
                }
                break;
            case 2:
            case 3:
            case 4:
                Preconditions.checkState(this.mCameraDevice == null);
                setState(InternalState.RELEASING);
                Preconditions.checkState(isSessionCloseComplete());
                configAndCloseIfNeeded();
                break;
            case 9:
            case 10:
                setState(InternalState.RELEASING);
                closeCamera(false);
                break;
            default:
                debugLog("release() ignored due to being in state: " + this.mState);
                break;
        }
        return orCreateUserReleaseFuture;
    }

    private void removeMeteringRepeating() {
        if (this.mMeteringRepeatingSession != null) {
            this.mUseCaseAttachState.setUseCaseDetached(this.mMeteringRepeatingSession.getName() + this.mMeteringRepeatingSession.hashCode());
            this.mUseCaseAttachState.setUseCaseInactive(this.mMeteringRepeatingSession.getName() + this.mMeteringRepeatingSession.hashCode());
            this.mMeteringRepeatingSession.clear();
            this.mMeteringRepeatingSession = null;
        }
    }

    private void resetUseCase(String str, SessionConfig sessionConfig, UseCaseConfig<?> useCaseConfig, StreamSpec streamSpec, List<UseCaseConfigFactory.CaptureType> list) {
        this.mExecutor.execute(new k(this, str, sessionConfig, useCaseConfig, streamSpec, list, 1));
    }

    private Collection<UseCaseInfo> toUseCaseInfos(Collection<UseCase> collection) {
        ArrayList arrayList = new ArrayList();
        Iterator<UseCase> it = collection.iterator();
        while (it.hasNext()) {
            arrayList.add(UseCaseInfo.from(it.next(), this.mIsPrimary));
        }
        return arrayList;
    }

    private void tryAttachUseCases(Collection<UseCaseInfo> collection) {
        Size surfaceResolution;
        boolean zIsEmpty = this.mUseCaseAttachState.getAttachedSessionConfigs().isEmpty();
        ArrayList arrayList = new ArrayList();
        Rational rational = null;
        for (UseCaseInfo useCaseInfo : collection) {
            if (!this.mUseCaseAttachState.isUseCaseAttached(useCaseInfo.getUseCaseId())) {
                this.mUseCaseAttachState.setUseCaseAttached(useCaseInfo.getUseCaseId(), useCaseInfo.getSessionConfig(), useCaseInfo.getUseCaseConfig(), useCaseInfo.getStreamSpec(), useCaseInfo.getCaptureTypes());
                arrayList.add(useCaseInfo.getUseCaseId());
                if (useCaseInfo.getUseCaseType() == Preview.class && (surfaceResolution = useCaseInfo.getSurfaceResolution()) != null) {
                    rational = new Rational(surfaceResolution.getWidth(), surfaceResolution.getHeight());
                }
            }
        }
        if (arrayList.isEmpty()) {
            return;
        }
        debugLog("Use cases [" + TextUtils.join(", ", arrayList) + "] now ATTACHED");
        if (zIsEmpty) {
            this.mCameraControlInternal.setActive(true);
            this.mCameraControlInternal.incrementUseCount();
        }
        addOrRemoveMeteringRepeatingUseCase();
        updateZslDisabledByUseCaseConfigStatus();
        updateLowLightBoostDisabledByUseCaseSessionConfigStatus();
        updateCaptureSessionConfig();
        resetCaptureSession(false);
        if (this.mState == InternalState.OPENED) {
            openCaptureSession();
        } else {
            openInternal();
        }
        if (rational != null) {
            this.mCameraControlInternal.setPreviewAspectRatio(rational);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: tryDetachUseCases, reason: merged with bridge method [inline-methods] */
    public void lambda$detachUseCases$17(Collection<UseCaseInfo> collection) {
        ArrayList arrayList = new ArrayList();
        boolean z2 = false;
        for (UseCaseInfo useCaseInfo : collection) {
            if (this.mUseCaseAttachState.isUseCaseAttached(useCaseInfo.getUseCaseId())) {
                this.mUseCaseAttachState.removeUseCase(useCaseInfo.getUseCaseId());
                arrayList.add(useCaseInfo.getUseCaseId());
                if (useCaseInfo.getUseCaseType() == Preview.class) {
                    z2 = true;
                }
            }
        }
        if (arrayList.isEmpty()) {
            return;
        }
        debugLog("Use cases [" + TextUtils.join(", ", arrayList) + "] now DETACHED for camera");
        if (z2) {
            this.mCameraControlInternal.setPreviewAspectRatio(null);
        }
        addOrRemoveMeteringRepeatingUseCase();
        if (this.mUseCaseAttachState.getAttachedUseCaseConfigs().isEmpty()) {
            this.mCameraControlInternal.setZslDisabledByUserCaseConfig(false);
            this.mCameraControlInternal.setLowLightBoostDisabledByUseCaseSessionConfig(false);
        } else {
            updateZslDisabledByUseCaseConfigStatus();
            updateLowLightBoostDisabledByUseCaseSessionConfigStatus();
        }
        if (this.mUseCaseAttachState.getAttachedSessionConfigs().isEmpty()) {
            this.mCameraControlInternal.decrementUseCount();
            resetCaptureSession(false);
            this.mCameraControlInternal.setActive(false);
            this.mCaptureSession = newCaptureSession();
            closeInternal();
            return;
        }
        updateCaptureSessionConfig();
        resetCaptureSession(false);
        if (this.mState == InternalState.OPENED) {
            openCaptureSession();
        }
    }

    private void updateLowLightBoostDisabledByUseCaseSessionConfigStatus() {
        if (this.mCameraInfoInternal.isLowLightBoostSupported()) {
            SessionConfig.ValidatingBuilder activeAndAttachedBuilder = this.mUseCaseAttachState.getActiveAndAttachedBuilder();
            if (activeAndAttachedBuilder.isValid()) {
                if (((Integer) activeAndAttachedBuilder.build().getExpectedFrameRateRange().getUpper()).intValue() > 30) {
                    this.mCameraControlInternal.setLowLightBoostDisabledByUseCaseSessionConfig(true);
                } else {
                    this.mCameraControlInternal.setLowLightBoostDisabledByUseCaseSessionConfig(false);
                }
            }
        }
    }

    private void updateZslDisabledByUseCaseConfigStatus() {
        Iterator<UseCaseConfig<?>> it = this.mUseCaseAttachState.getAttachedUseCaseConfigs().iterator();
        boolean zIsZslDisabled = false;
        while (it.hasNext()) {
            zIsZslDisabled |= it.next().isZslDisabled(false);
        }
        this.mCameraControlInternal.setZslDisabledByUserCaseConfig(zIsZslDisabled);
    }

    @Override // androidx.camera.core.impl.CameraInternal
    public void attachUseCases(Collection<UseCase> collection) {
        ArrayList arrayList = new ArrayList(collection);
        if (arrayList.isEmpty()) {
            return;
        }
        this.mCameraControlInternal.incrementUseCount();
        notifySessionStartedAndCameraControlReady(new ArrayList<>(arrayList));
        try {
            this.mExecutor.execute(new n(this, new ArrayList(toUseCaseInfos(arrayList)), 1));
        } catch (RejectedExecutionException e) {
            debugLog("Unable to attach use cases.", e);
            this.mCameraControlInternal.decrementUseCount();
        }
    }

    @Override // androidx.camera.core.impl.CameraInternal
    public void close() {
        this.mExecutor.execute(new r(this, 3));
    }

    public void closeCamera(boolean z2) {
        Preconditions.checkState(this.mState == InternalState.CLOSING || this.mState == InternalState.RELEASING || (this.mState == InternalState.REOPENING && this.mCameraDeviceError != 0), "closeCamera should only be called in a CLOSING, RELEASING or REOPENING (with error) state. Current state: " + this.mState + " (error: " + getErrorMessage(this.mCameraDeviceError) + ")");
        resetCaptureSession(z2);
        this.mCaptureSession.cancelIssuedCaptureRequests();
    }

    public void debugLog(String str) {
        debugLog(str, null);
    }

    @Override // androidx.camera.core.impl.CameraInternal
    public void detachUseCases(Collection<UseCase> collection) {
        ArrayList arrayList = new ArrayList(collection);
        if (arrayList.isEmpty()) {
            return;
        }
        ArrayList arrayList2 = new ArrayList(toUseCaseInfos(arrayList));
        notifySessionStoppedToUseCases(new ArrayList<>(arrayList));
        this.mExecutor.execute(new n(this, arrayList2, 0));
    }

    public SessionConfig findSessionConfigForSurface(DeferrableSurface deferrableSurface) {
        for (SessionConfig sessionConfig : this.mUseCaseAttachState.getAttachedSessionConfigs()) {
            if (sessionConfig.getSurfaces().contains(deferrableSurface)) {
                return sessionConfig;
            }
        }
        return null;
    }

    public void finishClose() {
        Preconditions.checkState(this.mState == InternalState.RELEASING || this.mState == InternalState.CLOSING);
        Preconditions.checkState(this.mReleasedCaptureSessions.isEmpty());
        this.mCameraDevice = null;
        if (this.mState == InternalState.CLOSING) {
            setState(InternalState.INITIALIZED);
            return;
        }
        this.mCameraManager.unregisterAvailabilityCallback(this.mCameraAvailability);
        setState(InternalState.RELEASED);
        CallbackToFutureAdapter.Completer<Void> completer = this.mUserReleaseNotifier;
        if (completer != null) {
            completer.set(null);
            this.mUserReleaseNotifier = null;
        }
    }

    @VisibleForTesting
    public CameraAvailability getCameraAvailability() {
        return this.mCameraAvailability;
    }

    @Override // androidx.camera.core.impl.CameraInternal, androidx.camera.core.Camera
    public final /* synthetic */ CameraControl getCameraControl() {
        return androidx.camera.core.impl.l.a(this);
    }

    @Override // androidx.camera.core.impl.CameraInternal
    public CameraControlInternal getCameraControlInternal() {
        return this.mCameraControlInternal;
    }

    @Override // androidx.camera.core.impl.CameraInternal, androidx.camera.core.Camera
    public final /* synthetic */ CameraInfo getCameraInfo() {
        return androidx.camera.core.impl.l.b(this);
    }

    @Override // androidx.camera.core.impl.CameraInternal
    public CameraInfoInternal getCameraInfoInternal() {
        return this.mCameraInfoInternal;
    }

    @Override // androidx.camera.core.impl.CameraInternal
    public Observable<CameraInternal.State> getCameraState() {
        return this.mObservableState;
    }

    @Override // androidx.camera.core.impl.CameraInternal, androidx.camera.core.Camera
    public CameraConfig getExtendedConfig() {
        return this.mCameraConfig;
    }

    @Override // androidx.camera.core.impl.CameraInternal
    public final /* synthetic */ boolean getHasTransform() {
        return androidx.camera.core.impl.l.d(this);
    }

    @Override // androidx.camera.core.impl.CameraInternal
    public final /* synthetic */ boolean isFrontFacing() {
        return androidx.camera.core.impl.l.e(this);
    }

    @VisibleForTesting
    public boolean isMeteringRepeatingAttached() {
        try {
            return ((Boolean) CallbackToFutureAdapter.getFuture(new l(this, 4)).get()).booleanValue();
        } catch (InterruptedException | ExecutionException e) {
            throw new RuntimeException("Unable to check if MeteringRepeating is attached.", e);
        }
    }

    public boolean isSessionCloseComplete() {
        return this.mReleasedCaptureSessions.isEmpty();
    }

    @VisibleForTesting
    public boolean isUseCaseAttached(UseCase useCase) {
        try {
            return ((Boolean) CallbackToFutureAdapter.getFuture(new m(0, this, getUseCaseId(useCase))).get()).booleanValue();
        } catch (InterruptedException | ExecutionException e) {
            throw new RuntimeException("Unable to check if use case is attached.", e);
        }
    }

    @Override // androidx.camera.core.Camera
    public final /* synthetic */ boolean isUseCasesCombinationSupported(boolean z2, UseCase... useCaseArr) {
        return androidx.camera.core.c.a(this, z2, useCaseArr);
    }

    @Override // androidx.camera.core.Camera
    public final /* synthetic */ boolean isUseCasesCombinationSupportedByFramework(UseCase... useCaseArr) {
        return androidx.camera.core.c.c(this, useCaseArr);
    }

    @Override // androidx.camera.core.impl.CameraInternal
    public void onRemoved() {
        this.mExecutor.execute(new r(this, 0));
    }

    @Override // androidx.camera.core.UseCase.StateChangeCallback
    public void onUseCaseActive(UseCase useCase) {
        Preconditions.checkNotNull(useCase);
        this.mExecutor.execute(new k(this, getUseCaseId(useCase), this.mIsPrimary ? useCase.getSessionConfig() : useCase.getSecondarySessionConfig(), useCase.getCurrentConfig(), useCase.getAttachedStreamSpec(), getCaptureTypes(useCase), 0));
    }

    @Override // androidx.camera.core.UseCase.StateChangeCallback
    public void onUseCaseInactive(UseCase useCase) {
        Preconditions.checkNotNull(useCase);
        this.mExecutor.execute(new j(1, this, getUseCaseId(useCase)));
    }

    @Override // androidx.camera.core.UseCase.StateChangeCallback
    public void onUseCaseReset(UseCase useCase) {
        Preconditions.checkNotNull(useCase);
        resetUseCase(getUseCaseId(useCase), this.mIsPrimary ? useCase.getSessionConfig() : useCase.getSecondarySessionConfig(), useCase.getCurrentConfig(), useCase.getAttachedStreamSpec(), getCaptureTypes(useCase));
    }

    @Override // androidx.camera.core.UseCase.StateChangeCallback
    public void onUseCaseUpdated(UseCase useCase) {
        Preconditions.checkNotNull(useCase);
        this.mExecutor.execute(new k(this, getUseCaseId(useCase), this.mIsPrimary ? useCase.getSessionConfig() : useCase.getSecondarySessionConfig(), useCase.getCurrentConfig(), useCase.getAttachedStreamSpec(), getCaptureTypes(useCase), 2));
    }

    @Override // androidx.camera.core.impl.CameraInternal
    public void open() {
        this.mExecutor.execute(new r(this, 1));
    }

    @OptIn(markerClass = {ExperimentalCamera2Interop.class})
    public void openCaptureSession() {
        Preconditions.checkState(this.mState == InternalState.OPENED);
        SessionConfig.ValidatingBuilder attachedBuilder = this.mUseCaseAttachState.getAttachedBuilder();
        if (!attachedBuilder.isValid()) {
            debugLog("Unable to create capture session due to conflicting configurations");
            return;
        }
        if (!this.mCameraStateRegistry.tryOpenCaptureSession(this.mCameraDevice.getId(), this.mCameraCoordinator.getPairedConcurrentCameraId(this.mCameraDevice.getId()))) {
            debugLog("Unable to create capture session in camera operating mode = " + this.mCameraCoordinator.getCameraOperatingMode());
        } else {
            HashMap map = new HashMap();
            StreamUseCaseUtil.populateSurfaceToStreamUseCaseMapping(this.mUseCaseAttachState.getAttachedSessionConfigs(), this.mUseCaseAttachState.getAttachedUseCaseConfigs(), map);
            this.mCaptureSession.setStreamUseCaseMap(map);
            final CaptureSessionInterface captureSessionInterface = this.mCaptureSession;
            Futures.addCallback(captureSessionInterface.open(attachedBuilder.build(), (CameraDevice) Preconditions.checkNotNull(this.mCameraDevice), this.mCaptureSessionOpenerBuilder.build()), new FutureCallback<Void>() { // from class: androidx.camera.camera2.internal.Camera2CameraImpl.4
                @Override // androidx.camera.core.impl.utils.futures.FutureCallback
                public void onFailure(Throwable th) {
                    if (th instanceof DeferrableSurface.SurfaceClosedException) {
                        SessionConfig sessionConfigFindSessionConfigForSurface = Camera2CameraImpl.this.findSessionConfigForSurface(((DeferrableSurface.SurfaceClosedException) th).getDeferrableSurface());
                        if (sessionConfigFindSessionConfigForSurface != null) {
                            Camera2CameraImpl.this.postSurfaceClosedError(sessionConfigFindSessionConfigForSurface);
                            return;
                        }
                        return;
                    }
                    if (th instanceof CancellationException) {
                        Camera2CameraImpl.this.debugLog("Unable to configure camera cancelled");
                        return;
                    }
                    InternalState internalState = Camera2CameraImpl.this.mState;
                    InternalState internalState2 = InternalState.OPENED;
                    if (internalState == internalState2) {
                        Camera2CameraImpl.this.setState(internalState2, CameraState.StateError.create(4, th));
                    }
                    Logger.e(Camera2CameraImpl.TAG, "Unable to configure camera " + Camera2CameraImpl.this, th);
                    Camera2CameraImpl camera2CameraImpl = Camera2CameraImpl.this;
                    if (camera2CameraImpl.mCaptureSession == captureSessionInterface) {
                        camera2CameraImpl.resetCaptureSession(false);
                    }
                }

                @Override // androidx.camera.core.impl.utils.futures.FutureCallback
                public void onSuccess(Void r22) {
                    if (Camera2CameraImpl.this.mCameraCoordinator.getCameraOperatingMode() == 2 && Camera2CameraImpl.this.mState == InternalState.OPENED) {
                        Camera2CameraImpl.this.setState(InternalState.CONFIGURED);
                    }
                }
            }, this.mExecutor);
        }
    }

    public void postSurfaceClosedError(SessionConfig sessionConfig) {
        ScheduledExecutorService scheduledExecutorServiceMainThreadExecutor = CameraXExecutors.mainThreadExecutor();
        SessionConfig.ErrorListener errorListener = sessionConfig.getErrorListener();
        if (errorListener != null) {
            debugLog("Posting surface closed", new Throwable());
            scheduledExecutorServiceMainThreadExecutor.execute(new j(2, errorListener, sessionConfig));
        }
    }

    @Override // androidx.camera.core.impl.CameraInternal
    public j2.q release() {
        return CallbackToFutureAdapter.getFuture(new l(this, 0));
    }

    public j2.q releaseSession(final CaptureSessionInterface captureSessionInterface, boolean z2) {
        captureSessionInterface.close();
        j2.q qVarRelease = captureSessionInterface.release(z2);
        debugLog("Releasing session in state " + this.mState.name());
        this.mReleasedCaptureSessions.put(captureSessionInterface, qVarRelease);
        Futures.addCallback(qVarRelease, new FutureCallback<Void>() { // from class: androidx.camera.camera2.internal.Camera2CameraImpl.3
            @Override // androidx.camera.core.impl.utils.futures.FutureCallback
            public void onSuccess(Void r22) {
                Camera2CameraImpl.this.mReleasedCaptureSessions.remove(captureSessionInterface);
                int iOrdinal = Camera2CameraImpl.this.mState.ordinal();
                if (iOrdinal != 1 && iOrdinal != 5) {
                    if (iOrdinal != 6 && (iOrdinal != 7 || Camera2CameraImpl.this.mCameraDeviceError == 0)) {
                        return;
                    } else {
                        Camera2CameraImpl.this.debugLog("Camera reopen required. Checking if the current camera can be closed safely.");
                    }
                }
                if (Camera2CameraImpl.this.isSessionCloseComplete()) {
                    Camera2CameraImpl camera2CameraImpl = Camera2CameraImpl.this;
                    if (camera2CameraImpl.mCameraDevice != null) {
                        camera2CameraImpl.debugLog("closing camera");
                        ApiCompat.Api21Impl.close(Camera2CameraImpl.this.mCameraDevice);
                        Camera2CameraImpl.this.mCameraDevice = null;
                    }
                }
            }

            @Override // androidx.camera.core.impl.utils.futures.FutureCallback
            public void onFailure(Throwable th) {
            }
        }, CameraXExecutors.directExecutor());
        return qVarRelease;
    }

    public void resetCaptureSession(boolean z2) {
        Preconditions.checkState(this.mCaptureSession != null);
        debugLog("Resetting Capture Session");
        CaptureSessionInterface captureSessionInterface = this.mCaptureSession;
        SessionConfig sessionConfig = captureSessionInterface.getSessionConfig();
        List<CaptureConfig> captureConfigs = captureSessionInterface.getCaptureConfigs();
        CaptureSessionInterface captureSessionInterfaceNewCaptureSession = newCaptureSession();
        this.mCaptureSession = captureSessionInterfaceNewCaptureSession;
        captureSessionInterfaceNewCaptureSession.setSessionConfig(sessionConfig);
        this.mCaptureSession.issueCaptureRequests(captureConfigs);
        if (this.mState.ordinal() != 9) {
            debugLog("Skipping Capture Session state check due to current camera state: " + this.mState + " and previous session status: " + captureSessionInterface.isInOpenState());
        } else if (this.mShouldCloseCameraBeforeCreateNewSession && captureSessionInterface.isInOpenState()) {
            debugLog("Close camera before creating new session");
            setState(InternalState.REOPENING_QUIRK);
        }
        if (this.mConfigAndCloseQuirk && captureSessionInterface.isInOpenState()) {
            debugLog("ConfigAndClose is required when close the camera.");
            this.mIsConfigAndCloseRequired = true;
        }
        releaseSession(captureSessionInterface, z2);
    }

    @Override // androidx.camera.core.impl.CameraInternal
    public void setActiveResumingMode(final boolean z2) {
        this.mExecutor.execute(new Runnable() { // from class: androidx.camera.camera2.internal.o
            @Override // java.lang.Runnable
            public final void run() {
                this.f3494a.lambda$setActiveResumingMode$19(z2);
            }
        });
    }

    @Override // androidx.camera.core.impl.CameraInternal
    public void setExtendedConfig(CameraConfig cameraConfig) {
        if (cameraConfig == null) {
            cameraConfig = CameraConfigs.defaultConfig();
        }
        SessionProcessor sessionProcessor = cameraConfig.getSessionProcessor(null);
        this.mCameraConfig = cameraConfig;
        synchronized (this.mLock) {
            this.mSessionProcessor = sessionProcessor;
        }
    }

    @Override // androidx.camera.core.impl.CameraInternal
    public void setPrimary(boolean z2) {
        this.mIsPrimary = z2;
    }

    public void setState(InternalState internalState) {
        setState(internalState, null);
    }

    public void submitCaptureRequests(List<CaptureConfig> list) {
        ArrayList arrayList = new ArrayList();
        for (CaptureConfig captureConfig : list) {
            CaptureConfig.Builder builderFrom = CaptureConfig.Builder.from(captureConfig);
            if (captureConfig.getTemplateType() == 5 && captureConfig.getCameraCaptureResult() != null) {
                builderFrom.setCameraCaptureResult(captureConfig.getCameraCaptureResult());
            }
            if (!captureConfig.getSurfaces().isEmpty() || !captureConfig.isUseRepeatingSurface() || checkAndAttachRepeatingSurface(builderFrom)) {
                arrayList.add(builderFrom.build());
            }
        }
        debugLog("Issue capture request");
        this.mCaptureSession.issueCaptureRequests(arrayList);
    }

    public String toString() {
        return String.format(Locale.US, "Camera@%x[id=%s]", Integer.valueOf(hashCode()), this.mCameraInfoInternal.getCameraId());
    }

    public void traceInternalState(InternalState internalState, CameraState.StateError stateError) {
        if (Trace.isEnabled()) {
            Trace.setCounter("CX:C2State[" + this + C2300e4.i.e, internalState.ordinal());
            if (stateError != null) {
                this.mTraceStateErrorCount++;
            }
            if (this.mTraceStateErrorCount > 0) {
                Trace.setCounter("CX:C2StateErrorCode[" + this + C2300e4.i.e, stateError != null ? stateError.getCode() : 0);
            }
        }
    }

    public void tryForceOpenCameraDevice(boolean z2) {
        debugLog("Attempting to force open the camera.");
        if (this.mCameraStateRegistry.tryOpenCamera(this)) {
            openCameraDevice(z2);
        } else {
            debugLog("No cameras available. Waiting for available camera before opening camera.");
            setState(InternalState.PENDING_OPEN);
        }
    }

    public void tryOpenCameraDevice(boolean z2) {
        debugLog("Attempting to open the camera.");
        if (this.mCameraAvailability.isCameraAvailable() && this.mCameraStateRegistry.tryOpenCamera(this)) {
            openCameraDevice(z2);
        } else {
            debugLog("No cameras available. Waiting for available camera before opening camera.");
            setState(InternalState.PENDING_OPEN);
        }
    }

    public void updateCaptureSessionConfig() {
        SessionConfig.ValidatingBuilder activeAndAttachedBuilder = this.mUseCaseAttachState.getActiveAndAttachedBuilder();
        if (!activeAndAttachedBuilder.isValid()) {
            this.mCameraControlInternal.resetTemplate();
            this.mCaptureSession.setSessionConfig(this.mCameraControlInternal.getSessionConfig());
            return;
        }
        this.mCameraControlInternal.setTemplate(activeAndAttachedBuilder.build().getTemplateType());
        activeAndAttachedBuilder.add(this.mCameraControlInternal.getSessionConfig());
        this.mCaptureSession.setSessionConfig(activeAndAttachedBuilder.build());
    }

    private void debugLog(String str, Throwable th) {
        Logger.d(TAG, a1.a.n("{", toString(), "} ", str), th);
    }

    @Override // androidx.camera.core.Camera
    public final /* synthetic */ boolean isUseCasesCombinationSupported(UseCase... useCaseArr) {
        return androidx.camera.core.c.b(this, useCaseArr);
    }

    public void setState(InternalState internalState, CameraState.StateError stateError) {
        setState(internalState, stateError, true);
    }

    public void setState(InternalState internalState, CameraState.StateError stateError, boolean z2) {
        CameraInternal.State state;
        debugLog("Transitioning camera internal state: " + this.mState + " --> " + internalState);
        traceInternalState(internalState, stateError);
        this.mState = internalState;
        switch (internalState) {
            case RELEASED:
                state = CameraInternal.State.RELEASED;
                break;
            case RELEASING:
                state = CameraInternal.State.RELEASING;
                break;
            case INITIALIZED:
                state = CameraInternal.State.CLOSED;
                break;
            case PENDING_OPEN:
                state = CameraInternal.State.PENDING_OPEN;
                break;
            case OPENING_WITH_ERROR:
            case CLOSING:
            case REOPENING_QUIRK:
                state = CameraInternal.State.CLOSING;
                break;
            case REOPENING:
            case OPENING:
                state = CameraInternal.State.OPENING;
                break;
            case OPENED:
                state = CameraInternal.State.OPEN;
                break;
            case CONFIGURED:
                state = CameraInternal.State.CONFIGURED;
                break;
            default:
                throw new IllegalStateException("Unknown state: " + internalState);
        }
        this.mCameraStateRegistry.markCameraState(this, state, z2);
        this.mObservableState.postValue(state);
        this.mCameraStateMachine.updateState(state, stateError);
    }
}
