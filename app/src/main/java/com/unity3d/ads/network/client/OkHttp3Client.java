package com.unity3d.ads.network.client;

import com.unity3d.ads.network.HttpClient;
import com.unity3d.ads.network.mapper.HttpRequestToOkHttpRequestKt;
import com.unity3d.ads.network.model.HttpRequest;
import com.unity3d.ads.network.model.HttpResponse;
import com.unity3d.services.core.domain.ISDKDispatchers;
import e6.p;
import java.io.IOException;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import kotlin.jvm.internal.k;
import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.ResponseBody;
import q5.x;
import q6.a0;
import q6.c0;
import q6.l;
import r2.q;
import v5.c;
import w5.a;
import x5.e;
import x5.i;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes5.dex */
public final class OkHttp3Client implements HttpClient {
    private final OkHttpClient client;
    private final ISDKDispatchers dispatchers;

    /* JADX INFO: renamed from: com.unity3d.ads.network.client.OkHttp3Client$execute$2, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
    @e(c = "com.unity3d.ads.network.client.OkHttp3Client$execute$2", f = "OkHttp3Client.kt", l = {35}, m = "invokeSuspend")
    public static final class AnonymousClass2 extends i implements p {
        final /* synthetic */ HttpRequest $request;
        int label;
        final /* synthetic */ OkHttp3Client this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass2(HttpRequest httpRequest, OkHttp3Client okHttp3Client, c<? super AnonymousClass2> cVar) {
            super(2, cVar);
            this.$request = httpRequest;
            this.this$0 = okHttp3Client;
        }

        @Override // x5.a
        public final c<x> create(Object obj, c<?> cVar) {
            return new AnonymousClass2(this.$request, this.this$0, cVar);
        }

        @Override // x5.a
        public final Object invokeSuspend(Object obj) throws Throwable {
            a aVar = a.f17774a;
            int i2 = this.label;
            if (i2 == 0) {
                q.z0(obj);
                Request okHttpRequest = HttpRequestToOkHttpRequestKt.toOkHttpRequest(this.$request);
                OkHttp3Client okHttp3Client = this.this$0;
                long connectTimeout = this.$request.getConnectTimeout();
                long readTimeout = this.$request.getReadTimeout();
                this.label = 1;
                obj = okHttp3Client.makeRequest(okHttpRequest, connectTimeout, readTimeout, this);
                if (obj == aVar) {
                    return aVar;
                }
            } else {
                if (i2 != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                q.z0(obj);
            }
            Response response = (Response) obj;
            int iCode = response.code();
            Map<String, List<String>> multimap = response.headers().toMultimap();
            String string = response.request().url().toString();
            ResponseBody responseBodyBody = response.body();
            String strString = responseBodyBody != null ? responseBodyBody.string() : null;
            if (strString == null) {
                strString = "";
            }
            k.d(multimap, "toMultimap()");
            k.d(string, "toString()");
            return new HttpResponse(strString, iCode, multimap, string);
        }

        @Override // e6.p
        public final Object invoke(a0 a0Var, c<? super HttpResponse> cVar) {
            return ((AnonymousClass2) create(a0Var, cVar)).invokeSuspend(x.f13520a);
        }
    }

    public OkHttp3Client(ISDKDispatchers dispatchers, OkHttpClient client) {
        k.e(dispatchers, "dispatchers");
        k.e(client, "client");
        this.dispatchers = dispatchers;
        this.client = client;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Object makeRequest(Request request, long j, long j3, c<? super Response> cVar) {
        final l lVar = new l(1, a.a.I(cVar));
        lVar.r();
        OkHttpClient.Builder builderNewBuilder = this.client.newBuilder();
        TimeUnit timeUnit = TimeUnit.MILLISECONDS;
        builderNewBuilder.connectTimeout(j, timeUnit).readTimeout(j3, timeUnit).build().newCall(request).enqueue(new Callback() { // from class: com.unity3d.ads.network.client.OkHttp3Client$makeRequest$2$1
            @Override // okhttp3.Callback
            public void onFailure(Call call, IOException e) {
                k.e(call, "call");
                k.e(e, "e");
                lVar.resumeWith(q.M(e));
            }

            @Override // okhttp3.Callback
            public void onResponse(Call call, Response response) {
                k.e(call, "call");
                k.e(response, "response");
                lVar.resumeWith(response);
            }
        });
        Object objP = lVar.p();
        a aVar = a.f17774a;
        return objP;
    }

    @Override // com.unity3d.ads.network.HttpClient
    public Object execute(HttpRequest httpRequest, c<? super HttpResponse> cVar) {
        return c0.H(new AnonymousClass2(httpRequest, this, null), this.dispatchers.getIo(), cVar);
    }
}
