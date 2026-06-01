package com.onesignal.notifications.internal.common;

import android.content.Context;
import android.net.Uri;
import kotlin.jvm.internal.k;
import org.json.JSONObject;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes5.dex */
public final class OSNotificationOpenBehaviorFromPushPayload {
    private final Context context;
    private final JSONObject fcmPayload;

    public OSNotificationOpenBehaviorFromPushPayload(Context context, JSONObject fcmPayload) {
        k.e(context, "context");
        k.e(fcmPayload, "fcmPayload");
        this.context = context;
        this.fcmPayload = fcmPayload;
    }

    public final boolean getShouldOpenApp() {
        return OSNotificationOpenAppSettings.INSTANCE.getShouldOpenActivity(this.context) && getUri() == null;
    }

    public final Uri getUri() {
        OSNotificationOpenAppSettings oSNotificationOpenAppSettings = OSNotificationOpenAppSettings.INSTANCE;
        if (!oSNotificationOpenAppSettings.getShouldOpenActivity(this.context) || oSNotificationOpenAppSettings.getSuppressLaunchURL(this.context)) {
            return null;
        }
        JSONObject jSONObject = new JSONObject(this.fcmPayload.optString(NotificationFormatHelper.PAYLOAD_OS_ROOT_CUSTOM));
        if (jSONObject.has("u")) {
            String url = jSONObject.optString("u");
            if (!k.a(url, "")) {
                k.d(url, "url");
                int length = url.length() - 1;
                int i2 = 0;
                boolean z2 = false;
                while (i2 <= length) {
                    boolean z7 = k.g(url.charAt(!z2 ? i2 : length), 32) <= 0;
                    if (z2) {
                        if (!z7) {
                            break;
                        }
                        length--;
                    } else if (z7) {
                        i2++;
                    } else {
                        z2 = true;
                    }
                }
                return Uri.parse(url.subSequence(i2, length + 1).toString());
            }
        }
        return null;
    }
}
