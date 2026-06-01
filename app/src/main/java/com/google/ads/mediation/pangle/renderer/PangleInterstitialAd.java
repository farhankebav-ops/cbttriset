package com.google.ads.mediation.pangle.renderer;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import androidx.annotation.NonNull;
import com.bytedance.sdk.openadsdk.api.interstitial.PAGInterstitialAd;
import com.bytedance.sdk.openadsdk.api.interstitial.PAGInterstitialAdInteractionListener;
import com.bytedance.sdk.openadsdk.api.interstitial.PAGInterstitialAdLoadListener;
import com.bytedance.sdk.openadsdk.api.interstitial.PAGInterstitialRequest;
import com.google.ads.mediation.pangle.PangleConstants;
import com.google.ads.mediation.pangle.PangleFactory;
import com.google.ads.mediation.pangle.PangleInitializer;
import com.google.ads.mediation.pangle.PangleMediationAdapter;
import com.google.ads.mediation.pangle.PangleRequestHelper;
import com.google.ads.mediation.pangle.PangleSdkWrapper;
import com.google.android.gms.ads.AdError;
import com.google.android.gms.ads.mediation.MediationAdLoadCallback;
import com.google.android.gms.ads.mediation.MediationInterstitialAd;
import com.google.android.gms.ads.mediation.MediationInterstitialAdCallback;
import com.google.android.gms.ads.mediation.MediationInterstitialAdConfiguration;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes3.dex */
public class PangleInterstitialAd implements MediationInterstitialAd {
    private final MediationInterstitialAdConfiguration adConfiguration;
    private final MediationAdLoadCallback<MediationInterstitialAd, MediationInterstitialAdCallback> adLoadCallback;
    private MediationInterstitialAdCallback interstitialAdCallback;
    private PAGInterstitialAd pagInterstitialAd;
    private final PangleFactory pangleFactory;
    private final PangleInitializer pangleInitializer;
    private final PangleSdkWrapper pangleSdkWrapper;

    public PangleInterstitialAd(@NonNull MediationInterstitialAdConfiguration mediationInterstitialAdConfiguration, @NonNull MediationAdLoadCallback<MediationInterstitialAd, MediationInterstitialAdCallback> mediationAdLoadCallback, @NonNull PangleInitializer pangleInitializer, PangleSdkWrapper pangleSdkWrapper, PangleFactory pangleFactory) {
        this.adConfiguration = mediationInterstitialAdConfiguration;
        this.adLoadCallback = mediationAdLoadCallback;
        this.pangleInitializer = pangleInitializer;
        this.pangleSdkWrapper = pangleSdkWrapper;
        this.pangleFactory = pangleFactory;
    }

    public void render() {
        Bundle serverParameters = this.adConfiguration.getServerParameters();
        final String string = serverParameters.getString(PangleConstants.PLACEMENT_ID);
        if (TextUtils.isEmpty(string)) {
            AdError adErrorCreateAdapterError = PangleConstants.createAdapterError(101, "Failed to load interstitial ad from Pangle. Missing or invalid Placement ID.");
            Log.e(PangleMediationAdapter.TAG, adErrorCreateAdapterError.toString());
            this.adLoadCallback.onFailure(adErrorCreateAdapterError);
        } else {
            final String bidResponse = this.adConfiguration.getBidResponse();
            this.pangleInitializer.initialize(this.adConfiguration.getContext(), serverParameters.getString("appid"), new PangleInitializer.Listener() { // from class: com.google.ads.mediation.pangle.renderer.PangleInterstitialAd.1
                @Override // com.google.ads.mediation.pangle.PangleInitializer.Listener
                public void onInitializeError(@NonNull AdError adError) {
                    Log.w(PangleMediationAdapter.TAG, adError.toString());
                    PangleInterstitialAd.this.adLoadCallback.onFailure(adError);
                }

                @Override // com.google.ads.mediation.pangle.PangleInitializer.Listener
                public void onInitializeSuccess() {
                    PAGInterstitialRequest pAGInterstitialRequestCreatePagInterstitialRequest = PangleInterstitialAd.this.pangleFactory.createPagInterstitialRequest();
                    pAGInterstitialRequestCreatePagInterstitialRequest.setAdString(bidResponse);
                    PangleRequestHelper.setWatermarkString(pAGInterstitialRequestCreatePagInterstitialRequest, bidResponse, PangleInterstitialAd.this.adConfiguration);
                    PangleInterstitialAd.this.pangleSdkWrapper.loadInterstitialAd(string, pAGInterstitialRequestCreatePagInterstitialRequest, new PAGInterstitialAdLoadListener() { // from class: com.google.ads.mediation.pangle.renderer.PangleInterstitialAd.1.1
                        @Override // com.bytedance.sdk.openadsdk.api.PAGLoadListener, com.bytedance.sdk.openadsdk.common.vCE
                        public void onError(int i2, String str) {
                            AdError adErrorCreateSdkError = PangleConstants.createSdkError(i2, str);
                            Log.w(PangleMediationAdapter.TAG, adErrorCreateSdkError.toString());
                            PangleInterstitialAd.this.adLoadCallback.onFailure(adErrorCreateSdkError);
                        }

                        @Override // com.bytedance.sdk.openadsdk.api.PAGLoadListener
                        public void onAdLoaded(PAGInterstitialAd pAGInterstitialAd) {
                            PangleInterstitialAd pangleInterstitialAd = PangleInterstitialAd.this;
                            pangleInterstitialAd.interstitialAdCallback = (MediationInterstitialAdCallback) pangleInterstitialAd.adLoadCallback.onSuccess(PangleInterstitialAd.this);
                            PangleInterstitialAd.this.pagInterstitialAd = pAGInterstitialAd;
                        }
                    });
                }
            });
        }
    }

    @Override // com.google.android.gms.ads.mediation.MediationInterstitialAd
    public void showAd(@NonNull Context context) {
        this.pagInterstitialAd.setAdInteractionListener(new PAGInterstitialAdInteractionListener() { // from class: com.google.ads.mediation.pangle.renderer.PangleInterstitialAd.2
            @Override // com.bytedance.sdk.openadsdk.api.PAGAdListener
            public void onAdClicked() {
                if (PangleInterstitialAd.this.interstitialAdCallback != null) {
                    PangleInterstitialAd.this.interstitialAdCallback.reportAdClicked();
                }
            }

            @Override // com.bytedance.sdk.openadsdk.api.PAGAdListener
            public void onAdDismissed() {
                if (PangleInterstitialAd.this.interstitialAdCallback != null) {
                    PangleInterstitialAd.this.interstitialAdCallback.onAdClosed();
                }
            }

            @Override // com.bytedance.sdk.openadsdk.api.PAGAdListener
            public void onAdShowed() {
                if (PangleInterstitialAd.this.interstitialAdCallback != null) {
                    PangleInterstitialAd.this.interstitialAdCallback.onAdOpened();
                    PangleInterstitialAd.this.interstitialAdCallback.reportAdImpression();
                }
            }
        });
        if (context instanceof Activity) {
            this.pagInterstitialAd.show((Activity) context);
        } else {
            this.pagInterstitialAd.show(null);
        }
    }
}
