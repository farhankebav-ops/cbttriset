package com.ironsource;

import org.json.JSONObject;

/* JADX INFO: renamed from: com.ironsource.i4, reason: case insensitive filesystem */
/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes5.dex */
public class C2372i4 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final String f8712a = "SSA_CORE.SDKController.runFunction";

    public static String a(C2389j4 c2389j4) {
        return String.format("%1$s('%2$s%3$s'%4$s)", f8712a, c2389j4.b(), a(c2389j4.c()), b(c2389j4));
    }

    private static String b(C2389j4 c2389j4) {
        return (c2389j4.d() == null || c2389j4.a() == null) ? "" : String.format(", '%1$s', '%2$s'", c2389j4.d(), c2389j4.a());
    }

    private static String a(JSONObject jSONObject) {
        if (jSONObject != null && jSONObject.length() != 0) {
            return jSONObject.toString();
        }
        return "";
    }
}
