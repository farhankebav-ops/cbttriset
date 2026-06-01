package com.instagram.common.viewpoint.core;

import android.text.TextUtils;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

/* JADX INFO: renamed from: com.facebook.ads.redexgen.X.cm, reason: case insensitive filesystem */
/* JADX INFO: loaded from: assets/audience_network.dex */
public final class C1443cm extends LinearLayout {
    public static final int A04 = (int) (AbstractC1180Wl.A02 * 32.0f);
    public static final int A05 = (int) (AbstractC1180Wl.A02 * 8.0f);
    public TextView A00;
    public TextView A01;
    public C1291aK A02;
    public final C1477dL A03;

    public C1443cm(C1477dL c1477dL) {
        super(c1477dL);
        this.A03 = c1477dL;
        A00(c1477dL);
    }

    private final void A00(C1477dL c1477dL) {
        setGravity(16);
        this.A02 = new C1291aK(c1477dL);
        this.A02.setFullCircleCorners(true);
        LinearLayout.LayoutParams pageImageViewParams = new LinearLayout.LayoutParams(A04, A04);
        pageImageViewParams.setMargins(0, 0, A05, 0);
        addView(this.A02, pageImageViewParams);
        LinearLayout pageInfoView = new LinearLayout(c1477dL);
        pageInfoView.setOrientation(1);
        this.A00 = new TextView(c1477dL);
        ViewGroup.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, -2);
        XP.A0W(this.A00, true, 16);
        this.A00.setEllipsize(TextUtils.TruncateAt.END);
        this.A00.setSingleLine(true);
        this.A01 = new TextView(c1477dL);
        XP.A0W(this.A01, false, 14);
        pageInfoView.addView(this.A00);
        pageInfoView.addView(this.A01);
        addView(pageInfoView, layoutParams);
    }

    public final void A01() {
        this.A02.setImageBitmap(null);
        this.A00.setText("");
        this.A01.setText("");
    }

    public final void A02(int i2, int i8) {
        this.A00.setTextColor(i2);
        this.A01.setTextColor(i8);
    }

    public void setPageDetails(N9 n9) {
        KZ kz = new KZ(this.A02, this.A03);
        kz.A05(A04, A04);
        kz.A07(n9.A01());
        this.A00.setText(n9.A02());
        this.A01.setText(n9.A03());
    }
}
