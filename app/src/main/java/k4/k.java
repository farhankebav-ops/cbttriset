package k4;

import i4.a1;
import i4.c1;
import j4.d5;
import j4.g5;
import java.io.Serializable;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes5.dex */
public final class k extends j4.d {

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public static final l7.j f12651r = new l7.j();
    public final c1 j;
    public final String k;
    public final d5 l;
    public final String m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public final j f12652n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public final a4.a f12653o;
    public final i4.b p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public boolean f12654q;

    public k(c1 c1Var, a1 a1Var, d dVar, n nVar, y yVar, Object obj, int i2, int i8, String str, String str2, d5 d5Var, g5 g5Var, i4.d dVar2) {
        super(new w1.f(2), d5Var, g5Var, a1Var, dVar2, false);
        this.f12653o = new a4.a(this, 20);
        this.f12654q = false;
        this.l = d5Var;
        this.j = c1Var;
        this.m = str;
        this.k = str2;
        this.p = nVar.f12671u;
        Serializable serializable = c1Var.f11839d;
        this.f12652n = new j(this, i2, d5Var, obj, dVar, yVar, nVar, i8);
    }

    public static void u(k kVar, int i2) {
        j jVar = kVar.f12652n;
        synchronized (jVar.f12135b) {
            jVar.e += i2;
        }
    }
}
