package com.bytedance.adsdk.ugeno.tV.tV;

import android.content.Context;
import java.util.Map;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes3.dex */
public class Cc extends IlO {
    public Cc(Context context) {
        super(context);
    }

    @Override // com.bytedance.adsdk.ugeno.tV.tV.IlO
    public boolean IlO(Object... objArr) {
        if (objArr != null && objArr.length > 0) {
            int iIlO = com.bytedance.adsdk.ugeno.Bc.EO.IlO(String.valueOf(objArr[0]), 0);
            Map<String, String> map = this.Cc;
            if (map == null || map.isEmpty() || iIlO == com.bytedance.adsdk.ugeno.Bc.EO.IlO(this.Cc.get("type"), 0)) {
                this.IlO.IlO(this.MY, this.vCE, this.EO.MY());
            }
        }
        return false;
    }
}
