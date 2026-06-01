package com.ironsource;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes5.dex */
public class Wf {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    protected long f7784a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    protected long f7785b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    protected long f7786c;

    public long a() {
        return Math.max(0L, this.f7784a - System.currentTimeMillis());
    }

    public void b(long j) {
        this.f7786c = j;
        this.f7784a = (j - this.f7785b) + this.f7784a;
    }

    public void c(long j) {
        this.f7785b = j;
        this.f7786c = 0L;
    }

    public void a(long j) {
        this.f7784a = System.currentTimeMillis() + j;
    }

    public void b() {
        this.f7784a = 0L;
        this.f7785b = 0L;
        this.f7786c = 0L;
    }
}
