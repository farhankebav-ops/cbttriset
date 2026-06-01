package com.bytedance.sdk.openadsdk.bWL;

import android.content.Context;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import com.bytedance.sdk.openadsdk.core.widget.PAGLogoView;
import com.bytedance.sdk.openadsdk.utils.BS;
import com.bytedance.sdk.openadsdk.utils.zPa;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes3.dex */
public class Cc extends NV {
    private com.bytedance.sdk.openadsdk.core.Cc.tV Bc;
    private com.bytedance.sdk.openadsdk.core.Cc.lEW lEW;

    public Cc(Context context) {
        this(context, null);
    }

    @Override // com.bytedance.sdk.openadsdk.bWL.NV
    public void IlO(Context context) {
        int iMY = BS.MY(context, 6.0f);
        setPadding(iMY, iMY, iMY, iMY);
        com.bytedance.sdk.openadsdk.core.Cc.EO eoCc = Cc(context);
        this.IlO = eoCc;
        eoCc.setId(zPa.Aw);
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -1);
        int iMY2 = BS.MY(context, 26.0f);
        layoutParams.topMargin = iMY2;
        this.IlO.setLayoutParams(layoutParams);
        addView(this.IlO);
        com.bytedance.sdk.openadsdk.core.Cc.tV tVVar = new com.bytedance.sdk.openadsdk.core.Cc.tV(context);
        this.Bc = tVVar;
        tVVar.setId(zPa.uF);
        this.Bc.setScaleType(ImageView.ScaleType.FIT_CENTER);
        FrameLayout.LayoutParams layoutParams2 = new FrameLayout.LayoutParams(-1, -1);
        layoutParams2.topMargin = iMY2;
        this.Bc.setLayoutParams(layoutParams2);
        addView(this.Bc);
        PAGLogoView pAGLogoViewLEW = lEW(context);
        FrameLayout.LayoutParams layoutParams3 = new FrameLayout.LayoutParams(-2, -2);
        layoutParams3.gravity = 80;
        int iMY3 = BS.MY(context, 10.0f);
        layoutParams3.leftMargin = iMY3;
        layoutParams3.topMargin = iMY3;
        layoutParams3.bottomMargin = iMY3;
        pAGLogoViewLEW.setLayoutParams(layoutParams3);
        addView(pAGLogoViewLEW);
        com.bytedance.sdk.openadsdk.core.Cc.Cc cc = new com.bytedance.sdk.openadsdk.core.Cc.Cc(context);
        cc.setLayoutParams(new FrameLayout.LayoutParams(-1, -2));
        cc.setOrientation(0);
        cc.setGravity(17);
        addView(cc);
        com.bytedance.sdk.openadsdk.core.Cc.lEW lew = new com.bytedance.sdk.openadsdk.core.Cc.lEW(context);
        this.lEW = lew;
        lew.setId(zPa.eDn);
        this.lEW.setEllipsize(TextUtils.TruncateAt.END);
        this.lEW.setMaxLines(1);
        this.lEW.setTextColor(-1);
        this.lEW.setTextSize(2, 12.0f);
        LinearLayout.LayoutParams layoutParams4 = new LinearLayout.LayoutParams(0, -2);
        layoutParams4.weight = 1.0f;
        this.lEW.setLayoutParams(layoutParams4);
        cc.addView(this.lEW);
    }

    public com.bytedance.sdk.openadsdk.core.Cc.lEW getTtBuDescTV() {
        return this.lEW;
    }

    public com.bytedance.sdk.openadsdk.core.Cc.tV getTtBuImg() {
        return this.Bc;
    }

    public Cc(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public Cc(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
    }
}
