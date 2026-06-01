package androidx.core.text;

import android.text.Spannable;
import android.text.SpannableString;
import k6.d;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes.dex */
public final class SpannableStringKt {
    public static final void clearSpans(Spannable spannable) {
        for (Object obj : spannable.getSpans(0, spannable.length(), Object.class)) {
            spannable.removeSpan(obj);
        }
    }

    public static final void set(Spannable spannable, int i2, int i8, Object obj) {
        spannable.setSpan(obj, i2, i8, 17);
    }

    public static final Spannable toSpannable(CharSequence charSequence) {
        return SpannableString.valueOf(charSequence);
    }

    public static final void set(Spannable spannable, d dVar, Object obj) {
        spannable.setSpan(obj, dVar.f12709a, dVar.f12710b, 17);
    }
}
