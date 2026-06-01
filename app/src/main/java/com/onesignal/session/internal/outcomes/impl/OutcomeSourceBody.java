package com.onesignal.session.internal.outcomes.impl;

import kotlin.jvm.internal.f;
import kotlin.jvm.internal.k;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes5.dex */
public final class OutcomeSourceBody {
    private JSONArray inAppMessagesIds;
    private JSONArray notificationIds;

    public OutcomeSourceBody() {
        this(null, 0 == true ? 1 : 0, 3, 0 == true ? 1 : 0);
    }

    public final JSONArray getInAppMessagesIds() {
        return this.inAppMessagesIds;
    }

    public final JSONArray getNotificationIds() {
        return this.notificationIds;
    }

    public final void setInAppMessagesIds(JSONArray jSONArray) {
        this.inAppMessagesIds = jSONArray;
    }

    public final void setNotificationIds(JSONArray jSONArray) {
        this.notificationIds = jSONArray;
    }

    public final JSONObject toJSONObject() throws JSONException {
        JSONObject jSONObjectPut = new JSONObject().put("notification_ids", this.notificationIds).put(OutcomeConstants.IAM_IDS, this.inAppMessagesIds);
        k.d(jSONObjectPut, "JSONObject()\n           …AM_IDS, inAppMessagesIds)");
        return jSONObjectPut;
    }

    public String toString() {
        return "OutcomeSourceBody{notificationIds=" + this.notificationIds + ", inAppMessagesIds=" + this.inAppMessagesIds + '}';
    }

    public OutcomeSourceBody(JSONArray jSONArray) {
        this(jSONArray, null, 2, 0 == true ? 1 : 0);
    }

    public OutcomeSourceBody(JSONArray jSONArray, JSONArray jSONArray2) {
        this.notificationIds = jSONArray;
        this.inAppMessagesIds = jSONArray2;
    }

    public /* synthetic */ OutcomeSourceBody(JSONArray jSONArray, JSONArray jSONArray2, int i2, f fVar) {
        this((i2 & 1) != 0 ? new JSONArray() : jSONArray, (i2 & 2) != 0 ? new JSONArray() : jSONArray2);
    }
}
