package com.google.firebase.sessions;

import android.os.SystemClock;
import r2.q;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes4.dex */
public final class TimeProviderImpl implements TimeProvider {
    public static final TimeProviderImpl INSTANCE = new TimeProviderImpl();

    private TimeProviderImpl() {
    }

    @Override // com.google.firebase.sessions.TimeProvider
    public Time currentTime() {
        return new Time(System.currentTimeMillis());
    }

    @Override // com.google.firebase.sessions.TimeProvider
    /* JADX INFO: renamed from: elapsedRealtime-UwyO8pc */
    public long mo216elapsedRealtimeUwyO8pc() {
        int i2 = o6.a.f13207d;
        return q.B0(SystemClock.elapsedRealtime(), o6.c.f13211c);
    }
}
