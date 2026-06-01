package com.bytedance.sdk.openadsdk.bWL;

import android.content.Context;
import android.graphics.Color;
import android.util.AttributeSet;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import com.bytedance.sdk.component.utils.pP;
import com.bytedance.sdk.openadsdk.utils.BS;
import com.bytedance.sdk.openadsdk.utils.zPa;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes3.dex */
public class ea extends com.bytedance.sdk.openadsdk.core.Cc.Bc {
    public ea(Context context) {
        this(context, null);
    }

    private void IlO(Context context) {
        setId(zPa.QLG);
        setBackgroundColor(Color.parseColor("#00000000"));
        setGravity(16);
        setVisibility(8);
        com.bytedance.sdk.openadsdk.core.Cc.lEW lew = new com.bytedance.sdk.openadsdk.core.Cc.lEW(context);
        int i2 = zPa.Pbh;
        lew.setId(i2);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams.addRule(14);
        lew.setLayoutParams(layoutParams);
        lew.setIncludeFontPadding(false);
        lew.setText(pP.IlO(context, "tt_video_without_wifi_tips"));
        lew.setTextColor(Color.parseColor("#cacaca"));
        lew.setTextSize(2, 14.0f);
        addView(lew);
        com.bytedance.sdk.openadsdk.core.Cc.Bc bc = new com.bytedance.sdk.openadsdk.core.Cc.Bc(context);
        bc.setId(zPa.qIK);
        RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams2.addRule(3, i2);
        layoutParams2.addRule(13);
        bc.setLayoutParams(layoutParams2);
        addView(bc);
        com.bytedance.sdk.openadsdk.core.Cc.tV tVVar = new com.bytedance.sdk.openadsdk.core.Cc.tV(context);
        tVVar.setId(zPa.LO);
        int iMY = BS.MY(context, 44.0f);
        RelativeLayout.LayoutParams layoutParams3 = new RelativeLayout.LayoutParams(iMY, iMY);
        layoutParams3.addRule(15);
        tVVar.setLayoutParams(layoutParams3);
        tVVar.setImageDrawable(pP.EO(context, "tt_new_play_video"));
        tVVar.setScaleType(ImageView.ScaleType.FIT_XY);
        bc.addView(tVVar);
    }

    public ea(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public ea(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        IlO(context);
    }
}
