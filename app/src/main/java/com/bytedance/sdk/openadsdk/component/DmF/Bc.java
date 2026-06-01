package com.bytedance.sdk.openadsdk.component.DmF;

import android.content.Context;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import androidx.annotation.NonNull;
import com.bytedance.sdk.component.utils.pP;
import com.bytedance.sdk.openadsdk.core.cl;
import com.bytedance.sdk.openadsdk.utils.BS;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes3.dex */
public class Bc extends com.bytedance.sdk.openadsdk.core.Cc.Bc {
    private final com.bytedance.sdk.openadsdk.core.Cc.lEW EO;
    private final com.bytedance.sdk.openadsdk.core.Cc.tV IlO;
    private final com.bytedance.sdk.openadsdk.core.Cc.tV MY;

    public Bc(@NonNull Context context) {
        super(context);
        setLayoutParams(new RelativeLayout.LayoutParams(-1, -2));
        int iMY = BS.MY(context, 12.0f);
        int iMY2 = BS.MY(context, 16.0f);
        int iMY3 = BS.MY(context, 20.0f);
        int iMY4 = BS.MY(context, 24.0f);
        int iMY5 = BS.MY(context, 28.0f);
        com.bytedance.sdk.openadsdk.core.Cc.tV tVVar = new com.bytedance.sdk.openadsdk.core.Cc.tV(context);
        this.IlO = tVVar;
        tVVar.setId(520093713);
        int iMY6 = BS.MY(getContext(), 5.0f);
        tVVar.setPadding(iMY6, iMY6, iMY6, iMY6);
        ImageView.ScaleType scaleType = ImageView.ScaleType.CENTER;
        tVVar.setScaleType(scaleType);
        tVVar.setBackground(com.bytedance.sdk.openadsdk.core.widget.tV.IlO());
        tVVar.setImageResource(pP.tV(cl.IlO(), "tt_reward_full_feedback"));
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(iMY5, iMY5);
        layoutParams.topMargin = iMY3;
        layoutParams.leftMargin = iMY2;
        layoutParams.setMarginStart(iMY2);
        tVVar.setLayoutParams(layoutParams);
        com.bytedance.sdk.openadsdk.core.Cc.tV tVVar2 = new com.bytedance.sdk.openadsdk.core.Cc.tV(context);
        this.MY = tVVar2;
        tVVar2.setId(520093714);
        tVVar2.setPadding(iMY6, iMY6, iMY6, iMY6);
        tVVar2.setScaleType(scaleType);
        tVVar2.setBackground(com.bytedance.sdk.openadsdk.core.widget.tV.IlO());
        tVVar2.setImageResource(pP.tV(cl.IlO(), "tt_close_btn"));
        if (tVVar2.getDrawable() != null) {
            tVVar2.getDrawable().setAutoMirrored(true);
        }
        RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(iMY5, iMY5);
        layoutParams2.topMargin = iMY3;
        layoutParams2.rightMargin = iMY2;
        layoutParams2.setMarginEnd(iMY2);
        layoutParams2.addRule(11);
        layoutParams2.addRule(21);
        tVVar2.setLayoutParams(layoutParams2);
        tVVar2.setVisibility(4);
        com.bytedance.sdk.openadsdk.core.Cc.lEW lew = new com.bytedance.sdk.openadsdk.core.Cc.lEW(context);
        this.EO = lew;
        RelativeLayout.LayoutParams layoutParams3 = new RelativeLayout.LayoutParams(-2, iMY4);
        layoutParams3.topMargin = iMY3;
        layoutParams3.rightMargin = iMY2;
        layoutParams3.addRule(11);
        layoutParams3.setMarginEnd(iMY2);
        layoutParams3.addRule(21);
        lew.setLayoutParams(layoutParams3);
        lew.setBackground(com.bytedance.sdk.openadsdk.core.widget.tV.MY());
        lew.setGravity(17);
        lew.setPadding(iMY, 0, iMY, 0);
        lew.setTextColor(-1);
        lew.setTextSize(1, 14.0f);
        lew.setVisibility(4);
        addView(tVVar);
        addView(lew);
        addView(tVVar2);
    }

    public com.bytedance.sdk.openadsdk.core.Cc.lEW getTopCountDown() {
        return this.EO;
    }

    public View getTopDislike() {
        return this.IlO;
    }

    public com.bytedance.sdk.openadsdk.core.Cc.tV getTopSkip() {
        return this.MY;
    }
}
