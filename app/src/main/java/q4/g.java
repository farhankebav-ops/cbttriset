package q4;

import i4.n0;
import i4.o0;
import java.util.IdentityHashMap;
import java.util.Map;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes5.dex */
public final class g extends b {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final i4.f f13443d;
    public final n0 e;

    public g(i4.f fVar, n0 n0Var) {
        r2.q.D(fVar, "delegate");
        this.f13443d = fVar;
        r2.q.D(n0Var, "healthListener");
        this.e = n0Var;
    }

    @Override // i4.f
    public final i4.b d() {
        i4.b bVarD = this.f13443d.d();
        bVarD.getClass();
        Boolean bool = Boolean.TRUE;
        IdentityHashMap identityHashMap = new IdentityHashMap(1);
        identityHashMap.put(o0.f11924d, bool);
        for (Map.Entry entry : bVarD.f11822a.entrySet()) {
            if (!identityHashMap.containsKey(entry.getKey())) {
                identityHashMap.put((i4.a) entry.getKey(), entry.getValue());
            }
        }
        return new i4.b(identityHashMap);
    }

    @Override // i4.f
    public final void r(n0 n0Var) {
        this.f13443d.r(new f(this, n0Var, 0));
    }

    @Override // q4.b
    public final i4.f t() {
        return this.f13443d;
    }
}
