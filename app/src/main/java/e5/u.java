package e5;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes5.dex */
public final class u extends b5.a implements s4.j {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final s4.m f11297a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public Object f11298b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public u4.b f11299c;

    public u(s4.m mVar) {
        this.f11297a = mVar;
    }

    @Override // s4.j, s4.r
    public final void a(u4.b bVar) {
        if (y4.a.f(this.f11299c, bVar)) {
            this.f11299c = bVar;
            this.f11297a.a(this);
        }
    }

    @Override // a5.h
    public final void clear() {
        lazySet(32);
        this.f11298b = null;
    }

    @Override // a5.d
    public final int d(int i2) {
        lazySet(8);
        return 2;
    }

    @Override // u4.b
    public final void dispose() {
        set(4);
        this.f11298b = null;
        this.f11299c.dispose();
    }

    @Override // a5.h
    public final boolean isEmpty() {
        return get() != 16;
    }

    @Override // s4.j
    public final void onComplete() {
        if ((get() & 54) != 0) {
            return;
        }
        lazySet(2);
        this.f11297a.onComplete();
    }

    @Override // s4.j, s4.r
    public final void onError(Throwable th) {
        if ((get() & 54) != 0) {
            n7.b.F(th);
        } else {
            lazySet(2);
            this.f11297a.onError(th);
        }
    }

    @Override // s4.j, s4.r
    public final void onSuccess(Object obj) {
        int i2 = get();
        if ((i2 & 54) != 0) {
            return;
        }
        s4.m mVar = this.f11297a;
        if (i2 == 8) {
            this.f11298b = obj;
            lazySet(16);
            mVar.b(null);
        } else {
            lazySet(2);
            mVar.b(obj);
        }
        if (get() != 4) {
            mVar.onComplete();
        }
    }

    @Override // a5.h
    public final Object poll() {
        if (get() != 16) {
            return null;
        }
        Object obj = this.f11298b;
        this.f11298b = null;
        lazySet(32);
        return obj;
    }
}
