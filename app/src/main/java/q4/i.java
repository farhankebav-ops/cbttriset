package q4;

import i4.m0;
import i4.p0;
import j4.e2;
import j4.p3;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes5.dex */
public final class i {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final j f13446a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final e f13447b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final p0 f13448c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public i4.m f13449d;
    public m0 e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public boolean f13450f = false;
    public final /* synthetic */ x g;

    public i(x xVar, j jVar, p3 p3Var, e2 e2Var) {
        this.g = xVar;
        this.f13446a = jVar;
        this.f13448c = p3Var;
        this.e = e2Var;
        e eVar = new e(new h(this, 1));
        this.f13447b = eVar;
        this.f13449d = i4.m.f11894a;
        eVar.i(p3Var);
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder("Address = ");
        sb.append(this.f13446a);
        sb.append(", state = ");
        sb.append(this.f13449d);
        sb.append(", picker type: ");
        sb.append(this.e.getClass());
        sb.append(", lb: ");
        sb.append(this.f13447b.g().getClass());
        sb.append(this.f13450f ? ", deactivated" : "");
        return sb.toString();
    }
}
