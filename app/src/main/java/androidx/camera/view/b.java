package androidx.camera.view;

import androidx.arch.core.util.Function;
import androidx.camera.view.RotationProvider;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class b implements Function, RotationProvider.Listener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f3889a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ CameraController f3890b;

    public /* synthetic */ b(CameraController cameraController, int i2) {
        this.f3889a = i2;
        this.f3890b = cameraController;
    }

    @Override // androidx.arch.core.util.Function, m0.f, x4.c
    public Object apply(Object obj) {
        switch (this.f3889a) {
            case 0:
                return this.f3890b.lambda$new$0((ProcessCameraProviderWrapper) obj);
            case 1:
                return this.f3890b.enableTorch(((Boolean) obj).booleanValue());
            case 2:
                return this.f3890b.setLinearZoom(((Float) obj).floatValue());
            default:
                return this.f3890b.setZoomRatio(((Float) obj).floatValue());
        }
    }

    @Override // androidx.camera.view.RotationProvider.Listener
    public void onRotationChanged(int i2) {
        this.f3890b.lambda$new$1(i2);
    }
}
