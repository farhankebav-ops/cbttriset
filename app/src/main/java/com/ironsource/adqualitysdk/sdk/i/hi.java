package com.ironsource.adqualitysdk.sdk.i;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes5.dex */
public enum hi {
    f2322(-1),
    f2321(0),
    f2324(1),
    f2320(2),
    f2323(3),
    f2319(4),
    f2316(5),
    f2318(6),
    f2317(7);


    /* JADX INFO: renamed from: ﭖ, reason: contains not printable characters */
    private static int f2312 = 0;

    /* JADX INFO: renamed from: ﭴ, reason: contains not printable characters */
    private static int f2313 = 1;

    /* JADX INFO: renamed from: ﭸ, reason: contains not printable characters */
    private static int f2314;

    /* JADX INFO: renamed from: ﮐ, reason: contains not printable characters */
    private final int f2325;

    static {
        m2297();
        f2313 = (f2312 + 75) % 128;
    }

    hi(int i2) {
        this.f2325 = i2;
    }

    public static hi valueOf(String str) {
        int i2 = f2312 + 37;
        f2313 = i2 % 128;
        if (i2 % 2 == 0) {
            Enum.valueOf(hi.class, str);
            throw null;
        }
        hi hiVar = (hi) Enum.valueOf(hi.class, str);
        int i8 = f2312 + 109;
        f2313 = i8 % 128;
        if (i8 % 2 != 0) {
            return hiVar;
        }
        throw null;
    }

    /* JADX INFO: renamed from: values, reason: to resolve conflict with enum method */
    public static hi[] valuesCustom() {
        f2313 = (f2312 + 79) % 128;
        hi[] hiVarArr = (hi[]) values().clone();
        int i2 = f2313 + 1;
        f2312 = i2 % 128;
        if (i2 % 2 == 0) {
            return hiVarArr;
        }
        throw null;
    }

    /* JADX INFO: renamed from: ﻐ, reason: contains not printable characters */
    public static hi m2295(int i2) {
        switch (i2) {
            case -1:
                return f2322;
            case 0:
                return f2321;
            case 1:
                return f2324;
            case 2:
                hi hiVar = f2320;
                int i8 = f2312 + 51;
                f2313 = i8 % 128;
                if (i8 % 2 != 0) {
                    return hiVar;
                }
                throw null;
            case 3:
                return f2323;
            case 4:
                hi hiVar2 = f2319;
                int i9 = f2312 + 19;
                f2313 = i9 % 128;
                if (i9 % 2 == 0) {
                    int i10 = 80 / 0;
                }
                return hiVar2;
            case 5:
                hi hiVar3 = f2316;
                f2313 = (f2312 + 53) % 128;
                return hiVar3;
            case 6:
                return f2318;
            case 7:
                return f2317;
            default:
                return null;
        }
    }

    /* JADX INFO: renamed from: ﾒ, reason: contains not printable characters */
    public static void m2297() {
        f2314 = 152;
    }

    /* JADX INFO: renamed from: ｋ, reason: contains not printable characters */
    public final int m2298() {
        int i2 = (f2312 + 79) % 128;
        f2313 = i2;
        int i8 = this.f2325;
        int i9 = i2 + 111;
        f2312 = i9 % 128;
        if (i9 % 2 == 0) {
            return i8;
        }
        throw null;
    }

    /* JADX INFO: renamed from: ｋ, reason: contains not printable characters */
    private static String m2296(int i2, int i8, String str, int i9, boolean z2) {
        String str2;
        Object charArray = str;
        if (str != null) {
            charArray = str.toCharArray();
        }
        char[] cArr = (char[]) charArray;
        synchronized (e.f1927) {
            try {
                char[] cArr2 = new char[i8];
                e.f1926 = 0;
                while (true) {
                    int i10 = e.f1926;
                    if (i10 >= i8) {
                        break;
                    }
                    e.f1929 = cArr[i10];
                    cArr2[e.f1926] = (char) (e.f1929 + i2);
                    int i11 = e.f1926;
                    cArr2[i11] = (char) (cArr2[i11] - f2314);
                    e.f1926 = i11 + 1;
                }
                if (i9 > 0) {
                    e.f1928 = i9;
                    char[] cArr3 = new char[i8];
                    System.arraycopy(cArr2, 0, cArr3, 0, i8);
                    int i12 = e.f1928;
                    System.arraycopy(cArr3, 0, cArr2, i8 - i12, i12);
                    int i13 = e.f1928;
                    System.arraycopy(cArr3, i13, cArr2, 0, i8 - i13);
                }
                if (z2) {
                    char[] cArr4 = new char[i8];
                    e.f1926 = 0;
                    while (true) {
                        int i14 = e.f1926;
                        if (i14 >= i8) {
                            break;
                        }
                        cArr4[i14] = cArr2[(i8 - i14) - 1];
                        e.f1926 = i14 + 1;
                    }
                    cArr2 = cArr4;
                }
                str2 = new String(cArr2);
            } catch (Throwable th) {
                throw th;
            }
        }
        return str2;
    }
}
