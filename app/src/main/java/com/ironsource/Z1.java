package com.ironsource;

import java.util.HashMap;
import java.util.Map;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes5.dex */
public final class Z1 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final String f7881a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final boolean f7882b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private boolean f7883c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private String f7884d;
    private Map<String, ? extends Object> e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private com.ironsource.mediationsdk.h f7885f;
    private Map<String, Object> g;

    public Z1(String name, boolean z2) {
        kotlin.jvm.internal.k.e(name, "name");
        this.f7881a = name;
        this.f7882b = z2;
        this.f7884d = "";
        this.e = r5.s.f13639a;
        this.g = new HashMap();
    }

    public final String a() {
        return this.f7881a;
    }

    public final boolean b() {
        return this.f7882b;
    }

    public final Map<String, Object> c() {
        return this.g;
    }

    public final com.ironsource.mediationsdk.h d() {
        return this.f7885f;
    }

    public final boolean e() {
        return this.f7882b;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof Z1)) {
            return false;
        }
        Z1 z12 = (Z1) obj;
        return kotlin.jvm.internal.k.a(this.f7881a, z12.f7881a) && this.f7882b == z12.f7882b;
    }

    public final Map<String, Object> f() {
        return this.e;
    }

    public final String g() {
        return this.f7881a;
    }

    public final String h() {
        return this.f7884d;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r1v1, types: [int] */
    /* JADX WARN: Type inference failed for: r1v2 */
    /* JADX WARN: Type inference failed for: r1v3 */
    public int hashCode() {
        int iHashCode = this.f7881a.hashCode() * 31;
        boolean z2 = this.f7882b;
        ?? r1 = z2;
        if (z2) {
            r1 = 1;
        }
        return iHashCode + r1;
    }

    public final boolean i() {
        return this.f7883c;
    }

    public String toString() {
        return "AuctionInstanceInfo(name=" + this.f7881a + ", bidder=" + this.f7882b + ")";
    }

    public final Z1 a(String name, boolean z2) {
        kotlin.jvm.internal.k.e(name, "name");
        return new Z1(name, z2);
    }

    public final void b(Map<String, ? extends Object> map) {
        kotlin.jvm.internal.k.e(map, "<set-?>");
        this.e = map;
    }

    public static /* synthetic */ Z1 a(Z1 z12, String str, boolean z2, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            str = z12.f7881a;
        }
        if ((i2 & 2) != 0) {
            z2 = z12.f7882b;
        }
        return z12.a(str, z2);
    }

    public final void a(boolean z2) {
        this.f7883c = z2;
    }

    public final void a(String str) {
        kotlin.jvm.internal.k.e(str, "<set-?>");
        this.f7884d = str;
    }

    public final void a(com.ironsource.mediationsdk.h hVar) {
        this.f7885f = hVar;
    }

    public final void a(Map<String, Object> map) {
        kotlin.jvm.internal.k.e(map, "<set-?>");
        this.g = map;
    }
}
