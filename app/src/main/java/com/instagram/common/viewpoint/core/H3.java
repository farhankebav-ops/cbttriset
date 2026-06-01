package com.instagram.common.viewpoint.core;

/* JADX INFO: loaded from: assets/audience_network.dex */
public final class H3 {
    public int A00;
    public int A01;
    public final int A02;
    public final byte[] A03;

    public H3(byte[] bArr) {
        this.A03 = bArr;
        this.A02 = bArr.length;
    }

    private void A00() {
        C3M.A08(this.A01 >= 0 && (this.A01 < this.A02 || (this.A01 == this.A02 && this.A00 == 0)));
    }

    public final int A01() {
        return (this.A01 * 8) + this.A00;
    }

    public final int A02(int i2) {
        int bitsRead = this.A01;
        int tempByteOffset = Math.min(i2, 8 - this.A00);
        int i8 = bitsRead + 1;
        int tempByteOffset2 = this.A03[bitsRead];
        int tempByteOffset3 = ((tempByteOffset2 & 255) >> this.A00) & (255 >> (8 - tempByteOffset));
        while (tempByteOffset < i2) {
            int returnValue = this.A03[i8];
            tempByteOffset3 |= (returnValue & 255) << tempByteOffset;
            tempByteOffset += 8;
            i8++;
        }
        int returnValue2 = (-1) >>> (32 - i2);
        int tempByteOffset4 = tempByteOffset3 & returnValue2;
        A03(i2);
        return tempByteOffset4;
    }

    public final void A03(int i2) {
        int i8 = i2 / 8;
        int numBytes = this.A01;
        this.A01 = numBytes + i8;
        int numBytes2 = i8 * 8;
        this.A00 += i2 - numBytes2;
        if (this.A00 > 7) {
            int numBytes3 = this.A01;
            this.A01 = numBytes3 + 1;
            int numBytes4 = this.A00;
            this.A00 = numBytes4 - 8;
        }
        A00();
    }

    public final boolean A04() {
        boolean returnValue = (((this.A03[this.A01] & 255) >> this.A00) & 1) == 1;
        A03(1);
        return returnValue;
    }
}
