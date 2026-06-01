package com.instagram.common.viewpoint.core;

import android.graphics.drawable.GradientDrawable;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.DecelerateInterpolator;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

/* JADX INFO: renamed from: com.facebook.ads.redexgen.X.cX, reason: case insensitive filesystem */
/* JADX INFO: loaded from: assets/audience_network.dex */
public final class C1428cX extends LinearLayout {
    public LinearLayout A00;
    public String A01;
    public boolean A02;
    public final int A03;
    public final C1477dL A04;
    public final C1291aK A05;
    public final C1297aQ A06;
    public static String[] A07 = {"mO6OCzz183u1Bigulq5KeRnnu3UhUErY", "M8wuVwCqg47swjluxOTBwYkXCALJOS1f", "isO3a6yeUrEqJHaKmCFaV", "J8y0fQZRtVpgz1Itec1cmA3ue79eN13N", "z6IigVxY2j2waSprQRCf4749VcxJv5uz", "GG3OTiE6t7MwpY", "UBA0QA1YjTXejDlGkh9vREu7YbW4o1hK", "iNB15eFG13fee2"};
    public static final int A0A = (int) (AbstractC1180Wl.A02 * 16.0f);
    public static final int A0B = (int) (AbstractC1180Wl.A02 * 32.0f);
    public static final int A0C = (int) (AbstractC1180Wl.A02 * 16.0f);
    public static final int A09 = (int) (AbstractC1180Wl.A02 * 4.0f);
    public static final int A08 = (int) (AbstractC1180Wl.A02 * 72.0f);

    public C1428cX(C1426cV c1426cV) {
        super(c1426cV.A08);
        this.A02 = false;
        this.A01 = "";
        this.A04 = c1426cV.A08;
        this.A05 = new C1291aK(this.A04);
        this.A06 = new C1297aQ(this.A04, c1426cV.A01, true, false, true);
        this.A03 = c1426cV.A00;
        this.A02 = c1426cV.A05;
        this.A01 = c1426cV.A04;
        A03(c1426cV);
    }

    public /* synthetic */ C1428cX(C1426cV c1426cV, C0753Fr c0753Fr) {
        this(c1426cV);
    }

    private void A00() {
        A01(this.A05, 150);
        A01(this.A06, 170);
        if (this.A00 != null) {
            A01(this.A00, 190);
        }
    }

    private void A01(View view, int i2) {
        view.setTranslationY(i2);
        view.setScaleY(0.75f);
        view.setScaleX(0.75f);
        view.animate().translationYBy(-i2).scaleX(1.0f).scaleY(1.0f).setDuration(300L).setInterpolator(new DecelerateInterpolator(2.0f));
    }

    private void A02(C1426cV c1426cV) {
        if (!TextUtils.isEmpty(c1426cV.A03)) {
            this.A00 = new LinearLayout(getContext());
            this.A00.setGravity(17);
            int i2 = A0C / 2;
            if (this.A02) {
                i2 = 0;
            }
            LinearLayout linearLayout = this.A00;
            int i8 = A0C;
            int i9 = A0C;
            int marginTop = A0C;
            linearLayout.setPadding(i8, i2, i9, marginTop / 2);
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -2);
            layoutParams.setMargins(0, i2, 0, 0);
            TextView textView = new TextView(getContext());
            textView.setTextColor(-1);
            XP.A0W(textView, false, 16);
            textView.setText(c1426cV.A03);
            LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(-2, -2);
            ImageView imageView = new ImageView(getContext());
            new KZ(imageView, this.A04).A04().A07(c1426cV.A02);
            int i10 = A0A;
            int marginTop2 = A0A;
            LinearLayout.LayoutParams informativeContainerParams = new LinearLayout.LayoutParams(i10, marginTop2);
            int marginTop3 = A0C;
            informativeContainerParams.setMargins(0, 0, marginTop3 / 2, 0);
            if (this.A02) {
                C1285aE c1285aE = new C1285aE(getContext(), 0, -1, XX.PLAYABLE_ICON);
                c1285aE.setLayoutParams(new LinearLayout.LayoutParams(A0B, A0B));
                this.A00.addView(c1285aE);
            } else {
                this.A00.addView(imageView, informativeContainerParams);
                this.A00.addView(textView, layoutParams2);
                GradientDrawable gradientDrawable = new GradientDrawable();
                gradientDrawable.setCornerRadius(100.0f);
                gradientDrawable.setColor(469762047);
                XP.A0Q(this.A00, gradientDrawable);
            }
            View view = this.A00;
            String[] strArr = A07;
            String str = strArr[5];
            String str2 = strArr[7];
            int length = str.length();
            int marginTop4 = str2.length();
            if (length != marginTop4) {
                throw new RuntimeException();
            }
            String[] strArr2 = A07;
            strArr2[0] = "6JdK2pyeEPUWkfGuYxPy07w26kgdYt9J";
            strArr2[1] = "5VEwQONd4c8VI19uC0Ib5tVL9YvIxUH6";
            addView(view, layoutParams);
        }
    }

    private void A03(C1426cV c1426cV) {
        XP.A0K(this.A05, 0);
        this.A05.setRadius(50);
        if (!this.A02) {
            if (c1426cV.A06.A00() == EnumC0936Mu.A05) {
                this.A05.setFullCircleCorners(true);
            } else {
                C1291aK c1291aK = this.A05;
                int i2 = A09;
                String[] strArr = A07;
                if (strArr[5].length() != strArr[7].length()) {
                    throw new RuntimeException();
                }
                A07[2] = "avcxrBXnTsgV2I5Ie1k2l";
                c1291aK.setRadius(i2);
            }
        } else {
            this.A05.setRadius(A09);
        }
        new KZ(this.A05, this.A04).A04().A07(c1426cV.A07.A01());
        this.A06.A04(c1426cV.A06.A0F(), c1426cV.A07.A03(), null, false, true);
        if (!this.A02) {
            this.A06.getDescriptionTextView().setAlpha(0.8f);
        } else {
            this.A06.getDescriptionTextView().setText(this.A01);
        }
        this.A06.setAlignment(17);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -2);
        layoutParams.setMargins(0, A0C, 0, A0C / 2);
        View view = this.A05;
        ViewGroup.LayoutParams titleAndDescriptionParams = new LinearLayout.LayoutParams(A08, A08);
        addView(view, titleAndDescriptionParams);
        addView(this.A06, layoutParams);
        A02(c1426cV);
        XP.A0K(this, -14473425);
        setGravity(17);
        setOrientation(1);
    }

    public final void A04(InterfaceC1427cW interfaceC1427cW) {
        A00();
        postDelayed(new C0753Fr(this, interfaceC1427cW), this.A03);
    }
}
