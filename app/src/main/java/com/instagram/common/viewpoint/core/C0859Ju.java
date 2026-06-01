package com.instagram.common.viewpoint.core;

import android.os.Bundle;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import java.util.Arrays;

/* JADX INFO: renamed from: com.facebook.ads.redexgen.X.Ju, reason: case insensitive filesystem */
/* JADX INFO: loaded from: assets/audience_network.dex */
public final class C0859Ju extends AbstractC1311ae implements Wf {
    public static byte[] A03;
    public static String[] A04 = {"jViytUMb8W4ggVUJxJM4ipopCTL5", "9aLNfhHGIgyW1yw0lAvb2knTk6C61HAs", "tSRmVjXXTSnTtzrce7INiQjRTYiInlbV", "4hcdJiGUQmFME9vgh87fiTmYWHBJid0b", "Sl93MFe7LYTqHCUKgRBPFfcYUFdC2Wx2", "6CReOOSeiw7R4vGYWPFAi839J8MszZAI", "rkSedGSxOJTtoP7gEY2R8PFp4jzzUrYJ", "HZKY5YyrBfN27m9O42YnVDeAUeo6GkfS"};
    public final AbstractC1752hy A00;
    public final C1176Wh A01;
    public final InterfaceC1208Xn A02;

    public static String A00(int i2, int i8, int i9) {
        byte[] bArrCopyOfRange = Arrays.copyOfRange(A03, i2, i2 + i8);
        int i10 = 0;
        while (true) {
            int length = bArrCopyOfRange.length;
            if (A04[0].length() != 28) {
                throw new RuntimeException();
            }
            String[] strArr = A04;
            strArr[1] = "P3g3yiO3ICi92ZTGqQIjITPfAPWFUEMm";
            strArr[2] = "pyBqNmisWoZkDTGCi8bHuToayw1uFlPn";
            if (i10 >= length) {
                return new String(bArrCopyOfRange);
            }
            bArrCopyOfRange[i10] = (byte) ((bArrCopyOfRange[i10] ^ i9) ^ 78);
            i10++;
        }
    }

    public static void A01() {
        A03 = new byte[]{64, 68, 72, 78, 76};
    }

    static {
        A01();
    }

    public C0859Ju(C1315ai c1315ai, boolean z2) {
        FrameLayout.LayoutParams layoutParams;
        super(c1315ai, true);
        this.A02 = c1315ai.A0D();
        this.A00 = c1315ai.A05();
        RelativeLayout relativeLayout = new RelativeLayout(c1315ai.A06());
        RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(-1, -2);
        layoutParams2.addRule(12);
        XP.A0P(relativeLayout, getAdContextWrapper());
        LinearLayout linearLayout = new LinearLayout(c1315ai.A06());
        linearLayout.setOrientation(!z2 ? 1 : 0);
        linearLayout.setGravity(80);
        XP.A0I(linearLayout);
        RelativeLayout.LayoutParams layoutParams3 = new RelativeLayout.LayoutParams(-1, -2);
        layoutParams3.setMargins(AbstractC1311ae.A07, 0, AbstractC1311ae.A07, AbstractC1311ae.A07);
        LinearLayout.LayoutParams layoutParams4 = new LinearLayout.LayoutParams(z2 ? -2 : -1, -2);
        layoutParams4.setMargins(z2 ? AbstractC1311ae.A07 : 0, z2 ? 0 : AbstractC1311ae.A07, 0, 0);
        LinearLayout.LayoutParams layoutParams5 = new LinearLayout.LayoutParams(z2 ? 0 : -1, -2);
        layoutParams5.setMargins(0, 0, 0, 0);
        layoutParams5.weight = 1.0f;
        linearLayout.addView(getTitleDescContainer(), layoutParams5);
        this.A01 = C1176Wh.A00(c1315ai.A06(), this.A00, this);
        C1175Wg c1175WgA02 = this.A01.A02(this.A00);
        c1315ai.A06().A0H().A00(c1175WgA02.A01);
        if (c1315ai.A0I() && !z2) {
            C1443cm c1443cm = new C1443cm(c1315ai.A06());
            c1443cm.setPageDetails(c1315ai.A05().A23());
            int iA05 = this.A06.A05().A1z().A00().A05(true);
            c1443cm.A02(iA05, iA05);
            XP.A0E(1007, c1443cm);
            LinearLayout.LayoutParams layoutParams6 = new LinearLayout.LayoutParams(-1, -2);
            layoutParams6.setMargins(0, AbstractC1311ae.A07, 0, 0);
            linearLayout.addView(c1443cm, layoutParams6);
            if (U7.A18(c1315ai.A06())) {
                c1443cm.setOnClickListener(getCtaButton());
            }
        }
        linearLayout.addView(getCtaButton(), layoutParams4);
        relativeLayout.addView(linearLayout, layoutParams3);
        getCtaButton().A0F(c1315ai.A05(), c1315ai.A0C());
        View viewA02 = c1315ai.A02();
        if (viewA02 != null && (c1175WgA02.A00 || U7.A1I(getAdContextWrapper()))) {
            if (z2) {
                layoutParams = new FrameLayout.LayoutParams(-2, -1);
            } else {
                layoutParams = new FrameLayout.LayoutParams(-1, -2);
            }
            layoutParams.gravity = 17;
            FrameLayout frameLayout = new FrameLayout(c1315ai.A06());
            frameLayout.addView(viewA02, layoutParams);
            addView(frameLayout, new RelativeLayout.LayoutParams(-1, -1));
            getCtaButton().setCreativeAsCtaLoggingHelper(this.A01);
            if (c1175WgA02.A00) {
                viewA02.setOnClickListener(new View.OnClickListener() { // from class: com.facebook.ads.redexgen.X.aa
                    @Override // android.view.View.OnClickListener
                    public final void onClick(View view) {
                        this.A00.A1O(view);
                    }
                });
            } else {
                AbstractC1265Zs.A00(viewA02, U7.A1J(getAdContextWrapper()), new ViewOnClickListenerC1308ab(this));
            }
        } else if (viewA02 != null) {
            addView(viewA02, new RelativeLayout.LayoutParams(-1, -1));
        }
        addView(relativeLayout, layoutParams2);
        if (U7.A17(c1315ai.A06())) {
            getTitleDescContainer().setCTAClickListener(getCtaButton());
            if (c1315ai.A0C() != null) {
                c1315ai.A0C().setCTAClickListener(getCtaButton());
            }
        }
    }

    @Override // com.instagram.common.viewpoint.core.AbstractC1311ae
    public final void A1B() {
        super.A1B();
        this.A01.A03();
    }

    @Override // com.instagram.common.viewpoint.core.AbstractC1311ae
    public final void A1G(C0931Mp c0931Mp, String str, double d8, Bundle bundle) {
        super.A1G(c0931Mp, str, d8, bundle);
    }

    @Override // com.instagram.common.viewpoint.core.AbstractC1311ae
    public final boolean A1M() {
        return true;
    }

    public final /* synthetic */ void A1O(View view) {
        getCtaButton().A0E(A00(0, 5, 103));
    }
}
