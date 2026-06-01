package com.google.ads.mediation.vungle.renderers;

import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import com.google.ads.mediation.vungle.VungleConstants;
import com.google.ads.mediation.vungle.VungleFactory;
import com.google.ads.mediation.vungle.VungleInitializer;
import com.google.ads.mediation.vungle.VungleMediationAdapter;
import com.google.android.gms.ads.AdError;
import com.google.android.gms.ads.mediation.MediationAdLoadCallback;
import com.google.android.gms.ads.mediation.MediationAppOpenAd;
import com.google.android.gms.ads.mediation.MediationAppOpenAdCallback;
import com.google.android.gms.ads.mediation.MediationAppOpenAdConfiguration;
import com.vungle.ads.AdConfig;
import com.vungle.ads.BaseAd;
import com.vungle.ads.InterstitialAd;
import com.vungle.ads.InterstitialAdListener;
import com.vungle.ads.VungleError;
import kotlin.jvm.internal.k;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes3.dex */
public abstract class VungleAppOpenAd implements MediationAppOpenAd, InterstitialAdListener {
    private InterstitialAd appOpenAd;
    private final MediationAdLoadCallback<MediationAppOpenAd, MediationAppOpenAdCallback> mediationAdLoadCallback;
    private MediationAppOpenAdCallback mediationAppOpenAdCallback;
    private final VungleFactory vungleFactory;

    public VungleAppOpenAd(MediationAdLoadCallback<MediationAppOpenAd, MediationAppOpenAdCallback> mediationAdLoadCallback, VungleFactory vungleFactory) {
        k.e(mediationAdLoadCallback, "mediationAdLoadCallback");
        k.e(vungleFactory, "vungleFactory");
        this.mediationAdLoadCallback = mediationAdLoadCallback;
        this.vungleFactory = vungleFactory;
    }

    public abstract String getAdMarkup(MediationAppOpenAdConfiguration mediationAppOpenAdConfiguration);

    public abstract void maybeAddWatermarkToVungleAdConfig(AdConfig adConfig, MediationAppOpenAdConfiguration mediationAppOpenAdConfiguration);

    @Override // com.vungle.ads.BaseAdListener
    public void onAdClicked(BaseAd baseAd) {
        k.e(baseAd, "baseAd");
        MediationAppOpenAdCallback mediationAppOpenAdCallback = this.mediationAppOpenAdCallback;
        if (mediationAppOpenAdCallback == null || mediationAppOpenAdCallback == null) {
            return;
        }
        mediationAppOpenAdCallback.reportAdClicked();
    }

    @Override // com.vungle.ads.BaseAdListener
    public void onAdEnd(BaseAd baseAd) {
        k.e(baseAd, "baseAd");
        MediationAppOpenAdCallback mediationAppOpenAdCallback = this.mediationAppOpenAdCallback;
        if (mediationAppOpenAdCallback == null || mediationAppOpenAdCallback == null) {
            return;
        }
        mediationAppOpenAdCallback.onAdClosed();
    }

    @Override // com.vungle.ads.BaseAdListener
    public void onAdFailedToLoad(BaseAd baseAd, VungleError adError) {
        k.e(baseAd, "baseAd");
        k.e(adError, "adError");
        AdError adError2 = VungleMediationAdapter.getAdError(adError);
        k.d(adError2, "getAdError(...)");
        Log.w(VungleMediationAdapter.TAG, adError2.toString());
        this.mediationAdLoadCallback.onFailure(adError2);
    }

    @Override // com.vungle.ads.BaseAdListener
    public void onAdFailedToPlay(BaseAd baseAd, VungleError adError) {
        k.e(baseAd, "baseAd");
        k.e(adError, "adError");
        AdError adError2 = VungleMediationAdapter.getAdError(adError);
        k.d(adError2, "getAdError(...)");
        Log.w(VungleMediationAdapter.TAG, adError2.toString());
        MediationAppOpenAdCallback mediationAppOpenAdCallback = this.mediationAppOpenAdCallback;
        if (mediationAppOpenAdCallback == null || mediationAppOpenAdCallback == null) {
            return;
        }
        mediationAppOpenAdCallback.onAdFailedToShow(adError2);
    }

    @Override // com.vungle.ads.BaseAdListener
    public void onAdImpression(BaseAd baseAd) {
        k.e(baseAd, "baseAd");
        MediationAppOpenAdCallback mediationAppOpenAdCallback = this.mediationAppOpenAdCallback;
        if (mediationAppOpenAdCallback == null || mediationAppOpenAdCallback == null) {
            return;
        }
        mediationAppOpenAdCallback.reportAdImpression();
    }

    @Override // com.vungle.ads.BaseAdListener
    public void onAdLeftApplication(BaseAd baseAd) {
        k.e(baseAd, "baseAd");
    }

    @Override // com.vungle.ads.BaseAdListener
    public void onAdLoaded(BaseAd baseAd) {
        k.e(baseAd, "baseAd");
        this.mediationAppOpenAdCallback = this.mediationAdLoadCallback.onSuccess(this);
    }

    @Override // com.vungle.ads.BaseAdListener
    public void onAdStart(BaseAd baseAd) {
        k.e(baseAd, "baseAd");
        MediationAppOpenAdCallback mediationAppOpenAdCallback = this.mediationAppOpenAdCallback;
        if (mediationAppOpenAdCallback == null || mediationAppOpenAdCallback == null) {
            return;
        }
        mediationAppOpenAdCallback.onAdOpened();
    }

    public final void render(final MediationAppOpenAdConfiguration mediationAppOpenAdConfiguration) {
        k.e(mediationAppOpenAdConfiguration, "mediationAppOpenAdConfiguration");
        final Bundle mediationExtras = mediationAppOpenAdConfiguration.getMediationExtras();
        k.d(mediationExtras, "getMediationExtras(...)");
        Bundle serverParameters = mediationAppOpenAdConfiguration.getServerParameters();
        k.d(serverParameters, "getServerParameters(...)");
        String string = serverParameters.getString("appid");
        if (string == null || string.length() == 0) {
            AdError adError = new AdError(101, "Failed to load app open ad from Liftoff Monetize. Missing or invalid App ID configured for this ad source instance in the AdMob or Ad Manager UI.", VungleMediationAdapter.ERROR_DOMAIN);
            Log.w(VungleMediationAdapter.TAG, adError.toString());
            this.mediationAdLoadCallback.onFailure(adError);
            return;
        }
        final String string2 = serverParameters.getString(VungleConstants.KEY_PLACEMENT_ID);
        if (string2 == null || string2.length() == 0) {
            AdError adError2 = new AdError(101, "Failed to load app open ad from Liftoff Monetize. Missing or Invalid Placement ID configured for this ad source instance in the AdMob or Ad Manager UI.", VungleMediationAdapter.ERROR_DOMAIN);
            Log.w(VungleMediationAdapter.TAG, adError2.toString());
            this.mediationAdLoadCallback.onFailure(adError2);
        } else {
            final Context context = mediationAppOpenAdConfiguration.getContext();
            k.d(context, "getContext(...)");
            VungleInitializer vungleInitializer = VungleInitializer.getInstance();
            k.b(string);
            vungleInitializer.initialize(string, context, new VungleInitializer.VungleInitializationListener() { // from class: com.google.ads.mediation.vungle.renderers.VungleAppOpenAd.render.1
                @Override // com.google.ads.mediation.vungle.VungleInitializer.VungleInitializationListener
                public void onInitializeError(AdError error) {
                    k.e(error, "error");
                    Log.w(VungleMediationAdapter.TAG, error.toString());
                    VungleAppOpenAd.this.mediationAdLoadCallback.onFailure(error);
                }

                @Override // com.google.ads.mediation.vungle.VungleInitializer.VungleInitializationListener
                public void onInitializeSuccess() {
                    AdConfig adConfigCreateAdConfig = VungleAppOpenAd.this.vungleFactory.createAdConfig();
                    if (mediationExtras.containsKey(VungleConstants.KEY_ORIENTATION)) {
                        adConfigCreateAdConfig.setAdOrientation(mediationExtras.getInt(VungleConstants.KEY_ORIENTATION, 2));
                    }
                    VungleAppOpenAd.this.maybeAddWatermarkToVungleAdConfig(adConfigCreateAdConfig, mediationAppOpenAdConfiguration);
                    VungleAppOpenAd vungleAppOpenAd = VungleAppOpenAd.this;
                    VungleFactory vungleFactory = vungleAppOpenAd.vungleFactory;
                    Context context2 = context;
                    String str = string2;
                    k.b(str);
                    vungleAppOpenAd.appOpenAd = vungleFactory.createInterstitialAd(context2, str, adConfigCreateAdConfig);
                    InterstitialAd interstitialAd = VungleAppOpenAd.this.appOpenAd;
                    if (interstitialAd == null) {
                        k.l("appOpenAd");
                        throw null;
                    }
                    interstitialAd.setAdListener(VungleAppOpenAd.this);
                    InterstitialAd interstitialAd2 = VungleAppOpenAd.this.appOpenAd;
                    if (interstitialAd2 != null) {
                        interstitialAd2.load(VungleAppOpenAd.this.getAdMarkup(mediationAppOpenAdConfiguration));
                    } else {
                        k.l("appOpenAd");
                        throw null;
                    }
                }
            });
        }
    }

    @Override // com.google.android.gms.ads.mediation.MediationAppOpenAd
    public void showAd(Context context) {
        k.e(context, "context");
        InterstitialAd interstitialAd = this.appOpenAd;
        if (interstitialAd == null) {
            k.l("appOpenAd");
            throw null;
        }
        if (interstitialAd.canPlayAd().booleanValue()) {
            InterstitialAd interstitialAd2 = this.appOpenAd;
            if (interstitialAd2 != null) {
                interstitialAd2.play(context);
                return;
            } else {
                k.l("appOpenAd");
                throw null;
            }
        }
        AdError adError = new AdError(107, "Failed to show app open ad from Liftoff Monetize.", VungleMediationAdapter.ERROR_DOMAIN);
        Log.w(VungleMediationAdapter.TAG, adError.toString());
        MediationAppOpenAdCallback mediationAppOpenAdCallback = this.mediationAppOpenAdCallback;
        if (mediationAppOpenAdCallback != null) {
            mediationAppOpenAdCallback.onAdFailedToShow(adError);
        }
    }
}
