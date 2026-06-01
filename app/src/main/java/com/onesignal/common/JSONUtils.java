package com.onesignal.common;

import android.os.Bundle;
import com.onesignal.debug.internal.logging.Logging;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.Map;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import kotlin.jvm.internal.k;
import n6.t;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes5.dex */
public final class JSONUtils {
    public static final String EXTERNAL_USER_ID = "external_user_id";
    public static final JSONUtils INSTANCE = new JSONUtils();

    private JSONUtils() {
    }

    public final JSONObject bundleAsJSONObject(Bundle bundle) {
        k.e(bundle, "bundle");
        JSONObject jSONObject = new JSONObject();
        for (String str : bundle.keySet()) {
            try {
                jSONObject.put(str, bundle.get(str));
            } catch (JSONException e) {
                Logging.error("bundleAsJSONObject error for key: " + str, e);
            }
        }
        return jSONObject;
    }

    /* JADX WARN: Code restructure failed: missing block: B:20:0x0048, code lost:
    
        r3 = r3 + 1;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final boolean compareJSONArrays(org.json.JSONArray r10, org.json.JSONArray r11) {
        /*
            r9 = this;
            r0 = 1
            if (r10 != 0) goto L6
            if (r11 != 0) goto L6
            return r0
        L6:
            r1 = 0
            if (r10 == 0) goto L52
            if (r11 != 0) goto Lc
            goto L52
        Lc:
            int r2 = r10.length()
            int r3 = r11.length()
            if (r2 == r3) goto L17
            return r1
        L17:
            int r2 = r10.length()     // Catch: org.json.JSONException -> L4b
            r3 = r1
        L1c:
            if (r3 >= r2) goto L4e
            int r4 = r11.length()     // Catch: org.json.JSONException -> L4b
            r5 = r1
        L23:
            if (r5 >= r4) goto L4d
            java.lang.Object r6 = r10.get(r3)     // Catch: org.json.JSONException -> L4b
            java.lang.String r7 = "jsonArray1[i]"
            kotlin.jvm.internal.k.d(r6, r7)     // Catch: org.json.JSONException -> L4b
            java.lang.Object r6 = r9.normalizeType(r6)     // Catch: org.json.JSONException -> L4b
            java.lang.Object r7 = r11.get(r5)     // Catch: org.json.JSONException -> L4b
            java.lang.String r8 = "jsonArray2[j]"
            kotlin.jvm.internal.k.d(r7, r8)     // Catch: org.json.JSONException -> L4b
            java.lang.Object r7 = r9.normalizeType(r7)     // Catch: org.json.JSONException -> L4b
            boolean r6 = kotlin.jvm.internal.k.a(r6, r7)     // Catch: org.json.JSONException -> L4b
            if (r6 != 0) goto L48
            int r5 = r5 + 1
            goto L23
        L48:
            int r3 = r3 + 1
            goto L1c
        L4b:
            r10 = move-exception
            goto L4f
        L4d:
            return r1
        L4e:
            return r0
        L4f:
            r10.printStackTrace()
        L52:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.onesignal.common.JSONUtils.compareJSONArrays(org.json.JSONArray, org.json.JSONArray):boolean");
    }

    public final Bundle jsonStringToBundle(String data) {
        k.e(data, "data");
        try {
            JSONObject jSONObject = new JSONObject(data);
            Bundle bundle = new Bundle();
            Iterator<String> itKeys = jSONObject.keys();
            k.d(itKeys, "jsonObject.keys()");
            while (itKeys.hasNext()) {
                String next = itKeys.next();
                k.c(next, "null cannot be cast to non-null type kotlin.String");
                String str = next;
                bundle.putString(str, jSONObject.getString(str));
            }
            return bundle;
        } catch (JSONException e) {
            e.printStackTrace();
            return null;
        }
    }

    public final Map<String, String> newStringMapFromJSONObject(JSONObject jsonObject) {
        k.e(jsonObject, "jsonObject");
        Iterator<String> itKeys = jsonObject.keys();
        k.d(itKeys, "jsonObject.keys()");
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        while (itKeys.hasNext()) {
            String next = itKeys.next();
            try {
                Object objOpt = jsonObject.opt(next);
                if ((objOpt instanceof JSONArray) || (objOpt instanceof JSONObject)) {
                    Logging.error$default("Omitting key '" + next + "'! sendTags DO NOT supported nested values!", null, 2, null);
                } else if (jsonObject.isNull(next) || "".equals(objOpt)) {
                    linkedHashMap.put(next, "");
                } else {
                    linkedHashMap.put(next, objOpt.toString());
                }
            } catch (Throwable unused) {
            }
        }
        return linkedHashMap;
    }

    public final Set<String> newStringSetFromJSONArray(JSONArray jsonArray) throws JSONException {
        k.e(jsonArray, "jsonArray");
        LinkedHashSet linkedHashSet = new LinkedHashSet();
        int length = jsonArray.length();
        for (int i2 = 0; i2 < length; i2++) {
            String string = jsonArray.getString(i2);
            k.d(string, "jsonArray.getString(i)");
            linkedHashSet.add(string);
        }
        return linkedHashSet;
    }

    public final Object normalizeType(Object object) {
        k.e(object, "object");
        Class<?> cls = object.getClass();
        return cls.equals(Integer.TYPE) ? Long.valueOf(((Integer) object).intValue()) : cls.equals(Float.TYPE) ? Double.valueOf(((Float) object).floatValue()) : object;
    }

    public final String toUnescapedEUIDString(JSONObject json) {
        String strGroup;
        k.e(json, "json");
        String string = json.toString();
        k.d(string, "json.toString()");
        if (json.has(EXTERNAL_USER_ID)) {
            Matcher matcher = Pattern.compile("(?<=\"external_user_id\":\").*?(?=\")").matcher(string);
            if (matcher.find() && (strGroup = matcher.group(0)) != null) {
                String strReplaceAll = matcher.replaceAll(Matcher.quoteReplacement(t.l0(strGroup, "\\/", "/")));
                k.d(strReplaceAll, "eidMatcher.replaceAll(unescapedEID)");
                return strReplaceAll;
            }
        }
        return string;
    }

    public final JSONArray wrapInJsonArray(JSONObject jSONObject) {
        JSONArray jSONArrayPut = new JSONArray().put(jSONObject);
        k.d(jSONArrayPut, "JSONArray().put(jsonObject)");
        return jSONArrayPut;
    }
}
