package com.ironsource;

import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes5.dex */
public final class Cd {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Map<String, C2675zc> f6409a;

    /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
    public static final class a extends kotlin.jvm.internal.l implements e6.l {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ JSONObject f6410a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(JSONObject jSONObject) {
            super(1);
            this.f6410a = jSONObject;
        }

        @Override // e6.l
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public final q5.i invoke(String networkName) throws JSONException {
            kotlin.jvm.internal.k.d(networkName, "networkName");
            JSONObject jSONObject = this.f6410a.getJSONObject(networkName);
            kotlin.jvm.internal.k.d(jSONObject, "providerSettings.getJSONObject(networkName)");
            return new q5.i(networkName, new C2675zc(networkName, jSONObject));
        }
    }

    public Cd(JSONObject providerSettings) {
        kotlin.jvm.internal.k.e(providerSettings, "providerSettings");
        Iterator<String> itKeys = providerSettings.keys();
        kotlin.jvm.internal.k.d(itKeys, "providerSettings\n          .keys()");
        m6.f fVarJ0 = m6.k.J0(m6.k.G0(itKeys), new a(providerSettings));
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        Iterator it = fVarJ0.f12979b.iterator();
        while (it.hasNext()) {
            q5.i iVar = (q5.i) fVarJ0.f12980c.invoke(it.next());
            linkedHashMap.put(iVar.f13498a, iVar.f13499b);
        }
        Map<String, C2675zc> mapH0 = r5.x.h0(linkedHashMap);
        this.f6409a = mapH0;
        for (Map.Entry<String, C2675zc> entry : mapH0.entrySet()) {
            entry.getKey();
            C2675zc value = entry.getValue();
            if (b(value)) {
                value.b(a(value));
            }
        }
    }

    private final boolean b(C2675zc c2675zc) {
        return c2675zc.o() && c2675zc.l().length() > 0;
    }

    public final Map<String, C2675zc> a() {
        return this.f6409a;
    }

    private final C2675zc a(C2675zc c2675zc) {
        return this.f6409a.get(c2675zc.h());
    }
}
