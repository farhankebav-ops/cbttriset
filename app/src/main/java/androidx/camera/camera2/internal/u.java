package androidx.camera.camera2.internal;

import android.hardware.camera2.CameraDevice;
import androidx.camera.camera2.internal.Camera2CameraImpl;
import androidx.camera.camera2.internal.Camera2CapturePipeline;
import androidx.camera.core.ImageCapture;
import androidx.camera.core.impl.DeferrableSurface;
import java.util.LinkedHashSet;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class u implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f3524a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ Object f3525b;

    public /* synthetic */ u(Object obj, int i2) {
        this.f3524a = i2;
        this.f3525b = obj;
    }

    @Override // java.lang.Runnable
    public final void run() {
        switch (this.f3524a) {
            case 0:
                ((Camera2CameraImpl.StateCallback.ScheduledReopen) this.f3525b).lambda$run$0();
                break;
            case 1:
                ((Camera2CapturePipeline.Pipeline) this.f3525b).executePostCapture();
                break;
            case 2:
                ((CaptureSession) this.f3525b).lambda$issuePendingCaptureRequest$2();
                break;
            case 3:
                CaptureSessionRepository.forceOnClosed((LinkedHashSet) this.f3525b);
                break;
            case 4:
                ((ProcessingCaptureSession) this.f3525b).lambda$release$4();
                break;
            case 5:
                ProcessingCaptureSession.lambda$open$1((DeferrableSurface) this.f3525b);
                break;
            case 6:
                ((SynchronizedCaptureSessionBaseImpl) this.f3525b).lambda$close$2();
                break;
            case 7:
                ((SynchronizedCaptureSessionImpl) this.f3525b).lambda$close$2();
                break;
            case 8:
                ((Camera2CameraControlImpl) this.f3525b).updateSessionConfigSynchronous();
                break;
            case 9:
                ((CameraDevice) this.f3525b).close();
                break;
            default:
                ((ImageCapture.ScreenFlash) this.f3525b).clear();
                break;
        }
    }
}
