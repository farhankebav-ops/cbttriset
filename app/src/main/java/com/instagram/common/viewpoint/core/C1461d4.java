package com.instagram.common.viewpoint.core;

import android.text.TextUtils;
import android.util.Pair;
import android.view.View;
import android.widget.LinearLayout;

/* JADX INFO: renamed from: com.facebook.ads.redexgen.X.d4, reason: case insensitive filesystem */
/* JADX INFO: loaded from: assets/audience_network.dex */
public final class C1461d4 {
    public KE A00;
    public final C0928Ml A01;
    public final C0938Mw A02;
    public final N0 A03;
    public final N9 A04;
    public final C1477dL A05;
    public final C1120Ua A06;
    public static final int A09 = (int) (AbstractC1180Wl.A02 * 4.0f);
    public static final int A07 = (int) (AbstractC1180Wl.A02 * 72.0f);
    public static final int A08 = (int) (AbstractC1180Wl.A02 * 8.0f);

    public C1461d4(C1477dL c1477dL, US us, AbstractC1752hy abstractC1752hy) {
        this.A05 = c1477dL;
        this.A06 = new C1120Ua(abstractC1752hy.A25(), us);
        this.A01 = abstractC1752hy.A1z();
        this.A02 = abstractC1752hy.A20().A0I();
        this.A04 = abstractC1752hy.A23();
        this.A03 = abstractC1752hy.A20().A0K();
    }

    private View A00(KE ke) {
        C1297aQ c1297aQ = new C1297aQ(this.A05, this.A01.A01(), true, false, false);
        c1297aQ.A04(this.A02.A0F(), this.A02.A04(), null, false, true);
        c1297aQ.setAlignment(17);
        C1291aK c1291aK = new C1291aK(this.A05);
        XP.A0K(c1291aK, 0);
        c1291aK.setRadius(50);
        new KZ(c1291aK, this.A05).A04().A07(this.A04.A01());
        LinearLayout linearLayout = new LinearLayout(this.A05);
        linearLayout.setOrientation(1);
        linearLayout.setGravity(17);
        linearLayout.addView(c1291aK, new LinearLayout.LayoutParams(A07, A07));
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -2);
        layoutParams.setMargins(0, A08, 0, A08);
        linearLayout.addView(c1297aQ, layoutParams);
        if (ke != null) {
            XP.A0H(ke);
            linearLayout.addView(ke, layoutParams);
            if (TextUtils.isEmpty(ke.getText())) {
                XP.A0F(ke);
            }
        }
        return linearLayout;
    }

    private C05246g A01() {
        C05246g c05246g = new C05246g(this.A05);
        c05246g.setLayoutManager(new C1657gI(this.A05, 0, false));
        c05246g.setAdapter(new C0711Eb(this.A05, this.A03.A02(), A09, this.A00));
        return c05246g;
    }

    private final EnumC1460d3 A02() {
        if (!this.A03.A02().isEmpty()) {
            return EnumC1460d3.A03;
        }
        return EnumC1460d3.A02;
    }

    public final Pair<EnumC1460d3, View> A03(KE ke) {
        View viewA01;
        this.A00 = ke;
        EnumC1460d3 enumC1460d3A02 = A02();
        switch (enumC1460d3A02) {
            case A03:
                viewA01 = A01();
                break;
            default:
                viewA01 = A00(this.A00);
                break;
        }
        AbstractC1122Uc.A04(viewA01, this.A06, UZ.A0S);
        return new Pair<>(enumC1460d3A02, viewA01);
    }
}
