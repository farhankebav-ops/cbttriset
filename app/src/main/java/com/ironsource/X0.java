package com.ironsource;

import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes5.dex */
public final class X0 {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final a f7790b = new a(null);

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final String f7791c = "adUnits";

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final JSONObject f7792a;

    /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
    public static final class a {
        public /* synthetic */ a(kotlin.jvm.internal.f fVar) {
            this();
        }

        private a() {
        }
    }

    public X0(JSONObject configurations) {
        kotlin.jvm.internal.k.e(configurations, "configurations");
        this.f7792a = configurations.optJSONObject(f7791c);
    }

    public final <T> Map<String, T> a(e6.l valueExtractor) throws JSONException {
        kotlin.jvm.internal.k.e(valueExtractor, "valueExtractor");
        JSONObject jSONObject = this.f7792a;
        if (jSONObject == null) {
            return r5.s.f13639a;
        }
        Iterator<String> itKeys = jSONObject.keys();
        kotlin.jvm.internal.k.d(itKeys, "adUnits.keys()");
        m6.h hVarG0 = m6.k.G0(itKeys);
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        for (Object obj : (m6.a) hVarG0) {
            JSONObject jSONObject2 = jSONObject.getJSONObject((String) obj);
            kotlin.jvm.internal.k.d(jSONObject2, "adUnits.getJSONObject(adUnitId)");
            linkedHashMap.put(obj, valueExtractor.invoke(jSONObject2));
        }
        return linkedHashMap;
    }
}
