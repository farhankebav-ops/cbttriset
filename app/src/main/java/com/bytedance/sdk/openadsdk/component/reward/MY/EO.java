package com.bytedance.sdk.openadsdk.component.reward.MY;

import android.content.Context;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import com.bytedance.sdk.openadsdk.core.model.es;
import com.bytedance.sdk.openadsdk.core.model.oeT;
import com.bytedance.sdk.openadsdk.utils.BS;
import com.bytedance.sdk.openadsdk.utils.zPa;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes3.dex */
public class EO extends MY {
    public EO(com.bytedance.sdk.openadsdk.component.reward.IlO.IlO ilO) {
        super(ilO);
    }

    private void MY(com.bytedance.sdk.openadsdk.component.reward.view.Bc bc) {
        if (bc == null) {
            return;
        }
        Context context = bc.getContext();
        com.bytedance.sdk.openadsdk.core.Cc.Cc cc = new com.bytedance.sdk.openadsdk.core.Cc.Cc(context);
        cc.setOrientation(1);
        bc.addView(cc, new FrameLayout.LayoutParams(-1, -1));
        com.bytedance.sdk.openadsdk.core.Cc.EO eo = new com.bytedance.sdk.openadsdk.core.Cc.EO(context);
        eo.setId(zPa.nvX);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, 0);
        layoutParams.weight = 100.0f;
        cc.addView(eo, layoutParams);
        com.bytedance.sdk.openadsdk.core.Cc.EO eo2 = new com.bytedance.sdk.openadsdk.core.Cc.EO(context);
        eo2.setId(zPa.NV);
        FrameLayout.LayoutParams layoutParams2 = new FrameLayout.LayoutParams(-1, -1);
        layoutParams2.gravity = 17;
        eo.addView(eo2, layoutParams2);
        eo2.addView(MY.IlO(context));
        if (this.MY.uI() != 3 && this.MY.uI() != 5) {
            com.bytedance.sdk.openadsdk.core.Cc.tV tVVar = new com.bytedance.sdk.openadsdk.core.Cc.tV(context);
            tVVar.setId(zPa.TkD);
            tVVar.setVisibility(8);
            tVVar.setBackground(com.bytedance.sdk.openadsdk.core.widget.tV.IlO());
            FrameLayout.LayoutParams layoutParams3 = new FrameLayout.LayoutParams(BS.MY(context, 28.0f), BS.MY(context, 28.0f));
            layoutParams3.gravity = 8388693;
            layoutParams3.rightMargin = BS.MY(context, 20.0f);
            layoutParams3.bottomMargin = BS.MY(context, 10.0f);
            eo.addView(tVVar, layoutParams3);
        }
        com.bytedance.sdk.openadsdk.core.Cc.EO eo3 = new com.bytedance.sdk.openadsdk.core.Cc.EO(context);
        eo3.setId(zPa.xF);
        LinearLayout.LayoutParams layoutParams4 = new LinearLayout.LayoutParams(-1, 0);
        layoutParams4.weight = 0.0f;
        cc.addView(eo3, layoutParams4);
        eo3.addView(tV.IlO(context, this.IlO.MY));
        com.bytedance.sdk.openadsdk.component.reward.view.tV.IlO(eo3, this.MY);
        com.bytedance.sdk.openadsdk.component.reward.view.tV.IlO(eo);
    }

    @Override // com.bytedance.sdk.openadsdk.component.reward.MY.MY
    public boolean Cc() {
        return false;
    }

    @Override // com.bytedance.sdk.openadsdk.component.reward.MY.MY
    public void IlO(FrameLayout frameLayout) {
    }

    @Override // com.bytedance.sdk.openadsdk.component.reward.MY.MY
    public boolean vCE() {
        return true;
    }

    public static boolean IlO(oeT oet) {
        es.EO(oet);
        return es.EO(oet);
    }

    @Override // com.bytedance.sdk.openadsdk.component.reward.MY.MY
    public void IlO(com.bytedance.sdk.openadsdk.component.reward.view.Bc bc) {
        MY(bc);
    }

    @Override // com.bytedance.sdk.openadsdk.component.reward.MY.MY
    public void Bc() {
    }
}
