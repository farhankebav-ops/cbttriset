package com.instagram.common.viewpoint.core;

import android.text.TextUtils;
import android.widget.LinearLayout;
import android.widget.TextView;

/* JADX INFO: loaded from: assets/audience_network.dex */
public final class Mn extends AbstractC1268Zv {
    public final TextView A00;
    public final TextView A01;
    public static final int A02 = (int) (AbstractC1180Wl.A02 * 36.0f);
    public static final int A05 = (int) (AbstractC1180Wl.A02 * 4.0f);
    public static final int A03 = (int) (AbstractC1180Wl.A02 * 8.0f);
    public static final int A04 = (int) (AbstractC1180Wl.A02 * 4.0f);

    public Mn(C1477dL c1477dL, int i2, C0940My c0940My, boolean z2, String str, US us, InterfaceC1208Xn interfaceC1208Xn, C1550eX c1550eX, XH xh, N3 n32) {
        super(c1477dL, null, i2, c0940My, z2, str, us, interfaceC1208Xn, c1550eX, xh, n32, false, "");
        setOrientation(0);
        setPadding(A05, A05, A05, A05);
        this.A01 = A01(-16448251, 13, true);
        this.A00 = A01(-10131605, 12, false);
        this.A06.addView(A00(i2), new LinearLayout.LayoutParams(-1, -2));
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(0, -2);
        layoutParams.weight = 1.0f;
        addView(this.A06, layoutParams);
        this.A08.setPadding(A03, 0, A03, 0);
        LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(-2, A02);
        layoutParams2.gravity = 17;
        addView(this.A08, layoutParams2);
    }

    private LinearLayout A00(int i2) {
        LinearLayout linearLayout = new LinearLayout(this.A07);
        linearLayout.setOrientation(1);
        linearLayout.setPadding(A04, 0, A04, 0);
        linearLayout.addView(this.A01, AbstractC1268Zv.A0B);
        linearLayout.addView(this.A00, AbstractC1268Zv.A0B);
        LinearLayout linearLayout2 = new LinearLayout(this.A07);
        linearLayout2.setOrientation(0);
        linearLayout2.addView(this.A09, new LinearLayout.LayoutParams(i2, i2));
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, -2);
        layoutParams.gravity = 16;
        linearLayout2.addView(linearLayout, layoutParams);
        return linearLayout2;
    }

    private TextView A01(int i2, int i8, boolean z2) {
        TextView textView = new TextView(this.A07);
        textView.setTextColor(i2);
        textView.setSingleLine(true);
        textView.setEllipsize(TextUtils.TruncateAt.END);
        XP.A0W(textView, z2, i8);
        return textView;
    }

    @Override // com.instagram.common.viewpoint.core.AbstractC1268Zv
    public final void A0g() {
        super.A0g();
        setOnClickListener(this.A05);
    }

    @Override // com.instagram.common.viewpoint.core.AbstractC1268Zv
    public final void A0h(int i2) {
    }

    @Override // com.instagram.common.viewpoint.core.AbstractC1268Zv
    public void setInfo(C0938Mw c0938Mw, C0941Mz c0941Mz, String str, String str2, InterfaceC1190Wv interfaceC1190Wv, InterfaceC1277a4 interfaceC1277a4) {
        super.setInfo(c0938Mw, c0941Mz, str, str2, interfaceC1190Wv, interfaceC1277a4);
        this.A01.setText(c0938Mw.A0F());
        this.A00.setText(c0938Mw.A0E());
        if (TextUtils.isEmpty(c0941Mz.A04())) {
            XP.A0F(this.A08);
        }
    }
}
