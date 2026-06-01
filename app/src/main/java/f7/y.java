package f7;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes5.dex */
public final class y extends e1 {
    public final d7.l l;
    public final q5.m m;

    public y(String str, int i2) {
        super(str, null, i2);
        this.l = d7.l.f11200b;
        this.m = n7.b.C(new x(i2, str, this));
    }

    @Override // f7.e1
    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || !(obj instanceof d7.g)) {
            return false;
        }
        d7.g gVar = (d7.g) obj;
        return gVar.getKind() == d7.l.f11200b && this.f11441a.equals(gVar.h()) && kotlin.jvm.internal.k.a(c1.b(this), c1.b(gVar));
    }

    @Override // f7.e1, d7.g
    public final d7.g g(int i2) {
        return ((d7.g[]) this.m.getValue())[i2];
    }

    @Override // f7.e1, d7.g
    public final a.a getKind() {
        return this.l;
    }

    @Override // f7.e1
    public final int hashCode() {
        int iHashCode = this.f11441a.hashCode();
        d7.i iVar = new d7.i(this);
        int iHashCode2 = 1;
        while (iVar.hasNext()) {
            int i2 = iHashCode2 * 31;
            String str = (String) iVar.next();
            iHashCode2 = i2 + (str != null ? str.hashCode() : 0);
        }
        return (iHashCode * 31) + iHashCode2;
    }

    @Override // f7.e1
    public final String toString() {
        return r5.l.c1(new d7.j(this, 0), ", ", this.f11441a.concat("("), ")", null, 56);
    }
}
