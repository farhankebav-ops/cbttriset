package com.bytedance.sdk.component.Cc.Cc;

import android.text.TextUtils;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes3.dex */
public class EO extends IlO {
    @Override // com.bytedance.sdk.component.Cc.Cc.DmF
    public void IlO(com.bytedance.sdk.component.Cc.EO.EO eo) {
        if (TextUtils.isEmpty(eo.NV())) {
            com.bytedance.sdk.component.Cc.rp rpVarVCE = eo.cL().vCE();
            eo.MY(rpVarVCE.IlO(eo));
            eo.IlO(rpVarVCE.MY(eo));
        }
        eo.IlO(new Bc());
    }

    @Override // com.bytedance.sdk.component.Cc.Cc.DmF
    public String IlO() {
        return "generate_key";
    }
}
