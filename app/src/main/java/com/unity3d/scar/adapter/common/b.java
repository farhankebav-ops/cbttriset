package com.unity3d.scar.adapter.common;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes5.dex */
public final class b extends j {
    public static b a(u3.c cVar) {
        String strL = a1.a.l("Cannot show ad that is not loaded for placement ", cVar.f17527a);
        return new b(c.f10970s, strL, cVar.f17527a, cVar.f17528b, strL);
    }

    @Override // com.unity3d.scar.adapter.common.j
    public final String getDomain() {
        return "GMA";
    }
}
