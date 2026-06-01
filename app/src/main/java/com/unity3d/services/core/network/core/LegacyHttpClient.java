package com.unity3d.services.core.network.core;

import com.unity3d.services.core.domain.ISDKDispatchers;
import com.unity3d.services.core.network.mapper.HttpRequestToWebRequestKt;
import com.unity3d.services.core.network.model.HttpRequest;
import com.unity3d.services.core.network.model.HttpResponse;
import com.unity3d.services.core.request.WebRequest;
import e6.p;
import java.util.List;
import java.util.Map;
import kotlin.jvm.internal.f;
import kotlin.jvm.internal.k;
import q5.x;
import q6.a0;
import q6.c0;
import r2.q;
import v5.c;
import w5.a;
import x5.e;
import x5.i;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes5.dex */
public final class LegacyHttpClient implements HttpClient {
    public static final Companion Companion = new Companion(null);
    private static final String NETWORK_CLIENT_LEGACY = "legacy";
    private final ISDKDispatchers dispatchers;

    /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
    public static final class Companion {
        public /* synthetic */ Companion(f fVar) {
            this();
        }

        private Companion() {
        }
    }

    /* JADX INFO: renamed from: com.unity3d.services.core.network.core.LegacyHttpClient$execute$2, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
    @e(c = "com.unity3d.services.core.network.core.LegacyHttpClient$execute$2", f = "LegacyHttpClient.kt", l = {}, m = "invokeSuspend")
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
            return new AnonymousClass2(this.$request, cVar);
        }

        @Override // x5.a
        public final Object invokeSuspend(Object obj) throws Exception {
            a aVar = a.f17774a;
            if (this.label != 0) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            q.z0(obj);
            WebRequest webRequest = HttpRequestToWebRequestKt.toWebRequest(this.$request);
            String strMakeRequest = webRequest.makeRequest();
            int responseCode = webRequest.getResponseCode();
            Map<String, List<String>> headers = webRequest.getHeaders();
            String string = webRequest.getUrl().toString();
            if (strMakeRequest == null) {
                strMakeRequest = "";
            }
            k.d(headers, "headers");
            k.d(string, "toString()");
            return new HttpResponse(strMakeRequest, responseCode, headers, string, null, LegacyHttpClient.NETWORK_CLIENT_LEGACY, 0L, 80, null);
        }

        @Override // e6.p
        public final Object invoke(a0 a0Var, c<? super HttpResponse> cVar) {
            return ((AnonymousClass2) create(a0Var, cVar)).invokeSuspend(x.f13520a);
        }
    }

    /* JADX INFO: renamed from: com.unity3d.services.core.network.core.LegacyHttpClient$executeBlocking$1, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
    @e(c = "com.unity3d.services.core.network.core.LegacyHttpClient$executeBlocking$1", f = "LegacyHttpClient.kt", l = {26}, m = "invokeSuspend")
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
            return LegacyHttpClient.this.new AnonymousClass1(this.$request, cVar);
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
            LegacyHttpClient legacyHttpClient = LegacyHttpClient.this;
            HttpRequest httpRequest = this.$request;
            this.label = 1;
            Object objExecute = legacyHttpClient.execute(httpRequest, this);
            return objExecute == aVar ? aVar : objExecute;
        }

        @Override // e6.p
        public final Object invoke(a0 a0Var, c<? super HttpResponse> cVar) {
            return ((AnonymousClass1) create(a0Var, cVar)).invokeSuspend(x.f13520a);
        }
    }

    public LegacyHttpClient(ISDKDispatchers dispatchers) {
        k.e(dispatchers, "dispatchers");
        this.dispatchers = dispatchers;
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
