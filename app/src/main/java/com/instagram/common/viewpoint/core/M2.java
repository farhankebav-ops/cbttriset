package com.instagram.common.viewpoint.core;

import androidx.core.location.LocationRequestCompat;
import androidx.exifinterface.media.ExifInterface;
import java.io.IOException;
import java.io.InterruptedIOException;

/* JADX INFO: loaded from: assets/audience_network.dex */
public final class M2 {
    public static String[] A0A = {"Zahrr4TzPnlvzL1ryUDBJHiLrNQrc0do", "gdtiLcJnOI63VIDKC4FZh", "mcKRdr7QIVfArpWMDov87T9yp6nn6XkX", "hh9PATM4XXQMpkTMp0yEe4VjsJayobMb", "DHsdxhl2jOmdOKqNSGjxb8rQV1nmB92A", "YMP8jok2HwiV", "9", ExifInterface.LATITUDE_SOUTH};
    public long A00;
    public long A01;
    public long A02;
    public final AnonymousClass56 A03;
    public final InterfaceC0904Ln A04;
    public final C7S A05;
    public final M1 A06;
    public final String A07;
    public final byte[] A08;
    public volatile boolean A09;

    public M2(C7S c7s, AnonymousClass56 anonymousClass56, byte[] bArr, M1 m12) {
        this.A05 = c7s;
        this.A04 = c7s.A0E();
        this.A03 = anonymousClass56;
        this.A08 = bArr == null ? new byte[131072] : bArr;
        this.A06 = m12;
        this.A07 = c7s.A0F().A4d(anonymousClass56);
        this.A02 = anonymousClass56.A04;
    }

    private long A00() {
        if (this.A01 == -1) {
            return -1L;
        }
        return this.A01 - this.A03.A04;
    }

    private long A01(long j, long j3) throws Throwable {
        boolean z2 = j + j3 == this.A01 || j3 == -1;
        long jAFy = -1;
        boolean z7 = false;
        if (j3 != -1) {
            try {
                jAFy = this.A05.AFy(this.A03.A04().A04(j).A03(j3).A09());
                z7 = true;
            } catch (IOException unused) {
                AnonymousClass51.A00(this.A05);
            }
        }
        if (!z7) {
            A02();
            try {
                jAFy = this.A05.AFy(this.A03.A04().A04(j).A03(-1L).A09());
            } catch (IOException e) {
                AnonymousClass51.A00(this.A05);
                throw e;
            }
        }
        int bytesRead = 0;
        if (A0A[3].charAt(20) != 'e') {
            throw new RuntimeException();
        }
        A0A[0] = "hZR9VwpKkwuUXqoAcu0MC0lnjZxabJfZ";
        if (z2 && jAFy != -1) {
            try {
                A04(j + jAFy);
            } catch (IOException e4) {
                AnonymousClass51.A00(this.A05);
                throw e4;
            }
        }
        int i2 = 0;
        while (i2 != -1) {
            A02();
            i2 = this.A05.read(this.A08, 0, this.A08.length);
            if (i2 != -1) {
                A03(i2);
                bytesRead += i2;
            }
        }
        if (z2) {
            A04(((long) bytesRead) + j);
        }
        this.A05.close();
        long j8 = bytesRead;
        String[] strArr = A0A;
        if (strArr[5].length() == strArr[7].length()) {
            throw new RuntimeException();
        }
        String[] strArr2 = A0A;
        strArr2[5] = "HblyszVHSCLV";
        strArr2[7] = "g";
        return j8;
    }

    private void A02() throws InterruptedIOException {
        if (!this.A09) {
        } else {
            throw new InterruptedIOException();
        }
    }

    private void A03(long j) {
        this.A00 += j;
        if (this.A06 != null) {
            this.A06.AEp(A00(), this.A00, j);
        }
    }

    private void A04(long j) {
        if (this.A01 == j) {
            return;
        }
        this.A01 = j;
        if (this.A06 != null) {
            this.A06.AEp(A00(), this.A00, 0L);
        }
    }

    public final void A05() throws IOException {
        long nextRequestLength;
        A02();
        this.A00 = this.A04.A73(this.A07, this.A03.A04, this.A03.A03);
        if (this.A03.A03 != -1) {
            this.A01 = this.A03.A04 + this.A03.A03;
        } else {
            long jA00 = M7.A00(this.A04.A7K(this.A07));
            if (A0A[3].charAt(20) == 'e') {
                String[] strArr = A0A;
                strArr[4] = "d2NeaqM7PiJwxNK1Ah3bQ5GZkUsby9uw";
                strArr[2] = "tLvOBlFvjcFhEySGIYecGT7qbHBlIMmD";
                if (jA00 == -1) {
                    jA00 = -1;
                }
                this.A01 = jA00;
            }
            throw new RuntimeException();
        }
        if (this.A06 != null) {
            this.A06.AEp(A00(), this.A00, 0L);
        }
        while (true) {
            long j = this.A01;
            if (A0A[6].length() == 13) {
                break;
            }
            A0A[1] = "NGuGGBYtFkRF3XmDWlB70";
            if (j == -1 || this.A02 < this.A01) {
                A02();
                if (this.A01 == -1) {
                    nextRequestLength = Long.MAX_VALUE;
                } else {
                    long nextRequestLength2 = this.A01;
                    long blockLength = this.A02;
                    nextRequestLength = nextRequestLength2 - blockLength;
                }
                long jA74 = this.A04.A74(this.A07, this.A02, nextRequestLength);
                if (jA74 > 0) {
                    long blockLength2 = this.A02;
                    this.A02 = blockLength2 + jA74;
                } else {
                    long nextRequestLength3 = -jA74;
                    if (nextRequestLength3 == LocationRequestCompat.PASSIVE_INTERVAL) {
                        nextRequestLength3 = -1;
                    }
                    long j3 = this.A02;
                    long blockLength3 = this.A02;
                    this.A02 = j3 + A01(blockLength3, nextRequestLength3);
                }
            } else {
                return;
            }
        }
    }

    public final void A06() {
        this.A09 = true;
    }
}
