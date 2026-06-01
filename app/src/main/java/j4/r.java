package j4;

import java.io.InputStream;
import java.util.logging.Logger;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes5.dex */
public final class r extends h0 {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ int f12403c = 1;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final /* synthetic */ e2.h f12404d;
    public final /* synthetic */ Object e;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public r(e2.h hVar, i4.a1 a1Var) {
        super(((v) hVar.f11233c).h, 0);
        this.f12404d = hVar;
        this.e = a1Var;
    }

    @Override // j4.h0
    public final void b() {
        switch (this.f12403c) {
            case 0:
                e2.h hVar = this.f12404d;
                r4.b.c();
                try {
                    r4.b.a();
                    r4.b.f13625a.getClass();
                    if (((i4.n1) hVar.f11232b) == null) {
                        try {
                            ((i4.x) hVar.f11231a).g((i4.a1) this.e);
                        } catch (Throwable th) {
                            i4.n1 n1VarH = i4.n1.f11914f.g(th).h("Failed to read headers");
                            hVar.f11232b = n1VarH;
                            ((v) hVar.f11233c).l.d(n1VarH);
                        }
                        break;
                    }
                    r4.b.f13625a.getClass();
                    return;
                } finally {
                    try {
                        r4.b.f13625a.getClass();
                        break;
                    } catch (Throwable th2) {
                        th.addSuppressed(th2);
                    }
                }
            default:
                r4.b.c();
                try {
                    r4.b.a();
                    r4.a aVar = r4.b.f13625a;
                    aVar.getClass();
                    c();
                    aVar.getClass();
                    return;
                } catch (Throwable th3) {
                    try {
                        break;
                    } catch (Throwable th22) {
                    }
                    throw th3;
                }
        }
    }

    public void c() {
        a4.a aVar = (a4.a) this.e;
        e2.h hVar = this.f12404d;
        v vVar = (v) hVar.f11233c;
        if (((i4.n1) hVar.f11232b) != null) {
            Logger logger = f1.f12183a;
            while (true) {
                InputStream inputStreamK = aVar.k();
                if (inputStreamK == null) {
                    return;
                } else {
                    f1.b(inputStreamK);
                }
            }
        } else {
            while (true) {
                try {
                    InputStream inputStreamK2 = aVar.k();
                    if (inputStreamK2 == null) {
                        return;
                    }
                    try {
                        ((i4.x) hVar.f11231a).h(vVar.f12495d.e(inputStreamK2));
                        inputStreamK2.close();
                    } catch (Throwable th) {
                        f1.b(inputStreamK2);
                        throw th;
                    }
                } catch (Throwable th2) {
                    Logger logger2 = f1.f12183a;
                    while (true) {
                        InputStream inputStreamK3 = aVar.k();
                        if (inputStreamK3 == null) {
                            i4.n1 n1VarH = i4.n1.f11914f.g(th2).h("Failed to read message.");
                            hVar.f11232b = n1VarH;
                            vVar.l.d(n1VarH);
                            return;
                        }
                        f1.b(inputStreamK3);
                    }
                }
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public r(e2.h hVar, a4.a aVar) {
        super(((v) hVar.f11233c).h, 0);
        this.f12404d = hVar;
        this.e = aVar;
    }
}
