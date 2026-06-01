package com.unity3d.services.core.network.model;

import com.ironsource.mediationsdk.logger.IronSourceError;
import com.unity3d.ads.core.data.model.exception.UnityAdsNetworkException;
import kotlin.jvm.internal.k;
import r5.s;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes5.dex */
public final class HttpResponseKt {
    public static final boolean isSuccessful(HttpResponse httpResponse) {
        k.e(httpResponse, "<this>");
        int statusCode = httpResponse.getStatusCode();
        return 200 <= statusCode && statusCode < 300;
    }

    public static final HttpResponse toHttpResponse(UnityAdsNetworkException unityAdsNetworkException) {
        k.e(unityAdsNetworkException, "<this>");
        Integer code = unityAdsNetworkException.getCode();
        int iIntValue = code != null ? code.intValue() : IronSourceError.ERROR_NO_INTERNET_CONNECTION;
        String url = unityAdsNetworkException.getUrl();
        String str = url == null ? "" : url;
        String protocol = unityAdsNetworkException.getProtocol();
        String str2 = protocol == null ? "" : protocol;
        String client = unityAdsNetworkException.getClient();
        if (client == null) {
            client = "unknown";
        }
        return new HttpResponse("", iIntValue, s.f13639a, str, str2, client, 0L, 64, null);
    }
}
