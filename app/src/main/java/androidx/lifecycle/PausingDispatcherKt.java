package androidx.lifecycle;

import androidx.lifecycle.Lifecycle;
import com.vungle.ads.internal.protos.Sdk;
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
public final class PausingDispatcherKt {

    /* JADX INFO: renamed from: androidx.lifecycle.PausingDispatcherKt$whenStateAtLeast$2, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
    @x5.e(c = "androidx.lifecycle.PausingDispatcherKt$whenStateAtLeast$2", f = "PausingDispatcher.jvm.kt", l = {Sdk.SDKError.Reason.INVALID_ADUNIT_BID_PAYLOAD_VALUE}, m = "invokeSuspend")
    public static final class AnonymousClass2 extends x5.i implements p {
        final /* synthetic */ p $block;
        final /* synthetic */ Lifecycle.State $minState;
        final /* synthetic */ Lifecycle $this_whenStateAtLeast;
        private /* synthetic */ Object L$0;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass2(Lifecycle lifecycle, Lifecycle.State state, p pVar, v5.c<? super AnonymousClass2> cVar) {
            super(2, cVar);
            this.$this_whenStateAtLeast = lifecycle;
            this.$minState = state;
            this.$block = pVar;
        }

        @Override // x5.a
        public final v5.c<x> create(Object obj, v5.c<?> cVar) {
            AnonymousClass2 anonymousClass2 = new AnonymousClass2(this.$this_whenStateAtLeast, this.$minState, this.$block, cVar);
            anonymousClass2.L$0 = obj;
            return anonymousClass2;
        }

        @Override // x5.a
        public final Object invokeSuspend(Object obj) throws Throwable {
            LifecycleController lifecycleController;
            w5.a aVar = w5.a.f17774a;
            int i2 = this.label;
            if (i2 != 0) {
                if (i2 != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                lifecycleController = (LifecycleController) this.L$0;
                try {
                    q.z0(obj);
                    lifecycleController.finish();
                    return obj;
                } catch (Throwable th) {
                    th = th;
                    lifecycleController.finish();
                    throw th;
                }
            }
            q.z0(obj);
            f1 f1Var = (f1) ((a0) this.L$0).getCoroutineContext().get(e1.f13546a);
            if (f1Var == null) {
                throw new IllegalStateException("when[State] methods should have a parent job");
            }
            PausingDispatcher pausingDispatcher = new PausingDispatcher();
            LifecycleController lifecycleController2 = new LifecycleController(this.$this_whenStateAtLeast, this.$minState, pausingDispatcher.dispatchQueue, f1Var);
            try {
                p pVar = this.$block;
                this.L$0 = lifecycleController2;
                this.label = 1;
                obj = c0.H(pVar, pausingDispatcher, this);
                if (obj == aVar) {
                    return aVar;
                }
                lifecycleController = lifecycleController2;
                lifecycleController.finish();
                return obj;
            } catch (Throwable th2) {
                th = th2;
                lifecycleController = lifecycleController2;
                lifecycleController.finish();
                throw th;
            }
        }

        @Override // e6.p
        public final Object invoke(a0 a0Var, v5.c<? super T> cVar) {
            return ((AnonymousClass2) create(a0Var, cVar)).invokeSuspend(x.f13520a);
        }
    }

    public static final <T> Object whenCreated(LifecycleOwner lifecycleOwner, p pVar, v5.c<? super T> cVar) {
        return whenCreated(lifecycleOwner.getLifecycle(), pVar, cVar);
    }

    public static final <T> Object whenResumed(LifecycleOwner lifecycleOwner, p pVar, v5.c<? super T> cVar) {
        return whenResumed(lifecycleOwner.getLifecycle(), pVar, cVar);
    }

    public static final <T> Object whenStarted(LifecycleOwner lifecycleOwner, p pVar, v5.c<? super T> cVar) {
        return whenStarted(lifecycleOwner.getLifecycle(), pVar, cVar);
    }

    public static final <T> Object whenStateAtLeast(Lifecycle lifecycle, Lifecycle.State state, p pVar, v5.c<? super T> cVar) {
        x6.e eVar = m0.f13566a;
        return c0.H(new AnonymousClass2(lifecycle, state, pVar, null), v6.n.f17641a.f13648c, cVar);
    }

    public static final <T> Object whenCreated(Lifecycle lifecycle, p pVar, v5.c<? super T> cVar) {
        return whenStateAtLeast(lifecycle, Lifecycle.State.CREATED, pVar, cVar);
    }

    public static final <T> Object whenResumed(Lifecycle lifecycle, p pVar, v5.c<? super T> cVar) {
        return whenStateAtLeast(lifecycle, Lifecycle.State.RESUMED, pVar, cVar);
    }

    public static final <T> Object whenStarted(Lifecycle lifecycle, p pVar, v5.c<? super T> cVar) {
        return whenStateAtLeast(lifecycle, Lifecycle.State.STARTED, pVar, cVar);
    }
}
