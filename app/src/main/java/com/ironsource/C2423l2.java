package com.ironsource;

import org.json.JSONObject;

/* JADX INFO: renamed from: com.ironsource.l2, reason: case insensitive filesystem */
/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes5.dex */
public final class C2423l2 implements InterfaceC2441m2 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final String f8906a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final InterfaceC2676zd f8907b;

    public C2423l2(String encryptedAuctionResponse, InterfaceC2676zd providerName) {
        kotlin.jvm.internal.k.e(encryptedAuctionResponse, "encryptedAuctionResponse");
        kotlin.jvm.internal.k.e(providerName, "providerName");
        this.f8906a = encryptedAuctionResponse;
        this.f8907b = providerName;
    }

    @Override // com.ironsource.InterfaceC2441m2
    public Object a() {
        Object objM;
        String strC = C2499p5.b().c();
        kotlin.jvm.internal.k.d(strC, "getInstance().mediationKey");
        try {
            objM = new C2537ra(new J4(this.f8906a, strC)).a();
        } catch (Throwable th) {
            objM = r2.q.M(th);
        }
        Throwable thA = q5.k.a(objM);
        if (thA == null) {
            return C2387j2.h.a((JSONObject) objM, this.f8907b.value());
        }
        C2531r4.d().a(thA);
        return thA instanceof IllegalArgumentException ? r2.q.M(new C2322f8(C2668z5.f10625a.d())) : r2.q.M(new C2322f8(C2668z5.f10625a.h()));
    }
}
