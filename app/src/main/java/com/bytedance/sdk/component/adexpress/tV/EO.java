package com.bytedance.sdk.component.adexpress.tV;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes3.dex */
public class EO {
    public static Drawable IlO(Context context, com.bytedance.sdk.component.adexpress.dynamic.tV.Bc bc) {
        if (context == null || bc == null) {
            return null;
        }
        return IlO(context, (int) Bc.IlO(context, bc.cl()), bc.zPa(), bc.wPn());
    }

    public static Drawable IlO(Context context, int i2, int i8, int i9) {
        GradientDrawable gradientDrawable = new GradientDrawable();
        gradientDrawable.setShape(1);
        if (context != null) {
            gradientDrawable.setStroke(i2, i8);
        }
        gradientDrawable.setColor(i9);
        return gradientDrawable;
    }
}
