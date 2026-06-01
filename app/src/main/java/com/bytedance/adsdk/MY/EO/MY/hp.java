package com.bytedance.adsdk.MY.EO.MY;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes3.dex */
public class hp implements EO {
    private final String IlO;
    private final com.bytedance.adsdk.MY.EO.IlO.hp<Float, Float> MY;

    public hp(String str, com.bytedance.adsdk.MY.EO.IlO.hp<Float, Float> hpVar) {
        this.IlO = str;
        this.MY = hpVar;
    }

    public String IlO() {
        return this.IlO;
    }

    public com.bytedance.adsdk.MY.EO.IlO.hp<Float, Float> MY() {
        return this.MY;
    }

    @Override // com.bytedance.adsdk.MY.EO.MY.EO
    public com.bytedance.adsdk.MY.IlO.IlO.EO IlO(com.bytedance.adsdk.MY.DmF dmF, com.bytedance.adsdk.MY.Bc bc, com.bytedance.adsdk.MY.EO.EO.IlO ilO) {
        return new com.bytedance.adsdk.MY.IlO.IlO.cl(dmF, ilO, this);
    }
}
