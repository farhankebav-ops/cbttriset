package com.onesignal.session.internal.outcomes.impl;

import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes5.dex */
public final class OutcomeSource {
    private OutcomeSourceBody directBody;
    private OutcomeSourceBody indirectBody;

    public OutcomeSource(OutcomeSourceBody outcomeSourceBody, OutcomeSourceBody outcomeSourceBody2) {
        this.directBody = outcomeSourceBody;
        this.indirectBody = outcomeSourceBody2;
    }

    public final OutcomeSourceBody getDirectBody() {
        return this.directBody;
    }

    public final OutcomeSourceBody getIndirectBody() {
        return this.indirectBody;
    }

    /* JADX INFO: renamed from: setDirectBody, reason: collision with other method in class */
    public final void m3176setDirectBody(OutcomeSourceBody outcomeSourceBody) {
        this.directBody = outcomeSourceBody;
    }

    /* JADX INFO: renamed from: setIndirectBody, reason: collision with other method in class */
    public final void m3177setIndirectBody(OutcomeSourceBody outcomeSourceBody) {
        this.indirectBody = outcomeSourceBody;
    }

    public final JSONObject toJSONObject() throws JSONException {
        JSONObject jSONObject = new JSONObject();
        OutcomeSourceBody outcomeSourceBody = this.directBody;
        if (outcomeSourceBody != null) {
            jSONObject.put("direct", outcomeSourceBody.toJSONObject());
        }
        OutcomeSourceBody outcomeSourceBody2 = this.indirectBody;
        if (outcomeSourceBody2 != null) {
            jSONObject.put(OutcomeConstants.INDIRECT, outcomeSourceBody2.toJSONObject());
        }
        return jSONObject;
    }

    public String toString() {
        return "OutcomeSource{directBody=" + this.directBody + ", indirectBody=" + this.indirectBody + '}';
    }

    public final OutcomeSource setDirectBody(OutcomeSourceBody outcomeSourceBody) {
        this.directBody = outcomeSourceBody;
        return this;
    }

    public final OutcomeSource setIndirectBody(OutcomeSourceBody outcomeSourceBody) {
        this.indirectBody = outcomeSourceBody;
        return this;
    }
}
