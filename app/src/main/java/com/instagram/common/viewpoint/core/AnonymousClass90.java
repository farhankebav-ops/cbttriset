package com.instagram.common.viewpoint.core;

import android.net.Uri;
import java.io.EOFException;
import java.io.IOException;
import java.io.InterruptedIOException;
import java.util.Arrays;

/* JADX INFO: renamed from: com.facebook.ads.redexgen.X.90, reason: invalid class name */
/* JADX INFO: loaded from: assets/audience_network.dex */
public final class AnonymousClass90 implements InterfaceC1943lN {
    public static String[] A07 = {"YlHQuKLayYbpqzx9FSV6CQrLdQj96AeM", "S4RZcb4lBSGk97kEvSl91HaEV0P4", "uVSfNf", "Coq", "aQ2CxhcvUBulJYKynnVyQo", "flTysjHMhLtcJrzUbSTnFz15x2mZl", "8oFgaOvQgeQ1BxQlutu1jILF1QVjJ1FW", "wjWZdP"};
    public int A00;
    public int A01;
    public long A02;
    public byte[] A03;
    public final long A04;
    public final InterfaceC2089nl A05;
    public final byte[] A06;

    public AnonymousClass90(InterfaceC2089nl interfaceC2089nl, long j, long j3) {
        this(interfaceC2089nl, j, j3, false);
    }

    public AnonymousClass90(InterfaceC2089nl interfaceC2089nl, long j, long j3, boolean z2) {
        this.A05 = interfaceC2089nl;
        this.A02 = j;
        this.A04 = j3;
        this.A03 = new byte[65536];
        this.A06 = new byte[4096];
    }

    private int A00(int i2) {
        int bytesSkipped = Math.min(this.A00, i2);
        A05(bytesSkipped);
        return bytesSkipped;
    }

    private int A01(byte[] bArr, int i2, int i8) {
        if (this.A00 == 0) {
            return 0;
        }
        int iMin = Math.min(this.A00, i8);
        System.arraycopy(this.A03, 0, bArr, i2, iMin);
        A05(iMin);
        return iMin;
    }

    private int A02(byte[] bArr, int i2, int i8, int i9, boolean z2) throws IOException {
        if (!Thread.interrupted()) {
            int i10 = this.A05.read(bArr, i2 + i9, i8 - i9);
            if (i10 == -1) {
                if (i9 == 0 && z2) {
                    return -1;
                }
                throw new EOFException();
            }
            return i9 + i10;
        }
        throw new InterruptedIOException();
    }

    private void A03(int i2) {
        if (i2 != -1) {
            this.A02 += (long) i2;
        }
    }

    private void A04(int i2) {
        int i8 = this.A01 + i2;
        int requiredLength = this.A03.length;
        if (i8 > requiredLength) {
            int requiredLength2 = this.A03.length;
            int requiredLength3 = 524288 + i8;
            int newPeekCapacity = AbstractC04664a.A07(requiredLength2 * 2, 65536 + i8, requiredLength3);
            this.A03 = Arrays.copyOf(this.A03, newPeekCapacity);
        }
    }

    private void A05(int i2) {
        this.A00 -= i2;
        this.A01 = 0;
        byte[] bArr = this.A03;
        if (this.A00 < this.A03.length - 524288) {
            bArr = new byte[this.A00 + 65536];
        }
        byte[] bArr2 = this.A03;
        int i8 = this.A00;
        if (A07[3].length() != 3) {
            throw new RuntimeException();
        }
        String[] strArr = A07;
        strArr[7] = "U6HOVF";
        strArr[2] = "FLrwJS";
        System.arraycopy(bArr2, i2, bArr, 0, i8);
        this.A03 = bArr;
    }

    public final boolean A06(int i2, boolean z2) throws IOException {
        int iA00 = A00(i2);
        while (true) {
            String[] strArr = A07;
            String str = strArr[1];
            String str2 = strArr[5];
            int length = str.length();
            int bytesSkipped = str2.length();
            if (length == bytesSkipped) {
                throw new RuntimeException();
            }
            String[] strArr2 = A07;
            strArr2[7] = "VT2oIT";
            strArr2[2] = "AHKvNZ";
            if (iA00 >= i2 || iA00 == -1) {
                break;
            }
            int bytesSkipped2 = this.A06.length;
            iA00 = A02(this.A06, -iA00, Math.min(i2, bytesSkipped2 + iA00), iA00, z2);
        }
        A03(iA00);
        return iA00 != -1;
    }

    @Override // com.instagram.common.viewpoint.core.InterfaceC1943lN
    public final void A3z(int i2) throws IOException {
        A40(i2, false);
    }

    /* JADX WARN: Code restructure failed: missing block: B:9:0x0032, code lost:
    
        throw new java.lang.RuntimeException();
     */
    @Override // com.instagram.common.viewpoint.core.InterfaceC1943lN
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final boolean A40(int r7, boolean r8) throws java.io.IOException {
        /*
            r6 = this;
            r3 = r7
            r6.A04(r3)
            int r4 = r6.A00
            int r0 = r6.A01
            int r4 = r4 - r0
        L9:
            if (r4 >= r3) goto L39
            byte[] r1 = r6.A03
            int r2 = r6.A01
            r0 = r6
            r5 = r8
            int r4 = r0.A02(r1, r2, r3, r4, r5)
            r0 = -1
            if (r4 != r0) goto L33
            r3 = 0
            java.lang.String[] r2 = com.instagram.common.viewpoint.core.AnonymousClass90.A07
            r0 = 6
            r1 = r2[r0]
            r0 = 0
            r2 = r2[r0]
            r0 = 25
            char r1 = r1.charAt(r0)
            char r0 = r2.charAt(r0)
            if (r1 == r0) goto L59
        L2d:
            java.lang.RuntimeException r0 = new java.lang.RuntimeException
            r0.<init>()
            throw r0
        L33:
            int r0 = r6.A01
            int r0 = r0 + r4
            r6.A00 = r0
            goto L9
        L39:
            int r0 = r6.A01
            int r0 = r0 + r3
            r6.A01 = r0
            java.lang.String[] r2 = com.instagram.common.viewpoint.core.AnonymousClass90.A07
            r0 = 1
            r1 = r2[r0]
            r0 = 5
            r0 = r2[r0]
            int r1 = r1.length()
            int r0 = r0.length()
            if (r1 == r0) goto L2d
            java.lang.String[] r2 = com.instagram.common.viewpoint.core.AnonymousClass90.A07
            java.lang.String r1 = "05c"
            r0 = 3
            r2[r0] = r1
            r0 = 1
            return r0
        L59:
            java.lang.String[] r2 = com.instagram.common.viewpoint.core.AnonymousClass90.A07
            java.lang.String r1 = "U9yRyStfgEDvt0OpJggQJXPRXL9S"
            r0 = 1
            r2[r0] = r1
            java.lang.String r1 = "yvkfr8ZSlHssIeYh6rwGG04GsxspU"
            r0 = 5
            r2[r0] = r1
            return r3
        */
        throw new UnsupportedOperationException("Method not decompiled: com.instagram.common.viewpoint.core.AnonymousClass90.A40(int, boolean):boolean");
    }

    @Override // com.instagram.common.viewpoint.core.InterfaceC1943lN
    public final long A8G() {
        return this.A04;
    }

    @Override // com.instagram.common.viewpoint.core.InterfaceC1943lN
    public final long A8a() {
        return this.A02 + ((long) this.A01);
    }

    @Override // com.instagram.common.viewpoint.core.InterfaceC1943lN
    public final long A8f() {
        return this.A02;
    }

    @Override // com.instagram.common.viewpoint.core.InterfaceC1943lN
    public final Uri A9H() {
        return this.A05.A9H();
    }

    @Override // com.instagram.common.viewpoint.core.InterfaceC1943lN
    public final int AG8(byte[] bArr, int i2, int i8) throws IOException {
        int iMin;
        A04(i8);
        int bytesPeeked = this.A00 - this.A01;
        if (bytesPeeked == 0) {
            iMin = A02(this.A03, this.A01, i8, 0, true);
            if (iMin == -1) {
                return -1;
            }
            int peekBufferRemainingBytes = this.A00;
            this.A00 = peekBufferRemainingBytes + iMin;
        } else {
            iMin = Math.min(i8, bytesPeeked);
        }
        byte[] bArr2 = this.A03;
        int peekBufferRemainingBytes2 = this.A01;
        System.arraycopy(bArr2, peekBufferRemainingBytes2, bArr, i2, iMin);
        int peekBufferRemainingBytes3 = this.A01;
        this.A01 = peekBufferRemainingBytes3 + iMin;
        return iMin;
    }

    @Override // com.instagram.common.viewpoint.core.InterfaceC1943lN
    public final void AG9(byte[] bArr, int i2, int i8) throws IOException {
        AGA(bArr, i2, i8, false);
    }

    @Override // com.instagram.common.viewpoint.core.InterfaceC1943lN
    public final boolean AGA(byte[] bArr, int i2, int i8, boolean z2) throws IOException {
        if (!A40(i8, z2)) {
            return false;
        }
        System.arraycopy(this.A03, this.A01 - i8, bArr, i2, i8);
        return true;
    }

    @Override // com.instagram.common.viewpoint.core.InterfaceC1943lN
    public final boolean AGh(byte[] bArr, int i2, int i8, boolean z2) throws IOException {
        int iA01 = A01(bArr, i2, i8);
        while (iA01 < i8 && iA01 != -1) {
            iA01 = A02(bArr, i2, i8, iA01, z2);
        }
        A03(iA01);
        return iA01 != -1;
    }

    @Override // com.instagram.common.viewpoint.core.InterfaceC1943lN
    public final void AI1() {
        this.A01 = 0;
    }

    @Override // com.instagram.common.viewpoint.core.InterfaceC1943lN
    public final int AJG(int i2) throws IOException {
        int iA00 = A00(i2);
        if (iA00 == 0) {
            byte[] bArr = this.A06;
            int bytesSkipped = this.A06.length;
            iA00 = A02(bArr, 0, Math.min(i2, bytesSkipped), 0, true);
        }
        A03(iA00);
        String[] strArr = A07;
        String str = strArr[7];
        String str2 = strArr[2];
        int length = str.length();
        int bytesSkipped2 = str2.length();
        if (length != bytesSkipped2) {
            throw new RuntimeException();
        }
        String[] strArr2 = A07;
        strArr2[6] = "4muWdj2u5Q3eId9F7O7O9kyn7QS9F70y";
        strArr2[0] = "MQBZi4ACHP4vbg8D4iuKjBQaYQ9ASuUs";
        return iA00;
    }

    @Override // com.instagram.common.viewpoint.core.InterfaceC1943lN
    public final void AJJ(int i2) throws IOException {
        A06(i2, false);
    }

    @Override // com.instagram.common.viewpoint.core.InterfaceC1943lN, com.instagram.common.viewpoint.core.AnonymousClass20
    public final int read(byte[] bArr, int i2, int i8) throws IOException {
        int bytesRead = A01(bArr, i2, i8);
        if (bytesRead == 0) {
            bytesRead = A02(bArr, i2, i8, 0, true);
        }
        A03(bytesRead);
        return bytesRead;
    }

    @Override // com.instagram.common.viewpoint.core.InterfaceC1943lN
    public final void readFully(byte[] bArr, int i2, int i8) throws IOException {
        AGh(bArr, i2, i8, false);
    }
}
