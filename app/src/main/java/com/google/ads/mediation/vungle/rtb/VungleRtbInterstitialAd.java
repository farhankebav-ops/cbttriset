package com.google.ads.mediation.vungle.rtb;

import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.google.ads.mediation.vungle.VungleConstants;
import com.google.ads.mediation.vungle.VungleFactory;
import com.google.ads.mediation.vungle.VungleInitializer;
import com.google.ads.mediation.vungle.VungleMediationAdapter;
import com.google.android.gms.ads.AdError;
import com.google.android.gms.ads.mediation.MediationAdLoadCallback;
import com.google.android.gms.ads.mediation.MediationInterstitialAd;
import com.google.android.gms.ads.mediation.MediationInterstitialAdCallback;
import com.google.android.gms.ads.mediation.MediationInterstitialAdConfiguration;
import com.vungle.ads.AdConfig;
import com.vungle.ads.BaseAd;
import com.vungle.ads.InterstitialAd;
import com.vungle.ads.InterstitialAdListener;
import com.vungle.ads.VungleError;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes3.dex */
public class VungleRtbInterstitialAd implements MediationInterstitialAd, InterstitialAdListener {
    private InterstitialAd interstitialAd;

    @NonNull
    private final MediationAdLoadCallback<MediationInterstitialAd, MediationInterstitialAdCallback> mediationAdLoadCallback;

    @Nullable
    private MediationInterstitialAdCallback mediationInterstitialAdCallback;
    private final VungleFactory vungleFactory;

    public VungleRtbInterstitialAd(@NonNull MediationAdLoadCallback<MediationInterstitialAd, MediationInterstitialAdCallback> mediationAdLoadCallback, VungleFactory vungleFactory) {
        this.mediationAdLoadCallback = mediationAdLoadCallback;
        this.vungleFactory = vungleFactory;
    }

    @Override // com.vungle.ads.BaseAdListener
    public void onAdClicked(@NonNull BaseAd baseAd) {
        MediationInterstitialAdCallback mediationInterstitialAdCallback = this.mediationInterstitialAdCallback;
        if (mediationInterstitialAdCallback != null) {
            mediationInterstitialAdCallback.reportAdClicked();
        }
    }

    @Override // com.vungle.ads.BaseAdListener
    public void onAdEnd(@NonNull BaseAd baseAd) {
        MediationInterstitialAdCallback mediationInterstitialAdCallback = this.mediationInterstitialAdCallback;
        if (mediationInterstitialAdCallback != null) {
            mediationInterstitialAdCallback.onAdClosed();
        }
    }

    @Override // com.vungle.ads.BaseAdListener
    public void onAdFailedToLoad(@NonNull BaseAd baseAd, @NonNull VungleError vungleError) {
        AdError adError = VungleMediationAdapter.getAdError(vungleError);
        Log.w(VungleMediationAdapter.TAG, adError.toString());
        this.mediationAdLoadCallback.onFailure(adError);
    }

    @Override // com.vungle.ads.BaseAdListener
    public void onAdFailedToPlay(@NonNull BaseAd baseAd, @NonNull VungleError vungleError) {
        AdError adError = VungleMediationAdapter.getAdError(vungleError);
        Log.w(VungleMediationAdapter.TAG, adError.toString());
        MediationInterstitialAdCallback mediationInterstitialAdCallback = this.mediationInterstitialAdCallback;
        if (mediationInterstitialAdCallback != null) {
            mediationInterstitialAdCallback.onAdFailedToShow(adError);
        }
    }

    @Override // com.vungle.ads.BaseAdListener
    public void onAdImpression(@NonNull BaseAd baseAd) {
        MediationInterstitialAdCallback mediationInterstitialAdCallback = this.mediationInterstitialAdCallback;
        if (mediationInterstitialAdCallback != null) {
            mediationInterstitialAdCallback.reportAdImpression();
        }
    }

    @Override // com.vungle.ads.BaseAdListener
    public void onAdLeftApplication(@NonNull BaseAd baseAd) {
        MediationInterstitialAdCallback mediationInterstitialAdCallback = this.mediationInterstitialAdCallback;
        if (mediationInterstitialAdCallback != null) {
            mediationInterstitialAdCallback.onAdLeftApplication();
        }
    }

    @Override // com.vungle.ads.BaseAdListener
    public void onAdLoaded(@NonNull BaseAd baseAd) {
        this.mediationInterstitialAdCallback = this.mediationAdLoadCallback.onSuccess(this);
    }

    @Override // com.vungle.ads.BaseAdListener
    public void onAdStart(@NonNull BaseAd baseAd) {
        MediationInterstitialAdCallback mediationInterstitialAdCallback = this.mediationInterstitialAdCallback;
        if (mediationInterstitialAdCallback != null) {
            mediationInterstitialAdCallback.onAdOpened();
        }
    }

    public void render(@NonNull MediationInterstitialAdConfiguration mediationInterstitialAdConfiguration) {
        Bundle mediationExtras = mediationInterstitialAdConfiguration.getMediationExtras();
        Bundle serverParameters = mediationInterstitialAdConfiguration.getServerParameters();
        String string = serverParameters.getString("appid");
        if (TextUtils.isEmpty(string)) {
            AdError adError = new AdError(101, "Failed to load bidding interstitial ad from Liftoff Monetize. Missing or invalid App ID configured for this ad source instance in the AdMob or Ad Manager UI.", VungleMediationAdapter.ERROR_DOMAIN);
            Log.w(VungleMediationAdapter.TAG, adError.toString());
            this.mediationAdLoadCallback.onFailure(adError);
            return;
        }
        final String string2 = serverParameters.getString(VungleConstants.KEY_PLACEMENT_ID);
        if (TextUtils.isEmpty(string2)) {
            AdError adError2 = new AdError(101, "Failed to load bidding interstitial ad from Liftoff Monetize. Missing or Invalid Placement ID configured for this ad source instance in the AdMob or Ad Manager UI.", VungleMediationAdapter.ERROR_DOMAIN);
            Log.w(VungleMediationAdapter.TAG, adError2.toString());
            this.mediationAdLoadCallback.onFailure(adError2);
            return;
        }
        final String bidResponse = mediationInterstitialAdConfiguration.getBidResponse();
        final AdConfig adConfigCreateAdConfig = this.vungleFactory.createAdConfig();
        if (mediationExtras.containsKey(VungleConstants.KEY_ORIENTATION)) {
            adConfigCreateAdConfig.setAdOrientation(mediationExtras.getInt(VungleConstants.KEY_ORIENTATION, 2));
        }
        String watermark = mediationInterstitialAdConfiguration.getWatermark();
        if (!TextUtils.isEmpty(watermark)) {
            adConfigCreateAdConfig.setWatermark(watermark);
        }
        final Context context = mediationInterstitialAdConfiguration.getContext();
        VungleInitializer.getInstance().initialize(string, context, new VungleInitializer.VungleInitializationListener() { // from class: com.google.ads.mediation.vungle.rtb.VungleRtbInterstitialAd.1
            @Override // com.google.ads.mediation.vungle.VungleInitializer.VungleInitializationListener
            public void onInitializeError(AdError adError3) {
                Log.w(VungleMediationAdapter.TAG, adError3.toString());
                VungleRtbInterstitialAd.this.mediationAdLoadCallback.onFailure(adError3);
            }

            @Override // com.google.ads.mediation.vungle.VungleInitializer.VungleInitializationListener
            public void onInitializeSuccess() throws Throwable {
                VungleRtbInterstitialAd vungleRtbInterstitialAd = VungleRtbInterstitialAd.this;
                vungleRtbInterstitialAd.interstitialAd = vungleRtbInterstitialAd.vungleFactory.createInterstitialAd(context, string2, adConfigCreateAdConfig);
                VungleRtbInterstitialAd.this.interstitialAd.setAdListener(VungleRtbInterstitialAd.this);
                VungleRtbInterstitialAd.this.interstitialAd.load(bidResponse);
            }
        });
    }

    @Override // com.google.android.gms.ads.mediation.MediationInterstitialAd
    public void showAd(@NonNull Context context) throws Throwable {
        InterstitialAd interstitialAd = this.interstitialAd;
        if (interstitialAd != null) {
            interstitialAd.play(context);
        } else if (this.mediationInterstitialAdCallback != null) {
            AdError adError = new AdError(107, "Failed to show bidding rewarded ad from Liftoff Monetize.", VungleMediationAdapter.ERROR_DOMAIN);
            Log.w(VungleMediationAdapter.TAG, adError.toString());
            this.mediationInterstitialAdCallback.onAdFailedToShow(adError);
        }
    }
}
