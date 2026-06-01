package com.ironsource;

import com.unity3d.mediation.LevelPlayAdInfo;

/* JADX INFO: renamed from: com.ironsource.s0, reason: case insensitive filesystem */
/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes5.dex */
public final class C2544s0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final AbstractC2477o0 f9788a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final LevelPlayAdInfo f9789b;

    public C2544s0(AbstractC2477o0 adUnit, LevelPlayAdInfo levelPlayAdInfo) {
        kotlin.jvm.internal.k.e(adUnit, "adUnit");
        this.f9788a = adUnit;
        this.f9789b = levelPlayAdInfo;
    }

    public final AbstractC2477o0 a() {
        return this.f9788a;
    }

    public final LevelPlayAdInfo b() {
        return this.f9789b;
    }

    public final LevelPlayAdInfo c() {
        return this.f9789b;
    }

    public final AbstractC2477o0 d() {
        return this.f9788a;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof C2544s0)) {
            return false;
        }
        C2544s0 c2544s0 = (C2544s0) obj;
        return kotlin.jvm.internal.k.a(this.f9788a, c2544s0.f9788a) && kotlin.jvm.internal.k.a(this.f9789b, c2544s0.f9789b);
    }

    public int hashCode() {
        int iHashCode = this.f9788a.hashCode() * 31;
        LevelPlayAdInfo levelPlayAdInfo = this.f9789b;
        return iHashCode + (levelPlayAdInfo == null ? 0 : levelPlayAdInfo.hashCode());
    }

    public String toString() {
        return "AdUnitCallback(adUnit=" + this.f9788a + ", adInfo=" + this.f9789b + ")";
    }

    public /* synthetic */ C2544s0(AbstractC2477o0 abstractC2477o0, LevelPlayAdInfo levelPlayAdInfo, int i2, kotlin.jvm.internal.f fVar) {
        this(abstractC2477o0, (i2 & 2) != 0 ? null : levelPlayAdInfo);
    }

    public final C2544s0 a(AbstractC2477o0 adUnit, LevelPlayAdInfo levelPlayAdInfo) {
        kotlin.jvm.internal.k.e(adUnit, "adUnit");
        return new C2544s0(adUnit, levelPlayAdInfo);
    }

    public static /* synthetic */ C2544s0 a(C2544s0 c2544s0, AbstractC2477o0 abstractC2477o0, LevelPlayAdInfo levelPlayAdInfo, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            abstractC2477o0 = c2544s0.f9788a;
        }
        if ((i2 & 2) != 0) {
            levelPlayAdInfo = c2544s0.f9789b;
        }
        return c2544s0.a(abstractC2477o0, levelPlayAdInfo);
    }
}
