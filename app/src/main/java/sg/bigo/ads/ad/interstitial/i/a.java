package sg.bigo.ads.ad.interstitial.i;

import android.content.Context;
import android.view.View;
import android.widget.FrameLayout;
import androidx.annotation.NonNull;
import sg.bigo.ads.ad.banner.g;
import sg.bigo.ads.ad.interstitial.n;
import sg.bigo.ads.api.InterstitialAd;
import sg.bigo.ads.api.core.i;

/* JADX INFO: loaded from: classes6.dex */
public class a implements g {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    Context f14802a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    InterstitialAd f14803b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public n f14804c;

    public a(InterstitialAd interstitialAd, Context context, @NonNull n nVar) {
        this.f14804c = nVar;
        this.f14802a = context;
        this.f14803b = interstitialAd;
    }

    @Override // sg.bigo.ads.ad.banner.g
    public void a(View view, View view2, i.b bVar) {
        FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) view.getLayoutParams();
        layoutParams.width = -1;
        layoutParams.height = -1;
    }
}
