package d5;

import java.util.concurrent.atomic.AtomicLong;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes5.dex */
public abstract class i extends AtomicLong implements s4.e, o7.b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final s4.g f11099a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final b5.b f11100b = new b5.b(2);

    public i(s4.g gVar) {
        this.f11099a = gVar;
    }

    public final void a() {
        b5.b bVar = this.f11100b;
        if (bVar.b()) {
            return;
        }
        try {
            this.f11099a.onComplete();
        } finally {
            y4.a.a(bVar);
        }
    }

    @Override // o7.b
    public final void c(long j) {
        if (k5.f.d(j)) {
            a.a.f(this, j);
            f();
        }
    }

    @Override // o7.b
    public final void cancel() {
        b5.b bVar = this.f11100b;
        bVar.getClass();
        y4.a.a(bVar);
        g();
    }

    public final boolean d(Throwable th) {
        if (th == null) {
            th = new NullPointerException("onError called with null. Null values are generally not allowed in 2.x operators and sources.");
        }
        b5.b bVar = this.f11100b;
        if (bVar.b()) {
            return false;
        }
        try {
            this.f11099a.onError(th);
            y4.a.a(bVar);
            return true;
        } catch (Throwable th2) {
            y4.a.a(bVar);
            throw th2;
        }
    }

    public final void e(Throwable th) {
        if (h(th)) {
            return;
        }
        n7.b.F(th);
    }

    public boolean h(Throwable th) {
        return d(th);
    }

    @Override // java.util.concurrent.atomic.AtomicLong
    public final String toString() {
        return androidx.camera.core.processing.util.a.l(getClass().getSimpleName(), "{", super.toString(), "}");
    }

    public void f() {
    }

    public void g() {
    }
}
