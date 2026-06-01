package com.instagram.common.viewpoint.core;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Arrays;

/* JADX INFO: renamed from: com.facebook.ads.redexgen.X.bw, reason: case insensitive filesystem */
/* JADX INFO: loaded from: assets/audience_network.dex */
public final class C1391bw extends InputStream {
    public static byte[] A04;
    public MessageDigest A00;
    public final C1451cu A01;
    public final InterfaceC1390bv A02;
    public final FileInputStream A03;

    static {
        A01();
    }

    public static String A00(int i2, int i8, int i9) {
        byte[] bArrCopyOfRange = Arrays.copyOfRange(A04, i2, i2 + i8);
        for (int i10 = 0; i10 < bArrCopyOfRange.length; i10++) {
            bArrCopyOfRange[i10] = (byte) ((bArrCopyOfRange[i10] - i9) - 43);
        }
        return new String(bArrCopyOfRange);
    }

    public static void A01() {
        A04 = new byte[]{-52, -61, -76, -23, -8, -15};
    }

    public C1391bw(C1451cu c1451cu, FileInputStream fileInputStream, InterfaceC1390bv interfaceC1390bv) {
        this.A03 = fileInputStream;
        this.A02 = interfaceC1390bv;
        this.A01 = c1451cu;
        try {
            this.A00 = MessageDigest.getInstance(A00(0, 3, 84));
        } catch (NoSuchAlgorithmException unused) {
            this.A00 = null;
        }
    }

    @Override // java.io.InputStream
    public final int available() throws IOException {
        return this.A03.available();
    }

    @Override // java.io.InputStream
    public final int read() throws IOException {
        byte[] b8 = new byte[1];
        return read(b8);
    }

    @Override // java.io.InputStream
    public final int read(byte[] bArr, int i2, int i8) throws IOException {
        int i9 = this.A03.read(bArr, i2, i8);
        if (this.A00 != null) {
            try {
                if (i9 > 0) {
                    this.A00.update(bArr, i2, i9);
                } else if (i9 == -1) {
                    this.A02.A9k(C1183Wo.A05(this.A00.digest()));
                    this.A00 = null;
                }
            } catch (Exception e) {
                this.A00 = null;
                this.A01.A08().ABR(A00(3, 3, 90), AbstractC1090Sv.A13, new C1091Sw(e));
            }
        }
        return i9;
    }

    @Override // java.io.InputStream
    public final long skip(long j) throws IOException {
        int actuallyRead = (int) j;
        byte[] bArr = new byte[1024];
        long j3 = 0;
        while (actuallyRead > 0) {
            int bytesToRead = read(bArr, 0, Math.min(actuallyRead, 1024));
            if (bytesToRead <= 0) {
                break;
            }
            actuallyRead -= bytesToRead;
            j3 += (long) bytesToRead;
        }
        return j3;
    }
}
