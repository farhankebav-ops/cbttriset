package d5;

import androidx.core.location.LocationRequestCompat;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes5.dex */
public final class q extends k5.c implements s4.g {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public o7.b f11140c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public long f11141d;
    public boolean e;

    @Override // s4.g
    public final void b(Object obj) {
        if (this.e) {
            return;
        }
        long j = this.f11141d;
        if (j != 0) {
            this.f11141d = j + 1;
            return;
        }
        this.e = true;
        this.f11140c.cancel();
        g(obj);
    }

    @Override // o7.b
    public final void cancel() {
        set(4);
        this.f12702b = null;
        this.f11140c.cancel();
    }

    @Override // s4.g
    public final void f(o7.b bVar) {
        if (k5.f.e(this.f11140c, bVar)) {
            this.f11140c = bVar;
            this.f12701a.f(this);
            bVar.c(LocationRequestCompat.PASSIVE_INTERVAL);
        }
    }

    @Override // s4.g
    public final void onComplete() {
        if (this.e) {
            return;
        }
        this.e = true;
        this.f12701a.onComplete();
    }

    @Override // s4.g
    public final void onError(Throwable th) {
        if (this.e) {
            n7.b.F(th);
        } else {
            this.e = true;
            this.f12701a.onError(th);
        }
    }
}
