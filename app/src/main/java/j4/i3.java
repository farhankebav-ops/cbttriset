package j4;

import java.util.Objects;
import java.util.concurrent.atomic.AtomicBoolean;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes5.dex */
public final class i3 extends i4.m0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f12258a = 0;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final AtomicBoolean f12259b = new AtomicBoolean(false);

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Object f12260c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final /* synthetic */ i4.o0 f12261d;

    public i3(k3 k3Var, k3 k3Var2) {
        this.f12261d = k3Var;
        this.f12260c = k3Var2;
    }

    @Override // i4.m0
    public final i4.k0 a(q3 q3Var) {
        switch (this.f12258a) {
            case 0:
                if (this.f12259b.compareAndSet(false, true)) {
                    i4.s1 s1VarE = ((k3) this.f12261d).f12287f.e();
                    k3 k3Var = (k3) this.f12260c;
                    Objects.requireNonNull(k3Var);
                    s1VarE.execute(new com.vungle.ads.internal.omsdk.a(k3Var, 7));
                }
                break;
            default:
                if (this.f12259b.compareAndSet(false, true)) {
                    ((o3) this.f12261d).f12351f.e().execute(new a4.c(this, 12));
                }
                break;
        }
        return i4.k0.e;
    }

    public i3(o3 o3Var, i4.f fVar) {
        this.f12261d = o3Var;
        r2.q.D(fVar, "subchannel");
        this.f12260c = fVar;
    }
}
