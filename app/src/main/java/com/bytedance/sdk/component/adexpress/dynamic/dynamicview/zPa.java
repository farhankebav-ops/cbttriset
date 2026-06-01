package com.bytedance.sdk.component.adexpress.dynamic.dynamicview;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.widget.ImageView;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes3.dex */
public class zPa extends vCE implements com.bytedance.sdk.component.adexpress.dynamic.MY {
    public zPa(Context context, DynamicRootView dynamicRootView, com.bytedance.sdk.component.adexpress.dynamic.tV.lEW lew) {
        super(context, dynamicRootView, lew);
        ImageView imageView = new ImageView(context);
        this.ea = imageView;
        imageView.setTag(5);
        addView(this.ea, getWidgetLayoutParams());
        dynamicRootView.setMuteListener(this);
        if (dynamicRootView.getRenderRequest() == null || dynamicRootView.getRenderRequest().pP()) {
            return;
        }
        this.ea.setVisibility(8);
        setVisibility(8);
    }

    @Override // com.bytedance.sdk.component.adexpress.dynamic.dynamicview.Cc
    public boolean Cc() {
        return true;
    }

    @Override // com.bytedance.sdk.component.adexpress.dynamic.dynamicview.vCE, com.bytedance.sdk.component.adexpress.dynamic.dynamicview.YA
    public boolean DmF() {
        super.DmF();
        if (com.bytedance.sdk.component.adexpress.tV.MY()) {
            ((ImageView) this.ea).setScaleType(ImageView.ScaleType.FIT_CENTER);
        } else {
            ((ImageView) this.ea).setScaleType(ImageView.ScaleType.CENTER);
        }
        setSoundMute(this.bWL.mIsMute);
        if (!com.bytedance.sdk.component.adexpress.tV.MY()) {
            ((ImageView) this.ea).setBackgroundDrawable(com.bytedance.sdk.component.adexpress.tV.lEW.IlO(0, Integer.valueOf(this.rp.wPn()), new int[]{this.lEW / 2}, null, null, null));
            return true;
        }
        Drawable drawableIlO = com.bytedance.sdk.component.adexpress.tV.EO.IlO(getContext(), this.rp);
        if (drawableIlO == null) {
            return true;
        }
        ((ImageView) this.ea).setBackground(drawableIlO);
        return true;
    }

    @Override // com.bytedance.sdk.component.adexpress.dynamic.MY
    public void setSoundMute(boolean z2) {
        ((ImageView) this.ea).setImageResource(com.bytedance.sdk.component.adexpress.tV.MY() ? z2 ? com.bytedance.sdk.component.utils.pP.tV(getContext(), "tt_reward_full_mute") : com.bytedance.sdk.component.utils.pP.tV(getContext(), "tt_reward_full_unmute") : z2 ? com.bytedance.sdk.component.utils.pP.tV(getContext(), "tt_mute") : com.bytedance.sdk.component.utils.pP.tV(getContext(), "tt_unmute"));
        if (((ImageView) this.ea).getDrawable() != null) {
            ((ImageView) this.ea).getDrawable().setAutoMirrored(true);
        }
    }
}
