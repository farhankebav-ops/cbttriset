package com.ironsource.adapters.unityads;

import com.google.android.gms.ads.internal.client.a;
import com.ironsource.mediationsdk.logger.IronLog;
import com.ironsource.mediationsdk.logger.IronSourceError;
import com.ironsource.mediationsdk.sdk.InterstitialSmashListener;
import com.ironsource.mediationsdk.utils.ErrorBuilder;
import com.unity3d.ads.IUnityAdsLoadListener;
import com.unity3d.ads.IUnityAdsShowListener;
import com.unity3d.ads.UnityAds;
import java.lang.ref.WeakReference;
import kotlin.jvm.internal.k;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes5.dex */
public final class UnityAdsInterstitialAdListener implements IUnityAdsLoadListener, IUnityAdsShowListener {
    private final WeakReference<UnityAdsAdapter> mAdapter;
    private final InterstitialSmashListener mListener;
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

    public UnityAdsInterstitialAdListener(InterstitialSmashListener interstitialSmashListener, WeakReference<UnityAdsAdapter> weakReference, String mPlacementId) {
        k.e(mPlacementId, "mPlacementId");
        this.mListener = interstitialSmashListener;
        this.mAdapter = weakReference;
        this.mPlacementId = mPlacementId;
    }

    @Override // com.unity3d.ads.IUnityAdsLoadListener
    public void onUnityAdsAdLoaded(String str) {
        UnityAdsAdapter unityAdsAdapter;
        a.p("placementId = ", this.mPlacementId, IronLog.ADAPTER_CALLBACK);
        WeakReference<UnityAdsAdapter> weakReference = this.mAdapter;
        if (weakReference != null && (unityAdsAdapter = weakReference.get()) != null) {
            unityAdsAdapter.setInterstitialAdAvailability$unityadsadapter_release(this.mPlacementId, true);
        }
        InterstitialSmashListener interstitialSmashListener = this.mListener;
        if (interstitialSmashListener != null) {
            interstitialSmashListener.onInterstitialAdReady();
        }
    }

    @Override // com.unity3d.ads.IUnityAdsLoadListener
    public void onUnityAdsFailedToLoad(String str, UnityAds.UnityAdsLoadError unityAdsLoadError, String str2) {
        IronSourceError ironSourceErrorBuildLoadFailedError;
        UnityAdsAdapter unityAdsAdapter;
        int unityAdsLoadErrorCode;
        UnityAdsAdapter unityAdsAdapter2;
        UnityAdsAdapter unityAdsAdapter3;
        WeakReference<UnityAdsAdapter> weakReference = this.mAdapter;
        if (weakReference != null && (unityAdsAdapter3 = weakReference.get()) != null) {
            unityAdsAdapter3.setInterstitialAdAvailability$unityadsadapter_release(this.mPlacementId, false);
        }
        if (unityAdsLoadError != null) {
            if (unityAdsLoadError == UnityAds.UnityAdsLoadError.NO_FILL) {
                unityAdsLoadErrorCode = 1158;
            } else {
                WeakReference<UnityAdsAdapter> weakReference2 = this.mAdapter;
                unityAdsLoadErrorCode = (weakReference2 == null || (unityAdsAdapter2 = weakReference2.get()) == null) ? 510 : unityAdsAdapter2.getUnityAdsLoadErrorCode(unityAdsLoadError);
            }
            ironSourceErrorBuildLoadFailedError = new IronSourceError(unityAdsLoadErrorCode, str2);
        } else {
            WeakReference<UnityAdsAdapter> weakReference3 = this.mAdapter;
            ironSourceErrorBuildLoadFailedError = ErrorBuilder.buildLoadFailedError("Interstitial", (weakReference3 == null || (unityAdsAdapter = weakReference3.get()) == null) ? null : unityAdsAdapter.getProviderName(), str2);
            k.d(ironSourceErrorBuildLoadFailedError, "{\n      ErrorBuilder.bui…me, message\n      )\n    }");
        }
        IronLog.ADAPTER_CALLBACK.error("placementId = " + this.mPlacementId + " ironSourceError = " + ironSourceErrorBuildLoadFailedError);
        InterstitialSmashListener interstitialSmashListener = this.mListener;
        if (interstitialSmashListener != null) {
            interstitialSmashListener.onInterstitialAdLoadFailed(ironSourceErrorBuildLoadFailedError);
        }
    }

    @Override // com.unity3d.ads.IUnityAdsShowListener
    public void onUnityAdsShowClick(String str) {
        a.p("placementId = ", this.mPlacementId, IronLog.ADAPTER_CALLBACK);
        InterstitialSmashListener interstitialSmashListener = this.mListener;
        if (interstitialSmashListener != null) {
            interstitialSmashListener.onInterstitialAdClicked();
        }
    }

    @Override // com.unity3d.ads.IUnityAdsShowListener
    public void onUnityAdsShowComplete(String str, UnityAds.UnityAdsShowCompletionState unityAdsShowCompletionState) {
        InterstitialSmashListener interstitialSmashListener;
        IronLog.ADAPTER_CALLBACK.verbose("placementId = " + this.mPlacementId + " completionState = " + unityAdsShowCompletionState);
        int i2 = unityAdsShowCompletionState == null ? -1 : WhenMappings.$EnumSwitchMapping$0[unityAdsShowCompletionState.ordinal()];
        if ((i2 == 1 || i2 == 2) && (interstitialSmashListener = this.mListener) != null) {
            interstitialSmashListener.onInterstitialAdClosed();
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
            ironSourceErrorBuildShowFailedError = ErrorBuilder.buildShowFailedError("Interstitial", str2);
        }
        IronLog.ADAPTER_CALLBACK.error("placementId = " + this.mPlacementId + " ironSourceError = " + ironSourceErrorBuildShowFailedError);
        InterstitialSmashListener interstitialSmashListener = this.mListener;
        if (interstitialSmashListener != null) {
            interstitialSmashListener.onInterstitialAdShowFailed(ironSourceErrorBuildShowFailedError);
        }
    }

    @Override // com.unity3d.ads.IUnityAdsShowListener
    public void onUnityAdsShowStart(String str) {
        a.p("placementId = ", this.mPlacementId, IronLog.ADAPTER_CALLBACK);
        InterstitialSmashListener interstitialSmashListener = this.mListener;
        if (interstitialSmashListener != null) {
            interstitialSmashListener.onInterstitialAdOpened();
        }
        InterstitialSmashListener interstitialSmashListener2 = this.mListener;
        if (interstitialSmashListener2 != null) {
            interstitialSmashListener2.onInterstitialAdShowSucceeded();
        }
    }
}
