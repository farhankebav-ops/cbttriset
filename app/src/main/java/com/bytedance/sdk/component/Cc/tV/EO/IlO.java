package com.bytedance.sdk.component.Cc.tV.EO;

import com.bytedance.sdk.component.Cc.EV;
import com.bytedance.sdk.component.Cc.xF;
import com.bytedance.sdk.component.Cc.zPa;
import com.ironsource.C2300e4;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes3.dex */
public class IlO<T> {
    private EO IlO;
    private xF MY;

    public IlO(EO eo, xF xFVar) {
        this.IlO = eo;
        this.MY = xFVar;
    }

    public void IlO(EV<T> ev) {
        try {
            xF xFVar = this.MY;
            if (xFVar != null) {
                xFVar.IlO("success", this.IlO);
            }
            String strXF = this.IlO.xF();
            Map<String, List<EO>> mapDmF = this.IlO.cl().DmF();
            List<EO> list = mapDmF.get(strXF);
            if (list == null) {
                zPa zpaLEW = this.IlO.lEW();
                if (zpaLEW != null) {
                    zpaLEW.toString();
                    this.IlO.NV();
                    zpaLEW.IlO(ev);
                }
            } else {
                synchronized (list) {
                    try {
                        list.size();
                        for (EO eo : list) {
                            zPa zpaLEW2 = eo.lEW();
                            if (zpaLEW2 != null) {
                                zpaLEW2.toString();
                                eo.NV();
                                zpaLEW2.IlO(ev);
                            }
                        }
                        list.clear();
                        mapDmF.remove(strXF);
                    } finally {
                    }
                }
            }
            xF xFVar2 = this.MY;
            if (xFVar2 != null) {
                xFVar2.MY("success", this.IlO);
            }
        } catch (Throwable unused) {
        }
    }

    public void IlO(int i2, String str, Throwable th) {
        try {
            xF xFVar = this.MY;
            if (xFVar != null) {
                xFVar.IlO(C2300e4.h.f8385t, this.IlO);
            }
            String strXF = this.IlO.xF();
            Map<String, List<EO>> mapDmF = this.IlO.cl().DmF();
            List<EO> list = mapDmF.get(strXF);
            if (list == null) {
                zPa zpaLEW = this.IlO.lEW();
                if (zpaLEW != null) {
                    zpaLEW.IlO(i2, str, th);
                }
            } else {
                synchronized (list) {
                    try {
                        Iterator<EO> it = list.iterator();
                        while (it.hasNext()) {
                            zPa zpaLEW2 = it.next().lEW();
                            if (zpaLEW2 != null) {
                                zpaLEW2.toString();
                                zpaLEW2.IlO(i2, str, th);
                            }
                        }
                        list.clear();
                        mapDmF.remove(strXF);
                    } finally {
                    }
                }
            }
            xF xFVar2 = this.MY;
            if (xFVar2 != null) {
                xFVar2.MY(C2300e4.h.f8385t, this.IlO);
            }
        } catch (Throwable unused) {
        }
    }
}
