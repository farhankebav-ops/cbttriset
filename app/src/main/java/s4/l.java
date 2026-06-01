package s4;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes5.dex */
public abstract class l {
    public final void c(m mVar) {
        try {
            d(mVar);
        } catch (NullPointerException e) {
            throw e;
        } catch (Throwable th) {
            r2.q.y0(th);
            n7.b.F(th);
            NullPointerException nullPointerException = new NullPointerException("Actually not, but can't throw other exceptions due to RS");
            nullPointerException.initCause(th);
            throw nullPointerException;
        }
    }

    public abstract void d(m mVar);
}
