package com.bytedance.adsdk.MY.IlO.MY;

import android.graphics.Path;
import android.graphics.PathMeasure;
import android.graphics.PointF;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes3.dex */
public class NV extends Bc<PointF> {
    private DmF Bc;
    private final float[] Cc;
    private final PointF tV;
    private final PathMeasure vCE;

    public NV(List<? extends com.bytedance.adsdk.MY.Bc.IlO<PointF>> list) {
        super(list);
        this.tV = new PointF();
        this.Cc = new float[2];
        this.vCE = new PathMeasure();
    }

    @Override // com.bytedance.adsdk.MY.IlO.MY.IlO
    /* JADX INFO: renamed from: MY, reason: merged with bridge method [inline-methods] */
    public PointF IlO(com.bytedance.adsdk.MY.Bc.IlO<PointF> ilO, float f4) {
        DmF dmF = (DmF) ilO;
        Path pathMY = dmF.MY();
        if (pathMY == null) {
            return ilO.IlO;
        }
        if (this.EO != null) {
            dmF.Bc.getClass();
            tV();
            lEW();
            throw null;
        }
        if (this.Bc != dmF) {
            this.vCE.setPath(pathMY, false);
            this.Bc = dmF;
        }
        PathMeasure pathMeasure = this.vCE;
        pathMeasure.getPosTan(pathMeasure.getLength() * f4, this.Cc, null);
        PointF pointF = this.tV;
        float[] fArr = this.Cc;
        pointF.set(fArr[0], fArr[1]);
        return this.tV;
    }
}
