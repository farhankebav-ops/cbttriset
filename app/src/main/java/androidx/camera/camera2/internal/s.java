package androidx.camera.camera2.internal;

import androidx.camera.camera2.internal.Camera2CapturePipeline;
import androidx.camera.core.impl.CameraCaptureCallback;
import androidx.concurrent.futures.CallbackToFutureAdapter;
import java.util.concurrent.Executor;
import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class s implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f3515a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ Object f3516b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ Object f3517c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final /* synthetic */ Object f3518d;

    public /* synthetic */ s(Camera2CapturePipeline.ScreenFlashTask screenFlashTask, AtomicReference atomicReference, CallbackToFutureAdapter.Completer completer) {
        this.f3515a = 1;
        this.f3517c = screenFlashTask;
        this.f3518d = atomicReference;
        this.f3516b = completer;
    }

    @Override // java.lang.Runnable
    public final void run() {
        switch (this.f3515a) {
            case 0:
                ((Camera2CameraImpl) this.f3517c).lambda$isUseCaseAttached$11((CallbackToFutureAdapter.Completer) this.f3516b, (String) this.f3518d);
                break;
            case 1:
                ((Camera2CapturePipeline.ScreenFlashTask) this.f3517c).lambda$preCapture$2((AtomicReference) this.f3518d, (CallbackToFutureAdapter.Completer) this.f3516b);
                break;
            default:
                ((Camera2CameraControlImpl) this.f3517c).lambda$addSessionCameraCaptureCallback$8((Executor) this.f3516b, (CameraCaptureCallback) this.f3518d);
                break;
        }
    }

    public /* synthetic */ s(Object obj, Object obj2, Object obj3, int i2) {
        this.f3515a = i2;
        this.f3517c = obj;
        this.f3516b = obj2;
        this.f3518d = obj3;
    }
}
