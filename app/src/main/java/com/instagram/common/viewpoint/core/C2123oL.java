package com.instagram.common.viewpoint.core;

import android.net.Uri;
import android.os.Bundle;
import java.util.Arrays;

/* JADX INFO: renamed from: com.facebook.ads.redexgen.X.oL, reason: case insensitive filesystem */
/* JADX INFO: loaded from: assets/audience_network.dex */
public final class C2123oL implements C1S {
    public static byte[] A0H;
    public static String[] A0I = {"AtN4gZlBq", "c6vG0ZoB350sNCwGTcbmyQxG", "GzjisXMF7MeBETThzgY0McLZmUxvZEHG", "X6Q", "OR9IAwpAbXPQPDykEqLOHO0nD", "OJOMvHQBuYweGyqOlvOJ7Ft7l3L2", "Cgb", "Ei80eZ3oJ"};
    public static final C1R<C2123oL> A0J;
    public static final Object A0K;
    public static final C2145oi A0L;
    public static final Object A0M;
    public static final String A0N;
    public static final String A0O;
    public static final String A0P;
    public static final String A0Q;
    public static final String A0R;
    public static final String A0S;
    public static final String A0T;
    public static final String A0U;
    public static final String A0V;
    public static final String A0W;
    public static final String A0X;
    public static final String A0Y;
    public static final String A0Z;
    public int A00;
    public int A01;
    public long A02;
    public long A03;
    public long A04;
    public long A05;
    public long A06;
    public long A07;
    public C2147ok A08;
    public Object A0A;

    @Deprecated
    public Object A0B;
    public boolean A0D;

    @Deprecated
    public boolean A0E;
    public boolean A0F;
    public boolean A0G;
    public Object A0C = A0K;
    public C2145oi A09 = A0L;

    /* JADX WARN: Failed to parse debug info
    java.lang.ArrayIndexOutOfBoundsException: Index 30 out of bounds for length 30
    	at jadx.plugins.input.dex.sections.debuginfo.DebugInfoParser.startVar(DebugInfoParser.java:203)
    	at jadx.plugins.input.dex.sections.debuginfo.DebugInfoParser.process(DebugInfoParser.java:125)
    	at jadx.plugins.input.dex.sections.DexCodeReader.getDebugInfo(DexCodeReader.java:122)
    	at jadx.core.dex.nodes.MethodNode.getDebugInfo(MethodNode.java:645)
    	at jadx.core.dex.visitors.debuginfo.DebugInfoAttachVisitor.visit(DebugInfoAttachVisitor.java:38)
     */
    public static C2123oL A00(Bundle bundle) {
        C2147ok c2147ok;
        Bundle bundle2 = bundle.getBundle(A0W);
        C2145oi c2145oi = bundle2 != null ? (C2145oi) C2145oi.A08.A6X(bundle2) : C2145oi.A09;
        long j = bundle.getLong(A0Y, -9223372036854775807L);
        long j3 = bundle.getLong(A0Z, -9223372036854775807L);
        long j8 = bundle.getLong(A0P, -9223372036854775807L);
        boolean z2 = bundle.getBoolean(A0T, false);
        boolean z7 = bundle.getBoolean(A0R, false);
        Bundle bundle3 = bundle.getBundle(A0V);
        if (bundle3 != null) {
            c2147ok = (C2147ok) C2147ok.A06.A6X(bundle3);
        } else {
            c2147ok = null;
            if (A0I[2].charAt(1) != 'z') {
                throw new RuntimeException();
            }
            String[] strArr = A0I;
            strArr[6] = "auZ";
            strArr[3] = "aKQ";
        }
        boolean z8 = bundle.getBoolean(A0S, false);
        long j9 = bundle.getLong(A0N, 0L);
        long j10 = bundle.getLong(A0O, -9223372036854775807L);
        int i2 = bundle.getInt(A0Q, 0);
        int i8 = bundle.getInt(A0U, 0);
        long j11 = bundle.getLong(A0X, 0L);
        C2123oL c2123oL = new C2123oL();
        c2123oL.A07(A0M, c2145oi, null, j, j3, j8, z2, z7, c2147ok, j9, j10, i2, i8, j11);
        c2123oL.A0F = z8;
        return c2123oL;
    }

    public static String A02(int i2, int i8, int i9) {
        byte[] bArrCopyOfRange = Arrays.copyOfRange(A0H, i2, i2 + i8);
        for (int i10 = 0; i10 < bArrCopyOfRange.length; i10++) {
            bArrCopyOfRange[i10] = (byte) ((bArrCopyOfRange[i10] ^ i9) ^ 14);
        }
        return new String(bArrCopyOfRange);
    }

    public static void A03() {
        A0H = new byte[]{6, 10, 8, 75, 3, 4, 6, 0, 7, 10, 10, 14, 75, 4, 1, 22, 75, 4, 11, 1, 23, 10, 12, 1, 29, 75, 8, 0, 1, 12, 4, 86, 75, 6, 10, 8, 8, 10, 11, 75, 49, 12, 8, 0, 9, 12, 11, 0};
    }

    static {
        A03();
        A0K = new Object();
        A0M = new Object();
        A0L = new C2I().A03(A02(0, 48, 107)).A00(Uri.EMPTY).A05();
        A0W = AbstractC04664a.A0h(1);
        A0Y = AbstractC04664a.A0h(2);
        A0Z = AbstractC04664a.A0h(3);
        A0P = AbstractC04664a.A0h(4);
        A0T = AbstractC04664a.A0h(5);
        A0R = AbstractC04664a.A0h(6);
        A0V = AbstractC04664a.A0h(7);
        A0S = AbstractC04664a.A0h(8);
        A0N = AbstractC04664a.A0h(9);
        A0O = AbstractC04664a.A0h(10);
        A0Q = AbstractC04664a.A0h(11);
        A0U = AbstractC04664a.A0h(12);
        A0X = AbstractC04664a.A0h(13);
        A0J = new C1R() { // from class: com.facebook.ads.redexgen.X.oM
            @Override // com.instagram.common.viewpoint.core.C1R
            public final C1S A6X(Bundle bundle) {
                return C2123oL.A00(bundle);
            }
        };
    }

    public final long A04() {
        return AbstractC04664a.A0P(this.A02);
    }

    public final long A05() {
        return this.A02;
    }

    public final long A06() {
        return AbstractC04664a.A0P(this.A03);
    }

    /* JADX WARN: Removed duplicated region for block: B:16:0x0041  */
    /* JADX WARN: Removed duplicated region for block: B:26:0x0082  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final com.instagram.common.viewpoint.core.C2123oL A07(java.lang.Object r6, com.instagram.common.viewpoint.core.C2145oi r7, java.lang.Object r8, long r9, long r11, long r13, boolean r15, boolean r16, com.instagram.common.viewpoint.core.C2147ok r17, long r18, long r20, int r22, int r23, long r24) {
        /*
            r5 = this;
            r3 = r5
            r3.A0C = r6
            if (r7 == 0) goto L1c
            r0 = r7
        L6:
            r3.A09 = r0
            java.lang.String[] r1 = com.instagram.common.viewpoint.core.C2123oL.A0I
            r0 = 2
            r1 = r1[r0]
            r0 = 1
            char r1 = r1.charAt(r0)
            r0 = 122(0x7a, float:1.71E-43)
            if (r1 == r0) goto L1f
            java.lang.RuntimeException r0 = new java.lang.RuntimeException
            r0.<init>()
            throw r0
        L1c:
            com.facebook.ads.redexgen.X.oi r0 = com.instagram.common.viewpoint.core.C2123oL.A0L
            goto L6
        L1f:
            java.lang.String[] r2 = com.instagram.common.viewpoint.core.C2123oL.A0I
            java.lang.String r1 = "sHLAwqiYlmMVa087WjDP7yFYW"
            r0 = 5
            r2[r0] = r1
            if (r7 == 0) goto L82
            com.facebook.ads.redexgen.X.2Q r4 = r7.A03
            java.lang.String[] r1 = com.instagram.common.viewpoint.core.C2123oL.A0I
            r0 = 2
            r1 = r1[r0]
            r0 = 1
            char r1 = r1.charAt(r0)
            r0 = 122(0x7a, float:1.71E-43)
            if (r1 == r0) goto L78
            java.lang.String[] r2 = com.instagram.common.viewpoint.core.C2123oL.A0I
            java.lang.String r1 = "JzGzHC0FwGnnWhMzWBrJaCXM29VIx9g1"
            r0 = 2
            r2[r0] = r1
            if (r4 == 0) goto L82
        L41:
            com.facebook.ads.redexgen.X.2Q r0 = r7.A03
            java.lang.Object r0 = r0.A03
        L45:
            r3.A0B = r0
            r3.A0A = r8
            r3.A06 = r9
            r3.A07 = r11
            r3.A04 = r13
            r3.A0G = r15
            r0 = r16
            r3.A0D = r0
            r1 = r17
            if (r1 == 0) goto L76
            r0 = 1
        L5a:
            r3.A0E = r0
            r3.A08 = r1
            r0 = r18
            r3.A02 = r0
            r0 = r20
            r3.A03 = r0
            r0 = r22
            r3.A00 = r0
            r0 = r23
            r3.A01 = r0
            r0 = r24
            r3.A05 = r0
            r0 = 0
            r3.A0F = r0
            return r3
        L76:
            r0 = 0
            goto L5a
        L78:
            java.lang.String[] r2 = com.instagram.common.viewpoint.core.C2123oL.A0I
            java.lang.String r1 = "IGwZtC"
            r0 = 5
            r2[r0] = r1
            if (r4 == 0) goto L82
            goto L41
        L82:
            r0 = 0
            goto L45
        */
        throw new UnsupportedOperationException("Method not decompiled: com.instagram.common.viewpoint.core.C2123oL.A07(java.lang.Object, com.facebook.ads.redexgen.X.oi, java.lang.Object, long, long, long, boolean, boolean, com.facebook.ads.redexgen.X.ok, long, long, int, int, long):com.facebook.ads.redexgen.X.oL");
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || !getClass().equals(obj.getClass())) {
            return false;
        }
        C2123oL c2123oL = (C2123oL) obj;
        if (AbstractC04664a.A1E(this.A0C, c2123oL.A0C) && AbstractC04664a.A1E(this.A09, c2123oL.A09) && AbstractC04664a.A1E(this.A0A, c2123oL.A0A) && AbstractC04664a.A1E(this.A08, c2123oL.A08) && this.A06 == c2123oL.A06 && this.A07 == c2123oL.A07 && this.A04 == c2123oL.A04 && this.A0G == c2123oL.A0G && this.A0D == c2123oL.A0D && this.A0F == c2123oL.A0F && this.A02 == c2123oL.A02 && this.A03 == c2123oL.A03 && this.A00 == c2123oL.A00 && this.A01 == c2123oL.A01) {
            long j = this.A05;
            long j3 = c2123oL.A05;
            String[] strArr = A0I;
            if (strArr[6].length() != strArr[3].length()) {
                throw new RuntimeException();
            }
            String[] strArr2 = A0I;
            strArr2[6] = "Zdu";
            strArr2[3] = "ITW";
            if (j == j3) {
                return true;
            }
        }
        return false;
    }

    public final int hashCode() {
        int iHashCode = (((((((((((((((7 * 31) + this.A0C.hashCode()) * 31) + this.A09.hashCode()) * 31) + (this.A0A == null ? 0 : this.A0A.hashCode())) * 31) + (this.A08 != null ? this.A08.hashCode() : 0)) * 31) + ((int) (this.A06 ^ (this.A06 >>> 32)))) * 31) + ((int) (this.A07 ^ (this.A07 >>> 32)))) * 31) + ((int) (this.A04 ^ (this.A04 >>> 32)))) * 31) + (this.A0G ? 1 : 0);
        if (A0I[2].charAt(1) != 'z') {
            throw new RuntimeException();
        }
        String[] strArr = A0I;
        strArr[6] = "6VN";
        strArr[3] = "iNJ";
        return (((((((((((((iHashCode * 31) + (this.A0D ? 1 : 0)) * 31) + (this.A0F ? 1 : 0)) * 31) + ((int) (this.A02 ^ (this.A02 >>> 32)))) * 31) + ((int) (this.A03 ^ (this.A03 >>> 32)))) * 31) + this.A00) * 31) + this.A01) * 31) + ((int) (this.A05 ^ (this.A05 >>> 32)));
    }
}
