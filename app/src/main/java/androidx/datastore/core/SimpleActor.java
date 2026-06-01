package androidx.datastore.core;

import com.vungle.ads.internal.protos.Sdk;
import e6.p;
import kotlin.jvm.internal.k;
import q5.x;
import q6.a0;
import q6.c0;
import q6.e1;
import q6.f1;
import s6.l;
import s6.m;
import s6.n;
import s6.o;
import s6.s;
import v5.c;
import x5.e;
import x5.i;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes.dex */
public final class SimpleActor<T> {
    private final p consumeMessage;
    private final l messageQueue;
    private final AtomicInt remainingMessages;
    private final a0 scope;

    /* JADX INFO: renamed from: androidx.datastore.core.SimpleActor$1, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
    public static final class AnonymousClass1 extends kotlin.jvm.internal.l implements e6.l {
        final /* synthetic */ e6.l $onComplete;
        final /* synthetic */ p $onUndeliveredElement;
        final /* synthetic */ SimpleActor<T> this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass1(e6.l lVar, SimpleActor<T> simpleActor, p pVar) {
            super(1);
            this.$onComplete = lVar;
            this.this$0 = simpleActor;
            this.$onUndeliveredElement = pVar;
        }

        @Override // e6.l
        public /* bridge */ /* synthetic */ Object invoke(Object obj) {
            invoke((Throwable) obj);
            return x.f13520a;
        }

        public final void invoke(Throwable th) {
            x xVar;
            this.$onComplete.invoke(th);
            ((SimpleActor) this.this$0).messageQueue.o(th);
            do {
                Object objL = ((SimpleActor) this.this$0).messageQueue.l();
                xVar = null;
                if (objL instanceof n) {
                    objL = null;
                }
                if (objL != null) {
                    this.$onUndeliveredElement.invoke(objL, th);
                    xVar = x.f13520a;
                }
            } while (xVar != null);
        }
    }

    /* JADX INFO: renamed from: androidx.datastore.core.SimpleActor$offer$2, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
    @e(c = "androidx.datastore.core.SimpleActor$offer$2", f = "SimpleActor.kt", l = {Sdk.SDKError.Reason.TPAT_ERROR_VALUE, Sdk.SDKError.Reason.TPAT_ERROR_VALUE}, m = "invokeSuspend")
    public static final class AnonymousClass2 extends i implements p {
        Object L$0;
        int label;
        final /* synthetic */ SimpleActor<T> this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass2(SimpleActor<T> simpleActor, c<? super AnonymousClass2> cVar) {
            super(2, cVar);
            this.this$0 = simpleActor;
        }

        @Override // x5.a
        public final c<x> create(Object obj, c<?> cVar) {
            return new AnonymousClass2(this.this$0, cVar);
        }

        /* JADX WARN: Code restructure failed: missing block: B:16:0x005c, code lost:
        
            if (r1.invoke(r6, r5) != r0) goto L18;
         */
        /* JADX WARN: Removed duplicated region for block: B:15:0x0053 A[PHI: r1 r6
  0x0053: PHI (r1v1 e6.p) = (r1v2 e6.p), (r1v4 e6.p) binds: [B:13:0x0050, B:9:0x0018] A[DONT_GENERATE, DONT_INLINE]
  0x0053: PHI (r6v5 java.lang.Object) = (r6v13 java.lang.Object), (r6v0 java.lang.Object) binds: [B:13:0x0050, B:9:0x0018] A[DONT_GENERATE, DONT_INLINE]] */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:16:0x005c -> B:18:0x005f). Please report as a decompilation issue!!! */
        @Override // x5.a
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public final java.lang.Object invokeSuspend(java.lang.Object r6) throws java.lang.Throwable {
            /*
                r5 = this;
                w5.a r0 = w5.a.f17774a
                int r1 = r5.label
                r2 = 2
                r3 = 1
                if (r1 == 0) goto L20
                if (r1 == r3) goto L18
                if (r1 != r2) goto L10
                r2.q.z0(r6)
                goto L5f
            L10:
                java.lang.IllegalStateException r6 = new java.lang.IllegalStateException
                java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
                r6.<init>(r0)
                throw r6
            L18:
                java.lang.Object r1 = r5.L$0
                e6.p r1 = (e6.p) r1
                r2.q.z0(r6)
                goto L53
            L20:
                r2.q.z0(r6)
                androidx.datastore.core.SimpleActor<T> r6 = r5.this$0
                androidx.datastore.core.AtomicInt r6 = androidx.datastore.core.SimpleActor.access$getRemainingMessages$p(r6)
                int r6 = r6.get()
                if (r6 <= 0) goto L6e
            L2f:
                androidx.datastore.core.SimpleActor<T> r6 = r5.this$0
                q6.a0 r6 = androidx.datastore.core.SimpleActor.access$getScope$p(r6)
                v5.h r6 = r6.getCoroutineContext()
                q6.c0.l(r6)
                androidx.datastore.core.SimpleActor<T> r6 = r5.this$0
                e6.p r1 = androidx.datastore.core.SimpleActor.access$getConsumeMessage$p(r6)
                androidx.datastore.core.SimpleActor<T> r6 = r5.this$0
                s6.l r6 = androidx.datastore.core.SimpleActor.access$getMessageQueue$p(r6)
                r5.L$0 = r1
                r5.label = r3
                java.lang.Object r6 = r6.m(r5)
                if (r6 != r0) goto L53
                goto L5e
            L53:
                r4 = 0
                r5.L$0 = r4
                r5.label = r2
                java.lang.Object r6 = r1.invoke(r6, r5)
                if (r6 != r0) goto L5f
            L5e:
                return r0
            L5f:
                androidx.datastore.core.SimpleActor<T> r6 = r5.this$0
                androidx.datastore.core.AtomicInt r6 = androidx.datastore.core.SimpleActor.access$getRemainingMessages$p(r6)
                int r6 = r6.decrementAndGet()
                if (r6 != 0) goto L2f
                q5.x r6 = q5.x.f13520a
                return r6
            L6e:
                java.lang.IllegalStateException r6 = new java.lang.IllegalStateException
                java.lang.String r0 = "Check failed."
                r6.<init>(r0)
                throw r6
            */
            throw new UnsupportedOperationException("Method not decompiled: androidx.datastore.core.SimpleActor.AnonymousClass2.invokeSuspend(java.lang.Object):java.lang.Object");
        }

        @Override // e6.p
        public final Object invoke(a0 a0Var, c<? super x> cVar) {
            return ((AnonymousClass2) create(a0Var, cVar)).invokeSuspend(x.f13520a);
        }
    }

    public SimpleActor(a0 scope, e6.l onComplete, p onUndeliveredElement, p consumeMessage) {
        k.e(scope, "scope");
        k.e(onComplete, "onComplete");
        k.e(onUndeliveredElement, "onUndeliveredElement");
        k.e(consumeMessage, "consumeMessage");
        this.scope = scope;
        this.consumeMessage = consumeMessage;
        this.messageQueue = a.a.a(Integer.MAX_VALUE, 6, null);
        this.remainingMessages = new AtomicInt(0);
        f1 f1Var = (f1) scope.getCoroutineContext().get(e1.f13546a);
        if (f1Var != null) {
            f1Var.n(new AnonymousClass1(onComplete, this, onUndeliveredElement));
        }
    }

    public final void offer(T t3) {
        Object objD = this.messageQueue.d(t3);
        if (objD instanceof m) {
            Throwable thA = o.a(objD);
            if (thA != null) {
                throw thA;
            }
            throw new s("Channel was closed normally");
        }
        if (objD instanceof n) {
            throw new IllegalStateException("Check failed.");
        }
        if (this.remainingMessages.getAndIncrement() == 0) {
            c0.u(this.scope, null, new AnonymousClass2(this, null), 3);
        }
    }
}
