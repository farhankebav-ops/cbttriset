package androidx.datastore.core;

import e6.p;
import kotlin.jvm.internal.y;
import q5.x;
import v5.c;
import x5.e;
import x5.i;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes.dex */
@e(c = "androidx.datastore.core.DataStoreImpl$writeData$2", f = "DataStoreImpl.kt", l = {352, 353}, m = "invokeSuspend")
public final class DataStoreImpl$writeData$2 extends i implements p {
    final /* synthetic */ T $newData;
    final /* synthetic */ y $newVersion;
    final /* synthetic */ boolean $updateCache;
    private /* synthetic */ Object L$0;
    Object L$1;
    int label;
    final /* synthetic */ DataStoreImpl<T> this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public DataStoreImpl$writeData$2(y yVar, DataStoreImpl<T> dataStoreImpl, T t3, boolean z2, c<? super DataStoreImpl$writeData$2> cVar) {
        super(2, cVar);
        this.$newVersion = yVar;
        this.this$0 = dataStoreImpl;
        this.$newData = t3;
        this.$updateCache = z2;
    }

    @Override // x5.a
    public final c<x> create(Object obj, c<?> cVar) {
        DataStoreImpl$writeData$2 dataStoreImpl$writeData$2 = new DataStoreImpl$writeData$2(this.$newVersion, this.this$0, this.$newData, this.$updateCache, cVar);
        dataStoreImpl$writeData$2.L$0 = obj;
        return dataStoreImpl$writeData$2;
    }

    @Override // e6.p
    public final Object invoke(WriteScope<T> writeScope, c<? super x> cVar) {
        return ((DataStoreImpl$writeData$2) create(writeScope, cVar)).invokeSuspend(x.f13520a);
    }

    /* JADX WARN: Code restructure failed: missing block: B:15:0x0058, code lost:
    
        if (r3.writeData(r7, r6) == r0) goto L16;
     */
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
            r2 = 2
            r3 = 1
            if (r1 == 0) goto L24
            if (r1 == r3) goto L18
            if (r1 != r2) goto L10
            r2.q.z0(r7)
            goto L5b
        L10:
            java.lang.IllegalStateException r7 = new java.lang.IllegalStateException
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            r7.<init>(r0)
            throw r7
        L18:
            java.lang.Object r1 = r6.L$1
            kotlin.jvm.internal.y r1 = (kotlin.jvm.internal.y) r1
            java.lang.Object r3 = r6.L$0
            androidx.datastore.core.WriteScope r3 = (androidx.datastore.core.WriteScope) r3
            r2.q.z0(r7)
            goto L43
        L24:
            r2.q.z0(r7)
            java.lang.Object r7 = r6.L$0
            androidx.datastore.core.WriteScope r7 = (androidx.datastore.core.WriteScope) r7
            kotlin.jvm.internal.y r1 = r6.$newVersion
            androidx.datastore.core.DataStoreImpl<T> r4 = r6.this$0
            androidx.datastore.core.InterProcessCoordinator r4 = androidx.datastore.core.DataStoreImpl.access$getCoordinator(r4)
            r6.L$0 = r7
            r6.L$1 = r1
            r6.label = r3
            java.lang.Object r3 = r4.incrementAndGetVersion(r6)
            if (r3 != r0) goto L40
            goto L5a
        L40:
            r5 = r3
            r3 = r7
            r7 = r5
        L43:
            java.lang.Number r7 = (java.lang.Number) r7
            int r7 = r7.intValue()
            r1.f12730a = r7
            T r7 = r6.$newData
            r1 = 0
            r6.L$0 = r1
            r6.L$1 = r1
            r6.label = r2
            java.lang.Object r7 = r3.writeData(r7, r6)
            if (r7 != r0) goto L5b
        L5a:
            return r0
        L5b:
            boolean r7 = r6.$updateCache
            if (r7 == 0) goto L7b
            androidx.datastore.core.DataStoreImpl<T> r7 = r6.this$0
            androidx.datastore.core.DataStoreInMemoryCache r7 = androidx.datastore.core.DataStoreImpl.access$getInMemoryCache$p(r7)
            androidx.datastore.core.Data r0 = new androidx.datastore.core.Data
            T r1 = r6.$newData
            if (r1 == 0) goto L70
            int r2 = r1.hashCode()
            goto L71
        L70:
            r2 = 0
        L71:
            kotlin.jvm.internal.y r3 = r6.$newVersion
            int r3 = r3.f12730a
            r0.<init>(r1, r2, r3)
            r7.tryUpdate(r0)
        L7b:
            q5.x r7 = q5.x.f13520a
            return r7
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.datastore.core.DataStoreImpl$writeData$2.invokeSuspend(java.lang.Object):java.lang.Object");
    }
}
