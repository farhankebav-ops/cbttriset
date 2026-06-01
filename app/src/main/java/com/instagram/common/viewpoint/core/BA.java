package com.instagram.common.viewpoint.core;

import com.google.common.collect.ElementTypesAreNonnullByDefault;
import com.google.common.collect.ParametricNullness;
import java.io.Serializable;
import java.util.Arrays;
import javax.annotation.CheckForNull;

/* JADX INFO: loaded from: assets/audience_network.dex */
@ElementTypesAreNonnullByDefault
public final class BA<F, T> extends AbstractC2133oV<F> implements Serializable {
    public static byte[] A02;
    public static String[] A03 = {"qP7uN3CTeBtugcvn4iscvs4NawNVw3hj", "uACvKKD4Xh814PQzJz7fno8Y0d2htzTr", "OaGwUL0wruZXrmXuBUYR8eOdlsWVX5jO", "JY9GX7tPgJ", "UJNVJd39Mn7RrVqRZr4HQjubetYZ2pJj", "tP9Bx5HW1SG5GbSCFf4kAQmgB2SyEv9b", "xcsG1NfXHnFrLoKWAotfCT6bqQ3ToZXO", "wDWfKnr2Hnyq67FaxNzVQD5A0FwwfXbW"};
    public static final long serialVersionUID = 0;
    public final InterfaceC1799ip<F, ? extends T> A00;
    public final AbstractC2133oV<T> A01;

    public static String A00(int i2, int i8, int i9) {
        byte[] bArrCopyOfRange = Arrays.copyOfRange(A02, i2, i2 + i8);
        int i10 = 0;
        while (true) {
            int length = bArrCopyOfRange.length;
            String[] strArr = A03;
            if (strArr[2].charAt(0) == strArr[6].charAt(0)) {
                throw new RuntimeException();
            }
            A03[1] = "UOsr4mSSP3XVk2xA78tBNfMlPB0RSTkt";
            if (i10 >= length) {
                return new String(bArrCopyOfRange);
            }
            bArrCopyOfRange[i10] = (byte) ((bArrCopyOfRange[i10] ^ i9) ^ 5);
            i10++;
        }
    }

    public static void A01() {
        A02 = new byte[]{78, 122, 59, 58, 6, 49, 39, 33, 56, 32, 27, 50, 124};
    }

    /* JADX WARN: Failed to parse debug info
    java.lang.ArrayIndexOutOfBoundsException
     */
    @Override // java.util.Comparator
    public final boolean equals(@CheckForNull Object object) {
        if (object == this) {
            return true;
        }
        if (!(object instanceof BA)) {
            return false;
        }
        BA ba = (BA) object;
        return this.A00.equals(ba.A00) && this.A01.equals(ba.A01);
    }

    static {
        A01();
    }

    /* JADX WARN: Generic types in debug info not equals: com.facebook.ads.redexgen.X.BA != com.google.common.collect.ByFunctionOrdering<F, T> */
    /* JADX WARN: Generic types in debug info not equals: com.facebook.ads.redexgen.X.ip != com.google.common.base.Function<F, ? extends T> */
    /* JADX WARN: Generic types in debug info not equals: com.facebook.ads.redexgen.X.oV != com.google.common.collect.Ordering<T> */
    public BA(InterfaceC1799ip<F, ? extends T> function, AbstractC2133oV<T> ordering) {
        this.A00 = (InterfaceC1799ip) AbstractC1819jA.A04(function);
        this.A01 = (AbstractC2133oV) AbstractC1819jA.A04(ordering);
    }

    /* JADX WARN: Generic types in debug info not equals: com.facebook.ads.redexgen.X.BA != com.google.common.collect.ByFunctionOrdering<F, T> */
    @Override // com.instagram.common.viewpoint.core.AbstractC2133oV, java.util.Comparator
    public final int compare(@ParametricNullness F f4, @ParametricNullness F f8) {
        return this.A01.compare(this.A00.A43(f4), this.A00.A43(f8));
    }

    /* JADX WARN: Generic types in debug info not equals: com.facebook.ads.redexgen.X.BA != com.google.common.collect.ByFunctionOrdering<F, T> */
    public final int hashCode() {
        return BX.A00(this.A00, this.A01);
    }

    /* JADX WARN: Generic types in debug info not equals: com.facebook.ads.redexgen.X.BA != com.google.common.collect.ByFunctionOrdering<F, T> */
    public final String toString() {
        return this.A01 + A00(1, 12, 81) + this.A00 + A00(0, 1, 98);
    }
}
