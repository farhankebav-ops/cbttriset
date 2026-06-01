package com.instagram.common.viewpoint.core;

import com.vungle.ads.internal.protos.Sdk;
import java.util.Arrays;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: assets/audience_network.dex */
public abstract class T0 {
    public static byte[] A00;

    static {
        A02();
    }

    public static String A00(int i2, int i8, int i9) {
        byte[] bArrCopyOfRange = Arrays.copyOfRange(A00, i2, i2 + i8);
        for (int i10 = 0; i10 < bArrCopyOfRange.length; i10++) {
            bArrCopyOfRange[i10] = (byte) ((bArrCopyOfRange[i10] ^ i9) ^ 112);
        }
        return new String(bArrCopyOfRange);
    }

    public static void A02() {
        A00 = new byte[]{23, 52, 60, 60, 50, 53, 60, 123, 21, 62, 47, 44, 52, 41, 48, 123, 30, 45, 62, 53, 47, 34, 51, 52, 39, 50, 47, 41, 40, 96, 119, 119, 106, 119, 32, 60, 60, 56, 23, 59, 60, 41, 60, 61, 59, 23, 43, 39, 44, 45, 98, 105, 120, 123, 99, 126, 103, 41, 56, 32, 53, 54, 56, 61, 6, 42, 48, 35, 60, 55, 48, 37, 54, 48, 27, 48, 45, 41, 33, 40, 45, 49, 50, 60, 57, 2, 46, 52, 39, 56};
    }

    public static JSONObject A01(SQ sq, long j, long j3, long j8, long j9, int i2, Exception exc) {
        JSONObject jSONObject = new JSONObject();
        try {
            try {
                jSONObject.put(A00(69, 10, 52), j);
                try {
                    jSONObject.put(A00(21, 8, 54), j3 / 1000.0d);
                    try {
                        jSONObject.put(A00(57, 12, 41), j8);
                        try {
                            jSONObject.put(A00(79, 11, 45), j9);
                            try {
                                jSONObject.put(A00(34, 16, 56), i2);
                                if (exc != null) {
                                    jSONObject.put(A00(29, 5, Sdk.SDKError.Reason.ASSET_FAILED_STATUS_CODE_VALUE), exc.getMessage());
                                }
                            } catch (JSONException e) {
                                e = e;
                                sq.A08().A4A(e);
                            }
                        } catch (JSONException e4) {
                            e = e4;
                        }
                    } catch (JSONException e8) {
                        e = e8;
                    }
                } catch (JSONException e9) {
                    e = e9;
                }
            } catch (JSONException e10) {
                e = e10;
            }
        } catch (JSONException e11) {
            e = e11;
        }
        return jSONObject;
    }

    public static void A03(SQ sq, long j, long j3, long j8, long j9, int i2, Exception exc) {
        C1091Sw c1091Sw = new C1091Sw(A00(0, 21, 43));
        c1091Sw.A05(1);
        c1091Sw.A07(A01(sq, j, j3, j8, j9, i2, exc));
        sq.A08().ABZ(A00(50, 7, Sdk.SDKError.Reason.INVALID_LOG_ERROR_ENDPOINT_VALUE), AbstractC1090Sv.A20, c1091Sw);
    }
}
