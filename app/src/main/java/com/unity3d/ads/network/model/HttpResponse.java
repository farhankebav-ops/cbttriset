package com.unity3d.ads.network.model;

import a1.a;
import java.util.Map;
import kotlin.jvm.internal.f;
import kotlin.jvm.internal.k;
import r5.s;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes5.dex */
public final class HttpResponse {
    private final Object body;
    private final Map<String, Object> headers;
    private final int statusCode;
    private final String urlString;

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public HttpResponse(Object body) {
        this(body, 0, null, null, 14, null);
        k.e(body, "body");
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ HttpResponse copy$default(HttpResponse httpResponse, Object obj, int i2, Map map, String str, int i8, Object obj2) {
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
        return httpResponse.copy(obj, i2, map, str);
    }

    public final Object component1() {
        return this.body;
    }

    public final int component2() {
        return this.statusCode;
    }

    public final Map<String, Object> component3() {
        return this.headers;
    }

    public final String component4() {
        return this.urlString;
    }

    public final HttpResponse copy(Object body, int i2, Map<String, ? extends Object> headers, String urlString) {
        k.e(body, "body");
        k.e(headers, "headers");
        k.e(urlString, "urlString");
        return new HttpResponse(body, i2, headers, urlString);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof HttpResponse)) {
            return false;
        }
        HttpResponse httpResponse = (HttpResponse) obj;
        return k.a(this.body, httpResponse.body) && this.statusCode == httpResponse.statusCode && k.a(this.headers, httpResponse.headers) && k.a(this.urlString, httpResponse.urlString);
    }

    public final Object getBody() {
        return this.body;
    }

    public final Map<String, Object> getHeaders() {
        return this.headers;
    }

    public final int getStatusCode() {
        return this.statusCode;
    }

    public final String getUrlString() {
        return this.urlString;
    }

    public int hashCode() {
        return this.urlString.hashCode() + ((this.headers.hashCode() + (((this.body.hashCode() * 31) + this.statusCode) * 31)) * 31);
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("HttpResponse(body=");
        sb.append(this.body);
        sb.append(", statusCode=");
        sb.append(this.statusCode);
        sb.append(", headers=");
        sb.append(this.headers);
        sb.append(", urlString=");
        return a.e(')', this.urlString, sb);
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public HttpResponse(Object body, int i2) {
        this(body, i2, null, null, 12, null);
        k.e(body, "body");
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public HttpResponse(Object body, int i2, Map<String, ? extends Object> headers) {
        this(body, i2, headers, null, 8, null);
        k.e(body, "body");
        k.e(headers, "headers");
    }

    public HttpResponse(Object body, int i2, Map<String, ? extends Object> headers, String urlString) {
        k.e(body, "body");
        k.e(headers, "headers");
        k.e(urlString, "urlString");
        this.body = body;
        this.statusCode = i2;
        this.headers = headers;
        this.urlString = urlString;
    }

    public /* synthetic */ HttpResponse(Object obj, int i2, Map map, String str, int i8, f fVar) {
        this(obj, (i8 & 2) != 0 ? 200 : i2, (i8 & 4) != 0 ? s.f13639a : map, (i8 & 8) != 0 ? "" : str);
    }
}
