package com.bytedance.adsdk.ugeno.tV.IlO;

import java.util.HashMap;
import java.util.Map;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes3.dex */
public class IlO {
    private volatile Map<String, EO> IlO = new HashMap();

    public EO IlO(String str) {
        if (this.IlO.containsKey(str) && this.IlO.get(str) != null) {
            return this.IlO.get(str);
        }
        MY my = new MY();
        this.IlO.put(str, my);
        return my;
    }

    public void IlO(String str, EO eo) {
        if (!this.IlO.containsKey(str) || this.IlO.get(str) == null) {
            this.IlO.put(str, eo);
        }
    }
}
