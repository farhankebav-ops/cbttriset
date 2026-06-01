package com.ironsource;

import com.ironsource.C2300e4;
import org.json.JSONObject;

/* JADX INFO: renamed from: com.ironsource.sf, reason: case insensitive filesystem */
/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes5.dex */
public class C2559sf {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final JSONObject f10226a;

    public C2559sf(JSONObject jSONObject) {
        this.f10226a = jSONObject == null ? new JSONObject() : jSONObject;
    }

    public boolean a() {
        return this.f10226a.optBoolean("uxt", false);
    }

    public boolean b() {
        return this.f10226a.optBoolean(C2300e4.a.f8298o, false);
    }

    public boolean c() {
        return this.f10226a.optBoolean(C2300e4.a.p, false);
    }

    public boolean d() {
        return this.f10226a.optBoolean(C2300e4.a.l, false);
    }

    public boolean e() {
        return this.f10226a.optBoolean(C2300e4.a.f8297n, false);
    }
}
