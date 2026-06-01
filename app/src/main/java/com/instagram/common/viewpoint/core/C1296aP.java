package com.instagram.common.viewpoint.core;

import android.text.TextUtils;
import com.vungle.ads.internal.protos.Sdk;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;

/* JADX INFO: renamed from: com.facebook.ads.redexgen.X.aP, reason: case insensitive filesystem */
/* JADX INFO: loaded from: assets/audience_network.dex */
public class C1296aP extends AbstractRunnableC1164Vt {
    public static byte[] A05;
    public final /* synthetic */ int A00;
    public final /* synthetic */ SQ A01;
    public final /* synthetic */ InterfaceC1083So A02;
    public final /* synthetic */ C1091Sw A03;
    public final /* synthetic */ String A04;

    static {
        A01();
    }

    public static String A00(int i2, int i8, int i9) {
        byte[] bArrCopyOfRange = Arrays.copyOfRange(A05, i2, i2 + i8);
        for (int i10 = 0; i10 < bArrCopyOfRange.length; i10++) {
            bArrCopyOfRange[i10] = (byte) ((bArrCopyOfRange[i10] - i9) - 7);
        }
        return new String(bArrCopyOfRange);
    }

    public static void A01() {
        A05 = new byte[]{115, -97, -64, -67, -48, -62, 123, -66, -51, -68, -50, -61, 123, -67, -64, -66, -68, -48, -50, -64, 123, -50, -96, -55, -47, -60, -51, -54, -55, -56, -64, -55, -49, -97, -68, -49, -68, -85, -51, -54, -47, -60, -65, -64, -51, 123, -55, -54, -49, 123, -60, -55, -59, -64, -66, -49, -64, -65, 113, -121, -116, -119, 62, -121, -111, 62, -116, -109, -118, -118, 63, -109, -106, -106, -101, -90, -101, -95, -96, -109, -98, -111, -101, -96, -104, -95, 116, -119, 116, 124, 127, 116, 117, 127, 120, 114, 119, 124, -122, 126, 114, -122, -125, 116, 118, 120, -26, -28, -26, -21, -24, -106, -119, -121, -109, -106, -120, -125, -120, -123, -104, -123, -122, -123, -105, -119, -59, -72, -60, -56, -72, -58, -57, -78, -68, -73, -115, -113, 124, -114, -109, -118, 127, -104, -102, -121, -103, -98, -107, -118, -124, -120, -108, -119, -118};
    }

    public C1296aP(SQ sq, String str, int i2, C1091Sw c1091Sw, InterfaceC1083So interfaceC1083So) {
        this.A01 = sq;
        this.A04 = str;
        this.A00 = i2;
        this.A03 = c1091Sw;
        this.A02 = interfaceC1083So;
    }

    @Override // com.instagram.common.viewpoint.core.AbstractRunnableC1164Vt
    public final void A07() {
        String strA03;
        Map<String, String> mapA5S;
        String strA8D;
        try {
            if (C1084Sp.A0K(this.A01, this.A04, this.A00, this.A03)) {
                return;
            }
            C1123Ud.A08(this.A01, UV.A0A.toString() + A00(0, 1, 50) + this.A04);
            Throwable cause = this.A03.getCause();
            if (cause != null) {
                strA03 = X7.A03(this.A01, cause);
            } else if (U9.A0R(this.A01)) {
                SQ sq = this.A01;
                Throwable deLogExceptionCause = this.A03;
                strA03 = X7.A03(sq, deLogExceptionCause);
            } else {
                strA03 = A00(0, 0, 81) + this.A03.getMessage();
            }
            if (U9.A0V(this.A01)) {
                mapA5S = this.A01.A04().A5S();
            } else if (this.A02 != null) {
                mapA5S = this.A02.A7r();
            } else if (C1084Sp.A02) {
                C1084Sp.A0F(new RuntimeException(A00(1, 57, 84), this.A03));
                mapA5S = new HashMap<>();
            } else {
                mapA5S = this.A01.A04().A5S();
            }
            mapA5S.put(A00(Sdk.SDKError.Reason.PRIVACY_URL_ERROR_VALUE, 7, 19), this.A04);
            mapA5S.put(A00(143, 12, 30), String.valueOf(this.A00));
            JSONObject jSONObjectA03 = this.A03.A03();
            if (jSONObjectA03 != null) {
                mapA5S.put(A00(71, 15, 43), jSONObjectA03.toString());
            }
            if ((A00(106, 5, Sdk.SDKError.Reason.INVALID_LOG_ERROR_ENDPOINT_VALUE).equals(this.A04) || A00(111, 15, 29).equals(this.A04)) && (strA8D = this.A01.A04().A8D()) != null) {
                mapA5S.put(A00(86, 20, 12), strA8D);
            }
            String strA0C = this.A01.A0C();
            if (strA0C != null && !TextUtils.isEmpty(strA0C)) {
                mapA5S.put(A00(126, 10, 76), strA0C);
            }
            InterfaceC1082Sn interfaceC1082Sn = (InterfaceC1082Sn) C1084Sp.A0A.get();
            if (interfaceC1082Sn == null) {
                C1084Sp.A0F(new RuntimeException(A00(58, 13, 23)));
            } else {
                interfaceC1082Sn.AKK(strA03, mapA5S, this.A01);
            }
        } catch (Throwable t3) {
            C1084Sp.A0F(t3);
        }
    }
}
