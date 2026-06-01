package com.instagram.common.viewpoint.core;

import android.view.View;
import android.view.ViewGroup;
import java.util.Arrays;

/* JADX INFO: renamed from: com.facebook.ads.redexgen.X.g9, reason: case insensitive filesystem */
/* JADX INFO: loaded from: assets/audience_network.dex */
public class C1648g9 implements InterfaceC1003Pl {
    public static byte[] A01;
    public final /* synthetic */ C05246g A00;

    static {
        A01();
    }

    public static String A00(int i2, int i8, int i9) {
        byte[] bArrCopyOfRange = Arrays.copyOfRange(A01, i2, i2 + i8);
        for (int i10 = 0; i10 < bArrCopyOfRange.length; i10++) {
            bArrCopyOfRange[i10] = (byte) ((bArrCopyOfRange[i10] - i9) - 72);
        }
        return new String(bArrCopyOfRange);
    }

    public static void A01() {
        A01 = new byte[]{-26, 4, 15, 15, 8, 7, -61, 4, 23, 23, 4, 6, 11, -61, 18, 17, -61, 4, -61, 6, 11, 12, 15, 7, -61, 26, 11, 12, 6, 11, -61, 12, 22, -61, 17, 18, 23, -61, 7, 8, 23, 4, 6, 11, 8, 7, -35, -61, -53, -55, -44, -44, -51, -52, -120, -52, -51, -36, -55, -53, -48, -120, -41, -42, -120, -55, -42, -120, -55, -44, -38, -51, -55, -52, -31, -120, -52, -51, -36, -55, -53, -48, -51, -52, -120, -53, -48, -47, -44, -52, -120};
    }

    public C1648g9(C05246g c05246g) {
        this.A00 = c05246g;
    }

    @Override // com.instagram.common.viewpoint.core.InterfaceC1003Pl
    public final void A4C(View view, int i2, ViewGroup.LayoutParams layoutParams) {
        AbstractC1024Qg abstractC1024QgA0F = C05246g.A0F(view);
        if (abstractC1024QgA0F != null) {
            if (abstractC1024QgA0F.A0i() || abstractC1024QgA0F.A0l()) {
                abstractC1024QgA0F.A0V();
            } else {
                throw new IllegalArgumentException(A00(0, 48, 91) + abstractC1024QgA0F + this.A00.A1J());
            }
        }
        this.A00.attachViewToParent(view, i2, layoutParams);
    }

    @Override // com.instagram.common.viewpoint.core.InterfaceC1003Pl
    public final void A5o(int i2) {
        AbstractC1024Qg abstractC1024QgA0F;
        View view = A79(i2);
        if (view != null && (abstractC1024QgA0F = C05246g.A0F(view)) != null) {
            if (!abstractC1024QgA0F.A0i() || abstractC1024QgA0F.A0l()) {
                abstractC1024QgA0F.A0Z(256);
            } else {
                throw new IllegalArgumentException(A00(48, 43, 32) + abstractC1024QgA0F + this.A00.A1J());
            }
        }
        this.A00.detachViewFromParent(i2);
    }

    @Override // com.instagram.common.viewpoint.core.InterfaceC1003Pl
    public final View A79(int i2) {
        return this.A00.getChildAt(i2);
    }

    @Override // com.instagram.common.viewpoint.core.InterfaceC1003Pl
    public final int A7A() {
        return this.A00.getChildCount();
    }

    @Override // com.instagram.common.viewpoint.core.InterfaceC1003Pl
    public final AbstractC1024Qg A7D(View view) {
        return C05246g.A0F(view);
    }

    @Override // com.instagram.common.viewpoint.core.InterfaceC1003Pl
    public final int A9z(View view) {
        return this.A00.indexOfChild(view);
    }

    @Override // com.instagram.common.viewpoint.core.InterfaceC1003Pl
    public final void ADA(View view) {
        AbstractC1024Qg abstractC1024QgA0F = C05246g.A0F(view);
        if (abstractC1024QgA0F != null) {
            abstractC1024QgA0F.A0D(this.A00);
        }
    }

    @Override // com.instagram.common.viewpoint.core.InterfaceC1003Pl
    public final void ADv(View view) {
        AbstractC1024Qg abstractC1024QgA0F = C05246g.A0F(view);
        if (abstractC1024QgA0F != null) {
            abstractC1024QgA0F.A0E(this.A00);
        }
    }

    @Override // com.instagram.common.viewpoint.core.InterfaceC1003Pl
    public final void AHg() {
        int iA7A = A7A();
        for (int i2 = 0; i2 < iA7A; i2++) {
            View viewA79 = A79(i2);
            this.A00.A1g(viewA79);
            viewA79.clearAnimation();
        }
        this.A00.removeAllViews();
    }

    @Override // com.instagram.common.viewpoint.core.InterfaceC1003Pl
    public final void AHm(int i2) {
        View childAt = this.A00.getChildAt(i2);
        if (childAt != null) {
            this.A00.A1g(childAt);
            childAt.clearAnimation();
        }
        this.A00.removeViewAt(i2);
    }

    @Override // com.instagram.common.viewpoint.core.InterfaceC1003Pl
    public final void addView(View view, int i2) {
        this.A00.addView(view, i2);
        this.A00.A1f(view);
    }
}
