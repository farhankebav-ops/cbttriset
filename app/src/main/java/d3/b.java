package d3;

import com.ironsource.mediationsdk.logger.IronSourceError;
import com.ironsource.mediationsdk.sdk.InterstitialSmashListener;
import java.util.Map;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes5.dex */
public abstract /* synthetic */ class b {
    public static void a(InterstitialSmashListener interstitialSmashListener, Map map) {
        interstitialSmashListener.onInterstitialAdClicked();
    }

    public static void b(InterstitialSmashListener interstitialSmashListener, Map map) {
        interstitialSmashListener.onInterstitialAdClosed();
    }

    public static void c(InterstitialSmashListener interstitialSmashListener, IronSourceError ironSourceError, Map map) {
        interstitialSmashListener.onInterstitialAdLoadFailed(ironSourceError);
    }

    public static void d(InterstitialSmashListener interstitialSmashListener, Map map) {
        interstitialSmashListener.onInterstitialAdOpened();
    }

    public static void e(InterstitialSmashListener interstitialSmashListener, Map map) {
        interstitialSmashListener.onInterstitialAdReady();
    }

    public static void f(InterstitialSmashListener interstitialSmashListener, IronSourceError ironSourceError, Map map) {
        interstitialSmashListener.onInterstitialAdShowFailed(ironSourceError);
    }

    public static void g(InterstitialSmashListener interstitialSmashListener, Map map) {
        interstitialSmashListener.onInterstitialAdShowSucceeded();
    }

    public static void h(InterstitialSmashListener interstitialSmashListener, Map map) {
        interstitialSmashListener.onInterstitialAdVisible();
    }

    public static void i(InterstitialSmashListener interstitialSmashListener, IronSourceError ironSourceError, Map map) {
        interstitialSmashListener.onInterstitialInitFailed(ironSourceError);
    }

    public static void j(InterstitialSmashListener interstitialSmashListener, Map map) {
        interstitialSmashListener.onInterstitialInitSuccess();
    }
}
