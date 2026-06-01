package com.bytedance.adsdk.IlO.MY.tV;

import com.ironsource.C2300e4;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes3.dex */
public enum tV implements Cc {
    LEFT_PAREN("("),
    RIGHT_PAREN(")"),
    LEFT_BRACKET(C2300e4.i.f8403d),
    RIGHT_BRACKET(C2300e4.i.e),
    COMMA(",");

    private static final Map<String, tV> vCE;
    private final String Bc;

    static {
        HashMap map = new HashMap(128);
        vCE = map;
        for (tV tVVar : map.values()) {
            vCE.put(tVVar.IlO(), tVVar);
        }
    }

    tV(String str) {
        this.Bc = str;
    }

    public static boolean IlO(Cc cc) {
        return cc instanceof tV;
    }

    public String IlO() {
        return this.Bc;
    }
}
