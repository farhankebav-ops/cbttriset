package com.onesignal.user.state;

import kotlin.jvm.internal.k;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes5.dex */
public final class UserChangedState {
    private final UserState current;

    public UserChangedState(UserState current) {
        k.e(current, "current");
        this.current = current;
    }

    public final UserState getCurrent() {
        return this.current;
    }

    public final JSONObject toJSONObject() throws JSONException {
        JSONObject jSONObjectPut = new JSONObject().put("current", this.current.toJSONObject());
        k.d(jSONObjectPut, "JSONObject()\n           …, current.toJSONObject())");
        return jSONObjectPut;
    }
}
