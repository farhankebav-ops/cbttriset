package com.ironsource;

import com.ironsource.InterfaceC2568t7;
import java.util.concurrent.ConcurrentHashMap;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes5.dex */
public final class S4 implements InterfaceC2568t7, InterfaceC2568t7.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final ConcurrentHashMap<String, P4> f7588a = new ConcurrentHashMap<>();

    @Override // com.ironsource.InterfaceC2568t7
    public O3 a(String identifier) {
        kotlin.jvm.internal.k.e(identifier, "identifier");
        P4 p42 = this.f7588a.get(identifier);
        return (p42 == null || p42.a()) ? new O3(false, null, 2, null) : new O3(true, Q3.Delivery);
    }

    @Override // com.ironsource.InterfaceC2568t7.a
    public void b(String identifier) {
        kotlin.jvm.internal.k.e(identifier, "identifier");
    }

    @Override // com.ironsource.InterfaceC2568t7.a
    public Object a(String identifier, Q3 cappingType, InterfaceC2534r7 cappingConfig) {
        kotlin.jvm.internal.k.e(identifier, "identifier");
        kotlin.jvm.internal.k.e(cappingType, "cappingType");
        kotlin.jvm.internal.k.e(cappingConfig, "cappingConfig");
        Object objA = cappingConfig.a();
        boolean z2 = objA instanceof q5.j;
        q5.x xVar = q5.x.f13520a;
        if (z2) {
            Throwable thA = q5.k.a(objA);
            if (thA != null) {
                return r2.q.M(thA);
            }
        } else {
            P4 p42 = (P4) objA;
            if (p42 != null) {
                this.f7588a.put(identifier, p42);
                return xVar;
            }
        }
        return xVar;
    }
}
