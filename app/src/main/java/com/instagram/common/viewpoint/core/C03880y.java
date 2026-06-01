package com.instagram.common.viewpoint.core;

import com.facebook.video.heroplayer.exocustom.MetaExoPlayerCustomization;
import java.util.Arrays;
import java.util.List;

/* JADX INFO: renamed from: com.facebook.ads.redexgen.X.0y, reason: invalid class name and case insensitive filesystem */
/* JADX INFO: loaded from: assets/audience_network.dex */
public final class C03880y extends AnonymousClass94 {
    public static byte[] A0H;
    public static String[] A0I = {"m5Q3aiQKICJZrVflAtkG72aHaW7D7vzV", "Te6TlfxhDkM1nSnzhWnFswazR8GhYsIL", "RAA", "kEgqAeLW1EWE377lDOv4M7tHjIvdZKXO", "06ys5nuQ5LNcvNVR71UhF3Tfl10HYLje", "yFo", "kDpjkJehLDjfyQcmHJ0GXPIrbeMaoLDA", "wnjbAtiJPFcw6YA"};
    public AnonymousClass96 A00;
    public float A01;
    public int A02;
    public int A03;
    public long A04;
    public final float A05;
    public final int A06;
    public final int A07;
    public final long A08;
    public final long A09;
    public final long A0A;
    public final AbstractC0621Am<C0702Ds> A0B;
    public final float A0C;
    public final int A0D;
    public final long A0E;
    public final C3T A0F;
    public final EU A0G;

    /* JADX WARN: Failed to parse debug info
    java.lang.ArrayIndexOutOfBoundsException
     */
    public C03880y(@MetaExoPlayerCustomization("Used for OculusAdaptiveTrackSelection") C2120oH c2120oH, @MetaExoPlayerCustomization("Used to retain old value for Oculus") int[] iArr, int i2, EU eu, int i8, long j, long j3, long j8, int i9, int i10, float f4, float f8, long j9, List<C0702Ds> list, C3T c3t) {
        super(c2120oH, iArr, i2);
        if (j8 < j) {
            AnonymousClass44.A07(A03(0, 22, 43), A03(22, 90, 50));
            j8 = j;
        }
        this.A0G = eu;
        this.A0D = i8;
        this.A08 = j * 1000;
        this.A0E = j3 * 1000;
        this.A09 = 1000 * j8;
        this.A07 = i9;
        this.A06 = i10;
        this.A0C = f4;
        this.A05 = f8;
        this.A0B = AbstractC0621Am.A05(list);
        this.A0A = j9;
        this.A0F = c3t;
        this.A01 = 1.0f;
        this.A02 = 0;
        this.A04 = -9223372036854775807L;
    }

    public static String A03(int i2, int i8, int i9) {
        byte[] bArrCopyOfRange = Arrays.copyOfRange(A0H, i2, i2 + i8);
        for (int i10 = 0; i10 < bArrCopyOfRange.length; i10++) {
            bArrCopyOfRange[i10] = (byte) ((bArrCopyOfRange[i10] - i9) - 89);
        }
        return new String(bArrCopyOfRange);
    }

    public static void A04() {
        A0H = new byte[]{-59, -24, -27, -12, -8, -19, -6, -23, -40, -10, -27, -25, -17, -41, -23, -16, -23, -25, -8, -19, -13, -14, -52, -17, -11, 0, -2, -1, -12, -7, -14, -85, -8, -12, -7, -49, 0, -3, -20, -1, -12, -6, -7, -33, -6, -35, -16, -1, -20, -12, -7, -52, -15, -1, -16, -3, -49, -12, -2, -18, -20, -3, -17, -40, -2, -85, -1, -6, -85, -19, -16, -85, -20, -1, -85, -9, -16, -20, -2, -1, -85, -8, -12, -7, -49, 0, -3, -20, -1, -12, -6, -7, -47, -6, -3, -36, 0, -20, -9, -12, -1, 4, -44, -7, -18, -3, -16, -20, -2, -16, -40, -2};
    }

    static {
        A04();
    }

    /* JADX WARN: Generic types in debug info not equals: com.facebook.ads.redexgen.X.1h != com.google.common.collect.ImmutableList$Builder<com.facebook.ads.androidx.media3.exoplayer.trackselection.AdaptiveTrackSelection$AdaptationCheckpoint> */
    /* JADX WARN: Generic types in debug info not equals: com.facebook.ads.redexgen.X.1h != com.google.common.collect.ImmutableList$Builder<com.google.common.collect.ImmutableList<com.facebook.ads.androidx.media3.exoplayer.trackselection.AdaptiveTrackSelection$AdaptationCheckpoint>> */
    /* JADX WARN: Generic types in debug info not equals: com.facebook.ads.redexgen.X.Am != com.google.common.collect.ImmutableList<java.lang.Integer> */
    /* JADX WARN: Removed duplicated region for block: B:46:0x0110  */
    /* JADX WARN: Removed duplicated region for block: B:48:0x011a  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static com.instagram.common.viewpoint.core.AbstractC0621Am<com.instagram.common.viewpoint.core.AbstractC0621Am<com.instagram.common.viewpoint.core.C0702Ds>> A00(com.instagram.common.viewpoint.core.E9[] r12) {
        /*
            Method dump skipped, instruction units count: 313
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.instagram.common.viewpoint.core.C03880y.A00(com.facebook.ads.redexgen.X.E9[]):com.facebook.ads.redexgen.X.Am");
    }

    /* JADX WARN: Generic types in debug info not equals: com.facebook.ads.redexgen.X.oE != com.google.common.collect.Multimap<java.lang.Double, java.lang.Integer> */
    public static AbstractC0621Am<Integer> A02(long[][] jArr) {
        InterfaceC2117oE interfaceC2117oEA00 = AbstractC2119oG.A02().A03().A00();
        for (int i2 = 0; i2 < jArr.length; i2++) {
            if (jArr[i2].length > 1) {
                double[] logBitrates = new double[jArr[i2].length];
                int i8 = 0;
                while (true) {
                    double dLog = 0.0d;
                    if (i8 >= jArr[i2].length) {
                        break;
                    }
                    if (jArr[i2][i8] != -1) {
                        dLog = Math.log(jArr[i2][i8]);
                    }
                    logBitrates[i8] = dLog;
                    i8++;
                }
                double d8 = logBitrates[logBitrates.length - 1] - logBitrates[0];
                int i9 = 0;
                for (int i10 = 1; i9 < logBitrates.length - i10; i10 = 1) {
                    interfaceC2117oEA00.AGU(Double.valueOf(d8 == 0.0d ? 1.0d : (((logBitrates[i9] + logBitrates[i9 + 1]) * 0.5d) - logBitrates[0]) / d8), Integer.valueOf(i2));
                    i9++;
                }
            }
        }
        return AbstractC0621Am.A05(interfaceC2117oEA00.values());
    }

    /* JADX WARN: Generic types in debug info not equals: com.facebook.ads.redexgen.X.1h != com.google.common.collect.ImmutableList$Builder<com.facebook.ads.androidx.media3.exoplayer.trackselection.AdaptiveTrackSelection$AdaptationCheckpoint> */
    public static void A05(List<C03971h<C0702Ds>> list, long[] jArr) {
        long j = 0;
        int i2 = 0;
        while (true) {
            if (i2 < jArr.length) {
                long j3 = jArr[i2];
                String[] strArr = A0I;
                if (strArr[5].length() != strArr[2].length()) {
                    break;
                }
                A0I[0] = "hzQzkxJwAHZ0fRiIn7Pvrd3jIUiof14p";
                j += j3;
                i2++;
            } else {
                for (int i8 = 0; i8 < list.size(); i8++) {
                    C03971h<C0702Ds> c03971h = list.get(i8);
                    if (A0I[0].charAt(10) != 'x') {
                        A0I[0] = "0V4VZlbFayh1Opq7Ah9Nva0ccysrREXP";
                        if (c03971h != null) {
                            c03971h.A04(new C0702Ds(j, jArr[i8]));
                        }
                    }
                }
                return;
            }
        }
        throw new RuntimeException();
    }

    /* JADX WARN: Removed duplicated region for block: B:18:0x006e A[PHI: r5
  0x006e: PHI (r5v2 long[]) = (r5v0 long[]), (r5v3 long[]) binds: [B:21:0x007c, B:17:0x006c] A[DONT_GENERATE, DONT_INLINE]] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static long[][] A06(com.instagram.common.viewpoint.core.E9[] r10) {
        /*
            int r0 = r10.length
            long[][] r9 = new long[r0][]
            r8 = 0
        L4:
            int r0 = r10.length
            if (r8 >= r0) goto L8b
            r7 = r10[r8]
            if (r7 != 0) goto L13
            r0 = 0
            long[] r0 = new long[r0]
            r9[r8] = r0
        L10:
            int r8 = r8 + 1
            goto L4
        L13:
            int[] r0 = r7.A02
            int r0 = r0.length
            long[] r3 = new long[r0]
            java.lang.String[] r2 = com.instagram.common.viewpoint.core.C03880y.A0I
            r0 = 6
            r1 = r2[r0]
            r0 = 3
            r2 = r2[r0]
            r0 = 18
            char r1 = r1.charAt(r0)
            char r0 = r2.charAt(r0)
            if (r1 == r0) goto L85
            java.lang.String[] r2 = com.instagram.common.viewpoint.core.C03880y.A0I
            java.lang.String r1 = "e4C"
            r0 = 5
            r2[r0] = r1
            java.lang.String r1 = "lZL"
            r0 = 2
            r2[r0] = r1
            r9[r8] = r3
            r6 = 0
        L3b:
            int[] r0 = r7.A02
            int r0 = r0.length
            if (r6 >= r0) goto L7f
            com.facebook.ads.redexgen.X.oH r1 = r7.A01
            int[] r0 = r7.A02
            r0 = r0[r6]
            com.facebook.ads.redexgen.X.or r0 = r1.A08(r0)
            int r3 = r0.A05
            java.lang.String[] r1 = com.instagram.common.viewpoint.core.C03880y.A0I
            r0 = 7
            r0 = r1[r0]
            int r1 = r0.length()
            r0 = 11
            if (r1 == r0) goto L75
            java.lang.String[] r2 = com.instagram.common.viewpoint.core.C03880y.A0I
            java.lang.String r1 = "HL2"
            r0 = 5
            r2[r0] = r1
            java.lang.String r1 = "liv"
            r0 = 2
            r2[r0] = r1
            long r3 = (long) r3
            r5 = r9[r8]
            r1 = -1
            int r0 = (r3 > r1 ? 1 : (r3 == r1 ? 0 : -1))
            if (r0 != 0) goto L70
        L6e:
            r3 = 0
        L70:
            r5[r6] = r3
            int r6 = r6 + 1
            goto L3b
        L75:
            long r3 = (long) r3
            r5 = r9[r8]
            r1 = -1
            int r0 = (r3 > r1 ? 1 : (r3 == r1 ? 0 : -1))
            if (r0 != 0) goto L70
            goto L6e
        L7f:
            r0 = r9[r8]
            java.util.Arrays.sort(r0)
            goto L10
        L85:
            java.lang.RuntimeException r0 = new java.lang.RuntimeException
            r0.<init>()
            throw r0
        L8b:
            return r9
        */
        throw new UnsupportedOperationException("Method not decompiled: com.instagram.common.viewpoint.core.C03880y.A06(com.facebook.ads.redexgen.X.E9[]):long[][]");
    }

    @Override // com.instagram.common.viewpoint.core.AnonymousClass94, com.instagram.common.viewpoint.core.InterfaceC1964lj
    public final void A5p() {
        this.A00 = null;
    }

    @Override // com.instagram.common.viewpoint.core.AnonymousClass94, com.instagram.common.viewpoint.core.InterfaceC1964lj
    public final void A6C() {
        this.A04 = -9223372036854775807L;
        this.A00 = null;
    }

    @Override // com.instagram.common.viewpoint.core.InterfaceC1964lj
    public final int A8v() {
        return this.A03;
    }

    @Override // com.instagram.common.viewpoint.core.AnonymousClass94, com.instagram.common.viewpoint.core.InterfaceC1964lj
    public final void AEc(float f4) {
        this.A01 = f4;
    }
}
