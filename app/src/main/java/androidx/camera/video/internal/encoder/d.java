package androidx.camera.video.internal.encoder;

import com.vungle.ads.internal.presenter.MRAIDPresenter;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class d implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f3825a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ long f3826b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ long f3827c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final /* synthetic */ Object f3828d;

    public /* synthetic */ d(Object obj, long j, long j3, int i2) {
        this.f3825a = i2;
        this.f3828d = obj;
        this.f3826b = j;
        this.f3827c = j3;
    }

    @Override // java.lang.Runnable
    public final void run() {
        switch (this.f3825a) {
            case 0:
                ((EncoderImpl) this.f3828d).lambda$stop$4(this.f3826b, this.f3827c);
                break;
            default:
                MRAIDPresenter.m3338processCommand$lambda11((MRAIDPresenter) this.f3828d, this.f3826b, this.f3827c);
                break;
        }
    }
}
