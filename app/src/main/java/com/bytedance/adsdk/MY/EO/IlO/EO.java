package com.bytedance.adsdk.MY.EO.IlO;

import java.util.Arrays;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes3.dex */
public class EO extends bWL<com.bytedance.adsdk.MY.EO.MY.tV, com.bytedance.adsdk.MY.EO.MY.tV> {
    public EO(List<com.bytedance.adsdk.MY.Bc.IlO<com.bytedance.adsdk.MY.EO.MY.tV>> list) {
        super(IlO(list));
    }

    private static List<com.bytedance.adsdk.MY.Bc.IlO<com.bytedance.adsdk.MY.EO.MY.tV>> IlO(List<com.bytedance.adsdk.MY.Bc.IlO<com.bytedance.adsdk.MY.EO.MY.tV>> list) {
        for (int i2 = 0; i2 < list.size(); i2++) {
            list.set(i2, IlO(list.get(i2)));
        }
        return list;
    }

    @Override // com.bytedance.adsdk.MY.EO.IlO.bWL, com.bytedance.adsdk.MY.EO.IlO.hp
    public /* bridge */ /* synthetic */ List EO() {
        return super.EO();
    }

    @Override // com.bytedance.adsdk.MY.EO.IlO.bWL, com.bytedance.adsdk.MY.EO.IlO.hp
    public /* bridge */ /* synthetic */ boolean MY() {
        return super.MY();
    }

    @Override // com.bytedance.adsdk.MY.EO.IlO.bWL
    public /* bridge */ /* synthetic */ String toString() {
        return super.toString();
    }

    private static com.bytedance.adsdk.MY.Bc.IlO<com.bytedance.adsdk.MY.EO.MY.tV> IlO(com.bytedance.adsdk.MY.Bc.IlO<com.bytedance.adsdk.MY.EO.MY.tV> ilO) {
        com.bytedance.adsdk.MY.EO.MY.tV tVVar = ilO.IlO;
        com.bytedance.adsdk.MY.EO.MY.tV tVVar2 = ilO.MY;
        if (tVVar == null || tVVar2 == null || tVVar.IlO().length == tVVar2.IlO().length) {
            return ilO;
        }
        float[] fArrIlO = IlO(tVVar.IlO(), tVVar2.IlO());
        return ilO.IlO(tVVar.IlO(fArrIlO), tVVar2.IlO(fArrIlO));
    }

    public static float[] IlO(float[] fArr, float[] fArr2) {
        int length = fArr.length + fArr2.length;
        float[] fArr3 = new float[length];
        System.arraycopy(fArr, 0, fArr3, 0, fArr.length);
        System.arraycopy(fArr2, 0, fArr3, fArr.length, fArr2.length);
        Arrays.sort(fArr3);
        float f4 = Float.NaN;
        int i2 = 0;
        for (int i8 = 0; i8 < length; i8++) {
            float f8 = fArr3[i8];
            if (f8 != f4) {
                fArr3[i2] = f8;
                i2++;
                f4 = fArr3[i8];
            }
        }
        return Arrays.copyOfRange(fArr3, 0, i2);
    }

    @Override // com.bytedance.adsdk.MY.EO.IlO.hp
    public com.bytedance.adsdk.MY.IlO.MY.IlO<com.bytedance.adsdk.MY.EO.MY.tV, com.bytedance.adsdk.MY.EO.MY.tV> IlO() {
        return new com.bytedance.adsdk.MY.IlO.MY.Cc(this.IlO);
    }
}
