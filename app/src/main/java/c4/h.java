package c4;

import com.google.android.gms.ads.AdError;
import com.google.android.gms.ads.FullScreenContentCallback;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes5.dex */
public final class h extends FullScreenContentCallback {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f4192a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ Object f4193b;

    public /* synthetic */ h(Object obj, int i2) {
        this.f4192a = i2;
        this.f4193b = obj;
    }

    @Override // com.google.android.gms.ads.FullScreenContentCallback
    public final void onAdClicked() {
        switch (this.f4192a) {
            case 0:
                super.onAdClicked();
                ((i) this.f4193b).f4195c.onAdClicked();
                break;
            case 1:
                super.onAdClicked();
                ((k) this.f4193b).f4200c.onAdClicked();
                break;
            case 2:
                super.onAdClicked();
                ((y3.d) this.f4193b).f17841c.onAdClicked();
                break;
            default:
                super.onAdClicked();
                ((y3.e) this.f4193b).f17844c.onAdClicked();
                break;
        }
    }

    @Override // com.google.android.gms.ads.FullScreenContentCallback
    public final void onAdDismissedFullScreenContent() {
        switch (this.f4192a) {
            case 0:
                super.onAdDismissedFullScreenContent();
                ((i) this.f4193b).f4195c.onAdClosed();
                break;
            case 1:
                super.onAdDismissedFullScreenContent();
                ((k) this.f4193b).f4200c.onAdClosed();
                break;
            case 2:
                super.onAdDismissedFullScreenContent();
                ((y3.d) this.f4193b).f17841c.onAdClosed();
                break;
            default:
                super.onAdDismissedFullScreenContent();
                ((y3.e) this.f4193b).f17844c.onAdClosed();
                break;
        }
    }

    @Override // com.google.android.gms.ads.FullScreenContentCallback
    public final void onAdFailedToShowFullScreenContent(AdError adError) {
        switch (this.f4192a) {
            case 0:
                super.onAdFailedToShowFullScreenContent(adError);
                ((i) this.f4193b).f4195c.onAdFailedToShow(adError.getCode(), adError.toString());
                break;
            case 1:
                super.onAdFailedToShowFullScreenContent(adError);
                ((k) this.f4193b).f4200c.onAdFailedToShow(adError.getCode(), adError.toString());
                break;
            case 2:
                super.onAdFailedToShowFullScreenContent(adError);
                ((y3.d) this.f4193b).f17841c.onAdFailedToShow(adError.getCode(), adError.toString());
                break;
            default:
                super.onAdFailedToShowFullScreenContent(adError);
                ((y3.e) this.f4193b).f17844c.onAdFailedToShow(adError.getCode(), adError.toString());
                break;
        }
    }

    @Override // com.google.android.gms.ads.FullScreenContentCallback
    public final void onAdImpression() {
        switch (this.f4192a) {
            case 0:
                super.onAdImpression();
                ((i) this.f4193b).f4195c.onAdImpression();
                break;
            case 1:
                super.onAdImpression();
                ((k) this.f4193b).f4200c.onAdImpression();
                break;
            case 2:
                super.onAdImpression();
                ((y3.d) this.f4193b).f17841c.onAdImpression();
                break;
            default:
                super.onAdImpression();
                ((y3.e) this.f4193b).f17844c.onAdImpression();
                break;
        }
    }

    @Override // com.google.android.gms.ads.FullScreenContentCallback
    public final void onAdShowedFullScreenContent() {
        switch (this.f4192a) {
            case 0:
                super.onAdShowedFullScreenContent();
                ((i) this.f4193b).f4195c.onAdOpened();
                break;
            case 1:
                super.onAdShowedFullScreenContent();
                ((k) this.f4193b).f4200c.onAdOpened();
                break;
            case 2:
                super.onAdShowedFullScreenContent();
                ((y3.d) this.f4193b).f17841c.onAdOpened();
                break;
            default:
                super.onAdShowedFullScreenContent();
                ((y3.e) this.f4193b).f17844c.onAdOpened();
                break;
        }
    }
}
