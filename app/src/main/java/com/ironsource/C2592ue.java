package com.ironsource;

import org.json.JSONObject;

/* JADX INFO: renamed from: com.ironsource.ue, reason: case insensitive filesystem */
/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes5.dex */
public final class C2592ue {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Me f10397a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final Ad f10398b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final Cd f10399c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final W3 f10400d;
    private final Q5 e;

    public C2592ue(Me fullResponse) {
        kotlin.jvm.internal.k.e(fullResponse, "fullResponse");
        this.f10397a = fullResponse;
        JSONObject jSONObjectOptJSONObject = fullResponse.i().optJSONObject(C2609ve.f10454a);
        this.f10398b = new Ad(jSONObjectOptJSONObject == null ? new JSONObject() : jSONObjectOptJSONObject);
        JSONObject jSONObjectOptJSONObject2 = fullResponse.i().optJSONObject(C2609ve.f10455b);
        this.f10399c = new Cd(jSONObjectOptJSONObject2 == null ? new JSONObject() : jSONObjectOptJSONObject2);
        JSONObject jSONObjectOptJSONObject3 = fullResponse.i().optJSONObject("configurations");
        this.f10400d = new W3(jSONObjectOptJSONObject3 == null ? new JSONObject() : jSONObjectOptJSONObject3);
        JSONObject jSONObjectOptJSONObject4 = fullResponse.i().optJSONObject(C2609ve.f10457d);
        this.e = new Q5(jSONObjectOptJSONObject4 == null ? new JSONObject() : jSONObjectOptJSONObject4);
    }

    public final W3 a() {
        return this.f10400d;
    }

    public final Q5 b() {
        return this.e;
    }

    public final Me c() {
        return this.f10397a;
    }

    public final Ad d() {
        return this.f10398b;
    }

    public final Cd e() {
        return this.f10399c;
    }
}
