package com.bytedance.adsdk.ugeno.tV.tV;

import android.content.Context;
import com.bytedance.adsdk.ugeno.tV.vCE;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes3.dex */
public class vCE extends IlO {
    private int EV;
    private int hp;
    private int rp;

    public vCE(Context context) {
        super(context);
        this.EV = -1;
        this.rp = -1;
        this.hp = -1;
    }

    @Override // com.bytedance.adsdk.ugeno.tV.tV.IlO
    public boolean IlO(Object... objArr) {
        if (objArr != null && objArr.length > 0) {
            int iIlO = com.bytedance.adsdk.ugeno.Bc.EO.IlO(String.valueOf(objArr[0]), -1);
            int iIlO2 = com.bytedance.adsdk.ugeno.Bc.EO.IlO(String.valueOf(objArr[1]), -1);
            int iIlO3 = com.bytedance.adsdk.ugeno.Bc.EO.IlO(String.valueOf(objArr[2]), -1);
            Map<String, String> map = this.Cc;
            if (map == null || map.isEmpty()) {
                HashMap map2 = new HashMap();
                map2.put("fromIndex", Integer.valueOf(iIlO));
                map2.put("toIndex", Integer.valueOf(iIlO2));
                map2.put("type", Integer.valueOf(iIlO3));
                Iterator<vCE.IlO> it = this.EO.MY().iterator();
                while (it.hasNext()) {
                    it.next().MY(map2);
                }
                this.IlO.IlO(this.MY, this.vCE, this.EO.MY());
            } else {
                this.EV = com.bytedance.adsdk.ugeno.Bc.EO.IlO(this.Cc.get("fromIndex"), -1);
                this.rp = com.bytedance.adsdk.ugeno.Bc.EO.IlO(this.Cc.get("toIndex"), -1);
                int iIlO4 = com.bytedance.adsdk.ugeno.Bc.EO.IlO(this.Cc.get("type"), -1);
                this.hp = iIlO4;
                if (iIlO == this.EV && iIlO2 == this.rp && iIlO3 == iIlO4) {
                    this.IlO.IlO(this.MY, this.vCE, this.EO.MY());
                }
            }
        }
        return false;
    }
}
