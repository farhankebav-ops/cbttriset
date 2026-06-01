package com.bytedance.sdk.openadsdk.component.reward;

import android.content.Context;
import com.bytedance.sdk.openadsdk.AdSlot;
import com.bytedance.sdk.openadsdk.TTClientBidding;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes3.dex */
class ea implements TTClientBidding {
    private final lEW IlO;

    public ea(Context context, com.bytedance.sdk.openadsdk.core.model.IlO ilO, AdSlot adSlot) {
        this.IlO = new lEW(context, ilO, adSlot);
    }

    public lEW IlO() {
        return this.IlO;
    }

    public void MY() {
        this.IlO.IlO();
    }

    @Override // com.bytedance.sdk.openadsdk.TTClientBidding
    public void loss(Double d8, String str, String str2) {
        this.IlO.loss(d8, str, str2);
    }

    @Override // com.bytedance.sdk.openadsdk.TTClientBidding
    public void win(Double d8) {
        this.IlO.win(d8);
    }
}
