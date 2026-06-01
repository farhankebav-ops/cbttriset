package sg.bigo.ads.api;

import android.webkit.WebView;
import androidx.annotation.NonNull;
import sg.bigo.ads.api.b.d;

/* JADX INFO: loaded from: classes6.dex */
public interface InnerBannerAd extends BannerAd {
    void destroyInMainThread();

    sg.bigo.ads.api.core.c getInnerBannerAdData();

    WebView getWebView();

    void handleInnerBannerAdResponse(@NonNull d.a<InnerBannerAd> aVar);

    boolean isInnerBannerAdFromAutoRefresh();

    void markFromAutoFresh(sg.bigo.ads.api.core.c cVar);

    int updateFormOpenTimes();
}
