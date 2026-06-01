package androidx.camera.camera2.internal;

import android.graphics.Rect;
import android.hardware.camera2.CameraCaptureSession;
import android.hardware.camera2.CameraCharacteristics;
import android.hardware.camera2.CaptureRequest;
import android.hardware.camera2.TotalCaptureResult;
import android.os.Build;
import android.util.ArrayMap;
import android.util.Rational;
import androidx.annotation.GuardedBy;
import androidx.annotation.IntRange;
import androidx.annotation.OptIn;
import androidx.annotation.VisibleForTesting;
import androidx.camera.camera2.impl.Camera2ImplConfig;
import androidx.camera.camera2.internal.compat.CameraCharacteristicsCompat;
import androidx.camera.camera2.internal.compat.workaround.AutoFlashAEModeDisabler;
import androidx.camera.camera2.interop.Camera2CameraControl;
import androidx.camera.camera2.interop.CaptureRequestOptions;
import androidx.camera.camera2.interop.ExperimentalCamera2Interop;
import androidx.camera.core.CameraControl;
import androidx.camera.core.FocusMeteringAction;
import androidx.camera.core.ImageCapture;
import androidx.camera.core.Logger;
import androidx.camera.core.impl.CameraCaptureCallback;
import androidx.camera.core.impl.CameraCaptureFailure;
import androidx.camera.core.impl.CameraCaptureResult;
import androidx.camera.core.impl.CameraControlInternal;
import androidx.camera.core.impl.CaptureConfig;
import androidx.camera.core.impl.Config;
import androidx.camera.core.impl.Quirks;
import androidx.camera.core.impl.SessionConfig;
import androidx.camera.core.impl.TagBundle;
import androidx.camera.core.impl.utils.executor.CameraXExecutors;
import androidx.camera.core.impl.utils.futures.AsyncFunction;
import androidx.camera.core.impl.utils.futures.FutureChain;
import androidx.camera.core.impl.utils.futures.Futures;
import androidx.concurrent.futures.CallbackToFutureAdapter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executor;
import java.util.concurrent.RejectedExecutionException;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.atomic.AtomicLong;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes.dex */
@OptIn(markerClass = {ExperimentalCamera2Interop.class})
public class Camera2CameraControlImpl implements CameraControlInternal {
    private static final int DEFAULT_TEMPLATE = 1;
    private static final String TAG = "Camera2CameraControlImp";
    static final String TAG_SESSION_UPDATE_ID = "CameraControlSessionUpdateId";
    private final AutoFlashAEModeDisabler mAutoFlashAEModeDisabler;
    private final Camera2CameraControl mCamera2CameraControl;
    private final Camera2CapturePipeline mCamera2CapturePipeline;
    private final CameraCaptureCallbackSet mCameraCaptureCallbackSet;
    private final CameraCharacteristicsCompat mCameraCharacteristics;
    private final CameraControlInternal.ControlUpdateCallback mControlUpdateCallback;
    private long mCurrentSessionUpdateId;
    final Executor mExecutor;
    private final ExposureControl mExposureControl;
    private volatile int mFlashMode;
    private volatile j2.q mFlashModeChangeSessionUpdateFuture;
    private final FocusMeteringControl mFocusMeteringControl;
    private volatile boolean mIsLowLightBoostOn;
    private boolean mIsRepeatingRequestAvailable;
    private final Object mLock;
    private final LowLightBoostControl mLowLightBoostControl;
    private final AtomicLong mNextSessionUpdateId;
    private ImageCapture.ScreenFlash mScreenFlash;

    @VisibleForTesting
    final CameraControlSessionCallback mSessionCallback;
    private final SessionConfig.Builder mSessionConfigBuilder;
    private int mTemplate;
    private final TorchControl mTorchControl;
    private volatile int mTorchState;

    @IntRange(from = 1)
    private volatile int mTorchStrength;

    @GuardedBy("mLock")
    private int mUseCount;
    private final VideoUsageControl mVideoUsageControl;
    private final ZoomControl mZoomControl;

    @VisibleForTesting
    ZslControl mZslControl;

    /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
    public static final class CameraCaptureCallbackSet extends CameraCaptureCallback {
        Set<CameraCaptureCallback> mCallbacks = new HashSet();
        Map<CameraCaptureCallback, Executor> mCallbackExecutors = new ArrayMap();

        public void addCaptureCallback(Executor executor, CameraCaptureCallback cameraCaptureCallback) {
            this.mCallbacks.add(cameraCaptureCallback);
            this.mCallbackExecutors.put(cameraCaptureCallback, executor);
        }

        @Override // androidx.camera.core.impl.CameraCaptureCallback
        public void onCaptureCancelled(int i2) {
            for (CameraCaptureCallback cameraCaptureCallback : this.mCallbacks) {
                try {
                    this.mCallbackExecutors.get(cameraCaptureCallback).execute(new i(cameraCaptureCallback, i2, 0));
                } catch (RejectedExecutionException e) {
                    Logger.e(Camera2CameraControlImpl.TAG, "Executor rejected to invoke onCaptureCancelled.", e);
                }
            }
        }

        @Override // androidx.camera.core.impl.CameraCaptureCallback
        public void onCaptureCompleted(int i2, CameraCaptureResult cameraCaptureResult) {
            for (CameraCaptureCallback cameraCaptureCallback : this.mCallbacks) {
                try {
                    this.mCallbackExecutors.get(cameraCaptureCallback).execute(new h(cameraCaptureCallback, i2, cameraCaptureResult, 1));
                } catch (RejectedExecutionException e) {
                    Logger.e(Camera2CameraControlImpl.TAG, "Executor rejected to invoke onCaptureCompleted.", e);
                }
            }
        }

        @Override // androidx.camera.core.impl.CameraCaptureCallback
        public void onCaptureFailed(int i2, CameraCaptureFailure cameraCaptureFailure) {
            for (CameraCaptureCallback cameraCaptureCallback : this.mCallbacks) {
                try {
                    this.mCallbackExecutors.get(cameraCaptureCallback).execute(new h(cameraCaptureCallback, i2, cameraCaptureFailure, 0));
                } catch (RejectedExecutionException e) {
                    Logger.e(Camera2CameraControlImpl.TAG, "Executor rejected to invoke onCaptureFailed.", e);
                }
            }
        }

        public void removeCaptureCallback(CameraCaptureCallback cameraCaptureCallback) {
            this.mCallbacks.remove(cameraCaptureCallback);
            this.mCallbackExecutors.remove(cameraCaptureCallback);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
    public static final class CameraControlSessionCallback extends CameraCaptureSession.CaptureCallback {
        private final Executor mExecutor;
        final Set<CaptureResultListener> mResultListeners = new HashSet();

        public CameraControlSessionCallback(Executor executor) {
            this.mExecutor = executor;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void lambda$onCaptureCompleted$0(TotalCaptureResult totalCaptureResult) {
            HashSet hashSet = new HashSet();
            for (CaptureResultListener captureResultListener : this.mResultListeners) {
                if (captureResultListener.onCaptureResult(totalCaptureResult)) {
                    hashSet.add(captureResultListener);
                }
            }
            if (hashSet.isEmpty()) {
                return;
            }
            this.mResultListeners.removeAll(hashSet);
        }

        public void addListener(CaptureResultListener captureResultListener) {
            this.mResultListeners.add(captureResultListener);
        }

        @Override // android.hardware.camera2.CameraCaptureSession.CaptureCallback
        public void onCaptureCompleted(CameraCaptureSession cameraCaptureSession, CaptureRequest captureRequest, TotalCaptureResult totalCaptureResult) {
            this.mExecutor.execute(new j(0, this, totalCaptureResult));
        }

        public void removeListener(CaptureResultListener captureResultListener) {
            this.mResultListeners.remove(captureResultListener);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
    public interface CaptureResultListener {
        boolean onCaptureResult(TotalCaptureResult totalCaptureResult);
    }

    @VisibleForTesting
    public Camera2CameraControlImpl(CameraCharacteristicsCompat cameraCharacteristicsCompat, ScheduledExecutorService scheduledExecutorService, Executor executor, CameraControlInternal.ControlUpdateCallback controlUpdateCallback) {
        this(cameraCharacteristicsCompat, scheduledExecutorService, executor, controlUpdateCallback, new Quirks(new ArrayList()));
    }

    private int getSupportedAwbMode(int i2) {
        int[] iArr = (int[]) this.mCameraCharacteristics.get(CameraCharacteristics.CONTROL_AWB_AVAILABLE_MODES);
        if (iArr == null) {
            return 0;
        }
        return isModeInList(i2, iArr) ? i2 : isModeInList(1, iArr) ? 1 : 0;
    }

    private boolean isControlInUse() {
        return getUseCount() > 0;
    }

    private static boolean isModeInList(int i2, int[] iArr) {
        for (int i8 : iArr) {
            if (i2 == i8) {
                return true;
            }
        }
        return false;
    }

    @VisibleForTesting
    private boolean isRepeatingRequestAvailable() {
        try {
            return ((Boolean) CallbackToFutureAdapter.getFuture(new b(this, 1)).get()).booleanValue();
        } catch (InterruptedException | ExecutionException e) {
            throw new RuntimeException("Unable to check if repeating request is available.", e);
        }
    }

    public static boolean isSessionUpdated(TotalCaptureResult totalCaptureResult, long j) {
        Long l;
        if (totalCaptureResult.getRequest() == null) {
            return false;
        }
        Object tag = totalCaptureResult.getRequest().getTag();
        return (tag instanceof TagBundle) && (l = (Long) ((TagBundle) tag).getTag(TAG_SESSION_UPDATE_ID)) != null && l.longValue() >= j;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$addSessionCameraCaptureCallback$8(Executor executor, CameraCaptureCallback cameraCaptureCallback) {
        this.mCameraCaptureCallbackSet.addCaptureCallback(executor, cameraCaptureCallback);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ j2.q lambda$getCameraCapturePipelineAsync$5(int i2, int i8, int i9, Void r42) throws Exception {
        return Futures.immediateFuture(this.mCamera2CapturePipeline.getCameraCapturePipeline(i2, i8, i9));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$isRepeatingRequestAvailable$10(CallbackToFutureAdapter.Completer completer) {
        completer.set(Boolean.valueOf(this.mIsRepeatingRequestAvailable));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ Object lambda$isRepeatingRequestAvailable$11(CallbackToFutureAdapter.Completer completer) throws Exception {
        try {
            this.mExecutor.execute(new c(this, completer, 0));
            return "isRepeatingRequestAvailable";
        } catch (RejectedExecutionException unused) {
            completer.setException(new RuntimeException("Unable to check if repeating request is available. Camera executor shut down."));
            return "isRepeatingRequestAvailable";
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$removeSessionCameraCaptureCallback$9(CameraCaptureCallback cameraCaptureCallback) {
        this.mCameraCaptureCallbackSet.removeCaptureCallback(cameraCaptureCallback);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ j2.q lambda$submitStillCaptureRequests$4(List list, int i2, int i8, int i9, Void r52) throws Exception {
        return this.mCamera2CapturePipeline.submitStillCaptures(list, i2, i8, i9);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$updateSessionConfigAsync$6(CallbackToFutureAdapter.Completer completer) {
        Futures.propagate(waitForSessionUpdateId(updateSessionConfigSynchronous()), completer);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ Object lambda$updateSessionConfigAsync$7(CallbackToFutureAdapter.Completer completer) throws Exception {
        this.mExecutor.execute(new c(this, completer, 1));
        return "updateSessionConfigAsync";
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ boolean lambda$waitForSessionUpdateId$2(long j, CallbackToFutureAdapter.Completer completer, TotalCaptureResult totalCaptureResult) {
        if (!isSessionUpdated(totalCaptureResult, j)) {
            return false;
        }
        completer.set(null);
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ Object lambda$waitForSessionUpdateId$3(final long j, final CallbackToFutureAdapter.Completer completer) throws Exception {
        addCaptureResultListener(new CaptureResultListener() { // from class: androidx.camera.camera2.internal.d
            @Override // androidx.camera.camera2.internal.Camera2CameraControlImpl.CaptureResultListener
            public final boolean onCaptureResult(TotalCaptureResult totalCaptureResult) {
                return Camera2CameraControlImpl.lambda$waitForSessionUpdateId$2(j, completer, totalCaptureResult);
            }
        });
        return "waitForSessionUpdateId:" + j;
    }

    private void resetAeFlashState() {
        CaptureConfig.Builder builder = new CaptureConfig.Builder();
        builder.setTemplateType(this.mTemplate);
        builder.setUseRepeatingSurface(true);
        Camera2ImplConfig.Builder builder2 = new Camera2ImplConfig.Builder();
        builder2.setCaptureRequestOption(CaptureRequest.CONTROL_AE_MODE, Integer.valueOf(getSupportedAeMode(1)));
        builder2.setCaptureRequestOption(CaptureRequest.FLASH_MODE, 0);
        builder.addImplementationOptions(builder2.build());
        submitCaptureRequestsInternal(Collections.singletonList(builder.build()));
    }

    private j2.q waitForSessionUpdateId(final long j) {
        return CallbackToFutureAdapter.getFuture(new CallbackToFutureAdapter.Resolver() { // from class: androidx.camera.camera2.internal.g
            @Override // androidx.concurrent.futures.CallbackToFutureAdapter.Resolver
            public final Object attachCompleter(CallbackToFutureAdapter.Completer completer) {
                return this.f3443a.lambda$waitForSessionUpdateId$3(j, completer);
            }
        });
    }

    public void addCaptureResultListener(CaptureResultListener captureResultListener) {
        this.mSessionCallback.addListener(captureResultListener);
    }

    @Override // androidx.camera.core.impl.CameraControlInternal
    public void addInteropConfig(Config config) {
        this.mCamera2CameraControl.addCaptureRequestOptions(CaptureRequestOptions.Builder.from(config).build()).addListener(new a0(2), CameraXExecutors.directExecutor());
    }

    public void addSessionCameraCaptureCallback(Executor executor, CameraCaptureCallback cameraCaptureCallback) {
        this.mExecutor.execute(new s(this, executor, cameraCaptureCallback, 2));
    }

    @Override // androidx.camera.core.impl.CameraControlInternal
    public void addZslConfig(SessionConfig.Builder builder) {
        this.mZslControl.addZslConfig(builder);
    }

    @Override // androidx.camera.core.CameraControl
    public j2.q cancelFocusAndMetering() {
        return !isControlInUse() ? Futures.immediateFailedFuture(new CameraControl.OperationCanceledException("Camera is not active.")) : !isRepeatingRequestAvailable() ? Futures.immediateFailedFuture(new CameraControl.OperationCanceledException("Repeating request is not available possibly because it's disable for the ImageCapture.")) : Futures.nonCancellationPropagating(this.mFocusMeteringControl.cancelFocusAndMetering());
    }

    @Override // androidx.camera.core.impl.CameraControlInternal
    public void clearInteropConfig() {
        this.mCamera2CameraControl.clearCaptureRequestOptions().addListener(new a0(1), CameraXExecutors.directExecutor());
    }

    @Override // androidx.camera.core.impl.CameraControlInternal
    public void clearZslConfig() {
        this.mZslControl.clearZslConfig();
    }

    public void decrementUseCount() {
        synchronized (this.mLock) {
            try {
                int i2 = this.mUseCount;
                if (i2 == 0) {
                    throw new IllegalStateException("Decrementing use count occurs more times than incrementing");
                }
                this.mUseCount = i2 - 1;
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Override // androidx.camera.core.impl.CameraControlInternal
    public void decrementVideoUsage() {
        this.mVideoUsageControl.decrementUsage();
    }

    @Override // androidx.camera.core.CameraControl
    public j2.q enableLowLightBoostAsync(boolean z2) {
        return !isControlInUse() ? Futures.immediateFailedFuture(new CameraControl.OperationCanceledException("Camera is not active.")) : Futures.nonCancellationPropagating(this.mLowLightBoostControl.enableLowLightBoost(z2));
    }

    public void enableLowLightBoostInternal(boolean z2) {
        if (this.mIsLowLightBoostOn == z2) {
            return;
        }
        if (z2 && isTorchOn()) {
            resetAeFlashState();
            this.mTorchState = 0;
            this.mTorchControl.forceUpdateTorchStateToOff();
        }
        this.mIsLowLightBoostOn = z2;
        updateSessionConfigSynchronous();
    }

    @Override // androidx.camera.core.CameraControl
    public j2.q enableTorch(boolean z2) {
        return !isControlInUse() ? Futures.immediateFailedFuture(new CameraControl.OperationCanceledException("Camera is not active.")) : Futures.nonCancellationPropagating(this.mTorchControl.enableTorch(z2));
    }

    public void enableTorchInternal(int i2) {
        if (this.mIsLowLightBoostOn) {
            return;
        }
        this.mTorchState = i2;
        if (i2 == 0) {
            resetAeFlashState();
        }
        updateSessionConfigSynchronous();
    }

    public Camera2CameraControl getCamera2CameraControl() {
        return this.mCamera2CameraControl;
    }

    @Override // androidx.camera.core.impl.CameraControlInternal
    public j2.q getCameraCapturePipelineAsync(final int i2, final int i8) {
        if (isControlInUse()) {
            final int flashMode = getFlashMode();
            return FutureChain.from(Futures.nonCancellationPropagating(this.mFlashModeChangeSessionUpdateFuture)).transformAsync(new AsyncFunction() { // from class: androidx.camera.camera2.internal.f
                @Override // androidx.camera.core.impl.utils.futures.AsyncFunction
                public final j2.q apply(Object obj) {
                    return this.f3432a.lambda$getCameraCapturePipelineAsync$5(i2, flashMode, i8, (Void) obj);
                }
            }, this.mExecutor);
        }
        Logger.w(TAG, "Camera is not active.");
        return Futures.immediateFailedFuture(new CameraControl.OperationCanceledException("Camera is not active."));
    }

    public Rect getCropSensorRegion() {
        return this.mZoomControl.getCropSensorRegion();
    }

    @VisibleForTesting
    public long getCurrentSessionUpdateId() {
        return this.mCurrentSessionUpdateId;
    }

    public ExposureControl getExposureControl() {
        return this.mExposureControl;
    }

    @Override // androidx.camera.core.impl.CameraControlInternal
    public int getFlashMode() {
        return this.mFlashMode;
    }

    public FocusMeteringControl getFocusMeteringControl() {
        return this.mFocusMeteringControl;
    }

    @Override // androidx.camera.core.impl.CameraControlInternal
    public final /* synthetic */ CameraControlInternal getImplementation() {
        return CameraControlInternal.CC.c(this);
    }

    @Override // androidx.camera.core.impl.CameraControlInternal
    public Config getInteropConfig() {
        return this.mCamera2CameraControl.getCamera2ImplConfig();
    }

    public LowLightBoostControl getLowLightBoostControl() {
        return this.mLowLightBoostControl;
    }

    public int getMaxAeRegionCount() {
        Integer num = (Integer) this.mCameraCharacteristics.get(CameraCharacteristics.CONTROL_MAX_REGIONS_AE);
        if (num == null) {
            return 0;
        }
        return num.intValue();
    }

    public int getMaxAfRegionCount() {
        Integer num = (Integer) this.mCameraCharacteristics.get(CameraCharacteristics.CONTROL_MAX_REGIONS_AF);
        if (num == null) {
            return 0;
        }
        return num.intValue();
    }

    public int getMaxAwbRegionCount() {
        Integer num = (Integer) this.mCameraCharacteristics.get(CameraCharacteristics.CONTROL_MAX_REGIONS_AWB);
        if (num == null) {
            return 0;
        }
        return num.intValue();
    }

    public ImageCapture.ScreenFlash getScreenFlash() {
        return this.mScreenFlash;
    }

    @Override // androidx.camera.core.impl.CameraControlInternal
    public SessionConfig getSessionConfig() {
        this.mSessionConfigBuilder.setTemplateType(this.mTemplate);
        this.mSessionConfigBuilder.setImplementationOptions(getSessionOptions());
        this.mSessionConfigBuilder.addTag(TAG_SESSION_UPDATE_ID, Long.valueOf(this.mCurrentSessionUpdateId));
        return this.mSessionConfigBuilder.build();
    }

    @VisibleForTesting
    public Config getSessionOptions() {
        Camera2ImplConfig.Builder builder = new Camera2ImplConfig.Builder();
        CaptureRequest.Key key = CaptureRequest.CONTROL_MODE;
        Config.OptionPriority optionPriority = Config.OptionPriority.REQUIRED;
        builder.setCaptureRequestOptionWithPriority(key, 1, optionPriority);
        this.mFocusMeteringControl.addFocusMeteringOptions(builder);
        this.mZoomControl.addZoomOption(builder);
        int correctedAeMode = this.mFocusMeteringControl.isExternalFlashAeModeEnabled() ? 5 : 1;
        if (this.mIsLowLightBoostOn) {
            correctedAeMode = 6;
        } else if (isTorchOn()) {
            builder.setCaptureRequestOptionWithPriority(CaptureRequest.FLASH_MODE, 2, optionPriority);
            if (Build.VERSION.SDK_INT >= 35) {
                if (this.mTorchState == 1) {
                    builder.setCaptureRequestOptionWithPriority(CaptureRequest.FLASH_STRENGTH_LEVEL, Integer.valueOf(this.mTorchStrength), optionPriority);
                } else if (this.mTorchState == 2) {
                    builder.setCaptureRequestOptionWithPriority(CaptureRequest.FLASH_STRENGTH_LEVEL, Integer.valueOf(this.mCameraCharacteristics.getDefaultTorchStrengthLevel()), optionPriority);
                }
            }
        } else {
            int i2 = this.mFlashMode;
            if (i2 == 0) {
                correctedAeMode = this.mAutoFlashAEModeDisabler.getCorrectedAeMode(2);
            } else if (i2 == 1) {
                correctedAeMode = 3;
            } else if (i2 == 2) {
                correctedAeMode = 1;
            }
        }
        builder.setCaptureRequestOptionWithPriority(CaptureRequest.CONTROL_AE_MODE, Integer.valueOf(getSupportedAeMode(correctedAeMode)), optionPriority);
        builder.setCaptureRequestOptionWithPriority(CaptureRequest.CONTROL_AWB_MODE, Integer.valueOf(getSupportedAwbMode(1)), optionPriority);
        this.mExposureControl.setCaptureRequestOption(builder);
        this.mCamera2CameraControl.applyOptionsToBuilder(builder);
        return builder.build();
    }

    public int getSupportedAeMode(int i2) {
        return getSupportedAeMode(this.mCameraCharacteristics, i2);
    }

    public int getSupportedAfMode(int i2) {
        int[] iArr = (int[]) this.mCameraCharacteristics.get(CameraCharacteristics.CONTROL_AF_AVAILABLE_MODES);
        if (iArr == null) {
            return 0;
        }
        if (isModeInList(i2, iArr)) {
            return i2;
        }
        if (isModeInList(4, iArr)) {
            return 4;
        }
        return isModeInList(1, iArr) ? 1 : 0;
    }

    public TorchControl getTorchControl() {
        return this.mTorchControl;
    }

    @VisibleForTesting
    public int getUseCount() {
        int i2;
        synchronized (this.mLock) {
            i2 = this.mUseCount;
        }
        return i2;
    }

    public ZoomControl getZoomControl() {
        return this.mZoomControl;
    }

    public ZslControl getZslControl() {
        return this.mZslControl;
    }

    public void incrementUseCount() {
        synchronized (this.mLock) {
            this.mUseCount++;
        }
    }

    @Override // androidx.camera.core.impl.CameraControlInternal
    public void incrementVideoUsage() {
        this.mVideoUsageControl.incrementUsage();
    }

    @Override // androidx.camera.core.impl.CameraControlInternal
    public boolean isInVideoUsage() {
        int usage = this.mVideoUsageControl.getUsage();
        Logger.d(TAG, "isInVideoUsage: mVideoUsageControl value = " + usage);
        return usage > 0;
    }

    public boolean isLowLightBoostOn() {
        return this.mIsLowLightBoostOn;
    }

    public boolean isTorchOn() {
        return this.mTorchState != 0;
    }

    @Override // androidx.camera.core.impl.CameraControlInternal
    public boolean isZslDisabledByByUserCaseConfig() {
        return this.mZslControl.isZslDisabledByUserCaseConfig();
    }

    public void removeCaptureResultListener(CaptureResultListener captureResultListener) {
        this.mSessionCallback.removeListener(captureResultListener);
    }

    public void removeSessionCameraCaptureCallback(CameraCaptureCallback cameraCaptureCallback) {
        this.mExecutor.execute(new j(7, this, cameraCaptureCallback));
    }

    public void resetTemplate() {
        setTemplate(1);
    }

    public void setActive(boolean z2) {
        Logger.d(TAG, "setActive: isActive = " + z2);
        this.mFocusMeteringControl.setActive(z2);
        this.mZoomControl.setActive(z2);
        this.mLowLightBoostControl.setActive(z2);
        this.mTorchControl.setActive(z2);
        this.mExposureControl.setActive(z2);
        this.mCamera2CameraControl.setActive(z2);
        if (z2) {
            return;
        }
        this.mScreenFlash = null;
        this.mVideoUsageControl.resetDirectly();
    }

    @Override // androidx.camera.core.CameraControl
    public j2.q setExposureCompensationIndex(int i2) {
        return !isControlInUse() ? Futures.immediateFailedFuture(new CameraControl.OperationCanceledException("Camera is not active.")) : this.mExposureControl.setExposureCompensationIndex(i2);
    }

    @Override // androidx.camera.core.impl.CameraControlInternal
    public void setFlashMode(int i2) {
        if (!isControlInUse()) {
            Logger.w(TAG, "Camera is not active.");
            return;
        }
        this.mFlashMode = i2;
        Logger.d(TAG, "setFlashMode: mFlashMode = " + this.mFlashMode);
        ZslControl zslControl = this.mZslControl;
        boolean z2 = true;
        if (this.mFlashMode != 1 && this.mFlashMode != 0) {
            z2 = false;
        }
        zslControl.setZslDisabledByFlashMode(z2);
        this.mFlashModeChangeSessionUpdateFuture = updateSessionConfigAsync();
    }

    public void setIsRepeatingRequestAvailable(boolean z2) {
        this.mIsRepeatingRequestAvailable = z2;
    }

    @Override // androidx.camera.core.CameraControl
    public j2.q setLinearZoom(float f4) {
        return !isControlInUse() ? Futures.immediateFailedFuture(new CameraControl.OperationCanceledException("Camera is not active.")) : Futures.nonCancellationPropagating(this.mZoomControl.setLinearZoom(f4));
    }

    @Override // androidx.camera.core.impl.CameraControlInternal
    public void setLowLightBoostDisabledByUseCaseSessionConfig(boolean z2) {
        this.mLowLightBoostControl.setLowLightBoostDisabledByUseCaseSessionConfig(z2);
    }

    public void setPreviewAspectRatio(Rational rational) {
        this.mFocusMeteringControl.setPreviewAspectRatio(rational);
    }

    @Override // androidx.camera.core.impl.CameraControlInternal
    public void setScreenFlash(ImageCapture.ScreenFlash screenFlash) {
        this.mScreenFlash = screenFlash;
    }

    public void setTemplate(int i2) {
        this.mTemplate = i2;
        this.mFocusMeteringControl.setTemplate(i2);
        this.mCamera2CapturePipeline.setTemplate(this.mTemplate);
    }

    @Override // androidx.camera.core.CameraControl
    public j2.q setTorchStrengthLevel(@IntRange(from = 1) int i2) {
        return !isControlInUse() ? Futures.immediateFailedFuture(new CameraControl.OperationCanceledException("Camera is not active.")) : !this.mCameraCharacteristics.isTorchStrengthLevelSupported() ? Futures.immediateFailedFuture(new UnsupportedOperationException("The device doesn't support configuring torch strength level.")) : (i2 < 1 || i2 > this.mCameraCharacteristics.getMaxTorchStrengthLevel()) ? Futures.immediateFailedFuture(new IllegalArgumentException("The specified torch strength is not within the valid range.")) : Futures.nonCancellationPropagating(this.mTorchControl.setTorchStrengthLevel(Math.min(i2, this.mCameraCharacteristics.getMaxTorchStrengthLevel())));
    }

    public void setTorchStrengthLevelInternal(@IntRange(from = 1) int i2) {
        this.mTorchStrength = i2;
        if (isTorchOn()) {
            updateSessionConfigSynchronous();
        }
    }

    @Override // androidx.camera.core.CameraControl
    public j2.q setZoomRatio(float f4) {
        return !isControlInUse() ? Futures.immediateFailedFuture(new CameraControl.OperationCanceledException("Camera is not active.")) : Futures.nonCancellationPropagating(this.mZoomControl.setZoomRatio(f4));
    }

    @Override // androidx.camera.core.impl.CameraControlInternal
    public void setZslDisabledByUserCaseConfig(boolean z2) {
        this.mZslControl.setZslDisabledByUserCaseConfig(z2);
    }

    @Override // androidx.camera.core.CameraControl
    public j2.q startFocusAndMetering(FocusMeteringAction focusMeteringAction) {
        return !isControlInUse() ? Futures.immediateFailedFuture(new CameraControl.OperationCanceledException("Camera is not active.")) : !isRepeatingRequestAvailable() ? Futures.immediateFailedFuture(new CameraControl.OperationCanceledException("Repeating request is not available possibly because it's disable for the ImageCapture.")) : Futures.nonCancellationPropagating(this.mFocusMeteringControl.startFocusAndMetering(focusMeteringAction));
    }

    public void submitCaptureRequestsInternal(List<CaptureConfig> list) {
        this.mControlUpdateCallback.onCameraControlCaptureRequests(list);
    }

    @Override // androidx.camera.core.impl.CameraControlInternal
    public j2.q submitStillCaptureRequests(final List<CaptureConfig> list, final int i2, final int i8) {
        if (isControlInUse()) {
            final int flashMode = getFlashMode();
            return FutureChain.from(Futures.nonCancellationPropagating(this.mFlashModeChangeSessionUpdateFuture)).transformAsync(new AsyncFunction() { // from class: androidx.camera.camera2.internal.e
                @Override // androidx.camera.core.impl.utils.futures.AsyncFunction
                public final j2.q apply(Object obj) {
                    return this.f3424a.lambda$submitStillCaptureRequests$4(list, i2, flashMode, i8, (Void) obj);
                }
            }, this.mExecutor);
        }
        Logger.w(TAG, "Camera is not active.");
        return Futures.immediateFailedFuture(new CameraControl.OperationCanceledException("Camera is not active."));
    }

    public void updateSessionConfig() {
        this.mExecutor.execute(new u(this, 8));
    }

    public j2.q updateSessionConfigAsync() {
        return Futures.nonCancellationPropagating(CallbackToFutureAdapter.getFuture(new b(this, 0)));
    }

    public long updateSessionConfigSynchronous() {
        this.mCurrentSessionUpdateId = this.mNextSessionUpdateId.getAndIncrement();
        this.mControlUpdateCallback.onCameraControlUpdateSessionConfig();
        return this.mCurrentSessionUpdateId;
    }

    public Camera2CameraControlImpl(CameraCharacteristicsCompat cameraCharacteristicsCompat, ScheduledExecutorService scheduledExecutorService, Executor executor, CameraControlInternal.ControlUpdateCallback controlUpdateCallback, Quirks quirks) {
        this.mLock = new Object();
        SessionConfig.Builder builder = new SessionConfig.Builder();
        this.mSessionConfigBuilder = builder;
        this.mUseCount = 0;
        this.mTorchState = 0;
        this.mIsLowLightBoostOn = false;
        this.mFlashMode = 2;
        this.mIsRepeatingRequestAvailable = true;
        this.mNextSessionUpdateId = new AtomicLong(0L);
        this.mFlashModeChangeSessionUpdateFuture = Futures.immediateFuture(null);
        this.mTemplate = 1;
        this.mCurrentSessionUpdateId = 0L;
        CameraCaptureCallbackSet cameraCaptureCallbackSet = new CameraCaptureCallbackSet();
        this.mCameraCaptureCallbackSet = cameraCaptureCallbackSet;
        this.mCameraCharacteristics = cameraCharacteristicsCompat;
        this.mControlUpdateCallback = controlUpdateCallback;
        this.mExecutor = executor;
        this.mVideoUsageControl = new VideoUsageControl(executor);
        CameraControlSessionCallback cameraControlSessionCallback = new CameraControlSessionCallback(executor);
        this.mSessionCallback = cameraControlSessionCallback;
        builder.setTemplateType(this.mTemplate);
        builder.addRepeatingCameraCaptureCallback(CaptureCallbackContainer.create(cameraControlSessionCallback));
        builder.addRepeatingCameraCaptureCallback(cameraCaptureCallbackSet);
        this.mExposureControl = new ExposureControl(this, cameraCharacteristicsCompat, executor);
        this.mFocusMeteringControl = new FocusMeteringControl(this, scheduledExecutorService, executor, quirks);
        this.mZoomControl = new ZoomControl(this, cameraCharacteristicsCompat, executor);
        this.mTorchControl = new TorchControl(this, cameraCharacteristicsCompat, executor);
        this.mTorchStrength = cameraCharacteristicsCompat.getDefaultTorchStrengthLevel();
        this.mLowLightBoostControl = new LowLightBoostControl(this, cameraCharacteristicsCompat, executor);
        this.mZslControl = new ZslControlImpl(cameraCharacteristicsCompat, executor);
        this.mAutoFlashAEModeDisabler = new AutoFlashAEModeDisabler(quirks);
        this.mCamera2CameraControl = new Camera2CameraControl(this, executor);
        this.mCamera2CapturePipeline = new Camera2CapturePipeline(this, cameraCharacteristicsCompat, quirks, executor, scheduledExecutorService);
    }

    public static int getSupportedAeMode(CameraCharacteristicsCompat cameraCharacteristicsCompat, int i2) {
        int[] iArr = (int[]) cameraCharacteristicsCompat.get(CameraCharacteristics.CONTROL_AE_AVAILABLE_MODES);
        if (iArr == null) {
            return 0;
        }
        return isModeInList(i2, iArr) ? i2 : isModeInList(1, iArr) ? 1 : 0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void lambda$addInteropConfig$0() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void lambda$clearInteropConfig$1() {
    }
}
