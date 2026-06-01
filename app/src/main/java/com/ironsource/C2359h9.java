package com.ironsource;

import com.ironsource.environment.ContextProvider;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: renamed from: com.ironsource.h9, reason: case insensitive filesystem */
/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes5.dex */
public final class C2359h9 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final C2359h9 f8678a = new C2359h9();

    private C2359h9() {
    }

    public static final JSONObject a() throws JSONException {
        new V9().b(ContextProvider.getInstance().getApplicationContext());
        JSONObject jSONObjectPut = new JSONObject().put("data", L9.e(C2499p5.b().c(), new C2341g9().a().toString()));
        kotlin.jvm.internal.k.d(jSONObjectPut, "InitProvider()\n        .…ATA_KEY, encryptedData) }");
        return jSONObjectPut;
    }
}
