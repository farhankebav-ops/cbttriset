package q6;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes5.dex */
public final /* synthetic */ class k implements e6.q {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f13557a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ Object f13558b;

    public /* synthetic */ k(Object obj, int i2) {
        this.f13557a = i2;
        this.f13558b = obj;
    }

    @Override // e6.q
    public final Object invoke(Object obj, Object obj2, Object obj3) {
        switch (this.f13557a) {
            case 0:
                ((androidx.camera.core.impl.utils.a) this.f13558b).invoke((Throwable) obj);
                break;
            case 1:
                z6.c cVar = (z6.c) this.f13558b;
                z6.c.g.set(cVar, null);
                cVar.f(null);
                break;
            default:
                ((z6.g) this.f13558b).b();
                break;
        }
        return q5.x.f13520a;
    }

    public /* synthetic */ k(z6.c cVar, z6.b bVar) {
        this.f13557a = 1;
        this.f13558b = cVar;
    }
}
