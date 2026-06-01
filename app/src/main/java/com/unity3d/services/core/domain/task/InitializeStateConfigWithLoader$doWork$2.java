package com.unity3d.services.core.domain.task;

import com.unity3d.services.core.domain.task.InitializeStateConfigWithLoader;
import com.vungle.ads.internal.protos.Sdk;
import e6.p;
import q5.k;
import q5.x;
import q6.a0;
import v5.c;
import x5.e;
import x5.i;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes5.dex */
@e(c = "com.unity3d.services.core.domain.task.InitializeStateConfigWithLoader$doWork$2", f = "InitializeStateConfigWithLoader.kt", l = {Sdk.SDKMetric.SDKMetricType.INIT_TO_FAIL_CALLBACK_DURATION_MS_VALUE, 101, 109}, m = "invokeSuspend")
public final class InitializeStateConfigWithLoader$doWork$2 extends i implements p {
    final /* synthetic */ InitializeStateConfigWithLoader.Params $params;
    private /* synthetic */ Object L$0;
    Object L$1;
    Object L$2;
    Object L$3;
    Object L$4;
    int label;
    final /* synthetic */ InitializeStateConfigWithLoader this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public InitializeStateConfigWithLoader$doWork$2(InitializeStateConfigWithLoader initializeStateConfigWithLoader, InitializeStateConfigWithLoader.Params params, c<? super InitializeStateConfigWithLoader$doWork$2> cVar) {
        super(2, cVar);
        this.this$0 = initializeStateConfigWithLoader;
        this.$params = params;
    }

    @Override // x5.a
    public final c<x> create(Object obj, c<?> cVar) {
        InitializeStateConfigWithLoader$doWork$2 initializeStateConfigWithLoader$doWork$2 = new InitializeStateConfigWithLoader$doWork$2(this.this$0, this.$params, cVar);
        initializeStateConfigWithLoader$doWork$2.L$0 = obj;
        return initializeStateConfigWithLoader$doWork$2;
    }

    /* JADX WARN: Removed duplicated region for block: B:52:0x0198 A[Catch: all -> 0x0022, CancellationException -> 0x0025, TryCatch #6 {CancellationException -> 0x0025, all -> 0x0022, blocks: (B:8:0x001d, B:56:0x01c3, B:62:0x01f4, B:50:0x0194, B:52:0x0198, B:57:0x01cd, B:58:0x01df, B:49:0x018f, B:37:0x0152, B:39:0x0156, B:59:0x01e0, B:60:0x01ed, B:61:0x01ee, B:36:0x014d, B:27:0x0082), top: B:82:0x000d }] */
    /* JADX WARN: Removed duplicated region for block: B:57:0x01cd A[Catch: all -> 0x0022, CancellationException -> 0x0025, TryCatch #6 {CancellationException -> 0x0025, all -> 0x0022, blocks: (B:8:0x001d, B:56:0x01c3, B:62:0x01f4, B:50:0x0194, B:52:0x0198, B:57:0x01cd, B:58:0x01df, B:49:0x018f, B:37:0x0152, B:39:0x0156, B:59:0x01e0, B:60:0x01ed, B:61:0x01ee, B:36:0x014d, B:27:0x0082), top: B:82:0x000d }] */
    /* JADX WARN: Removed duplicated region for block: B:68:0x0204  */
    @Override // x5.a
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object invokeSuspend(java.lang.Object r19) throws java.lang.Throwable {
        /*
            Method dump skipped, instruction units count: 533
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.unity3d.services.core.domain.task.InitializeStateConfigWithLoader$doWork$2.invokeSuspend(java.lang.Object):java.lang.Object");
    }

    @Override // e6.p
    public final Object invoke(a0 a0Var, c<? super k> cVar) {
        return ((InitializeStateConfigWithLoader$doWork$2) create(a0Var, cVar)).invokeSuspend(x.f13520a);
    }
}
