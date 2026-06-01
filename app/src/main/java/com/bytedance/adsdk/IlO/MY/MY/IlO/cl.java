package com.bytedance.adsdk.IlO.MY.MY.IlO;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes3.dex */
public abstract class cl implements com.bytedance.adsdk.IlO.MY.MY.IlO {
    protected com.bytedance.adsdk.IlO.MY.tV.EO EO;
    protected com.bytedance.adsdk.IlO.MY.MY.IlO IlO;
    protected com.bytedance.adsdk.IlO.MY.MY.IlO MY;

    public cl(com.bytedance.adsdk.IlO.MY.tV.EO eo) {
        this.EO = eo;
    }

    public void IlO(com.bytedance.adsdk.IlO.MY.MY.IlO ilO) {
        this.IlO = ilO;
    }

    public void MY(com.bytedance.adsdk.IlO.MY.MY.IlO ilO) {
        this.MY = ilO;
    }

    public String toString() {
        return MY();
    }

    @Override // com.bytedance.adsdk.IlO.MY.MY.IlO
    public com.bytedance.adsdk.IlO.MY.tV.Cc IlO() {
        return com.bytedance.adsdk.IlO.MY.tV.vCE.OPERATOR_RESULT;
    }

    @Override // com.bytedance.adsdk.IlO.MY.MY.IlO
    public String MY() {
        return this.IlO.MY() + this.EO.IlO() + this.MY.MY();
    }
}
