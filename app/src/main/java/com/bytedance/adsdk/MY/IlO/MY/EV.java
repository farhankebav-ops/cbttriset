package com.bytedance.adsdk.MY.IlO.MY;

import a1.a;
import android.graphics.PointF;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes3.dex */
public class EV extends Bc<PointF> {
    private final PointF tV;

    public EV(List<com.bytedance.adsdk.MY.Bc.IlO<PointF>> list) {
        super(list);
        this.tV = new PointF();
    }

    @Override // com.bytedance.adsdk.MY.IlO.MY.IlO
    /* JADX INFO: renamed from: MY, reason: merged with bridge method [inline-methods] */
    public PointF IlO(com.bytedance.adsdk.MY.Bc.IlO<PointF> ilO, float f4) {
        return IlO(ilO, f4, f4, f4);
    }

    @Override // com.bytedance.adsdk.MY.IlO.MY.IlO
    /* JADX INFO: renamed from: MY, reason: merged with bridge method [inline-methods] */
    public PointF IlO(com.bytedance.adsdk.MY.Bc.IlO<PointF> ilO, float f4, float f8, float f9) {
        PointF pointF;
        PointF pointF2 = ilO.IlO;
        if (pointF2 == null || (pointF = ilO.MY) == null) {
            throw new IllegalStateException("Missing values for keyframe.");
        }
        PointF pointF3 = pointF2;
        PointF pointF4 = pointF;
        if (this.EO != null) {
            ilO.Bc.getClass();
            tV();
            lEW();
            throw null;
        }
        PointF pointF5 = this.tV;
        float f10 = pointF3.x;
        float fA = a.a(pointF4.x, f10, f8, f10);
        float f11 = pointF3.y;
        pointF5.set(fA, a.a(pointF4.y, f11, f9, f11));
        return this.tV;
    }
}
