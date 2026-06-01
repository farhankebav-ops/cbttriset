package com.instagram.common.viewpoint.core;

import android.content.res.Configuration;
import android.os.Bundle;
import android.os.Handler;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import java.util.HashMap;

/* JADX INFO: renamed from: com.facebook.ads.redexgen.X.ae, reason: case insensitive filesystem */
/* JADX INFO: loaded from: assets/audience_network.dex */
public abstract class AbstractC1311ae extends RelativeLayout {
    public C0940My A00;
    public boolean A01;
    public final C1477dL A02;
    public final US A03;
    public final KE A04;
    public final C1297aQ A05;
    public final C1315ai A06;
    public static final int A07 = (int) (AbstractC1180Wl.A02 * 16.0f);
    public static final int A08 = (int) (AbstractC1180Wl.A02 * 28.0f);
    public static final int A0B = (int) (AbstractC1180Wl.A02 * 2.0f);
    public static final int A0E = (int) (AbstractC1180Wl.A02 * 4.0f);
    public static final int A0I = (int) (AbstractC1180Wl.A02 * 8.0f);
    public static final int A09 = (int) (AbstractC1180Wl.A02 * 12.0f);
    public static final int A0A = (int) (AbstractC1180Wl.A02 * 16.0f);
    public static final int A0C = (int) (AbstractC1180Wl.A02 * 20.0f);
    public static final int A0D = (int) (AbstractC1180Wl.A02 * 24.0f);
    public static final int A0F = (int) (AbstractC1180Wl.A02 * 44.0f);
    public static final int A0G = (int) (AbstractC1180Wl.A02 * 48.0f);
    public static final int A0H = (int) (AbstractC1180Wl.A02 * 64.0f);
    public static final int A0J = (int) (AbstractC1180Wl.A02 * 32.0f);

    public abstract boolean A1M();

    public AbstractC1311ae(C1315ai c1315ai, boolean z2) {
        C0940My c0940MyA00;
        super(c1315ai.A06());
        this.A06 = c1315ai;
        this.A02 = c1315ai.A06();
        this.A03 = c1315ai.A07();
        if (c1315ai.A00() == 1) {
            c0940MyA00 = c1315ai.A05().A1z().A01();
        } else {
            c0940MyA00 = c1315ai.A05().A1z().A00();
        }
        this.A00 = c0940MyA00;
        this.A01 = z2;
        this.A04 = new KE(c1315ai.A06(), c1315ai.A05(), this.A00, c1315ai.A07(), c1315ai.A0D(), c1315ai.A0G(), c1315ai.A0A(), c1315ai.A09());
        this.A04.setRoundedCornersEnabled(A01());
        this.A04.setViewShowsOverMedia(A0C());
        XP.A0E(1001, this.A04);
        this.A05 = new C1297aQ(this.A02, this.A00, this.A01, A02(), A0D());
        XP.A0I(this.A05);
    }

    public final ImageView A00(C1477dL c1477dL, AbstractC1752hy abstractC1752hy, C1120Ua c1120Ua, Z5 z52, InterfaceC1208Xn interfaceC1208Xn, Handler handler) {
        ImageView imageViewA01 = Z9.A01(c1477dL, c1120Ua, abstractC1752hy, z52, interfaceC1208Xn, handler);
        XP.A0I(imageViewA01);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams.setMargins(A0A, 0, 0, A0A);
        layoutParams.addRule(12);
        layoutParams.addRule(9);
        imageViewA01.setLayoutParams(layoutParams);
        return imageViewA01;
    }

    public boolean A01() {
        return true;
    }

    public boolean A02() {
        return true;
    }

    public final boolean A03() {
        return this.A06.A05().A1m() || this.A06.A05().A1o();
    }

    public boolean A0C() {
        return true;
    }

    public boolean A0D() {
        return true;
    }

    public ME A1A(String str) {
        return getCtaButton().A0E(str);
    }

    public void A1B() {
    }

    public void A1C() {
    }

    public void A1D() {
    }

    public void A1E() {
    }

    public void A1F() {
    }

    public void A1G(C0931Mp c0931Mp, String str, double d8, Bundle bundle) {
        this.A05.A04(c0931Mp.A0I().A0E(), c0931Mp.A0I().A04(), null, false, !A1M() && d8 > 0.0d && d8 < 1.0d);
        this.A04.setCta(c0931Mp.A0J(), str, new HashMap());
    }

    public void A1H(C04433d c04433d) {
    }

    public void A1I(DO r1) {
    }

    public void A1J(C3Q c3q, int i2) {
    }

    public boolean A1K() {
        return false;
    }

    public boolean A1L() {
        return true;
    }

    public boolean A1N(boolean z2) {
        return false;
    }

    public C1477dL getAdContextWrapper() {
        return this.A02;
    }

    public US getAdEventManager() {
        return this.A03;
    }

    public int getCloseButtonStyle() {
        return 0;
    }

    public C0940My getColors() {
        return this.A00;
    }

    public KE getCtaButton() {
        return this.A04;
    }

    public C1297aQ getTitleDescContainer() {
        return this.A05;
    }

    @Override // android.view.View
    public void onConfigurationChanged(Configuration configuration) {
        C0940My c0940MyA00;
        super.onConfigurationChanged(configuration);
        if (configuration.orientation == 1) {
            c0940MyA00 = this.A06.A05().A1z().A01();
        } else {
            c0940MyA00 = this.A06.A05().A1z().A00();
        }
        this.A00 = c0940MyA00;
        this.A04.setViewShowsOverMedia(A0C());
        this.A04.setUpButtonColors(this.A00);
        this.A05.A03(this.A00, this.A01);
    }

    public void setAccidentalClickCappingListener(MF mf) {
        getCtaButton().getCtaActionHelper().A07(mf);
    }

    public void setChainedWatchAndBrowseSkippableStatus(boolean z2) {
    }
}
