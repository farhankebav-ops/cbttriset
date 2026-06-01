package com.instagram.common.viewpoint.core;

import com.facebook.ads.internal.api.NativeAdRatingApi;
import java.util.Arrays;
import org.json.JSONObject;

/* JADX INFO: renamed from: com.facebook.ads.redexgen.X.Uq, reason: case insensitive filesystem */
/* JADX INFO: loaded from: assets/audience_network.dex */
public final class C1136Uq implements NativeAdRatingApi {
    public static byte[] A02;
    public static String[] A03 = {"hUjcMotf6J7QgolLzfJFqEdJCj8", "g61DfN6A", "xfoiRdjW7FqaK", "7BIjRnWTmZFI6", "QawwIwJGbW4wV95frp", "JAocLFgZR1eZV5wbskPWRgC49zmLSQ48", "dTzZFi0gHRoFN0fz4IZK", "PRpOn4dc8EeXJ60LxB5o"};
    public final double A00;
    public final double A01;

    public static String A01(int i2, int i8, int i9) {
        byte[] bArrCopyOfRange = Arrays.copyOfRange(A02, i2, i2 + i8);
        for (int i10 = 0; i10 < bArrCopyOfRange.length; i10++) {
            bArrCopyOfRange[i10] = (byte) ((bArrCopyOfRange[i10] - i9) - 53);
        }
        return new String(bArrCopyOfRange);
    }

    public static void A02() {
        byte[] bArr = {20, 4, 2, 13, 6, -68, -89, -78, -69, -85};
        if (A03[0].length() == 23) {
            throw new RuntimeException();
        }
        A03[2] = "JTw9XW";
        A02 = bArr;
    }

    static {
        A02();
    }

    public C1136Uq(double d8, double d9) {
        this.A01 = d8;
        this.A00 = d9;
    }

    public static C1136Uq A00(JSONObject jSONObject) {
        if (jSONObject == null) {
            return null;
        }
        double dOptDouble = jSONObject.optDouble(A01(5, 5, 17), 0.0d);
        double dOptDouble2 = jSONObject.optDouble(A01(0, 5, 108), 0.0d);
        if (dOptDouble == 0.0d || dOptDouble2 == 0.0d) {
            return null;
        }
        return new C1136Uq(dOptDouble, dOptDouble2);
    }

    @Override // com.facebook.ads.internal.api.NativeAdRatingApi
    public final double getScale() {
        return this.A00;
    }

    @Override // com.facebook.ads.internal.api.NativeAdRatingApi
    public final double getValue() {
        return this.A01;
    }
}
