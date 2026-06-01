package com.bykv.vk.openvk.preload.a.b;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes3.dex */
public final class d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final int f4809a;

    static {
        String property = System.getProperty("java.version");
        int iA = a(property);
        if (iA == -1) {
            iA = b(property);
        }
        if (iA == -1) {
            iA = 6;
        }
        f4809a = iA;
    }

    private static int a(String str) {
        try {
            String[] strArrSplit = str.split("[._]");
            int i2 = Integer.parseInt(strArrSplit[0]);
            return (i2 != 1 || strArrSplit.length <= 1) ? i2 : Integer.parseInt(strArrSplit[1]);
        } catch (NumberFormatException unused) {
            return -1;
        }
    }

    private static int b(String str) {
        try {
            StringBuilder sb = new StringBuilder();
            for (int i2 = 0; i2 < str.length(); i2++) {
                char cCharAt = str.charAt(i2);
                if (!Character.isDigit(cCharAt)) {
                    break;
                }
                sb.append(cCharAt);
            }
            return Integer.parseInt(sb.toString());
        } catch (NumberFormatException unused) {
            return -1;
        }
    }

    public static int a() {
        return f4809a;
    }

    public static boolean b() {
        return f4809a >= 9;
    }
}
