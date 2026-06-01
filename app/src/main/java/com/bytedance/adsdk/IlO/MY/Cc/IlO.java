package com.bytedance.adsdk.IlO.MY.Cc;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes3.dex */
public class IlO {
    public static boolean EO(char c7) {
        return c7 >= '0' && c7 <= '9';
    }

    public static boolean IlO(char c7) {
        return c7 == ' ';
    }

    public static boolean MY(char c7) {
        if (c7 < 'A' || c7 > 'Z') {
            return c7 >= 'a' && c7 <= 'z';
        }
        return true;
    }

    public static boolean tV(char c7) {
        return '+' == c7 || '-' == c7 || '*' == c7 || '/' == c7 || '%' == c7 || '=' == c7 || '>' == c7 || '<' == c7 || '!' == c7 || '&' == c7 || '|' == c7 || '?' == c7 || ':' == c7;
    }
}
