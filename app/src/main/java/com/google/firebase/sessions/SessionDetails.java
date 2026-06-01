package com.google.firebase.sessions;

import b7.h;
import d7.g;
import f7.c1;
import f7.m1;
import kotlin.jvm.internal.f;
import kotlin.jvm.internal.k;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes4.dex */
@h
public final class SessionDetails {
    public static final Companion Companion = new Companion(null);
    private final String firstSessionId;
    private final String sessionId;
    private final int sessionIndex;
    private final long sessionStartTimestampUs;

    /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
    public static final class Companion {
        private Companion() {
        }

        public final b7.c serializer() {
            return SessionDetails$$serializer.INSTANCE;
        }

        public /* synthetic */ Companion(f fVar) {
            this();
        }
    }

    public /* synthetic */ SessionDetails(int i2, String str, String str2, int i8, long j, m1 m1Var) {
        if (15 != (i2 & 15)) {
            c1.j(SessionDetails$$serializer.INSTANCE.getDescriptor(), i2, 15);
            throw null;
        }
        this.sessionId = str;
        this.firstSessionId = str2;
        this.sessionIndex = i8;
        this.sessionStartTimestampUs = j;
    }

    public static /* synthetic */ SessionDetails copy$default(SessionDetails sessionDetails, String str, String str2, int i2, long j, int i8, Object obj) {
        if ((i8 & 1) != 0) {
            str = sessionDetails.sessionId;
        }
        if ((i8 & 2) != 0) {
            str2 = sessionDetails.firstSessionId;
        }
        if ((i8 & 4) != 0) {
            i2 = sessionDetails.sessionIndex;
        }
        if ((i8 & 8) != 0) {
            j = sessionDetails.sessionStartTimestampUs;
        }
        int i9 = i2;
        return sessionDetails.copy(str, str2, i9, j);
    }

    public static final /* synthetic */ void write$Self$com_google_firebase_firebase_sessions(SessionDetails sessionDetails, e7.d dVar, g gVar) {
        dVar.encodeStringElement(gVar, 0, sessionDetails.sessionId);
        dVar.encodeStringElement(gVar, 1, sessionDetails.firstSessionId);
        dVar.encodeIntElement(gVar, 2, sessionDetails.sessionIndex);
        dVar.encodeLongElement(gVar, 3, sessionDetails.sessionStartTimestampUs);
    }

    public final String component1() {
        return this.sessionId;
    }

    public final String component2() {
        return this.firstSessionId;
    }

    public final int component3() {
        return this.sessionIndex;
    }

    public final long component4() {
        return this.sessionStartTimestampUs;
    }

    public final SessionDetails copy(String sessionId, String firstSessionId, int i2, long j) {
        k.e(sessionId, "sessionId");
        k.e(firstSessionId, "firstSessionId");
        return new SessionDetails(sessionId, firstSessionId, i2, j);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof SessionDetails)) {
            return false;
        }
        SessionDetails sessionDetails = (SessionDetails) obj;
        return k.a(this.sessionId, sessionDetails.sessionId) && k.a(this.firstSessionId, sessionDetails.firstSessionId) && this.sessionIndex == sessionDetails.sessionIndex && this.sessionStartTimestampUs == sessionDetails.sessionStartTimestampUs;
    }

    public final String getFirstSessionId() {
        return this.firstSessionId;
    }

    public final String getSessionId() {
        return this.sessionId;
    }

    public final int getSessionIndex() {
        return this.sessionIndex;
    }

    public final long getSessionStartTimestampUs() {
        return this.sessionStartTimestampUs;
    }

    public int hashCode() {
        int iB = (androidx.camera.core.processing.util.a.b(this.sessionId.hashCode() * 31, 31, this.firstSessionId) + this.sessionIndex) * 31;
        long j = this.sessionStartTimestampUs;
        return iB + ((int) (j ^ (j >>> 32)));
    }

    public String toString() {
        return "SessionDetails(sessionId=" + this.sessionId + ", firstSessionId=" + this.firstSessionId + ", sessionIndex=" + this.sessionIndex + ", sessionStartTimestampUs=" + this.sessionStartTimestampUs + ')';
    }

    public SessionDetails(String sessionId, String firstSessionId, int i2, long j) {
        k.e(sessionId, "sessionId");
        k.e(firstSessionId, "firstSessionId");
        this.sessionId = sessionId;
        this.firstSessionId = firstSessionId;
        this.sessionIndex = i2;
        this.sessionStartTimestampUs = j;
    }
}
