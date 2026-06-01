package com.onesignal.user.subscriptions;

import kotlin.jvm.internal.k;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes5.dex */
public final class PushSubscriptionChangedState {
    private final PushSubscriptionState current;
    private final PushSubscriptionState previous;

    public PushSubscriptionChangedState(PushSubscriptionState previous, PushSubscriptionState current) {
        k.e(previous, "previous");
        k.e(current, "current");
        this.previous = previous;
        this.current = current;
    }

    public final PushSubscriptionState getCurrent() {
        return this.current;
    }

    public final PushSubscriptionState getPrevious() {
        return this.previous;
    }

    public final JSONObject toJSONObject() throws JSONException {
        JSONObject jSONObjectPut = new JSONObject().put("previous", this.previous.toJSONObject()).put("current", this.current.toJSONObject());
        k.d(jSONObjectPut, "JSONObject()\n           …, current.toJSONObject())");
        return jSONObjectPut;
    }
}
