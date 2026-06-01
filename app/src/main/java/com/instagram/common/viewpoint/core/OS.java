package com.instagram.common.viewpoint.core;

import com.ironsource.G5;
import java.util.Arrays;

/* JADX INFO: loaded from: assets/audience_network.dex */
public final class OS<E> implements Cloneable {
    public static byte[] A04;
    public static String[] A05 = {"3rdfmaS4Bvs6KD5DohCaazKJ5nPjrowZ", "nk5cgk6zHA99knZ4VIBWP6swe9j6XVxJ", "SR1GrmmGZb5WiV5DUpa8V4qNmvh", "hXJT0tWkN7S4w3G0a7yWDauM9ZCHUr7o", "HR23fndUBIfy3sX8NPdMDAzNZ7ikzeu", "Yza27yUTeZsQZywWns2Eqk9QSJgdTaNC", "To1PPTsvrqg0vOGGncKBfzj1ovx9xtsA", "AHHllHZ2j6xopeQt7"};
    public static final Object A06;
    public int A00;
    public boolean A01;
    public long[] A02;
    public Object[] A03;

    public static String A03(int i2, int i8, int i9) {
        byte[] bArrCopyOfRange = Arrays.copyOfRange(A04, i2, i2 + i8);
        for (int i10 = 0; i10 < bArrCopyOfRange.length; i10++) {
            bArrCopyOfRange[i10] = (byte) ((bArrCopyOfRange[i10] ^ i9) ^ 104);
        }
        return new String(bArrCopyOfRange);
    }

    public static void A05() {
        A04 = new byte[]{107, 55, 43, 42, 48, 99, 14, 34, 51, 106, 4, 8, 25, 31};
    }

    /* JADX WARN: Failed to parse debug info
    java.lang.ArrayIndexOutOfBoundsException: Index 6 out of bounds for length 6
    	at jadx.plugins.input.dex.sections.debuginfo.DebugInfoParser.startVar(DebugInfoParser.java:203)
    	at jadx.plugins.input.dex.sections.debuginfo.DebugInfoParser.process(DebugInfoParser.java:135)
    	at jadx.plugins.input.dex.sections.DexCodeReader.getDebugInfo(DexCodeReader.java:122)
    	at jadx.core.dex.nodes.MethodNode.getDebugInfo(MethodNode.java:645)
    	at jadx.core.dex.visitors.debuginfo.DebugInfoAttachVisitor.visit(DebugInfoAttachVisitor.java:38)
     */
    public final String toString() {
        if (A06() <= 0) {
            String strA03 = A03(12, 2, 10);
            String[] strArr = A05;
            if (strArr[6].charAt(16) != strArr[5].charAt(16)) {
                throw new RuntimeException();
            }
            String[] strArr2 = A05;
            strArr2[1] = "Skpu9y55M8HCr5nD5qLEIrlUv7DMUr8f";
            strArr2[3] = "83PSjIhGPkyHWD5a17BzKCZMIovhzHLb";
            return strA03;
        }
        StringBuilder sb = new StringBuilder(this.A00 * 28);
        sb.append('{');
        for (int i2 = 0; i2 < this.A00; i2++) {
            if (i2 > 0) {
                sb.append(A03(10, 2, 64));
            }
            sb.append(A00(i2));
            sb.append(G5.T);
            E eA07 = A07(i2);
            if (eA07 != this) {
                sb.append(eA07);
            } else {
                sb.append(A03(0, 10, 43));
            }
        }
        sb.append('}');
        return sb.toString();
    }

    static {
        A05();
        A06 = new Object();
    }

    /* JADX WARN: Generic types in debug info not equals: com.facebook.ads.redexgen.X.OS != com.facebook.ads.internal.androidx.support.v4.util.LongSparseArray<E> */
    public OS() {
        this(10);
    }

    /* JADX WARN: Generic types in debug info not equals: com.facebook.ads.redexgen.X.OS != com.facebook.ads.internal.androidx.support.v4.util.LongSparseArray<E> */
    public OS(int i2) {
        this.A01 = false;
        if (i2 == 0) {
            this.A02 = OR.A02;
            this.A03 = OR.A03;
        } else {
            int iA00 = OR.A00(i2);
            this.A02 = new long[iA00];
            this.A03 = new Object[iA00];
        }
        this.A00 = 0;
    }

    /* JADX WARN: Generic types in debug info not equals: com.facebook.ads.redexgen.X.OS != com.facebook.ads.internal.androidx.support.v4.util.LongSparseArray<E> */
    private final long A00(int i2) {
        if (this.A01) {
            A04();
        }
        return this.A02[i2];
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Generic types in debug info not equals: com.facebook.ads.redexgen.X.OS != com.facebook.ads.internal.androidx.support.v4.util.LongSparseArray<E> */
    /* JADX INFO: renamed from: A01, reason: merged with bridge method [inline-methods] */
    public final OS<E> clone() {
        OS<E> os = null;
        try {
            os = (OS) super.clone();
            os.A02 = (long[]) this.A02.clone();
            os.A03 = (Object[]) this.A03.clone();
            return os;
        } catch (CloneNotSupportedException unused) {
            return os;
        }
    }

    /* JADX WARN: Generic types in debug info not equals: com.facebook.ads.redexgen.X.OS != com.facebook.ads.internal.androidx.support.v4.util.LongSparseArray<E> */
    private final E A02(long j, E e) {
        int iA03 = OR.A03(this.A02, this.A00, j);
        if (iA03 >= 0) {
            Object[] objArr = this.A03;
            if (A05[7].length() != 17) {
                throw new RuntimeException();
            }
            A05[2] = "jXlMUCcAItIj0GcupoJ3Otj";
            if (objArr[iA03] != A06) {
                return (E) this.A03[iA03];
            }
        }
        return e;
    }

    /* JADX WARN: Generic types in debug info not equals: com.facebook.ads.redexgen.X.OS != com.facebook.ads.internal.androidx.support.v4.util.LongSparseArray<E> */
    private void A04() {
        int i2 = this.A00;
        int i8 = 0;
        long[] jArr = this.A02;
        Object[] objArr = this.A03;
        for (int i9 = 0; i9 < i2; i9++) {
            Object obj = objArr[i9];
            if (obj != A06) {
                if (i9 != i8) {
                    jArr[i8] = jArr[i9];
                    objArr[i8] = obj;
                    objArr[i9] = null;
                }
                i8++;
            }
        }
        this.A01 = false;
        this.A00 = i8;
    }

    /* JADX WARN: Generic types in debug info not equals: com.facebook.ads.redexgen.X.OS != com.facebook.ads.internal.androidx.support.v4.util.LongSparseArray<E> */
    public final int A06() {
        if (this.A01) {
            A04();
        }
        int i2 = this.A00;
        String[] strArr = A05;
        if (strArr[6].charAt(16) != strArr[5].charAt(16)) {
            throw new RuntimeException();
        }
        A05[4] = "ypCZ";
        return i2;
    }

    /* JADX WARN: Generic types in debug info not equals: com.facebook.ads.redexgen.X.OS != com.facebook.ads.internal.androidx.support.v4.util.LongSparseArray<E> */
    public final E A07(int i2) {
        if (this.A01) {
            A04();
        }
        return (E) this.A03[i2];
    }

    /* JADX WARN: Generic types in debug info not equals: com.facebook.ads.redexgen.X.OS != com.facebook.ads.internal.androidx.support.v4.util.LongSparseArray<E> */
    public final E A08(long j) {
        return A02(j, null);
    }

    /* JADX WARN: Generic types in debug info not equals: com.facebook.ads.redexgen.X.OS != com.facebook.ads.internal.androidx.support.v4.util.LongSparseArray<E> */
    public final void A09() {
        int i2 = this.A00;
        Object[] objArr = this.A03;
        for (int i8 = 0; i8 < i2; i8++) {
            objArr[i8] = null;
        }
        this.A00 = 0;
        this.A01 = false;
    }

    /* JADX WARN: Generic types in debug info not equals: com.facebook.ads.redexgen.X.OS != com.facebook.ads.internal.androidx.support.v4.util.LongSparseArray<E> */
    public final void A0A(int i2) {
        if (this.A03[i2] != A06) {
            this.A03[i2] = A06;
            this.A01 = true;
        }
    }

    /* JADX WARN: Generic types in debug info not equals: com.facebook.ads.redexgen.X.OS != com.facebook.ads.internal.androidx.support.v4.util.LongSparseArray<E> */
    /* JADX WARN: Removed duplicated region for block: B:18:0x0058  */
    /* JADX WARN: Removed duplicated region for block: B:23:0x007a  */
    /* JADX WARN: Removed duplicated region for block: B:28:0x008a  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void A0B(long r9, E r11) {
        /*
            Method dump skipped, instruction units count: 254
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.instagram.common.viewpoint.core.OS.A0B(long, java.lang.Object):void");
    }
}
