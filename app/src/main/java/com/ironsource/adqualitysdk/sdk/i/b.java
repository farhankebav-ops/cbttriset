package com.ironsource.adqualitysdk.sdk.i;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes5.dex */
public final class b {
    /* JADX INFO: renamed from: ｋ, reason: contains not printable characters */
    private static void m762(int[] iArr) {
        for (int i2 = 0; i2 < iArr.length / 2; i2++) {
            int i8 = iArr[i2];
            iArr[i2] = iArr[(iArr.length - i2) - 1];
            iArr[(iArr.length - i2) - 1] = i8;
        }
    }

    /* JADX INFO: renamed from: ﾒ, reason: contains not printable characters */
    public static void m763(int i2, int i8, boolean z2, int i9, int[] iArr, int[][] iArr2, int[] iArr3) {
        if (!z2) {
            m762(iArr);
        }
        int i10 = 0;
        while (i10 < i9) {
            int i11 = i2 ^ iArr[i10];
            int i12 = i8 ^ ((iArr2[2][(i11 >>> 8) & 255] ^ (iArr2[0][i11 >>> 24] + iArr2[1][(i11 >>> 16) & 255])) + iArr2[3][i11 & 255]);
            i10++;
            i8 = i11;
            i2 = i12;
        }
        int i13 = i2 ^ iArr[iArr.length - 2];
        int i14 = i8 ^ iArr[iArr.length - 1];
        if (!z2) {
            m762(iArr);
        }
        iArr3[0] = i14;
        iArr3[1] = i13;
    }
}
