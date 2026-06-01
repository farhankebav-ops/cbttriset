package com.onesignal.core.internal.operations.impl;

import com.vungle.ads.internal.protos.Sdk;
import x5.c;
import x5.e;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes5.dex */
@e(c = "com.onesignal.core.internal.operations.impl.OperationRepo", f = "OperationRepo.kt", l = {242, 318, Sdk.SDKError.Reason.WEBVIEW_ERROR_VALUE}, m = "executeOperations$com_onesignal_core")
public final class OperationRepo$executeOperations$1 extends c {
    Object L$0;
    Object L$1;
    Object L$2;
    Object L$3;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ OperationRepo this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public OperationRepo$executeOperations$1(OperationRepo operationRepo, v5.c<? super OperationRepo$executeOperations$1> cVar) {
        super(cVar);
        this.this$0 = operationRepo;
    }

    @Override // x5.a
    public final Object invokeSuspend(Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        return this.this$0.executeOperations$com_onesignal_core(null, this);
    }
}
