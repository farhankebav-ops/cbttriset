package com.bytedance.sdk.openadsdk.bWL;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import com.bytedance.sdk.openadsdk.core.widget.PAGLogoView;
import com.bytedance.sdk.openadsdk.utils.BS;
import com.bytedance.sdk.openadsdk.utils.zPa;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes3.dex */
public class EO extends NV {
    public EO(Context context) {
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
        cc2.setGravity(81);
        int iMY2 = BS.MY(context, 16.0f);
        cc2.setPadding(iMY2, iMY2, iMY2, iMY2);
        cc.addView(cc2);
        com.bytedance.sdk.openadsdk.core.widget.zPa zpaBc = Bc(context);
        this.EO = zpaBc;
        zpaBc.setId(zPa.OW);
        int iMY3 = BS.MY(context, 45.0f);
        this.EO.setLayoutParams(new LinearLayout.LayoutParams(iMY3, iMY3));
        cc2.addView(this.EO);
        com.bytedance.sdk.openadsdk.core.Cc.lEW lewMY = MY(context);
        this.tV = lewMY;
        lewMY.setId(zPa.eeU);
        LinearLayout.LayoutParams layoutParams4 = new LinearLayout.LayoutParams(-2, -2);
        layoutParams4.topMargin = BS.MY(context, 4.0f);
        this.tV.setLayoutParams(layoutParams4);
        cc2.addView(this.tV);
        com.bytedance.sdk.openadsdk.core.Cc.lEW lewEO = EO(context);
        this.Cc = lewEO;
        lewEO.setId(zPa.BES);
        LinearLayout.LayoutParams layoutParams5 = new LinearLayout.LayoutParams(-2, -2);
        layoutParams5.topMargin = iMY;
        layoutParams5.bottomMargin = BS.MY(context, 25.0f);
        this.Cc.setLayoutParams(layoutParams5);
        cc2.addView(this.Cc);
        com.bytedance.sdk.openadsdk.core.Cc.lEW lewTV = tV(context);
        this.vCE = lewTV;
        lewTV.setId(zPa.tf);
        LinearLayout.LayoutParams layoutParams6 = new LinearLayout.LayoutParams(-1, BS.MY(context, 32.0f));
        layoutParams6.topMargin = iMY2;
        this.vCE.setLayoutParams(layoutParams6);
        cc2.addView(this.vCE);
    }

    @Override // com.bytedance.sdk.openadsdk.bWL.NV
    public com.bytedance.sdk.openadsdk.core.Cc.lEW MY(Context context) {
        com.bytedance.sdk.openadsdk.core.Cc.lEW lewMY = super.MY(context);
        lewMY.setTextColor(-1);
        return lewMY;
    }

    public EO(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public EO(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
    }
}
