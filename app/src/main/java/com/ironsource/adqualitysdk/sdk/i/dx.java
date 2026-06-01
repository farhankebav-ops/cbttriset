package com.ironsource.adqualitysdk.sdk.i;

import android.view.ViewConfiguration;
import android.widget.ExpandableListView;
import com.vungle.ads.internal.protos.Sdk;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes5.dex */
public final class dx {

    /* JADX INFO: renamed from: ﮐ, reason: contains not printable characters */
    private static int f1899 = 1;

    /* JADX INFO: renamed from: ﻐ, reason: contains not printable characters */
    private static int f1900 = 0;

    /* JADX INFO: renamed from: ﾒ, reason: contains not printable characters */
    private static int f1901 = 127;

    /* JADX INFO: renamed from: ﻛ, reason: contains not printable characters */
    private int f1902;

    /* JADX INFO: renamed from: ｋ, reason: contains not printable characters */
    private e f1903;

    /* JADX INFO: renamed from: ﾇ, reason: contains not printable characters */
    private String f1904;

    /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
    public enum e {
        f1914,
        f1913,
        f1916,
        f1915,
        f1912,
        f1909,
        f1907,
        f1910;


        /* JADX INFO: renamed from: ﭖ, reason: contains not printable characters */
        private static int f1905 = 1;

        /* JADX INFO: renamed from: ﭸ, reason: contains not printable characters */
        private static int f1906;

        /* JADX INFO: renamed from: ﱟ, reason: contains not printable characters */
        private static int f1908;

        static {
            m2173();
            f1905 = (f1906 + 81) % 128;
        }

        public static e valueOf(String str) {
            int i2 = f1905 + 51;
            f1906 = i2 % 128;
            if (i2 % 2 == 0) {
                return (e) Enum.valueOf(e.class, str);
            }
            Enum.valueOf(e.class, str);
            throw null;
        }

        /* JADX INFO: renamed from: values, reason: to resolve conflict with enum method */
        public static e[] valuesCustom() {
            f1905 = (f1906 + 101) % 128;
            e[] eVarArr = (e[]) values().clone();
            f1906 = (f1905 + 49) % 128;
            return eVarArr;
        }

        /* JADX INFO: renamed from: ﻐ, reason: contains not printable characters */
        private static String m2172(int i2, int i8, String str, int i9, boolean z2) {
            String str2;
            Object charArray = str;
            if (str != null) {
                charArray = str.toCharArray();
            }
            char[] cArr = (char[]) charArray;
            synchronized (com.ironsource.adqualitysdk.sdk.i.e.f1927) {
                try {
                    char[] cArr2 = new char[i8];
                    com.ironsource.adqualitysdk.sdk.i.e.f1926 = 0;
                    while (true) {
                        int i10 = com.ironsource.adqualitysdk.sdk.i.e.f1926;
                        if (i10 >= i8) {
                            break;
                        }
                        com.ironsource.adqualitysdk.sdk.i.e.f1929 = cArr[i10];
                        cArr2[com.ironsource.adqualitysdk.sdk.i.e.f1926] = (char) (com.ironsource.adqualitysdk.sdk.i.e.f1929 + i2);
                        int i11 = com.ironsource.adqualitysdk.sdk.i.e.f1926;
                        cArr2[i11] = (char) (cArr2[i11] - f1908);
                        com.ironsource.adqualitysdk.sdk.i.e.f1926 = i11 + 1;
                    }
                    if (i9 > 0) {
                        com.ironsource.adqualitysdk.sdk.i.e.f1928 = i9;
                        char[] cArr3 = new char[i8];
                        System.arraycopy(cArr2, 0, cArr3, 0, i8);
                        int i12 = com.ironsource.adqualitysdk.sdk.i.e.f1928;
                        System.arraycopy(cArr3, 0, cArr2, i8 - i12, i12);
                        int i13 = com.ironsource.adqualitysdk.sdk.i.e.f1928;
                        System.arraycopy(cArr3, i13, cArr2, 0, i8 - i13);
                    }
                    if (z2) {
                        char[] cArr4 = new char[i8];
                        com.ironsource.adqualitysdk.sdk.i.e.f1926 = 0;
                        while (true) {
                            int i14 = com.ironsource.adqualitysdk.sdk.i.e.f1926;
                            if (i14 >= i8) {
                                break;
                            }
                            cArr4[i14] = cArr2[(i8 - i14) - 1];
                            com.ironsource.adqualitysdk.sdk.i.e.f1926 = i14 + 1;
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

        /* JADX INFO: renamed from: ﾒ, reason: contains not printable characters */
        public static void m2173() {
            f1908 = 24;
        }
    }

    public dx(e eVar, String str, int i2) {
        this.f1903 = eVar;
        this.f1904 = str;
        this.f1902 = i2;
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(this.f1903);
        sb.append(m2158((ViewConfiguration.getScrollBarFadeDuration() >> 16) + 185, ExpandableListView.getPackedPositionType(0L) + 1, "\u0000", (ViewConfiguration.getTapTimeout() >> 16) + 1, false).intern());
        sb.append(this.f1904);
        String string = sb.toString();
        f1900 = (f1899 + 95) % 128;
        return string;
    }

    /* JADX INFO: renamed from: ﭖ, reason: contains not printable characters */
    public final boolean m2159() {
        f1900 = (f1899 + 15) % 128;
        if (m2170() == e.f1914) {
            return true;
        }
        int i2 = f1900 + 29;
        f1899 = i2 % 128;
        if (i2 % 2 != 0) {
            return false;
        }
        throw null;
    }

    /* JADX INFO: renamed from: ﭴ, reason: contains not printable characters */
    public final boolean m2160() {
        f1899 = (f1900 + 57) % 128;
        if (m2170() != e.f1913) {
            return false;
        }
        f1899 = (f1900 + 13) % 128;
        return true;
    }

    /* JADX INFO: renamed from: ﮐ, reason: contains not printable characters */
    public final boolean m2161() {
        int i2 = f1900 + 81;
        f1899 = i2 % 128;
        if (i2 % 2 == 0) {
            m2170();
            e eVar = e.f1914;
            throw null;
        }
        if (m2170() != e.f1907) {
            f1900 = (f1899 + 21) % 128;
            return false;
        }
        int i8 = f1899 + 31;
        f1900 = i8 % 128;
        if (i8 % 2 == 0) {
            return true;
        }
        throw null;
    }

    /* JADX INFO: renamed from: ﱟ, reason: contains not printable characters */
    public final boolean m2162() {
        f1900 = (f1899 + 17) % 128;
        if (m2170() == e.f1910) {
            int i2 = f1899 + 111;
            f1900 = i2 % 128;
            if (i2 % 2 == 0) {
                return true;
            }
            throw null;
        }
        int i8 = f1899 + 113;
        f1900 = i8 % 128;
        if (i8 % 2 == 0) {
            return false;
        }
        throw null;
    }

    /* JADX INFO: renamed from: ﱡ, reason: contains not printable characters */
    public final boolean m2163() {
        f1900 = (f1899 + 65) % 128;
        if (m2170() == e.f1909) {
            return true;
        }
        int i2 = f1900 + 83;
        f1899 = i2 % 128;
        if (i2 % 2 == 0) {
            int i8 = 75 / 0;
        }
        return false;
    }

    /* JADX INFO: renamed from: ﺙ, reason: contains not printable characters */
    public final boolean m2164() {
        f1899 = (f1900 + 25) % 128;
        if (m2170() != e.f1912) {
            return false;
        }
        int i2 = (f1900 + 31) % 128;
        f1899 = i2;
        f1900 = (i2 + 107) % 128;
        return true;
    }

    /* JADX INFO: renamed from: ﻏ, reason: contains not printable characters */
    public final boolean m2165() {
        int i2 = f1899 + 47;
        f1900 = i2 % 128;
        if (i2 % 2 != 0) {
            m2170();
            e eVar = e.f1914;
            throw null;
        }
        if (m2170() != e.f1916) {
            return false;
        }
        int i8 = f1900 + Sdk.SDKError.Reason.INVALID_RI_ENDPOINT_VALUE;
        f1899 = i8 % 128;
        if (i8 % 2 != 0) {
            return true;
        }
        throw null;
    }

    /* JADX INFO: renamed from: ﻐ, reason: contains not printable characters */
    public final boolean m2167(String str) {
        int i2 = f1899 + 73;
        f1900 = i2 % 128;
        if (i2 % 2 == 0) {
            return this.f1904.equals(str);
        }
        int i8 = 51 / 0;
        return this.f1904.equals(str);
    }

    /* JADX INFO: renamed from: ﻛ, reason: contains not printable characters */
    public final boolean m2168() {
        f1900 = (f1899 + 93) % 128;
        if (m2170() != e.f1915) {
            return false;
        }
        int i2 = f1900 + 87;
        f1899 = i2 % 128;
        return i2 % 2 != 0;
    }

    /* JADX INFO: renamed from: ｋ, reason: contains not printable characters */
    public final String m2169() {
        int i2 = f1899 + 45;
        f1900 = i2 % 128;
        if (i2 % 2 == 0) {
            return this.f1904;
        }
        throw null;
    }

    /* JADX INFO: renamed from: ﾇ, reason: contains not printable characters */
    public final e m2170() {
        int i2 = f1899 + 45;
        f1900 = i2 % 128;
        if (i2 % 2 == 0) {
            return this.f1903;
        }
        int i8 = 96 / 0;
        return this.f1903;
    }

    /* JADX INFO: renamed from: ﾒ, reason: contains not printable characters */
    public final int m2171() {
        int i2 = f1899 + 57;
        int i8 = i2 % 128;
        f1900 = i8;
        if (i2 % 2 != 0) {
            throw null;
        }
        int i9 = this.f1902;
        f1899 = (i8 + 51) % 128;
        return i9;
    }

    /* JADX INFO: renamed from: ｋ, reason: contains not printable characters */
    private static String m2158(int i2, int i8, String str, int i9, boolean z2) {
        String str2;
        Object charArray = str;
        if (str != null) {
            charArray = str.toCharArray();
        }
        char[] cArr = (char[]) charArray;
        synchronized (com.ironsource.adqualitysdk.sdk.i.e.f1927) {
            try {
                char[] cArr2 = new char[i8];
                com.ironsource.adqualitysdk.sdk.i.e.f1926 = 0;
                while (true) {
                    int i10 = com.ironsource.adqualitysdk.sdk.i.e.f1926;
                    if (i10 >= i8) {
                        break;
                    }
                    com.ironsource.adqualitysdk.sdk.i.e.f1929 = cArr[i10];
                    cArr2[com.ironsource.adqualitysdk.sdk.i.e.f1926] = (char) (com.ironsource.adqualitysdk.sdk.i.e.f1929 + i2);
                    int i11 = com.ironsource.adqualitysdk.sdk.i.e.f1926;
                    cArr2[i11] = (char) (cArr2[i11] - f1901);
                    com.ironsource.adqualitysdk.sdk.i.e.f1926 = i11 + 1;
                }
                if (i9 > 0) {
                    com.ironsource.adqualitysdk.sdk.i.e.f1928 = i9;
                    char[] cArr3 = new char[i8];
                    System.arraycopy(cArr2, 0, cArr3, 0, i8);
                    int i12 = com.ironsource.adqualitysdk.sdk.i.e.f1928;
                    System.arraycopy(cArr3, 0, cArr2, i8 - i12, i12);
                    int i13 = com.ironsource.adqualitysdk.sdk.i.e.f1928;
                    System.arraycopy(cArr3, i13, cArr2, 0, i8 - i13);
                }
                if (z2) {
                    char[] cArr4 = new char[i8];
                    com.ironsource.adqualitysdk.sdk.i.e.f1926 = 0;
                    while (true) {
                        int i14 = com.ironsource.adqualitysdk.sdk.i.e.f1926;
                        if (i14 >= i8) {
                            break;
                        }
                        cArr4[i14] = cArr2[(i8 - i14) - 1];
                        com.ironsource.adqualitysdk.sdk.i.e.f1926 = i14 + 1;
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

    /* JADX INFO: renamed from: ﻐ, reason: contains not printable characters */
    public final boolean m2166() {
        int i2 = f1900 + 47;
        f1899 = i2 % 128;
        if (i2 % 2 == 0) {
            m2168();
            throw null;
        }
        if (m2168() || m2164() || m2163() || m2161()) {
            f1899 = (f1900 + 111) % 128;
            return true;
        }
        int i8 = f1899 + 9;
        f1900 = i8 % 128;
        if (i8 % 2 == 0) {
            return false;
        }
        throw null;
    }
}
