package com.vungle.ads.internal.network;

import androidx.annotation.VisibleForTesting;
import com.ironsource.G5;
import com.unity3d.ads.gatewayclient.CommonGatewayClient;
import com.vungle.ads.internal.model.AdPayload;
import com.vungle.ads.internal.model.CommonRequestBody;
import com.vungle.ads.internal.model.ConfigPayload;
import com.vungle.ads.internal.network.converters.EmptyResponseConverter;
import com.vungle.ads.internal.network.converters.JsonConverter;
import e2.s;
import g7.c;
import java.util.List;
import java.util.Map;
import kotlin.jvm.internal.b0;
import kotlin.jvm.internal.f;
import kotlin.jvm.internal.k;
import okhttp3.Call;
import okhttp3.Headers;
import okhttp3.HttpUrl;
import okhttp3.MediaType;
import okhttp3.Request;
import okhttp3.RequestBody;
import r2.q;
import r5.l;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes5.dex */
public final class VungleApiImpl implements VungleApi {
    private static final String VUNGLE_VERSION = "7.1.0";
    private final EmptyResponseConverter emptyResponseConverter;
    private final Call.Factory okHttpClient;
    public static final Companion Companion = new Companion(null);
    private static final c json = a.a.b(VungleApiImpl$Companion$json$1.INSTANCE);

    /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
    public static final class Companion {
        public /* synthetic */ Companion(f fVar) {
            this();
        }

        private Companion() {
        }
    }

    /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[HttpMethod.values().length];
            iArr[HttpMethod.GET.ordinal()] = 1;
            iArr[HttpMethod.POST.ordinal()] = 2;
            $EnumSwitchMapping$0 = iArr;
        }
    }

    public VungleApiImpl(Call.Factory okHttpClient) {
        k.e(okHttpClient, "okHttpClient");
        this.okHttpClient = okHttpClient;
        this.emptyResponseConverter = new EmptyResponseConverter();
    }

    private final Request.Builder defaultBuilder(String str, String str2, String str3, Map<String, String> map) {
        Request.Builder builderAddHeader = new Request.Builder().url(str2).addHeader("User-Agent", str).addHeader("Vungle-Version", VUNGLE_VERSION).addHeader("Content-Type", G5.L);
        if (map != null) {
            builderAddHeader.headers(Headers.Companion.of(map));
        }
        if (str3 != null) {
            builderAddHeader.addHeader("X-Vungle-Placement-Ref-Id", str3);
        }
        VungleHeader vungleHeader = VungleHeader.INSTANCE;
        String appVersion = vungleHeader.getAppVersion();
        if (appVersion != null) {
            builderAddHeader.addHeader("X-VUNGLE-APP-VERSION", appVersion);
        }
        String appId = vungleHeader.getAppId();
        if (appId != null) {
            builderAddHeader.addHeader("X-Vungle-App-Id", appId);
        }
        return builderAddHeader;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ Request.Builder defaultBuilder$default(VungleApiImpl vungleApiImpl, String str, String str2, String str3, Map map, int i2, Object obj) {
        if ((i2 & 4) != 0) {
            str3 = null;
        }
        if ((i2 & 8) != 0) {
            map = null;
        }
        return vungleApiImpl.defaultBuilder(str, str2, str3, map);
    }

    private final Request.Builder defaultProtoBufBuilder(String str, HttpUrl httpUrl) {
        Request.Builder builderAddHeader = new Request.Builder().url(httpUrl).addHeader("User-Agent", str).addHeader("Vungle-Version", VUNGLE_VERSION).addHeader("Content-Type", CommonGatewayClient.HEADER_PROTOBUF);
        VungleHeader vungleHeader = VungleHeader.INSTANCE;
        String appId = vungleHeader.getAppId();
        if (appId != null) {
            builderAddHeader.addHeader("X-Vungle-App-Id", appId);
        }
        String appVersion = vungleHeader.getAppVersion();
        if (appVersion != null) {
            builderAddHeader.addHeader("X-VUNGLE-APP-VERSION", appVersion);
        }
        return builderAddHeader;
    }

    @Override // com.vungle.ads.internal.network.VungleApi
    public Call<AdPayload> ads(String ua, String path, CommonRequestBody body) {
        String strB;
        CommonRequestBody.RequestParam request;
        List<String> placements;
        k.e(ua, "ua");
        k.e(path, "path");
        k.e(body, "body");
        try {
            c cVar = json;
            strB = cVar.b(q.q0(cVar.f11599b, b0.b(CommonRequestBody.class)), body);
            request = body.getRequest();
        } catch (Exception unused) {
        }
        try {
            return new OkHttpCall(this.okHttpClient.newCall(defaultBuilder$default(this, ua, path, (request == null || (placements = request.getPlacements()) == null) ? null : (String) l.Y0(placements), null, 8, null).post(RequestBody.Companion.create(strB, (MediaType) null)).build()), new JsonConverter(b0.b(AdPayload.class)));
        } catch (Exception unused2) {
            return null;
        }
    }

    @Override // com.vungle.ads.internal.network.VungleApi
    public Call<ConfigPayload> config(String ua, String path, CommonRequestBody body) {
        c cVar;
        k.e(ua, "ua");
        k.e(path, "path");
        k.e(body, "body");
        try {
            cVar = json;
        } catch (Exception unused) {
        }
        try {
            return new OkHttpCall(this.okHttpClient.newCall(defaultBuilder$default(this, ua, path, null, null, 12, null).post(RequestBody.Companion.create(cVar.b(q.q0(cVar.f11599b, b0.b(CommonRequestBody.class)), body), (MediaType) null)).build()), new JsonConverter(b0.b(ConfigPayload.class)));
        } catch (Exception unused2) {
            return null;
        }
    }

    @VisibleForTesting
    public final Call.Factory getOkHttpClient$vungle_ads_release() {
        return this.okHttpClient;
    }

    @Override // com.vungle.ads.internal.network.VungleApi
    public Call<Void> pingTPAT(String ua, String url, HttpMethod requestType, Map<String, String> map, RequestBody requestBody) {
        Request requestBuild;
        k.e(ua, "ua");
        k.e(url, "url");
        k.e(requestType, "requestType");
        Request.Builder builderDefaultBuilder$default = defaultBuilder$default(this, ua, url, null, map, 4, null);
        int i2 = WhenMappings.$EnumSwitchMapping$0[requestType.ordinal()];
        if (i2 == 1) {
            requestBuild = builderDefaultBuilder$default.get().build();
        } else {
            if (i2 != 2) {
                throw new s(3);
            }
            if (requestBody == null) {
                requestBody = RequestBody.Companion.create$default(RequestBody.Companion, new byte[0], (MediaType) null, 0, 0, 6, (Object) null);
            }
            requestBuild = builderDefaultBuilder$default.post(requestBody).build();
        }
        return new OkHttpCall(this.okHttpClient.newCall(requestBuild), this.emptyResponseConverter);
    }

    @Override // com.vungle.ads.internal.network.VungleApi
    public Call<Void> ri(String ua, String path, CommonRequestBody body) {
        c cVar;
        k.e(ua, "ua");
        k.e(path, "path");
        k.e(body, "body");
        try {
            cVar = json;
        } catch (Exception unused) {
        }
        try {
            return new OkHttpCall(this.okHttpClient.newCall(defaultBuilder$default(this, ua, path, null, null, 12, null).post(RequestBody.Companion.create(cVar.b(q.q0(cVar.f11599b, b0.b(CommonRequestBody.class)), body), (MediaType) null)).build()), this.emptyResponseConverter);
        } catch (Exception unused2) {
            return null;
        }
    }

    @Override // com.vungle.ads.internal.network.VungleApi
    public Call<Void> sendAdMarkup(String path, RequestBody requestBody) {
        k.e(path, "path");
        k.e(requestBody, "requestBody");
        return new OkHttpCall(this.okHttpClient.newCall(defaultBuilder$default(this, "debug", HttpUrl.Companion.get(path).newBuilder().build().toString(), null, null, 12, null).post(requestBody).build()), this.emptyResponseConverter);
    }

    @Override // com.vungle.ads.internal.network.VungleApi
    public Call<Void> sendErrors(String ua, String path, RequestBody requestBody) {
        k.e(ua, "ua");
        k.e(path, "path");
        k.e(requestBody, "requestBody");
        return new OkHttpCall(this.okHttpClient.newCall(defaultProtoBufBuilder(ua, HttpUrl.Companion.get(path).newBuilder().build()).post(requestBody).build()), this.emptyResponseConverter);
    }

    @Override // com.vungle.ads.internal.network.VungleApi
    public Call<Void> sendMetrics(String ua, String path, RequestBody requestBody) {
        k.e(ua, "ua");
        k.e(path, "path");
        k.e(requestBody, "requestBody");
        return new OkHttpCall(this.okHttpClient.newCall(defaultProtoBufBuilder(ua, HttpUrl.Companion.get(path).newBuilder().build()).post(requestBody).build()), this.emptyResponseConverter);
    }
}
