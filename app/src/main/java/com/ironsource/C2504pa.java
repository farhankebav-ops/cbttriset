package com.ironsource;

import com.ironsource.C2300e4;
import com.ironsource.mediationsdk.logger.IronLog;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: renamed from: com.ironsource.pa, reason: case insensitive filesystem */
/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes5.dex */
public class C2504pa {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private String f9653a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private JSONObject f9654b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private String f9655c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private String f9656d;

    public C2504pa(JSONObject jSONObject) {
        this.f9653a = jSONObject.optString(C2300e4.f.f8337b);
        this.f9654b = jSONObject.optJSONObject(C2300e4.f.f8338c);
        this.f9655c = jSONObject.optString("success");
        this.f9656d = jSONObject.optString(C2300e4.f.e);
    }

    public String a() {
        return this.f9656d;
    }

    public String b() {
        return this.f9653a;
    }

    public JSONObject c() {
        return this.f9654b;
    }

    public String d() {
        return this.f9655c;
    }

    public JSONObject e() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put(C2300e4.f.f8337b, this.f9653a);
            jSONObject.put(C2300e4.f.f8338c, this.f9654b);
            jSONObject.put("success", this.f9655c);
            jSONObject.put(C2300e4.f.e, this.f9656d);
            return jSONObject;
        } catch (JSONException e) {
            C2531r4.d().a(e);
            IronLog.INTERNAL.error(e.toString());
            return jSONObject;
        }
    }
}
