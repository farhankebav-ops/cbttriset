package k4;

import j4.h0;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes5.dex */
public final class a extends h0 {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ int f12613c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final /* synthetic */ c f12614d;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public a(c cVar, int i2) {
        super(cVar, 1);
        this.f12613c = i2;
        switch (i2) {
            case 1:
                this.f12614d = cVar;
                super(cVar, 1);
                r4.b.b();
                break;
            default:
                this.f12614d = cVar;
                r4.b.b();
                break;
        }
    }

    private final void c() {
        c cVar;
        int i2;
        l7.j jVar = new l7.j();
        r4.b.c();
        try {
            r4.a aVar = r4.b.f13625a;
            aVar.getClass();
            synchronized (this.f12614d.f12617a) {
                l7.j jVar2 = this.f12614d.f12618b;
                jVar.write(jVar2, jVar2.e());
                cVar = this.f12614d;
                cVar.f12621f = false;
                i2 = cVar.m;
            }
            cVar.f12622i.write(jVar, jVar.f12868b);
            synchronized (this.f12614d.f12617a) {
                this.f12614d.m -= i2;
            }
            aVar.getClass();
        } catch (Throwable th) {
            try {
                r4.b.f13625a.getClass();
            } catch (Throwable th2) {
                th.addSuppressed(th2);
            }
            throw th;
        }
    }

    @Override // j4.h0
    public final void a() {
        c cVar;
        switch (this.f12613c) {
            case 0:
                c();
                return;
            default:
                l7.j jVar = new l7.j();
                r4.b.c();
                try {
                    r4.a aVar = r4.b.f13625a;
                    aVar.getClass();
                    synchronized (this.f12614d.f12617a) {
                        l7.j jVar2 = this.f12614d.f12618b;
                        jVar.write(jVar2, jVar2.f12868b);
                        cVar = this.f12614d;
                        cVar.g = false;
                        break;
                    }
                    cVar.f12622i.write(jVar, jVar.f12868b);
                    this.f12614d.f12622i.flush();
                    aVar.getClass();
                    return;
                } catch (Throwable th) {
                    try {
                        r4.b.f13625a.getClass();
                        break;
                    } catch (Throwable th2) {
                        th.addSuppressed(th2);
                    }
                    throw th;
                }
        }
    }
}
