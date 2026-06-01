package m4;

import j4.p1;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import l7.j0;
import l7.m;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes5.dex */
public final class c {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final j0 f12938b;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final ArrayList f12937a = new ArrayList();
    public b[] e = new b[8];

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public int f12941f = 7;
    public int g = 0;
    public int h = 0;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public int f12939c = 4096;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public int f12940d = 4096;

    public c(f fVar) {
        this.f12938b = l7.b.c(fVar);
    }

    public final int a(int i2) {
        int i8;
        int i9 = 0;
        if (i2 > 0) {
            int length = this.e.length;
            while (true) {
                length--;
                i8 = this.f12941f;
                if (length < i8 || i2 <= 0) {
                    break;
                }
                int i10 = this.e[length].f12936c;
                i2 -= i10;
                this.h -= i10;
                this.g--;
                i9++;
            }
            b[] bVarArr = this.e;
            System.arraycopy(bVarArr, i8 + 1, bVarArr, i8 + 1 + i9, this.g);
            this.f12941f += i9;
        }
        return i9;
    }

    public final m b(int i2) throws IOException {
        if (i2 >= 0) {
            b[] bVarArr = e.f12947b;
            if (i2 <= bVarArr.length - 1) {
                return bVarArr[i2].f12934a;
            }
        }
        int length = this.f12941f + 1 + (i2 - e.f12947b.length);
        if (length >= 0) {
            b[] bVarArr2 = this.e;
            if (length < bVarArr2.length) {
                return bVarArr2[length].f12934a;
            }
        }
        throw new IOException("Header index too large " + (i2 + 1));
    }

    public final void c(b bVar) {
        this.f12937a.add(bVar);
        int i2 = bVar.f12936c;
        int i8 = this.f12940d;
        if (i2 > i8) {
            Arrays.fill(this.e, (Object) null);
            this.f12941f = this.e.length - 1;
            this.g = 0;
            this.h = 0;
            return;
        }
        a((this.h + i2) - i8);
        int i9 = this.g + 1;
        b[] bVarArr = this.e;
        if (i9 > bVarArr.length) {
            b[] bVarArr2 = new b[bVarArr.length * 2];
            System.arraycopy(bVarArr, 0, bVarArr2, bVarArr.length, bVarArr.length);
            this.f12941f = this.e.length - 1;
            this.e = bVarArr2;
        }
        int i10 = this.f12941f;
        this.f12941f = i10 - 1;
        this.e[i10] = bVar;
        this.g++;
        this.h += i2;
    }

    public final m d() {
        j0 j0Var = this.f12938b;
        byte b8 = j0Var.readByte();
        int i2 = b8 & 255;
        boolean z2 = (b8 & 128) == 128;
        int iE = e(i2, 127);
        if (!z2) {
            return j0Var.J(iE);
        }
        k kVar = k.f12968d;
        long j = iE;
        j0Var.F(j);
        byte[] bArrO = j0Var.f12870b.o(j);
        kVar.getClass();
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        p1 p1Var = kVar.f12969a;
        p1 p1Var2 = p1Var;
        int i8 = 0;
        int i9 = 0;
        for (byte b9 : bArrO) {
            i8 = (i8 << 8) | (b9 & 255);
            i9 += 8;
            while (i9 >= 8) {
                p1Var2 = ((p1[]) p1Var2.f12363a)[(i8 >>> (i9 - 8)) & 255];
                if (((p1[]) p1Var2.f12363a) == null) {
                    byteArrayOutputStream.write(p1Var2.f12364b);
                    i9 -= p1Var2.f12365c;
                    p1Var2 = p1Var;
                } else {
                    i9 -= 8;
                }
            }
        }
        while (i9 > 0) {
            p1 p1Var3 = ((p1[]) p1Var2.f12363a)[(i8 << (8 - i9)) & 255];
            p1[] p1VarArr = (p1[]) p1Var3.f12363a;
            int i10 = p1Var3.f12365c;
            if (p1VarArr != null || i10 > i9) {
                break;
            }
            byteArrayOutputStream.write(p1Var3.f12364b);
            i9 -= i10;
            p1Var2 = p1Var;
        }
        byte[] byteArray = byteArrayOutputStream.toByteArray();
        m mVar = m.f12880d;
        return r4.c.f(byteArray);
    }

    public final int e(int i2, int i8) {
        int i9 = i2 & i8;
        if (i9 < i8) {
            return i9;
        }
        int i10 = 0;
        while (true) {
            byte b8 = this.f12938b.readByte();
            int i11 = b8 & 255;
            if ((b8 & 128) == 0) {
                return i8 + (i11 << i10);
            }
            i8 += (b8 & 127) << i10;
            i10 += 7;
        }
    }
}
