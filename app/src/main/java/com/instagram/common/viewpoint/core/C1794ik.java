package com.instagram.common.viewpoint.core;

import android.net.Uri;
import android.text.TextUtils;
import java.util.Arrays;
import java.util.Map;

/* JADX INFO: renamed from: com.facebook.ads.redexgen.X.ik, reason: case insensitive filesystem */
/* JADX INFO: loaded from: assets/audience_network.dex */
public final class C1794ik extends MH {
    public static byte[] A02;
    public static final String A03;
    public final Uri A00;
    public final Map<String, String> A01;

    public static String A00(int i2, int i8, int i9) {
        byte[] bArrCopyOfRange = Arrays.copyOfRange(A02, i2, i2 + i8);
        for (int i10 = 0; i10 < bArrCopyOfRange.length; i10++) {
            bArrCopyOfRange[i10] = (byte) ((bArrCopyOfRange[i10] - i9) - 87);
        }
        return new String(bArrCopyOfRange);
    }

    public static void A01() {
        A02 = new byte[]{52, 54, 45, 51, 54, 45, 56, 61, -32, -27, -36, -47};
    }

    static {
        A01();
        A03 = C1794ik.class.getSimpleName();
    }

    public C1794ik(C1477dL c1477dL, US us, String str, Uri uri, Map<String, String> mExtraData) {
        super(c1477dL, us, str);
        this.A00 = uri;
        this.A01 = mExtraData;
    }

    @Override // com.instagram.common.viewpoint.core.MH
    public final ME A0G(String str) {
        UU uu = UU.A05;
        String queryParameter = this.A00.getQueryParameter(A00(0, 8, 109));
        if (!TextUtils.isEmpty(queryParameter)) {
            try {
                uu = UU.values()[Integer.valueOf(queryParameter).intValue()];
            } catch (Exception unused) {
            }
        }
        this.A02.ABK(this.A03, this.A01, this.A00.getQueryParameter(A00(8, 4, 21)), uu);
        return ME.A09;
    }
}
