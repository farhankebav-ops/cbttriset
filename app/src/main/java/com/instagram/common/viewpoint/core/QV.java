package com.instagram.common.viewpoint.core;

import android.util.SparseArray;
import java.util.ArrayList;

/* JADX INFO: loaded from: assets/audience_network.dex */
public class QV {
    public SparseArray<QU> A00 = new SparseArray<>();
    public int A01 = 0;

    private final long A00(long j, long j3) {
        if (j == 0) {
            return j3;
        }
        return ((j / 4) * 3) + (j3 / 4);
    }

    private QU A01(int i2) {
        QU qu = this.A00.get(i2);
        if (qu == null) {
            QU qu2 = new QU();
            this.A00.put(i2, qu2);
            return qu2;
        }
        return qu;
    }

    /* JADX WARN: Incorrect condition in loop: B:4:0x0007 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private final void A02() {
        /*
            r2 = this;
            r1 = 0
        L1:
            android.util.SparseArray<com.facebook.ads.redexgen.X.QU> r0 = r2.A00
            int r0 = r0.size()
            if (r1 >= r0) goto L19
            android.util.SparseArray<com.facebook.ads.redexgen.X.QU> r0 = r2.A00
            java.lang.Object r0 = r0.valueAt(r1)
            com.facebook.ads.redexgen.X.QU r0 = (com.instagram.common.viewpoint.core.QU) r0
            java.util.ArrayList<com.facebook.ads.redexgen.X.Qg> r0 = r0.A03
            r0.clear()
            int r1 = r1 + 1
            goto L1
        L19:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.instagram.common.viewpoint.core.QV.A02():void");
    }

    public final AbstractC1024Qg A03(int i2) {
        QU qu = this.A00.get(i2);
        if (qu != null && !qu.A03.isEmpty()) {
            return qu.A03.remove(r1.size() - 1);
        }
        return null;
    }

    public final void A04() {
        this.A01--;
    }

    public final void A05(int i2, long j) {
        QU quA01 = A01(i2);
        quA01.A01 = A00(quA01.A01, j);
    }

    public final void A06(int i2, long j) {
        QU quA01 = A01(i2);
        quA01.A02 = A00(quA01.A02, j);
    }

    public final void A07(QC qc) {
        this.A01++;
    }

    public final void A08(QC qc, QC qc2, boolean z2) {
        if (qc != null) {
            A04();
        }
        if (!z2 && this.A01 == 0) {
            A02();
        }
        if (qc2 != null) {
            A07(qc2);
        }
    }

    public final void A09(AbstractC1024Qg abstractC1024Qg) {
        int iA0N = abstractC1024Qg.A0N();
        ArrayList<AbstractC1024Qg> arrayList = A01(iA0N).A03;
        int i2 = this.A00.get(iA0N).A00;
        int viewType = arrayList.size();
        if (i2 <= viewType) {
            return;
        }
        abstractC1024Qg.A0W();
        arrayList.add(abstractC1024Qg);
    }

    public final boolean A0A(int i2, long j, long j3) {
        long j8 = A01(i2).A01;
        return j8 == 0 || j + j8 < j3;
    }

    public final boolean A0B(int i2, long j, long j3) {
        long j8 = A01(i2).A02;
        return j8 == 0 || j + j8 < j3;
    }
}
