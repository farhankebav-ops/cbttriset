package com.ironsource;

import org.json.JSONObject;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes5.dex */
public final class R3 implements X5 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final JSONObject f7536a;

    /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final a f7537a = new a();

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final boolean f7538b = false;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public static final String f7539c = "curlError";

        private a() {
        }
    }

    public R3(JSONObject jSONObject) {
        this.f7536a = jSONObject == null ? new JSONObject() : jSONObject;
    }

    @Override // com.ironsource.X5
    public boolean b() {
        return this.f7536a.optBoolean("enabled", false);
    }

    public final boolean d() {
        return this.f7536a.optBoolean("closeActivity", true);
    }

    public final boolean e() {
        return this.f7536a.optBoolean("reportController", true);
    }
}
