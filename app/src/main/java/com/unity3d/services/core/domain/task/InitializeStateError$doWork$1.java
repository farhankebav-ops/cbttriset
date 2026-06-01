package com.unity3d.services.core.domain.task;

import com.unity3d.services.core.domain.task.InitializeStateError;
import q5.k;
import w5.a;
import x5.c;
import x5.e;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes5.dex */
@e(c = "com.unity3d.services.core.domain.task.InitializeStateError", f = "InitializeStateError.kt", l = {27}, m = "doWork-gIAlu-s")
public final class InitializeStateError$doWork$1 extends c {
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ InitializeStateError this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public InitializeStateError$doWork$1(InitializeStateError initializeStateError, v5.c<? super InitializeStateError$doWork$1> cVar) {
        super(cVar);
        this.this$0 = initializeStateError;
    }

    @Override // x5.a
    public final Object invokeSuspend(Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        Object objM3233doWorkgIAlus = this.this$0.m3233doWorkgIAlus((InitializeStateError.Params) null, (v5.c<? super k>) this);
        return objM3233doWorkgIAlus == a.f17774a ? objM3233doWorkgIAlus : new k(objM3233doWorkgIAlus);
    }
}
