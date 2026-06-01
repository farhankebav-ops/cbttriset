package e5;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes5.dex */
public final class h extends s4.h {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f11271a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Object f11272b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Object f11273c;

    public /* synthetic */ h(int i2, Object obj, Object obj2) {
        this.f11271a = i2;
        this.f11272b = obj;
        this.f11273c = obj2;
    }

    @Override // s4.h
    public final void c(s4.j jVar) {
        switch (this.f11271a) {
            case 0:
                ((s4.q) this.f11272b).b(new f(jVar, (x4.d) this.f11273c, 1));
                break;
            default:
                s4.k[] kVarArr = (s4.k[]) this.f11272b;
                int length = kVarArr.length;
                if (length == 1) {
                    ((s4.h) kVarArr[0]).b(new c5.e(jVar, new a4.a(this, 10), 1));
                } else {
                    w wVar = new w(jVar, length, (w1.f) this.f11273c);
                    jVar.a(wVar);
                    for (int i2 = 0; i2 < length; i2++) {
                        if (!(wVar.get() <= 0)) {
                            s4.k kVar = kVarArr[i2];
                            if (kVar == null) {
                                NullPointerException nullPointerException = new NullPointerException("One of the sources is null");
                                if (wVar.getAndSet(0) > 0) {
                                    wVar.a(i2);
                                    wVar.f11302a.onError(nullPointerException);
                                } else {
                                    n7.b.F(nullPointerException);
                                }
                            } else {
                                ((s4.h) kVar).b(wVar.f11304c[i2]);
                            }
                        }
                    }
                }
                break;
        }
    }
}
