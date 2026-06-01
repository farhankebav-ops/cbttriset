package com.instagram.common.viewpoint.core;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: renamed from: com.facebook.ads.redexgen.X.Mx, reason: case insensitive filesystem */
/* JADX INFO: loaded from: assets/audience_network.dex */
public abstract class AbstractC0939Mx {
    public static byte[] A00;

    static {
        A02();
    }

    public static String A00(int i2, int i8, int i9) {
        byte[] bArrCopyOfRange = Arrays.copyOfRange(A00, i2, i2 + i8);
        for (int i10 = 0; i10 < bArrCopyOfRange.length; i10++) {
            bArrCopyOfRange[i10] = (byte) ((bArrCopyOfRange[i10] ^ i9) ^ 78);
        }
        return new String(bArrCopyOfRange);
    }

    public static void A02() {
        A00 = new byte[]{24, 26, 9, 20, 14, 8, 30, 23, 100, 117, 102, 103, 125, 122, 115, 85, 74, 71, 70, 76, 124, 86, 81, 79};
    }

    public static List<C0931Mp> A01(JSONArray jSONArray, JSONObject jSONObject, C1477dL c1477dL, N1 n12) {
        ArrayList arrayList = new ArrayList();
        for (int i2 = 0; i2 < jSONArray.length(); i2++) {
            try {
                JSONObject jSONObject2 = jSONArray.getJSONObject(i2);
                if (i2 == 0) {
                    A03(jSONObject2, jSONObject);
                }
                C0931Mp c0931MpA00 = C0931Mp.A00(jSONObject2);
                n12.A3q(c0931MpA00, jSONObject2);
                arrayList.add(c0931MpA00);
            } catch (JSONException e) {
                c1477dL.A08().AAy(A00(8, 7, 90), AbstractC1090Sv.A2B, new C1091Sw(e));
            }
        }
        return arrayList;
    }

    public static void A03(JSONObject jSONObject, JSONObject jSONObject2) throws JSONException {
        Iterator<String> itKeys = jSONObject2.keys();
        while (itKeys.hasNext()) {
            String next = itKeys.next();
            if (!next.equals(A00(15, 9, 109)) && !next.equals(A00(0, 8, 53)) && !jSONObject.has(next)) {
                jSONObject.put(next, jSONObject2.opt(next));
            }
        }
    }
}
