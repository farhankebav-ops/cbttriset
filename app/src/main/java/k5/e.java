package k5;

import java.util.concurrent.atomic.AtomicInteger;
import s4.g;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes5.dex */
public final class e extends AtomicInteger implements a5.e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Object f12705a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final g f12706b;

    public e(Object obj, g gVar) {
        this.f12706b = gVar;
        this.f12705a = obj;
    }

    @Override // o7.b
    public final void c(long j) {
        if (f.d(j) && compareAndSet(0, 1)) {
            Object obj = this.f12705a;
            g gVar = this.f12706b;
            gVar.b(obj);
            if (get() != 2) {
                gVar.onComplete();
            }
        }
    }

    @Override // o7.b
    public final void cancel() {
        lazySet(2);
    }

    @Override // a5.h
    public final void clear() {
        lazySet(1);
    }

    @Override // a5.d
    public final int d(int i2) {
        return 1;
    }

    @Override // a5.h
    public final boolean isEmpty() {
        return get() != 0;
    }

    @Override // a5.h
    public final boolean offer(Object obj) {
        throw new UnsupportedOperationException("Should not be called!");
    }

    @Override // a5.h
    public final Object poll() {
        if (get() != 0) {
            return null;
        }
        lazySet(1);
        return this.f12705a;
    }
}
