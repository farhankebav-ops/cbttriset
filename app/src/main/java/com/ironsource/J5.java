package com.ironsource;

import com.ironsource.mediationsdk.utils.IronSourceConstants;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes5.dex */
public abstract class J5 implements C0 {
    public final Map<String, Object> a(C2314f0 adProperties) {
        kotlin.jvm.internal.k.e(adProperties, "adProperties");
        HashMap map = new HashMap();
        map.put(IronSourceConstants.EVENTS_PROGRAMMATIC, 1);
        String string = adProperties.a().toString();
        kotlin.jvm.internal.k.d(string, "adProperties.adFormat.toString()");
        map.put(C2253bb.f8068f, string);
        map.put("adf", Integer.valueOf(C2627wf.c(adProperties.a())));
        String string2 = adProperties.b().toString();
        kotlin.jvm.internal.k.d(string2, "adProperties.adId.toString()");
        map.put(C2253bb.f8069i, string2);
        map.put("mediationAdUnitId", adProperties.c());
        map.put("isMultipleAdUnits", 1);
        return map;
    }
}
