package com.instagram.common.viewpoint.core;

import java.io.IOException;
import java.util.ArrayDeque;
import java.util.Arrays;
import org.checkerframework.checker.nullness.qual.RequiresNonNull;

/* JADX INFO: renamed from: com.facebook.ads.redexgen.X.kr, reason: case insensitive filesystem */
/* JADX INFO: loaded from: assets/audience_network.dex */
public final class C1922kr implements I9 {
    public static byte[] A07;
    public static String[] A08 = {"eVwUBMvHO9uBMhknAGNfZP2yr814WJyE", "k5ILRUABeDXqCwWpN", "hJjZHs3Q8zIp76bYyURn3XwI", "BeESTKEHKjvJbhVudlSNXwxkHuAjvLDZ", "rbeMFWTNNauR3FTC2xnHN2ozIe2oUtV0", "bbPaxRhv7ZvGWrZH", "Yl9CHZRrzKaSrdtxcFsBA9EFbwcoGK5g", "dqSnihCeyqEvBM16"};
    public int A00;
    public int A01;
    public long A02;
    public I8 A03;
    public final byte[] A06 = new byte[8];
    public final ArrayDeque<I6> A05 = new ArrayDeque<>();
    public final IE A04 = new IE();

    public static String A03(int i2, int i8, int i9) {
        byte[] bArrCopyOfRange = Arrays.copyOfRange(A07, i2, i2 + i8);
        for (int i10 = 0; i10 < bArrCopyOfRange.length; i10++) {
            bArrCopyOfRange[i10] = (byte) ((bArrCopyOfRange[i10] - i9) - 15);
        }
        return new String(bArrCopyOfRange);
    }

    public static void A05() {
        A07 = new byte[]{98, -121, -113, 122, -123, -126, 125, 57, 126, -123, 126, -122, 126, -121, -115, 57, -115, -110, -119, 126, 57, 91, -128, -120, 115, 126, 123, 118, 50, 120, 126, -127, 115, -122, 50, -123, 123, -116, 119, 76, 50, -78, -41, -33, -54, -43, -46, -51, -119, -46, -41, -35, -50, -48, -50, -37, -119, -36, -46, -29, -50, -93, -119, -61, -28, -30, -39, -34, -41, -112, -43, -36, -43, -35, -43, -34, -28, -112, -29, -39, -22, -43, -86, -112};
        if (A08[6].charAt(2) != '9') {
            throw new RuntimeException();
        }
        String[] strArr = A08;
        strArr[0] = "OJtOaz7eyeuGy8JHYC7MsYj9KI0teM8x";
        strArr[4] = "Pthq8qREsbuOKTWUYG3bxj4Nb5ptFAt8";
    }

    static {
        A05();
    }

    private double A00(InterfaceC1943lN interfaceC1943lN, int i2) throws IOException {
        long jA02 = A02(interfaceC1943lN, i2);
        if (i2 == 4) {
            return Float.intBitsToFloat((int) jA02);
        }
        return Double.longBitsToDouble(jA02);
    }

    @RequiresNonNull({"processor"})
    private long A01(InterfaceC1943lN interfaceC1943lN) throws IOException {
        interfaceC1943lN.AI1();
        while (true) {
            interfaceC1943lN.AG9(this.A06, 0, 4);
            int iA00 = IE.A00(this.A06[0]);
            if (iA00 != -1 && iA00 <= 4) {
                int iA01 = (int) IE.A01(this.A06, iA00, false);
                if (this.A03.AAN(iA01)) {
                    interfaceC1943lN.AJJ(iA00);
                    return iA01;
                }
            }
            interfaceC1943lN.AJJ(1);
        }
    }

    private long A02(InterfaceC1943lN interfaceC1943lN, int i2) throws IOException {
        interfaceC1943lN.readFully(this.A06, 0, i2);
        long j = 0;
        for (int i8 = 0; i8 < i2; i8++) {
            long value = this.A06[i8] & 255;
            j = (j << 8) | value;
        }
        return j;
    }

    public static String A04(InterfaceC1943lN interfaceC1943lN, int i2) throws IOException {
        if (i2 == 0) {
            return A03(0, 0, 32);
        }
        byte[] bArr = new byte[i2];
        interfaceC1943lN.readFully(bArr, 0, i2);
        while (i2 > 0 && bArr[i2 - 1] == 0) {
            i2--;
        }
        return new String(bArr, 0, i2);
    }

    @Override // com.instagram.common.viewpoint.core.I9
    public final void AA5(I8 i8) {
        this.A03 = i8;
    }

    /* JADX WARN: Code restructure failed: missing block: B:43:0x011d, code lost:
    
        if (r0 <= 2147483647L) goto L44;
     */
    /* JADX WARN: Code restructure failed: missing block: B:44:0x011f, code lost:
    
        r12.A03.AJZ(r12.A00, A04(r13, (int) r12.A02));
        r12.A01 = 0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:45:0x012f, code lost:
    
        return true;
     */
    /* JADX WARN: Code restructure failed: missing block: B:47:0x0137, code lost:
    
        if (r0 <= 2147483647L) goto L44;
     */
    /* JADX WARN: Code restructure failed: missing block: B:50:0x015b, code lost:
    
        throw com.instagram.common.viewpoint.core.C04222i.A01(A03(63, 21, 97) + r12.A02, null);
     */
    @Override // com.instagram.common.viewpoint.core.I9
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final boolean AGe(com.instagram.common.viewpoint.core.InterfaceC1943lN r13) throws java.io.IOException {
        /*
            Method dump skipped, instruction units count: 454
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.instagram.common.viewpoint.core.C1922kr.AGe(com.facebook.ads.redexgen.X.lN):boolean");
    }

    @Override // com.instagram.common.viewpoint.core.I9
    public final void reset() {
        this.A01 = 0;
        this.A05.clear();
        this.A04.A06();
    }
}
