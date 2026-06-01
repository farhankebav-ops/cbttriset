package com.unity3d.services.core.domain.task;

import q5.k;
import w5.a;
import x5.c;
import x5.e;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes5.dex */
@e(c = "com.unity3d.services.core.domain.task.InitializeSDK", f = "InitializeSDK.kt", l = {120}, m = "executeErrorState-BWLJW6A")
public final class InitializeSDK$executeErrorState$1 extends c {
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ InitializeSDK this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public InitializeSDK$executeErrorState$1(InitializeSDK initializeSDK, v5.c<? super InitializeSDK$executeErrorState$1> cVar) {
        super(cVar);
        this.this$0 = initializeSDK;
    }

    @Override // x5.a
    public final Object invokeSuspend(Object obj) throws Throwable {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        Object objM3226executeErrorStateBWLJW6A = this.this$0.m3226executeErrorStateBWLJW6A(null, null, null, this);
        return objM3226executeErrorStateBWLJW6A == a.f17774a ? objM3226executeErrorStateBWLJW6A : new k(objM3226executeErrorStateBWLJW6A);
    }
}
