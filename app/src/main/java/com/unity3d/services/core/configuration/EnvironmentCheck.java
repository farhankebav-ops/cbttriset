package com.unity3d.services.core.configuration;

import android.webkit.JavascriptInterface;
import com.unity3d.services.core.log.DeviceLog;
import com.unity3d.services.core.properties.SdkProperties;
import com.unity3d.services.core.webview.bridge.WebViewBridgeInterface;
import java.io.File;
import java.lang.annotation.Annotation;
import java.lang.reflect.Method;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes5.dex */
public class EnvironmentCheck {
    private static boolean hasJavascriptInterface(Method method) {
        Annotation[] annotations = method.getAnnotations();
        if (annotations != null) {
            for (Annotation annotation : annotations) {
                if (annotation instanceof JavascriptInterface) {
                    return true;
                }
            }
        }
        return false;
    }

    public static boolean isEnvironmentOk() {
        return testProGuard() && testCacheDirectory();
    }

    public static boolean testCacheDirectory() {
        File cacheDirectory = SdkProperties.getCacheDirectory();
        File webViewCacheDirectory = SdkProperties.getWebViewCacheDirectory();
        if (cacheDirectory == null || webViewCacheDirectory == null) {
            DeviceLog.error("Unity Ads cache directory check fail: no working cache directory available");
            return false;
        }
        DeviceLog.debug("Unity Ads cache directory check OK");
        return true;
    }

    public static boolean testProGuard() {
        try {
            Method method = WebViewBridgeInterface.class.getMethod("handleInvocation", String.class);
            Method method2 = WebViewBridgeInterface.class.getMethod("handleCallback", String.class, String.class, String.class);
            if (hasJavascriptInterface(method) && hasJavascriptInterface(method2)) {
                DeviceLog.debug("Unity Ads ProGuard check OK");
                return true;
            }
            DeviceLog.error("Unity Ads ProGuard check fail: missing @JavascriptInterface annotations in Unity Ads web bridge");
            return false;
        } catch (ClassNotFoundException e) {
            DeviceLog.exception("Unity Ads ProGuard check fail: Unity Ads web bridge class not found", e);
            return false;
        } catch (NoSuchMethodException e4) {
            DeviceLog.exception("Unity Ads ProGuard check fail: Unity Ads web bridge methods not found", e4);
            return false;
        } catch (Exception e8) {
            DeviceLog.exception("Unknown exception during Unity Ads ProGuard check: " + e8.getMessage(), e8);
            return true;
        }
    }
}
