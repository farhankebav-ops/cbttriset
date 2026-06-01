package com.ironsource;

import com.ironsource.D0;
import com.ironsource.mediationsdk.IronSource;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes5.dex */
public final class E5 implements C0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final IronSource.a f6658a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final D0 f6659b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final List<C0> f6660c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final C2251b9 f6661d;
    private final Ab e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final Yf f6662f;
    private final R1 g;
    private final M h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private final C2294dg f6663i;
    private final Vc j;

    public E5(IronSource.a adFormat, D0.b level, List<? extends C0> eventsInterfaces, AbstractC2581u3 abstractC2581u3) {
        kotlin.jvm.internal.k.e(adFormat, "adFormat");
        kotlin.jvm.internal.k.e(level, "level");
        kotlin.jvm.internal.k.e(eventsInterfaces, "eventsInterfaces");
        this.f6658a = adFormat;
        D0 d0 = new D0(adFormat, level, this, abstractC2581u3);
        this.f6659b = d0;
        this.f6660c = r5.l.o1(eventsInterfaces);
        C2251b9 c2251b9 = d0.e;
        kotlin.jvm.internal.k.d(c2251b9, "wrapper.init");
        this.f6661d = c2251b9;
        Ab ab = d0.f6419f;
        kotlin.jvm.internal.k.d(ab, "wrapper.load");
        this.e = ab;
        Yf yf = d0.g;
        kotlin.jvm.internal.k.d(yf, "wrapper.token");
        this.f6662f = yf;
        R1 r1 = d0.h;
        kotlin.jvm.internal.k.d(r1, "wrapper.auction");
        this.g = r1;
        M m = d0.f6420i;
        kotlin.jvm.internal.k.d(m, "wrapper.adInteraction");
        this.h = m;
        C2294dg c2294dg = d0.j;
        kotlin.jvm.internal.k.d(c2294dg, "wrapper.troubleshoot");
        this.f6663i = c2294dg;
        Vc vc = d0.k;
        kotlin.jvm.internal.k.d(vc, "wrapper.operational");
        this.j = vc;
    }

    public final M a() {
        return this.h;
    }

    public final R1 b() {
        return this.g;
    }

    public final List<C0> c() {
        return this.f6660c;
    }

    public final C2251b9 d() {
        return this.f6661d;
    }

    public final Ab e() {
        return this.e;
    }

    public final Vc f() {
        return this.j;
    }

    public final Yf g() {
        return this.f6662f;
    }

    public final C2294dg h() {
        return this.f6663i;
    }

    @Override // com.ironsource.C0
    public Map<String, Object> a(A0 event) {
        kotlin.jvm.internal.k.e(event, "event");
        HashMap map = new HashMap();
        Iterator<C0> it = this.f6660c.iterator();
        while (it.hasNext()) {
            Map<String, Object> mapA = it.next().a(event);
            kotlin.jvm.internal.k.d(mapA, "it.getEventsAdditionalDataMap(event)");
            map.putAll(mapA);
        }
        return map;
    }

    public final void a(C0 eventInterface) {
        kotlin.jvm.internal.k.e(eventInterface, "eventInterface");
        this.f6660c.add(eventInterface);
    }

    public final void a(boolean z2) {
        if (z2) {
            this.e.a(true);
        } else {
            if (!z2) {
                if (this.f6658a == IronSource.a.BANNER) {
                    this.e.a();
                    return;
                } else {
                    this.e.a(false);
                    return;
                }
            }
            throw new e2.s(3);
        }
    }

    public /* synthetic */ E5(IronSource.a aVar, D0.b bVar, List list, AbstractC2581u3 abstractC2581u3, int i2, kotlin.jvm.internal.f fVar) {
        this(aVar, bVar, (i2 & 4) != 0 ? r5.r.f13638a : list, (i2 & 8) != 0 ? null : abstractC2581u3);
    }
}
