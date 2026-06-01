package com.instagram.common.viewpoint.core;

import com.facebook.video.heroplayer.exocustom.MetaExoPlayerCustomization;

/* JADX INFO: renamed from: com.facebook.ads.redexgen.X.nG, reason: case insensitive filesystem */
/* JADX INFO: loaded from: assets/audience_network.dex */
@MetaExoPlayerCustomization("Should be final")
public class C2058nG implements C6W {
    public static String[] A05 = {"hSbyIXWx35EcWpJ5mgpqJrodnP2zgUAj", "AVKvZ0FxnTaSPhab1fIF2iZ72kGLJbya", "jBX7iJXGD8JRWgbUYtK1siSQEeTEZwCL", "i2fIBHFmzda6l4Lh5IwFm1sKJFPGPiRM", "MPSpeSFedASltWD94wRgDX9C2oesADq", "pjPp4ZdncQK9eqjJ4SlffLD", "oopCB6d3Vy5GhBPVddSO0qnC65I08xM", "WPZc57Li25BnEd3F6sy7axVnNov0V"};
    public long A00;
    public long A01;
    public C2138ob A02 = C2138ob.A06;
    public boolean A03;
    public final C3T A04;

    public C2058nG(C3T c3t) {
        this.A04 = c3t;
    }

    public void A00() {
        if (!this.A03) {
            this.A00 = this.A04.A6B();
            this.A03 = true;
        }
    }

    public void A01() {
        if (this.A03) {
            A02(A8h());
            this.A03 = false;
        }
    }

    public void A02(long j) {
        this.A01 = j;
        if (this.A03) {
            this.A00 = this.A04.A6B();
        }
    }

    @Override // com.instagram.common.viewpoint.core.C6W
    public C2138ob A8e() {
        return this.A02;
    }

    @Override // com.instagram.common.viewpoint.core.C6W
    public long A8h() {
        long elapsedSinceBaseMs = this.A01;
        if (this.A03) {
            long jA6B = this.A04.A6B();
            long positionUs = this.A00;
            long j = jA6B - positionUs;
            if (this.A02.A01 == 1.0f) {
                long positionUs2 = AbstractC04664a.A0O(j);
                return elapsedSinceBaseMs + positionUs2;
            }
            long positionUs3 = this.A02.A03(j);
            return elapsedSinceBaseMs + positionUs3;
        }
        return elapsedSinceBaseMs;
    }

    @Override // com.instagram.common.viewpoint.core.C6W
    public void AIt(C2138ob c2138ob) {
        if (this.A03) {
            long jA8h = A8h();
            String[] strArr = A05;
            if (strArr[3].charAt(3) == strArr[2].charAt(3)) {
                throw new RuntimeException();
            }
            A05[7] = "MyAjQeitkUrtgk2AHovxe6SLNdU2U";
            A02(jA8h);
        }
        this.A02 = c2138ob;
    }
}
