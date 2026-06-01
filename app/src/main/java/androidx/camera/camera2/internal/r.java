package androidx.camera.camera2.internal;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class r implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f3511a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ Camera2CameraImpl f3512b;

    public /* synthetic */ r(Camera2CameraImpl camera2CameraImpl, int i2) {
        this.f3511a = i2;
        this.f3512b = camera2CameraImpl;
    }

    @Override // java.lang.Runnable
    public final void run() {
        switch (this.f3511a) {
            case 0:
                this.f3512b.lambda$onRemoved$16();
                break;
            case 1:
                this.f3512b.openInternal();
                break;
            case 2:
                this.f3512b.lambda$configAndCloseIfNeeded$0();
                break;
            default:
                this.f3512b.closeInternal();
                break;
        }
    }
}
