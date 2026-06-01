package com.onesignal.user.state;

import kotlin.jvm.internal.k;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes5.dex */
public final class UserState {
    private final String externalId;
    private final String onesignalId;

    public UserState(String onesignalId, String externalId) {
        k.e(onesignalId, "onesignalId");
        k.e(externalId, "externalId");
        this.onesignalId = onesignalId;
        this.externalId = externalId;
    }

    public final String getExternalId() {
        return this.externalId;
    }

    public final String getOnesignalId() {
        return this.onesignalId;
    }

    public final JSONObject toJSONObject() throws JSONException {
        JSONObject jSONObjectPut = new JSONObject().put("onesignalId", this.onesignalId).put("externalId", this.externalId);
        k.d(jSONObjectPut, "JSONObject()\n           …\"externalId\", externalId)");
        return jSONObjectPut;
    }
}
