package com.onesignal.notifications.internal;

import com.onesignal.common.JSONObjectExtensionsKt;
import com.onesignal.notifications.INotificationClickResult;
import com.onesignal.notifications.internal.common.NotificationConstants;
import org.json.JSONObject;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes5.dex */
public final class NotificationClickResult implements INotificationClickResult {
    private final String actionId;
    private final String url;

    public NotificationClickResult(String str, String str2) {
        this.actionId = str;
        this.url = str2;
    }

    @Override // com.onesignal.notifications.INotificationClickResult
    public String getActionId() {
        return this.actionId;
    }

    @Override // com.onesignal.notifications.INotificationClickResult
    public String getUrl() {
        return this.url;
    }

    public final JSONObject toJSONObject() {
        return JSONObjectExtensionsKt.putSafe(JSONObjectExtensionsKt.putSafe(new JSONObject(), NotificationConstants.GENERATE_NOTIFICATION_BUNDLE_KEY_ACTION_ID, getActionId()), "url", getUrl());
    }
}
