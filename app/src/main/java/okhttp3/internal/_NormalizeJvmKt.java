package okhttp3.internal;

import java.text.Normalizer;
import kotlin.jvm.internal.k;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes5.dex */
public final class _NormalizeJvmKt {
    public static final String normalizeNfc(String string) {
        k.e(string, "string");
        String strNormalize = Normalizer.normalize(string, Normalizer.Form.NFC);
        k.d(strNormalize, "normalize(...)");
        return strNormalize;
    }
}
