package com.bytedance.adsdk.MY.EO.MY;

import a1.a;
import android.graphics.PointF;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes3.dex */
public class bWL {
    private boolean EO;
    private final List<com.bytedance.adsdk.MY.EO.IlO> IlO;
    private PointF MY;

    public bWL(PointF pointF, boolean z2, List<com.bytedance.adsdk.MY.EO.IlO> list) {
        this.MY = pointF;
        this.EO = z2;
        this.IlO = new ArrayList(list);
    }

    public List<com.bytedance.adsdk.MY.EO.IlO> EO() {
        return this.IlO;
    }

    public void IlO(float f4, float f8) {
        if (this.MY == null) {
            this.MY = new PointF();
        }
        this.MY.set(f4, f8);
    }

    public boolean MY() {
        return this.EO;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("ShapeData{numCurves=");
        sb.append(this.IlO.size());
        sb.append("closed=");
        return a.t(sb, this.EO, '}');
    }

    public PointF IlO() {
        return this.MY;
    }

    public bWL() {
        this.IlO = new ArrayList();
    }

    public void IlO(boolean z2) {
        this.EO = z2;
    }

    public void IlO(bWL bwl, bWL bwl2, float f4) {
        if (this.MY == null) {
            this.MY = new PointF();
        }
        this.EO = bwl.MY() || bwl2.MY();
        if (bwl.EO().size() != bwl2.EO().size()) {
            bwl.EO().size();
            bwl2.EO().size();
        }
        int iMin = Math.min(bwl.EO().size(), bwl2.EO().size());
        if (this.IlO.size() < iMin) {
            for (int size = this.IlO.size(); size < iMin; size++) {
                this.IlO.add(new com.bytedance.adsdk.MY.EO.IlO());
            }
        } else if (this.IlO.size() > iMin) {
            for (int size2 = this.IlO.size() - 1; size2 >= iMin; size2--) {
                List<com.bytedance.adsdk.MY.EO.IlO> list = this.IlO;
                list.remove(list.size() - 1);
            }
        }
        PointF pointFIlO = bwl.IlO();
        PointF pointFIlO2 = bwl2.IlO();
        IlO(com.bytedance.adsdk.MY.vCE.Cc.IlO(pointFIlO.x, pointFIlO2.x, f4), com.bytedance.adsdk.MY.vCE.Cc.IlO(pointFIlO.y, pointFIlO2.y, f4));
        for (int size3 = this.IlO.size() - 1; size3 >= 0; size3--) {
            com.bytedance.adsdk.MY.EO.IlO ilO = bwl.EO().get(size3);
            com.bytedance.adsdk.MY.EO.IlO ilO2 = bwl2.EO().get(size3);
            PointF pointFIlO3 = ilO.IlO();
            PointF pointFMY = ilO.MY();
            PointF pointFEO = ilO.EO();
            PointF pointFIlO4 = ilO2.IlO();
            PointF pointFMY2 = ilO2.MY();
            PointF pointFEO2 = ilO2.EO();
            this.IlO.get(size3).IlO(com.bytedance.adsdk.MY.vCE.Cc.IlO(pointFIlO3.x, pointFIlO4.x, f4), com.bytedance.adsdk.MY.vCE.Cc.IlO(pointFIlO3.y, pointFIlO4.y, f4));
            this.IlO.get(size3).MY(com.bytedance.adsdk.MY.vCE.Cc.IlO(pointFMY.x, pointFMY2.x, f4), com.bytedance.adsdk.MY.vCE.Cc.IlO(pointFMY.y, pointFMY2.y, f4));
            this.IlO.get(size3).EO(com.bytedance.adsdk.MY.vCE.Cc.IlO(pointFEO.x, pointFEO2.x, f4), com.bytedance.adsdk.MY.vCE.Cc.IlO(pointFEO.y, pointFEO2.y, f4));
        }
    }
}
