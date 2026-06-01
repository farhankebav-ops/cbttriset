package com.ironsource;

/* JADX INFO: renamed from: com.ironsource.ya, reason: case insensitive filesystem */
/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes5.dex */
public abstract class AbstractC2656ya {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final C2459n0 f10561a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private String f10562b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private boolean f10563c;

    public AbstractC2656ya(C2459n0 adTools) {
        kotlin.jvm.internal.k.e(adTools, "adTools");
        this.f10561a = adTools;
        this.f10562b = "";
    }

    public final C2459n0 a() {
        return this.f10561a;
    }

    public final String b() {
        return this.f10562b;
    }

    public final boolean c() {
        return this.f10563c;
    }

    public abstract boolean d();

    public final void a(String str) {
        kotlin.jvm.internal.k.e(str, "<set-?>");
        this.f10562b = str;
    }

    public final void b(Runnable callback) {
        kotlin.jvm.internal.k.e(callback, "callback");
        this.f10561a.e(callback);
    }

    public final void a(boolean z2) {
        this.f10563c = z2;
    }

    public final void a(Runnable runnable) {
        kotlin.jvm.internal.k.e(runnable, "runnable");
        this.f10561a.d(runnable);
    }

    public final void a(C2314f0 adProperties) {
        kotlin.jvm.internal.k.e(adProperties, "adProperties");
        this.f10561a.e().a(new B0(this.f10561a, adProperties, null, 4, null));
    }
}
