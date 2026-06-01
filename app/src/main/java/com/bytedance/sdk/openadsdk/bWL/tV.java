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
public class tV extends NV {
    public tV(Context context) {
        this(context, null);
    }

    @Override // com.bytedance.sdk.openadsdk.bWL.NV
    public void IlO(Context context) {
        int iMY = BS.MY(context, 10.0f);
        com.bytedance.sdk.openadsdk.core.Cc.Cc cc = new com.bytedance.sdk.openadsdk.core.Cc.Cc(context);
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -1);
        cc.setLayoutParams(layoutParams);
        layoutParams.gravity = 17;
        cc.setOrientation(1);
        cc.setPadding(iMY, iMY, iMY, iMY);
        addView(cc);
        com.bytedance.sdk.openadsdk.core.Cc.EO eo = new com.bytedance.sdk.openadsdk.core.Cc.EO(context);
        LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(-1, 0);
        layoutParams2.weight = 3.0f;
        eo.setLayoutParams(layoutParams2);
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
        FrameLayout.LayoutParams layoutParams3 = new FrameLayout.LayoutParams(-2, -2);
        layoutParams3.gravity = 80;
        layoutParams3.leftMargin = iMY;
        layoutParams3.topMargin = iMY;
        layoutParams3.bottomMargin = iMY;
        pAGLogoViewLEW.setLayoutParams(layoutParams3);
        eo.addView(pAGLogoViewLEW);
        com.bytedance.sdk.openadsdk.core.Cc.Bc bc = new com.bytedance.sdk.openadsdk.core.Cc.Bc(context);
        LinearLayout.LayoutParams layoutParams4 = new LinearLayout.LayoutParams(-1, 0);
        layoutParams4.weight = 1.0f;
        bc.setLayoutParams(layoutParams4);
        cc.addView(bc);
        com.bytedance.sdk.openadsdk.core.widget.zPa zpaBc = Bc(context);
        this.EO = zpaBc;
        int i2 = zPa.OW;
        zpaBc.setId(i2);
        int iMY2 = BS.MY(context, 40.0f);
        RelativeLayout.LayoutParams layoutParams5 = new RelativeLayout.LayoutParams(iMY2, iMY2);
        layoutParams5.addRule(15);
        this.EO.setLayoutParams(layoutParams5);
        bc.addView(this.EO);
        com.bytedance.sdk.openadsdk.core.Cc.lEW lewMY = MY(context);
        this.tV = lewMY;
        lewMY.setId(zPa.eeU);
        RelativeLayout.LayoutParams layoutParams6 = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams6.addRule(15);
        layoutParams6.leftMargin = iMY;
        layoutParams6.setMarginStart(iMY);
        layoutParams6.addRule(1, i2);
        layoutParams6.addRule(17, i2);
        this.tV.setLayoutParams(layoutParams6);
        bc.addView(this.tV);
        com.bytedance.sdk.openadsdk.core.Cc.lEW lewTV = tV(context);
        this.vCE = lewTV;
        lewTV.setId(zPa.tf);
        RelativeLayout.LayoutParams layoutParams7 = new RelativeLayout.LayoutParams(BS.MY(context, 100.0f), BS.MY(context, 32.0f));
        layoutParams7.addRule(11);
        layoutParams7.addRule(21);
        layoutParams7.addRule(15);
        this.vCE.setLayoutParams(layoutParams7);
        bc.addView(this.vCE);
    }

    public tV(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public tV(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
    }
}
