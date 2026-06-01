package com.bytedance.sdk.component.adexpress.dynamic.EO;

import android.content.Context;
import android.widget.FrameLayout;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes3.dex */
public class bWL implements Bc<com.bytedance.sdk.component.adexpress.vCE.zPa> {
    private com.bytedance.sdk.component.adexpress.vCE.zPa IlO;

    public bWL(Context context, com.bytedance.sdk.component.adexpress.dynamic.dynamicview.Cc cc, com.bytedance.sdk.component.adexpress.dynamic.tV.Bc bc) {
        this.IlO = new com.bytedance.sdk.component.adexpress.vCE.zPa(context);
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams((int) com.bytedance.sdk.component.adexpress.tV.Bc.IlO(context, 180.0f), (int) com.bytedance.sdk.component.adexpress.tV.Bc.IlO(context, 180.0f));
        layoutParams.gravity = 17;
        layoutParams.leftMargin = (int) com.bytedance.sdk.component.adexpress.tV.Bc.IlO(context, 20.0f);
        this.IlO.setLayoutParams(layoutParams);
        this.IlO.setGuideText(bc.fdM());
    }

    @Override // com.bytedance.sdk.component.adexpress.dynamic.EO.Bc
    public void IlO() {
        this.IlO.IlO();
    }

    @Override // com.bytedance.sdk.component.adexpress.dynamic.EO.Bc
    public void MY() {
        this.IlO.MY();
    }

    @Override // com.bytedance.sdk.component.adexpress.dynamic.EO.Bc
    /* JADX INFO: renamed from: tV, reason: merged with bridge method [inline-methods] */
    public com.bytedance.sdk.component.adexpress.vCE.zPa EO() {
        return this.IlO;
    }
}
