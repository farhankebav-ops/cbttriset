package com.ironsource;

/* JADX INFO: renamed from: com.ironsource.y1, reason: case insensitive filesystem */
/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes5.dex */
public final class C2647y1 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final String f10542a;

    public C2647y1() {
        this(null, 1, 0 == true ? 1 : 0);
    }

    public final String a() {
        return this.f10542a;
    }

    public final String b() {
        return this.f10542a;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof C2647y1) && kotlin.jvm.internal.k.a(this.f10542a, ((C2647y1) obj).f10542a);
    }

    public int hashCode() {
        return this.f10542a.hashCode();
    }

    public String toString() {
        return a1.a.m("ApplicationAuctionSettings(auctionData=", this.f10542a, ")");
    }

    public C2647y1(String auctionData) {
        kotlin.jvm.internal.k.e(auctionData, "auctionData");
        this.f10542a = auctionData;
    }

    public final C2647y1 a(String auctionData) {
        kotlin.jvm.internal.k.e(auctionData, "auctionData");
        return new C2647y1(auctionData);
    }

    public /* synthetic */ C2647y1(String str, int i2, kotlin.jvm.internal.f fVar) {
        this((i2 & 1) != 0 ? "" : str);
    }

    public static /* synthetic */ C2647y1 a(C2647y1 c2647y1, String str, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            str = c2647y1.f10542a;
        }
        return c2647y1.a(str);
    }
}
