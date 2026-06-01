package com.bytedance.sdk.openadsdk.IlO.MY;

import com.bytedance.sdk.openadsdk.api.nativeAd.PAGNativeAd;
import com.bytedance.sdk.openadsdk.api.nativeAd.PAGNativeAdInteractionListener;
import com.bytedance.sdk.openadsdk.utils.mmj;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes3.dex */
public class Bc implements vCE {
    private final PAGNativeAdInteractionListener IlO;

    public Bc(PAGNativeAdInteractionListener pAGNativeAdInteractionListener) {
        this.IlO = pAGNativeAdInteractionListener;
    }

    @Override // com.bytedance.sdk.openadsdk.IlO.MY.vCE
    public boolean MY() {
        return this.IlO != null;
    }

    @Override // com.bytedance.sdk.openadsdk.api.PAGAdWrapperListener
    public void onAdClicked() {
        mmj.IlO(new Runnable() { // from class: com.bytedance.sdk.openadsdk.IlO.MY.Bc.1
            @Override // java.lang.Runnable
            public void run() {
                if (Bc.this.IlO != null) {
                    Bc.this.IlO.onAdClicked();
                }
            }
        });
    }

    @Override // com.bytedance.sdk.openadsdk.IlO.MY.vCE
    public void IlO(PAGNativeAd pAGNativeAd) {
        mmj.IlO(new Runnable() { // from class: com.bytedance.sdk.openadsdk.IlO.MY.Bc.2
            @Override // java.lang.Runnable
            public void run() {
                if (Bc.this.IlO != null) {
                    Bc.this.IlO.onAdShowed();
                }
            }
        });
    }

    @Override // com.bytedance.sdk.openadsdk.IlO.MY.vCE
    public void IlO() {
        mmj.IlO(new Runnable() { // from class: com.bytedance.sdk.openadsdk.IlO.MY.Bc.3
            @Override // java.lang.Runnable
            public void run() {
                if (Bc.this.IlO != null) {
                    Bc.this.IlO.onAdDismissed();
                }
            }
        });
    }
}
