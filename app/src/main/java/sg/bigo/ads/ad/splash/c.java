package sg.bigo.ads.ad.splash;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import sg.bigo.ads.api.AdError;
import sg.bigo.ads.api.SplashAdInteractionListener;

/* JADX INFO: loaded from: classes6.dex */
public class c implements SplashAdInteractionListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private boolean f15425a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @Nullable
    SplashAdInteractionListener f15426b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @Nullable
    SplashAdInteractionListener f15427c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private boolean f15428d = false;

    @Override // sg.bigo.ads.api.AdInteractionListener
    public void onAdClicked() {
        SplashAdInteractionListener splashAdInteractionListener = this.f15426b;
        if (splashAdInteractionListener != null) {
            splashAdInteractionListener.onAdClicked();
        }
        SplashAdInteractionListener splashAdInteractionListener2 = this.f15427c;
        if (splashAdInteractionListener2 != null) {
            splashAdInteractionListener2.onAdClicked();
        }
    }

    @Override // sg.bigo.ads.api.AdInteractionListener
    public void onAdClosed() {
        SplashAdInteractionListener splashAdInteractionListener = this.f15426b;
        if (splashAdInteractionListener != null) {
            splashAdInteractionListener.onAdClosed();
        }
        SplashAdInteractionListener splashAdInteractionListener2 = this.f15427c;
        if (splashAdInteractionListener2 != null) {
            splashAdInteractionListener2.onAdClosed();
        }
    }

    @Override // sg.bigo.ads.api.AdInteractionListener
    public void onAdError(@NonNull AdError adError) {
        if (adError.getCode() == 2002 && this.f15428d) {
            sg.bigo.ads.common.t.a.a(0, 3, "SplashAdInteractionListenerWrapper", "don't call onAdError when video has impressed");
            return;
        }
        SplashAdInteractionListener splashAdInteractionListener = this.f15426b;
        if (splashAdInteractionListener != null) {
            splashAdInteractionListener.onAdError(adError);
        }
        SplashAdInteractionListener splashAdInteractionListener2 = this.f15427c;
        if (splashAdInteractionListener2 != null) {
            splashAdInteractionListener2.onAdError(adError);
        }
    }

    @Override // sg.bigo.ads.api.SplashAdInteractionListener
    public void onAdFinished() {
        if (this.f15425a) {
            return;
        }
        SplashAdInteractionListener splashAdInteractionListener = this.f15426b;
        if (splashAdInteractionListener != null) {
            splashAdInteractionListener.onAdFinished();
        }
        SplashAdInteractionListener splashAdInteractionListener2 = this.f15427c;
        if (splashAdInteractionListener2 != null) {
            splashAdInteractionListener2.onAdFinished();
        }
    }

    @Override // sg.bigo.ads.api.AdInteractionListener
    public void onAdImpression() {
        SplashAdInteractionListener splashAdInteractionListener = this.f15426b;
        if (splashAdInteractionListener != null) {
            splashAdInteractionListener.onAdImpression();
        }
        SplashAdInteractionListener splashAdInteractionListener2 = this.f15427c;
        if (splashAdInteractionListener2 != null) {
            splashAdInteractionListener2.onAdImpression();
        }
        this.f15428d = true;
    }

    @Override // sg.bigo.ads.api.AdInteractionListener
    public void onAdOpened() {
        SplashAdInteractionListener splashAdInteractionListener = this.f15426b;
        if (splashAdInteractionListener != null) {
            splashAdInteractionListener.onAdOpened();
        }
        SplashAdInteractionListener splashAdInteractionListener2 = this.f15427c;
        if (splashAdInteractionListener2 != null) {
            splashAdInteractionListener2.onAdOpened();
        }
    }

    @Override // sg.bigo.ads.api.SplashAdInteractionListener
    public void onAdSkipped() {
        SplashAdInteractionListener splashAdInteractionListener = this.f15426b;
        if (splashAdInteractionListener != null) {
            splashAdInteractionListener.onAdSkipped();
        }
        SplashAdInteractionListener splashAdInteractionListener2 = this.f15427c;
        if (splashAdInteractionListener2 != null) {
            splashAdInteractionListener2.onAdSkipped();
        }
        this.f15425a = true;
    }
}
