package com.vungle.ads.internal.util;

import g7.m;
import g7.n;
import g7.x;
import kotlin.jvm.internal.k;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes5.dex */
public final class JsonUtil {
    public static final JsonUtil INSTANCE = new JsonUtil();

    private JsonUtil() {
    }

    public final String getContentStringValue(x json, String key) {
        k.e(json, "json");
        k.e(key, "key");
        try {
            return n.e((m) r5.x.b0(json, key)).a();
        } catch (Exception unused) {
            return null;
        }
    }
}
