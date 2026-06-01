package com.instagram.common.viewpoint.core;

import android.graphics.Typeface;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.google.android.gms.ads.RequestConfiguration;

/* JADX INFO: renamed from: com.facebook.ads.redexgen.X.5r, reason: invalid class name and case insensitive filesystem */
/* JADX INFO: loaded from: assets/audience_network.dex */
public final class C05095r extends KL {
    public static String[] A00 = {RequestConfiguration.MAX_AD_CONTENT_RATING_G, "KzTy2hy9hhtw1RMGA4AWQtLCSBRvIgNx", "TFXx3faCMHKsw8ZQwSQJp4p3qrvSFGQZ", "FDPqMwfpfrBnIs9VqOwKhGqv0efVrSDC", "w99CmZO3gVFe1JaqJ0AV2MifxVBEUT0K", "IReileYPgfNfW", "Qab6Yr7DAj1gKX83C9lxa", "vvhOodmvLfB1cs4WARwmrAXLlmUlw4y7"};
    public static final int A01 = (int) (AbstractC1180Wl.A02 * 152.0f);

    public C05095r(C1477dL c1477dL, KE ke, int i2, boolean z2, C0940My c0940My, String str, US us, InterfaceC1208Xn interfaceC1208Xn, C1550eX c1550eX, XH xh, AbstractC1752hy abstractC1752hy, C0680Cw c0680Cw, C1120Ua c1120Ua, boolean z7) {
        super(c1477dL, ke, i2, z2, c0940My, false, str, us, interfaceC1208Xn, c1550eX, xh, abstractC1752hy, c0680Cw, c1120Ua, z7);
        int i8 = getResources().getConfiguration().orientation;
        A00();
        A07(i8);
        A09(i8);
        XP.A0I(this.A0P);
        A06(i8);
        A02(i8);
        A05(i8);
        A04(i8);
        A03(i8);
        A08(i8);
        A0A(((KL) this).A04, i8);
        addView(this.A0O);
    }

    private void A00() {
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -2);
        layoutParams.addRule(13);
        int i2 = (int) (getResources().getDisplayMetrics().widthPixels * 0.1f);
        layoutParams.setMargins(i2, 0, i2, 0);
        this.A0N.setLayoutParams(layoutParams);
    }

    private void A01(int i2) {
        if (((AbstractC1268Zv) this).A08.getParent() != null) {
            KE ke = ((AbstractC1268Zv) this).A08;
            if (A00[6].length() != 21) {
                throw new RuntimeException();
            }
            A00[6] = "77Sm8WMgdJozvQKOpKshJ";
            XP.A0H(ke);
        }
        if (i2 == 1) {
            A0u(this.A0O);
            this.A0O.addView(this.A0I);
            this.A0O.addView(this.A0U);
            this.A0O.addView(((AbstractC1268Zv) this).A08);
            this.A0O.addView(this.A0K);
            this.A0O.addView(this.A0J);
        } else {
            this.A0N.addView(((AbstractC1268Zv) this).A09);
            this.A0N.addView(this.A0Q);
            this.A0N.addView(this.A0P);
            this.A0N.addView(((AbstractC1268Zv) this).A08);
            this.A0N.addView(this.A0U);
            A0u(this.A0N);
            this.A0N.addView(this.A0I);
            this.A0O.addView(this.A0J);
            this.A0O.addView(this.A0N);
            this.A0O.addView(this.A0K);
        }
        if (this.A0Y) {
            A0n();
        }
    }

    private void A02(int i2) {
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.A0K.getLayoutParams();
        layoutParams.setMargins(0, 0, KL.A0r, 0);
        layoutParams.addRule(12);
        layoutParams.addRule(11);
        this.A0K.setLayoutParams(layoutParams);
        this.A0K.setPadding(KL.A0u, KL.A0u, 0, 0);
    }

    private void A03(int i2) {
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, KL.A0b);
        if (i2 == 1) {
            layoutParams.setMargins(KL.A0r, 0, KL.A0r, KL.A0l);
            layoutParams.addRule(2, this.A0U.getId());
        } else {
            layoutParams.setMargins(0, 0, 0, 0);
            layoutParams.addRule(3, this.A0I.getId());
        }
        layoutParams.addRule(14);
        ((AbstractC1268Zv) this).A08.setLayoutParams(layoutParams);
        A0k();
    }

    private void A04(int i2) {
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.A0I.getLayoutParams();
        if (i2 == 1) {
            layoutParams.removeRule(3);
            KE ke = ((AbstractC1268Zv) this).A08;
            if (A00[0].length() != 1) {
                throw new RuntimeException();
            }
            A00[0] = "l";
            layoutParams.addRule(2, ke.getId());
        } else {
            layoutParams.removeRule(2);
            layoutParams.setMargins(0, 0, 0, KL.A0u);
            layoutParams.addRule(3, this.A0P.getId());
        }
        this.A0I.setLayoutParams(layoutParams);
    }

    private void A05(int i2) {
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
        if (i2 == 1) {
            layoutParams.removeRule(11);
            layoutParams.addRule(7, ((AbstractC1268Zv) this).A08.getId());
            layoutParams.setMargins(0, 0, 0, 0);
        } else {
            layoutParams.removeRule(7);
            layoutParams.addRule(11);
            layoutParams.setMargins(0, 0, KL.A0l, 0);
        }
        layoutParams.addRule(12);
        this.A0J.setPadding(0, 0, 0, KL.A0l);
        this.A0J.setLayoutParams(layoutParams);
    }

    private void A06(int i2) {
        int i8;
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.A0P.getLayoutParams();
        if (i2 == 1) {
            i8 = KL.A0t;
            this.A0P.setMaxLines(4);
        } else {
            i8 = KL.A0u;
            this.A0P.setMaxLines(2);
        }
        int horizontalMargin = KL.A0u;
        layoutParams.setMargins(i8, horizontalMargin, i8, KL.A0l);
        layoutParams.addRule(14);
        int horizontalMargin2 = this.A0Q.getId();
        layoutParams.addRule(3, horizontalMargin2);
        layoutParams.addRule(14);
        this.A0P.setTypeface(Typeface.DEFAULT);
        this.A0P.setTextSize(18.0f);
        this.A0P.setLayoutParams(layoutParams);
    }

    private void A07(int i2) {
        int topMargin;
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) ((AbstractC1268Zv) this).A09.getLayoutParams();
        if (i2 == 1) {
            layoutParams.width = A01;
            layoutParams.height = A01;
            layoutParams.setMargins(0, (-A01) / 4, 0, 0);
            topMargin = 30;
        } else {
            layoutParams.removeRule(3);
            layoutParams.removeRule(14);
            int i8 = KL.A0h;
            if (A00[0].length() != 1) {
                throw new RuntimeException();
            }
            A00[1] = "bedGjlLGZ2badAr5t95UZlauyGcNPG4D";
            layoutParams.width = i8;
            layoutParams.height = KL.A0h;
            layoutParams.setMargins(0, KL.A0l, 0, 0);
            topMargin = 15;
        }
        if (!this.A0X) {
            ((AbstractC1268Zv) this).A09.setRadius(topMargin);
        }
        layoutParams.addRule(14);
        ((AbstractC1268Zv) this).A09.setLayoutParams(layoutParams);
    }

    private void A08(int i2) {
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.A0U.getLayoutParams();
        if (i2 == 1) {
            layoutParams.removeRule(3);
            if (this.A0J.getVisibility() == 0) {
                layoutParams.addRule(2, this.A0J.getId());
            } else {
                layoutParams.addRule(2, this.A0K.getId());
            }
            layoutParams.setMargins(KL.A0r, 0, KL.A0r, KL.A0p);
        } else {
            layoutParams.removeRule(2);
            layoutParams.addRule(3, ((AbstractC1268Zv) this).A08.getId());
            layoutParams.setMargins(0, KL.A0l, 0, 0);
        }
        this.A0U.setLayoutParams(layoutParams);
    }

    private void A09(int i2) {
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.A0Q.getLayoutParams();
        this.A0Q.setTypeface(Typeface.DEFAULT_BOLD);
        this.A0Q.setTextSize(30.0f);
        int i8 = 0;
        if (i2 == 1) {
            i8 = KL.A0r;
        }
        int horizontalMargin = KL.A0l;
        layoutParams.setMargins(i8, horizontalMargin, i8, 0);
        layoutParams.addRule(14);
        int horizontalMargin2 = ((AbstractC1268Zv) this).A09.getId();
        layoutParams.addRule(3, horizontalMargin2);
        this.A0Q.setLayoutParams(layoutParams);
        this.A0P.setMaxLines(2);
    }

    private void A0A(TextView textView, int i2) {
        if (textView == null || textView.getVisibility() != 0) {
            return;
        }
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) textView.getLayoutParams();
        if (A00[5].length() == 30) {
            throw new RuntimeException();
        }
        A00[2] = "MzAm3HoD6orDxlJQlGTEx6IPe7UcdOUI";
        if (i2 == 1) {
            layoutParams.removeRule(3);
            if (this.A0J.getVisibility() == 0) {
                layoutParams.addRule(2, this.A0J.getId());
            } else {
                layoutParams.addRule(2, this.A0K.getId());
            }
            layoutParams.addRule(5, this.A0U.getId());
        } else {
            layoutParams.removeRule(2);
            if (A00[6].length() != 21) {
                A00[6] = "7zj9JJJnjsPUDa1S35qln";
                layoutParams.removeRule(5);
                layoutParams.addRule(3, this.A0U.getId());
            } else {
                A00[6] = "ItVyc3UmcGyu1CZchDJaM";
                layoutParams.removeRule(5);
                layoutParams.addRule(3, this.A0U.getId());
            }
        }
        layoutParams.setMargins(0, KL.A0u, 0, 0);
        textView.setLayoutParams(layoutParams);
    }

    @Override // com.instagram.common.viewpoint.core.KL, com.instagram.common.viewpoint.core.AbstractC1268Zv
    public final void A0h(int i2) {
        super.A0h(i2);
        XP.A0Z(this.A0N, ((AbstractC1268Zv) this).A09, this.A0Q, this.A0U, ((KL) this).A04, this.A0P, this.A0K, this.A0J, this.A0I);
        A00();
        A07(i2);
        A0A(((KL) this).A04, i2);
        A08(i2);
        A04(i2);
        A03(i2);
        A09(i2);
        A06(i2);
        A02(i2);
        A05(i2);
    }

    @Override // com.instagram.common.viewpoint.core.KL
    public final void A0q(int i2) {
    }

    @Override // com.instagram.common.viewpoint.core.KL
    public final void A0s(ViewGroup viewGroup, RelativeLayout relativeLayout, int i2) {
        if (i2 == 1) {
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) ((AbstractC1268Zv) this).A09.getLayoutParams();
            layoutParams.addRule(3, relativeLayout.getId());
            ((AbstractC1268Zv) this).A09.setLayoutParams(layoutParams);
            viewGroup.addView(((AbstractC1268Zv) this).A09);
            viewGroup.addView(this.A0Q);
            viewGroup.addView(this.A0P);
        }
        A01(i2);
    }
}
