package com.google.android.gms.internal.mlkit_vision_barcode_bundled;

import com.ironsource.mediationsdk.logger.IronSourceError;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes4.dex */
final class zzha {
    public static /* bridge */ /* synthetic */ void zza(byte b8, byte b9, byte b10, byte b11, char[] cArr, int i2) throws zzer {
        if (!zze(b9)) {
            if ((((b9 + 112) + (b8 << 28)) >> 30) == 0 && !zze(b10) && !zze(b11)) {
                int i8 = ((b8 & 7) << 18) | ((b9 & 63) << 12) | ((b10 & 63) << 6) | (b11 & 63);
                cArr[i2] = (char) ((i8 >>> 10) + 55232);
                cArr[i2 + 1] = (char) ((i8 & IronSourceError.ERROR_RV_SHOW_CALLED_WRONG_STATE) + 56320);
                return;
            }
        }
        throw new zzer("Protocol message had invalid UTF-8.");
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x0013  */
    /* JADX WARN: Removed duplicated region for block: B:12:0x0016 A[PHI: r2
  0x0016: PHI (r2v3 byte) = (r2v2 byte), (r2v9 byte) binds: [B:9:0x0011, B:11:0x0015] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Removed duplicated region for block: B:14:0x001c  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static /* bridge */ /* synthetic */ void zzb(byte r2, byte r3, byte r4, char[] r5, int r6) throws com.google.android.gms.internal.mlkit_vision_barcode_bundled.zzer {
        /*
            boolean r0 = zze(r3)
            if (r0 != 0) goto L2c
            r0 = -96
            r1 = -32
            if (r2 != r1) goto Lf
            if (r3 < r0) goto L2c
            r2 = r1
        Lf:
            r1 = -19
            if (r2 != r1) goto L16
            if (r3 >= r0) goto L2c
            r2 = r1
        L16:
            boolean r0 = zze(r4)
            if (r0 != 0) goto L2c
            r2 = r2 & 15
            r3 = r3 & 63
            r4 = r4 & 63
            int r2 = r2 << 12
            int r3 = r3 << 6
            r2 = r2 | r3
            r2 = r2 | r4
            char r2 = (char) r2
            r5[r6] = r2
            return
        L2c:
            com.google.android.gms.internal.mlkit_vision_barcode_bundled.zzer r2 = new com.google.android.gms.internal.mlkit_vision_barcode_bundled.zzer
            java.lang.String r3 = "Protocol message had invalid UTF-8."
            r2.<init>(r3)
            throw r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.mlkit_vision_barcode_bundled.zzha.zzb(byte, byte, byte, char[], int):void");
    }

    public static /* bridge */ /* synthetic */ void zzc(byte b8, byte b9, char[] cArr, int i2) throws zzer {
        if (b8 < -62 || zze(b9)) {
            throw new zzer("Protocol message had invalid UTF-8.");
        }
        cArr[i2] = (char) (((b8 & 31) << 6) | (b9 & 63));
    }

    public static /* bridge */ /* synthetic */ boolean zzd(byte b8) {
        return b8 >= 0;
    }

    private static boolean zze(byte b8) {
        return b8 > -65;
    }
}
