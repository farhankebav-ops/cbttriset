package androidx.lifecycle;

import androidx.lifecycle.Lifecycle;
import e6.p;
import q5.x;
import q6.a0;
import q6.c0;
import q6.e1;
import q6.f1;
import q6.m0;
import r2.q;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes.dex */
public final class LifecycleCoroutineScopeImpl extends LifecycleCoroutineScope implements LifecycleEventObserver {
    private final v5.h coroutineContext;
    private final Lifecycle lifecycle;

    /* JADX INFO: renamed from: androidx.lifecycle.LifecycleCoroutineScopeImpl$register$1, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
    @x5.e(c = "androidx.lifecycle.LifecycleCoroutineScopeImpl$register$1", f = "Lifecycle.kt", l = {}, m = "invokeSuspend")
    public static final class AnonymousClass1 extends x5.i implements p {
        private /* synthetic */ Object L$0;
        int label;

        public AnonymousClass1(v5.c<? super AnonymousClass1> cVar) {
            super(2, cVar);
        }

        @Override // x5.a
        public final v5.c<x> create(Object obj, v5.c<?> cVar) {
            AnonymousClass1 anonymousClass1 = LifecycleCoroutineScopeImpl.this.new AnonymousClass1(cVar);
            anonymousClass1.L$0 = obj;
            return anonymousClass1;
        }

        @Override // x5.a
        public final Object invokeSuspend(Object obj) throws Throwable {
            w5.a aVar = w5.a.f17774a;
            if (this.label != 0) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            q.z0(obj);
            a0 a0Var = (a0) this.L$0;
            if (LifecycleCoroutineScopeImpl.this.getLifecycle$lifecycle_common().getCurrentState().compareTo(Lifecycle.State.INITIALIZED) >= 0) {
                LifecycleCoroutineScopeImpl.this.getLifecycle$lifecycle_common().addObserver(LifecycleCoroutineScopeImpl.this);
            } else {
                f1 f1Var = (f1) a0Var.getCoroutineContext().get(e1.f13546a);
                if (f1Var != null) {
                    f1Var.a(null);
                }
            }
            return x.f13520a;
        }

        @Override // e6.p
        public final Object invoke(a0 a0Var, v5.c<? super x> cVar) {
            return ((AnonymousClass1) create(a0Var, cVar)).invokeSuspend(x.f13520a);
        }
    }

    public LifecycleCoroutineScopeImpl(Lifecycle lifecycle, v5.h coroutineContext) {
        f1 f1Var;
        kotlin.jvm.internal.k.e(lifecycle, "lifecycle");
        kotlin.jvm.internal.k.e(coroutineContext, "coroutineContext");
        this.lifecycle = lifecycle;
        this.coroutineContext = coroutineContext;
        if (getLifecycle$lifecycle_common().getCurrentState() != Lifecycle.State.DESTROYED || (f1Var = (f1) getCoroutineContext().get(e1.f13546a)) == null) {
            return;
        }
        f1Var.a(null);
    }

    @Override // androidx.lifecycle.LifecycleCoroutineScope, q6.a0
    public v5.h getCoroutineContext() {
        return this.coroutineContext;
    }

    @Override // androidx.lifecycle.LifecycleCoroutineScope
    public Lifecycle getLifecycle$lifecycle_common() {
        return this.lifecycle;
    }

    @Override // androidx.lifecycle.LifecycleEventObserver
    public void onStateChanged(LifecycleOwner source, Lifecycle.Event event) {
        kotlin.jvm.internal.k.e(source, "source");
        kotlin.jvm.internal.k.e(event, "event");
        if (getLifecycle$lifecycle_common().getCurrentState().compareTo(Lifecycle.State.DESTROYED) <= 0) {
            getLifecycle$lifecycle_common().removeObserver(this);
            f1 f1Var = (f1) getCoroutineContext().get(e1.f13546a);
            if (f1Var != null) {
                f1Var.a(null);
            }
        }
    }

    public final void register() {
        x6.e eVar = m0.f13566a;
        c0.u(this, v6.n.f17641a.f13648c, new AnonymousClass1(null), 2);
    }
}
