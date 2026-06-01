package com.bytedance.sdk.openadsdk.component.reward;

import android.content.Context;
import com.bytedance.sdk.openadsdk.TTClientBidding;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes3.dex */
class bWL implements TTClientBidding {
    private final vCE IlO;

    public bWL(Context context, com.bytedance.sdk.openadsdk.core.model.IlO ilO) {
        this.IlO = new vCE(context, ilO);
    }

    public vCE IlO() {
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

    public void IlO(boolean z2) {
        this.IlO.IlO(z2);
    }
}
