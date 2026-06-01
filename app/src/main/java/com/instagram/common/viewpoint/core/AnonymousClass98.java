package com.instagram.common.viewpoint.core;

import android.net.Uri;
import android.os.Looper;
import com.facebook.ads.androidx.media3.common.Timeline;
import com.facebook.video.heroplayer.exocustom.MetaExoPlayerCustomization;

/* JADX INFO: renamed from: com.facebook.ads.redexgen.X.98, reason: invalid class name */
/* JADX INFO: loaded from: assets/audience_network.dex */
public final class AnonymousClass98 extends AbstractC2008mS implements InterfaceC0664Cg {
    public long A00;
    public C5H A01;
    public InterfaceC1830jM<InterfaceExecutorC0735Ez> A02;
    public boolean A03;
    public boolean A04;
    public boolean A05;
    public final int A06;
    public final C2Q A07;
    public final C2145oi A08;
    public final InterfaceC04884w A09;
    public final C9U A0A;
    public final InterfaceC0658Ca A0B;
    public final InterfaceC0713Ed A0C;

    /* JADX WARN: Generic types in debug info not equals: com.facebook.ads.redexgen.X.jM != com.google.common.base.Supplier<com.facebook.ads.androidx.media3.exoplayer.util.ReleasableExecutor> */
    @MetaExoPlayerCustomization("Allow for passing a new drmSessionManager")
    public AnonymousClass98(C2145oi c2145oi, InterfaceC04884w interfaceC04884w, InterfaceC0658Ca interfaceC0658Ca, C9U c9u, InterfaceC0713Ed interfaceC0713Ed, int i2, InterfaceC1830jM<InterfaceExecutorC0735Ez> interfaceC1830jM) {
        this.A07 = (C2Q) C3M.A01(c2145oi.A03);
        this.A08 = c2145oi;
        this.A09 = interfaceC04884w;
        this.A0B = interfaceC0658Ca;
        this.A0A = c9u == null ? C9U.A00 : c9u;
        this.A0C = interfaceC0713Ed;
        this.A06 = i2;
        this.A04 = true;
        this.A00 = -9223372036854775807L;
        this.A02 = interfaceC1830jM;
    }

    private void A00() {
        final Timeline anonymousClass97 = new AnonymousClass97(this.A00, this.A05, false, this.A03, null, this.A08);
        if (this.A04) {
            Timeline timeline = new C9C(anonymousClass97) { // from class: com.facebook.ads.redexgen.X.12
                @Override // com.instagram.common.viewpoint.core.C9C, com.facebook.ads.androidx.media3.common.Timeline
                public final C2125oN A0I(int i2, C2125oN c2125oN, boolean z2) {
                    super.A0I(i2, c2125oN, z2);
                    c2125oN.A05 = true;
                    return c2125oN;
                }

                @Override // com.instagram.common.viewpoint.core.C9C, com.facebook.ads.androidx.media3.common.Timeline
                public final C2123oL A0L(int i2, C2123oL c2123oL, long j) {
                    super.A0L(i2, c2123oL, j);
                    c2123oL.A0F = true;
                    return c2123oL;
                }
            };
            anonymousClass97 = timeline;
        }
        A05(anonymousClass97);
    }

    @Override // com.instagram.common.viewpoint.core.AbstractC2008mS
    public final void A09() {
    }

    @Override // com.instagram.common.viewpoint.core.AbstractC2008mS
    public final void A0A(C5H c5h) {
        this.A01 = c5h;
        this.A0A.AGK();
        this.A0A.AIu((Looper) C3M.A01(Looper.myLooper()), A00());
        A00();
    }

    @Override // com.instagram.common.viewpoint.core.CL
    @MetaExoPlayerCustomization("PlayerId needs to be set")
    public final InterfaceC2002mM A5O(C2001mL c2001mL, EO eo, long j) {
        InterfaceExecutorC0735Ez interfaceExecutorC0735Ez;
        InterfaceC2089nl interfaceC2089nlA5A = this.A09.A5A();
        if (this.A01 != null) {
            interfaceC2089nlA5A.A3v(this.A01);
        }
        Uri uri = this.A07.A00;
        InterfaceC0659Cb interfaceC0659CbA5P = this.A0B.A5P(C05567m.A03);
        C9U c9u = this.A0A;
        C9P c9pA01 = A01(c2001mL);
        InterfaceC0713Ed interfaceC0713Ed = this.A0C;
        CW cwA02 = A02(c2001mL);
        String str = this.A07.A04;
        int i2 = this.A06;
        if (this.A02 != null) {
            interfaceExecutorC0735Ez = this.A02.get();
        } else {
            interfaceExecutorC0735Ez = null;
        }
        return new C9A(uri, interfaceC2089nlA5A, interfaceC0659CbA5P, c9u, c9pA01, interfaceC0713Ed, cwA02, this, eo, str, i2, interfaceExecutorC0735Ez);
    }

    @Override // com.instagram.common.viewpoint.core.CL
    public final void ABu() {
    }

    @Override // com.instagram.common.viewpoint.core.InterfaceC0664Cg
    public final void AFH(long j, boolean z2, boolean z7) {
        if (j == -9223372036854775807L) {
            j = this.A00;
        }
        if (!this.A04 && this.A00 == j && this.A05 == z2 && this.A03 == z7) {
            return;
        }
        this.A00 = j;
        this.A05 = z2;
        this.A03 = z7;
        this.A04 = false;
        A00();
    }

    @Override // com.instagram.common.viewpoint.core.CL
    public final void AH0(InterfaceC2002mM interfaceC2002mM) {
        ((C9A) interfaceC2002mM).A0a();
    }
}
