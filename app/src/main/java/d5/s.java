package d5;

import androidx.core.location.LocationRequestCompat;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes5.dex */
public final class s implements s4.g, u4.b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final s4.j f11147a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public o7.b f11148b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public long f11149c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public boolean f11150d;

    public s(s4.j jVar) {
        this.f11147a = jVar;
    }

    @Override // s4.g
    public final void b(Object obj) {
        if (this.f11150d) {
            return;
        }
        long j = this.f11149c;
        if (j != 0) {
            this.f11149c = j + 1;
            return;
        }
        this.f11150d = true;
        this.f11148b.cancel();
        this.f11148b = k5.f.f12707a;
        this.f11147a.onSuccess(obj);
    }

    @Override // u4.b
    public final void dispose() {
        this.f11148b.cancel();
        this.f11148b = k5.f.f12707a;
    }

    @Override // s4.g
    public final void f(o7.b bVar) {
        if (k5.f.e(this.f11148b, bVar)) {
            this.f11148b = bVar;
            this.f11147a.a(this);
            bVar.c(LocationRequestCompat.PASSIVE_INTERVAL);
        }
    }

    @Override // s4.g
    public final void onComplete() {
        this.f11148b = k5.f.f12707a;
        if (this.f11150d) {
            return;
        }
        this.f11150d = true;
        this.f11147a.onComplete();
    }

    @Override // s4.g
    public final void onError(Throwable th) {
        if (this.f11150d) {
            n7.b.F(th);
            return;
        }
        this.f11150d = true;
        this.f11148b = k5.f.f12707a;
        this.f11147a.onError(th);
    }
}
