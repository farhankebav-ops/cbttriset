package com.ironsource;

import org.json.JSONObject;

/* JADX INFO: renamed from: com.ironsource.cd, reason: case insensitive filesystem */
/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes5.dex */
public final class C2273cd {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Boolean f8156a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final Integer f8157b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final P3 f8158c;

    public C2273cd(JSONObject features) {
        kotlin.jvm.internal.k.e(features, "features");
        this.f8156a = features.has("enabled") ? Boolean.valueOf(features.getBoolean("enabled")) : null;
        this.f8157b = features.has("numOfSeconds") ? Integer.valueOf(features.getInt("numOfSeconds")) : null;
        this.f8158c = P3.Second;
    }

    public final Boolean a() {
        return this.f8156a;
    }

    public final Integer b() {
        return this.f8157b;
    }

    public final P3 c() {
        return this.f8158c;
    }
}
