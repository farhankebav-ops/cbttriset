package androidx.camera.camera2.internal;

import androidx.camera.camera2.internal.Camera2CapturePipeline;
import androidx.camera.core.impl.ImmediateSurface;
import androidx.camera.core.impl.utils.futures.AsyncFunction;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class q implements AsyncFunction {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f3505a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ Object f3506b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ Object f3507c;

    public /* synthetic */ q(int i2, Object obj, Object obj2) {
        this.f3505a = i2;
        this.f3506b = obj;
        this.f3507c = obj2;
    }

    @Override // androidx.camera.core.impl.utils.futures.AsyncFunction
    public final j2.q apply(Object obj) {
        switch (this.f3505a) {
            case 0:
                return Camera2CameraImpl.lambda$configAndClose$3((CaptureSession) this.f3506b, (ImmediateSurface) this.f3507c, (Void) obj);
            case 1:
                return ((Camera2CapturePipeline.ScreenFlashTask) this.f3506b).lambda$preCapture$7((j2.q) this.f3507c, obj);
            default:
                return ((SynchronizedCaptureSessionBaseImpl) this.f3506b).lambda$startWithDeferrableSurface$1((List) this.f3507c, (List) obj);
        }
    }
}
