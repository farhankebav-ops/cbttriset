package com.instagram.common.viewpoint.core;

import com.vungle.ads.internal.protos.Sdk;
import java.util.Arrays;
import org.json.JSONArray;
import org.json.JSONException;

/* JADX INFO: renamed from: com.facebook.ads.redexgen.X.fV, reason: case insensitive filesystem */
/* JADX INFO: loaded from: assets/audience_network.dex */
public class C1609fV extends AbstractRunnableC1164Vt {
    public static byte[] A01;
    public static String[] A02 = {"QJHZKkwEEt2XAA8qb811yZkloXTxKqNm", "0Eo8hyAH95ZWxpQDtz3kXr2Dg2BAnbpt", "yx1IzqDtrK1i7eGrpZodHZ", "KUuZPkausU2VOaHnsIAk0Hn07pOf06lA", "ddvRVBlQrtqHFM3JEeiDXs23nPXnVLtA", "0N8fJtCAvq63STI6q3YZ9dLrj33X3xUc", "d0kigy9sFkFC2aZLzfYLsKXCuWX9Z7p3", "u6xVOdZhMjB663K3VBvQukbaw71N5v3b"};
    public final /* synthetic */ C1049Rf A00;

    public static String A00(int i2, int i8, int i9) {
        byte[] bArrCopyOfRange = Arrays.copyOfRange(A01, i2, i2 + i8);
        for (int i10 = 0; i10 < bArrCopyOfRange.length; i10++) {
            int i11 = (bArrCopyOfRange[i10] ^ i9) ^ Sdk.SDKError.Reason.INVALID_ADS_ENDPOINT_VALUE;
            if (A02[2].length() != 22) {
                throw new RuntimeException();
            }
            String[] strArr = A02;
            strArr[3] = "wsWgA7V3OPhtM2agFx6R9FkGRpDQ8hFC";
            strArr[5] = "5QDbKue07C6BH4ozhF9MSdyiVJUT25MO";
            bArrCopyOfRange[i10] = (byte) i11;
        }
        return new String(bArrCopyOfRange);
    }

    public static void A01() {
        A01 = new byte[]{43, 57, 57, 47, 62, 57};
    }

    static {
        A01();
    }

    public C1609fV(C1049Rf c1049Rf) {
        this.A00 = c1049Rf;
    }

    @Override // com.instagram.common.viewpoint.core.AbstractRunnableC1164Vt
    public final void A07() {
        try {
            JSONArray jSONArray = this.A00.A05.getJSONArray(A00(0, 6, 48));
            for (int i2 = 0; i2 < jSONArray.length(); i2++) {
                C1047Rd assetData = C1047Rd.A00(jSONArray.getJSONObject(i2));
                this.A00.A09(assetData.A04, assetData);
            }
            this.A00.A02.A0X(new C1611fX(this), new S8(this.A00.A04, this.A00.A03));
        } catch (JSONException unused) {
            this.A00.A00.post(new C1610fW(this));
        }
    }
}
