package com.vungle.ads.internal.model;

import a1.a;
import b7.c;
import b7.h;
import d7.g;
import e7.d;
import f7.c1;
import f7.m1;
import kotlin.jvm.internal.f;
import kotlin.jvm.internal.k;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes5.dex */
@h
public final class UnclosedAd {
    public static final Companion Companion = new Companion(null);
    private final String eventId;
    private String sessionId;

    /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
    public static final class Companion {
        public /* synthetic */ Companion(f fVar) {
            this();
        }

        public final c serializer() {
            return UnclosedAd$$serializer.INSTANCE;
        }

        private Companion() {
        }
    }

    public /* synthetic */ UnclosedAd(int i2, String str, String str2, m1 m1Var) {
        if (1 != (i2 & 1)) {
            c1.j(UnclosedAd$$serializer.INSTANCE.getDescriptor(), i2, 1);
            throw null;
        }
        this.eventId = str;
        if ((i2 & 2) == 0) {
            this.sessionId = "";
        } else {
            this.sessionId = str2;
        }
    }

    public static /* synthetic */ UnclosedAd copy$default(UnclosedAd unclosedAd, String str, String str2, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            str = unclosedAd.eventId;
        }
        if ((i2 & 2) != 0) {
            str2 = unclosedAd.sessionId;
        }
        return unclosedAd.copy(str, str2);
    }

    public static final void write$Self(UnclosedAd self, d output, g serialDesc) {
        k.e(self, "self");
        k.e(output, "output");
        k.e(serialDesc, "serialDesc");
        output.encodeStringElement(serialDesc, 0, self.eventId);
        if (!output.shouldEncodeElementDefault(serialDesc, 1) && k.a(self.sessionId, "")) {
            return;
        }
        output.encodeStringElement(serialDesc, 1, self.sessionId);
    }

    public final String component1() {
        return this.eventId;
    }

    public final String component2() {
        return this.sessionId;
    }

    public final UnclosedAd copy(String eventId, String sessionId) {
        k.e(eventId, "eventId");
        k.e(sessionId, "sessionId");
        return new UnclosedAd(eventId, sessionId);
    }

    public boolean equals(Object obj) {
        if (obj != null && UnclosedAd.class.equals(obj.getClass())) {
            UnclosedAd unclosedAd = (UnclosedAd) obj;
            if (k.a(this.eventId, unclosedAd.eventId) && k.a(this.sessionId, unclosedAd.sessionId)) {
                return true;
            }
        }
        return false;
    }

    public final String getEventId() {
        return this.eventId;
    }

    public final String getSessionId() {
        return this.sessionId;
    }

    public int hashCode() {
        return this.sessionId.hashCode() + (this.eventId.hashCode() * 31);
    }

    public final void setSessionId(String str) {
        k.e(str, "<set-?>");
        this.sessionId = str;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("UnclosedAd(eventId=");
        sb.append(this.eventId);
        sb.append(", sessionId=");
        return a.e(')', this.sessionId, sb);
    }

    public UnclosedAd(String eventId, String sessionId) {
        k.e(eventId, "eventId");
        k.e(sessionId, "sessionId");
        this.eventId = eventId;
        this.sessionId = sessionId;
    }

    public /* synthetic */ UnclosedAd(String str, String str2, int i2, f fVar) {
        this(str, (i2 & 2) != 0 ? "" : str2);
    }

    public static /* synthetic */ void getEventId$annotations() {
    }

    public static /* synthetic */ void getSessionId$annotations() {
    }
}
