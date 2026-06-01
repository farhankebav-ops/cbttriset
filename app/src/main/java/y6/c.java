package y6;

import e6.q;
import q6.o0;
import v6.s;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes5.dex */
public final class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Object f17854a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final q f17855b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final q f17856c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final Object f17857d;
    public final x5.i e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final q f17858f;
    public Object g;
    public int h = -1;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final /* synthetic */ e f17859i;

    public c(e eVar, Object obj, q qVar, q qVar2, e2.f fVar, x5.i iVar, q qVar3) {
        this.f17859i = eVar;
        this.f17854a = obj;
        this.f17855b = qVar;
        this.f17856c = qVar2;
        this.f17857d = fVar;
        this.e = iVar;
        this.f17858f = qVar3;
    }

    public final void a() {
        Object obj = this.g;
        if (obj instanceof s) {
            ((s) obj).h(this.h, this.f17859i.f17863a);
            return;
        }
        o0 o0Var = obj instanceof o0 ? (o0) obj : null;
        if (o0Var != null) {
            o0Var.dispose();
        }
    }
}
