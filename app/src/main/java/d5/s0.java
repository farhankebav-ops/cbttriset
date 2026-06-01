package d5;

import androidx.core.location.LocationRequestCompat;
import java.util.Collection;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes5.dex */
public final class s0 extends k5.c implements s4.g, o7.b {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public o7.b f11151c;

    @Override // s4.g
    public final void b(Object obj) {
        Collection collection = (Collection) this.f12702b;
        if (collection != null) {
            collection.add(obj);
        }
    }

    @Override // o7.b
    public final void cancel() {
        set(4);
        this.f12702b = null;
        this.f11151c.cancel();
    }

    @Override // s4.g
    public final void f(o7.b bVar) {
        if (k5.f.e(this.f11151c, bVar)) {
            this.f11151c = bVar;
            this.f12701a.f(this);
            bVar.c(LocationRequestCompat.PASSIVE_INTERVAL);
        }
    }

    @Override // s4.g
    public final void onComplete() {
        g(this.f12702b);
    }

    @Override // s4.g
    public final void onError(Throwable th) {
        this.f12702b = null;
        this.f12701a.onError(th);
    }
}
