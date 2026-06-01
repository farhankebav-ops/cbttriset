package com.ironsource;

import org.json.JSONObject;

/* JADX INFO: renamed from: com.ironsource.k2, reason: case insensitive filesystem */
/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes5.dex */
public final class C2405k2 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final String f8813a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final JSONObject f8814b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final C2461n2 f8815c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final int f8816d;
    private final String e;

    public C2405k2(String auctionId, JSONObject jSONObject, C2461n2 c2461n2, int i2, String auctionFallback) {
        kotlin.jvm.internal.k.e(auctionId, "auctionId");
        kotlin.jvm.internal.k.e(auctionFallback, "auctionFallback");
        this.f8813a = auctionId;
        this.f8814b = jSONObject;
        this.f8815c = c2461n2;
        this.f8816d = i2;
        this.e = auctionFallback;
    }

    public final String a() {
        return this.f8813a;
    }

    public final JSONObject b() {
        return this.f8814b;
    }

    public final C2461n2 c() {
        return this.f8815c;
    }

    public final int d() {
        return this.f8816d;
    }

    public final String e() {
        return this.e;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof C2405k2)) {
            return false;
        }
        C2405k2 c2405k2 = (C2405k2) obj;
        return kotlin.jvm.internal.k.a(this.f8813a, c2405k2.f8813a) && kotlin.jvm.internal.k.a(this.f8814b, c2405k2.f8814b) && kotlin.jvm.internal.k.a(this.f8815c, c2405k2.f8815c) && this.f8816d == c2405k2.f8816d && kotlin.jvm.internal.k.a(this.e, c2405k2.e);
    }

    public final String f() {
        return this.e;
    }

    public final String g() {
        return this.f8813a;
    }

    public final JSONObject h() {
        return this.f8814b;
    }

    public int hashCode() {
        int iHashCode = this.f8813a.hashCode() * 31;
        JSONObject jSONObject = this.f8814b;
        int iHashCode2 = (iHashCode + (jSONObject == null ? 0 : jSONObject.hashCode())) * 31;
        C2461n2 c2461n2 = this.f8815c;
        return this.e.hashCode() + ((((iHashCode2 + (c2461n2 != null ? c2461n2.hashCode() : 0)) * 31) + this.f8816d) * 31);
    }

    public final int i() {
        return this.f8816d;
    }

    public final C2461n2 j() {
        return this.f8815c;
    }

    public String toString() {
        String str = this.f8813a;
        JSONObject jSONObject = this.f8814b;
        C2461n2 c2461n2 = this.f8815c;
        int i2 = this.f8816d;
        String str2 = this.e;
        StringBuilder sb = new StringBuilder("AuctionResponseData(auctionId=");
        sb.append(str);
        sb.append(", auctionResponseGenericParam=");
        sb.append(jSONObject);
        sb.append(", genericNotifications=");
        sb.append(c2461n2);
        sb.append(", auctionTrial=");
        sb.append(i2);
        sb.append(", auctionFallback=");
        return a1.a.r(sb, str2, ")");
    }

    public final C2405k2 a(String auctionId, JSONObject jSONObject, C2461n2 c2461n2, int i2, String auctionFallback) {
        kotlin.jvm.internal.k.e(auctionId, "auctionId");
        kotlin.jvm.internal.k.e(auctionFallback, "auctionFallback");
        return new C2405k2(auctionId, jSONObject, c2461n2, i2, auctionFallback);
    }

    public static /* synthetic */ C2405k2 a(C2405k2 c2405k2, String str, JSONObject jSONObject, C2461n2 c2461n2, int i2, String str2, int i8, Object obj) {
        if ((i8 & 1) != 0) {
            str = c2405k2.f8813a;
        }
        if ((i8 & 2) != 0) {
            jSONObject = c2405k2.f8814b;
        }
        if ((i8 & 4) != 0) {
            c2461n2 = c2405k2.f8815c;
        }
        if ((i8 & 8) != 0) {
            i2 = c2405k2.f8816d;
        }
        if ((i8 & 16) != 0) {
            str2 = c2405k2.e;
        }
        String str3 = str2;
        C2461n2 c2461n22 = c2461n2;
        return c2405k2.a(str, jSONObject, c2461n22, i2, str3);
    }
}
