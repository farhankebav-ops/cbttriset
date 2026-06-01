package com.bytedance.sdk.component.adexpress.dynamic.dynamicview;

import android.content.Context;
import android.widget.FrameLayout;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes3.dex */
public class vAh extends vCE implements com.bytedance.sdk.component.adexpress.dynamic.EO {
    private int IlO;
    private int MY;
    private int xF;

    public vAh(Context context, DynamicRootView dynamicRootView, com.bytedance.sdk.component.adexpress.dynamic.tV.lEW lew) {
        super(context, dynamicRootView, lew);
        setTag(Integer.valueOf(getClickArea()));
        dynamicRootView.setTimeOutListener(this);
        IlO();
    }

    @Override // com.bytedance.sdk.component.adexpress.dynamic.dynamicview.vCE, com.bytedance.sdk.component.adexpress.dynamic.dynamicview.YA
    public boolean DmF() {
        setBackground(getBackgroundDrawable());
        setPadding((int) com.bytedance.sdk.component.adexpress.tV.Bc.IlO(com.bytedance.sdk.component.adexpress.tV.IlO(), this.rp.EO()), (int) com.bytedance.sdk.component.adexpress.tV.Bc.IlO(com.bytedance.sdk.component.adexpress.tV.IlO(), this.rp.MY()), (int) com.bytedance.sdk.component.adexpress.tV.Bc.IlO(com.bytedance.sdk.component.adexpress.tV.IlO(), this.rp.tV()), (int) com.bytedance.sdk.component.adexpress.tV.Bc.IlO(com.bytedance.sdk.component.adexpress.tV.IlO(), this.rp.IlO()));
        return true;
    }

    @Override // com.bytedance.sdk.component.adexpress.dynamic.EO
    public void IlO(CharSequence charSequence, boolean z2, int i2, boolean z7) {
        this.xF = i2;
    }

    @Override // com.bytedance.sdk.component.adexpress.dynamic.dynamicview.vCE
    public FrameLayout.LayoutParams getWidgetLayoutParams() {
        return new FrameLayout.LayoutParams(-2, -2);
    }

    @Override // android.widget.FrameLayout, android.view.View
    public void onMeasure(int i2, int i8) {
        super.onMeasure(i2, i8);
        if (this.xF == 0) {
            setMeasuredDimension(this.MY, this.lEW);
        } else {
            setMeasuredDimension(this.IlO, this.lEW);
        }
    }

    @Override // com.bytedance.sdk.component.adexpress.dynamic.dynamicview.Cc
    public void vCE() {
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-2, -2);
        int i2 = this.DmF;
        layoutParams.leftMargin = i2;
        layoutParams.topMargin = this.NV;
        layoutParams.setMarginStart(i2);
        layoutParams.setMarginEnd(layoutParams.rightMargin);
        setLayoutParams(layoutParams);
    }

    private void IlO() {
        List<com.bytedance.sdk.component.adexpress.dynamic.tV.lEW> listEV = this.hp.EV();
        if (listEV == null || listEV.size() <= 0) {
            return;
        }
        for (com.bytedance.sdk.component.adexpress.dynamic.tV.lEW lew : listEV) {
            if (lew.NV().IlO() == 21) {
                this.IlO = (int) (this.Bc - com.bytedance.sdk.component.adexpress.tV.Bc.IlO(this.EV, lew.lEW()));
            }
            if (lew.NV().IlO() == 20) {
                this.MY = (int) (this.Bc - com.bytedance.sdk.component.adexpress.tV.Bc.IlO(this.EV, lew.lEW()));
            }
        }
    }
}
