package androidx.camera.core.processing;

import androidx.camera.view.CameraController;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class o implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f3726a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ int f3727b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ int f3728c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final /* synthetic */ Object f3729d;

    public /* synthetic */ o(Object obj, int i2, int i8, int i9) {
        this.f3726a = i9;
        this.f3729d = obj;
        this.f3727b = i2;
        this.f3728c = i8;
    }

    @Override // java.lang.Runnable
    public final void run() {
        switch (this.f3726a) {
            case 0:
                ((SurfaceEdge) this.f3729d).lambda$updateTransformation$3(this.f3727b, this.f3728c);
                break;
            default:
                ((CameraController) this.f3729d).lambda$setEnabledUseCases$2(this.f3727b, this.f3728c);
                break;
        }
    }
}
