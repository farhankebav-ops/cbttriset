package p0;

import java.util.HashMap;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes3.dex */
public final class u implements m0.g {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final k f13308a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f13309b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final m0.c f13310c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final m0.f f13311d;
    public final v e;

    public u(k kVar, String str, m0.c cVar, m0.f fVar, v vVar) {
        this.f13308a = kVar;
        this.f13309b = str;
        this.f13310c = cVar;
        this.f13311d = fVar;
        this.e = vVar;
    }

    public final void a(m0.d dVar, m0.i iVar) {
        if (dVar == null) {
            throw new NullPointerException("Null event");
        }
        m0.f fVar = this.f13311d;
        if (fVar == null) {
            throw new NullPointerException("Null transformer");
        }
        v vVar = this.e;
        u0.c cVar = vVar.f13314c;
        m0.a aVar = (m0.a) dVar;
        k kVarA = this.f13308a.a(aVar.f12917b);
        i iVar2 = new i();
        iVar2.f13284f = new HashMap();
        iVar2.f13283d = Long.valueOf(vVar.f13312a.getTime());
        iVar2.e = Long.valueOf(vVar.f13313b.getTime());
        iVar2.f13280a = this.f13309b;
        iVar2.f13282c = new n(this.f13310c, (byte[]) fVar.apply(aVar.f12916a));
        iVar2.f13281b = null;
        m0.b bVar = aVar.f12918c;
        if (bVar != null) {
            iVar2.g = bVar.f12919a;
        }
        u0.a aVar2 = (u0.a) cVar;
        aVar2.f17518b.execute(new a3.d(aVar2, kVarA, iVar, iVar2.b(), 11));
    }

    public final void b(m0.d dVar) {
        a(dVar, new com.mimikridev.utilmanager.config.b(10));
    }
}
