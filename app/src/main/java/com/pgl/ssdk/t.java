package com.pgl.ssdk;

import java.nio.ByteBuffer;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes5.dex */
public class t {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final long f10806a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final long f10807b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final int f10808c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final long f10809d;
    private final ByteBuffer e;

    public t(long j, long j3, int i2, long j8, ByteBuffer byteBuffer) {
        this.f10806a = j;
        this.f10807b = j3;
        this.f10808c = i2;
        this.f10809d = j8;
        this.e = byteBuffer;
    }

    public long a() {
        return this.f10806a;
    }

    public int b() {
        return this.f10808c;
    }

    public long c() {
        return this.f10807b;
    }

    public ByteBuffer d() {
        return this.e;
    }

    public long e() {
        return this.f10809d;
    }
}
