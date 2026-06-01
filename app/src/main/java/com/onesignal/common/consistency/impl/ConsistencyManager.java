package com.onesignal.common.consistency.impl;

import com.onesignal.common.consistency.RywData;
import com.onesignal.common.consistency.models.ICondition;
import com.onesignal.common.consistency.models.IConsistencyKeyEnum;
import com.onesignal.common.consistency.models.IConsistencyManager;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.jvm.internal.k;
import q5.i;
import q5.x;
import q6.n1;
import q6.q;
import q6.r;
import v5.f;
import x5.c;
import x5.e;
import z6.a;
import z6.d;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes5.dex */
public final class ConsistencyManager implements IConsistencyManager {
    private final a mutex = d.a();
    private final Map<String, Map<IConsistencyKeyEnum, RywData>> indexedTokens = new LinkedHashMap();
    private final List<i> conditions = new ArrayList();

    /* JADX INFO: renamed from: com.onesignal.common.consistency.impl.ConsistencyManager$getRywDataFromAwaitableCondition$1, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
    @e(c = "com.onesignal.common.consistency.impl.ConsistencyManager", f = "ConsistencyManager.kt", l = {100}, m = "getRywDataFromAwaitableCondition")
    public static final class AnonymousClass1 extends c {
        Object L$0;
        Object L$1;
        Object L$2;
        int label;
        /* synthetic */ Object result;

        public AnonymousClass1(v5.c<? super AnonymousClass1> cVar) {
            super(cVar);
        }

        @Override // x5.a
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return ConsistencyManager.this.getRywDataFromAwaitableCondition(null, this);
        }
    }

    /* JADX INFO: renamed from: com.onesignal.common.consistency.impl.ConsistencyManager$setRywData$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
    @e(c = "com.onesignal.common.consistency.impl.ConsistencyManager", f = "ConsistencyManager.kt", l = {100}, m = "setRywData")
    public static final class C26801 extends c {
        Object L$0;
        Object L$1;
        Object L$2;
        Object L$3;
        Object L$4;
        int label;
        /* synthetic */ Object result;

        public C26801(v5.c<? super C26801> cVar) {
            super(cVar);
        }

        @Override // x5.a
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return ConsistencyManager.this.setRywData(null, null, null, this);
        }
    }

    private final void checkConditionsAndComplete() {
        ArrayList arrayList = new ArrayList();
        for (i iVar : this.conditions) {
            ICondition iCondition = (ICondition) iVar.f13498a;
            f fVar = (q) iVar.f13499b;
            if (iCondition.isMet(this.indexedTokens)) {
                RywData rywData = iCondition.getRywData(this.indexedTokens);
                if (!((n1) fVar).K()) {
                    ((r) fVar).N(rywData);
                }
                arrayList.add(new i(iCondition, fVar));
            }
        }
        this.conditions.removeAll(arrayList);
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    @Override // com.onesignal.common.consistency.models.IConsistencyManager
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public java.lang.Object getRywDataFromAwaitableCondition(com.onesignal.common.consistency.models.ICondition r5, v5.c<? super q6.q> r6) throws java.lang.Throwable {
        /*
            r4 = this;
            boolean r0 = r6 instanceof com.onesignal.common.consistency.impl.ConsistencyManager.AnonymousClass1
            if (r0 == 0) goto L13
            r0 = r6
            com.onesignal.common.consistency.impl.ConsistencyManager$getRywDataFromAwaitableCondition$1 r0 = (com.onesignal.common.consistency.impl.ConsistencyManager.AnonymousClass1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.label = r1
            goto L18
        L13:
            com.onesignal.common.consistency.impl.ConsistencyManager$getRywDataFromAwaitableCondition$1 r0 = new com.onesignal.common.consistency.impl.ConsistencyManager$getRywDataFromAwaitableCondition$1
            r0.<init>(r6)
        L18:
            java.lang.Object r6 = r0.result
            w5.a r1 = w5.a.f17774a
            int r2 = r0.label
            r3 = 1
            if (r2 == 0) goto L3d
            if (r2 != r3) goto L35
            java.lang.Object r5 = r0.L$2
            z6.a r5 = (z6.a) r5
            java.lang.Object r1 = r0.L$1
            com.onesignal.common.consistency.models.ICondition r1 = (com.onesignal.common.consistency.models.ICondition) r1
            java.lang.Object r0 = r0.L$0
            com.onesignal.common.consistency.impl.ConsistencyManager r0 = (com.onesignal.common.consistency.impl.ConsistencyManager) r0
            r2.q.z0(r6)
            r6 = r5
            r5 = r1
            goto L54
        L35:
            java.lang.IllegalStateException r5 = new java.lang.IllegalStateException
            java.lang.String r6 = "call to 'resume' before 'invoke' with coroutine"
            r5.<init>(r6)
            throw r5
        L3d:
            r2.q.z0(r6)
            z6.a r6 = r4.mutex
            r0.L$0 = r4
            r0.L$1 = r5
            r0.L$2 = r6
            r0.label = r3
            z6.c r6 = (z6.c) r6
            java.lang.Object r0 = r6.d(r0)
            if (r0 != r1) goto L53
            return r1
        L53:
            r0 = r4
        L54:
            r1 = 0
            q6.r r2 = q6.c0.a()     // Catch: java.lang.Throwable -> L6c
            q5.i r3 = new q5.i     // Catch: java.lang.Throwable -> L6c
            r3.<init>(r5, r2)     // Catch: java.lang.Throwable -> L6c
            java.util.List<q5.i> r5 = r0.conditions     // Catch: java.lang.Throwable -> L6c
            r5.add(r3)     // Catch: java.lang.Throwable -> L6c
            r0.checkConditionsAndComplete()     // Catch: java.lang.Throwable -> L6c
            z6.c r6 = (z6.c) r6
            r6.f(r1)
            return r2
        L6c:
            r5 = move-exception
            z6.c r6 = (z6.c) r6
            r6.f(r1)
            throw r5
        */
        throw new UnsupportedOperationException("Method not decompiled: com.onesignal.common.consistency.impl.ConsistencyManager.getRywDataFromAwaitableCondition(com.onesignal.common.consistency.models.ICondition, v5.c):java.lang.Object");
    }

    @Override // com.onesignal.common.consistency.models.IConsistencyManager
    public Object resolveConditionsWithID(String str, v5.c<? super x> cVar) {
        ArrayList arrayList = new ArrayList();
        for (i iVar : this.conditions) {
            ICondition iCondition = (ICondition) iVar.f13498a;
            f fVar = (q) iVar.f13499b;
            if (k.a(iCondition.getId(), str) && !((n1) fVar).K()) {
                ((r) fVar).N(null);
            }
            arrayList.add(new i(iCondition, fVar));
        }
        this.conditions.removeAll(arrayList);
        return x.f13520a;
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    @Override // com.onesignal.common.consistency.models.IConsistencyManager
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public java.lang.Object setRywData(java.lang.String r5, com.onesignal.common.consistency.models.IConsistencyKeyEnum r6, com.onesignal.common.consistency.RywData r7, v5.c<? super q5.x> r8) throws java.lang.Throwable {
        /*
            r4 = this;
            boolean r0 = r8 instanceof com.onesignal.common.consistency.impl.ConsistencyManager.C26801
            if (r0 == 0) goto L13
            r0 = r8
            com.onesignal.common.consistency.impl.ConsistencyManager$setRywData$1 r0 = (com.onesignal.common.consistency.impl.ConsistencyManager.C26801) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.label = r1
            goto L18
        L13:
            com.onesignal.common.consistency.impl.ConsistencyManager$setRywData$1 r0 = new com.onesignal.common.consistency.impl.ConsistencyManager$setRywData$1
            r0.<init>(r8)
        L18:
            java.lang.Object r8 = r0.result
            w5.a r1 = w5.a.f17774a
            int r2 = r0.label
            r3 = 1
            if (r2 == 0) goto L46
            if (r2 != r3) goto L3e
            java.lang.Object r5 = r0.L$4
            z6.a r5 = (z6.a) r5
            java.lang.Object r6 = r0.L$3
            r7 = r6
            com.onesignal.common.consistency.RywData r7 = (com.onesignal.common.consistency.RywData) r7
            java.lang.Object r6 = r0.L$2
            com.onesignal.common.consistency.models.IConsistencyKeyEnum r6 = (com.onesignal.common.consistency.models.IConsistencyKeyEnum) r6
            java.lang.Object r1 = r0.L$1
            java.lang.String r1 = (java.lang.String) r1
            java.lang.Object r0 = r0.L$0
            com.onesignal.common.consistency.impl.ConsistencyManager r0 = (com.onesignal.common.consistency.impl.ConsistencyManager) r0
            r2.q.z0(r8)
            r8 = r5
            r5 = r1
            goto L61
        L3e:
            java.lang.IllegalStateException r5 = new java.lang.IllegalStateException
            java.lang.String r6 = "call to 'resume' before 'invoke' with coroutine"
            r5.<init>(r6)
            throw r5
        L46:
            r2.q.z0(r8)
            z6.a r8 = r4.mutex
            r0.L$0 = r4
            r0.L$1 = r5
            r0.L$2 = r6
            r0.L$3 = r7
            r0.L$4 = r8
            r0.label = r3
            z6.c r8 = (z6.c) r8
            java.lang.Object r0 = r8.d(r0)
            if (r0 != r1) goto L60
            return r1
        L60:
            r0 = r4
        L61:
            r1 = 0
            java.util.Map<java.lang.String, java.util.Map<com.onesignal.common.consistency.models.IConsistencyKeyEnum, com.onesignal.common.consistency.RywData>> r2 = r0.indexedTokens     // Catch: java.lang.Throwable -> L73
            java.lang.Object r3 = r2.get(r5)     // Catch: java.lang.Throwable -> L73
            if (r3 != 0) goto L75
            java.util.LinkedHashMap r3 = new java.util.LinkedHashMap     // Catch: java.lang.Throwable -> L73
            r3.<init>()     // Catch: java.lang.Throwable -> L73
            r2.put(r5, r3)     // Catch: java.lang.Throwable -> L73
            goto L75
        L73:
            r5 = move-exception
            goto L85
        L75:
            java.util.Map r3 = (java.util.Map) r3     // Catch: java.lang.Throwable -> L73
            r3.put(r6, r7)     // Catch: java.lang.Throwable -> L73
            r0.checkConditionsAndComplete()     // Catch: java.lang.Throwable -> L73
            z6.c r8 = (z6.c) r8
            r8.f(r1)
            q5.x r5 = q5.x.f13520a
            return r5
        L85:
            z6.c r8 = (z6.c) r8
            r8.f(r1)
            throw r5
        */
        throw new UnsupportedOperationException("Method not decompiled: com.onesignal.common.consistency.impl.ConsistencyManager.setRywData(java.lang.String, com.onesignal.common.consistency.models.IConsistencyKeyEnum, com.onesignal.common.consistency.RywData, v5.c):java.lang.Object");
    }
}
