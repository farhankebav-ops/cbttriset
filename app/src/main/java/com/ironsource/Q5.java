package com.ironsource;

import org.json.JSONObject;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes5.dex */
public final class Q5 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final JSONObject f7425a;

    public Q5(JSONObject jSONObject) {
        this.f7425a = jSONObject;
    }

    public final Boolean a(String key) {
        kotlin.jvm.internal.k.e(key, "key");
        JSONObject jSONObject = this.f7425a;
        Object objOpt = jSONObject != null ? jSONObject.opt(key) : null;
        if (objOpt instanceof Boolean) {
            return (Boolean) objOpt;
        }
        return null;
    }

    public final Integer b(String key) {
        kotlin.jvm.internal.k.e(key, "key");
        JSONObject jSONObject = this.f7425a;
        Object objOpt = jSONObject != null ? jSONObject.opt(key) : null;
        if (objOpt instanceof Integer) {
            return (Integer) objOpt;
        }
        return null;
    }

    public final String c(String key) {
        kotlin.jvm.internal.k.e(key, "key");
        JSONObject jSONObject = this.f7425a;
        Object objOpt = jSONObject != null ? jSONObject.opt(key) : null;
        if (objOpt instanceof String) {
            return (String) objOpt;
        }
        return null;
    }
}
