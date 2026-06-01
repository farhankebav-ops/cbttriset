package l7;

import java.nio.charset.Charset;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes3.dex */
public final class m0 extends m {
    public final transient byte[][] e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final transient int[] f12884f;

    public m0(byte[][] bArr, int[] iArr) {
        super(m.f12880d.f12881a);
        this.e = bArr;
        this.f12884f = iArr;
    }

    @Override // l7.m
    public final String a() {
        return v().a();
    }

    @Override // l7.m
    public final m c(String str) throws NoSuchAlgorithmException {
        MessageDigest messageDigest = MessageDigest.getInstance(str);
        byte[][] bArr = this.e;
        int length = bArr.length;
        int i2 = 0;
        int i8 = 0;
        while (i2 < length) {
            int[] iArr = this.f12884f;
            int i9 = iArr[length + i2];
            int i10 = iArr[i2];
            messageDigest.update(bArr[i2], i9, i10 - i8);
            i2++;
            i8 = i10;
        }
        byte[] bArrDigest = messageDigest.digest();
        kotlin.jvm.internal.k.b(bArrDigest);
        return new m(bArrDigest);
    }

    @Override // l7.m
    public final int d() {
        return this.f12884f[this.e.length - 1];
    }

    @Override // l7.m
    public final String e() {
        return v().e();
    }

    @Override // l7.m
    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof m) {
            m mVar = (m) obj;
            if (mVar.d() == d() && l(0, mVar, d())) {
                return true;
            }
        }
        return false;
    }

    @Override // l7.m
    public final int f(byte[] other, int i2) {
        kotlin.jvm.internal.k.e(other, "other");
        return v().f(other, i2);
    }

    @Override // l7.m
    public final byte[] h() {
        return s();
    }

    @Override // l7.m
    public final int hashCode() {
        int i2 = this.f12882b;
        if (i2 != 0) {
            return i2;
        }
        byte[][] bArr = this.e;
        int length = bArr.length;
        int i8 = 0;
        int i9 = 1;
        int i10 = 0;
        while (i8 < length) {
            int[] iArr = this.f12884f;
            int i11 = iArr[length + i8];
            int i12 = iArr[i8];
            byte[] bArr2 = bArr[i8];
            int i13 = (i12 - i10) + i11;
            while (i11 < i13) {
                i9 = (i9 * 31) + bArr2[i11];
                i11++;
            }
            i8++;
            i10 = i12;
        }
        this.f12882b = i9;
        return i9;
    }

    @Override // l7.m
    public final byte i(int i2) {
        byte[][] bArr = this.e;
        int length = bArr.length - 1;
        int[] iArr = this.f12884f;
        b.e(iArr[length], i2, 1L);
        int i8 = m7.b.i(this, i2);
        return bArr[i8][(i2 - (i8 == 0 ? 0 : iArr[i8 - 1])) + iArr[bArr.length + i8]];
    }

    @Override // l7.m
    public final int j(byte[] other) {
        kotlin.jvm.internal.k.e(other, "other");
        return v().j(other);
    }

    @Override // l7.m
    public final boolean l(int i2, m other, int i8) {
        kotlin.jvm.internal.k.e(other, "other");
        if (i2 >= 0 && i2 <= d() - i8) {
            int i9 = i8 + i2;
            int i10 = m7.b.i(this, i2);
            int i11 = 0;
            while (i2 < i9) {
                int[] iArr = this.f12884f;
                int i12 = i10 == 0 ? 0 : iArr[i10 - 1];
                int i13 = iArr[i10] - i12;
                byte[][] bArr = this.e;
                int i14 = iArr[bArr.length + i10];
                int iMin = Math.min(i9, i13 + i12) - i2;
                if (other.m(i11, bArr[i10], (i2 - i12) + i14, iMin)) {
                    i11 += iMin;
                    i2 += iMin;
                    i10++;
                }
            }
            return true;
        }
        return false;
    }

    @Override // l7.m
    public final boolean m(int i2, byte[] other, int i8, int i9) {
        kotlin.jvm.internal.k.e(other, "other");
        if (i2 < 0 || i2 > d() - i9 || i8 < 0 || i8 > other.length - i9) {
            return false;
        }
        int i10 = i9 + i2;
        int i11 = m7.b.i(this, i2);
        while (i2 < i10) {
            int[] iArr = this.f12884f;
            int i12 = i11 == 0 ? 0 : iArr[i11 - 1];
            int i13 = iArr[i11] - i12;
            byte[][] bArr = this.e;
            int i14 = iArr[bArr.length + i11];
            int iMin = Math.min(i10, i13 + i12) - i2;
            if (!b.a((i2 - i12) + i14, i8, iMin, bArr[i11], other)) {
                return false;
            }
            i8 += iMin;
            i2 += iMin;
            i11++;
        }
        return true;
    }

    @Override // l7.m
    public final String o(Charset charset) {
        kotlin.jvm.internal.k.e(charset, "charset");
        return v().o(charset);
    }

    @Override // l7.m
    public final m p(int i2, int i8) {
        if (i8 == -1234567890) {
            i8 = d();
        }
        if (i2 < 0) {
            throw new IllegalArgumentException(a1.a.h(i2, "beginIndex=", " < 0").toString());
        }
        if (i8 > d()) {
            StringBuilder sbV = a1.a.v(i8, "endIndex=", " > length(");
            sbV.append(d());
            sbV.append(')');
            throw new IllegalArgumentException(sbV.toString().toString());
        }
        int i9 = i8 - i2;
        if (i9 < 0) {
            throw new IllegalArgumentException(androidx.camera.core.processing.util.a.i("endIndex=", i8, " < beginIndex=", i2).toString());
        }
        if (i2 == 0 && i8 == d()) {
            return this;
        }
        if (i2 == i8) {
            return m.f12880d;
        }
        int i10 = m7.b.i(this, i2);
        int i11 = m7.b.i(this, i8 - 1);
        byte[][] bArr = this.e;
        byte[][] bArr2 = (byte[][]) r5.j.j0(i10, i11 + 1, bArr);
        int[] iArr = new int[bArr2.length * 2];
        int[] iArr2 = this.f12884f;
        if (i10 <= i11) {
            int i12 = i10;
            int i13 = 0;
            while (true) {
                iArr[i13] = Math.min(iArr2[i12] - i2, i9);
                int i14 = i13 + 1;
                iArr[i13 + bArr2.length] = iArr2[bArr.length + i12];
                if (i12 == i11) {
                    break;
                }
                i12++;
                i13 = i14;
            }
        }
        int i15 = i10 != 0 ? iArr2[i10 - 1] : 0;
        int length = bArr2.length;
        iArr[length] = (i2 - i15) + iArr[length];
        return new m0(bArr2, iArr);
    }

    @Override // l7.m
    public final m r() {
        return v().r();
    }

    @Override // l7.m
    public final byte[] s() {
        byte[] bArr = new byte[d()];
        byte[][] bArr2 = this.e;
        int length = bArr2.length;
        int i2 = 0;
        int i8 = 0;
        int i9 = 0;
        while (i2 < length) {
            int[] iArr = this.f12884f;
            int i10 = iArr[length + i2];
            int i11 = iArr[i2];
            int i12 = i11 - i8;
            r5.j.b0(i9, i10, i10 + i12, bArr2[i2], bArr);
            i9 += i12;
            i2++;
            i8 = i11;
        }
        return bArr;
    }

    @Override // l7.m
    public final String toString() {
        return v().toString();
    }

    @Override // l7.m
    public final void u(int i2, j jVar) {
        int i8 = m7.b.i(this, 0);
        int i9 = 0;
        while (i9 < i2) {
            int[] iArr = this.f12884f;
            int i10 = i8 == 0 ? 0 : iArr[i8 - 1];
            int i11 = iArr[i8] - i10;
            byte[][] bArr = this.e;
            int i12 = iArr[bArr.length + i8];
            int iMin = Math.min(i2, i11 + i10) - i9;
            int i13 = (i9 - i10) + i12;
            k0 k0Var = new k0(bArr[i8], i13, i13 + iMin, true, false);
            k0 k0Var2 = jVar.f12867a;
            if (k0Var2 == null) {
                k0Var.g = k0Var;
                k0Var.f12876f = k0Var;
                jVar.f12867a = k0Var;
            } else {
                k0 k0Var3 = k0Var2.g;
                kotlin.jvm.internal.k.b(k0Var3);
                k0Var3.b(k0Var);
            }
            i9 += iMin;
            i8++;
        }
        jVar.f12868b += (long) i2;
    }

    public final m v() {
        return new m(s());
    }
}
