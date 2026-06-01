package com.bytedance.sdk.component.adexpress.dynamic.dynamicview;

import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import android.widget.FrameLayout;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes3.dex */
public class wPn extends vCE implements com.bytedance.sdk.component.adexpress.dynamic.EO {
    private int AXM;
    int IlO;
    boolean MY;
    private boolean oeT;
    private int xF;

    public wPn(Context context, DynamicRootView dynamicRootView, com.bytedance.sdk.component.adexpress.dynamic.tV.lEW lew) {
        super(context, dynamicRootView, lew);
        this.AXM = 0;
        setTag(Integer.valueOf(getClickArea()));
        IlO();
        dynamicRootView.setTimeOutListener(this);
        if (dynamicRootView.getRenderRequest() == null || dynamicRootView.getRenderRequest().pP()) {
            return;
        }
        View view = this.ea;
        if (view != null) {
            view.setVisibility(8);
        }
        setVisibility(8);
    }

    private void IlO() {
        List<com.bytedance.sdk.component.adexpress.dynamic.tV.lEW> listEV = this.hp.EV();
        if (listEV == null || listEV.size() <= 0) {
            return;
        }
        Iterator<com.bytedance.sdk.component.adexpress.dynamic.tV.lEW> it = listEV.iterator();
        while (true) {
            if (!it.hasNext()) {
                break;
            }
            com.bytedance.sdk.component.adexpress.dynamic.tV.lEW next = it.next();
            if (TextUtils.equals("skip-with-time-skip-btn", next.NV().MY())) {
                int iIlO = (int) com.bytedance.sdk.component.adexpress.tV.Bc.IlO(this.EV, next.lEW() + (com.bytedance.sdk.component.adexpress.tV.MY() ? next.hp() : 0));
                this.xF = iIlO;
                this.IlO = this.Bc - iIlO;
            }
        }
        this.AXM = this.Bc - this.IlO;
    }

    @Override // com.bytedance.sdk.component.adexpress.dynamic.dynamicview.vCE, com.bytedance.sdk.component.adexpress.dynamic.dynamicview.YA
    public boolean DmF() {
        if (com.bytedance.sdk.component.adexpress.tV.vCE.MY(this.bWL.getRenderRequest().tV())) {
            return true;
        }
        super.DmF();
        setPadding((int) com.bytedance.sdk.component.adexpress.tV.Bc.IlO(com.bytedance.sdk.component.adexpress.tV.IlO(), this.rp.EO()), (int) com.bytedance.sdk.component.adexpress.tV.Bc.IlO(com.bytedance.sdk.component.adexpress.tV.IlO(), this.rp.MY()), (int) com.bytedance.sdk.component.adexpress.tV.Bc.IlO(com.bytedance.sdk.component.adexpress.tV.IlO(), this.rp.tV()), (int) com.bytedance.sdk.component.adexpress.tV.Bc.IlO(com.bytedance.sdk.component.adexpress.tV.IlO(), this.rp.IlO()));
        return true;
    }

    @Override // com.bytedance.sdk.component.adexpress.dynamic.dynamicview.vCE
    public FrameLayout.LayoutParams getWidgetLayoutParams() {
        return new FrameLayout.LayoutParams(-2, -2);
    }

    @Override // android.widget.FrameLayout, android.view.View
    public void onMeasure(int i2, int i8) {
        super.onMeasure(i2, i8);
        if (this.oeT && this.rp != null) {
            setMeasuredDimension(this.xF + ((int) com.bytedance.sdk.component.adexpress.tV.Bc.IlO(com.bytedance.sdk.component.adexpress.tV.IlO(), this.rp.EO())) + ((int) com.bytedance.sdk.component.adexpress.tV.Bc.IlO(com.bytedance.sdk.component.adexpress.tV.IlO(), this.rp.tV())), this.lEW);
        } else if (this.MY) {
            setMeasuredDimension(this.Bc, this.lEW);
        } else {
            setMeasuredDimension(this.IlO, this.lEW);
        }
    }

    @Override // com.bytedance.sdk.component.adexpress.dynamic.dynamicview.Cc
    public void vCE() {
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-2, -2);
        if (this.MY) {
            layoutParams.leftMargin = this.DmF;
        } else {
            layoutParams.leftMargin = this.DmF + this.AXM;
        }
        if (this.oeT && this.rp != null) {
            layoutParams.leftMargin = ((this.DmF + this.AXM) - ((int) com.bytedance.sdk.component.adexpress.tV.Bc.IlO(com.bytedance.sdk.component.adexpress.tV.IlO(), this.rp.EO()))) - ((int) com.bytedance.sdk.component.adexpress.tV.Bc.IlO(com.bytedance.sdk.component.adexpress.tV.IlO(), this.rp.tV()));
        }
        if (com.bytedance.sdk.component.adexpress.tV.MY()) {
            layoutParams.topMargin = this.NV - ((int) com.bytedance.sdk.component.adexpress.tV.Bc.IlO(com.bytedance.sdk.component.adexpress.tV.IlO(), this.rp.MY()));
        } else {
            layoutParams.topMargin = this.NV;
        }
        layoutParams.setMarginStart(layoutParams.leftMargin);
        layoutParams.setMarginEnd(layoutParams.rightMargin);
        setLayoutParams(layoutParams);
    }

    @Override // com.bytedance.sdk.component.adexpress.dynamic.EO
    public void IlO(CharSequence charSequence, boolean z2, int i2, boolean z7) {
        if (z7 && this.oeT != z7) {
            this.oeT = z7;
            vCE();
            return;
        }
        if (z2 && this.MY != z2) {
            this.MY = z2;
            vCE();
        }
        this.MY = z2;
    }
}
