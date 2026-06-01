package com.instagram.common.viewpoint.core;

import android.graphics.Typeface;
import android.view.View;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import androidx.core.view.ViewCompat;
import java.util.HashMap;
import java.util.Locale;

/* JADX INFO: renamed from: com.facebook.ads.redexgen.X.bJ, reason: case insensitive filesystem */
/* JADX INFO: loaded from: assets/audience_network.dex */
public final class C1352bJ extends FrameLayout {
    public final int A00;
    public final RelativeLayout A01;
    public final KE A02;
    public static final int A05 = (int) (AbstractC1180Wl.A02 * 36.0f);
    public static final int A06 = (int) (AbstractC1180Wl.A02 * 36.0f);
    public static final int A03 = (int) (AbstractC1180Wl.A02 * 23.0f);
    public static final int A04 = (int) (AbstractC1180Wl.A02 * 3.0f);
    public static final int A07 = (int) (AbstractC1180Wl.A02 * 4.0f);

    public C1352bJ(C1477dL c1477dL, KE ke, AbstractC1752hy abstractC1752hy, US us, InterfaceC1208Xn interfaceC1208Xn, C1550eX c1550eX, XH xh, C0940My c0940My, InterfaceC1277a4 interfaceC1277a4) {
        super(c1477dL);
        this.A00 = c0940My.A09(true);
        this.A01 = new RelativeLayout(c1477dL);
        addView(this.A01, new FrameLayout.LayoutParams(-1, -1));
        this.A01.setClickable(false);
        A01(c1477dL, abstractC1752hy.A20().A0J().A04());
        if (ke == null) {
            this.A02 = new KE(c1477dL, abstractC1752hy.A0r(), (C0940My) null, us, interfaceC1208Xn, c1550eX, xh, abstractC1752hy.A21());
        } else {
            this.A02 = ke;
        }
        A03();
        this.A02.setCta(abstractC1752hy.A20().A0J(), abstractC1752hy.A25(), new HashMap(), interfaceC1277a4);
        this.A02.setIsInAppBrowser(true);
        FrameLayout.LayoutParams ctaButtonParams = new FrameLayout.LayoutParams(-1, -1);
        addView(this.A02, ctaButtonParams);
    }

    private void A00(C1477dL c1477dL, View view) {
        ImageView imageView = new ImageView(c1477dL);
        imageView.setImageBitmap(XY.A01(XX.MINIMIZE_ARROW));
        imageView.setRotation(180.0f);
        imageView.setClickable(false);
        imageView.setColorFilter(this.A00);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(A03, A03);
        imageView.setPadding(A04, A04, A04, A04);
        layoutParams.addRule(2, view.getId());
        layoutParams.addRule(14);
        this.A01.addView(imageView, layoutParams);
    }

    private void A01(C1477dL c1477dL, String str) {
        Button button = new Button(c1477dL);
        XP.A0I(button);
        button.setPadding(A06, 0, A06, 0);
        button.setText(str.toUpperCase(Locale.getDefault()));
        button.setTextSize(14.0f);
        button.setTypeface(Typeface.defaultFromStyle(1));
        XP.A0M(button, this.A00, A07);
        button.setTextColor(ViewCompat.MEASURED_STATE_MASK);
        RelativeLayout.LayoutParams ctaParams = new RelativeLayout.LayoutParams(-2, A05);
        ctaParams.addRule(12);
        ctaParams.addRule(14);
        this.A01.addView(button, ctaParams);
        A00(c1477dL, button);
    }

    public final ME A02(String str) {
        return this.A02.A0E(str);
    }

    public final void A03() {
        this.A02.setBackgroundColor(0);
        this.A02.setTextColor(0);
    }

    @Override // android.view.View
    public final boolean performClick() {
        return this.A02.performClick();
    }

    public void setAutoClickTime(AbstractC1752hy abstractC1752hy, AbstractC1207Xm abstractC1207Xm) {
        this.A02.A0F(abstractC1752hy, abstractC1207Xm);
    }

    public void setCta(C0941Mz c0941Mz, String str, HashMap<String, String> extras, InterfaceC1277a4 interfaceC1277a4) {
        this.A02.setCta(c0941Mz, str, extras, interfaceC1277a4);
    }
}
