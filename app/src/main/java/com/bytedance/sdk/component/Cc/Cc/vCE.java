package com.bytedance.sdk.component.Cc.Cc;

import java.util.Collection;
import java.util.Iterator;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes3.dex */
public class vCE extends IlO {
    private byte[] MY(com.bytedance.sdk.component.Cc.EO.EO eo, String str) {
        com.bytedance.sdk.component.Cc.EO EO = eo.cL().EO(eo.es());
        if (EO == null) {
            return null;
        }
        return EO.IlO(str);
    }

    @Override // com.bytedance.sdk.component.Cc.Cc.DmF
    public void IlO(com.bytedance.sdk.component.Cc.EO.EO eo) {
        String strDmF = eo.DmF();
        byte[] bArrIlO = (eo.xF() || eo.es().DmF()) ? IlO(eo, strDmF) : MY(eo, strDmF);
        if (bArrIlO == null) {
            eo.IlO(new EV());
        } else {
            eo.IlO(new MY(bArrIlO, null));
            eo.cL().MY(eo.es()).IlO(strDmF, bArrIlO);
        }
    }

    private byte[] IlO(com.bytedance.sdk.component.Cc.EO.EO eo, String str) {
        eo.cL().EO(eo.es());
        Collection<com.bytedance.sdk.component.Cc.EO> collectionEO = eo.cL().EO();
        if (collectionEO == null) {
            return null;
        }
        Iterator<com.bytedance.sdk.component.Cc.EO> it = collectionEO.iterator();
        while (it.hasNext()) {
            byte[] bArrIlO = it.next().IlO(str);
            if (bArrIlO != null) {
                return bArrIlO;
            }
        }
        return null;
    }

    @Override // com.bytedance.sdk.component.Cc.Cc.DmF
    public String IlO() {
        return "disk_cache";
    }
}
