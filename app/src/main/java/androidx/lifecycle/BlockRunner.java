package androidx.lifecycle;

import androidx.annotation.MainThread;
import e6.p;
import q5.x;
import q6.a0;
import q6.c0;
import q6.f1;
import q6.m0;
import r2.q;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes.dex */
public final class BlockRunner<T> {
    private final p block;
    private f1 cancellationJob;
    private final CoroutineLiveData<T> liveData;
    private final e6.a onDone;
    private f1 runningJob;
    private final a0 scope;
    private final long timeoutInMs;

    /* JADX INFO: renamed from: androidx.lifecycle.BlockRunner$cancel$1, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
    @x5.e(c = "androidx.lifecycle.BlockRunner$cancel$1", f = "CoroutineLiveData.kt", l = {180}, m = "invokeSuspend")
    public static final class AnonymousClass1 extends x5.i implements p {
        int label;
        final /* synthetic */ BlockRunner<T> this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass1(BlockRunner<T> blockRunner, v5.c<? super AnonymousClass1> cVar) {
            super(2, cVar);
            this.this$0 = blockRunner;
        }

        @Override // x5.a
        public final v5.c<x> create(Object obj, v5.c<?> cVar) {
            return new AnonymousClass1(this.this$0, cVar);
        }

        @Override // x5.a
        public final Object invokeSuspend(Object obj) throws Throwable {
            w5.a aVar = w5.a.f17774a;
            int i2 = this.label;
            if (i2 == 0) {
                q.z0(obj);
                long j = ((BlockRunner) this.this$0).timeoutInMs;
                this.label = 1;
                if (c0.k(j, this) == aVar) {
                    return aVar;
                }
            } else {
                if (i2 != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                q.z0(obj);
            }
            if (!((BlockRunner) this.this$0).liveData.hasActiveObservers()) {
                f1 f1Var = ((BlockRunner) this.this$0).runningJob;
                if (f1Var != null) {
                    f1Var.a(null);
                }
                ((BlockRunner) this.this$0).runningJob = null;
            }
            return x.f13520a;
        }

        @Override // e6.p
        public final Object invoke(a0 a0Var, v5.c<? super x> cVar) {
            return ((AnonymousClass1) create(a0Var, cVar)).invokeSuspend(x.f13520a);
        }
    }

    /* JADX INFO: renamed from: androidx.lifecycle.BlockRunner$maybeRun$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
    @x5.e(c = "androidx.lifecycle.BlockRunner$maybeRun$1", f = "CoroutineLiveData.kt", l = {168}, m = "invokeSuspend")
    public static final class C03571 extends x5.i implements p {
        private /* synthetic */ Object L$0;
        int label;
        final /* synthetic */ BlockRunner<T> this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C03571(BlockRunner<T> blockRunner, v5.c<? super C03571> cVar) {
            super(2, cVar);
            this.this$0 = blockRunner;
        }

        @Override // x5.a
        public final v5.c<x> create(Object obj, v5.c<?> cVar) {
            C03571 c03571 = new C03571(this.this$0, cVar);
            c03571.L$0 = obj;
            return c03571;
        }

        @Override // x5.a
        public final Object invokeSuspend(Object obj) throws Throwable {
            w5.a aVar = w5.a.f17774a;
            int i2 = this.label;
            if (i2 == 0) {
                q.z0(obj);
                LiveDataScopeImpl liveDataScopeImpl = new LiveDataScopeImpl(((BlockRunner) this.this$0).liveData, ((a0) this.L$0).getCoroutineContext());
                p pVar = ((BlockRunner) this.this$0).block;
                this.label = 1;
                if (pVar.invoke(liveDataScopeImpl, this) == aVar) {
                    return aVar;
                }
            } else {
                if (i2 != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                q.z0(obj);
            }
            ((BlockRunner) this.this$0).onDone.invoke();
            return x.f13520a;
        }

        @Override // e6.p
        public final Object invoke(a0 a0Var, v5.c<? super x> cVar) {
            return ((C03571) create(a0Var, cVar)).invokeSuspend(x.f13520a);
        }
    }

    public BlockRunner(CoroutineLiveData<T> liveData, p block, long j, a0 scope, e6.a onDone) {
        kotlin.jvm.internal.k.e(liveData, "liveData");
        kotlin.jvm.internal.k.e(block, "block");
        kotlin.jvm.internal.k.e(scope, "scope");
        kotlin.jvm.internal.k.e(onDone, "onDone");
        this.liveData = liveData;
        this.block = block;
        this.timeoutInMs = j;
        this.scope = scope;
        this.onDone = onDone;
    }

    @MainThread
    public final void cancel() {
        if (this.cancellationJob != null) {
            throw new IllegalStateException("Cancel call cannot happen without a maybeRun");
        }
        a0 a0Var = this.scope;
        x6.e eVar = m0.f13566a;
        this.cancellationJob = c0.u(a0Var, v6.n.f17641a.f13648c, new AnonymousClass1(this, null), 2);
    }

    @MainThread
    public final void maybeRun() {
        f1 f1Var = this.cancellationJob;
        if (f1Var != null) {
            f1Var.a(null);
        }
        this.cancellationJob = null;
        if (this.runningJob != null) {
            return;
        }
        this.runningJob = c0.u(this.scope, null, new C03571(this, null), 3);
    }
}
