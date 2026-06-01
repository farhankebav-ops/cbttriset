package com.instagram.common.viewpoint.core;

import android.util.Pair;
import com.facebook.ads.androidx.media3.common.Timeline;

/* JADX INFO: renamed from: com.facebook.ads.redexgen.X.6c, reason: invalid class name and case insensitive filesystem */
/* JADX INFO: loaded from: assets/audience_network.dex */
public final class C05206c {
    public static String[] A0B = {"ytES6GjYCCZeLRsctY", "", "JAF1Tg0UjyffIggj5BNMmxVlRkgdhjMr", "rlk3ZCySajOx3", "MCGN0v", "", "6TmcGiXQ57FFOBCo2j", "Z1k2a4cknNke6aCh8ssxRFJ66FmodiBm"};
    public int A00;
    public int A01;
    public long A02;
    public long A03;
    public C6Y A04;
    public C6Y A05;
    public C6Y A06;
    public Object A07;
    public boolean A08;
    public final C2125oN A09 = new C2125oN();
    public final C2123oL A0A = new C2123oL();

    /* JADX WARN: Failed to parse debug info
    java.lang.ArrayIndexOutOfBoundsException
     */
    public static C2001mL A06(Timeline timeline, Object obj, long j, long j3, C2125oN c2125oN) {
        timeline.A0J(obj, c2125oN);
        int iA08 = c2125oN.A08(j);
        return iA08 == -1 ? new C2001mL(obj, j3) : new C2001mL(obj, iA08, c2125oN.A05(iA08), j3);
    }

    /* JADX WARN: Failed to parse debug info
    java.lang.ArrayIndexOutOfBoundsException
     */
    public final C6Z A0I(Timeline timeline, C6Z c6z) {
        long j = c6z.A01;
        boolean zA08 = A08(timeline, c6z.A04, j);
        boolean zA09 = A09(timeline, c6z.A04, zA08);
        timeline.A0J(c6z.A04.A04, this.A09);
        return new C6Z(c6z.A04, c6z.A03, j, c6z.A02, c6z.A04.A00() ? this.A09.A0E(c6z.A04.A00, c6z.A04.A01) : j == Long.MIN_VALUE ? this.A09.A0A() : j, zA08, zA09);
    }

    private long A00(Timeline timeline, Object obj) {
        int oldFrontPeriodIndex;
        int holderWindowIndex = timeline.A0J(obj, this.A09).A00;
        if (this.A07 != null && (oldFrontPeriodIndex = timeline.A0A(this.A07)) != -1) {
            int windowIndex = timeline.A0H(oldFrontPeriodIndex, this.A09).A00;
            if (windowIndex == holderWindowIndex) {
                return this.A03;
            }
        }
        for (C6Y mediaPeriodHolder = A0D(); mediaPeriodHolder != null; mediaPeriodHolder = mediaPeriodHolder.A0I()) {
            if (mediaPeriodHolder.A08.equals(obj)) {
                return mediaPeriodHolder.A00.A04.A03;
            }
        }
        for (C6Y c6yA0D = A0D(); c6yA0D != null; c6yA0D = c6yA0D.A0I()) {
            int iA0A = timeline.A0A(c6yA0D.A08);
            if (iA0A != -1) {
                int windowIndex2 = timeline.A0H(iA0A, this.A09).A00;
                if (windowIndex2 == holderWindowIndex) {
                    return c6yA0D.A00.A04.A03;
                }
            }
        }
        long j = this.A02;
        this.A02 = 1 + j;
        return j;
    }

    private C6Z A01(Timeline timeline, C6Y c6y, long j) {
        long jLongValue;
        C05206c c05206c = this;
        C6Z c6z = c6y.A00;
        if (c6z.A07) {
            int iA0A = timeline.A0A(c6z.A04.A04);
            C2125oN c2125oN = c05206c.A09;
            C2123oL c2123oL = c05206c.A0A;
            int currentPeriodIndex = c05206c.A01;
            int iA09 = timeline.A09(iA0A, c2125oN, c2123oL, currentPeriodIndex, c05206c.A08);
            if (iA09 == -1) {
                return null;
            }
            int i2 = timeline.A0I(iA09, c05206c.A09, true).A00;
            Object obj = c05206c.A09.A04;
            long j3 = c6z.A04.A03;
            if (timeline.A0K(i2, c05206c.A0A).A00 == iA09) {
                Pair<Object, Long> defaultPosition = timeline.A0F(c05206c.A0A, c05206c.A09, i2, -9223372036854775807L, Math.max(0L, (c6y.A0B() + c6z.A00) - j));
                if (defaultPosition == null) {
                    return null;
                }
                obj = defaultPosition.first;
                jLongValue = ((Long) defaultPosition.second).longValue();
                C6Y c6yA0I = c6y.A0I();
                if (c6yA0I != null && c6yA0I.A08.equals(obj)) {
                    j3 = c6yA0I.A00.A04.A03;
                    c05206c = this;
                } else {
                    c05206c = this;
                    j3 = c05206c.A02;
                    long startPositionUs = 1 + j3;
                    String[] strArr = A0B;
                    if (strArr[6].length() == strArr[4].length()) {
                        throw new RuntimeException();
                    }
                    A0B[0] = "5yy5YdDharfiXP";
                    c05206c.A02 = startPositionUs;
                }
            } else {
                jLongValue = 0;
            }
            return A02(timeline, A06(timeline, obj, jLongValue, j3, c05206c.A09), jLongValue, jLongValue);
        }
        C2001mL c2001mL = c6z.A04;
        timeline.A0J(c2001mL.A04, c05206c.A09);
        if (c2001mL.A00()) {
            int i8 = c2001mL.A00;
            int iA04 = c05206c.A09.A04(i8);
            if (iA04 != -1) {
                int iA06 = c05206c.A09.A06(i8, c2001mL.A01);
                if (iA06 < iA04) {
                    if (!c05206c.A09.A0I(i8, iA06)) {
                        return null;
                    }
                    return A03(timeline, c2001mL.A04, i8, iA06, c6z.A02, c2001mL.A03);
                }
                return A04(timeline, c2001mL.A04, c6z.A02, c2001mL.A03);
            }
            String[] strArr2 = A0B;
            if (strArr2[5].length() != strArr2[1].length()) {
                throw new RuntimeException();
            }
            String[] strArr3 = A0B;
            strArr3[5] = "";
            strArr3[1] = "";
            return null;
        }
        if (c6z.A01 != Long.MIN_VALUE) {
            int iA08 = c05206c.A09.A08(c6z.A01);
            if (iA08 == -1) {
                return A04(timeline, c2001mL.A04, c6z.A01, c2001mL.A03);
            }
            int iA05 = c05206c.A09.A05(iA08);
            if (!c05206c.A09.A0I(iA08, iA05)) {
                return null;
            }
            return A03(timeline, c2001mL.A04, iA08, iA05, c6z.A01, c2001mL.A03);
        }
        int iA03 = c05206c.A09.A03();
        if (iA03 == 0) {
            return null;
        }
        int i9 = iA03 - 1;
        if (A0B[7].charAt(7) == 'k') {
            A0B[0] = "u0JZC9rSowd61rcMlDOlOE";
            if (c05206c.A09.A0D(i9) != Long.MIN_VALUE) {
                return null;
            }
        } else if (c05206c.A09.A0D(i9) != Long.MIN_VALUE) {
            return null;
        }
        if (c05206c.A09.A0H(i9)) {
            return null;
        }
        int iA052 = c05206c.A09.A05(i9);
        if (!c05206c.A09.A0I(i9, iA052)) {
            return null;
        }
        return A03(timeline, c2001mL.A04, i9, iA052, c05206c.A09.A0A(), c2001mL.A03);
    }

    private C6Z A02(Timeline timeline, C2001mL c2001mL, long j, long j3) {
        timeline.A0J(c2001mL.A04, this.A09);
        if (c2001mL.A00()) {
            if (!this.A09.A0I(c2001mL.A00, c2001mL.A01)) {
                return null;
            }
            return A03(timeline, c2001mL.A04, c2001mL.A00, c2001mL.A01, j, c2001mL.A03);
        }
        return A04(timeline, c2001mL.A04, j3, c2001mL.A03);
    }

    private C6Z A03(Timeline timeline, Object obj, int i2, int i8, long startPositionUs, long j) {
        long jA09;
        C2001mL c2001mL = new C2001mL(obj, i2, i8, j);
        boolean zA08 = A08(timeline, c2001mL, Long.MIN_VALUE);
        boolean zA09 = A09(timeline, c2001mL, zA08);
        long jA0E = timeline.A0J(c2001mL.A04, this.A09).A0E(c2001mL.A00, c2001mL.A01);
        if (i8 == this.A09.A05(i2)) {
            C2125oN c2125oN = this.A09;
            if (A0B[0].length() == 8) {
                throw new RuntimeException();
            }
            String[] strArr = A0B;
            strArr[6] = "btiW32P1CxlKUaykVb";
            strArr[4] = "aD0NnH";
            jA09 = c2125oN.A09();
        } else {
            jA09 = 0;
        }
        return new C6Z(c2001mL, jA09, Long.MIN_VALUE, startPositionUs, jA0E, zA08, zA09);
    }

    private C6Z A04(Timeline timeline, Object obj, long j, long j3) {
        long jA0D;
        long jA0A;
        C2001mL c2001mL = new C2001mL(obj, j3);
        timeline.A0J(c2001mL.A04, this.A09);
        int iA07 = this.A09.A07(j);
        if (iA07 == -1) {
            jA0D = Long.MIN_VALUE;
        } else {
            C2125oN c2125oN = this.A09;
            String[] strArr = A0B;
            if (strArr[6].length() == strArr[4].length()) {
                throw new RuntimeException();
            }
            String[] strArr2 = A0B;
            strArr2[6] = "hcjC8Oe5bspAHclLrN";
            strArr2[4] = "7U4c4Z";
            jA0D = c2125oN.A0D(iA07);
        }
        boolean isLastInTimeline = A08(timeline, c2001mL, jA0D);
        boolean zA09 = A09(timeline, c2001mL, isLastInTimeline);
        if (jA0D == Long.MIN_VALUE) {
            jA0A = this.A09.A0A();
        } else {
            jA0A = jA0D;
        }
        return new C6Z(c2001mL, j, jA0D, -9223372036854775807L, jA0A, isLastInTimeline, zA09);
    }

    private C6Z A05(C05416x c05416x) {
        return A02(c05416x.A03, c05416x.A05, c05416x.A01, c05416x.A02);
    }

    /* JADX WARN: Incorrect condition in loop: B:10:0x0033 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private boolean A07(com.facebook.ads.androidx.media3.common.Timeline r13) {
        /*
            r12 = this;
            com.facebook.ads.redexgen.X.6Y r3 = r12.A0D()
            r5 = 1
            if (r3 != 0) goto L8
            return r5
        L8:
            java.lang.Object r0 = r3.A08
            r6 = r13
            int r7 = r6.A0A(r0)
            java.lang.String[] r1 = com.instagram.common.viewpoint.core.C05206c.A0B
            r0 = 3
            r0 = r1[r0]
            int r1 = r0.length()
            r0 = 26
            if (r1 == r0) goto La1
            java.lang.String[] r2 = com.instagram.common.viewpoint.core.C05206c.A0B
            java.lang.String r1 = "XXauRi"
            r0 = 0
            r2[r0] = r1
        L23:
            com.facebook.ads.redexgen.X.oN r8 = r12.A09
            com.facebook.ads.redexgen.X.oL r9 = r12.A0A
            int r10 = r12.A01
            boolean r11 = r12.A08
            int r7 = r6.A09(r7, r8, r9, r10, r11)
        L2f:
            com.facebook.ads.redexgen.X.6Y r0 = r3.A0I()
            if (r0 == 0) goto L40
            com.facebook.ads.redexgen.X.6Z r0 = r3.A00
            boolean r0 = r0.A07
            if (r0 != 0) goto L40
            com.facebook.ads.redexgen.X.6Y r3 = r3.A0I()
            goto L2f
        L40:
            com.facebook.ads.redexgen.X.6Y r1 = r3.A0I()
            r0 = -1
            if (r7 == r0) goto L49
            if (r1 != 0) goto L89
        L49:
            boolean r4 = r12.A0S(r3)
            java.lang.String[] r2 = com.instagram.common.viewpoint.core.C05206c.A0B
            r0 = 5
            r1 = r2[r0]
            r0 = 1
            r0 = r2[r0]
            int r1 = r1.length()
            int r0 = r0.length()
            if (r1 == r0) goto L72
            com.facebook.ads.redexgen.X.6Z r0 = r3.A00
            com.facebook.ads.redexgen.X.6Z r0 = r12.A0I(r6, r0)
            r3.A00 = r0
            if (r4 == 0) goto L6f
        L69:
            boolean r0 = r12.A0N()
            if (r0 != 0) goto L70
        L6f:
            return r5
        L70:
            r5 = 0
            goto L6f
        L72:
            java.lang.String[] r2 = com.instagram.common.viewpoint.core.C05206c.A0B
            java.lang.String r1 = "90zfs8gzmg4UDoZfId"
            r0 = 6
            r2[r0] = r1
            java.lang.String r1 = "a4jnrj"
            r0 = 4
            r2[r0] = r1
            com.facebook.ads.redexgen.X.6Z r0 = r3.A00
            com.facebook.ads.redexgen.X.6Z r0 = r12.A0I(r6, r0)
            r3.A00 = r0
            if (r4 == 0) goto L6f
            goto L69
        L89:
            java.lang.Object r0 = r1.A08
            int r0 = r6.A0A(r0)
            if (r0 == r7) goto L92
            goto L49
        L92:
            r3 = r1
            java.lang.String[] r1 = com.instagram.common.viewpoint.core.C05206c.A0B
            r0 = 7
            r1 = r1[r0]
            r0 = 7
            char r1 = r1.charAt(r0)
            r0 = 107(0x6b, float:1.5E-43)
            if (r1 == r0) goto La7
        La1:
            java.lang.RuntimeException r0 = new java.lang.RuntimeException
            r0.<init>()
            throw r0
        La7:
            java.lang.String[] r2 = com.instagram.common.viewpoint.core.C05206c.A0B
            java.lang.String r1 = "Cr1P4n0WQ70sIc2hdXVlmIoPdJb3W1mn"
            r0 = 2
            r2[r0] = r1
            goto L23
        */
        throw new UnsupportedOperationException("Method not decompiled: com.instagram.common.viewpoint.core.C05206c.A07(com.facebook.ads.androidx.media3.common.Timeline):boolean");
    }

    private boolean A08(Timeline timeline, C2001mL c2001mL, long j) {
        int adGroupCount = timeline.A0J(c2001mL.A04, this.A09).A03();
        if (adGroupCount == 0) {
            return true;
        }
        int i2 = adGroupCount - 1;
        boolean zA00 = c2001mL.A00();
        if (this.A09.A0D(i2) != Long.MIN_VALUE) {
            return !zA00 && j == Long.MIN_VALUE;
        }
        int lastAdGroupIndex = this.A09.A04(i2);
        if (lastAdGroupIndex == -1) {
            return false;
        }
        if (((zA00 && c2001mL.A00 == i2 && c2001mL.A01 == lastAdGroupIndex + (-1)) ? 1 : 0) == 0) {
            return !zA00 && this.A09.A05(i2) == lastAdGroupIndex;
        }
        return true;
    }

    private boolean A09(Timeline timeline, C2001mL c2001mL, boolean z2) {
        int iA0A = timeline.A0A(c2001mL.A04);
        return !timeline.A0K(timeline.A0H(iA0A, this.A09).A00, this.A0A).A0D && timeline.A0O(iA0A, this.A09, this.A0A, this.A01, this.A08) && z2;
    }

    private boolean A0A(C6Y c6y, C6Z c6z) {
        C6Z c6z2 = c6y.A00;
        return c6z2.A03 == c6z.A03 && c6z2.A01 == c6z.A01 && c6z2.A04.equals(c6z.A04);
    }

    public final C6Y A0B() {
        if (this.A05 != null) {
            if (this.A05 == this.A06) {
                C6Y c6y = this.A05;
                if (A0B[3].length() == 26) {
                    throw new RuntimeException();
                }
                A0B[2] = "cSlSOVjTMxyZvCYIIsIM7Z4RVriFSMIi";
                this.A06 = c6y.A0I();
            }
            this.A05.A0M();
            this.A05 = this.A05.A0I();
            this.A00--;
            if (this.A00 == 0) {
                this.A04 = null;
            }
        } else {
            this.A05 = this.A04;
            this.A06 = this.A04;
        }
        C6Y c6y2 = this.A05;
        if (A0B[0].length() != 8) {
            A0B[7] = "hdbErrckm1X5j4dXkt1ObCB8O8NcABpS";
            return c6y2;
        }
        A0B[3] = "prScRK6qkOjWt";
        return c6y2;
    }

    public final C6Y A0C() {
        C3M.A08((this.A06 == null || this.A06.A0I() == null) ? false : true);
        this.A06 = this.A06.A0I();
        return this.A06;
    }

    public final C6Y A0D() {
        return A0N() ? this.A05 : this.A04;
    }

    public final C6Y A0E() {
        return this.A04;
    }

    public final C6Y A0F() {
        return this.A05;
    }

    public final C6Y A0G() {
        return this.A06;
    }

    public final C6Z A0H(long j, C05416x c05416x) {
        if (this.A04 == null) {
            return A05(c05416x);
        }
        return A01(c05416x.A03, this.A04, j);
    }

    public final InterfaceC2002mM A0J(C7D[] c7dArr, long j, EK ek, EO eo, CL cl, C6Z c6z, EL el) {
        long jA0B;
        if (this.A04 != null) {
            jA0B = this.A04.A0B() + this.A04.A00.A00;
        } else {
            jA0B = c6z.A03 + j;
        }
        C6Y c6y = new C6Y(c7dArr, jA0B, ek, eo, cl, c6z, el);
        if (this.A04 != null) {
            C3M.A08(A0N());
            this.A04.A0Q(c6y);
        }
        this.A07 = null;
        this.A04 = c6y;
        this.A00++;
        return c6y.A07;
    }

    public final C2001mL A0K(Timeline timeline, Object obj, long j) {
        return A06(timeline, obj, j, A00(timeline, obj), this.A09);
    }

    public final void A0L(long j) {
        if (this.A04 != null) {
            this.A04.A0P(j);
        }
    }

    public final void A0M(boolean z2) {
        C6Y c6yA0D = A0D();
        if (c6yA0D != null) {
            this.A07 = z2 ? c6yA0D.A08 : null;
            this.A03 = c6yA0D.A00.A04.A03;
            c6yA0D.A0M();
            A0S(c6yA0D);
        } else if (!z2) {
            this.A07 = null;
        }
        this.A05 = null;
        this.A04 = null;
        this.A06 = null;
        this.A00 = 0;
    }

    public final boolean A0N() {
        return this.A05 != null;
    }

    public final boolean A0O() {
        if (this.A04 != null) {
            if (!this.A04.A00.A05 && this.A04.A0R()) {
                long j = this.A04.A00.A00;
                if (A0B[2].charAt(6) == 'F') {
                    throw new RuntimeException();
                }
                A0B[3] = "WQJhcBpqvfFlde6mvMcdcISTeYvrM";
                if (j == -9223372036854775807L || this.A00 >= 100) {
                }
            }
            return false;
        }
        return true;
    }

    public final boolean A0P(Timeline timeline, int i2) {
        this.A01 = i2;
        return A07(timeline);
    }

    public final boolean A0Q(Timeline timeline, C2001mL c2001mL, long j) {
        int iA0A = timeline.A0A(c2001mL.A04);
        C6Y c6y = null;
        for (C6Y c6yA0D = A0D(); c6yA0D != null; c6yA0D = c6yA0D.A0I()) {
            if (c6y == null) {
                c6yA0D.A00 = A0I(timeline, c6yA0D.A00);
            } else {
                if (iA0A != -1) {
                    boolean zEquals = c6yA0D.A08.equals(timeline.A0M(iA0A));
                    if (A0B[3].length() == 26) {
                        throw new RuntimeException();
                    }
                    String[] strArr = A0B;
                    strArr[6] = "ytUDxXblB5dYuzkyb9";
                    strArr[4] = "n5GR8r";
                    if (zEquals) {
                        C6Z c6zA01 = A01(timeline, c6y, j);
                        if (c6zA01 == null) {
                            return true ^ A0S(c6y);
                        }
                        c6yA0D.A00 = A0I(timeline, c6yA0D.A00);
                        if (!A0A(c6yA0D, c6zA01)) {
                            return true ^ A0S(c6y);
                        }
                    }
                }
                return true ^ A0S(c6y);
            }
            if (c6yA0D.A00.A07) {
                iA0A = timeline.A09(iA0A, this.A09, this.A0A, this.A01, this.A08);
            }
            c6y = c6yA0D;
        }
        return true;
    }

    public final boolean A0R(Timeline timeline, boolean z2) {
        this.A08 = z2;
        return A07(timeline);
    }

    public final boolean A0S(C6Y c6y) {
        C3M.A08(c6y != null);
        boolean z2 = false;
        this.A04 = c6y;
        while (c6y.A0I() != null) {
            c6y = c6y.A0I();
            if (c6y == this.A06) {
                this.A06 = this.A05;
                z2 = true;
            }
            c6y.A0M();
            this.A00--;
        }
        this.A04.A0Q(null);
        return z2;
    }

    public final boolean A0T(InterfaceC2002mM interfaceC2002mM) {
        return this.A04 != null && this.A04.A07 == interfaceC2002mM;
    }
}
