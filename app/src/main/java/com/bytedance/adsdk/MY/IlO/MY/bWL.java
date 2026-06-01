package com.bytedance.adsdk.MY.IlO.MY;

import android.graphics.PointF;
import java.util.Collections;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes3.dex */
public class bWL extends IlO<PointF, PointF> {
    private final PointF Bc;
    protected com.bytedance.adsdk.MY.Bc.MY<Float> Cc;
    private final IlO<Float, Float> DmF;
    private final IlO<Float, Float> lEW;
    protected com.bytedance.adsdk.MY.Bc.MY<Float> tV;
    private final PointF vCE;

    public bWL(IlO<Float, Float> ilO, IlO<Float, Float> ilO2) {
        super(Collections.EMPTY_LIST);
        this.vCE = new PointF();
        this.Bc = new PointF();
        this.lEW = ilO;
        this.DmF = ilO2;
        IlO(lEW());
    }

    @Override // com.bytedance.adsdk.MY.IlO.MY.IlO
    /* JADX INFO: renamed from: DmF, reason: merged with bridge method [inline-methods] */
    public PointF Bc() {
        return IlO(null, 0.0f);
    }

    @Override // com.bytedance.adsdk.MY.IlO.MY.IlO
    /* JADX INFO: renamed from: MY, reason: merged with bridge method [inline-methods] */
    public PointF IlO(com.bytedance.adsdk.MY.Bc.IlO<PointF> ilO, float f4) {
        if (this.tV != null && this.lEW.EO() != null) {
            this.lEW.Cc();
            throw null;
        }
        if (this.Cc != null && this.DmF.EO() != null) {
            this.DmF.Cc();
            throw null;
        }
        this.Bc.set(this.vCE.x, 0.0f);
        PointF pointF = this.Bc;
        pointF.set(pointF.x, this.vCE.y);
        return this.Bc;
    }

    @Override // com.bytedance.adsdk.MY.IlO.MY.IlO
    public void IlO(float f4) {
        this.lEW.IlO(f4);
        this.DmF.IlO(f4);
        this.vCE.set(this.lEW.Bc().floatValue(), this.DmF.Bc().floatValue());
        for (int i2 = 0; i2 < this.IlO.size(); i2++) {
            this.IlO.get(i2).IlO();
        }
    }
}
