package com.ironsource;

import java.util.Map;

/* JADX INFO: renamed from: com.ironsource.o2, reason: case insensitive filesystem */
/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes5.dex */
public final class C2479o2 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final String f9535a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final com.ironsource.mediationsdk.d f9536b;

    public C2479o2(String serverData) {
        kotlin.jvm.internal.k.e(serverData, "serverData");
        this.f9535a = serverData;
        this.f9536b = com.ironsource.mediationsdk.d.b();
    }

    private final String c() {
        return this.f9535a;
    }

    public final C2479o2 a(String serverData) {
        kotlin.jvm.internal.k.e(serverData, "serverData");
        return new C2479o2(serverData);
    }

    public final Map<String, String> b() {
        Map<String, String> mapB = this.f9536b.b(this.f9535a);
        kotlin.jvm.internal.k.d(mapB, "auctionDataUtils.getAuct…verDataParams(serverData)");
        return mapB;
    }

    public final String d() {
        String strC = this.f9536b.c(this.f9535a);
        kotlin.jvm.internal.k.d(strC, "auctionDataUtils.getDyna…romServerData(serverData)");
        return strC;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof C2479o2) && kotlin.jvm.internal.k.a(this.f9535a, ((C2479o2) obj).f9535a);
    }

    public int hashCode() {
        return this.f9535a.hashCode();
    }

    public String toString() {
        return a1.a.m("AuctionServerData(serverData=", this.f9535a, ")");
    }

    public static /* synthetic */ C2479o2 a(C2479o2 c2479o2, String str, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            str = c2479o2.f9535a;
        }
        return c2479o2.a(str);
    }

    public final String a() {
        String strA = this.f9536b.a(this.f9535a);
        kotlin.jvm.internal.k.d(strA, "auctionDataUtils.getAdmFromServerData(serverData)");
        return strA;
    }
}
