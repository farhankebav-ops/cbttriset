package okhttp3.internal.idn;

import e6.l;
import kotlin.jvm.internal.k;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes3.dex */
public final class IdnaMappingTableKt {
    public static final int binarySearch(int i2, int i8, l compare) {
        k.e(compare, "compare");
        int i9 = i8 - 1;
        while (i2 <= i9) {
            int i10 = (i2 + i9) / 2;
            int iIntValue = ((Number) compare.invoke(Integer.valueOf(i10))).intValue();
            if (iIntValue < 0) {
                i9 = i10 - 1;
            } else {
                if (iIntValue <= 0) {
                    return i10;
                }
                i2 = i10 + 1;
            }
        }
        return (-i2) - 1;
    }

    public static final int read14BitInt(String str, int i2) {
        k.e(str, "<this>");
        char cCharAt = str.charAt(i2);
        return (cCharAt << 7) + str.charAt(i2 + 1);
    }
}
