package x5;

import kotlin.jvm.internal.k;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes5.dex */
public abstract class c extends a {
    private final v5.h _context;
    private transient v5.c<Object> intercepted;

    public c(v5.c cVar, v5.h hVar) {
        super(cVar);
        this._context = hVar;
    }

    @Override // v5.c
    public v5.h getContext() {
        v5.h hVar = this._context;
        k.b(hVar);
        return hVar;
    }

    public final v5.c<Object> intercepted() {
        v5.c cVarInterceptContinuation = this.intercepted;
        if (cVarInterceptContinuation == null) {
            v5.e eVar = (v5.e) getContext().get(v5.d.f17609a);
            if (eVar == null || (cVarInterceptContinuation = eVar.interceptContinuation(this)) == null) {
                cVarInterceptContinuation = this;
            }
            this.intercepted = cVarInterceptContinuation;
        }
        return cVarInterceptContinuation;
    }

    @Override // x5.a
    public void releaseIntercepted() {
        v5.c<Object> cVar = this.intercepted;
        if (cVar != null && cVar != this) {
            v5.f fVar = getContext().get(v5.d.f17609a);
            k.b(fVar);
            ((v5.e) fVar).releaseInterceptedContinuation(cVar);
        }
        this.intercepted = b.f17790a;
    }

    public c(v5.c cVar) {
        this(cVar, cVar != null ? cVar.getContext() : null);
    }
}
