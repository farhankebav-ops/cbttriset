package com.bytedance.sdk.component.adexpress.dynamic.dynamicview;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.view.View;
import android.widget.ImageView;
import androidx.annotation.NonNull;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes3.dex */
public class DmF extends vCE {
    public DmF(Context context, @NonNull DynamicRootView dynamicRootView, @NonNull com.bytedance.sdk.component.adexpress.dynamic.tV.lEW lew) {
        super(context, dynamicRootView, lew);
        if (com.bytedance.sdk.component.adexpress.tV.MY()) {
            this.ea = new ImageView(context);
        } else {
            this.ea = new com.bytedance.sdk.component.adexpress.vCE.DmF(context);
        }
        this.ea.setTag(3);
        addView(this.ea, getWidgetLayoutParams());
        dynamicRootView.setDislikeView(this.ea);
    }

    @Override // com.bytedance.sdk.component.adexpress.dynamic.dynamicview.vCE, com.bytedance.sdk.component.adexpress.dynamic.dynamicview.YA
    public boolean DmF() {
        super.DmF();
        if (com.bytedance.sdk.component.adexpress.tV.MY()) {
            Drawable drawableIlO = com.bytedance.sdk.component.adexpress.tV.EO.IlO(getContext(), this.rp);
            if (drawableIlO != null) {
                this.ea.setBackground(drawableIlO);
            }
            int iTV = com.bytedance.sdk.component.utils.pP.tV(getContext(), "tt_close_btn");
            if (iTV > 0) {
                ((ImageView) this.ea).setImageResource(iTV);
            }
            ((ImageView) this.ea).setScaleType(ImageView.ScaleType.FIT_XY);
            return true;
        }
        int iIlO = (int) com.bytedance.sdk.component.adexpress.tV.Bc.IlO(this.EV, this.rp.cl());
        View view = this.ea;
        if (view instanceof com.bytedance.sdk.component.adexpress.vCE.DmF) {
            ((com.bytedance.sdk.component.adexpress.vCE.DmF) view).setRadius((int) com.bytedance.sdk.component.adexpress.tV.Bc.IlO(this.EV, this.rp.ea()));
            ((com.bytedance.sdk.component.adexpress.vCE.DmF) this.ea).setStrokeWidth(iIlO);
            ((com.bytedance.sdk.component.adexpress.vCE.DmF) this.ea).setStrokeColor(this.rp.zPa());
            ((com.bytedance.sdk.component.adexpress.vCE.DmF) this.ea).setBgColor(this.rp.wPn());
            ((com.bytedance.sdk.component.adexpress.vCE.DmF) this.ea).setDislikeColor(this.rp.Bc());
            ((com.bytedance.sdk.component.adexpress.vCE.DmF) this.ea).setDislikeWidth((int) com.bytedance.sdk.component.adexpress.tV.Bc.IlO(this.EV, 1.0f));
        }
        return true;
    }
}
