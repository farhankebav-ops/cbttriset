package b5;

import java.util.concurrent.atomic.AtomicReference;
import v4.d;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes5.dex */
public final class b extends AtomicReference implements s4.b, u4.b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f4146a;

    public /* synthetic */ b(int i2) {
        this.f4146a = i2;
    }

    @Override // s4.b, s4.j, s4.r
    public void a(u4.b bVar) {
        y4.a.e(this, bVar);
    }

    public boolean b() {
        switch (this.f4146a) {
            case 1:
                return get() == null;
            default:
                return y4.a.b((u4.b) get());
        }
    }

    public void c(u4.b bVar) {
        while (true) {
            u4.b bVar2 = (u4.b) get();
            if (bVar2 == y4.a.f17847a) {
                if (bVar != null) {
                    bVar.dispose();
                    return;
                }
                return;
            } else {
                while (!compareAndSet(bVar2, bVar)) {
                    if (get() != bVar2) {
                        break;
                    }
                }
                if (bVar2 != null) {
                    bVar2.dispose();
                    return;
                }
                return;
            }
        }
    }

    @Override // u4.b
    public final void dispose() {
        Object andSet;
        switch (this.f4146a) {
            case 0:
                y4.a.a(this);
                break;
            case 1:
                if (get() != null && (andSet = getAndSet(null)) != null) {
                    ((Runnable) andSet).run();
                    break;
                }
                break;
            default:
                y4.a.a(this);
                break;
        }
    }

    @Override // s4.b, s4.j
    public void onComplete() {
        lazySet(y4.a.f17847a);
    }

    @Override // s4.b, s4.j, s4.r
    public void onError(Throwable th) {
        lazySet(y4.a.f17847a);
        n7.b.F(new d(th));
    }

    @Override // java.util.concurrent.atomic.AtomicReference
    public String toString() {
        switch (this.f4146a) {
            case 1:
                return "RunnableDisposable(disposed=" + b() + ", " + get() + ")";
            default:
                return super.toString();
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public /* synthetic */ b(Object obj) {
        super(obj);
        this.f4146a = 1;
    }
}
