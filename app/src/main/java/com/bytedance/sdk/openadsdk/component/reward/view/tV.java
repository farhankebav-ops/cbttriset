package com.bytedance.sdk.openadsdk.component.reward.view;

import android.content.Context;
import android.graphics.Color;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import androidx.core.view.ViewCompat;
import com.bytedance.sdk.component.utils.pP;
import com.bytedance.sdk.openadsdk.common.rp;
import com.bytedance.sdk.openadsdk.core.model.oeT;
import com.bytedance.sdk.openadsdk.core.widget.PAGLogoView;
import com.bytedance.sdk.openadsdk.utils.BS;
import com.bytedance.sdk.openadsdk.utils.zPa;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes3.dex */
public class tV {
    public static void IlO(FrameLayout frameLayout, oeT oet) {
        Context context = frameLayout.getContext();
        com.bytedance.sdk.openadsdk.core.Cc.Bc bc = new com.bytedance.sdk.openadsdk.core.Cc.Bc(context);
        bc.setId(zPa.kBB);
        bc.setBackgroundColor(Color.parseColor("#F8F8F8"));
        frameLayout.addView(bc, new FrameLayout.LayoutParams(-1, -1));
        View rpVar = new rp(context);
        rpVar.setId(zPa.pP);
        bc.addView(rpVar, new RelativeLayout.LayoutParams(-1, -1));
        com.bytedance.sdk.openadsdk.core.Cc.Cc cc = new com.bytedance.sdk.openadsdk.core.Cc.Cc(context);
        cc.setId(zPa.tl);
        cc.setOrientation(1);
        cc.setVisibility(8);
        cc.setGravity(1);
        cc.setId(zPa.mmj);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -2);
        layoutParams.addRule(13);
        bc.addView(cc, layoutParams);
        com.bytedance.sdk.openadsdk.core.widget.zPa zpa = new com.bytedance.sdk.openadsdk.core.widget.zPa(context);
        zpa.setId(zPa.wPn);
        cc.addView(zpa, new LinearLayout.LayoutParams(BS.MY(context, 80.0f), BS.MY(context, 80.0f)));
        com.bytedance.sdk.openadsdk.core.Cc.lEW lew = new com.bytedance.sdk.openadsdk.core.Cc.lEW(context);
        lew.setId(zPa.oc);
        lew.setTextColor(Color.parseColor("#161823"));
        lew.setTextSize(2, 24.0f);
        LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(-2, -2);
        layoutParams2.topMargin = BS.MY(context, 12.0f);
        cc.addView(lew, layoutParams2);
        com.bytedance.sdk.openadsdk.core.Cc.lEW lew2 = new com.bytedance.sdk.openadsdk.core.Cc.lEW(context);
        lew2.setId(zPa.vSq);
        lew2.setGravity(17);
        lew2.setTextColor(Color.parseColor("#80161823"));
        lew2.setTextSize(2, 16.0f);
        lew2.setTextAlignment(4);
        LinearLayout.LayoutParams layoutParams3 = new LinearLayout.LayoutParams(-2, -2);
        int iMY = BS.MY(context, 60.0f);
        layoutParams3.leftMargin = iMY;
        layoutParams3.rightMargin = iMY;
        layoutParams3.setMarginStart(iMY);
        layoutParams3.setMarginEnd(layoutParams3.rightMargin);
        layoutParams3.topMargin = BS.MY(context, 8.0f);
        cc.addView(lew2, layoutParams3);
        com.bytedance.sdk.openadsdk.core.Cc.lEW lew3 = new com.bytedance.sdk.openadsdk.core.Cc.lEW(context);
        lew3.setId(zPa.dY);
        lew3.setGravity(17);
        lew3.setTextColor(-1);
        lew3.setText(pP.IlO(context, "tt_video_mobile_go_detail"));
        lew3.setBackground(com.bytedance.sdk.openadsdk.utils.EV.IlO(context, "tt_reward_video_download_btn_bg"));
        LinearLayout.LayoutParams layoutParams4 = new LinearLayout.LayoutParams(BS.MY(context, 255.0f), BS.MY(context, 44.0f));
        layoutParams4.topMargin = BS.MY(context, 32.0f);
        cc.addView(lew3, layoutParams4);
        com.bytedance.sdk.openadsdk.core.Cc.lEW lew4 = new com.bytedance.sdk.openadsdk.core.Cc.lEW(context);
        lew4.setId(zPa.OOq);
        lew4.setGravity(17);
        lew4.setTextColor(ViewCompat.MEASURED_STATE_MASK);
        lew4.setText("Sorry,this AD fails to load...");
        lew4.setVisibility(8);
        lew4.setGravity(1);
        RelativeLayout.LayoutParams layoutParams5 = new RelativeLayout.LayoutParams(-1, -2);
        layoutParams5.addRule(13);
        bc.addView(lew4, layoutParams5);
        View viewCreatePAGLogoViewByMaterial = PAGLogoView.createPAGLogoViewByMaterial(context, oet);
        viewCreatePAGLogoViewByMaterial.setId(zPa.lMM);
        RelativeLayout.LayoutParams layoutParams6 = new RelativeLayout.LayoutParams(-2, BS.MY(context, 14.0f));
        layoutParams6.addRule(12);
        int iMY2 = BS.MY(context, 16.0f);
        layoutParams6.leftMargin = iMY2;
        layoutParams6.setMarginStart(iMY2);
        layoutParams6.bottomMargin = BS.MY(context, 20.0f);
        bc.addView(viewCreatePAGLogoViewByMaterial, layoutParams6);
    }

    public static void IlO(FrameLayout frameLayout) {
        Context context = frameLayout.getContext();
        View eo = new EO(context);
        eo.setId(zPa.rp);
        eo.setVisibility(8);
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -2);
        layoutParams.gravity = 80;
        frameLayout.addView(eo, layoutParams);
        View cc = new com.bytedance.sdk.openadsdk.core.Cc.Cc(context);
        cc.setId(zPa.hp);
        cc.setVisibility(8);
        frameLayout.addView(cc, new FrameLayout.LayoutParams(-1, -1));
        View vce = new com.bytedance.sdk.component.DmF.vCE(context, true);
        vce.setLayerType(2, null);
        vce.setVisibility(4);
        vce.setId(zPa.bWL);
        frameLayout.addView(vce, new FrameLayout.LayoutParams(-1, -1));
        View frameLayout2 = new FrameLayout(context);
        frameLayout2.setId(zPa.ea);
        frameLayout2.setVisibility(4);
        frameLayout.addView(frameLayout2, new FrameLayout.LayoutParams(-1, -1));
        View vce2 = new com.bytedance.sdk.component.DmF.vCE(context, true);
        vce2.setVisibility(8);
        vce2.setId(zPa.zPa);
        frameLayout.addView(vce2, new FrameLayout.LayoutParams(-1, -1));
        frameLayout.addView(new RFEndCardBackUpLayout(context), new FrameLayout.LayoutParams(-1, -1));
    }
}
