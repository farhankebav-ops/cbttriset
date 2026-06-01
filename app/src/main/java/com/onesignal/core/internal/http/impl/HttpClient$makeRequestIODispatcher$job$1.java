package com.onesignal.core.internal.http.impl;

import e6.p;
import kotlin.jvm.internal.a0;
import org.json.JSONObject;
import q5.x;
import v5.c;
import x5.e;
import x5.i;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes5.dex */
@e(c = "com.onesignal.core.internal.http.impl.HttpClient$makeRequestIODispatcher$job$1", f = "HttpClient.kt", l = {151}, m = "invokeSuspend")
public final class HttpClient$makeRequestIODispatcher$job$1 extends i implements p {
    final /* synthetic */ OptionalHeaders $headers;
    final /* synthetic */ JSONObject $jsonBody;
    final /* synthetic */ String $method;
    final /* synthetic */ a0 $retVal;
    final /* synthetic */ int $timeout;
    final /* synthetic */ String $url;
    int I$0;
    Object L$0;
    Object L$1;
    Object L$2;
    int label;
    final /* synthetic */ HttpClient this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public HttpClient$makeRequestIODispatcher$job$1(HttpClient httpClient, String str, int i2, JSONObject jSONObject, String str2, OptionalHeaders optionalHeaders, a0 a0Var, c<? super HttpClient$makeRequestIODispatcher$job$1> cVar) {
        super(2, cVar);
        this.this$0 = httpClient;
        this.$url = str;
        this.$timeout = i2;
        this.$jsonBody = jSONObject;
        this.$method = str2;
        this.$headers = optionalHeaders;
        this.$retVal = a0Var;
    }

    @Override // x5.a
    public final c<x> create(Object obj, c<?> cVar) {
        return new HttpClient$makeRequestIODispatcher$job$1(this.this$0, this.$url, this.$timeout, this.$jsonBody, this.$method, this.$headers, this.$retVal, cVar);
    }

    /* JADX WARN: Removed duplicated region for block: B:130:0x03fc A[Catch: all -> 0x0418, TryCatch #1 {all -> 0x0418, blocks: (B:128:0x03f8, B:130:0x03fc, B:133:0x0401, B:137:0x042b, B:136:0x041a), top: B:147:0x03f8 }] */
    /* JADX WARN: Removed duplicated region for block: B:136:0x041a A[Catch: all -> 0x0418, TryCatch #1 {all -> 0x0418, blocks: (B:128:0x03f8, B:130:0x03fc, B:133:0x0401, B:137:0x042b, B:136:0x041a), top: B:147:0x03f8 }] */
    /* JADX WARN: Removed duplicated region for block: B:139:0x043e  */
    @Override // x5.a
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object invokeSuspend(java.lang.Object r24) throws java.lang.Throwable {
        /*
            Method dump skipped, instruction units count: 1108
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.onesignal.core.internal.http.impl.HttpClient$makeRequestIODispatcher$job$1.invokeSuspend(java.lang.Object):java.lang.Object");
    }

    @Override // e6.p
    public final Object invoke(q6.a0 a0Var, c<? super x> cVar) {
        return ((HttpClient$makeRequestIODispatcher$job$1) create(a0Var, cVar)).invokeSuspend(x.f13520a);
    }
}
