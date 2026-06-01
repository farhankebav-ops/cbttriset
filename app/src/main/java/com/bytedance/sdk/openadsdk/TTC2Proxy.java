package com.bytedance.sdk.openadsdk;

import android.content.Context;
import com.bytedance.sdk.openadsdk.api.open.PAGAppOpenAdLoadListener;
import com.bytedance.sdk.openadsdk.component.Bc;
import com.bytedance.sdk.openadsdk.component.Bc.IlO;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes3.dex */
public class TTC2Proxy {
    private TTC2Proxy() {
    }

    public static void a(Context context) {
        IlO.IlO(context);
    }

    public static void load(Context context, AdSlot adSlot, PAGAppOpenAdLoadListener pAGAppOpenAdLoadListener, int i2) {
        adSlot.setDurationSlotType(3);
        Bc.IlO(context).IlO(adSlot, pAGAppOpenAdLoadListener, i2);
    }
}
