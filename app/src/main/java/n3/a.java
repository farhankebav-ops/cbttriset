package n3;

import com.ironsource.Cb;
import com.unity3d.ironsourceads.banner.BannerAdLoader;
import com.unity3d.ironsourceads.interstitial.InterstitialAdLoader;
import com.unity3d.ironsourceads.rewarded.RewardedAdLoader;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes5.dex */
public final /* synthetic */ class a implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f13061a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ Cb f13062b;

    public /* synthetic */ a(Cb cb, int i2) {
        this.f13061a = i2;
        this.f13062b = cb;
    }

    @Override // java.lang.Runnable
    public final void run() {
        switch (this.f13061a) {
            case 0:
                BannerAdLoader.a(this.f13062b);
                break;
            case 1:
                InterstitialAdLoader.a(this.f13062b);
                break;
            default:
                RewardedAdLoader.a(this.f13062b);
                break;
        }
    }
}
