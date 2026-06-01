package com.bytedance.sdk.component.Cc.Cc;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes3.dex */
public class rp extends IlO {
    @Override // com.bytedance.sdk.component.Cc.Cc.DmF
    public void IlO(com.bytedance.sdk.component.Cc.EO.EO eo) {
        byte[] bArrIlO = eo.cL().MY(eo.es()).IlO(eo.DmF());
        if (bArrIlO == null) {
            eo.IlO(new vCE());
        } else {
            eo.IlO(new MY(bArrIlO, null));
        }
    }

    @Override // com.bytedance.sdk.component.Cc.Cc.DmF
    public String IlO() {
        return "raw_cache";
    }
}
