package androidx.camera.camera2.internal;

import android.hardware.camera2.CameraCharacteristics;
import androidx.arch.core.util.Function;
import androidx.camera.camera2.internal.Camera2CapturePipeline;
import androidx.camera.camera2.internal.compat.CameraCharacteristicsCompat;
import androidx.camera.camera2.internal.compat.workaround.CameraCharacteristicsProvider;
import androidx.camera.camera2.internal.compat.workaround.ForceCloseCaptureSession;
import androidx.concurrent.futures.CallbackToFutureAdapter;
import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class v implements CallbackToFutureAdapter.Resolver, Function, ForceCloseCaptureSession.OnConfigured, CameraCharacteristicsProvider {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f3526a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ Object f3527b;

    public /* synthetic */ v(Object obj, int i2) {
        this.f3526a = i2;
        this.f3527b = obj;
    }

    @Override // androidx.arch.core.util.Function, m0.f, x4.c
    public Object apply(Object obj) {
        return ((ProcessingCaptureSession) this.f3527b).lambda$open$3((Void) obj);
    }

    @Override // androidx.concurrent.futures.CallbackToFutureAdapter.Resolver
    public Object attachCompleter(CallbackToFutureAdapter.Completer completer) {
        switch (this.f3526a) {
            case 0:
                return ((Camera2CapturePipeline.AePreCaptureTask) this.f3527b).lambda$preCapture$0(completer);
            case 1:
                return ((Camera2CapturePipeline.CameraCapturePipelineImpl) this.f3527b).lambda$invokePostCapture$1(completer);
            case 2:
                return ((Camera2CapturePipeline.ResultListener) this.f3527b).lambda$new$0(completer);
            case 3:
                return ((Camera2CapturePipeline.ScreenFlashTask) this.f3527b).lambda$preCapture$5(completer);
            case 4:
                return Camera2CapturePipeline.ScreenFlashTask.lambda$preCapture$1((AtomicReference) this.f3527b, completer);
            case 5:
                return ((Camera2CapturePipeline.TorchTask) this.f3527b).lambda$preCapture$0(completer);
            default:
                return Camera2PresenceSource.fetchData$lambda$3((Camera2PresenceSource) this.f3527b, completer);
        }
    }

    @Override // androidx.camera.camera2.internal.compat.workaround.CameraCharacteristicsProvider
    public Object get(CameraCharacteristics.Key key) {
        return ((CameraCharacteristicsCompat) this.f3527b).get(key);
    }

    @Override // androidx.camera.camera2.internal.compat.workaround.ForceCloseCaptureSession.OnConfigured
    public void run(SynchronizedCaptureSession synchronizedCaptureSession) {
        ((SynchronizedCaptureSessionImpl) this.f3527b).lambda$onConfigured$1(synchronizedCaptureSession);
    }
}
