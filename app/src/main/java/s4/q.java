package s4;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes5.dex */
public abstract class q {
    public final void b(r rVar) {
        try {
            c(rVar);
        } catch (NullPointerException e) {
            throw e;
        } catch (Throwable th) {
            r2.q.y0(th);
            NullPointerException nullPointerException = new NullPointerException("subscribeActual failed");
            nullPointerException.initCause(th);
            throw nullPointerException;
        }
    }

    public abstract void c(r rVar);
}
