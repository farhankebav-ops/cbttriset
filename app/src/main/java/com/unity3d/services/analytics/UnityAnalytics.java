package com.unity3d.services.analytics;

import androidx.camera.core.processing.util.a;
import androidx.core.app.NotificationCompat;
import com.google.ads.mediation.facebook.FacebookMediationAdapter;
import com.google.firebase.analytics.FirebaseAnalytics;
import com.ironsource.C2543s;
import com.unity3d.services.core.webview.WebViewApp;
import com.unity3d.services.core.webview.WebViewEventCategory;
import java.util.Date;
import java.util.HashMap;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes5.dex */
public class UnityAnalytics {
    protected static JSONArray eventQueue = new JSONArray();

    /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
    public enum AnalyticsEventType {
        POSTEVENT
    }

    private static JSONObject createAdComplete(String str, String str2, Boolean bool) {
        HashMap map = new HashMap();
        map.put("rewarded", bool);
        map.put("network", str);
        map.put(FacebookMediationAdapter.RTB_PLACEMENT_PARAMETER, str2);
        HashMap map2 = new HashMap();
        map2.put("custom_params", map);
        map2.put("ts", Long.valueOf(new Date().getTime()));
        map2.put("name", "ad_complete");
        HashMap map3 = new HashMap();
        map3.put("type", "analytics.custom.v1");
        map3.put(NotificationCompat.CATEGORY_MESSAGE, map2);
        return new JSONObject(map3);
    }

    private static JSONObject createIapTransaction(String str, Float f4, String str2, Boolean bool, String str3) {
        HashMap map = new HashMap();
        map.put("ts", Long.valueOf(new Date().getTime()));
        map.put("productid", str);
        map.put(C2543s.l, f4);
        map.put("currency", str2);
        map.put(NotificationCompat.CATEGORY_PROMO, bool);
        map.put("receipt", str3);
        HashMap map2 = new HashMap();
        map2.put("type", "analytics.transaction.v1");
        map2.put(NotificationCompat.CATEGORY_MESSAGE, map);
        return new JSONObject(map2);
    }

    private static JSONObject createItemAcquired(String str, Float f4, String str2, Float f8, String str3, String str4, String str5, AcquisitionType acquisitionType) {
        HashMap map = new HashMap();
        map.put("currency_type", acquisitionType.toString());
        map.put("transaction_context", str);
        map.put(C2543s.l, f4);
        map.put(FirebaseAnalytics.Param.ITEM_ID, str2);
        map.put("balance", f8);
        map.put("item_type", str3);
        map.put(FirebaseAnalytics.Param.LEVEL, str4);
        map.put(FirebaseAnalytics.Param.TRANSACTION_ID, str5);
        HashMap map2 = new HashMap();
        map2.put("custom_params", map);
        map2.put("ts", 1533594423477L);
        map2.put("name", "item_acquired");
        HashMap map3 = new HashMap();
        map3.put("type", "analytics.custom.v1");
        map3.put(NotificationCompat.CATEGORY_MESSAGE, map2);
        return new JSONObject(map3);
    }

    private static JSONObject createItemSpent(String str, Float f4, String str2, Float f8, String str3, String str4, String str5, AcquisitionType acquisitionType) {
        HashMap map = new HashMap();
        map.put("currency_type", acquisitionType.toString());
        map.put("transaction_context", str);
        map.put(C2543s.l, f4);
        map.put(FirebaseAnalytics.Param.ITEM_ID, str2);
        map.put("balance", f8);
        map.put("item_type", str3);
        map.put(FirebaseAnalytics.Param.LEVEL, str4);
        map.put(FirebaseAnalytics.Param.TRANSACTION_ID, str5);
        HashMap map2 = new HashMap();
        map2.put("custom_params", map);
        map2.put("ts", Long.valueOf(new Date().getTime()));
        map2.put("name", "item_spent");
        HashMap map3 = new HashMap();
        map3.put("type", "analytics.custom.v1");
        map3.put(NotificationCompat.CATEGORY_MESSAGE, map2);
        return new JSONObject(map3);
    }

    private static JSONObject createLevelFail(String str) {
        HashMap mapU = a.u("level_index", str);
        HashMap map = new HashMap();
        map.put("custom_params", mapU);
        map.put("ts", Long.valueOf(new Date().getTime()));
        map.put("name", "level_fail");
        HashMap map2 = new HashMap();
        map2.put("type", "analytics.custom.v1");
        map2.put(NotificationCompat.CATEGORY_MESSAGE, map);
        return new JSONObject(map2);
    }

    private static JSONObject createLevelUp(String str) {
        HashMap mapU = a.u("new_level_index", str);
        HashMap map = new HashMap();
        map.put("custom_params", mapU);
        map.put("ts", Long.valueOf(new Date().getTime()));
        map.put("name", FirebaseAnalytics.Event.LEVEL_UP);
        HashMap map2 = new HashMap();
        map2.put("type", "analytics.custom.v1");
        map2.put(NotificationCompat.CATEGORY_MESSAGE, map);
        return new JSONObject(map2);
    }

    public static void onAdComplete(String str, String str2, Boolean bool) {
        postEvent(createAdComplete(str, str2, bool));
    }

    public static void onEvent(JSONObject jSONObject) {
        postEvent(jSONObject);
    }

    public static void onIapTransaction(String str, Float f4, String str2, Boolean bool, String str3) {
        postEvent(createIapTransaction(str, f4, str2, bool, str3));
    }

    public static void onItemAcquired(String str, Float f4, String str2, Float f8, String str3, String str4, String str5, AcquisitionType acquisitionType) {
        postEvent(createItemAcquired(str, f4, str2, f8, str3, str4, str5, acquisitionType));
    }

    public static void onItemSpent(String str, Float f4, String str2, Float f8, String str3, String str4, String str5, AcquisitionType acquisitionType) {
        postEvent(createItemSpent(str, f4, str2, f8, str3, str4, str5, acquisitionType));
    }

    public static void onLevelFail(String str) {
        postEvent(createLevelFail(str));
    }

    public static void onLevelUp(String str) {
        postEvent(createLevelUp(str));
    }

    private static synchronized void postEvent(JSONObject jSONObject) {
        try {
            if (eventQueue.length() < 200) {
                eventQueue.put(jSONObject);
            }
            WebViewApp currentApp = WebViewApp.getCurrentApp();
            if (currentApp != null && currentApp.sendEvent(WebViewEventCategory.ANALYTICS, AnalyticsEventType.POSTEVENT, eventQueue.toString())) {
                eventQueue = new JSONArray();
            }
        } catch (Throwable th) {
            throw th;
        }
    }
}
