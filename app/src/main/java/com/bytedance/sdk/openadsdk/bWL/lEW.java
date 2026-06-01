package com.bytedance.sdk.openadsdk.bWL;

import android.content.Context;
import android.graphics.Color;
import android.util.AttributeSet;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.RelativeLayout;
import com.bytedance.sdk.openadsdk.utils.BS;
import com.bytedance.sdk.openadsdk.utils.zPa;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes3.dex */
public class lEW extends NV {
    public lEW(Context context) {
        this(context, null);
    }

    @Override // com.bytedance.sdk.openadsdk.bWL.NV
    public void IlO(Context context) {
        int iMY = BS.MY(context, 10.0f);
        int iMY2 = BS.MY(context, 16.0f);
        int iMY3 = BS.MY(context, 15.0f);
        int iMY4 = BS.MY(context, 20.0f);
        com.bytedance.sdk.openadsdk.core.Cc.Bc bc = new com.bytedance.sdk.openadsdk.core.Cc.Bc(context);
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -1);
        layoutParams.gravity = 17;
        bc.setLayoutParams(layoutParams);
        addView(bc);
        com.bytedance.sdk.openadsdk.core.Cc.EO eoCc = Cc(context);
        this.IlO = eoCc;
        eoCc.setId(zPa.Aw);
        this.IlO.setLayoutParams(new RelativeLayout.LayoutParams(-1, -1));
        bc.addView(this.IlO);
        com.bytedance.sdk.openadsdk.core.Cc.tV tVVarVCE = vCE(context);
        this.MY = tVVarVCE;
        tVVarVCE.setId(zPa.La);
        this.MY.setLayoutParams(new RelativeLayout.LayoutParams(-1, -1));
        bc.addView(this.MY);
        com.bytedance.sdk.openadsdk.core.Cc.Bc bc2 = new com.bytedance.sdk.openadsdk.core.Cc.Bc(context);
        int i2 = zPa.tU;
        bc2.setId(i2);
        RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(-1, BS.MY(context, 60.0f));
        layoutParams2.addRule(12);
        layoutParams2.rightMargin = iMY3;
        layoutParams2.leftMargin = iMY3;
        layoutParams2.bottomMargin = iMY3;
        layoutParams2.setMarginEnd(iMY3);
        layoutParams2.setMarginStart(iMY3);
        bc2.setBackgroundColor(Color.parseColor("#26000000"));
        bc2.setLayoutParams(layoutParams2);
        bc.addView(bc2);
        com.bytedance.sdk.openadsdk.core.widget.zPa zpaBc = Bc(context);
        this.EO = zpaBc;
        int i8 = zPa.OW;
        zpaBc.setId(i8);
        int iMY5 = BS.MY(context, 50.0f);
        RelativeLayout.LayoutParams layoutParams3 = new RelativeLayout.LayoutParams(iMY5, iMY5);
        layoutParams3.addRule(20);
        layoutParams3.addRule(9);
        layoutParams3.addRule(15);
        this.EO.setLayoutParams(layoutParams3);
        bc2.addView(this.EO);
        com.bytedance.sdk.openadsdk.core.Cc.lEW lewMY = MY(context);
        this.tV = lewMY;
        lewMY.setId(zPa.eeU);
        RelativeLayout.LayoutParams layoutParams4 = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams4.addRule(15);
        layoutParams4.leftMargin = iMY4;
        layoutParams4.setMarginStart(iMY4);
        layoutParams4.addRule(1, i8);
        layoutParams4.addRule(17, i8);
        this.tV.setLayoutParams(layoutParams4);
        bc2.addView(this.tV);
        com.bytedance.sdk.openadsdk.core.Cc.lEW lewTV = tV(context);
        this.vCE = lewTV;
        lewTV.setId(zPa.tf);
        RelativeLayout.LayoutParams layoutParams5 = new RelativeLayout.LayoutParams(BS.MY(context, 100.0f), BS.MY(context, 30.0f));
        layoutParams5.addRule(21);
        layoutParams5.addRule(11);
        layoutParams5.addRule(15);
        layoutParams5.rightMargin = iMY;
        layoutParams5.setMarginEnd(iMY);
        this.vCE.setLayoutParams(layoutParams5);
        bc2.addView(this.vCE);
        View viewLEW = lEW(context);
        RelativeLayout.LayoutParams layoutParams6 = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams6.addRule(2, i2);
        layoutParams6.leftMargin = iMY2;
        layoutParams6.bottomMargin = iMY;
        viewLEW.setLayoutParams(layoutParams6);
        bc.addView(viewLEW);
    }

    @Override // com.bytedance.sdk.openadsdk.bWL.NV
    public com.bytedance.sdk.openadsdk.core.Cc.lEW MY(Context context) {
        com.bytedance.sdk.openadsdk.core.Cc.lEW lewMY = super.MY(context);
        lewMY.setGravity(16);
        lewMY.setMaxWidth(BS.MY(context, 250.0f));
        lewMY.setTextColor(-1);
        lewMY.setTextSize(2, 17.0f);
        lewMY.setText("APP NAME");
        return lewMY;
    }

    @Override // com.bytedance.sdk.openadsdk.bWL.NV
    public com.bytedance.sdk.openadsdk.core.Cc.lEW tV(Context context) {
        com.bytedance.sdk.openadsdk.core.Cc.lEW lewTV = super.tV(context);
        lewTV.setBackground(com.bytedance.sdk.openadsdk.utils.EV.IlO(context, "tt_download_corner_bg"));
        lewTV.setTextSize(2, 15.0f);
        return lewTV;
    }

    public lEW(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public lEW(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
    }
}
