package okhttp3.internal.cache;

import java.io.IOException;
import java.util.concurrent.TimeUnit;
import kotlin.jvm.internal.f;
import kotlin.jvm.internal.k;
import l7.b;
import l7.i0;
import l7.j;
import l7.l;
import l7.n0;
import l7.o0;
import l7.r0;
import n6.t;
import okhttp3.Cache;
import okhttp3.Call;
import okhttp3.EventListener;
import okhttp3.Headers;
import okhttp3.Interceptor;
import okhttp3.Protocol;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.internal.UnreadableResponseBodyKt;
import okhttp3.internal._UtilCommonKt;
import okhttp3.internal._UtilJvmKt;
import okhttp3.internal.cache.CacheStrategy;
import okhttp3.internal.connection.RealCall;
import okhttp3.internal.http.HttpHeaders;
import okhttp3.internal.http.HttpMethod;
import okhttp3.internal.http.RealResponseBody;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes5.dex */
public final class CacheInterceptor implements Interceptor {
    public static final Companion Companion = new Companion(null);
    private final Cache cache;

    /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
    public static final class Companion {
        public /* synthetic */ Companion(f fVar) {
            this();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final Headers combine(Headers headers, Headers headers2) {
            Headers.Builder builder = new Headers.Builder();
            int size = headers.size();
            for (int i2 = 0; i2 < size; i2++) {
                String strName = headers.name(i2);
                String strValue = headers.value(i2);
                if ((!"Warning".equalsIgnoreCase(strName) || !t.n0(strValue, "1", false)) && (isContentSpecificHeader(strName) || !isEndToEnd(strName) || headers2.get(strName) == null)) {
                    builder.addLenient$okhttp(strName, strValue);
                }
            }
            int size2 = headers2.size();
            for (int i8 = 0; i8 < size2; i8++) {
                String strName2 = headers2.name(i8);
                if (!isContentSpecificHeader(strName2) && isEndToEnd(strName2)) {
                    builder.addLenient$okhttp(strName2, headers2.value(i8));
                }
            }
            return builder.build();
        }

        private final boolean isContentSpecificHeader(String str) {
            return "Content-Length".equalsIgnoreCase(str) || "Content-Encoding".equalsIgnoreCase(str) || "Content-Type".equalsIgnoreCase(str);
        }

        private final boolean isEndToEnd(String str) {
            return ("Connection".equalsIgnoreCase(str) || "Keep-Alive".equalsIgnoreCase(str) || "Proxy-Authenticate".equalsIgnoreCase(str) || "Proxy-Authorization".equalsIgnoreCase(str) || "TE".equalsIgnoreCase(str) || "Trailers".equalsIgnoreCase(str) || "Transfer-Encoding".equalsIgnoreCase(str) || "Upgrade".equalsIgnoreCase(str)) ? false : true;
        }

        private Companion() {
        }
    }

    public CacheInterceptor(Cache cache) {
        this.cache = cache;
    }

    private final Response cacheWritingResponse(final CacheRequest cacheRequest, Response response) throws IOException {
        if (cacheRequest == null) {
            return response;
        }
        n0 n0VarBody = cacheRequest.body();
        final l lVarSource = response.body().source();
        final i0 i0VarB = b.b(n0VarBody);
        o0 o0Var = new o0() { // from class: okhttp3.internal.cache.CacheInterceptor$cacheWritingResponse$cacheWritingSource$1
            private boolean cacheRequestClosed;

            @Override // java.io.Closeable, java.lang.AutoCloseable
            public void close() throws IOException {
                if (!this.cacheRequestClosed && !_UtilJvmKt.discard(this, 100, TimeUnit.MILLISECONDS)) {
                    this.cacheRequestClosed = true;
                    cacheRequest.abort();
                }
                lVarSource.close();
            }

            @Override // l7.o0
            public long read(j sink, long j) throws IOException {
                k.e(sink, "sink");
                try {
                    long j3 = lVarSource.read(sink, j);
                    if (j3 == -1) {
                        if (!this.cacheRequestClosed) {
                            this.cacheRequestClosed = true;
                            i0VarB.close();
                        }
                        return -1L;
                    }
                    sink.g(sink.f12868b - j3, i0VarB.getBuffer(), j3);
                    i0VarB.B();
                    return j3;
                } catch (IOException e) {
                    if (this.cacheRequestClosed) {
                        throw e;
                    }
                    this.cacheRequestClosed = true;
                    cacheRequest.abort();
                    throw e;
                }
            }

            @Override // l7.o0
            public r0 timeout() {
                return lVarSource.timeout();
            }
        };
        return response.newBuilder().body(new RealResponseBody(Response.header$default(response, "Content-Type", null, 2, null), response.body().contentLength(), b.c(o0Var))).build();
    }

    public final Cache getCache$okhttp() {
        return this.cache;
    }

    @Override // okhttp3.Interceptor
    public Response intercept(Interceptor.Chain chain) throws IOException {
        EventListener eventListener$okhttp;
        k.e(chain, "chain");
        Call call = chain.call();
        Cache cache = this.cache;
        Response response = cache != null ? cache.get$okhttp(CacheInterceptorKt.requestForCache(chain.request())) : null;
        CacheStrategy cacheStrategyCompute = new CacheStrategy.Factory(System.currentTimeMillis(), chain.request(), response).compute();
        Request networkRequest = cacheStrategyCompute.getNetworkRequest();
        Response cacheResponse = cacheStrategyCompute.getCacheResponse();
        Cache cache2 = this.cache;
        if (cache2 != null) {
            cache2.trackResponse$okhttp(cacheStrategyCompute);
        }
        RealCall realCall = call instanceof RealCall ? (RealCall) call : null;
        if (realCall == null || (eventListener$okhttp = realCall.getEventListener$okhttp()) == null) {
            eventListener$okhttp = EventListener.NONE;
        }
        if (response != null && cacheResponse == null) {
            _UtilCommonKt.closeQuietly(response.body());
        }
        if (networkRequest == null && cacheResponse == null) {
            Response responseBuild = new Response.Builder().request(chain.request()).protocol(Protocol.HTTP_1_1).code(504).message("Unsatisfiable Request (only-if-cached)").sentRequestAtMillis(-1L).receivedResponseAtMillis(System.currentTimeMillis()).build();
            eventListener$okhttp.satisfactionFailure(call, responseBuild);
            return responseBuild;
        }
        if (networkRequest == null) {
            k.b(cacheResponse);
            Response responseBuild2 = cacheResponse.newBuilder().cacheResponse(UnreadableResponseBodyKt.stripBody(cacheResponse)).build();
            eventListener$okhttp.cacheHit(call, responseBuild2);
            return responseBuild2;
        }
        if (cacheResponse != null) {
            eventListener$okhttp.cacheConditionalHit(call, cacheResponse);
        } else if (this.cache != null) {
            eventListener$okhttp.cacheMiss(call);
        }
        try {
            Response responseProceed = chain.proceed(networkRequest);
            if (responseProceed == null && response != null) {
            }
            if (cacheResponse != null) {
                if (responseProceed != null && responseProceed.code() == 304) {
                    Response responseBuild3 = cacheResponse.newBuilder().headers(Companion.combine(cacheResponse.headers(), responseProceed.headers())).sentRequestAtMillis(responseProceed.sentRequestAtMillis()).receivedResponseAtMillis(responseProceed.receivedResponseAtMillis()).cacheResponse(UnreadableResponseBodyKt.stripBody(cacheResponse)).networkResponse(UnreadableResponseBodyKt.stripBody(responseProceed)).build();
                    responseProceed.body().close();
                    Cache cache3 = this.cache;
                    k.b(cache3);
                    cache3.trackConditionalCacheHit$okhttp();
                    this.cache.update$okhttp(cacheResponse, responseBuild3);
                    eventListener$okhttp.cacheHit(call, responseBuild3);
                    return responseBuild3;
                }
                _UtilCommonKt.closeQuietly(cacheResponse.body());
            }
            k.b(responseProceed);
            Response responseBuild4 = responseProceed.newBuilder().cacheResponse(cacheResponse != null ? UnreadableResponseBodyKt.stripBody(cacheResponse) : null).networkResponse(UnreadableResponseBodyKt.stripBody(responseProceed)).build();
            if (this.cache != null) {
                Request requestRequestForCache = CacheInterceptorKt.requestForCache(networkRequest);
                if (HttpHeaders.promisesBody(responseBuild4) && CacheStrategy.Companion.isCacheable(responseBuild4, requestRequestForCache)) {
                    Response responseCacheWritingResponse = cacheWritingResponse(this.cache.put$okhttp(responseBuild4.newBuilder().request(requestRequestForCache).build()), responseBuild4);
                    if (cacheResponse != null) {
                        eventListener$okhttp.cacheMiss(call);
                    }
                    return responseCacheWritingResponse;
                }
                if (HttpMethod.invalidatesCache(networkRequest.method())) {
                    try {
                        this.cache.remove$okhttp(networkRequest);
                    } catch (IOException unused) {
                    }
                }
            }
            return responseBuild4;
        } finally {
            if (response != null) {
                _UtilCommonKt.closeQuietly(response.body());
            }
        }
    }
}
