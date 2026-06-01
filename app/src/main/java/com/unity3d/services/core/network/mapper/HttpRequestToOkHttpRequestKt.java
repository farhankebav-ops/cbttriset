package com.unity3d.services.core.network.mapper;

import com.unity3d.ads.gatewayclient.CommonGatewayClient;
import com.unity3d.services.core.network.model.HttpRequest;
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
    private static final RequestBody generateOkHttpBody(Object obj) {
        if (obj instanceof byte[]) {
            RequestBody requestBodyCreate = RequestBody.create(MediaType.parse("text/plain;charset=utf-8"), (byte[]) obj);
            k.d(requestBodyCreate, "create(MediaType.parse(\"…in;charset=utf-8\"), body)");
            return requestBodyCreate;
        }
        if (obj instanceof String) {
            RequestBody requestBodyCreate2 = RequestBody.create(MediaType.parse("text/plain;charset=utf-8"), (String) obj);
            k.d(requestBodyCreate2, "create(MediaType.parse(\"…in;charset=utf-8\"), body)");
            return requestBodyCreate2;
        }
        RequestBody requestBodyCreate3 = RequestBody.create(MediaType.parse("text/plain;charset=utf-8"), "");
        k.d(requestBodyCreate3, "create(MediaType.parse(\"…lain;charset=utf-8\"), \"\")");
        return requestBodyCreate3;
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

    private static final RequestBody generateOkHttpProtobufBody(Object obj) {
        if (obj instanceof byte[]) {
            RequestBody requestBodyCreate = RequestBody.create(MediaType.parse(CommonGatewayClient.HEADER_PROTOBUF), (byte[]) obj);
            k.d(requestBodyCreate, "create(MediaType.parse(\"…ation/x-protobuf\"), body)");
            return requestBodyCreate;
        }
        if (obj instanceof String) {
            RequestBody requestBodyCreate2 = RequestBody.create(MediaType.parse(CommonGatewayClient.HEADER_PROTOBUF), (String) obj);
            k.d(requestBodyCreate2, "create(MediaType.parse(\"…ation/x-protobuf\"), body)");
            return requestBodyCreate2;
        }
        RequestBody requestBodyCreate3 = RequestBody.create(MediaType.parse(CommonGatewayClient.HEADER_PROTOBUF), "");
        k.d(requestBodyCreate3, "create(MediaType.parse(\"…ication/x-protobuf\"), \"\")");
        return requestBodyCreate3;
    }

    public static final Request toOkHttpProtoRequest(HttpRequest httpRequest) {
        k.e(httpRequest, "<this>");
        Request.Builder builderUrl = new Request.Builder().url(m.G0(m.U0(httpRequest.getBaseURL(), '/') + '/' + m.U0(httpRequest.getPath(), '/'), "/"));
        String string = httpRequest.getMethod().toString();
        Object body = httpRequest.getBody();
        Request requestBuild = builderUrl.method(string, body != null ? generateOkHttpProtobufBody(body) : null).headers(generateOkHttpHeaders(httpRequest)).build();
        k.d(requestBuild, "Builder()\n    .url(\"${ba…tpHeaders())\n    .build()");
        return requestBuild;
    }

    public static final Request toOkHttpRequest(HttpRequest httpRequest) {
        k.e(httpRequest, "<this>");
        Request.Builder builderUrl = new Request.Builder().url(m.G0(m.U0(httpRequest.getBaseURL(), '/') + '/' + m.U0(httpRequest.getPath(), '/'), "/"));
        String string = httpRequest.getMethod().toString();
        Object body = httpRequest.getBody();
        Request requestBuild = builderUrl.method(string, body != null ? generateOkHttpBody(body) : null).headers(generateOkHttpHeaders(httpRequest)).build();
        k.d(requestBuild, "Builder()\n    .url(\"${ba…tpHeaders())\n    .build()");
        return requestBuild;
    }
}
