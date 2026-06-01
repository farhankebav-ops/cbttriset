package com.unity3d.ads.core.domain.work;

import com.unity3d.ads.core.domain.work.DownloadPriorityQueue;
import com.vungle.ads.internal.protos.Sdk;
import e6.p;
import java.util.Comparator;
import java.util.PriorityQueue;
import n7.b;
import q5.x;
import r2.q;
import t6.q0;
import t6.x0;
import x5.e;
import x5.i;
import z6.a;
import z6.c;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes5.dex */
public final class DownloadPriorityQueue {
    private final a mutex = new c(false);
    private final q0 nextTurn = x0.c(null);
    private final PriorityQueue<PriorityItem> queue = new PriorityQueue<>(50, new Comparator() { // from class: com.unity3d.ads.core.domain.work.DownloadPriorityQueue$special$$inlined$compareBy$1
        /* JADX WARN: Multi-variable type inference failed */
        @Override // java.util.Comparator
        public final int compare(T t3, T t7) {
            return b.j(Integer.valueOf(((DownloadPriorityQueue.PriorityItem) t3).getPriority()), Integer.valueOf(((DownloadPriorityQueue.PriorityItem) t7).getPriority()));
        }
    });

    /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
    public static final class PriorityItem {
        private final int priority;

        public PriorityItem(int i2) {
            this.priority = i2;
        }

        public final int getPriority() {
            return this.priority;
        }
    }

    /* JADX INFO: renamed from: com.unity3d.ads.core.domain.work.DownloadPriorityQueue$invoke$1, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
    @e(c = "com.unity3d.ads.core.domain.work.DownloadPriorityQueue", f = "DownloadPriorityQueue.kt", l = {47, 28, 31, Sdk.SDKMetric.SDKMetricType.INIT_TO_SUCCESS_CALLBACK_DURATION_MS_VALUE}, m = "invoke")
    public static final class AnonymousClass1 extends x5.c {
        Object L$0;
        Object L$1;
        Object L$2;
        Object L$3;
        int label;
        /* synthetic */ Object result;

        public AnonymousClass1(v5.c<? super AnonymousClass1> cVar) {
            super(cVar);
        }

        @Override // x5.a
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return DownloadPriorityQueue.this.invoke(0, null, this);
        }
    }

    /* JADX INFO: renamed from: com.unity3d.ads.core.domain.work.DownloadPriorityQueue$invoke$3, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
    @e(c = "com.unity3d.ads.core.domain.work.DownloadPriorityQueue$invoke$3", f = "DownloadPriorityQueue.kt", l = {}, m = "invokeSuspend")
    public static final class AnonymousClass3 extends i implements p {
        final /* synthetic */ PriorityItem $priorityItem;
        /* synthetic */ Object L$0;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass3(PriorityItem priorityItem, v5.c<? super AnonymousClass3> cVar) {
            super(2, cVar);
            this.$priorityItem = priorityItem;
        }

        @Override // x5.a
        public final v5.c<x> create(Object obj, v5.c<?> cVar) {
            AnonymousClass3 anonymousClass3 = new AnonymousClass3(this.$priorityItem, cVar);
            anonymousClass3.L$0 = obj;
            return anonymousClass3;
        }

        @Override // e6.p
        public final Object invoke(PriorityItem priorityItem, v5.c<? super Boolean> cVar) {
            return ((AnonymousClass3) create(priorityItem, cVar)).invokeSuspend(x.f13520a);
        }

        @Override // x5.a
        public final Object invokeSuspend(Object obj) throws Throwable {
            w5.a aVar = w5.a.f17774a;
            if (this.label != 0) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            q.z0(obj);
            return Boolean.valueOf(((PriorityItem) this.L$0) == this.$priorityItem);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:18:0x0052 A[PHI: r2 r11
  0x0052: PHI (r2v6 com.unity3d.ads.core.domain.work.DownloadPriorityQueue) = 
  (r2v5 com.unity3d.ads.core.domain.work.DownloadPriorityQueue)
  (r2v11 com.unity3d.ads.core.domain.work.DownloadPriorityQueue)
 binds: [B:31:0x00db, B:17:0x0046] A[DONT_GENERATE, DONT_INLINE]
  0x0052: PHI (r11v7 com.unity3d.ads.core.domain.work.DownloadPriorityQueue$PriorityItem) = 
  (r11v6 com.unity3d.ads.core.domain.work.DownloadPriorityQueue$PriorityItem)
  (r11v20 com.unity3d.ads.core.domain.work.DownloadPriorityQueue$PriorityItem)
 binds: [B:31:0x00db, B:17:0x0046] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Removed duplicated region for block: B:36:0x00f1  */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object invoke(int r11, e6.l r12, v5.c<? super q5.x> r13) throws java.lang.Throwable {
        /*
            Method dump skipped, instruction units count: 282
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.unity3d.ads.core.domain.work.DownloadPriorityQueue.invoke(int, e6.l, v5.c):java.lang.Object");
    }
}
