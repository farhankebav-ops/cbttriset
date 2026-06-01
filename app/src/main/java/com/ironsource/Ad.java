package com.ironsource;

import com.unity3d.mediation.LevelPlay;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes5.dex */
public final class Ad {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Map<LevelPlay.AdFormat, a> f6339a;

    /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final Map<String, b> f6340a;

        public a(JSONObject adFormatProviderOrder) throws JSONException {
            kotlin.jvm.internal.k.e(adFormatProviderOrder, "adFormatProviderOrder");
            Iterable iterableB = C2395ja.b(adFormatProviderOrder.names());
            iterableB = iterableB == null ? r5.r.f13638a : iterableB;
            int iD0 = r5.x.d0(r5.n.L0(iterableB, 10));
            LinkedHashMap linkedHashMap = new LinkedHashMap(iD0 < 16 ? 16 : iD0);
            for (Object obj : iterableB) {
                JSONArray jSONArrayOptJSONArray = adFormatProviderOrder.optJSONArray((String) obj);
                if (jSONArrayOptJSONArray == null) {
                    jSONArrayOptJSONArray = new JSONArray();
                }
                linkedHashMap.put(obj, new b(jSONArrayOptJSONArray));
            }
            this.f6340a = linkedHashMap;
        }

        public final Map<String, b> a() {
            return this.f6340a;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
    public static final class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final List<String> f6341a;

        public b(JSONArray providerOrder) throws JSONException {
            kotlin.jvm.internal.k.e(providerOrder, "providerOrder");
            List<String> listB = C2395ja.b(providerOrder);
            kotlin.jvm.internal.k.d(listB, "jsonArrayToStringList(providerOrder)");
            this.f6341a = listB;
        }

        public final List<String> a() {
            return this.f6341a;
        }
    }

    public Ad(JSONObject providerOrder) {
        kotlin.jvm.internal.k.e(providerOrder, "providerOrder");
        LevelPlay.AdFormat[] adFormatArrValues = LevelPlay.AdFormat.values();
        int iD0 = r5.x.d0(adFormatArrValues.length);
        LinkedHashMap linkedHashMap = new LinkedHashMap(iD0 < 16 ? 16 : iD0);
        for (LevelPlay.AdFormat adFormat : adFormatArrValues) {
            JSONObject jSONObjectOptJSONObject = providerOrder.optJSONObject(C2627wf.a(adFormat));
            if (jSONObjectOptJSONObject == null) {
                jSONObjectOptJSONObject = new JSONObject();
            }
            linkedHashMap.put(adFormat, new a(jSONObjectOptJSONObject));
        }
        this.f6339a = linkedHashMap;
    }

    public final Map<LevelPlay.AdFormat, a> a() {
        return this.f6339a;
    }
}
