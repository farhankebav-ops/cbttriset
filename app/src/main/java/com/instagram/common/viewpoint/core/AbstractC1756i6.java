package com.instagram.common.viewpoint.core;

import android.view.ViewGroup;
import android.widget.ImageView;
import java.util.List;

/* JADX INFO: renamed from: com.facebook.ads.redexgen.X.i6, reason: case insensitive filesystem */
/* JADX INFO: loaded from: assets/audience_network.dex */
public abstract class AbstractC1756i6 extends QC<OB> {
    public static String[] A05 = {"BofGdT", "Cb8B81bPHxSAbCDzy4", "tLXqRIVVg6Ax3ByQPtTHAjuCLXMkMIv2", "Awqy8gsEnlsE3SarczMGKLCzZdtyeG5w", "c95zYEegXXkMe1M4f4KrlDKZ96YYHdKl", "dzB1VPy83al1mBxHBTo", "7fXNgxpNBgLKECdM7L4CyN3WmxsqHAeT", "HUwJOtf8ZOX36MmDYBkOhN0MiSikj2Pg"};
    public static final int A06 = (int) (AbstractC1180Wl.A02 * 4.0f);
    public InterfaceC0927Mk A00;
    public final List<C1020Qc> A01;
    public final int A02;
    public final C1477dL A03;
    public final AbstractC1549eW A04 = new C1759i9(this);

    public AbstractC1756i6(C0L c0l, List<C1020Qc> list, C1477dL c1477dL) {
        this.A03 = c1477dL;
        this.A02 = c0l.getChildSpacing();
        this.A01 = list;
    }

    private ViewGroup.MarginLayoutParams A01(int i2) {
        ViewGroup.MarginLayoutParams marginLayoutParams = new ViewGroup.MarginLayoutParams(-2, -1);
        int i8 = this.A02;
        if (i2 == 0) {
            i8 *= 2;
        }
        int size = this.A01.size() - 1;
        String[] strArr = A05;
        if (strArr[3].charAt(2) == strArr[4].charAt(2)) {
            throw new RuntimeException();
        }
        String[] strArr2 = A05;
        strArr2[7] = "KlchvvVcsY9zV3e8wqzNtTZQscUuxnqD";
        strArr2[1] = "gQBYn2ao1l5plthpQQ";
        marginLayoutParams.setMargins(i8, 0, i2 >= size ? this.A02 * 2 : this.A02, 0);
        return marginLayoutParams;
    }

    @Override // com.instagram.common.viewpoint.core.QC
    public final int A0B() {
        return this.A01.size();
    }

    public final void A0O(ImageView imageView, int i2) {
        C1020Qc c1020Qc = this.A01.get(i2);
        C1135Up adCoverImage = c1020Qc.getAdCoverImage();
        if (adCoverImage != null) {
            KZ kzA04 = new KZ(imageView, this.A03).A04();
            kzA04.A06(new C1758i8(this, i2, c1020Qc));
            kzA04.A07(adCoverImage.getUrl());
        }
    }

    public final void A0P(InterfaceC0927Mk interfaceC0927Mk) {
        this.A00 = interfaceC0927Mk;
    }

    public void A0Q(OB ob, int i2) {
        ob.A0p().setLayoutParams(A01(i2));
    }
}
