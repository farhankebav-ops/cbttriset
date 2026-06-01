package com.bytedance.sdk.component.Cc.Cc;

import java.util.LinkedList;
import java.util.List;
import java.util.Map;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes3.dex */
public class Bc extends IlO {
    @Override // com.bytedance.sdk.component.Cc.Cc.DmF
    public void IlO(com.bytedance.sdk.component.Cc.EO.EO eo) {
        List<com.bytedance.sdk.component.Cc.EO.EO> linkedList;
        String strOeT = eo.oeT();
        Map<String, List<com.bytedance.sdk.component.Cc.EO.EO>> mapLEW = eo.cL().lEW();
        synchronized (mapLEW) {
            try {
                linkedList = mapLEW.get(strOeT);
                if (linkedList == null) {
                    linkedList = new LinkedList<>();
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        synchronized (linkedList) {
            try {
                linkedList.add(eo);
                mapLEW.put(strOeT, linkedList);
                if (linkedList.size() <= 1) {
                    eo.IlO(new tV());
                }
            } catch (Throwable th2) {
                throw th2;
            }
        }
    }

    @Override // com.bytedance.sdk.component.Cc.Cc.DmF
    public String IlO() {
        return "check_duplicate";
    }
}
