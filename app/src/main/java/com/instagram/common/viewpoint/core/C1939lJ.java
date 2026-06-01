package com.instagram.common.viewpoint.core;

/* JADX INFO: renamed from: com.facebook.ads.redexgen.X.lJ, reason: case insensitive filesystem */
/* JADX INFO: loaded from: assets/audience_network.dex */
public final class C1939lJ implements InterfaceC0784Gw {
    public final long A00;
    public final boolean A01;
    public final long[] A02;
    public final long[] A03;

    public C1939lJ(long[] jArr, long[] jArr2, long j) {
        C3M.A07(jArr.length == jArr2.length);
        int length = jArr2.length;
        this.A01 = length > 0;
        if (this.A01 && jArr2[0] > 0) {
            int length2 = length + 1;
            this.A02 = new long[length2];
            int length3 = length + 1;
            this.A03 = new long[length3];
            System.arraycopy(jArr, 0, this.A02, 1, length);
            System.arraycopy(jArr2, 0, this.A03, 1, length);
        } else {
            this.A02 = jArr;
            this.A03 = jArr2;
        }
        this.A00 = j;
    }

    @Override // com.instagram.common.viewpoint.core.InterfaceC0784Gw
    public final long A7l() {
        return this.A00;
    }

    @Override // com.instagram.common.viewpoint.core.InterfaceC0784Gw
    public final C0783Gv A8t(long j) {
        if (!this.A01) {
            return new C0783Gv(C0785Gx.A04);
        }
        int iA0L = AbstractC04664a.A0L(this.A03, j, true, true);
        C0785Gx c0785Gx = new C0785Gx(this.A03[iA0L], this.A02[iA0L]);
        if (c0785Gx.A01 != j) {
            int targetIndex = this.A03.length;
            if (iA0L != targetIndex - 1) {
                int targetIndex2 = iA0L + 1;
                long j3 = this.A03[targetIndex2];
                int targetIndex3 = iA0L + 1;
                C0785Gx rightSeekPoint = new C0785Gx(j3, this.A02[targetIndex3]);
                return new C0783Gv(c0785Gx, rightSeekPoint);
            }
        }
        return new C0783Gv(c0785Gx);
    }

    @Override // com.instagram.common.viewpoint.core.InterfaceC0784Gw
    public final boolean AAa() {
        return this.A01;
    }
}
