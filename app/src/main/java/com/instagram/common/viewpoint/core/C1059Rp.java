package com.instagram.common.viewpoint.core;

/* JADX INFO: renamed from: com.facebook.ads.redexgen.X.Rp, reason: case insensitive filesystem */
/* JADX INFO: loaded from: assets/audience_network.dex */
public final class C1059Rp {
    public final long A00;
    public final EnumC1058Ro A01;
    public final String A02;
    public final boolean A03;

    public C1059Rp(String str, boolean z2, EnumC1058Ro enumC1058Ro) {
        this(str, z2, enumC1058Ro, System.currentTimeMillis());
    }

    public C1059Rp(String str, boolean z2, EnumC1058Ro enumC1058Ro, long j) {
        this.A02 = str;
        this.A03 = z2;
        this.A01 = enumC1058Ro;
        this.A00 = j;
    }

    public static C1059Rp A00() {
        return new C1059Rp("", true, EnumC1058Ro.A05, -1L);
    }

    public final long A01() {
        return this.A00;
    }

    public final EnumC1058Ro A02() {
        return this.A01;
    }

    public final String A03() {
        return this.A02;
    }

    public final boolean A04() {
        return this.A03;
    }
}
