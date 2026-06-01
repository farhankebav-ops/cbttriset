package com.unity3d.services.ads.adunit;

import android.os.ConditionVariable;
import com.ironsource.C2300e4;
import com.ironsource.C2461n2;
import com.unity3d.services.core.configuration.Configuration;
import com.unity3d.services.core.misc.Utilities;
import com.unity3d.services.core.request.metrics.AdOperationError;
import com.unity3d.services.core.request.metrics.AdOperationMetric;
import com.unity3d.services.core.request.metrics.SDKMetricsSender;
import com.unity3d.services.core.webview.WebViewApp;
import com.unity3d.services.core.webview.bridge.CallbackStatus;
import java.lang.reflect.Method;
import org.json.JSONObject;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes5.dex */
public class AdUnitOpen {
    private static Configuration _configuration;
    private static final SDKMetricsSender _sdkMetricsSender = (SDKMetricsSender) Utilities.getService(SDKMetricsSender.class);
    private static ConditionVariable _waitShowStatus;

    public static synchronized boolean open(String str, JSONObject jSONObject) throws NoSuchMethodException {
        boolean zBlock;
        try {
            Method method = AdUnitOpen.class.getMethod("showCallback", CallbackStatus.class);
            _waitShowStatus = new ConditionVariable();
            if (_configuration == null) {
                _configuration = new Configuration();
            }
            WebViewApp.getCurrentApp().invokeMethod(C2300e4.h.K, C2461n2.f9471v, method, str, jSONObject);
            zBlock = _waitShowStatus.block(_configuration.getShowTimeout());
            _waitShowStatus = null;
            if (!zBlock) {
                _sdkMetricsSender.sendMetric(AdOperationMetric.newAdShowFailure(AdOperationError.timeout, Long.valueOf(_configuration.getShowTimeout())));
            }
        } catch (Throwable th) {
            throw th;
        }
        return zBlock;
    }

    public static void setConfiguration(Configuration configuration) {
        _configuration = configuration;
    }

    public static void showCallback(CallbackStatus callbackStatus) {
        if (_waitShowStatus == null || !callbackStatus.equals(CallbackStatus.OK)) {
            return;
        }
        _waitShowStatus.open();
    }
}
