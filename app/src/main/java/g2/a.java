package g2;

import java.math.RoundingMode;
import java.util.Arrays;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes4.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f11579a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final char[] f11580b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final int f11581c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final int f11582d;
    public final int e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final int f11583f;
    public final byte[] g;
    public final boolean[] h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final boolean f11584i;

    public a(String str, char[] cArr, byte[] bArr, boolean z2) {
        str.getClass();
        this.f11579a = str;
        cArr.getClass();
        this.f11580b = cArr;
        try {
            int length = cArr.length;
            RoundingMode roundingMode = RoundingMode.UNNECESSARY;
            int iD = n7.b.D(length);
            this.f11582d = iD;
            int iNumberOfTrailingZeros = Integer.numberOfTrailingZeros(iD);
            int i2 = 1 << (3 - iNumberOfTrailingZeros);
            this.e = i2;
            this.f11583f = iD >> iNumberOfTrailingZeros;
            this.f11581c = cArr.length - 1;
            this.g = bArr;
            boolean[] zArr = new boolean[i2];
            for (int i8 = 0; i8 < this.f11583f; i8++) {
                int i9 = this.f11582d;
                RoundingMode roundingMode2 = RoundingMode.CEILING;
                zArr[n7.b.m(i8 * 8, i9)] = true;
            }
            this.h = zArr;
            this.f11584i = z2;
        } catch (ArithmeticException e) {
            throw new IllegalArgumentException("Illegal alphabet length " + cArr.length, e);
        }
    }

    public final int a(char c7) throws d {
        if (c7 > 127) {
            throw new d(a1.a.i(c7, new StringBuilder("Unrecognized character: 0x")));
        }
        byte b8 = this.g[c7];
        if (b8 != -1) {
            return b8;
        }
        if (c7 <= ' ' || c7 == 127) {
            throw new d(a1.a.i(c7, new StringBuilder("Unrecognized character: 0x")));
        }
        throw new d("Unrecognized character: " + c7);
    }

    public final boolean equals(Object obj) {
        if (!(obj instanceof a)) {
            return false;
        }
        a aVar = (a) obj;
        return this.f11584i == aVar.f11584i && Arrays.equals(this.f11580b, aVar.f11580b);
    }

    public final int hashCode() {
        return Arrays.hashCode(this.f11580b) + (this.f11584i ? 1231 : 1237);
    }

    public final String toString() {
        return this.f11579a;
    }

    /* JADX WARN: Illegal instructions before constructor call */
    public a(String str, char[] cArr) {
        byte[] bArr = new byte[128];
        Arrays.fill(bArr, (byte) -1);
        for (int i2 = 0; i2 < cArr.length; i2++) {
            char c7 = cArr[i2];
            if (c7 < 128) {
                if (bArr[c7] == -1) {
                    bArr[c7] = (byte) i2;
                } else {
                    throw new IllegalArgumentException(a.a.K("Duplicate character: %s", Character.valueOf(c7)));
                }
            } else {
                throw new IllegalArgumentException(a.a.K("Non-ASCII character: %s", Character.valueOf(c7)));
            }
        }
        this(str, cArr, bArr, false);
    }
}
