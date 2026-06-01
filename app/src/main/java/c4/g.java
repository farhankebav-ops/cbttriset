package c4;

import com.google.android.gms.ads.LoadAdError;
import com.google.android.gms.ads.interstitial.InterstitialAd;
import com.google.android.gms.ads.interstitial.InterstitialAdLoadCallback;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes5.dex */
public final class g extends InterstitialAdLoadCallback {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f4190a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ Object f4191b;

    public /* synthetic */ g(Object obj, int i2) {
        this.f4190a = i2;
        this.f4191b = obj;
    }

    @Override // com.google.android.gms.ads.AdLoadCallback
    public final void onAdFailedToLoad(LoadAdError loadAdError) {
        switch (this.f4190a) {
            case 0:
                super.onAdFailedToLoad(loadAdError);
                ((i) this.f4191b).f4195c.onAdFailedToLoad(loadAdError.getCode(), loadAdError.toString());
                break;
            default:
                super.onAdFailedToLoad(loadAdError);
                ((y3.d) this.f4191b).f17841c.onAdFailedToLoad(loadAdError.getCode(), loadAdError.toString());
                break;
        }
    }

    @Override // com.google.android.gms.ads.AdLoadCallback
    public final void onAdLoaded(InterstitialAd interstitialAd) {
        switch (this.f4190a) {
            case 0:
                InterstitialAd interstitialAd2 = interstitialAd;
                super.onAdLoaded(interstitialAd2);
                i iVar = (i) this.f4191b;
                iVar.f4195c.onAdLoaded();
                interstitialAd2.setFullScreenContentCallback(iVar.e);
                iVar.f4194b.f4179b = interstitialAd2;
                u3.b bVar = iVar.f4183a;
                if (bVar != null) {
                    bVar.onAdLoaded();
                }
                break;
            default:
                InterstitialAd interstitialAd3 = interstitialAd;
                super.onAdLoaded(interstitialAd3);
                y3.d dVar = (y3.d) this.f4191b;
                dVar.f17841c.onAdLoaded();
                interstitialAd3.setFullScreenContentCallback(dVar.e);
                dVar.f17840b.f4179b = interstitialAd3;
                u3.b bVar2 = dVar.f4183a;
                if (bVar2 != null) {
                    bVar2.onAdLoaded();
                }
                break;
        }
    }
}
