package com.instagram.common.viewpoint.core;

import android.view.View;
import android.widget.LinearLayout;
import java.util.Arrays;

/* JADX INFO: renamed from: com.facebook.ads.redexgen.X.Nr, reason: case insensitive filesystem */
/* JADX INFO: loaded from: assets/audience_network.dex */
public final class C0959Nr extends AbstractC1207Xm {
    public static byte[] A03;
    public C1477dL A00;
    public InterfaceC1206Xl A01;
    public final YQ A02;

    static {
        A05();
    }

    public static String A02(int i2, int i8, int i9) {
        byte[] bArrCopyOfRange = Arrays.copyOfRange(A03, i2, i2 + i8);
        for (int i10 = 0; i10 < bArrCopyOfRange.length; i10++) {
            bArrCopyOfRange[i10] = (byte) ((bArrCopyOfRange[i10] - i9) - 75);
        }
        return new String(bArrCopyOfRange);
    }

    public static void A05() {
        A03 = new byte[]{-75, -34, -31, -27, -41, -110, -77, -42};
    }

    public C0959Nr(C1477dL c1477dL, InterfaceC1208Xn interfaceC1208Xn, C1120Ua c1120Ua, int i2) {
        super(c1477dL);
        this.A00 = c1477dL;
        setGravity(16);
        A04();
        this.A02 = new YQ(this.A00, i2);
        A03();
    }

    private void A03() {
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -2);
        this.A02.setContentDescription(A02(0, 8, 39));
        this.A02.setActionClickListener(new ViewOnClickListenerC1218Xx(this));
        addView(this.A02, layoutParams);
    }

    private void A04() {
        View view = new View(this.A00);
        view.setLayoutParams(new LinearLayout.LayoutParams(0, 0, 1.0f));
        addView(view);
    }

    @Override // com.instagram.common.viewpoint.core.AbstractC1207Xm
    public final void A06() {
    }

    @Override // com.instagram.common.viewpoint.core.AbstractC1207Xm
    public final void A07() {
    }

    @Override // com.instagram.common.viewpoint.core.AbstractC1207Xm
    public final void A08() {
    }

    @Override // com.instagram.common.viewpoint.core.AbstractC1207Xm
    public final void A09(float f4, int i2) {
    }

    @Override // com.instagram.common.viewpoint.core.AbstractC1207Xm
    public final void A0A(C0940My c0940My, boolean z2) {
    }

    @Override // com.instagram.common.viewpoint.core.AbstractC1207Xm
    public final boolean A0B() {
        return false;
    }

    @Override // com.instagram.common.viewpoint.core.AbstractC1207Xm
    public int getToolbarActionMode() {
        return this.A02.getToolbarActionMode();
    }

    @Override // com.instagram.common.viewpoint.core.AbstractC1207Xm
    public int getToolbarHeight() {
        return AbstractC1207Xm.A01;
    }

    @Override // com.instagram.common.viewpoint.core.AbstractC1207Xm
    public InterfaceC1206Xl getToolbarListener() {
        return null;
    }

    @Override // com.instagram.common.viewpoint.core.AbstractC1207Xm
    public void setAdReportingVisible(boolean z2) {
    }

    @Override // com.instagram.common.viewpoint.core.AbstractC1207Xm
    public void setCTAClickListener(View.OnClickListener onClickListener) {
    }

    @Override // com.instagram.common.viewpoint.core.AbstractC1207Xm
    public void setCTAClickListener(KE ke) {
    }

    @Override // com.instagram.common.viewpoint.core.AbstractC1207Xm
    public void setFullscreen(boolean z2) {
    }

    public void setInitialUnskippableSeconds(int i2) {
        this.A02.setInitialUnskippableSeconds(i2);
    }

    @Override // com.instagram.common.viewpoint.core.AbstractC1207Xm
    public void setPageDetails(N9 n9, String str, int i2, NF nf) {
        this.A02.setInitialUnskippableSeconds(i2);
    }

    @Override // com.instagram.common.viewpoint.core.AbstractC1207Xm
    public void setPageDetailsVisible(boolean z2) {
    }

    @Override // com.instagram.common.viewpoint.core.AbstractC1207Xm
    public void setProgress(float f4) {
    }

    @Override // com.instagram.common.viewpoint.core.AbstractC1207Xm
    public void setProgressClickListener(View.OnClickListener onClickListener) {
    }

    @Override // com.instagram.common.viewpoint.core.AbstractC1207Xm
    public void setProgressImage(XX xx) {
    }

    @Override // com.instagram.common.viewpoint.core.AbstractC1207Xm
    public void setProgressImmediate(float f4) {
    }

    @Override // com.instagram.common.viewpoint.core.AbstractC1207Xm
    public void setProgressSpinnerInvisible(boolean z2) {
    }

    @Override // com.instagram.common.viewpoint.core.AbstractC1207Xm
    public void setToolbarActionMessage(String str) {
    }

    @Override // com.instagram.common.viewpoint.core.AbstractC1207Xm
    public void setToolbarActionMode(int i2) {
        this.A02.setToolbarActionMode(i2);
    }

    @Override // com.instagram.common.viewpoint.core.AbstractC1207Xm
    public void setToolbarListener(InterfaceC1206Xl interfaceC1206Xl) {
        this.A01 = interfaceC1206Xl;
    }
}
