package com.instagram.common.viewpoint.core;

import java.util.Arrays;

/* JADX INFO: loaded from: assets/audience_network.dex */
public final class KK {
    public static final byte[] A04 = {0, 0, 1};
    public int A00;
    public int A01;
    public byte[] A02;
    public boolean A03;

    public KK(int i2) {
        this.A02 = new byte[i2];
    }

    public final void A00() {
        this.A03 = false;
        this.A00 = 0;
        this.A01 = 0;
    }

    public final void A01(byte[] bArr, int i2, int i8) {
        if (!this.A03) {
            return;
        }
        int i9 = i8 - i2;
        int length = this.A02.length;
        int readLength = this.A00;
        if (length < readLength + i9) {
            byte[] bArr2 = this.A02;
            int readLength2 = this.A00;
            this.A02 = Arrays.copyOf(bArr2, (readLength2 + i9) * 2);
        }
        byte[] bArr3 = this.A02;
        int readLength3 = this.A00;
        System.arraycopy(bArr, i2, bArr3, readLength3, i9);
        int readLength4 = this.A00;
        this.A00 = readLength4 + i9;
    }

    public final boolean A02(int i2, int i8) {
        if (this.A03) {
            this.A00 -= i8;
            if (this.A01 == 0 && i2 == 181) {
                this.A01 = this.A00;
            } else {
                this.A03 = false;
                return true;
            }
        } else if (i2 == 179) {
            this.A03 = true;
        }
        A01(A04, 0, A04.length);
        return false;
    }
}
