package com.instagram.common.viewpoint.core;

import android.content.Intent;
import android.content.res.Configuration;
import android.os.Build;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.MotionEvent;
import android.widget.FrameLayout;
import android.widget.RelativeLayout;
import java.lang.ref.WeakReference;

/* JADX INFO: loaded from: assets/audience_network.dex */
public abstract class G2 extends FrameLayout implements InterfaceC1209Xo {
    public boolean A00;
    public boolean A01;
    public final AbstractC1752hy A02;
    public final SF A03;
    public final C1477dL A04;
    public final US A05;
    public final C1120Ua A06;
    public final XH A07;
    public final AbstractC1207Xm A08;
    public final InterfaceC1208Xn A09;
    public final YY A0A;
    public final C1550eX A0B;
    public final XC A0C;
    public final AbstractC1549eW A0D;
    public static final int A0F = (int) (AbstractC1180Wl.A02 * 48.0f);
    public static final int A0G = (int) (AbstractC1180Wl.A02 * 64.0f);
    public static final RelativeLayout.LayoutParams A0E = new RelativeLayout.LayoutParams(-1, -1);

    public abstract AbstractC1207Xm A0b();

    public abstract void A0e();

    public abstract void A0f();

    public abstract void A0h(R0 r02);

    public abstract boolean A0i();

    public abstract boolean A0j();

    public G2(C1477dL c1477dL, YY yy, US us, AbstractC1752hy abstractC1752hy, SF sf, InterfaceC1208Xn interfaceC1208Xn) {
        super(c1477dL);
        this.A01 = false;
        this.A0D = new G7(this);
        this.A07 = new XH();
        this.A00 = false;
        this.A04 = c1477dL;
        this.A0A = yy;
        this.A05 = us;
        this.A02 = abstractC1752hy;
        this.A03 = sf;
        this.A09 = interfaceC1208Xn;
        this.A06 = new C1120Ua(this.A02.A25(), this.A05);
        this.A0B = new C1550eX(this, 1, new WeakReference(this.A0D), this.A04);
        this.A0B.A0W(this.A02.A0i());
        this.A0B.A0X(this.A02.A0j());
        this.A08 = A0Z();
        this.A0C = new XC(this);
        this.A0C.A05(XB.A02);
        if (!A0j() && Build.VERSION.SDK_INT >= 35) {
            setFitsSystemWindows(true);
        }
    }

    private AbstractC1207Xm A0Z() {
        AbstractC1207Xm abstractC1207XmA0b = A0b();
        abstractC1207XmA0b.setFullscreen(true);
        int iA04 = this.A02.A20().A0H().A04();
        abstractC1207XmA0b.setPageDetails(this.A02.A23(), this.A02.A25(), iA04, this.A02.A24());
        abstractC1207XmA0b.A0A(this.A02.A1z().A01(), KE.A05(this.A02));
        if (this.A02.A20().A0H().A02() == 0) {
            this.A01 = true;
            abstractC1207XmA0b.setToolbarActionMode(8);
        } else if (iA04 < 0 && this.A02.A20().A0S()) {
            abstractC1207XmA0b.setToolbarActionMode(4);
        }
        if (this.A02.A20().A0H().A02() >= 0) {
            abstractC1207XmA0b.setProgressSpinnerInvisible(true);
        }
        abstractC1207XmA0b.setToolbarListener(new G3(this));
        return abstractC1207XmA0b;
    }

    private void A0a() {
        if (this.A02.A20().A0W()) {
            C1428cX c1428cXA0F = new C1426cV(this.A04, this.A02.A20().A0I(), this.A02.A23()).A0A(this.A02.A1z().A01()).A0F();
            AbstractC1122Uc.A04(c1428cXA0F, this.A06, UZ.A0U);
            addView(c1428cXA0F, A0E);
            c1428cXA0F.A04(new G5(this));
            return;
        }
        A0f();
    }

    public final void A0c() {
        if (!this.A00) {
            this.A0B.A0U();
            this.A00 = true;
        }
    }

    public final void A0d() {
        if (this.A08.getToolbarActionMode() == 8) {
            this.A08.setToolbarActionMode(2);
        }
        this.A02.A2B(false);
        this.A02.A20().A0M(-1);
    }

    public final void A0g(int i2, AbstractRunnableC1164Vt abstractRunnableC1164Vt, C0680Cw c0680Cw) {
        new C1174Wd(i2, new G6(this, i2, c0680Cw, abstractRunnableC1164Vt)).A07();
    }

    @Override // com.instagram.common.viewpoint.core.InterfaceC1209Xo
    public final void AAl(Intent intent, Bundle bundle, R0 r02) {
        this.A09.A3x(this, A0E);
        A0h(r02);
        A0a();
    }

    @Override // com.instagram.common.viewpoint.core.InterfaceC1209Xo
    public final void AIB(Bundle bundle) {
    }

    @Override // com.instagram.common.viewpoint.core.InterfaceC1209Xo
    public String getCurrentClientToken() {
        return this.A02.A25();
    }

    @Override // com.instagram.common.viewpoint.core.InterfaceC1209Xo
    public final boolean onActivityResult(int i2, int i8, Intent intent) {
        return false;
    }

    @Override // android.view.View
    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        if (!A0j() && Build.VERSION.SDK_INT >= 35) {
            setFitsSystemWindows(true);
        }
    }

    public void onDestroy() {
        this.A0C.A03();
        if (!TextUtils.isEmpty(this.A02.A25())) {
            this.A05.AAt(this.A02.A25(), new C1262Zp().A03(this.A0B).A02(this.A07).A05());
        }
    }

    @Override // android.view.ViewGroup
    public final boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        this.A07.A06(this.A04, motionEvent, this, this);
        return super.onInterceptTouchEvent(motionEvent);
    }

    public void setListener(InterfaceC1208Xn interfaceC1208Xn) {
    }

    public void setUpFullscreenMode(boolean z2) {
        XB xb;
        if (z2) {
            xb = XB.A03;
        } else {
            xb = XB.A02;
        }
        this.A0C.A05(xb);
    }
}
