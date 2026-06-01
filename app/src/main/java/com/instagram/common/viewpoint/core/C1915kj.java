package com.instagram.common.viewpoint.core;

import com.facebook.video.heroplayer.exocustom.MetaExoPlayerCustomization;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/* JADX INFO: renamed from: com.facebook.ads.redexgen.X.kj, reason: case insensitive filesystem */
/* JADX INFO: loaded from: assets/audience_network.dex */
@MetaExoPlayerCustomization(type = {"INCREASE_VISIBILITY"}, value = "To support OculusMp4Extractor")
public final class C1915kj extends II {
    public static byte[] A03;
    public static String[] A04 = {"GA2pmS7X4ROGOgByNCdi18taC", "aAh4RNygY6pz4IdlAQ9iIXEvCFWWkzLF", "JuodTrkofMpjka010", "J1Lmlws0eqmUUC5GC3jhEdxTYojxk4jf", "6Ya7uqSvo", "3XyRCMiSsp8rG7f8J4q6xkUhsqnZzFaE", "VspF2Q", "vTSdivoAe22KROlTGGoK4NP8GmV"};
    public final long A00;
    public final List<C1915kj> A01;
    public final List<C1914ki> A02;

    public static String A04(int i2, int i8, int i9) {
        byte[] bArrCopyOfRange = Arrays.copyOfRange(A03, i2, i2 + i8);
        for (int i10 = 0; i10 < bArrCopyOfRange.length; i10++) {
            bArrCopyOfRange[i10] = (byte) ((bArrCopyOfRange[i10] ^ i9) ^ 84);
        }
        return new String(bArrCopyOfRange);
    }

    public static void A05() {
        A03 = new byte[]{68, 7, 11, 10, 16, 5, 13, 10, 1, 22, 23, 94, 68, 105, 37, 44, 40, 63, 44, 58, 115, 105};
    }

    static {
        A05();
    }

    public C1915kj(int i2, long j) {
        super(i2);
        this.A00 = j;
        this.A02 = new ArrayList();
        this.A01 = new ArrayList();
    }

    public final C1915kj A06(int i2) {
        int size = this.A01.size();
        for (int i8 = 0; i8 < size; i8++) {
            C1915kj c1915kj = this.A01.get(i8);
            int i9 = A04[7].length();
            if (i9 == 3) {
                throw new RuntimeException();
            }
            String[] strArr = A04;
            strArr[1] = "n49CDGF4gSULbNzRfDOXSmTNWTogkE10";
            strArr[3] = "P3Agw1JJwclCkyu9DcuVtuUqOjxfkaYK";
            C1915kj c1915kj2 = c1915kj;
            int childrenSize = ((II) c1915kj2).A00;
            if (childrenSize == i2) {
                return c1915kj2;
            }
        }
        if (A04[4].length() == 14) {
            throw new RuntimeException();
        }
        String[] strArr2 = A04;
        strArr2[1] = "eWhxbLiQvYVwUHrDqb1spRuVxj0ikF7I";
        strArr2[3] = "G0JrlMiW26lgTwAQcPtVzhOkcvjPkvCh";
        return null;
    }

    public final C1914ki A07(int i2) {
        int size = this.A02.size();
        for (int i8 = 0; i8 < size; i8++) {
            C1914ki c1914ki = this.A02.get(i8);
            String[] strArr = A04;
            String str = strArr[2];
            String str2 = strArr[0];
            int i9 = str.length();
            int childrenSize = str2.length();
            if (i9 == childrenSize) {
                throw new RuntimeException();
            }
            A04[5] = "r5cbbIuLaeCnR7fWkiITKmUfsEKVcSuB";
            int childrenSize2 = ((II) c1914ki).A00;
            if (childrenSize2 == i2) {
                return c1914ki;
            }
        }
        return null;
    }

    public final void A08(C1915kj c1915kj) {
        this.A01.add(c1915kj);
    }

    public final void A09(C1914ki c1914ki) {
        this.A02.add(c1914ki);
    }

    @Override // com.instagram.common.viewpoint.core.II
    public final String toString() {
        return II.A02(super.A00) + A04(13, 9, 29) + Arrays.toString(this.A02.toArray()) + A04(0, 13, 48) + Arrays.toString(this.A01.toArray());
    }
}
