package androidx.datastore.core;

import com.vungle.ads.internal.protos.Sdk;
import e6.p;
import q5.x;
import q6.a0;
import v5.c;
import x5.e;
import x5.i;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes.dex */
@e(c = "androidx.datastore.core.DataStoreImpl$incrementCollector$2$1", f = "DataStoreImpl.kt", l = {Sdk.SDKError.Reason.STORE_REGION_CODE_ERROR_VALUE, Sdk.SDKError.Reason.INVALID_CONFIG_RESPONSE_VALUE}, m = "invokeSuspend")
public final class DataStoreImpl$incrementCollector$2$1 extends i implements p {
    int label;
    final /* synthetic */ DataStoreImpl<T> this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public DataStoreImpl$incrementCollector$2$1(DataStoreImpl<T> dataStoreImpl, c<? super DataStoreImpl$incrementCollector$2$1> cVar) {
        super(2, cVar);
        this.this$0 = dataStoreImpl;
    }

    @Override // x5.a
    public final c<x> create(Object obj, c<?> cVar) {
        return new DataStoreImpl$incrementCollector$2$1(this.this$0, cVar);
    }

    /* JADX WARN: Code restructure failed: missing block: B:14:0x004a, code lost:
    
        if (r5.collect(r1, r4) == r0) goto L15;
     */
    @Override // x5.a
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object invokeSuspend(java.lang.Object r5) throws java.lang.Throwable {
        /*
            r4 = this;
            w5.a r0 = w5.a.f17774a
            int r1 = r4.label
            r2 = 2
            r3 = 1
            if (r1 == 0) goto L1c
            if (r1 == r3) goto L18
            if (r1 != r2) goto L10
            r2.q.z0(r5)
            goto L4d
        L10:
            java.lang.IllegalStateException r5 = new java.lang.IllegalStateException
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            r5.<init>(r0)
            throw r5
        L18:
            r2.q.z0(r5)
            goto L2e
        L1c:
            r2.q.z0(r5)
            androidx.datastore.core.DataStoreImpl<T> r5 = r4.this$0
            androidx.datastore.core.DataStoreImpl$InitDataStore r5 = androidx.datastore.core.DataStoreImpl.access$getReadAndInit$p(r5)
            r4.label = r3
            java.lang.Object r5 = r5.awaitComplete(r4)
            if (r5 != r0) goto L2e
            goto L4c
        L2e:
            androidx.datastore.core.DataStoreImpl<T> r5 = r4.this$0
            androidx.datastore.core.InterProcessCoordinator r5 = androidx.datastore.core.DataStoreImpl.access$getCoordinator(r5)
            t6.e r5 = r5.getUpdateNotifications()
            r1 = -1
            t6.e r5 = t6.x0.g(r5, r1)
            androidx.datastore.core.DataStoreImpl$incrementCollector$2$1$1 r1 = new androidx.datastore.core.DataStoreImpl$incrementCollector$2$1$1
            androidx.datastore.core.DataStoreImpl<T> r3 = r4.this$0
            r1.<init>()
            r4.label = r2
            java.lang.Object r5 = r5.collect(r1, r4)
            if (r5 != r0) goto L4d
        L4c:
            return r0
        L4d:
            q5.x r5 = q5.x.f13520a
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.datastore.core.DataStoreImpl$incrementCollector$2$1.invokeSuspend(java.lang.Object):java.lang.Object");
    }

    @Override // e6.p
    public final Object invoke(a0 a0Var, c<? super x> cVar) {
        return ((DataStoreImpl$incrementCollector$2$1) create(a0Var, cVar)).invokeSuspend(x.f13520a);
    }
}
