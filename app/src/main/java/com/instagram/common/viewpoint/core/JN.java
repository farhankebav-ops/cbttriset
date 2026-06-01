package com.instagram.common.viewpoint.core;

import android.util.SparseArray;

/* JADX INFO: loaded from: assets/audience_network.dex */
public final class JN {
    public final int A00;
    public final int A01;
    public final int A02;
    public final int A03;
    public final int A04;
    public final int A05;
    public final int A06;
    public final int A07;
    public final int A08;
    public final SparseArray<JO> A09;
    public final boolean A0A;

    public JN(int i2, boolean z2, int i8, int i9, int i10, int i11, int i12, int i13, int i14, int i15, SparseArray<JO> sparseArray) {
        this.A03 = i2;
        this.A0A = z2;
        this.A08 = i8;
        this.A02 = i9;
        this.A04 = i10;
        this.A01 = i11;
        this.A00 = i12;
        this.A07 = i13;
        this.A06 = i14;
        this.A05 = i15;
        this.A09 = sparseArray;
    }

    public final void A00(JN jn) {
        SparseArray<JO> sparseArray = jn.A09;
        for (int i2 = 0; i2 < sparseArray.size(); i2++) {
            SparseArray<JO> sparseArray2 = this.A09;
            int i8 = sparseArray.keyAt(i2);
            sparseArray2.put(i8, sparseArray.valueAt(i2));
        }
    }
}
