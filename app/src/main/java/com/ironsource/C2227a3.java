package com.ironsource;

/* JADX INFO: renamed from: com.ironsource.a3, reason: case insensitive filesystem */
/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes5.dex */
public final class C2227a3 implements InterfaceC2430l9 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final C2243b1 f7943a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final V2 f7944b;

    public C2227a3(C2243b1 adapterConfig, V2 adFormatConfigurations) {
        kotlin.jvm.internal.k.e(adapterConfig, "adapterConfig");
        kotlin.jvm.internal.k.e(adFormatConfigurations, "adFormatConfigurations");
        this.f7943a = adapterConfig;
        this.f7944b = adFormatConfigurations;
    }

    @Override // com.ironsource.InterfaceC2261c1
    public boolean a() {
        return true;
    }

    @Override // com.ironsource.InterfaceC2560t
    public long b() {
        return this.f7944b.b();
    }

    @Override // com.ironsource.InterfaceC2261c1
    public String c() {
        String strF = this.f7943a.f();
        kotlin.jvm.internal.k.d(strF, "adapterConfig.providerName");
        return strF;
    }

    @Override // com.ironsource.InterfaceC2261c1
    public boolean d() {
        return !this.f7943a.j();
    }

    @Override // com.ironsource.InterfaceC2261c1
    public String e() {
        String strA = this.f7943a.a();
        kotlin.jvm.internal.k.d(strA, "adapterConfig.adSourceNameForEvents");
        return strA;
    }

    @Override // com.ironsource.InterfaceC2261c1
    public EnumC2468n9 f() {
        return EnumC2468n9.f9502b.a(this.f7943a.d());
    }
}
