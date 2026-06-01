package com.ironsource;

import android.content.Context;
import android.util.Pair;
import com.ironsource.C2569t8;
import com.ironsource.C2654y8;
import com.ironsource.I5;
import java.util.ArrayList;
import java.util.Map;
import org.json.JSONObject;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes5.dex */
public class B8 {
    public static C2654y8 a(Context context, String str, String str2, Map<String, String> map) throws Exception {
        C2654y8.a aVar = new C2654y8.a();
        if (map != null && map.containsKey("sessionid")) {
            aVar.c(map.get("sessionid"));
        }
        aVar.a(context);
        return aVar.d(str).a(str2).a();
    }

    public static I5 a(JSONObject jSONObject) {
        return new I5.a(jSONObject.optString(G5.f6811r)).b().b(jSONObject.optBoolean("enabled")).a(new C2671z8()).a(a()).a(false).a();
    }

    private static ArrayList<Pair<String, String>> a() {
        ArrayList<Pair<String, String>> arrayList = new ArrayList<>();
        arrayList.add(new Pair<>("Content-Type", G5.L));
        arrayList.add(new Pair<>(G5.M, G5.N));
        return arrayList;
    }

    public static boolean a(Y4 y42) {
        if (y42 == null || y42.g().get("inAppBidding") == null) {
            return false;
        }
        return Boolean.parseBoolean(y42.g().get("inAppBidding"));
    }

    public static C2569t8.e a(Y4 y42, C2569t8.e eVar) {
        if (y42 == null || y42.g() == null || y42.g().get("rewarded") == null) {
            return eVar;
        }
        if (Boolean.parseBoolean(y42.g().get("rewarded"))) {
            return C2569t8.e.RewardedVideo;
        }
        return C2569t8.e.Interstitial;
    }
}
