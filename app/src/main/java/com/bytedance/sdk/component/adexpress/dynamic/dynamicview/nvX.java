package com.bytedance.sdk.component.adexpress.dynamic.dynamicview;

import a1.a;
import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.GradientDrawable;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.TextView;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes3.dex */
public class nvX extends vCE implements com.bytedance.sdk.component.adexpress.dynamic.Cc {
    TextView IlO;
    FrameLayout MY;
    boolean xF;

    public nvX(Context context, DynamicRootView dynamicRootView, com.bytedance.sdk.component.adexpress.dynamic.tV.lEW lew) {
        super(context, dynamicRootView, lew);
        this.xF = false;
        View view = new View(context);
        this.ea = view;
        view.setTag(Integer.valueOf(getClickArea()));
        this.IlO = new TextView(context);
        this.MY = new FrameLayout(context);
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams((int) com.bytedance.sdk.component.adexpress.tV.Bc.IlO(context, 40.0f), (int) com.bytedance.sdk.component.adexpress.tV.Bc.IlO(context, 15.0f));
        layoutParams.gravity = 8388693;
        layoutParams.rightMargin = 20;
        layoutParams.bottomMargin = 20;
        this.IlO.setLayoutParams(layoutParams);
        GradientDrawable gradientDrawable = new GradientDrawable();
        gradientDrawable.setShape(0);
        gradientDrawable.setCornerRadius(25.0f);
        gradientDrawable.setColor(Color.parseColor("#57000000"));
        this.IlO.setBackground(gradientDrawable);
        this.IlO.setTextSize(10.0f);
        this.IlO.setGravity(17);
        this.IlO.setTextColor(-1);
        this.IlO.setVisibility(8);
        if (com.bytedance.sdk.component.adexpress.tV.MY()) {
            addView(this.MY, new FrameLayout.LayoutParams(-1, -1));
        }
        addView(this.IlO);
        addView(this.ea, getWidgetLayoutParams());
        if (!com.bytedance.sdk.component.adexpress.tV.MY()) {
            addView(this.MY, getWidgetLayoutParams());
        }
        dynamicRootView.videoView = this.MY;
        dynamicRootView.setVideoListener(this);
    }

    private void EO(View view) {
        if (view == this.IlO || view == ((vCE) this).es) {
            return;
        }
        try {
            if (((Integer) view.getTag(com.bytedance.sdk.component.adexpress.dynamic.IlO.vCE)).intValue() == 1) {
                return;
            }
        } catch (Throwable unused) {
        }
        int i2 = 0;
        view.setVisibility(0);
        if (!(view instanceof ViewGroup)) {
            return;
        }
        while (true) {
            ViewGroup viewGroup = (ViewGroup) view;
            if (i2 >= viewGroup.getChildCount()) {
                return;
            }
            EO(viewGroup.getChildAt(i2));
            i2++;
        }
    }

    @Override // com.bytedance.sdk.component.adexpress.dynamic.dynamicview.Cc
    public boolean Cc() {
        return true;
    }

    @Override // com.bytedance.sdk.component.adexpress.dynamic.dynamicview.vCE, com.bytedance.sdk.component.adexpress.dynamic.dynamicview.YA
    public boolean DmF() {
        super.DmF();
        double dCc = 0.0d;
        double dTV = 0.0d;
        for (com.bytedance.sdk.component.adexpress.dynamic.tV.lEW lewRp = this.hp; lewRp != null; lewRp = lewRp.rp()) {
            double dVCE = dTV + ((double) lewRp.vCE());
            double dBc = dCc + ((double) lewRp.Bc());
            dTV = dVCE - ((double) lewRp.tV());
            dCc = dBc - ((double) lewRp.Cc());
        }
        try {
            float f4 = (float) dTV;
            int iIlO = (int) com.bytedance.sdk.component.adexpress.tV.Bc.IlO(getContext(), f4);
            int iIlO2 = (int) com.bytedance.sdk.component.adexpress.tV.Bc.IlO(getContext(), f4 + this.Cc);
            if (com.bytedance.sdk.component.adexpress.tV.MY.IlO(getContext())) {
                int dynamicWidth = ((es) this.bWL.getChildAt(0)).getDynamicWidth();
                int i2 = dynamicWidth - iIlO2;
                iIlO2 = dynamicWidth - iIlO;
                iIlO = i2;
            }
            if ("open_ad".equals(this.bWL.getRenderRequest().tV())) {
                this.bWL.videoView = this.MY;
            } else {
                float f8 = (float) dCc;
                ((es) this.bWL.getChildAt(0)).IlO.IlO(iIlO, (int) com.bytedance.sdk.component.adexpress.tV.Bc.IlO(getContext(), f8), iIlO2, (int) com.bytedance.sdk.component.adexpress.tV.Bc.IlO(getContext(), f8 + this.vCE));
            }
        } catch (Exception unused) {
        }
        this.bWL.updateRenderInfoForVideo(dTV, dCc, this.Cc, this.vCE, this.rp.ea());
        return true;
    }

    @Override // com.bytedance.sdk.component.adexpress.dynamic.Cc
    public void IlO() {
        this.IlO.setVisibility(8);
    }

    @Override // com.bytedance.sdk.component.adexpress.dynamic.Cc
    public void setTimeUpdate(int i2) {
        if (!this.hp.NV().Cc().BC() || i2 <= 0 || this.xF) {
            this.xF = true;
            for (int i8 = 0; i8 < getChildCount(); i8++) {
                EO(getChildAt(i8));
            }
            this.IlO.setVisibility(8);
            return;
        }
        String strC = a.C(i2 >= 60 ? "0" + (i2 / 60) : "00", ":");
        int i9 = i2 % 60;
        this.IlO.setText(i9 > 9 ? strC + i9 : strC + "0" + i9);
        this.IlO.setVisibility(0);
    }
}
