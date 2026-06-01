package com.instagram.common.viewpoint.core;

import androidx.core.location.LocationRequestCompat;
import com.facebook.video.heroplayer.exocustom.MetaExoPlayerCustomization;
import java.io.IOException;

/* JADX INFO: renamed from: com.facebook.ads.redexgen.X.9Z, reason: invalid class name */
/* JADX INFO: loaded from: assets/audience_network.dex */
public abstract class C9Z implements InterfaceC2064nM, C7D {
    public int A00;
    public int A01;
    public long A02;
    public long A04;
    public C7G A05;
    public C05567m A06;
    public InterfaceC0675Cr A07;
    public boolean A08;
    public boolean A09;
    public C2154or[] A0A;
    public final int A0C;

    @MetaExoPlayerCustomization(type = {"NEW_CLASS_ARG"}, value = "D18870411: Adding start stall debug reason")
    public EnumC1730hX A0B = EnumC1730hX.A09;
    public final C6N A0D = new C6N();
    public long A03 = Long.MIN_VALUE;

    public abstract void A1Z();

    public abstract void A1a(long j, boolean z2) throws C9Y;

    public abstract void A1c(C2154or[] c2154orArr, long j, long j3) throws C9Y;

    public C9Z(int i2) {
        this.A0C = i2;
    }

    private final int A1O() {
        return this.A00;
    }

    private void A1P(long j, boolean z2) throws C9Y {
        this.A08 = false;
        this.A02 = j;
        this.A03 = j;
        A1a(j, z2);
    }

    public final int A1Q(long j) {
        return ((InterfaceC0675Cr) C3M.A01(this.A07)).AJI(j - this.A04);
    }

    @MetaExoPlayerCustomization(type = {"FEATURE_LOGIC"}, value = "Keep track of the non-adjusted timestamp")
    public final int A1R(C6N c6n, C2076nY c2076nY, int i2) {
        int iAGf = ((InterfaceC0675Cr) C3M.A01(this.A07)).AGf(c6n, c2076nY, i2);
        if (iAGf == -4) {
            if (c2076nY.A05()) {
                this.A03 = Long.MIN_VALUE;
                return this.A08 ? -4 : -3;
            }
            c2076nY.A00 = c2076nY.A01;
            c2076nY.A01 += this.A04;
            this.A03 = Math.max(this.A03, c2076nY.A01);
        } else if (iAGf == -5) {
            C2154or c2154or = (C2154or) C3M.A01(c6n.A00);
            if (c2154or.A0M != LocationRequestCompat.PASSIVE_INTERVAL) {
                c6n.A00 = c2154or.A07().A0s(c2154or.A0M + this.A04).A14();
            }
        }
        return iAGf;
    }

    public final C9Y A1S(Throwable th, C2154or c2154or, int i2) {
        return A1T(th, c2154or, false, i2);
    }

    public final C9Y A1T(Throwable th, C2154or c2154or, boolean z2, int i2) {
        int iA03 = 4;
        if (c2154or != null && !this.A09) {
            this.A09 = true;
            try {
                int formatSupport = AJb(c2154or);
                iA03 = AnonymousClass76.A03(formatSupport);
            } catch (C9Y unused) {
            } catch (Throwable th2) {
                this.A09 = false;
                throw th2;
            }
            this.A09 = false;
        }
        return C9Y.A04(th, getName(), A1O(), c2154or, iA03, z2, i2);
    }

    public final C6N A1U() {
        this.A0D.A00();
        return this.A0D;
    }

    public final C7G A1V() {
        return (C7G) C3M.A01(this.A05);
    }

    public final C05567m A1W() {
        return (C05567m) C3M.A01(this.A06);
    }

    public void A1X() throws C9Y {
    }

    public void A1Y() {
    }

    public void A1b(boolean z2, boolean z7) throws C9Y {
    }

    public final boolean A1d() {
        return A9h() ? this.A08 : ((InterfaceC0675Cr) C3M.A01(this.A07)).AAV();
    }

    public final C2154or[] A1e() {
        return (C2154or[]) C3M.A01(this.A0A);
    }

    @Override // com.instagram.common.viewpoint.core.InterfaceC2064nM
    public final void A5p() {
        C3M.A08(this.A01 == 1);
        this.A0D.A00();
        this.A01 = 0;
        this.A07 = null;
        this.A0A = null;
        this.A08 = false;
        A1Z();
    }

    @Override // com.instagram.common.viewpoint.core.InterfaceC2064nM
    public final void A6D(C7G c7g, C2154or[] c2154orArr, InterfaceC0675Cr interfaceC0675Cr, long j, boolean z2, boolean z7, long j3, long j8) throws C9Y {
        C3M.A08(this.A01 == 0);
        this.A05 = c7g;
        this.A01 = 1;
        A1b(z2, z7);
        AHq(c2154orArr, interfaceC0675Cr, j3, j8);
        A1P(j, z2);
    }

    @Override // com.instagram.common.viewpoint.core.InterfaceC2064nM
    public final C7D A75() {
        return this;
    }

    @Override // com.instagram.common.viewpoint.core.InterfaceC2064nM
    public C6W A8L() {
        return null;
    }

    @Override // com.instagram.common.viewpoint.core.InterfaceC2064nM
    @MetaExoPlayerCustomization(type = {"NEW_METHOD"}, value = "D18870411: Adding start stall debug reason")
    public final EnumC1730hX A91() {
        return this.A0B;
    }

    @Override // com.instagram.common.viewpoint.core.InterfaceC2064nM
    public final int A92() {
        return this.A01;
    }

    @Override // com.instagram.common.viewpoint.core.InterfaceC2064nM
    public final InterfaceC0675Cr A95() {
        return this.A07;
    }

    @Override // com.instagram.common.viewpoint.core.InterfaceC2064nM, com.instagram.common.viewpoint.core.C7D
    public final int A9F() {
        return this.A0C;
    }

    @Override // com.instagram.common.viewpoint.core.AnonymousClass70
    public void A9a(int i2, Object obj) throws C9Y {
    }

    @Override // com.instagram.common.viewpoint.core.InterfaceC2064nM
    public final boolean A9h() {
        return this.A03 == Long.MIN_VALUE;
    }

    @Override // com.instagram.common.viewpoint.core.InterfaceC2064nM
    public final void AA1(int i2, C05567m c05567m) {
        this.A00 = i2;
        this.A06 = c05567m;
    }

    @Override // com.instagram.common.viewpoint.core.InterfaceC2064nM
    public final boolean AAE() {
        return this.A08;
    }

    @Override // com.instagram.common.viewpoint.core.InterfaceC2064nM
    public final void ABv() throws IOException {
        ((InterfaceC0675Cr) C3M.A01(this.A07)).ABs();
    }

    @Override // com.instagram.common.viewpoint.core.InterfaceC2064nM
    public final void AHq(C2154or[] c2154orArr, InterfaceC0675Cr interfaceC0675Cr, long j, long j3) throws C9Y {
        C3M.A08(!this.A08);
        this.A07 = interfaceC0675Cr;
        if (this.A03 == Long.MIN_VALUE) {
            this.A03 = j;
        }
        this.A0A = c2154orArr;
        this.A04 = j3;
        A1c(c2154orArr, j, j3);
    }

    @Override // com.instagram.common.viewpoint.core.InterfaceC2064nM
    public final void AI2(long j) throws C9Y {
        A1P(j, false);
    }

    @Override // com.instagram.common.viewpoint.core.InterfaceC2064nM
    public final void AId() {
        this.A08 = true;
    }

    public int AJd() throws C9Y {
        return 0;
    }

    @Override // com.instagram.common.viewpoint.core.InterfaceC2064nM
    public final void start() throws C9Y {
        C3M.A08(this.A01 == 1);
        this.A01 = 2;
        A1X();
    }

    @Override // com.instagram.common.viewpoint.core.InterfaceC2064nM
    public final void stop() {
        C3M.A08(this.A01 == 2);
        this.A01 = 1;
        A1Y();
    }
}
