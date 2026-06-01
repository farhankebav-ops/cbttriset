package com.onesignal.notifications.internal.common;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import com.onesignal.common.AndroidUtils;
import kotlin.jvm.internal.k;
import org.json.JSONObject;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes5.dex */
public final class GenerateNotificationOpenIntentFromPushPayload {
    public static final GenerateNotificationOpenIntentFromPushPayload INSTANCE = new GenerateNotificationOpenIntentFromPushPayload();

    private GenerateNotificationOpenIntentFromPushPayload() {
    }

    private final Intent openBrowserIntent(Uri uri) {
        if (uri == null) {
            return null;
        }
        return AndroidUtils.INSTANCE.openURLInBrowserIntent(uri);
    }

    public final GenerateNotificationOpenIntent create(Context context, JSONObject fcmPayload) {
        k.e(context, "context");
        k.e(fcmPayload, "fcmPayload");
        OSNotificationOpenBehaviorFromPushPayload oSNotificationOpenBehaviorFromPushPayload = new OSNotificationOpenBehaviorFromPushPayload(context, fcmPayload);
        return new GenerateNotificationOpenIntent(context, openBrowserIntent(oSNotificationOpenBehaviorFromPushPayload.getUri()), oSNotificationOpenBehaviorFromPushPayload.getShouldOpenApp());
    }
}
