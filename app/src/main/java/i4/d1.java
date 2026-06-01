package i4;

import j4.i2;
import j4.o2;
import j4.s4;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes5.dex */
public final class d1 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f11846a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final i1 f11847b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final s1 f11848c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final s4 f11849d;
    public final o2 e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final j4.o f11850f;
    public final i2 g;

    public d1(Integer num, i1 i1Var, s1 s1Var, s4 s4Var, o2 o2Var, j4.o oVar, i2 i2Var) {
        this.f11846a = num.intValue();
        r2.q.D(i1Var, "proxyDetector not set");
        this.f11847b = i1Var;
        this.f11848c = s1Var;
        this.f11849d = s4Var;
        this.e = o2Var;
        this.f11850f = oVar;
        this.g = i2Var;
    }

    public final String toString() {
        e2.i iVarY = a.a.Y(this);
        iVarY.f("defaultPort", String.valueOf(this.f11846a));
        iVarY.c(this.f11847b, "proxyDetector");
        iVarY.c(this.f11848c, "syncContext");
        iVarY.c(this.f11849d, "serviceConfigParser");
        iVarY.c(this.e, "scheduledExecutorService");
        iVarY.c(this.f11850f, "channelLogger");
        iVarY.c(this.g, "executor");
        iVarY.c(null, "overrideAuthority");
        return iVarY.toString();
    }
}
