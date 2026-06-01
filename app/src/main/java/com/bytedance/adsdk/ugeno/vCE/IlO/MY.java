package com.bytedance.adsdk.ugeno.vCE.IlO;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes3.dex */
public class MY extends IlO {
    public MY(Context context) {
        super(context);
    }

    @Override // com.bytedance.adsdk.ugeno.vCE.IlO.IlO
    public Drawable MY(int i2) {
        GradientDrawable gradientDrawable = new GradientDrawable();
        gradientDrawable.setShape(1);
        gradientDrawable.setColor(i2);
        return gradientDrawable;
    }
}
