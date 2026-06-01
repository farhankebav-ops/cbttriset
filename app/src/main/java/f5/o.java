package f5;

import java.util.concurrent.atomic.AtomicInteger;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes5.dex */
public final class o extends AtomicInteger implements a5.c, Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final s4.m f11411a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Object f11412b;

    public o(s4.m mVar, Object obj) {
        this.f11411a = mVar;
        this.f11412b = obj;
    }

    @Override // a5.h
    public final void clear() {
        lazySet(3);
    }

    @Override // a5.d
    public final int d(int i2) {
        lazySet(1);
        return 1;
    }

    @Override // u4.b
    public final void dispose() {
        set(3);
    }

    @Override // a5.h
    public final boolean isEmpty() {
        return get() != 1;
    }

    @Override // a5.h
    public final boolean offer(Object obj) {
        throw new UnsupportedOperationException("Should not be called!");
    }

    @Override // a5.h
    public final Object poll() {
        if (get() != 1) {
            return null;
        }
        lazySet(3);
        return this.f11412b;
    }

    @Override // java.lang.Runnable
    public final void run() {
        if (get() == 0 && compareAndSet(0, 2)) {
            Object obj = this.f11412b;
            s4.m mVar = this.f11411a;
            mVar.b(obj);
            if (get() == 2) {
                lazySet(3);
                mVar.onComplete();
            }
        }
    }
}
