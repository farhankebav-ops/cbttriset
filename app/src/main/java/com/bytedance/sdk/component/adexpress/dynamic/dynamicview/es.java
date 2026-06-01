package com.bytedance.sdk.component.adexpress.dynamic.dynamicview;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.drawable.GradientDrawable;
import androidx.annotation.ColorInt;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes3.dex */
public class es extends vCE {
    public MY IlO;

    public es(Context context, DynamicRootView dynamicRootView, com.bytedance.sdk.component.adexpress.dynamic.tV.lEW lew) {
        super(context, dynamicRootView, lew);
    }

    @Override // com.bytedance.sdk.component.adexpress.dynamic.dynamicview.vCE, com.bytedance.sdk.component.adexpress.dynamic.dynamicview.YA
    public boolean DmF() {
        return super.DmF();
    }

    @Override // com.bytedance.sdk.component.adexpress.dynamic.dynamicview.Cc
    public MY IlO(Bitmap bitmap) {
        IlO ilO = new IlO(bitmap, this.IlO);
        this.IlO = ilO;
        return ilO;
    }

    @Override // com.bytedance.sdk.component.adexpress.dynamic.dynamicview.Cc
    public GradientDrawable getDrawable() {
        MY my = new MY();
        this.IlO = my;
        return my;
    }

    @Override // com.bytedance.sdk.component.adexpress.dynamic.dynamicview.Cc
    public GradientDrawable IlO(GradientDrawable.Orientation orientation, @ColorInt int[] iArr) {
        MY my = new MY(orientation, iArr);
        this.IlO = my;
        return my;
    }
}
