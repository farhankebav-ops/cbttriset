package com.instagram.common.viewpoint.core;

import android.util.SparseArray;

/* JADX INFO: loaded from: assets/audience_network.dex */
public final class D2<V> {
    public static String[] A03 = {"wnvxif6ytcBGtz0Mqv5PMSHqncXz0DK7", "L7XB5FnCPhx5DqxmHlZAG0IW", "W7hvMAjIuj2lsI", "WrlikZWMylRqaSPi0Ibe0HqhEkIhSSyj", "po5n5kVohPdvLQNJ9M8nO8P4vS7WmOX1", "qra4pPEOgaq041jIiRoYAjwA6HXH5OR", "0kvmHOBdOwqUCsJ2namrKa5OUETi", "Uzr0GTjpGam7FLw5cJa3iEu5W45H5eya"};
    public int A00;
    public final SparseArray<V> A01;
    public final C3X<V> A02;

    /* JADX WARN: Failed to parse debug info
    java.lang.ArrayIndexOutOfBoundsException: Index 7 out of bounds for length 7
    	at jadx.plugins.input.dex.sections.debuginfo.DebugInfoParser.startVar(DebugInfoParser.java:203)
    	at jadx.plugins.input.dex.sections.debuginfo.DebugInfoParser.process(DebugInfoParser.java:135)
    	at jadx.plugins.input.dex.sections.DexCodeReader.getDebugInfo(DexCodeReader.java:122)
    	at jadx.core.dex.nodes.MethodNode.getDebugInfo(MethodNode.java:645)
    	at jadx.core.dex.visitors.debuginfo.DebugInfoAttachVisitor.visit(DebugInfoAttachVisitor.java:38)
     */
    public final void A05(int i2, V v2) {
        if (this.A00 == -1) {
            C3M.A08(this.A01.size() == 0);
            this.A00 = 0;
        }
        if (this.A01.size() > 0) {
            int iKeyAt = this.A01.keyAt(this.A01.size() - 1);
            C3M.A07(i2 >= iKeyAt);
            if (iKeyAt == i2) {
                this.A02.A31(this.A01.valueAt(this.A01.size() - 1));
            }
        }
        this.A01.append(i2, v2);
    }

    /* JADX WARN: Generic types in debug info not equals: com.facebook.ads.redexgen.X.D2 != com.facebook.ads.androidx.media3.exoplayer.source.SpannedData<V> */
    public D2() {
        this(new C3X() { // from class: com.facebook.ads.redexgen.X.mC
            @Override // com.instagram.common.viewpoint.core.C3X
            public final void A31(Object obj) {
            }
        });
    }

    /* JADX WARN: Generic types in debug info not equals: com.facebook.ads.redexgen.X.3X != com.facebook.ads.androidx.media3.common.util.Consumer<V> */
    /* JADX WARN: Generic types in debug info not equals: com.facebook.ads.redexgen.X.D2 != com.facebook.ads.androidx.media3.exoplayer.source.SpannedData<V> */
    public D2(C3X<V> c3x) {
        this.A01 = new SparseArray<>();
        this.A02 = c3x;
        this.A00 = -1;
    }

    /* JADX WARN: Generic types in debug info not equals: com.facebook.ads.redexgen.X.D2 != com.facebook.ads.androidx.media3.exoplayer.source.SpannedData<V> */
    public final V A00() {
        return this.A01.valueAt(this.A01.size() - 1);
    }

    /* JADX WARN: Generic types in debug info not equals: com.facebook.ads.redexgen.X.D2 != com.facebook.ads.androidx.media3.exoplayer.source.SpannedData<V> */
    public final V A01(int i2) {
        if (this.A00 == -1) {
            this.A00 = 0;
        }
        while (this.A00 > 0 && i2 < this.A01.keyAt(this.A00)) {
            this.A00--;
        }
        while (this.A00 < this.A01.size() - 1 && i2 >= this.A01.keyAt(this.A00 + 1)) {
            int i8 = this.A00;
            String[] strArr = A03;
            if (strArr[2].length() == strArr[7].length()) {
                break;
            }
            String[] strArr2 = A03;
            strArr2[2] = "5gSetCnK4GRsLk";
            strArr2[7] = "9X4w0tOvMLq1romZr5jnatJ22c9uDFke";
            this.A00 = i8 + 1;
        }
        V vValueAt = this.A01.valueAt(this.A00);
        String[] strArr3 = A03;
        if (strArr3[2].length() != strArr3[7].length()) {
            A03[4] = "mGDCyGfOZW37eucZgDEYXrj36iZYXBw1";
            return vValueAt;
        }
        throw new RuntimeException();
    }

    /* JADX WARN: Generic types in debug info not equals: com.facebook.ads.redexgen.X.D2 != com.facebook.ads.androidx.media3.exoplayer.source.SpannedData<V> */
    public final void A02() {
        for (int i2 = 0; i2 < this.A01.size(); i2++) {
            this.A02.A31(this.A01.valueAt(i2));
        }
        this.A00 = -1;
        this.A01.clear();
    }

    /* JADX WARN: Generic types in debug info not equals: com.facebook.ads.redexgen.X.D2 != com.facebook.ads.androidx.media3.exoplayer.source.SpannedData<V> */
    public final void A03(int i2) {
        for (int size = this.A01.size() - 1; size >= 0 && i2 < this.A01.keyAt(size); size--) {
            this.A02.A31(this.A01.valueAt(size));
            this.A01.removeAt(size);
        }
        this.A00 = this.A01.size() > 0 ? Math.min(this.A00, this.A01.size() - 1) : -1;
    }

    /* JADX WARN: Generic types in debug info not equals: com.facebook.ads.redexgen.X.D2 != com.facebook.ads.androidx.media3.exoplayer.source.SpannedData<V> */
    public final void A04(int i2) {
        for (int i8 = 0; i8 < this.A01.size() - 1 && i2 >= this.A01.keyAt(i8 + 1); i8++) {
            this.A02.A31(this.A01.valueAt(i8));
            this.A01.removeAt(i8);
            if (this.A00 > 0) {
                this.A00--;
            }
        }
    }

    /* JADX WARN: Generic types in debug info not equals: com.facebook.ads.redexgen.X.D2 != com.facebook.ads.androidx.media3.exoplayer.source.SpannedData<V> */
    public final boolean A06() {
        return this.A01.size() == 0;
    }
}
