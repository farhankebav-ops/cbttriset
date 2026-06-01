package com.unity3d.services.core.network.core;

import com.unity3d.services.core.log.DeviceLog;
import com.unity3d.services.core.network.model.HttpRequest;
import e6.p;
import q5.x;
import r2.q;
import v5.c;
import w5.a;
import x5.e;
import x5.i;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes5.dex */
@e(c = "com.unity3d.services.core.network.core.OkHttp3Client$makeRequest$2$1$onResponse$downloadProgressLoggingJob$3", f = "OkHttp3Client.kt", l = {}, m = "invokeSuspend")
public final class OkHttp3Client$makeRequest$2$1$onResponse$downloadProgressLoggingJob$3 extends i implements p {
    final /* synthetic */ HttpRequest $request;
    /* synthetic */ int I$0;
    int label;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public OkHttp3Client$makeRequest$2$1$onResponse$downloadProgressLoggingJob$3(HttpRequest httpRequest, c<? super OkHttp3Client$makeRequest$2$1$onResponse$downloadProgressLoggingJob$3> cVar) {
        super(2, cVar);
        this.$request = httpRequest;
    }

    @Override // x5.a
    public final c<x> create(Object obj, c<?> cVar) {
        OkHttp3Client$makeRequest$2$1$onResponse$downloadProgressLoggingJob$3 okHttp3Client$makeRequest$2$1$onResponse$downloadProgressLoggingJob$3 = new OkHttp3Client$makeRequest$2$1$onResponse$downloadProgressLoggingJob$3(this.$request, cVar);
        okHttp3Client$makeRequest$2$1$onResponse$downloadProgressLoggingJob$3.I$0 = ((Number) obj).intValue();
        return okHttp3Client$makeRequest$2$1$onResponse$downloadProgressLoggingJob$3;
    }

    public final Object invoke(int i2, c<? super x> cVar) {
        return ((OkHttp3Client$makeRequest$2$1$onResponse$downloadProgressLoggingJob$3) create(Integer.valueOf(i2), cVar)).invokeSuspend(x.f13520a);
    }

    @Override // x5.a
    public final Object invokeSuspend(Object obj) throws Throwable {
        a aVar = a.f17774a;
        if (this.label != 0) {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        q.z0(obj);
        StringBuilder sbV = a1.a.v(this.I$0, "Downloaded ", "% of ");
        sbV.append(this.$request.getBaseURL());
        DeviceLog.debug(sbV.toString());
        return x.f13520a;
    }

    @Override // e6.p
    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
        return invoke(((Number) obj).intValue(), (c<? super x>) obj2);
    }
}
