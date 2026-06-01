package com.ironsource;

import java.util.LinkedHashMap;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes5.dex */
public final class G0 implements InterfaceC2365hf<JSONObject>, InterfaceC2329ff<E0> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Map<String, C2590uc> f6781a = new LinkedHashMap();

    @Override // com.ironsource.InterfaceC2357h7
    /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
    public JSONObject a(EnumC2347gf mode) throws JSONException {
        kotlin.jvm.internal.k.e(mode, "mode");
        JSONObject jSONObject = new JSONObject();
        for (Map.Entry<String, C2590uc> entry : this.f6781a.entrySet()) {
            String key = entry.getKey();
            JSONObject jSONObjectA = entry.getValue().a(mode);
            if (jSONObjectA.length() > 0) {
                jSONObject.put(n6.m.P0(key, "_"), jSONObjectA);
            }
        }
        return jSONObject;
    }

    @Override // com.ironsource.InterfaceC2329ff
    public void a(E0 record) {
        kotlin.jvm.internal.k.e(record, "record");
        String strD = record.d();
        Map<String, C2590uc> map = this.f6781a;
        C2590uc c2590uc = map.get(strD);
        if (c2590uc == null) {
            c2590uc = new C2590uc();
            map.put(strD, c2590uc);
        }
        c2590uc.a(record.a(new F0()));
    }
}
