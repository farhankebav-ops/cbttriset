package com.ironsource;

import java.util.ArrayList;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: renamed from: com.ironsource.g9, reason: case insensitive filesystem */
/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes5.dex */
public final class C2341g9 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final ArrayList<String> f8608a = new ArrayList<>(new C2323f9().a());

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final S6 f8609b = new S6();

    public final JSONObject a() throws JSONException {
        JSONObject jSONObjectA = this.f8609b.a(this.f8608a);
        kotlin.jvm.internal.k.d(jSONObjectA, "mGlobalDataReader.getDataByKeys(mInitKeyList)");
        return jSONObjectA;
    }
}
