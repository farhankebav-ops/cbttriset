package com.bytedance.sdk.openadsdk.bWL;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import com.bytedance.sdk.openadsdk.core.widget.PAGLogoView;
import com.bytedance.sdk.openadsdk.utils.BS;
import com.bytedance.sdk.openadsdk.utils.zPa;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes3.dex */
public class IlO extends NV {
    public IlO(Context context) {
        this(context, null);
    }

    @Override // com.bytedance.sdk.openadsdk.bWL.NV
    public void IlO(Context context) {
        com.bytedance.sdk.openadsdk.core.Cc.Cc cc = new com.bytedance.sdk.openadsdk.core.Cc.Cc(context);
        cc.setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
        cc.setOrientation(1);
        addView(cc);
        com.bytedance.sdk.openadsdk.core.Cc.EO eo = new com.bytedance.sdk.openadsdk.core.Cc.EO(context);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, 0);
        layoutParams.weight = 337.0f;
        eo.setLayoutParams(layoutParams);
        cc.addView(eo);
        com.bytedance.sdk.openadsdk.core.Cc.EO eoCc = Cc(context);
        this.IlO = eoCc;
        eoCc.setId(zPa.Aw);
        this.IlO.setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
        eo.addView(this.IlO);
        com.bytedance.sdk.openadsdk.core.Cc.tV tVVarVCE = vCE(context);
        this.MY = tVVarVCE;
        tVVarVCE.setId(zPa.La);
        this.MY.setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
        eo.addView(this.MY);
        PAGLogoView pAGLogoViewLEW = lEW(context);
        FrameLayout.LayoutParams layoutParams2 = new FrameLayout.LayoutParams(-2, -2);
        layoutParams2.gravity = 80;
        int iMY = BS.MY(context, 10.0f);
        layoutParams2.leftMargin = iMY;
        layoutParams2.topMargin = iMY;
        layoutParams2.bottomMargin = iMY;
        pAGLogoViewLEW.setLayoutParams(layoutParams2);
        eo.addView(pAGLogoViewLEW);
        com.bytedance.sdk.openadsdk.core.Cc.Cc cc2 = new com.bytedance.sdk.openadsdk.core.Cc.Cc(context);
        LinearLayout.LayoutParams layoutParams3 = new LinearLayout.LayoutParams(-1, 0);
        layoutParams3.weight = 263.0f;
        cc2.setLayoutParams(layoutParams3);
        cc2.setOrientation(1);
        int iMY2 = BS.MY(context, 16.0f);
        cc2.setPadding(iMY2, iMY2, iMY2, iMY2);
        cc.addView(cc2);
        com.bytedance.sdk.openadsdk.core.Cc.Bc bc = new com.bytedance.sdk.openadsdk.core.Cc.Bc(context);
        bc.setLayoutParams(new LinearLayout.LayoutParams(-2, -2));
        cc2.addView(bc);
        com.bytedance.sdk.openadsdk.core.widget.zPa zpaBc = Bc(context);
        this.EO = zpaBc;
        zpaBc.setId(zPa.OW);
        int iMY3 = BS.MY(context, 45.0f);
        RelativeLayout.LayoutParams layoutParams4 = new RelativeLayout.LayoutParams(iMY3, iMY3);
        layoutParams4.rightMargin = iMY;
        layoutParams4.setMarginEnd(iMY);
        this.EO.setLayoutParams(layoutParams4);
        bc.addView(this.EO);
        com.bytedance.sdk.openadsdk.core.Cc.lEW lewMY = MY(context);
        this.tV = lewMY;
        lewMY.setId(zPa.eeU);
        RelativeLayout.LayoutParams layoutParams5 = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams5.addRule(1, this.EO.getId());
        layoutParams5.addRule(17, this.EO.getId());
        this.tV.setLayoutParams(layoutParams5);
        bc.addView(this.tV);
        com.bytedance.sdk.openadsdk.core.Cc.lEW lewEO = EO(context);
        this.Cc = lewEO;
        lewEO.setId(zPa.BES);
        RelativeLayout.LayoutParams layoutParams6 = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams6.addRule(3, this.tV.getId());
        layoutParams6.addRule(1, this.EO.getId());
        layoutParams6.addRule(17, this.EO.getId());
        this.Cc.setLayoutParams(layoutParams6);
        bc.addView(this.Cc);
        com.bytedance.sdk.openadsdk.core.Cc.lEW lewTV = tV(context);
        this.vCE = lewTV;
        lewTV.setId(zPa.tf);
        LinearLayout.LayoutParams layoutParams7 = new LinearLayout.LayoutParams(-1, BS.MY(context, 32.0f));
        layoutParams7.topMargin = iMY2;
        this.vCE.setLayoutParams(layoutParams7);
        cc2.addView(this.vCE);
    }

    public IlO(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public IlO(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
    }
}
