package com.bytedance.adsdk.MY.EO.MY;

import android.graphics.Path;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes3.dex */
public class Cc implements EO {
    private final String Bc;
    private final com.bytedance.adsdk.MY.EO.IlO.vCE Cc;
    private final com.bytedance.adsdk.MY.EO.IlO.MY DmF;
    private final com.bytedance.adsdk.MY.EO.IlO.EO EO;
    private final Bc IlO;
    private final Path.FillType MY;
    private final boolean NV;
    private final com.bytedance.adsdk.MY.EO.IlO.MY lEW;
    private final com.bytedance.adsdk.MY.EO.IlO.tV tV;
    private final com.bytedance.adsdk.MY.EO.IlO.vCE vCE;

    public Cc(String str, Bc bc, Path.FillType fillType, com.bytedance.adsdk.MY.EO.IlO.EO eo, com.bytedance.adsdk.MY.EO.IlO.tV tVVar, com.bytedance.adsdk.MY.EO.IlO.vCE vce, com.bytedance.adsdk.MY.EO.IlO.vCE vce2, com.bytedance.adsdk.MY.EO.IlO.MY my, com.bytedance.adsdk.MY.EO.IlO.MY my2, boolean z2) {
        this.IlO = bc;
        this.MY = fillType;
        this.EO = eo;
        this.tV = tVVar;
        this.Cc = vce;
        this.vCE = vce2;
        this.Bc = str;
        this.lEW = my;
        this.DmF = my2;
        this.NV = z2;
    }

    public com.bytedance.adsdk.MY.EO.IlO.vCE Bc() {
        return this.vCE;
    }

    public com.bytedance.adsdk.MY.EO.IlO.tV Cc() {
        return this.tV;
    }

    public Path.FillType EO() {
        return this.MY;
    }

    public String IlO() {
        return this.Bc;
    }

    public Bc MY() {
        return this.IlO;
    }

    public boolean lEW() {
        return this.NV;
    }

    public com.bytedance.adsdk.MY.EO.IlO.EO tV() {
        return this.EO;
    }

    public com.bytedance.adsdk.MY.EO.IlO.vCE vCE() {
        return this.Cc;
    }

    @Override // com.bytedance.adsdk.MY.EO.MY.EO
    public com.bytedance.adsdk.MY.IlO.IlO.EO IlO(com.bytedance.adsdk.MY.DmF dmF, com.bytedance.adsdk.MY.Bc bc, com.bytedance.adsdk.MY.EO.EO.IlO ilO) {
        return new com.bytedance.adsdk.MY.IlO.IlO.lEW(dmF, bc, ilO, this);
    }
}
