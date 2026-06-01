package com.onesignal.common.events;

import com.onesignal.common.threading.ThreadUtilsKt;
import e6.l;
import e6.p;
import kotlin.jvm.internal.k;
import q5.x;
import q6.a0;
import q6.c0;
import q6.m0;
import r2.q;
import v5.c;
import v6.n;
import w5.a;
import x5.e;
import x5.i;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes5.dex */
public class CallbackProducer<THandler> implements ICallbackNotifier<THandler> {
    private THandler callback;

    /* JADX INFO: renamed from: com.onesignal.common.events.CallbackProducer$fireOnMain$1, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
    @e(c = "com.onesignal.common.events.CallbackProducer$fireOnMain$1", f = "CallbackProducer.kt", l = {}, m = "invokeSuspend")
    public static final class AnonymousClass1 extends i implements l {
        final /* synthetic */ l $callback;
        int label;
        final /* synthetic */ CallbackProducer<THandler> this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass1(CallbackProducer<THandler> callbackProducer, l lVar, c<? super AnonymousClass1> cVar) {
            super(1, cVar);
            this.this$0 = callbackProducer;
            this.$callback = lVar;
        }

        @Override // x5.a
        public final c<x> create(c<?> cVar) {
            return new AnonymousClass1(this.this$0, this.$callback, cVar);
        }

        @Override // x5.a
        public final Object invokeSuspend(Object obj) throws Throwable {
            a aVar = a.f17774a;
            if (this.label != 0) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            q.z0(obj);
            if (((CallbackProducer) this.this$0).callback != null) {
                l lVar = this.$callback;
                Object obj2 = ((CallbackProducer) this.this$0).callback;
                k.b(obj2);
                lVar.invoke(obj2);
            }
            return x.f13520a;
        }

        @Override // e6.l
        public final Object invoke(c<? super x> cVar) {
            return ((AnonymousClass1) create(cVar)).invokeSuspend(x.f13520a);
        }
    }

    /* JADX INFO: renamed from: com.onesignal.common.events.CallbackProducer$suspendingFireOnMain$2, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
    @e(c = "com.onesignal.common.events.CallbackProducer$suspendingFireOnMain$2", f = "CallbackProducer.kt", l = {75}, m = "invokeSuspend")
    public static final class AnonymousClass2 extends i implements p {
        final /* synthetic */ p $callback;
        int label;
        final /* synthetic */ CallbackProducer<THandler> this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass2(p pVar, CallbackProducer<THandler> callbackProducer, c<? super AnonymousClass2> cVar) {
            super(2, cVar);
            this.$callback = pVar;
            this.this$0 = callbackProducer;
        }

        @Override // x5.a
        public final c<x> create(Object obj, c<?> cVar) {
            return new AnonymousClass2(this.$callback, this.this$0, cVar);
        }

        @Override // x5.a
        public final Object invokeSuspend(Object obj) throws Throwable {
            a aVar = a.f17774a;
            int i2 = this.label;
            if (i2 == 0) {
                q.z0(obj);
                p pVar = this.$callback;
                Object obj2 = ((CallbackProducer) this.this$0).callback;
                k.b(obj2);
                this.label = 1;
                if (pVar.invoke(obj2, this) == aVar) {
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
            return ((AnonymousClass2) create(a0Var, cVar)).invokeSuspend(x.f13520a);
        }
    }

    public final void fire(l callback) {
        k.e(callback, "callback");
        THandler thandler = this.callback;
        if (thandler != null) {
            k.b(thandler);
            callback.invoke(thandler);
        }
    }

    public final void fireOnMain(l callback) {
        k.e(callback, "callback");
        ThreadUtilsKt.suspendifyOnMain(new AnonymousClass1(this, callback, null));
    }

    @Override // com.onesignal.common.events.ICallbackNotifier
    public boolean getHasCallback() {
        return this.callback != null;
    }

    @Override // com.onesignal.common.events.ICallbackNotifier
    public void set(THandler thandler) {
        this.callback = thandler;
    }

    public final Object suspendingFire(p pVar, c<? super x> cVar) {
        THandler thandler = this.callback;
        x xVar = x.f13520a;
        if (thandler != null) {
            k.b(thandler);
            Object objInvoke = pVar.invoke(thandler, cVar);
            if (objInvoke == a.f17774a) {
                return objInvoke;
            }
        }
        return xVar;
    }

    public final Object suspendingFireOnMain(p pVar, c<? super x> cVar) throws Throwable {
        if (this.callback != null) {
            x6.e eVar = m0.f13566a;
            Object objH = c0.H(new AnonymousClass2(pVar, this, null), n.f17641a, cVar);
            if (objH == a.f17774a) {
                return objH;
            }
        }
        return x.f13520a;
    }
}
