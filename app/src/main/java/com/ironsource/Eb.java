package com.ironsource;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes5.dex */
public final class Eb implements V5<Db> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final String f6675a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final InterfaceC2676zd f6676b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final InterfaceC2279d1 f6677c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final boolean f6678d;

    public Eb(String adm, InterfaceC2676zd providerName, InterfaceC2279d1 adapterConfigs, boolean z2) {
        kotlin.jvm.internal.k.e(adm, "adm");
        kotlin.jvm.internal.k.e(providerName, "providerName");
        kotlin.jvm.internal.k.e(adapterConfigs, "adapterConfigs");
        this.f6675a = adm;
        this.f6676b = providerName;
        this.f6677c = adapterConfigs;
        this.f6678d = z2;
    }

    @Override // com.ironsource.V5
    /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
    public Db a() throws Exception {
        InterfaceC2430l9 interfaceC2430l9A = this.f6677c.a(this.f6676b);
        new S(this.f6675a, interfaceC2430l9A, this.f6678d).a();
        if (interfaceC2430l9A != null) {
            return new Db(interfaceC2430l9A.f(), interfaceC2430l9A.e(), interfaceC2430l9A.b(), interfaceC2430l9A.d(), false, 16, null);
        }
        return null;
    }
}
