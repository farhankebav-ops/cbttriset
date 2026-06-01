package com.bytedance.adsdk.MY.EO.MY;

import android.graphics.PointF;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes3.dex */
public class NV implements EO {
    private final com.bytedance.adsdk.MY.EO.IlO.MY Bc;
    private final com.bytedance.adsdk.MY.EO.IlO.MY Cc;
    private final com.bytedance.adsdk.MY.EO.IlO.MY DmF;
    private final com.bytedance.adsdk.MY.EO.IlO.MY EO;
    private final boolean EV;
    private final String IlO;
    private final IlO MY;
    private final boolean NV;
    private final com.bytedance.adsdk.MY.EO.IlO.MY lEW;
    private final com.bytedance.adsdk.MY.EO.IlO.hp<PointF, PointF> tV;
    private final com.bytedance.adsdk.MY.EO.IlO.MY vCE;

    /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
    public enum IlO {
        STAR(1),
        POLYGON(2);

        private final int EO;

        IlO(int i2) {
            this.EO = i2;
        }

        public static IlO IlO(int i2) {
            for (IlO ilO : values()) {
                if (ilO.EO == i2) {
                    return ilO;
                }
            }
            return null;
        }
    }

    public NV(String str, IlO ilO, com.bytedance.adsdk.MY.EO.IlO.MY my, com.bytedance.adsdk.MY.EO.IlO.hp<PointF, PointF> hpVar, com.bytedance.adsdk.MY.EO.IlO.MY my2, com.bytedance.adsdk.MY.EO.IlO.MY my3, com.bytedance.adsdk.MY.EO.IlO.MY my4, com.bytedance.adsdk.MY.EO.IlO.MY my5, com.bytedance.adsdk.MY.EO.IlO.MY my6, boolean z2, boolean z7) {
        this.IlO = str;
        this.MY = ilO;
        this.EO = my;
        this.tV = hpVar;
        this.Cc = my2;
        this.vCE = my3;
        this.Bc = my4;
        this.lEW = my5;
        this.DmF = my6;
        this.NV = z2;
        this.EV = z7;
    }

    public com.bytedance.adsdk.MY.EO.IlO.MY Bc() {
        return this.Bc;
    }

    public com.bytedance.adsdk.MY.EO.IlO.MY Cc() {
        return this.Cc;
    }

    public com.bytedance.adsdk.MY.EO.IlO.MY DmF() {
        return this.DmF;
    }

    public com.bytedance.adsdk.MY.EO.IlO.MY EO() {
        return this.EO;
    }

    public boolean EV() {
        return this.EV;
    }

    public String IlO() {
        return this.IlO;
    }

    public IlO MY() {
        return this.MY;
    }

    public boolean NV() {
        return this.NV;
    }

    public com.bytedance.adsdk.MY.EO.IlO.MY lEW() {
        return this.lEW;
    }

    public com.bytedance.adsdk.MY.EO.IlO.hp<PointF, PointF> tV() {
        return this.tV;
    }

    public com.bytedance.adsdk.MY.EO.IlO.MY vCE() {
        return this.vCE;
    }

    @Override // com.bytedance.adsdk.MY.EO.MY.EO
    public com.bytedance.adsdk.MY.IlO.IlO.EO IlO(com.bytedance.adsdk.MY.DmF dmF, com.bytedance.adsdk.MY.Bc bc, com.bytedance.adsdk.MY.EO.EO.IlO ilO) {
        return new com.bytedance.adsdk.MY.IlO.IlO.bWL(dmF, ilO, this);
    }
}
