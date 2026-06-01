package com.vungle.ads.internal.network;

import kotlin.jvm.internal.f;
import kotlin.jvm.internal.k;
import okhttp3.Headers;
import okhttp3.ResponseBody;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes5.dex */
public final class Response<T> {
    public static final Companion Companion = new Companion(null);
    private final T body;
    private final ResponseBody errorBody;
    private final okhttp3.Response rawResponse;

    /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
    public static final class Companion {
        public /* synthetic */ Companion(f fVar) {
            this();
        }

        public final <T> Response<T> error(ResponseBody responseBody, okhttp3.Response rawResponse) {
            k.e(rawResponse, "rawResponse");
            if (rawResponse.isSuccessful()) {
                throw new IllegalArgumentException("rawResponse should not be successful response");
            }
            f fVar = null;
            return new Response<>(rawResponse, fVar, responseBody, fVar);
        }

        public final <T> Response<T> success(T t3, okhttp3.Response rawResponse) {
            k.e(rawResponse, "rawResponse");
            if (rawResponse.isSuccessful()) {
                return new Response<>(rawResponse, t3, null, 0 == true ? 1 : 0);
            }
            throw new IllegalArgumentException("rawResponse must be successful response");
        }

        private Companion() {
        }
    }

    public /* synthetic */ Response(okhttp3.Response response, Object obj, ResponseBody responseBody, f fVar) {
        this(response, obj, responseBody);
    }

    public final T body() {
        return this.body;
    }

    public final int code() {
        return this.rawResponse.code();
    }

    public final ResponseBody errorBody() {
        return this.errorBody;
    }

    public final Headers headers() {
        return this.rawResponse.headers();
    }

    public final boolean isSuccessful() {
        return this.rawResponse.isSuccessful();
    }

    public final String message() {
        return this.rawResponse.message();
    }

    public final okhttp3.Response raw() {
        return this.rawResponse;
    }

    public String toString() {
        return this.rawResponse.toString();
    }

    private Response(okhttp3.Response response, T t3, ResponseBody responseBody) {
        this.rawResponse = response;
        this.body = t3;
        this.errorBody = responseBody;
    }
}
