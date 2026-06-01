package com.onesignal.core.internal.http.impl;

import com.onesignal.common.JSONUtils;
import com.onesignal.core.internal.config.ConfigModelStore;
import com.onesignal.core.internal.device.IInstallIdService;
import com.onesignal.core.internal.http.HttpResponse;
import com.onesignal.core.internal.http.IHttpClient;
import com.onesignal.core.internal.preferences.IPreferencesService;
import com.onesignal.core.internal.time.ITime;
import com.onesignal.debug.internal.logging.Logging;
import com.unity3d.ads.gatewayclient.CommonGatewayClient;
import e6.p;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.List;
import java.util.Map;
import kotlin.jvm.internal.f;
import kotlin.jvm.internal.k;
import n6.t;
import org.json.JSONObject;
import q5.x;
import q6.a0;
import r2.q;
import r5.l;
import w5.a;
import x5.c;
import x5.e;
import x5.i;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes5.dex */
public final class HttpClient implements IHttpClient {
    public static final Companion Companion = new Companion(null);
    private static final String OS_ACCEPT_HEADER = "application/vnd.onesignal.v1+json";
    private static final String OS_API_VERSION = "1";
    private static final int THREAD_ID = 10000;
    private final ConfigModelStore _configModelStore;
    private final IHttpConnectionFactory _connectionFactory;
    private final IInstallIdService _installIdService;
    private final IPreferencesService _prefs;
    private final ITime _time;
    private long delayNewRequestsUntil;

    /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
    public static final class Companion {
        public /* synthetic */ Companion(f fVar) {
            this();
        }

        private Companion() {
        }
    }

    /* JADX INFO: renamed from: com.onesignal.core.internal.http.impl.HttpClient$makeRequest$1, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
    @e(c = "com.onesignal.core.internal.http.impl.HttpClient", f = "HttpClient.kt", l = {89, 92}, m = "makeRequest")
    public static final class AnonymousClass1 extends c {
        int I$0;
        Object L$0;
        Object L$1;
        Object L$2;
        Object L$3;
        Object L$4;
        int label;
        /* synthetic */ Object result;

        public AnonymousClass1(v5.c<? super AnonymousClass1> cVar) {
            super(cVar);
        }

        @Override // x5.a
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return HttpClient.this.makeRequest(null, null, null, 0, null, this);
        }
    }

    /* JADX INFO: renamed from: com.onesignal.core.internal.http.impl.HttpClient$makeRequest$2, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
    @e(c = "com.onesignal.core.internal.http.impl.HttpClient$makeRequest$2", f = "HttpClient.kt", l = {93}, m = "invokeSuspend")
    public static final class AnonymousClass2 extends i implements p {
        final /* synthetic */ OptionalHeaders $headers;
        final /* synthetic */ JSONObject $jsonBody;
        final /* synthetic */ String $method;
        final /* synthetic */ int $timeout;
        final /* synthetic */ String $url;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass2(String str, String str2, JSONObject jSONObject, int i2, OptionalHeaders optionalHeaders, v5.c<? super AnonymousClass2> cVar) {
            super(2, cVar);
            this.$url = str;
            this.$method = str2;
            this.$jsonBody = jSONObject;
            this.$timeout = i2;
            this.$headers = optionalHeaders;
        }

        @Override // x5.a
        public final v5.c<x> create(Object obj, v5.c<?> cVar) {
            return HttpClient.this.new AnonymousClass2(this.$url, this.$method, this.$jsonBody, this.$timeout, this.$headers, cVar);
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
            HttpClient httpClient = HttpClient.this;
            String str = this.$url;
            String str2 = this.$method;
            JSONObject jSONObject = this.$jsonBody;
            int i8 = this.$timeout;
            OptionalHeaders optionalHeaders = this.$headers;
            this.label = 1;
            Object objMakeRequestIODispatcher = httpClient.makeRequestIODispatcher(str, str2, jSONObject, i8, optionalHeaders, this);
            return objMakeRequestIODispatcher == aVar ? aVar : objMakeRequestIODispatcher;
        }

        @Override // e6.p
        public final Object invoke(a0 a0Var, v5.c<? super HttpResponse> cVar) {
            return ((AnonymousClass2) create(a0Var, cVar)).invokeSuspend(x.f13520a);
        }
    }

    /* JADX INFO: renamed from: com.onesignal.core.internal.http.impl.HttpClient$makeRequestIODispatcher$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
    @e(c = "com.onesignal.core.internal.http.impl.HttpClient", f = "HttpClient.kt", l = {286}, m = "makeRequestIODispatcher")
    public static final class C26981 extends c {
        Object L$0;
        int label;
        /* synthetic */ Object result;

        public C26981(v5.c<? super C26981> cVar) {
            super(cVar);
        }

        @Override // x5.a
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return HttpClient.this.makeRequestIODispatcher(null, null, null, 0, null, this);
        }
    }

    public HttpClient(IHttpConnectionFactory _connectionFactory, IPreferencesService _prefs, ConfigModelStore _configModelStore, ITime _time, IInstallIdService _installIdService) {
        k.e(_connectionFactory, "_connectionFactory");
        k.e(_prefs, "_prefs");
        k.e(_configModelStore, "_configModelStore");
        k.e(_time, "_time");
        k.e(_installIdService, "_installIdService");
        this._connectionFactory = _connectionFactory;
        this._prefs = _prefs;
        this._configModelStore = _configModelStore;
        this._time = _time;
        this._installIdService = _installIdService;
    }

    private final int getThreadTimeout(int i2) {
        return i2 + 5000;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void logHTTPSent(String str, URL url, JSONObject jSONObject, Map<String, ? extends List<String>> map) {
        String strC1 = l.c1(map.entrySet(), null, null, null, null, 63);
        if (str == null) {
            str = "GET";
        }
        String unescapedEUIDString = jSONObject != null ? JSONUtils.INSTANCE.toUnescapedEUIDString(jSONObject) : null;
        StringBuilder sb = new StringBuilder("HttpClient: Request Sent = ");
        sb.append(str);
        sb.append(' ');
        sb.append(url);
        sb.append(" - Body: ");
        Logging.debug$default(a1.a.s(sb, unescapedEUIDString, " - Headers: ", strC1), null, 2, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:41:0x010a A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:42:0x010b A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:7:0x001b  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object makeRequest(java.lang.String r22, java.lang.String r23, org.json.JSONObject r24, int r25, com.onesignal.core.internal.http.impl.OptionalHeaders r26, v5.c<? super com.onesignal.core.internal.http.HttpResponse> r27) throws java.lang.Throwable {
        /*
            Method dump skipped, instruction units count: 315
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.onesignal.core.internal.http.impl.HttpClient.makeRequest(java.lang.String, java.lang.String, org.json.JSONObject, int, com.onesignal.core.internal.http.impl.OptionalHeaders, v5.c):java.lang.Object");
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0015  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object makeRequestIODispatcher(java.lang.String r14, java.lang.String r15, org.json.JSONObject r16, int r17, com.onesignal.core.internal.http.impl.OptionalHeaders r18, v5.c<? super com.onesignal.core.internal.http.HttpResponse> r19) throws java.lang.Throwable {
        /*
            r13 = this;
            r0 = r19
            boolean r1 = r0 instanceof com.onesignal.core.internal.http.impl.HttpClient.C26981
            if (r1 == 0) goto L15
            r1 = r0
            com.onesignal.core.internal.http.impl.HttpClient$makeRequestIODispatcher$1 r1 = (com.onesignal.core.internal.http.impl.HttpClient.C26981) r1
            int r2 = r1.label
            r3 = -2147483648(0xffffffff80000000, float:-0.0)
            r4 = r2 & r3
            if (r4 == 0) goto L15
            int r2 = r2 - r3
            r1.label = r2
            goto L1a
        L15:
            com.onesignal.core.internal.http.impl.HttpClient$makeRequestIODispatcher$1 r1 = new com.onesignal.core.internal.http.impl.HttpClient$makeRequestIODispatcher$1
            r1.<init>(r0)
        L1a:
            java.lang.Object r0 = r1.result
            w5.a r11 = w5.a.f17774a
            int r2 = r1.label
            r12 = 1
            if (r2 == 0) goto L35
            if (r2 != r12) goto L2d
            java.lang.Object r1 = r1.L$0
            kotlin.jvm.internal.a0 r1 = (kotlin.jvm.internal.a0) r1
            r2.q.z0(r0)
            goto L63
        L2d:
            java.lang.IllegalStateException r0 = new java.lang.IllegalStateException
            java.lang.String r1 = "call to 'resume' before 'invoke' with coroutine"
            r0.<init>(r1)
            throw r0
        L35:
            r2.q.z0(r0)
            kotlin.jvm.internal.a0 r9 = new kotlin.jvm.internal.a0
            r9.<init>()
            x6.e r0 = q6.m0.f13566a
            x6.d r0 = x6.d.f17810a
            com.onesignal.core.internal.http.impl.HttpClient$makeRequestIODispatcher$job$1 r2 = new com.onesignal.core.internal.http.impl.HttpClient$makeRequestIODispatcher$job$1
            r10 = 0
            r3 = r13
            r4 = r14
            r7 = r15
            r6 = r16
            r5 = r17
            r8 = r18
            r2.<init>(r3, r4, r5, r6, r7, r8, r9, r10)
            r3 = 2
            q6.z0 r4 = q6.z0.f13606a
            q6.u1 r0 = q6.c0.u(r4, r0, r2, r3)
            r1.L$0 = r9
            r1.label = r12
            java.lang.Object r0 = r0.M(r1)
            if (r0 != r11) goto L62
            return r11
        L62:
            r1 = r9
        L63:
            java.lang.Object r0 = r1.f12717a
            kotlin.jvm.internal.k.b(r0)
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.onesignal.core.internal.http.impl.HttpClient.makeRequestIODispatcher(java.lang.String, java.lang.String, org.json.JSONObject, int, com.onesignal.core.internal.http.impl.OptionalHeaders, v5.c):java.lang.Object");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Integer retryAfterFromResponse(HttpURLConnection httpURLConnection) {
        String headerField = httpURLConnection.getHeaderField(CommonGatewayClient.HEADER_RETRY_AFTER);
        if (headerField != null) {
            Logging.debug$default("HttpClient: Response Retry-After: ".concat(headerField), null, 2, null);
            Integer numO0 = t.o0(headerField);
            return Integer.valueOf(numO0 != null ? numO0.intValue() : this._configModelStore.getModel().getHttpRetryAfterParseFailFallback());
        }
        if (httpURLConnection.getResponseCode() == 429) {
            return Integer.valueOf(this._configModelStore.getModel().getHttpRetryAfterParseFailFallback());
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Integer retryLimitFromResponse(HttpURLConnection httpURLConnection) {
        String headerField = httpURLConnection.getHeaderField("OneSignal-Retry-Limit");
        if (headerField == null) {
            return null;
        }
        Logging.debug$default("HttpClient: Response OneSignal-Retry-Limit: ".concat(headerField), null, 2, null);
        return t.o0(headerField);
    }

    @Override // com.onesignal.core.internal.http.IHttpClient
    public Object delete(String str, OptionalHeaders optionalHeaders, v5.c<? super HttpResponse> cVar) {
        return makeRequest(str, "DELETE", null, this._configModelStore.getModel().getHttpTimeout(), optionalHeaders, cVar);
    }

    @Override // com.onesignal.core.internal.http.IHttpClient
    public Object get(String str, OptionalHeaders optionalHeaders, v5.c<? super HttpResponse> cVar) {
        return makeRequest(str, null, null, this._configModelStore.getModel().getHttpGetTimeout(), optionalHeaders, cVar);
    }

    @Override // com.onesignal.core.internal.http.IHttpClient
    public Object patch(String str, JSONObject jSONObject, OptionalHeaders optionalHeaders, v5.c<? super HttpResponse> cVar) {
        return makeRequest(str, "PATCH", jSONObject, this._configModelStore.getModel().getHttpTimeout(), optionalHeaders, cVar);
    }

    @Override // com.onesignal.core.internal.http.IHttpClient
    public Object post(String str, JSONObject jSONObject, OptionalHeaders optionalHeaders, v5.c<? super HttpResponse> cVar) {
        return makeRequest(str, "POST", jSONObject, this._configModelStore.getModel().getHttpTimeout(), optionalHeaders, cVar);
    }

    @Override // com.onesignal.core.internal.http.IHttpClient
    public Object put(String str, JSONObject jSONObject, OptionalHeaders optionalHeaders, v5.c<? super HttpResponse> cVar) {
        return makeRequest(str, "PUT", jSONObject, this._configModelStore.getModel().getHttpTimeout(), optionalHeaders, cVar);
    }
}
