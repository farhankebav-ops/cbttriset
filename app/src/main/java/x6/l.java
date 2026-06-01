package x6;

import q6.w;
import v6.o;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes5.dex */
public final class l extends w {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final l f17823a = new l();

    @Override // q6.w
    public final void dispatch(v5.h hVar, Runnable runnable) {
        e.f17812b.f17814a.b(true, false, runnable);
    }

    @Override // q6.w
    public final void dispatchYield(v5.h hVar, Runnable runnable) {
        e.f17812b.f17814a.b(true, true, runnable);
    }

    @Override // q6.w
    public final w limitedParallelism(int i2, String str) {
        v6.a.a(i2);
        return i2 >= k.f17821d ? str != null ? new o(this, str) : this : super.limitedParallelism(i2, str);
    }

    @Override // q6.w
    public final String toString() {
        return "Dispatchers.IO";
    }
}
