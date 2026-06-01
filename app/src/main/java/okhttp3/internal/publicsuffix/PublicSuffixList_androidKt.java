package okhttp3.internal.publicsuffix;

import kotlin.jvm.internal.k;
import okhttp3.internal.publicsuffix.PublicSuffixList;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes3.dex */
public final class PublicSuffixList_androidKt {
    public static final PublicSuffixList getDefault(PublicSuffixList.Companion companion) {
        k.e(companion, "<this>");
        return new AssetPublicSuffixList(null, 1, null);
    }
}
