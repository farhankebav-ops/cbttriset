package androidx.camera.camera2.internal;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class d1 implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f3422a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ VideoUsageControl f3423b;

    public /* synthetic */ d1(VideoUsageControl videoUsageControl, int i2) {
        this.f3422a = i2;
        this.f3423b = videoUsageControl;
    }

    @Override // java.lang.Runnable
    public final void run() {
        switch (this.f3422a) {
            case 0:
                VideoUsageControl.decrementUsage$lambda$1(this.f3423b);
                break;
            case 1:
                this.f3423b.resetDirectly();
                break;
            default:
                VideoUsageControl.incrementUsage$lambda$0(this.f3423b);
                break;
        }
    }
}
