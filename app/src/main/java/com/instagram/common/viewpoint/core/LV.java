package com.instagram.common.viewpoint.core;

import android.transition.ChangeBounds;
import android.transition.Explode;
import android.transition.TransitionSet;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;

/* JADX INFO: loaded from: assets/audience_network.dex */
public final class LV extends AbstractC1224Yd {
    public static String[] A03 = {"ps9u6Kn8p", "fRCCllxRFm9XYnsS5Nz0CDYYbd8rz98F", "veZY5LUK4HkumILqtvhVtf9OT9QK1Jmh", "8c6Edyt19YE2bwpDp37rWBgdyfN4I4si", "Dgwj6SSLqT", "biYcUlACC5CMDg3zbjwwDR7mq5XP76DA", "rp5V5gFYHfFnaijOqqdMDMWavMrEx7HP", "ycj43TNZcka4uMSCxDz6fuqQ2r9gi3g6"};
    public static final int A04 = (int) (AbstractC1180Wl.A02 * 8.0f);
    public final RelativeLayout A00;
    public final O2 A01;
    public final C1477dL A02;

    public LV(C1477dL c1477dL, US us, String str, N9 n9, InterfaceC1209Xo interfaceC1209Xo, InterfaceC1208Xn interfaceC1208Xn) {
        super(c1477dL, us, str, n9, interfaceC1209Xo, interfaceC1208Xn);
        this.A02 = c1477dL;
        this.A01 = O3.A00(c1477dL.A02());
        this.A00 = new RelativeLayout(getContext());
        addView(this.A00, new RelativeLayout.LayoutParams(-1, -1));
        XP.A0K(this.A00, -1728053248);
        this.A00.setOnClickListener(new ViewOnClickListenerC1229Yi(this));
    }

    public static RelativeLayout.LayoutParams A00(boolean z2) {
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, z2 ? -1 : -2);
        layoutParams.addRule(12);
        return layoutParams;
    }

    private void A01() {
        TransitionSet transitionSet = new TransitionSet();
        transitionSet.setOrdering(0);
        transitionSet.addTransition(new ChangeBounds()).addTransition(new Explode());
        XP.A0T(this, transitionSet);
    }

    @Override // com.instagram.common.viewpoint.core.AbstractC1224Yd
    public final void A0N() {
        O6 o6A0A = this.A01.A0A();
        C1239Ys c1239Ys = new C1239Ys(this.A02);
        c1239Ys.setInfo(XX.HIDE_AD, this.A01.A0H(), this.A01.A0G());
        c1239Ys.setOnClickListener(new ViewOnClickListenerC1230Yj(this));
        O6 o6A0B = this.A01.A0B();
        C1239Ys c1239Ys2 = new C1239Ys(this.A02);
        c1239Ys2.setInfo(XX.REPORT_AD, this.A01.A0L(), this.A01.A0K());
        c1239Ys2.setOnClickListener(new ViewOnClickListenerC1231Yk(this));
        C1239Ys c1239Ys3 = new C1239Ys(this.A02);
        c1239Ys3.setInfo(XX.AD_CHOICES_ICON, this.A01.A0M(), "");
        c1239Ys3.setOnClickListener(new ViewOnClickListenerC1232Yl(this));
        LinearLayout.LayoutParams itemParams = new LinearLayout.LayoutParams(-1, -2);
        LinearLayout linearLayout = new LinearLayout(getContext());
        linearLayout.setClickable(true);
        linearLayout.setOrientation(1);
        linearLayout.setPadding(A04 * 2, A04, A04 * 2, A04);
        XP.A0K(linearLayout, -1);
        if (!o6A0A.A05().isEmpty()) {
            linearLayout.addView(c1239Ys, itemParams);
        }
        if (!o6A0B.A05().isEmpty()) {
            linearLayout.addView(c1239Ys2, itemParams);
        }
        linearLayout.addView(c1239Ys3, itemParams);
        A01();
        this.A00.removeAllViews();
        this.A00.addView(linearLayout, A00(false));
    }

    @Override // com.instagram.common.viewpoint.core.AbstractC1224Yd
    public final void A0O() {
        XP.A0G(this);
        this.A00.removeAllViews();
        XP.A0H(this);
    }

    @Override // com.instagram.common.viewpoint.core.AbstractC1224Yd
    public final void A0P(O6 o62, O4 o42) {
        String strA0E;
        int i2;
        String strA01;
        if (o42 == O4.A05) {
            return;
        }
        boolean z2 = o42 == O4.A06;
        C1222Yb c1222Yb = new C1222Yb(this.A02, this.A0B);
        if (z2) {
            O2 o2 = this.A01;
            if (A03[4].length() != 10) {
                throw new RuntimeException();
            }
            A03[6] = "KfE81dulHFmzGO7NxqDM7oaE1pV2dKkX";
            strA0E = o2.A0F();
        } else {
            strA0E = this.A01.A0E();
        }
        C1222Yb c1222YbA0E = c1222Yb.A0I(strA0E).A0H(this.A01.A0D()).A0F(o62.A04()).A0E(z2 ? XX.REPORT_AD : XX.HIDE_AD);
        if (z2) {
            i2 = -552389;
        } else {
            i2 = -13272859;
        }
        C1222Yb c1222YbA0D = c1222YbA0E.A0D(i2);
        if (this.A0A != null) {
            N9 n9 = this.A0A;
            if (A03[1].charAt(11) != 'X') {
                strA01 = n9.A01();
            } else {
                A03[0] = "vLdx3pZGf";
                strA01 = n9.A01();
            }
        } else {
            strA01 = "";
        }
        C1223Yc adHiddenView = c1222YbA0D.A0G(strA01).A0M();
        XP.A0K(adHiddenView, -1);
        XP.A0R(this);
        this.A00.removeAllViews();
        this.A00.addView(adHiddenView, A00(true));
    }

    @Override // com.instagram.common.viewpoint.core.AbstractC1224Yd
    public final void A0Q(O6 o62, O4 o42) {
        String strA0H;
        boolean z2 = o42 == O4.A06;
        C1477dL c1477dL = this.A02;
        InterfaceC1226Yf interfaceC1226Yf = this.A0B;
        if (z2) {
            strA0H = this.A01.A0L();
        } else {
            strA0H = this.A01.A0H();
        }
        C1242Yv c1242Yv = new C1242Yv(c1477dL, o62, interfaceC1226Yf, strA0H, z2 ? XX.REPORT_AD : XX.HIDE_AD);
        c1242Yv.setClickable(true);
        XP.A0K(c1242Yv, -1);
        c1242Yv.setPadding(A04 * 2, A04, A04 * 2, A04);
        A01();
        this.A00.removeAllViews();
        RelativeLayout relativeLayout = this.A00;
        String[] strArr = A03;
        if (strArr[3].charAt(9) == strArr[5].charAt(9)) {
            throw new RuntimeException();
        }
        A03[1] = "OoQvJ70CiRWXlhIiWSDPNsGTFrOY4nX1";
        relativeLayout.addView(c1242Yv, A00(false));
    }

    @Override // com.instagram.common.viewpoint.core.AbstractC1224Yd
    public final boolean A0R() {
        return false;
    }
}
