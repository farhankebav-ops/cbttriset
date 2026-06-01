package com.bytedance.sdk.component.MY.IlO.MY;

import java.util.Arrays;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes3.dex */
final class Bc extends tV {
    final transient byte[][] Bc;
    final transient int[] lEW;

    public Bc(IlO ilO, int i2) {
        super(null);
        DmF.IlO(ilO.MY, 0L, i2);
        Cc cc = ilO.IlO;
        int i8 = 0;
        int i9 = 0;
        int i10 = 0;
        while (i9 < i2) {
            int i11 = cc.EO;
            int i12 = cc.MY;
            if (i11 == i12) {
                throw new AssertionError("s.limit == s.pos");
            }
            i9 += i11 - i12;
            i10++;
            cc = cc.vCE;
        }
        this.Bc = new byte[i10][];
        this.lEW = new int[i10 * 2];
        Cc cc2 = ilO.IlO;
        int i13 = 0;
        while (i8 < i2) {
            byte[][] bArr = this.Bc;
            bArr[i13] = cc2.IlO;
            int i14 = cc2.EO;
            int i15 = cc2.MY;
            int i16 = (i14 - i15) + i8;
            i8 = i16 > i2 ? i2 : i16;
            int[] iArr = this.lEW;
            iArr[i13] = i8;
            iArr[bArr.length + i13] = i15;
            cc2.tV = true;
            i13++;
            cc2 = cc2.vCE;
        }
    }

    private tV Cc() {
        return new tV(tV());
    }

    @Override // com.bytedance.sdk.component.MY.IlO.MY.tV
    public int EO() {
        return this.lEW[this.Bc.length - 1];
    }

    @Override // com.bytedance.sdk.component.MY.IlO.MY.tV
    public String IlO() {
        return Cc().IlO();
    }

    @Override // com.bytedance.sdk.component.MY.IlO.MY.tV
    public String MY() {
        return Cc().MY();
    }

    @Override // com.bytedance.sdk.component.MY.IlO.MY.tV
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof tV) {
            tV tVVar = (tV) obj;
            if (tVVar.EO() == EO() && IlO(0, tVVar, 0, EO())) {
                return true;
            }
        }
        return false;
    }

    @Override // com.bytedance.sdk.component.MY.IlO.MY.tV
    public int hashCode() {
        int i2 = this.Cc;
        if (i2 != 0) {
            return i2;
        }
        int length = this.Bc.length;
        int i8 = 0;
        int i9 = 1;
        int i10 = 0;
        while (i8 < length) {
            byte[] bArr = this.Bc[i8];
            int[] iArr = this.lEW;
            int i11 = iArr[length + i8];
            int i12 = iArr[i8];
            int i13 = (i12 - i10) + i11;
            while (i11 < i13) {
                i9 = (i9 * 31) + bArr[i11];
                i11++;
            }
            i8++;
            i10 = i12;
        }
        this.Cc = i9;
        return i9;
    }

    @Override // com.bytedance.sdk.component.MY.IlO.MY.tV
    public byte[] tV() {
        int[] iArr = this.lEW;
        byte[][] bArr = this.Bc;
        byte[] bArr2 = new byte[iArr[bArr.length - 1]];
        int length = bArr.length;
        int i2 = 0;
        int i8 = 0;
        while (i2 < length) {
            int[] iArr2 = this.lEW;
            int i9 = iArr2[length + i2];
            int i10 = iArr2[i2];
            System.arraycopy(this.Bc[i2], i9, bArr2, i8, i10 - i8);
            i2++;
            i8 = i10;
        }
        return bArr2;
    }

    @Override // com.bytedance.sdk.component.MY.IlO.MY.tV
    public String toString() {
        return Cc().toString();
    }

    private int MY(int i2) {
        int iBinarySearch = Arrays.binarySearch(this.lEW, 0, this.Bc.length, i2 + 1);
        return iBinarySearch >= 0 ? iBinarySearch : ~iBinarySearch;
    }

    @Override // com.bytedance.sdk.component.MY.IlO.MY.tV
    public tV IlO(int i2, int i8) {
        return Cc().IlO(i2, i8);
    }

    @Override // com.bytedance.sdk.component.MY.IlO.MY.tV
    public byte IlO(int i2) {
        DmF.IlO(this.lEW[this.Bc.length - 1], i2, 1L);
        int iMY = MY(i2);
        int i8 = iMY == 0 ? 0 : this.lEW[iMY - 1];
        int[] iArr = this.lEW;
        byte[][] bArr = this.Bc;
        return bArr[iMY][(i2 - i8) + iArr[bArr.length + iMY]];
    }

    @Override // com.bytedance.sdk.component.MY.IlO.MY.tV
    public boolean IlO(int i2, tV tVVar, int i8, int i9) {
        if (i2 < 0 || i2 > EO() - i9) {
            return false;
        }
        int iMY = MY(i2);
        while (i9 > 0) {
            int i10 = iMY == 0 ? 0 : this.lEW[iMY - 1];
            int iMin = Math.min(i9, ((this.lEW[iMY] - i10) + i10) - i2);
            int[] iArr = this.lEW;
            byte[][] bArr = this.Bc;
            if (!tVVar.IlO(i8, bArr[iMY], (i2 - i10) + iArr[bArr.length + iMY], iMin)) {
                return false;
            }
            i2 += iMin;
            i8 += iMin;
            i9 -= iMin;
            iMY++;
        }
        return true;
    }

    @Override // com.bytedance.sdk.component.MY.IlO.MY.tV
    public boolean IlO(int i2, byte[] bArr, int i8, int i9) {
        if (i2 < 0 || i2 > EO() - i9 || i8 < 0 || i8 > bArr.length - i9) {
            return false;
        }
        int iMY = MY(i2);
        while (i9 > 0) {
            int i10 = iMY == 0 ? 0 : this.lEW[iMY - 1];
            int iMin = Math.min(i9, ((this.lEW[iMY] - i10) + i10) - i2);
            int[] iArr = this.lEW;
            byte[][] bArr2 = this.Bc;
            if (!DmF.IlO(bArr2[iMY], (i2 - i10) + iArr[bArr2.length + iMY], bArr, i8, iMin)) {
                return false;
            }
            i2 += iMin;
            i8 += iMin;
            i9 -= iMin;
            iMY++;
        }
        return true;
    }
}
