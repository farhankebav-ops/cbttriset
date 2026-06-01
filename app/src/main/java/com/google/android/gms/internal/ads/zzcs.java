package com.google.android.gms.internal.ads;

import android.text.Spannable;
import android.text.style.RelativeSizeSpan;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes4.dex */
public final class zzcs {
    public static void zza(Spannable spannable, Object obj, int i2, int i8, int i9) {
        for (Object obj2 : spannable.getSpans(i2, i8, obj.getClass())) {
            zzc(spannable, obj2, i2, i8, 33);
        }
        spannable.setSpan(obj, i2, i8, 33);
    }

    public static void zzb(Spannable spannable, float f4, int i2, int i8, int i9) {
        for (RelativeSizeSpan relativeSizeSpan : (RelativeSizeSpan[]) spannable.getSpans(i2, i8, RelativeSizeSpan.class)) {
            if (spannable.getSpanStart(relativeSizeSpan) <= i2 && spannable.getSpanEnd(relativeSizeSpan) >= i8) {
                f4 = relativeSizeSpan.getSizeChange() * f4;
            }
            zzc(spannable, relativeSizeSpan, i2, i8, 33);
        }
        spannable.setSpan(new RelativeSizeSpan(f4), i2, i8, 33);
    }

    private static void zzc(Spannable spannable, Object obj, int i2, int i8, int i9) {
        if (spannable.getSpanStart(obj) == i2 && spannable.getSpanEnd(obj) == i8 && spannable.getSpanFlags(obj) == 33) {
            spannable.removeSpan(obj);
        }
    }
}
