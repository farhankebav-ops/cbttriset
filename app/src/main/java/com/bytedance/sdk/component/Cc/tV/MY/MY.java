package com.bytedance.sdk.component.Cc.tV.MY;

import android.text.TextUtils;
import com.bytedance.sdk.component.Cc.xF;
import com.bytedance.sdk.component.utils.zPa;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes3.dex */
public class MY implements vCE {
    @Override // com.bytedance.sdk.component.Cc.tV.MY.vCE
    public boolean IlO(com.bytedance.sdk.component.Cc.tV.EO.EO eo, xF xFVar, com.bytedance.sdk.component.Cc.tV.EO.IlO ilO) {
        if (TextUtils.isEmpty(eo.NV())) {
            String strIlO = IlO(eo);
            eo.MY(strIlO);
            eo.IlO(strIlO);
        }
        eo.IlO();
        return true;
    }

    @Override // com.bytedance.sdk.component.Cc.tV.MY.vCE
    public String IlO() {
        return "generate_key";
    }

    private String IlO(com.bytedance.sdk.component.Cc.tV.EO.EO eo) {
        return zPa.IlO(eo.IlO());
    }
}
