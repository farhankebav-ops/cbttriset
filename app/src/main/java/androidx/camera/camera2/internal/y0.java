package androidx.camera.camera2.internal;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class y0 implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f3543a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ SynchronizedCaptureSessionBaseImpl f3544b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ SynchronizedCaptureSession f3545c;

    public /* synthetic */ y0(SynchronizedCaptureSessionBaseImpl synchronizedCaptureSessionBaseImpl, SynchronizedCaptureSession synchronizedCaptureSession, int i2) {
        this.f3543a = i2;
        this.f3544b = synchronizedCaptureSessionBaseImpl;
        this.f3545c = synchronizedCaptureSession;
    }

    @Override // java.lang.Runnable
    public final void run() {
        switch (this.f3543a) {
            case 0:
                this.f3544b.lambda$onSessionFinished$4(this.f3545c);
                break;
            default:
                this.f3544b.lambda$onClosed$3(this.f3545c);
                break;
        }
    }
}
