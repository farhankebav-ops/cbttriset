package com.bytedance.adsdk.MY.Cc;

import android.graphics.Color;
import java.util.Arrays;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes3.dex */
public class ea implements HSR<com.bytedance.adsdk.MY.EO.MY.tV> {
    private int IlO;

    public ea(int i2) {
        this.IlO = i2;
    }

    /* JADX WARN: Removed duplicated region for block: B:38:0x00c9  */
    @Override // com.bytedance.adsdk.MY.Cc.HSR
    /* JADX INFO: renamed from: IlO, reason: merged with bridge method [inline-methods] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public com.bytedance.adsdk.MY.EO.MY.tV MY(android.util.JsonReader r18, float r19) throws java.io.IOException {
        /*
            Method dump skipped, instruction units count: 217
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bytedance.adsdk.MY.Cc.ea.MY(android.util.JsonReader, float):com.bytedance.adsdk.MY.EO.MY.tV");
    }

    private com.bytedance.adsdk.MY.EO.MY.tV IlO(com.bytedance.adsdk.MY.EO.MY.tV tVVar, List<Float> list) {
        int i2 = this.IlO * 4;
        if (list.size() <= i2) {
            return tVVar;
        }
        float[] fArrIlO = tVVar.IlO();
        int[] iArrMY = tVVar.MY();
        int size = (list.size() - i2) / 2;
        float[] fArr = new float[size];
        float[] fArr2 = new float[size];
        int i8 = 0;
        while (i2 < list.size()) {
            if (i2 % 2 == 0) {
                fArr[i8] = list.get(i2).floatValue();
            } else {
                fArr2[i8] = list.get(i2).floatValue();
                i8++;
            }
            i2++;
        }
        float[] fArrIlO2 = IlO(tVVar.IlO(), fArr);
        int length = fArrIlO2.length;
        int[] iArr = new int[length];
        for (int i9 = 0; i9 < length; i9++) {
            float f4 = fArrIlO2[i9];
            int iBinarySearch = Arrays.binarySearch(fArrIlO, f4);
            int iBinarySearch2 = Arrays.binarySearch(fArr, f4);
            if (iBinarySearch >= 0 && iBinarySearch2 <= 0) {
                iArr[i9] = IlO(f4, iArrMY[iBinarySearch], fArr, fArr2);
            } else {
                if (iBinarySearch2 < 0) {
                    iBinarySearch2 = -(iBinarySearch2 + 1);
                }
                iArr[i9] = IlO(f4, fArr2[iBinarySearch2], fArrIlO, iArrMY);
            }
        }
        return new com.bytedance.adsdk.MY.EO.MY.tV(fArrIlO2, iArr);
    }

    public int IlO(float f4, float f8, float[] fArr, int[] iArr) {
        if (iArr.length >= 2 && f4 != fArr[0]) {
            for (int i2 = 1; i2 < fArr.length; i2++) {
                float f9 = fArr[i2];
                if (f9 >= f4 || i2 == fArr.length - 1) {
                    int i8 = i2 - 1;
                    float f10 = fArr[i8];
                    float f11 = (f4 - f10) / (f9 - f10);
                    int i9 = iArr[i2];
                    int i10 = iArr[i8];
                    return Color.argb((int) (f8 * 255.0f), com.bytedance.adsdk.MY.vCE.MY.IlO(f11, Color.red(i10), Color.red(i9)), com.bytedance.adsdk.MY.vCE.MY.IlO(f11, Color.green(i10), Color.green(i9)), com.bytedance.adsdk.MY.vCE.MY.IlO(f11, Color.blue(i10), Color.blue(i9)));
                }
            }
            throw new IllegalArgumentException("Unreachable code.");
        }
        return iArr[0];
    }

    private int IlO(float f4, int i2, float[] fArr, float[] fArr2) {
        float fIlO;
        if (fArr2.length >= 2 && f4 > fArr[0]) {
            for (int i8 = 1; i8 < fArr.length; i8++) {
                float f8 = fArr[i8];
                if (f8 >= f4 || i8 == fArr.length - 1) {
                    if (f8 <= f4) {
                        fIlO = fArr2[i8];
                    } else {
                        int i9 = i8 - 1;
                        float f9 = fArr[i9];
                        fIlO = com.bytedance.adsdk.MY.vCE.Cc.IlO(fArr2[i9], fArr2[i8], (f4 - f9) / (f8 - f9));
                    }
                    return Color.argb((int) (fIlO * 255.0f), Color.red(i2), Color.green(i2), Color.blue(i2));
                }
            }
            throw new IllegalArgumentException("Unreachable code.");
        }
        return Color.argb((int) (fArr2[0] * 255.0f), Color.red(i2), Color.green(i2), Color.blue(i2));
    }

    public static float[] IlO(float[] fArr, float[] fArr2) {
        if (fArr.length == 0) {
            return fArr2;
        }
        if (fArr2.length == 0) {
            return fArr;
        }
        int length = fArr.length + fArr2.length;
        float[] fArr3 = new float[length];
        int i2 = 0;
        int i8 = 0;
        int i9 = 0;
        for (int i10 = 0; i10 < length; i10++) {
            float f4 = i8 < fArr.length ? fArr[i8] : Float.NaN;
            float f8 = i9 < fArr2.length ? fArr2[i9] : Float.NaN;
            if (!Float.isNaN(f8) && f4 >= f8) {
                if (!Float.isNaN(f4) && f8 >= f4) {
                    fArr3[i10] = f4;
                    i8++;
                    i9++;
                    i2++;
                } else {
                    fArr3[i10] = f8;
                    i9++;
                }
            } else {
                fArr3[i10] = f4;
                i8++;
            }
        }
        return i2 == 0 ? fArr3 : Arrays.copyOf(fArr3, length - i2);
    }
}
