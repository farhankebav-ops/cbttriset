package com.ironsource;

import com.ironsource.mediationsdk.IronSource;
import com.unity3d.mediation.LevelPlayAdSize;
import java.util.UUID;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes5.dex */
public final class K2 extends C2314f0 {
    private final LevelPlayAdSize g;
    private final Boolean h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private final Long f7041i;

    public /* synthetic */ K2(UUID uuid, String str, C2434ld c2434ld, LevelPlayAdSize levelPlayAdSize, Boolean bool, Long l, Hf hf, Double d8, int i2, kotlin.jvm.internal.f fVar) {
        this(uuid, str, (i2 & 4) != 0 ? null : c2434ld, (i2 & 8) != 0 ? LevelPlayAdSize.BANNER : levelPlayAdSize, (i2 & 16) != 0 ? null : bool, (i2 & 32) != 0 ? null : l, (i2 & 64) != 0 ? null : hf, (i2 & 128) != 0 ? null : d8);
    }

    public final LevelPlayAdSize h() {
        return this.g;
    }

    public final Boolean i() {
        return this.h;
    }

    public final Long j() {
        return this.f7041i;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public K2(UUID adId, String adUnitId, C2434ld c2434ld, LevelPlayAdSize adSize, Boolean bool, Long l, Hf hf, Double d8) {
        super(IronSource.a.BANNER, adId, adUnitId, c2434ld, hf, d8);
        kotlin.jvm.internal.k.e(adId, "adId");
        kotlin.jvm.internal.k.e(adUnitId, "adUnitId");
        kotlin.jvm.internal.k.e(adSize, "adSize");
        this.g = adSize;
        this.h = bool;
        this.f7041i = l;
    }

    public K2() {
        this(C2670z7.f10631a.a(), "", null, null, null, null, null, null, 252, null);
    }
}
