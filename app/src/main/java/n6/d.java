package n6;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes5.dex */
public abstract class d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final int[] f13086a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final long[] f13087b;

    static {
        int[] iArr = new int[256];
        int i2 = 0;
        for (int i8 = 0; i8 < 256; i8++) {
            iArr[i8] = "0123456789abcdef".charAt(i8 & 15) | ("0123456789abcdef".charAt(i8 >> 4) << '\b');
        }
        f13086a = iArr;
        int[] iArr2 = new int[256];
        for (int i9 = 0; i9 < 256; i9++) {
            iArr2[i9] = "0123456789ABCDEF".charAt(i9 & 15) | ("0123456789ABCDEF".charAt(i9 >> 4) << '\b');
        }
        int[] iArr3 = new int[256];
        for (int i10 = 0; i10 < 256; i10++) {
            iArr3[i10] = -1;
        }
        int i11 = 0;
        int i12 = 0;
        while (i11 < "0123456789abcdef".length()) {
            iArr3["0123456789abcdef".charAt(i11)] = i12;
            i11++;
            i12++;
        }
        int i13 = 0;
        int i14 = 0;
        while (i13 < "0123456789ABCDEF".length()) {
            iArr3["0123456789ABCDEF".charAt(i13)] = i14;
            i13++;
            i14++;
        }
        long[] jArr = new long[256];
        for (int i15 = 0; i15 < 256; i15++) {
            jArr[i15] = -1;
        }
        int i16 = 0;
        int i17 = 0;
        while (i16 < "0123456789abcdef".length()) {
            jArr["0123456789abcdef".charAt(i16)] = i17;
            i16++;
            i17++;
        }
        int i18 = 0;
        while (i2 < "0123456789ABCDEF".length()) {
            jArr["0123456789ABCDEF".charAt(i2)] = i18;
            i2++;
            i18++;
        }
        f13087b = jArr;
    }

    public static final void a(int i2, int i8, String str) {
        int i9 = i8 - i2;
        if (i9 < 1) {
            String strSubstring = str.substring(i2, i8);
            kotlin.jvm.internal.k.d(strSubstring, "substring(...)");
            throw new NumberFormatException("Expected at least 1 hexadecimal digits at index " + i2 + ", but was \"" + strSubstring + "\" of length " + i9);
        }
        if (i9 > 16) {
            int i10 = (i9 + i2) - 16;
            while (i2 < i10) {
                if (str.charAt(i2) != '0') {
                    StringBuilder sbV = a1.a.v(i2, "Expected the hexadecimal digit '0' at index ", ", but was '");
                    sbV.append(str.charAt(i2));
                    sbV.append("'.\nThe result won't fit the type being parsed.");
                    throw new NumberFormatException(sbV.toString());
                }
                i2++;
            }
        }
    }

    public static long b(int i2, int i8, String str) {
        g format = g.f13091d;
        kotlin.jvm.internal.k.e(format, "format");
        r5.b bVar = r5.e.Companion;
        int length = str.length();
        bVar.getClass();
        r5.b.a(i2, i8, length);
        if (format.f13094c.f13090a) {
            a(i2, i8, str);
            return c(i2, i8, str);
        }
        if (i8 - i2 > 0) {
            a(i2, i8, str);
            return c(i2, i8, str);
        }
        String strSubstring = str.substring(i2, i8);
        kotlin.jvm.internal.k.d(strSubstring, "substring(...)");
        throw new NumberFormatException("Expected a hexadecimal number with prefix \"\" and suffix \"\", but was ".concat(strSubstring));
    }

    public static final long c(int i2, int i8, String str) {
        long j = 0;
        while (i2 < i8) {
            long j3 = j << 4;
            char cCharAt = str.charAt(i2);
            if ((cCharAt >>> '\b') == 0) {
                long j8 = f13087b[cCharAt];
                if (j8 >= 0) {
                    j = j3 | j8;
                    i2++;
                }
            }
            StringBuilder sbV = a1.a.v(i2, "Expected a hexadecimal digit at index ", ", but was ");
            sbV.append(str.charAt(i2));
            throw new NumberFormatException(sbV.toString());
        }
        return j;
    }
}
