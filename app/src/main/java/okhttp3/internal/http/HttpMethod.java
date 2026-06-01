package okhttp3.internal.http;

import kotlin.jvm.internal.k;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes.dex */
public final class HttpMethod {
    public static final HttpMethod INSTANCE = new HttpMethod();

    private HttpMethod() {
    }

    public static final boolean invalidatesCache(String method) {
        k.e(method, "method");
        return method.equals("POST") || method.equals("PATCH") || method.equals("PUT") || method.equals("DELETE") || method.equals("MOVE");
    }

    public static final boolean permitsRequestBody(String method) {
        k.e(method, "method");
        return (method.equals("GET") || method.equals("HEAD")) ? false : true;
    }

    public static final boolean requiresRequestBody(String method) {
        k.e(method, "method");
        return method.equals("POST") || method.equals("PUT") || method.equals("PATCH") || method.equals("PROPPATCH") || method.equals("REPORT");
    }

    public final boolean redirectsToGet(String method) {
        k.e(method, "method");
        return !method.equals("PROPFIND");
    }

    public final boolean redirectsWithBody(String method) {
        k.e(method, "method");
        return method.equals("PROPFIND");
    }
}
