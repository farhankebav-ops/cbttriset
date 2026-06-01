package okhttp3.internal.http;

import com.ironsource.G5;
import java.io.IOException;
import java.util.List;
import kotlin.jvm.internal.k;
import l7.b;
import l7.z;
import okhttp3.Cookie;
import okhttp3.CookieJar;
import okhttp3.Interceptor;
import okhttp3.MediaType;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;
import okhttp3.ResponseBody;
import okhttp3.internal._UtilCommonKt;
import okhttp3.internal._UtilJvmKt;
import r5.m;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes.dex */
public final class BridgeInterceptor implements Interceptor {
    private final CookieJar cookieJar;

    public BridgeInterceptor(CookieJar cookieJar) {
        k.e(cookieJar, "cookieJar");
        this.cookieJar = cookieJar;
    }

    private final String cookieHeader(List<Cookie> list) {
        StringBuilder sb = new StringBuilder();
        int i2 = 0;
        for (Object obj : list) {
            int i8 = i2 + 1;
            if (i2 < 0) {
                m.K0();
                throw null;
            }
            Cookie cookie = (Cookie) obj;
            if (i2 > 0) {
                sb.append("; ");
            }
            sb.append(cookie.name());
            sb.append(G5.T);
            sb.append(cookie.value());
            i2 = i8;
        }
        return sb.toString();
    }

    @Override // okhttp3.Interceptor
    public Response intercept(Interceptor.Chain chain) throws IOException {
        ResponseBody responseBodyBody;
        k.e(chain, "chain");
        Request request = chain.request();
        Request.Builder builderNewBuilder = request.newBuilder();
        RequestBody requestBodyBody = request.body();
        if (requestBodyBody != null) {
            MediaType mediaTypeContentType = requestBodyBody.contentType();
            if (mediaTypeContentType != null) {
                builderNewBuilder.header("Content-Type", mediaTypeContentType.toString());
            }
            long jContentLength = requestBodyBody.contentLength();
            if (jContentLength != -1) {
                builderNewBuilder.header("Content-Length", String.valueOf(jContentLength));
                builderNewBuilder.removeHeader("Transfer-Encoding");
            } else {
                builderNewBuilder.header("Transfer-Encoding", "chunked");
                builderNewBuilder.removeHeader("Content-Length");
            }
        }
        boolean z2 = true;
        if (request.header("Host") == null) {
            builderNewBuilder.header("Host", _UtilJvmKt.toHostHeader$default(request.url(), false, 1, null));
        }
        if (request.header("Connection") == null) {
            builderNewBuilder.header("Connection", "Keep-Alive");
        }
        if (request.header("Accept-Encoding") == null && request.header("Range") == null) {
            builderNewBuilder.header("Accept-Encoding", "gzip");
        } else {
            z2 = false;
        }
        List<Cookie> listLoadForRequest = this.cookieJar.loadForRequest(request.url());
        if (!listLoadForRequest.isEmpty()) {
            builderNewBuilder.header("Cookie", cookieHeader(listLoadForRequest));
        }
        if (request.header("User-Agent") == null) {
            builderNewBuilder.header("User-Agent", _UtilCommonKt.USER_AGENT);
        }
        Request requestBuild = builderNewBuilder.build();
        Response responseProceed = chain.proceed(requestBuild);
        HttpHeaders.receiveHeaders(this.cookieJar, requestBuild.url(), responseProceed.headers());
        Response.Builder builderRequest = responseProceed.newBuilder().request(requestBuild);
        if (z2 && "gzip".equalsIgnoreCase(Response.header$default(responseProceed, "Content-Encoding", null, 2, null)) && HttpHeaders.promisesBody(responseProceed) && (responseBodyBody = responseProceed.body()) != null) {
            z zVar = new z(responseBodyBody.source());
            builderRequest.headers(responseProceed.headers().newBuilder().removeAll("Content-Encoding").removeAll("Content-Length").build());
            builderRequest.body(new RealResponseBody(Response.header$default(responseProceed, "Content-Type", null, 2, null), -1L, b.c(zVar)));
        }
        return builderRequest.build();
    }
}
