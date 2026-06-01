package com.instagram.common.viewpoint.core;

/* JADX INFO: renamed from: com.facebook.ads.redexgen.X.lS, reason: case insensitive filesystem */
/* JADX INFO: loaded from: assets/audience_network.dex */
public class C1947lS implements InterfaceC0784Gw {
    public final int A00;
    public final int A01;
    public final long A02;
    public final long A03;
    public final long A04;
    public final long A05;
    public final boolean A06;

    public C1947lS(long j, long j3, int i2, int i8, boolean z2) {
        this.A05 = j;
        this.A04 = j3;
        this.A01 = i8 == -1 ? 1 : i8;
        this.A00 = i2;
        this.A06 = z2;
        if (j == -1) {
            this.A02 = -1L;
            this.A03 = -9223372036854775807L;
        } else {
            this.A02 = j - j3;
            this.A03 = A01(j, j3, i2);
        }
    }

    private long A00(long j) {
        long j3 = (((long) this.A00) * j) / 8000000;
        long positionOffset = this.A01;
        long j8 = j3 / positionOffset;
        long positionOffset2 = this.A01;
        long positionOffset3 = j8 * positionOffset2;
        if (this.A02 != -1) {
            positionOffset3 = Math.min(positionOffset3, this.A02 - ((long) this.A01));
        }
        long positionOffset4 = Math.max(positionOffset3, 0L);
        long positionOffset5 = this.A04;
        return positionOffset5 + positionOffset4;
    }

    public static long A01(long j, long j3, int i2) {
        return ((Math.max(0L, j - j3) * 8) * 1000000) / ((long) i2);
    }

    public final long A02(long j) {
        return A01(j, this.A04, this.A00);
    }

    @Override // com.instagram.common.viewpoint.core.InterfaceC0784Gw
    public final long A7l() {
        return this.A03;
    }

    @Override // com.instagram.common.viewpoint.core.InterfaceC0784Gw
    public final C0783Gv A8t(long j) {
        if (this.A02 == -1 && !this.A06) {
            return new C0783Gv(new C0785Gx(0L, this.A04));
        }
        long jA00 = A00(j);
        long jA02 = A02(jA00);
        C0785Gx seekPoint = new C0785Gx(jA02, jA00);
        if (this.A02 == -1 || jA02 >= j || ((long) this.A01) + jA00 >= this.A05) {
            return new C0783Gv(seekPoint);
        }
        long seekTimeUs = ((long) this.A01) + jA00;
        long secondSeekPosition = A02(seekTimeUs);
        return new C0783Gv(seekPoint, new C0785Gx(secondSeekPosition, seekTimeUs));
    }

    @Override // com.instagram.common.viewpoint.core.InterfaceC0784Gw
    public final boolean AAa() {
        return this.A02 != -1 || this.A06;
    }
}
