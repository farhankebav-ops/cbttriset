package v6;

import q6.e0;
import q6.h0;
import q6.o0;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes5.dex */
public final class o extends q6.w implements h0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ h0 f17642a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final q6.w f17643b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f17644c;

    /* JADX WARN: Multi-variable type inference failed */
    public o(q6.w wVar, String str) {
        h0 h0Var = wVar instanceof h0 ? (h0) wVar : null;
        this.f17642a = h0Var == null ? e0.f13545a : h0Var;
        this.f17643b = wVar;
        this.f17644c = str;
    }

    @Override // q6.w
    public final void dispatch(v5.h hVar, Runnable runnable) {
        this.f17643b.dispatch(hVar, runnable);
    }

    @Override // q6.w
    public final void dispatchYield(v5.h hVar, Runnable runnable) {
        this.f17643b.dispatchYield(hVar, runnable);
    }

    @Override // q6.h0
    public final o0 e(long j, Runnable runnable, v5.h hVar) {
        return this.f17642a.e(j, runnable, hVar);
    }

    @Override // q6.w
    public final boolean isDispatchNeeded(v5.h hVar) {
        return this.f17643b.isDispatchNeeded(hVar);
    }

    @Override // q6.h0
    public final void l(long j, q6.l lVar) {
        this.f17642a.l(j, lVar);
    }

    @Override // q6.w
    public final String toString() {
        return this.f17644c;
    }
}
