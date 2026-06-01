package j4;

import java.util.Collections;
import java.util.IdentityHashMap;
import java.util.List;
import java.util.Map;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes5.dex */
public final class q4 extends i4.f {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final i4.f f12402d;
    public final /* synthetic */ r4 e;

    public q4(r4 r4Var, i4.f fVar) {
        this.e = r4Var;
        this.f12402d = fVar;
    }

    @Override // i4.f
    public final void k(i4.n1 n1Var) {
        this.f12402d.k(n1Var);
        this.e.f12436c.execute(new com.vungle.ads.internal.omsdk.a(this, 8));
    }

    @Override // i4.f
    public final void l(i4.f1 f1Var) {
        i4.b bVar = f1Var.f11861b;
        IdentityHashMap identityHashMap = bVar.f11822a;
        i4.a aVar = r4.f12433d;
        if (identityHashMap.get(aVar) != null) {
            throw new IllegalStateException("RetryingNameResolver can only be used once to wrap a NameResolver");
        }
        List list = Collections.EMPTY_LIST;
        i4.b bVar2 = i4.b.f11821b;
        List list2 = f1Var.f11860a;
        i4.e1 e1Var = f1Var.f11862c;
        bVar.getClass();
        p4 p4Var = new p4(this.e);
        IdentityHashMap identityHashMap2 = new IdentityHashMap(1);
        identityHashMap2.put(aVar, p4Var);
        for (Map.Entry entry : bVar.f11822a.entrySet()) {
            if (!identityHashMap2.containsKey(entry.getKey())) {
                identityHashMap2.put((i4.a) entry.getKey(), entry.getValue());
            }
        }
        this.f12402d.l(new i4.f1(list2, new i4.b(identityHashMap2), e1Var));
    }
}
