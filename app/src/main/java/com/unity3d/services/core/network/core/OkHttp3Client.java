package com.unity3d.services.core.network.core;

import android.content.Context;
import android.support.v4.media.g;
import androidx.activity.u;
import com.unity3d.ads.core.configuration.AlternativeFlowReader;
import com.unity3d.ads.core.data.model.exception.NetworkTimeoutException;
import com.unity3d.ads.core.data.model.exception.UnityAdsNetworkException;
import com.unity3d.ads.core.data.repository.SessionRepository;
import com.unity3d.ads.core.extensions.StringExtensionsKt;
import com.unity3d.services.UnityAdsConstants;
import com.unity3d.services.core.domain.ISDKDispatchers;
import com.unity3d.services.core.log.DeviceLog;
import com.unity3d.services.core.network.core.OkHttp3Client;
import com.unity3d.services.core.network.domain.CleanupDirectory;
import com.unity3d.services.core.network.mapper.HttpRequestToOkHttpRequestKt;
import com.unity3d.services.core.network.model.HttpRequest;
import com.unity3d.services.core.network.model.HttpResponse;
import com.vungle.ads.internal.protos.Sdk;
import e6.p;
import gatewayprotocol.v1.NativeConfigurationOuterClass;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.SocketTimeoutException;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import kotlin.jvm.internal.f;
import kotlin.jvm.internal.k;
import l7.b;
import l7.i0;
import l7.j;
import n6.m;
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
import q6.u1;
import r2.q;
import t6.d1;
import t6.n;
import t6.x0;
import v5.c;
import w5.a;
import x5.e;
import x5.i;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes5.dex */
public final class OkHttp3Client implements HttpClient {
    public static final Companion Companion = new Companion(null);
    public static final String MSG_CONNECTION_FAILED = "Network request failed";
    public static final String MSG_CONNECTION_TIMEOUT = "Network request timeout";
    public static final String NETWORK_CLIENT_OKHTTP = "okhttp";
    private final CleanupDirectory cleanupDirectory;
    private final OkHttpClient client;
    private final Context context;
    private final ISDKDispatchers dispatchers;
    private final AlternativeFlowReader isAlternativeFlowReader;
    private final File okHttpCache;
    private final SessionRepository sessionRepository;

    /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
    public static final class Companion {
        public /* synthetic */ Companion(f fVar) {
            this();
        }

        private Companion() {
        }
    }

    /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
    public static final class RequestComplete {
        private final Object body;
        private final Response response;

        public RequestComplete(Response response, Object obj) {
            k.e(response, "response");
            this.response = response;
            this.body = obj;
        }

        public static /* synthetic */ RequestComplete copy$default(RequestComplete requestComplete, Response response, Object obj, int i2, Object obj2) {
            if ((i2 & 1) != 0) {
                response = requestComplete.response;
            }
            if ((i2 & 2) != 0) {
                obj = requestComplete.body;
            }
            return requestComplete.copy(response, obj);
        }

        public final Response component1() {
            return this.response;
        }

        public final Object component2() {
            return this.body;
        }

        public final RequestComplete copy(Response response, Object obj) {
            k.e(response, "response");
            return new RequestComplete(response, obj);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof RequestComplete)) {
                return false;
            }
            RequestComplete requestComplete = (RequestComplete) obj;
            return k.a(this.response, requestComplete.response) && k.a(this.body, requestComplete.body);
        }

        public final Object getBody() {
            return this.body;
        }

        public final Response getResponse() {
            return this.response;
        }

        public int hashCode() {
            int iHashCode = this.response.hashCode() * 31;
            Object obj = this.body;
            return iHashCode + (obj == null ? 0 : obj.hashCode());
        }

        public String toString() {
            return "RequestComplete(response=" + this.response + ", body=" + this.body + ')';
        }

        public /* synthetic */ RequestComplete(Response response, Object obj, int i2, f fVar) {
            this(response, (i2 & 2) != 0 ? null : obj);
        }
    }

    /* JADX INFO: renamed from: com.unity3d.services.core.network.core.OkHttp3Client$execute$2, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
    @e(c = "com.unity3d.services.core.network.core.OkHttp3Client$execute$2", f = "OkHttp3Client.kt", l = {74}, m = "invokeSuspend")
    public static final class AnonymousClass2 extends i implements p {
        final /* synthetic */ HttpRequest $request;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass2(HttpRequest httpRequest, c<? super AnonymousClass2> cVar) {
            super(2, cVar);
            this.$request = httpRequest;
        }

        @Override // x5.a
        public final c<x> create(Object obj, c<?> cVar) {
            return OkHttp3Client.this.new AnonymousClass2(this.$request, cVar);
        }

        @Override // x5.a
        public final Object invokeSuspend(Object obj) throws Throwable {
            Object objMakeRequest;
            a aVar = a.f17774a;
            int i2 = this.label;
            try {
                if (i2 == 0) {
                    q.z0(obj);
                    OkHttp3Client okHttp3Client = OkHttp3Client.this;
                    HttpRequest httpRequest = this.$request;
                    long connectTimeout = httpRequest.getConnectTimeout();
                    long readTimeout = this.$request.getReadTimeout();
                    long writeTimeout = this.$request.getWriteTimeout();
                    this.label = 1;
                    objMakeRequest = okHttp3Client.makeRequest(httpRequest, connectTimeout, readTimeout, writeTimeout, this);
                    if (objMakeRequest == aVar) {
                        return aVar;
                    }
                } else {
                    if (i2 != 1) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    q.z0(obj);
                    objMakeRequest = obj;
                }
                RequestComplete requestComplete = (RequestComplete) objMakeRequest;
                Response responseComponent1 = requestComplete.component1();
                String strComponent2 = requestComplete.component2();
                if (!OkHttp3Client.this.isAlternativeFlowReader.invoke()) {
                    strComponent2 = strComponent2 instanceof File ? c6.k.c0((File) strComponent2) : strComponent2 instanceof byte[] ? new String((byte[]) strComponent2, n6.a.f13073a) : "";
                }
                int iCode = responseComponent1.code();
                Map<String, List<String>> multimap = responseComponent1.headers().toMultimap();
                String string = responseComponent1.request().url().toString();
                Object obj2 = strComponent2 == null ? "" : strComponent2;
                String string2 = responseComponent1.protocol().toString();
                k.d(multimap, "toMultimap()");
                k.d(string, "toString()");
                k.d(string2, "toString()");
                return new HttpResponse(obj2, iCode, multimap, string, string2, OkHttp3Client.NETWORK_CLIENT_OKHTTP, 0L, 64, null);
            } catch (SocketTimeoutException unused) {
                throw new NetworkTimeoutException("Network request timeout", null, null, this.$request.getBaseURL(), null, null, OkHttp3Client.NETWORK_CLIENT_OKHTTP, 54, null);
            } catch (IOException unused2) {
                throw new UnityAdsNetworkException("Network request failed", null, null, this.$request.getBaseURL(), null, null, OkHttp3Client.NETWORK_CLIENT_OKHTTP, 54, null);
            }
        }

        @Override // e6.p
        public final Object invoke(a0 a0Var, c<? super HttpResponse> cVar) {
            return ((AnonymousClass2) create(a0Var, cVar)).invokeSuspend(x.f13520a);
        }
    }

    /* JADX INFO: renamed from: com.unity3d.services.core.network.core.OkHttp3Client$executeBlocking$1, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
    @e(c = "com.unity3d.services.core.network.core.OkHttp3Client$executeBlocking$1", f = "OkHttp3Client.kt", l = {63}, m = "invokeSuspend")
    public static final class AnonymousClass1 extends i implements p {
        final /* synthetic */ HttpRequest $request;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass1(HttpRequest httpRequest, c<? super AnonymousClass1> cVar) {
            super(2, cVar);
            this.$request = httpRequest;
        }

        @Override // x5.a
        public final c<x> create(Object obj, c<?> cVar) {
            return OkHttp3Client.this.new AnonymousClass1(this.$request, cVar);
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
            OkHttp3Client okHttp3Client = OkHttp3Client.this;
            HttpRequest httpRequest = this.$request;
            this.label = 1;
            Object objExecute = okHttp3Client.execute(httpRequest, this);
            return objExecute == aVar ? aVar : objExecute;
        }

        @Override // e6.p
        public final Object invoke(a0 a0Var, c<? super HttpResponse> cVar) {
            return ((AnonymousClass1) create(a0Var, cVar)).invokeSuspend(x.f13520a);
        }
    }

    public OkHttp3Client(ISDKDispatchers dispatchers, OkHttpClient client, Context context, SessionRepository sessionRepository, CleanupDirectory cleanupDirectory, AlternativeFlowReader isAlternativeFlowReader) {
        k.e(dispatchers, "dispatchers");
        k.e(client, "client");
        k.e(context, "context");
        k.e(sessionRepository, "sessionRepository");
        k.e(cleanupDirectory, "cleanupDirectory");
        k.e(isAlternativeFlowReader, "isAlternativeFlowReader");
        this.dispatchers = dispatchers;
        this.client = client;
        this.context = context;
        this.sessionRepository = sessionRepository;
        this.cleanupDirectory = cleanupDirectory;
        this.isAlternativeFlowReader = isAlternativeFlowReader;
        this.okHttpCache = getOkHttpCache();
    }

    private final File getOkHttpCache() {
        File filesDir = this.context.getFilesDir();
        k.d(filesDir, "context.filesDir");
        File fileD0 = c6.k.d0(filesDir, UnityAdsConstants.DefaultUrls.HTTP_CACHE_DIR_NAME);
        fileD0.mkdirs();
        if (this.sessionRepository.getNativeConfiguration().hasCachedAssetsConfiguration()) {
            NativeConfigurationOuterClass.CachedAssetsConfiguration cachedAssetsConfiguration = this.sessionRepository.getNativeConfiguration().getCachedAssetsConfiguration();
            this.cleanupDirectory.invoke(fileD0, cachedAssetsConfiguration.getMaxCachedAssetSizeMb(), cachedAssetsConfiguration.getMaxCachedAssetAgeMs());
        }
        return fileD0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Object makeRequest(final HttpRequest httpRequest, long j, long j3, long j8, c<? super RequestComplete> cVar) {
        Request okHttpProtoRequest = httpRequest.isProtobuf() ? HttpRequestToOkHttpRequestKt.toOkHttpProtoRequest(httpRequest) : HttpRequestToOkHttpRequestKt.toOkHttpRequest(httpRequest);
        OkHttpClient.Builder builderNewBuilder = this.client.newBuilder();
        TimeUnit timeUnit = TimeUnit.MILLISECONDS;
        OkHttpClient okHttpClientBuild = builderNewBuilder.connectTimeout(j, timeUnit).readTimeout(j3, timeUnit).writeTimeout(j8, timeUnit).build();
        final File file = new File(this.okHttpCache, StringExtensionsKt.getSHA256Hash(httpRequest.getBaseURL()));
        Long l = new Long((file.exists() && file.isFile()) ? file.length() : 0L);
        Request requestBuild = null;
        if (l.longValue() <= 0) {
            l = null;
        }
        if (l != null) {
            long jLongValue = l.longValue();
            DeviceLog.debug("Resuming download for " + httpRequest.getBaseURL());
            requestBuild = okHttpProtoRequest.newBuilder().addHeader("Range", "bytes=" + jLongValue + '-').build();
        }
        final l lVar = new l(1, a.a.I(cVar));
        lVar.r();
        if (requestBuild != null) {
            okHttpProtoRequest = requestBuild;
        }
        okHttpClientBuild.newCall(okHttpProtoRequest).enqueue(new Callback() { // from class: com.unity3d.services.core.network.core.OkHttp3Client$makeRequest$2$1
            @Override // okhttp3.Callback
            public void onFailure(Call call, IOException e) {
                k.e(call, "call");
                k.e(e, "e");
                lVar.resumeWith(q.M(e));
            }

            @Override // okhttp3.Callback
            public void onResponse(Call call, Response response) {
                i0 i0VarB;
                u1 u1VarO;
                k.e(call, "call");
                k.e(response, "response");
                if (!response.isSuccessful()) {
                    lVar.resumeWith(q.M(new IOException("Network request failed with code " + response.code())));
                    return;
                }
                try {
                    ResponseBody responseBodyBody = response.body();
                    f fVar = null;
                    if (responseBodyBody == null) {
                        lVar.resumeWith(new OkHttp3Client.RequestComplete(response, fVar, 2, fVar));
                        return;
                    }
                    final long jContentLength = responseBodyBody.contentLength();
                    j jVar = new j();
                    String strHeader = response.header("Cache-Control");
                    if (((strHeader == null || m.q0(strHeader, "no-cache", false)) ? null : this) != null) {
                        File file2 = file;
                        if (!file2.exists()) {
                            file2.createNewFile();
                        }
                        i0VarB = b.b(b.h(new FileOutputStream(file2, true)));
                    } else {
                        i0VarB = null;
                    }
                    long jLongValue2 = 0;
                    d1 d1VarC = i0VarB != null ? x0.c(0L) : null;
                    if (d1VarC != null) {
                        final a4.a aVar = new a4.a(new n(new u(12), d1VarC, null), 28);
                        final t6.e eVar = new t6.e() { // from class: com.unity3d.services.core.network.core.OkHttp3Client$makeRequest$2$1$onResponse$$inlined$filter$1

                            /* JADX INFO: renamed from: com.unity3d.services.core.network.core.OkHttp3Client$makeRequest$2$1$onResponse$$inlined$filter$1$2, reason: invalid class name */
                            /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
                            public static final class AnonymousClass2<T> implements t6.f {
                                final /* synthetic */ t6.f $this_unsafeFlow;

                                /* JADX INFO: renamed from: com.unity3d.services.core.network.core.OkHttp3Client$makeRequest$2$1$onResponse$$inlined$filter$1$2$1, reason: invalid class name */
                                /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
                                @e(c = "com.unity3d.services.core.network.core.OkHttp3Client$makeRequest$2$1$onResponse$$inlined$filter$1$2", f = "OkHttp3Client.kt", l = {Sdk.SDKError.Reason.STALE_CACHED_RESPONSE_VALUE}, m = "emit")
                                public static final class AnonymousClass1 extends x5.c {
                                    Object L$0;
                                    Object L$1;
                                    int label;
                                    /* synthetic */ Object result;

                                    public AnonymousClass1(c cVar) {
                                        super(cVar);
                                    }

                                    @Override // x5.a
                                    public final Object invokeSuspend(Object obj) {
                                        this.result = obj;
                                        this.label |= Integer.MIN_VALUE;
                                        return AnonymousClass2.this.emit(null, this);
                                    }
                                }

                                public AnonymousClass2(t6.f fVar) {
                                    this.$this_unsafeFlow = fVar;
                                }

                                /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
                                @Override // t6.f
                                /*
                                    Code decompiled incorrectly, please refer to instructions dump.
                                    To view partially-correct code enable 'Show inconsistent code' option in preferences
                                */
                                public final java.lang.Object emit(java.lang.Object r9, v5.c r10) throws java.lang.Throwable {
                                    /*
                                        r8 = this;
                                        boolean r0 = r10 instanceof com.unity3d.services.core.network.core.OkHttp3Client$makeRequest$2$1$onResponse$$inlined$filter$1.AnonymousClass2.AnonymousClass1
                                        if (r0 == 0) goto L13
                                        r0 = r10
                                        com.unity3d.services.core.network.core.OkHttp3Client$makeRequest$2$1$onResponse$$inlined$filter$1$2$1 r0 = (com.unity3d.services.core.network.core.OkHttp3Client$makeRequest$2$1$onResponse$$inlined$filter$1.AnonymousClass2.AnonymousClass1) r0
                                        int r1 = r0.label
                                        r2 = -2147483648(0xffffffff80000000, float:-0.0)
                                        r3 = r1 & r2
                                        if (r3 == 0) goto L13
                                        int r1 = r1 - r2
                                        r0.label = r1
                                        goto L18
                                    L13:
                                        com.unity3d.services.core.network.core.OkHttp3Client$makeRequest$2$1$onResponse$$inlined$filter$1$2$1 r0 = new com.unity3d.services.core.network.core.OkHttp3Client$makeRequest$2$1$onResponse$$inlined$filter$1$2$1
                                        r0.<init>(r10)
                                    L18:
                                        java.lang.Object r10 = r0.result
                                        w5.a r1 = w5.a.f17774a
                                        int r2 = r0.label
                                        r3 = 1
                                        if (r2 == 0) goto L2f
                                        if (r2 != r3) goto L27
                                        r2.q.z0(r10)
                                        goto L4a
                                    L27:
                                        java.lang.IllegalStateException r9 = new java.lang.IllegalStateException
                                        java.lang.String r10 = "call to 'resume' before 'invoke' with coroutine"
                                        r9.<init>(r10)
                                        throw r9
                                    L2f:
                                        r2.q.z0(r10)
                                        t6.f r10 = r8.$this_unsafeFlow
                                        r2 = r9
                                        java.lang.Number r2 = (java.lang.Number) r2
                                        long r4 = r2.longValue()
                                        r6 = 0
                                        int r2 = (r4 > r6 ? 1 : (r4 == r6 ? 0 : -1))
                                        if (r2 == 0) goto L4a
                                        r0.label = r3
                                        java.lang.Object r9 = r10.emit(r9, r0)
                                        if (r9 != r1) goto L4a
                                        return r1
                                    L4a:
                                        q5.x r9 = q5.x.f13520a
                                        return r9
                                    */
                                    throw new UnsupportedOperationException("Method not decompiled: com.unity3d.services.core.network.core.OkHttp3Client$makeRequest$2$1$onResponse$$inlined$filter$1.AnonymousClass2.emit(java.lang.Object, v5.c):java.lang.Object");
                                }
                            }

                            @Override // t6.e
                            public Object collect(t6.f fVar2, c cVar2) {
                                Object objCollect = aVar.collect(new AnonymousClass2(fVar2), cVar2);
                                return objCollect == a.f17774a ? objCollect : x.f13520a;
                            }
                        };
                        u1VarO = x0.o(new g(24, new t6.e() { // from class: com.unity3d.services.core.network.core.OkHttp3Client$makeRequest$2$1$onResponse$$inlined$map$1

                            /* JADX INFO: renamed from: com.unity3d.services.core.network.core.OkHttp3Client$makeRequest$2$1$onResponse$$inlined$map$1$2, reason: invalid class name */
                            /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
                            public static final class AnonymousClass2<T> implements t6.f {
                                final /* synthetic */ long $contentLength$inlined;
                                final /* synthetic */ t6.f $this_unsafeFlow;

                                /* JADX INFO: renamed from: com.unity3d.services.core.network.core.OkHttp3Client$makeRequest$2$1$onResponse$$inlined$map$1$2$1, reason: invalid class name */
                                /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
                                @e(c = "com.unity3d.services.core.network.core.OkHttp3Client$makeRequest$2$1$onResponse$$inlined$map$1$2", f = "OkHttp3Client.kt", l = {Sdk.SDKError.Reason.STALE_CACHED_RESPONSE_VALUE}, m = "emit")
                                public static final class AnonymousClass1 extends x5.c {
                                    Object L$0;
                                    int label;
                                    /* synthetic */ Object result;

                                    public AnonymousClass1(c cVar) {
                                        super(cVar);
                                    }

                                    @Override // x5.a
                                    public final Object invokeSuspend(Object obj) {
                                        this.result = obj;
                                        this.label |= Integer.MIN_VALUE;
                                        return AnonymousClass2.this.emit(null, this);
                                    }
                                }

                                public AnonymousClass2(t6.f fVar, long j) {
                                    this.$this_unsafeFlow = fVar;
                                    this.$contentLength$inlined = j;
                                }

                                /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
                                @Override // t6.f
                                /*
                                    Code decompiled incorrectly, please refer to instructions dump.
                                    To view partially-correct code enable 'Show inconsistent code' option in preferences
                                */
                                public final java.lang.Object emit(java.lang.Object r7, v5.c r8) throws java.lang.Throwable {
                                    /*
                                        r6 = this;
                                        boolean r0 = r8 instanceof com.unity3d.services.core.network.core.OkHttp3Client$makeRequest$2$1$onResponse$$inlined$map$1.AnonymousClass2.AnonymousClass1
                                        if (r0 == 0) goto L13
                                        r0 = r8
                                        com.unity3d.services.core.network.core.OkHttp3Client$makeRequest$2$1$onResponse$$inlined$map$1$2$1 r0 = (com.unity3d.services.core.network.core.OkHttp3Client$makeRequest$2$1$onResponse$$inlined$map$1.AnonymousClass2.AnonymousClass1) r0
                                        int r1 = r0.label
                                        r2 = -2147483648(0xffffffff80000000, float:-0.0)
                                        r3 = r1 & r2
                                        if (r3 == 0) goto L13
                                        int r1 = r1 - r2
                                        r0.label = r1
                                        goto L18
                                    L13:
                                        com.unity3d.services.core.network.core.OkHttp3Client$makeRequest$2$1$onResponse$$inlined$map$1$2$1 r0 = new com.unity3d.services.core.network.core.OkHttp3Client$makeRequest$2$1$onResponse$$inlined$map$1$2$1
                                        r0.<init>(r8)
                                    L18:
                                        java.lang.Object r8 = r0.result
                                        w5.a r1 = w5.a.f17774a
                                        int r2 = r0.label
                                        r3 = 1
                                        if (r2 == 0) goto L2f
                                        if (r2 != r3) goto L27
                                        r2.q.z0(r8)
                                        goto L55
                                    L27:
                                        java.lang.IllegalStateException r7 = new java.lang.IllegalStateException
                                        java.lang.String r8 = "call to 'resume' before 'invoke' with coroutine"
                                        r7.<init>(r8)
                                        throw r7
                                    L2f:
                                        r2.q.z0(r8)
                                        t6.f r8 = r6.$this_unsafeFlow
                                        java.lang.Number r7 = (java.lang.Number) r7
                                        long r4 = r7.longValue()
                                        float r7 = (float) r4
                                        long r4 = r6.$contentLength$inlined
                                        float r2 = (float) r4
                                        float r7 = r7 / r2
                                        r2 = 100
                                        float r2 = (float) r2
                                        float r7 = r7 * r2
                                        int r7 = a.a.U(r7)
                                        java.lang.Integer r2 = new java.lang.Integer
                                        r2.<init>(r7)
                                        r0.label = r3
                                        java.lang.Object r7 = r8.emit(r2, r0)
                                        if (r7 != r1) goto L55
                                        return r1
                                    L55:
                                        q5.x r7 = q5.x.f13520a
                                        return r7
                                    */
                                    throw new UnsupportedOperationException("Method not decompiled: com.unity3d.services.core.network.core.OkHttp3Client$makeRequest$2$1$onResponse$$inlined$map$1.AnonymousClass2.emit(java.lang.Object, v5.c):java.lang.Object");
                                }
                            }

                            @Override // t6.e
                            public Object collect(t6.f fVar2, c cVar2) {
                                Object objCollect = eVar.collect(new AnonymousClass2(fVar2, jContentLength), cVar2);
                                return objCollect == a.f17774a ? objCollect : x.f13520a;
                            }
                        }, new OkHttp3Client$makeRequest$2$1$onResponse$downloadProgressLoggingJob$3(httpRequest, null)), c0.b(this.dispatchers.getIo()));
                    } else {
                        u1VarO = null;
                    }
                    l7.l lVarSource = responseBodyBody.source();
                    OkHttp3Client$makeRequest$2$1$onResponse$1 okHttp3Client$makeRequest$2$1$onResponse$1 = new OkHttp3Client$makeRequest$2$1$onResponse$1(lVarSource, i0VarB != null ? i0VarB.f12865b : jVar);
                    m6.a aVar2 = new m6.a(new c6.i(okHttp3Client$makeRequest$2$1$onResponse$1, new androidx.camera.core.impl.utils.a(okHttp3Client$makeRequest$2$1$onResponse$1, 14)));
                    OkHttp3Client$makeRequest$2$1$onResponse$2 predicate = OkHttp3Client$makeRequest$2$1$onResponse$2.INSTANCE;
                    k.e(predicate, "predicate");
                    c6.g gVar = new c6.g(new m6.f(aVar2, predicate, 1), (byte) 0);
                    while (gVar.hasNext()) {
                        jLongValue2 += ((Number) gVar.next()).longValue();
                        if (i0VarB != null) {
                            i0VarB.B();
                        }
                        if (d1VarC != null) {
                            d1VarC.i(null, Long.valueOf(jLongValue2));
                        }
                    }
                    if (i0VarB != null) {
                        i0VarB.close();
                    }
                    if (u1VarO != null) {
                        u1VarO.a(null);
                    }
                    lVarSource.close();
                    responseBodyBody.close();
                    lVar.resumeWith(new OkHttp3Client.RequestComplete(response, i0VarB != null ? file : jVar.o(jVar.f12868b)));
                } catch (IOException e) {
                    lVar.resumeWith(q.M(e));
                }
            }
        });
        Object objP = lVar.p();
        a aVar = a.f17774a;
        return objP;
    }

    @Override // com.unity3d.services.core.network.core.HttpClient
    public Object execute(HttpRequest httpRequest, c<? super HttpResponse> cVar) {
        return c0.H(new AnonymousClass2(httpRequest, null), this.dispatchers.getIo(), cVar);
    }

    @Override // com.unity3d.services.core.network.core.HttpClient
    public HttpResponse executeBlocking(HttpRequest request) {
        k.e(request, "request");
        return (HttpResponse) c0.A(this.dispatchers.getIo(), new AnonymousClass1(request, null));
    }
}
