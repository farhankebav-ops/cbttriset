package com.ironsource;

import androidx.lifecycle.Lifecycle;
import com.ironsource.AbstractC2581u3;
import com.ironsource.C2579u1;
import com.ironsource.G7;
import com.ironsource.mediationsdk.logger.IronSourceError;
import com.unity3d.ironsourceads.InitListener;
import com.unity3d.ironsourceads.banner.BannerAdView;
import com.unity3d.ironsourceads.interstitial.InterstitialAd;
import com.unity3d.ironsourceads.rewarded.RewardedAd;
import com.unity3d.mediation.LevelPlayAdError;
import com.unity3d.mediation.LevelPlayAdInfo;
import com.unity3d.mediation.LevelPlayInitListener;
import com.unity3d.mediation.banner.LevelPlayBannerAdViewListener;
import com.unity3d.mediation.rewarded.LevelPlayReward;
import java.util.Map;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes5.dex */
public final /* synthetic */ class ti implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f10314a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ Object f10315b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ Object f10316c;

    public /* synthetic */ ti(int i2, Object obj, Object obj2) {
        this.f10314a = i2;
        this.f10315b = obj;
        this.f10316c = obj2;
    }

    @Override // java.lang.Runnable
    public final void run() {
        switch (this.f10314a) {
            case 0:
                C2579u1.a.a((Lifecycle.Event) this.f10315b, (C2579u1.a) this.f10316c);
                break;
            case 1:
                ((AbstractC2581u3.c) this.f10315b).b((G7.a) this.f10316c);
                break;
            case 2:
                Ae.a((InterfaceC2541re) this.f10315b, (IronSourceError) this.f10316c);
                break;
            case 3:
                Da.a((LevelPlayAdError) this.f10315b, (Da) this.f10316c);
                break;
            case 4:
                Da.a((Da) this.f10315b, (LevelPlayBannerAdViewListener) this.f10316c);
                break;
            case 5:
                Nd.a((Nd) this.f10315b, (IronSourceError) this.f10316c);
                break;
            case 6:
                P9.a((C2473ne) this.f10315b, (InitListener) this.f10316c);
                break;
            case 7:
                Pd.a((Pd) this.f10315b, (M9) this.f10316c);
                break;
            case 8:
                Pd.a((Pd) this.f10315b, (IronSourceError) this.f10316c);
                break;
            case 9:
                Qf.a((Qf) this.f10315b, (String) this.f10316c);
                break;
            case 10:
                Rd.a((Rd) this.f10315b, (IronSourceError) this.f10316c);
                break;
            case 11:
                Rd.a((RewardedAd) this.f10315b, (Rd) this.f10316c);
                break;
            case 12:
                Uf.a((Uf) this.f10315b, (AbstractC2345gd[]) this.f10316c);
                break;
            case 13:
                C2271cb.a((C2271cb) this.f10315b, (LevelPlayReward) this.f10316c);
                break;
            case 14:
                C2281d3.a((C2281d3) this.f10315b, (IronSourceError) this.f10316c);
                break;
            case 15:
                C2317f3.a((BannerAdView) this.f10315b, (C2317f3) this.f10316c);
                break;
            case 16:
                C2317f3.a((IronSourceError) this.f10315b, (C2317f3) this.f10316c);
                break;
            case 17:
                C2427l6.a((C2427l6) this.f10315b, (Map) this.f10316c);
                break;
            case 18:
                C2450mb.a((C2450mb) this.f10315b, (LevelPlayAdError) this.f10316c);
                break;
            case 19:
                C2450mb.a((C2450mb) this.f10315b, (String) this.f10316c);
                break;
            case 20:
                C2450mb.a((C2450mb) this.f10315b, (InterfaceC2488ob) this.f10316c);
                break;
            case 21:
                C2483o6.a((C2483o6) this.f10315b, (LevelPlayAdInfo) this.f10316c);
                break;
            case 22:
                C2517q6.a((C2517q6) this.f10315b, (LevelPlayAdInfo) this.f10316c);
                break;
            case 23:
                C2587u9.a((C2587u9) this.f10315b, (IronSourceError) this.f10316c);
                break;
            case 24:
                C2606vb.a((C2473ne) this.f10315b, (LevelPlayInitListener) this.f10316c);
                break;
            case 25:
                C2606vb.a((LevelPlayInitListener) this.f10315b, (C2235ab) this.f10316c);
                break;
            case 26:
                C2621w9.a((C2621w9) this.f10315b, (M9) this.f10316c);
                break;
            case 27:
                C2621w9.a((C2621w9) this.f10315b, (IronSourceError) this.f10316c);
                break;
            case 28:
                C2648y2.a((C2648y2) this.f10315b, (pg) this.f10316c);
                break;
            default:
                C2655y9.a((InterstitialAd) this.f10315b, (C2655y9) this.f10316c);
                break;
        }
    }
}
