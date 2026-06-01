package com.bytedance.sdk.component.adexpress.dynamic.dynamicview;

import android.content.Context;
import android.text.TextUtils;
import android.widget.FrameLayout;
import android.widget.TextView;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes3.dex */
public class OOq extends Bc implements com.bytedance.sdk.component.adexpress.dynamic.EO {
    private boolean IlO;
    private boolean MY;
    private boolean xF;

    public OOq(Context context, DynamicRootView dynamicRootView, com.bytedance.sdk.component.adexpress.dynamic.tV.lEW lew) {
        super(context, dynamicRootView, lew);
        dynamicRootView.setTimeOutListener(this);
        if ("timedown".equals(lew.NV().MY())) {
            dynamicRootView.setTimedown(this.lEW);
        }
    }

    @Override // com.bytedance.sdk.component.adexpress.dynamic.dynamicview.Bc, com.bytedance.sdk.component.adexpress.dynamic.dynamicview.vCE, com.bytedance.sdk.component.adexpress.dynamic.dynamicview.YA
    public boolean DmF() {
        super.DmF();
        if (com.bytedance.sdk.component.adexpress.tV.vCE.MY(this.bWL.getRenderRequest().tV())) {
            setVisibility(8);
        }
        if ("timedown".equals(this.hp.NV().MY())) {
            ((TextView) this.ea).setText(String.valueOf((int) Double.parseDouble(this.rp.NV())));
            return true;
        }
        ((TextView) this.ea).setText(((int) Double.parseDouble(this.rp.NV())) + "s");
        return true;
    }

    @Override // com.bytedance.sdk.component.adexpress.dynamic.EO
    public void IlO(CharSequence charSequence, boolean z2, int i2, boolean z7) {
        if (z7 || this.xF) {
            ((TextView) this.ea).setText("");
            setVisibility(8);
            return;
        }
        try {
            if (Integer.parseInt((String) charSequence) <= 0) {
                setVisibility(8);
                return;
            }
        } catch (Exception unused) {
        }
        setVisibility(0);
        if (!z2 && this.bWL.getRenderRequest().IlO() && com.bytedance.sdk.component.adexpress.tV.vCE.MY(this.bWL.getRenderRequest().tV())) {
            if (com.bytedance.sdk.component.adexpress.tV.MY()) {
                ((TextView) this.ea).setText(i2 + "s");
            } else {
                ((TextView) this.ea).setText(String.format(com.bytedance.sdk.component.utils.pP.IlO(com.bytedance.sdk.component.adexpress.tV.IlO(), "tt_reward_full_skip"), Integer.valueOf(i2)));
            }
            this.IlO = true;
            return;
        }
        if (com.bytedance.sdk.component.adexpress.tV.MY() && !"open_ad".equals(this.bWL.getRenderRequest().tV()) && this.bWL.getRenderRequest().IlO()) {
            this.xF = true;
            setVisibility(8);
            return;
        }
        if ("timedown".equals(this.hp.NV().MY())) {
            ((TextView) this.ea).setText(charSequence);
            return;
        }
        ((TextView) this.ea).setText(((Object) charSequence) + "s");
        this.MY = true;
        if (this.IlO) {
            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams((int) (com.bytedance.sdk.component.adexpress.tV.Bc.IlO(com.bytedance.sdk.component.adexpress.tV.IlO(), this.rp.tV() + this.rp.EO()) + com.bytedance.sdk.component.adexpress.dynamic.Cc.EV.MY(((TextView) this.ea).getText() != null ? r5.toString() : "", this.rp.Cc(), true)[0]), this.lEW);
            layoutParams.gravity = 8388629;
            this.ea.setLayoutParams(layoutParams);
            this.IlO = false;
            requestLayout();
        }
    }

    @Override // android.widget.FrameLayout, android.view.View
    public void onMeasure(int i2, int i8) {
        super.onMeasure(i2, i8);
        if (TextUtils.isEmpty(((TextView) this.ea).getText())) {
            setMeasuredDimension(0, this.lEW);
        }
    }

    @Override // com.bytedance.sdk.component.adexpress.dynamic.dynamicview.Cc
    public void vCE() {
        if (!TextUtils.equals("skip-with-countdowns-video-countdown", this.hp.NV().MY()) && !TextUtils.equals("skip-with-time-countdown", this.hp.NV().MY())) {
            super.vCE();
            return;
        }
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(this.Bc, this.lEW);
        layoutParams.gravity = 8388627;
        if (com.bytedance.sdk.component.adexpress.tV.MY()) {
            layoutParams.leftMargin = this.DmF;
        }
        layoutParams.setMarginStart(layoutParams.leftMargin);
        layoutParams.setMarginEnd(layoutParams.rightMargin);
        setLayoutParams(layoutParams);
    }
}
