package com.instagram.common.viewpoint.core;

import android.content.SharedPreferences;
import com.facebook.ads.internal.util.process.ProcessUtils;
import com.vungle.ads.internal.protos.Sdk;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: renamed from: com.facebook.ads.redexgen.X.Ud, reason: case insensitive filesystem */
/* JADX INFO: loaded from: assets/audience_network.dex */
public final class C1123Ud {
    public static byte[] A00;
    public static final String A01;
    public static final Map<String, Integer> A02;
    public static final AtomicInteger A03;

    public static String A01(int i2, int i8, int i9) {
        byte[] bArrCopyOfRange = Arrays.copyOfRange(A00, i2, i2 + i8);
        for (int i10 = 0; i10 < bArrCopyOfRange.length; i10++) {
            bArrCopyOfRange[i10] = (byte) ((bArrCopyOfRange[i10] - i9) - 57);
        }
        return new String(bArrCopyOfRange);
    }

    public static void A04() {
        A00 = new byte[]{-82, -96, -50, -27, -9, -96, -10, -31, -20, -11, -27, -70, -96, -111, -88, -124, -87, -77, -80, -95, -76, -93, -88, -87, -82, -89, 96, -84, -81, -93, -95, -84, 96, -93, -81, -75, -82, -76, -91, -78, -77, 122, 96, -4, 33, 22, 37, 24, 32, 24, 33, 39, 28, 33, 26, -45, 22, 34, 40, 33, 39, 24, 37, -19, -45, -7, 28, 16, 14, 25, -16, 28, 34, 27, 33, 18, 31, 32, -99, -96, -96, -91, -80, -91, -85, -86, -99, -88, -101, -91, -86, -94, -85, -35, -16, -16, -31, -23, -20, -16, -84, -86, -66, -80, -79, -67, -88, -82, -63, -84, -82, -71, -67, -78, -72, -73, -17, -5, -7, -70, -14, -19, -17, -15, -18, -5, -5, -9, -70, -19, -16, -1, -70, -40, -37, -49, -51, -40, -21, -49, -37, -31, -38, -32, -47, -34, -33, -87, -90, -71, -90, -95, -78, -95, -86, -80, -81, 24, 27, 15, 13, 24, 11, 15, 27, 33, 26, 32, 17, 30, 31, -47, -62, -38, -51, -48, -62, -59, -10, -9, -28, -26, -18, -9, -11, -28, -26, -24, -48, -46, -65, -47, -42, -51, -62, -47, -45, -64, -46, -41, -50, -61, -67, -63, -51, -62, -61};
    }

    /* JADX WARN: Failed to parse debug info
    java.lang.ArrayIndexOutOfBoundsException
     */
    public static void A06(SQ sq, InterfaceC1556ed interfaceC1556ed, Map<String, ?> map) throws JSONException {
        HashMap map2 = new HashMap();
        map2.put(A01(93, 7, 67), A01(13, 1, 40));
        A0A(sq, map2);
        HashMap map3 = new HashMap();
        map3.put(A01(188, 7, 36), A01(157, 14, 115));
        map3.put(A01(195, 12, 37), String.valueOf(3501));
        map3.put(A01(100, 16, 16), A01(14, 1, 62));
        map3.put(A01(178, 10, 74), A01(65, 13, 116));
        JSONObject jSONObject = new JSONObject();
        for (Map.Entry<String, ?> entry : map.entrySet()) {
            jSONObject.put(entry.getKey(), String.valueOf(entry.getValue()));
        }
        if (sq.A05().AAF()) {
            String str = A01(15, 28, 7) + jSONObject.toString(2);
        }
        map3.put(A01(78, 15, 3), jSONObject.toString());
        A0A(sq, map3);
        TP tpA09 = sq.A09();
        JSONObject jSONObjectA05 = C1092Sx.A05(new C1094Sz(tpA09.A01(), tpA09.A02(), map3));
        JSONArray jSONArray = new JSONArray();
        jSONArray.put(jSONObjectA05);
        JSONObject jSONObject2 = new JSONObject();
        jSONObject2.put(A01(147, 4, 12), new JSONObject(map2));
        jSONObject2.put(A01(151, 6, 3), jSONArray);
        C1570er c1570er = new C1570er();
        c1570er.put(A01(171, 7, 40), jSONObject2.toString());
        interfaceC1556ed.AGE(sq.A05().A7y(), c1570er.A08(), new V7(sq));
    }

    /* JADX WARN: Failed to parse debug info
    java.lang.ArrayIndexOutOfBoundsException
     */
    public static void A0A(SQ sq, Map<String, String> map) {
        map.putAll(sq.A04().A5S());
    }

    static {
        A04();
        A01 = C1123Ud.class.getSimpleName();
        A03 = new AtomicInteger(0);
        A02 = new HashMap();
    }

    public static void A05(SQ sq) {
        if (A0C(sq)) {
            return;
        }
        synchronized (C1123Ud.class) {
            if (A03.get() != 0) {
                return;
            }
            A03.set(1);
            XU.A06.execute(new VD(sq));
        }
    }

    public static void A08(SQ sq, String str) {
        int value;
        int iIntValue;
        if (A0C(sq)) {
            return;
        }
        synchronized (C1123Ud.class) {
            if (A03.get() != 2) {
                if (A02.containsKey(str)) {
                    iIntValue = A02.get(str).intValue();
                } else {
                    iIntValue = 0;
                }
                value = iIntValue + 1;
                A02.put(str, Integer.valueOf(value));
            } else {
                SharedPreferences sharedPreferences = sq.getApplicationContext().getSharedPreferences(ProcessUtils.getProcessSpecificName(A01(116, 31, 83), sq), 0);
                value = sharedPreferences.getInt(str, 0) + 1;
                sharedPreferences.edit().putInt(str, value).apply();
            }
            if (sq.A05().AAF()) {
                String str2 = A01(43, 22, Sdk.SDKError.Reason.INVALID_ADS_ENDPOINT_VALUE) + str + A01(0, 13, 71) + value;
            }
        }
    }

    public static void A09(SQ sq, String str) {
        if (A0C(sq)) {
            return;
        }
        XU.A06.execute(new VC(sq, str));
    }

    public static boolean A0B(double d8, int i2) {
        return i2 <= 0 || d8 >= 1.0d / ((double) i2);
    }

    public static boolean A0C(SQ sq) {
        if (sq.A05().AAF()) {
            return false;
        }
        if (!U9.A0U(sq)) {
            return true;
        }
        return A0B(sq.A09().A00(), U9.A0C(sq));
    }
}
