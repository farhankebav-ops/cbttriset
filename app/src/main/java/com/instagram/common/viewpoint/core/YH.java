package com.instagram.common.viewpoint.core;

import com.vungle.ads.internal.protos.Sdk;
import java.util.Arrays;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: assets/audience_network.dex */
public final class YH implements LI {
    public static byte[] A01;
    public final SQ A00;

    static {
        A01();
    }

    public static String A00(int i2, int i8, int i9) {
        byte[] bArrCopyOfRange = Arrays.copyOfRange(A01, i2, i2 + i8);
        for (int i10 = 0; i10 < bArrCopyOfRange.length; i10++) {
            bArrCopyOfRange[i10] = (byte) ((bArrCopyOfRange[i10] - i9) - 24);
        }
        return new String(bArrCopyOfRange);
    }

    public static void A01() {
        A01 = new byte[]{-93, -73, -56, -82, -118, -71, -78, -78, -87, -80, -87, -40, -47, -47, -56, -49, -99, -125, -39, -24, -2, -52, -3, -20, -11, -5, -26, -117, -102, -109, -109, -118, -111, -68, -53, -60, -60, -69, -62, -75, -62, -59, -67, -67, -69, -70, -58, -43, -50, -50, -59, -52, -65, -52, -49, -57, -57, -55, -50, -57, -65, -51, -49, -60, -59};
    }

    public YH(SQ sq) {
        this.A00 = sq;
    }

    private void A02(int i2, String str, JSONObject jSONObject, boolean z2, int i8) {
        C1091Sw c1091Sw = new C1091Sw(A00(4, 6, 44));
        c1091Sw.A07(jSONObject);
        c1091Sw.A05(1);
        c1091Sw.A09(z2);
        c1091Sw.A04(i8);
        try {
            jSONObject.put(A00(33, 13, 62), C1084Sp.A0H(this.A00));
        } catch (JSONException unused) {
        }
        try {
            jSONObject.put(A00(46, 19, 72), i8);
        } catch (JSONException unused2) {
        }
        this.A00.A08().AAz(A00(27, 6, 13), i2 + 4000, c1091Sw);
        if (this.A00.A05().AAF()) {
            String str2 = A00(10, 8, 75) + str + A00(0, 1, 99) + i2 + A00(1, 3, Sdk.SDKError.Reason.PROTOBUF_SERIALIZATION_ERROR_VALUE) + jSONObject.toString();
        }
    }

    public static boolean A03(LK lk) {
        for (LK lk2 : C1172Wb.A06) {
            if (lk2.equals(lk)) {
                return true;
            }
        }
        return false;
    }

    @Override // com.instagram.common.viewpoint.core.LI
    public final void AB0(LK lk, JSONObject jSONObject, int i2) {
        A02(lk.A03(), lk.toString(), jSONObject, A03(lk), i2);
    }

    @Override // com.instagram.common.viewpoint.core.LI
    public final void ABM(int i2, JSONObject jSONObject, int i8) {
        A02(i2, A00(18, 9, 111) + i2, jSONObject, false, i8);
    }
}
