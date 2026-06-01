package com.bytedance.sdk.component.adexpress.dynamic.dynamicview;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.widget.ImageView;
import android.widget.TextView;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes3.dex */
public class NV extends vCE {
    public NV(Context context, DynamicRootView dynamicRootView, com.bytedance.sdk.component.adexpress.dynamic.tV.lEW lew) {
        super(context, dynamicRootView, lew);
        if (com.bytedance.sdk.component.adexpress.tV.MY()) {
            ImageView imageView = new ImageView(context);
            this.ea = imageView;
            imageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
            this.Bc = this.lEW;
        } else {
            this.ea = new TextView(context);
        }
        this.ea.setTag(3);
        addView(this.ea, getWidgetLayoutParams());
        dynamicRootView.setDislikeView(this.ea);
        if (dynamicRootView.getRenderRequest() != null) {
            if (dynamicRootView.getRenderRequest().lEW() && dynamicRootView.getRenderRequest().pP()) {
                return;
            }
            this.ea.setVisibility(8);
            setVisibility(8);
        }
    }

    @Override // com.bytedance.sdk.component.adexpress.dynamic.dynamicview.vCE, com.bytedance.sdk.component.adexpress.dynamic.dynamicview.YA
    public boolean DmF() {
        super.DmF();
        if (com.bytedance.sdk.component.adexpress.tV.MY()) {
            Drawable drawableIlO = com.bytedance.sdk.component.adexpress.tV.EO.IlO(getContext(), this.rp);
            if (drawableIlO != null) {
                ((ImageView) this.ea).setBackground(drawableIlO);
            }
            ((ImageView) this.ea).setScaleType(ImageView.ScaleType.CENTER_INSIDE);
            int iTV = com.bytedance.sdk.component.utils.pP.tV(getContext(), "tt_reward_full_feedback");
            if (iTV > 0) {
                ((ImageView) this.ea).setImageResource(iTV);
            }
            return true;
        }
        ((TextView) this.ea).setText(getText());
        this.ea.setTextAlignment(this.rp.lEW());
        ((TextView) this.ea).setTextColor(this.rp.Bc());
        ((TextView) this.ea).setTextSize(this.rp.Cc());
        this.ea.setBackground(getBackgroundDrawable());
        if (this.rp.oeT()) {
            int iVAh = this.rp.vAh();
            if (iVAh > 0) {
                ((TextView) this.ea).setLines(iVAh);
                ((TextView) this.ea).setEllipsize(TextUtils.TruncateAt.END);
            }
        } else {
            ((TextView) this.ea).setMaxLines(1);
            ((TextView) this.ea).setGravity(17);
            ((TextView) this.ea).setEllipsize(TextUtils.TruncateAt.END);
        }
        this.ea.setPadding((int) com.bytedance.sdk.component.adexpress.tV.Bc.IlO(com.bytedance.sdk.component.adexpress.tV.IlO(), this.rp.EO()), (int) com.bytedance.sdk.component.adexpress.tV.Bc.IlO(com.bytedance.sdk.component.adexpress.tV.IlO(), this.rp.MY()), (int) com.bytedance.sdk.component.adexpress.tV.Bc.IlO(com.bytedance.sdk.component.adexpress.tV.IlO(), this.rp.tV()), (int) com.bytedance.sdk.component.adexpress.tV.Bc.IlO(com.bytedance.sdk.component.adexpress.tV.IlO(), this.rp.IlO()));
        ((TextView) this.ea).setGravity(17);
        return true;
    }

    public String getText() {
        return com.bytedance.sdk.component.utils.pP.IlO(com.bytedance.sdk.component.adexpress.tV.IlO(), "tt_reward_feedback");
    }
}
