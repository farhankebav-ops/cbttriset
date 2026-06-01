package androidx.core.text;

import android.text.Spanned;
import android.text.SpannedString;
import kotlin.jvm.internal.k;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes.dex */
public final class SpannedStringKt {
    public static final <T> T[] getSpans(Spanned spanned, int i2, int i8) {
        k.k();
        throw null;
    }

    public static Object[] getSpans$default(Spanned spanned, int i2, int i8, int i9, Object obj) {
        if ((i9 & 2) != 0) {
            spanned.length();
        }
        k.k();
        throw null;
    }

    public static final Spanned toSpanned(CharSequence charSequence) {
        return SpannedString.valueOf(charSequence);
    }
}
