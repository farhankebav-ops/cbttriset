package com.ironsource;

import com.ironsource.mediationsdk.IronSource;
import com.ironsource.sdk.controller.f;
import java.util.Date;
import java.util.Objects;
import org.json.JSONObject;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes5.dex */
public final class N {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final a f7247f = new a(null);
    public static final String g = "0";
    public static final String h = "0";

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public static final String f7248i = "0";
    public static final String j = "0";

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final M9 f7249a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private W7 f7250b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private String f7251c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private EnumC2439m0 f7252d;
    private double e;

    /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
    public static final class a {
        public /* synthetic */ a(kotlin.jvm.internal.f fVar) {
            this();
        }

        private a() {
        }
    }

    public N(M9 adInstance) {
        kotlin.jvm.internal.k.e(adInstance, "adInstance");
        this.f7249a = adInstance;
        this.f7250b = W7.UnknownProvider;
        this.f7251c = "0";
        this.f7252d = EnumC2439m0.LOAD_REQUEST;
        this.e = new Date().getTime() / 1000.0d;
    }

    public final M9 a() {
        return this.f7249a;
    }

    public final IronSource.a b() {
        return this.f7249a.i() ? IronSource.a.BANNER : this.f7249a.n() ? IronSource.a.REWARDED_VIDEO : IronSource.a.INTERSTITIAL;
    }

    public final String c() {
        String strE = this.f7249a.e();
        kotlin.jvm.internal.k.d(strE, "adInstance.id");
        return strE;
    }

    public final M9 d() {
        return this.f7249a;
    }

    public final W7 e() {
        return this.f7250b;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof N)) {
            return false;
        }
        N n2 = (N) obj;
        return kotlin.jvm.internal.k.a(c(), n2.c()) && kotlin.jvm.internal.k.a(g(), n2.g()) && b() == n2.b() && kotlin.jvm.internal.k.a(i(), n2.i()) && this.f7250b == n2.f7250b && kotlin.jvm.internal.k.a(this.f7251c, n2.f7251c) && this.f7252d == n2.f7252d;
    }

    public final EnumC2439m0 f() {
        return this.f7252d;
    }

    public final String g() {
        String strC = this.f7249a.c();
        return strC == null ? "0" : strC;
    }

    public final String h() {
        return this.f7251c;
    }

    public int hashCode() {
        return Objects.hash(c(), g(), b(), i(), this.f7250b, this.f7251c, this.f7252d, Double.valueOf(this.e));
    }

    public final String i() {
        String strG = this.f7249a.g();
        kotlin.jvm.internal.k.d(strG, "adInstance.name");
        return strG;
    }

    public final double j() {
        return this.e;
    }

    public String toString() {
        String string = new JSONObject().put(f.b.f9966c, c()).put("advertiserBundleId", this.f7251c).put("adProvider", this.f7250b.ordinal()).put("adStatus", this.f7252d.ordinal()).put("lastStatusUpdateTimeStamp", (long) this.e).put("adUnitId", g()).put("adFormat", b().toString()).put("instanceId", i()).toString();
        kotlin.jvm.internal.k.d(string, "JSONObject()\n        .pu…ceId)\n        .toString()");
        return string;
    }

    public final N a(M9 adInstance) {
        kotlin.jvm.internal.k.e(adInstance, "adInstance");
        return new N(adInstance);
    }

    public static /* synthetic */ N a(N n2, M9 m9, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            m9 = n2.f7249a;
        }
        return n2.a(m9);
    }

    public final void a(W7 w7) {
        kotlin.jvm.internal.k.e(w7, "<set-?>");
        this.f7250b = w7;
    }

    public final void a(String str) {
        kotlin.jvm.internal.k.e(str, "<set-?>");
        this.f7251c = str;
    }

    public final void a(EnumC2439m0 enumC2439m0) {
        kotlin.jvm.internal.k.e(enumC2439m0, "<set-?>");
        this.f7252d = enumC2439m0;
    }

    public final void a(double d8) {
        this.e = d8;
    }
}
