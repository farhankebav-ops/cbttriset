package com.instagram.common.viewpoint.core;

import android.text.Spannable;

/* JADX INFO: renamed from: com.facebook.ads.redexgen.X.3H, reason: invalid class name */
/* JADX INFO: loaded from: assets/audience_network.dex */
public abstract class C3H {
    public static void A00(Spannable spannable, Object obj, int i2, int i8, int i9) {
        for (Object obj2 : spannable.getSpans(i2, i8, obj.getClass())) {
            if (spannable.getSpanStart(obj2) == i2 && spannable.getSpanEnd(obj2) == i8 && spannable.getSpanFlags(obj2) == i9) {
                spannable.removeSpan(obj2);
            }
        }
        spannable.setSpan(obj, i2, i8, i9);
    }
}
