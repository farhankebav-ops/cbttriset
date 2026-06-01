package com.ironsource.adqualitysdk.sdk.i;

import android.text.TextUtils;
import android.util.Base64;
import com.vungle.ads.internal.protos.Sdk;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.zip.GZIPInputStream;
import org.json.JSONArray;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes5.dex */
public final class ka {

    /* JADX INFO: renamed from: ｋ, reason: contains not printable characters */
    private static int f2945 = 1;

    /* JADX INFO: renamed from: ﾇ, reason: contains not printable characters */
    private static int f2946;

    /* JADX INFO: renamed from: ﾒ, reason: contains not printable characters */
    private static char[] f2947 = {'.', 'E', '3', '3', '.', 'G', '\\', 23, 'E', 't', 230, 232, 209, 221, 231, 193, 205, 207, 184, 189, 213, 205, 177, 127, '3', 'e', 'd', 'p', 'p', '`', 'a', 'L', 's', '-', '[', 'g', 'g', 'W', 'X', 'C', 28, '2', '9', 'M', 'T'};

    /* JADX INFO: renamed from: ﻐ, reason: contains not printable characters */
    public static int m2874(String str, String str2) {
        f2946 = (f2945 + 53) % 128;
        int i2 = 0;
        String[] strArrSplit = str.replaceAll(m2877("\u0001\u0001\u0001\u0000\u0001\u0000\u0001", true, new int[]{0, 7, 0, 0}).intern(), "").split(m2877("\u0000\u0000", true, new int[]{7, 2, 0, 2}).intern());
        String[] strArrSplit2 = str2.replaceAll(m2877("\u0001\u0001\u0001\u0000\u0001\u0000\u0001", true, new int[]{0, 7, 0, 0}).intern(), "").split(m2877("\u0000\u0000", true, new int[]{7, 2, 0, 2}).intern());
        while (i2 < strArrSplit.length) {
            int i8 = f2945 + 51;
            f2946 = i8 % 128;
            if (i8 % 2 != 0) {
                int length = strArrSplit2.length;
                throw null;
            }
            if (i2 >= strArrSplit2.length || !strArrSplit[i2].equals(strArrSplit2[i2])) {
                break;
            }
            i2++;
        }
        if (i2 >= strArrSplit.length || i2 >= strArrSplit2.length) {
            return Integer.signum(strArrSplit.length - strArrSplit2.length);
        }
        f2946 = (f2945 + 83) % 128;
        return Integer.signum(Integer.valueOf(strArrSplit[i2]).compareTo(Integer.valueOf(strArrSplit2[i2])));
    }

    /* JADX INFO: renamed from: ﻛ, reason: contains not printable characters */
    public static List<String> m2879(String str, String str2) {
        f2946 = (f2945 + 51) % 128;
        List<String> listM2880 = m2880(str, str2, false);
        int i2 = f2946 + 45;
        f2945 = i2 % 128;
        if (i2 % 2 == 0) {
            int i8 = 0 / 0;
        }
        return listM2880;
    }

    /* JADX INFO: renamed from: ｋ, reason: contains not printable characters */
    public static String m2883(String str, JSONArray jSONArray, boolean z2) {
        int i2 = 0;
        while (i2 < jSONArray.length()) {
            f2946 = (f2945 + 111) % 128;
            String strM2876 = m2876(str, jSONArray.optString(i2), z2);
            if (strM2876 != null) {
                f2945 = (f2946 + 15) % 128;
                return strM2876;
            }
            i2++;
            f2945 = (f2946 + 1) % 128;
        }
        return null;
    }

    /* JADX INFO: renamed from: ﾇ, reason: contains not printable characters */
    public static List<String> m2885(String str, JSONArray jSONArray) {
        ArrayList arrayList = new ArrayList();
        int i2 = 0;
        while (i2 < jSONArray.length()) {
            f2945 = (f2946 + 7) % 128;
            arrayList.addAll(m2880(str, jSONArray.optString(i2), false));
            i2++;
            f2946 = (f2945 + 59) % 128;
        }
        f2946 = (f2945 + 37) % 128;
        return arrayList;
    }

    /* JADX INFO: renamed from: ﻛ, reason: contains not printable characters */
    private static List<String> m2880(String str, String str2, boolean z2) {
        ArrayList arrayList = new ArrayList();
        Matcher matcher = Pattern.compile(str2).matcher(str);
        while (matcher.find()) {
            if (matcher.groupCount() == 0) {
                f2946 = (f2945 + 95) % 128;
                arrayList.add(matcher.group());
                if (z2) {
                    int i2 = f2945 + 25;
                    f2946 = i2 % 128;
                    if (i2 % 2 != 0) {
                        int i8 = 93 / 0;
                    }
                    return arrayList;
                }
            } else {
                for (int i9 = 1; i9 <= matcher.groupCount(); i9++) {
                    f2946 = (f2945 + Sdk.SDKError.Reason.INVALID_METRICS_ENDPOINT_VALUE) % 128;
                    arrayList.add(matcher.group(i9));
                    if (z2) {
                        f2946 = (f2945 + 75) % 128;
                        return arrayList;
                    }
                }
            }
        }
        return arrayList;
    }

    /* JADX INFO: renamed from: ｋ, reason: contains not printable characters */
    public static String m2882(String str, String str2) {
        int i2 = f2945 + 1;
        f2946 = i2 % 128;
        String strSubstring = i2 % 2 != 0 ? str.substring(1, str.length() >> str2.length()) : str.substring(0, str.length() - str2.length());
        int i8 = f2945 + 83;
        f2946 = i8 % 128;
        if (i8 % 2 == 0) {
            return strSubstring;
        }
        throw null;
    }

    /* JADX INFO: renamed from: ｋ, reason: contains not printable characters */
    public static boolean m2884(String str) {
        f2946 = (f2945 + 101) % 128;
        if (p.m2965()) {
            int i2 = (f2946 + 3) % 128;
            f2945 = i2;
            f2946 = (i2 + Sdk.SDKError.Reason.INVALID_METRICS_ENDPOINT_VALUE) % 128;
            return false;
        }
        try {
            new GZIPInputStream(new ByteArrayInputStream(Base64.decode(str, 0)));
            return true;
        } catch (Throwable unused) {
            return false;
        }
    }

    /* JADX INFO: renamed from: ﾇ, reason: contains not printable characters */
    public static boolean m2886(String str) {
        int i2 = f2945 + Sdk.SDKError.Reason.INVALID_RI_ENDPOINT_VALUE;
        f2946 = i2 % 128;
        if (i2 % 2 != 0) {
            TextUtils.isEmpty(str);
            throw null;
        }
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        boolean zMatches = str.matches(m2877("\u0000\u0001\u0000\u0000\u0001\u0001\u0000\u0001\u0000\u0001\u0000\u0000\u0001\u0000", false, new int[]{9, 14, Sdk.SDKError.Reason.CONFIG_REFRESH_FAILED_VALUE, 0}).intern());
        f2946 = (f2945 + 35) % 128;
        return zMatches;
    }

    /* JADX INFO: renamed from: ﻐ, reason: contains not printable characters */
    public static String m2876(String str, String str2, boolean z2) {
        if (z2) {
            f2945 = (f2946 + 11) % 128;
            str2 = m2878(str2);
        }
        List<String> listM2880 = m2880(str, str2, true);
        if (listM2880.size() <= 0) {
            return null;
        }
        int i2 = f2946 + 113;
        f2945 = i2 % 128;
        return i2 % 2 == 0 ? listM2880.get(1) : listM2880.get(0);
    }

    /* JADX INFO: renamed from: ﻛ, reason: contains not printable characters */
    public static boolean m2881(String str, int i2) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        f2945 = (f2946 + 75) % 128;
        if (str.length() <= 0) {
            return false;
        }
        f2945 = (f2946 + 37) % 128;
        return str.length() <= i2;
    }

    /* JADX INFO: renamed from: ﻛ, reason: contains not printable characters */
    private static String m2878(String str) {
        int i2 = f2946 + 75;
        f2945 = i2 % 128;
        if (i2 % 2 == 0) {
            TextUtils.isEmpty(str);
            throw null;
        }
        if (!TextUtils.isEmpty(str)) {
            if (!str.startsWith(m2877("\u0001", false, new int[]{23, 1, 161, 1}).intern())) {
                str = a0.d(new StringBuilder(), m2877("\u0001\u0001\u0001\u0001\u0001\u0001\u0000\u0001", false, new int[]{24, 8, 9, 0}), str);
                f2945 = (f2946 + 101) % 128;
            }
            if (!str.endsWith(m2877("\u0000", false, new int[]{32, 1, 194, 0}).intern())) {
                str = com.google.android.gms.ads.internal.client.a.z(androidx.camera.core.processing.util.a.r(str), m2877("\u0001\u0001\u0001\u0001\u0001\u0000\u0001", false, new int[]{33, 7, 0, 0}));
            }
        }
        int i8 = f2946 + 25;
        f2945 = i8 % 128;
        if (i8 % 2 == 0) {
            int i9 = 97 / 0;
        }
        return str;
    }

    /* JADX INFO: renamed from: ﻐ, reason: contains not printable characters */
    public static String m2875(String str) {
        if (str != null) {
            f2946 = (f2945 + 43) % 128;
            if (!p.m2965() && m2884(str)) {
                try {
                    ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(Base64.decode(str, 0));
                    GZIPInputStream gZIPInputStream = new GZIPInputStream(byteArrayInputStream);
                    new ByteArrayOutputStream();
                    byte[] bArr = new byte[8192];
                    f2945 = (f2946 + 13) % 128;
                    int i2 = 0;
                    while (true) {
                        int i8 = gZIPInputStream.read(bArr, i2, 8192 - i2);
                        if (i8 == -1) {
                            gZIPInputStream.close();
                            byteArrayInputStream.close();
                            return new String(bArr, m2877("\u0000\u0001\u0001\u0000\u0001", true, new int[]{40, 5, 0, 5}).intern());
                        }
                        i2 += i8;
                    }
                } catch (Throwable unused) {
                }
            }
        }
        return null;
    }

    /* JADX INFO: renamed from: ﻐ, reason: contains not printable characters */
    private static String m2877(String str, boolean z2, int[] iArr) throws UnsupportedEncodingException {
        String str2;
        Object bytes = str;
        if (str != null) {
            bytes = str.getBytes("ISO-8859-1");
        }
        byte[] bArr = (byte[]) bytes;
        synchronized (g.f2126) {
            try {
                int i2 = iArr[0];
                int i8 = iArr[1];
                int i9 = iArr[2];
                int i10 = iArr[3];
                char[] cArr = new char[i8];
                System.arraycopy(f2947, i2, cArr, 0, i8);
                if (bArr != null) {
                    char[] cArr2 = new char[i8];
                    g.f2125 = 0;
                    char c7 = 0;
                    while (true) {
                        int i11 = g.f2125;
                        if (i11 >= i8) {
                            break;
                        }
                        if (bArr[i11] == 1) {
                            cArr2[i11] = (char) (((cArr[i11] << 1) + 1) - c7);
                        } else {
                            cArr2[i11] = (char) ((cArr[i11] << 1) - c7);
                        }
                        c7 = cArr2[i11];
                        g.f2125 = i11 + 1;
                    }
                    cArr = cArr2;
                }
                if (i10 > 0) {
                    char[] cArr3 = new char[i8];
                    System.arraycopy(cArr, 0, cArr3, 0, i8);
                    int i12 = i8 - i10;
                    System.arraycopy(cArr3, 0, cArr, i12, i10);
                    System.arraycopy(cArr3, i10, cArr, 0, i12);
                }
                if (z2) {
                    char[] cArr4 = new char[i8];
                    g.f2125 = 0;
                    while (true) {
                        int i13 = g.f2125;
                        if (i13 >= i8) {
                            break;
                        }
                        cArr4[i13] = cArr[(i8 - i13) - 1];
                        g.f2125 = i13 + 1;
                    }
                    cArr = cArr4;
                }
                if (i9 > 0) {
                    g.f2125 = 0;
                    while (true) {
                        int i14 = g.f2125;
                        if (i14 >= i8) {
                            break;
                        }
                        cArr[i14] = (char) (cArr[i14] - iArr[2]);
                        g.f2125 = i14 + 1;
                    }
                }
                str2 = new String(cArr);
            } catch (Throwable th) {
                throw th;
            }
        }
        return str2;
    }
}
