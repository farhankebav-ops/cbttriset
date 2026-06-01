package t6;

import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes5.dex */
public final class e1 extends u6.d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final AtomicReference f17434a = new AtomicReference(null);

    @Override // u6.d
    public final boolean a(u6.b bVar) {
        AtomicReference atomicReference = this.f17434a;
        if (atomicReference.get() != null) {
            return false;
        }
        atomicReference.set(x0.f17504b);
        return true;
    }

    @Override // u6.d
    public final v5.c[] b(u6.b bVar) {
        this.f17434a.set(null);
        return u6.c.f17543a;
    }
}
