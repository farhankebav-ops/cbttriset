package com.ironsource;

import java.util.HashMap;
import java.util.Map;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes5.dex */
public class M9 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final boolean f7123a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private String f7124b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private String f7125c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private boolean f7126d;
    private C2376i8 e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private Map<String, String> f7127f;
    private Ic g;
    private String h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private boolean f7128i;
    private boolean j;

    public M9(String str, String str2, boolean z2, boolean z7, boolean z8, boolean z9, String str3, Map<String, String> map, Ic ic, C2376i8 c2376i8) {
        this.f7124b = str;
        this.f7125c = str2;
        this.f7123a = z2;
        this.f7126d = z7;
        this.f7127f = map;
        this.g = ic;
        this.e = c2376i8;
        this.f7128i = z8;
        this.j = z9;
        this.h = str3;
    }

    public Map<String, String> a() {
        HashMap map = new HashMap();
        map.put("instanceId", this.f7124b);
        map.put("instanceName", this.f7125c);
        map.put("rewarded", Boolean.toString(this.f7123a));
        map.put("inAppBidding", Boolean.toString(this.f7126d));
        map.put("isOneFlow", Boolean.toString(this.f7128i));
        map.put(C2300e4.f8285r, String.valueOf(2));
        C2376i8 c2376i8 = this.e;
        map.put("width", c2376i8 != null ? Integer.toString(c2376i8.c()) : "0");
        C2376i8 c2376i82 = this.e;
        map.put("height", c2376i82 != null ? Integer.toString(c2376i82.a()) : "0");
        C2376i8 c2376i83 = this.e;
        map.put("label", c2376i83 != null ? c2376i83.b() : "");
        map.put(C2300e4.f8289v, Boolean.toString(i()));
        if (this.j) {
            map.put("isMultipleAdObjects", com.ironsource.mediationsdk.metadata.a.g);
        }
        String str = this.h;
        if (str != null) {
            map.put("adUnitId", str);
        }
        Map<String, String> map2 = this.f7127f;
        if (map2 != null) {
            map.putAll(map2);
        }
        return map;
    }

    public final Ic b() {
        return this.g;
    }

    public String c() {
        return this.h;
    }

    public Map<String, String> d() {
        return this.f7127f;
    }

    public String e() {
        return this.f7124b;
    }

    public String f() {
        return this.f7125c.replaceAll("IronSource_", "");
    }

    public String g() {
        return this.f7125c;
    }

    public C2376i8 h() {
        return this.e;
    }

    public boolean i() {
        return h() != null && h().d();
    }

    public boolean j() {
        return this.f7126d;
    }

    public boolean k() {
        return j() || m();
    }

    public boolean l() {
        return this.j;
    }

    public boolean m() {
        return this.f7128i;
    }

    public boolean n() {
        return this.f7123a;
    }

    public void a(Ic ic) {
        this.g = ic;
    }

    public void a(String str) {
        this.h = str;
    }
}
