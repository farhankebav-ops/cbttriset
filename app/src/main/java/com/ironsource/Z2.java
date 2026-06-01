package com.ironsource;

import com.ironsource.mediationsdk.ISBannerSize;
import java.util.LinkedHashMap;
import java.util.Map;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes5.dex */
public final class Z2 extends C2540rd {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final C2459n0 f7886b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final ISBannerSize f7887c;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public Z2(C2459n0 adTools, ISBannerSize size, String placement) {
        super(placement);
        kotlin.jvm.internal.k.e(adTools, "adTools");
        kotlin.jvm.internal.k.e(size, "size");
        kotlin.jvm.internal.k.e(placement, "placement");
        this.f7886b = adTools;
        this.f7887c = size;
    }

    @Override // com.ironsource.C2540rd, com.ironsource.C0
    public Map<String, Object> a(A0 a02) {
        LinkedHashMap linkedHashMapO0 = r5.x.o0(super.a(a02));
        this.f7886b.a(linkedHashMapO0, this.f7887c);
        return linkedHashMapO0;
    }
}
