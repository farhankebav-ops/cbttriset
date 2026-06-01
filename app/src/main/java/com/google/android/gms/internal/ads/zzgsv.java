package com.google.android.gms.internal.ads;

import java.util.Arrays;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes4.dex */
final class zzgsv {
    private static final byte[] zza;

    static {
        byte[] bArr = new byte[128];
        Arrays.fill(bArr, (byte) -1);
        for (int i2 = 0; i2 < 10; i2++) {
            bArr[i2 + 48] = (byte) i2;
        }
        for (int i8 = 0; i8 < 26; i8++) {
            byte b8 = (byte) (i8 + 10);
            bArr[i8 + 65] = b8;
            bArr[i8 + 97] = b8;
        }
        zza = bArr;
    }

    public static int zza(char c7) {
        if (c7 < 128) {
            return zza[c7];
        }
        return -1;
    }
}
