package okhttp3;

import java.net.URL;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.jvm.internal.b0;
import kotlin.jvm.internal.d0;
import kotlin.jvm.internal.e;
import kotlin.jvm.internal.f;
import kotlin.jvm.internal.k;
import n6.t;
import okhttp3.Headers;
import okhttp3.HttpUrl;
import okhttp3.internal._UtilCommonKt;
import okhttp3.internal.http.GzipRequestBody;
import okhttp3.internal.http.HttpMethod;
import q5.i;
import r5.m;
import r5.s;
import r5.x;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes5.dex */
public final class Request {
    private final RequestBody body;
    private final HttpUrl cacheUrlOverride;
    private final Headers headers;
    private CacheControl lazyCacheControl;
    private final String method;
    private final Map<l6.c, Object> tags;
    private final HttpUrl url;

    /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
    public static class Builder {
        private RequestBody body;
        private HttpUrl cacheUrlOverride;
        private Headers.Builder headers;
        private String method;
        private Map<l6.c, ? extends Object> tags;
        private HttpUrl url;

        public Builder() {
            this.tags = s.f13639a;
            this.method = "GET";
            this.headers = new Headers.Builder();
        }

        private final String canonicalUrl(String str) {
            if (t.n0(str, "ws:", true)) {
                String strSubstring = str.substring(3);
                k.d(strSubstring, "substring(...)");
                return "http:".concat(strSubstring);
            }
            if (!t.n0(str, "wss:", true)) {
                return str;
            }
            String strSubstring2 = str.substring(4);
            k.d(strSubstring2, "substring(...)");
            return "https:".concat(strSubstring2);
        }

        public static /* synthetic */ Builder delete$default(Builder builder, RequestBody requestBody, int i2, Object obj) {
            if (obj != null) {
                throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: delete");
            }
            if ((i2 & 1) != 0) {
                requestBody = RequestBody.EMPTY;
            }
            return builder.delete(requestBody);
        }

        public Builder addHeader(String name, String value) {
            k.e(name, "name");
            k.e(value, "value");
            this.headers.add(name, value);
            return this;
        }

        public Request build() {
            return new Request(this);
        }

        public Builder cacheControl(CacheControl cacheControl) {
            k.e(cacheControl, "cacheControl");
            String string = cacheControl.toString();
            return string.length() == 0 ? removeHeader("Cache-Control") : header("Cache-Control", string);
        }

        public final Builder cacheUrlOverride(HttpUrl httpUrl) {
            this.cacheUrlOverride = httpUrl;
            return this;
        }

        public final Builder delete() {
            return delete$default(this, null, 1, null);
        }

        public Builder get() {
            return method("GET", null);
        }

        public final RequestBody getBody$okhttp() {
            return this.body;
        }

        public final HttpUrl getCacheUrlOverride$okhttp() {
            return this.cacheUrlOverride;
        }

        public final Headers.Builder getHeaders$okhttp() {
            return this.headers;
        }

        public final String getMethod$okhttp() {
            return this.method;
        }

        public final Map<l6.c, Object> getTags$okhttp() {
            return this.tags;
        }

        public final HttpUrl getUrl$okhttp() {
            return this.url;
        }

        public final Builder gzip() {
            RequestBody requestBody = this.body;
            if (requestBody == null) {
                throw new IllegalStateException("cannot gzip a request that has no body");
            }
            String str = this.headers.get("Content-Encoding");
            if (str != null) {
                throw new IllegalStateException(a1.a.l("Content-Encoding already set: ", str).toString());
            }
            this.headers.add("Content-Encoding", "gzip");
            this.body = new GzipRequestBody(requestBody);
            return this;
        }

        public Builder head() {
            return method("HEAD", null);
        }

        public Builder header(String name, String value) {
            k.e(name, "name");
            k.e(value, "value");
            this.headers.set(name, value);
            return this;
        }

        public Builder headers(Headers headers) {
            k.e(headers, "headers");
            this.headers = headers.newBuilder();
            return this;
        }

        public Builder method(String method, RequestBody requestBody) {
            k.e(method, "method");
            if (method.length() <= 0) {
                throw new IllegalArgumentException("method.isEmpty() == true");
            }
            if (requestBody == null) {
                if (HttpMethod.requiresRequestBody(method)) {
                    throw new IllegalArgumentException(a1.a.m("method ", method, " must have a request body.").toString());
                }
            } else if (!HttpMethod.permitsRequestBody(method)) {
                throw new IllegalArgumentException(a1.a.m("method ", method, " must not have a request body.").toString());
            }
            this.method = method;
            this.body = requestBody;
            return this;
        }

        public Builder patch(RequestBody body) {
            k.e(body, "body");
            return method("PATCH", body);
        }

        public Builder post(RequestBody body) {
            k.e(body, "body");
            return method("POST", body);
        }

        public Builder put(RequestBody body) {
            k.e(body, "body");
            return method("PUT", body);
        }

        public final <T> Builder reifiedTag(T t3) {
            k.k();
            throw null;
        }

        public Builder removeHeader(String name) {
            k.e(name, "name");
            this.headers.removeAll(name);
            return this;
        }

        public final void setBody$okhttp(RequestBody requestBody) {
            this.body = requestBody;
        }

        public final void setCacheUrlOverride$okhttp(HttpUrl httpUrl) {
            this.cacheUrlOverride = httpUrl;
        }

        public final void setHeaders$okhttp(Headers.Builder builder) {
            k.e(builder, "<set-?>");
            this.headers = builder;
        }

        public final void setMethod$okhttp(String str) {
            k.e(str, "<set-?>");
            this.method = str;
        }

        public final void setTags$okhttp(Map<l6.c, ? extends Object> map) {
            k.e(map, "<set-?>");
            this.tags = map;
        }

        public final void setUrl$okhttp(HttpUrl httpUrl) {
            this.url = httpUrl;
        }

        public <T> Builder tag(Class<? super T> type, T t3) {
            k.e(type, "type");
            return tag(b0.a(type), t3);
        }

        public Builder url(HttpUrl url) {
            k.e(url, "url");
            this.url = url;
            return this;
        }

        public Builder delete(RequestBody requestBody) {
            return method("DELETE", requestBody);
        }

        public Builder url(String url) {
            k.e(url, "url");
            return url(HttpUrl.Companion.get(canonicalUrl(url)));
        }

        public final <T> Builder tag(l6.c type, T t3) {
            Map mapC;
            k.e(type, "type");
            if (t3 == null) {
                if (!this.tags.isEmpty()) {
                    Map<l6.c, ? extends Object> map = this.tags;
                    k.c(map, "null cannot be cast to non-null type kotlin.collections.MutableMap<kotlin.reflect.KClass<*>, kotlin.Any>");
                    d0.c(map).remove(type);
                }
                return this;
            }
            if (this.tags.isEmpty()) {
                mapC = new LinkedHashMap();
                this.tags = mapC;
            } else {
                Map<l6.c, ? extends Object> map2 = this.tags;
                k.c(map2, "null cannot be cast to non-null type kotlin.collections.MutableMap<kotlin.reflect.KClass<*>, kotlin.Any>");
                mapC = d0.c(map2);
            }
            e eVar = (e) type;
            if (eVar.g(t3)) {
                mapC.put(type, t3);
                return this;
            }
            throw new ClassCastException("Value cannot be cast to " + eVar.e());
        }

        public Builder url(URL url) {
            k.e(url, "url");
            HttpUrl.Companion companion = HttpUrl.Companion;
            String string = url.toString();
            k.d(string, "toString(...)");
            return url(companion.get(string));
        }

        public Builder(Request request) {
            k.e(request, "request");
            Map<l6.c, ? extends Object> map = s.f13639a;
            this.tags = map;
            this.url = request.url();
            this.method = request.method();
            this.body = request.body();
            this.tags = request.getTags$okhttp().isEmpty() ? map : x.o0(request.getTags$okhttp());
            this.headers = request.headers().newBuilder();
            this.cacheUrlOverride = request.cacheUrlOverride();
        }

        public Builder tag(Object obj) {
            return tag(b0.a(Object.class), obj);
        }
    }

    public Request(Builder builder) {
        k.e(builder, "builder");
        HttpUrl url$okhttp = builder.getUrl$okhttp();
        if (url$okhttp == null) {
            throw new IllegalStateException("url == null");
        }
        this.url = url$okhttp;
        this.method = builder.getMethod$okhttp();
        this.headers = builder.getHeaders$okhttp().build();
        this.body = builder.getBody$okhttp();
        this.cacheUrlOverride = builder.getCacheUrlOverride$okhttp();
        this.tags = x.n0(builder.getTags$okhttp());
    }

    /* JADX INFO: renamed from: -deprecated_body, reason: not valid java name */
    public final RequestBody m3578deprecated_body() {
        return this.body;
    }

    /* JADX INFO: renamed from: -deprecated_cacheControl, reason: not valid java name */
    public final CacheControl m3579deprecated_cacheControl() {
        return cacheControl();
    }

    /* JADX INFO: renamed from: -deprecated_headers, reason: not valid java name */
    public final Headers m3580deprecated_headers() {
        return this.headers;
    }

    /* JADX INFO: renamed from: -deprecated_method, reason: not valid java name */
    public final String m3581deprecated_method() {
        return this.method;
    }

    /* JADX INFO: renamed from: -deprecated_url, reason: not valid java name */
    public final HttpUrl m3582deprecated_url() {
        return this.url;
    }

    public final RequestBody body() {
        return this.body;
    }

    public final CacheControl cacheControl() {
        CacheControl cacheControl = this.lazyCacheControl;
        if (cacheControl != null) {
            return cacheControl;
        }
        CacheControl cacheControl2 = CacheControl.Companion.parse(this.headers);
        this.lazyCacheControl = cacheControl2;
        return cacheControl2;
    }

    public final HttpUrl cacheUrlOverride() {
        return this.cacheUrlOverride;
    }

    public final Map<l6.c, Object> getTags$okhttp() {
        return this.tags;
    }

    public final String header(String name) {
        k.e(name, "name");
        return this.headers.get(name);
    }

    public final Headers headers() {
        return this.headers;
    }

    public final boolean isHttps() {
        return this.url.isHttps();
    }

    public final String method() {
        return this.method;
    }

    public final Builder newBuilder() {
        return new Builder(this);
    }

    public final <T> T reifiedTag() {
        k.k();
        throw null;
    }

    public final <T> T tag(Class<? extends T> type) {
        k.e(type, "type");
        return (T) tag(b0.a(type));
    }

    public String toString() {
        StringBuilder sb = new StringBuilder(32);
        sb.append("Request{method=");
        sb.append(this.method);
        sb.append(", url=");
        sb.append(this.url);
        if (this.headers.size() != 0) {
            sb.append(", headers=[");
            int i2 = 0;
            for (i iVar : this.headers) {
                int i8 = i2 + 1;
                if (i2 < 0) {
                    m.K0();
                    throw null;
                }
                i iVar2 = iVar;
                String str = (String) iVar2.f13498a;
                String str2 = (String) iVar2.f13499b;
                if (i2 > 0) {
                    sb.append(", ");
                }
                sb.append(str);
                sb.append(':');
                if (_UtilCommonKt.isSensitiveHeader(str)) {
                    str2 = "██";
                }
                sb.append(str2);
                i2 = i8;
            }
            sb.append(']');
        }
        if (!this.tags.isEmpty()) {
            sb.append(", tags=");
            sb.append(this.tags);
        }
        sb.append('}');
        return sb.toString();
    }

    public final HttpUrl url() {
        return this.url;
    }

    public final List<String> headers(String name) {
        k.e(name, "name");
        return this.headers.values(name);
    }

    public final <T> T tag(l6.c type) {
        k.e(type, "type");
        return (T) a.a.B(type).cast(this.tags.get(type));
    }

    public final Object tag() {
        return tag(b0.a(Object.class));
    }

    public /* synthetic */ Request(HttpUrl httpUrl, Headers headers, String str, RequestBody requestBody, int i2, f fVar) {
        this(httpUrl, (i2 & 2) != 0 ? Headers.Companion.of(new String[0]) : headers, (i2 & 4) != 0 ? "\u0000" : str, (i2 & 8) != 0 ? null : requestBody);
    }

    /* JADX WARN: Illegal instructions before constructor call */
    public Request(HttpUrl url, Headers headers, String method, RequestBody requestBody) {
        k.e(url, "url");
        k.e(headers, "headers");
        k.e(method, "method");
        Builder builderHeaders = new Builder().url(url).headers(headers);
        if (method.equals("\u0000")) {
            if (requestBody != null) {
                method = "POST";
            } else {
                method = "GET";
            }
        }
        this(builderHeaders.method(method, requestBody));
    }
}
