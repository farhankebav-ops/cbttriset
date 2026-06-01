package com.google.firebase.sessions;

import kotlin.jvm.internal.k;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes4.dex */
public final class SessionInfo {
    private final DataCollectionStatus dataCollectionStatus;
    private final long eventTimestampUs;
    private final String firebaseAuthenticationToken;
    private final String firebaseInstallationId;
    private final String firstSessionId;
    private final String sessionId;
    private final int sessionIndex;

    public SessionInfo(String sessionId, String firstSessionId, int i2, long j, DataCollectionStatus dataCollectionStatus, String firebaseInstallationId, String firebaseAuthenticationToken) {
        k.e(sessionId, "sessionId");
        k.e(firstSessionId, "firstSessionId");
        k.e(dataCollectionStatus, "dataCollectionStatus");
        k.e(firebaseInstallationId, "firebaseInstallationId");
        k.e(firebaseAuthenticationToken, "firebaseAuthenticationToken");
        this.sessionId = sessionId;
        this.firstSessionId = firstSessionId;
        this.sessionIndex = i2;
        this.eventTimestampUs = j;
        this.dataCollectionStatus = dataCollectionStatus;
        this.firebaseInstallationId = firebaseInstallationId;
        this.firebaseAuthenticationToken = firebaseAuthenticationToken;
    }

    public static /* synthetic */ SessionInfo copy$default(SessionInfo sessionInfo, String str, String str2, int i2, long j, DataCollectionStatus dataCollectionStatus, String str3, String str4, int i8, Object obj) {
        if ((i8 & 1) != 0) {
            str = sessionInfo.sessionId;
        }
        if ((i8 & 2) != 0) {
            str2 = sessionInfo.firstSessionId;
        }
        if ((i8 & 4) != 0) {
            i2 = sessionInfo.sessionIndex;
        }
        if ((i8 & 8) != 0) {
            j = sessionInfo.eventTimestampUs;
        }
        if ((i8 & 16) != 0) {
            dataCollectionStatus = sessionInfo.dataCollectionStatus;
        }
        if ((i8 & 32) != 0) {
            str3 = sessionInfo.firebaseInstallationId;
        }
        if ((i8 & 64) != 0) {
            str4 = sessionInfo.firebaseAuthenticationToken;
        }
        String str5 = str4;
        DataCollectionStatus dataCollectionStatus2 = dataCollectionStatus;
        long j3 = j;
        int i9 = i2;
        return sessionInfo.copy(str, str2, i9, j3, dataCollectionStatus2, str3, str5);
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
        return this.eventTimestampUs;
    }

    public final DataCollectionStatus component5() {
        return this.dataCollectionStatus;
    }

    public final String component6() {
        return this.firebaseInstallationId;
    }

    public final String component7() {
        return this.firebaseAuthenticationToken;
    }

    public final SessionInfo copy(String sessionId, String firstSessionId, int i2, long j, DataCollectionStatus dataCollectionStatus, String firebaseInstallationId, String firebaseAuthenticationToken) {
        k.e(sessionId, "sessionId");
        k.e(firstSessionId, "firstSessionId");
        k.e(dataCollectionStatus, "dataCollectionStatus");
        k.e(firebaseInstallationId, "firebaseInstallationId");
        k.e(firebaseAuthenticationToken, "firebaseAuthenticationToken");
        return new SessionInfo(sessionId, firstSessionId, i2, j, dataCollectionStatus, firebaseInstallationId, firebaseAuthenticationToken);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof SessionInfo)) {
            return false;
        }
        SessionInfo sessionInfo = (SessionInfo) obj;
        return k.a(this.sessionId, sessionInfo.sessionId) && k.a(this.firstSessionId, sessionInfo.firstSessionId) && this.sessionIndex == sessionInfo.sessionIndex && this.eventTimestampUs == sessionInfo.eventTimestampUs && k.a(this.dataCollectionStatus, sessionInfo.dataCollectionStatus) && k.a(this.firebaseInstallationId, sessionInfo.firebaseInstallationId) && k.a(this.firebaseAuthenticationToken, sessionInfo.firebaseAuthenticationToken);
    }

    public final DataCollectionStatus getDataCollectionStatus() {
        return this.dataCollectionStatus;
    }

    public final long getEventTimestampUs() {
        return this.eventTimestampUs;
    }

    public final String getFirebaseAuthenticationToken() {
        return this.firebaseAuthenticationToken;
    }

    public final String getFirebaseInstallationId() {
        return this.firebaseInstallationId;
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

    public int hashCode() {
        int iB = (androidx.camera.core.processing.util.a.b(this.sessionId.hashCode() * 31, 31, this.firstSessionId) + this.sessionIndex) * 31;
        long j = this.eventTimestampUs;
        return this.firebaseAuthenticationToken.hashCode() + androidx.camera.core.processing.util.a.b((this.dataCollectionStatus.hashCode() + ((iB + ((int) (j ^ (j >>> 32)))) * 31)) * 31, 31, this.firebaseInstallationId);
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("SessionInfo(sessionId=");
        sb.append(this.sessionId);
        sb.append(", firstSessionId=");
        sb.append(this.firstSessionId);
        sb.append(", sessionIndex=");
        sb.append(this.sessionIndex);
        sb.append(", eventTimestampUs=");
        sb.append(this.eventTimestampUs);
        sb.append(", dataCollectionStatus=");
        sb.append(this.dataCollectionStatus);
        sb.append(", firebaseInstallationId=");
        sb.append(this.firebaseInstallationId);
        sb.append(", firebaseAuthenticationToken=");
        return a1.a.e(')', this.firebaseAuthenticationToken, sb);
    }
}
