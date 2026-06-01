package com.unity3d.services.core.domain.task;

import com.unity3d.services.core.domain.task.InitializeStateComplete;
import q5.k;
import w5.a;
import x5.c;
import x5.e;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes5.dex */
@e(c = "com.unity3d.services.core.domain.task.InitializeStateComplete", f = "InitializeStateComplete.kt", l = {21}, m = "doWork-gIAlu-s")
public final class InitializeStateComplete$doWork$1 extends c {
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ InitializeStateComplete this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public InitializeStateComplete$doWork$1(InitializeStateComplete initializeStateComplete, v5.c<? super InitializeStateComplete$doWork$1> cVar) {
        super(cVar);
        this.this$0 = initializeStateComplete;
    }

    @Override // x5.a
    public final Object invokeSuspend(Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        Object objM3228doWorkgIAlus = this.this$0.m3228doWorkgIAlus((InitializeStateComplete.Params) null, (v5.c<? super k>) this);
        return objM3228doWorkgIAlus == a.f17774a ? objM3228doWorkgIAlus : new k(objM3228doWorkgIAlus);
    }
}
