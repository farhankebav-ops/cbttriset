package v6;

import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;
import q6.c0;
import q6.k0;
import q6.w0;
import q6.x1;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes5.dex */
public final class f extends k0 implements x5.d, v5.c {
    public static final /* synthetic */ AtomicReferenceFieldUpdater h = AtomicReferenceFieldUpdater.newUpdater(f.class, Object.class, "_reusableCancellableContinuation$volatile");
    private volatile /* synthetic */ Object _reusableCancellableContinuation$volatile;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final q6.w f17623d;
    public final v5.c e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public Object f17624f;
    public final Object g;

    public f(q6.w wVar, v5.c cVar) {
        super(-1);
        this.f17623d = wVar;
        this.e = cVar;
        this.f17624f = a.f17614b;
        this.g = a.k(cVar.getContext());
    }

    @Override // x5.d
    public final x5.d getCallerFrame() {
        v5.c cVar = this.e;
        if (cVar instanceof x5.d) {
            return (x5.d) cVar;
        }
        return null;
    }

    @Override // v5.c
    public final v5.h getContext() {
        return this.e.getContext();
    }

    @Override // q6.k0
    public final Object i() {
        Object obj = this.f17624f;
        this.f17624f = a.f17614b;
        return obj;
    }

    @Override // v5.c
    public final void resumeWith(Object obj) {
        Throwable thA = q5.k.a(obj);
        Object uVar = thA == null ? obj : new q6.u(false, thA);
        v5.c cVar = this.e;
        v5.h context = cVar.getContext();
        q6.w wVar = this.f17623d;
        if (wVar.isDispatchNeeded(context)) {
            this.f17624f = uVar;
            this.f13559c = 0;
            wVar.dispatch(cVar.getContext(), this);
            return;
        }
        w0 w0VarA = x1.a();
        if (w0VarA.f13597a >= 4294967296L) {
            this.f17624f = uVar;
            this.f13559c = 0;
            w0VarA.p(this);
            return;
        }
        w0VarA.r(true);
        try {
            v5.h context2 = cVar.getContext();
            Object objL = a.l(context2, this.g);
            try {
                cVar.resumeWith(obj);
                while (w0VarA.t()) {
                }
            } finally {
                a.g(context2, objL);
            }
        } finally {
            try {
            } finally {
            }
        }
    }

    public final String toString() {
        return "DispatchedContinuation[" + this.f17623d + ", " + c0.D(this.e) + ']';
    }

    @Override // q6.k0
    public final v5.c c() {
        return this;
    }
}
