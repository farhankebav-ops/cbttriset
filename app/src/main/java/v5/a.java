package v5;

import e6.p;
import kotlin.jvm.internal.k;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes5.dex */
public abstract class a implements f {
    private final g key;

    public a(g key) {
        k.e(key, "key");
        this.key = key;
    }

    @Override // v5.h
    public <R> R fold(R r7, p operation) {
        k.e(operation, "operation");
        return (R) operation.invoke(r7, this);
    }

    @Override // v5.h
    public <E extends f> E get(g gVar) {
        return (E) a.a.A(this, gVar);
    }

    @Override // v5.f
    public g getKey() {
        return this.key;
    }

    @Override // v5.h
    public h minusKey(g gVar) {
        return a.a.N(this, gVar);
    }

    @Override // v5.h
    public h plus(h hVar) {
        return a.a.O(this, hVar);
    }
}
