package com.bytedance.adsdk.MY.EO.MY;

import a1.a;
import java.util.Arrays;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes3.dex */
public class tV {
    private final float[] IlO;
    private final int[] MY;

    public tV(float[] fArr, int[] iArr) {
        this.IlO = fArr;
        this.MY = iArr;
    }

    public int EO() {
        return this.MY.length;
    }

    public float[] IlO() {
        return this.IlO;
    }

    public int[] MY() {
        return this.MY;
    }

    public void IlO(tV tVVar, tV tVVar2, float f4) {
        if (tVVar.MY.length != tVVar2.MY.length) {
            StringBuilder sb = new StringBuilder("Cannot interpolate between gradients. Lengths vary (");
            sb.append(tVVar.MY.length);
            sb.append(" vs ");
            throw new IllegalArgumentException(a.q(sb, ")", tVVar2.MY.length));
        }
        for (int i2 = 0; i2 < tVVar.MY.length; i2++) {
            this.IlO[i2] = com.bytedance.adsdk.MY.vCE.Cc.IlO(tVVar.IlO[i2], tVVar2.IlO[i2], f4);
            this.MY[i2] = com.bytedance.adsdk.MY.vCE.MY.IlO(f4, tVVar.MY[i2], tVVar2.MY[i2]);
        }
    }

    public tV IlO(float[] fArr) {
        int[] iArr = new int[fArr.length];
        for (int i2 = 0; i2 < fArr.length; i2++) {
            iArr[i2] = IlO(fArr[i2]);
        }
        return new tV(fArr, iArr);
    }

    private int IlO(float f4) {
        int iBinarySearch = Arrays.binarySearch(this.IlO, f4);
        if (iBinarySearch >= 0) {
            return this.MY[iBinarySearch];
        }
        int i2 = -(iBinarySearch + 1);
        if (i2 == 0) {
            return this.MY[0];
        }
        int[] iArr = this.MY;
        if (i2 == iArr.length - 1) {
            return iArr[iArr.length - 1];
        }
        float[] fArr = this.IlO;
        int i8 = i2 - 1;
        float f8 = fArr[i8];
        return com.bytedance.adsdk.MY.vCE.MY.IlO((f4 - f8) / (fArr[i2] - f8), iArr[i8], iArr[i2]);
    }
}
