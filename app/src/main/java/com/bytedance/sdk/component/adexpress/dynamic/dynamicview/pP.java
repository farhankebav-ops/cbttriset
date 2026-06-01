package com.bytedance.sdk.component.adexpress.dynamic.dynamicview;

import android.content.Context;
import android.widget.FrameLayout;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes3.dex */
public class pP extends vCE {
    private int IlO;

    public pP(Context context, DynamicRootView dynamicRootView, com.bytedance.sdk.component.adexpress.dynamic.tV.lEW lew) {
        super(context, dynamicRootView, lew);
        this.IlO = 0;
        com.bytedance.sdk.component.adexpress.vCE.pP pPVar = new com.bytedance.sdk.component.adexpress.vCE.pP(context, null);
        this.ea = pPVar;
        pPVar.setTag(Integer.valueOf(getClickArea()));
        addView(this.ea, getWidgetLayoutParams());
    }

    @Override // com.bytedance.sdk.component.adexpress.dynamic.dynamicview.vCE, com.bytedance.sdk.component.adexpress.dynamic.dynamicview.YA
    public boolean DmF() {
        DynamicRootView dynamicRootView;
        super.DmF();
        double dHp = this.rp.hp();
        if (com.bytedance.sdk.component.adexpress.tV.MY() && (dHp < 0.0d || dHp > 5.0d || ((dynamicRootView = this.bWL) != null && dynamicRootView.getRenderRequest() != null && this.bWL.getRenderRequest().NV() != 4))) {
            this.ea.setVisibility(8);
            return true;
        }
        double d8 = (dHp < 0.0d || dHp > 5.0d) ? 5.0d : dHp;
        this.ea.setVisibility(0);
        ((com.bytedance.sdk.component.adexpress.vCE.pP) this.ea).IlO(d8, this.rp.Bc(), (int) this.rp.Cc(), ((int) com.bytedance.sdk.component.adexpress.tV.Bc.IlO(this.EV, this.rp.MY())) + ((int) com.bytedance.sdk.component.adexpress.tV.Bc.IlO(this.EV, this.rp.IlO())) + ((int) com.bytedance.sdk.component.adexpress.tV.Bc.IlO(this.EV, this.rp.Cc())));
        return true;
    }

    @Override // com.bytedance.sdk.component.adexpress.dynamic.dynamicview.vCE
    public FrameLayout.LayoutParams getWidgetLayoutParams() {
        int iIlO = (int) (com.bytedance.sdk.component.adexpress.tV.Bc.IlO(com.bytedance.sdk.component.adexpress.tV.IlO(), com.bytedance.sdk.component.adexpress.tV.Bc.IlO(com.bytedance.sdk.component.adexpress.tV.IlO(), this.rp.tV()) + this.rp.EO()) + (com.bytedance.sdk.component.adexpress.tV.Bc.IlO(com.bytedance.sdk.component.adexpress.tV.IlO(), this.rp.Cc()) * 5.0f));
        if (this.Bc > iIlO && 4 == this.rp.lEW()) {
            this.IlO = (this.Bc - iIlO) / 2;
        }
        this.Bc = iIlO;
        return new FrameLayout.LayoutParams(this.Bc, this.lEW);
    }

    @Override // com.bytedance.sdk.component.adexpress.dynamic.dynamicview.Cc
    public void vCE() {
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(this.Bc, this.lEW);
        layoutParams.topMargin = this.NV;
        int i2 = this.DmF + this.IlO;
        layoutParams.leftMargin = i2;
        layoutParams.setMarginStart(i2);
        layoutParams.setMarginEnd(layoutParams.rightMargin);
        setLayoutParams(layoutParams);
    }
}
