package com.bytedance.adsdk.ugeno.tV.MY;

import android.text.TextUtils;
import com.bytedance.adsdk.ugeno.tV.vCE;
import java.util.Map;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes3.dex */
public class tV extends IlO {
    public tV(com.bytedance.adsdk.ugeno.MY.EO eo, String str, vCE.IlO ilO) {
        super(eo, str, ilO);
    }

    @Override // com.bytedance.adsdk.ugeno.tV.MY.IlO
    public void IlO() {
        Map<String, String> map = this.vCE;
        if (map == null || map.size() <= 0) {
            return;
        }
        String str = this.vCE.get("id");
        if (TextUtils.isEmpty(str)) {
            IlO(this.EO);
            return;
        }
        com.bytedance.adsdk.ugeno.MY.EO eo = this.EO;
        com.bytedance.adsdk.ugeno.MY.EO eoMY = eo.MY(eo);
        if (eoMY == null) {
            return;
        }
        IlO(eoMY.EO(str));
    }

    private void IlO(com.bytedance.adsdk.ugeno.MY.EO eo) {
        if (eo == null) {
            return;
        }
        for (String str : this.vCE.keySet()) {
            if (!TextUtils.isEmpty(str) && !TextUtils.equals(str, "id")) {
                eo.IlO(str, this.vCE.get(str));
            }
        }
        eo.IlO(this.vCE.containsKey("width"), this.vCE.containsKey("height"));
        eo.MY();
    }
}
