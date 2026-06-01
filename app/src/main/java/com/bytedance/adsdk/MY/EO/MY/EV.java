package com.bytedance.adsdk.MY.EO.MY;

import android.graphics.PointF;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes3.dex */
public class EV implements EO {
    private final boolean Cc;
    private final com.bytedance.adsdk.MY.EO.IlO.hp<PointF, PointF> EO;
    private final String IlO;
    private final com.bytedance.adsdk.MY.EO.IlO.hp<PointF, PointF> MY;
    private final com.bytedance.adsdk.MY.EO.IlO.MY tV;

    public EV(String str, com.bytedance.adsdk.MY.EO.IlO.hp<PointF, PointF> hpVar, com.bytedance.adsdk.MY.EO.IlO.hp<PointF, PointF> hpVar2, com.bytedance.adsdk.MY.EO.IlO.MY my, boolean z2) {
        this.IlO = str;
        this.MY = hpVar;
        this.EO = hpVar2;
        this.tV = my;
        this.Cc = z2;
    }

    public boolean Cc() {
        return this.Cc;
    }

    public com.bytedance.adsdk.MY.EO.IlO.hp<PointF, PointF> EO() {
        return this.EO;
    }

    public String IlO() {
        return this.IlO;
    }

    public com.bytedance.adsdk.MY.EO.IlO.MY MY() {
        return this.tV;
    }

    public com.bytedance.adsdk.MY.EO.IlO.hp<PointF, PointF> tV() {
        return this.MY;
    }

    public String toString() {
        return "RectangleShape{position=" + this.MY + ", size=" + this.EO + '}';
    }

    @Override // com.bytedance.adsdk.MY.EO.MY.EO
    public com.bytedance.adsdk.MY.IlO.IlO.EO IlO(com.bytedance.adsdk.MY.DmF dmF, com.bytedance.adsdk.MY.Bc bc, com.bytedance.adsdk.MY.EO.EO.IlO ilO) {
        return new com.bytedance.adsdk.MY.IlO.IlO.ea(dmF, ilO, this);
    }
}
