package com.bytedance.adsdk.ugeno.tV;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes3.dex */
public class tV {
    private static Map<String, MY> IlO = new HashMap();

    public static void IlO(List<MY> list) {
        if (list == null || list.size() <= 0) {
            return;
        }
        for (MY my : list) {
            if (my != null) {
                IlO.put(my.IlO(), my);
            }
        }
    }

    public static MY IlO(String str) {
        return IlO.get(str);
    }
}
