package com.onesignal.notifications.internal;

import com.onesignal.core.internal.database.impl.OneSignalDbContract;
import com.onesignal.notifications.INotification;
import com.onesignal.notifications.INotificationClickEvent;
import com.onesignal.notifications.INotificationClickResult;
import kotlin.jvm.internal.k;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes5.dex */
public final class NotificationClickEvent implements INotificationClickEvent {
    private final Notification _notification;
    private final NotificationClickResult _result;

    public NotificationClickEvent(Notification _notification, NotificationClickResult _result) {
        k.e(_notification, "_notification");
        k.e(_result, "_result");
        this._notification = _notification;
        this._result = _result;
    }

    @Override // com.onesignal.notifications.INotificationClickEvent
    public INotification getNotification() {
        return this._notification;
    }

    @Override // com.onesignal.notifications.INotificationClickEvent
    public INotificationClickResult getResult() {
        return this._result;
    }

    public final JSONObject toJSONObject() throws JSONException {
        JSONObject jSONObjectPut = new JSONObject().put(OneSignalDbContract.NotificationTable.TABLE_NAME, this._notification.toJSONObject()).put("action", this._result.toJSONObject());
        k.d(jSONObjectPut, "JSONObject()\n           …, _result.toJSONObject())");
        return jSONObjectPut;
    }
}
