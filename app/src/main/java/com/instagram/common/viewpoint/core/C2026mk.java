package com.instagram.common.viewpoint.core;

import android.media.MediaCodecInfo;
import android.media.MediaCodecList;
import com.vungle.ads.internal.protos.Sdk;
import java.util.Arrays;

/* JADX INFO: renamed from: com.facebook.ads.redexgen.X.mk, reason: case insensitive filesystem */
/* JADX INFO: loaded from: assets/audience_network.dex */
public final class C2026mk implements InterfaceC0631Aw {
    public static byte[] A00;

    static {
        A01();
    }

    public static String A00(int i2, int i8, int i9) {
        byte[] bArrCopyOfRange = Arrays.copyOfRange(A00, i2, i2 + i8);
        for (int i10 = 0; i10 < bArrCopyOfRange.length; i10++) {
            bArrCopyOfRange[i10] = (byte) ((bArrCopyOfRange[i10] ^ i9) ^ 11);
        }
        return new String(bArrCopyOfRange);
    }

    public static void A01() {
        A00 = new byte[]{13, 27, 29, 11, 12, 27, 83, 14, 18, 31, 7, 28, 31, 29, 21, 10, 21, 24, 25, 19, 83, 29, 10, 31};
    }

    public C2026mk() {
    }

    @Override // com.instagram.common.viewpoint.core.InterfaceC0631Aw
    public final int A7H() {
        return MediaCodecList.getCodecCount();
    }

    @Override // com.instagram.common.viewpoint.core.InterfaceC0631Aw
    public final MediaCodecInfo A7I(int i2) {
        return MediaCodecList.getCodecInfoAt(i2);
    }

    @Override // com.instagram.common.viewpoint.core.InterfaceC0631Aw
    public final boolean AAI(String str, String str2, MediaCodecInfo.CodecCapabilities codecCapabilities) {
        return false;
    }

    @Override // com.instagram.common.viewpoint.core.InterfaceC0631Aw
    public final boolean AAJ(String str, String str2, MediaCodecInfo.CodecCapabilities codecCapabilities) {
        return A00(0, 15, Sdk.SDKError.Reason.ASSET_FAILED_STATUS_CODE_VALUE).equals(str) && A00(15, 9, Sdk.SDKError.Reason.JSON_ENCODE_ERROR_VALUE).equals(str2);
    }

    @Override // com.instagram.common.viewpoint.core.InterfaceC0631Aw
    public final boolean AIK() {
        return false;
    }
}
