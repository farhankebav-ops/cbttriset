package k5;

import s4.g;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes5.dex */
public abstract class c extends a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final g f12701a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public Object f12702b;

    public c(g gVar) {
        this.f12701a = gVar;
    }

    @Override // o7.b
    public final void c(long j) {
        Object obj;
        if (f.d(j)) {
            do {
                int i2 = get();
                if ((i2 & (-2)) != 0) {
                    return;
                }
                if (i2 == 1) {
                    if (!compareAndSet(1, 3) || (obj = this.f12702b) == null) {
                        return;
                    }
                    this.f12702b = null;
                    g gVar = this.f12701a;
                    gVar.b(obj);
                    if (get() != 4) {
                        gVar.onComplete();
                        return;
                    }
                    return;
                }
            } while (!compareAndSet(0, 2));
        }
    }

    @Override // a5.h
    public final void clear() {
        lazySet(32);
        this.f12702b = null;
    }

    @Override // a5.d
    public final int d(int i2) {
        lazySet(8);
        return 2;
    }

    public final void g(Object obj) {
        int i2 = get();
        do {
            g gVar = this.f12701a;
            if (i2 == 8) {
                this.f12702b = obj;
                lazySet(16);
                gVar.b(obj);
                if (get() != 4) {
                    gVar.onComplete();
                    return;
                }
                return;
            }
            if ((i2 & (-3)) != 0) {
                return;
            }
            if (i2 == 2) {
                lazySet(3);
                gVar.b(obj);
                if (get() != 4) {
                    gVar.onComplete();
                    return;
                }
                return;
            }
            this.f12702b = obj;
            if (compareAndSet(0, 1)) {
                return;
            } else {
                i2 = get();
            }
        } while (i2 != 4);
        this.f12702b = null;
    }

    @Override // a5.h
    public final boolean isEmpty() {
        return get() != 16;
    }

    public void onSuccess(Object obj) {
        g(obj);
    }

    @Override // a5.h
    public final Object poll() {
        if (get() != 16) {
            return null;
        }
        lazySet(32);
        Object obj = this.f12702b;
        this.f12702b = null;
        return obj;
    }
}
