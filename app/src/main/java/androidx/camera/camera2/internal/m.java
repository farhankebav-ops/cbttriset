package androidx.camera.camera2.internal;

import androidx.camera.camera2.internal.Camera2CapturePipeline;
import androidx.camera.core.impl.CaptureConfig;
import androidx.concurrent.futures.CallbackToFutureAdapter;
import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class m implements CallbackToFutureAdapter.Resolver {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f3481a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ Object f3482b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ Object f3483c;

    public /* synthetic */ m(int i2, Object obj, Object obj2) {
        this.f3481a = i2;
        this.f3482b = obj;
        this.f3483c = obj2;
    }

    @Override // androidx.concurrent.futures.CallbackToFutureAdapter.Resolver
    public final Object attachCompleter(CallbackToFutureAdapter.Completer completer) {
        switch (this.f3481a) {
            case 0:
                return ((Camera2CameraImpl) this.f3482b).lambda$isUseCaseAttached$12((String) this.f3483c, completer);
            case 1:
                return ((Camera2CapturePipeline.Pipeline) this.f3482b).lambda$submitConfigsInternal$4((CaptureConfig.Builder) this.f3483c, completer);
            default:
                return ((Camera2CapturePipeline.ScreenFlashTask) this.f3482b).lambda$preCapture$3((AtomicReference) this.f3483c, completer);
        }
    }
}
