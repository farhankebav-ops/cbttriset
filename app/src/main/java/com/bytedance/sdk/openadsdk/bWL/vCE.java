package com.bytedance.sdk.openadsdk.bWL;

import android.content.Context;
import android.graphics.Color;
import android.util.AttributeSet;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import com.bytedance.sdk.openadsdk.utils.BS;
import com.bytedance.sdk.openadsdk.utils.zPa;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes3.dex */
public class vCE extends NV {
    public vCE(Context context) {
        this(context, null);
    }

    @Override // com.bytedance.sdk.openadsdk.bWL.NV
    public com.bytedance.sdk.openadsdk.core.Cc.lEW EO(Context context) {
        com.bytedance.sdk.openadsdk.core.Cc.lEW lewEO = super.EO(context);
        lewEO.setGravity(16);
        lewEO.setMaxWidth(BS.MY(context, 53.0f));
        lewEO.setTextColor(-1);
        lewEO.setTextSize(2, 8.0f);
        return lewEO;
    }

    @Override // com.bytedance.sdk.openadsdk.bWL.NV
    public void IlO(Context context) {
        int iMY = BS.MY(context, 10.0f);
        int iMY2 = BS.MY(context, 5.0f);
        int iMY3 = BS.MY(context, 6.0f);
        int iMY4 = BS.MY(context, 16.0f);
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
        RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(-1, BS.MY(context, 48.0f));
        layoutParams2.setMargins(iMY2, iMY2, iMY2, iMY2);
        layoutParams2.addRule(12);
        bc2.setBackgroundColor(Color.parseColor("#26000000"));
        bc2.setGravity(16);
        bc2.setLayoutParams(layoutParams2);
        bc.addView(bc2);
        com.bytedance.sdk.openadsdk.core.widget.zPa zpaBc = Bc(context);
        this.EO = zpaBc;
        int i8 = zPa.OW;
        zpaBc.setId(i8);
        int iMY5 = BS.MY(context, 25.0f);
        RelativeLayout.LayoutParams layoutParams3 = new RelativeLayout.LayoutParams(iMY5, iMY5);
        layoutParams3.addRule(20);
        layoutParams3.addRule(9);
        layoutParams3.addRule(15);
        this.EO.setLayoutParams(layoutParams3);
        bc2.addView(this.EO);
        com.bytedance.sdk.openadsdk.core.Cc.Cc cc = new com.bytedance.sdk.openadsdk.core.Cc.Cc(context);
        RelativeLayout.LayoutParams layoutParams4 = new RelativeLayout.LayoutParams(-2, -1);
        layoutParams4.addRule(17, i8);
        layoutParams4.addRule(1, i8);
        cc.setLayoutParams(layoutParams4);
        cc.setGravity(16);
        cc.setOrientation(1);
        bc2.addView(cc);
        com.bytedance.sdk.openadsdk.core.Cc.lEW lewMY = MY(context);
        this.tV = lewMY;
        lewMY.setId(zPa.eeU);
        LinearLayout.LayoutParams layoutParams5 = new LinearLayout.LayoutParams(-2, -2);
        layoutParams5.leftMargin = iMY3;
        layoutParams5.setMarginStart(iMY3);
        this.tV.setLayoutParams(layoutParams5);
        cc.addView(this.tV);
        com.bytedance.sdk.openadsdk.core.Cc.lEW lewEO = EO(context);
        this.Cc = lewEO;
        lewEO.setId(zPa.BES);
        LinearLayout.LayoutParams layoutParams6 = new LinearLayout.LayoutParams(-2, -2);
        layoutParams6.leftMargin = iMY3;
        layoutParams6.setMarginStart(iMY3);
        this.Cc.setLayoutParams(layoutParams6);
        cc.addView(this.Cc);
        com.bytedance.sdk.openadsdk.core.Cc.lEW lewTV = tV(context);
        this.vCE = lewTV;
        lewTV.setId(zPa.tf);
        RelativeLayout.LayoutParams layoutParams7 = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams7.addRule(21);
        layoutParams7.addRule(11);
        layoutParams7.addRule(15);
        this.vCE.setLayoutParams(layoutParams7);
        int iMY6 = BS.MY(context, 4.0f);
        this.vCE.setPadding(iMY6, iMY6, iMY6, iMY6);
        bc2.addView(this.vCE);
        View viewLEW = lEW(context);
        RelativeLayout.LayoutParams layoutParams8 = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams8.addRule(2, i2);
        layoutParams8.leftMargin = iMY4;
        layoutParams8.bottomMargin = iMY;
        viewLEW.setLayoutParams(layoutParams8);
        bc.addView(viewLEW);
    }

    @Override // com.bytedance.sdk.openadsdk.bWL.NV
    public com.bytedance.sdk.openadsdk.core.Cc.lEW MY(Context context) {
        com.bytedance.sdk.openadsdk.core.Cc.lEW lewMY = super.MY(context);
        lewMY.setGravity(16);
        lewMY.setMaxWidth(BS.MY(context, 53.0f));
        lewMY.setTextColor(-1);
        lewMY.setTextSize(2, 10.0f);
        return lewMY;
    }

    @Override // com.bytedance.sdk.openadsdk.bWL.NV
    public com.bytedance.sdk.openadsdk.core.Cc.lEW tV(Context context) {
        com.bytedance.sdk.openadsdk.core.Cc.lEW lewTV = super.tV(context);
        lewTV.setBackground(com.bytedance.sdk.openadsdk.utils.EV.IlO(context, "tt_download_corner_bg"));
        lewTV.setTextSize(2, 8.0f);
        return lewTV;
    }

    public vCE(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public vCE(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
    }
}
