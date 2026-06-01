package com.instagram.common.viewpoint.core;

import android.text.Layout;
import java.util.Arrays;

/* JADX INFO: renamed from: com.facebook.ads.redexgen.X.Jr, reason: case insensitive filesystem */
/* JADX INFO: loaded from: assets/audience_network.dex */
public final class C0856Jr {
    public static byte[] A0J;
    public static String[] A0K = {"Usxox1Jpg4zI1D26A46628IJoKVIfDOb", "DJj4Y7Lf5wmbgFbmipnyENDrbENW0zBu", "xAirbBVx6sN", "JUHzrsF6PskbrsOcxUQeRZ6EJgAR84BH", "g21uR390", "sct5cBRRGNi", "fSzYgZjiZ3zjw2rk03FKz0970uetzuqd", "YzsQQs1"};
    public float A00;
    public int A02;
    public int A04;
    public Layout.Alignment A0C;
    public Layout.Alignment A0D;
    public C0845Jg A0E;
    public String A0F;
    public String A0G;
    public boolean A0H;
    public boolean A0I;
    public int A07 = -1;
    public int A0B = -1;
    public int A03 = -1;
    public int A06 = -1;
    public int A05 = -1;
    public int A09 = -1;
    public int A08 = -1;
    public int A0A = -1;
    public float A01 = Float.MAX_VALUE;

    public static String A01(int i2, int i8, int i9) {
        byte[] bArrCopyOfRange = Arrays.copyOfRange(A0J, i2, i2 + i8);
        for (int i10 = 0; i10 < bArrCopyOfRange.length; i10++) {
            bArrCopyOfRange[i10] = (byte) ((bArrCopyOfRange[i10] - i9) - 111);
        }
        return new String(bArrCopyOfRange);
    }

    public static void A02() {
        A0J = new byte[]{-24, 7, 9, 17, 13, 24, 21, 27, 20, 10, -58, 9, 21, 18, 21, 24, -58, 14, 7, 25, -58, 20, 21, 26, -58, 8, 11, 11, 20, -58, 10, 11, 12, 15, 20, 11, 10, -44, -27, 14, 13, 19, -65, 2, 14, 11, 14, 17, -65, 7, 0, 18, -65, 13, 14, 19, -65, 1, 4, 4, 13, -65, 3, 4, 5, 8, 13, 4, 3, -51};
    }

    static {
        A02();
    }

    /* JADX WARN: Removed duplicated region for block: B:40:0x00a2  */
    /* JADX WARN: Removed duplicated region for block: B:50:0x00ba  */
    /* JADX WARN: Removed duplicated region for block: B:53:0x00c2  */
    /* JADX WARN: Removed duplicated region for block: B:56:0x00ce  */
    /* JADX WARN: Removed duplicated region for block: B:59:0x00db  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private com.instagram.common.viewpoint.core.C0856Jr A00(com.instagram.common.viewpoint.core.C0856Jr r6, boolean r7) {
        /*
            Method dump skipped, instruction units count: 263
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.instagram.common.viewpoint.core.C0856Jr.A00(com.facebook.ads.redexgen.X.Jr, boolean):com.facebook.ads.redexgen.X.Jr");
    }

    public final float A03() {
        return this.A00;
    }

    public final float A04() {
        return this.A01;
    }

    public final int A05() {
        if (this.A0H) {
            return this.A02;
        }
        throw new IllegalStateException(A01(0, 38, 55));
    }

    public final int A06() {
        if (this.A0I) {
            return this.A04;
        }
        throw new IllegalStateException(A01(38, 32, 48));
    }

    public final int A07() {
        return this.A05;
    }

    public final int A08() {
        return this.A08;
    }

    public final int A09() {
        return this.A09;
    }

    public final int A0A() {
        if (this.A03 == -1 && this.A06 == -1) {
            return -1;
        }
        int i2 = (this.A03 == 1 ? 1 : 0) | (this.A06 == 1 ? 2 : 0);
        String[] strArr = A0K;
        if (strArr[2].length() != strArr[5].length()) {
            throw new RuntimeException();
        }
        String[] strArr2 = A0K;
        strArr2[2] = "pc7acbLDMjB";
        strArr2[5] = "xuQHQFUerHu";
        return i2;
    }

    public final Layout.Alignment A0B() {
        return this.A0C;
    }

    public final Layout.Alignment A0C() {
        return this.A0D;
    }

    public final C0845Jg A0D() {
        return this.A0E;
    }

    public final C0856Jr A0E(float f4) {
        this.A00 = f4;
        return this;
    }

    public final C0856Jr A0F(float f4) {
        this.A01 = f4;
        return this;
    }

    public final C0856Jr A0G(int i2) {
        this.A02 = i2;
        this.A0H = true;
        return this;
    }

    public final C0856Jr A0H(int i2) {
        this.A04 = i2;
        this.A0I = true;
        return this;
    }

    public final C0856Jr A0I(int i2) {
        this.A05 = i2;
        return this;
    }

    public final C0856Jr A0J(int i2) {
        this.A08 = i2;
        return this;
    }

    public final C0856Jr A0K(int i2) {
        this.A09 = i2;
        return this;
    }

    public final C0856Jr A0L(Layout.Alignment alignment) {
        this.A0C = alignment;
        return this;
    }

    public final C0856Jr A0M(Layout.Alignment alignment) {
        this.A0D = alignment;
        return this;
    }

    public final C0856Jr A0N(C0845Jg c0845Jg) {
        this.A0E = c0845Jg;
        return this;
    }

    public final C0856Jr A0O(C0856Jr c0856Jr) {
        return A00(c0856Jr, true);
    }

    public final C0856Jr A0P(String str) {
        this.A0F = str;
        return this;
    }

    public final C0856Jr A0Q(String str) {
        this.A0G = str;
        return this;
    }

    public final C0856Jr A0R(boolean z2) {
        this.A03 = z2 ? 1 : 0;
        return this;
    }

    public final C0856Jr A0S(boolean z2) {
        this.A06 = z2 ? 1 : 0;
        return this;
    }

    public final C0856Jr A0T(boolean z2) {
        this.A07 = z2 ? 1 : 0;
        return this;
    }

    public final C0856Jr A0U(boolean z2) {
        this.A0A = z2 ? 1 : 0;
        return this;
    }

    public final C0856Jr A0V(boolean z2) {
        this.A0B = z2 ? 1 : 0;
        return this;
    }

    public final String A0W() {
        return this.A0F;
    }

    public final String A0X() {
        return this.A0G;
    }

    public final boolean A0Y() {
        return this.A0A == 1;
    }

    public final boolean A0Z() {
        return this.A0H;
    }

    public final boolean A0a() {
        return this.A0I;
    }

    public final boolean A0b() {
        return this.A07 == 1;
    }

    public final boolean A0c() {
        return this.A0B == 1;
    }
}
