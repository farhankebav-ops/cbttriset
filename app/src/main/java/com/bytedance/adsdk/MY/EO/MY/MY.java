package com.bytedance.adsdk.MY.EO.MY;

import android.graphics.PointF;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes3.dex */
public class MY implements EO {
    private final boolean Cc;
    private final com.bytedance.adsdk.MY.EO.IlO.vCE EO;
    private final String IlO;
    private final com.bytedance.adsdk.MY.EO.IlO.hp<PointF, PointF> MY;
    private final boolean tV;

    public MY(String str, com.bytedance.adsdk.MY.EO.IlO.hp<PointF, PointF> hpVar, com.bytedance.adsdk.MY.EO.IlO.vCE vce, boolean z2, boolean z7) {
        this.IlO = str;
        this.MY = hpVar;
        this.EO = vce;
        this.tV = z2;
        this.Cc = z7;
    }

    public boolean Cc() {
        return this.Cc;
    }

    public com.bytedance.adsdk.MY.EO.IlO.vCE EO() {
        return this.EO;
    }

    @Override // com.bytedance.adsdk.MY.EO.MY.EO
    public com.bytedance.adsdk.MY.IlO.IlO.EO IlO(com.bytedance.adsdk.MY.DmF dmF, com.bytedance.adsdk.MY.Bc bc, com.bytedance.adsdk.MY.EO.EO.IlO ilO) {
        return new com.bytedance.adsdk.MY.IlO.IlO.vCE(dmF, ilO, this);
    }

    public com.bytedance.adsdk.MY.EO.IlO.hp<PointF, PointF> MY() {
        return this.MY;
    }

    public boolean tV() {
        return this.tV;
    }

    public String IlO() {
        return this.IlO;
    }
}
