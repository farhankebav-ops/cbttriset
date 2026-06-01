package com.bytedance.sdk.openadsdk.component.reward;

import com.bytedance.sdk.openadsdk.api.model.PAGErrorModel;
import com.bytedance.sdk.openadsdk.api.reward.PAGRewardItem;
import com.bytedance.sdk.openadsdk.api.reward.PAGRewardedAdInteractionCallback;
import com.bytedance.sdk.openadsdk.api.reward.PAGRewardedAdInteractionListener;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes3.dex */
public class DmF implements com.bytedance.sdk.openadsdk.IlO.Cc.IlO {
    private final PAGRewardedAdInteractionListener IlO;
    private final PAGRewardedAdInteractionCallback MY;

    public DmF(PAGRewardedAdInteractionListener pAGRewardedAdInteractionListener) {
        this.IlO = pAGRewardedAdInteractionListener;
        this.MY = null;
    }

    @Override // com.bytedance.sdk.openadsdk.IlO.Cc.IlO
    public void IlO() {
        PAGRewardedAdInteractionListener pAGRewardedAdInteractionListener = this.IlO;
        if (pAGRewardedAdInteractionListener != null) {
            pAGRewardedAdInteractionListener.onAdShowed();
            return;
        }
        PAGRewardedAdInteractionCallback pAGRewardedAdInteractionCallback = this.MY;
        if (pAGRewardedAdInteractionCallback != null) {
            pAGRewardedAdInteractionCallback.onAdShowed();
        }
    }

    @Override // com.bytedance.sdk.openadsdk.IlO.Cc.IlO
    public void MY() {
        PAGRewardedAdInteractionListener pAGRewardedAdInteractionListener = this.IlO;
        if (pAGRewardedAdInteractionListener != null) {
            pAGRewardedAdInteractionListener.onAdDismissed();
            return;
        }
        PAGRewardedAdInteractionCallback pAGRewardedAdInteractionCallback = this.MY;
        if (pAGRewardedAdInteractionCallback != null) {
            pAGRewardedAdInteractionCallback.onAdDismissed();
        }
    }

    @Override // com.bytedance.sdk.openadsdk.api.PAGAdWrapperListener
    public void onAdClicked() {
        PAGRewardedAdInteractionListener pAGRewardedAdInteractionListener = this.IlO;
        if (pAGRewardedAdInteractionListener != null) {
            pAGRewardedAdInteractionListener.onAdClicked();
            return;
        }
        PAGRewardedAdInteractionCallback pAGRewardedAdInteractionCallback = this.MY;
        if (pAGRewardedAdInteractionCallback != null) {
            pAGRewardedAdInteractionCallback.onAdClicked();
        }
    }

    public DmF(PAGRewardedAdInteractionCallback pAGRewardedAdInteractionCallback) {
        this.MY = pAGRewardedAdInteractionCallback;
        this.IlO = null;
    }

    @Override // com.bytedance.sdk.openadsdk.IlO.Cc.IlO
    public void IlO(boolean z2, int i2, String str, int i8, String str2) {
        PAGRewardedAdInteractionListener pAGRewardedAdInteractionListener = this.IlO;
        if (pAGRewardedAdInteractionListener != null) {
            if (z2) {
                pAGRewardedAdInteractionListener.onUserEarnedReward(new PAGRewardItem(i2, str));
                return;
            } else {
                pAGRewardedAdInteractionListener.onUserEarnedRewardFail(i8, str2);
                return;
            }
        }
        PAGRewardedAdInteractionCallback pAGRewardedAdInteractionCallback = this.MY;
        if (pAGRewardedAdInteractionCallback != null) {
            if (z2) {
                pAGRewardedAdInteractionCallback.onUserEarnedReward(new PAGRewardItem(i2, str));
            } else {
                pAGRewardedAdInteractionCallback.onUserEarnedRewardFail(new PAGErrorModel(i8, str2));
            }
        }
    }
}
