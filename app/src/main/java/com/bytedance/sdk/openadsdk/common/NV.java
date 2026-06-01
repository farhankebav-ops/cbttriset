package com.bytedance.sdk.openadsdk.common;

import android.content.Context;
import android.text.TextUtils;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import androidx.core.view.ViewCompat;
import com.bytedance.sdk.component.utils.pP;
import com.bytedance.sdk.openadsdk.utils.BS;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes3.dex */
public class NV extends RelativeLayout {
    public NV(Context context) {
        super(context);
        IlO();
    }

    private void IlO() {
        Context context = getContext();
        int iMY = BS.MY(context, 12.0f);
        setLayoutParams(new ViewGroup.LayoutParams(-1, BS.MY(context, 44.0f)));
        setBackgroundColor(-1);
        com.bytedance.sdk.openadsdk.core.Cc.tV tVVar = new com.bytedance.sdk.openadsdk.core.Cc.tV(context);
        tVVar.setId(520093720);
        tVVar.setClickable(true);
        tVVar.setFocusable(true);
        tVVar.setImageDrawable(com.bytedance.sdk.openadsdk.utils.EV.IlO(context, "tt_leftbackicon_selector"));
        int iMY2 = BS.MY(context, 24.0f);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(iMY2, iMY2);
        layoutParams.leftMargin = iMY;
        layoutParams.addRule(15);
        addView(tVVar, layoutParams);
        com.bytedance.sdk.openadsdk.core.Cc.tV tVVar2 = new com.bytedance.sdk.openadsdk.core.Cc.tV(context);
        tVVar2.setId(520093716);
        tVVar2.setClickable(true);
        tVVar2.setFocusable(true);
        tVVar2.setImageDrawable(com.bytedance.sdk.openadsdk.utils.EV.IlO(context, "tt_titlebar_close_seletor"));
        RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(iMY2, iMY2);
        layoutParams2.leftMargin = iMY;
        layoutParams2.addRule(15);
        layoutParams2.addRule(1, 520093720);
        addView(tVVar2, layoutParams2);
        com.bytedance.sdk.openadsdk.core.Cc.tV tVVar3 = new com.bytedance.sdk.openadsdk.core.Cc.tV(context);
        int i2 = com.bytedance.sdk.openadsdk.utils.zPa.zTS;
        tVVar3.setId(i2);
        tVVar3.setImageDrawable(pP.EO(context, "tt_ad_feedback_new"));
        RelativeLayout.LayoutParams layoutParams3 = new RelativeLayout.LayoutParams(iMY2, iMY2);
        layoutParams3.addRule(11);
        layoutParams3.addRule(15);
        layoutParams3.rightMargin = iMY;
        addView(tVVar3, layoutParams3);
        com.bytedance.sdk.openadsdk.core.Cc.lEW lew = new com.bytedance.sdk.openadsdk.core.Cc.lEW(context);
        lew.setId(com.bytedance.sdk.openadsdk.utils.zPa.KT);
        lew.setSingleLine(true);
        lew.setEllipsize(TextUtils.TruncateAt.MARQUEE);
        lew.setGravity(17);
        lew.setTextColor(ViewCompat.MEASURED_STATE_MASK);
        lew.setTextSize(1, 16.0f);
        RelativeLayout.LayoutParams layoutParams4 = new RelativeLayout.LayoutParams(BS.MY(context, 240.0f), -2);
        layoutParams4.addRule(15);
        layoutParams4.addRule(1, 520093716);
        layoutParams4.addRule(0, i2);
        int iMY3 = BS.MY(context, 25.0f);
        layoutParams4.rightMargin = iMY3;
        layoutParams4.leftMargin = iMY3;
        addView(lew, layoutParams4);
    }
}
