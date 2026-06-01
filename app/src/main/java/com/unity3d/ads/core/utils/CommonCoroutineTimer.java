package com.unity3d.ads.core.utils;

import e6.a;
import e6.p;
import kotlin.jvm.internal.k;
import q5.x;
import q6.a0;
import q6.c0;
import q6.f1;
import q6.s;
import q6.v1;
import q6.w;
import r2.q;
import v5.c;
import x5.e;
import x5.i;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes5.dex */
public final class CommonCoroutineTimer implements CoroutineTimer {
    private final w dispatcher;
    private final s job;
    private final a0 scope;

    /* JADX INFO: renamed from: com.unity3d.ads.core.utils.CommonCoroutineTimer$start$1, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
    @e(c = "com.unity3d.ads.core.utils.CommonCoroutineTimer$start$1", f = "CommonCoroutineTimer.kt", l = {21, 24}, m = "invokeSuspend")
    public static final class AnonymousClass1 extends i implements p {
        final /* synthetic */ a $action;
        final /* synthetic */ long $delayStartMillis;
        final /* synthetic */ long $repeatMillis;
        private /* synthetic */ Object L$0;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass1(long j, a aVar, long j3, c<? super AnonymousClass1> cVar) {
            super(2, cVar);
            this.$delayStartMillis = j;
            this.$action = aVar;
            this.$repeatMillis = j3;
        }

        @Override // x5.a
        public final c<x> create(Object obj, c<?> cVar) {
            AnonymousClass1 anonymousClass1 = new AnonymousClass1(this.$delayStartMillis, this.$action, this.$repeatMillis, cVar);
            anonymousClass1.L$0 = obj;
            return anonymousClass1;
        }

        @Override // x5.a
        public final Object invokeSuspend(Object obj) throws Throwable {
            a0 a0Var;
            w5.a aVar = w5.a.f17774a;
            int i2 = this.label;
            if (i2 == 0) {
                q.z0(obj);
                a0Var = (a0) this.L$0;
                long j = this.$delayStartMillis;
                this.L$0 = a0Var;
                this.label = 1;
                if (c0.k(j, this) != aVar) {
                }
                return aVar;
            }
            if (i2 != 1 && i2 != 2) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            a0Var = (a0) this.L$0;
            q.z0(obj);
            while (c0.t(a0Var)) {
                this.$action.invoke();
                long j3 = this.$repeatMillis;
                this.L$0 = a0Var;
                this.label = 2;
                if (c0.k(j3, this) == aVar) {
                    return aVar;
                }
            }
            return x.f13520a;
        }

        @Override // e6.p
        public final Object invoke(a0 a0Var, c<? super x> cVar) {
            return ((AnonymousClass1) create(a0Var, cVar)).invokeSuspend(x.f13520a);
        }
    }

    public CommonCoroutineTimer(w dispatcher) {
        k.e(dispatcher, "dispatcher");
        this.dispatcher = dispatcher;
        v1 v1VarE = c0.e();
        this.job = v1VarE;
        this.scope = c0.b(dispatcher.plus(v1VarE));
    }

    @Override // com.unity3d.ads.core.utils.CoroutineTimer
    public f1 start(long j, long j3, a action) {
        k.e(action, "action");
        return c0.u(this.scope, this.dispatcher, new AnonymousClass1(j, action, j3, null), 2);
    }
}
