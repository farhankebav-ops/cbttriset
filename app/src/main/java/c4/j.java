package c4;

import com.google.android.gms.ads.LoadAdError;
import com.google.android.gms.ads.rewarded.RewardedAd;
import com.google.android.gms.ads.rewarded.RewardedAdLoadCallback;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes5.dex */
public final class j extends RewardedAdLoadCallback {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f4197a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ Object f4198b;

    public /* synthetic */ j(Object obj, int i2) {
        this.f4197a = i2;
        this.f4198b = obj;
    }

    @Override // com.google.android.gms.ads.AdLoadCallback
    public final void onAdFailedToLoad(LoadAdError loadAdError) {
        switch (this.f4197a) {
            case 0:
                super.onAdFailedToLoad(loadAdError);
                ((k) this.f4198b).f4200c.onAdFailedToLoad(loadAdError.getCode(), loadAdError.toString());
                break;
            default:
                super.onAdFailedToLoad(loadAdError);
                ((y3.e) this.f4198b).f17844c.onAdFailedToLoad(loadAdError.getCode(), loadAdError.toString());
                break;
        }
    }

    @Override // com.google.android.gms.ads.AdLoadCallback
    public final void onAdLoaded(RewardedAd rewardedAd) {
        switch (this.f4197a) {
            case 0:
                RewardedAd rewardedAd2 = rewardedAd;
                super.onAdLoaded(rewardedAd2);
                k kVar = (k) this.f4198b;
                kVar.f4200c.onAdLoaded();
                rewardedAd2.setFullScreenContentCallback(kVar.f4202f);
                kVar.f4199b.f4179b = rewardedAd2;
                u3.b bVar = kVar.f4183a;
                if (bVar != null) {
                    bVar.onAdLoaded();
                }
                break;
            default:
                RewardedAd rewardedAd3 = rewardedAd;
                super.onAdLoaded(rewardedAd3);
                y3.e eVar = (y3.e) this.f4198b;
                eVar.f17844c.onAdLoaded();
                rewardedAd3.setFullScreenContentCallback(eVar.f17846f);
                eVar.f17843b.f4179b = rewardedAd3;
                u3.b bVar2 = eVar.f4183a;
                if (bVar2 != null) {
                    bVar2.onAdLoaded();
                }
                break;
        }
    }
}
