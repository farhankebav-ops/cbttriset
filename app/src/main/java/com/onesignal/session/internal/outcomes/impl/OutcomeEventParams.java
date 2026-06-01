package com.onesignal.session.internal.outcomes.impl;

import kotlin.jvm.internal.k;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes5.dex */
public final class OutcomeEventParams {
    private final String outcomeId;
    private final OutcomeSource outcomeSource;
    private long sessionTime;
    private long timestamp;
    private float weight;

    public OutcomeEventParams(String outcomeId, OutcomeSource outcomeSource, float f4, long j, long j3) {
        k.e(outcomeId, "outcomeId");
        this.outcomeId = outcomeId;
        this.outcomeSource = outcomeSource;
        this.weight = f4;
        this.sessionTime = j;
        this.timestamp = j3;
    }

    public final String getOutcomeId() {
        return this.outcomeId;
    }

    public final OutcomeSource getOutcomeSource() {
        return this.outcomeSource;
    }

    public final long getSessionTime() {
        return this.sessionTime;
    }

    public final long getTimestamp() {
        return this.timestamp;
    }

    public final float getWeight() {
        return this.weight;
    }

    public final boolean isUnattributed() {
        OutcomeSource outcomeSource = this.outcomeSource;
        if (outcomeSource != null) {
            return outcomeSource.getDirectBody() == null && this.outcomeSource.getIndirectBody() == null;
        }
        return true;
    }

    public final void setSessionTime(long j) {
        this.sessionTime = j;
    }

    public final void setTimestamp(long j) {
        this.timestamp = j;
    }

    public final void setWeight(float f4) {
        this.weight = f4;
    }

    public final JSONObject toJSONObject() throws JSONException {
        JSONObject json = new JSONObject().put("id", this.outcomeId);
        OutcomeSource outcomeSource = this.outcomeSource;
        if (outcomeSource != null) {
            json.put(OutcomeConstants.OUTCOME_SOURCES, outcomeSource.toJSONObject());
        }
        float f4 = this.weight;
        if (f4 > 0.0f) {
            json.put("weight", Float.valueOf(f4));
        }
        long j = this.timestamp;
        if (j > 0) {
            json.put("timestamp", j);
        }
        long j3 = this.sessionTime;
        if (j3 > 0) {
            json.put("session_time", j3);
        }
        k.d(json, "json");
        return json;
    }

    public String toString() {
        return "OutcomeEventParams{outcomeId='" + this.outcomeId + "', outcomeSource=" + this.outcomeSource + ", weight=" + this.weight + ", timestamp=" + this.timestamp + ", sessionTime=" + this.sessionTime + '}';
    }
}
