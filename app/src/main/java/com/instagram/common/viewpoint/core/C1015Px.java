package com.instagram.common.viewpoint.core;

import java.util.Comparator;

/* JADX INFO: renamed from: com.facebook.ads.redexgen.X.Px, reason: case insensitive filesystem */
/* JADX INFO: loaded from: assets/audience_network.dex */
public class C1015Px implements Comparator<C1016Py> {
    public static String[] A00 = {"RlDlwXS4AA55AOqx8zmN7uoMQ4", "FglEZvMIBCB6z", "AxTekMmYmWDdJoDxuavW255zDNKNRAPE", "pDpvZxom4p5NfzWuwibdxFCyrgD8wKok", "A10HdUhRMRjxQ62diLF5JQ0qPoODY0oj", "HiaacAz8KFEe90RKULVJfn7mD15J7Igj", "NHRqTP3H9N0qm1ewn1pnzRz0iIE8sZVk", "d5VyinGL3JDhuqMz7l90vG32rgbNgkhM"};

    /* JADX INFO: Access modifiers changed from: private */
    @Override // java.util.Comparator
    /* JADX INFO: renamed from: A00, reason: merged with bridge method [inline-methods] */
    public final int compare(C1016Py c1016Py, C1016Py c1016Py2) {
        if ((c1016Py.A03 == null) != (c1016Py2.A03 == null)) {
            C05246g c05246g = c1016Py.A03;
            if (A00[1].length() == 18) {
                throw new RuntimeException();
            }
            String[] strArr = A00;
            strArr[7] = "WTdcF3CBINcFCy4xHoe1W3dXr7HqLtJl";
            strArr[3] = "sYvRb4Jfa5Xca5GLbtDoWdBBrccl9kaR";
            return c05246g == null ? 1 : -1;
        }
        if (c1016Py.A04 != c1016Py2.A04) {
            return c1016Py.A04 ? -1 : 1;
        }
        int i2 = c1016Py2.A02 - c1016Py.A02;
        if (i2 != 0) {
            return i2;
        }
        int i8 = c1016Py.A00;
        int deltaViewVelocity = c1016Py2.A00;
        int i9 = i8 - deltaViewVelocity;
        if (i9 != 0) {
            return i9;
        }
        return 0;
    }
}
