package androidx.camera.video.internal.encoder;

import com.ironsource.C2271cb;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class c implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f3822a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ Object f3823b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ long f3824c;

    public /* synthetic */ c(Object obj, long j, int i2) {
        this.f3822a = i2;
        this.f3823b = obj;
        this.f3824c = j;
    }

    @Override // java.lang.Runnable
    public final void run() {
        switch (this.f3822a) {
            case 0:
                ((EncoderImpl) this.f3823b).lambda$start$1(this.f3824c);
                break;
            case 1:
                ((EncoderImpl) this.f3823b).lambda$pause$5(this.f3824c);
                break;
            default:
                C2271cb.a((C2271cb) this.f3823b, this.f3824c);
                break;
        }
    }
}
