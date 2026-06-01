package com.bytedance.sdk.component.adexpress.dynamic.dynamicview;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.widget.ImageView;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes3.dex */
public class oc extends vCE implements com.bytedance.sdk.component.adexpress.dynamic.EO {
    private boolean IlO;

    public oc(Context context, DynamicRootView dynamicRootView, com.bytedance.sdk.component.adexpress.dynamic.tV.lEW lew) {
        super(context, dynamicRootView, lew);
        if (dynamicRootView.getRenderRequest() != null) {
            this.IlO = dynamicRootView.getRenderRequest().hp();
        }
        this.Bc = this.lEW;
        ImageView imageView = new ImageView(context);
        this.ea = imageView;
        imageView.setTag(Integer.valueOf(getClickArea()));
        addView(this.ea, getWidgetLayoutParams());
        dynamicRootView.setTimeOutListener(this);
        if (dynamicRootView.getRenderRequest() == null || dynamicRootView.getRenderRequest().pP()) {
            return;
        }
        this.ea.setVisibility(8);
        setVisibility(8);
    }

    @Override // com.bytedance.sdk.component.adexpress.dynamic.dynamicview.vCE, com.bytedance.sdk.component.adexpress.dynamic.dynamicview.YA
    public boolean DmF() {
        Drawable drawableEO;
        super.DmF();
        ((ImageView) this.ea).setScaleType(ImageView.ScaleType.CENTER_CROP);
        Drawable drawableIlO = com.bytedance.sdk.component.adexpress.tV.EO.IlO(getContext(), this.rp);
        if (drawableIlO != null) {
            ((ImageView) this.ea).setBackground(drawableIlO);
        }
        if (this.IlO) {
            drawableEO = com.bytedance.sdk.component.utils.pP.EO(getContext(), "tt_close_btn");
        } else {
            drawableEO = com.bytedance.sdk.component.utils.pP.EO(getContext(), "tt_skip_btn");
            if (drawableEO != null) {
                drawableEO.setAutoMirrored(true);
            }
        }
        if (drawableEO != null) {
            ((ImageView) this.ea).setImageDrawable(drawableEO);
        }
        setVisibility(8);
        return true;
    }

    @Override // com.bytedance.sdk.component.adexpress.dynamic.EO
    public void IlO(CharSequence charSequence, boolean z2, int i2, boolean z7) {
        int i8 = 0;
        if (!z2 && !z7) {
            i8 = 8;
        }
        setVisibility(i8);
    }
}
