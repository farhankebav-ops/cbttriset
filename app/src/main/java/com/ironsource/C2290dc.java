package com.ironsource;

import com.ironsource.mediationsdk.IronSource;
import java.util.UUID;

/* JADX INFO: renamed from: com.ironsource.dc, reason: case insensitive filesystem */
/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes5.dex */
public final class C2290dc extends C2314f0 {
    public /* synthetic */ C2290dc(UUID uuid, String str, C2434ld c2434ld, int i2, kotlin.jvm.internal.f fVar) {
        this(uuid, str, (i2 & 4) != 0 ? null : c2434ld);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public C2290dc(UUID adId, String adUnitId, C2434ld c2434ld) {
        super(IronSource.a.NATIVE_AD, adId, adUnitId, c2434ld, null, null, 48, null);
        kotlin.jvm.internal.k.e(adId, "adId");
        kotlin.jvm.internal.k.e(adUnitId, "adUnitId");
    }

    public C2290dc() {
        this(C2670z7.f10631a.a(), "", null, 4, null);
    }
}
