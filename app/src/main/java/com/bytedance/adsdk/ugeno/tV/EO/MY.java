package com.bytedance.adsdk.ugeno.tV.EO;

import com.bytedance.adsdk.ugeno.tV.vCE;
import com.ironsource.C2300e4;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes3.dex */
public class MY extends com.bytedance.adsdk.ugeno.tV.MY.IlO {
    public MY(com.bytedance.adsdk.ugeno.MY.EO eo, String str, vCE.IlO ilO) {
        super(eo, str, ilO);
    }

    @Override // com.bytedance.adsdk.ugeno.tV.MY.IlO
    public void IlO() {
        if (this.EO == null) {
            return;
        }
        int iIlO = com.bytedance.adsdk.ugeno.Bc.EO.IlO(this.vCE.get(C2300e4.h.L), 0);
        com.bytedance.adsdk.ugeno.MY.EO eo = this.EO;
        com.bytedance.adsdk.ugeno.MY.EO eoMY = eo.MY(eo);
        if (eoMY == null) {
            return;
        }
        com.bytedance.adsdk.ugeno.MY.EO eoTV = eoMY.tV("SwiperView");
        if (eoTV instanceof com.bytedance.adsdk.ugeno.MY) {
            ((com.bytedance.adsdk.ugeno.MY) eoTV).IlO(iIlO);
        }
    }
}
