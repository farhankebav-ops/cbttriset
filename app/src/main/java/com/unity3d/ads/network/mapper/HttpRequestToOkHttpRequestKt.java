package com.unity3d.ads.network.mapper;

import com.unity3d.ads.network.model.HttpBody;
import com.unity3d.ads.network.model.HttpRequest;
import e2.s;
import java.util.List;
import java.util.Map;
import kotlin.jvm.internal.k;
import n6.m;
import okhttp3.Headers;
import okhttp3.MediaType;
import okhttp3.Request;
import okhttp3.RequestBody;
import r5.l;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes5.dex */
public final class HttpRequestToOkHttpRequestKt {
    private static final RequestBody generateOkHttpBody(HttpBody httpBody) {
        if (httpBody instanceof HttpBody.StringBody) {
            return RequestBody.create(MediaType.parse("text/plain;charset=utf-8"), ((HttpBody.StringBody) httpBody).getContent());
        }
        if (httpBody instanceof HttpBody.ByteArrayBody) {
            return RequestBody.create(MediaType.parse("text/plain;charset=utf-8"), ((HttpBody.ByteArrayBody) httpBody).getContent());
        }
        if (httpBody instanceof HttpBody.EmptyBody) {
            return null;
        }
        throw new s(3);
    }

    private static final Headers generateOkHttpHeaders(HttpRequest httpRequest) {
        Headers.Builder builder = new Headers.Builder();
        for (Map.Entry<String, List<String>> entry : httpRequest.getHeaders().entrySet()) {
            builder.add(entry.getKey(), l.c1(entry.getValue(), ",", null, null, null, 62));
        }
        Headers headersBuild = builder.build();
        k.d(headersBuild, "Builder()\n    .also { he…ng(\",\")) } }\n    .build()");
        return headersBuild;
    }

    public static final Request toOkHttpRequest(HttpRequest httpRequest) {
        k.e(httpRequest, "<this>");
        Request requestBuild = new Request.Builder().url(m.G0(m.U0(httpRequest.getBaseURL(), '/') + '/' + m.U0(httpRequest.getPath(), '/'), "/")).method(httpRequest.getMethod().toString(), generateOkHttpBody(httpRequest.getBody())).headers(generateOkHttpHeaders(httpRequest)).build();
        k.d(requestBuild, "Builder()\n    .url(\"${ba…tpHeaders())\n    .build()");
        return requestBuild;
    }
}
