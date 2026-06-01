package com.instagram.common.viewpoint.core;

import java.io.Serializable;
import java.util.Arrays;
import java.util.List;
import javax.annotation.CheckForNull;

/* JADX INFO: loaded from: assets/audience_network.dex */
public class BR<T> implements InterfaceC1820jB<T>, Serializable {
    public static byte[] A01;
    public static final long serialVersionUID = 0;
    public final List<? extends InterfaceC1820jB<? super T>> A00;

    static {
        A01();
    }

    public static String A00(int i2, int i8, int i9) {
        byte[] bArrCopyOfRange = Arrays.copyOfRange(A01, i2, i2 + i8);
        for (int i10 = 0; i10 < bArrCopyOfRange.length; i10++) {
            bArrCopyOfRange[i10] = (byte) ((bArrCopyOfRange[i10] - i9) - 99);
        }
        return new String(bArrCopyOfRange);
    }

    public static void A01() {
        A01 = new byte[]{52, 65, 55};
    }

    /* JADX WARN: Generic types in debug info not equals: com.facebook.ads.redexgen.X.BR != com.google.common.base.Predicates$AndPredicate<T> */
    public BR(List<? extends InterfaceC1820jB<? super T>> components) {
        this.A00 = components;
    }

    /* JADX WARN: Generic types in debug info not equals: com.facebook.ads.redexgen.X.BR != com.google.common.base.Predicates$AndPredicate<T> */
    /* JADX WARN: Incorrect condition in loop: B:4:0x0007 */
    @Override // com.instagram.common.viewpoint.core.InterfaceC1820jB
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final boolean A44(@com.google.common.base.ParametricNullness T r3) {
        /*
            r2 = this;
            r1 = 0
        L1:
            java.util.List<? extends com.facebook.ads.redexgen.X.jB<? super T>> r0 = r2.A00
            int r0 = r0.size()
            if (r1 >= r0) goto L1c
            java.util.List<? extends com.facebook.ads.redexgen.X.jB<? super T>> r0 = r2.A00
            java.lang.Object r0 = r0.get(r1)
            com.facebook.ads.redexgen.X.jB r0 = (com.instagram.common.viewpoint.core.InterfaceC1820jB) r0
            boolean r0 = r0.A44(r3)
            if (r0 != 0) goto L19
            r0 = 0
            return r0
        L19:
            int r1 = r1 + 1
            goto L1
        L1c:
            r0 = 1
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.instagram.common.viewpoint.core.BR.A44(java.lang.Object):boolean");
    }

    /* JADX WARN: Generic types in debug info not equals: com.facebook.ads.redexgen.X.BR != com.google.common.base.Predicates$AndPredicate<?> */
    /* JADX WARN: Generic types in debug info not equals: com.facebook.ads.redexgen.X.BR != com.google.common.base.Predicates$AndPredicate<T> */
    public final boolean equals(@CheckForNull Object obj) {
        if (obj instanceof BR) {
            return this.A00.equals(((BR) obj).A00);
        }
        return false;
    }

    /* JADX WARN: Generic types in debug info not equals: com.facebook.ads.redexgen.X.BR != com.google.common.base.Predicates$AndPredicate<T> */
    public final int hashCode() {
        return this.A00.hashCode() + 306654252;
    }

    /* JADX WARN: Generic types in debug info not equals: com.facebook.ads.redexgen.X.BR != com.google.common.base.Predicates$AndPredicate<T> */
    public final String toString() {
        return AbstractC1822jD.A02(A00(0, 3, 112), this.A00);
    }
}
