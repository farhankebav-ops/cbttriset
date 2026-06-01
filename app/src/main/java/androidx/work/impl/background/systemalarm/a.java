package androidx.work.impl.background.systemalarm;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes3.dex */
public final /* synthetic */ class a implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f4100a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ DelayMetCommandHandler f4101b;

    public /* synthetic */ a(DelayMetCommandHandler delayMetCommandHandler, int i2) {
        this.f4100a = i2;
        this.f4101b = delayMetCommandHandler;
    }

    @Override // java.lang.Runnable
    public final void run() {
        switch (this.f4100a) {
            case 0:
                this.f4101b.stopWork();
                break;
            default:
                this.f4101b.startWork();
                break;
        }
    }
}
