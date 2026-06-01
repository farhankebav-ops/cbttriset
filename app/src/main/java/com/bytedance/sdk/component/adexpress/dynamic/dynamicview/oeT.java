package com.bytedance.sdk.component.adexpress.dynamic.dynamicview;

import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.TextView;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes3.dex */
public class oeT extends Bc implements com.bytedance.sdk.component.adexpress.dynamic.EO {
    private int[] IlO;
    private int MY;
    private int xF;

    public oeT(Context context, DynamicRootView dynamicRootView, com.bytedance.sdk.component.adexpress.dynamic.tV.lEW lew) {
        super(context, dynamicRootView, lew);
        dynamicRootView.setTimeOutListener(this);
    }

    @Override // com.bytedance.sdk.component.adexpress.dynamic.dynamicview.Bc, com.bytedance.sdk.component.adexpress.dynamic.dynamicview.vCE, com.bytedance.sdk.component.adexpress.dynamic.dynamicview.YA
    public boolean DmF() {
        super.DmF();
        ((TextView) this.ea).setText("");
        return true;
    }

    @Override // com.bytedance.sdk.component.adexpress.dynamic.EO
    public void IlO(CharSequence charSequence, boolean z2, int i2, boolean z7) {
        String strIlO = com.bytedance.sdk.component.utils.pP.IlO(com.bytedance.sdk.component.adexpress.tV.IlO(), "tt_reward_screen_skip_tx");
        if (i2 == 0) {
            this.ea.setVisibility(0);
            ((TextView) this.ea).setText("| ".concat(String.valueOf(strIlO)));
            this.ea.measure(-2, -2);
            this.IlO = new int[]{this.ea.getMeasuredWidth() + 1, this.ea.getMeasuredHeight()};
            View view = this.ea;
            int[] iArr = this.IlO;
            view.setLayoutParams(new FrameLayout.LayoutParams(iArr[0], iArr[1]));
            ((TextView) this.ea).setGravity(17);
            ((TextView) this.ea).setIncludeFontPadding(false);
            IlO();
            this.ea.setPadding(this.rp.EO(), this.MY, this.rp.tV(), this.xF);
        }
        requestLayout();
    }

    @Override // android.widget.FrameLayout, android.view.View
    public void onMeasure(int i2, int i8) {
        super.onMeasure(i2, i8);
        if (TextUtils.isEmpty(((TextView) this.ea).getText())) {
            setMeasuredDimension(0, this.lEW);
        } else {
            setMeasuredDimension(this.Bc, this.lEW);
        }
    }

    @Override // com.bytedance.sdk.component.adexpress.dynamic.dynamicview.Cc
    public void vCE() {
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(this.Bc, this.lEW);
        layoutParams.gravity = 8388629;
        layoutParams.setMarginStart(layoutParams.leftMargin);
        layoutParams.setMarginEnd(layoutParams.rightMargin);
        setLayoutParams(layoutParams);
    }

    private void IlO() {
        int iIlO = (int) com.bytedance.sdk.component.adexpress.tV.Bc.IlO(this.EV, this.rp.Cc());
        this.MY = ((this.lEW - iIlO) / 2) - this.rp.IlO();
        this.xF = 0;
    }
}
