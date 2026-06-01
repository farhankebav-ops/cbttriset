package com.ironsource;

import java.util.HashMap;
import java.util.Map;

/* JADX INFO: renamed from: com.ironsource.rd, reason: case insensitive filesystem */
/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes5.dex */
public class C2540rd implements C0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final String f9769a;

    public C2540rd(String placementName) {
        kotlin.jvm.internal.k.e(placementName, "placementName");
        this.f9769a = placementName;
    }

    @Override // com.ironsource.C0
    public Map<String, Object> a(A0 a02) {
        HashMap map = new HashMap();
        map.put("placement", this.f9769a);
        return map;
    }
}
