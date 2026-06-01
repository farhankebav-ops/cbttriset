package com.ironsource;

import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes5.dex */
class Wc extends AbstractC2295e {

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private final String f7779i = C2416kd.f8860a;

    public Wc(int i2) {
        this.g = i2;
    }

    @Override // com.ironsource.AbstractC2295e
    public String a() {
        return C2416kd.f8860a;
    }

    @Override // com.ironsource.AbstractC2295e
    public String c() {
        return "outcome";
    }

    @Override // com.ironsource.AbstractC2295e
    public String a(ArrayList<C5> arrayList, JSONObject jSONObject) {
        if (jSONObject == null) {
            this.f8264f = new JSONObject();
        } else {
            this.f8264f = jSONObject;
        }
        JSONArray jSONArray = new JSONArray();
        if (arrayList != null && !arrayList.isEmpty()) {
            int size = arrayList.size();
            int i2 = 0;
            while (i2 < size) {
                C5 c52 = arrayList.get(i2);
                i2++;
                JSONObject jSONObjectA = a(c52);
                if (jSONObjectA != null) {
                    jSONArray.put(jSONObjectA);
                }
            }
        }
        return a(jSONArray);
    }
}
