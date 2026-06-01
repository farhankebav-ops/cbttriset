package com.unity3d.services.core.network.model;

import androidx.camera.core.processing.util.a;
import com.ironsource.adqualitysdk.sdk.i.a0;
import com.unity3d.ads.core.data.model.OperationType;
import java.io.File;
import java.util.List;
import java.util.Map;
import kotlin.jvm.internal.f;
import kotlin.jvm.internal.k;
import r5.s;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes5.dex */
public final class HttpRequest {
    public static final Companion Companion = new Companion(null);
    public static final String DEFAULT_SCHEME = "https";
    public static final int DEFAULT_TIMEOUT = 30000;
    private final String baseURL;
    private final Object body;
    private final BodyType bodyType;
    private final int callTimeout;
    private final int connectTimeout;
    private final File downloadDestination;
    private final Map<String, List<String>> headers;
    private final boolean isProtobuf;
    private final RequestType method;
    private final OperationType operationType;
    private final Map<String, String> parameters;
    private final String path;
    private final Integer port;
    private final int priority;
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
        this(baseURL, null, null, null, null, null, null, null, null, 0, 0, 0, 0, false, null, null, 0, 131070, null);
        k.e(baseURL, "baseURL");
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ HttpRequest copy$default(HttpRequest httpRequest, String str, String str2, RequestType requestType, Object obj, Map map, Map map2, BodyType bodyType, String str3, Integer num, int i2, int i8, int i9, int i10, boolean z2, OperationType operationType, File file, int i11, int i12, Object obj2) {
        int i13;
        File file2;
        String str4;
        HttpRequest httpRequest2;
        OperationType operationType2;
        String str5;
        RequestType requestType2;
        Object obj3;
        Map map3;
        Map map4;
        BodyType bodyType2;
        String str6;
        Integer num2;
        int i14;
        int i15;
        int i16;
        int i17;
        boolean z7;
        String str7 = (i12 & 1) != 0 ? httpRequest.baseURL : str;
        String str8 = (i12 & 2) != 0 ? httpRequest.path : str2;
        RequestType requestType3 = (i12 & 4) != 0 ? httpRequest.method : requestType;
        Object obj4 = (i12 & 8) != 0 ? httpRequest.body : obj;
        Map map5 = (i12 & 16) != 0 ? httpRequest.headers : map;
        Map map6 = (i12 & 32) != 0 ? httpRequest.parameters : map2;
        BodyType bodyType3 = (i12 & 64) != 0 ? httpRequest.bodyType : bodyType;
        String str9 = (i12 & 128) != 0 ? httpRequest.scheme : str3;
        Integer num3 = (i12 & 256) != 0 ? httpRequest.port : num;
        int i18 = (i12 & 512) != 0 ? httpRequest.connectTimeout : i2;
        int i19 = (i12 & 1024) != 0 ? httpRequest.readTimeout : i8;
        int i20 = (i12 & 2048) != 0 ? httpRequest.writeTimeout : i9;
        int i21 = (i12 & 4096) != 0 ? httpRequest.callTimeout : i10;
        boolean z8 = (i12 & 8192) != 0 ? httpRequest.isProtobuf : z2;
        String str10 = str7;
        OperationType operationType3 = (i12 & 16384) != 0 ? httpRequest.operationType : operationType;
        File file3 = (i12 & 32768) != 0 ? httpRequest.downloadDestination : file;
        if ((i12 & 65536) != 0) {
            file2 = file3;
            i13 = httpRequest.priority;
            operationType2 = operationType3;
            str5 = str8;
            requestType2 = requestType3;
            obj3 = obj4;
            map3 = map5;
            map4 = map6;
            bodyType2 = bodyType3;
            str6 = str9;
            num2 = num3;
            i14 = i18;
            i15 = i19;
            i16 = i20;
            i17 = i21;
            z7 = z8;
            str4 = str10;
            httpRequest2 = httpRequest;
        } else {
            i13 = i11;
            file2 = file3;
            str4 = str10;
            httpRequest2 = httpRequest;
            operationType2 = operationType3;
            str5 = str8;
            requestType2 = requestType3;
            obj3 = obj4;
            map3 = map5;
            map4 = map6;
            bodyType2 = bodyType3;
            str6 = str9;
            num2 = num3;
            i14 = i18;
            i15 = i19;
            i16 = i20;
            i17 = i21;
            z7 = z8;
        }
        return httpRequest2.copy(str4, str5, requestType2, obj3, map3, map4, bodyType2, str6, num2, i14, i15, i16, i17, z7, operationType2, file2, i13);
    }

    public final String component1() {
        return this.baseURL;
    }

    public final int component10() {
        return this.connectTimeout;
    }

    public final int component11() {
        return this.readTimeout;
    }

    public final int component12() {
        return this.writeTimeout;
    }

    public final int component13() {
        return this.callTimeout;
    }

    public final boolean component14() {
        return this.isProtobuf;
    }

    public final OperationType component15() {
        return this.operationType;
    }

    public final File component16() {
        return this.downloadDestination;
    }

    public final int component17() {
        return this.priority;
    }

    public final String component2() {
        return this.path;
    }

    public final RequestType component3() {
        return this.method;
    }

    public final Object component4() {
        return this.body;
    }

    public final Map<String, List<String>> component5() {
        return this.headers;
    }

    public final Map<String, String> component6() {
        return this.parameters;
    }

    public final BodyType component7() {
        return this.bodyType;
    }

    public final String component8() {
        return this.scheme;
    }

    public final Integer component9() {
        return this.port;
    }

    public final HttpRequest copy(String baseURL, String path, RequestType method, Object obj, Map<String, ? extends List<String>> headers, Map<String, String> parameters, BodyType bodyType, String scheme, Integer num, int i2, int i8, int i9, int i10, boolean z2, OperationType operationType, File file, int i11) {
        k.e(baseURL, "baseURL");
        k.e(path, "path");
        k.e(method, "method");
        k.e(headers, "headers");
        k.e(parameters, "parameters");
        k.e(bodyType, "bodyType");
        k.e(scheme, "scheme");
        k.e(operationType, "operationType");
        return new HttpRequest(baseURL, path, method, obj, headers, parameters, bodyType, scheme, num, i2, i8, i9, i10, z2, operationType, file, i11);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof HttpRequest)) {
            return false;
        }
        HttpRequest httpRequest = (HttpRequest) obj;
        return k.a(this.baseURL, httpRequest.baseURL) && k.a(this.path, httpRequest.path) && this.method == httpRequest.method && k.a(this.body, httpRequest.body) && k.a(this.headers, httpRequest.headers) && k.a(this.parameters, httpRequest.parameters) && this.bodyType == httpRequest.bodyType && k.a(this.scheme, httpRequest.scheme) && k.a(this.port, httpRequest.port) && this.connectTimeout == httpRequest.connectTimeout && this.readTimeout == httpRequest.readTimeout && this.writeTimeout == httpRequest.writeTimeout && this.callTimeout == httpRequest.callTimeout && this.isProtobuf == httpRequest.isProtobuf && this.operationType == httpRequest.operationType && k.a(this.downloadDestination, httpRequest.downloadDestination) && this.priority == httpRequest.priority;
    }

    public final String getBaseURL() {
        return this.baseURL;
    }

    public final Object getBody() {
        return this.body;
    }

    public final BodyType getBodyType() {
        return this.bodyType;
    }

    public final int getCallTimeout() {
        return this.callTimeout;
    }

    public final int getConnectTimeout() {
        return this.connectTimeout;
    }

    public final File getDownloadDestination() {
        return this.downloadDestination;
    }

    public final Map<String, List<String>> getHeaders() {
        return this.headers;
    }

    public final RequestType getMethod() {
        return this.method;
    }

    public final OperationType getOperationType() {
        return this.operationType;
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

    public final int getPriority() {
        return this.priority;
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

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r2v20, types: [int] */
    /* JADX WARN: Type inference failed for: r2v28 */
    /* JADX WARN: Type inference failed for: r2v30 */
    public int hashCode() {
        int iHashCode = (this.method.hashCode() + a.b(this.baseURL.hashCode() * 31, 31, this.path)) * 31;
        Object obj = this.body;
        int iB = a.b((this.bodyType.hashCode() + ((this.parameters.hashCode() + ((this.headers.hashCode() + ((iHashCode + (obj == null ? 0 : obj.hashCode())) * 31)) * 31)) * 31)) * 31, 31, this.scheme);
        Integer num = this.port;
        int iHashCode2 = (((((((((iB + (num == null ? 0 : num.hashCode())) * 31) + this.connectTimeout) * 31) + this.readTimeout) * 31) + this.writeTimeout) * 31) + this.callTimeout) * 31;
        boolean z2 = this.isProtobuf;
        ?? r22 = z2;
        if (z2) {
            r22 = 1;
        }
        int iHashCode3 = (this.operationType.hashCode() + ((iHashCode2 + r22) * 31)) * 31;
        File file = this.downloadDestination;
        return ((iHashCode3 + (file != null ? file.hashCode() : 0)) * 31) + this.priority;
    }

    public final boolean isProtobuf() {
        return this.isProtobuf;
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
        sb.append(", bodyType=");
        sb.append(this.bodyType);
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
        sb.append(this.callTimeout);
        sb.append(", isProtobuf=");
        sb.append(this.isProtobuf);
        sb.append(", operationType=");
        sb.append(this.operationType);
        sb.append(", downloadDestination=");
        sb.append(this.downloadDestination);
        sb.append(", priority=");
        return a0.c(sb, this.priority, ')');
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public HttpRequest(String baseURL, String path) {
        this(baseURL, path, null, null, null, null, null, null, null, 0, 0, 0, 0, false, null, null, 0, 131068, null);
        k.e(baseURL, "baseURL");
        k.e(path, "path");
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public HttpRequest(String baseURL, String path, RequestType method) {
        this(baseURL, path, method, null, null, null, null, null, null, 0, 0, 0, 0, false, null, null, 0, 131064, null);
        k.e(baseURL, "baseURL");
        k.e(path, "path");
        k.e(method, "method");
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public HttpRequest(String baseURL, String path, RequestType method, Object obj) {
        this(baseURL, path, method, obj, null, null, null, null, null, 0, 0, 0, 0, false, null, null, 0, 131056, null);
        k.e(baseURL, "baseURL");
        k.e(path, "path");
        k.e(method, "method");
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public HttpRequest(String baseURL, String path, RequestType method, Object obj, Map<String, ? extends List<String>> headers) {
        this(baseURL, path, method, obj, headers, null, null, null, null, 0, 0, 0, 0, false, null, null, 0, 131040, null);
        k.e(baseURL, "baseURL");
        k.e(path, "path");
        k.e(method, "method");
        k.e(headers, "headers");
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public HttpRequest(String baseURL, String path, RequestType method, Object obj, Map<String, ? extends List<String>> headers, Map<String, String> parameters) {
        this(baseURL, path, method, obj, headers, parameters, null, null, null, 0, 0, 0, 0, false, null, null, 0, 131008, null);
        k.e(baseURL, "baseURL");
        k.e(path, "path");
        k.e(method, "method");
        k.e(headers, "headers");
        k.e(parameters, "parameters");
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public HttpRequest(String baseURL, String path, RequestType method, Object obj, Map<String, ? extends List<String>> headers, Map<String, String> parameters, BodyType bodyType) {
        this(baseURL, path, method, obj, headers, parameters, bodyType, null, null, 0, 0, 0, 0, false, null, null, 0, 130944, null);
        k.e(baseURL, "baseURL");
        k.e(path, "path");
        k.e(method, "method");
        k.e(headers, "headers");
        k.e(parameters, "parameters");
        k.e(bodyType, "bodyType");
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public HttpRequest(String baseURL, String path, RequestType method, Object obj, Map<String, ? extends List<String>> headers, Map<String, String> parameters, BodyType bodyType, String scheme) {
        this(baseURL, path, method, obj, headers, parameters, bodyType, scheme, null, 0, 0, 0, 0, false, null, null, 0, 130816, null);
        k.e(baseURL, "baseURL");
        k.e(path, "path");
        k.e(method, "method");
        k.e(headers, "headers");
        k.e(parameters, "parameters");
        k.e(bodyType, "bodyType");
        k.e(scheme, "scheme");
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public HttpRequest(String baseURL, String path, RequestType method, Object obj, Map<String, ? extends List<String>> headers, Map<String, String> parameters, BodyType bodyType, String scheme, Integer num) {
        this(baseURL, path, method, obj, headers, parameters, bodyType, scheme, num, 0, 0, 0, 0, false, null, null, 0, 130560, null);
        k.e(baseURL, "baseURL");
        k.e(path, "path");
        k.e(method, "method");
        k.e(headers, "headers");
        k.e(parameters, "parameters");
        k.e(bodyType, "bodyType");
        k.e(scheme, "scheme");
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public HttpRequest(String baseURL, String path, RequestType method, Object obj, Map<String, ? extends List<String>> headers, Map<String, String> parameters, BodyType bodyType, String scheme, Integer num, int i2) {
        this(baseURL, path, method, obj, headers, parameters, bodyType, scheme, num, i2, 0, 0, 0, false, null, null, 0, 130048, null);
        k.e(baseURL, "baseURL");
        k.e(path, "path");
        k.e(method, "method");
        k.e(headers, "headers");
        k.e(parameters, "parameters");
        k.e(bodyType, "bodyType");
        k.e(scheme, "scheme");
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public HttpRequest(String baseURL, String path, RequestType method, Object obj, Map<String, ? extends List<String>> headers, Map<String, String> parameters, BodyType bodyType, String scheme, Integer num, int i2, int i8) {
        this(baseURL, path, method, obj, headers, parameters, bodyType, scheme, num, i2, i8, 0, 0, false, null, null, 0, 129024, null);
        k.e(baseURL, "baseURL");
        k.e(path, "path");
        k.e(method, "method");
        k.e(headers, "headers");
        k.e(parameters, "parameters");
        k.e(bodyType, "bodyType");
        k.e(scheme, "scheme");
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public HttpRequest(String baseURL, String path, RequestType method, Object obj, Map<String, ? extends List<String>> headers, Map<String, String> parameters, BodyType bodyType, String scheme, Integer num, int i2, int i8, int i9) {
        this(baseURL, path, method, obj, headers, parameters, bodyType, scheme, num, i2, i8, i9, 0, false, null, null, 0, 126976, null);
        k.e(baseURL, "baseURL");
        k.e(path, "path");
        k.e(method, "method");
        k.e(headers, "headers");
        k.e(parameters, "parameters");
        k.e(bodyType, "bodyType");
        k.e(scheme, "scheme");
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public HttpRequest(String baseURL, String path, RequestType method, Object obj, Map<String, ? extends List<String>> headers, Map<String, String> parameters, BodyType bodyType, String scheme, Integer num, int i2, int i8, int i9, int i10) {
        this(baseURL, path, method, obj, headers, parameters, bodyType, scheme, num, i2, i8, i9, i10, false, null, null, 0, 122880, null);
        k.e(baseURL, "baseURL");
        k.e(path, "path");
        k.e(method, "method");
        k.e(headers, "headers");
        k.e(parameters, "parameters");
        k.e(bodyType, "bodyType");
        k.e(scheme, "scheme");
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public HttpRequest(String baseURL, String path, RequestType method, Object obj, Map<String, ? extends List<String>> headers, Map<String, String> parameters, BodyType bodyType, String scheme, Integer num, int i2, int i8, int i9, int i10, boolean z2) {
        this(baseURL, path, method, obj, headers, parameters, bodyType, scheme, num, i2, i8, i9, i10, z2, null, null, 0, 114688, null);
        k.e(baseURL, "baseURL");
        k.e(path, "path");
        k.e(method, "method");
        k.e(headers, "headers");
        k.e(parameters, "parameters");
        k.e(bodyType, "bodyType");
        k.e(scheme, "scheme");
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public HttpRequest(String baseURL, String path, RequestType method, Object obj, Map<String, ? extends List<String>> headers, Map<String, String> parameters, BodyType bodyType, String scheme, Integer num, int i2, int i8, int i9, int i10, boolean z2, OperationType operationType) {
        this(baseURL, path, method, obj, headers, parameters, bodyType, scheme, num, i2, i8, i9, i10, z2, operationType, null, 0, 98304, null);
        k.e(baseURL, "baseURL");
        k.e(path, "path");
        k.e(method, "method");
        k.e(headers, "headers");
        k.e(parameters, "parameters");
        k.e(bodyType, "bodyType");
        k.e(scheme, "scheme");
        k.e(operationType, "operationType");
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public HttpRequest(String baseURL, String path, RequestType method, Object obj, Map<String, ? extends List<String>> headers, Map<String, String> parameters, BodyType bodyType, String scheme, Integer num, int i2, int i8, int i9, int i10, boolean z2, OperationType operationType, File file) {
        this(baseURL, path, method, obj, headers, parameters, bodyType, scheme, num, i2, i8, i9, i10, z2, operationType, file, 0, 65536, null);
        k.e(baseURL, "baseURL");
        k.e(path, "path");
        k.e(method, "method");
        k.e(headers, "headers");
        k.e(parameters, "parameters");
        k.e(bodyType, "bodyType");
        k.e(scheme, "scheme");
        k.e(operationType, "operationType");
    }

    /* JADX WARN: Multi-variable type inference failed */
    public HttpRequest(String baseURL, String path, RequestType method, Object obj, Map<String, ? extends List<String>> headers, Map<String, String> parameters, BodyType bodyType, String scheme, Integer num, int i2, int i8, int i9, int i10, boolean z2, OperationType operationType, File file, int i11) {
        k.e(baseURL, "baseURL");
        k.e(path, "path");
        k.e(method, "method");
        k.e(headers, "headers");
        k.e(parameters, "parameters");
        k.e(bodyType, "bodyType");
        k.e(scheme, "scheme");
        k.e(operationType, "operationType");
        this.baseURL = baseURL;
        this.path = path;
        this.method = method;
        this.body = obj;
        this.headers = headers;
        this.parameters = parameters;
        this.bodyType = bodyType;
        this.scheme = scheme;
        this.port = num;
        this.connectTimeout = i2;
        this.readTimeout = i8;
        this.writeTimeout = i9;
        this.callTimeout = i10;
        this.isProtobuf = z2;
        this.operationType = operationType;
        this.downloadDestination = file;
        this.priority = i11;
    }

    /* JADX WARN: Illegal instructions before constructor call */
    public /* synthetic */ HttpRequest(String str, String str2, RequestType requestType, Object obj, Map map, Map map2, BodyType bodyType, String str3, Integer num, int i2, int i8, int i9, int i10, boolean z2, OperationType operationType, File file, int i11, int i12, f fVar) {
        String str4 = (i12 & 2) != 0 ? "" : str2;
        RequestType requestType2 = (i12 & 4) != 0 ? RequestType.GET : requestType;
        Object obj2 = (i12 & 8) != 0 ? null : obj;
        int i13 = i12 & 16;
        Map map3 = s.f13639a;
        this(str, str4, requestType2, obj2, i13 != 0 ? map3 : map, (i12 & 32) == 0 ? map2 : map3, (i12 & 64) != 0 ? BodyType.UNKNOWN : bodyType, (i12 & 128) != 0 ? "https" : str3, (i12 & 256) != 0 ? null : num, (i12 & 512) != 0 ? 30000 : i2, (i12 & 1024) != 0 ? 30000 : i8, (i12 & 2048) != 0 ? 30000 : i9, (i12 & 4096) == 0 ? i10 : 30000, (i12 & 8192) != 0 ? false : z2, (i12 & 16384) != 0 ? OperationType.UNKNOWN : operationType, (i12 & 32768) != 0 ? null : file, (i12 & 65536) != 0 ? 0 : i11);
    }
}
