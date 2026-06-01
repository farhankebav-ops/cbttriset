package com.bytedance.sdk.component.adexpress.dynamic.dynamicview;

import android.content.Context;
import android.text.TextUtils;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.TextView;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes3.dex */
public class AXM extends Bc implements com.bytedance.sdk.component.adexpress.dynamic.EO {
    public AXM(Context context, DynamicRootView dynamicRootView, com.bytedance.sdk.component.adexpress.dynamic.tV.lEW lew) {
        super(context, dynamicRootView, lew);
        dynamicRootView.setTimeOutListener(this);
    }

    @Override // com.bytedance.sdk.component.adexpress.dynamic.EO
    public void IlO(CharSequence charSequence, boolean z2, int i2, boolean z7) {
        if (i2 != 0) {
            ((TextView) this.ea).setText(" | ".concat(String.format(com.bytedance.sdk.component.utils.pP.IlO(com.bytedance.sdk.component.adexpress.tV.IlO(), "tt_reward_full_skip_count_down"), Integer.valueOf(i2))));
        } else if (getParent() != null) {
            ((ViewGroup) getParent()).removeView(this);
        }
        requestLayout();
    }

    @Override // com.bytedance.sdk.component.adexpress.dynamic.dynamicview.Bc, com.bytedance.sdk.component.adexpress.dynamic.dynamicview.vCE
    public FrameLayout.LayoutParams getWidgetLayoutParams() {
        return new FrameLayout.LayoutParams(-2, -2);
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
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(this.Bc, this.lEW);
        int i2 = this.DmF;
        layoutParams.leftMargin = i2;
        layoutParams.gravity = 16;
        layoutParams.setMarginStart(i2);
        layoutParams.setMarginEnd(layoutParams.rightMargin);
        setLayoutParams(layoutParams);
    }
}
