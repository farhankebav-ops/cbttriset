package u6;

import java.util.Arrays;
import q5.x;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes5.dex */
public abstract class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public d[] f17540a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f17541b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public int f17542c;

    public final d a() {
        d dVarB;
        synchronized (this) {
            try {
                d[] dVarArrC = this.f17540a;
                if (dVarArrC == null) {
                    dVarArrC = c();
                    this.f17540a = dVarArrC;
                } else if (this.f17541b >= dVarArrC.length) {
                    Object[] objArrCopyOf = Arrays.copyOf(dVarArrC, dVarArrC.length * 2);
                    kotlin.jvm.internal.k.d(objArrCopyOf, "copyOf(...)");
                    this.f17540a = (d[]) objArrCopyOf;
                    dVarArrC = (d[]) objArrCopyOf;
                }
                int i2 = this.f17542c;
                do {
                    dVarB = dVarArrC[i2];
                    if (dVarB == null) {
                        dVarB = b();
                        dVarArrC[i2] = dVarB;
                    }
                    i2++;
                    if (i2 >= dVarArrC.length) {
                        i2 = 0;
                    }
                } while (!dVarB.a(this));
                this.f17542c = i2;
                this.f17541b++;
            } catch (Throwable th) {
                throw th;
            }
        }
        return dVarB;
    }

    public abstract d b();

    public abstract d[] c();

    public final void f(d dVar) {
        int i2;
        v5.c[] cVarArrB;
        synchronized (this) {
            try {
                int i8 = this.f17541b - 1;
                this.f17541b = i8;
                if (i8 == 0) {
                    this.f17542c = 0;
                }
                kotlin.jvm.internal.k.c(dVar, "null cannot be cast to non-null type kotlinx.coroutines.flow.internal.AbstractSharedFlowSlot<kotlin.Any>");
                cVarArrB = dVar.b(this);
            } catch (Throwable th) {
                throw th;
            }
        }
        for (v5.c cVar : cVarArrB) {
            if (cVar != null) {
                cVar.resumeWith(x.f13520a);
            }
        }
    }
}
