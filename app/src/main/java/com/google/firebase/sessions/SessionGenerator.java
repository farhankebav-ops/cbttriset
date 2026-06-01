package com.google.firebase.sessions;

import java.util.Locale;
import kotlin.jvm.internal.k;
import n6.t;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes4.dex */
public final class SessionGenerator {
    private final TimeProvider timeProvider;
    private final UuidGenerator uuidGenerator;

    public SessionGenerator(TimeProvider timeProvider, UuidGenerator uuidGenerator) {
        k.e(timeProvider, "timeProvider");
        k.e(uuidGenerator, "uuidGenerator");
        this.timeProvider = timeProvider;
        this.uuidGenerator = uuidGenerator;
    }

    private final String generateSessionId() {
        String string = this.uuidGenerator.next().toString();
        k.d(string, "toString(...)");
        String lowerCase = t.l0(string, "-", "").toLowerCase(Locale.ROOT);
        k.d(lowerCase, "toLowerCase(...)");
        return lowerCase;
    }

    public final SessionDetails generateNewSession(SessionDetails sessionDetails) {
        String firstSessionId;
        String strGenerateSessionId = generateSessionId();
        if (sessionDetails == null || (firstSessionId = sessionDetails.getFirstSessionId()) == null) {
            firstSessionId = strGenerateSessionId;
        }
        return new SessionDetails(strGenerateSessionId, firstSessionId, sessionDetails != null ? sessionDetails.getSessionIndex() + 1 : 0, this.timeProvider.currentTime().getUs());
    }
}
