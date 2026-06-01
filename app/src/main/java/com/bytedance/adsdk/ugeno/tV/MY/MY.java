package com.bytedance.adsdk.ugeno.tV.MY;

import com.bytedance.adsdk.ugeno.tV.vCE;
import java.util.List;
import java.util.Map;
import java.util.concurrent.CopyOnWriteArrayList;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes3.dex */
public class MY extends IlO {
    private List<com.bytedance.adsdk.ugeno.tV.IlO.tV> lEW;

    public MY(com.bytedance.adsdk.ugeno.MY.EO eo, String str, vCE.IlO ilO) {
        super(eo, str, ilO);
        this.lEW = new CopyOnWriteArrayList();
    }

    @Override // com.bytedance.adsdk.ugeno.tV.MY.IlO
    public void IlO() {
        com.bytedance.adsdk.ugeno.tV.IlO.EO eoIlO;
        Map<String, String> map = this.vCE;
        if (map == null || map.size() <= 0) {
            return;
        }
        String str = this.vCE.get("name");
        com.bytedance.adsdk.ugeno.tV.IlO.IlO ilOZLG = this.EO.zLG();
        if (ilOZLG == null || (eoIlO = ilOZLG.IlO(str)) == null) {
            return;
        }
        eoIlO.IlO(str);
    }
}
