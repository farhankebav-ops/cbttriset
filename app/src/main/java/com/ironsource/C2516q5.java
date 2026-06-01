package com.ironsource;

import com.ironsource.mediationsdk.d;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: renamed from: com.ironsource.q5, reason: case insensitive filesystem */
/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes5.dex */
public final class C2516q5 implements Lb<String, d.a> {
    @Override // com.ironsource.Lb
    public d.a a(String input) throws JSONException {
        kotlin.jvm.internal.k.e(input, "input");
        d.a aVarA = com.ironsource.mediationsdk.d.b().a(new JSONObject(input));
        kotlin.jvm.internal.k.d(aVarA, "getInstance().getAuction…sponse(JSONObject(input))");
        return aVarA;
    }
}
