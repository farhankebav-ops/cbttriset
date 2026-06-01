package com.pgl.ssdk;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes5.dex */
public final class o<A, B> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final A f10799a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final B f10800b;

    public o(A a8, B b8) {
        this.f10799a = a8;
        this.f10800b = b8;
    }

    public static <A, B> o<A, B> a(A a8, B b8) {
        return new o<>(a8, b8);
    }

    public B b() {
        return this.f10800b;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || o.class != obj.getClass()) {
            return false;
        }
        o oVar = (o) obj;
        A a8 = this.f10799a;
        if (a8 == null) {
            if (oVar.f10799a != null) {
                return false;
            }
        } else if (!a8.equals(oVar.f10799a)) {
            return false;
        }
        B b8 = this.f10800b;
        if (b8 == null) {
            if (oVar.f10800b != null) {
                return false;
            }
        } else if (!b8.equals(oVar.f10800b)) {
            return false;
        }
        return true;
    }

    public int hashCode() {
        A a8 = this.f10799a;
        int iHashCode = ((a8 == null ? 0 : a8.hashCode()) + 31) * 31;
        B b8 = this.f10800b;
        return iHashCode + (b8 != null ? b8.hashCode() : 0);
    }

    public A a() {
        return this.f10799a;
    }
}
