package com.unity3d.services.core.network.core;

import com.unity3d.ads.core.data.model.exception.NetworkTimeoutException;
import com.unity3d.ads.core.data.model.exception.UnityAdsNetworkException;
import com.unity3d.services.core.domain.ISDKDispatchers;
import com.unity3d.services.core.network.model.HttpRequest;
import com.unity3d.services.core.network.model.HttpResponse;
import com.unity3d.services.core.network.model.RequestType;
import e6.p;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.jvm.internal.f;
import kotlin.jvm.internal.k;
import n6.m;
import n6.t;
import org.chromium.net.CronetEngine;
import org.chromium.net.CronetException;
import org.chromium.net.NetworkException;
import org.chromium.net.UploadDataProviders;
import org.chromium.net.UrlRequest;
import org.chromium.net.UrlResponseInfo;
import q5.x;
import q6.a0;
import q6.c0;
import q6.j;
import q6.l;
import r2.q;
import v5.c;
import w5.a;
import x5.e;
import x5.i;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes5.dex */
public final class CronetClient implements HttpClient {
    public static final Companion Companion = new Companion(null);
    private static final String MSG_CONNECTION_FAILED = "Network request failed";
    private static final String MSG_CONNECTION_TIMEOUT = "Network request timed out";
    private static final String NETWORK_CLIENT_CRONET = "cronet";
    private final ISDKDispatchers dispatchers;
    private final CronetEngine engine;

    /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
    public static final class Companion {
        public /* synthetic */ Companion(f fVar) {
            this();
        }

        private Companion() {
        }
    }

    /* JADX INFO: renamed from: com.unity3d.services.core.network.core.CronetClient$executeBlocking$1, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
    @e(c = "com.unity3d.services.core.network.core.CronetClient$executeBlocking$1", f = "CronetClient.kt", l = {31}, m = "invokeSuspend")
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
            return CronetClient.this.new AnonymousClass1(this.$request, cVar);
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
            CronetClient cronetClient = CronetClient.this;
            HttpRequest httpRequest = this.$request;
            this.label = 1;
            Object objExecute = cronetClient.execute(httpRequest, this);
            return objExecute == aVar ? aVar : objExecute;
        }

        @Override // e6.p
        public final Object invoke(a0 a0Var, c<? super HttpResponse> cVar) {
            return ((AnonymousClass1) create(a0Var, cVar)).invokeSuspend(x.f13520a);
        }
    }

    public CronetClient(CronetEngine engine, ISDKDispatchers dispatchers) {
        k.e(engine, "engine");
        k.e(dispatchers, "dispatchers");
        this.engine = engine;
        this.dispatchers = dispatchers;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final String buildUrl(HttpRequest httpRequest) {
        return m.G0(m.U0(httpRequest.getBaseURL(), '/') + '/' + m.U0(httpRequest.getPath(), '/'), "/");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final long getContentSize(UrlResponseInfo urlResponseInfo) {
        String str;
        Long lP0;
        List<String> list = urlResponseInfo.getAllHeaders().get("Content-Length");
        if (list == null || (str = list.get(0)) == null || (lP0 = t.p0(str)) == null) {
            return -1L;
        }
        return lP0.longValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final int getPriority(int i2) {
        if (i2 == 0) {
            return 4;
        }
        if (i2 != 1) {
            return i2 != 2 ? 1 : 2;
        }
        return 3;
    }

    @Override // com.unity3d.services.core.network.core.HttpClient
    public Object execute(HttpRequest httpRequest, c<? super HttpResponse> cVar) {
        byte[] bytes;
        final l lVar = new l(1, a.a.I(cVar));
        lVar.r();
        final ISDKDispatchers iSDKDispatchers = this.dispatchers;
        final long readTimeout = httpRequest.getReadTimeout();
        UnityAdsUrlRequestCallback unityAdsUrlRequestCallback = new UnityAdsUrlRequestCallback(iSDKDispatchers, readTimeout) { // from class: com.unity3d.services.core.network.core.CronetClient$execute$2$callback$1
            @Override // com.unity3d.services.core.network.core.UnityAdsUrlRequestCallback, org.chromium.net.UrlRequest.Callback
            public void onCanceled(UrlRequest urlRequest, UrlResponseInfo urlResponseInfo) {
                super.onCanceled(urlRequest, urlResponseInfo);
                lVar.resumeWith(q.M(new NetworkTimeoutException("Network request timed out", null, null, urlResponseInfo != null ? urlResponseInfo.getUrl() : null, urlResponseInfo != null ? urlResponseInfo.getNegotiatedProtocol() : null, null, "cronet", 38, null)));
            }

            @Override // com.unity3d.services.core.network.core.UnityAdsUrlRequestCallback, org.chromium.net.UrlRequest.Callback
            public void onFailed(UrlRequest urlRequest, UrlResponseInfo urlResponseInfo, CronetException cronetException) {
                super.onFailed(urlRequest, urlResponseInfo, cronetException);
                NetworkException networkException = cronetException instanceof NetworkException ? (NetworkException) cronetException : null;
                lVar.resumeWith(q.M(new UnityAdsNetworkException("Network request failed", null, urlResponseInfo != null ? Integer.valueOf(urlResponseInfo.getHttpStatusCode()) : null, urlResponseInfo != null ? urlResponseInfo.getUrl() : null, urlResponseInfo != null ? urlResponseInfo.getNegotiatedProtocol() : null, networkException != null ? Integer.valueOf(networkException.getCronetInternalErrorCode()) : null, "cronet", 2, null)));
            }

            @Override // com.unity3d.services.core.network.core.UnityAdsUrlRequestCallback
            public void onSucceeded(UrlRequest request, UrlResponseInfo info, byte[] bodyBytes) {
                k.e(request, "request");
                k.e(info, "info");
                k.e(bodyBytes, "bodyBytes");
                j jVar = lVar;
                int httpStatusCode = info.getHttpStatusCode();
                Map<String, List<String>> allHeaders = info.getAllHeaders();
                String url = info.getUrl();
                String negotiatedProtocol = info.getNegotiatedProtocol();
                long contentSize = this.getContentSize(info);
                k.d(allHeaders, "allHeaders");
                k.d(url, "url");
                k.d(negotiatedProtocol, "negotiatedProtocol");
                jVar.resumeWith(new HttpResponse(bodyBytes, httpStatusCode, allHeaders, url, negotiatedProtocol, "cronet", contentSize));
            }
        };
        UrlRequest.Builder builderNewUrlRequestBuilder = this.engine.newUrlRequestBuilder(buildUrl(httpRequest), unityAdsUrlRequestCallback, c0.f(this.dispatchers.getIo()));
        for (Map.Entry<String, List<String>> entry : httpRequest.getHeaders().entrySet()) {
            String key = entry.getKey();
            Iterator<T> it = entry.getValue().iterator();
            while (it.hasNext()) {
                builderNewUrlRequestBuilder.addHeader(key, (String) it.next());
            }
        }
        if (httpRequest.getMethod() == RequestType.POST) {
            Object body = httpRequest.getBody();
            if (body instanceof byte[]) {
                bytes = (byte[]) httpRequest.getBody();
            } else if (body instanceof String) {
                bytes = ((String) httpRequest.getBody()).getBytes(n6.a.f13073a);
                k.d(bytes, "this as java.lang.String).getBytes(charset)");
            } else {
                bytes = new byte[0];
            }
            builderNewUrlRequestBuilder.setUploadDataProvider(UploadDataProviders.create(bytes), c0.f(this.dispatchers.getIo()));
        }
        UrlRequest req = builderNewUrlRequestBuilder.setHttpMethod(httpRequest.getMethod().toString()).setPriority(getPriority(httpRequest.getPriority())).build();
        lVar.t(new CronetClient$execute$2$2(req));
        k.d(req, "req");
        unityAdsUrlRequestCallback.startTimer(req);
        req.start();
        Object objP = lVar.p();
        a aVar = a.f17774a;
        return objP;
    }

    @Override // com.unity3d.services.core.network.core.HttpClient
    public HttpResponse executeBlocking(HttpRequest request) {
        k.e(request, "request");
        return (HttpResponse) c0.A(this.dispatchers.getIo(), new AnonymousClass1(request, null));
    }

    public final void shutdown() {
        this.engine.shutdown();
    }
}
