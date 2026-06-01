package com.instagram.common.viewpoint.core;

import android.net.Uri;
import android.text.TextUtils;
import com.vungle.ads.internal.protos.Sdk;
import java.util.Arrays;
import java.util.Map;

/* JADX INFO: renamed from: com.facebook.ads.redexgen.X.7P, reason: invalid class name */
/* JADX INFO: loaded from: assets/audience_network.dex */
public final class C7P extends AbstractC1796im {
    public static byte[] A03;
    public Map<String, String> A00;
    public boolean A01;
    public final Uri A02;

    static {
        A01();
    }

    public static String A00(int i2, int i8, int i9) {
        byte[] bArrCopyOfRange = Arrays.copyOfRange(A03, i2, i2 + i8);
        for (int i10 = 0; i10 < bArrCopyOfRange.length; i10++) {
            bArrCopyOfRange[i10] = (byte) ((bArrCopyOfRange[i10] ^ i9) ^ 77);
        }
        return new String(bArrCopyOfRange);
    }

    public static void A01() {
        A03 = new byte[]{88, 93, 90, 95, 59, 60, 39, 58, 45, 23, 61, 58, 36, 23, 63, 45, 42, 23, 46, 41, 36, 36, 42, 41, 43, 35};
    }

    public C7P(C1477dL c1477dL, US us, String str, Uri uri, Map<String, String> mExtraData) {
        super(c1477dL, us, str, null, true, true);
        this.A02 = uri;
        this.A00 = mExtraData;
    }

    public C7P(C1477dL c1477dL, US us, String str, Uri uri, Map<String, String> mExtraData, boolean z2) {
        this(c1477dL, us, str, uri, mExtraData);
        this.A01 = z2;
    }

    @Override // com.instagram.common.viewpoint.core.AbstractC1796im
    public final ME A0H() {
        A0J(this.A00, null);
        return ME.A09;
    }

    public final Uri A0M() {
        String queryParameter = this.A02.getQueryParameter(A00(4, 22, 5));
        if (this.A01 && !TextUtils.isEmpty(queryParameter)) {
            return WQ.A00(queryParameter);
        }
        Uri uri = this.A02;
        String url = A00(0, 4, Sdk.SDKError.Reason.TPAT_ERROR_VALUE);
        return WQ.A00(uri.getQueryParameter(url));
    }
}
