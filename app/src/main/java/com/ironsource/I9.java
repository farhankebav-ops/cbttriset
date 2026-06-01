package com.ironsource;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes5.dex */
public final class I9 implements InterfaceC2430l9 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final C2243b1 f6982a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final F9 f6983b;

    public I9(C2243b1 adapterConfig, F9 adFormatConfigurations) {
        kotlin.jvm.internal.k.e(adapterConfig, "adapterConfig");
        kotlin.jvm.internal.k.e(adFormatConfigurations, "adFormatConfigurations");
        this.f6982a = adapterConfig;
        this.f6983b = adFormatConfigurations;
    }

    @Override // com.ironsource.InterfaceC2261c1
    public boolean a() {
        return true;
    }

    @Override // com.ironsource.InterfaceC2560t
    public long b() {
        return this.f6983b.e();
    }

    @Override // com.ironsource.InterfaceC2261c1
    public String c() {
        String strF = this.f6982a.f();
        kotlin.jvm.internal.k.d(strF, "adapterConfig.providerName");
        return strF;
    }

    @Override // com.ironsource.InterfaceC2261c1
    public boolean d() {
        return !this.f6982a.j();
    }

    @Override // com.ironsource.InterfaceC2261c1
    public String e() {
        String strA = this.f6982a.a();
        kotlin.jvm.internal.k.d(strA, "adapterConfig.adSourceNameForEvents");
        return strA;
    }

    @Override // com.ironsource.InterfaceC2261c1
    public EnumC2468n9 f() {
        return EnumC2468n9.f9502b.a(this.f6982a.d());
    }
}
