package i4;

import java.util.List;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes5.dex */
public abstract class o0 {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final a f11922b = new a("internal:health-checking-config");

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final j f11923c = new j(5);

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final a f11924d = new a("internal:has-health-check-producer-listener");
    public static final a e = new a("io.grpc.IS_PETIOLE_POLICY");

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f11925a;

    public n1 a(l0 l0Var) {
        List list = l0Var.f11891a;
        if (!list.isEmpty() || b()) {
            int i2 = this.f11925a;
            this.f11925a = i2 + 1;
            if (i2 == 0) {
                d(l0Var);
            }
            this.f11925a = 0;
            return n1.e;
        }
        n1 n1VarH = n1.m.h("NameResolver returned no usable address. addrs=" + list + ", attrs=" + l0Var.f11892b);
        c(n1VarH);
        return n1VarH;
    }

    public boolean b() {
        return false;
    }

    public abstract void c(n1 n1Var);

    public void d(l0 l0Var) {
        int i2 = this.f11925a;
        this.f11925a = i2 + 1;
        if (i2 == 0) {
            a(l0Var);
        }
        this.f11925a = 0;
    }

    public abstract void f();

    public void e() {
    }
}
