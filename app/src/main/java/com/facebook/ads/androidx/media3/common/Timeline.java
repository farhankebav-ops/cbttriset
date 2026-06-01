package com.facebook.ads.androidx.media3.common;

import android.os.Bundle;
import android.os.IBinder;
import android.util.Pair;
import com.facebook.ads.androidx.media3.common.Timeline;
import com.google.common.collect.ImmutableList;
import com.instagram.common.viewpoint.core.AbstractC04664a;
import com.instagram.common.viewpoint.core.AbstractC0621Am;
import com.instagram.common.viewpoint.core.C03971h;
import com.instagram.common.viewpoint.core.C05959m;
import com.instagram.common.viewpoint.core.C1Q;
import com.instagram.common.viewpoint.core.C1R;
import com.instagram.common.viewpoint.core.C1S;
import com.instagram.common.viewpoint.core.C2123oL;
import com.instagram.common.viewpoint.core.C2125oN;
import com.instagram.common.viewpoint.core.C3M;
import com.instagram.common.viewpoint.core.C3R;

/* JADX INFO: loaded from: assets/audience_network.dex */
public abstract class Timeline implements C1S {
    public static String[] A00 = {"u1TV1j0aFj13GJQ9ixTagHG8KyMgbnog", "4GMeFBxldVuonExwkIPaDDi9I59L728Z", "hqD1wOYcZTmehOTQOtlNc0UQ2KV4ETaI", "yejsGunEYiKaKfUzobCfCtheJf3zEEcL", "wYd9LRHFlTpJXE3VqmNr3ySXFdmyeGzN", "VCegaKN739XbWKUaP5Uwy30Zmvr6QTeK", "Cr3igiuAIuu", "x89DN52UD2fFRZn9rQXfWzGYhaiJYHE1"};
    public static final Timeline A02 = new Timeline() { // from class: com.facebook.ads.redexgen.X.9n
        @Override // com.facebook.ads.androidx.media3.common.Timeline
        public final int A06() {
            return 0;
        }

        @Override // com.facebook.ads.androidx.media3.common.Timeline
        public final int A07() {
            return 0;
        }

        @Override // com.facebook.ads.androidx.media3.common.Timeline
        public final int A0A(Object obj) {
            return -1;
        }

        @Override // com.facebook.ads.androidx.media3.common.Timeline
        public final C2125oN A0I(int i2, C2125oN c2125oN, boolean z2) {
            throw new IndexOutOfBoundsException();
        }

        @Override // com.facebook.ads.androidx.media3.common.Timeline
        public final C2123oL A0L(int i2, C2123oL c2123oL, long j) {
            throw new IndexOutOfBoundsException();
        }

        @Override // com.facebook.ads.androidx.media3.common.Timeline
        public final Object A0M(int i2) {
            throw new IndexOutOfBoundsException();
        }
    };
    public static final String A05 = AbstractC04664a.A0h(0);
    public static final String A03 = AbstractC04664a.A0h(1);
    public static final String A04 = AbstractC04664a.A0h(2);
    public static final C1R<Timeline> A01 = new C1R() { // from class: com.facebook.ads.redexgen.X.oP
        @Override // com.instagram.common.viewpoint.core.C1R
        public final C1S A6X(Bundle bundle) {
            return Timeline.A02(bundle);
        }
    };

    public abstract int A06();

    public abstract int A07();

    public abstract int A0A(Object obj);

    public abstract C2125oN A0I(int i2, C2125oN c2125oN, boolean z2);

    public abstract C2123oL A0L(int i2, C2123oL c2123oL, long j);

    public abstract Object A0M(int i2);

    /* JADX WARN: Generic types in debug info not equals: com.facebook.ads.redexgen.X.Am != com.google.common.collect.ImmutableList<com.facebook.ads.androidx.media3.common.Timeline$Period> */
    /* JADX WARN: Generic types in debug info not equals: com.facebook.ads.redexgen.X.Am != com.google.common.collect.ImmutableList<com.facebook.ads.androidx.media3.common.Timeline$Window> */
    public static C05959m A02(Bundle bundle) {
        final AbstractC0621Am abstractC0621AmA04 = A04(C2123oL.A0J, C3R.A00(bundle, A05));
        final AbstractC0621Am abstractC0621AmA042 = A04(C2125oN.A08, C3R.A00(bundle, A03));
        final int[] intArray = bundle.getIntArray(A04);
        if (intArray == null) {
            intArray = A05(abstractC0621AmA04.size());
        }
        ImmutableList<Window> windows = new Timeline(abstractC0621AmA04, abstractC0621AmA042, intArray) { // from class: com.facebook.ads.redexgen.X.9m
            public static String[] A04 = {"nDkuZZEFG4iGMwbsGEvKBo4ueCI7wxif", "OM6NJOBBZMKrUazjZz4CdR8Ljfz9nzwy", "h9AdYD37MAF4FmuzDOyGIvEw", "VkmtOVI9Gbc78hEhNGIz4LiMtzYnUrU2", "bkWqGplua99PBwc9ED6yZtwvDtuw6KwN", "305DBImSoaz5MlD7g6qLfpiwFg5d3Fl", "QtOjLPNYFNek9UnmHWOFtbeX9w", "y2avdvKeY0dhYPEmFhuJXZmeyR2ks2D4"};
            public final AbstractC0621Am<C2125oN> A00;
            public final AbstractC0621Am<C2123oL> A01;
            public final int[] A02;
            public final int[] A03;

            /* JADX WARN: Generic types in debug info not equals: com.facebook.ads.redexgen.X.Am != com.google.common.collect.ImmutableList<com.facebook.ads.androidx.media3.common.Timeline$Period> */
            /* JADX WARN: Generic types in debug info not equals: com.facebook.ads.redexgen.X.Am != com.google.common.collect.ImmutableList<com.facebook.ads.androidx.media3.common.Timeline$Window> */
            /* JADX WARN: Incorrect condition in loop: B:7:0x001b */
            {
                /*
                    r3 = this;
                    r3.<init>()
                    int r1 = r4.size()
                    int r0 = r6.length
                    if (r1 != r0) goto L26
                    r0 = 1
                Lb:
                    com.instagram.common.viewpoint.core.C3M.A07(r0)
                    r3.A01 = r4
                    r3.A00 = r5
                    r3.A02 = r6
                    int r0 = r6.length
                    int[] r0 = new int[r0]
                    r3.A03 = r0
                    r2 = 0
                L1a:
                    int r0 = r6.length
                    if (r2 >= r0) goto L28
                    int[] r1 = r3.A03
                    r0 = r6[r2]
                    r1[r0] = r2
                    int r2 = r2 + 1
                    goto L1a
                L26:
                    r0 = 0
                    goto Lb
                L28:
                    return
                */
                throw new UnsupportedOperationException("Method not decompiled: com.instagram.common.viewpoint.core.C05959m.<init>(com.facebook.ads.redexgen.X.Am, com.facebook.ads.redexgen.X.Am, int[]):void");
            }

            @Override // com.facebook.ads.androidx.media3.common.Timeline
            public final int A06() {
                return this.A00.size();
            }

            @Override // com.facebook.ads.androidx.media3.common.Timeline
            public final int A07() {
                return this.A01.size();
            }

            @Override // com.facebook.ads.androidx.media3.common.Timeline
            public final int A08(int i2, int i8, boolean z2) {
                if (i8 == 1) {
                    return i2;
                }
                if (i2 == A0C(z2)) {
                    if (i8 == 2) {
                        return A0B(z2);
                    }
                    return -1;
                }
                if (z2) {
                    return this.A02[this.A03[i2] + 1];
                }
                return i2 + 1;
            }

            @Override // com.facebook.ads.androidx.media3.common.Timeline
            public final int A0A(Object obj) {
                throw new UnsupportedOperationException();
            }

            @Override // com.facebook.ads.androidx.media3.common.Timeline
            public final int A0B(boolean z2) {
                if (A0N()) {
                    return -1;
                }
                if (!z2) {
                    return 0;
                }
                int[] iArr = this.A02;
                if (A04[1].charAt(22) == 'H') {
                    throw new RuntimeException();
                }
                A04[7] = "6ncpOYdEr0xsUZdZBYFnYejLEosAstPL";
                return iArr[0];
            }

            @Override // com.facebook.ads.androidx.media3.common.Timeline
            public final int A0C(boolean z2) {
                if (A0N()) {
                    return -1;
                }
                if (z2) {
                    return this.A02[A07() - 1];
                }
                return A07() - 1;
            }

            @Override // com.facebook.ads.androidx.media3.common.Timeline
            public final C2125oN A0I(int i2, C2125oN p, boolean z2) {
                C2125oN p2 = this.A00.get(i2);
                p.A0G(p2.A03, p2.A04, p2.A00, p2.A01, p2.A02, p2.A06, p2.A05);
                return p;
            }

            @Override // com.facebook.ads.androidx.media3.common.Timeline
            public final C2123oL A0L(int i2, C2123oL c2123oL, long j) {
                C2123oL c2123oL2 = this.A01.get(i2);
                c2123oL.A07(c2123oL2.A0C, c2123oL2.A09, c2123oL2.A0A, c2123oL2.A06, c2123oL2.A07, c2123oL2.A04, c2123oL2.A0G, c2123oL2.A0D, c2123oL2.A08, c2123oL2.A02, c2123oL2.A03, c2123oL2.A00, c2123oL2.A01, c2123oL2.A05);
                c2123oL.A0F = c2123oL2.A0F;
                return c2123oL;
            }

            @Override // com.facebook.ads.androidx.media3.common.Timeline
            public final Object A0M(int i2) {
                throw new UnsupportedOperationException();
            }
        };
        return windows;
    }

    /* JADX WARN: Generic types in debug info not equals: com.facebook.ads.redexgen.X.1R != com.facebook.ads.androidx.media3.common.Bundleable$Creator<T extends com.facebook.ads.redexgen.X.1S> */
    /* JADX WARN: Generic types in debug info not equals: com.facebook.ads.redexgen.X.1h != com.google.common.collect.ImmutableList$Builder<T extends com.facebook.ads.redexgen.X.1S> */
    public static <T extends C1S> AbstractC0621Am<T> A04(C1R<T> c1r, IBinder iBinder) {
        if (iBinder == null) {
            return AbstractC0621Am.A03();
        }
        C03971h c03971h = new C03971h();
        AbstractC0621Am<Bundle> abstractC0621AmA00 = C1Q.A00(iBinder);
        for (int i2 = 0; i2 < abstractC0621AmA00.size(); i2++) {
            c03971h.A04(c1r.A6X(abstractC0621AmA00.get(i2)));
        }
        return c03971h.A05();
    }

    public static int[] A05(int i2) {
        int[] iArr = new int[i2];
        for (int i8 = 0; i8 < i2; i8++) {
            iArr[i8] = i8;
            int i9 = A00[1].charAt(20);
            if (i9 == 50) {
                throw new RuntimeException();
            }
            String[] strArr = A00;
            strArr[2] = "bm1hpxiL8T70YPoy7qoC4X3DFFhRRvrI";
            strArr[4] = "ZU2doOYnXTdq2XyitRV5O0BVNSu1NLTL";
        }
        return iArr;
    }

    public int A08(int i2, int i8, boolean z2) {
        switch (i8) {
            case 0:
                if (i2 == A0C(z2)) {
                    return -1;
                }
                return i2 + 1;
            case 1:
                return i2;
            case 2:
                int iA0C = A0C(z2);
                String[] strArr = A00;
                if (strArr[3].charAt(14) != strArr[5].charAt(14)) {
                    throw new RuntimeException();
                }
                A00[1] = "R0HEAX03GiDQUcMP0CiDD2yYG3qNGv8H";
                if (i2 == iA0C) {
                    return A0B(z2);
                }
                return i2 + 1;
            default:
                throw new IllegalStateException();
        }
    }

    public final int A09(int i2, C2125oN c2125oN, C2123oL c2123oL, int i8, boolean z2) {
        int i9 = A0H(i2, c2125oN).A00;
        int windowIndex = A0K(i9, c2123oL).A01;
        if (windowIndex == i2) {
            int nextWindowIndex = A08(i9, i8, z2);
            if (nextWindowIndex == -1) {
                return -1;
            }
            int windowIndex2 = A0K(nextWindowIndex, c2123oL).A00;
            return windowIndex2;
        }
        int windowIndex3 = i2 + 1;
        return windowIndex3;
    }

    public int A0B(boolean z2) {
        return A0N() ? -1 : 0;
    }

    public int A0C(boolean z2) {
        if (A0N()) {
            return -1;
        }
        return A07() - 1;
    }

    @Deprecated
    public final Pair<Object, Long> A0D(C2123oL c2123oL, C2125oN c2125oN, int i2, long j) {
        return A0E(c2123oL, c2125oN, i2, j);
    }

    public final Pair<Object, Long> A0E(C2123oL c2123oL, C2125oN c2125oN, int i2, long j) {
        return (Pair) C3M.A01(A0G(c2123oL, c2125oN, i2, j, 0L));
    }

    @Deprecated
    public final Pair<Object, Long> A0F(C2123oL c2123oL, C2125oN c2125oN, int i2, long j, long j3) {
        return A0G(c2123oL, c2125oN, i2, j, j3);
    }

    public final Pair<Object, Long> A0G(C2123oL c2123oL, C2125oN c2125oN, int i2, long j, long j3) {
        C3M.A00(i2, 0, A07());
        A0L(i2, c2123oL, j3);
        if (j == -9223372036854775807L) {
            j = c2123oL.A05();
            if (j == -9223372036854775807L) {
                return null;
            }
        }
        int i8 = c2123oL.A00;
        A0H(i8, c2125oN);
        while (i8 < c2123oL.A01 && c2125oN.A02 != j && A0H(i8 + 1, c2125oN).A02 <= j) {
            i8++;
        }
        A0I(i8, c2125oN, true);
        long jMin = j - c2125oN.A02;
        if (c2125oN.A01 != -9223372036854775807L) {
            long j8 = c2125oN.A01;
            if (A00[1].charAt(20) == '2') {
                throw new RuntimeException();
            }
            A00[1] = "slEcDLMOMSnRw8lzrIQwxe9jf9tcgTic";
            jMin = Math.min(jMin, j8 - 1);
        }
        return Pair.create(C3M.A01(c2125oN.A04), Long.valueOf(Math.max(0L, jMin)));
    }

    public final C2125oN A0H(int i2, C2125oN c2125oN) {
        return A0I(i2, c2125oN, false);
    }

    public C2125oN A0J(Object obj, C2125oN c2125oN) {
        return A0I(A0A(obj), c2125oN, true);
    }

    public final C2123oL A0K(int i2, C2123oL c2123oL) {
        return A0L(i2, c2123oL, 0L);
    }

    public final boolean A0N() {
        return A07() == 0;
    }

    public final boolean A0O(int i2, C2125oN c2125oN, C2123oL c2123oL, int i8, boolean z2) {
        return A09(i2, c2125oN, c2123oL, i8, z2) == -1;
    }

    public final boolean equals(Object obj) {
        int iA0C;
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof Timeline)) {
            return false;
        }
        Timeline timeline = (Timeline) obj;
        if (timeline.A07() != A07() || timeline.A06() != A06()) {
            return false;
        }
        C2123oL c2123oL = new C2123oL();
        C2125oN c2125oN = new C2125oN();
        C2123oL window = new C2123oL();
        C2125oN otherPeriod = new C2125oN();
        for (int i2 = 0; i2 < A07(); i2++) {
            if (!A0K(i2, c2123oL).equals(timeline.A0K(i2, window))) {
                return false;
            }
        }
        for (int i8 = 0; i8 < A06(); i8++) {
            boolean zEquals = A0I(i8, c2125oN, true).equals(timeline.A0I(i8, otherPeriod, true));
            if (A00[6].length() != 11) {
                throw new RuntimeException();
            }
            String[] strArr = A00;
            strArr[7] = "LCXdoHEXleHtD1UyLVprjOGqC7qnADXU";
            strArr[0] = "np8LEsRhRemsbbWWIjAQc1GjKbBRdfRS";
            if (!zEquals) {
                return false;
            }
        }
        int iA0B = A0B(true);
        if (iA0B != timeline.A0B(true) || (iA0C = A0C(true)) != timeline.A0C(true)) {
            return false;
        }
        while (iA0B != iA0C) {
            int iA08 = A08(iA0B, 0, true);
            if (iA08 != timeline.A08(iA0B, 0, true)) {
                return false;
            }
            iA0B = iA08;
        }
        return true;
    }

    public final int hashCode() {
        C2123oL c2123oL = new C2123oL();
        C2125oN c2125oN = new C2125oN();
        int result = 7 * 31;
        int i2 = result + A07();
        for (int i8 = 0; i8 < A07(); i8++) {
            C2123oL window = A0K(i8, c2123oL);
            i2 = (i2 * 31) + window.hashCode();
        }
        int result2 = i2 * 31;
        int i9 = result2 + A06();
        for (int i10 = 0; i10 < A06(); i10++) {
            i9 = (i9 * 31) + A0I(i10, c2125oN, true).hashCode();
        }
        int iA0B = A0B(true);
        while (iA0B != -1) {
            int windowIndex = i9 * 31;
            i9 = windowIndex + iA0B;
            iA0B = A08(iA0B, 0, true);
        }
        return i9;
    }
}
