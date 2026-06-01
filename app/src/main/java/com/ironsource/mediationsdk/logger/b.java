package com.ironsource.mediationsdk.logger;

import com.google.firebase.analytics.FirebaseAnalytics;
import com.ironsource.C2531r4;
import com.ironsource.mediationsdk.logger.IronSourceLogger;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes5.dex */
class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private IronSourceLogger.IronSourceTag f9225a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private String f9226b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private String f9227c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private int f9228d;

    public b(IronSourceLogger.IronSourceTag ironSourceTag, String str, String str2, int i2) {
        this.f9225a = ironSourceTag;
        this.f9226b = str;
        this.f9227c = str2;
        this.f9228d = i2;
    }

    public int a() {
        return this.f9228d;
    }

    public JSONObject b() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("timestamp", this.f9226b);
            jSONObject.put("tag", this.f9225a);
            jSONObject.put(FirebaseAnalytics.Param.LEVEL, this.f9228d);
            jSONObject.put("message", this.f9227c);
            return jSONObject;
        } catch (JSONException e) {
            C2531r4.d().a(e);
            IronLog.INTERNAL.error(e.toString());
            return jSONObject;
        }
    }
}
