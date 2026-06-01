package com.onesignal.user.subscriptions;

import kotlin.jvm.internal.k;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes5.dex */
public final class PushSubscriptionState {
    private final String id;
    private final boolean optedIn;
    private final String token;

    public PushSubscriptionState(String id, String token, boolean z2) {
        k.e(id, "id");
        k.e(token, "token");
        this.id = id;
        this.token = token;
        this.optedIn = z2;
    }

    public final String getId() {
        return this.id;
    }

    public final boolean getOptedIn() {
        return this.optedIn;
    }

    public final String getToken() {
        return this.token;
    }

    public final JSONObject toJSONObject() throws JSONException {
        JSONObject jSONObjectPut = new JSONObject().put("id", this.id).put("token", this.token).put("optedIn", this.optedIn);
        k.d(jSONObjectPut, "JSONObject()\n           … .put(\"optedIn\", optedIn)");
        return jSONObjectPut;
    }
}
