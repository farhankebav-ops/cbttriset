package com.bytedance.sdk.component.adexpress.dynamic.dynamicview;

import android.content.Context;
import android.graphics.PorterDuff;
import android.text.TextUtils;
import android.widget.ImageView;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes3.dex */
public class bWL extends vCE {
    public bWL(Context context, DynamicRootView dynamicRootView, com.bytedance.sdk.component.adexpress.dynamic.tV.lEW lew) {
        super(context, dynamicRootView, lew);
        ImageView imageView = new ImageView(context);
        this.ea = imageView;
        imageView.setTag(Integer.valueOf(getClickArea()));
        if (com.bytedance.sdk.component.adexpress.tV.MY()) {
            this.lEW = Math.max(dynamicRootView.getLogoUnionHeight(), this.lEW);
        }
        addView(this.ea, getWidgetLayoutParams());
    }

    @Override // com.bytedance.sdk.component.adexpress.dynamic.dynamicview.vCE, com.bytedance.sdk.component.adexpress.dynamic.dynamicview.YA
    public boolean DmF() {
        super.DmF();
        if (com.bytedance.sdk.component.adexpress.tV.MY()) {
            ((ImageView) this.ea).setScaleType(ImageView.ScaleType.CENTER_INSIDE);
        }
        DynamicRootView dynamicRootView = this.bWL;
        if (dynamicRootView == null || dynamicRootView.getRenderRequest() == null || TextUtils.isEmpty(this.bWL.getRenderRequest().tl())) {
            setVisibility(8);
        } else {
            String strTl = this.bWL.getRenderRequest().tl();
            if (strTl.equals("logo")) {
                ((ImageView) this.ea).setImageResource(com.bytedance.sdk.component.utils.pP.tV(getContext(), "tt_ad_logo"));
            } else {
                com.bytedance.sdk.component.Cc.NV nvCc = com.bytedance.sdk.component.adexpress.IlO.IlO.IlO.IlO().Cc().IlO(strTl).IlO(this.Bc).MY(this.lEW).tV(this.Bc).Cc(this.lEW);
                String strBWL = this.bWL.getRenderRequest().bWL();
                if (!TextUtils.isEmpty(strBWL)) {
                    nvCc.MY(strBWL);
                }
                nvCc.IlO((ImageView) this.ea);
            }
        }
        ((ImageView) this.ea).setColorFilter(this.rp.Bc(), PorterDuff.Mode.SRC_IN);
        return true;
    }
}
