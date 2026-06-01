package com.unity3d.services.core.domain.task;

import q5.k;
import w5.a;
import x5.c;
import x5.e;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes5.dex */
@e(c = "com.unity3d.services.core.domain.task.InitializeStateReset", f = "InitializeStateReset.kt", l = {33}, m = "doWork-gIAlu-s$suspendImpl")
public final class InitializeStateReset$doWork$1 extends c {
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ InitializeStateReset this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public InitializeStateReset$doWork$1(InitializeStateReset initializeStateReset, v5.c<? super InitializeStateReset$doWork$1> cVar) {
        super(cVar);
        this.this$0 = initializeStateReset;
    }

    @Override // x5.a
    public final Object invokeSuspend(Object obj) throws Throwable {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        Object objM3237doWorkgIAlus$suspendImpl = InitializeStateReset.m3237doWorkgIAlus$suspendImpl(this.this$0, null, this);
        return objM3237doWorkgIAlus$suspendImpl == a.f17774a ? objM3237doWorkgIAlus$suspendImpl : new k(objM3237doWorkgIAlus$suspendImpl);
    }
}
