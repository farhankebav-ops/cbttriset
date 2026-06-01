package com.ironsource;

/* JADX INFO: renamed from: com.ironsource.ld, reason: case insensitive filesystem */
/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes5.dex */
public final class C2434ld extends AbstractC2615w3 {
    private String e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private int f8920f;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public C2434ld(int i2, String placementName, boolean z2, String rewardName, int i8, C2452md c2452md) {
        super(i2, placementName, z2, c2452md);
        kotlin.jvm.internal.k.e(placementName, "placementName");
        kotlin.jvm.internal.k.e(rewardName, "rewardName");
        this.f8920f = i8;
        this.e = rewardName;
    }

    public final int e() {
        return this.f8920f;
    }

    public final String f() {
        return this.e;
    }

    @Override // com.ironsource.AbstractC2615w3
    public String toString() {
        return super.toString() + ", reward name: " + this.e + " , amount: " + this.f8920f;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public C2434ld(AbstractC2615w3 placement) {
        super(placement.b(), placement.c(), placement.d(), placement.a());
        kotlin.jvm.internal.k.e(placement, "placement");
        this.e = "";
    }
}
