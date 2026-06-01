package com.ironsource;

import java.util.LinkedHashMap;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: renamed from: com.ironsource.td, reason: case insensitive filesystem */
/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes5.dex */
public final class C2574td {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final a f10302b = new a(null);

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final String f10303c = "placements";

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final String f10304d = "placementName";

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final JSONArray f10305a;

    /* JADX INFO: renamed from: com.ironsource.td$a */
    /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
    public static final class a {
        public /* synthetic */ a(kotlin.jvm.internal.f fVar) {
            this();
        }

        private a() {
        }
    }

    public C2574td(JSONObject configuration) {
        kotlin.jvm.internal.k.e(configuration, "configuration");
        this.f10305a = configuration.optJSONArray(f10303c);
    }

    public final <T> Map<String, T> a(e6.l valueExtractor) throws JSONException {
        kotlin.jvm.internal.k.e(valueExtractor, "valueExtractor");
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        JSONArray jSONArray = this.f10305a;
        if (jSONArray != null) {
            int length = jSONArray.length();
            for (int i2 = 0; i2 < length; i2++) {
                JSONObject jSONObject = jSONArray.getJSONObject(i2);
                String key = jSONObject.optString("placementName");
                Object objInvoke = valueExtractor.invoke(jSONObject);
                kotlin.jvm.internal.k.d(key, "key");
                linkedHashMap.put(key, objInvoke);
            }
        }
        return linkedHashMap;
    }
}
