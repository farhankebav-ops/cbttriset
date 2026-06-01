package com.instagram.common.viewpoint.core;

import android.content.res.Resources;
import android.os.Bundle;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.RelativeLayout;
import java.util.Arrays;

/* JADX INFO: renamed from: com.facebook.ads.redexgen.X.5e, reason: invalid class name and case insensitive filesystem */
/* JADX INFO: loaded from: assets/audience_network.dex */
public final class C04965e extends AbstractC0861Jw {
    public static byte[] A02;
    public static String[] A03 = {"ccLmdgMtf", "50lpHgsnQSuWf1CWCacJGyiAwAWsDUud", "Nq2vo108Bdlpu7LWCjcAC5dDG31maruF", "TAe0PaklKNA7XHBVlxrhZCtyBfgeydAO", "ouUdcivF6", "IAXVD4SBpgtyrGYWX4yc8p2wBrUpSeUf", "nA5GNdAWyE31pAGlKcdnPdOQEY7Q2fwD", "a5Dyr8HKQP9cZfy0xnx35qJg31dQk6"};
    public static final int A04;
    public final View A00;
    public final boolean A01;

    public static String A00(int i2, int i8, int i9) {
        byte[] bArrCopyOfRange = Arrays.copyOfRange(A02, i2, i2 + i8);
        int i10 = 0;
        while (true) {
            int length = bArrCopyOfRange.length;
            if (A03[7].length() != 30) {
                throw new RuntimeException();
            }
            String[] strArr = A03;
            strArr[0] = "FT3046kmt";
            strArr[4] = "J6Q3a22Lt";
            if (i10 >= length) {
                return new String(bArrCopyOfRange);
            }
            bArrCopyOfRange[i10] = (byte) ((bArrCopyOfRange[i10] ^ i9) ^ 71);
            i10++;
        }
    }

    public static void A01() {
        A02 = new byte[]{37, 33, 45, 43, 41};
    }

    static {
        A01();
        A04 = Resources.getSystem().getDisplayMetrics().widthPixels;
    }

    public C04965e(C1315ai c1315ai, boolean z2) {
        super(c1315ai, true);
        this.A01 = z2;
        this.A00 = c1315ai.A02();
        A1R();
        if (this.A01) {
            addView(c1315ai.A02(), new RelativeLayout.LayoutParams(-1, -1));
        } else {
            FrameLayout frameLayout = new FrameLayout(c1315ai.A06());
            RelativeLayout.LayoutParams insideContainerParams = new RelativeLayout.LayoutParams(-1, -1);
            insideContainerParams.addRule(2, getAdDetailsView().getId());
            frameLayout.setLayoutParams(insideContainerParams);
            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -2);
            layoutParams.gravity = 17;
            layoutParams.setMargins(AbstractC1311ae.A07, 0, AbstractC1311ae.A07, 0);
            frameLayout.addView(this.A00, layoutParams);
            addView(frameLayout);
        }
        C1175Wg c1175WgA02 = this.A09.A02(getAdDataBundle());
        c1315ai.A06().A0H().A00(c1175WgA02.A01);
        getCtaButton().setCreativeAsCtaLoggingHelper(this.A09);
        if (this.A00 != null) {
            if (c1175WgA02.A00) {
                this.A00.setOnClickListener(new View.OnClickListener() { // from class: com.facebook.ads.redexgen.X.aj
                    @Override // android.view.View.OnClickListener
                    public final void onClick(View view) {
                        this.A00.A1W(view);
                    }
                });
            } else if (U7.A1I(getAdContextWrapper())) {
                AbstractC1265Zs.A00(this.A00, U7.A1J(getAdContextWrapper()), new ViewOnClickListenerC1317ak(this));
            }
        }
        getAdDetailsView().bringToFront();
    }

    @Override // com.instagram.common.viewpoint.core.AbstractC1311ae
    public final boolean A0C() {
        return this.A01 && super.A0D();
    }

    @Override // com.instagram.common.viewpoint.core.AbstractC1311ae
    public final boolean A0D() {
        return this.A01 && super.A0D();
    }

    @Override // com.instagram.common.viewpoint.core.AbstractC0861Jw, com.instagram.common.viewpoint.core.AbstractC1311ae
    public final void A1G(C0931Mp c0931Mp, String str, double d8, Bundle bundle) {
        super.A1G(c0931Mp, str, d8, bundle);
        if (!this.A01 && d8 > 0.0d) {
            int mediaHeight = (int) (((double) (A04 - (AbstractC1311ae.A07 * 2))) / d8);
            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, mediaHeight);
            layoutParams.gravity = 17;
            int i2 = AbstractC1311ae.A07;
            int mediaHeight2 = AbstractC1311ae.A07;
            layoutParams.setMargins(i2, 0, mediaHeight2, 0);
            this.A00.setLayoutParams(layoutParams);
        }
    }

    @Override // com.instagram.common.viewpoint.core.AbstractC1311ae
    public final boolean A1M() {
        return this.A01;
    }

    @Override // com.instagram.common.viewpoint.core.AbstractC0861Jw
    public final AbstractC1268Zv A1P(C1315ai c1315ai, C0931Mp c0931Mp, String str) {
        return new C0863Jy(c1315ai.A06(), getCtaButton(), AbstractC0861Jw.A0H, c0931Mp.A0I().A00() == EnumC0936Mu.A05, getColors(), c0931Mp.A0J().A06(), str, c1315ai.A07(), c1315ai.A0D(), c1315ai.A0G(), c1315ai.A0A(), c1315ai.A05());
    }

    public final /* synthetic */ void A1W(View view) {
        getCtaButton().A0E(A00(0, 5, 11));
    }
}
