package g2;

import com.ironsource.G5;
import r2.q;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes4.dex */
public final class c extends e {
    public c(String str, String str2) {
        this(new a(str, str2.toCharArray()), Character.valueOf(G5.T));
    }

    @Override // g2.e
    public final int b(byte[] bArr, CharSequence charSequence) throws d {
        CharSequence charSequenceG = g(charSequence);
        int length = charSequenceG.length();
        a aVar = this.f11587a;
        if (!aVar.h[length % aVar.e]) {
            throw new d("Invalid input length " + charSequenceG.length());
        }
        int i2 = 0;
        int i8 = 0;
        while (i2 < charSequenceG.length()) {
            int i9 = i2 + 2;
            int iA = (aVar.a(charSequenceG.charAt(i2 + 1)) << 12) | (aVar.a(charSequenceG.charAt(i2)) << 18);
            int i10 = i8 + 1;
            bArr[i8] = (byte) (iA >>> 16);
            if (i9 < charSequenceG.length()) {
                int i11 = i2 + 3;
                int iA2 = iA | (aVar.a(charSequenceG.charAt(i9)) << 6);
                int i12 = i8 + 2;
                bArr[i10] = (byte) ((iA2 >>> 8) & 255);
                if (i11 < charSequenceG.length()) {
                    i2 += 4;
                    i8 += 3;
                    bArr[i12] = (byte) ((iA2 | aVar.a(charSequenceG.charAt(i11))) & 255);
                } else {
                    i8 = i12;
                    i2 = i11;
                }
            } else {
                i8 = i10;
                i2 = i9;
            }
        }
        return i8;
    }

    @Override // g2.e
    public final void e(StringBuilder sb, byte[] bArr, int i2) {
        int i8 = 0;
        q.F(0, i2, bArr.length);
        for (int i9 = i2; i9 >= 3; i9 -= 3) {
            int i10 = i8 + 2;
            int i11 = ((bArr[i8 + 1] & 255) << 8) | ((bArr[i8] & 255) << 16);
            i8 += 3;
            int i12 = i11 | (bArr[i10] & 255);
            a aVar = this.f11587a;
            char[] cArr = aVar.f11580b;
            char[] cArr2 = aVar.f11580b;
            sb.append(cArr[i12 >>> 18]);
            sb.append(cArr2[(i12 >>> 12) & 63]);
            sb.append(cArr2[(i12 >>> 6) & 63]);
            sb.append(cArr2[i12 & 63]);
        }
        if (i8 < i2) {
            d(sb, bArr, i8, i2 - i8);
        }
    }

    @Override // g2.e
    public final e f(a aVar, Character ch) {
        return new c(aVar, ch);
    }

    public c(a aVar, Character ch) {
        super(aVar, ch);
        q.x(aVar.f11580b.length == 64);
    }
}
