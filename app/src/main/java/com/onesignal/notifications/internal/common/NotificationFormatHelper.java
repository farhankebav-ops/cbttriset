package com.onesignal.notifications.internal.common;

import android.content.Intent;
import android.os.Bundle;
import com.onesignal.debug.internal.logging.Logging;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes5.dex */
public final class NotificationFormatHelper {
    public static final NotificationFormatHelper INSTANCE = new NotificationFormatHelper();
    public static final String PAYLOAD_OS_NOTIFICATION_ID = "i";
    public static final String PAYLOAD_OS_ROOT_CUSTOM = "custom";

    private NotificationFormatHelper() {
    }

    private final String getOSNotificationIdFromBundle(Bundle bundle) {
        if (bundle != null && !bundle.isEmpty()) {
            String string = bundle.getString(PAYLOAD_OS_ROOT_CUSTOM, null);
            if (string != null) {
                return getOSNotificationIdFromJsonString(string);
            }
            Logging.debug$default("Not a OneSignal formatted Bundle. No 'custom' field in the bundle.", null, 2, null);
        }
        return null;
    }

    private final String getOSNotificationIdFromJsonString(String str) {
        JSONObject jSONObject;
        try {
            jSONObject = new JSONObject(str);
        } catch (JSONException unused) {
            Logging.debug$default("Not a OneSignal formatted JSON String, error parsing string as JSON.", null, 2, null);
        }
        if (jSONObject.has("i")) {
            return jSONObject.optString("i", null);
        }
        Logging.debug$default("Not a OneSignal formatted JSON string. No 'i' field in custom.", null, 2, null);
        return null;
    }

    public final String getOSNotificationIdFromJson(JSONObject jSONObject) {
        if (jSONObject == null) {
            return null;
        }
        return getOSNotificationIdFromJsonString(jSONObject.optString(PAYLOAD_OS_ROOT_CUSTOM, null));
    }

    public final boolean isOneSignalBundle(Bundle bundle) {
        return getOSNotificationIdFromBundle(bundle) != null;
    }

    public final boolean isOneSignalIntent(Intent intent) {
        if (intent == null) {
            return false;
        }
        return isOneSignalBundle(intent.getExtras());
    }
}
