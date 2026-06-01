package com.ironsource;

import com.ironsource.C2569t8;
import java.util.UUID;
import org.json.JSONObject;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes5.dex */
public class X9 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    static String f7796a = "ManRewInst_";

    public static String a(JSONObject jSONObject) {
        if (!jSONObject.optBoolean("rewarded")) {
            return jSONObject.optString("name");
        }
        return f7796a + jSONObject.optString("name");
    }

    public static String b() {
        return UUID.randomUUID().toString();
    }

    public static String a() {
        return String.valueOf(System.currentTimeMillis());
    }

    public static String a(M9 m9) {
        if (m9.i()) {
            return C2569t8.e.Banner.toString();
        }
        if (m9.n()) {
            return C2569t8.e.RewardedVideo.toString();
        }
        return C2569t8.e.Interstitial.toString();
    }
}
