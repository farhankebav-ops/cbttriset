package com.facebook.ads.internal.view;

import android.graphics.drawable.GradientDrawable;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import androidx.core.view.ViewCompat;
import com.instagram.common.viewpoint.core.AbstractC1180Wl;
import com.instagram.common.viewpoint.core.AbstractC1207Xm;
import com.instagram.common.viewpoint.core.AbstractC1302aV;
import com.instagram.common.viewpoint.core.C0940My;
import com.instagram.common.viewpoint.core.C1120Ua;
import com.instagram.common.viewpoint.core.C1205Xk;
import com.instagram.common.viewpoint.core.C1443cm;
import com.instagram.common.viewpoint.core.C1477dL;
import com.instagram.common.viewpoint.core.InterfaceC1206Xl;
import com.instagram.common.viewpoint.core.InterfaceC1208Xn;
import com.instagram.common.viewpoint.core.KE;
import com.instagram.common.viewpoint.core.N9;
import com.instagram.common.viewpoint.core.NF;
import com.instagram.common.viewpoint.core.ViewOnClickListenerC1217Xw;
import com.instagram.common.viewpoint.core.XP;
import com.instagram.common.viewpoint.core.XX;
import com.instagram.common.viewpoint.core.YG;
import com.instagram.common.viewpoint.core.YO;
import java.util.Arrays;

/* JADX INFO: loaded from: assets/audience_network.dex */
public final class FullScreenAdToolbar extends AbstractC1207Xm {
    public static byte[] A0B;
    public static String[] A0C = {"bFTGQZCDUsZohbmTeIVqSIHEteTzH9ln", "yXw5A2C", "1AgOSkHO0Pb00RrFT9UOiqy", "TxDFqDHdXRoHKl2DTNxbpTLqI26RISWJ", "CWbWmw8OaNX6ff1fhEYiHQW6wjCjGro9", "znIzyGoGhCcdAsXYdQkLlPNG9alZ5sNL", "lf2qO9K", "XEgUxEHpppw1PxIgjlcxmDWHelwWu1Ow"};
    public static final int A0D;
    public static final int A0E;
    public static final int A0F;
    public static final int A0G;
    public static final int A0H;
    public C1205Xk A00;
    public InterfaceC1206Xl A01;
    public InterfaceC1206Xl A02;
    public YG A03;
    public boolean A04;
    public boolean A05;
    public final RelativeLayout A06;
    public final C1120Ua A07;
    public final InterfaceC1208Xn A08;
    public final YO A09;
    public final C1443cm A0A;

    public static String A02(int i2, int i8, int i9) {
        byte[] bArrCopyOfRange = Arrays.copyOfRange(A0B, i2, i2 + i8);
        for (int i10 = 0; i10 < bArrCopyOfRange.length; i10++) {
            bArrCopyOfRange[i10] = (byte) ((bArrCopyOfRange[i10] - i9) - 22);
        }
        return new String(bArrCopyOfRange);
    }

    public static void A03() {
        byte[] bArr = {113, -102, -99, -95, -109, 78, 111, -110, -100, -81, -70, -71, -68, -66, 106, -117, -82, -71, -76, -76, -79, -89, -90, -73};
        if (A0C[5].charAt(20) != 'l') {
            throw new RuntimeException();
        }
        A0C[2] = "ATFpsL3dKIxr1CEZIKZeGPZ";
        A0B = bArr;
    }

    static {
        A03();
        A0D = (int) (AbstractC1180Wl.A02 * 10.0f);
        A0H = (int) (AbstractC1180Wl.A02 * 16.0f);
        A0F = A0H - A0D;
        A0G = (A0H * 2) - A0D;
        A0E = (int) (AbstractC1180Wl.A02 * 4.0f);
    }

    public FullScreenAdToolbar(C1477dL c1477dL, InterfaceC1208Xn interfaceC1208Xn, C1120Ua c1120Ua, int i2, int i8, boolean z2) {
        super(c1477dL);
        this.A01 = null;
        this.A04 = true;
        this.A05 = z2;
        this.A08 = interfaceC1208Xn;
        this.A07 = c1120Ua;
        setGravity(16);
        this.A09 = new YO(c1477dL, i2, z2);
        this.A09.setContentDescription(A02(0, 8, 24));
        this.A09.setActionClickListener(new ViewOnClickListenerC1217Xw(this));
        if (!this.A05) {
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -2);
            layoutParams.setMargins(A0F, A0F, A0G, A0F);
            addView(this.A09, layoutParams);
            this.A06 = new RelativeLayout(c1477dL);
            LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(0, -2);
            layoutParams2.weight = 1.0f;
            this.A0A = new C1443cm(c1477dL);
            XP.A0E(1006, this.A0A);
            LinearLayout.LayoutParams layoutParams3 = new LinearLayout.LayoutParams(-2, -2);
            layoutParams3.gravity = 17;
            this.A0A.setLayoutParams(layoutParams3);
            this.A06.addView(this.A0A);
            addView(this.A06, layoutParams2);
            if (i8 != -1) {
                A0D(c1477dL, i8);
                return;
            }
            return;
        }
        if (i8 != -1) {
            A0D(c1477dL, i8);
        }
        this.A06 = new RelativeLayout(c1477dL);
        LinearLayout.LayoutParams layoutParams4 = new LinearLayout.LayoutParams(0, -2);
        layoutParams4.weight = 1.0f;
        this.A0A = new C1443cm(c1477dL);
        XP.A0E(1006, this.A0A);
        LinearLayout.LayoutParams layoutParams5 = new LinearLayout.LayoutParams(-2, -2);
        layoutParams5.gravity = 17;
        this.A0A.setLayoutParams(layoutParams5);
        this.A06.addView(this.A0A);
        addView(this.A06, layoutParams4);
        LinearLayout.LayoutParams layoutParams6 = new LinearLayout.LayoutParams(-2, -2);
        layoutParams6.setMargins(0, A0H / 2, A0H / 2, A0H / 2);
        addView(this.A09, layoutParams6);
    }

    private void A04(View view, boolean z2) {
        if (view == null) {
            return;
        }
        view.setVisibility(z2 ? 0 : 8);
    }

    @Override // com.instagram.common.viewpoint.core.AbstractC1207Xm
    public final void A06() {
        this.A09.A02();
    }

    @Override // com.instagram.common.viewpoint.core.AbstractC1207Xm
    public final void A07() {
        if (this.A01 != null) {
            this.A02 = this.A01;
        }
    }

    @Override // com.instagram.common.viewpoint.core.AbstractC1207Xm
    public final void A08() {
        this.A01 = getToolbarListener();
    }

    @Override // com.instagram.common.viewpoint.core.AbstractC1207Xm
    public final void A09(float f4, int i2) {
        this.A09.A03(f4, i2);
    }

    @Override // com.instagram.common.viewpoint.core.AbstractC1207Xm
    public final void A0A(C0940My c0940My, boolean z2) {
        boolean z7 = this.A04;
        int iA05 = c0940My.A05(z7);
        this.A0A.A02(c0940My.A0B(z7), iA05);
        boolean z8 = this.A05;
        String strA02 = A02(8, 9, 52);
        if (!z8) {
            if (this.A00 != null) {
                this.A00.setIconColors(iA05);
                this.A00.setContentDescription(strA02);
            }
        } else if (this.A03 != null) {
            this.A03.setIconColors(iA05);
            this.A03.setContentDescription(strA02);
        }
        this.A09.A04(c0940My, z7, z2);
        if (z7) {
            GradientDrawable gradientDrawable = new GradientDrawable(GradientDrawable.Orientation.TOP_BOTTOM, new int[]{-1778384896, 0});
            gradientDrawable.setCornerRadius(0.0f);
            XP.A0Q(this, gradientDrawable);
            boolean fullScreenEnabled = this.A05;
            setReportingViewColor(!fullScreenEnabled ? this.A00 : this.A03);
            return;
        }
        XP.A0K(this, 0);
    }

    @Override // com.instagram.common.viewpoint.core.AbstractC1207Xm
    public final boolean A0B() {
        return this.A09.A05();
    }

    public final void A0C(N9 n9, String str, int i2) {
        this.A09.setInitialUnskippableSeconds(i2);
        if (this.A05) {
            if (this.A03 != null) {
                this.A03.setAdDetails(n9, str, this.A07, this.A08);
            }
        } else {
            if (this.A00 == null) {
                return;
            }
            this.A00.setAdDetails(n9, str, this.A07, this.A08);
        }
    }

    public final void A0D(C1477dL c1477dL, int i2) {
        if (this.A00 != null) {
            XP.A0H(this.A00);
            this.A00.removeAllViews();
        }
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -1);
        if (!this.A05) {
            this.A00 = new C1205Xk(c1477dL, i2);
            layoutParams.setMargins(0, A0H / 2, A0H / 2, A0H / 2);
            addView(this.A00, layoutParams);
        } else {
            this.A03 = new YG(c1477dL);
            layoutParams.setMargins(A0F, A0F, A0G, A0F);
            addView(this.A03, layoutParams);
        }
    }

    @Override // com.instagram.common.viewpoint.core.AbstractC1207Xm
    public int getToolbarActionMode() {
        return this.A09.getToolbarActionMode();
    }

    @Override // com.instagram.common.viewpoint.core.AbstractC1207Xm
    public int getToolbarHeight() {
        return AbstractC1207Xm.A00;
    }

    @Override // com.instagram.common.viewpoint.core.AbstractC1207Xm
    public InterfaceC1206Xl getToolbarListener() {
        return this.A02;
    }

    @Override // com.instagram.common.viewpoint.core.AbstractC1207Xm
    public void setAdReportingVisible(boolean z2) {
        A04(!this.A05 ? this.A00 : this.A03, z2);
    }

    @Override // com.instagram.common.viewpoint.core.AbstractC1207Xm
    public void setCTAClickListener(View.OnClickListener onClickListener) {
        this.A0A.setOnClickListener(onClickListener);
    }

    @Override // com.instagram.common.viewpoint.core.AbstractC1207Xm
    public void setCTAClickListener(KE ke) {
        this.A0A.setOnClickListener(AbstractC1302aV.A03(ke, A02(17, 7, 47)));
    }

    @Override // com.instagram.common.viewpoint.core.AbstractC1207Xm
    public void setFullscreen(boolean z2) {
        this.A04 = z2;
    }

    public void setOnlyPageDetails(N9 n9) {
        if (n9 != null) {
            this.A0A.setPageDetails(n9);
        } else {
            this.A0A.A01();
        }
    }

    @Override // com.instagram.common.viewpoint.core.AbstractC1207Xm
    public void setPageDetails(N9 n9, String str, int i2, NF nf) {
        this.A09.setInitialUnskippableSeconds(i2);
        this.A0A.setPageDetails(n9);
        if (this.A05) {
            if (this.A03 != null) {
                this.A03.setAdDetails(n9, str, this.A07, this.A08);
            }
        } else {
            if (this.A00 == null) {
                return;
            }
            this.A00.setAdDetails(n9, str, this.A07, this.A08);
        }
    }

    @Override // com.instagram.common.viewpoint.core.AbstractC1207Xm
    public void setPageDetailsVisible(boolean z2) {
        this.A06.removeAllViews();
        if (z2) {
            this.A06.addView(this.A0A);
        }
        this.A09.setToolbarMessageEnabled(!z2);
    }

    @Override // com.instagram.common.viewpoint.core.AbstractC1207Xm
    public void setProgress(float f4) {
        this.A09.setProgress(f4);
    }

    @Override // com.instagram.common.viewpoint.core.AbstractC1207Xm
    public void setProgressClickListener(View.OnClickListener onClickListener) {
        this.A09.setProgressClickListener(onClickListener);
    }

    @Override // com.instagram.common.viewpoint.core.AbstractC1207Xm
    public void setProgressImage(XX xx) {
        this.A09.setProgressImage(xx);
    }

    @Override // com.instagram.common.viewpoint.core.AbstractC1207Xm
    public void setProgressImmediate(float f4) {
        this.A09.setProgressImmediate(f4);
    }

    @Override // com.instagram.common.viewpoint.core.AbstractC1207Xm
    public void setProgressSpinnerInvisible(boolean z2) {
        this.A09.setProgressSpinnerInvisible(z2);
    }

    private void setReportingViewColor(View view) {
        if (view != null) {
            XP.A0O(view, 0, ViewCompat.MEASURED_STATE_MASK, A0E);
        }
    }

    @Override // com.instagram.common.viewpoint.core.AbstractC1207Xm
    public void setToolbarActionMessage(String str) {
        this.A09.setToolbarMessage(str);
    }

    @Override // com.instagram.common.viewpoint.core.AbstractC1207Xm
    public void setToolbarActionMode(int i2) {
        this.A09.setToolbarActionMode(i2);
    }

    @Override // com.instagram.common.viewpoint.core.AbstractC1207Xm
    public void setToolbarListener(InterfaceC1206Xl interfaceC1206Xl) {
        this.A02 = interfaceC1206Xl;
    }
}
