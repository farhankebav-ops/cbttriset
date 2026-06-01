package com.ironsource;

import java.util.LinkedHashMap;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: renamed from: com.ironsource.uc, reason: case insensitive filesystem */
/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes5.dex */
public final class C2590uc implements InterfaceC2365hf<JSONObject>, InterfaceC2329ff<C2556sc> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Map<String, C2333g1> f10396a = new LinkedHashMap();

    @Override // com.ironsource.InterfaceC2357h7
    /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
    public JSONObject a(EnumC2347gf mode) throws JSONException {
        kotlin.jvm.internal.k.e(mode, "mode");
        JSONObject jSONObject = new JSONObject();
        for (Map.Entry<String, C2333g1> entry : this.f10396a.entrySet()) {
            String key = entry.getKey();
            JSONArray jSONArrayA = entry.getValue().a(mode);
            if (jSONArrayA.length() > 0) {
                jSONObject.put(key, jSONArrayA);
            }
        }
        return jSONObject;
    }

    @Override // com.ironsource.InterfaceC2329ff
    public void a(C2556sc record) {
        kotlin.jvm.internal.k.e(record, "record");
        String strC = record.c();
        Map<String, C2333g1> map = this.f10396a;
        C2333g1 c2333g1 = map.get(strC);
        if (c2333g1 == null) {
            c2333g1 = new C2333g1();
            map.put(strC, c2333g1);
        }
        c2333g1.a(record.a(new C2573tc()));
    }
}
