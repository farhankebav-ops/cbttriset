package com.ironsource;

import java.util.ArrayList;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes5.dex */
public final class M5 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final ArrayList<String> f7116a = new ArrayList<>(new L5().a());

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final S6 f7117b = new S6();

    public final JSONObject a() throws JSONException {
        JSONObject jSONObjectA = this.f7117b.a(this.f7116a);
        kotlin.jvm.internal.k.d(jSONObjectA, "mGlobalDataReader.getDataByKeys(mEventsKeyList)");
        return jSONObjectA;
    }
}
