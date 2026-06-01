package com.bytedance.sdk.openadsdk.component.DmF;

import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.GradientDrawable;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import com.bytedance.sdk.openadsdk.core.model.oeT;
import com.bytedance.sdk.openadsdk.core.widget.PAGLogoView;
import com.bytedance.sdk.openadsdk.core.widget.ea;
import com.bytedance.sdk.openadsdk.core.widget.zPa;
import com.bytedance.sdk.openadsdk.utils.BS;
import com.bytedance.sdk.openadsdk.utils.EV;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes3.dex */
public class vCE extends EO {
    private final ea bWL;
    private final com.bytedance.sdk.openadsdk.core.Cc.Cc hp;

    public vCE(Context context, oeT oet) {
        super(context);
        setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
        setBackground(new GradientDrawable(GradientDrawable.Orientation.LEFT_RIGHT, new int[]{Color.parseColor("#EDFCFF"), Color.parseColor("#FFF6FD")}));
        com.bytedance.sdk.openadsdk.core.Cc.Cc cc = new com.bytedance.sdk.openadsdk.core.Cc.Cc(context);
        this.hp = cc;
        cc.setId(520093758);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams.leftMargin = BS.MY(context, 24.0f);
        layoutParams.topMargin = BS.MY(context, 56.0f);
        cc.setLayoutParams(layoutParams);
        cc.setClickable(false);
        cc.setGravity(16);
        cc.setOrientation(0);
        zPa zpa = new zPa(context);
        this.vCE = zpa;
        zpa.setId(520093759);
        this.vCE.setLayoutParams(new LinearLayout.LayoutParams(BS.MY(context, 24.0f), BS.MY(context, 24.0f)));
        com.bytedance.sdk.openadsdk.core.Cc.lEW lew = new com.bytedance.sdk.openadsdk.core.Cc.lEW(context);
        this.Bc = lew;
        lew.setId(520093761);
        LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(-2, -2);
        layoutParams2.leftMargin = BS.MY(context, 8.0f);
        this.Bc.setLayoutParams(layoutParams2);
        com.bytedance.sdk.openadsdk.core.Cc.lEW lew2 = this.Bc;
        TextUtils.TruncateAt truncateAt = TextUtils.TruncateAt.END;
        lew2.setEllipsize(truncateAt);
        this.Bc.setMaxLines(2);
        this.Bc.setTextColor(Color.parseColor("#161823"));
        this.Bc.setTextSize(12.0f);
        com.bytedance.sdk.openadsdk.core.Cc.Bc bc = new com.bytedance.sdk.openadsdk.core.Cc.Bc(context);
        RelativeLayout.LayoutParams layoutParams3 = new RelativeLayout.LayoutParams(BS.MY(context, 327.0f), -2);
        layoutParams3.addRule(13);
        layoutParams3.leftMargin = BS.MY(context, 24.0f);
        layoutParams3.rightMargin = BS.MY(context, 24.0f);
        bc.setLayoutParams(layoutParams3);
        zPa zpa2 = new zPa(context);
        this.DmF = zpa2;
        int i2 = com.bytedance.sdk.openadsdk.utils.zPa.SU;
        zpa2.setId(i2);
        RelativeLayout.LayoutParams layoutParams4 = new RelativeLayout.LayoutParams(BS.MY(context, 80.0f), BS.MY(context, 80.0f));
        layoutParams4.addRule(14);
        this.DmF.setLayoutParams(layoutParams4);
        com.bytedance.sdk.openadsdk.core.Cc.lEW lew3 = new com.bytedance.sdk.openadsdk.core.Cc.lEW(context);
        this.NV = lew3;
        int i8 = com.bytedance.sdk.openadsdk.utils.zPa.pbX;
        lew3.setId(i8);
        this.NV.setTextSize(24.0f);
        this.NV.setTextColor(Color.parseColor("#161823"));
        this.NV.setGravity(17);
        this.NV.setMaxLines(1);
        this.NV.setEllipsize(truncateAt);
        RelativeLayout.LayoutParams layoutParams5 = new RelativeLayout.LayoutParams(-1, -2);
        layoutParams5.addRule(3, i2);
        layoutParams5.topMargin = BS.MY(context, 12.0f);
        layoutParams5.addRule(14);
        this.NV.setLayoutParams(layoutParams5);
        com.bytedance.sdk.openadsdk.core.Cc.lEW lew4 = new com.bytedance.sdk.openadsdk.core.Cc.lEW(context);
        this.EV = lew4;
        int i9 = com.bytedance.sdk.openadsdk.utils.zPa.ey;
        lew4.setId(i9);
        this.EV.setTextSize(16.0f);
        this.EV.setTextColor(Color.parseColor("#80161823"));
        this.EV.setGravity(17);
        this.EV.setMaxLines(2);
        this.EV.setEllipsize(truncateAt);
        RelativeLayout.LayoutParams layoutParams6 = new RelativeLayout.LayoutParams(-1, -2);
        layoutParams6.addRule(3, i8);
        layoutParams6.topMargin = BS.MY(context, 4.0f);
        layoutParams6.addRule(14);
        this.EV.setLayoutParams(layoutParams6);
        ea eaVar = new ea(context);
        this.bWL = eaVar;
        RelativeLayout.LayoutParams layoutParams7 = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams7.addRule(14);
        layoutParams7.topMargin = BS.MY(context, 12.0f);
        eaVar.setLayoutParams(layoutParams7);
        com.bytedance.sdk.openadsdk.core.Cc.lEW lew5 = new com.bytedance.sdk.openadsdk.core.Cc.lEW(context);
        this.Cc = lew5;
        lew5.setId(520093717);
        this.Cc.setBackground(EV.IlO(context, "tt_reward_full_video_backup_btn_bg"));
        this.Cc.setEllipsize(truncateAt);
        this.Cc.setLines(1);
        this.Cc.setGravity(17);
        this.Cc.setTextColor(-1);
        this.Cc.setTextSize(16.0f);
        this.Cc.setTag("open_ad_click_button_tag");
        RelativeLayout.LayoutParams layoutParams8 = new RelativeLayout.LayoutParams(-1, BS.MY(context, 44.0f));
        layoutParams8.addRule(3, i9);
        layoutParams8.topMargin = BS.MY(context, 54.0f);
        layoutParams8.addRule(14);
        this.Cc.setLayoutParams(layoutParams8);
        PAGLogoView pAGLogoViewCreatePAGLogoViewByMaterial = PAGLogoView.createPAGLogoViewByMaterial(context, oet);
        this.tV = pAGLogoViewCreatePAGLogoViewByMaterial;
        pAGLogoViewCreatePAGLogoViewByMaterial.setId(520093757);
        RelativeLayout.LayoutParams layoutParams9 = new RelativeLayout.LayoutParams(-2, BS.MY(context, 14.0f));
        layoutParams9.leftMargin = BS.MY(context, 16.0f);
        layoutParams9.bottomMargin = BS.MY(context, 24.0f);
        layoutParams9.addRule(12);
        this.tV.setLayoutParams(layoutParams9);
        addView(this.lEW);
        cc.addView(this.vCE);
        cc.addView(this.Bc);
        addView(cc);
        bc.addView(this.DmF);
        bc.addView(this.NV);
        bc.addView(this.EV);
        bc.addView(eaVar);
        bc.addView(this.Cc);
        addView(bc);
        addView(this.tV);
    }

    @Override // com.bytedance.sdk.openadsdk.component.DmF.EO
    public com.bytedance.sdk.openadsdk.core.Cc.tV getAdIconView() {
        return null;
    }

    @Override // com.bytedance.sdk.openadsdk.component.DmF.EO
    public com.bytedance.sdk.openadsdk.core.Cc.lEW getAdTitleTextView() {
        return null;
    }

    @Override // com.bytedance.sdk.openadsdk.component.DmF.EO
    public ea getScoreBar() {
        return this.bWL;
    }

    @Override // com.bytedance.sdk.openadsdk.component.DmF.EO
    public View getUserInfo() {
        return this.hp;
    }
}
