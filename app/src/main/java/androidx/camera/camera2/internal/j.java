package androidx.camera.camera2.internal;

import android.graphics.SurfaceTexture;
import android.hardware.camera2.TotalCaptureResult;
import android.view.Surface;
import androidx.camera.camera2.internal.Camera2CameraControlImpl;
import androidx.camera.camera2.internal.Camera2CapturePipeline;
import androidx.camera.camera2.internal.ZslControlImpl;
import androidx.camera.core.SafeCloseImageReaderProxy;
import androidx.camera.core.impl.CameraCaptureCallback;
import androidx.camera.core.impl.DeferrableSurface;
import androidx.camera.core.impl.SessionConfig;
import androidx.concurrent.futures.CallbackToFutureAdapter;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class j implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f3462a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ Object f3463b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ Object f3464c;

    public /* synthetic */ j(int i2, Object obj, Object obj2) {
        this.f3462a = i2;
        this.f3463b = obj;
        this.f3464c = obj2;
    }

    @Override // java.lang.Runnable
    public final void run() {
        switch (this.f3462a) {
            case 0:
                ((Camera2CameraControlImpl.CameraControlSessionCallback) this.f3463b).lambda$onCaptureCompleted$0((TotalCaptureResult) this.f3464c);
                break;
            case 1:
                ((Camera2CameraImpl) this.f3463b).lambda$onUseCaseInactive$8((String) this.f3464c);
                break;
            case 2:
                Camera2CameraImpl.lambda$postSurfaceClosedError$20((SessionConfig.ErrorListener) this.f3463b, (SessionConfig) this.f3464c);
                break;
            case 3:
                Camera2CameraImpl.lambda$configAndClose$2((Surface) this.f3463b, (SurfaceTexture) this.f3464c);
                break;
            case 4:
                ((Camera2CameraControlImpl) this.f3463b).removeCaptureResultListener((Camera2CapturePipeline.ResultListener) this.f3464c);
                break;
            case 5:
                ((ProcessingCaptureSession) this.f3463b).lambda$open$0((DeferrableSurface) this.f3464c);
                break;
            case 6:
                ZslControlImpl.lambda$addZslConfig$1((SafeCloseImageReaderProxy) this.f3463b, (ZslControlImpl.ImageWriterHolder) this.f3464c);
                break;
            case 7:
                ((Camera2CameraControlImpl) this.f3463b).lambda$removeSessionCameraCaptureCallback$9((CameraCaptureCallback) this.f3464c);
                break;
            default:
                Camera2PresenceSource.fetchData$lambda$3$lambda$2((Camera2PresenceSource) this.f3463b, (CallbackToFutureAdapter.Completer) this.f3464c);
                break;
        }
    }
}
