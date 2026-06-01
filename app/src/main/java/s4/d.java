package s4;

import d5.b0;
import d5.n0;
import d5.q0;
import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes5.dex */
public abstract class d implements o7.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final int f13683a = Math.max(1, Integer.getInteger("rx2.buffer-size", 128).intValue());

    @Override // o7.a
    public final void a(g gVar) {
        if (gVar != null) {
            d(gVar);
        } else {
            z4.b.a(gVar, "s is null");
            d(new j5.d(gVar));
        }
    }

    public final b0 b(x4.c cVar) {
        z4.b.a(cVar, "mapper is null");
        z4.b.b(Integer.MAX_VALUE, "maxConcurrency");
        return new b0(this, cVar);
    }

    public final q0 c() {
        int i2 = f13683a;
        z4.b.b(i2, "bufferSize");
        AtomicReference atomicReference = new AtomicReference();
        return new q0(new n0(atomicReference, i2), this, atomicReference, i2);
    }

    public final void d(g gVar) {
        z4.b.a(gVar, "s is null");
        try {
            e(gVar);
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

    public abstract void e(g gVar);
}
