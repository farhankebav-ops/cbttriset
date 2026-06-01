package com.onesignal.session.internal.outcomes.impl;

import com.onesignal.session.internal.influence.InfluenceType;
import com.onesignal.session.internal.outcomes.IOutcomeEvent;
import kotlin.jvm.internal.f;
import kotlin.jvm.internal.k;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes5.dex */
public final class OutcomeEvent implements IOutcomeEvent {
    public static final Companion Companion = new Companion(null);
    private static final String NOTIFICATION_IDS = "notification_ids";
    private static final String OUTCOME_ID = "id";
    private static final String SESSION = "session";
    private static final String SESSION_TIME = "session_time";
    private static final String TIMESTAMP = "timestamp";
    private static final String WEIGHT = "weight";
    private final String name;
    private final JSONArray notificationIds;
    private final InfluenceType session;
    private final long sessionTime;
    private final long timestamp;
    private final float weight;

    /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
    public static final class Companion {
        public /* synthetic */ Companion(f fVar) {
            this();
        }

        /* JADX WARN: Removed duplicated region for block: B:12:0x0048  */
        /* JADX WARN: Removed duplicated region for block: B:19:0x007d  */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public final com.onesignal.session.internal.outcomes.impl.OutcomeEvent fromOutcomeEventParamstoOutcomeEvent(com.onesignal.session.internal.outcomes.impl.OutcomeEventParams r12) {
            /*
                r11 = this;
                java.lang.String r0 = "outcomeEventParams"
                kotlin.jvm.internal.k.e(r12, r0)
                com.onesignal.session.internal.influence.InfluenceType r0 = com.onesignal.session.internal.influence.InfluenceType.UNATTRIBUTED
                com.onesignal.session.internal.outcomes.impl.OutcomeSource r1 = r12.getOutcomeSource()
                if (r1 == 0) goto L7d
                com.onesignal.session.internal.outcomes.impl.OutcomeSource r1 = r12.getOutcomeSource()
                com.onesignal.session.internal.outcomes.impl.OutcomeSourceBody r2 = r1.getDirectBody()
                if (r2 == 0) goto L48
                com.onesignal.session.internal.outcomes.impl.OutcomeSourceBody r2 = r1.getDirectBody()
                kotlin.jvm.internal.k.b(r2)
                org.json.JSONArray r2 = r2.getNotificationIds()
                if (r2 == 0) goto L48
                com.onesignal.session.internal.outcomes.impl.OutcomeSourceBody r2 = r1.getDirectBody()
                kotlin.jvm.internal.k.b(r2)
                org.json.JSONArray r2 = r2.getNotificationIds()
                kotlin.jvm.internal.k.b(r2)
                int r2 = r2.length()
                if (r2 <= 0) goto L48
                com.onesignal.session.internal.influence.InfluenceType r0 = com.onesignal.session.internal.influence.InfluenceType.DIRECT
                com.onesignal.session.internal.outcomes.impl.OutcomeSourceBody r1 = r1.getDirectBody()
                kotlin.jvm.internal.k.b(r1)
                org.json.JSONArray r1 = r1.getNotificationIds()
            L45:
                r3 = r0
                r4 = r1
                goto L7f
            L48:
                com.onesignal.session.internal.outcomes.impl.OutcomeSourceBody r2 = r1.getIndirectBody()
                if (r2 == 0) goto L7d
                com.onesignal.session.internal.outcomes.impl.OutcomeSourceBody r2 = r1.getIndirectBody()
                kotlin.jvm.internal.k.b(r2)
                org.json.JSONArray r2 = r2.getNotificationIds()
                if (r2 == 0) goto L7d
                com.onesignal.session.internal.outcomes.impl.OutcomeSourceBody r2 = r1.getIndirectBody()
                kotlin.jvm.internal.k.b(r2)
                org.json.JSONArray r2 = r2.getNotificationIds()
                kotlin.jvm.internal.k.b(r2)
                int r2 = r2.length()
                if (r2 <= 0) goto L7d
                com.onesignal.session.internal.influence.InfluenceType r0 = com.onesignal.session.internal.influence.InfluenceType.INDIRECT
                com.onesignal.session.internal.outcomes.impl.OutcomeSourceBody r1 = r1.getIndirectBody()
                kotlin.jvm.internal.k.b(r1)
                org.json.JSONArray r1 = r1.getNotificationIds()
                goto L45
            L7d:
                r1 = 0
                goto L45
            L7f:
                com.onesignal.session.internal.outcomes.impl.OutcomeEvent r2 = new com.onesignal.session.internal.outcomes.impl.OutcomeEvent
                java.lang.String r5 = r12.getOutcomeId()
                long r6 = r12.getTimestamp()
                long r8 = r12.getSessionTime()
                float r10 = r12.getWeight()
                r2.<init>(r3, r4, r5, r6, r8, r10)
                return r2
            */
            throw new UnsupportedOperationException("Method not decompiled: com.onesignal.session.internal.outcomes.impl.OutcomeEvent.Companion.fromOutcomeEventParamstoOutcomeEvent(com.onesignal.session.internal.outcomes.impl.OutcomeEventParams):com.onesignal.session.internal.outcomes.impl.OutcomeEvent");
        }

        private Companion() {
        }
    }

    public OutcomeEvent(InfluenceType session, JSONArray jSONArray, String name, long j, long j3, float f4) {
        k.e(session, "session");
        k.e(name, "name");
        this.session = session;
        this.notificationIds = jSONArray;
        this.name = name;
        this.timestamp = j;
        this.sessionTime = j3;
        this.weight = f4;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && OutcomeEvent.class.equals(obj.getClass())) {
            OutcomeEvent outcomeEvent = (OutcomeEvent) obj;
            if (getSession() == outcomeEvent.getSession() && k.a(getNotificationIds(), outcomeEvent.getNotificationIds()) && k.a(getName(), outcomeEvent.getName()) && getTimestamp() == outcomeEvent.getTimestamp() && getSessionTime() == outcomeEvent.getSessionTime() && getWeight() == outcomeEvent.getWeight()) {
                return true;
            }
        }
        return false;
    }

    @Override // com.onesignal.session.internal.outcomes.IOutcomeEvent
    public String getName() {
        return this.name;
    }

    @Override // com.onesignal.session.internal.outcomes.IOutcomeEvent
    public JSONArray getNotificationIds() {
        return this.notificationIds;
    }

    @Override // com.onesignal.session.internal.outcomes.IOutcomeEvent
    public InfluenceType getSession() {
        return this.session;
    }

    @Override // com.onesignal.session.internal.outcomes.IOutcomeEvent
    public long getSessionTime() {
        return this.sessionTime;
    }

    @Override // com.onesignal.session.internal.outcomes.IOutcomeEvent
    public long getTimestamp() {
        return this.timestamp;
    }

    @Override // com.onesignal.session.internal.outcomes.IOutcomeEvent
    public float getWeight() {
        return this.weight;
    }

    public int hashCode() {
        int iHashCode = 1;
        Object[] objArr = {getSession(), getNotificationIds(), getName(), Long.valueOf(getTimestamp()), Long.valueOf(getSessionTime()), Float.valueOf(getWeight())};
        for (int i2 = 0; i2 < 6; i2++) {
            Object obj = objArr[i2];
            iHashCode = (iHashCode * 31) + (obj != null ? obj.hashCode() : 0);
        }
        return iHashCode;
    }

    public final JSONObject toJSONObject() throws JSONException {
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("session", getSession());
        jSONObject.put("notification_ids", getNotificationIds());
        jSONObject.put("id", getName());
        jSONObject.put("timestamp", getTimestamp());
        jSONObject.put("session_time", getSessionTime());
        jSONObject.put("weight", Float.valueOf(getWeight()));
        return jSONObject;
    }

    public String toString() {
        return "OutcomeEvent{session=" + getSession() + ", notificationIds=" + getNotificationIds() + ", name='" + getName() + "', timestamp=" + getTimestamp() + ", sessionTime=" + getSessionTime() + ", weight=" + getWeight() + '}';
    }
}
