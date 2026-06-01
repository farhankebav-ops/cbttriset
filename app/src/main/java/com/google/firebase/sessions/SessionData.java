package com.google.firebase.sessions;

import b7.h;
import d7.g;
import f7.c1;
import f7.g0;
import f7.m1;
import f7.q1;
import java.util.Map;
import kotlin.jvm.internal.f;
import kotlin.jvm.internal.k;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes4.dex */
@h
public final class SessionData {
    private final Time backgroundTime;
    private final Map<String, ProcessData> processDataMap;
    private final SessionDetails sessionDetails;
    public static final Companion Companion = new Companion(null);
    private static final b7.c[] $childSerializers = {null, null, new g0(q1.f11501a, ProcessData$$serializer.INSTANCE, 1)};

    /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
    public static final class Companion {
        private Companion() {
        }

        public final b7.c serializer() {
            return SessionData$$serializer.INSTANCE;
        }

        public /* synthetic */ Companion(f fVar) {
            this();
        }
    }

    public /* synthetic */ SessionData(int i2, SessionDetails sessionDetails, Time time, Map map, m1 m1Var) {
        if (1 != (i2 & 1)) {
            c1.j(SessionData$$serializer.INSTANCE.getDescriptor(), i2, 1);
            throw null;
        }
        this.sessionDetails = sessionDetails;
        if ((i2 & 2) == 0) {
            this.backgroundTime = null;
        } else {
            this.backgroundTime = time;
        }
        if ((i2 & 4) == 0) {
            this.processDataMap = null;
        } else {
            this.processDataMap = map;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ SessionData copy$default(SessionData sessionData, SessionDetails sessionDetails, Time time, Map map, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            sessionDetails = sessionData.sessionDetails;
        }
        if ((i2 & 2) != 0) {
            time = sessionData.backgroundTime;
        }
        if ((i2 & 4) != 0) {
            map = sessionData.processDataMap;
        }
        return sessionData.copy(sessionDetails, time, map);
    }

    public static final /* synthetic */ void write$Self$com_google_firebase_firebase_sessions(SessionData sessionData, e7.d dVar, g gVar) {
        b7.c[] cVarArr = $childSerializers;
        dVar.encodeSerializableElement(gVar, 0, SessionDetails$$serializer.INSTANCE, sessionData.sessionDetails);
        if (dVar.shouldEncodeElementDefault(gVar, 1) || sessionData.backgroundTime != null) {
            dVar.encodeNullableSerializableElement(gVar, 1, Time$$serializer.INSTANCE, sessionData.backgroundTime);
        }
        if (!dVar.shouldEncodeElementDefault(gVar, 2) && sessionData.processDataMap == null) {
            return;
        }
        dVar.encodeNullableSerializableElement(gVar, 2, cVarArr[2], sessionData.processDataMap);
    }

    public final SessionDetails component1() {
        return this.sessionDetails;
    }

    public final Time component2() {
        return this.backgroundTime;
    }

    public final Map<String, ProcessData> component3() {
        return this.processDataMap;
    }

    public final SessionData copy(SessionDetails sessionDetails, Time time, Map<String, ProcessData> map) {
        k.e(sessionDetails, "sessionDetails");
        return new SessionData(sessionDetails, time, map);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof SessionData)) {
            return false;
        }
        SessionData sessionData = (SessionData) obj;
        return k.a(this.sessionDetails, sessionData.sessionDetails) && k.a(this.backgroundTime, sessionData.backgroundTime) && k.a(this.processDataMap, sessionData.processDataMap);
    }

    public final Time getBackgroundTime() {
        return this.backgroundTime;
    }

    public final Map<String, ProcessData> getProcessDataMap() {
        return this.processDataMap;
    }

    public final SessionDetails getSessionDetails() {
        return this.sessionDetails;
    }

    public int hashCode() {
        int iHashCode = this.sessionDetails.hashCode() * 31;
        Time time = this.backgroundTime;
        int iHashCode2 = (iHashCode + (time == null ? 0 : time.hashCode())) * 31;
        Map<String, ProcessData> map = this.processDataMap;
        return iHashCode2 + (map != null ? map.hashCode() : 0);
    }

    public String toString() {
        return "SessionData(sessionDetails=" + this.sessionDetails + ", backgroundTime=" + this.backgroundTime + ", processDataMap=" + this.processDataMap + ')';
    }

    public SessionData(SessionDetails sessionDetails, Time time, Map<String, ProcessData> map) {
        k.e(sessionDetails, "sessionDetails");
        this.sessionDetails = sessionDetails;
        this.backgroundTime = time;
        this.processDataMap = map;
    }

    public /* synthetic */ SessionData(SessionDetails sessionDetails, Time time, Map map, int i2, f fVar) {
        this(sessionDetails, (i2 & 2) != 0 ? null : time, (i2 & 4) != 0 ? null : map);
    }
}
