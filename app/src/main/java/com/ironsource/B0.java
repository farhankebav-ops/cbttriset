package com.ironsource;

import com.ironsource.mediationsdk.utils.IronSourceConstants;
import java.util.Map;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes5.dex */
public final class B0 extends J5 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final C2459n0 f6352a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final C2314f0 f6353b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final String f6354c;

    public /* synthetic */ B0(C2459n0 c2459n0, C2314f0 c2314f0, String str, int i2, kotlin.jvm.internal.f fVar) {
        this(c2459n0, c2314f0, (i2 & 4) != 0 ? null : str);
    }

    @Override // com.ironsource.C0
    public Map<String, Object> a(A0 a02) {
        Map<String, Object> mapA = a(this.f6353b);
        mapA.put(IronSourceConstants.EVENTS_PROVIDER, "Mediation");
        mapA.put("sessionDepth", Integer.valueOf(this.f6352a.f()));
        String str = this.f6354c;
        if (str != null) {
            mapA.put(IronSourceConstants.EVENTS_MEDIATION_LOAD_STRATEGY, str);
        }
        return mapA;
    }

    public B0(C2459n0 adTools, C2314f0 adProperties, String str) {
        kotlin.jvm.internal.k.e(adTools, "adTools");
        kotlin.jvm.internal.k.e(adProperties, "adProperties");
        this.f6352a = adTools;
        this.f6353b = adProperties;
        this.f6354c = str;
    }
}
