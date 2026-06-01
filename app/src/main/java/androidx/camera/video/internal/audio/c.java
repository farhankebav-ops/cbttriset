package androidx.camera.video.internal.audio;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class c implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f3809a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ AudioSource f3810b;

    public /* synthetic */ c(AudioSource audioSource, int i2) {
        this.f3809a = i2;
        this.f3810b = audioSource;
    }

    @Override // java.lang.Runnable
    public final void run() {
        switch (this.f3809a) {
            case 0:
                this.f3810b.lambda$stop$3();
                break;
            default:
                this.f3810b.lambda$start$1();
                break;
        }
    }
}
