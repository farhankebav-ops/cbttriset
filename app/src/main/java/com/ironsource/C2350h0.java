package com.ironsource;

import java.util.ArrayList;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: renamed from: com.ironsource.h0, reason: case insensitive filesystem */
/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes5.dex */
public final class C2350h0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final ArrayList<String> f8632a = new ArrayList<>(new C2332g0().a());

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final S6 f8633b = new S6();

    public final JSONObject a() throws JSONException {
        JSONObject jSONObjectA = this.f8633b.a(this.f8632a);
        kotlin.jvm.internal.k.d(jSONObjectA, "mGlobalDataReader.getDataByKeys(mAdQualityKeyList)");
        return jSONObjectA;
    }
}
