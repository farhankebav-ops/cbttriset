package com.vungle.ads.internal.signals;

import b7.c;
import b7.h;
import d7.g;
import e7.d;
import f7.c1;
import f7.m1;
import f7.q1;
import kotlin.jvm.internal.f;
import kotlin.jvm.internal.k;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes5.dex */
@h
public final class SignaledAd {
    public static final Companion Companion = new Companion(null);
    private long adAvailabilityCallbackTime;
    private String eventId;
    private final Long lastAdLoadTime;
    private final long loadAdTime;
    private long playAdTime;
    private int screenOrientation;
    private String templateSignals;
    private long timeBetweenAdAvailabilityAndPlayAd;
    private final long timeSinceLastAdLoad;

    /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
    public static final class Companion {
        public /* synthetic */ Companion(f fVar) {
            this();
        }

        public final c serializer() {
            return SignaledAd$$serializer.INSTANCE;
        }

        private Companion() {
        }
    }

    public SignaledAd() {
        this(null, 0L, 3, null);
    }

    public static /* synthetic */ SignaledAd copy$default(SignaledAd signaledAd, Long l, long j, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            l = signaledAd.lastAdLoadTime;
        }
        if ((i2 & 2) != 0) {
            j = signaledAd.loadAdTime;
        }
        return signaledAd.copy(l, j);
    }

    private final long getTimeDifference(Long l, long j) {
        if (l == null) {
            return -1L;
        }
        long jLongValue = j - l.longValue();
        if (jLongValue < 0) {
            return -1L;
        }
        return jLongValue;
    }

    public static final void write$Self(SignaledAd self, d output, g serialDesc) {
        k.e(self, "self");
        k.e(output, "output");
        k.e(serialDesc, "serialDesc");
        if (output.shouldEncodeElementDefault(serialDesc, 0) || self.templateSignals != null) {
            output.encodeNullableSerializableElement(serialDesc, 0, q1.f11501a, self.templateSignals);
        }
        output.encodeLongElement(serialDesc, 1, self.timeSinceLastAdLoad);
        if (output.shouldEncodeElementDefault(serialDesc, 2) || self.eventId != null) {
            output.encodeNullableSerializableElement(serialDesc, 2, q1.f11501a, self.eventId);
        }
        if (output.shouldEncodeElementDefault(serialDesc, 3) || self.timeBetweenAdAvailabilityAndPlayAd != 0) {
            output.encodeLongElement(serialDesc, 3, self.timeBetweenAdAvailabilityAndPlayAd);
        }
        if (!output.shouldEncodeElementDefault(serialDesc, 4) && self.screenOrientation == 0) {
            return;
        }
        output.encodeIntElement(serialDesc, 4, self.screenOrientation);
    }

    public final void calculateTimeBetweenAdAvailabilityAndPlayAd() {
        this.timeBetweenAdAvailabilityAndPlayAd = getTimeDifference(Long.valueOf(this.adAvailabilityCallbackTime), this.playAdTime);
    }

    public final Long component1() {
        return this.lastAdLoadTime;
    }

    public final long component2() {
        return this.loadAdTime;
    }

    public final SignaledAd copy(Long l, long j) {
        return new SignaledAd(l, j);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof SignaledAd)) {
            return false;
        }
        SignaledAd signaledAd = (SignaledAd) obj;
        return k.a(this.lastAdLoadTime, signaledAd.lastAdLoadTime) && this.loadAdTime == signaledAd.loadAdTime;
    }

    public final long getAdAvailabilityCallbackTime() {
        return this.adAvailabilityCallbackTime;
    }

    public final String getEventId() {
        return this.eventId;
    }

    public final Long getLastAdLoadTime() {
        return this.lastAdLoadTime;
    }

    public final long getLoadAdTime() {
        return this.loadAdTime;
    }

    public final long getPlayAdTime() {
        return this.playAdTime;
    }

    public final int getScreenOrientation() {
        return this.screenOrientation;
    }

    public final String getTemplateSignals() {
        return this.templateSignals;
    }

    public final long getTimeBetweenAdAvailabilityAndPlayAd() {
        return this.timeBetweenAdAvailabilityAndPlayAd;
    }

    public final long getTimeSinceLastAdLoad() {
        return this.timeSinceLastAdLoad;
    }

    public int hashCode() {
        Long l = this.lastAdLoadTime;
        int iHashCode = l == null ? 0 : l.hashCode();
        long j = this.loadAdTime;
        return (iHashCode * 31) + ((int) (j ^ (j >>> 32)));
    }

    public final void setAdAvailabilityCallbackTime(long j) {
        this.adAvailabilityCallbackTime = j;
    }

    public final void setEventId(String str) {
        this.eventId = str;
    }

    public final void setPlayAdTime(long j) {
        this.playAdTime = j;
    }

    public final void setScreenOrientation(int i2) {
        this.screenOrientation = i2;
    }

    public final void setTemplateSignals(String str) {
        this.templateSignals = str;
    }

    public final void setTimeBetweenAdAvailabilityAndPlayAd(long j) {
        this.timeBetweenAdAvailabilityAndPlayAd = j;
    }

    public String toString() {
        return "SignaledAd(lastAdLoadTime=" + this.lastAdLoadTime + ", loadAdTime=" + this.loadAdTime + ')';
    }

    public /* synthetic */ SignaledAd(int i2, String str, long j, String str2, long j3, int i8, m1 m1Var) {
        if (2 != (i2 & 2)) {
            c1.j(SignaledAd$$serializer.INSTANCE.getDescriptor(), i2, 2);
            throw null;
        }
        this.lastAdLoadTime = 0L;
        this.loadAdTime = 0L;
        if ((i2 & 1) == 0) {
            this.templateSignals = null;
        } else {
            this.templateSignals = str;
        }
        this.timeSinceLastAdLoad = j;
        if ((i2 & 4) == 0) {
            this.eventId = null;
        } else {
            this.eventId = str2;
        }
        if ((i2 & 8) == 0) {
            this.timeBetweenAdAvailabilityAndPlayAd = 0L;
        } else {
            this.timeBetweenAdAvailabilityAndPlayAd = j3;
        }
        if ((i2 & 16) == 0) {
            this.screenOrientation = 0;
        } else {
            this.screenOrientation = i8;
        }
        this.adAvailabilityCallbackTime = 0L;
        this.playAdTime = 0L;
        this.timeSinceLastAdLoad = getTimeDifference(0L, 0L);
    }

    public SignaledAd(Long l, long j) {
        this.lastAdLoadTime = l;
        this.loadAdTime = j;
        this.timeSinceLastAdLoad = getTimeDifference(l, j);
    }

    public /* synthetic */ SignaledAd(Long l, long j, int i2, f fVar) {
        this((i2 & 1) != 0 ? 0L : l, (i2 & 2) != 0 ? 0L : j);
    }

    public static /* synthetic */ void getAdAvailabilityCallbackTime$annotations() {
    }

    public static /* synthetic */ void getEventId$annotations() {
    }

    public static /* synthetic */ void getLastAdLoadTime$annotations() {
    }

    public static /* synthetic */ void getLoadAdTime$annotations() {
    }

    public static /* synthetic */ void getPlayAdTime$annotations() {
    }

    public static /* synthetic */ void getScreenOrientation$annotations() {
    }

    public static /* synthetic */ void getTemplateSignals$annotations() {
    }

    public static /* synthetic */ void getTimeBetweenAdAvailabilityAndPlayAd$annotations() {
    }

    public static /* synthetic */ void getTimeSinceLastAdLoad$annotations() {
    }
}
