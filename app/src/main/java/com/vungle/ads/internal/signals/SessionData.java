package com.vungle.ads.internal.signals;

import b7.c;
import b7.h;
import com.ironsource.adqualitysdk.sdk.i.a0;
import com.vungle.ads.internal.model.UnclosedAd;
import f7.c1;
import f7.m1;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import kotlin.jvm.internal.f;
import kotlin.jvm.internal.k;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes5.dex */
@h
public final class SessionData {
    public static final Companion Companion = new Companion(null);
    private int httpProxyEnabled;
    private int isDevice;
    private int isVPNConnected;
    private int overlayGranted;
    private int sensorCount;
    private final int sessionCount;
    private long sessionCreationTime;
    private int sessionDepthCounter;
    private long sessionDuration;
    private final String sessionId;
    private List<SignaledAd> signaledAd;
    private List<UnclosedAd> unclosedAd;

    /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
    public static final class Companion {
        public /* synthetic */ Companion(f fVar) {
            this();
        }

        public final c serializer() {
            return SessionData$$serializer.INSTANCE;
        }

        private Companion() {
        }
    }

    public SessionData(int i2) {
        this.sessionCount = i2;
        String string = UUID.randomUUID().toString();
        k.d(string, "randomUUID().toString()");
        this.sessionId = string;
        this.sessionCreationTime = System.currentTimeMillis() / 1000;
        this.signaledAd = new ArrayList();
        this.unclosedAd = new ArrayList();
    }

    public static /* synthetic */ SessionData copy$default(SessionData sessionData, int i2, int i8, Object obj) {
        if ((i8 & 1) != 0) {
            i2 = sessionData.sessionCount;
        }
        return sessionData.copy(i2);
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0032  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static final void write$Self(com.vungle.ads.internal.signals.SessionData r7, e7.d r8, d7.g r9) {
        /*
            Method dump skipped, instruction units count: 277
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.vungle.ads.internal.signals.SessionData.write$Self(com.vungle.ads.internal.signals.SessionData, e7.d, d7.g):void");
    }

    public final int component1() {
        return this.sessionCount;
    }

    public final SessionData copy(int i2) {
        return new SessionData(i2);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof SessionData) && this.sessionCount == ((SessionData) obj).sessionCount;
    }

    public final int getHttpProxyEnabled() {
        return this.httpProxyEnabled;
    }

    public final int getOverlayGranted() {
        return this.overlayGranted;
    }

    public final int getSensorCount() {
        return this.sensorCount;
    }

    public final int getSessionCount() {
        return this.sessionCount;
    }

    public final long getSessionCreationTime() {
        return this.sessionCreationTime;
    }

    public final int getSessionDepthCounter() {
        return this.sessionDepthCounter;
    }

    public final long getSessionDuration() {
        return this.sessionDuration;
    }

    public final String getSessionId() {
        return this.sessionId;
    }

    public final List<SignaledAd> getSignaledAd() {
        return this.signaledAd;
    }

    public final List<UnclosedAd> getUnclosedAd() {
        return this.unclosedAd;
    }

    public int hashCode() {
        return this.sessionCount;
    }

    public final int isDevice() {
        return this.isDevice;
    }

    public final int isVPNConnected() {
        return this.isVPNConnected;
    }

    public final void setDevice(int i2) {
        this.isDevice = i2;
    }

    public final void setHttpProxyEnabled(int i2) {
        this.httpProxyEnabled = i2;
    }

    public final void setOverlayGranted(int i2) {
        this.overlayGranted = i2;
    }

    public final void setSensorCount(int i2) {
        this.sensorCount = i2;
    }

    public final void setSessionCreationTime(long j) {
        this.sessionCreationTime = j;
    }

    public final void setSessionDepthCounter(int i2) {
        this.sessionDepthCounter = i2;
    }

    public final void setSessionDuration(long j) {
        this.sessionDuration = j;
    }

    public final void setSignaledAd(List<SignaledAd> list) {
        k.e(list, "<set-?>");
        this.signaledAd = list;
    }

    public final void setUnclosedAd(List<UnclosedAd> list) {
        k.e(list, "<set-?>");
        this.unclosedAd = list;
    }

    public final void setVPNConnected(int i2) {
        this.isVPNConnected = i2;
    }

    public String toString() {
        return a0.c(new StringBuilder("SessionData(sessionCount="), this.sessionCount, ')');
    }

    public /* synthetic */ SessionData(int i2, int i8, String str, long j, List list, long j3, int i9, List list2, int i10, int i11, int i12, int i13, int i14, m1 m1Var) {
        if (1 != (i2 & 1)) {
            c1.j(SessionData$$serializer.INSTANCE.getDescriptor(), i2, 1);
            throw null;
        }
        this.sessionCount = i8;
        if ((i2 & 2) == 0) {
            String string = UUID.randomUUID().toString();
            k.d(string, "randomUUID().toString()");
            this.sessionId = string;
        } else {
            this.sessionId = str;
        }
        if ((i2 & 4) == 0) {
            this.sessionCreationTime = System.currentTimeMillis() / 1000;
        } else {
            this.sessionCreationTime = j;
        }
        if ((i2 & 8) == 0) {
            this.signaledAd = new ArrayList();
        } else {
            this.signaledAd = list;
        }
        if ((i2 & 16) == 0) {
            this.sessionDuration = 0L;
        } else {
            this.sessionDuration = j3;
        }
        if ((i2 & 32) == 0) {
            this.sessionDepthCounter = 0;
        } else {
            this.sessionDepthCounter = i9;
        }
        if ((i2 & 64) == 0) {
            this.unclosedAd = new ArrayList();
        } else {
            this.unclosedAd = list2;
        }
        if ((i2 & 128) == 0) {
            this.isDevice = 0;
        } else {
            this.isDevice = i10;
        }
        if ((i2 & 256) == 0) {
            this.isVPNConnected = 0;
        } else {
            this.isVPNConnected = i11;
        }
        if ((i2 & 512) == 0) {
            this.overlayGranted = 0;
        } else {
            this.overlayGranted = i12;
        }
        if ((i2 & 1024) == 0) {
            this.sensorCount = 0;
        } else {
            this.sensorCount = i13;
        }
        if ((i2 & 2048) == 0) {
            this.httpProxyEnabled = 0;
        } else {
            this.httpProxyEnabled = i14;
        }
    }

    public static /* synthetic */ void getHttpProxyEnabled$annotations() {
    }

    public static /* synthetic */ void getOverlayGranted$annotations() {
    }

    public static /* synthetic */ void getSensorCount$annotations() {
    }

    public static /* synthetic */ void getSessionCount$annotations() {
    }

    public static /* synthetic */ void getSessionCreationTime$annotations() {
    }

    public static /* synthetic */ void getSessionDepthCounter$annotations() {
    }

    public static /* synthetic */ void getSessionDuration$annotations() {
    }

    public static /* synthetic */ void getSessionId$annotations() {
    }

    public static /* synthetic */ void getSignaledAd$annotations() {
    }

    public static /* synthetic */ void getUnclosedAd$annotations() {
    }

    public static /* synthetic */ void isDevice$annotations() {
    }

    public static /* synthetic */ void isVPNConnected$annotations() {
    }
}
