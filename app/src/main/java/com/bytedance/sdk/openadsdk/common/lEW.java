package com.bytedance.sdk.openadsdk.common;

import android.content.Context;
import android.graphics.Color;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import com.bytedance.sdk.component.utils.pP;
import com.bytedance.sdk.openadsdk.utils.BS;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes3.dex */
public class lEW extends LinearLayout {
    public lEW(Context context) {
        super(context);
        IlO();
    }

    private static ImageView IlO(Context context, float f4, float f8, float f9, float f10) {
        com.bytedance.sdk.openadsdk.core.Cc.tV tVVar = new com.bytedance.sdk.openadsdk.core.Cc.tV(context);
        tVVar.setClickable(true);
        tVVar.setFocusable(true);
        tVVar.setPadding(BS.MY(context, f9), BS.MY(context, f10), BS.MY(context, f9), BS.MY(context, f10));
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(BS.MY(context, 40.0f), BS.MY(context, 44.0f));
        if (f4 > 0.0f) {
            layoutParams.leftMargin = BS.MY(context, f4);
        }
        if (f8 > 0.0f) {
            layoutParams.rightMargin = BS.MY(context, f8);
        }
        tVVar.setLayoutParams(layoutParams);
        return tVVar;
    }

    private void IlO() {
        Context context = getContext();
        setId(com.bytedance.sdk.openadsdk.utils.zPa.dm);
        setLayoutParams(new ViewGroup.LayoutParams(-1, BS.MY(context, 44.5f)));
        setBackgroundColor(-1);
        setClickable(true);
        setFocusable(true);
        setOrientation(1);
        View view = new View(context);
        view.setBackgroundColor(Color.parseColor("#1F161823"));
        addView(view, new LinearLayout.LayoutParams(-1, BS.MY(context, 0.5f)));
        com.bytedance.sdk.openadsdk.core.Cc.Cc cc = new com.bytedance.sdk.openadsdk.core.Cc.Cc(context);
        cc.setOrientation(0);
        addView(cc, new LinearLayout.LayoutParams(-1, BS.MY(context, 44.0f)));
        ImageView imageViewIlO = IlO(context, 16.0f, 0.0f, 14.75f, 12.5f);
        imageViewIlO.setId(com.bytedance.sdk.openadsdk.utils.zPa.gm);
        imageViewIlO.setImageResource(pP.tV(context, "tt_ad_arrow_backward"));
        cc.addView(imageViewIlO);
        View view2 = new View(context);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(0, 0);
        layoutParams.weight = 1.0f;
        cc.addView(view2, layoutParams);
        ImageView imageViewIlO2 = IlO(context, 8.0f, 0.0f, 14.75f, 12.5f);
        imageViewIlO2.setId(com.bytedance.sdk.openadsdk.utils.zPa.aa);
        imageViewIlO2.setImageResource(pP.tV(context, "tt_ad_arrow_forward"));
        cc.addView(imageViewIlO2);
        View view3 = new View(context);
        LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(0, 0);
        layoutParams2.weight = 1.0f;
        cc.addView(view3, layoutParams2);
        ImageView imageViewIlO3 = IlO(context, 8.0f, 0.0f, 10.0f, 12.0f);
        imageViewIlO3.setId(com.bytedance.sdk.openadsdk.utils.zPa.ED);
        imageViewIlO3.setImageResource(pP.tV(context, "tt_ad_refresh"));
        cc.addView(imageViewIlO3);
        View view4 = new View(context);
        LinearLayout.LayoutParams layoutParams3 = new LinearLayout.LayoutParams(0, 0);
        layoutParams3.weight = 1.0f;
        cc.addView(view4, layoutParams3);
        ImageView imageViewIlO4 = IlO(context, 0.0f, 16.0f, 9.0f, 11.0f);
        imageViewIlO4.setId(com.bytedance.sdk.openadsdk.utils.zPa.PTq);
        imageViewIlO4.setImageResource(pP.tV(context, "tt_ad_link"));
        cc.addView(imageViewIlO4);
    }
}
