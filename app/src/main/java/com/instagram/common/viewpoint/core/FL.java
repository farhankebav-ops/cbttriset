package com.instagram.common.viewpoint.core;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.RelativeLayout;
import java.util.Arrays;
import java.util.HashMap;

/* JADX INFO: loaded from: assets/audience_network.dex */
public final class FL extends FrameLayout implements InterfaceC1209Xo {
    public static byte[] A0B;
    public static final RelativeLayout.LayoutParams A0C;
    public R0 A00;
    public Intent A01;
    public Bundle A02;
    public InterfaceC1209Xo A03;
    public final AbstractC1752hy A04;
    public final AbstractC1752hy A05;
    public final R0 A06;
    public final C1477dL A07;
    public final US A08;
    public final XC A09;
    public final InterfaceC1208Xn A0A;

    public static String A08(int i2, int i8, int i9) {
        byte[] bArrCopyOfRange = Arrays.copyOfRange(A0B, i2, i2 + i8);
        for (int i10 = 0; i10 < bArrCopyOfRange.length; i10++) {
            bArrCopyOfRange[i10] = (byte) ((bArrCopyOfRange[i10] ^ i9) ^ 32);
        }
        return new String(bArrCopyOfRange);
    }

    public static void A0A() {
        A0B = new byte[]{117, 105, 100, 102, 96, 104, 96, 107, 113};
    }

    static {
        A0A();
        A0C = new RelativeLayout.LayoutParams(-1, -1);
    }

    public FL(C1477dL c1477dL, US us, AbstractC1752hy abstractC1752hy, AbstractC1752hy abstractC1752hy2, InterfaceC1208Xn interfaceC1208Xn, R0 r02) {
        super(c1477dL);
        this.A07 = c1477dL;
        this.A08 = us;
        this.A05 = abstractC1752hy;
        this.A04 = abstractC1752hy2;
        this.A0A = interfaceC1208Xn;
        this.A06 = r02;
        this.A09 = new XC(this);
        this.A09.A05(XB.A02);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public C0893Lc A05(C1456cz c1456cz, YY yy) {
        return new C0893Lc(this.A07, this.A08, this.A0A, this.A04, this.A04.A1A(), yy, true, c1456cz);
    }

    private C04573r A06() {
        if (this.A04.A20().A0H().A07() != null) {
            this.A05.A1M(this.A04.A20().A0H().A07().A0N());
            this.A05.A1N(this.A04.A20().A0H().A07().A0P());
        }
        LX lx = new LX();
        C1456cz c1456czA07 = A07(lx, this.A04);
        C04573r c04573r = new C04573r(this.A07, lx, this.A08, this.A05, new SF(this.A07), this.A0A);
        c04573r.setVideoLeadingPlayableAdListener(new FM(this, c1456czA07, lx));
        return c04573r;
    }

    private C1456cz A07(YY yy, AbstractC1752hy abstractC1752hy) {
        NB nbA07 = abstractC1752hy.A20().A0H().A07();
        if (nbA07 == null || !nbA07.A0M()) {
            return null;
        }
        HashMap map = new HashMap();
        map.put(A08(0, 9, 37), yy.A8d());
        return new C1456cz(this.A07, abstractC1752hy, nbA07, this.A08, null, map);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void A09() {
        if (this.A03 != null) {
            this.A03.onDestroy();
            if (this.A03 instanceof View) {
                ((View) this.A03).setVisibility(8);
                removeView((View) this.A03);
            }
        }
    }

    private final void A0B(Intent intent, Bundle bundle, R0 r02) {
        this.A03 = A06();
        this.A03.AAl(intent, bundle, r02);
    }

    @Override // com.instagram.common.viewpoint.core.InterfaceC1209Xo
    public final void AAl(Intent intent, Bundle bundle, R0 r02) {
        this.A01 = intent;
        this.A02 = bundle;
        this.A00 = r02;
        this.A0A.A3x(this, A0C);
        A0B(intent, bundle, r02);
    }

    @Override // com.instagram.common.viewpoint.core.InterfaceC1209Xo
    public final void AEV(boolean z2) {
    }

    @Override // com.instagram.common.viewpoint.core.InterfaceC1209Xo
    public final void AF0(boolean z2) {
    }

    @Override // com.instagram.common.viewpoint.core.InterfaceC1209Xo
    public final void AIB(Bundle bundle) {
    }

    public InterfaceC1209Xo getContentView() {
        return this.A03;
    }

    @Override // com.instagram.common.viewpoint.core.InterfaceC1209Xo
    public String getCurrentClientToken() {
        return this.A05.A25();
    }

    @Override // com.instagram.common.viewpoint.core.InterfaceC1209Xo
    public final boolean onActivityResult(int i2, int i8, Intent intent) {
        return false;
    }

    @Override // com.instagram.common.viewpoint.core.InterfaceC1209Xo
    public final void onDestroy() {
    }

    public void setListener(InterfaceC1208Xn interfaceC1208Xn) {
    }
}
