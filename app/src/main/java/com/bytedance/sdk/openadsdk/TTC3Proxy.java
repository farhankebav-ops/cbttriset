package com.bytedance.sdk.openadsdk;

import android.content.Context;
import com.bytedance.sdk.openadsdk.api.interstitial.PAGInterstitialAdLoadListener;
import com.bytedance.sdk.openadsdk.api.reward.PAGRewardedAdLoadListener;
import com.bytedance.sdk.openadsdk.component.EO.MY;
import com.bytedance.sdk.openadsdk.component.reward.Bc;
import com.bytedance.sdk.openadsdk.component.reward.Cc;
import com.bytedance.sdk.openadsdk.component.reward.NV;
import com.bytedance.sdk.openadsdk.component.reward.hp;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes3.dex */
public class TTC3Proxy {
    public static void a(Context context) {
        try {
            hp.IlO(context).IlO();
        } catch (Throwable unused) {
        }
        try {
            Cc.IlO(context).IlO();
        } catch (Throwable unused2) {
        }
    }

    public static void loadFull(Context context, AdSlot adSlot, PAGInterstitialAdLoadListener pAGInterstitialAdLoadListener) {
        adSlot.setDurationSlotType(8);
        Cc.IlO(context).IlO(adSlot, new MY(pAGInterstitialAdLoadListener));
    }

    public static void loadReward(Context context, AdSlot adSlot, PAGRewardedAdLoadListener pAGRewardedAdLoadListener) {
        adSlot.setDurationSlotType(7);
        hp.IlO(context).IlO(adSlot, new Bc(pAGRewardedAdLoadListener));
    }

    public static void verityPlayable(String str, int i2, String str2, String str3, String str4) {
        NV.IlO(str, i2, str2, str3, str4);
    }
}
