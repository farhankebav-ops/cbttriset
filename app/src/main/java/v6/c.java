package v6;

import q6.a0;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes5.dex */
public final class c implements a0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final v5.h f17620a;

    public c(v5.h hVar) {
        this.f17620a = hVar;
    }

    @Override // q6.a0
    public final v5.h getCoroutineContext() {
        return this.f17620a;
    }

    public final String toString() {
        return "CoroutineScope(coroutineContext=" + this.f17620a + ')';
    }
}
