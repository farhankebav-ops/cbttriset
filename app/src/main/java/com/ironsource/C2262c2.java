package com.ironsource;

import com.ironsource.Q6;
import java.util.ArrayList;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: renamed from: com.ironsource.c2, reason: case insensitive filesystem */
/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes5.dex */
public final class C2262c2 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Q6.a f8102a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final ArrayList<String> f8103b = new ArrayList<>(new C2226a2().a());

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final S6 f8104c = new S6();

    public C2262c2(Q6.a aVar) {
        this.f8102a = aVar;
    }

    public final JSONObject a() {
        Q6.a aVar = this.f8102a;
        JSONObject jSONObjectA = aVar != null ? this.f8104c.a(this.f8103b, aVar) : null;
        if (jSONObjectA == null) {
            jSONObjectA = this.f8104c.a(this.f8103b);
            kotlin.jvm.internal.k.d(jSONObjectA, "mGlobalDataReader.getDataByKeys(mAuctionKeyList)");
        }
        return a(jSONObjectA);
    }

    private final JSONObject a(JSONObject jSONObject) throws JSONException {
        JSONObject jSONObjectB = T6.b(jSONObject.optJSONObject(Q6.f7470u));
        if (jSONObjectB != null) {
            jSONObject.put(Q6.f7470u, jSONObjectB);
        }
        return jSONObject;
    }
}
