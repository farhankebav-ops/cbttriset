package com.instagram.common.viewpoint.core;

import android.content.res.Configuration;
import android.os.Handler;
import android.os.Looper;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import java.util.HashMap;
import java.util.concurrent.atomic.AtomicBoolean;

/* JADX INFO: renamed from: com.facebook.ads.redexgen.X.50, reason: invalid class name */
/* JADX INFO: loaded from: assets/audience_network.dex */
public final class AnonymousClass50 extends AbstractC0804Hr {
    public static String[] A09 = {"48gXxVXafINQx", "X9eHMFtmNxkudREV2ga0mL63IUwpVFyn", "fDHVKSg", "BJ3S", "6p1nQLD", "GwvdfXoW7Tkcgx6xI32", "XjSW5yJHqMwpzXQP1hTrWYHuzeodWOV3", "mLwcnNPCnn6Mi"};
    public static final RelativeLayout.LayoutParams A0A = new RelativeLayout.LayoutParams(-1, -1);
    public C1174Wd A00;
    public AbstractC1311ae A01;
    public C0680Cw A02;
    public final int A03;
    public final ImageView A04;
    public final C1120Ua A05;
    public final AbstractC1207Xm A06;
    public final InterfaceC1424cT A07;
    public final AtomicBoolean A08;

    public AnonymousClass50(C1477dL c1477dL, YY yy, int i2, US us, AbstractC1752hy abstractC1752hy, InterfaceC1208Xn interfaceC1208Xn, AbstractC1207Xm abstractC1207Xm, C1120Ua c1120Ua, boolean z2, boolean z7, InterfaceC1424cT interfaceC1424cT, int i8, int i9) {
        super(c1477dL, yy, us, abstractC1752hy, i2, z2, z7, interfaceC1208Xn, i9);
        this.A08 = new AtomicBoolean(false);
        this.A03 = i8;
        this.A07 = interfaceC1424cT;
        this.A04 = new ImageView(getContext());
        this.A06 = abstractC1207Xm;
        this.A05 = c1120Ua;
        if (abstractC1752hy.A1U()) {
            this.A02 = new C0680Cw(c1477dL, this.A03);
        }
        this.A04.setScaleType(ImageView.ScaleType.CENTER);
        this.A04.setAdjustViewBounds(true);
        new KZ(this.A04, c1477dL).A05(abstractC1752hy.A20().A0H().A00(), abstractC1752hy.A20().A0H().A01()).A06(new C0797Hj(this)).A07(abstractC1752hy.A20().A0H().A08());
        A08(c1477dL.getResources().getConfiguration().orientation);
    }

    private AbstractC1311ae A02(int i2) {
        if (this.A04.getParent() != null) {
            XP.A0H(this.A04);
        }
        boolean z2 = i2 != 2;
        C1314ah c1314ah = new C1314ah(super.A07, super.A08, this.A0B, super.A06, this.A04, this.A0D, this.A0A);
        C1314ah interstitialLayoutParamsBuilder = c1314ah.A0K(this.A06.getToolbarHeight());
        interstitialLayoutParamsBuilder.A0R(this.A06).A0J(i2).A0V(z2).A0U(super.A00).A0N(this.A05);
        if (this.A02 != null) {
            c1314ah.A0T(this.A02);
        }
        c1314ah.A0M(MI.A00(super.A07, super.A08, "", WQ.A00(super.A06.A20().A0J().A05()), new HashMap(), super.A06.A21()));
        c1314ah.A0S(this.A07);
        return AbstractC1312af.A00(c1314ah.A0W(), null, true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void A07() {
        if (this.A08.get()) {
            A1C();
        }
    }

    private void A08(int i2) {
        XP.A0H(this.A01);
        this.A01 = A02(i2);
        if (this.A01 instanceof JU) {
            ((JU) this.A01).setChildChainedAd(true);
        } else if (this.A01 instanceof C0831Is) {
            AbstractC1311ae abstractC1311ae = this.A01;
            String[] strArr = A09;
            if (strArr[1].charAt(0) != strArr[6].charAt(0)) {
                throw new RuntimeException();
            }
            A09[5] = "Sp2NSSouatJBlog5Q54";
            ((C0831Is) abstractC1311ae).setChildChainedAd(true);
        }
        addView(this.A01, 0, A0A);
    }

    @Override // com.instagram.common.viewpoint.core.AbstractC0804Hr
    public final ME A1A(String str) {
        return this.A01.A1A(str);
    }

    @Override // com.instagram.common.viewpoint.core.AbstractC0804Hr
    public final void A1B() {
        if (U7.A1u(super.A07)) {
            super.A07.A0B().AJj(this.A04);
        }
        if (this.A01 != null) {
            this.A01.A1B();
        }
    }

    @Override // com.instagram.common.viewpoint.core.AbstractC0804Hr
    public final void A1D() {
        if (this.A01 instanceof C0862Jx) {
            AbstractC1311ae abstractC1311ae = this.A01;
            String[] strArr = A09;
            if (strArr[7].length() != strArr[0].length()) {
                throw new RuntimeException();
            }
            A09[3] = "fHRV";
            ((C0862Jx) abstractC1311ae).A1O();
            return;
        }
        if (this.A01 instanceof C0831Is) {
            ((C0831Is) this.A01).A1R(false);
        }
    }

    @Override // com.instagram.common.viewpoint.core.AbstractC0804Hr
    public final void A1E() {
        int iA02 = super.A06.A20().A0H().A02();
        int secondsForNextCta = this.A03;
        if (secondsForNextCta > 0) {
            this.A00 = new C1174Wd(this.A03, 100.0f, 100L, new Handler(Looper.getMainLooper()), new HV(this));
            this.A00.A07();
            if (iA02 >= 0) {
                this.A06.setProgressSpinnerInvisible(true);
            }
            if (iA02 != 0) {
                int secondsForNextCta2 = this.A03;
                if (iA02 < secondsForNextCta2) {
                    if (iA02 <= 0) {
                        return;
                    }
                    new C1174Wd(iA02, new HS(this)).A07();
                    return;
                }
            }
            this.A06.setToolbarActionMode(8);
            return;
        }
        this.A07.AFE(false);
    }

    @Override // com.instagram.common.viewpoint.core.AbstractC0804Hr
    public final void A1F(boolean z2) {
        this.A01.setChainedWatchAndBrowseSkippableStatus(z2);
    }

    @Override // com.instagram.common.viewpoint.core.AbstractC0804Hr
    public final void A1G(boolean z2) {
        if (this.A00 != null && this.A00.A05()) {
            this.A00.A06();
        }
    }

    @Override // com.instagram.common.viewpoint.core.AbstractC0804Hr
    public final void A1H(boolean z2) {
        if (this.A00 != null && !this.A00.A04()) {
            this.A00.A07();
        }
    }

    @Override // com.instagram.common.viewpoint.core.AbstractC0804Hr
    public final boolean A1I() {
        if (this.A01.A1K()) {
            if (!(this.A01 instanceof C0862Jx) || ((C0862Jx) this.A01).A1P()) {
                return (this.A01 instanceof C0831Is) && !((C0831Is) this.A01).A1T();
            }
            return true;
        }
        return false;
    }

    @Override // com.instagram.common.viewpoint.core.AbstractC0804Hr
    public final boolean A1J() {
        if (this.A01 instanceof C0862Jx) {
            return ((C0862Jx) this.A01).A1P();
        }
        boolean z2 = this.A01 instanceof C0831Is;
        String[] strArr = A09;
        if (strArr[1].charAt(0) != strArr[6].charAt(0)) {
            throw new RuntimeException();
        }
        String[] strArr2 = A09;
        strArr2[2] = "VUX6Wbk";
        strArr2[4] = "Kq1l7t9";
        if (z2) {
            return ((C0831Is) this.A01).A1T();
        }
        return false;
    }

    @Override // com.instagram.common.viewpoint.core.AbstractC0804Hr
    public final boolean A1K() {
        if (this.A01 instanceof C0862Jx) {
            return ((C0862Jx) this.A01).A1Q();
        }
        if (this.A01 instanceof C0831Is) {
            return ((C0831Is) this.A01).A1U();
        }
        return true;
    }

    @Override // com.instagram.common.viewpoint.core.AbstractC0804Hr
    public C1422cR getFullScreenAdStyle() {
        C0940My colors = this.A01.getColors();
        return new C1422cR(this.A01.A1M(), C1422cR.A07, colors, KE.A05(super.A06), colors.A08(this.A01.A1M() || (this.A01 instanceof AbstractC0861Jw)), null);
    }

    @Override // com.instagram.common.viewpoint.core.AbstractC0804Hr, android.view.View
    public final void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        if (this.A01 instanceof C0862Jx) {
            this.A01.onConfigurationChanged(configuration);
        } else if (!super.A06.A20().A0T()) {
            A08(configuration.orientation);
        }
    }
}
