package f7;

import java.util.Arrays;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes5.dex */
public final class h0 extends e1 {
    public final boolean l;

    public h0(String str, i0 i0Var) {
        super(str, i0Var, 1);
        this.l = true;
    }

    /* JADX WARN: Type inference failed for: r2v3, types: [java.lang.Object, q5.f] */
    /* JADX WARN: Type inference failed for: r6v3, types: [java.lang.Object, q5.f] */
    @Override // f7.e1
    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof h0) {
            d7.g gVar = (d7.g) obj;
            if (this.f11441a.equals(gVar.h())) {
                h0 h0Var = (h0) obj;
                if (h0Var.l && Arrays.equals((d7.g[]) this.j.getValue(), (d7.g[]) h0Var.j.getValue())) {
                    int iD = gVar.d();
                    int i2 = this.f11443c;
                    if (i2 == iD) {
                        for (int i8 = 0; i8 < i2; i8++) {
                            if (kotlin.jvm.internal.k.a(g(i8).h(), gVar.g(i8).h()) && kotlin.jvm.internal.k.a(g(i8).getKind(), gVar.g(i8).getKind())) {
                            }
                        }
                        return true;
                    }
                }
            }
        }
        return false;
    }

    @Override // f7.e1
    public final int hashCode() {
        return super.hashCode() * 31;
    }

    @Override // f7.e1, d7.g
    public final boolean isInline() {
        return this.l;
    }
}
