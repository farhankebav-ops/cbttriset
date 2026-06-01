package com.google.android.gms.internal.ads;

import com.vungle.ads.internal.protos.Sdk;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes4.dex */
public final class zzhhy {
    public static byte[] zza(byte[] bArr) {
        if (bArr.length != 16) {
            throw new IllegalArgumentException("value must be a block.");
        }
        byte[] bArr2 = new byte[16];
        int i2 = 0;
        while (i2 < 16) {
            int i8 = i2 + 1;
            byte b8 = bArr[i2];
            byte b9 = (byte) ((b8 + b8) & 254);
            bArr2[i2] = b9;
            if (i2 < 15) {
                bArr2[i2] = (byte) (((bArr[i8] >> 7) & 1) | b9);
            }
            i2 = i8;
        }
        bArr2[15] = (byte) (((byte) ((bArr[0] >> 7) & Sdk.SDKError.Reason.INVALID_CONFIG_RESPONSE_VALUE)) ^ bArr2[15]);
        return bArr2;
    }
}
