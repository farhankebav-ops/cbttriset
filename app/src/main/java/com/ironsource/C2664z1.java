package com.ironsource;

import org.json.JSONObject;

/* JADX INFO: renamed from: com.ironsource.z1, reason: case insensitive filesystem */
/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes5.dex */
public final class C2664z1 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Hb f10607a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final boolean f10608b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final D1 f10609c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final K1 f10610d;
    private final C2630x1 e;

    public C2664z1(JSONObject applicationConfigurations) {
        kotlin.jvm.internal.k.e(applicationConfigurations, "applicationConfigurations");
        JSONObject jSONObjectOptJSONObject = applicationConfigurations.optJSONObject(B1.f6355a);
        this.f10607a = new Hb(jSONObjectOptJSONObject == null ? new JSONObject() : jSONObjectOptJSONObject);
        this.f10608b = applicationConfigurations.optBoolean(B1.g, false);
        JSONObject jSONObjectOptJSONObject2 = applicationConfigurations.optJSONObject(B1.h);
        this.f10609c = new D1(jSONObjectOptJSONObject2 == null ? new JSONObject() : jSONObjectOptJSONObject2);
        JSONObject jSONObjectOptJSONObject3 = applicationConfigurations.optJSONObject("settings");
        this.f10610d = new K1(jSONObjectOptJSONObject3 == null ? new JSONObject() : jSONObjectOptJSONObject3);
        JSONObject jSONObjectOptJSONObject4 = applicationConfigurations.optJSONObject(B1.f6359f);
        this.e = new C2630x1(jSONObjectOptJSONObject4 == null ? new JSONObject() : jSONObjectOptJSONObject4);
    }

    public final C2630x1 a() {
        return this.e;
    }

    public final D1 b() {
        return this.f10609c;
    }

    public final K1 c() {
        return this.f10610d;
    }

    public final boolean d() {
        return this.f10608b;
    }

    public final Hb e() {
        return this.f10607a;
    }
}
