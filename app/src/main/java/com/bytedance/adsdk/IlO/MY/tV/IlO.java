package com.bytedance.adsdk.IlO.MY.tV;

import java.util.HashMap;
import java.util.Map;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes3.dex */
public enum IlO implements Cc {
    TRUE,
    FALSE,
    NULL;

    private static final Map<String, IlO> tV = new HashMap(128);

    static {
        for (IlO ilO : values()) {
            tV.put(ilO.name().toLowerCase(), ilO);
        }
    }

    public static IlO IlO(String str) {
        return tV.get(str.toLowerCase());
    }
}
