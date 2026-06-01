package com.bytedance.adsdk.ugeno.tV;

import com.bytedance.adsdk.ugeno.tV.vCE;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes3.dex */
public class Cc implements EO {
    @Override // com.bytedance.adsdk.ugeno.tV.EO
    public List<MY> IlO() {
        ArrayList arrayList = new ArrayList();
        arrayList.add(new MY("update") { // from class: com.bytedance.adsdk.ugeno.tV.Cc.1
            @Override // com.bytedance.adsdk.ugeno.tV.MY
            public com.bytedance.adsdk.ugeno.tV.MY.IlO IlO(com.bytedance.adsdk.ugeno.MY.EO eo, String str, vCE.IlO ilO) {
                return new com.bytedance.adsdk.ugeno.tV.MY.tV(eo, str, ilO);
            }
        });
        arrayList.add(new MY("emit") { // from class: com.bytedance.adsdk.ugeno.tV.Cc.2
            @Override // com.bytedance.adsdk.ugeno.tV.MY
            public com.bytedance.adsdk.ugeno.tV.MY.IlO IlO(com.bytedance.adsdk.ugeno.MY.EO eo, String str, vCE.IlO ilO) {
                return new com.bytedance.adsdk.ugeno.tV.MY.MY(eo, str, ilO);
            }
        });
        return arrayList;
    }
}
