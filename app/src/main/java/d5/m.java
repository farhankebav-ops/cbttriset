package d5;

import com.google.protobuf.Internal;
import java.util.Iterator;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes5.dex */
public final class m extends s4.d {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ int f11118b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Object f11119c;

    public /* synthetic */ m(Object obj, int i2) {
        this.f11118b = i2;
        this.f11119c = obj;
    }

    public static void f(s4.g gVar, Iterator it) {
        try {
            if (!it.hasNext()) {
                k5.d.a(gVar);
            } else if (gVar instanceof a5.a) {
                gVar.f(new e0((a5.a) gVar, it, 0));
            } else {
                gVar.f(new e0(gVar, it, 1));
            }
        } catch (Throwable th) {
            r2.q.y0(th);
            k5.d.b(th, gVar);
        }
    }

    @Override // s4.d
    public final void e(s4.g gVar) {
        switch (this.f11118b) {
            case 0:
                int iB = q0.c.b(3);
                i jVar = iB != 0 ? iB != 1 ? iB != 3 ? iB != 4 ? new j(gVar, s4.d.f13683a) : new j(gVar) : new k(gVar, 0) : new k(gVar, 1) : new l(gVar);
                gVar.f(jVar);
                try {
                    ((s4.f) this.f11119c).subscribe(jVar);
                } catch (Throwable th) {
                    r2.q.y0(th);
                    jVar.e(th);
                    return;
                }
                break;
            case 1:
                Object[] objArr = (Object[]) this.f11119c;
                if (!(gVar instanceof a5.a)) {
                    gVar.f(new d0(gVar, objArr, 1));
                } else {
                    gVar.f(new d0((a5.a) gVar, objArr, 0));
                }
                break;
            case 2:
                try {
                    f(gVar, ((Internal.ProtobufList) this.f11119c).iterator());
                } catch (Throwable th2) {
                    r2.q.y0(th2);
                    k5.d.b(th2, gVar);
                    return;
                }
                break;
            case 3:
                ((s4.l) this.f11119c).c(new f0(gVar));
                break;
            default:
                ((e5.k) this.f11119c).b(new e5.t(gVar));
                break;
        }
    }
}
