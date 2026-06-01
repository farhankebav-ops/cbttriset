package com.instagram.common.viewpoint.core;

import android.text.TextUtils;
import android.util.SparseBooleanArray;
import android.view.ViewGroup;
import java.lang.ref.WeakReference;

/* JADX INFO: loaded from: assets/audience_network.dex */
public final class FD extends AbstractC1024Qg implements InterfaceC1215Xu {
    public static String[] A08 = {"biNTtjxa0xULALtZEUOcP", "rMVpYr4hwZgX", "y0rebd1hOaNR", "snwXdVXwO66aPvNuuMD2", "jxkMgVVp1g5", "Dcah1JX", "lglxOXHbCZFpcLf1TWQPAMUDis4zLCZx", "n80A5ryznQOlcAJIvKv7FeLq2ck19EHB"};
    public N3 A00;
    public AbstractC1549eW A01;
    public C1550eX A02;
    public C1550eX A03;
    public final int A04;
    public final SparseBooleanArray A05;
    public final C1477dL A06;
    public final C04995h A07;

    public FD(C04995h c04995h, SparseBooleanArray sparseBooleanArray, C1550eX c1550eX, int i2, C1477dL c1477dL, N3 n32) {
        super(c04995h);
        this.A06 = c1477dL;
        this.A07 = c04995h;
        this.A05 = sparseBooleanArray;
        this.A02 = c1550eX;
        this.A04 = i2;
        this.A00 = n32;
    }

    private void A05(US us, XH xh, String str, C1444cn c1444cn) {
        if (this.A05.get(c1444cn.A02())) {
            return;
        }
        if (this.A03 != null) {
            this.A03.A0V();
            String[] strArr = A08;
            if (strArr[1].length() != strArr[2].length()) {
                throw new RuntimeException();
            }
            String[] strArr2 = A08;
            strArr2[3] = "sEemyGdXpNnP2WRBMWcD";
            strArr2[0] = "kawPFcVLuq3VyedHvbBIc";
            this.A03 = null;
        }
        this.A01 = new FF(this, str, c1444cn, us, c1444cn.A04(), xh);
        this.A03 = new C1550eX(this.A07, 10, new WeakReference(this.A01), this.A06);
        this.A03.A0Y(false);
        this.A03.A0W(100);
        this.A03.A0X(100);
        this.A07.setOnAssetsLoadedListener(new FE(this, c1444cn));
    }

    public final void A0p(C1444cn c1444cn, US us, SF sf, XH xh, String str, int i2, int i8, int i9) {
        int iA02 = c1444cn.A02();
        this.A07.setTag(-1593835536, Integer.valueOf(iA02));
        this.A07.setupNativeCtaExtension(c1444cn);
        ViewGroup.MarginLayoutParams marginLayoutParams = new ViewGroup.MarginLayoutParams(i2, -2);
        int rightMargin = iA02 == 0 ? i9 : i8;
        if (iA02 < this.A04 - 1) {
            i9 = i8;
        }
        String[] strArr = A08;
        if (strArr[1].length() != strArr[2].length()) {
            throw new RuntimeException();
        }
        String[] strArr2 = A08;
        strArr2[1] = "ng4t5bAKqCWK";
        strArr2[2] = "n9xBZs9SEWUc";
        marginLayoutParams.setMargins(rightMargin, 0, i9, 0);
        String strA08 = c1444cn.A03().A0H().A08();
        String strA09 = c1444cn.A03().A0H().A09();
        this.A07.setIsVideo(!TextUtils.isEmpty(strA09));
        if (this.A07.A1T()) {
            this.A07.setVideoPlaceholderUrl(strA08);
            this.A07.setVideoUrl(sf.A0T(strA09));
        } else {
            this.A07.setImageUrl(strA08);
        }
        this.A07.setLayoutParams(marginLayoutParams);
        this.A07.setCTAInfo(c1444cn.A03().A0J(), c1444cn.A04());
        this.A07.A1U(c1444cn.A04());
        A05(us, xh, str, c1444cn);
    }

    public final void A0q(C1550eX c1550eX) {
        this.A02 = c1550eX;
    }

    @Override // com.instagram.common.viewpoint.core.InterfaceC1215Xu
    public final void AIV() {
        this.A07.A1O();
    }
}
