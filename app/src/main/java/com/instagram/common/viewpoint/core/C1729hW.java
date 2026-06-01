package com.instagram.common.viewpoint.core;

import android.media.MediaCodec;
import android.os.Build;
import com.vungle.ads.internal.protos.Sdk;
import java.io.IOException;
import java.util.Arrays;
import java.util.Iterator;
import javax.annotation.Nullable;

/* JADX INFO: renamed from: com.facebook.ads.redexgen.X.hW, reason: case insensitive filesystem */
/* JADX INFO: loaded from: assets/audience_network.dex */
public class C1729hW {

    @Nullable
    public static Boolean A00;
    public static byte[] A01;

    public static String A00(int i2, int i8, int i9) {
        byte[] bArrCopyOfRange = Arrays.copyOfRange(A01, i2, i2 + i8);
        for (int i10 = 0; i10 < bArrCopyOfRange.length; i10++) {
            bArrCopyOfRange[i10] = (byte) ((bArrCopyOfRange[i10] ^ i9) ^ Sdk.SDKError.Reason.INVALID_METRICS_ENDPOINT_VALUE);
        }
        return new String(bArrCopyOfRange);
    }

    public static void A01() {
        A01 = new byte[]{106, 77, 69, 64, 73, 72, 12, 88, 67, 12, 75, 73, 88, 12, 65, 73, 72, 69, 77, 12, 111, 67, 72, 73, 79, 7, 42, 61, 32, 10, 55, 32, 26, 59, 38, 35, 97, 114, 121, 115, 120, 101, 57, 100, 114, 116, 58, 118, 126, 113, 101, 116, 58, 99, 101, 118, 121, 100, 113, 114, 101, 58, 101, 114, 102, 98, 114, 100, 99, 57, 97, 118, 123, 98, 114, 65, 94, 83, 82, 88, 24, 86, 65, 84};
    }

    static {
        A01();
        A00 = null;
    }

    public static boolean A02() {
        if (A00 != null) {
            return A00.booleanValue();
        }
        A00 = false;
        try {
            if (Build.VERSION.SDK_INT >= 31) {
                MediaCodec mediaCodecCreateDecoderByType = MediaCodec.createDecoderByType(A00(75, 9, 74));
                Iterator<String> it = mediaCodecCreateDecoderByType.getSupportedVendorParameters().iterator();
                while (true) {
                    if (!it.hasNext()) {
                        break;
                    }
                    String param = it.next();
                    if (param.equals(A00(36, 39, 106))) {
                        A00 = true;
                        break;
                    }
                }
                mediaCodecCreateDecoderByType.release();
            }
        } catch (IOException e) {
            String param2 = A00(25, 11, 50);
            AbstractC1660gL.A02(param2, A00(0, 25, 81), e);
        }
        return A00.booleanValue();
    }

    public static boolean A03(int i2, int i8) {
        if (i2 >= 480 && i8 >= 480 && i2 <= 3840 && i8 <= 2160) {
            return true;
        }
        return false;
    }
}
