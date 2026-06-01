package com.unity3d.services.core.domain.task;

import com.unity3d.services.core.domain.task.BaseParams;
import com.unity3d.services.core.domain.task.BaseTask;
import q5.k;
import w5.a;
import x5.c;
import x5.e;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes5.dex */
@e(c = "com.unity3d.services.core.domain.task.BaseTask$DefaultImpls", f = "BaseTask.kt", l = {11}, m = "invoke-gIAlu-s")
public final class BaseTask$invoke$1<P extends BaseParams, R> extends c {
    int label;
    /* synthetic */ Object result;

    public BaseTask$invoke$1(v5.c<? super BaseTask$invoke$1> cVar) {
        super(cVar);
    }

    @Override // x5.a
    public final Object invokeSuspend(Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        Object objM3223invokegIAlus = BaseTask.DefaultImpls.m3223invokegIAlus(null, null, this);
        return objM3223invokegIAlus == a.f17774a ? objM3223invokegIAlus : new k(objM3223invokegIAlus);
    }
}
