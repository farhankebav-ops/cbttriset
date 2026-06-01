package a3;

import com.ironsource.mediationsdk.ads.nativead.LevelPlayNativeAd;
import com.ironsource.mediationsdk.adunit.adapter.utility.AdInfo;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes5.dex */
public final /* synthetic */ class a implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f3203a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ LevelPlayNativeAd f3204b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ AdInfo f3205c;

    public /* synthetic */ a(LevelPlayNativeAd levelPlayNativeAd, AdInfo adInfo, int i2) {
        this.f3203a = i2;
        this.f3204b = levelPlayNativeAd;
        this.f3205c = adInfo;
    }

    @Override // java.lang.Runnable
    public final void run() {
        switch (this.f3203a) {
            case 0:
                LevelPlayNativeAd.a(this.f3204b, this.f3205c);
                break;
            default:
                LevelPlayNativeAd.b(this.f3204b, this.f3205c);
                break;
        }
    }
}
