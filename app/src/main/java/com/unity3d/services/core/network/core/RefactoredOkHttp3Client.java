package com.unity3d.services.core.network.core;

import com.unity3d.services.core.domain.ISDKDispatchers;
import com.unity3d.services.core.network.model.HttpRequest;
import com.unity3d.services.core.network.model.HttpResponse;
import com.vungle.ads.internal.protos.Sdk;
import e6.p;
import kotlin.jvm.internal.f;
import kotlin.jvm.internal.k;
import okhttp3.OkHttpClient;
import q5.x;
import q6.a0;
import q6.c0;
import r2.q;
import w5.a;
import x5.c;
import x5.e;
import x5.i;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes5.dex */
public final class RefactoredOkHttp3Client implements HttpClient {
    public static final Companion Companion = new Companion(null);
    public static final String MSG_CONNECTION_FAILED = "Network request failed";
    public static final String MSG_CONNECTION_TIMEOUT = "Network request timeout";
    public static final String NETWORK_CLIENT_OKHTTP = "refactored-okhttp";
    private final OkHttpClient client;
    private final ISDKDispatchers dispatchers;

    /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
    public static final class Companion {
        public /* synthetic */ Companion(f fVar) {
            this();
        }

        private Companion() {
        }
    }

    /* JADX INFO: renamed from: com.unity3d.services.core.network.core.RefactoredOkHttp3Client$execute$1, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
    @e(c = "com.unity3d.services.core.network.core.RefactoredOkHttp3Client", f = "RefactoredOkHttp3Client.kt", l = {Sdk.SDKError.Reason.JSON_ENCODE_ERROR_VALUE}, m = "execute")
    public static final class AnonymousClass1 extends c {
        Object L$0;
        Object L$1;
        Object L$2;
        int label;
        /* synthetic */ Object result;

        public AnonymousClass1(v5.c<? super AnonymousClass1> cVar) {
            super(cVar);
        }

        @Override // x5.a
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return RefactoredOkHttp3Client.this.execute(null, this);
        }
    }

    /* JADX INFO: renamed from: com.unity3d.services.core.network.core.RefactoredOkHttp3Client$executeBlocking$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
    @e(c = "com.unity3d.services.core.network.core.RefactoredOkHttp3Client$executeBlocking$1", f = "RefactoredOkHttp3Client.kt", l = {37}, m = "invokeSuspend")
    public static final class C29681 extends i implements p {
        final /* synthetic */ HttpRequest $request;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C29681(HttpRequest httpRequest, v5.c<? super C29681> cVar) {
            super(2, cVar);
            this.$request = httpRequest;
        }

        @Override // x5.a
        public final v5.c<x> create(Object obj, v5.c<?> cVar) {
            return RefactoredOkHttp3Client.this.new C29681(this.$request, cVar);
        }

        @Override // x5.a
        public final Object invokeSuspend(Object obj) throws Throwable {
            a aVar = a.f17774a;
            int i2 = this.label;
            if (i2 != 0) {
                if (i2 != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                q.z0(obj);
                return obj;
            }
            q.z0(obj);
            RefactoredOkHttp3Client refactoredOkHttp3Client = RefactoredOkHttp3Client.this;
            HttpRequest httpRequest = this.$request;
            this.label = 1;
            Object objExecute = refactoredOkHttp3Client.execute(httpRequest, this);
            return objExecute == aVar ? aVar : objExecute;
        }

        @Override // e6.p
        public final Object invoke(a0 a0Var, v5.c<? super HttpResponse> cVar) {
            return ((C29681) create(a0Var, cVar)).invokeSuspend(x.f13520a);
        }
    }

    public RefactoredOkHttp3Client(ISDKDispatchers dispatchers, OkHttpClient client) {
        k.e(dispatchers, "dispatchers");
        k.e(client, "client");
        this.dispatchers = dispatchers;
        this.client = client;
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    @Override // com.unity3d.services.core.network.core.HttpClient
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public java.lang.Object execute(com.unity3d.services.core.network.model.HttpRequest r11, v5.c<? super com.unity3d.services.core.network.model.HttpResponse> r12) throws java.lang.Throwable {
        /*
            r10 = this;
            boolean r0 = r12 instanceof com.unity3d.services.core.network.core.RefactoredOkHttp3Client.AnonymousClass1
            if (r0 == 0) goto L13
            r0 = r12
            com.unity3d.services.core.network.core.RefactoredOkHttp3Client$execute$1 r0 = (com.unity3d.services.core.network.core.RefactoredOkHttp3Client.AnonymousClass1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.label = r1
            goto L18
        L13:
            com.unity3d.services.core.network.core.RefactoredOkHttp3Client$execute$1 r0 = new com.unity3d.services.core.network.core.RefactoredOkHttp3Client$execute$1
            r0.<init>(r12)
        L18:
            java.lang.Object r12 = r0.result
            w5.a r1 = w5.a.f17774a
            int r2 = r0.label
            r3 = 1
            if (r2 == 0) goto L3b
            if (r2 != r3) goto L33
            java.lang.Object r11 = r0.L$2
            okhttp3.OkHttpClient r11 = (okhttp3.OkHttpClient) r11
            java.lang.Object r11 = r0.L$1
            okhttp3.Request r11 = (okhttp3.Request) r11
            java.lang.Object r11 = r0.L$0
            com.unity3d.services.core.network.model.HttpRequest r11 = (com.unity3d.services.core.network.model.HttpRequest) r11
            r2.q.z0(r12)     // Catch: java.io.IOException -> L99 java.net.SocketTimeoutException -> Lae
            return r12
        L33:
            java.lang.IllegalStateException r11 = new java.lang.IllegalStateException
            java.lang.String r12 = "call to 'resume' before 'invoke' with coroutine"
            r11.<init>(r12)
            throw r11
        L3b:
            r2.q.z0(r12)
            okhttp3.Request r12 = com.unity3d.services.core.network.mapper.HttpRequestToOkHttpRequestKt.toOkHttpProtoRequest(r11)     // Catch: java.io.IOException -> L99 java.net.SocketTimeoutException -> Lae
            okhttp3.OkHttpClient r2 = r10.client     // Catch: java.io.IOException -> L99 java.net.SocketTimeoutException -> Lae
            okhttp3.OkHttpClient$Builder r2 = r2.newBuilder()     // Catch: java.io.IOException -> L99 java.net.SocketTimeoutException -> Lae
            int r4 = r11.getConnectTimeout()     // Catch: java.io.IOException -> L99 java.net.SocketTimeoutException -> Lae
            long r4 = (long) r4     // Catch: java.io.IOException -> L99 java.net.SocketTimeoutException -> Lae
            java.util.concurrent.TimeUnit r6 = java.util.concurrent.TimeUnit.MILLISECONDS     // Catch: java.io.IOException -> L99 java.net.SocketTimeoutException -> Lae
            okhttp3.OkHttpClient$Builder r2 = r2.connectTimeout(r4, r6)     // Catch: java.io.IOException -> L99 java.net.SocketTimeoutException -> Lae
            int r4 = r11.getReadTimeout()     // Catch: java.io.IOException -> L99 java.net.SocketTimeoutException -> Lae
            long r4 = (long) r4     // Catch: java.io.IOException -> L99 java.net.SocketTimeoutException -> Lae
            okhttp3.OkHttpClient$Builder r2 = r2.readTimeout(r4, r6)     // Catch: java.io.IOException -> L99 java.net.SocketTimeoutException -> Lae
            int r4 = r11.getWriteTimeout()     // Catch: java.io.IOException -> L99 java.net.SocketTimeoutException -> Lae
            long r4 = (long) r4     // Catch: java.io.IOException -> L99 java.net.SocketTimeoutException -> Lae
            okhttp3.OkHttpClient$Builder r2 = r2.writeTimeout(r4, r6)     // Catch: java.io.IOException -> L99 java.net.SocketTimeoutException -> Lae
            okhttp3.OkHttpClient r2 = r2.build()     // Catch: java.io.IOException -> L99 java.net.SocketTimeoutException -> Lae
            r0.L$0 = r11     // Catch: java.io.IOException -> L99 java.net.SocketTimeoutException -> Lae
            r0.L$1 = r12     // Catch: java.io.IOException -> L99 java.net.SocketTimeoutException -> Lae
            r0.L$2 = r2     // Catch: java.io.IOException -> L99 java.net.SocketTimeoutException -> Lae
            r0.label = r3     // Catch: java.io.IOException -> L99 java.net.SocketTimeoutException -> Lae
            q6.l r4 = new q6.l     // Catch: java.io.IOException -> L99 java.net.SocketTimeoutException -> Lae
            v5.c r0 = a.a.I(r0)     // Catch: java.io.IOException -> L99 java.net.SocketTimeoutException -> Lae
            r4.<init>(r3, r0)     // Catch: java.io.IOException -> L99 java.net.SocketTimeoutException -> Lae
            r4.r()     // Catch: java.io.IOException -> L99 java.net.SocketTimeoutException -> Lae
            okhttp3.Call r12 = r2.newCall(r12)     // Catch: java.io.IOException -> L99 java.net.SocketTimeoutException -> Lae
            com.unity3d.services.core.network.core.RefactoredOkHttp3Client$execute$2$1 r0 = new com.unity3d.services.core.network.core.RefactoredOkHttp3Client$execute$2$1     // Catch: java.io.IOException -> L99 java.net.SocketTimeoutException -> Lae
            r0.<init>(r12)     // Catch: java.io.IOException -> L99 java.net.SocketTimeoutException -> Lae
            r4.t(r0)     // Catch: java.io.IOException -> L99 java.net.SocketTimeoutException -> Lae
            com.unity3d.services.core.network.core.RefactoredOkHttp3Client$execute$2$2 r0 = new com.unity3d.services.core.network.core.RefactoredOkHttp3Client$execute$2$2     // Catch: java.io.IOException -> L99 java.net.SocketTimeoutException -> Lae
            r0.<init>()     // Catch: java.io.IOException -> L99 java.net.SocketTimeoutException -> Lae
            r12.enqueue(r0)     // Catch: java.io.IOException -> L99 java.net.SocketTimeoutException -> Lae
            java.lang.Object r11 = r4.p()     // Catch: java.io.IOException -> L99 java.net.SocketTimeoutException -> Lae
            if (r11 != r1) goto L98
            return r1
        L98:
            return r11
        L99:
            com.unity3d.ads.core.data.model.exception.UnityAdsNetworkException r0 = new com.unity3d.ads.core.data.model.exception.UnityAdsNetworkException
            java.lang.String r4 = r11.getBaseURL()
            r8 = 54
            r9 = 0
            java.lang.String r1 = "Network request failed"
            r2 = 0
            r3 = 0
            r5 = 0
            r6 = 0
            java.lang.String r7 = "refactored-okhttp"
            r0.<init>(r1, r2, r3, r4, r5, r6, r7, r8, r9)
            throw r0
        Lae:
            com.unity3d.ads.core.data.model.exception.NetworkTimeoutException r0 = new com.unity3d.ads.core.data.model.exception.NetworkTimeoutException
            java.lang.String r4 = r11.getBaseURL()
            r8 = 54
            r9 = 0
            java.lang.String r1 = "Network request timeout"
            r2 = 0
            r3 = 0
            r5 = 0
            r6 = 0
            java.lang.String r7 = "refactored-okhttp"
            r0.<init>(r1, r2, r3, r4, r5, r6, r7, r8, r9)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.unity3d.services.core.network.core.RefactoredOkHttp3Client.execute(com.unity3d.services.core.network.model.HttpRequest, v5.c):java.lang.Object");
    }

    @Override // com.unity3d.services.core.network.core.HttpClient
    public HttpResponse executeBlocking(HttpRequest request) {
        k.e(request, "request");
        return (HttpResponse) c0.A(this.dispatchers.getIo(), new C29681(request, null));
    }
}
