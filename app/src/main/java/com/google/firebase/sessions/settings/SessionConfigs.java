package com.google.firebase.sessions.settings;

import b7.c;
import b7.h;
import d7.g;
import e7.d;
import f7.c1;
import f7.l0;
import f7.m1;
import f7.q0;
import f7.u;
import kotlin.jvm.internal.f;
import kotlin.jvm.internal.k;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes4.dex */
@h
public final class SessionConfigs {
    public static final Companion Companion = new Companion(null);
    private final Integer cacheDurationSeconds;
    private final Long cacheUpdatedTimeSeconds;
    private final Double sessionSamplingRate;
    private final Integer sessionTimeoutSeconds;
    private final Boolean sessionsEnabled;

    /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
    public static final class Companion {
        private Companion() {
        }

        public final c serializer() {
            return SessionConfigs$$serializer.INSTANCE;
        }

        public /* synthetic */ Companion(f fVar) {
            this();
        }
    }

    public /* synthetic */ SessionConfigs(int i2, Boolean bool, Double d8, Integer num, Integer num2, Long l, m1 m1Var) {
        if (31 != (i2 & 31)) {
            c1.j(SessionConfigs$$serializer.INSTANCE.getDescriptor(), i2, 31);
            throw null;
        }
        this.sessionsEnabled = bool;
        this.sessionSamplingRate = d8;
        this.sessionTimeoutSeconds = num;
        this.cacheDurationSeconds = num2;
        this.cacheUpdatedTimeSeconds = l;
    }

    public static /* synthetic */ SessionConfigs copy$default(SessionConfigs sessionConfigs, Boolean bool, Double d8, Integer num, Integer num2, Long l, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            bool = sessionConfigs.sessionsEnabled;
        }
        if ((i2 & 2) != 0) {
            d8 = sessionConfigs.sessionSamplingRate;
        }
        if ((i2 & 4) != 0) {
            num = sessionConfigs.sessionTimeoutSeconds;
        }
        if ((i2 & 8) != 0) {
            num2 = sessionConfigs.cacheDurationSeconds;
        }
        if ((i2 & 16) != 0) {
            l = sessionConfigs.cacheUpdatedTimeSeconds;
        }
        Long l8 = l;
        Integer num3 = num;
        return sessionConfigs.copy(bool, d8, num3, num2, l8);
    }

    public static final /* synthetic */ void write$Self$com_google_firebase_firebase_sessions(SessionConfigs sessionConfigs, d dVar, g gVar) {
        dVar.encodeNullableSerializableElement(gVar, 0, f7.g.f11455a, sessionConfigs.sessionsEnabled);
        dVar.encodeNullableSerializableElement(gVar, 1, u.f11523a, sessionConfigs.sessionSamplingRate);
        l0 l0Var = l0.f11478a;
        dVar.encodeNullableSerializableElement(gVar, 2, l0Var, sessionConfigs.sessionTimeoutSeconds);
        dVar.encodeNullableSerializableElement(gVar, 3, l0Var, sessionConfigs.cacheDurationSeconds);
        dVar.encodeNullableSerializableElement(gVar, 4, q0.f11499a, sessionConfigs.cacheUpdatedTimeSeconds);
    }

    public final Boolean component1() {
        return this.sessionsEnabled;
    }

    public final Double component2() {
        return this.sessionSamplingRate;
    }

    public final Integer component3() {
        return this.sessionTimeoutSeconds;
    }

    public final Integer component4() {
        return this.cacheDurationSeconds;
    }

    public final Long component5() {
        return this.cacheUpdatedTimeSeconds;
    }

    public final SessionConfigs copy(Boolean bool, Double d8, Integer num, Integer num2, Long l) {
        return new SessionConfigs(bool, d8, num, num2, l);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof SessionConfigs)) {
            return false;
        }
        SessionConfigs sessionConfigs = (SessionConfigs) obj;
        return k.a(this.sessionsEnabled, sessionConfigs.sessionsEnabled) && k.a(this.sessionSamplingRate, sessionConfigs.sessionSamplingRate) && k.a(this.sessionTimeoutSeconds, sessionConfigs.sessionTimeoutSeconds) && k.a(this.cacheDurationSeconds, sessionConfigs.cacheDurationSeconds) && k.a(this.cacheUpdatedTimeSeconds, sessionConfigs.cacheUpdatedTimeSeconds);
    }

    public final Integer getCacheDurationSeconds() {
        return this.cacheDurationSeconds;
    }

    public final Long getCacheUpdatedTimeSeconds() {
        return this.cacheUpdatedTimeSeconds;
    }

    public final Double getSessionSamplingRate() {
        return this.sessionSamplingRate;
    }

    public final Integer getSessionTimeoutSeconds() {
        return this.sessionTimeoutSeconds;
    }

    public final Boolean getSessionsEnabled() {
        return this.sessionsEnabled;
    }

    public int hashCode() {
        Boolean bool = this.sessionsEnabled;
        int iHashCode = (bool == null ? 0 : bool.hashCode()) * 31;
        Double d8 = this.sessionSamplingRate;
        int iHashCode2 = (iHashCode + (d8 == null ? 0 : d8.hashCode())) * 31;
        Integer num = this.sessionTimeoutSeconds;
        int iHashCode3 = (iHashCode2 + (num == null ? 0 : num.hashCode())) * 31;
        Integer num2 = this.cacheDurationSeconds;
        int iHashCode4 = (iHashCode3 + (num2 == null ? 0 : num2.hashCode())) * 31;
        Long l = this.cacheUpdatedTimeSeconds;
        return iHashCode4 + (l != null ? l.hashCode() : 0);
    }

    public String toString() {
        return "SessionConfigs(sessionsEnabled=" + this.sessionsEnabled + ", sessionSamplingRate=" + this.sessionSamplingRate + ", sessionTimeoutSeconds=" + this.sessionTimeoutSeconds + ", cacheDurationSeconds=" + this.cacheDurationSeconds + ", cacheUpdatedTimeSeconds=" + this.cacheUpdatedTimeSeconds + ')';
    }

    public SessionConfigs(Boolean bool, Double d8, Integer num, Integer num2, Long l) {
        this.sessionsEnabled = bool;
        this.sessionSamplingRate = d8;
        this.sessionTimeoutSeconds = num;
        this.cacheDurationSeconds = num2;
        this.cacheUpdatedTimeSeconds = l;
    }
}
