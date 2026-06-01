package androidx.lifecycle;

import androidx.lifecycle.Lifecycle;
import e6.p;
import q5.x;
import q6.a0;
import q6.c0;
import q6.m0;
import r2.q;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes.dex */
public final class RepeatOnLifecycleKt {

    /* JADX INFO: renamed from: androidx.lifecycle.RepeatOnLifecycleKt$repeatOnLifecycle$3, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
    @x5.e(c = "androidx.lifecycle.RepeatOnLifecycleKt$repeatOnLifecycle$3", f = "RepeatOnLifecycle.kt", l = {83}, m = "invokeSuspend")
    public static final class AnonymousClass3 extends x5.i implements p {
        final /* synthetic */ p $block;
        final /* synthetic */ Lifecycle.State $state;
        final /* synthetic */ Lifecycle $this_repeatOnLifecycle;
        private /* synthetic */ Object L$0;
        int label;

        /* JADX INFO: renamed from: androidx.lifecycle.RepeatOnLifecycleKt$repeatOnLifecycle$3$1, reason: invalid class name */
        /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
        @x5.e(c = "androidx.lifecycle.RepeatOnLifecycleKt$repeatOnLifecycle$3$1", f = "RepeatOnLifecycle.kt", l = {161}, m = "invokeSuspend")
        public static final class AnonymousClass1 extends x5.i implements p {
            final /* synthetic */ a0 $$this$coroutineScope;
            final /* synthetic */ p $block;
            final /* synthetic */ Lifecycle.State $state;
            final /* synthetic */ Lifecycle $this_repeatOnLifecycle;
            Object L$0;
            Object L$1;
            Object L$2;
            Object L$3;
            Object L$4;
            Object L$5;
            int label;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public AnonymousClass1(Lifecycle lifecycle, Lifecycle.State state, a0 a0Var, p pVar, v5.c<? super AnonymousClass1> cVar) {
                super(2, cVar);
                this.$this_repeatOnLifecycle = lifecycle;
                this.$state = state;
                this.$$this$coroutineScope = a0Var;
                this.$block = pVar;
            }

            @Override // x5.a
            public final v5.c<x> create(Object obj, v5.c<?> cVar) {
                return new AnonymousClass1(this.$this_repeatOnLifecycle, this.$state, this.$$this$coroutineScope, this.$block, cVar);
            }

            /* JADX WARN: Removed duplicated region for block: B:22:0x0096  */
            /* JADX WARN: Removed duplicated region for block: B:25:0x009f  */
            /* JADX WARN: Removed duplicated region for block: B:31:0x00ae  */
            /* JADX WARN: Removed duplicated region for block: B:34:0x00b7  */
            /* JADX WARN: Removed duplicated region for block: B:40:? A[SYNTHETIC] */
            @Override // x5.a
            /*
                Code decompiled incorrectly, please refer to instructions dump.
                To view partially-correct code enable 'Show inconsistent code' option in preferences
            */
            public final java.lang.Object invokeSuspend(java.lang.Object r15) throws java.lang.Throwable {
                /*
                    r14 = this;
                    w5.a r0 = w5.a.f17774a
                    int r1 = r14.label
                    r2 = 0
                    q5.x r3 = q5.x.f13520a
                    r4 = 1
                    if (r1 == 0) goto L36
                    if (r1 != r4) goto L2e
                    java.lang.Object r0 = r14.L$5
                    e6.p r0 = (e6.p) r0
                    java.lang.Object r0 = r14.L$4
                    q6.a0 r0 = (q6.a0) r0
                    java.lang.Object r0 = r14.L$3
                    androidx.lifecycle.Lifecycle r0 = (androidx.lifecycle.Lifecycle) r0
                    java.lang.Object r0 = r14.L$2
                    androidx.lifecycle.Lifecycle$State r0 = (androidx.lifecycle.Lifecycle.State) r0
                    java.lang.Object r0 = r14.L$1
                    r1 = r0
                    kotlin.jvm.internal.a0 r1 = (kotlin.jvm.internal.a0) r1
                    java.lang.Object r0 = r14.L$0
                    r4 = r0
                    kotlin.jvm.internal.a0 r4 = (kotlin.jvm.internal.a0) r4
                    r2.q.z0(r15)     // Catch: java.lang.Throwable -> L2a
                    goto L90
                L2a:
                    r0 = move-exception
                    r15 = r0
                    goto La8
                L2e:
                    java.lang.IllegalStateException r15 = new java.lang.IllegalStateException
                    java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
                    r15.<init>(r0)
                    throw r15
                L36:
                    r2.q.z0(r15)
                    androidx.lifecycle.Lifecycle r15 = r14.$this_repeatOnLifecycle
                    androidx.lifecycle.Lifecycle$State r15 = r15.getCurrentState()
                    androidx.lifecycle.Lifecycle$State r1 = androidx.lifecycle.Lifecycle.State.DESTROYED
                    if (r15 != r1) goto L44
                    goto La4
                L44:
                    kotlin.jvm.internal.a0 r7 = new kotlin.jvm.internal.a0
                    r7.<init>()
                    kotlin.jvm.internal.a0 r1 = new kotlin.jvm.internal.a0
                    r1.<init>()
                    androidx.lifecycle.Lifecycle$State r15 = r14.$state     // Catch: java.lang.Throwable -> La5
                    androidx.lifecycle.Lifecycle r13 = r14.$this_repeatOnLifecycle     // Catch: java.lang.Throwable -> La5
                    q6.a0 r8 = r14.$$this$coroutineScope     // Catch: java.lang.Throwable -> La5
                    e6.p r12 = r14.$block     // Catch: java.lang.Throwable -> La5
                    r14.L$0 = r7     // Catch: java.lang.Throwable -> La5
                    r14.L$1 = r1     // Catch: java.lang.Throwable -> La5
                    r14.L$2 = r15     // Catch: java.lang.Throwable -> La5
                    r14.L$3 = r13     // Catch: java.lang.Throwable -> La5
                    r14.L$4 = r8     // Catch: java.lang.Throwable -> La5
                    r14.L$5 = r12     // Catch: java.lang.Throwable -> La5
                    r14.label = r4     // Catch: java.lang.Throwable -> La5
                    q6.l r10 = new q6.l     // Catch: java.lang.Throwable -> La5
                    v5.c r5 = a.a.I(r14)     // Catch: java.lang.Throwable -> La5
                    r10.<init>(r4, r5)     // Catch: java.lang.Throwable -> La5
                    r10.r()     // Catch: java.lang.Throwable -> La5
                    androidx.lifecycle.Lifecycle$Event$Companion r4 = androidx.lifecycle.Lifecycle.Event.Companion     // Catch: java.lang.Throwable -> La5
                    androidx.lifecycle.Lifecycle$Event r6 = r4.upTo(r15)     // Catch: java.lang.Throwable -> La5
                    androidx.lifecycle.Lifecycle$Event r9 = r4.downFrom(r15)     // Catch: java.lang.Throwable -> La5
                    z6.c r11 = z6.d.a()     // Catch: java.lang.Throwable -> La5
                    androidx.lifecycle.RepeatOnLifecycleKt$repeatOnLifecycle$3$1$1$1 r5 = new androidx.lifecycle.RepeatOnLifecycleKt$repeatOnLifecycle$3$1$1$1     // Catch: java.lang.Throwable -> La5
                    r5.<init>()     // Catch: java.lang.Throwable -> La5
                    r1.f12717a = r5     // Catch: java.lang.Throwable -> La5
                    r13.addObserver(r5)     // Catch: java.lang.Throwable -> La5
                    java.lang.Object r15 = r10.p()     // Catch: java.lang.Throwable -> La5
                    if (r15 != r0) goto L8f
                    return r0
                L8f:
                    r4 = r7
                L90:
                    java.lang.Object r15 = r4.f12717a
                    q6.f1 r15 = (q6.f1) r15
                    if (r15 == 0) goto L99
                    r15.a(r2)
                L99:
                    java.lang.Object r15 = r1.f12717a
                    androidx.lifecycle.LifecycleEventObserver r15 = (androidx.lifecycle.LifecycleEventObserver) r15
                    if (r15 == 0) goto La4
                    androidx.lifecycle.Lifecycle r0 = r14.$this_repeatOnLifecycle
                    r0.removeObserver(r15)
                La4:
                    return r3
                La5:
                    r0 = move-exception
                    r15 = r0
                    r4 = r7
                La8:
                    java.lang.Object r0 = r4.f12717a
                    q6.f1 r0 = (q6.f1) r0
                    if (r0 == 0) goto Lb1
                    r0.a(r2)
                Lb1:
                    java.lang.Object r0 = r1.f12717a
                    androidx.lifecycle.LifecycleEventObserver r0 = (androidx.lifecycle.LifecycleEventObserver) r0
                    if (r0 == 0) goto Lbc
                    androidx.lifecycle.Lifecycle r1 = r14.$this_repeatOnLifecycle
                    r1.removeObserver(r0)
                Lbc:
                    throw r15
                */
                throw new UnsupportedOperationException("Method not decompiled: androidx.lifecycle.RepeatOnLifecycleKt.AnonymousClass3.AnonymousClass1.invokeSuspend(java.lang.Object):java.lang.Object");
            }

            @Override // e6.p
            public final Object invoke(a0 a0Var, v5.c<? super x> cVar) {
                return ((AnonymousClass1) create(a0Var, cVar)).invokeSuspend(x.f13520a);
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass3(Lifecycle lifecycle, Lifecycle.State state, p pVar, v5.c<? super AnonymousClass3> cVar) {
            super(2, cVar);
            this.$this_repeatOnLifecycle = lifecycle;
            this.$state = state;
            this.$block = pVar;
        }

        @Override // x5.a
        public final v5.c<x> create(Object obj, v5.c<?> cVar) {
            AnonymousClass3 anonymousClass3 = new AnonymousClass3(this.$this_repeatOnLifecycle, this.$state, this.$block, cVar);
            anonymousClass3.L$0 = obj;
            return anonymousClass3;
        }

        @Override // x5.a
        public final Object invokeSuspend(Object obj) throws Throwable {
            w5.a aVar = w5.a.f17774a;
            int i2 = this.label;
            if (i2 == 0) {
                q.z0(obj);
                a0 a0Var = (a0) this.L$0;
                x6.e eVar = m0.f13566a;
                r6.c cVar = v6.n.f17641a.f13648c;
                AnonymousClass1 anonymousClass1 = new AnonymousClass1(this.$this_repeatOnLifecycle, this.$state, a0Var, this.$block, null);
                this.label = 1;
                if (c0.H(anonymousClass1, cVar, this) == aVar) {
                    return aVar;
                }
            } else {
                if (i2 != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                q.z0(obj);
            }
            return x.f13520a;
        }

        @Override // e6.p
        public final Object invoke(a0 a0Var, v5.c<? super x> cVar) {
            return ((AnonymousClass3) create(a0Var, cVar)).invokeSuspend(x.f13520a);
        }
    }

    public static final Object repeatOnLifecycle(Lifecycle lifecycle, Lifecycle.State state, p pVar, v5.c<? super x> cVar) {
        Object objJ;
        if (state == Lifecycle.State.INITIALIZED) {
            throw new IllegalArgumentException("repeatOnLifecycle cannot start work with the INITIALIZED lifecycle state.");
        }
        Lifecycle.State currentState = lifecycle.getCurrentState();
        Lifecycle.State state2 = Lifecycle.State.DESTROYED;
        x xVar = x.f13520a;
        return (currentState != state2 && (objJ = c0.j(new AnonymousClass3(lifecycle, state, pVar, null), cVar)) == w5.a.f17774a) ? objJ : xVar;
    }

    public static final Object repeatOnLifecycle(LifecycleOwner lifecycleOwner, Lifecycle.State state, p pVar, v5.c<? super x> cVar) {
        Object objRepeatOnLifecycle = repeatOnLifecycle(lifecycleOwner.getLifecycle(), state, pVar, cVar);
        return objRepeatOnLifecycle == w5.a.f17774a ? objRepeatOnLifecycle : x.f13520a;
    }
}
