package com.bytedance.sdk.component.Cc.Cc;

import com.bytedance.sdk.component.Cc.zPa;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes3.dex */
public class hp<T> extends IlO {
    private boolean EO;
    private T IlO;
    private com.bytedance.sdk.component.Cc.vCE MY;

    public hp(T t3, com.bytedance.sdk.component.Cc.vCE vce, boolean z2) {
        this.IlO = t3;
        this.MY = vce;
        this.EO = z2;
    }

    private Map<String, String> MY() {
        com.bytedance.sdk.component.Cc.vCE vce = this.MY;
        if (vce != null) {
            return vce.Cc();
        }
        return null;
    }

    @Override // com.bytedance.sdk.component.Cc.Cc.DmF
    public void IlO(com.bytedance.sdk.component.Cc.EO.EO eo) {
        String strOeT = eo.oeT();
        Map<String, List<com.bytedance.sdk.component.Cc.EO.EO>> mapLEW = eo.cL().lEW();
        List<com.bytedance.sdk.component.Cc.EO.EO> list = mapLEW.get(strOeT);
        if (list == null) {
            MY(eo);
            return;
        }
        synchronized (list) {
            try {
                Iterator<com.bytedance.sdk.component.Cc.EO.EO> it = list.iterator();
                while (it.hasNext()) {
                    MY(it.next());
                }
                list.clear();
                mapLEW.remove(strOeT);
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    private void MY(com.bytedance.sdk.component.Cc.EO.EO eo) {
        zPa zpaLEW = eo.lEW();
        if (zpaLEW != null) {
            zpaLEW.IlO(new com.bytedance.sdk.component.Cc.EO.tV().IlO(eo, this.IlO, MY(), this.EO));
        }
    }

    @Override // com.bytedance.sdk.component.Cc.Cc.DmF
    public String IlO() {
        return "success";
    }
}
