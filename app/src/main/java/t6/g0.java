package t6;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes5.dex */
public final class g0 implements f {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f17441a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ kotlin.jvm.internal.a0 f17442b;

    public /* synthetic */ g0(kotlin.jvm.internal.a0 a0Var, int i2) {
        this.f17441a = i2;
        this.f17442b = a0Var;
    }

    @Override // t6.f
    public final Object emit(Object obj, v5.c cVar) {
        switch (this.f17441a) {
            case 0:
                this.f17442b.f12717a = obj;
                throw new u6.a(this);
            case 1:
                this.f17442b.f12717a = obj;
                throw new u6.a(this);
            default:
                kotlin.jvm.internal.a0 a0Var = this.f17442b;
                if (a0Var.f12717a != u6.c.f17544b) {
                    throw new IllegalArgumentException("Flow has more than one element");
                }
                a0Var.f12717a = obj;
                return q5.x.f13520a;
        }
    }
}
