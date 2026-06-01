package com.unity3d.services.ads.api;

import android.view.InputEvent;
import com.unity3d.services.ads.measurements.MeasurementsErrors;
import com.unity3d.services.ads.measurements.MeasurementsService;
import com.unity3d.services.core.misc.Utilities;
import com.unity3d.services.core.webview.bridge.WebViewCallback;
import com.unity3d.services.core.webview.bridge.WebViewExposed;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes5.dex */
public class Measurements {
    private static final MeasurementsService measurementsService = (MeasurementsService) Utilities.getService(MeasurementsService.class);

    @WebViewExposed
    public static void checkAvailability(WebViewCallback webViewCallback) {
        measurementsService.checkAvailability();
        webViewCallback.invoke(new Object[0]);
    }

    @WebViewExposed
    public static void registerClick(String str, WebViewCallback webViewCallback) {
        if (AdUnit.getAdUnitActivity() == null) {
            webViewCallback.error(MeasurementsErrors.ERROR_AD_UNIT_NULL, new Object[0]);
            return;
        }
        if (AdUnit.getAdUnitActivity().getLayout() == null) {
            webViewCallback.error(MeasurementsErrors.ERROR_LAYOUT_NULL, new Object[0]);
            return;
        }
        InputEvent lastInputEvent = AdUnit.getAdUnitActivity().getLayout().getLastInputEvent();
        if (lastInputEvent == null) {
            webViewCallback.error(MeasurementsErrors.ERROR_LAST_INPUT_EVENT_NULL, new Object[0]);
        } else {
            measurementsService.registerClick(str, lastInputEvent);
            webViewCallback.invoke(new Object[0]);
        }
    }

    @WebViewExposed
    public static void registerTrigger(String str, WebViewCallback webViewCallback) {
        measurementsService.registerTrigger(str);
        webViewCallback.invoke(new Object[0]);
    }

    @WebViewExposed
    public static void registerView(String str, WebViewCallback webViewCallback) {
        measurementsService.registerView(str);
        webViewCallback.invoke(new Object[0]);
    }
}
