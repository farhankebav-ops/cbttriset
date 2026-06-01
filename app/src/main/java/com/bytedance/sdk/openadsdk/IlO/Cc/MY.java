package com.bytedance.sdk.openadsdk.IlO.Cc;

import com.bytedance.sdk.openadsdk.api.reward.PAGRewardedAd;
import com.bytedance.sdk.openadsdk.api.reward.PAGRewardedAdLoadListener;
import com.bytedance.sdk.openadsdk.utils.mmj;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes3.dex */
public class MY implements PAGRewardedAdLoadListener {
    private final PAGRewardedAdLoadListener IlO;

    public MY(PAGRewardedAdLoadListener pAGRewardedAdLoadListener) {
        this.IlO = pAGRewardedAdLoadListener;
    }

    @Override // com.bytedance.sdk.openadsdk.api.PAGLoadListener, com.bytedance.sdk.openadsdk.common.vCE
    public void onError(final int i2, final String str) {
        if (this.IlO == null) {
            return;
        }
        if (str == null) {
            str = "Unknown exception.";
        }
        mmj.IlO(new Runnable() { // from class: com.bytedance.sdk.openadsdk.IlO.Cc.MY.1
            @Override // java.lang.Runnable
            public void run() {
                if (MY.this.IlO != null) {
                    MY.this.IlO.onError(i2, str);
                }
            }
        });
    }

    @Override // com.bytedance.sdk.openadsdk.api.PAGLoadListener
    /* JADX INFO: renamed from: IlO, reason: merged with bridge method [inline-methods] */
    public void onAdLoaded(final PAGRewardedAd pAGRewardedAd) {
        if (this.IlO == null) {
            return;
        }
        mmj.IlO(new Runnable() { // from class: com.bytedance.sdk.openadsdk.IlO.Cc.MY.2
            @Override // java.lang.Runnable
            public void run() {
                if (MY.this.IlO != null) {
                    MY.this.IlO.onAdLoaded(pAGRewardedAd);
                }
            }
        });
    }
}
