package com.bytedance.sdk.component.Cc.Cc;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes3.dex */
public class tV extends IlO {
    @Override // com.bytedance.sdk.component.Cc.Cc.DmF
    public void IlO(com.bytedance.sdk.component.Cc.EO.EO eo) {
        com.bytedance.sdk.component.Cc.MY myEs = eo.es();
        if (myEs != null) {
            if (myEs.Cc()) {
                eo.IlO(new NV());
                return;
            } else if (myEs.Bc()) {
                eo.IlO(new vCE());
                return;
            }
        }
        eo.IlO(new EV());
    }

    @Override // com.bytedance.sdk.component.Cc.Cc.DmF
    public String IlO() {
        return "cache_policy";
    }
}
