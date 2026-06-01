package com.instagram.common.viewpoint.core;

import android.content.res.Resources;
import android.os.Bundle;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.RelativeLayout;
import java.util.Arrays;

/* JADX INFO: renamed from: com.facebook.ads.redexgen.X.Jp, reason: case insensitive filesystem */
/* JADX INFO: loaded from: assets/audience_network.dex */
public final class C0854Jp extends AbstractC1311ae implements Wf {
    public static byte[] A05;
    public static final int A06;
    public final AbstractC1752hy A00;
    public final C1176Wh A01;
    public final InterfaceC1208Xn A02;
    public final C1343bA A03;
    public final C1443cm A04;

    public static String A00(int i2, int i8, int i9) {
        byte[] bArrCopyOfRange = Arrays.copyOfRange(A05, i2, i2 + i8);
        for (int i10 = 0; i10 < bArrCopyOfRange.length; i10++) {
            bArrCopyOfRange[i10] = (byte) ((bArrCopyOfRange[i10] - i9) - 86);
        }
        return new String(bArrCopyOfRange);
    }

    public static void A01() {
        A05 = new byte[]{38, 42, 30, 36, 34};
    }

    static {
        A01();
        A06 = Resources.getSystem().getDisplayMetrics().widthPixels;
    }

    public C0854Jp(C1315ai c1315ai, boolean z2) {
        int id;
        int iA01;
        super(c1315ai, z2);
        this.A02 = c1315ai.A0D();
        this.A00 = c1315ai.A05();
        this.A03 = new C1343bA(c1315ai.A06(), c1315ai.A02());
        this.A03.A01(getTitleDescContainer(), z2);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -2);
        layoutParams.addRule(12);
        layoutParams.setMargins(AbstractC1311ae.A07, AbstractC1311ae.A07, AbstractC1311ae.A07, AbstractC1311ae.A07);
        getCtaButton().setLayoutParams(layoutParams);
        if (c1315ai.A0I()) {
            this.A04 = new C1443cm(c1315ai.A06());
            this.A04.setPageDetails(c1315ai.A05().A23());
            XP.A0E(1007, this.A04);
            RelativeLayout.LayoutParams pageDetailsParams = new RelativeLayout.LayoutParams(-2, -2);
            pageDetailsParams.addRule(2, getCtaButton().getId());
            pageDetailsParams.setMargins(AbstractC1311ae.A07, AbstractC1311ae.A07 - (AbstractC1311ae.A07 / 2), AbstractC1311ae.A07, 0);
            this.A04.setLayoutParams(pageDetailsParams);
            id = this.A04.getId();
            iA01 = c1315ai.A01() - (AbstractC1311ae.A07 / 2);
        } else {
            id = getCtaButton().getId();
            iA01 = c1315ai.A01();
            this.A04 = null;
        }
        FrameLayout insideContainerLayout = new FrameLayout(c1315ai.A06());
        RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(-1, -1);
        layoutParams2.addRule(10);
        layoutParams2.addRule(2, id);
        layoutParams2.setMargins(0, iA01, 0, 0);
        insideContainerLayout.setLayoutParams(layoutParams2);
        FrameLayout.LayoutParams layoutParams3 = new FrameLayout.LayoutParams(-1, -2);
        layoutParams3.gravity = 17;
        layoutParams3.setMargins(AbstractC1311ae.A07, 0, AbstractC1311ae.A07, 0);
        insideContainerLayout.addView(this.A03, layoutParams3);
        addView(insideContainerLayout);
        if (this.A04 != null) {
            addView(this.A04);
        }
        addView(getCtaButton());
        getCtaButton().A0F(c1315ai.A05(), c1315ai.A0C());
        View viewA02 = c1315ai.A02();
        this.A01 = C1176Wh.A00(c1315ai.A06(), this.A00, this);
        C1175Wg c1175WgA02 = this.A01.A02(this.A00);
        c1315ai.A06().A0H().A00(c1175WgA02.A01);
        getCtaButton().setCreativeAsCtaLoggingHelper(this.A01);
        if (viewA02 != null && c1175WgA02.A00) {
            viewA02.setOnClickListener(new View.OnClickListener() { // from class: com.facebook.ads.redexgen.X.ao
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    this.A00.A1O(view);
                }
            });
        } else if (viewA02 != null && U7.A1I(getAdContextWrapper())) {
            AbstractC1265Zs.A00(viewA02, U7.A1J(getAdContextWrapper()), new ViewOnClickListenerC1322ap(this));
        }
        if (U7.A17(c1315ai.A06())) {
            getTitleDescContainer().setCTAClickListener(getCtaButton());
            if (c1315ai.A0C() != null) {
                c1315ai.A0C().setCTAClickListener(getCtaButton());
            }
        }
        if (this.A04 != null && U7.A18(c1315ai.A06())) {
            this.A04.setOnClickListener(getCtaButton());
        }
    }

    @Override // com.instagram.common.viewpoint.core.AbstractC1311ae
    public final boolean A0C() {
        return false;
    }

    @Override // com.instagram.common.viewpoint.core.AbstractC1311ae
    public final boolean A0D() {
        return false;
    }

    @Override // com.instagram.common.viewpoint.core.AbstractC1311ae
    public final void A1B() {
        super.A1B();
        this.A01.A03();
    }

    @Override // com.instagram.common.viewpoint.core.AbstractC1311ae
    public final void A1G(C0931Mp c0931Mp, String str, double d8, Bundle bundle) {
        super.A1G(c0931Mp, str, d8, bundle);
        if (d8 > 0.0d) {
            int mediaHeight = (int) (((double) (A06 - (AbstractC1311ae.A07 * 2))) / d8);
            this.A03.A00(mediaHeight);
        }
    }

    @Override // com.instagram.common.viewpoint.core.AbstractC1311ae
    public final boolean A1M() {
        return false;
    }

    public final /* synthetic */ void A1O(View view) {
        getCtaButton().A0E(A00(0, 5, 103));
    }
}
