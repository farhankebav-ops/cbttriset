package com.google.ads.mediation.pangle.renderer;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import androidx.annotation.NonNull;
import com.bytedance.sdk.openadsdk.api.reward.PAGRewardItem;
import com.bytedance.sdk.openadsdk.api.reward.PAGRewardedAd;
import com.bytedance.sdk.openadsdk.api.reward.PAGRewardedAdInteractionListener;
import com.bytedance.sdk.openadsdk.api.reward.PAGRewardedAdLoadListener;
import com.bytedance.sdk.openadsdk.api.reward.PAGRewardedRequest;
import com.google.ads.mediation.pangle.PangleConstants;
import com.google.ads.mediation.pangle.PangleFactory;
import com.google.ads.mediation.pangle.PangleInitializer;
import com.google.ads.mediation.pangle.PangleMediationAdapter;
import com.google.ads.mediation.pangle.PangleRequestHelper;
import com.google.ads.mediation.pangle.PangleSdkWrapper;
import com.google.android.gms.ads.AdError;
import com.google.android.gms.ads.mediation.MediationAdLoadCallback;
import com.google.android.gms.ads.mediation.MediationRewardedAd;
import com.google.android.gms.ads.mediation.MediationRewardedAdCallback;
import com.google.android.gms.ads.mediation.MediationRewardedAdConfiguration;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes3.dex */
public class PangleRewardedAd implements MediationRewardedAd {
    private final MediationRewardedAdConfiguration adConfiguration;
    private final MediationAdLoadCallback<MediationRewardedAd, MediationRewardedAdCallback> adLoadCallback;
    private PAGRewardedAd pagRewardedAd;
    private final PangleFactory pangleFactory;
    private final PangleInitializer pangleInitializer;
    private final PangleSdkWrapper pangleSdkWrapper;
    private MediationRewardedAdCallback rewardedAdCallback;

    public PangleRewardedAd(@NonNull MediationRewardedAdConfiguration mediationRewardedAdConfiguration, @NonNull MediationAdLoadCallback<MediationRewardedAd, MediationRewardedAdCallback> mediationAdLoadCallback, @NonNull PangleInitializer pangleInitializer, PangleSdkWrapper pangleSdkWrapper, PangleFactory pangleFactory) {
        this.adConfiguration = mediationRewardedAdConfiguration;
        this.adLoadCallback = mediationAdLoadCallback;
        this.pangleInitializer = pangleInitializer;
        this.pangleSdkWrapper = pangleSdkWrapper;
        this.pangleFactory = pangleFactory;
    }

    public void render() {
        Bundle serverParameters = this.adConfiguration.getServerParameters();
        final String string = serverParameters.getString(PangleConstants.PLACEMENT_ID);
        if (TextUtils.isEmpty(string)) {
            AdError adErrorCreateAdapterError = PangleConstants.createAdapterError(101, "Failed to load rewarded ad from Pangle. Missing or invalid Placement ID.");
            Log.e(PangleMediationAdapter.TAG, adErrorCreateAdapterError.toString());
            this.adLoadCallback.onFailure(adErrorCreateAdapterError);
        } else {
            final String bidResponse = this.adConfiguration.getBidResponse();
            this.pangleInitializer.initialize(this.adConfiguration.getContext(), serverParameters.getString("appid"), new PangleInitializer.Listener() { // from class: com.google.ads.mediation.pangle.renderer.PangleRewardedAd.1
                @Override // com.google.ads.mediation.pangle.PangleInitializer.Listener
                public void onInitializeError(@NonNull AdError adError) {
                    Log.w(PangleMediationAdapter.TAG, adError.toString());
                    PangleRewardedAd.this.adLoadCallback.onFailure(adError);
                }

                @Override // com.google.ads.mediation.pangle.PangleInitializer.Listener
                public void onInitializeSuccess() {
                    PAGRewardedRequest pAGRewardedRequestCreatePagRewardedRequest = PangleRewardedAd.this.pangleFactory.createPagRewardedRequest();
                    pAGRewardedRequestCreatePagRewardedRequest.setAdString(bidResponse);
                    PangleRequestHelper.setWatermarkString(pAGRewardedRequestCreatePagRewardedRequest, bidResponse, PangleRewardedAd.this.adConfiguration);
                    PangleRewardedAd.this.pangleSdkWrapper.loadRewardedAd(string, pAGRewardedRequestCreatePagRewardedRequest, new PAGRewardedAdLoadListener() { // from class: com.google.ads.mediation.pangle.renderer.PangleRewardedAd.1.1
                        @Override // com.bytedance.sdk.openadsdk.api.PAGLoadListener, com.bytedance.sdk.openadsdk.common.vCE
                        public void onError(int i2, String str) {
                            AdError adErrorCreateSdkError = PangleConstants.createSdkError(i2, str);
                            Log.w(PangleMediationAdapter.TAG, adErrorCreateSdkError.toString());
                            PangleRewardedAd.this.adLoadCallback.onFailure(adErrorCreateSdkError);
                        }

                        @Override // com.bytedance.sdk.openadsdk.api.PAGLoadListener
                        public void onAdLoaded(PAGRewardedAd pAGRewardedAd) {
                            PangleRewardedAd pangleRewardedAd = PangleRewardedAd.this;
                            pangleRewardedAd.rewardedAdCallback = (MediationRewardedAdCallback) pangleRewardedAd.adLoadCallback.onSuccess(PangleRewardedAd.this);
                            PangleRewardedAd.this.pagRewardedAd = pAGRewardedAd;
                        }
                    });
                }
            });
        }
    }

    @Override // com.google.android.gms.ads.mediation.MediationRewardedAd
    public void showAd(@NonNull Context context) {
        this.pagRewardedAd.setAdInteractionListener(new PAGRewardedAdInteractionListener() { // from class: com.google.ads.mediation.pangle.renderer.PangleRewardedAd.2
            @Override // com.bytedance.sdk.openadsdk.api.PAGAdListener
            public void onAdClicked() {
                if (PangleRewardedAd.this.rewardedAdCallback != null) {
                    PangleRewardedAd.this.rewardedAdCallback.reportAdClicked();
                }
            }

            @Override // com.bytedance.sdk.openadsdk.api.PAGAdListener
            public void onAdDismissed() {
                if (PangleRewardedAd.this.rewardedAdCallback != null) {
                    PangleRewardedAd.this.rewardedAdCallback.onAdClosed();
                }
            }

            @Override // com.bytedance.sdk.openadsdk.api.PAGAdListener
            public void onAdShowed() {
                if (PangleRewardedAd.this.rewardedAdCallback != null) {
                    PangleRewardedAd.this.rewardedAdCallback.onAdOpened();
                    PangleRewardedAd.this.rewardedAdCallback.reportAdImpression();
                }
            }

            @Override // com.bytedance.sdk.openadsdk.api.reward.PAGRewardedAdInteractionListener
            public void onUserEarnedReward(PAGRewardItem pAGRewardItem) {
                if (PangleRewardedAd.this.rewardedAdCallback != null) {
                    PangleRewardedAd.this.rewardedAdCallback.onUserEarnedReward();
                }
            }

            @Override // com.bytedance.sdk.openadsdk.api.reward.PAGRewardedAdInteractionListener
            public void onUserEarnedRewardFail(int i2, String str) {
                Log.d(PangleMediationAdapter.TAG, PangleConstants.createSdkError(i2, "Failed to reward user: " + str).toString());
            }
        });
        if (context instanceof Activity) {
            this.pagRewardedAd.show((Activity) context);
        } else {
            this.pagRewardedAd.show(null);
        }
    }
}
