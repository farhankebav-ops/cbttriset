package com.google.android.material.datepicker;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.Paint;
import com.cbt.exam.browser.R;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes4.dex */
public final class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final w1.f f5343a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final w1.f f5344b;

    public c(Context context) {
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(t1.b.c(context, R.attr.materialCalendarStyle, n.class.getCanonicalName()).data, b1.a.p);
        w1.f.c(context, typedArrayObtainStyledAttributes.getResourceId(4, 0));
        w1.f.c(context, typedArrayObtainStyledAttributes.getResourceId(2, 0));
        w1.f.c(context, typedArrayObtainStyledAttributes.getResourceId(3, 0));
        w1.f.c(context, typedArrayObtainStyledAttributes.getResourceId(5, 0));
        ColorStateList colorStateListA = t1.c.a(context, typedArrayObtainStyledAttributes, 7);
        this.f5343a = w1.f.c(context, typedArrayObtainStyledAttributes.getResourceId(9, 0));
        w1.f.c(context, typedArrayObtainStyledAttributes.getResourceId(8, 0));
        this.f5344b = w1.f.c(context, typedArrayObtainStyledAttributes.getResourceId(10, 0));
        new Paint().setColor(colorStateListA.getDefaultColor());
        typedArrayObtainStyledAttributes.recycle();
    }
}
