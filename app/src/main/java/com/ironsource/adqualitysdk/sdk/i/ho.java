package com.ironsource.adqualitysdk.sdk.i;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes5.dex */
public enum ho {
    f2367(-1),
    f2368(0),
    f2366(1),
    f2369(2),
    f2370(3),
    f2363(4),
    f2364(5),
    f2362(6);


    /* JADX INFO: renamed from: ﭴ, reason: contains not printable characters */
    private static long f2358 = 0;

    /* JADX INFO: renamed from: ﭸ, reason: contains not printable characters */
    private static int f2359 = 0;

    /* JADX INFO: renamed from: ﮉ, reason: contains not printable characters */
    private static int f2360 = 1;

    /* JADX INFO: renamed from: ﮌ, reason: contains not printable characters */
    private static char[] f2361;

    /* JADX INFO: renamed from: ﻏ, reason: contains not printable characters */
    private final int f2371;

    static {
        m2337();
        int i2 = f2359 + 109;
        f2360 = i2 % 128;
        if (i2 % 2 == 0) {
            throw null;
        }
    }

    ho(int i2) {
        this.f2371 = i2;
    }

    public static ho valueOf(String str) {
        int i2 = f2359 + 55;
        f2360 = i2 % 128;
        int i8 = i2 % 2;
        ho hoVar = (ho) Enum.valueOf(ho.class, str);
        if (i8 == 0) {
            int i9 = 5 / 0;
        }
        f2359 = (f2360 + 99) % 128;
        return hoVar;
    }

    /* JADX INFO: renamed from: values, reason: to resolve conflict with enum method */
    public static ho[] valuesCustom() throws CloneNotSupportedException {
        int i2 = f2360 + 67;
        f2359 = i2 % 128;
        if (i2 % 2 == 0) {
            return (ho[]) values().clone();
        }
        values().clone();
        throw null;
    }

    /* JADX INFO: renamed from: ﻛ, reason: contains not printable characters */
    public static void m2337() {
        f2361 = new char[]{'U', 3256, 6567, 9900, 13207, 16537, 19850, 25091, 28401, 31719, 17647, 20951, 45342, 48628, 43255, 38904, 'V', 3263, 6568, 9895, 13207, 27656, 24802, 30197, 19171, 24513, 11476, 8656, 13991, 3578, 286, 5123, 11039, 15924, 19748, 16428, 'S', 3234, 6573, 9910, 13201, 16525, 2200, 1132, 4453, 11894, 15190, 18502, 17754, 21037};
        f2358 = -227646984869245706L;
    }

    /* JADX INFO: renamed from: ｋ, reason: contains not printable characters */
    private static String m2338(char c7, int i2, int i8) {
        String str;
        synchronized (c.f1192) {
            try {
                char[] cArr = new char[i2];
                c.f1193 = 0;
                while (true) {
                    int i9 = c.f1193;
                    if (i9 < i2) {
                        cArr[i9] = (char) ((((long) f2361[i8 + i9]) ^ (((long) i9) * f2358)) ^ ((long) c7));
                        c.f1193 = i9 + 1;
                    } else {
                        str = new String(cArr);
                    }
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        return str;
    }

    /* JADX INFO: renamed from: ﾒ, reason: contains not printable characters */
    public final int m2339() {
        int i2 = f2359;
        int i8 = this.f2371;
        f2360 = (i2 + 75) % 128;
        return i8;
    }

    /* JADX INFO: renamed from: ﻛ, reason: contains not printable characters */
    public static ho m2336(int i2) {
        int i8 = f2360 + 25;
        int i9 = i8 % 128;
        f2359 = i9;
        if (i8 % 2 != 0) {
            throw null;
        }
        switch (i2) {
            case -1:
                return f2367;
            case 0:
                return f2368;
            case 1:
                ho hoVar = f2366;
                int i10 = i9 + 95;
                f2360 = i10 % 128;
                if (i10 % 2 != 0) {
                    return hoVar;
                }
                throw null;
            case 2:
                return f2369;
            case 3:
                return f2370;
            case 4:
                return f2363;
            case 5:
                return f2364;
            case 6:
                return f2362;
            default:
                return null;
        }
    }
}
