package com.ironsource;

import com.ironsource.C2300e4;
import org.json.JSONObject;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes5.dex */
public final class K1 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final JSONObject f7035a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final boolean f7036b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final String f7037c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final boolean f7038d;
    private final boolean e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final int f7039f;
    private final boolean g;
    private final boolean h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private final int f7040i;
    private final boolean j;
    private final boolean k;
    private final JSONObject l;

    public K1(JSONObject config) {
        kotlin.jvm.internal.k.e(config, "config");
        this.f7035a = config;
        this.f7036b = config.optBoolean("isExternalArmEventsEnabled", true);
        String strOptString = config.optString("externalArmEventsUrl", T5.j);
        kotlin.jvm.internal.k.d(strOptString, "config.optString(EXTERNA…AL_EVENTS_IMPRESSION_URL)");
        this.f7037c = strOptString;
        this.f7038d = config.optBoolean(Q6.f7434c1, true);
        this.e = config.optBoolean("radvid", false);
        this.f7039f = config.optInt("uaeh", 0);
        this.g = config.optBoolean("sharedThreadPool", false);
        this.h = config.optBoolean("sharedThreadPoolADP", true);
        this.f7040i = config.optInt(Q6.S0, -1);
        this.j = config.optBoolean("axal", false);
        this.k = config.optBoolean("psrt", false);
        this.l = config.optJSONObject(C2300e4.a.f8293c);
    }

    private final JSONObject a() {
        return this.f7035a;
    }

    public final int b() {
        return this.f7040i;
    }

    public final JSONObject c() {
        return this.l;
    }

    public final String d() {
        return this.f7037c;
    }

    public final boolean e() {
        return this.k;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof K1) && kotlin.jvm.internal.k.a(this.f7035a, ((K1) obj).f7035a);
    }

    public final boolean f() {
        return this.e;
    }

    public final boolean g() {
        return this.f7038d;
    }

    public final boolean h() {
        return this.g;
    }

    public int hashCode() {
        return this.f7035a.hashCode();
    }

    public final boolean i() {
        return this.h;
    }

    public final int j() {
        return this.f7039f;
    }

    public final boolean k() {
        return this.j;
    }

    public final boolean l() {
        return this.f7036b;
    }

    public String toString() {
        return "ApplicationGeneralSettings(config=" + this.f7035a + ")";
    }

    public final K1 a(JSONObject config) {
        kotlin.jvm.internal.k.e(config, "config");
        return new K1(config);
    }

    public static /* synthetic */ K1 a(K1 k12, JSONObject jSONObject, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            jSONObject = k12.f7035a;
        }
        return k12.a(jSONObject);
    }
}
