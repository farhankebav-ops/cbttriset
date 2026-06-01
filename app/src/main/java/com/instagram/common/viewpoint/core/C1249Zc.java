package com.instagram.common.viewpoint.core;

import android.widget.RelativeLayout;
import com.vungle.ads.internal.protos.Sdk;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/* JADX INFO: renamed from: com.facebook.ads.redexgen.X.Zc, reason: case insensitive filesystem */
/* JADX INFO: loaded from: assets/audience_network.dex */
public final class C1249Zc extends RelativeLayout {
    public static InterfaceC1208Xn A05;
    public static byte[] A06;
    public static final int A07;
    public static final int A08;
    public static final int A09;
    public AbstractC1638fy A00;
    public C1477dL A01;
    public C0K A02;
    public LE A03;
    public C1290aJ A04;

    public static String A00(int i2, int i8, int i9) {
        byte[] bArrCopyOfRange = Arrays.copyOfRange(A06, i2, i2 + i8);
        for (int i10 = 0; i10 < bArrCopyOfRange.length; i10++) {
            bArrCopyOfRange[i10] = (byte) ((bArrCopyOfRange[i10] ^ i9) ^ 60);
        }
        return new String(bArrCopyOfRange);
    }

    public static void A02() {
        A06 = new byte[]{2, 32, 51, 46, 52, 50, 36, 45, 97, 15, 32, 53, 40, 55, 36, 97, 55, 40, 36, 54, 97, 32, 37, 36, 49, 53, 36, 51, 97, 40, 50, 47, 102, 53, 97, 34, 51, 36, 32, 53, 36, 37, 97, 49, 51, 46, 49, 36, 51, 45, 56, 67, 65, 74, 65, 86, 77, 71};
    }

    static {
        A02();
        A08 = (int) (AbstractC1180Wl.A02 * 8.0f);
        A07 = A08 * 10;
        A09 = (int) (AbstractC1180Wl.A02 * 15.0f);
        A05 = new LD();
    }

    public C1249Zc(C1477dL c1477dL) {
        super(c1477dL);
        this.A01 = c1477dL;
        this.A02 = new C0K(c1477dL);
        XP.A0I(this.A02);
        this.A00 = new C05256h();
        this.A00.A0G(this.A02);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -1);
        layoutParams.addRule(13);
        addView(this.A02, layoutParams);
    }

    private ArrayList<C1444cn> A01(AbstractC1752hy abstractC1752hy) {
        if (abstractC1752hy == null) {
            return new ArrayList<>();
        }
        List<C0931Mp> listA27 = abstractC1752hy.A27();
        ArrayList<C1444cn> arrayList = new ArrayList<>(listA27.size());
        for (int i2 = 0; i2 < listA27.size(); i2++) {
            arrayList.add(new C1444cn(i2, listA27.size(), listA27.get(i2)));
        }
        return arrayList;
    }

    public final void A04() {
        this.A02.setAdapter(null);
    }

    public final void A05(C1020Qc c1020Qc, int i2) {
        ArrayList<C1444cn> arrayListA01 = A01(c1020Qc.A10());
        this.A02.setCardsInfo(arrayListA01);
        this.A03 = new LE(this.A01, arrayListA01, c1020Qc.A10(), this.A01.A02().A0A(), c1020Qc, A05, c1020Qc.A10().A25(), this.A02.getCarouselCardBehaviorHelper(), null);
        this.A02.setAdapter(this.A03);
        if (i2 == 0) {
            i2 = AbstractC1180Wl.A04.widthPixels;
        }
        this.A03.A0O(i2 - A07, 16, 0);
        this.A03.A0G();
        setupDotsLayout(c1020Qc, arrayListA01);
    }

    public final void A06(C1550eX c1550eX) {
        if (this.A03 != null) {
            this.A03.A0P(c1550eX);
        } else {
            this.A01.A08().AAy(A00(51, 7, 24), AbstractC1090Sv.A1v, new C1091Sw(A00(0, 51, Sdk.SDKError.Reason.INVALID_METRICS_ENDPOINT_VALUE)));
        }
        this.A02.A20(c1550eX);
    }

    public static InterfaceC1208Xn getDummyListener() {
        return A05;
    }

    @Override // android.widget.RelativeLayout, android.view.ViewGroup, android.view.View
    public final void onLayout(boolean z2, int i2, int i8, int i9, int i10) {
        if (z2 && this.A03 != null) {
            this.A03.A0O((i9 - i2) - A07, 16, 0);
        }
        super.onLayout(z2, i2, i8, i9, i10);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setUpLayoutForCardAtIndex(int i2) {
        if (this.A04 != null) {
            this.A04.A00(i2);
        }
    }

    private void setupDotsLayout(C1020Qc c1020Qc, ArrayList<C1444cn> arrayList) {
        this.A02.getCarouselCardBehaviorHelper().A0Y(new L5(this));
        this.A04 = new C1290aJ(this.A01, c1020Qc.A10().A1z().A01(), arrayList.size());
        XP.A0I(this.A04);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -2);
        layoutParams.addRule(3, this.A02.getId());
        layoutParams.setMargins(0, A09, 0, 0);
        addView(this.A04, layoutParams);
    }
}
