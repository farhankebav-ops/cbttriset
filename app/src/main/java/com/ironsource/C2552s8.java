package com.ironsource;

import com.ironsource.C2300e4;
import com.ironsource.InterfaceC2535r8;
import org.json.JSONObject;

/* JADX INFO: renamed from: com.ironsource.s8, reason: case insensitive filesystem */
/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes5.dex */
public final class C2552s8 implements InterfaceC2535r8, InterfaceC2535r8.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private JSONObject f9818a = new JSONObject();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private JSONObject f9819b = new JSONObject();

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private JSONObject f9820c = new JSONObject();

    private final Object e(String str) {
        if (this.f9820c.has(str)) {
            return this.f9820c.get(str);
        }
        if (this.f9819b.has(str)) {
            return this.f9819b.get(str);
        }
        if (this.f9818a.has(str)) {
            return this.f9818a.get(str);
        }
        return null;
    }

    @Override // com.ironsource.InterfaceC2535r8
    public JSONObject a(String configKey) {
        kotlin.jvm.internal.k.e(configKey, "configKey");
        Object objE = e(configKey);
        if (objE instanceof JSONObject) {
            return (JSONObject) objE;
        }
        return null;
    }

    @Override // com.ironsource.InterfaceC2535r8
    public Integer b(String configKey) {
        kotlin.jvm.internal.k.e(configKey, "configKey");
        Object objE = e(configKey);
        if (objE instanceof Integer) {
            return (Integer) objE;
        }
        return null;
    }

    @Override // com.ironsource.InterfaceC2535r8
    public Boolean c(String configKey) {
        kotlin.jvm.internal.k.e(configKey, "configKey");
        Object objE = e(configKey);
        if (objE instanceof Boolean) {
            return (Boolean) objE;
        }
        return null;
    }

    @Override // com.ironsource.InterfaceC2535r8
    public String d(String configKey) {
        kotlin.jvm.internal.k.e(configKey, "configKey");
        Object objE = e(configKey);
        if (objE instanceof String) {
            return (String) objE;
        }
        return null;
    }

    @Override // com.ironsource.InterfaceC2535r8.a
    public void a(JSONObject controllerConfig) {
        kotlin.jvm.internal.k.e(controllerConfig, "controllerConfig");
        this.f9818a = controllerConfig;
        JSONObject jSONObjectOptJSONObject = controllerConfig.optJSONObject(C2300e4.a.f8292b);
        if (jSONObjectOptJSONObject == null) {
            jSONObjectOptJSONObject = new JSONObject();
        }
        this.f9819b = jSONObjectOptJSONObject;
        JSONObject jSONObjectOptJSONObject2 = this.f9818a.optJSONObject(C2300e4.a.f8293c);
        if (jSONObjectOptJSONObject2 == null) {
            jSONObjectOptJSONObject2 = new JSONObject();
        }
        this.f9820c = jSONObjectOptJSONObject2;
    }
}
