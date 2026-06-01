package com.google.ads.mediation.pangle.renderer;

import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.FrameLayout;
import androidx.annotation.NonNull;
import androidx.annotation.VisibleForTesting;
import com.bytedance.sdk.openadsdk.api.banner.PAGBannerAd;
import com.bytedance.sdk.openadsdk.api.banner.PAGBannerAdInteractionListener;
import com.bytedance.sdk.openadsdk.api.banner.PAGBannerAdLoadListener;
import com.bytedance.sdk.openadsdk.api.banner.PAGBannerRequest;
import com.bytedance.sdk.openadsdk.api.banner.PAGBannerSize;
import com.google.ads.mediation.pangle.PangleConstants;
import com.google.ads.mediation.pangle.PangleFactory;
import com.google.ads.mediation.pangle.PangleInitializer;
import com.google.ads.mediation.pangle.PangleMediationAdapter;
import com.google.ads.mediation.pangle.PangleRequestHelper;
import com.google.ads.mediation.pangle.PangleSdkWrapper;
import com.google.android.gms.ads.AdError;
import com.google.android.gms.ads.AdSize;
import com.google.android.gms.ads.mediation.MediationAdLoadCallback;
import com.google.android.gms.ads.mediation.MediationBannerAd;
import com.google.android.gms.ads.mediation.MediationBannerAdCallback;
import com.google.android.gms.ads.mediation.MediationBannerAdConfiguration;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes3.dex */
public class PangleBannerAd implements MediationBannerAd, PAGBannerAdInteractionListener {

    @VisibleForTesting
    public static final String ERROR_MESSAGE_BANNER_SIZE_MISMATCH = "Failed to request banner ad from Pangle. Invalid banner size.";
    private final MediationBannerAdConfiguration adConfiguration;
    private final MediationAdLoadCallback<MediationBannerAd, MediationBannerAdCallback> adLoadCallback;
    private MediationBannerAdCallback bannerAdCallback;
    private final PangleFactory pangleFactory;
    private final PangleInitializer pangleInitializer;
    private final PangleSdkWrapper pangleSdkWrapper;

    @VisibleForTesting
    FrameLayout wrappedAdView;

    public PangleBannerAd(@NonNull MediationBannerAdConfiguration mediationBannerAdConfiguration, @NonNull MediationAdLoadCallback<MediationBannerAd, MediationBannerAdCallback> mediationAdLoadCallback, @NonNull PangleInitializer pangleInitializer, @NonNull PangleSdkWrapper pangleSdkWrapper, @NonNull PangleFactory pangleFactory) {
        this.adConfiguration = mediationBannerAdConfiguration;
        this.adLoadCallback = mediationAdLoadCallback;
        this.pangleInitializer = pangleInitializer;
        this.pangleSdkWrapper = pangleSdkWrapper;
        this.pangleFactory = pangleFactory;
    }

    public static PAGBannerSize getBannerSizeFromGoogleAdSize(Context context, AdSize adSize) {
        if (adSize == null) {
            return null;
        }
        int width = adSize.getWidth();
        PAGBannerSize pAGBannerSize = PAGBannerSize.BANNER_W_320_H_50;
        if (width == pAGBannerSize.getWidth() && adSize.getHeight() == pAGBannerSize.getHeight()) {
            return pAGBannerSize;
        }
        int width2 = adSize.getWidth();
        PAGBannerSize pAGBannerSize2 = PAGBannerSize.BANNER_W_300_H_250;
        if (width2 == pAGBannerSize2.getWidth() && adSize.getHeight() == pAGBannerSize2.getHeight()) {
            return pAGBannerSize2;
        }
        int width3 = adSize.getWidth();
        PAGBannerSize pAGBannerSize3 = PAGBannerSize.BANNER_W_728_H_90;
        if (width3 == pAGBannerSize3.getWidth() && adSize.getHeight() == pAGBannerSize3.getHeight()) {
            return pAGBannerSize3;
        }
        PAGBannerSize currentOrientationAnchoredAdaptiveBannerAdSize = PAGBannerSize.getCurrentOrientationAnchoredAdaptiveBannerAdSize(context, adSize.getWidth());
        return (adSize.getWidth() == currentOrientationAnchoredAdaptiveBannerAdSize.getWidth() && adSize.getHeight() == currentOrientationAnchoredAdaptiveBannerAdSize.getHeight()) ? currentOrientationAnchoredAdaptiveBannerAdSize : PAGBannerSize.getInlineAdaptiveBannerAdSize(adSize.getWidth(), adSize.getHeight());
    }

    @Override // com.google.android.gms.ads.mediation.MediationBannerAd
    @NonNull
    public View getView() {
        return this.wrappedAdView;
    }

    @Override // com.bytedance.sdk.openadsdk.api.PAGAdListener
    public void onAdClicked() {
        MediationBannerAdCallback mediationBannerAdCallback = this.bannerAdCallback;
        if (mediationBannerAdCallback != null) {
            mediationBannerAdCallback.reportAdClicked();
        }
    }

    @Override // com.bytedance.sdk.openadsdk.api.PAGAdListener
    public void onAdShowed() {
        MediationBannerAdCallback mediationBannerAdCallback = this.bannerAdCallback;
        if (mediationBannerAdCallback != null) {
            mediationBannerAdCallback.reportAdImpression();
        }
    }

    public void render() {
        Bundle serverParameters = this.adConfiguration.getServerParameters();
        final String string = serverParameters.getString(PangleConstants.PLACEMENT_ID);
        if (TextUtils.isEmpty(string)) {
            AdError adErrorCreateAdapterError = PangleConstants.createAdapterError(101, "Failed to load banner ad from Pangle. Missing or invalid Placement ID.");
            Log.e(PangleMediationAdapter.TAG, adErrorCreateAdapterError.toString());
            this.adLoadCallback.onFailure(adErrorCreateAdapterError);
        } else {
            final String bidResponse = this.adConfiguration.getBidResponse();
            final Context context = this.adConfiguration.getContext();
            this.pangleInitializer.initialize(context, serverParameters.getString("appid"), new PangleInitializer.Listener() { // from class: com.google.ads.mediation.pangle.renderer.PangleBannerAd.1
                @Override // com.google.ads.mediation.pangle.PangleInitializer.Listener
                public void onInitializeError(@NonNull AdError adError) {
                    Log.w(PangleMediationAdapter.TAG, adError.toString());
                    PangleBannerAd.this.adLoadCallback.onFailure(adError);
                }

                @Override // com.google.ads.mediation.pangle.PangleInitializer.Listener
                public void onInitializeSuccess() {
                    PAGBannerSize bannerSizeFromGoogleAdSize = PangleBannerAd.getBannerSizeFromGoogleAdSize(context, PangleBannerAd.this.adConfiguration.getAdSize());
                    if (bannerSizeFromGoogleAdSize == null) {
                        AdError adErrorCreateAdapterError2 = PangleConstants.createAdapterError(102, PangleBannerAd.ERROR_MESSAGE_BANNER_SIZE_MISMATCH);
                        Log.w(PangleMediationAdapter.TAG, adErrorCreateAdapterError2.toString());
                        PangleBannerAd.this.adLoadCallback.onFailure(adErrorCreateAdapterError2);
                    } else {
                        PangleBannerAd.this.wrappedAdView = new FrameLayout(context);
                        PAGBannerRequest pAGBannerRequestCreatePagBannerRequest = PangleBannerAd.this.pangleFactory.createPagBannerRequest(bannerSizeFromGoogleAdSize);
                        pAGBannerRequestCreatePagBannerRequest.setAdString(bidResponse);
                        PangleRequestHelper.setWatermarkString(pAGBannerRequestCreatePagBannerRequest, bidResponse, PangleBannerAd.this.adConfiguration);
                        PangleBannerAd.this.pangleSdkWrapper.loadBannerAd(string, pAGBannerRequestCreatePagBannerRequest, new PAGBannerAdLoadListener() { // from class: com.google.ads.mediation.pangle.renderer.PangleBannerAd.1.1
                            @Override // com.bytedance.sdk.openadsdk.api.PAGLoadListener, com.bytedance.sdk.openadsdk.common.vCE
                            public void onError(int i2, String str) {
                                AdError adErrorCreateSdkError = PangleConstants.createSdkError(i2, str);
                                Log.w(PangleMediationAdapter.TAG, adErrorCreateSdkError.toString());
                                PangleBannerAd.this.adLoadCallback.onFailure(adErrorCreateSdkError);
                            }

                            @Override // com.bytedance.sdk.openadsdk.api.PAGLoadListener
                            public void onAdLoaded(PAGBannerAd pAGBannerAd) {
                                pAGBannerAd.setAdInteractionListener(PangleBannerAd.this);
                                PangleBannerAd.this.wrappedAdView.addView(pAGBannerAd.getBannerView());
                                PangleBannerAd pangleBannerAd = PangleBannerAd.this;
                                pangleBannerAd.bannerAdCallback = (MediationBannerAdCallback) pangleBannerAd.adLoadCallback.onSuccess(PangleBannerAd.this);
                            }
                        });
                    }
                }
            });
        }
    }

    @Override // com.bytedance.sdk.openadsdk.api.PAGAdListener
    public void onAdDismissed() {
    }
}
