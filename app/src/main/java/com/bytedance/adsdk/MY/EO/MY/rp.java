package com.bytedance.adsdk.MY.EO.MY;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes3.dex */
public class rp implements EO {
    private final boolean Cc;
    private final com.bytedance.adsdk.MY.EO.IlO.MY EO;
    private final String IlO;
    private final com.bytedance.adsdk.MY.EO.IlO.MY MY;
    private final com.bytedance.adsdk.MY.EO.IlO.rp tV;

    public rp(String str, com.bytedance.adsdk.MY.EO.IlO.MY my, com.bytedance.adsdk.MY.EO.IlO.MY my2, com.bytedance.adsdk.MY.EO.IlO.rp rpVar, boolean z2) {
        this.IlO = str;
        this.MY = my;
        this.EO = my2;
        this.tV = rpVar;
        this.Cc = z2;
    }

    public boolean Cc() {
        return this.Cc;
    }

    public com.bytedance.adsdk.MY.EO.IlO.MY EO() {
        return this.EO;
    }

    public String IlO() {
        return this.IlO;
    }

    public com.bytedance.adsdk.MY.EO.IlO.MY MY() {
        return this.MY;
    }

    public com.bytedance.adsdk.MY.EO.IlO.rp tV() {
        return this.tV;
    }

    @Override // com.bytedance.adsdk.MY.EO.MY.EO
    public com.bytedance.adsdk.MY.IlO.IlO.EO IlO(com.bytedance.adsdk.MY.DmF dmF, com.bytedance.adsdk.MY.Bc bc, com.bytedance.adsdk.MY.EO.EO.IlO ilO) {
        return new com.bytedance.adsdk.MY.IlO.IlO.zPa(dmF, ilO, this);
    }
}
