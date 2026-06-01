package com.instagram.common.viewpoint.core;

import android.view.View;

/* JADX INFO: renamed from: com.facebook.ads.redexgen.X.g0, reason: case insensitive filesystem */
/* JADX INFO: loaded from: assets/audience_network.dex */
public abstract class AbstractC1640g0 extends QK {
    public static String[] A01 = {"ofgeN", "GcYePxlnDkyLzFZQt8gXTfFAd", "bIohWxIGlUqKJ41hMBKnFxYrg", "ROugplE3NXuve66PKoPS6E1ZAyp", "eD20R2wAf", "s8oLKbIochRuLWrY7HR296xJjla", "faP6eJ6K6STeOEuOEXCJ6OuUaXzDbpLW", "oXM2gF3tn"};
    public boolean A00 = true;

    public abstract boolean A0X(AbstractC1024Qg abstractC1024Qg);

    public abstract boolean A0Y(AbstractC1024Qg abstractC1024Qg);

    public abstract boolean A0Z(AbstractC1024Qg abstractC1024Qg, int i2, int i8, int i9, int i10);

    public abstract boolean A0a(AbstractC1024Qg abstractC1024Qg, AbstractC1024Qg abstractC1024Qg2, int i2, int i8, int i9, int i10);

    @Override // com.instagram.common.viewpoint.core.QK
    public final boolean A0N(AbstractC1024Qg abstractC1024Qg) {
        return !this.A00 || abstractC1024Qg.A0f();
    }

    @Override // com.instagram.common.viewpoint.core.QK
    public final boolean A0O(AbstractC1024Qg abstractC1024Qg, QJ qj, QJ qj2) {
        if (qj != null && (qj.A01 != qj2.A01 || qj.A03 != qj2.A03)) {
            return A0Z(abstractC1024Qg, qj.A01, qj.A03, qj2.A01, qj2.A03);
        }
        return A0X(abstractC1024Qg);
    }

    @Override // com.instagram.common.viewpoint.core.QK
    public final boolean A0P(AbstractC1024Qg abstractC1024Qg, QJ qj, QJ qj2) {
        int i2 = qj.A01;
        int oldLeft = qj.A03;
        View view = abstractC1024Qg.A0H;
        int oldTop = qj2 == null ? view.getLeft() : qj2.A01;
        String[] strArr = A01;
        if (strArr[7].length() != strArr[4].length()) {
            throw new RuntimeException();
        }
        String[] strArr2 = A01;
        strArr2[7] = "jyZdeafgD";
        strArr2[4] = "NUmje91r8";
        int top = qj2 == null ? view.getTop() : qj2.A03;
        if (!abstractC1024Qg.A0g() && (i2 != oldTop || oldLeft != top)) {
            view.layout(oldTop, top, view.getWidth() + oldTop, view.getHeight() + top);
            return A0Z(abstractC1024Qg, i2, oldLeft, oldTop, top);
        }
        return A0Y(abstractC1024Qg);
    }

    @Override // com.instagram.common.viewpoint.core.QK
    public final boolean A0Q(AbstractC1024Qg abstractC1024Qg, QJ qj, QJ qj2) {
        if (qj.A01 != qj2.A01 || qj.A03 != qj2.A03) {
            return A0Z(abstractC1024Qg, qj.A01, qj.A03, qj2.A01, qj2.A03);
        }
        A0U(abstractC1024Qg);
        return false;
    }

    @Override // com.instagram.common.viewpoint.core.QK
    public final boolean A0R(AbstractC1024Qg abstractC1024Qg, AbstractC1024Qg abstractC1024Qg2, QJ qj, QJ qj2) {
        int i2;
        int i8;
        int i9 = qj.A01;
        int i10 = qj.A03;
        if (abstractC1024Qg2.A0l()) {
            i2 = qj.A01;
            i8 = qj.A03;
        } else {
            i2 = qj2.A01;
            i8 = qj2.A03;
        }
        return A0a(abstractC1024Qg, abstractC1024Qg2, i9, i10, i2, i8);
    }

    public final void A0T(AbstractC1024Qg abstractC1024Qg) {
        A0K(abstractC1024Qg);
    }

    public final void A0U(AbstractC1024Qg abstractC1024Qg) {
        A0K(abstractC1024Qg);
    }

    public final void A0V(AbstractC1024Qg abstractC1024Qg) {
        A0K(abstractC1024Qg);
    }

    public final void A0W(AbstractC1024Qg abstractC1024Qg, boolean z2) {
        A0K(abstractC1024Qg);
    }
}
