package com.bytedance.adsdk.MY.EO.MY;

import com.bytedance.adsdk.MY.EO.MY.es;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes3.dex */
public class vCE implements EO {
    private final com.bytedance.adsdk.MY.EO.IlO.MY Bc;
    private final com.bytedance.adsdk.MY.EO.IlO.vCE Cc;
    private final es.MY DmF;
    private final com.bytedance.adsdk.MY.EO.IlO.EO EO;
    private final List<com.bytedance.adsdk.MY.EO.IlO.MY> EV;
    private final String IlO;
    private final Bc MY;
    private final float NV;
    private final boolean hp;
    private final es.IlO lEW;
    private final com.bytedance.adsdk.MY.EO.IlO.MY rp;
    private final com.bytedance.adsdk.MY.EO.IlO.tV tV;
    private final com.bytedance.adsdk.MY.EO.IlO.vCE vCE;

    public vCE(String str, Bc bc, com.bytedance.adsdk.MY.EO.IlO.EO eo, com.bytedance.adsdk.MY.EO.IlO.tV tVVar, com.bytedance.adsdk.MY.EO.IlO.vCE vce, com.bytedance.adsdk.MY.EO.IlO.vCE vce2, com.bytedance.adsdk.MY.EO.IlO.MY my, es.IlO ilO, es.MY my2, float f4, List<com.bytedance.adsdk.MY.EO.IlO.MY> list, com.bytedance.adsdk.MY.EO.IlO.MY my3, boolean z2) {
        this.IlO = str;
        this.MY = bc;
        this.EO = eo;
        this.tV = tVVar;
        this.Cc = vce;
        this.vCE = vce2;
        this.Bc = my;
        this.lEW = ilO;
        this.DmF = my2;
        this.NV = f4;
        this.EV = list;
        this.rp = my3;
        this.hp = z2;
    }

    public com.bytedance.adsdk.MY.EO.IlO.MY Bc() {
        return this.Bc;
    }

    public com.bytedance.adsdk.MY.EO.IlO.vCE Cc() {
        return this.Cc;
    }

    public es.MY DmF() {
        return this.DmF;
    }

    public com.bytedance.adsdk.MY.EO.IlO.EO EO() {
        return this.EO;
    }

    public com.bytedance.adsdk.MY.EO.IlO.MY EV() {
        return this.rp;
    }

    public String IlO() {
        return this.IlO;
    }

    public Bc MY() {
        return this.MY;
    }

    public List<com.bytedance.adsdk.MY.EO.IlO.MY> NV() {
        return this.EV;
    }

    public boolean hp() {
        return this.hp;
    }

    public es.IlO lEW() {
        return this.lEW;
    }

    public float rp() {
        return this.NV;
    }

    public com.bytedance.adsdk.MY.EO.IlO.tV tV() {
        return this.tV;
    }

    public com.bytedance.adsdk.MY.EO.IlO.vCE vCE() {
        return this.vCE;
    }

    @Override // com.bytedance.adsdk.MY.EO.MY.EO
    public com.bytedance.adsdk.MY.IlO.IlO.EO IlO(com.bytedance.adsdk.MY.DmF dmF, com.bytedance.adsdk.MY.Bc bc, com.bytedance.adsdk.MY.EO.EO.IlO ilO) {
        return new com.bytedance.adsdk.MY.IlO.IlO.DmF(dmF, ilO, this);
    }
}
