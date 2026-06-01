package com.ironsource;

import java.util.HashMap;
import java.util.Map;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes5.dex */
public class Y4 {
    public static final int h = 0;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public static final int f7824i = 1;
    public static final int j = 2;
    public static final int k = 3;
    public static final int l = -1;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private String f7825a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private String f7826b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private int f7827c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private Map<String, String> f7828d;
    private int e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private boolean f7829f;
    private M9 g;

    public Y4(String str, String str2, Map<String, String> map, Ic ic) {
        this.f7827c = -1;
        this.f7826b = str;
        this.f7825a = str2;
        this.f7828d = map;
        this.e = 0;
        this.f7829f = false;
        this.g = null;
    }

    public void a(boolean z2) {
        this.f7829f = z2;
    }

    public synchronized void b(int i2) {
        this.e = i2;
    }

    public M9 c() {
        return this.g;
    }

    public boolean d() {
        return this.f7829f;
    }

    public int e() {
        return this.e;
    }

    public String f() {
        return this.f7825a;
    }

    public Map<String, String> g() {
        return this.f7828d;
    }

    public String h() {
        return this.f7826b;
    }

    public Ic i() {
        if (this.g != null) {
            return c().b();
        }
        return null;
    }

    public int j() {
        return this.f7827c;
    }

    public boolean k() {
        Map<String, String> map = this.f7828d;
        if (map == null || !map.containsKey("rewarded")) {
            return false;
        }
        return Boolean.parseBoolean(this.f7828d.get("rewarded"));
    }

    public boolean a(int i2) {
        return this.f7827c == i2;
    }

    public Map<String, String> b() {
        HashMap map = new HashMap();
        map.put("demandSourceId", this.f7826b);
        map.put("demandSourceName", this.f7825a);
        Map<String, String> map2 = this.f7828d;
        if (map2 != null) {
            map.putAll(map2);
        }
        return map;
    }

    public void c(int i2) {
        this.f7827c = i2;
    }

    public void a() {
        Map<String, String> map = this.f7828d;
        if (map != null) {
            map.clear();
        }
        this.f7828d = null;
    }

    public Y4(M9 m9) {
        this(m9.e(), m9.g(), m9.a(), m9.b());
        this.g = m9;
    }
}
