package com.unity3d.ads.network.model;

import androidx.camera.core.processing.util.a;
import com.ironsource.adqualitysdk.sdk.i.a0;
import com.unity3d.ads.network.model.HttpBody;
import java.util.List;
import java.util.Map;
import kotlin.jvm.internal.f;
import kotlin.jvm.internal.k;
import r5.s;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes5.dex */
public final class HttpRequest {
    public static final Companion Companion = new Companion(null);
    private static final String DEFAULT_SCHEME = "https";
    private static final int DEFAULT_TIMEOUT = 30000;
    private final String baseURL;
    private final HttpBody body;
    private final int callTimeout;
    private final int connectTimeout;
    private final Map<String, List<String>> headers;
    private final RequestType method;
    private final Map<String, String> parameters;
    private final String path;
    private final Integer port;
    private final int readTimeout;
    private final String scheme;
    private final int writeTimeout;

    /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
    public static final class Companion {
        public /* synthetic */ Companion(f fVar) {
            this();
        }

        private Companion() {
        }
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public HttpRequest(String baseURL) {
        this(baseURL, null, null, null, null, null, null, null, 0, 0, 0, 0, 4094, null);
        k.e(baseURL, "baseURL");
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ HttpRequest copy$default(HttpRequest httpRequest, String str, String str2, RequestType requestType, HttpBody httpBody, Map map, Map map2, String str3, Integer num, int i2, int i8, int i9, int i10, int i11, Object obj) {
        if ((i11 & 1) != 0) {
            str = httpRequest.baseURL;
        }
        if ((i11 & 2) != 0) {
            str2 = httpRequest.path;
        }
        if ((i11 & 4) != 0) {
            requestType = httpRequest.method;
        }
        if ((i11 & 8) != 0) {
            httpBody = httpRequest.body;
        }
        if ((i11 & 16) != 0) {
            map = httpRequest.headers;
        }
        if ((i11 & 32) != 0) {
            map2 = httpRequest.parameters;
        }
        if ((i11 & 64) != 0) {
            str3 = httpRequest.scheme;
        }
        if ((i11 & 128) != 0) {
            num = httpRequest.port;
        }
        if ((i11 & 256) != 0) {
            i2 = httpRequest.connectTimeout;
        }
        if ((i11 & 512) != 0) {
            i8 = httpRequest.readTimeout;
        }
        if ((i11 & 1024) != 0) {
            i9 = httpRequest.writeTimeout;
        }
        if ((i11 & 2048) != 0) {
            i10 = httpRequest.callTimeout;
        }
        int i12 = i9;
        int i13 = i10;
        int i14 = i2;
        int i15 = i8;
        String str4 = str3;
        Integer num2 = num;
        Map map3 = map;
        Map map4 = map2;
        return httpRequest.copy(str, str2, requestType, httpBody, map3, map4, str4, num2, i14, i15, i12, i13);
    }

    public final String component1() {
        return this.baseURL;
    }

    public final int component10() {
        return this.readTimeout;
    }

    public final int component11() {
        return this.writeTimeout;
    }

    public final int component12() {
        return this.callTimeout;
    }

    public final String component2() {
        return this.path;
    }

    public final RequestType component3() {
        return this.method;
    }

    public final HttpBody component4() {
        return this.body;
    }

    public final Map<String, List<String>> component5() {
        return this.headers;
    }

    public final Map<String, String> component6() {
        return this.parameters;
    }

    public final String component7() {
        return this.scheme;
    }

    public final Integer component8() {
        return this.port;
    }

    public final int component9() {
        return this.connectTimeout;
    }

    public final HttpRequest copy(String baseURL, String path, RequestType method, HttpBody body, Map<String, ? extends List<String>> headers, Map<String, String> parameters, String scheme, Integer num, int i2, int i8, int i9, int i10) {
        k.e(baseURL, "baseURL");
        k.e(path, "path");
        k.e(method, "method");
        k.e(body, "body");
        k.e(headers, "headers");
        k.e(parameters, "parameters");
        k.e(scheme, "scheme");
        return new HttpRequest(baseURL, path, method, body, headers, parameters, scheme, num, i2, i8, i9, i10);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof HttpRequest)) {
            return false;
        }
        HttpRequest httpRequest = (HttpRequest) obj;
        return k.a(this.baseURL, httpRequest.baseURL) && k.a(this.path, httpRequest.path) && this.method == httpRequest.method && k.a(this.body, httpRequest.body) && k.a(this.headers, httpRequest.headers) && k.a(this.parameters, httpRequest.parameters) && k.a(this.scheme, httpRequest.scheme) && k.a(this.port, httpRequest.port) && this.connectTimeout == httpRequest.connectTimeout && this.readTimeout == httpRequest.readTimeout && this.writeTimeout == httpRequest.writeTimeout && this.callTimeout == httpRequest.callTimeout;
    }

    public final String getBaseURL() {
        return this.baseURL;
    }

    public final HttpBody getBody() {
        return this.body;
    }

    public final int getCallTimeout() {
        return this.callTimeout;
    }

    public final int getConnectTimeout() {
        return this.connectTimeout;
    }

    public final Map<String, List<String>> getHeaders() {
        return this.headers;
    }

    public final RequestType getMethod() {
        return this.method;
    }

    public final Map<String, String> getParameters() {
        return this.parameters;
    }

    public final String getPath() {
        return this.path;
    }

    public final Integer getPort() {
        return this.port;
    }

    public final int getReadTimeout() {
        return this.readTimeout;
    }

    public final String getScheme() {
        return this.scheme;
    }

    public final int getWriteTimeout() {
        return this.writeTimeout;
    }

    public int hashCode() {
        int iB = a.b((this.parameters.hashCode() + ((this.headers.hashCode() + ((this.body.hashCode() + ((this.method.hashCode() + a.b(this.baseURL.hashCode() * 31, 31, this.path)) * 31)) * 31)) * 31)) * 31, 31, this.scheme);
        Integer num = this.port;
        return ((((((((iB + (num == null ? 0 : num.hashCode())) * 31) + this.connectTimeout) * 31) + this.readTimeout) * 31) + this.writeTimeout) * 31) + this.callTimeout;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("HttpRequest(baseURL=");
        sb.append(this.baseURL);
        sb.append(", path=");
        sb.append(this.path);
        sb.append(", method=");
        sb.append(this.method);
        sb.append(", body=");
        sb.append(this.body);
        sb.append(", headers=");
        sb.append(this.headers);
        sb.append(", parameters=");
        sb.append(this.parameters);
        sb.append(", scheme=");
        sb.append(this.scheme);
        sb.append(", port=");
        sb.append(this.port);
        sb.append(", connectTimeout=");
        sb.append(this.connectTimeout);
        sb.append(", readTimeout=");
        sb.append(this.readTimeout);
        sb.append(", writeTimeout=");
        sb.append(this.writeTimeout);
        sb.append(", callTimeout=");
        return a0.c(sb, this.callTimeout, ')');
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public HttpRequest(String baseURL, String path) {
        this(baseURL, path, null, null, null, null, null, null, 0, 0, 0, 0, 4092, null);
        k.e(baseURL, "baseURL");
        k.e(path, "path");
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public HttpRequest(String baseURL, String path, RequestType method) {
        this(baseURL, path, method, null, null, null, null, null, 0, 0, 0, 0, 4088, null);
        k.e(baseURL, "baseURL");
        k.e(path, "path");
        k.e(method, "method");
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public HttpRequest(String baseURL, String path, RequestType method, HttpBody body) {
        this(baseURL, path, method, body, null, null, null, null, 0, 0, 0, 0, 4080, null);
        k.e(baseURL, "baseURL");
        k.e(path, "path");
        k.e(method, "method");
        k.e(body, "body");
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public HttpRequest(String baseURL, String path, RequestType method, HttpBody body, Map<String, ? extends List<String>> headers) {
        this(baseURL, path, method, body, headers, null, null, null, 0, 0, 0, 0, 4064, null);
        k.e(baseURL, "baseURL");
        k.e(path, "path");
        k.e(method, "method");
        k.e(body, "body");
        k.e(headers, "headers");
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public HttpRequest(String baseURL, String path, RequestType method, HttpBody body, Map<String, ? extends List<String>> headers, Map<String, String> parameters) {
        this(baseURL, path, method, body, headers, parameters, null, null, 0, 0, 0, 0, 4032, null);
        k.e(baseURL, "baseURL");
        k.e(path, "path");
        k.e(method, "method");
        k.e(body, "body");
        k.e(headers, "headers");
        k.e(parameters, "parameters");
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public HttpRequest(String baseURL, String path, RequestType method, HttpBody body, Map<String, ? extends List<String>> headers, Map<String, String> parameters, String scheme) {
        this(baseURL, path, method, body, headers, parameters, scheme, null, 0, 0, 0, 0, 3968, null);
        k.e(baseURL, "baseURL");
        k.e(path, "path");
        k.e(method, "method");
        k.e(body, "body");
        k.e(headers, "headers");
        k.e(parameters, "parameters");
        k.e(scheme, "scheme");
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public HttpRequest(String baseURL, String path, RequestType method, HttpBody body, Map<String, ? extends List<String>> headers, Map<String, String> parameters, String scheme, Integer num) {
        this(baseURL, path, method, body, headers, parameters, scheme, num, 0, 0, 0, 0, 3840, null);
        k.e(baseURL, "baseURL");
        k.e(path, "path");
        k.e(method, "method");
        k.e(body, "body");
        k.e(headers, "headers");
        k.e(parameters, "parameters");
        k.e(scheme, "scheme");
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public HttpRequest(String baseURL, String path, RequestType method, HttpBody body, Map<String, ? extends List<String>> headers, Map<String, String> parameters, String scheme, Integer num, int i2) {
        this(baseURL, path, method, body, headers, parameters, scheme, num, i2, 0, 0, 0, 3584, null);
        k.e(baseURL, "baseURL");
        k.e(path, "path");
        k.e(method, "method");
        k.e(body, "body");
        k.e(headers, "headers");
        k.e(parameters, "parameters");
        k.e(scheme, "scheme");
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public HttpRequest(String baseURL, String path, RequestType method, HttpBody body, Map<String, ? extends List<String>> headers, Map<String, String> parameters, String scheme, Integer num, int i2, int i8) {
        this(baseURL, path, method, body, headers, parameters, scheme, num, i2, i8, 0, 0, 3072, null);
        k.e(baseURL, "baseURL");
        k.e(path, "path");
        k.e(method, "method");
        k.e(body, "body");
        k.e(headers, "headers");
        k.e(parameters, "parameters");
        k.e(scheme, "scheme");
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public HttpRequest(String baseURL, String path, RequestType method, HttpBody body, Map<String, ? extends List<String>> headers, Map<String, String> parameters, String scheme, Integer num, int i2, int i8, int i9) {
        this(baseURL, path, method, body, headers, parameters, scheme, num, i2, i8, i9, 0, 2048, null);
        k.e(baseURL, "baseURL");
        k.e(path, "path");
        k.e(method, "method");
        k.e(body, "body");
        k.e(headers, "headers");
        k.e(parameters, "parameters");
        k.e(scheme, "scheme");
    }

    /* JADX WARN: Multi-variable type inference failed */
    public HttpRequest(String baseURL, String path, RequestType method, HttpBody body, Map<String, ? extends List<String>> headers, Map<String, String> parameters, String scheme, Integer num, int i2, int i8, int i9, int i10) {
        k.e(baseURL, "baseURL");
        k.e(path, "path");
        k.e(method, "method");
        k.e(body, "body");
        k.e(headers, "headers");
        k.e(parameters, "parameters");
        k.e(scheme, "scheme");
        this.baseURL = baseURL;
        this.path = path;
        this.method = method;
        this.body = body;
        this.headers = headers;
        this.parameters = parameters;
        this.scheme = scheme;
        this.port = num;
        this.connectTimeout = i2;
        this.readTimeout = i8;
        this.writeTimeout = i9;
        this.callTimeout = i10;
    }

    /* JADX WARN: Illegal instructions before constructor call */
    public /* synthetic */ HttpRequest(String str, String str2, RequestType requestType, HttpBody httpBody, Map map, Map map2, String str3, Integer num, int i2, int i8, int i9, int i10, int i11, f fVar) {
        String str4 = (i11 & 2) != 0 ? "" : str2;
        RequestType requestType2 = (i11 & 4) != 0 ? RequestType.GET : requestType;
        HttpBody httpBody2 = (i11 & 8) != 0 ? HttpBody.EmptyBody.INSTANCE : httpBody;
        int i12 = i11 & 16;
        Map map3 = s.f13639a;
        this(str, str4, requestType2, httpBody2, i12 != 0 ? map3 : map, (i11 & 32) == 0 ? map2 : map3, (i11 & 64) != 0 ? "https" : str3, (i11 & 128) != 0 ? null : num, (i11 & 256) != 0 ? 30000 : i2, (i11 & 512) != 0 ? 30000 : i8, (i11 & 1024) != 0 ? 30000 : i9, (i11 & 2048) != 0 ? 30000 : i10);
    }
}
