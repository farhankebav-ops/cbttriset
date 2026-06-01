package com.bytedance.adsdk.MY.EO.EO;

import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.RectF;
import com.bytedance.adsdk.MY.EO.MY.zPa;
import java.util.Collections;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes3.dex */
public class Bc extends IlO {
    private final com.bytedance.adsdk.MY.IlO.IlO.tV Bc;
    private final MY lEW;

    public Bc(com.bytedance.adsdk.MY.DmF dmF, Cc cc, MY my, com.bytedance.adsdk.MY.Bc bc) {
        super(dmF, cc);
        this.lEW = my;
        com.bytedance.adsdk.MY.IlO.IlO.tV tVVar = new com.bytedance.adsdk.MY.IlO.IlO.tV(dmF, this, new zPa("__container", cc.bWL(), false), bc);
        this.Bc = tVVar;
        List<com.bytedance.adsdk.MY.IlO.IlO.EO> list = Collections.EMPTY_LIST;
        tVVar.IlO(list, list);
    }

    @Override // com.bytedance.adsdk.MY.EO.EO.IlO
    public com.bytedance.adsdk.MY.Cc.NV EV() {
        com.bytedance.adsdk.MY.Cc.NV nvEV = super.EV();
        return nvEV != null ? nvEV : this.lEW.EV();
    }

    @Override // com.bytedance.adsdk.MY.EO.EO.IlO, com.bytedance.adsdk.MY.IlO.IlO.Cc
    public void IlO(RectF rectF, Matrix matrix, boolean z2) {
        super.IlO(rectF, matrix, z2);
        this.Bc.IlO(rectF, this.IlO, z2);
    }

    @Override // com.bytedance.adsdk.MY.EO.EO.IlO
    public void MY(Canvas canvas, Matrix matrix, int i2) {
        super.MY(canvas, matrix, i2);
        this.Bc.IlO(canvas, matrix, i2);
    }

    @Override // com.bytedance.adsdk.MY.EO.EO.IlO
    public com.bytedance.adsdk.MY.EO.MY.IlO NV() {
        com.bytedance.adsdk.MY.EO.MY.IlO ilONV = super.NV();
        return ilONV != null ? ilONV : this.lEW.NV();
    }
}
