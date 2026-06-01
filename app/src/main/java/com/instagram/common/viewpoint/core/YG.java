package com.instagram.common.viewpoint.core;

import android.widget.ImageView;
import android.widget.LinearLayout;

/* JADX INFO: loaded from: assets/audience_network.dex */
public final class YG extends LinearLayout {
    public static final int A03 = (int) (AbstractC1180Wl.A02 * 10.0f);
    public static final int A04 = (int) (AbstractC1180Wl.A02 * 24.0f);
    public final ImageView A00;
    public final O2 A01;
    public final C1477dL A02;

    public YG(C1477dL c1477dL) {
        super(c1477dL);
        this.A02 = c1477dL;
        this.A01 = O3.A00(c1477dL.A02());
        this.A00 = new ImageView(c1477dL);
        A02();
    }

    private void A02() {
        A03(this.A00, XX.REDESIGN_INFO_ICON);
        setPadding(A03, A03 / 3, A03, A03 / 3);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(A04, A04);
        layoutParams.gravity = 16;
        addView(this.A00, layoutParams);
    }

    public static void A03(ImageView imageView, XX xx) {
        imageView.setScaleType(ImageView.ScaleType.FIT_CENTER);
        imageView.setImageBitmap(XY.A01(xx));
        imageView.setColorFilter(-1);
    }

    public void setAdDetails(N9 n9, String str, C1120Ua c1120Ua, InterfaceC1208Xn interfaceC1208Xn) {
        setOnClickListener(new YF(this, c1120Ua, interfaceC1208Xn, str, n9));
    }

    public void setIconColors(int i2) {
        this.A00.setColorFilter(i2);
    }
}
