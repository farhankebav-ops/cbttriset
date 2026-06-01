package com.unity3d.services.core.domain.task;

import q5.k;
import w5.a;
import x5.c;
import x5.e;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes5.dex */
@e(c = "com.unity3d.services.core.domain.task.MetricTask", f = "MetricTask.kt", l = {24}, m = "invoke-gIAlu-s$suspendImpl")
public final class MetricTask$invoke$1 extends c {
    long J$0;
    Object L$0;
    Object L$1;
    Object L$2;
    Object L$3;
    Object L$4;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ MetricTask<P, R> this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    public MetricTask$invoke$1(MetricTask<? super P, R> metricTask, v5.c<? super MetricTask$invoke$1> cVar) {
        super(cVar);
        this.this$0 = metricTask;
    }

    @Override // x5.a
    public final Object invokeSuspend(Object obj) throws Throwable {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        Object objM3239invokegIAlus$suspendImpl = MetricTask.m3239invokegIAlus$suspendImpl(this.this$0, null, this);
        return objM3239invokegIAlus$suspendImpl == a.f17774a ? objM3239invokegIAlus$suspendImpl : new k(objM3239invokegIAlus$suspendImpl);
    }
}
