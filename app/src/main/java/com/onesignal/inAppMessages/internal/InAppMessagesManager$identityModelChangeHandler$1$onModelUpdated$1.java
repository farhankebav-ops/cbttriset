package com.onesignal.inAppMessages.internal;

import e6.l;
import q5.x;
import v5.c;
import x5.e;
import x5.i;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes5.dex */
@e(c = "com.onesignal.inAppMessages.internal.InAppMessagesManager$identityModelChangeHandler$1$onModelUpdated$1", f = "InAppMessagesManager.kt", l = {139, 140, 142}, m = "invokeSuspend")
public final class InAppMessagesManager$identityModelChangeHandler$1$onModelUpdated$1 extends i implements l {
    final /* synthetic */ String $newOneSignalId;
    int label;
    final /* synthetic */ InAppMessagesManager this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public InAppMessagesManager$identityModelChangeHandler$1$onModelUpdated$1(InAppMessagesManager inAppMessagesManager, String str, c<? super InAppMessagesManager$identityModelChangeHandler$1$onModelUpdated$1> cVar) {
        super(1, cVar);
        this.this$0 = inAppMessagesManager;
        this.$newOneSignalId = str;
    }

    @Override // x5.a
    public final c<x> create(c<?> cVar) {
        return new InAppMessagesManager$identityModelChangeHandler$1$onModelUpdated$1(this.this$0, this.$newOneSignalId, cVar);
    }

    /* JADX WARN: Code restructure failed: missing block: B:21:0x0055, code lost:
    
        if (r1.fetchMessages(r7, r6) == r0) goto L22;
     */
    /* JADX WARN: Removed duplicated region for block: B:20:0x004d  */
    @Override // x5.a
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object invokeSuspend(java.lang.Object r7) throws java.lang.Throwable {
        /*
            r6 = this;
            w5.a r0 = w5.a.f17774a
            int r1 = r6.label
            r2 = 3
            r3 = 2
            r4 = 1
            if (r1 == 0) goto L23
            if (r1 == r4) goto L1f
            if (r1 == r3) goto L1b
            if (r1 != r2) goto L13
            r2.q.z0(r7)
            goto L58
        L13:
            java.lang.IllegalStateException r7 = new java.lang.IllegalStateException
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            r7.<init>(r0)
            throw r7
        L1b:
            r2.q.z0(r7)
            goto L49
        L1f:
            r2.q.z0(r7)
            goto L3c
        L23:
            r2.q.z0(r7)
            com.onesignal.inAppMessages.internal.InAppMessagesManager r7 = r6.this$0
            com.onesignal.common.consistency.models.IConsistencyManager r7 = com.onesignal.inAppMessages.internal.InAppMessagesManager.access$get_consistencyManager$p(r7)
            com.onesignal.common.consistency.IamFetchReadyCondition r1 = new com.onesignal.common.consistency.IamFetchReadyCondition
            java.lang.String r5 = r6.$newOneSignalId
            r1.<init>(r5)
            r6.label = r4
            java.lang.Object r7 = r7.getRywDataFromAwaitableCondition(r1, r6)
            if (r7 != r0) goto L3c
            goto L57
        L3c:
            q6.q r7 = (q6.q) r7
            r6.label = r3
            q6.r r7 = (q6.r) r7
            java.lang.Object r7 = r7.t(r6)
            if (r7 != r0) goto L49
            goto L57
        L49:
            com.onesignal.common.consistency.RywData r7 = (com.onesignal.common.consistency.RywData) r7
            if (r7 == 0) goto L58
            com.onesignal.inAppMessages.internal.InAppMessagesManager r1 = r6.this$0
            r6.label = r2
            java.lang.Object r7 = com.onesignal.inAppMessages.internal.InAppMessagesManager.access$fetchMessages(r1, r7, r6)
            if (r7 != r0) goto L58
        L57:
            return r0
        L58:
            q5.x r7 = q5.x.f13520a
            return r7
        */
        throw new UnsupportedOperationException("Method not decompiled: com.onesignal.inAppMessages.internal.InAppMessagesManager$identityModelChangeHandler$1$onModelUpdated$1.invokeSuspend(java.lang.Object):java.lang.Object");
    }

    @Override // e6.l
    public final Object invoke(c<? super x> cVar) {
        return ((InAppMessagesManager$identityModelChangeHandler$1$onModelUpdated$1) create(cVar)).invokeSuspend(x.f13520a);
    }
}
