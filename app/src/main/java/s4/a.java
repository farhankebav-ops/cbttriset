package s4;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes5.dex */
public abstract class a implements c {
    public final c5.b b(a aVar) {
        z4.b.a(aVar, "other is null");
        return new c5.b(new c[]{this, aVar}, 0);
    }

    public final c5.f c(x4.a aVar) {
        return new c5.f(this, z4.b.f17984d, aVar);
    }

    public final void d(b bVar) {
        try {
            e(bVar);
        } catch (NullPointerException e) {
            throw e;
        } catch (Throwable th) {
            r2.q.y0(th);
            n7.b.F(th);
            NullPointerException nullPointerException = new NullPointerException("Actually not, but can't pass out an exception otherwise...");
            nullPointerException.initCause(th);
            throw nullPointerException;
        }
    }

    public abstract void e(b bVar);

    public final h f() {
        return new e5.d(this, 1);
    }
}
