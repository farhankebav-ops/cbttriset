package com.ironsource;

import com.ironsource.InterfaceC2568t7;
import java.util.LinkedHashMap;
import java.util.Map;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes5.dex */
public final class Zc implements InterfaceC2568t7, InterfaceC2568t7.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final InterfaceC2565t4 f7921a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final M7 f7922b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final Map<String, Yc> f7923c;

    public Zc(InterfaceC2565t4 currentTimeProvider, M7 repository) {
        kotlin.jvm.internal.k.e(currentTimeProvider, "currentTimeProvider");
        kotlin.jvm.internal.k.e(repository, "repository");
        this.f7921a = currentTimeProvider;
        this.f7922b = repository;
        this.f7923c = new LinkedHashMap();
    }

    public final Map<String, Yc> a() {
        return this.f7923c;
    }

    @Override // com.ironsource.InterfaceC2568t7.a
    public void b(String identifier) {
        kotlin.jvm.internal.k.e(identifier, "identifier");
        if (this.f7923c.get(identifier) == null) {
            return;
        }
        this.f7922b.a(this.f7921a.a(), identifier);
    }

    private final boolean a(Yc yc, String str) {
        Long lA = this.f7922b.a(str);
        return lA != null && this.f7921a.a() - lA.longValue() < yc.a();
    }

    @Override // com.ironsource.InterfaceC2568t7
    public O3 a(String identifier) {
        kotlin.jvm.internal.k.e(identifier, "identifier");
        Yc yc = this.f7923c.get(identifier);
        if (yc == null) {
            return new O3(false, null, 2, null);
        }
        if (a(yc, identifier)) {
            return new O3(true, Q3.Pacing);
        }
        return new O3(false, null, 2, null);
    }

    @Override // com.ironsource.InterfaceC2568t7.a
    public Object a(String identifier, Q3 cappingType, InterfaceC2534r7 cappingConfig) {
        kotlin.jvm.internal.k.e(identifier, "identifier");
        kotlin.jvm.internal.k.e(cappingType, "cappingType");
        kotlin.jvm.internal.k.e(cappingConfig, "cappingConfig");
        Object objB = cappingConfig.b();
        boolean z2 = objB instanceof q5.j;
        q5.x xVar = q5.x.f13520a;
        if (z2) {
            Throwable thA = q5.k.a(objB);
            if (thA != null) {
                return r2.q.M(thA);
            }
        } else {
            Yc yc = (Yc) objB;
            if (yc != null) {
                this.f7923c.put(identifier, yc);
                return xVar;
            }
        }
        return xVar;
    }
}
