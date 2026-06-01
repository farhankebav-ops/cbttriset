package x6;

import java.util.concurrent.Executor;
import q6.x0;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes5.dex */
public abstract class h extends x0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public c f17814a;

    @Override // q6.w
    public final void dispatch(v5.h hVar, Runnable runnable) {
        c.e(this.f17814a, runnable, 6);
    }

    @Override // q6.w
    public final void dispatchYield(v5.h hVar, Runnable runnable) {
        c.e(this.f17814a, runnable, 2);
    }

    @Override // q6.x0
    public final Executor o() {
        return this.f17814a;
    }
}
