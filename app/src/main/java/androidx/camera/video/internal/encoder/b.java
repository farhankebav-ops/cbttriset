package androidx.camera.video.internal.encoder;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class b implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f3820a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ EncoderImpl f3821b;

    public /* synthetic */ b(EncoderImpl encoderImpl, int i2) {
        this.f3820a = i2;
        this.f3821b = encoderImpl;
    }

    @Override // java.lang.Runnable
    public final void run() {
        switch (this.f3820a) {
            case 0:
                this.f3821b.signalEndOfInputStream();
                break;
            case 1:
                this.f3821b.lambda$stop$3();
                break;
            case 2:
                this.f3821b.lambda$stop$2();
                break;
            case 3:
                this.f3821b.lambda$release$6();
                break;
            case 4:
                this.f3821b.lambda$requestKeyFrame$8();
                break;
            default:
                this.f3821b.lambda$signalSourceStopped$7();
                break;
        }
    }
}
