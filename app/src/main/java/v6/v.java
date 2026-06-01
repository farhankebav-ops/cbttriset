package v6;

import java.util.Arrays;
import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;
import q6.t0;
import q6.u0;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes5.dex */
public class v {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ AtomicIntegerFieldUpdater f17651b = AtomicIntegerFieldUpdater.newUpdater(v.class, "_size$volatile");
    private volatile /* synthetic */ int _size$volatile;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public t0[] f17652a;

    public final void a(t0 t0Var) {
        t0Var.d((u0) this);
        t0[] t0VarArr = this.f17652a;
        AtomicIntegerFieldUpdater atomicIntegerFieldUpdater = f17651b;
        if (t0VarArr == null) {
            t0VarArr = new t0[4];
            this.f17652a = t0VarArr;
        } else if (atomicIntegerFieldUpdater.get(this) >= t0VarArr.length) {
            Object[] objArrCopyOf = Arrays.copyOf(t0VarArr, atomicIntegerFieldUpdater.get(this) * 2);
            kotlin.jvm.internal.k.d(objArrCopyOf, "copyOf(...)");
            t0VarArr = (t0[]) objArrCopyOf;
            this.f17652a = t0VarArr;
        }
        int i2 = atomicIntegerFieldUpdater.get(this);
        atomicIntegerFieldUpdater.set(this, i2 + 1);
        t0VarArr[i2] = t0Var;
        t0Var.f13589b = i2;
        d(i2);
    }

    public final void b(t0 t0Var) {
        synchronized (this) {
            if (t0Var.b() != null) {
                c(t0Var.f13589b);
            }
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:17:0x0063  */
    /* JADX WARN: Removed duplicated region for block: B:26:? A[SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final q6.t0 c(int r9) {
        /*
            r8 = this;
            q6.t0[] r0 = r8.f17652a
            kotlin.jvm.internal.k.b(r0)
            java.util.concurrent.atomic.AtomicIntegerFieldUpdater r1 = v6.v.f17651b
            int r2 = r1.get(r8)
            r3 = -1
            int r2 = r2 + r3
            r1.set(r8, r2)
            int r2 = r1.get(r8)
            if (r9 >= r2) goto L7a
            int r2 = r1.get(r8)
            r8.e(r9, r2)
            int r2 = r9 + (-1)
            int r2 = r2 / 2
            if (r9 <= 0) goto L3a
            r4 = r0[r9]
            kotlin.jvm.internal.k.b(r4)
            r5 = r0[r2]
            kotlin.jvm.internal.k.b(r5)
            int r4 = r4.compareTo(r5)
            if (r4 >= 0) goto L3a
            r8.e(r9, r2)
            r8.d(r2)
            goto L7a
        L3a:
            int r2 = r9 * 2
            int r4 = r2 + 1
            int r5 = r1.get(r8)
            if (r4 < r5) goto L45
            goto L7a
        L45:
            q6.t0[] r5 = r8.f17652a
            kotlin.jvm.internal.k.b(r5)
            int r2 = r2 + 2
            int r6 = r1.get(r8)
            if (r2 >= r6) goto L63
            r6 = r5[r2]
            kotlin.jvm.internal.k.b(r6)
            r7 = r5[r4]
            kotlin.jvm.internal.k.b(r7)
            int r6 = r6.compareTo(r7)
            if (r6 >= 0) goto L63
            goto L64
        L63:
            r2 = r4
        L64:
            r4 = r5[r9]
            kotlin.jvm.internal.k.b(r4)
            r5 = r5[r2]
            kotlin.jvm.internal.k.b(r5)
            int r4 = r4.compareTo(r5)
            if (r4 > 0) goto L75
            goto L7a
        L75:
            r8.e(r9, r2)
            r9 = r2
            goto L3a
        L7a:
            int r9 = r1.get(r8)
            r9 = r0[r9]
            kotlin.jvm.internal.k.b(r9)
            r2 = 0
            r9.d(r2)
            r9.f13589b = r3
            int r1 = r1.get(r8)
            r0[r1] = r2
            return r9
        */
        throw new UnsupportedOperationException("Method not decompiled: v6.v.c(int):q6.t0");
    }

    public final void d(int i2) {
        while (i2 > 0) {
            t0[] t0VarArr = this.f17652a;
            kotlin.jvm.internal.k.b(t0VarArr);
            int i8 = (i2 - 1) / 2;
            t0 t0Var = t0VarArr[i8];
            kotlin.jvm.internal.k.b(t0Var);
            t0 t0Var2 = t0VarArr[i2];
            kotlin.jvm.internal.k.b(t0Var2);
            if (t0Var.compareTo(t0Var2) <= 0) {
                return;
            }
            e(i2, i8);
            i2 = i8;
        }
    }

    public final void e(int i2, int i8) {
        t0[] t0VarArr = this.f17652a;
        kotlin.jvm.internal.k.b(t0VarArr);
        t0 t0Var = t0VarArr[i8];
        kotlin.jvm.internal.k.b(t0Var);
        t0 t0Var2 = t0VarArr[i2];
        kotlin.jvm.internal.k.b(t0Var2);
        t0VarArr[i2] = t0Var;
        t0VarArr[i8] = t0Var2;
        t0Var.f13589b = i2;
        t0Var2.f13589b = i8;
    }
}
