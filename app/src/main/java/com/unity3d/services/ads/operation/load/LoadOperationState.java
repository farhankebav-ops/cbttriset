package com.unity3d.services.ads.operation.load;

import androidx.camera.core.processing.c;
import com.unity3d.ads.IUnityAdsLoadListener;
import com.unity3d.ads.UnityAds;
import com.unity3d.ads.UnityAdsLoadOptions;
import com.unity3d.services.ads.operation.OperationState;
import com.unity3d.services.core.configuration.Configuration;
import com.unity3d.services.core.misc.Utilities;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes5.dex */
public class LoadOperationState extends OperationState {
    public IUnityAdsLoadListener listener;
    public UnityAdsLoadOptions loadOptions;

    public LoadOperationState(String str, IUnityAdsLoadListener iUnityAdsLoadListener, UnityAdsLoadOptions unityAdsLoadOptions, Configuration configuration) {
        super(str, configuration);
        this.listener = iUnityAdsLoadListener;
        this.loadOptions = unityAdsLoadOptions;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$onUnityAdsAdLoaded$1() {
        this.listener.onUnityAdsAdLoaded(this.placementId);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$onUnityAdsFailedToLoad$0(UnityAds.UnityAdsLoadError unityAdsLoadError, String str) {
        this.listener.onUnityAdsFailedToLoad(this.placementId, unityAdsLoadError, str);
    }

    public boolean isBanner() {
        return this instanceof LoadBannerOperationState;
    }

    public boolean isHeaderBidding() {
        UnityAdsLoadOptions unityAdsLoadOptions = this.loadOptions;
        if (unityAdsLoadOptions == null || unityAdsLoadOptions.getData() == null) {
            return false;
        }
        return this.loadOptions.getData().has("adMarkup");
    }

    public void onUnityAdsAdLoaded() {
        if (this.listener != null) {
            Utilities.wrapCustomerListener(new a(this, 1));
        }
    }

    public void onUnityAdsFailedToLoad(UnityAds.UnityAdsLoadError unityAdsLoadError, String str) {
        if (this.listener != null) {
            Utilities.wrapCustomerListener(new c(this, unityAdsLoadError, str, 27));
        }
    }
}
