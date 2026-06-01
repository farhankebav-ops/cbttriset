package androidx.core.text;

import android.text.Html;
import android.text.Spanned;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes.dex */
public final class HtmlKt {
    public static final Spanned parseAsHtml(String str, int i2, Html.ImageGetter imageGetter, Html.TagHandler tagHandler) {
        return HtmlCompat.fromHtml(str, i2, imageGetter, tagHandler);
    }

    public static /* synthetic */ Spanned parseAsHtml$default(String str, int i2, Html.ImageGetter imageGetter, Html.TagHandler tagHandler, int i8, Object obj) {
        if ((i8 & 1) != 0) {
            i2 = 0;
        }
        if ((i8 & 2) != 0) {
            imageGetter = null;
        }
        if ((i8 & 4) != 0) {
            tagHandler = null;
        }
        return HtmlCompat.fromHtml(str, i2, imageGetter, tagHandler);
    }

    public static final String toHtml(Spanned spanned, int i2) {
        return HtmlCompat.toHtml(spanned, i2);
    }

    public static /* synthetic */ String toHtml$default(Spanned spanned, int i2, int i8, Object obj) {
        if ((i8 & 1) != 0) {
            i2 = 0;
        }
        return HtmlCompat.toHtml(spanned, i2);
    }
}
