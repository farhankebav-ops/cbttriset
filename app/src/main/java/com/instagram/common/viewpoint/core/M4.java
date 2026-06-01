package com.instagram.common.viewpoint.core;

import androidx.core.location.LocationRequestCompat;
import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.TreeSet;

/* JADX INFO: loaded from: assets/audience_network.dex */
public final class M4 {
    public static byte[] A05;
    public static String[] A06 = {"nQDli3B322dNyuNUEmcA1lNjVYYmcThQ", "JG8wfEU3nZ2EADYXO0uZDMHFqmVSkpWr", "8K0NmfCVVugnhGVgpCD", "5JHmUKWu4ei3dzUY0lNr", "xKwnuhTKVDH3YhaAiUGpqwLltg47C3CG", "Jcwv8MY0", "vBOLiuiZ", "hny3hth3cGmNH4IG9ndqfAmzri4VXjHL"};
    public C1802is A00;
    public final int A01;
    public final String A02;
    public final ArrayList<M3> A03;
    public final TreeSet<C1800iq> A04;

    public static String A00(int i2, int i8, int i9) {
        byte[] bArrCopyOfRange = Arrays.copyOfRange(A05, i2, i2 + i8);
        for (int i10 = 0; i10 < bArrCopyOfRange.length; i10++) {
            bArrCopyOfRange[i10] = (byte) ((bArrCopyOfRange[i10] - i9) - 47);
        }
        return new String(bArrCopyOfRange);
    }

    public static void A01() {
        A05 = new byte[]{115, -57, -62, 115, -100, -70, -68, -63, -66, -67, -100, -56, -57, -51, -66, -57, -51, -57, -30, -22, -19, -26, -27, -95, -11, -16, -95, -13, -26, -17, -30, -18, -26, -95};
    }

    static {
        A01();
    }

    public M4(int i2, String str) {
        this(i2, str, C1802is.A03);
    }

    public M4(int i2, String str, C1802is c1802is) {
        this.A01 = i2;
        this.A02 = str;
        this.A00 = c1802is;
        this.A04 = new TreeSet<>();
        this.A03 = new ArrayList<>();
    }

    public final long A02(long j, long j3) {
        boolean z2 = true;
        C3M.A07(j >= 0);
        if (j3 < 0) {
            z2 = false;
        }
        C3M.A07(z2);
        C1800iq c1800iqA04 = A04(j, j3);
        if (c1800iqA04.A03()) {
            return -Math.min(c1800iqA04.A04() ? LocationRequestCompat.PASSIVE_INTERVAL : c1800iqA04.A01, j3);
        }
        long j8 = j + j3;
        if (j8 < 0) {
            j8 = LocationRequestCompat.PASSIVE_INTERVAL;
        }
        long currentEndPosition = c1800iqA04.A02 + c1800iqA04.A01;
        if (currentEndPosition < j8) {
            TreeSet<C1800iq> treeSet = this.A04;
            String[] strArr = A06;
            if (strArr[5].length() != strArr[6].length()) {
                throw new RuntimeException();
            }
            String[] strArr2 = A06;
            strArr2[2] = "31viDRwdD8ErVcI5dXS";
            strArr2[3] = "q1k4diPGE3D0s4ujqDJA";
            for (C1800iq c1800iq : treeSet.tailSet(c1800iqA04, false)) {
                if (c1800iq.A02 > currentEndPosition) {
                    break;
                }
                long j9 = c1800iq.A02;
                long queryEndPosition = c1800iq.A01;
                currentEndPosition = Math.max(currentEndPosition, j9 + queryEndPosition);
                if (currentEndPosition >= j8) {
                    break;
                }
            }
        }
        return Math.min(currentEndPosition - j, j3);
    }

    public final C1802is A03() {
        return this.A00;
    }

    public final C1800iq A04(long j, long j3) {
        C1800iq c1800iqA03 = C1800iq.A03(this.A02, j);
        C1800iq c1800iqFloor = this.A04.floor(c1800iqA03);
        if (c1800iqFloor != null && c1800iqFloor.A02 + c1800iqFloor.A01 > j) {
            return c1800iqFloor;
        }
        C1800iq lookupSpan = this.A04.ceiling(c1800iqA03);
        if (lookupSpan != null) {
            long jMin = lookupSpan.A02 - j;
            if (j3 != -1) {
                jMin = Math.min(jMin, j3);
            }
            j3 = jMin;
        }
        return C1800iq.A04(this.A02, j, j3);
    }

    public final C1800iq A05(C1800iq c1800iq, long j, boolean z2) {
        C3M.A08(this.A04.remove(c1800iq));
        File file = (File) C3M.A01(c1800iq.A03);
        if (z2) {
            File file2 = file.getParentFile();
            File fileA05 = C1800iq.A05((File) C3M.A01(file2), this.A01, c1800iq.A02, j);
            if (file.renameTo(fileA05)) {
                file = fileA05;
            } else {
                AnonymousClass44.A07(A00(4, 13, 42), A00(17, 17, 82) + file + A00(0, 4, 36) + fileA05);
            }
        }
        C1800iq newCacheSpan = c1800iq.A09(file, j);
        this.A04.add(newCacheSpan);
        return newCacheSpan;
    }

    public final TreeSet<C1800iq> A06() {
        return this.A04;
    }

    /* JADX WARN: Incorrect condition in loop: B:4:0x0007 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void A07(long r5) {
        /*
            r4 = this;
            r3 = 0
        L1:
            java.util.ArrayList<com.facebook.ads.redexgen.X.M3> r0 = r4.A03
            int r0 = r0.size()
            if (r3 >= r0) goto L20
            java.util.ArrayList<com.facebook.ads.redexgen.X.M3> r0 = r4.A03
            java.lang.Object r0 = r0.get(r3)
            com.facebook.ads.redexgen.X.M3 r0 = (com.instagram.common.viewpoint.core.M3) r0
            long r1 = r0.A01
            int r0 = (r1 > r5 ? 1 : (r1 == r5 ? 0 : -1))
            if (r0 != 0) goto L1d
            java.util.ArrayList<com.facebook.ads.redexgen.X.M3> r0 = r4.A03
            r0.remove(r3)
            return
        L1d:
            int r3 = r3 + 1
            goto L1
        L20:
            java.lang.IllegalStateException r0 = new java.lang.IllegalStateException
            r0.<init>()
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.instagram.common.viewpoint.core.M4.A07(long):void");
    }

    public final void A08(C1800iq c1800iq) {
        this.A04.add(c1800iq);
    }

    public final boolean A09() {
        return this.A04.isEmpty();
    }

    public final boolean A0A() {
        return this.A03.isEmpty();
    }

    /* JADX WARN: Incorrect condition in loop: B:4:0x0007 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final boolean A0B(long r3, long r5) {
        /*
            r2 = this;
            r1 = 0
        L1:
            java.util.ArrayList<com.facebook.ads.redexgen.X.M3> r0 = r2.A03
            int r0 = r0.size()
            if (r1 >= r0) goto L1c
            java.util.ArrayList<com.facebook.ads.redexgen.X.M3> r0 = r2.A03
            java.lang.Object r0 = r0.get(r1)
            com.facebook.ads.redexgen.X.M3 r0 = (com.instagram.common.viewpoint.core.M3) r0
            boolean r0 = r0.A00(r3, r5)
            if (r0 == 0) goto L19
            r0 = 1
            return r0
        L19:
            int r1 = r1 + 1
            goto L1
        L1c:
            r0 = 0
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.instagram.common.viewpoint.core.M4.A0B(long, long):boolean");
    }

    /* JADX WARN: Incorrect condition in loop: B:4:0x0007 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final boolean A0C(long r3, long r5) {
        /*
            r2 = this;
            r1 = 0
        L1:
            java.util.ArrayList<com.facebook.ads.redexgen.X.M3> r0 = r2.A03
            int r0 = r0.size()
            if (r1 >= r0) goto L1c
            java.util.ArrayList<com.facebook.ads.redexgen.X.M3> r0 = r2.A03
            java.lang.Object r0 = r0.get(r1)
            com.facebook.ads.redexgen.X.M3 r0 = (com.instagram.common.viewpoint.core.M3) r0
            boolean r0 = r0.A01(r3, r5)
            if (r0 == 0) goto L19
            r0 = 0
            return r0
        L19:
            int r1 = r1 + 1
            goto L1
        L1c:
            java.util.ArrayList<com.facebook.ads.redexgen.X.M3> r1 = r2.A03
            com.facebook.ads.redexgen.X.M3 r0 = new com.facebook.ads.redexgen.X.M3
            r0.<init>(r3, r5)
            r1.add(r0)
            r0 = 1
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.instagram.common.viewpoint.core.M4.A0C(long, long):boolean");
    }

    public final boolean A0D(C0914Lx c0914Lx) {
        if (this.A04.remove(c0914Lx)) {
            if (c0914Lx.A03 != null) {
                c0914Lx.A03.delete();
                return true;
            }
            return true;
        }
        String[] strArr = A06;
        if (strArr[2].length() == strArr[3].length()) {
            throw new RuntimeException();
        }
        String[] strArr2 = A06;
        strArr2[2] = "U4uu0ltzeeg5QMm1KwS";
        strArr2[3] = "VtFGErd1YdVsfyUNL3Po";
        return false;
    }

    public final boolean A0E(M9 m9) {
        C1802is c1802is = this.A00;
        C1802is oldMetadata = this.A00;
        this.A00 = oldMetadata.A05(m9);
        C1802is oldMetadata2 = this.A00;
        return !oldMetadata2.equals(c1802is);
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        M4 m42 = (M4) obj;
        if (this.A01 == m42.A01 && this.A02.equals(m42.A02) && this.A04.equals(m42.A04) && this.A00.equals(m42.A00)) {
            return true;
        }
        return false;
    }

    public final int hashCode() {
        int result = this.A01;
        int i2 = result * 31;
        int result2 = this.A02.hashCode();
        return ((i2 + result2) * 31) + this.A00.hashCode();
    }
}
