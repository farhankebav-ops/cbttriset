package g2;

import r2.q;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes4.dex */
public final class b extends e {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final char[] f11585f;

    public b(a aVar) {
        super(aVar, (Character) null);
        this.f11585f = new char[512];
        char[] cArr = aVar.f11580b;
        q.x(cArr.length == 16);
        for (int i2 = 0; i2 < 256; i2++) {
            char[] cArr2 = this.f11585f;
            cArr2[i2] = cArr[i2 >>> 4];
            cArr2[i2 | 256] = cArr[i2 & 15];
        }
    }

    @Override // g2.e
    public final int b(byte[] bArr, CharSequence charSequence) throws d {
        if (charSequence.length() % 2 == 1) {
            throw new d("Invalid input length " + charSequence.length());
        }
        int i2 = 0;
        int i8 = 0;
        while (i2 < charSequence.length()) {
            char cCharAt = charSequence.charAt(i2);
            a aVar = this.f11587a;
            bArr[i8] = (byte) ((aVar.a(cCharAt) << 4) | aVar.a(charSequence.charAt(i2 + 1)));
            i2 += 2;
            i8++;
        }
        return i8;
    }

    @Override // g2.e
    public final void e(StringBuilder sb, byte[] bArr, int i2) {
        q.F(0, i2, bArr.length);
        for (int i8 = 0; i8 < i2; i8++) {
            int i9 = bArr[i8] & 255;
            char[] cArr = this.f11585f;
            sb.append(cArr[i9]);
            sb.append(cArr[i9 | 256]);
        }
    }

    @Override // g2.e
    public final e f(a aVar, Character ch) {
        return new b(aVar);
    }
}
