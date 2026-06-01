package com.bytedance.adsdk.MY.EO.IlO;

import android.graphics.PointF;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes3.dex */
public class DmF implements hp<PointF, PointF> {
    private final MY IlO;
    private final MY MY;

    public DmF(MY my, MY my2) {
        this.IlO = my;
        this.MY = my2;
    }

    @Override // com.bytedance.adsdk.MY.EO.IlO.hp
    public List<com.bytedance.adsdk.MY.Bc.IlO<PointF>> EO() {
        throw new UnsupportedOperationException("Cannot call getKeyframes on AnimatableSplitDimensionPathValue.");
    }

    @Override // com.bytedance.adsdk.MY.EO.IlO.hp
    public com.bytedance.adsdk.MY.IlO.MY.IlO<PointF, PointF> IlO() {
        return new com.bytedance.adsdk.MY.IlO.MY.bWL(this.IlO.IlO(), this.MY.IlO());
    }

    @Override // com.bytedance.adsdk.MY.EO.IlO.hp
    public boolean MY() {
        return this.IlO.MY() && this.MY.MY();
    }
}
