package com.bytedance.sdk.component.Cc.tV.MY;

import com.bytedance.sdk.component.Cc.xF;
import java.util.List;
import java.util.Map;
import java.util.concurrent.CopyOnWriteArrayList;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes3.dex */
public class Cc implements vCE {
    @Override // com.bytedance.sdk.component.Cc.tV.MY.vCE
    public boolean IlO(com.bytedance.sdk.component.Cc.tV.EO.EO eo, xF xFVar, com.bytedance.sdk.component.Cc.tV.EO.IlO ilO) {
        List<com.bytedance.sdk.component.Cc.tV.EO.EO> copyOnWriteArrayList;
        String strXF = eo.xF();
        Map<String, List<com.bytedance.sdk.component.Cc.tV.EO.EO>> mapDmF = eo.cl().DmF();
        eo.rp();
        eo.IlO();
        synchronized (mapDmF) {
            try {
                copyOnWriteArrayList = mapDmF.get(strXF);
                if (copyOnWriteArrayList == null) {
                    copyOnWriteArrayList = new CopyOnWriteArrayList<>();
                    mapDmF.put(strXF, copyOnWriteArrayList);
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        synchronized (copyOnWriteArrayList) {
            copyOnWriteArrayList.add(eo);
            if (copyOnWriteArrayList.size() <= 1) {
                return true;
            }
            eo.rp();
            eo.IlO();
            return false;
        }
    }

    @Override // com.bytedance.sdk.component.Cc.tV.MY.vCE
    public String IlO() {
        return "check_duplicate";
    }
}
