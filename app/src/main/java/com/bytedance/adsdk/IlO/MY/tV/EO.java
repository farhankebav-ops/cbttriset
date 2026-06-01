package com.bytedance.adsdk.IlO.MY.tV;

import androidx.webkit.ProxyConfig;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes3.dex */
public enum EO implements Cc {
    QUESTION("?", 0),
    COLON(":", 0),
    DOUBLE_AMP("&&", 1),
    DOUBLE_BAR("||", 1),
    EQ("==", 2),
    GT(">", 2),
    LT("<", 2),
    LT_EQ("<=", 2),
    GT_EQ(">=", 2),
    NOT_EQ("!=", 2),
    PLUS("+", 3),
    MINUS("-", 3),
    MULTI(ProxyConfig.MATCH_ALL_SCHEMES, 4),
    DIVISION("/", 4),
    MOD("%", 4);

    private final String cL;
    private final int es;
    private static final Map<String, EO> zPa = new HashMap(128);
    private static final Set<EO> cl = new HashSet();

    static {
        for (EO eo : values()) {
            zPa.put(eo.IlO(), eo);
            cl.add(eo);
        }
    }

    EO(String str, int i2) {
        this.cL = str;
        this.es = i2;
    }

    public static EO IlO(String str) {
        return zPa.get(str);
    }

    public int MY() {
        return this.es;
    }

    public static boolean IlO(Cc cc) {
        return cc instanceof EO;
    }

    public String IlO() {
        return this.cL;
    }
}
