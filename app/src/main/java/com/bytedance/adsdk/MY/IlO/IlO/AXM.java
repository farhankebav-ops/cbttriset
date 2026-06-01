package com.bytedance.adsdk.MY.IlO.IlO;

import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Matrix;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes3.dex */
public class AXM extends IlO {
    private final com.bytedance.adsdk.MY.IlO.MY.IlO<Integer, Integer> Bc;
    private final String Cc;
    private com.bytedance.adsdk.MY.IlO.MY.IlO<ColorFilter, ColorFilter> lEW;
    private final com.bytedance.adsdk.MY.EO.EO.IlO tV;
    private final boolean vCE;

    public AXM(com.bytedance.adsdk.MY.DmF dmF, com.bytedance.adsdk.MY.EO.EO.IlO ilO, com.bytedance.adsdk.MY.EO.MY.es esVar) {
        super(dmF, ilO, esVar.Bc().IlO(), esVar.lEW().IlO(), esVar.DmF(), esVar.EO(), esVar.tV(), esVar.Cc(), esVar.vCE());
        this.tV = ilO;
        this.Cc = esVar.IlO();
        this.vCE = esVar.NV();
        com.bytedance.adsdk.MY.IlO.MY.IlO<Integer, Integer> IlO = esVar.MY().IlO();
        this.Bc = IlO;
        IlO.IlO(this);
        ilO.IlO(IlO);
    }

    @Override // com.bytedance.adsdk.MY.IlO.IlO.IlO, com.bytedance.adsdk.MY.IlO.IlO.Cc
    public void IlO(Canvas canvas, Matrix matrix, int i2) {
        if (this.vCE) {
            return;
        }
        this.MY.setColor(((com.bytedance.adsdk.MY.IlO.MY.MY) this.Bc).DmF());
        com.bytedance.adsdk.MY.IlO.MY.IlO<ColorFilter, ColorFilter> ilO = this.lEW;
        if (ilO != null) {
            this.MY.setColorFilter(ilO.Bc());
        }
        super.IlO(canvas, matrix, i2);
    }
}
