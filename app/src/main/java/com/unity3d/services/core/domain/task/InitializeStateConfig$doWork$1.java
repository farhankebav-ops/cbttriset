package com.unity3d.services.core.domain.task;

import com.unity3d.services.core.domain.task.InitializeStateConfig;
import q5.k;
import w5.a;
import x5.c;
import x5.e;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes5.dex */
@e(c = "com.unity3d.services.core.domain.task.InitializeStateConfig", f = "InitializeStateConfig.kt", l = {24}, m = "doWork-gIAlu-s")
public final class InitializeStateConfig$doWork$1 extends c {
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ InitializeStateConfig this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public InitializeStateConfig$doWork$1(InitializeStateConfig initializeStateConfig, v5.c<? super InitializeStateConfig$doWork$1> cVar) {
        super(cVar);
        this.this$0 = initializeStateConfig;
    }

    @Override // x5.a
    public final Object invokeSuspend(Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        Object objM3229doWorkgIAlus = this.this$0.m3229doWorkgIAlus((InitializeStateConfig.Params) null, (v5.c<? super k>) this);
        return objM3229doWorkgIAlus == a.f17774a ? objM3229doWorkgIAlus : new k(objM3229doWorkgIAlus);
    }
}
