package com.ironsource;

import android.text.TextUtils;
import com.ironsource.mediationsdk.logger.IronLog;
import com.ironsource.mediationsdk.utils.IronSourceUtils;
import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: renamed from: com.ironsource.e, reason: case insensitive filesystem */
/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes5.dex */
abstract class AbstractC2295e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final String f8260a = "eventId";

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final String f8261b = "timestamp";

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final String f8262c = "InterstitialEvents";

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final String f8263d = "events";
    private final String e = "events";

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    JSONObject f8264f;
    int g;
    private String h;

    private String a(int i2) {
        return i2 != 2 ? "events" : "InterstitialEvents";
    }

    public abstract String a();

    public abstract String a(ArrayList<C5> arrayList, JSONObject jSONObject);

    public String b() {
        return TextUtils.isEmpty(this.h) ? a() : this.h;
    }

    public abstract String c();

    public JSONObject a(C5 c52) {
        JSONObject jSONObject;
        try {
            String strA = c52.a();
            if (!TextUtils.isEmpty(strA)) {
                jSONObject = new JSONObject(strA);
            } else {
                jSONObject = new JSONObject();
            }
            jSONObject.put("eventId", c52.c());
            jSONObject.put("timestamp", c52.d());
            return jSONObject;
        } catch (JSONException e) {
            C2531r4.d().a(e);
            IronLog.INTERNAL.error(e.toString());
            return null;
        }
    }

    public String a(JSONArray jSONArray) {
        try {
            if (this.f8264f == null) {
                return "";
            }
            JSONObject jSONObject = new JSONObject(this.f8264f.toString());
            jSONObject.put("timestamp", IronSourceUtils.e());
            jSONObject.put(a(this.g), jSONArray);
            return jSONObject.toString();
        } catch (Exception e) {
            C2531r4.d().a(e);
            return "";
        }
    }

    public void a(String str) {
        this.h = str;
    }
}
