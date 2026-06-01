package com.instagram.common.viewpoint.core;

import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ScrollView;
import java.util.Arrays;

/* JADX INFO: loaded from: assets/audience_network.dex */
public final class LS extends AbstractC1224Yd {
    public static byte[] A05;
    public static final int A06;
    public static final int A07;
    public static final int A08;
    public final ImageView A00;
    public final LinearLayout A01;
    public final ScrollView A02;
    public final O2 A03;
    public final C1477dL A04;

    public static String A00(int i2, int i8, int i9) {
        byte[] bArrCopyOfRange = Arrays.copyOfRange(A05, i2, i2 + i8);
        for (int i10 = 0; i10 < bArrCopyOfRange.length; i10++) {
            bArrCopyOfRange[i10] = (byte) ((bArrCopyOfRange[i10] - i9) - 24);
        }
        return new String(bArrCopyOfRange);
    }

    public static void A01() {
        A05 = new byte[]{-52, -21, -19, -11, 120, -95, -92, -88, -102, 85, 118, -103, 85, -121, -102, -91, -92, -89, -87, -98, -93, -100};
    }

    static {
        A01();
        A08 = (int) (AbstractC1180Wl.A02 * 8.0f);
        A07 = (int) (AbstractC1180Wl.A02 * 10.0f);
        A06 = (int) (AbstractC1180Wl.A02 * 44.0f);
    }

    public LS(C1477dL c1477dL, US us, String str) {
        super(c1477dL, us, str);
        this.A04 = c1477dL;
        this.A03 = O3.A00(this.A04.A02());
        this.A00 = new ImageView(getContext());
        this.A00.setPadding(A07, A07, A07, A07);
        this.A00.setColorFilter(-10459280);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(A06, A06);
        layoutParams.gravity = 3;
        this.A00.setLayoutParams(layoutParams);
        this.A02 = new ScrollView(getContext());
        this.A02.setFillViewport(true);
        XP.A0K(this.A02, -218103809);
        this.A01 = new LinearLayout(getContext());
        this.A01.setOrientation(1);
        this.A01.setPadding(A08, A08, A08, A08);
        this.A02.addView(this.A01, new FrameLayout.LayoutParams(-1, -2));
        addView(this.A02, new FrameLayout.LayoutParams(-1, -1));
    }

    @Override // com.instagram.common.viewpoint.core.AbstractC1224Yd
    public final void A0N() {
        this.A00.setImageBitmap(XY.A01(XX.CROSS));
        this.A00.setOnClickListener(new ViewOnClickListenerC1243Yw(this));
        this.A00.setContentDescription(A00(4, 18, 29));
        C1228Yh c1228Yh = new C1228Yh(this.A04);
        c1228Yh.setData(this.A03.A0H(), XX.HIDE_AD);
        c1228Yh.setOnClickListener(new ViewOnClickListenerC1244Yx(this, c1228Yh));
        C1228Yh c1228Yh2 = new C1228Yh(this.A04);
        c1228Yh2.setData(this.A03.A0L(), XX.REPORT_AD);
        c1228Yh2.setOnClickListener(new ViewOnClickListenerC1245Yy(this, c1228Yh2));
        C1228Yh c1228Yh3 = new C1228Yh(this.A04);
        c1228Yh3.setData(this.A03.A0M(), XX.AD_CHOICES_ICON);
        c1228Yh3.setOnClickListener(new ViewOnClickListenerC1246Yz(this, c1228Yh3));
        LinearLayout.LayoutParams menuParams = new LinearLayout.LayoutParams(-2, -2);
        menuParams.setMargins(A08, A08, A08, A08);
        menuParams.gravity = 17;
        LinearLayout linearLayout = new LinearLayout(getContext());
        linearLayout.setOrientation(1);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, 0);
        layoutParams.gravity = 17;
        layoutParams.weight = 1.0f;
        XP.A0R(this.A01);
        this.A01.removeAllViews();
        this.A01.addView(this.A00);
        this.A01.addView(linearLayout, layoutParams);
        linearLayout.addView(c1228Yh, menuParams);
        linearLayout.addView(c1228Yh2, menuParams);
        linearLayout.addView(c1228Yh3, menuParams);
    }

    @Override // com.instagram.common.viewpoint.core.AbstractC1224Yd
    public final void A0O() {
        XP.A0G(this);
        XP.A0H(this);
    }

    @Override // com.instagram.common.viewpoint.core.AbstractC1224Yd
    public final void A0P(O6 o62, O4 o42) {
        String strA0H;
        XX xx;
        int i2;
        this.A00.setOnClickListener(null);
        if (o42 == O4.A06) {
            strA0H = this.A03.A0F();
            xx = XX.REPORT_AD;
            i2 = -552389;
        } else {
            strA0H = this.A03.A0H();
            xx = XX.HIDE_AD;
            i2 = -13272859;
        }
        C1222Yb c1222YbA0I = new C1222Yb(this.A04, this.A0B).A0I(strA0H);
        String title = this.A03.A0D();
        C1222Yb c1222YbA0H = c1222YbA0I.A0H(title);
        String title2 = o62.A04();
        C1223Yc adHiddenView = c1222YbA0H.A0F(title2).A0K(false).A0E(xx).A0D(i2).A0L(false).A0J(false).A0M();
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, 0);
        layoutParams.gravity = 17;
        layoutParams.weight = 1.0f;
        XP.A0R(this.A01);
        this.A02.fullScroll(33);
        this.A01.removeAllViews();
        this.A01.addView(adHiddenView, layoutParams);
    }

    @Override // com.instagram.common.viewpoint.core.AbstractC1224Yd
    public final void A0Q(O6 o62, O4 o42) {
        boolean isReportFlow = o42 == O4.A06;
        C1242Yv c1242Yv = new C1242Yv(this.A04, o62, this.A0B, isReportFlow ? XX.REPORT_AD : XX.HIDE_AD);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, 0);
        layoutParams.gravity = 17;
        layoutParams.weight = 1.0f;
        this.A00.setImageBitmap(XY.A01(XX.BACK_ARROW));
        this.A00.setOnClickListener(new Z0(this));
        this.A00.setContentDescription(A00(0, 4, 114));
        XP.A0R(this.A01);
        this.A02.fullScroll(33);
        this.A01.removeAllViews();
        this.A01.addView(this.A00);
        this.A01.addView(c1242Yv, layoutParams);
    }

    @Override // com.instagram.common.viewpoint.core.AbstractC1224Yd
    public final boolean A0R() {
        return true;
    }
}
