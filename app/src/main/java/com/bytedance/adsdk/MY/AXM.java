package com.bytedance.adsdk.MY;

import java.util.Map;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes3.dex */
public class AXM {
    private final Map<String, String> IlO;
    private boolean MY;

    public String IlO(String str) {
        return str;
    }

    public final String MY(String str, String str2) {
        if (this.MY && this.IlO.containsKey(str2)) {
            return this.IlO.get(str2);
        }
        String strIlO = IlO(str, str2);
        if (this.MY) {
            this.IlO.put(str2, strIlO);
        }
        return strIlO;
    }

    public String IlO(String str, String str2) {
        return IlO(str2);
    }
}
