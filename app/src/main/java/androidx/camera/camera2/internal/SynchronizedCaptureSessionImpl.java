package androidx.camera.camera2.internal;

import android.hardware.camera2.CameraAccessException;
import android.hardware.camera2.CameraCaptureSession;
import android.hardware.camera2.CameraDevice;
import android.hardware.camera2.CaptureRequest;
import android.os.Handler;
import androidx.annotation.GuardedBy;
import androidx.camera.camera2.internal.compat.params.SessionConfigurationCompat;
import androidx.camera.camera2.internal.compat.quirk.CaptureSessionStuckQuirk;
import androidx.camera.camera2.internal.compat.quirk.IncorrectCaptureStateQuirk;
import androidx.camera.camera2.internal.compat.workaround.ForceCloseCaptureSession;
import androidx.camera.camera2.internal.compat.workaround.ForceCloseDeferrableSurface;
import androidx.camera.camera2.internal.compat.workaround.RequestMonitor;
import androidx.camera.camera2.internal.compat.workaround.SessionResetPolicy;
import androidx.camera.core.Logger;
import androidx.camera.core.impl.DeferrableSurface;
import androidx.camera.core.impl.Quirks;
import androidx.camera.core.impl.utils.futures.FutureChain;
import androidx.camera.core.impl.utils.futures.Futures;
import com.ironsource.C2300e4;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.Executor;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.atomic.AtomicBoolean;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes.dex */
class SynchronizedCaptureSessionImpl extends SynchronizedCaptureSessionBaseImpl {
    private static final String TAG = "SyncCaptureSessionImpl";
    private final ForceCloseDeferrableSurface mCloseSurfaceQuirk;
    private final AtomicBoolean mClosed;

    @GuardedBy("mObjectLock")
    private List<DeferrableSurface> mDeferrableSurfaces;
    private final ForceCloseCaptureSession mForceCloseSessionQuirk;
    private final Object mObjectLock;

    @GuardedBy("mObjectLock")
    j2.q mOpenSessionBlockerFuture;
    private final RequestMonitor mRequestMonitor;
    private final ScheduledExecutorService mScheduledExecutorService;
    private final SessionResetPolicy mSessionResetPolicy;

    public SynchronizedCaptureSessionImpl(Quirks quirks, Quirks quirks2, CaptureSessionRepository captureSessionRepository, Executor executor, ScheduledExecutorService scheduledExecutorService, Handler handler) {
        super(captureSessionRepository, executor, scheduledExecutorService, handler);
        this.mObjectLock = new Object();
        this.mClosed = new AtomicBoolean(false);
        this.mCloseSurfaceQuirk = new ForceCloseDeferrableSurface(quirks, quirks2);
        this.mRequestMonitor = new RequestMonitor(quirks.contains(CaptureSessionStuckQuirk.class) || quirks.contains(IncorrectCaptureStateQuirk.class));
        this.mForceCloseSessionQuirk = new ForceCloseCaptureSession(quirks2);
        this.mSessionResetPolicy = new SessionResetPolicy(quirks2);
        this.mScheduledExecutorService = scheduledExecutorService;
    }

    private void closeCreatedSession() {
        Iterator<SynchronizedCaptureSession> it = this.mCaptureSessionRepository.getCaptureSessions().iterator();
        while (it.hasNext()) {
            it.next().close();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$close$2() {
        debugLog("Session call super.close()");
        super.close();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$onConfigured$1(SynchronizedCaptureSession synchronizedCaptureSession) {
        super.onConfigured(synchronizedCaptureSession);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ j2.q lambda$openCaptureSession$0(CameraDevice cameraDevice, SessionConfigurationCompat sessionConfigurationCompat, List list, List list2) throws Exception {
        if (this.mSessionResetPolicy.needAbortCapture()) {
            closeCreatedSession();
        }
        debugLog("start openCaptureSession");
        return super.openCaptureSession(cameraDevice, sessionConfigurationCompat, list);
    }

    @Override // androidx.camera.camera2.internal.SynchronizedCaptureSessionBaseImpl, androidx.camera.camera2.internal.SynchronizedCaptureSession
    public int captureBurstRequests(List<CaptureRequest> list, CameraCaptureSession.CaptureCallback captureCallback) throws CameraAccessException {
        return super.captureBurstRequests(list, this.mRequestMonitor.createMonitorListener(captureCallback));
    }

    @Override // androidx.camera.camera2.internal.SynchronizedCaptureSessionBaseImpl, androidx.camera.camera2.internal.SynchronizedCaptureSession
    public void close() {
        if (!this.mClosed.compareAndSet(false, true)) {
            debugLog("close() has been called. Skip this invocation.");
            return;
        }
        if (this.mSessionResetPolicy.needAbortCapture()) {
            try {
                debugLog("Call abortCaptures() before closing session.");
                abortCaptures();
            } catch (Exception e) {
                debugLog("Exception when calling abortCaptures()" + e);
            }
        }
        debugLog("Session call close()");
        this.mRequestMonitor.getRequestsProcessedFuture().addListener(new u(this, 7), getExecutor());
    }

    public void debugLog(String str) {
        Logger.d(TAG, C2300e4.i.f8403d + this + "] " + str);
    }

    @Override // androidx.camera.camera2.internal.SynchronizedCaptureSessionBaseImpl, androidx.camera.camera2.internal.SynchronizedCaptureSession
    public void finishClose() {
        super.finishClose();
        this.mRequestMonitor.stop();
    }

    @Override // androidx.camera.camera2.internal.SynchronizedCaptureSessionBaseImpl, androidx.camera.camera2.internal.SynchronizedCaptureSession
    public j2.q getOpeningBlocker() {
        return Futures.makeTimeoutFuture(1500L, this.mScheduledExecutorService, this.mRequestMonitor.getRequestsProcessedFuture());
    }

    @Override // androidx.camera.camera2.internal.SynchronizedCaptureSessionBaseImpl, androidx.camera.camera2.internal.SynchronizedCaptureSession
    public void onCameraDeviceError(int i2) {
        super.onCameraDeviceError(i2);
        if (i2 == 5) {
            synchronized (this.mObjectLock) {
                try {
                    if (isCameraCaptureSessionOpen() && this.mDeferrableSurfaces != null) {
                        debugLog("Close DeferrableSurfaces for CameraDevice error.");
                        Iterator<DeferrableSurface> it = this.mDeferrableSurfaces.iterator();
                        while (it.hasNext()) {
                            it.next().close();
                        }
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
        }
    }

    @Override // androidx.camera.camera2.internal.SynchronizedCaptureSessionBaseImpl, androidx.camera.camera2.internal.SynchronizedCaptureSession.StateCallback
    public void onClosed(SynchronizedCaptureSession synchronizedCaptureSession) {
        synchronized (this.mObjectLock) {
            this.mCloseSurfaceQuirk.onSessionEnd(this.mDeferrableSurfaces);
        }
        debugLog("onClosed()");
        super.onClosed(synchronizedCaptureSession);
    }

    @Override // androidx.camera.camera2.internal.SynchronizedCaptureSessionBaseImpl, androidx.camera.camera2.internal.SynchronizedCaptureSession.StateCallback
    public void onConfigured(SynchronizedCaptureSession synchronizedCaptureSession) {
        debugLog("Session onConfigured()");
        this.mForceCloseSessionQuirk.onSessionConfigured(synchronizedCaptureSession, this.mCaptureSessionRepository.getCreatingCaptureSessions(), this.mCaptureSessionRepository.getCaptureSessions(), new v(this, 7));
    }

    @Override // androidx.camera.camera2.internal.SynchronizedCaptureSessionBaseImpl, androidx.camera.camera2.internal.SynchronizedCaptureSession.Opener
    public j2.q openCaptureSession(CameraDevice cameraDevice, SessionConfigurationCompat sessionConfigurationCompat, List<DeferrableSurface> list) {
        j2.q qVarNonCancellationPropagating;
        synchronized (this.mObjectLock) {
            try {
                List<SynchronizedCaptureSession> captureSessions = this.mCaptureSessionRepository.getCaptureSessions();
                ArrayList arrayList = new ArrayList();
                Iterator<SynchronizedCaptureSession> it = captureSessions.iterator();
                while (it.hasNext()) {
                    arrayList.add(it.next().getOpeningBlocker());
                }
                j2.q qVarSuccessfulAsList = Futures.successfulAsList(arrayList);
                this.mOpenSessionBlockerFuture = qVarSuccessfulAsList;
                qVarNonCancellationPropagating = Futures.nonCancellationPropagating(FutureChain.from(qVarSuccessfulAsList).transformAsync(new v0(this, cameraDevice, sessionConfigurationCompat, list), getExecutor()));
            } catch (Throwable th) {
                throw th;
            }
        }
        return qVarNonCancellationPropagating;
    }

    @Override // androidx.camera.camera2.internal.SynchronizedCaptureSessionBaseImpl, androidx.camera.camera2.internal.SynchronizedCaptureSession
    public int setSingleRepeatingRequest(CaptureRequest captureRequest, CameraCaptureSession.CaptureCallback captureCallback) throws CameraAccessException {
        return super.setSingleRepeatingRequest(captureRequest, this.mRequestMonitor.createMonitorListener(captureCallback));
    }

    @Override // androidx.camera.camera2.internal.SynchronizedCaptureSessionBaseImpl, androidx.camera.camera2.internal.SynchronizedCaptureSession.Opener
    public j2.q startWithDeferrableSurface(List<DeferrableSurface> list, long j) {
        j2.q qVarStartWithDeferrableSurface;
        synchronized (this.mObjectLock) {
            this.mDeferrableSurfaces = list;
            qVarStartWithDeferrableSurface = super.startWithDeferrableSurface(list, j);
        }
        return qVarStartWithDeferrableSurface;
    }

    @Override // androidx.camera.camera2.internal.SynchronizedCaptureSessionBaseImpl, androidx.camera.camera2.internal.SynchronizedCaptureSession.Opener
    public boolean stop() {
        boolean zStop;
        synchronized (this.mObjectLock) {
            try {
                if (isCameraCaptureSessionOpen()) {
                    this.mCloseSurfaceQuirk.onSessionEnd(this.mDeferrableSurfaces);
                } else {
                    j2.q qVar = this.mOpenSessionBlockerFuture;
                    if (qVar != null) {
                        qVar.cancel(true);
                    }
                }
                zStop = super.stop();
            } catch (Throwable th) {
                throw th;
            }
        }
        return zStop;
    }
}
