package com.instagram.common.viewpoint.core;

import androidx.core.location.LocationRequestCompat;
import com.facebook.video.heroplayer.exocustom.MetaExoPlayerCustomization;
import java.io.IOException;

/* JADX INFO: renamed from: com.facebook.ads.redexgen.X.9F, reason: invalid class name */
/* JADX INFO: loaded from: assets/audience_network.dex */
public final class C9F implements InterfaceC2002mM, InterfaceC2003mN {
    public static String[] A06 = {"JXRw8dEnvO1Lr4g7cFUS0dvQrSj2gCrD", "hvHNuBxl", "xmWilmV3z2eIIj1", "UUtHfwhImwRJiupXWlBcpFq10hKf2hZ3", "Gjwbiw3zcCnfnivX0C6Z4KLegMayRhyW", "PFLAFIzQgEofbdrT2htWxpP7W2gVOOgi", "405rypbMY6P", "HWuA8Rz9jBHRgd5bymvhijPSyV36G6mN"};
    public long A00;
    public long A01;
    public long A02;
    public InterfaceC2003mN A03;
    public C2006mQ[] A04 = new C2006mQ[0];
    public final InterfaceC2002mM A05;

    public C9F(InterfaceC2002mM interfaceC2002mM, boolean z2, long j, long j3) {
        this.A05 = interfaceC2002mM;
        this.A02 = z2 ? j : -9223372036854775807L;
        this.A01 = j;
        this.A00 = j3;
    }

    private C7I A00(long j, C7I c7i) {
        long toleranceBeforeUs = AbstractC04664a.A0T(c7i.A01, 0L, j - this.A01);
        long jA0T = AbstractC04664a.A0T(c7i.A00, 0L, this.A00 == Long.MIN_VALUE ? LocationRequestCompat.PASSIVE_INTERVAL : this.A00 - j);
        if (toleranceBeforeUs == c7i.A01) {
            long j3 = c7i.A00;
            if (A06[6].length() != 11) {
                throw new RuntimeException();
            }
            A06[0] = "SySHx2FlEzism2SEaRZKk1Ki9OIwKCgL";
            if (jA0T == j3) {
                return c7i;
            }
        }
        return new C7I(toleranceBeforeUs, jA0T);
    }

    /* JADX INFO: Access modifiers changed from: private */
    @Override // com.instagram.common.viewpoint.core.InterfaceC0678Cu
    /* JADX INFO: renamed from: A01, reason: merged with bridge method [inline-methods] */
    public final void ACs(InterfaceC2002mM interfaceC2002mM) {
        ((InterfaceC2003mN) C3M.A01(this.A03)).ACs(this);
    }

    public static boolean A02(long j, InterfaceC1964lj[] interfaceC1964ljArr) {
        if (j != 0) {
            for (InterfaceC1964lj interfaceC1964lj : interfaceC1964ljArr) {
                if (interfaceC1964lj != null) {
                    C2154or c2154orA8u = interfaceC1964lj.A8u();
                    if (!AbstractC04212h.A0G(c2154orA8u.A0W, c2154orA8u.A0R)) {
                        return true;
                    }
                }
            }
        }
        return false;
    }

    public final boolean A03() {
        return this.A02 != -9223372036854775807L;
    }

    @Override // com.instagram.common.viewpoint.core.InterfaceC0679Cv
    @MetaExoPlayerCustomization("Added in D19760981 for cancel request")
    public final void A4k(long j) {
        this.A05.A4k(j);
    }

    @Override // com.instagram.common.viewpoint.core.InterfaceC2002mM
    public final boolean A54(long j) {
        return this.A05.A54(j);
    }

    @Override // com.instagram.common.viewpoint.core.InterfaceC2002mM
    public final void A5s(long j, boolean z2) {
        this.A05.A5s(j, z2);
    }

    @Override // com.instagram.common.viewpoint.core.InterfaceC2002mM
    public final long A6j(long j, C7I c7i) {
        if (j == this.A01) {
            return this.A01;
        }
        return this.A05.A6j(j, A00(j, c7i));
    }

    @Override // com.instagram.common.viewpoint.core.InterfaceC0679Cv
    @MetaExoPlayerCustomization("Added in D9949576 for unstall buffer")
    public final long A6y(long j) {
        return this.A05.A6y(j);
    }

    @Override // com.instagram.common.viewpoint.core.InterfaceC2002mM
    public final long A70() {
        long jA70 = this.A05.A70();
        if (jA70 == Long.MIN_VALUE || (this.A00 != Long.MIN_VALUE && jA70 >= this.A00)) {
            return Long.MIN_VALUE;
        }
        return jA70;
    }

    @Override // com.instagram.common.viewpoint.core.InterfaceC2002mM
    public final long A8T() {
        long jA8T = this.A05.A8T();
        if (jA8T != Long.MIN_VALUE) {
            long nextLoadPositionUs = this.A00;
            if (A06[0].charAt(29) != 'C') {
                throw new RuntimeException();
            }
            A06[0] = "QBPPyRyowan8CCGBQiXIHMf03VOUOCSC";
            if (nextLoadPositionUs == Long.MIN_VALUE || jA8T < this.A00) {
                return jA8T;
            }
        }
        return Long.MIN_VALUE;
    }

    @Override // com.instagram.common.viewpoint.core.InterfaceC2002mM
    public final C1991mA A9E() {
        return this.A05.A9E();
    }

    @Override // com.instagram.common.viewpoint.core.InterfaceC2002mM
    public final void ABt() throws IOException {
        if (0 == 0) {
            this.A05.ABt();
            return;
        }
        throw null;
    }

    @Override // com.instagram.common.viewpoint.core.InterfaceC2003mN
    public final void AEk(InterfaceC2002mM interfaceC2002mM) {
        if (0 != 0) {
            return;
        }
        ((InterfaceC2003mN) C3M.A01(this.A03)).AEk(this);
    }

    @Override // com.instagram.common.viewpoint.core.InterfaceC2002mM
    public final void AGL(InterfaceC2003mN interfaceC2003mN, long j) {
        this.A03 = interfaceC2003mN;
        this.A05.AGL(this, j);
    }

    @Override // com.instagram.common.viewpoint.core.InterfaceC2002mM
    public final long AGg() {
        if (A03()) {
            long childDiscontinuityUs = this.A02;
            this.A02 = -9223372036854775807L;
            long jAGg = AGg();
            return jAGg != -9223372036854775807L ? jAGg : childDiscontinuityUs;
        }
        InterfaceC2002mM interfaceC2002mM = this.A05;
        if (A06[2].length() == 0) {
            throw new RuntimeException();
        }
        A06[6] = "ABWUoGiNBoa";
        long jAGg2 = interfaceC2002mM.AGg();
        if (jAGg2 == -9223372036854775807L) {
            return -9223372036854775807L;
        }
        long discontinuityUs = this.A01;
        boolean z2 = true;
        C3M.A08(jAGg2 >= discontinuityUs);
        if (this.A00 != Long.MIN_VALUE) {
            long discontinuityUs2 = this.A00;
            if (jAGg2 > discontinuityUs2) {
                z2 = false;
            }
        }
        C3M.A08(z2);
        return jAGg2;
    }

    @Override // com.instagram.common.viewpoint.core.InterfaceC2002mM
    public final void AGm(long j) {
        this.A05.AGm(j);
    }

    @Override // com.instagram.common.viewpoint.core.InterfaceC2002mM
    public final long AIO(@MetaExoPlayerCustomization long j, boolean z2) {
        this.A02 = -9223372036854775807L;
        boolean z7 = false;
        for (C2006mQ c2006mQ : this.A04) {
            if (c2006mQ != null) {
                c2006mQ.A00();
            }
        }
        long jAIO = this.A05.AIO(j, z2);
        if (jAIO == j || (jAIO >= this.A01 && (this.A00 == Long.MIN_VALUE || jAIO <= this.A00))) {
            z7 = true;
        }
        C3M.A08(z7);
        return jAIO;
    }

    /* JADX WARN: Removed duplicated region for block: B:17:0x005f  */
    /* JADX WARN: Removed duplicated region for block: B:29:0x0092  */
    /* JADX WARN: Removed duplicated region for block: B:33:0x00a5  */
    /* JADX WARN: Removed duplicated region for block: B:37:0x00b7  */
    /* JADX WARN: Removed duplicated region for block: B:40:0x00cd  */
    /* JADX WARN: Removed duplicated region for block: B:46:0x00f6  */
    /* JADX WARN: Removed duplicated region for block: B:51:0x0117  */
    @Override // com.instagram.common.viewpoint.core.InterfaceC2002mM
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final long AIP(com.instagram.common.viewpoint.core.InterfaceC1964lj[] r18, boolean[] r19, com.instagram.common.viewpoint.core.InterfaceC0675Cr[] r20, boolean[] r21, long r22) {
        /*
            Method dump skipped, instruction units count: 286
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.instagram.common.viewpoint.core.C9F.AIP(com.facebook.ads.redexgen.X.lj[], boolean[], com.facebook.ads.redexgen.X.Cr[], boolean[], long):long");
    }

    @Override // com.instagram.common.viewpoint.core.InterfaceC0679Cv
    @MetaExoPlayerCustomization("Added in D19875605 for error load during pause")
    public final void AIs(boolean z2) {
        this.A05.AIs(z2);
    }

    @Override // com.instagram.common.viewpoint.core.InterfaceC0679Cv
    @MetaExoPlayerCustomization("Added in D13267633 for lower priority during pause")
    public final void AJq(byte b8) {
        this.A05.AJq(b8);
    }
}
