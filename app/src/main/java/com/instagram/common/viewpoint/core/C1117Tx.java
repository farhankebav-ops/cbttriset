package com.instagram.common.viewpoint.core;

import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.Arrays;
import java.util.Locale;

/* JADX INFO: renamed from: com.facebook.ads.redexgen.X.Tx, reason: case insensitive filesystem */
/* JADX INFO: loaded from: assets/audience_network.dex */
public final class C1117Tx {
    public static int A03;
    public static byte[] A04;
    public static String[] A05 = {"60vC7Tqxq", "iit", "yZ8WhL2SKbyHWFuqrbqyqX6q9YBqbSbq", "zou4kHpYoYqOWULjtQgwmQsgY48o5sQE", "Jj1CAbkpCkmlTw2dBaB6fKsG", "LIdASrcH6z6LtpFKNKqsX", "9qyYxkloNYGFw4rMCbrwSMHZV85hWfZp", "eAI5s54jDPvvLg6GHfi1"};
    public C1116Tw A00;
    public boolean A01;
    public final File A02;

    public static String A01(int i2, int i8, int i9) {
        byte[] bArrCopyOfRange = Arrays.copyOfRange(A04, i2, i2 + i8);
        for (int i10 = 0; i10 < bArrCopyOfRange.length; i10++) {
            bArrCopyOfRange[i10] = (byte) ((bArrCopyOfRange[i10] - i9) - 65);
        }
        return new String(bArrCopyOfRange);
    }

    public static void A02() {
        byte[] bArr = {-29, -2, 6, 9, 2, 1, -67, 17, 12, -67, 1, 2, 9, 2, 17, 2, -67, 3, 6, 9, 2, -67, -60, -62, 16, -119, -84, -81, -88, 99, 106, 104, -74, 106, 99, -84, -74, 99, -79, -78, -73, 99, -92, 99, -75, -88, -92, -89, -92, -91, -81, -88, 99, -87, -84, -81, -88, -97, -60, -52, -73, -62, -65, -70, 118, -68, -69, -54, -71, -66, 118, -55, -54, -73, -56, -54, 118, -65, -60, -70, -69, -50, -112, 118, 123, -70, -75, -56, -58, -46, -43, -57, -125, -55, -52, -49, -56, -125, -60, -49, -43, -56, -60, -57, -36, -125, -57, -52, -42, -45, -46, -42, -56, -57};
        String[] strArr = A05;
        if (strArr[2].charAt(17) != strArr[6].charAt(17)) {
            throw new RuntimeException();
        }
        String[] strArr2 = A05;
        strArr2[1] = "hp8";
        strArr2[4] = "JPe8szfYYKMd1bH3O09b0bU9";
        A04 = bArr;
    }

    /* JADX WARN: Failed to parse debug info
    java.lang.ArrayIndexOutOfBoundsException
     */
    public final synchronized int A05() throws IOException {
        return A00().A00;
    }

    /* JADX WARN: Failed to parse debug info
    java.lang.ArrayIndexOutOfBoundsException
     */
    public final synchronized C1108To A06(int i2, byte[] bArr, int i8, int[] iArr, int i9) throws IOException {
        C1116Tw c1116TwA00 = A00();
        int i10 = 1;
        if (i2 < 0) {
            throw new IOException(String.format(Locale.US, A01(57, 29, 21), Integer.valueOf(i2)));
        }
        int i11 = i2;
        int i12 = 0;
        long j = -1;
        boolean z2 = false;
        while (true) {
            if (i11 >= c1116TwA00.A00) {
                break;
            }
            if ((i11 - i2) + i9 >= iArr.length) {
                z2 = true;
                break;
            }
            long j3 = c1116TwA00.A03[i11];
            long j8 = (i11 == c1116TwA00.A00 - i10 ? c1116TwA00.A01 : c1116TwA00.A03[i11 + 1]) - j3;
            if (j == -1) {
                j = j3;
            }
            if (((int) j8) + i12 + i8 > bArr.length) {
                z2 = true;
                break;
            }
            i12 += (int) j8;
            iArr[(i11 - i2) + i9] = (int) j8;
            i11++;
            i10 = 1;
        }
        if (i11 <= i2) {
            return new C1108To(z2 ? EnumC1107Tn.A04 : EnumC1107Tn.A05, i2, i2, 0);
        }
        c1116TwA00.A02.seek(j);
        c1116TwA00.A02.read(bArr, i8, i12);
        return new C1108To(EnumC1107Tn.A03, i2, i11, i12);
    }

    /* JADX WARN: Failed to parse debug info
    java.lang.ArrayIndexOutOfBoundsException
     */
    public final synchronized boolean A09(byte[] bArr) throws IOException {
        C1116Tw c1116TwA00 = A00();
        if (A05() == A03) {
            return false;
        }
        A03(c1116TwA00.A00, c1116TwA00.A01);
        A04(c1116TwA00.A01, bArr);
        c1116TwA00.A02.getFD().sync();
        c1116TwA00.A00++;
        c1116TwA00.A01 += (long) bArr.length;
        return true;
    }

    static {
        A02();
        A03 = 1000;
    }

    public C1117Tx(File file) throws IOException {
        this.A02 = file;
        if (!file.exists()) {
            this.A00 = C1116Tw.A03(file);
        } else if (!file.isFile()) {
            throw new IOException(String.format(Locale.US, A01(25, 32, 2), file.getCanonicalPath()));
        }
    }

    private C1116Tw A00() throws IOException {
        if (!this.A01) {
            if (this.A00 == null) {
                this.A00 = C1116Tw.A04(this.A02);
            }
            return this.A00;
        }
        throw new IOException(A01(86, 28, 34));
    }

    private void A03(int i2, long j) throws IOException {
        this.A00.A03[i2] = j;
        this.A00.A02.seek(C1116Tw.A02(i2));
        this.A00.A02.writeLong(j);
    }

    private void A04(long j, byte[] bArr) throws IOException {
        this.A00.A02.seek(j);
        this.A00.A02.write(bArr);
    }

    public final synchronized void A07() throws IOException {
        this.A01 = true;
        if (this.A00 == null) {
            return;
        }
        RandomAccessFile randomAccessFile = this.A00.A02;
        this.A00 = null;
        randomAccessFile.close();
    }

    public final synchronized void A08() throws IOException {
        if (!this.A01) {
            A07();
            if (!this.A02.delete()) {
                throw new IOException(String.format(Locale.US, A01(0, 25, 92), this.A02.getCanonicalPath()));
            }
        } else {
            throw new IOException(A01(86, 28, 34));
        }
    }
}
