package com.bytedance.adsdk.MY.IlO.IlO;

import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Path;
import android.graphics.RectF;
import com.bytedance.adsdk.MY.IlO.MY.IlO;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.ListIterator;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes3.dex */
public class zPa implements Cc, EV, NV, hp, IlO.InterfaceC0025IlO {
    private final com.bytedance.adsdk.MY.IlO.MY.IlO<Float, Float> Bc;
    private final String Cc;
    private final com.bytedance.adsdk.MY.IlO.MY.zPa DmF;
    private final com.bytedance.adsdk.MY.DmF EO;
    private final Matrix IlO = new Matrix();
    private final Path MY = new Path();
    private tV NV;
    private final com.bytedance.adsdk.MY.IlO.MY.IlO<Float, Float> lEW;
    private final com.bytedance.adsdk.MY.EO.EO.IlO tV;
    private final boolean vCE;

    public zPa(com.bytedance.adsdk.MY.DmF dmF, com.bytedance.adsdk.MY.EO.EO.IlO ilO, com.bytedance.adsdk.MY.EO.MY.rp rpVar) {
        this.EO = dmF;
        this.tV = ilO;
        this.Cc = rpVar.IlO();
        this.vCE = rpVar.Cc();
        com.bytedance.adsdk.MY.IlO.MY.IlO<Float, Float> IlO = rpVar.MY().IlO();
        this.Bc = IlO;
        ilO.IlO(IlO);
        IlO.IlO(this);
        com.bytedance.adsdk.MY.IlO.MY.IlO<Float, Float> IlO2 = rpVar.EO().IlO();
        this.lEW = IlO2;
        ilO.IlO(IlO2);
        IlO2.IlO(this);
        com.bytedance.adsdk.MY.IlO.MY.zPa zpaNV = rpVar.tV().NV();
        this.DmF = zpaNV;
        zpaNV.IlO(ilO);
        zpaNV.IlO(this);
    }

    @Override // com.bytedance.adsdk.MY.IlO.IlO.NV
    public void IlO(ListIterator<EO> listIterator) {
        if (this.NV != null) {
            return;
        }
        while (listIterator.hasPrevious() && listIterator.previous() != this) {
        }
        ArrayList arrayList = new ArrayList();
        while (listIterator.hasPrevious()) {
            arrayList.add(listIterator.previous());
            listIterator.remove();
        }
        Collections.reverse(arrayList);
        this.NV = new tV(this.EO, this.tV, "Repeater", this.vCE, arrayList, null);
    }

    @Override // com.bytedance.adsdk.MY.IlO.IlO.hp
    public Path tV() {
        Path pathTV = this.NV.tV();
        this.MY.reset();
        float fFloatValue = this.Bc.Bc().floatValue();
        float fFloatValue2 = this.lEW.Bc().floatValue();
        for (int i2 = ((int) fFloatValue) - 1; i2 >= 0; i2--) {
            this.IlO.set(this.DmF.MY(i2 + fFloatValue2));
            this.MY.addPath(pathTV, this.IlO);
        }
        return this.MY;
    }

    @Override // com.bytedance.adsdk.MY.IlO.IlO.EO
    public void IlO(List<EO> list, List<EO> list2) {
        this.NV.IlO(list, list2);
    }

    @Override // com.bytedance.adsdk.MY.IlO.IlO.Cc
    public void IlO(Canvas canvas, Matrix matrix, int i2) {
        float fFloatValue = this.Bc.Bc().floatValue();
        float fFloatValue2 = this.lEW.Bc().floatValue();
        float fFloatValue3 = this.DmF.MY().Bc().floatValue() / 100.0f;
        float fFloatValue4 = this.DmF.EO().Bc().floatValue() / 100.0f;
        for (int i8 = ((int) fFloatValue) - 1; i8 >= 0; i8--) {
            this.IlO.set(matrix);
            float f4 = i8;
            this.IlO.preConcat(this.DmF.MY(f4 + fFloatValue2));
            this.NV.IlO(canvas, this.IlO, (int) (com.bytedance.adsdk.MY.vCE.Cc.IlO(fFloatValue3, fFloatValue4, f4 / fFloatValue) * i2));
        }
    }

    @Override // com.bytedance.adsdk.MY.IlO.IlO.Cc
    public void IlO(RectF rectF, Matrix matrix, boolean z2) {
        this.NV.IlO(rectF, matrix, z2);
    }

    @Override // com.bytedance.adsdk.MY.IlO.MY.IlO.InterfaceC0025IlO
    public void IlO() {
        this.EO.invalidateSelf();
    }
}
