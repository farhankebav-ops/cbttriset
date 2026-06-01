package com.google.firebase.crashlytics.internal.metadata;

import java.util.Map;
import kotlin.jvm.internal.f;
import kotlin.jvm.internal.k;
import r5.s;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes4.dex */
public final class EventMetadata {
    private final Map<String, String> additionalCustomKeys;
    private final String sessionId;
    private final long timestamp;

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public EventMetadata(String sessionId, long j) {
        this(sessionId, j, null, 4, null);
        k.e(sessionId, "sessionId");
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ EventMetadata copy$default(EventMetadata eventMetadata, String str, long j, Map map, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            str = eventMetadata.sessionId;
        }
        if ((i2 & 2) != 0) {
            j = eventMetadata.timestamp;
        }
        if ((i2 & 4) != 0) {
            map = eventMetadata.additionalCustomKeys;
        }
        return eventMetadata.copy(str, j, map);
    }

    public final String component1() {
        return this.sessionId;
    }

    public final long component2() {
        return this.timestamp;
    }

    public final Map<String, String> component3() {
        return this.additionalCustomKeys;
    }

    public final EventMetadata copy(String sessionId, long j, Map<String, String> additionalCustomKeys) {
        k.e(sessionId, "sessionId");
        k.e(additionalCustomKeys, "additionalCustomKeys");
        return new EventMetadata(sessionId, j, additionalCustomKeys);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof EventMetadata)) {
            return false;
        }
        EventMetadata eventMetadata = (EventMetadata) obj;
        return k.a(this.sessionId, eventMetadata.sessionId) && this.timestamp == eventMetadata.timestamp && k.a(this.additionalCustomKeys, eventMetadata.additionalCustomKeys);
    }

    public final Map<String, String> getAdditionalCustomKeys() {
        return this.additionalCustomKeys;
    }

    public final String getSessionId() {
        return this.sessionId;
    }

    public final long getTimestamp() {
        return this.timestamp;
    }

    public int hashCode() {
        int iHashCode = this.sessionId.hashCode() * 31;
        long j = this.timestamp;
        return this.additionalCustomKeys.hashCode() + ((iHashCode + ((int) (j ^ (j >>> 32)))) * 31);
    }

    public String toString() {
        return "EventMetadata(sessionId=" + this.sessionId + ", timestamp=" + this.timestamp + ", additionalCustomKeys=" + this.additionalCustomKeys + ')';
    }

    public EventMetadata(String sessionId, long j, Map<String, String> additionalCustomKeys) {
        k.e(sessionId, "sessionId");
        k.e(additionalCustomKeys, "additionalCustomKeys");
        this.sessionId = sessionId;
        this.timestamp = j;
        this.additionalCustomKeys = additionalCustomKeys;
    }

    public /* synthetic */ EventMetadata(String str, long j, Map map, int i2, f fVar) {
        this(str, j, (i2 & 4) != 0 ? s.f13639a : map);
    }
}
