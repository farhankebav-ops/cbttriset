package com.unity3d.services.core.webview;

import com.bumptech.glide.load.Key;
import com.ironsource.C2300e4;
import com.unity3d.services.core.configuration.Configuration;
import com.unity3d.services.core.log.DeviceLog;
import com.unity3d.services.core.misc.Utilities;
import com.unity3d.services.core.request.metrics.SDKMetricsSender;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes5.dex */
public class WebViewUrlBuilder {
    private final SDKMetricsSender _sdkMetricsSender = (SDKMetricsSender) Utilities.getService(SDKMetricsSender.class);
    private final String _urlWithQueryString;

    public WebViewUrlBuilder(String str, Configuration configuration) {
        StringBuilder sbR = androidx.camera.core.processing.util.a.r("?platform=android" + buildQueryParam("origin", configuration.getWebViewUrl()));
        sbR.append(buildQueryParam("version", configuration.getWebViewVersion()));
        StringBuilder sbR2 = androidx.camera.core.processing.util.a.r(sbR.toString());
        sbR2.append(buildQueryParam("isNativeCollectingMetrics", String.valueOf(configuration.areMetricsEnabledForCurrentSession())));
        this._urlWithQueryString = a1.a.C(str, sbR2.toString());
    }

    private String buildQueryParam(String str, String str2) {
        if (str2 != null) {
            try {
                return C2300e4.i.f8401c + str + C2300e4.i.f8399b + URLEncoder.encode(str2, Key.STRING_CHARSET_NAME);
            } catch (UnsupportedEncodingException e) {
                DeviceLog.exception("Unsupported charset when encoding " + str, e);
            }
        }
        return "";
    }

    public String getUrlWithQueryString() {
        return this._urlWithQueryString;
    }
}
