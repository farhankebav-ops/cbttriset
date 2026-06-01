package com.ironsource;

/* JADX INFO: renamed from: com.ironsource.gd, reason: case insensitive filesystem */
/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes5.dex */
public abstract class AbstractC2345gd {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private InterfaceC2363hd f8617a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private long f8618b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private boolean f8619c;

    public AbstractC2345gd() {
        this(false, 1, null);
    }

    public final InterfaceC2363hd a() {
        return this.f8617a;
    }

    public abstract String b();

    public final long c() {
        return this.f8618b;
    }

    public final boolean d() {
        return this.f8619c;
    }

    public AbstractC2345gd(boolean z2) {
        this.f8619c = z2;
    }

    public final void a(InterfaceC2363hd interfaceC2363hd) {
        this.f8617a = interfaceC2363hd;
    }

    public final void a(boolean z2) {
        this.f8619c = z2;
        if (z2) {
            this.f8618b = System.currentTimeMillis();
            InterfaceC2363hd interfaceC2363hd = this.f8617a;
            if (interfaceC2363hd != null) {
                interfaceC2363hd.a(this);
                return;
            }
            return;
        }
        InterfaceC2363hd interfaceC2363hd2 = this.f8617a;
        if (interfaceC2363hd2 != null) {
            interfaceC2363hd2.b(this);
        }
    }

    public /* synthetic */ AbstractC2345gd(boolean z2, int i2, kotlin.jvm.internal.f fVar) {
        this((i2 & 1) != 0 ? false : z2);
    }
}
