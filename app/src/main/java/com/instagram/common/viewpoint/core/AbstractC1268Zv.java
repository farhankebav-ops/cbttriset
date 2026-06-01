package com.instagram.common.viewpoint.core;

import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import java.util.Arrays;
import java.util.HashMap;

/* JADX INFO: renamed from: com.facebook.ads.redexgen.X.Zv, reason: case insensitive filesystem */
/* JADX INFO: loaded from: assets/audience_network.dex */
public abstract class AbstractC1268Zv extends LinearLayout {
    public static byte[] A0A;
    public static final LinearLayout.LayoutParams A0B;
    public LinearLayout A00;
    public TextView A01;
    public String A02;
    public boolean A03;
    public final int A04;
    public final View.OnClickListener A05;
    public final RelativeLayout A06;
    public final C1477dL A07;
    public final KE A08;
    public final C1291aK A09;

    public static String A0d(int i2, int i8, int i9) {
        byte[] bArrCopyOfRange = Arrays.copyOfRange(A0A, i2, i2 + i8);
        for (int i10 = 0; i10 < bArrCopyOfRange.length; i10++) {
            bArrCopyOfRange[i10] = (byte) ((bArrCopyOfRange[i10] - i9) - 11);
        }
        return new String(bArrCopyOfRange);
    }

    public static void A0e() {
        A0A = new byte[]{-96, -93, -93, -92, -77, -96, -88, -85, -78};
    }

    public abstract void A0h(int i2);

    static {
        A0e();
        A0B = new LinearLayout.LayoutParams(-2, -2);
    }

    public AbstractC1268Zv(C1477dL c1477dL, KE ke, int i2, C0940My c0940My, boolean z2, String str, US us, InterfaceC1208Xn interfaceC1208Xn, C1550eX c1550eX, XH xh, N3 n32, boolean z7, String str2) {
        super(c1477dL);
        this.A02 = A0d(0, 0, 37);
        XP.A0I(this);
        this.A07 = c1477dL;
        this.A04 = i2;
        this.A03 = z7;
        this.A02 = str2;
        this.A09 = new C1291aK(c1477dL);
        XP.A0K(this.A09, 0);
        XP.A0I(this.A09);
        if (z7) {
            this.A00 = new LinearLayout(c1477dL);
            this.A01 = new TextView(c1477dL);
            XP.A0I(this.A01);
        }
        if (ke == null) {
            this.A08 = new KE(c1477dL, str, c0940My, z2, us, interfaceC1208Xn, c1550eX, xh, n32);
        } else {
            this.A08 = ke;
        }
        XP.A0E(1001, this.A08);
        this.A05 = AbstractC1302aV.A03(this.A08, A0d(0, 9, 52));
        this.A06 = new RelativeLayout(c1477dL);
        this.A06.setLayoutParams(A0B);
        XP.A0I(this.A06);
    }

    public void A0f() {
    }

    public void A0g() {
        this.A09.setOnClickListener(this.A05);
    }

    public final KE getCTAButton() {
        return this.A08;
    }

    public View getExpandableLayout() {
        return null;
    }

    public final ImageView getIconView() {
        return this.A09;
    }

    public void setInfo(C0938Mw c0938Mw, C0941Mz c0941Mz, String str, String str2, InterfaceC1190Wv interfaceC1190Wv, InterfaceC1277a4 interfaceC1277a4) {
        this.A08.setCta(c0941Mz, str, new HashMap(), interfaceC1190Wv, interfaceC1277a4);
        new KZ(this.A09, this.A07).A05(this.A04, this.A04).A07(str2);
    }

    public void setTitleMaxLines(int i2) {
    }
}
