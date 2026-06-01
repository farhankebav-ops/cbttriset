package androidx.camera.core.processing;

import androidx.camera.core.processing.SurfaceEdge;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class m implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f3722a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ SurfaceEdge.SettableSurface f3723b;

    public /* synthetic */ m(SurfaceEdge.SettableSurface settableSurface, int i2) {
        this.f3722a = i2;
        this.f3723b = settableSurface;
    }

    @Override // java.lang.Runnable
    public final void run() {
        switch (this.f3722a) {
            case 0:
                this.f3723b.close();
                break;
            case 1:
                this.f3723b.decrementUseCount();
                break;
            default:
                this.f3723b.lambda$close$1();
                break;
        }
    }
}
