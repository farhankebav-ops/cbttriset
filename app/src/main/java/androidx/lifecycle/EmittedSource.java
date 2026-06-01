package androidx.lifecycle;

import androidx.annotation.MainThread;
import e6.p;
import q5.x;
import q6.a0;
import q6.c0;
import q6.m0;
import q6.o0;
import r2.q;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes.dex */
public final class EmittedSource implements o0 {
    private boolean disposed;
    private final MediatorLiveData<?> mediator;
    private final LiveData<?> source;

    /* JADX INFO: renamed from: androidx.lifecycle.EmittedSource$dispose$1, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
    @x5.e(c = "androidx.lifecycle.EmittedSource$dispose$1", f = "CoroutineLiveData.kt", l = {}, m = "invokeSuspend")
    public static final class AnonymousClass1 extends x5.i implements p {
        int label;

        public AnonymousClass1(v5.c<? super AnonymousClass1> cVar) {
            super(2, cVar);
        }

        @Override // x5.a
        public final v5.c<x> create(Object obj, v5.c<?> cVar) {
            return EmittedSource.this.new AnonymousClass1(cVar);
        }

        @Override // x5.a
        public final Object invokeSuspend(Object obj) throws Throwable {
            w5.a aVar = w5.a.f17774a;
            if (this.label != 0) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            q.z0(obj);
            EmittedSource.this.removeSource();
            return x.f13520a;
        }

        @Override // e6.p
        public final Object invoke(a0 a0Var, v5.c<? super x> cVar) {
            return ((AnonymousClass1) create(a0Var, cVar)).invokeSuspend(x.f13520a);
        }
    }

    /* JADX INFO: renamed from: androidx.lifecycle.EmittedSource$disposeNow$2, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
    @x5.e(c = "androidx.lifecycle.EmittedSource$disposeNow$2", f = "CoroutineLiveData.kt", l = {}, m = "invokeSuspend")
    public static final class AnonymousClass2 extends x5.i implements p {
        int label;

        public AnonymousClass2(v5.c<? super AnonymousClass2> cVar) {
            super(2, cVar);
        }

        @Override // x5.a
        public final v5.c<x> create(Object obj, v5.c<?> cVar) {
            return EmittedSource.this.new AnonymousClass2(cVar);
        }

        @Override // x5.a
        public final Object invokeSuspend(Object obj) throws Throwable {
            w5.a aVar = w5.a.f17774a;
            if (this.label != 0) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            q.z0(obj);
            EmittedSource.this.removeSource();
            return x.f13520a;
        }

        @Override // e6.p
        public final Object invoke(a0 a0Var, v5.c<? super x> cVar) {
            return ((AnonymousClass2) create(a0Var, cVar)).invokeSuspend(x.f13520a);
        }
    }

    public EmittedSource(LiveData<?> source, MediatorLiveData<?> mediator) {
        kotlin.jvm.internal.k.e(source, "source");
        kotlin.jvm.internal.k.e(mediator, "mediator");
        this.source = source;
        this.mediator = mediator;
    }

    /* JADX INFO: Access modifiers changed from: private */
    @MainThread
    public final void removeSource() {
        if (this.disposed) {
            return;
        }
        this.mediator.removeSource(this.source);
        this.disposed = true;
    }

    @Override // q6.o0
    public void dispose() {
        x6.e eVar = m0.f13566a;
        c0.u(c0.b(v6.n.f17641a.f13648c), null, new AnonymousClass1(null), 3);
    }

    public final Object disposeNow(v5.c<? super x> cVar) throws Throwable {
        x6.e eVar = m0.f13566a;
        Object objH = c0.H(new AnonymousClass2(null), v6.n.f17641a.f13648c, cVar);
        return objH == w5.a.f17774a ? objH : x.f13520a;
    }
}
