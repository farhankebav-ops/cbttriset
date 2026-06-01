package com.google.firebase.sessions.api;

import kotlin.jvm.internal.k;
import n7.b;
import y5.a;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes4.dex */
public interface SessionSubscriber {

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* JADX WARN: Unknown enum class pattern. Please report as an issue! */
    /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
    public static final class Name {
        private static final /* synthetic */ a $ENTRIES;
        private static final /* synthetic */ Name[] $VALUES;
        public static final Name CRASHLYTICS = new Name("CRASHLYTICS", 0);
        public static final Name PERFORMANCE = new Name("PERFORMANCE", 1);
        public static final Name MATT_SAYS_HI = new Name("MATT_SAYS_HI", 2);

        private static final /* synthetic */ Name[] $values() {
            return new Name[]{CRASHLYTICS, PERFORMANCE, MATT_SAYS_HI};
        }

        static {
            Name[] nameArr$values = $values();
            $VALUES = nameArr$values;
            $ENTRIES = b.n(nameArr$values);
        }

        private Name(String str, int i2) {
        }

        public static a getEntries() {
            return $ENTRIES;
        }

        public static Name valueOf(String str) {
            return (Name) Enum.valueOf(Name.class, str);
        }

        public static Name[] values() {
            return (Name[]) $VALUES.clone();
        }
    }

    /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
    public static final class SessionDetails {
        private final String sessionId;

        public SessionDetails(String sessionId) {
            k.e(sessionId, "sessionId");
            this.sessionId = sessionId;
        }

        public static /* synthetic */ SessionDetails copy$default(SessionDetails sessionDetails, String str, int i2, Object obj) {
            if ((i2 & 1) != 0) {
                str = sessionDetails.sessionId;
            }
            return sessionDetails.copy(str);
        }

        public final String component1() {
            return this.sessionId;
        }

        public final SessionDetails copy(String sessionId) {
            k.e(sessionId, "sessionId");
            return new SessionDetails(sessionId);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            return (obj instanceof SessionDetails) && k.a(this.sessionId, ((SessionDetails) obj).sessionId);
        }

        public final String getSessionId() {
            return this.sessionId;
        }

        public int hashCode() {
            return this.sessionId.hashCode();
        }

        public String toString() {
            return a1.a.e(')', this.sessionId, new StringBuilder("SessionDetails(sessionId="));
        }
    }

    Name getSessionSubscriberName();

    boolean isDataCollectionEnabled();

    void onSessionChanged(SessionDetails sessionDetails);
}
