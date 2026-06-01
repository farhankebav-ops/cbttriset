package androidx.lifecycle;

import androidx.lifecycle.Lifecycle;
import q5.x;
import q6.m0;
import q6.w;
import r2.q;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes.dex */
public final class WithLifecycleStateKt {

    /* JADX INFO: renamed from: androidx.lifecycle.WithLifecycleStateKt$withStateAtLeastUnchecked$2, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
    public static final class AnonymousClass2 implements e6.a {
        final /* synthetic */ e6.a $block;

        public AnonymousClass2(e6.a aVar) {
            this.$block = aVar;
        }

        /* JADX WARN: Type inference failed for: r0v1, types: [R, java.lang.Object] */
        @Override // e6.a
        public final R invoke() {
            return this.$block.invoke();
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r7v2, types: [androidx.lifecycle.LifecycleObserver, androidx.lifecycle.WithLifecycleStateKt$suspendWithStateAtLeastUnchecked$2$observer$1] */
    public static final <R> Object suspendWithStateAtLeastUnchecked(final Lifecycle lifecycle, final Lifecycle.State state, boolean z2, final w wVar, final e6.a aVar, v5.c<? super R> cVar) {
        final q6.l lVar = new q6.l(1, a.a.I(cVar));
        lVar.r();
        final ?? r7 = new LifecycleEventObserver() { // from class: androidx.lifecycle.WithLifecycleStateKt$suspendWithStateAtLeastUnchecked$2$observer$1
            @Override // androidx.lifecycle.LifecycleEventObserver
            public void onStateChanged(LifecycleOwner source, Lifecycle.Event event) {
                Object objM;
                kotlin.jvm.internal.k.e(source, "source");
                kotlin.jvm.internal.k.e(event, "event");
                if (event != Lifecycle.Event.Companion.upTo(state)) {
                    if (event == Lifecycle.Event.ON_DESTROY) {
                        lifecycle.removeObserver(this);
                        lVar.resumeWith(q.M(new LifecycleDestroyedException()));
                        return;
                    }
                    return;
                }
                lifecycle.removeObserver(this);
                q6.j jVar = lVar;
                try {
                    objM = aVar.invoke();
                } catch (Throwable th) {
                    objM = q.M(th);
                }
                jVar.resumeWith(objM);
            }
        };
        if (z2) {
            wVar.dispatch(v5.i.f17610a, new Runnable() { // from class: androidx.lifecycle.WithLifecycleStateKt$suspendWithStateAtLeastUnchecked$2$1
                @Override // java.lang.Runnable
                public final void run() {
                    lifecycle.addObserver(r7);
                }
            });
        } else {
            lifecycle.addObserver(r7);
        }
        lVar.t(new e6.l() { // from class: androidx.lifecycle.WithLifecycleStateKt$suspendWithStateAtLeastUnchecked$2$2
            @Override // e6.l
            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                invoke((Throwable) obj);
                return x.f13520a;
            }

            public final void invoke(Throwable th) {
                w wVar2 = wVar;
                v5.i iVar = v5.i.f17610a;
                if (!wVar2.isDispatchNeeded(iVar)) {
                    lifecycle.removeObserver(r7);
                    return;
                }
                w wVar3 = wVar;
                final Lifecycle lifecycle2 = lifecycle;
                final WithLifecycleStateKt$suspendWithStateAtLeastUnchecked$2$observer$1 withLifecycleStateKt$suspendWithStateAtLeastUnchecked$2$observer$1 = r7;
                wVar3.dispatch(iVar, new Runnable() { // from class: androidx.lifecycle.WithLifecycleStateKt$suspendWithStateAtLeastUnchecked$2$2.1
                    @Override // java.lang.Runnable
                    public final void run() {
                        lifecycle2.removeObserver(withLifecycleStateKt$suspendWithStateAtLeastUnchecked$2$observer$1);
                    }
                });
            }
        });
        Object objP = lVar.p();
        w5.a aVar2 = w5.a.f17774a;
        return objP;
    }

    public static final <R> Object withCreated(Lifecycle lifecycle, e6.a aVar, v5.c<? super R> cVar) {
        Lifecycle.State state = Lifecycle.State.CREATED;
        x6.e eVar = m0.f13566a;
        r6.c cVar2 = v6.n.f17641a.f13648c;
        boolean zIsDispatchNeeded = cVar2.isDispatchNeeded(cVar.getContext());
        if (!zIsDispatchNeeded) {
            if (lifecycle.getCurrentState() == Lifecycle.State.DESTROYED) {
                throw new LifecycleDestroyedException();
            }
            if (lifecycle.getCurrentState().compareTo(state) >= 0) {
                return aVar.invoke();
            }
        }
        return suspendWithStateAtLeastUnchecked(lifecycle, state, zIsDispatchNeeded, cVar2, new AnonymousClass2(aVar), cVar);
    }

    private static final <R> Object withCreated$$forInline(Lifecycle lifecycle, e6.a aVar, v5.c<? super R> cVar) {
        Lifecycle.State state = Lifecycle.State.DESTROYED;
        x6.e eVar = m0.f13566a;
        r6.c cVar2 = v6.n.f17641a.f13648c;
        throw null;
    }

    public static final <R> Object withResumed(Lifecycle lifecycle, e6.a aVar, v5.c<? super R> cVar) {
        Lifecycle.State state = Lifecycle.State.RESUMED;
        x6.e eVar = m0.f13566a;
        r6.c cVar2 = v6.n.f17641a.f13648c;
        boolean zIsDispatchNeeded = cVar2.isDispatchNeeded(cVar.getContext());
        if (!zIsDispatchNeeded) {
            if (lifecycle.getCurrentState() == Lifecycle.State.DESTROYED) {
                throw new LifecycleDestroyedException();
            }
            if (lifecycle.getCurrentState().compareTo(state) >= 0) {
                return aVar.invoke();
            }
        }
        return suspendWithStateAtLeastUnchecked(lifecycle, state, zIsDispatchNeeded, cVar2, new AnonymousClass2(aVar), cVar);
    }

    private static final <R> Object withResumed$$forInline(Lifecycle lifecycle, e6.a aVar, v5.c<? super R> cVar) {
        Lifecycle.State state = Lifecycle.State.DESTROYED;
        x6.e eVar = m0.f13566a;
        r6.c cVar2 = v6.n.f17641a.f13648c;
        throw null;
    }

    public static final <R> Object withStarted(Lifecycle lifecycle, e6.a aVar, v5.c<? super R> cVar) {
        Lifecycle.State state = Lifecycle.State.STARTED;
        x6.e eVar = m0.f13566a;
        r6.c cVar2 = v6.n.f17641a.f13648c;
        boolean zIsDispatchNeeded = cVar2.isDispatchNeeded(cVar.getContext());
        if (!zIsDispatchNeeded) {
            if (lifecycle.getCurrentState() == Lifecycle.State.DESTROYED) {
                throw new LifecycleDestroyedException();
            }
            if (lifecycle.getCurrentState().compareTo(state) >= 0) {
                return aVar.invoke();
            }
        }
        return suspendWithStateAtLeastUnchecked(lifecycle, state, zIsDispatchNeeded, cVar2, new AnonymousClass2(aVar), cVar);
    }

    private static final <R> Object withStarted$$forInline(Lifecycle lifecycle, e6.a aVar, v5.c<? super R> cVar) {
        Lifecycle.State state = Lifecycle.State.DESTROYED;
        x6.e eVar = m0.f13566a;
        r6.c cVar2 = v6.n.f17641a.f13648c;
        throw null;
    }

    public static final <R> Object withStateAtLeast(Lifecycle lifecycle, Lifecycle.State state, e6.a aVar, v5.c<? super R> cVar) {
        if (state.compareTo(Lifecycle.State.CREATED) < 0) {
            throw new IllegalArgumentException(("target state must be CREATED or greater, found " + state).toString());
        }
        x6.e eVar = m0.f13566a;
        r6.c cVar2 = v6.n.f17641a.f13648c;
        boolean zIsDispatchNeeded = cVar2.isDispatchNeeded(cVar.getContext());
        if (!zIsDispatchNeeded) {
            if (lifecycle.getCurrentState() == Lifecycle.State.DESTROYED) {
                throw new LifecycleDestroyedException();
            }
            if (lifecycle.getCurrentState().compareTo(state) >= 0) {
                return aVar.invoke();
            }
        }
        return suspendWithStateAtLeastUnchecked(lifecycle, state, zIsDispatchNeeded, cVar2, new AnonymousClass2(aVar), cVar);
    }

    private static final <R> Object withStateAtLeast$$forInline(Lifecycle lifecycle, Lifecycle.State state, e6.a aVar, v5.c<? super R> cVar) {
        if (state.compareTo(Lifecycle.State.CREATED) >= 0) {
            x6.e eVar = m0.f13566a;
            r6.c cVar2 = v6.n.f17641a.f13648c;
            throw null;
        }
        throw new IllegalArgumentException(("target state must be CREATED or greater, found " + state).toString());
    }

    public static final <R> Object withStateAtLeastUnchecked(Lifecycle lifecycle, Lifecycle.State state, e6.a aVar, v5.c<? super R> cVar) {
        x6.e eVar = m0.f13566a;
        r6.c cVar2 = v6.n.f17641a.f13648c;
        boolean zIsDispatchNeeded = cVar2.isDispatchNeeded(cVar.getContext());
        if (!zIsDispatchNeeded) {
            if (lifecycle.getCurrentState() == Lifecycle.State.DESTROYED) {
                throw new LifecycleDestroyedException();
            }
            if (lifecycle.getCurrentState().compareTo(state) >= 0) {
                return aVar.invoke();
            }
        }
        return suspendWithStateAtLeastUnchecked(lifecycle, state, zIsDispatchNeeded, cVar2, new AnonymousClass2(aVar), cVar);
    }

    private static final <R> Object withStateAtLeastUnchecked$$forInline(Lifecycle lifecycle, Lifecycle.State state, e6.a aVar, v5.c<? super R> cVar) {
        x6.e eVar = m0.f13566a;
        r6.c cVar2 = v6.n.f17641a.f13648c;
        throw null;
    }

    private static final <R> Object withCreated$$forInline(LifecycleOwner lifecycleOwner, e6.a aVar, v5.c<? super R> cVar) {
        lifecycleOwner.getLifecycle();
        Lifecycle.State state = Lifecycle.State.DESTROYED;
        x6.e eVar = m0.f13566a;
        r6.c cVar2 = v6.n.f17641a.f13648c;
        throw null;
    }

    private static final <R> Object withResumed$$forInline(LifecycleOwner lifecycleOwner, e6.a aVar, v5.c<? super R> cVar) {
        lifecycleOwner.getLifecycle();
        Lifecycle.State state = Lifecycle.State.DESTROYED;
        x6.e eVar = m0.f13566a;
        r6.c cVar2 = v6.n.f17641a.f13648c;
        throw null;
    }

    private static final <R> Object withStarted$$forInline(LifecycleOwner lifecycleOwner, e6.a aVar, v5.c<? super R> cVar) {
        lifecycleOwner.getLifecycle();
        Lifecycle.State state = Lifecycle.State.DESTROYED;
        x6.e eVar = m0.f13566a;
        r6.c cVar2 = v6.n.f17641a.f13648c;
        throw null;
    }

    private static final <R> Object withStateAtLeast$$forInline(LifecycleOwner lifecycleOwner, Lifecycle.State state, e6.a aVar, v5.c<? super R> cVar) {
        lifecycleOwner.getLifecycle();
        if (state.compareTo(Lifecycle.State.CREATED) >= 0) {
            x6.e eVar = m0.f13566a;
            r6.c cVar2 = v6.n.f17641a.f13648c;
            throw null;
        }
        throw new IllegalArgumentException(("target state must be CREATED or greater, found " + state).toString());
    }

    public static final <R> Object withCreated(LifecycleOwner lifecycleOwner, e6.a aVar, v5.c<? super R> cVar) {
        Lifecycle lifecycle = lifecycleOwner.getLifecycle();
        Lifecycle.State state = Lifecycle.State.CREATED;
        x6.e eVar = m0.f13566a;
        r6.c cVar2 = v6.n.f17641a.f13648c;
        boolean zIsDispatchNeeded = cVar2.isDispatchNeeded(cVar.getContext());
        if (!zIsDispatchNeeded) {
            if (lifecycle.getCurrentState() != Lifecycle.State.DESTROYED) {
                if (lifecycle.getCurrentState().compareTo(state) >= 0) {
                    return aVar.invoke();
                }
            } else {
                throw new LifecycleDestroyedException();
            }
        }
        return suspendWithStateAtLeastUnchecked(lifecycle, state, zIsDispatchNeeded, cVar2, new AnonymousClass2(aVar), cVar);
    }

    public static final <R> Object withResumed(LifecycleOwner lifecycleOwner, e6.a aVar, v5.c<? super R> cVar) {
        Lifecycle lifecycle = lifecycleOwner.getLifecycle();
        Lifecycle.State state = Lifecycle.State.RESUMED;
        x6.e eVar = m0.f13566a;
        r6.c cVar2 = v6.n.f17641a.f13648c;
        boolean zIsDispatchNeeded = cVar2.isDispatchNeeded(cVar.getContext());
        if (!zIsDispatchNeeded) {
            if (lifecycle.getCurrentState() != Lifecycle.State.DESTROYED) {
                if (lifecycle.getCurrentState().compareTo(state) >= 0) {
                    return aVar.invoke();
                }
            } else {
                throw new LifecycleDestroyedException();
            }
        }
        return suspendWithStateAtLeastUnchecked(lifecycle, state, zIsDispatchNeeded, cVar2, new AnonymousClass2(aVar), cVar);
    }

    public static final <R> Object withStarted(LifecycleOwner lifecycleOwner, e6.a aVar, v5.c<? super R> cVar) {
        Lifecycle lifecycle = lifecycleOwner.getLifecycle();
        Lifecycle.State state = Lifecycle.State.STARTED;
        x6.e eVar = m0.f13566a;
        r6.c cVar2 = v6.n.f17641a.f13648c;
        boolean zIsDispatchNeeded = cVar2.isDispatchNeeded(cVar.getContext());
        if (!zIsDispatchNeeded) {
            if (lifecycle.getCurrentState() != Lifecycle.State.DESTROYED) {
                if (lifecycle.getCurrentState().compareTo(state) >= 0) {
                    return aVar.invoke();
                }
            } else {
                throw new LifecycleDestroyedException();
            }
        }
        return suspendWithStateAtLeastUnchecked(lifecycle, state, zIsDispatchNeeded, cVar2, new AnonymousClass2(aVar), cVar);
    }

    public static final <R> Object withStateAtLeast(LifecycleOwner lifecycleOwner, Lifecycle.State state, e6.a aVar, v5.c<? super R> cVar) {
        Lifecycle lifecycle = lifecycleOwner.getLifecycle();
        if (state.compareTo(Lifecycle.State.CREATED) >= 0) {
            x6.e eVar = m0.f13566a;
            r6.c cVar2 = v6.n.f17641a.f13648c;
            boolean zIsDispatchNeeded = cVar2.isDispatchNeeded(cVar.getContext());
            if (!zIsDispatchNeeded) {
                if (lifecycle.getCurrentState() != Lifecycle.State.DESTROYED) {
                    if (lifecycle.getCurrentState().compareTo(state) >= 0) {
                        return aVar.invoke();
                    }
                } else {
                    throw new LifecycleDestroyedException();
                }
            }
            return suspendWithStateAtLeastUnchecked(lifecycle, state, zIsDispatchNeeded, cVar2, new AnonymousClass2(aVar), cVar);
        }
        throw new IllegalArgumentException(("target state must be CREATED or greater, found " + state).toString());
    }
}
