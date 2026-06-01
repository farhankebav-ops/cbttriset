package com.ironsource;

import android.content.Context;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: renamed from: com.ironsource.ag, reason: case insensitive filesystem */
/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes5.dex */
public final class C2240ag {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final String[] f8017a = Zf.f7932a.a();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final S6 f8018b = new S6();

    public final JSONObject a() throws JSONException {
        JSONObject jSONObjectA = this.f8018b.a(this.f8017a);
        kotlin.jvm.internal.k.d(jSONObjectA, "mGlobalDataReader.getDataByKeys(mTokenKeyList)");
        return a(jSONObjectA);
    }

    public final JSONObject a(Context context) {
        kotlin.jvm.internal.k.e(context, "context");
        JSONObject jSONObjectA = this.f8018b.a(context, this.f8017a);
        kotlin.jvm.internal.k.d(jSONObjectA, "mGlobalDataReader.getDat…s(context, mTokenKeyList)");
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
