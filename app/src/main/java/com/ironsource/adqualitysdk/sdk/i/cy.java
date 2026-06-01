package com.ironsource.adqualitysdk.sdk.i;

import android.util.TypedValue;
import android.view.ViewConfiguration;
import android.widget.ExpandableListView;
import com.vungle.ads.internal.protos.Sdk;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes5.dex */
public final class cy extends da {

    /* JADX INFO: renamed from: ﻐ, reason: contains not printable characters */
    private static long f1658 = 0;

    /* JADX INFO: renamed from: ﻛ, reason: contains not printable characters */
    private static int f1659 = -301621572;

    /* JADX INFO: renamed from: ｋ, reason: contains not printable characters */
    private static char f1660 = 0;

    /* JADX INFO: renamed from: ﾇ, reason: contains not printable characters */
    private static int f1661 = 1;

    /* JADX INFO: renamed from: ﾒ, reason: contains not printable characters */
    private static int f1662;

    /* JADX INFO: renamed from: ﻐ, reason: contains not printable characters */
    public static char m1885(List<Object> list) {
        f1662 = (f1661 + 17) % 128;
        char cIntValue = (char) ((Number) da.m1896(list, 0, Number.class)).intValue();
        int i2 = f1661 + 59;
        f1662 = i2 % 128;
        if (i2 % 2 == 0) {
            return cIntValue;
        }
        throw null;
    }

    /* JADX INFO: renamed from: ｋ, reason: contains not printable characters */
    public static Class m1886(List<Object> list) {
        f1662 = (f1661 + 69) % 128;
        Class<?> cls = Array.newInstance((Class<?>) da.m1896(list, 0, Class.class), 0).getClass();
        int i2 = f1662 + 83;
        f1661 = i2 % 128;
        if (i2 % 2 != 0) {
            return cls;
        }
        throw null;
    }

    /* JADX INFO: renamed from: ﾒ, reason: contains not printable characters */
    public static Object m1888(cp cpVar, List<Object> list) {
        List list2;
        String string;
        Class cls = (Class) da.m1896(list, 0, Class.class);
        List arrayList = new ArrayList();
        if (list.size() > 1) {
            arrayList = (List) da.m1896(list, 1, List.class);
        }
        if (list.size() > 2) {
            f1661 = (f1662 + Sdk.SDKError.Reason.INVALID_RI_ENDPOINT_VALUE) % 128;
            list2 = (List) da.m1896(list, 2, List.class);
        } else {
            list2 = null;
        }
        try {
            if (list2 == null) {
                return jz.m2834(cls, (List<Object>) arrayList);
            }
            Class[] clsArr = new Class[list2.size()];
            list2.toArray(clsArr);
            return jz.m2831(cls, arrayList, clsArr);
        } catch (Exception e) {
            String strM1666 = cpVar.m1730().m1666();
            StringBuilder sb = new StringBuilder();
            sb.append(m1887("뤔墋㴭磄", (char) (50237 - (ViewConfiguration.getJumpTapTimeout() >> 16)), "䛊Η瓲䃾꽸뾴䙰䛸魰Ⰽ\udf3a䴫䙄\udca0엣ꄓ釘ꗊ폏", (ViewConfiguration.getZoomControlsTimeout() > 0L ? 1 : (ViewConfiguration.getZoomControlsTimeout() == 0L ? 0 : -1)) + 760777656, "\u0000\u0000\u0000\u0000").intern());
            sb.append(cls.getName());
            sb.append(m1887("쁚\uea79\uf169蘦", (char) ExpandableListView.getPackedPositionType(0L), "효\uf2ad곙\ue03bᱬ\ue82c듔䲀튙㺳ྟ", (TypedValue.complexToFloat(0) > 0.0f ? 1 : (TypedValue.complexToFloat(0) == 0.0f ? 0 : -1)) + 1776974272, "\u0000\u0000\u0000\u0000").intern());
            sb.append(arrayList);
            if (list2 != null) {
                StringBuilder sb2 = new StringBuilder();
                sb2.append(m1887("\ud8d8ऍ\udc25\ue1a6", (char) (42716 - (ViewConfiguration.getScrollBarFadeDuration() >> 16)), "ㅥ깿덊\ue364頗ᠲ嚄찼㤘\ud810∓\uf11f殯", (ViewConfiguration.getLongPressTimeout() >> 16) + 621350360, "\u0000\u0000\u0000\u0000").intern());
                sb2.append(list2);
                string = sb2.toString();
                f1661 = (f1662 + 95) % 128;
            } else {
                string = "";
            }
            sb.append(string);
            co.m1671(strM1666, sb.toString(), e);
            return null;
        }
    }

    /* JADX INFO: renamed from: ｋ, reason: contains not printable characters */
    private static String m1887(String str, char c7, String str2, int i2, String str3) {
        String str4;
        Object charArray = str3;
        if (str3 != null) {
            charArray = str3.toCharArray();
        }
        char[] cArr = (char[]) charArray;
        Object charArray2 = str2;
        if (str2 != null) {
            charArray2 = str2.toCharArray();
        }
        char[] cArr2 = (char[]) charArray2;
        Object charArray3 = str;
        if (str != null) {
            charArray3 = str.toCharArray();
        }
        char[] cArr3 = (char[]) charArray3;
        synchronized (f.f2031) {
            try {
                char[] cArr4 = (char[]) cArr3.clone();
                char[] cArr5 = (char[]) cArr.clone();
                cArr4[0] = (char) (c7 ^ cArr4[0]);
                cArr5[2] = (char) (cArr5[2] + ((char) i2));
                int length = cArr2.length;
                char[] cArr6 = new char[length];
                f.f2032 = 0;
                while (true) {
                    int i8 = f.f2032;
                    if (i8 < length) {
                        int i9 = (i8 + 2) % 4;
                        int i10 = (i8 + 3) % 4;
                        int i11 = cArr4[i8 % 4] * 32718;
                        char c8 = cArr5[i9];
                        char c9 = (char) ((i11 + c8) % 65535);
                        f.f2030 = c9;
                        cArr5[i10] = (char) com.google.android.gms.ads.internal.client.a.w(cArr4[i10], 32718, c8, 65535);
                        cArr4[i10] = c9;
                        int i12 = f.f2032;
                        cArr6[i12] = (char) (((((long) (c9 ^ cArr2[i12])) ^ f1658) ^ ((long) f1659)) ^ ((long) f1660));
                        f.f2032 = i12 + 1;
                    } else {
                        str4 = new String(cArr6);
                    }
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        return str4;
    }

    /* JADX INFO: renamed from: ﾒ, reason: contains not printable characters */
    public static boolean m1889(List<Object> list) {
        int i2 = f1661 + 103;
        f1662 = i2 % 128;
        if (i2 % 2 == 0 ? jz.m2842(da.m1896(list, 0, Object.class), (String) da.m1896(list, 1, String.class), (List) da.m1896(list, 2, List.class)) != null : jz.m2842(da.m1896(list, 1, Object.class), (String) da.m1896(list, 1, String.class), (List) da.m1896(list, 4, List.class)) != null) {
            return true;
        }
        f1661 = (f1662 + 61) % 128;
        return false;
    }
}
