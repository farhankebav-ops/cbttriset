package com.google.firebase.sessions;

import b7.h;
import d7.g;
import f7.c1;
import f7.m1;
import kotlin.jvm.internal.f;
import kotlin.jvm.internal.k;
import r2.q;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes4.dex */
@h
public final class Time {
    public static final Companion Companion = new Companion(null);
    private final long ms;
    private final long seconds;
    private final long us;

    /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
    public static final class Companion {
        private Companion() {
        }

        public final b7.c serializer() {
            return Time$$serializer.INSTANCE;
        }

        public /* synthetic */ Companion(f fVar) {
            this();
        }
    }

    public /* synthetic */ Time(int i2, long j, long j3, long j8, m1 m1Var) {
        if (1 != (i2 & 1)) {
            c1.j(Time$$serializer.INSTANCE.getDescriptor(), i2, 1);
            throw null;
        }
        this.ms = j;
        this.us = (i2 & 2) == 0 ? ((long) 1000) * j : j3;
        if ((i2 & 4) == 0) {
            this.seconds = j / ((long) 1000);
        } else {
            this.seconds = j8;
        }
    }

    public static /* synthetic */ Time copy$default(Time time, long j, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            j = time.ms;
        }
        return time.copy(j);
    }

    public static final /* synthetic */ void write$Self$com_google_firebase_firebase_sessions(Time time, e7.d dVar, g gVar) {
        dVar.encodeLongElement(gVar, 0, time.ms);
        if (dVar.shouldEncodeElementDefault(gVar, 1) || time.us != time.ms * ((long) 1000)) {
            dVar.encodeLongElement(gVar, 1, time.us);
        }
        if (!dVar.shouldEncodeElementDefault(gVar, 2) && time.seconds == time.ms / ((long) 1000)) {
            return;
        }
        dVar.encodeLongElement(gVar, 2, time.seconds);
    }

    public final long component1() {
        return this.ms;
    }

    public final Time copy(long j) {
        return new Time(j);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof Time) && this.ms == ((Time) obj).ms;
    }

    public final long getMs() {
        return this.ms;
    }

    public final long getSeconds() {
        return this.seconds;
    }

    public final long getUs() {
        return this.us;
    }

    public int hashCode() {
        long j = this.ms;
        return (int) (j ^ (j >>> 32));
    }

    /* JADX INFO: renamed from: minus-5sfh64U, reason: not valid java name */
    public final long m215minus5sfh64U(Time time) {
        k.e(time, "time");
        int i2 = o6.a.f13207d;
        return q.B0(this.ms - time.ms, o6.c.f13211c);
    }

    public String toString() {
        return "Time(ms=" + this.ms + ')';
    }

    public Time(long j) {
        this.ms = j;
        long j3 = 1000;
        this.us = j * j3;
        this.seconds = j / j3;
    }
}
