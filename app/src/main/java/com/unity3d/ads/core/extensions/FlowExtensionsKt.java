package com.unity3d.ads.core.extensions;

import com.vungle.ads.internal.presenter.MRAIDPresenter;
import e6.p;
import kotlin.jvm.internal.k;
import q6.a0;
import r2.q;
import s6.w;
import s6.x;
import t6.d;
import t6.f;
import v5.c;
import w5.a;
import x5.e;
import x5.i;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes5.dex */
public final class FlowExtensionsKt {

    /* JADX INFO: renamed from: com.unity3d.ads.core.extensions.FlowExtensionsKt$timeoutAfter$1, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
    @e(c = "com.unity3d.ads.core.extensions.FlowExtensionsKt$timeoutAfter$1", f = "FlowExtensions.kt", l = {15, 17}, m = "invokeSuspend")
    public static final class AnonymousClass1 extends i implements p {
        final /* synthetic */ boolean $active;
        final /* synthetic */ p $block;
        final /* synthetic */ t6.e $this_timeoutAfter;
        final /* synthetic */ long $timeoutMillis;
        private /* synthetic */ Object L$0;
        int label;

        /* JADX INFO: renamed from: com.unity3d.ads.core.extensions.FlowExtensionsKt$timeoutAfter$1$1, reason: invalid class name and collision with other inner class name */
        /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
        @e(c = "com.unity3d.ads.core.extensions.FlowExtensionsKt$timeoutAfter$1$1", f = "FlowExtensions.kt", l = {10}, m = "invokeSuspend")
        public static final class C02171 extends i implements p {
            final /* synthetic */ x $$this$channelFlow;
            final /* synthetic */ t6.e $this_timeoutAfter;
            int label;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public C02171(t6.e eVar, x xVar, c<? super C02171> cVar) {
                super(2, cVar);
                this.$this_timeoutAfter = eVar;
                this.$$this$channelFlow = xVar;
            }

            @Override // x5.a
            public final c<q5.x> create(Object obj, c<?> cVar) {
                return new C02171(this.$this_timeoutAfter, this.$$this$channelFlow, cVar);
            }

            @Override // x5.a
            public final Object invokeSuspend(Object obj) throws Throwable {
                a aVar = a.f17774a;
                int i2 = this.label;
                if (i2 == 0) {
                    q.z0(obj);
                    t6.e eVar = this.$this_timeoutAfter;
                    final x xVar = this.$$this$channelFlow;
                    f fVar = new f() { // from class: com.unity3d.ads.core.extensions.FlowExtensionsKt.timeoutAfter.1.1.1
                        @Override // t6.f
                        public final Object emit(T t3, c<? super q5.x> cVar) {
                            Object objC = ((w) xVar).f13759d.c(t3, cVar);
                            return objC == a.f17774a ? objC : q5.x.f13520a;
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
                ((w) this.$$this$channelFlow).o(null);
                return q5.x.f13520a;
            }

            @Override // e6.p
            public final Object invoke(a0 a0Var, c<? super q5.x> cVar) {
                return ((C02171) create(a0Var, cVar)).invokeSuspend(q5.x.f13520a);
            }
        }

        /* JADX INFO: renamed from: com.unity3d.ads.core.extensions.FlowExtensionsKt$timeoutAfter$1$2, reason: invalid class name */
        /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
        public /* synthetic */ class AnonymousClass2 extends kotlin.jvm.internal.a implements e6.a {
            public AnonymousClass2(Object obj) {
                super(0, obj, x.class, MRAIDPresenter.CLOSE, "close(Ljava/lang/Throwable;)Z", 8);
            }

            @Override // e6.a
            public /* bridge */ /* synthetic */ Object invoke() {
                m3218invoke();
                return q5.x.f13520a;
            }

            /* JADX INFO: renamed from: invoke, reason: collision with other method in class */
            public final void m3218invoke() {
                ((w) ((x) this.receiver)).o(null);
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass1(long j, boolean z2, p pVar, t6.e eVar, c<? super AnonymousClass1> cVar) {
            super(2, cVar);
            this.$timeoutMillis = j;
            this.$active = z2;
            this.$block = pVar;
            this.$this_timeoutAfter = eVar;
        }

        @Override // x5.a
        public final c<q5.x> create(Object obj, c<?> cVar) {
            AnonymousClass1 anonymousClass1 = new AnonymousClass1(this.$timeoutMillis, this.$active, this.$block, this.$this_timeoutAfter, cVar);
            anonymousClass1.L$0 = obj;
            return anonymousClass1;
        }

        /* JADX WARN: Code restructure failed: missing block: B:16:0x0054, code lost:
        
            if (r8.invoke(r4, r7) == r0) goto L17;
         */
        @Override // x5.a
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public final java.lang.Object invokeSuspend(java.lang.Object r8) throws java.lang.Throwable {
            /*
                r7 = this;
                w5.a r0 = w5.a.f17774a
                int r1 = r7.label
                r2 = 0
                r3 = 2
                r4 = 1
                if (r1 == 0) goto L21
                if (r1 == r4) goto L19
                if (r1 != r3) goto L11
                r2.q.z0(r8)
                goto L57
            L11:
                java.lang.IllegalStateException r8 = new java.lang.IllegalStateException
                java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
                r8.<init>(r0)
                throw r8
            L19:
                java.lang.Object r1 = r7.L$0
                s6.x r1 = (s6.x) r1
                r2.q.z0(r8)
                goto L41
            L21:
                r2.q.z0(r8)
                java.lang.Object r8 = r7.L$0
                r1 = r8
                s6.x r1 = (s6.x) r1
                com.unity3d.ads.core.extensions.FlowExtensionsKt$timeoutAfter$1$1 r8 = new com.unity3d.ads.core.extensions.FlowExtensionsKt$timeoutAfter$1$1
                t6.e r5 = r7.$this_timeoutAfter
                r8.<init>(r5, r1, r2)
                r5 = 3
                q6.c0.u(r1, r2, r8, r5)
                long r5 = r7.$timeoutMillis
                r7.L$0 = r1
                r7.label = r4
                java.lang.Object r8 = q6.c0.k(r5, r7)
                if (r8 != r0) goto L41
                goto L56
            L41:
                boolean r8 = r7.$active
                if (r8 == 0) goto L57
                e6.p r8 = r7.$block
                com.unity3d.ads.core.extensions.FlowExtensionsKt$timeoutAfter$1$2 r4 = new com.unity3d.ads.core.extensions.FlowExtensionsKt$timeoutAfter$1$2
                r4.<init>(r1)
                r7.L$0 = r2
                r7.label = r3
                java.lang.Object r8 = r8.invoke(r4, r7)
                if (r8 != r0) goto L57
            L56:
                return r0
            L57:
                q5.x r8 = q5.x.f13520a
                return r8
            */
            throw new UnsupportedOperationException("Method not decompiled: com.unity3d.ads.core.extensions.FlowExtensionsKt.AnonymousClass1.invokeSuspend(java.lang.Object):java.lang.Object");
        }

        @Override // e6.p
        public final Object invoke(x xVar, c<? super q5.x> cVar) {
            return ((AnonymousClass1) create(xVar, cVar)).invokeSuspend(q5.x.f13520a);
        }
    }

    public static final <T> t6.e timeoutAfter(t6.e eVar, long j, boolean z2, p block) {
        k.e(eVar, "<this>");
        k.e(block, "block");
        return new d(new AnonymousClass1(j, z2, block, eVar, null), v5.i.f17610a, -2, s6.a.f13718a);
    }

    public static /* synthetic */ t6.e timeoutAfter$default(t6.e eVar, long j, boolean z2, p pVar, int i2, Object obj) {
        if ((i2 & 2) != 0) {
            z2 = true;
        }
        return timeoutAfter(eVar, j, z2, pVar);
    }
}
