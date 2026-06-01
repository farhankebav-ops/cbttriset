package com.unity3d.ads.core.domain;

import com.unity3d.services.core.misc.Utilities;
import e6.p;
import kotlin.jvm.internal.k;
import q5.x;
import q6.a0;
import q6.c0;
import q6.w;
import r2.q;
import v5.c;
import x5.e;
import x5.i;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes5.dex */
public final class CommonSafeCallbackInvoke implements SafeCallbackInvoke {
    private final w mainDispatcher;

    /* JADX INFO: renamed from: com.unity3d.ads.core.domain.CommonSafeCallbackInvoke$invoke$1, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
    @e(c = "com.unity3d.ads.core.domain.CommonSafeCallbackInvoke$invoke$1", f = "CommonSafeCallbackInvoke.kt", l = {}, m = "invokeSuspend")
    public static final class AnonymousClass1 extends i implements p {
        final /* synthetic */ e6.a $block;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass1(e6.a aVar, c<? super AnonymousClass1> cVar) {
            super(2, cVar);
            this.$block = aVar;
        }

        @Override // x5.a
        public final c<x> create(Object obj, c<?> cVar) {
            return new AnonymousClass1(this.$block, cVar);
        }

        @Override // x5.a
        public final Object invokeSuspend(Object obj) throws Throwable {
            w5.a aVar = w5.a.f17774a;
            if (this.label != 0) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            q.z0(obj);
            final e6.a aVar2 = this.$block;
            Utilities.wrapCustomerListener(new Runnable() { // from class: com.unity3d.ads.core.domain.a
                @Override // java.lang.Runnable
                public final void run() {
                    aVar2.invoke();
                }
            });
            return x.f13520a;
        }

        @Override // e6.p
        public final Object invoke(a0 a0Var, c<? super x> cVar) {
            return ((AnonymousClass1) create(a0Var, cVar)).invokeSuspend(x.f13520a);
        }
    }

    public CommonSafeCallbackInvoke(w mainDispatcher) {
        k.e(mainDispatcher, "mainDispatcher");
        this.mainDispatcher = mainDispatcher;
    }

    @Override // com.unity3d.ads.core.domain.SafeCallbackInvoke
    public void invoke(e6.a block) {
        k.e(block, "block");
        c0.u(c0.b(this.mainDispatcher), null, new AnonymousClass1(block, null), 3);
    }
}
