package com.onesignal.common.threading;

import e6.l;
import e6.p;
import kotlin.jvm.internal.k;
import q5.x;
import q6.a0;
import q6.c0;
import r2.q;
import v5.c;
import w5.a;
import x5.e;
import x5.i;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes5.dex */
public final class OSPrimaryCoroutineScope {
    public static final OSPrimaryCoroutineScope INSTANCE = new OSPrimaryCoroutineScope();
    private static final a0 mainScope = c0.b(c0.w("OSPrimaryCoroutineScope"));

    /* JADX INFO: renamed from: com.onesignal.common.threading.OSPrimaryCoroutineScope$execute$1, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
    @e(c = "com.onesignal.common.threading.OSPrimaryCoroutineScope$execute$1", f = "OSPrimaryCoroutineScope.kt", l = {16}, m = "invokeSuspend")
    public static final class AnonymousClass1 extends i implements p {
        final /* synthetic */ l $block;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass1(l lVar, c<? super AnonymousClass1> cVar) {
            super(2, cVar);
            this.$block = lVar;
        }

        @Override // x5.a
        public final c<x> create(Object obj, c<?> cVar) {
            return new AnonymousClass1(this.$block, cVar);
        }

        @Override // x5.a
        public final Object invokeSuspend(Object obj) throws Throwable {
            a aVar = a.f17774a;
            int i2 = this.label;
            if (i2 == 0) {
                q.z0(obj);
                l lVar = this.$block;
                this.label = 1;
                if (lVar.invoke(this) == aVar) {
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
        public final Object invoke(a0 a0Var, c<? super x> cVar) {
            return ((AnonymousClass1) create(a0Var, cVar)).invokeSuspend(x.f13520a);
        }
    }

    /* JADX INFO: renamed from: com.onesignal.common.threading.OSPrimaryCoroutineScope$waitForIdle$2, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
    @e(c = "com.onesignal.common.threading.OSPrimaryCoroutineScope$waitForIdle$2", f = "OSPrimaryCoroutineScope.kt", l = {}, m = "invokeSuspend")
    public static final class AnonymousClass2 extends i implements p {
        int label;

        public AnonymousClass2(c<? super AnonymousClass2> cVar) {
            super(2, cVar);
        }

        @Override // x5.a
        public final c<x> create(Object obj, c<?> cVar) {
            return new AnonymousClass2(cVar);
        }

        @Override // x5.a
        public final Object invokeSuspend(Object obj) throws Throwable {
            a aVar = a.f17774a;
            if (this.label != 0) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            q.z0(obj);
            return x.f13520a;
        }

        @Override // e6.p
        public final Object invoke(a0 a0Var, c<? super x> cVar) {
            return ((AnonymousClass2) create(a0Var, cVar)).invokeSuspend(x.f13520a);
        }
    }

    private OSPrimaryCoroutineScope() {
    }

    public final void execute(l block) {
        k.e(block, "block");
        c0.u(mainScope, null, new AnonymousClass1(block, null), 3);
    }

    public final Object waitForIdle(c<? super x> cVar) {
        Object objM = c0.u(mainScope, null, new AnonymousClass2(null), 3).M(cVar);
        return objM == a.f17774a ? objM : x.f13520a;
    }
}
