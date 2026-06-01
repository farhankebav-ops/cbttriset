package c4;

import android.widget.RelativeLayout;
import com.google.android.gms.ads.AdListener;
import com.google.android.gms.ads.AdView;
import com.google.android.gms.ads.LoadAdError;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes5.dex */
public final class d extends AdListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f4185a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ Object f4186b;

    public /* synthetic */ d(Object obj, int i2) {
        this.f4185a = i2;
        this.f4186b = obj;
    }

    @Override // com.google.android.gms.ads.AdListener
    public final void onAdClicked() {
        switch (this.f4185a) {
            case 0:
                super.onAdClicked();
                ((e) this.f4186b).f4187b.onAdClicked();
                break;
            default:
                super.onAdClicked();
                ((y3.b) this.f4186b).f17837b.onAdClicked();
                break;
        }
    }

    @Override // com.google.android.gms.ads.AdListener
    public final void onAdClosed() {
        switch (this.f4185a) {
            case 0:
                super.onAdClosed();
                ((e) this.f4186b).f4187b.onAdClosed();
                break;
            default:
                super.onAdClosed();
                ((y3.b) this.f4186b).f17837b.onAdClosed();
                break;
        }
    }

    @Override // com.google.android.gms.ads.AdListener
    public final void onAdFailedToLoad(LoadAdError loadAdError) {
        AdView adView;
        AdView adView2;
        switch (this.f4185a) {
            case 0:
                super.onAdFailedToLoad(loadAdError);
                e eVar = (e) this.f4186b;
                c cVar = eVar.f4188c;
                RelativeLayout relativeLayout = cVar.h;
                if (relativeLayout != null && (adView = cVar.k) != null) {
                    relativeLayout.removeView(adView);
                }
                eVar.f4187b.onAdFailedToLoad(loadAdError.getCode(), loadAdError.getMessage());
                break;
            default:
                super.onAdFailedToLoad(loadAdError);
                y3.b bVar = (y3.b) this.f4186b;
                y3.a aVar = bVar.f17838c;
                RelativeLayout relativeLayout2 = aVar.h;
                if (relativeLayout2 != null && (adView2 = aVar.k) != null) {
                    relativeLayout2.removeView(adView2);
                }
                bVar.f17837b.onAdFailedToLoad(loadAdError.getCode(), loadAdError.getMessage());
                break;
        }
    }

    @Override // com.google.android.gms.ads.AdListener
    public final void onAdImpression() {
        switch (this.f4185a) {
            case 0:
                super.onAdImpression();
                ((e) this.f4186b).f4187b.onAdImpression();
                break;
            default:
                super.onAdImpression();
                ((y3.b) this.f4186b).f17837b.onAdImpression();
                break;
        }
    }

    @Override // com.google.android.gms.ads.AdListener
    public final void onAdLoaded() {
        switch (this.f4185a) {
            case 0:
                super.onAdLoaded();
                ((e) this.f4186b).f4187b.onAdLoaded();
                break;
            default:
                super.onAdLoaded();
                ((y3.b) this.f4186b).f17837b.onAdLoaded();
                break;
        }
    }

    @Override // com.google.android.gms.ads.AdListener
    public final void onAdOpened() {
        switch (this.f4185a) {
            case 0:
                super.onAdOpened();
                ((e) this.f4186b).f4187b.onAdOpened();
                break;
            default:
                super.onAdOpened();
                ((y3.b) this.f4186b).f17837b.onAdOpened();
                break;
        }
    }
}
