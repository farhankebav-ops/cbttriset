package com.ironsource;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes5.dex */
public class N0 {
    public static final int e = -1;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final a f7253a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final long f7254b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final long f7255c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final long f7256d;

    /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
    public enum a {
        MANUAL,
        MANUAL_WITH_AUTOMATIC_RELOAD,
        MANUAL_WITH_LOAD_ON_SHOW,
        AUTOMATIC_LOAD_AFTER_CLOSE,
        AUTOMATIC_LOAD_WHILE_SHOW
    }

    public N0(a aVar, long j, long j3, long j8) {
        this.f7253a = aVar;
        this.f7254b = j;
        this.f7255c = j3;
        this.f7256d = j8;
    }

    public a a() {
        return this.f7253a;
    }

    public long b() {
        return this.f7256d;
    }

    public long c() {
        return this.f7255c;
    }

    public long d() {
        return this.f7254b;
    }

    public boolean e() {
        a aVar = this.f7253a;
        return aVar == a.AUTOMATIC_LOAD_AFTER_CLOSE || aVar == a.AUTOMATIC_LOAD_WHILE_SHOW;
    }

    public boolean f() {
        a aVar = this.f7253a;
        return aVar == a.MANUAL || aVar == a.MANUAL_WITH_AUTOMATIC_RELOAD || aVar == a.MANUAL_WITH_LOAD_ON_SHOW;
    }
}
