package com.bykv.vk.openvk.preload.b;

import java.util.concurrent.atomic.AtomicLong;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes3.dex */
public abstract class d<IN, OUT> {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static AtomicLong f4879d = new AtomicLong();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    d f4880a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    IN f4881b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    OUT f4882c;
    private com.bykv.vk.openvk.preload.b.b.a e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private b f4883f;
    private long g;

    public abstract Object a(b<OUT> bVar, IN in) throws Throwable;

    public void a(Object... objArr) {
    }

    public final long b() {
        return this.g;
    }

    public final void c() {
        com.bykv.vk.openvk.preload.b.b.a aVar = this.e;
        if (aVar == null) {
            return;
        }
        aVar.a(this.f4883f, this);
    }

    public final void d() {
        com.bykv.vk.openvk.preload.b.b.a aVar = this.e;
        if (aVar == null) {
            return;
        }
        aVar.c(this.f4883f, this);
    }

    public final void e() {
        com.bykv.vk.openvk.preload.b.b.a aVar = this.e;
        if (aVar == null) {
            return;
        }
        aVar.b(this.f4883f, this);
    }

    public final OUT f() {
        return this.f4882c;
    }

    public final void a(b bVar, d dVar, IN in, com.bykv.vk.openvk.preload.b.b.a aVar, Object[] objArr) {
        this.f4883f = new m(bVar);
        this.f4880a = dVar;
        this.f4881b = in;
        this.e = aVar;
        if (dVar != null) {
            this.g = dVar.g;
        } else {
            long andIncrement = f4879d.getAndIncrement();
            this.g = andIncrement;
            if (andIncrement < 0) {
                throw new RuntimeException("Pipeline ID use up!");
            }
        }
        a(objArr);
    }

    public final void b(Throwable th) {
        com.bykv.vk.openvk.preload.b.b.a aVar = this.e;
        if (aVar == null) {
            return;
        }
        aVar.a(this.f4883f, this, th);
    }

    public final void c(Throwable th) {
        com.bykv.vk.openvk.preload.b.b.a aVar = this.e;
        if (aVar == null) {
            return;
        }
        aVar.b(this.f4883f, this, th);
    }

    public final void d(Throwable th) {
        com.bykv.vk.openvk.preload.b.b.a aVar = this.e;
        if (aVar == null) {
            return;
        }
        aVar.c(this.f4883f, this, th);
    }
}
