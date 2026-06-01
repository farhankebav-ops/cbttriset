package com.bytedance.sdk.openadsdk.bWL;

import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.Color;
import android.graphics.PorterDuff;
import android.graphics.Typeface;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import com.bytedance.sdk.openadsdk.utils.BS;
import com.bytedance.sdk.openadsdk.utils.zPa;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes3.dex */
public class rp extends com.bytedance.sdk.openadsdk.core.Cc.Bc {
    public rp(Context context) {
        this(context, null);
    }

    private void IlO(Context context) {
        setId(zPa.NST);
        setVisibility(8);
        setBackgroundColor(Color.parseColor("#7f000000"));
        com.bytedance.sdk.openadsdk.core.Cc.tV tVVar = new com.bytedance.sdk.openadsdk.core.Cc.tV(getContext());
        tVVar.setId(zPa.ao);
        tVVar.setScaleType(ImageView.ScaleType.CENTER_CROP);
        tVVar.setImageTintMode(PorterDuff.Mode.SRC_OVER);
        tVVar.setImageTintList(ColorStateList.valueOf(Color.parseColor("#7f000000")));
        tVVar.setBackgroundColor(Color.parseColor("#7f000000"));
        tVVar.setLayoutParams(new RelativeLayout.LayoutParams(-1, -1));
        addView(tVVar);
        com.bytedance.sdk.openadsdk.core.Cc.Bc bc = new com.bytedance.sdk.openadsdk.core.Cc.Bc(context);
        bc.setId(zPa.aP);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams.addRule(13);
        bc.setLayoutParams(layoutParams);
        addView(bc);
        int iMY = BS.MY(context, 44.0f);
        com.bytedance.sdk.openadsdk.core.widget.IlO ilO = new com.bytedance.sdk.openadsdk.core.widget.IlO(context);
        int i2 = zPa.ssS;
        ilO.setId(i2);
        RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(iMY, iMY);
        layoutParams2.addRule(14);
        ilO.setLayoutParams(layoutParams2);
        ilO.setScaleType(ImageView.ScaleType.CENTER_INSIDE);
        bc.addView(ilO);
        com.bytedance.sdk.openadsdk.core.Cc.lEW lew = new com.bytedance.sdk.openadsdk.core.Cc.lEW(context);
        lew.setId(zPa.gQ);
        RelativeLayout.LayoutParams layoutParams3 = new RelativeLayout.LayoutParams(iMY, iMY);
        layoutParams3.addRule(8, i2);
        layoutParams3.addRule(19, i2);
        layoutParams3.addRule(5, i2);
        layoutParams3.addRule(7, i2);
        layoutParams3.addRule(18, i2);
        layoutParams3.addRule(6, i2);
        layoutParams3.addRule(14);
        lew.setLayoutParams(layoutParams3);
        lew.setBackground(com.bytedance.sdk.openadsdk.utils.EV.IlO(context, "tt_circle_solid_mian"));
        lew.setGravity(17);
        lew.setTextColor(-1);
        lew.setTextSize(2, 19.0f);
        lew.setTypeface(Typeface.defaultFromStyle(1));
        lew.setVisibility(8);
        bc.addView(lew);
        com.bytedance.sdk.openadsdk.core.Cc.lEW lew2 = new com.bytedance.sdk.openadsdk.core.Cc.lEW(context);
        int i8 = zPa.HSR;
        lew2.setId(i8);
        RelativeLayout.LayoutParams layoutParams4 = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams4.addRule(3, i2);
        layoutParams4.addRule(14);
        layoutParams4.topMargin = BS.MY(context, 6.0f);
        lew2.setLayoutParams(layoutParams4);
        TextUtils.TruncateAt truncateAt = TextUtils.TruncateAt.END;
        lew2.setEllipsize(truncateAt);
        lew2.setMaxLines(1);
        lew2.setTextColor(-1);
        lew2.setTextSize(2, 12.0f);
        bc.addView(lew2);
        com.bytedance.sdk.openadsdk.core.Cc.lEW lew3 = new com.bytedance.sdk.openadsdk.core.Cc.lEW(context);
        lew3.setId(zPa.AK);
        RelativeLayout.LayoutParams layoutParams5 = new RelativeLayout.LayoutParams(BS.MY(context, 100.0f), BS.MY(context, 28.0f));
        layoutParams5.addRule(14);
        layoutParams5.addRule(3, i8);
        layoutParams5.topMargin = BS.MY(context, 20.0f);
        lew3.setLayoutParams(layoutParams5);
        lew3.setMinWidth(BS.MY(context, 72.0f));
        lew3.setMaxLines(1);
        lew3.setEllipsize(truncateAt);
        lew3.setTextColor(-1);
        lew3.setTextSize(2, 14.0f);
        lew3.setBackground(com.bytedance.sdk.openadsdk.utils.EV.IlO(context, "tt_ad_cover_btn_begin_bg"));
        lew3.setGravity(17);
        int iMY2 = BS.MY(context, 10.0f);
        int iMY3 = BS.MY(context, 2.0f);
        lew3.setPadding(iMY2, iMY3, iMY2, iMY3);
        lew3.setVisibility(8);
        bc.addView(lew3);
    }

    public rp(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public rp(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        IlO(context);
    }
}
