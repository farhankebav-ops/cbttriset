package com.bytedance.sdk.openadsdk.common;

import android.R;
import android.content.Context;
import android.graphics.Color;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import com.bytedance.sdk.component.utils.pP;
import com.bytedance.sdk.openadsdk.utils.BS;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes3.dex */
public class DmF extends RelativeLayout {
    public DmF(Context context) {
        super(context);
        IlO();
    }

    private void IlO() {
        setId(com.bytedance.sdk.openadsdk.utils.zPa.Hg);
        setBackgroundColor(-1);
        Context context = getContext();
        setLayoutParams(new ViewGroup.LayoutParams(-1, BS.MY(context, 44.0f)));
        com.bytedance.sdk.openadsdk.core.Cc.tV tVVar = new com.bytedance.sdk.openadsdk.core.Cc.tV(context);
        int i2 = com.bytedance.sdk.openadsdk.utils.zPa.qz;
        tVVar.setId(i2);
        tVVar.setClickable(true);
        tVVar.setFocusable(true);
        tVVar.setPadding(BS.MY(context, 12.0f), BS.MY(context, 14.0f), BS.MY(context, 12.0f), BS.MY(context, 14.0f));
        tVVar.setImageResource(pP.tV(context, "tt_ad_xmark"));
        addView(tVVar, new RelativeLayout.LayoutParams(BS.MY(context, 40.0f), BS.MY(context, 44.0f)));
        com.bytedance.sdk.openadsdk.core.Cc.tV tVVar2 = new com.bytedance.sdk.openadsdk.core.Cc.tV(context);
        int i8 = com.bytedance.sdk.openadsdk.utils.zPa.ts;
        tVVar2.setId(i8);
        tVVar2.setPadding(BS.MY(context, 8.0f), BS.MY(context, 10.0f), BS.MY(context, 8.0f), BS.MY(context, 10.0f));
        tVVar2.setImageResource(pP.tV(context, "tt_ad_feedback"));
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(BS.MY(context, 40.0f), BS.MY(context, 44.0f));
        layoutParams.addRule(11);
        addView(tVVar2, layoutParams);
        com.bytedance.sdk.openadsdk.core.Cc.lEW lew = new com.bytedance.sdk.openadsdk.core.Cc.lEW(context);
        lew.setId(com.bytedance.sdk.openadsdk.utils.zPa.qvT);
        lew.setSingleLine(true);
        lew.setEllipsize(TextUtils.TruncateAt.END);
        lew.setGravity(17);
        lew.setTextColor(Color.parseColor("#222222"));
        lew.setTextSize(2, 17.0f);
        RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(BS.MY(context, 191.0f), BS.MY(context, 24.0f));
        layoutParams2.addRule(15);
        layoutParams2.addRule(0, i8);
        layoutParams2.addRule(1, i2);
        int iMY = BS.MY(context, 10.0f);
        layoutParams2.leftMargin = iMY;
        layoutParams2.rightMargin = iMY;
        addView(lew, layoutParams2);
        com.bytedance.sdk.openadsdk.core.Cc.vCE vce = new com.bytedance.sdk.openadsdk.core.Cc.vCE(context, null, R.style.Widget.ProgressBar.Horizontal);
        vce.setId(com.bytedance.sdk.openadsdk.utils.zPa.BO);
        vce.setProgress(1);
        vce.setProgressDrawable(com.bytedance.sdk.openadsdk.utils.EV.IlO(context, "tt_privacy_progress_style"));
        RelativeLayout.LayoutParams layoutParams3 = new RelativeLayout.LayoutParams(-1, BS.MY(context, 2.0f));
        layoutParams3.addRule(12);
        addView(vce, layoutParams3);
        View view = new View(context);
        view.setBackgroundColor(Color.parseColor("#1F161823"));
        RelativeLayout.LayoutParams layoutParams4 = new RelativeLayout.LayoutParams(-1, BS.MY(context, 0.5f));
        layoutParams4.addRule(12);
        addView(view, layoutParams4);
    }
}
