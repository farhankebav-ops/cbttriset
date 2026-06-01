package com.bytedance.sdk.openadsdk.bWL;

import android.content.Context;
import android.graphics.Color;
import android.util.AttributeSet;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import com.bytedance.sdk.openadsdk.utils.BS;
import com.bytedance.sdk.openadsdk.utils.zPa;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes3.dex */
public class bWL extends com.bytedance.sdk.openadsdk.core.Cc.Bc {
    public bWL(Context context) {
        this(context, null);
    }

    private void IlO(Context context) {
        setBackgroundColor(Color.parseColor("#000000"));
        setId(520093726);
        int iMY = BS.MY(context, 60.0f);
        com.bytedance.sdk.openadsdk.core.Cc.EO eo = new com.bytedance.sdk.openadsdk.core.Cc.EO(context);
        eo.setId(zPa.XvI);
        eo.setLayoutParams(new RelativeLayout.LayoutParams(-1, -1));
        eo.setBackgroundColor(0);
        addView(eo);
        com.bytedance.sdk.openadsdk.core.Cc.tV tVVar = new com.bytedance.sdk.openadsdk.core.Cc.tV(context);
        tVVar.setId(zPa.IRy);
        tVVar.setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
        tVVar.setScaleType(ImageView.ScaleType.CENTER_CROP);
        eo.addView(tVVar);
        com.bytedance.sdk.openadsdk.core.Cc.vCE vce = new com.bytedance.sdk.openadsdk.core.Cc.vCE(context);
        vce.setId(zPa.BC);
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(iMY, iMY);
        layoutParams.gravity = 17;
        vce.setLayoutParams(layoutParams);
        vce.setIndeterminateDrawable(com.bytedance.sdk.openadsdk.utils.EV.IlO(context, "tt_video_loading_progress_bar"));
        eo.addView(vce);
        com.bytedance.sdk.openadsdk.core.Cc.tV tVVar2 = new com.bytedance.sdk.openadsdk.core.Cc.tV(context);
        tVVar2.setId(zPa.xJ);
        RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams2.addRule(13);
        tVVar2.setLayoutParams(layoutParams2);
        tVVar2.setScaleType(ImageView.ScaleType.CENTER);
        tVVar2.setImageDrawable(com.bytedance.sdk.openadsdk.utils.EV.IlO(context, "tt_play_movebar_textpage"));
        tVVar2.setVisibility(8);
        addView(tVVar2);
        View rpVar = new rp(context);
        rpVar.setId(zPa.NST);
        rpVar.setLayoutParams(new RelativeLayout.LayoutParams(-1, -1));
        addView(rpVar);
    }

    public bWL(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public bWL(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        IlO(context);
    }
}
