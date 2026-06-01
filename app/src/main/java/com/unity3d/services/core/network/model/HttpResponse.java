package com.unity3d.services.core.network.model;

import androidx.camera.core.processing.util.a;
import com.vungle.ads.internal.protos.Sdk;
import java.util.List;
import java.util.Map;
import kotlin.jvm.internal.f;
import kotlin.jvm.internal.k;
import r5.s;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes5.dex */
public final class HttpResponse {
    private final Object body;
    private final String client;
    private final long contentSize;
    private final Map<String, List<String>> headers;
    private final String protocol;
    private final int statusCode;
    private final String urlString;

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public HttpResponse(Object body) {
        this(body, 0, null, null, null, null, 0L, 126, null);
        k.e(body, "body");
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ HttpResponse copy$default(HttpResponse httpResponse, Object obj, int i2, Map map, String str, String str2, String str3, long j, int i8, Object obj2) {
        if ((i8 & 1) != 0) {
            obj = httpResponse.body;
        }
        if ((i8 & 2) != 0) {
            i2 = httpResponse.statusCode;
        }
        if ((i8 & 4) != 0) {
            map = httpResponse.headers;
        }
        if ((i8 & 8) != 0) {
            str = httpResponse.urlString;
        }
        if ((i8 & 16) != 0) {
            str2 = httpResponse.protocol;
        }
        if ((i8 & 32) != 0) {
            str3 = httpResponse.client;
        }
        if ((i8 & 64) != 0) {
            j = httpResponse.contentSize;
        }
        long j3 = j;
        String str4 = str2;
        String str5 = str3;
        return httpResponse.copy(obj, i2, map, str, str4, str5, j3);
    }

    public final Object component1() {
        return this.body;
    }

    public final int component2() {
        return this.statusCode;
    }

    public final Map<String, List<String>> component3() {
        return this.headers;
    }

    public final String component4() {
        return this.urlString;
    }

    public final String component5() {
        return this.protocol;
    }

    public final String component6() {
        return this.client;
    }

    public final long component7() {
        return this.contentSize;
    }

    public final HttpResponse copy(Object body, int i2, Map<String, ? extends List<String>> headers, String urlString, String protocol, String client, long j) {
        k.e(body, "body");
        k.e(headers, "headers");
        k.e(urlString, "urlString");
        k.e(protocol, "protocol");
        k.e(client, "client");
        return new HttpResponse(body, i2, headers, urlString, protocol, client, j);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof HttpResponse)) {
            return false;
        }
        HttpResponse httpResponse = (HttpResponse) obj;
        return k.a(this.body, httpResponse.body) && this.statusCode == httpResponse.statusCode && k.a(this.headers, httpResponse.headers) && k.a(this.urlString, httpResponse.urlString) && k.a(this.protocol, httpResponse.protocol) && k.a(this.client, httpResponse.client) && this.contentSize == httpResponse.contentSize;
    }

    public final Object getBody() {
        return this.body;
    }

    public final String getClient() {
        return this.client;
    }

    public final long getContentSize() {
        return this.contentSize;
    }

    public final Map<String, List<String>> getHeaders() {
        return this.headers;
    }

    public final String getProtocol() {
        return this.protocol;
    }

    public final int getStatusCode() {
        return this.statusCode;
    }

    public final String getUrlString() {
        return this.urlString;
    }

    public int hashCode() {
        int iB = a.b(a.b(a.b((this.headers.hashCode() + (((this.body.hashCode() * 31) + this.statusCode) * 31)) * 31, 31, this.urlString), 31, this.protocol), 31, this.client);
        long j = this.contentSize;
        return iB + ((int) (j ^ (j >>> 32)));
    }

    public String toString() {
        return "HttpResponse(body=" + this.body + ", statusCode=" + this.statusCode + ", headers=" + this.headers + ", urlString=" + this.urlString + ", protocol=" + this.protocol + ", client=" + this.client + ", contentSize=" + this.contentSize + ')';
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public HttpResponse(Object body, int i2) {
        this(body, i2, null, null, null, null, 0L, Sdk.SDKError.Reason.INVALID_LOG_ERROR_ENDPOINT_VALUE, null);
        k.e(body, "body");
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public HttpResponse(Object body, int i2, Map<String, ? extends List<String>> headers) {
        this(body, i2, headers, null, null, null, 0L, 120, null);
        k.e(body, "body");
        k.e(headers, "headers");
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public HttpResponse(Object body, int i2, Map<String, ? extends List<String>> headers, String urlString) {
        this(body, i2, headers, urlString, null, null, 0L, 112, null);
        k.e(body, "body");
        k.e(headers, "headers");
        k.e(urlString, "urlString");
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public HttpResponse(Object body, int i2, Map<String, ? extends List<String>> headers, String urlString, String protocol) {
        this(body, i2, headers, urlString, protocol, null, 0L, 96, null);
        k.e(body, "body");
        k.e(headers, "headers");
        k.e(urlString, "urlString");
        k.e(protocol, "protocol");
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public HttpResponse(Object body, int i2, Map<String, ? extends List<String>> headers, String urlString, String protocol, String client) {
        this(body, i2, headers, urlString, protocol, client, 0L, 64, null);
        k.e(body, "body");
        k.e(headers, "headers");
        k.e(urlString, "urlString");
        k.e(protocol, "protocol");
        k.e(client, "client");
    }

    /* JADX WARN: Multi-variable type inference failed */
    public HttpResponse(Object body, int i2, Map<String, ? extends List<String>> headers, String urlString, String protocol, String client, long j) {
        k.e(body, "body");
        k.e(headers, "headers");
        k.e(urlString, "urlString");
        k.e(protocol, "protocol");
        k.e(client, "client");
        this.body = body;
        this.statusCode = i2;
        this.headers = headers;
        this.urlString = urlString;
        this.protocol = protocol;
        this.client = client;
        this.contentSize = j;
    }

    public /* synthetic */ HttpResponse(Object obj, int i2, Map map, String str, String str2, String str3, long j, int i8, f fVar) {
        this(obj, (i8 & 2) != 0 ? 200 : i2, (i8 & 4) != 0 ? s.f13639a : map, (i8 & 8) != 0 ? "" : str, (i8 & 16) == 0 ? str2 : "", (i8 & 32) != 0 ? "unknown" : str3, (i8 & 64) != 0 ? -1L : j);
    }
}
