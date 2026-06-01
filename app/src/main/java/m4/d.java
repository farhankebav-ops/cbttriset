package m4;

import java.util.Arrays;
import l7.m;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes5.dex */
public final class d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final l7.j f12942a;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public int f12944c;
    public int e;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public b[] f12943b = new b[8];

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public int f12945d = 7;

    public d(l7.j jVar) {
        this.f12942a = jVar;
    }

    public final void a(b bVar) {
        int i2;
        int i8 = bVar.f12936c;
        if (i8 > 4096) {
            Arrays.fill(this.f12943b, (Object) null);
            this.f12945d = this.f12943b.length - 1;
            this.f12944c = 0;
            this.e = 0;
            return;
        }
        int i9 = (this.e + i8) - 4096;
        if (i9 > 0) {
            int length = this.f12943b.length - 1;
            int i10 = 0;
            while (true) {
                i2 = this.f12945d;
                if (length < i2 || i9 <= 0) {
                    break;
                }
                int i11 = this.f12943b[length].f12936c;
                i9 -= i11;
                this.e -= i11;
                this.f12944c--;
                i10++;
                length--;
            }
            b[] bVarArr = this.f12943b;
            int i12 = i2 + 1;
            System.arraycopy(bVarArr, i12, bVarArr, i12 + i10, this.f12944c);
            this.f12945d += i10;
        }
        int i13 = this.f12944c + 1;
        b[] bVarArr2 = this.f12943b;
        if (i13 > bVarArr2.length) {
            b[] bVarArr3 = new b[bVarArr2.length * 2];
            System.arraycopy(bVarArr2, 0, bVarArr3, bVarArr2.length, bVarArr2.length);
            this.f12945d = this.f12943b.length - 1;
            this.f12943b = bVarArr3;
        }
        int i14 = this.f12945d;
        this.f12945d = i14 - 1;
        this.f12943b[i14] = bVar;
        this.f12944c++;
        this.e += i8;
    }

    public final void b(m mVar) {
        c(mVar.d(), 127, 0);
        this.f12942a.w(mVar);
    }

    public final void c(int i2, int i8, int i9) {
        l7.j jVar = this.f12942a;
        if (i2 < i8) {
            jVar.x(i2 | i9);
            return;
        }
        jVar.x(i9 | i8);
        int i10 = i2 - i8;
        while (i10 >= 128) {
            jVar.x(128 | (i10 & 127));
            i10 >>>= 7;
        }
        jVar.x(i10);
    }
}
