package com.bytedance.sdk.component.adexpress.dynamic.dynamicview;

import android.content.Context;
import android.text.TextUtils;
import android.widget.FrameLayout;
import android.widget.TextView;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes3.dex */
public class Bc extends vCE {
    public Bc(Context context, DynamicRootView dynamicRootView, com.bytedance.sdk.component.adexpress.dynamic.tV.lEW lew) {
        super(context, dynamicRootView, lew);
        com.bytedance.sdk.component.adexpress.dynamic.animation.view.IlO ilO = new com.bytedance.sdk.component.adexpress.dynamic.animation.view.IlO(context);
        this.ea = ilO;
        ilO.setTag(Integer.valueOf(getClickArea()));
        addView(this.ea, getWidgetLayoutParams());
    }

    @Override // com.bytedance.sdk.component.adexpress.dynamic.dynamicview.vCE, com.bytedance.sdk.component.adexpress.dynamic.dynamicview.YA
    public boolean DmF() {
        super.DmF();
        if (TextUtils.equals("download-progress-button", this.hp.NV().MY()) && TextUtils.isEmpty(this.rp.NV())) {
            this.ea.setVisibility(4);
            return true;
        }
        this.ea.setTextAlignment(this.rp.lEW());
        ((TextView) this.ea).setText(this.rp.NV());
        ((TextView) this.ea).setTextColor(this.rp.Bc());
        ((TextView) this.ea).setTextSize(this.rp.Cc());
        ((TextView) this.ea).setGravity(17);
        ((TextView) this.ea).setIncludeFontPadding(false);
        if ("fillButton".equals(this.hp.NV().MY())) {
            this.ea.setPadding(0, 0, 0, 0);
        } else {
            this.ea.setPadding(this.rp.EO(), this.rp.MY(), this.rp.tV(), this.rp.IlO());
        }
        return true;
    }

    @Override // com.bytedance.sdk.component.adexpress.dynamic.dynamicview.vCE
    public FrameLayout.LayoutParams getWidgetLayoutParams() {
        if (!com.bytedance.sdk.component.adexpress.tV.MY() || !"fillButton".equals(this.hp.NV().MY())) {
            return super.getWidgetLayoutParams();
        }
        ((TextView) this.ea).setEllipsize(TextUtils.TruncateAt.END);
        ((TextView) this.ea).setMaxLines(1);
        FrameLayout.LayoutParams widgetLayoutParams = super.getWidgetLayoutParams();
        widgetLayoutParams.width -= this.rp.cL() * 2;
        widgetLayoutParams.height -= this.rp.cL() * 2;
        widgetLayoutParams.topMargin = this.rp.cL() + widgetLayoutParams.topMargin;
        int iCL = this.rp.cL() + widgetLayoutParams.leftMargin;
        widgetLayoutParams.leftMargin = iCL;
        widgetLayoutParams.setMarginStart(iCL);
        widgetLayoutParams.setMarginEnd(widgetLayoutParams.rightMargin);
        return widgetLayoutParams;
    }
}
