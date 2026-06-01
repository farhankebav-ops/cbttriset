package com.bytedance.sdk.component.utils;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes3.dex */
public class ea {
    private static String EO = "";
    private static boolean IlO = false;
    private static int MY = 4;

    public static void EO() {
        IlO = false;
        IlO(7);
    }

    public static void IlO(String str) {
        EO = str;
    }

    public static void MY() {
        IlO = true;
        IlO(3);
    }

    public static boolean tV() {
        return IlO;
    }

    public static void IlO(int i2) {
        MY = i2;
    }

    public static boolean IlO() {
        return MY <= 3;
    }
}
