package com.unity3d.ads.core.extensions;

import com.google.android.gms.ads.AdError;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.jvm.internal.k;
import m6.a;
import m6.h;
import org.json.JSONObject;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes5.dex */
public final class JSONObjectExtensionsKt {
    public static final Map<String, Object> toBuiltInMap(JSONObject jSONObject) {
        k.e(jSONObject, "<this>");
        Iterator<String> itKeys = jSONObject.keys();
        k.d(itKeys, "keys()");
        h hVarG0 = m6.k.G0(itKeys);
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        for (Object obj : (a) hVarG0) {
            Object objOpt = jSONObject.opt((String) obj);
            if (objOpt == null || String.valueOf(objOpt).equals(AdError.UNDEFINED_DOMAIN) || String.valueOf(objOpt).equals("null")) {
                objOpt = null;
            }
            linkedHashMap.put(obj, objOpt);
        }
        return linkedHashMap;
    }
}
