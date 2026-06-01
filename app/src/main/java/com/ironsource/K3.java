package com.ironsource;

import org.json.JSONObject;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes5.dex */
public final class K3 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Boolean f7042a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final Integer f7043b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final P3 f7044c;

    public K3(JSONObject features) {
        kotlin.jvm.internal.k.e(features, "features");
        this.f7042a = features.has("enabled") ? Boolean.valueOf(features.getBoolean("enabled")) : null;
        this.f7043b = features.has("maxImpressions") ? Integer.valueOf(features.getInt("maxImpressions")) : null;
        this.f7044c = features.has("unit") ? P3.f7368c.a(features.optString("unit")) : null;
    }

    public final Boolean a() {
        return this.f7042a;
    }

    public final Integer b() {
        return this.f7043b;
    }

    public final P3 c() {
        return this.f7044c;
    }
}
