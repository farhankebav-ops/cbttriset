package com.unity3d.services.ads.operation.load;

import com.unity3d.ads.IUnityAdsLoadListener;
import com.unity3d.ads.UnityAdsLoadOptions;
import com.unity3d.services.banners.UnityBannerSize;
import com.unity3d.services.core.configuration.Configuration;
import u3.c;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes5.dex */
public class LoadBannerOperationState extends LoadOperationState {
    private c _scarAdMetadata;
    private UnityBannerSize _size;

    public LoadBannerOperationState(String str, String str2, UnityBannerSize unityBannerSize, IUnityAdsLoadListener iUnityAdsLoadListener, UnityAdsLoadOptions unityAdsLoadOptions, Configuration configuration) {
        super(str, iUnityAdsLoadListener, unityAdsLoadOptions, configuration);
        this.id = str2;
        this._size = unityBannerSize;
    }

    public c getScarAdMetadata() {
        return this._scarAdMetadata;
    }

    public UnityBannerSize getSize() {
        return this._size;
    }

    public boolean isScarAd() {
        return this._scarAdMetadata != null;
    }

    public void setScarAdMetadata(c cVar) {
        this._scarAdMetadata = cVar;
    }

    public void setSize(UnityBannerSize unityBannerSize) {
        this._size = unityBannerSize;
    }
}
