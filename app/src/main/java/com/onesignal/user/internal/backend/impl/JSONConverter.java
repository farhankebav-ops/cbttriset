package com.onesignal.user.internal.backend.impl;

import com.ironsource.C2543s;
import com.ironsource.Q6;
import com.onesignal.common.JSONObjectExtensionsKt;
import com.onesignal.user.internal.backend.CreateUserResponse;
import com.onesignal.user.internal.backend.PropertiesDeltasObject;
import com.onesignal.user.internal.backend.PropertiesObject;
import com.onesignal.user.internal.backend.PurchaseObject;
import com.onesignal.user.internal.backend.SubscriptionObject;
import com.onesignal.user.internal.backend.SubscriptionObjectType;
import java.math.BigDecimal;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.jvm.internal.k;
import kotlin.jvm.internal.l;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import r5.s;
import r5.x;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes5.dex */
public final class JSONConverter {
    public static final JSONConverter INSTANCE = new JSONConverter();

    /* JADX INFO: renamed from: com.onesignal.user.internal.backend.impl.JSONConverter$convertToJSON$1, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
    public static final class AnonymousClass1 extends l implements e6.l {
        public static final AnonymousClass1 INSTANCE = new AnonymousClass1();

        public AnonymousClass1() {
            super(1);
        }

        @Override // e6.l
        public final JSONObject invoke(PurchaseObject it) {
            k.e(it, "it");
            return new JSONObject().put("sku", it.getSku()).put("iso", it.getIso()).put(C2543s.l, it.getAmount().toString());
        }
    }

    private JSONConverter() {
    }

    public final CreateUserResponse convertToCreateUserResponse(JSONObject jsonObject) {
        Map linkedHashMap;
        LinkedHashMap linkedHashMap2;
        JSONObject jSONObjectSafeJSONObject;
        Map<String, Object> map;
        Map<String, Object> map2;
        k.e(jsonObject, "jsonObject");
        JSONObject jSONObjectSafeJSONObject2 = JSONObjectExtensionsKt.safeJSONObject(jsonObject, "identity");
        if (jSONObjectSafeJSONObject2 == null || (map2 = JSONObjectExtensionsKt.toMap(jSONObjectSafeJSONObject2)) == null) {
            linkedHashMap = s.f13639a;
        } else {
            linkedHashMap = new LinkedHashMap(x.d0(map2.size()));
            Iterator<T> it = map2.entrySet().iterator();
            while (it.hasNext()) {
                Map.Entry entry = (Map.Entry) it.next();
                linkedHashMap.put(entry.getKey(), String.valueOf(entry.getValue()));
            }
        }
        JSONObject jSONObjectSafeJSONObject3 = JSONObjectExtensionsKt.safeJSONObject(jsonObject, "properties");
        if (jSONObjectSafeJSONObject3 == null || (jSONObjectSafeJSONObject = JSONObjectExtensionsKt.safeJSONObject(jSONObjectSafeJSONObject3, "tags")) == null || (map = JSONObjectExtensionsKt.toMap(jSONObjectSafeJSONObject)) == null) {
            linkedHashMap2 = null;
        } else {
            LinkedHashMap linkedHashMap3 = new LinkedHashMap(x.d0(map.size()));
            Iterator<T> it2 = map.entrySet().iterator();
            while (it2.hasNext()) {
                Map.Entry entry2 = (Map.Entry) it2.next();
                linkedHashMap3.put(entry2.getKey(), String.valueOf(entry2.getValue()));
            }
            linkedHashMap2 = linkedHashMap3;
        }
        return new CreateUserResponse(linkedHashMap, new PropertiesObject(linkedHashMap2, jSONObjectSafeJSONObject3 != null ? JSONObjectExtensionsKt.safeString(jSONObjectSafeJSONObject3, "language") : null, jSONObjectSafeJSONObject3 != null ? JSONObjectExtensionsKt.safeString(jSONObjectSafeJSONObject3, "timezone_id") : null, jSONObjectSafeJSONObject3 != null ? JSONObjectExtensionsKt.safeString(jSONObjectSafeJSONObject3, "country") : null, jSONObjectSafeJSONObject3 != null ? JSONObjectExtensionsKt.safeDouble(jSONObjectSafeJSONObject3, Q6.f7465s) : null, jSONObjectSafeJSONObject3 != null ? JSONObjectExtensionsKt.safeDouble(jSONObjectSafeJSONObject3, "long") : null), JSONObjectExtensionsKt.expandJSONArray(jsonObject, "subscriptions", JSONConverter$convertToCreateUserResponse$respSubscriptions$1.INSTANCE));
    }

    public final JSONObject convertToJSON(PropertiesObject properties) {
        k.e(properties, "properties");
        return JSONObjectExtensionsKt.putSafe(JSONObjectExtensionsKt.putSafe(JSONObjectExtensionsKt.putSafe(JSONObjectExtensionsKt.putSafe(JSONObjectExtensionsKt.putSafe(JSONObjectExtensionsKt.putMap(new JSONObject(), "tags", properties.getTags()), "language", properties.getLanguage()), "timezone_id", properties.getTimezoneId()), Q6.f7465s, properties.getLatitude()), "long", properties.getLongitude()), "country", properties.getCountry());
    }

    public final JSONObject convertToJSON(PropertiesDeltasObject propertiesDeltas) throws JSONException {
        k.e(propertiesDeltas, "propertiesDeltas");
        JSONObject jSONObjectPutSafe = JSONObjectExtensionsKt.putSafe(JSONObjectExtensionsKt.putSafe(new JSONObject(), "session_time", propertiesDeltas.getSessionTime()), "session_count", propertiesDeltas.getSessionCount());
        BigDecimal amountSpent = propertiesDeltas.getAmountSpent();
        return JSONObjectExtensionsKt.putJSONArray(JSONObjectExtensionsKt.putSafe(jSONObjectPutSafe, "amount_spent", amountSpent != null ? amountSpent.toString() : null), "purchases", propertiesDeltas.getPurchases(), AnonymousClass1.INSTANCE);
    }

    public final JSONArray convertToJSON(List<SubscriptionObject> subscriptions) {
        k.e(subscriptions, "subscriptions");
        JSONArray jSONArray = new JSONArray();
        Iterator<SubscriptionObject> it = subscriptions.iterator();
        while (it.hasNext()) {
            jSONArray.put(convertToJSON(it.next()));
        }
        return jSONArray;
    }

    public final JSONObject convertToJSON(SubscriptionObject subscription) throws JSONException {
        k.e(subscription, "subscription");
        JSONObject jSONObjectPutSafe = JSONObjectExtensionsKt.putSafe(new JSONObject(), "id", subscription.getId());
        SubscriptionObjectType type = subscription.getType();
        return JSONObjectExtensionsKt.putSafe(JSONObjectExtensionsKt.putSafe(JSONObjectExtensionsKt.putSafe(JSONObjectExtensionsKt.putSafe(JSONObjectExtensionsKt.putSafe(JSONObjectExtensionsKt.putSafe(JSONObjectExtensionsKt.putSafe(JSONObjectExtensionsKt.putSafe(JSONObjectExtensionsKt.putSafe(JSONObjectExtensionsKt.putSafe(JSONObjectExtensionsKt.putSafe(jSONObjectPutSafe, "type", type != null ? type.getValue() : null), "token", subscription.getToken()), "enabled", subscription.getEnabled()), "notification_types", subscription.getNotificationTypes()), "sdk", subscription.getSdk()), "device_model", subscription.getDeviceModel()), "device_os", subscription.getDeviceOS()), "rooted", subscription.getRooted()), "net_type", subscription.getNetType()), Q6.P0, subscription.getCarrier()), "app_version", subscription.getAppVersion());
    }
}
