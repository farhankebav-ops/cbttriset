package g2;

import com.ironsource.G5;
import java.io.IOException;
import java.math.RoundingMode;
import java.util.Objects;
import r2.q;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes4.dex */
public class e {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final c f11586d = new c("base64()", "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789+/");
    public static final b e;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final a f11587a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Character f11588b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public volatile e f11589c;

    static {
        new c("base64Url()", "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789-_");
        new e("base32()", "ABCDEFGHIJKLMNOPQRSTUVWXYZ234567");
        new e("base32Hex()", "0123456789ABCDEFGHIJKLMNOPQRSTUV");
        e = new b(new a("base16()", "0123456789ABCDEF".toCharArray()));
    }

    /* JADX WARN: Removed duplicated region for block: B:9:0x001a  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public e(g2.a r3, java.lang.Character r4) {
        /*
            r2 = this;
            r2.<init>()
            r3.getClass()
            r2.f11587a = r3
            if (r4 == 0) goto L1a
            char r0 = r4.charValue()
            byte[] r3 = r3.g
            int r1 = r3.length
            if (r0 >= r1) goto L1a
            r3 = r3[r0]
            r0 = -1
            if (r3 == r0) goto L1a
            r3 = 0
            goto L1b
        L1a:
            r3 = 1
        L1b:
            java.lang.String r0 = "Padding character %s was already in alphabet"
            r2.q.w(r4, r0, r3)
            r2.f11588b = r4
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: g2.e.<init>(g2.a, java.lang.Character):void");
    }

    public final byte[] a(String str) {
        try {
            CharSequence charSequenceG = g(str);
            int length = (int) (((((long) this.f11587a.f11582d) * ((long) charSequenceG.length())) + 7) / 8);
            byte[] bArr = new byte[length];
            int iB = b(bArr, charSequenceG);
            if (iB == length) {
                return bArr;
            }
            byte[] bArr2 = new byte[iB];
            System.arraycopy(bArr, 0, bArr2, 0, iB);
            return bArr2;
        } catch (d e4) {
            throw new IllegalArgumentException(e4);
        }
    }

    public int b(byte[] bArr, CharSequence charSequence) throws d {
        CharSequence charSequenceG = g(charSequence);
        int length = charSequenceG.length();
        a aVar = this.f11587a;
        boolean[] zArr = aVar.h;
        int i2 = aVar.f11582d;
        int i8 = aVar.e;
        if (!zArr[length % i8]) {
            throw new d("Invalid input length " + charSequenceG.length());
        }
        int i9 = 0;
        for (int i10 = 0; i10 < charSequenceG.length(); i10 += i8) {
            long jA = 0;
            int i11 = 0;
            for (int i12 = 0; i12 < i8; i12++) {
                jA <<= i2;
                if (i10 + i12 < charSequenceG.length()) {
                    jA |= (long) aVar.a(charSequenceG.charAt(i11 + i10));
                    i11++;
                }
            }
            int i13 = aVar.f11583f;
            int i14 = (i13 * 8) - (i11 * i2);
            int i15 = (i13 - 1) * 8;
            while (i15 >= i14) {
                bArr[i9] = (byte) ((jA >>> i15) & 255);
                i15 -= 8;
                i9++;
            }
        }
        return i9;
    }

    public final String c(byte[] bArr) {
        int length = bArr.length;
        q.F(0, length, bArr.length);
        a aVar = this.f11587a;
        int i2 = aVar.e;
        int i8 = aVar.f11583f;
        RoundingMode roundingMode = RoundingMode.CEILING;
        StringBuilder sb = new StringBuilder(n7.b.m(length, i8) * i2);
        try {
            e(sb, bArr, length);
            return sb.toString();
        } catch (IOException e4) {
            throw new AssertionError(e4);
        }
    }

    public final void d(StringBuilder sb, byte[] bArr, int i2, int i8) {
        q.F(i2, i2 + i8, bArr.length);
        a aVar = this.f11587a;
        int i9 = aVar.f11583f;
        int i10 = aVar.f11582d;
        int i11 = 0;
        q.x(i8 <= i9);
        long j = 0;
        for (int i12 = 0; i12 < i8; i12++) {
            j = (j | ((long) (bArr[i2 + i12] & 255))) << 8;
        }
        int i13 = ((i8 + 1) * 8) - i10;
        while (i11 < i8 * 8) {
            sb.append(aVar.f11580b[((int) (j >>> (i13 - i11))) & aVar.f11581c]);
            i11 += i10;
        }
        Character ch = this.f11588b;
        if (ch != null) {
            while (i11 < aVar.f11583f * 8) {
                sb.append(ch.charValue());
                i11 += i10;
            }
        }
    }

    public void e(StringBuilder sb, byte[] bArr, int i2) {
        int i8 = 0;
        q.F(0, i2, bArr.length);
        while (i8 < i2) {
            a aVar = this.f11587a;
            d(sb, bArr, i8, Math.min(aVar.f11583f, i2 - i8));
            i8 += aVar.f11583f;
        }
    }

    public final boolean equals(Object obj) {
        if (obj instanceof e) {
            e eVar = (e) obj;
            if (this.f11587a.equals(eVar.f11587a) && Objects.equals(this.f11588b, eVar.f11588b)) {
                return true;
            }
        }
        return false;
    }

    public e f(a aVar, Character ch) {
        return new e(aVar, ch);
    }

    public final CharSequence g(CharSequence charSequence) {
        Character ch = this.f11588b;
        if (ch == null) {
            return charSequence;
        }
        char cCharValue = ch.charValue();
        int length = charSequence.length() - 1;
        while (length >= 0 && charSequence.charAt(length) == cCharValue) {
            length--;
        }
        return charSequence.subSequence(0, length + 1);
    }

    /* JADX WARN: Removed duplicated region for block: B:47:0x00b5  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final g2.e h() {
        /*
            Method dump skipped, instruction units count: 202
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: g2.e.h():g2.e");
    }

    public final int hashCode() {
        return this.f11587a.hashCode() ^ Objects.hashCode(this.f11588b);
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder("BaseEncoding.");
        a aVar = this.f11587a;
        sb.append(aVar);
        if (8 % aVar.f11582d != 0) {
            Character ch = this.f11588b;
            if (ch == null) {
                sb.append(".omitPadding()");
            } else {
                sb.append(".withPadChar('");
                sb.append(ch);
                sb.append("')");
            }
        }
        return sb.toString();
    }

    public e(String str, String str2) {
        this(new a(str, str2.toCharArray()), Character.valueOf(G5.T));
    }
}
