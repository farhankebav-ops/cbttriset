package com.ironsource;

import java.util.HashMap;
import java.util.Map;

/* JADX INFO: renamed from: com.ironsource.g2, reason: case insensitive filesystem */
/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes5.dex */
public final class C2334g2 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final String f8562a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final boolean f8563b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private boolean f8564c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private String f8565d;
    private Map<String, ? extends Object> e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private com.ironsource.mediationsdk.h f8566f;
    private Map<String, Object> g;

    public C2334g2(String name, boolean z2) {
        kotlin.jvm.internal.k.e(name, "name");
        this.f8562a = name;
        this.f8563b = z2;
        this.f8565d = "";
        this.e = r5.s.f13639a;
        this.g = new HashMap();
    }

    public final String a() {
        return this.f8562a;
    }

    public final boolean b() {
        return this.f8563b;
    }

    public final Map<String, Object> c() {
        return this.g;
    }

    public final com.ironsource.mediationsdk.h d() {
        return this.f8566f;
    }

    public final boolean e() {
        return this.f8563b;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof C2334g2)) {
            return false;
        }
        C2334g2 c2334g2 = (C2334g2) obj;
        return kotlin.jvm.internal.k.a(this.f8562a, c2334g2.f8562a) && this.f8563b == c2334g2.f8563b;
    }

    public final Map<String, Object> f() {
        return this.e;
    }

    public final String g() {
        return this.f8562a;
    }

    public final String h() {
        return this.f8565d;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r1v1, types: [int] */
    /* JADX WARN: Type inference failed for: r1v2 */
    /* JADX WARN: Type inference failed for: r1v3 */
    public int hashCode() {
        int iHashCode = this.f8562a.hashCode() * 31;
        boolean z2 = this.f8563b;
        ?? r1 = z2;
        if (z2) {
            r1 = 1;
        }
        return iHashCode + r1;
    }

    public final boolean i() {
        return this.f8564c;
    }

    public String toString() {
        return "AuctionRequestInstanceInfo(name=" + this.f8562a + ", bidder=" + this.f8563b + ")";
    }

    public final C2334g2 a(String name, boolean z2) {
        kotlin.jvm.internal.k.e(name, "name");
        return new C2334g2(name, z2);
    }

    public final void b(Map<String, ? extends Object> map) {
        kotlin.jvm.internal.k.e(map, "<set-?>");
        this.e = map;
    }

    public static /* synthetic */ C2334g2 a(C2334g2 c2334g2, String str, boolean z2, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            str = c2334g2.f8562a;
        }
        if ((i2 & 2) != 0) {
            z2 = c2334g2.f8563b;
        }
        return c2334g2.a(str, z2);
    }

    public final void a(boolean z2) {
        this.f8564c = z2;
    }

    public final void a(String str) {
        kotlin.jvm.internal.k.e(str, "<set-?>");
        this.f8565d = str;
    }

    public final void a(com.ironsource.mediationsdk.h hVar) {
        this.f8566f = hVar;
    }

    public final void a(Map<String, Object> map) {
        kotlin.jvm.internal.k.e(map, "<set-?>");
        this.g = map;
    }
}
