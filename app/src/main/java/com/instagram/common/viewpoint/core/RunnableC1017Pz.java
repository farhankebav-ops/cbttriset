package com.instagram.common.viewpoint.core;

import androidx.core.location.LocationRequestCompat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.concurrent.TimeUnit;

/* JADX INFO: renamed from: com.facebook.ads.redexgen.X.Pz, reason: case insensitive filesystem */
/* JADX INFO: loaded from: assets/audience_network.dex */
public final class RunnableC1017Pz implements Runnable {
    public static Comparator<C1016Py> A04;
    public static byte[] A05;
    public static String[] A06 = {"ZWObiMwNkhaZGfEgqHenCxQvRQCezgXM", "iKaB5ntiNbaiz6tgW", "JplxjEE1IYbCInXXNCkbxZV0", "UEoPOy6vCmPnpiXEMXmcZKvRtDoHf0nN", "JvUlYJe7lgtJoJN1gtwvhyIs", "RcG3r4ysor4dcgCWVGn8CFYsdgQ7jZkt", "cxmAjzJ", "EyohaYHYoMvb6y9gFGiucolIeU60NsdM"};
    public static final ThreadLocal<RunnableC1017Pz> A07;
    public long A00;
    public long A01;
    public ArrayList<C05246g> A02 = new ArrayList<>();
    public ArrayList<C1016Py> A03 = new ArrayList<>();

    public static String A01(int i2, int i8, int i9) {
        byte[] bArrCopyOfRange = Arrays.copyOfRange(A05, i2, i2 + i8);
        for (int i10 = 0; i10 < bArrCopyOfRange.length; i10++) {
            bArrCopyOfRange[i10] = (byte) ((bArrCopyOfRange[i10] ^ i9) ^ 104);
        }
        return new String(bArrCopyOfRange);
    }

    public static void A03() {
        A05 = new byte[]{105, 109, 27, 117, 94, 72, 79, 94, 95, 27, 107, 73, 94, 93, 94, 79, 88, 83, 100, 96, 22, 102, 68, 83, 80, 83, 66, 85, 94};
    }

    static {
        A03();
        A07 = new ThreadLocal<>();
        A04 = new C1015Px();
    }

    private AbstractC1024Qg A00(C05246g c05246g, int i2, long j) {
        if (A08(c05246g, i2)) {
            return null;
        }
        QW qw = c05246g.A0r;
        try {
            c05246g.A1M();
            AbstractC1024Qg abstractC1024QgA0I = qw.A0I(i2, false, j);
            if (abstractC1024QgA0I != null) {
                if (abstractC1024QgA0I.A0e() && !abstractC1024QgA0I.A0f()) {
                    qw.A0T(abstractC1024QgA0I.A0H);
                } else {
                    qw.A0Z(abstractC1024QgA0I, false);
                }
            }
            return abstractC1024QgA0I;
        } finally {
            c05246g.A1o(false);
        }
    }

    /* JADX WARN: Incorrect condition in loop: B:16:0x0054 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private void A02() {
        /*
            r10 = this;
            java.util.ArrayList<com.facebook.ads.redexgen.X.6g> r0 = r10.A02
            int r9 = r0.size()
            r4 = 0
            r3 = 0
        L8:
            r2 = 0
            if (r3 >= r9) goto L26
            java.util.ArrayList<com.facebook.ads.redexgen.X.6g> r0 = r10.A02
            java.lang.Object r1 = r0.get(r3)
            com.facebook.ads.redexgen.X.6g r1 = (com.instagram.common.viewpoint.core.C05246g) r1
            int r0 = r1.getWindowVisibility()
            if (r0 != 0) goto L23
            com.facebook.ads.redexgen.X.gJ r0 = r1.A02
            r0.A04(r1, r2)
            com.facebook.ads.redexgen.X.gJ r0 = r1.A02
            int r0 = r0.A00
            int r4 = r4 + r0
        L23:
            int r3 = r3 + 1
            goto L8
        L26:
            java.util.ArrayList<com.facebook.ads.redexgen.X.Py> r0 = r10.A03
            r0.ensureCapacity(r4)
            r8 = 0
            r7 = 0
        L2d:
            if (r7 >= r9) goto L8f
            java.util.ArrayList<com.facebook.ads.redexgen.X.6g> r0 = r10.A02
            java.lang.Object r6 = r0.get(r7)
            com.facebook.ads.redexgen.X.6g r6 = (com.instagram.common.viewpoint.core.C05246g) r6
            int r0 = r6.getWindowVisibility()
            if (r0 == 0) goto L40
        L3d:
            int r7 = r7 + 1
            goto L2d
        L40:
            com.facebook.ads.redexgen.X.gJ r5 = r6.A02
            int r0 = r5.A01
            int r4 = java.lang.Math.abs(r0)
            int r0 = r5.A02
            int r0 = java.lang.Math.abs(r0)
            int r4 = r4 + r0
            r3 = 0
        L50:
            int r0 = r5.A00
            int r0 = r0 * 2
            if (r3 >= r0) goto L3d
            java.util.ArrayList<com.facebook.ads.redexgen.X.Py> r0 = r10.A03
            int r0 = r0.size()
            if (r8 < r0) goto L86
            com.facebook.ads.redexgen.X.Py r0 = new com.facebook.ads.redexgen.X.Py
            r0.<init>()
            java.util.ArrayList<com.facebook.ads.redexgen.X.Py> r1 = r10.A03
            r1.add(r0)
        L68:
            int[] r2 = r5.A03
            int r1 = r3 + 1
            r2 = r2[r1]
            if (r2 > r4) goto L84
            r1 = 1
        L71:
            r0.A04 = r1
            r0.A02 = r4
            r0.A00 = r2
            r0.A03 = r6
            int[] r1 = r5.A03
            r1 = r1[r3]
            r0.A01 = r1
            int r8 = r8 + 1
            int r3 = r3 + 2
            goto L50
        L84:
            r1 = 0
            goto L71
        L86:
            java.util.ArrayList<com.facebook.ads.redexgen.X.Py> r0 = r10.A03
            java.lang.Object r0 = r0.get(r8)
            com.facebook.ads.redexgen.X.Py r0 = (com.instagram.common.viewpoint.core.C1016Py) r0
            goto L68
        L8f:
            java.util.ArrayList<com.facebook.ads.redexgen.X.Py> r1 = r10.A03
            java.util.Comparator<com.facebook.ads.redexgen.X.Py> r0 = com.instagram.common.viewpoint.core.RunnableC1017Pz.A04
            java.util.Collections.sort(r1, r0)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.instagram.common.viewpoint.core.RunnableC1017Pz.A02():void");
    }

    /* JADX WARN: Incorrect condition in loop: B:4:0x0007 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private void A04(long r6) {
        /*
            r5 = this;
            r4 = 0
        L1:
            java.util.ArrayList<com.facebook.ads.redexgen.X.Py> r0 = r5.A03
            int r0 = r0.size()
            if (r4 >= r0) goto L31
            java.util.ArrayList<com.facebook.ads.redexgen.X.Py> r0 = r5.A03
            java.lang.Object r3 = r0.get(r4)
            java.lang.String[] r1 = com.instagram.common.viewpoint.core.RunnableC1017Pz.A06
            r0 = 7
            r1 = r1[r0]
            r0 = 15
            char r1 = r1.charAt(r0)
            r0 = 103(0x67, float:1.44E-43)
            if (r1 == r0) goto L24
            java.lang.RuntimeException r0 = new java.lang.RuntimeException
            r0.<init>()
            throw r0
        L24:
            java.lang.String[] r2 = com.instagram.common.viewpoint.core.RunnableC1017Pz.A06
            java.lang.String r1 = "gpZ2KV2"
            r0 = 6
            r2[r0] = r1
            com.facebook.ads.redexgen.X.Py r3 = (com.instagram.common.viewpoint.core.C1016Py) r3
            com.facebook.ads.redexgen.X.6g r0 = r3.A03
            if (r0 != 0) goto L32
        L31:
            return
        L32:
            r5.A06(r3, r6)
            r3.A00()
            int r4 = r4 + 1
            goto L1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.instagram.common.viewpoint.core.RunnableC1017Pz.A04(long):void");
    }

    private final void A05(long j) {
        A02();
        A04(j);
    }

    private void A06(C1016Py c1016Py, long j) {
        AbstractC1024Qg abstractC1024QgA00 = A00(c1016Py.A03, c1016Py.A01, c1016Py.A04 ? LocationRequestCompat.PASSIVE_INTERVAL : j);
        if (abstractC1024QgA00 != null && abstractC1024QgA00.A09 != null && abstractC1024QgA00.A0e() && !abstractC1024QgA00.A0f()) {
            C05246g c05246g = abstractC1024QgA00.A09.get();
            if (A06[3].charAt(4) != 'O') {
                throw new RuntimeException();
            }
            String[] strArr = A06;
            strArr[0] = "y01bdO2VJYUoPT1JEr7HCeGbjhjinZRt";
            strArr[5] = "ogbTL45N3M3fzw26YptkCantwmvhDLLM";
            A07(c05246g, j);
        }
    }

    private void A07(C05246g c05246g, long j) {
        if (c05246g == null) {
            return;
        }
        if (c05246g.A0C && c05246g.A01.A06() != 0) {
            c05246g.A1P();
        }
        C1658gJ c1658gJ = c05246g.A02;
        c1658gJ.A04(c05246g, true);
        if (c1658gJ.A00 != 0) {
            try {
                OQ.A01(A01(0, 18, 83));
                c05246g.A0s.A05(c05246g.A04);
                for (int i2 = 0; i2 < c1658gJ.A00 * 2; i2 += 2) {
                    A00(c05246g, c1658gJ.A03[i2], j);
                }
            } finally {
                OQ.A00();
            }
        }
    }

    public static boolean A08(C05246g c05246g, int i2) {
        int iA06 = c05246g.A01.A06();
        for (int i8 = 0; i8 < iA06; i8++) {
            AbstractC1024Qg abstractC1024QgA0F = C05246g.A0F(c05246g.A01.A0A(i8));
            int childCount = abstractC1024QgA0F.A03;
            if (childCount == i2 && !abstractC1024QgA0F.A0f()) {
                return true;
            }
        }
        return false;
    }

    public final void A09(C05246g c05246g) {
        this.A02.add(c05246g);
    }

    public final void A0A(C05246g c05246g) {
        this.A02.remove(c05246g);
    }

    public final void A0B(C05246g c05246g, int i2, int i8) {
        if (c05246g.isAttachedToWindow()) {
            long j = this.A01;
            String[] strArr = A06;
            if (strArr[0].charAt(20) != strArr[5].charAt(20)) {
                throw new RuntimeException();
            }
            A06[6] = "T8Y6UBY";
            if (j == 0) {
                this.A01 = c05246g.getNanoTime();
                c05246g.post(this);
            }
        }
        c05246g.A02.A03(i2, i8);
    }

    @Override // java.lang.Runnable
    public final void run() {
        try {
            OQ.A01(A01(18, 11, 94));
            if (this.A02.isEmpty()) {
                this.A01 = 0L;
                if (A06[6].length() != 7) {
                    throw new RuntimeException();
                }
                A06[7] = "jOxF3Mzmcdx8L8GgZmI4I6pGAsyGGZV3";
                OQ.A00();
                return;
            }
            int size = this.A02.size();
            long jMax = 0;
            for (int i2 = 0; i2 < size; i2++) {
                C05246g c05246g = this.A02.get(i2);
                if (c05246g.getWindowVisibility() == 0) {
                    jMax = Math.max(c05246g.getDrawingTime(), jMax);
                }
            }
            if (jMax == 0) {
                return;
            }
            A05(TimeUnit.MILLISECONDS.toNanos(jMax) + this.A00);
        } finally {
            this.A01 = 0L;
            OQ.A00();
        }
    }
}
