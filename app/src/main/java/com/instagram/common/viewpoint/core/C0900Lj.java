package com.instagram.common.viewpoint.core;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: renamed from: com.facebook.ads.redexgen.X.Lj, reason: case insensitive filesystem */
/* JADX INFO: loaded from: assets/audience_network.dex */
public final class C0900Lj {
    public static byte[] A0W;
    public static String[] A0X = {"lVJcyHuE1PJb579Sb1LAAlg5vS4NZYMV", "qyLkbqfl0JpOOnDgJdZjiTPjgkzmhXwK", "qCNdEz7ripOZNNb3yCY8Ki49zW8UWRt4", "Cjqz4QIw8w0k6KevPFem8GYP4yUKgFOK", "ptM4eVx6M57F8Ll6MNcW2L659ErB2sOY", "McIwIiSAB", "OKPGVpQZykPiX00cv", "DTBK8GKi"};
    public final int A00;
    public final int A01;
    public final int A02;
    public final int A03;
    public final int A04;
    public final int A05;
    public final int A06;
    public final int A07;
    public final int A08;
    public final int A09;
    public final long A0A;
    public final long A0B;
    public final long A0C;
    public final long A0D;
    public final long A0E;
    public final long A0F;
    public final long A0G;
    public final C0898Lh A0H;
    public final C0899Li A0I;
    public final String A0J;
    public final String A0K;
    public final String A0L;
    public final String A0M;
    public final String A0N;
    public final String A0O;
    public final String A0P;
    public final Map<String, String> A0Q;
    public final boolean A0R;
    public final boolean A0S;
    public final boolean A0T;
    public final boolean A0U;
    public final boolean A0V;

    public static String A00(int i2, int i8, int i9) {
        byte[] bArrCopyOfRange = Arrays.copyOfRange(A0W, i2, i2 + i8);
        for (int i10 = 0; i10 < bArrCopyOfRange.length; i10++) {
            byte b8 = (byte) ((bArrCopyOfRange[i10] ^ i9) ^ 89);
            if (A0X[4].charAt(24) == 'w') {
                throw new RuntimeException();
            }
            A0X[3] = "PXVGXjtmkErHxa13ZrhtcOEvw3ek";
            bArrCopyOfRange[i10] = b8;
        }
        return new String(bArrCopyOfRange);
    }

    public static void A01() {
        A0W = new byte[]{72, 68};
    }

    static {
        A01();
    }

    public C0900Lj() {
        this(A00(0, 0, 39), -1L, false, -1, -1, -1, -1, false, false, -1, -1L, new C0899Li(), -1L, false, -1, -1, -1L, -1L, -1, null, -1, null, null, C0898Lh.A02, -1, false, A00(0, 0, 39), A00(0, 0, 39), A00(0, 0, 39), null, -1L, -1L);
    }

    public C0900Lj(C0900Lj c0900Lj) {
        this(c0900Lj, c0900Lj.A0N);
    }

    public C0900Lj(C0900Lj c0900Lj, String str) {
        this(c0900Lj.A0M, c0900Lj.A0A, c0900Lj.A0T, c0900Lj.A08, c0900Lj.A07, c0900Lj.A00, c0900Lj.A09, c0900Lj.A0V, c0900Lj.A0S, c0900Lj.A05, c0900Lj.A0C, c0900Lj.A0I, c0900Lj.A0F, c0900Lj.A0U, c0900Lj.A06, c0900Lj.A02, c0900Lj.A0E, c0900Lj.A0B, c0900Lj.A01, c0900Lj.A0Q, c0900Lj.A04, c0900Lj.A0K, c0900Lj.A0J, c0900Lj.A0H, c0900Lj.A03, c0900Lj.A0R, c0900Lj.A0O, c0900Lj.A0L, c0900Lj.A0P, str, -1L, -1L);
    }

    public C0900Lj(String str, long j, boolean z2, int i2, int i8, int i9, int i10, boolean z7, boolean z8, int i11, long j3, C0899Li c0899Li, long j8, boolean z9, int i12, int i13, long j9, long j10, int i14, Map<String, String> map, int i15, String str2, String str3, C0898Lh c0898Lh, int i16, boolean z10, String str4, String str5, String str6, String str7, long j11, long j12) {
        this.A0Q = new HashMap();
        this.A0M = str;
        this.A0A = j;
        this.A0T = z2;
        this.A08 = i2;
        this.A07 = i8;
        this.A00 = i9;
        this.A09 = i10;
        this.A0V = z7;
        this.A0S = z8;
        this.A05 = i11;
        this.A0C = j3;
        this.A0I = c0899Li;
        this.A0F = j8;
        this.A0U = z9;
        this.A06 = i12;
        this.A02 = i13;
        this.A0E = j9;
        this.A0B = j10;
        this.A01 = i14;
        this.A04 = i15;
        this.A0J = str3;
        this.A0K = str2;
        if (map != null) {
            this.A0Q.putAll(map);
        }
        this.A0H = c0898Lh;
        this.A03 = i16;
        this.A0R = z10;
        this.A0O = str4;
        this.A0L = str5;
        this.A0P = str6;
        this.A0N = str7;
        this.A0G = j11;
        this.A0D = j12;
    }

    public final String toString() {
        StringBuilder sbAppend = new StringBuilder().append(this.A0M);
        String strA00 = A00(0, 2, 61);
        return sbAppend.append(strA00).append(this.A0A).append(strA00).append(this.A0T).append(strA00).append(this.A08).append(strA00).append(this.A07).append(strA00).append(this.A00).append(strA00).append(this.A09).append(strA00).append(this.A0V).append(strA00).append(this.A0S).append(strA00).append(this.A05).append(strA00).append(this.A0E).append(strA00).append(this.A0B).append(strA00).append(this.A01).append(strA00).append(this.A04).append(strA00).append(this.A06).append(strA00).append(this.A02).append(strA00).append(this.A03).append(strA00).append(this.A0R).append(strA00).append(this.A0O).toString();
    }
}
