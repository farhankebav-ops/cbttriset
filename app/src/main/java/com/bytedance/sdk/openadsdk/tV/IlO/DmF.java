package com.bytedance.sdk.openadsdk.tV.IlO;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes3.dex */
class DmF implements com.bytedance.sdk.component.vCE.IlO.Cc.tV {
    private final com.bytedance.sdk.component.Bc.MY IlO;

    public DmF(com.bytedance.sdk.component.Bc.MY my) {
        this.IlO = my;
    }

    @Override // com.bytedance.sdk.component.vCE.IlO.Cc.tV
    public String EO() {
        com.bytedance.sdk.component.Bc.MY my = this.IlO;
        return my != null ? my.MY() : "";
    }

    @Override // com.bytedance.sdk.component.vCE.IlO.Cc.tV
    public boolean IlO() {
        com.bytedance.sdk.component.Bc.MY my = this.IlO;
        if (my != null) {
            return my.vCE();
        }
        return false;
    }

    @Override // com.bytedance.sdk.component.vCE.IlO.Cc.tV
    public int MY() {
        com.bytedance.sdk.component.Bc.MY my = this.IlO;
        if (my != null) {
            return my.IlO();
        }
        return -1;
    }
}
