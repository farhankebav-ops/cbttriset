package i4;

import com.ironsource.G5;
import java.nio.charset.Charset;
import java.util.Arrays;
import java.util.logging.Logger;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes5.dex */
public final class a1 {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final Logger f11817c = Logger.getLogger(a1.class.getName());

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final j f11818d = new j(8);
    public static final g2.c e;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public Object[] f11819a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f11820b;

    static {
        g2.c cVar = g2.e.f11586d;
        if (cVar.f11588b != null) {
            cVar = new g2.c(cVar.f11587a, (Character) null);
        }
        e = cVar;
    }

    public final void a(x0 x0Var) {
        if (this.f11820b == 0) {
            return;
        }
        int i2 = 0;
        int i8 = 0;
        while (true) {
            int i9 = this.f11820b;
            if (i2 >= i9) {
                Arrays.fill(this.f11819a, i8 * 2, i9 * 2, (Object) null);
                this.f11820b = i8;
                return;
            }
            int i10 = i2 * 2;
            if (!Arrays.equals(x0Var.f11973b, (byte[]) this.f11819a[i10])) {
                Object[] objArr = this.f11819a;
                int i11 = i8 * 2;
                objArr[i11] = (byte[]) objArr[i10];
                Object obj = objArr[i10 + 1];
                if (objArr instanceof byte[][]) {
                    b(objArr.length);
                }
                this.f11819a[i11 + 1] = obj;
                i8++;
            }
            i2++;
        }
    }

    public final void b(int i2) {
        Object[] objArr = new Object[i2];
        int i8 = this.f11820b;
        if (i8 != 0) {
            System.arraycopy(this.f11819a, 0, objArr, 0, i8 * 2);
        }
        this.f11819a = objArr;
    }

    public final Object c(x0 x0Var) {
        for (int i2 = this.f11820b - 1; i2 >= 0; i2--) {
            int i8 = i2 * 2;
            if (Arrays.equals(x0Var.f11973b, (byte[]) this.f11819a[i8])) {
                Object obj = this.f11819a[i8 + 1];
                if (obj instanceof byte[]) {
                    return x0Var.a((byte[]) obj);
                }
                obj.getClass();
                throw new ClassCastException();
            }
        }
        return null;
    }

    public final void d(a1 a1Var) {
        int i2 = a1Var.f11820b;
        if (i2 == 0) {
            return;
        }
        Object[] objArr = this.f11819a;
        int length = objArr != null ? objArr.length : 0;
        int i8 = this.f11820b;
        int i9 = length - (i8 * 2);
        if (i8 == 0 || i9 < i2 * 2) {
            b((i2 * 2) + (i8 * 2));
        }
        System.arraycopy(a1Var.f11819a, 0, this.f11819a, this.f11820b * 2, a1Var.f11820b * 2);
        this.f11820b += a1Var.f11820b;
    }

    /* JADX WARN: Removed duplicated region for block: B:9:0x0019  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void e(i4.x0 r5, java.lang.Object r6) {
        /*
            r4 = this;
            java.lang.String r0 = "key"
            r2.q.D(r5, r0)
            java.lang.String r0 = "value"
            r2.q.D(r6, r0)
            int r0 = r4.f11820b
            int r1 = r0 * 2
            if (r1 == 0) goto L19
            java.lang.Object[] r2 = r4.f11819a
            if (r2 == 0) goto L16
            int r2 = r2.length
            goto L17
        L16:
            r2 = 0
        L17:
            if (r1 != r2) goto L24
        L19:
            int r0 = r0 * 4
            r1 = 8
            int r0 = java.lang.Math.max(r0, r1)
            r4.b(r0)
        L24:
            int r0 = r4.f11820b
            byte[] r1 = r5.f11973b
            java.lang.Object[] r2 = r4.f11819a
            int r3 = r0 * 2
            r2[r3] = r1
            byte[] r5 = r5.b(r6)
            java.lang.Object[] r6 = r4.f11819a
            int r0 = r0 * 2
            int r0 = r0 + 1
            r6[r0] = r5
            int r5 = r4.f11820b
            int r5 = r5 + 1
            r4.f11820b = r5
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: i4.a1.e(i4.x0, java.lang.Object):void");
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder("Metadata(");
        for (int i2 = 0; i2 < this.f11820b; i2++) {
            if (i2 != 0) {
                sb.append(',');
            }
            int i8 = i2 * 2;
            byte[] bArr = (byte[]) this.f11819a[i8];
            Charset charset = e2.d.f11227a;
            String str = new String(bArr, charset);
            sb.append(str);
            sb.append(G5.T);
            if (str.endsWith("-bin")) {
                Object obj = this.f11819a[i8 + 1];
                if (!(obj instanceof byte[])) {
                    com.ironsource.adqualitysdk.sdk.i.a0.l(obj);
                    throw null;
                }
                sb.append(e.c((byte[]) obj));
            } else {
                Object obj2 = this.f11819a[i8 + 1];
                if (!(obj2 instanceof byte[])) {
                    com.ironsource.adqualitysdk.sdk.i.a0.l(obj2);
                    throw null;
                }
                sb.append(new String((byte[]) obj2, charset));
            }
        }
        sb.append(')');
        return sb.toString();
    }
}
