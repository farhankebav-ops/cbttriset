package androidx.lifecycle;

import androidx.lifecycle.Lifecycle;
import e6.p;
import q6.a0;
import r2.q;
import s6.w;
import s6.x;
import t6.x0;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes.dex */
public final class FlowExtKt {

    /* JADX INFO: renamed from: androidx.lifecycle.FlowExtKt$flowWithLifecycle$1, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
    @x5.e(c = "androidx.lifecycle.FlowExtKt$flowWithLifecycle$1", f = "FlowExt.kt", l = {90}, m = "invokeSuspend")
    public static final class AnonymousClass1 extends x5.i implements p {
        final /* synthetic */ Lifecycle $lifecycle;
        final /* synthetic */ Lifecycle.State $minActiveState;
        final /* synthetic */ t6.e $this_flowWithLifecycle;
        private /* synthetic */ Object L$0;
        int label;

        /* JADX INFO: renamed from: androidx.lifecycle.FlowExtKt$flowWithLifecycle$1$1, reason: invalid class name and collision with other inner class name */
        /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
        @x5.e(c = "androidx.lifecycle.FlowExtKt$flowWithLifecycle$1$1", f = "FlowExt.kt", l = {90}, m = "invokeSuspend")
        public static final class C00061 extends x5.i implements p {
            final /* synthetic */ x $$this$callbackFlow;
            final /* synthetic */ t6.e $this_flowWithLifecycle;
            int label;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public C00061(t6.e eVar, x xVar, v5.c<? super C00061> cVar) {
                super(2, cVar);
                this.$this_flowWithLifecycle = eVar;
                this.$$this$callbackFlow = xVar;
            }

            @Override // x5.a
            public final v5.c<q5.x> create(Object obj, v5.c<?> cVar) {
                return new C00061(this.$this_flowWithLifecycle, this.$$this$callbackFlow, cVar);
            }

            @Override // x5.a
            public final Object invokeSuspend(Object obj) throws Throwable {
                w5.a aVar = w5.a.f17774a;
                int i2 = this.label;
                if (i2 == 0) {
                    q.z0(obj);
                    t6.e eVar = this.$this_flowWithLifecycle;
                    final x xVar = this.$$this$callbackFlow;
                    t6.f fVar = new t6.f() { // from class: androidx.lifecycle.FlowExtKt.flowWithLifecycle.1.1.1
                        @Override // t6.f
                        public final Object emit(T t3, v5.c<? super q5.x> cVar) {
                            Object objC = ((w) xVar).f13759d.c(t3, cVar);
                            return objC == w5.a.f17774a ? objC : q5.x.f13520a;
                        }
                    };
                    this.label = 1;
                    if (eVar.collect(fVar, this) == aVar) {
                        return aVar;
                    }
                } else {
                    if (i2 != 1) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    q.z0(obj);
                }
                return q5.x.f13520a;
            }

            @Override // e6.p
            public final Object invoke(a0 a0Var, v5.c<? super q5.x> cVar) {
                return ((C00061) create(a0Var, cVar)).invokeSuspend(q5.x.f13520a);
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass1(Lifecycle lifecycle, Lifecycle.State state, t6.e eVar, v5.c<? super AnonymousClass1> cVar) {
            super(2, cVar);
            this.$lifecycle = lifecycle;
            this.$minActiveState = state;
            this.$this_flowWithLifecycle = eVar;
        }

        @Override // x5.a
        public final v5.c<q5.x> create(Object obj, v5.c<?> cVar) {
            AnonymousClass1 anonymousClass1 = new AnonymousClass1(this.$lifecycle, this.$minActiveState, this.$this_flowWithLifecycle, cVar);
            anonymousClass1.L$0 = obj;
            return anonymousClass1;
        }

        @Override // x5.a
        public final Object invokeSuspend(Object obj) throws Throwable {
            x xVar;
            w5.a aVar = w5.a.f17774a;
            int i2 = this.label;
            if (i2 == 0) {
                q.z0(obj);
                x xVar2 = (x) this.L$0;
                Lifecycle lifecycle = this.$lifecycle;
                Lifecycle.State state = this.$minActiveState;
                C00061 c00061 = new C00061(this.$this_flowWithLifecycle, xVar2, null);
                this.L$0 = xVar2;
                this.label = 1;
                if (RepeatOnLifecycleKt.repeatOnLifecycle(lifecycle, state, c00061, this) == aVar) {
                    return aVar;
                }
                xVar = xVar2;
            } else {
                if (i2 != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                xVar = (x) this.L$0;
                q.z0(obj);
            }
            ((w) xVar).o(null);
            return q5.x.f13520a;
        }

        @Override // e6.p
        public final Object invoke(x xVar, v5.c<? super q5.x> cVar) {
            return ((AnonymousClass1) create(xVar, cVar)).invokeSuspend(q5.x.f13520a);
        }
    }

    public static final <T> t6.e flowWithLifecycle(t6.e eVar, Lifecycle lifecycle, Lifecycle.State minActiveState) {
        kotlin.jvm.internal.k.e(eVar, "<this>");
        kotlin.jvm.internal.k.e(lifecycle, "lifecycle");
        kotlin.jvm.internal.k.e(minActiveState, "minActiveState");
        return x0.h(new AnonymousClass1(lifecycle, minActiveState, eVar, null));
    }

    public static /* synthetic */ t6.e flowWithLifecycle$default(t6.e eVar, Lifecycle lifecycle, Lifecycle.State state, int i2, Object obj) {
        if ((i2 & 2) != 0) {
            state = Lifecycle.State.STARTED;
        }
        return flowWithLifecycle(eVar, lifecycle, state);
    }
}
