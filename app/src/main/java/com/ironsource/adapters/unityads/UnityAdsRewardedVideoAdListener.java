package com.ironsource.adapters.unityads;

import com.google.android.gms.ads.internal.client.a;
import com.ironsource.mediationsdk.logger.IronLog;
import com.ironsource.mediationsdk.logger.IronSourceError;
import com.ironsource.mediationsdk.sdk.RewardedVideoSmashListener;
import com.ironsource.mediationsdk.utils.ErrorBuilder;
import com.ironsource.mediationsdk.utils.IronSourceConstants;
import com.unity3d.ads.IUnityAdsLoadListener;
import com.unity3d.ads.IUnityAdsShowListener;
import com.unity3d.ads.UnityAds;
import java.lang.ref.WeakReference;
import kotlin.jvm.internal.k;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes5.dex */
public final class UnityAdsRewardedVideoAdListener implements IUnityAdsLoadListener, IUnityAdsShowListener {
    private final WeakReference<UnityAdsAdapter> mAdapter;
    private final RewardedVideoSmashListener mListener;
    private final String mPlacementId;

    /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[UnityAds.UnityAdsShowCompletionState.values().length];
            try {
                iArr[UnityAds.UnityAdsShowCompletionState.SKIPPED.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[UnityAds.UnityAdsShowCompletionState.COMPLETED.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            $EnumSwitchMapping$0 = iArr;
        }
    }

    public UnityAdsRewardedVideoAdListener(RewardedVideoSmashListener rewardedVideoSmashListener, WeakReference<UnityAdsAdapter> weakReference, String mPlacementId) {
        k.e(mPlacementId, "mPlacementId");
        this.mListener = rewardedVideoSmashListener;
        this.mAdapter = weakReference;
        this.mPlacementId = mPlacementId;
    }

    @Override // com.unity3d.ads.IUnityAdsLoadListener
    public void onUnityAdsAdLoaded(String str) {
        UnityAdsAdapter unityAdsAdapter;
        a.p("placementId = ", this.mPlacementId, IronLog.ADAPTER_CALLBACK);
        WeakReference<UnityAdsAdapter> weakReference = this.mAdapter;
        if (weakReference != null && (unityAdsAdapter = weakReference.get()) != null) {
            unityAdsAdapter.setRewardedVideoAdAvailability$unityadsadapter_release(this.mPlacementId, true);
        }
        RewardedVideoSmashListener rewardedVideoSmashListener = this.mListener;
        if (rewardedVideoSmashListener != null) {
            rewardedVideoSmashListener.onRewardedVideoAvailabilityChanged(true);
        }
    }

    @Override // com.unity3d.ads.IUnityAdsLoadListener
    public void onUnityAdsFailedToLoad(String str, UnityAds.UnityAdsLoadError unityAdsLoadError, String str2) {
        int unityAdsLoadErrorCode;
        UnityAdsAdapter unityAdsAdapter;
        UnityAdsAdapter unityAdsAdapter2;
        WeakReference<UnityAdsAdapter> weakReference = this.mAdapter;
        if (weakReference != null && (unityAdsAdapter2 = weakReference.get()) != null) {
            unityAdsAdapter2.setRewardedVideoAdAvailability$unityadsadapter_release(this.mPlacementId, false);
        }
        RewardedVideoSmashListener rewardedVideoSmashListener = this.mListener;
        if (rewardedVideoSmashListener != null) {
            rewardedVideoSmashListener.onRewardedVideoAvailabilityChanged(false);
        }
        if (unityAdsLoadError != null) {
            if (unityAdsLoadError == UnityAds.UnityAdsLoadError.NO_FILL) {
                unityAdsLoadErrorCode = 1058;
            } else {
                WeakReference<UnityAdsAdapter> weakReference2 = this.mAdapter;
                unityAdsLoadErrorCode = (weakReference2 == null || (unityAdsAdapter = weakReference2.get()) == null) ? 510 : unityAdsAdapter.getUnityAdsLoadErrorCode(unityAdsLoadError);
            }
            IronSourceError ironSourceError = new IronSourceError(unityAdsLoadErrorCode, str2);
            IronLog.ADAPTER_CALLBACK.error("placementId = " + this.mPlacementId + " ironSourceError = " + ironSourceError);
            RewardedVideoSmashListener rewardedVideoSmashListener2 = this.mListener;
            if (rewardedVideoSmashListener2 != null) {
                rewardedVideoSmashListener2.onRewardedVideoLoadFailed(ironSourceError);
            }
        }
    }

    @Override // com.unity3d.ads.IUnityAdsShowListener
    public void onUnityAdsShowClick(String str) {
        a.p("placementId = ", this.mPlacementId, IronLog.ADAPTER_CALLBACK);
        RewardedVideoSmashListener rewardedVideoSmashListener = this.mListener;
        if (rewardedVideoSmashListener != null) {
            rewardedVideoSmashListener.onRewardedVideoAdClicked();
        }
    }

    @Override // com.unity3d.ads.IUnityAdsShowListener
    public void onUnityAdsShowComplete(String str, UnityAds.UnityAdsShowCompletionState unityAdsShowCompletionState) {
        IronLog.ADAPTER_CALLBACK.verbose("placementId = " + this.mPlacementId + " completionState = " + unityAdsShowCompletionState);
        int i2 = unityAdsShowCompletionState == null ? -1 : WhenMappings.$EnumSwitchMapping$0[unityAdsShowCompletionState.ordinal()];
        if (i2 == 1) {
            RewardedVideoSmashListener rewardedVideoSmashListener = this.mListener;
            if (rewardedVideoSmashListener != null) {
                rewardedVideoSmashListener.onRewardedVideoAdClosed();
                return;
            }
            return;
        }
        if (i2 != 2) {
            return;
        }
        RewardedVideoSmashListener rewardedVideoSmashListener2 = this.mListener;
        if (rewardedVideoSmashListener2 != null) {
            rewardedVideoSmashListener2.onRewardedVideoAdEnded();
        }
        RewardedVideoSmashListener rewardedVideoSmashListener3 = this.mListener;
        if (rewardedVideoSmashListener3 != null) {
            rewardedVideoSmashListener3.onRewardedVideoAdRewarded();
        }
        RewardedVideoSmashListener rewardedVideoSmashListener4 = this.mListener;
        if (rewardedVideoSmashListener4 != null) {
            rewardedVideoSmashListener4.onRewardedVideoAdClosed();
        }
    }

    @Override // com.unity3d.ads.IUnityAdsShowListener
    public void onUnityAdsShowFailure(String str, UnityAds.UnityAdsShowError unityAdsShowError, String str2) {
        IronSourceError ironSourceErrorBuildShowFailedError;
        UnityAdsAdapter unityAdsAdapter;
        if (unityAdsShowError != null) {
            WeakReference<UnityAdsAdapter> weakReference = this.mAdapter;
            ironSourceErrorBuildShowFailedError = new IronSourceError((weakReference == null || (unityAdsAdapter = weakReference.get()) == null) ? 510 : unityAdsAdapter.getUnityAdsShowErrorCode(unityAdsShowError), str2);
        } else {
            ironSourceErrorBuildShowFailedError = ErrorBuilder.buildShowFailedError(IronSourceConstants.REWARDED_VIDEO_AD_UNIT, str2);
        }
        IronLog.ADAPTER_CALLBACK.error("placementId = " + this.mPlacementId + " ironSourceError = " + ironSourceErrorBuildShowFailedError);
        RewardedVideoSmashListener rewardedVideoSmashListener = this.mListener;
        if (rewardedVideoSmashListener != null) {
            rewardedVideoSmashListener.onRewardedVideoAdShowFailed(ironSourceErrorBuildShowFailedError);
        }
    }

    @Override // com.unity3d.ads.IUnityAdsShowListener
    public void onUnityAdsShowStart(String str) {
        a.p("placementId = ", this.mPlacementId, IronLog.ADAPTER_CALLBACK);
        RewardedVideoSmashListener rewardedVideoSmashListener = this.mListener;
        if (rewardedVideoSmashListener != null) {
            rewardedVideoSmashListener.onRewardedVideoAdOpened();
        }
        RewardedVideoSmashListener rewardedVideoSmashListener2 = this.mListener;
        if (rewardedVideoSmashListener2 != null) {
            rewardedVideoSmashListener2.onRewardedVideoAdStarted();
        }
    }
}
