package com.ironsource.adqualitysdk.sdk.i;

import android.graphics.Color;
import android.graphics.ImageFormat;
import android.os.Process;
import android.os.SystemClock;
import android.text.AndroidCharacter;
import android.text.TextUtils;
import android.util.TypedValue;
import android.view.Gravity;
import android.view.ViewConfiguration;
import android.widget.ExpandableListView;
import com.vungle.ads.internal.protos.Sdk;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes5.dex */
public final class kc {

    /* JADX INFO: renamed from: ﻐ, reason: contains not printable characters */
    private static int[] f2953 = {585137505, -1153935005, -1073851624, -246246857, 879469207, 862883917, 493837664, 125999003, -1596518699, 319916439, 1517759703, -479740947, 692807989, 726010753, 1744517460, 636271589, 637863345, 2081652814};

    /* JADX INFO: renamed from: ﻛ, reason: contains not printable characters */
    private static int f2954 = 1;

    /* JADX INFO: renamed from: ﾇ, reason: contains not printable characters */
    private static int f2955;

    /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
    public interface b<T> {
        /* JADX INFO: renamed from: ﻐ */
        T mo595(JSONObject jSONObject, String str);
    }

    /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
    public interface c<T> {
        /* JADX INFO: renamed from: ｋ */
        T mo599(JSONArray jSONArray, int i2);
    }

    /* JADX INFO: renamed from: ﻐ, reason: contains not printable characters */
    public static JSONObject m2895(JSONObject jSONObject) {
        int i2 = f2954 + 91;
        f2955 = i2 % 128;
        JSONObject jSONObjectM2909 = m2909(jSONObject, i2 % 2 != 0);
        f2955 = (f2954 + 85) % 128;
        return jSONObjectM2909;
    }

    /* JADX INFO: renamed from: ﻛ, reason: contains not printable characters */
    public static List<String> m2900(JSONArray jSONArray) {
        if (jSONArray == null) {
            int i2 = f2954 + 15;
            f2955 = i2 % 128;
            if (i2 % 2 == 0) {
                return null;
            }
            throw null;
        }
        List<String> listM2911 = m2911(jSONArray);
        int i8 = f2955 + 53;
        f2954 = i8 % 128;
        if (i8 % 2 == 0) {
            int i9 = 0 / 0;
        }
        return listM2911;
    }

    /* JADX INFO: renamed from: ｋ, reason: contains not printable characters */
    private static void m2906(JSONObject jSONObject, int i2) {
        f2954 = (f2955 + 89) % 128;
        m2897(jSONObject, i2, (List<String>) null);
        f2955 = (f2954 + 35) % 128;
    }

    /* JADX INFO: renamed from: ﾇ, reason: contains not printable characters */
    public static JSONObject m2909(JSONObject jSONObject, boolean z2) {
        f2955 = (f2954 + 83) % 128;
        if (jSONObject != null) {
            try {
                JSONObject jSONObject2 = new JSONObject(jSONObject.toString());
                if (z2) {
                    jSONObject2.remove(ig.f2520);
                    f2955 = (f2954 + 75) % 128;
                }
                return jSONObject2;
            } catch (JSONException unused) {
            }
        }
        return new JSONObject();
    }

    /* JADX INFO: renamed from: ﾒ, reason: contains not printable characters */
    public static <T> List<T> m2911(JSONArray jSONArray) {
        List<T> listM2908 = m2908(jSONArray, new c<T>() { // from class: com.ironsource.adqualitysdk.sdk.i.kc.3
            @Override // com.ironsource.adqualitysdk.sdk.i.kc.c
            /* JADX INFO: renamed from: ｋ */
            public final T mo599(JSONArray jSONArray2, int i2) {
                return (T) jSONArray2.opt(i2);
            }
        });
        int i2 = f2955 + 49;
        f2954 = i2 % 128;
        if (i2 % 2 != 0) {
            return listM2908;
        }
        throw null;
    }

    /* JADX INFO: renamed from: ﻐ, reason: contains not printable characters */
    public static void m2899(JSONObject jSONObject, JSONObject jSONObject2, boolean z2) {
        f2955 = (f2954 + 7) % 128;
        if (jSONObject == null || jSONObject2 == null) {
            return;
        }
        Iterator<String> itKeys = jSONObject2.keys();
        while (itKeys.hasNext()) {
            f2954 = (f2955 + 113) % 128;
            String next = itKeys.next();
            try {
                jSONObject.put(next, jSONObject2.opt(next));
            } catch (JSONException unused) {
            }
        }
        if (z2) {
            jSONObject.remove(ig.f2520);
        }
    }

    /* JADX INFO: renamed from: ﻛ, reason: contains not printable characters */
    public static List<String> m2901(JSONObject jSONObject, String str, List<String> list) {
        int i2 = f2955 + Sdk.SDKError.Reason.INVALID_RI_ENDPOINT_VALUE;
        f2954 = i2 % 128;
        if (i2 % 2 == 0) {
            jSONObject.optJSONArray(str);
            throw null;
        }
        JSONArray jSONArrayOptJSONArray = jSONObject.optJSONArray(str);
        if (jSONArrayOptJSONArray != null) {
            return m2900(jSONArrayOptJSONArray);
        }
        f2955 = (f2954 + 53) % 128;
        return list;
    }

    /* JADX INFO: renamed from: ｋ, reason: contains not printable characters */
    private static void m2905(JSONArray jSONArray, int i2) throws JSONException {
        f2954 = (f2955 + 91) % 128;
        int i8 = 0;
        while (i8 < jSONArray.length()) {
            m2896(jSONArray, i8, i2);
            i8++;
            f2955 = (f2954 + 27) % 128;
        }
        f2954 = (f2955 + 79) % 128;
    }

    /* JADX INFO: renamed from: ｋ, reason: contains not printable characters */
    public static Map<String, String> m2903(JSONObject jSONObject) {
        Map<String, String> mapM2902 = m2902(jSONObject, new b<String>() { // from class: com.ironsource.adqualitysdk.sdk.i.kc.1
            @Override // com.ironsource.adqualitysdk.sdk.i.kc.b
            /* JADX INFO: renamed from: ﻐ */
            public final /* synthetic */ String mo595(JSONObject jSONObject2, String str) {
                return jSONObject2.optString(str, null);
            }
        });
        int i2 = f2954 + 101;
        f2955 = i2 % 128;
        if (i2 % 2 == 0) {
            return mapM2902;
        }
        throw null;
    }

    /* JADX INFO: renamed from: ﾇ, reason: contains not printable characters */
    public static void m2910(JSONObject jSONObject, JSONObject jSONObject2) {
        int i2 = f2954 + 21;
        f2955 = i2 % 128;
        m2899(jSONObject, jSONObject2, i2 % 2 != 0);
    }

    /* JADX INFO: renamed from: ｋ, reason: contains not printable characters */
    public static JSONObject m2904(int i2, int i8, long j, long j3) {
        JSONObject jSONObject = new JSONObject();
        try {
            if (j > -1) {
                f2955 = (f2954 + 97) % 128;
                jSONObject.put(m2894(new int[]{-1541009894, -924313111}, (ViewConfiguration.getMaximumDrawingCacheSize() >> 24) + 1).intern(), i2);
                jSONObject.put(m2894(new int[]{1152688240, 266234741}, AndroidCharacter.getMirror('0') - '/').intern(), i8);
                jSONObject.put(m2894(new int[]{-1384553687, 680286553}, 1 - Gravity.getAbsoluteGravity(0, 0)).intern(), j);
                jSONObject.put(m2894(new int[]{-1056622296, 1788332105}, (SystemClock.currentThreadTimeMillis() > (-1L) ? 1 : (SystemClock.currentThreadTimeMillis() == (-1L) ? 0 : -1))).intern(), j3);
            } else {
                jSONObject.put(m2894(new int[]{-1541009894, -924313111}, (ViewConfiguration.getJumpTapTimeout() >> 16) + 1).intern(), -1);
                jSONObject.put(m2894(new int[]{1152688240, 266234741}, Color.green(0) + 1).intern(), -1);
                jSONObject.put(m2894(new int[]{-1384553687, 680286553}, -Process.getGidForName("")).intern(), -1);
                jSONObject.put(m2894(new int[]{-1056622296, 1788332105}, Color.green(0) + 1).intern(), -1);
            }
        } catch (JSONException e) {
            k.m2861(m2894(new int[]{-1349732139, 783411595, -1008704245, 1979279449, -1829298634, -306661175}, 8 - ImageFormat.getBitsPerPixel(0)).intern(), m2894(new int[]{-1281885105, 1214876572, -490413162, 1461695234, 1240285503, 1538012776, -1415646418, -772324787, -1864371192, -819063629, 542209106, -536855876, -1789634290, 1612620357, -2105414827, 1090236688}, 29 - (ViewConfiguration.getEdgeSlop() >> 16)).intern(), (Throwable) e);
        }
        int i9 = f2954 + 103;
        f2955 = i9 % 128;
        if (i9 % 2 == 0) {
            return jSONObject;
        }
        throw null;
    }

    /* JADX INFO: renamed from: ﾇ, reason: contains not printable characters */
    public static <T> List<T> m2908(JSONArray jSONArray, c<T> cVar) {
        f2954 = (f2955 + 65) % 128;
        if (jSONArray == null) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        int i2 = 0;
        while (i2 < jSONArray.length()) {
            T tMo599 = cVar.mo599(jSONArray, i2);
            if (tMo599 != null) {
                arrayList.add(tMo599);
            }
            i2++;
            f2954 = (f2955 + 3) % 128;
        }
        return arrayList;
    }

    /* JADX INFO: renamed from: ﻛ, reason: contains not printable characters */
    public static <T> Map<String, T> m2902(JSONObject jSONObject, b<T> bVar) {
        if (jSONObject == null) {
            f2954 = (f2955 + Sdk.SDKError.Reason.INVALID_METRICS_ENDPOINT_VALUE) % 128;
            return null;
        }
        HashMap map = new HashMap();
        Iterator<String> itKeys = jSONObject.keys();
        while (itKeys.hasNext()) {
            String next = itKeys.next();
            map.put(next, bVar.mo595(jSONObject, next));
        }
        int i2 = f2954 + 17;
        f2955 = i2 % 128;
        if (i2 % 2 == 0) {
            return map;
        }
        throw null;
    }

    /* JADX INFO: renamed from: ﻐ, reason: contains not printable characters */
    public static void m2897(JSONObject jSONObject, int i2, List<String> list) {
        try {
            JSONArray jSONArrayNames = jSONObject.names();
            if (jSONArrayNames != null) {
                f2955 = (f2954 + 9) % 128;
                for (int i8 = 0; i8 < jSONArrayNames.length(); i8++) {
                    f2954 = (f2955 + 35) % 128;
                    String strOptString = jSONArrayNames.optString(i8);
                    if (list != null) {
                        f2955 = (f2954 + 61) % 128;
                        if (!list.contains(strOptString)) {
                            m2898(jSONObject, strOptString, i2);
                        }
                    } else {
                        m2898(jSONObject, strOptString, i2);
                    }
                }
            }
        } catch (JSONException e) {
            k.m2861(m2894(new int[]{-1349732139, 783411595, -1008704245, 1979279449, -1829298634, -306661175}, (ExpandableListView.getPackedPositionForChild(0, 0) > 0L ? 1 : (ExpandableListView.getPackedPositionForChild(0, 0) == 0L ? 0 : -1)) + 10).intern(), m2894(new int[]{-1281885105, 1214876572, -1739218394, -69952560, -598892577, 1530458490, -624014220, -1520230438, -1789634290, 1612620357, -2105414827, 1090236688}, TextUtils.getTrimmedLength("") + 21).intern(), (Throwable) e);
        }
    }

    /* JADX INFO: renamed from: ﾇ, reason: contains not printable characters */
    private static String m2907(Object obj, int i2) throws JSONException {
        int i8 = f2955;
        f2954 = (i8 + 115) % 128;
        if (obj instanceof JSONObject) {
            f2954 = (i8 + Sdk.SDKError.Reason.TPAT_ERROR_VALUE) % 128;
            m2906((JSONObject) obj, i2);
        } else if (obj instanceof JSONArray) {
            m2905((JSONArray) obj, i2);
        } else if (obj instanceof String) {
            int i9 = i8 + 65;
            f2954 = i9 % 128;
            if (i9 % 2 != 0) {
                String str = (String) obj;
                if (str.length() <= i2) {
                    return str;
                }
                StringBuilder sb = new StringBuilder();
                sb.append(str.substring(0, i2));
                String strZ = com.google.android.gms.ads.internal.client.a.z(sb, m2894(new int[]{-1071674465, 310275926, -1727224816, 1312209778, -1801294351, -1058775554, -64801234, 335709623}, 14 - (TypedValue.complexToFraction(0, 0.0f, 0.0f) > 0.0f ? 1 : (TypedValue.complexToFraction(0, 0.0f, 0.0f) == 0.0f ? 0 : -1))));
                f2954 = (f2955 + 97) % 128;
                return strZ;
            }
            ((String) obj).length();
            throw null;
        }
        return null;
    }

    /* JADX INFO: renamed from: ﻐ, reason: contains not printable characters */
    private static void m2898(JSONObject jSONObject, String str, int i2) throws JSONException {
        f2955 = (f2954 + 77) % 128;
        String strM2907 = m2907(jSONObject.opt(str), i2);
        if (strM2907 != null) {
            if (strM2907.equals("")) {
                int i8 = f2954 + 115;
                f2955 = i8 % 128;
                if (i8 % 2 != 0) {
                    int i9 = 37 / 0;
                }
                strM2907 = null;
            }
            jSONObject.put(str, strM2907);
        }
    }

    /* JADX INFO: renamed from: ﻐ, reason: contains not printable characters */
    private static void m2896(JSONArray jSONArray, int i2, int i8) throws JSONException {
        String strM2907 = m2907(jSONArray.opt(i2), i8);
        if (strM2907 != null) {
            int i9 = f2955 + 73;
            f2954 = i9 % 128;
            int i10 = i9 % 2;
            jSONArray.put(i2, strM2907);
            if (i10 == 0) {
                int i11 = 25 / 0;
            }
            f2955 = (f2954 + 17) % 128;
        }
        f2955 = (f2954 + Sdk.SDKError.Reason.INVALID_METRICS_ENDPOINT_VALUE) % 128;
    }

    /* JADX INFO: renamed from: ﻐ, reason: contains not printable characters */
    private static String m2894(int[] iArr, int i2) {
        String str;
        synchronized (d.f1664) {
            try {
                char[] cArr = new char[4];
                char[] cArr2 = new char[iArr.length << 1];
                int[] iArr2 = (int[]) f2953.clone();
                d.f1665 = 0;
                while (true) {
                    int i8 = d.f1665;
                    if (i8 < iArr.length) {
                        int i9 = iArr[i8];
                        char c7 = (char) (i9 >> 16);
                        cArr[0] = c7;
                        char c8 = (char) i9;
                        cArr[1] = c8;
                        char c9 = (char) (iArr[i8 + 1] >> 16);
                        cArr[2] = c9;
                        char c10 = (char) iArr[i8 + 1];
                        cArr[3] = c10;
                        d.f1663 = (c7 << 16) + c8;
                        d.f1666 = (c9 << 16) + c10;
                        d.m1895(iArr2);
                        for (int i10 = 0; i10 < 16; i10++) {
                            int i11 = d.f1663 ^ iArr2[i10];
                            d.f1663 = i11;
                            int iM1894 = d.m1894(i11) ^ d.f1666;
                            int i12 = d.f1663;
                            d.f1663 = iM1894;
                            d.f1666 = i12;
                        }
                        int i13 = d.f1663;
                        int i14 = d.f1666;
                        d.f1663 = i14;
                        d.f1666 = i13;
                        int i15 = i13 ^ iArr2[16];
                        d.f1666 = i15;
                        int i16 = i14 ^ iArr2[17];
                        d.f1663 = i16;
                        cArr[0] = (char) (i16 >>> 16);
                        cArr[1] = (char) i16;
                        cArr[2] = (char) (i15 >>> 16);
                        cArr[3] = (char) i15;
                        d.m1895(iArr2);
                        int i17 = d.f1665;
                        cArr2[i17 << 1] = cArr[0];
                        cArr2[(i17 << 1) + 1] = cArr[1];
                        cArr2[(i17 << 1) + 2] = cArr[2];
                        cArr2[(i17 << 1) + 3] = cArr[3];
                        d.f1665 = i17 + 2;
                    } else {
                        str = new String(cArr2, 0, i2);
                    }
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        return str;
    }
}
