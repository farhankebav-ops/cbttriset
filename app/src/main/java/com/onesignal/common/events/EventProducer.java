package com.onesignal.common.events;

import com.onesignal.common.threading.ThreadUtilsKt;
import e6.l;
import e6.p;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
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
public class EventProducer<THandler> implements IEventNotifier<THandler> {
    private final List<THandler> subscribers;

    /* JADX INFO: renamed from: com.onesignal.common.events.EventProducer$fireOnMain$1, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
    @e(c = "com.onesignal.common.events.EventProducer$fireOnMain$1", f = "EventProducer.kt", l = {}, m = "invokeSuspend")
    public static final class AnonymousClass1 extends i implements l {
        final /* synthetic */ l $callback;
        int label;
        final /* synthetic */ EventProducer<THandler> this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass1(EventProducer<THandler> eventProducer, l lVar, c<? super AnonymousClass1> cVar) {
            super(1, cVar);
            this.this$0 = eventProducer;
            this.$callback = lVar;
        }

        @Override // x5.a
        public final c<x> create(c<?> cVar) {
            return new AnonymousClass1(this.this$0, this.$callback, cVar);
        }

        @Override // x5.a
        public final Object invokeSuspend(Object obj) throws Throwable {
            List listN1;
            a aVar = a.f17774a;
            if (this.label != 0) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            q.z0(obj);
            List list = ((EventProducer) this.this$0).subscribers;
            EventProducer<THandler> eventProducer = this.this$0;
            synchronized (list) {
                listN1 = r5.l.n1(((EventProducer) eventProducer).subscribers);
            }
            Iterator it = listN1.iterator();
            while (it.hasNext()) {
                this.$callback.invoke(it.next());
            }
            return x.f13520a;
        }

        @Override // e6.l
        public final Object invoke(c<? super x> cVar) {
            return ((AnonymousClass1) create(cVar)).invokeSuspend(x.f13520a);
        }
    }

    /* JADX INFO: renamed from: com.onesignal.common.events.EventProducer$suspendingFire$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
    @e(c = "com.onesignal.common.events.EventProducer", f = "EventProducer.kt", l = {79}, m = "suspendingFire")
    public static final class C26811 extends x5.c {
        Object L$0;
        Object L$1;
        int label;
        /* synthetic */ Object result;
        final /* synthetic */ EventProducer<THandler> this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C26811(EventProducer<THandler> eventProducer, c<? super C26811> cVar) {
            super(cVar);
            this.this$0 = eventProducer;
        }

        @Override // x5.a
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return this.this$0.suspendingFire(null, this);
        }
    }

    /* JADX INFO: renamed from: com.onesignal.common.events.EventProducer$suspendingFireOnMain$2, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
    @e(c = "com.onesignal.common.events.EventProducer$suspendingFireOnMain$2", f = "EventProducer.kt", l = {93}, m = "invokeSuspend")
    public static final class AnonymousClass2 extends i implements p {
        final /* synthetic */ p $callback;
        Object L$0;
        int label;
        final /* synthetic */ EventProducer<THandler> this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass2(EventProducer<THandler> eventProducer, p pVar, c<? super AnonymousClass2> cVar) {
            super(2, cVar);
            this.this$0 = eventProducer;
            this.$callback = pVar;
        }

        @Override // x5.a
        public final c<x> create(Object obj, c<?> cVar) {
            return new AnonymousClass2(this.this$0, this.$callback, cVar);
        }

        @Override // x5.a
        public final Object invokeSuspend(Object obj) throws Throwable {
            List listN1;
            Iterator it;
            a aVar = a.f17774a;
            int i2 = this.label;
            if (i2 == 0) {
                q.z0(obj);
                List list = ((EventProducer) this.this$0).subscribers;
                EventProducer<THandler> eventProducer = this.this$0;
                synchronized (list) {
                    listN1 = r5.l.n1(((EventProducer) eventProducer).subscribers);
                }
                it = listN1.iterator();
            } else {
                if (i2 != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                it = (Iterator) this.L$0;
                q.z0(obj);
            }
            while (it.hasNext()) {
                Object next = it.next();
                p pVar = this.$callback;
                this.L$0 = it;
                this.label = 1;
                if (pVar.invoke(next, this) == aVar) {
                    return aVar;
                }
            }
            return x.f13520a;
        }

        @Override // e6.p
        public final Object invoke(a0 a0Var, c<? super x> cVar) {
            return ((AnonymousClass2) create(a0Var, cVar)).invokeSuspend(x.f13520a);
        }
    }

    public EventProducer() {
        List<THandler> listSynchronizedList = Collections.synchronizedList(new ArrayList());
        k.d(listSynchronizedList, "synchronizedList(mutableListOf())");
        this.subscribers = listSynchronizedList;
    }

    public final void fire(l callback) {
        List listN1;
        k.e(callback, "callback");
        synchronized (this.subscribers) {
            listN1 = r5.l.n1(this.subscribers);
        }
        Iterator it = listN1.iterator();
        while (it.hasNext()) {
            callback.invoke(it.next());
        }
    }

    public final void fireOnMain(l callback) {
        k.e(callback, "callback");
        ThreadUtilsKt.suspendifyOnMain(new AnonymousClass1(this, callback, null));
    }

    @Override // com.onesignal.common.events.IEventNotifier
    public boolean getHasSubscribers() {
        k.e(this.subscribers, "<this>");
        return !r0.isEmpty();
    }

    @Override // com.onesignal.common.events.IEventNotifier
    public void subscribe(THandler thandler) {
        synchronized (this.subscribers) {
            this.subscribers.add(thandler);
        }
    }

    public final void subscribeAll(EventProducer<THandler> from) {
        k.e(from, "from");
        synchronized (this.subscribers) {
            Iterator<THandler> it = from.subscribers.iterator();
            while (it.hasNext()) {
                subscribe(it.next());
            }
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object suspendingFire(e6.p r6, v5.c<? super q5.x> r7) throws java.lang.Throwable {
        /*
            r5 = this;
            boolean r0 = r7 instanceof com.onesignal.common.events.EventProducer.C26811
            if (r0 == 0) goto L13
            r0 = r7
            com.onesignal.common.events.EventProducer$suspendingFire$1 r0 = (com.onesignal.common.events.EventProducer.C26811) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.label = r1
            goto L18
        L13:
            com.onesignal.common.events.EventProducer$suspendingFire$1 r0 = new com.onesignal.common.events.EventProducer$suspendingFire$1
            r0.<init>(r5, r7)
        L18:
            java.lang.Object r7 = r0.result
            w5.a r1 = w5.a.f17774a
            int r2 = r0.label
            r3 = 1
            if (r2 == 0) goto L38
            if (r2 != r3) goto L30
            java.lang.Object r6 = r0.L$1
            java.util.Iterator r6 = (java.util.Iterator) r6
            java.lang.Object r2 = r0.L$0
            e6.p r2 = (e6.p) r2
            r2.q.z0(r7)
            r7 = r2
            goto L4c
        L30:
            java.lang.IllegalStateException r6 = new java.lang.IllegalStateException
            java.lang.String r7 = "call to 'resume' before 'invoke' with coroutine"
            r6.<init>(r7)
            throw r6
        L38:
            r2.q.z0(r7)
            java.util.List<THandler> r7 = r5.subscribers
            monitor-enter(r7)
            java.util.List<THandler> r2 = r5.subscribers     // Catch: java.lang.Throwable -> L66
            java.util.List r2 = r5.l.n1(r2)     // Catch: java.lang.Throwable -> L66
            monitor-exit(r7)
            java.util.Iterator r7 = r2.iterator()
            r4 = r7
            r7 = r6
            r6 = r4
        L4c:
            boolean r2 = r6.hasNext()
            if (r2 == 0) goto L63
            java.lang.Object r2 = r6.next()
            r0.L$0 = r7
            r0.L$1 = r6
            r0.label = r3
            java.lang.Object r2 = r7.invoke(r2, r0)
            if (r2 != r1) goto L4c
            return r1
        L63:
            q5.x r6 = q5.x.f13520a
            return r6
        L66:
            r6 = move-exception
            monitor-exit(r7)
            throw r6
        */
        throw new UnsupportedOperationException("Method not decompiled: com.onesignal.common.events.EventProducer.suspendingFire(e6.p, v5.c):java.lang.Object");
    }

    public final Object suspendingFireOnMain(p pVar, c<? super x> cVar) throws Throwable {
        x6.e eVar = m0.f13566a;
        Object objH = c0.H(new AnonymousClass2(this, pVar, null), n.f17641a, cVar);
        return objH == a.f17774a ? objH : x.f13520a;
    }

    @Override // com.onesignal.common.events.IEventNotifier
    public void unsubscribe(THandler thandler) {
        synchronized (this.subscribers) {
            this.subscribers.remove(thandler);
        }
    }
}
