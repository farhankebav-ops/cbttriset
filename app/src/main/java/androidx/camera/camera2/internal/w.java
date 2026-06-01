package androidx.camera.camera2.internal;

import android.hardware.camera2.TotalCaptureResult;
import androidx.arch.core.util.Function;
import androidx.camera.camera2.internal.Camera2CapturePipeline;
import androidx.camera.core.ImageProxy;
import androidx.camera.core.internal.utils.RingBuffer;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class w implements Function, Camera2CapturePipeline.ResultListener.Checker, RingBuffer.OnRemoveCallback {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f3532a;

    public /* synthetic */ w(int i2) {
        this.f3532a = i2;
    }

    @Override // androidx.arch.core.util.Function, m0.f, x4.c
    public Object apply(Object obj) {
        switch (this.f3532a) {
            case 0:
                return Camera2CapturePipeline.AePreCaptureTask.lambda$preCapture$1((Void) obj);
            case 1:
                return Camera2CapturePipeline.CameraCapturePipelineImpl.lambda$invokePreCapture$0((TotalCaptureResult) obj);
            case 2:
            default:
                return Camera2CapturePipeline.TorchTask.lambda$preCapture$4((TotalCaptureResult) obj);
            case 3:
                return Camera2CapturePipeline.Pipeline.AnonymousClass1.lambda$preCapture$0((List) obj);
            case 4:
                return Camera2CapturePipeline.ScreenFlashTask.lambda$preCapture$11((TotalCaptureResult) obj);
        }
    }

    @Override // androidx.camera.camera2.internal.Camera2CapturePipeline.ResultListener.Checker
    public boolean check(TotalCaptureResult totalCaptureResult) {
        switch (this.f3532a) {
            case 2:
                return Camera2CapturePipeline.Pipeline.lambda$executePreCapture$2(totalCaptureResult);
            case 5:
                return Camera2CapturePipeline.ScreenFlashTask.lambda$preCapture$9(totalCaptureResult);
            default:
                return Camera2CapturePipeline.TorchTask.lambda$preCapture$2(totalCaptureResult);
        }
    }

    @Override // androidx.camera.core.internal.utils.RingBuffer.OnRemoveCallback
    public void onRemove(Object obj) {
        ((ImageProxy) obj).close();
    }
}
