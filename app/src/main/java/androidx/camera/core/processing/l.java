package androidx.camera.core.processing;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class l implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f3720a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ SurfaceEdge f3721b;

    public /* synthetic */ l(SurfaceEdge surfaceEdge, int i2) {
        this.f3720a = i2;
        this.f3721b = surfaceEdge;
    }

    @Override // java.lang.Runnable
    public final void run() {
        switch (this.f3720a) {
            case 0:
                this.f3721b.lambda$createSurfaceRequest$1();
                break;
            default:
                this.f3721b.lambda$createSurfaceRequest$0();
                break;
        }
    }
}
