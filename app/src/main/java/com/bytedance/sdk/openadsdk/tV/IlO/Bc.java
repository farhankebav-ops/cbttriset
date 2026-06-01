package com.bytedance.sdk.openadsdk.tV.IlO;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes3.dex */
class Bc implements com.bytedance.sdk.component.vCE.IlO.Cc.EO {
    private final com.bytedance.sdk.component.Bc.MY.MY IlO;

    public Bc() {
        com.bytedance.sdk.component.Bc.MY.MY myEO = com.bytedance.sdk.openadsdk.cL.Bc.IlO().MY().EO();
        this.IlO = myEO;
        myEO.IlO(7);
        myEO.IlO("track_url");
    }

    @Override // com.bytedance.sdk.component.vCE.IlO.Cc.EO
    public void IlO(String str) {
        this.IlO.MY(str);
    }

    @Override // com.bytedance.sdk.component.vCE.IlO.Cc.EO
    public void IlO(String str, String str2) {
        this.IlO.MY(str, str2);
    }

    @Override // com.bytedance.sdk.component.vCE.IlO.Cc.EO
    public com.bytedance.sdk.component.vCE.IlO.Cc.tV IlO() {
        return new DmF(this.IlO.IlO());
    }
}
