package androidx.camera.video.internal.audio;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class a implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f3806a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ AudioSource f3807b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ boolean f3808c;

    public /* synthetic */ a(AudioSource audioSource, boolean z2, int i2) {
        this.f3806a = i2;
        this.f3807b = audioSource;
        this.f3808c = z2;
    }

    @Override // java.lang.Runnable
    public final void run() {
        switch (this.f3806a) {
            case 0:
                this.f3807b.lambda$mute$7(this.f3808c);
                break;
            default:
                this.f3807b.lambda$start$2(this.f3808c);
                break;
        }
    }
}
