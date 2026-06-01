package com.bytedance.adsdk.ugeno.tV;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes3.dex */
public class NV {
    private static Map<String, Bc> IlO = new HashMap();

    public static void IlO(List<Bc> list) {
        if (list == null || list.size() <= 0) {
            return;
        }
        for (Bc bc : list) {
            if (bc != null) {
                IlO.put(bc.IlO(), bc);
            }
        }
    }

    public static Bc IlO(String str) {
        return IlO.get(str);
    }
}
