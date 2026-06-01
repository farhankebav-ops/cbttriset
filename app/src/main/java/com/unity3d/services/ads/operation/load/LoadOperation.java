package com.unity3d.services.ads.operation.load;

import com.unity3d.ads.UnityAds;
import com.unity3d.services.ads.operation.AdOperation;
import com.unity3d.services.core.misc.Utilities;
import com.unity3d.services.core.webview.bridge.invocation.IWebViewBridgeInvocation;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes5.dex */
public class LoadOperation extends AdOperation implements ILoadOperation {
    private LoadOperationState _loadOperationState;

    public LoadOperation(LoadOperationState loadOperationState, IWebViewBridgeInvocation iWebViewBridgeInvocation) {
        super(iWebViewBridgeInvocation, "load");
        this._loadOperationState = loadOperationState;
    }

    @Override // com.unity3d.services.core.webview.bridge.IWebViewSharedObject
    public String getId() {
        return this._loadOperationState.id;
    }

    @Override // com.unity3d.services.ads.operation.load.ILoadOperation
    public LoadOperationState getLoadOperationState() {
        return this._loadOperationState;
    }

    @Override // com.unity3d.ads.IUnityAdsLoadListener
    public void onUnityAdsAdLoaded(String str) {
        LoadOperationState loadOperationState = this._loadOperationState;
        if (loadOperationState == null || loadOperationState.listener == null || str == null) {
            return;
        }
        Utilities.runOnUiThread(new Runnable() { // from class: com.unity3d.services.ads.operation.load.LoadOperation.1
            @Override // java.lang.Runnable
            public void run() {
                if (LoadOperation.this._loadOperationState != null) {
                    LoadOperation.this._loadOperationState.onUnityAdsAdLoaded();
                }
            }
        });
    }

    @Override // com.unity3d.ads.IUnityAdsLoadListener
    public void onUnityAdsFailedToLoad(String str, final UnityAds.UnityAdsLoadError unityAdsLoadError, final String str2) {
        LoadOperationState loadOperationState = this._loadOperationState;
        if (loadOperationState == null || loadOperationState.listener == null || str == null) {
            return;
        }
        Utilities.runOnUiThread(new Runnable() { // from class: com.unity3d.services.ads.operation.load.LoadOperation.2
            @Override // java.lang.Runnable
            public void run() {
                if (LoadOperation.this._loadOperationState != null) {
                    LoadOperation.this._loadOperationState.onUnityAdsFailedToLoad(unityAdsLoadError, str2);
                }
            }
        });
    }
}
