package com.bytedance.adsdk.MY.IlO.MY;

import android.graphics.Path;
import android.graphics.PointF;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes3.dex */
public class DmF extends com.bytedance.adsdk.MY.Bc.IlO<PointF> {
    private final com.bytedance.adsdk.MY.Bc.IlO<PointF> EV;
    private Path NV;

    public DmF(com.bytedance.adsdk.MY.Bc bc, com.bytedance.adsdk.MY.Bc.IlO<PointF> ilO) {
        super(bc, ilO.IlO, ilO.MY, ilO.EO, ilO.tV, ilO.Cc, ilO.vCE, ilO.Bc);
        this.EV = ilO;
        IlO();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void IlO() {
        T t3;
        T t7;
        T t8 = this.MY;
        boolean z2 = (t8 == 0 || (t7 = this.IlO) == 0 || !((PointF) t7).equals(((PointF) t8).x, ((PointF) t8).y)) ? false : true;
        T t9 = this.IlO;
        if (t9 == 0 || (t3 = this.MY) == 0 || z2) {
            return;
        }
        com.bytedance.adsdk.MY.Bc.IlO<PointF> ilO = this.EV;
        this.NV = com.bytedance.adsdk.MY.vCE.vCE.IlO((PointF) t9, (PointF) t3, ilO.lEW, ilO.DmF);
    }

    public Path MY() {
        return this.NV;
    }
}
