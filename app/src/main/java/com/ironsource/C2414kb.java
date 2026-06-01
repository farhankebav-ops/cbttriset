package com.ironsource;

import com.ironsource.InterfaceC2432lb;
import com.ironsource.mediationsdk.adunit.adapter.internal.nativead.AdapterNativeAdViewBinder;

/* JADX INFO: renamed from: com.ironsource.kb, reason: case insensitive filesystem */
/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes5.dex */
public final class C2414kb {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final C2450mb f8853a;

    /* JADX INFO: renamed from: com.ironsource.kb$a */
    /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private C2414kb f8854a = new C2414kb(null);

        public final a a(String adUnitId) {
            kotlin.jvm.internal.k.e(adUnitId, "adUnitId");
            this.f8854a.a(adUnitId);
            return this;
        }

        public final a b(String placementName) {
            kotlin.jvm.internal.k.e(placementName, "placementName");
            this.f8854a.b(placementName);
            return this;
        }

        public final a a(InterfaceC2488ob listener) {
            kotlin.jvm.internal.k.e(listener, "listener");
            this.f8854a.a(listener);
            return this;
        }

        public final C2414kb a() {
            return this.f8854a;
        }
    }

    public /* synthetic */ C2414kb(kotlin.jvm.internal.f fVar) {
        this();
    }

    public final String c() {
        return this.f8853a.i();
    }

    public final String d() {
        return this.f8853a.j();
    }

    public final InterfaceC2432lb.a e() {
        return this.f8853a.k();
    }

    public final AdapterNativeAdViewBinder f() {
        return this.f8853a.l();
    }

    public final String g() {
        return this.f8853a.m();
    }

    public final void h() {
        this.f8853a.n();
    }

    private C2414kb() {
        this.f8853a = new C2450mb(C2670z7.f10631a.a(), this);
    }

    public final void a() {
        this.f8853a.f();
    }

    public final String b() {
        return this.f8853a.h();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void a(String str) {
        this.f8853a.a(str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void b(String str) {
        this.f8853a.b(str);
    }

    public final void a(InterfaceC2488ob interfaceC2488ob) {
        this.f8853a.a(interfaceC2488ob);
    }
}
