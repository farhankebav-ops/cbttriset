package f5;

import com.google.firebase.inappmessaging.internal.s;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes5.dex */
public final class l extends s4.a implements a5.b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final c f11403a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final s f11404b;

    public l(c cVar, s sVar) {
        this.f11403a = cVar;
        this.f11404b = sVar;
    }

    @Override // a5.b
    public final s4.l a() {
        return new c(this.f11403a, this.f11404b, 2);
    }

    @Override // s4.a
    public final void e(s4.b bVar) {
        this.f11403a.c(new k(bVar, this.f11404b));
    }
}
