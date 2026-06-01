package com.ironsource;

import com.ironsource.mediationsdk.IronSource;
import java.util.Map;
import java.util.UUID;

/* JADX INFO: renamed from: com.ironsource.n, reason: case insensitive filesystem */
/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes5.dex */
public final class C2458n extends J5 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final IronSource.a f9455a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final UUID f9456b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final String f9457c;

    public C2458n(IronSource.a adFormat, UUID adId, String adUnitId) {
        kotlin.jvm.internal.k.e(adFormat, "adFormat");
        kotlin.jvm.internal.k.e(adId, "adId");
        kotlin.jvm.internal.k.e(adUnitId, "adUnitId");
        this.f9455a = adFormat;
        this.f9456b = adId;
        this.f9457c = adUnitId;
    }

    @Override // com.ironsource.C0
    public Map<String, Object> a(A0 a02) {
        return a(new C2314f0(this.f9455a, this.f9456b, this.f9457c, null, null, null, 56, null));
    }
}
