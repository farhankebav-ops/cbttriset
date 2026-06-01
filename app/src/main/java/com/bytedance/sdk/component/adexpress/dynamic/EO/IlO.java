package com.bytedance.sdk.component.adexpress.dynamic.EO;

import android.content.Context;
import android.view.ViewGroup;
import android.widget.FrameLayout;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes3.dex */
public class IlO implements Bc {
    private com.bytedance.sdk.component.adexpress.vCE.MY IlO;

    public IlO(Context context, com.bytedance.sdk.component.adexpress.dynamic.dynamicview.Cc cc, com.bytedance.sdk.component.adexpress.dynamic.tV.Bc bc) {
        double dPFe = bc.pFe();
        dPFe = dPFe == 0.0d ? 1.0d : dPFe;
        double dHg = bc.Hg();
        double d8 = dHg != 0.0d ? dHg : 1.0d;
        int dynamicWidth = (int) (((double) cc.getDynamicWidth()) * 0.32d * dPFe);
        int dynamicWidth2 = (int) (((double) cc.getDynamicWidth()) * 0.32d * d8);
        this.IlO = new com.bytedance.sdk.component.adexpress.vCE.MY(context, dynamicWidth, dynamicWidth2);
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(dynamicWidth, dynamicWidth2);
        layoutParams.gravity = 17;
        layoutParams.topMargin = (int) com.bytedance.sdk.component.adexpress.tV.Bc.IlO(context, bc.HTA() - 7);
        layoutParams.leftMargin = (int) com.bytedance.sdk.component.adexpress.tV.Bc.IlO(context, bc.Tx() - 3);
        this.IlO.setLayoutParams(layoutParams);
    }

    @Override // com.bytedance.sdk.component.adexpress.dynamic.EO.Bc
    public ViewGroup EO() {
        return this.IlO;
    }

    @Override // com.bytedance.sdk.component.adexpress.dynamic.EO.Bc
    public void IlO() {
        this.IlO.IlO();
    }

    @Override // com.bytedance.sdk.component.adexpress.dynamic.EO.Bc
    public void MY() {
        this.IlO.MY();
    }
}
