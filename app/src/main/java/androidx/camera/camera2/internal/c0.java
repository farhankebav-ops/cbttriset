package androidx.camera.camera2.internal;

import androidx.camera.camera2.internal.Camera2CapturePipeline;
import androidx.camera.core.impl.utils.futures.AsyncFunction;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class c0 implements AsyncFunction {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f3374a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ Object f3375b;

    public /* synthetic */ c0(Object obj, int i2) {
        this.f3374a = i2;
        this.f3375b = obj;
    }

    @Override // androidx.camera.core.impl.utils.futures.AsyncFunction
    public final j2.q apply(Object obj) {
        switch (this.f3374a) {
            case 0:
                return ((Camera2CapturePipeline.TorchTask) this.f3375b).lambda$preCapture$1((Void) obj);
            case 1:
                return ((Camera2CapturePipeline.TorchTask) this.f3375b).lambda$preCapture$3((Void) obj);
            default:
                return ((Camera2CapturePipeline.Pipeline) this.f3375b).lambda$executePreCapture$3((Boolean) obj);
        }
    }
}
