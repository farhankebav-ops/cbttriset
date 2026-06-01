package androidx.camera.video.internal.audio;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class g implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f3814a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ BufferedAudioStream f3815b;

    public /* synthetic */ g(BufferedAudioStream bufferedAudioStream, int i2) {
        this.f3814a = i2;
        this.f3815b = bufferedAudioStream;
    }

    @Override // java.lang.Runnable
    public final void run() {
        switch (this.f3814a) {
            case 0:
                this.f3815b.lambda$stop$1();
                break;
            case 1:
                this.f3815b.lambda$start$0();
                break;
            case 2:
                this.f3815b.collectAudioData();
                break;
            default:
                this.f3815b.lambda$release$2();
                break;
        }
    }
}
