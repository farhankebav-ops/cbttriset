package com.bytedance.adsdk.MY.EO.IlO;

import android.graphics.PointF;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes3.dex */
public class Cc implements hp<PointF, PointF> {
    private final List<com.bytedance.adsdk.MY.Bc.IlO<PointF>> IlO;

    public Cc(List<com.bytedance.adsdk.MY.Bc.IlO<PointF>> list) {
        this.IlO = list;
    }

    @Override // com.bytedance.adsdk.MY.EO.IlO.hp
    public List<com.bytedance.adsdk.MY.Bc.IlO<PointF>> EO() {
        return this.IlO;
    }

    @Override // com.bytedance.adsdk.MY.EO.IlO.hp
    public com.bytedance.adsdk.MY.IlO.MY.IlO<PointF, PointF> IlO() {
        return this.IlO.get(0).Cc() ? new com.bytedance.adsdk.MY.IlO.MY.EV(this.IlO) : new com.bytedance.adsdk.MY.IlO.MY.NV(this.IlO);
    }

    @Override // com.bytedance.adsdk.MY.EO.IlO.hp
    public boolean MY() {
        return this.IlO.size() == 1 && this.IlO.get(0).Cc();
    }
}
