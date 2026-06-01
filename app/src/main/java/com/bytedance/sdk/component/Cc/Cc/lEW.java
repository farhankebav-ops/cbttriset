package com.bytedance.sdk.component.Cc.Cc;

import com.bytedance.sdk.component.Cc.zPa;
import com.ironsource.C2300e4;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes3.dex */
public class lEW extends IlO {
    private String EO;
    private Throwable IlO;
    private int MY;

    public lEW(int i2, String str, Throwable th) {
        this.MY = i2;
        this.EO = str;
        this.IlO = th;
    }

    private void MY(com.bytedance.sdk.component.Cc.EO.EO eo) {
        zPa zpaLEW = eo.lEW();
        if (zpaLEW != null) {
            zpaLEW.IlO(this.MY, this.EO, this.IlO);
        }
    }

    @Override // com.bytedance.sdk.component.Cc.Cc.DmF
    public void IlO(com.bytedance.sdk.component.Cc.EO.EO eo) {
        eo.IlO(new com.bytedance.sdk.component.Cc.EO.IlO(this.MY, this.EO, this.IlO));
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

    @Override // com.bytedance.sdk.component.Cc.Cc.DmF
    public String IlO() {
        return C2300e4.h.f8385t;
    }
}
