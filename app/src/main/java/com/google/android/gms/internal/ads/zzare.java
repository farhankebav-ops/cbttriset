package com.google.android.gms.internal.ads;

import androidx.core.view.ViewCompat;
import java.nio.ByteBuffer;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes4.dex */
public final class zzare {
    public static long zza(ByteBuffer byteBuffer) {
        long j = byteBuffer.getInt();
        return j < 0 ? j + 4294967296L : j;
    }

    public static int zzb(ByteBuffer byteBuffer) {
        return (zzc(byteBuffer.get()) << 8) + zzc(byteBuffer.get());
    }

    public static int zzc(byte b8) {
        return b8 < 0 ? b8 + 256 : b8;
    }

    public static long zzd(ByteBuffer byteBuffer) {
        long jZza = zza(byteBuffer) << 32;
        if (jZza >= 0) {
            return zza(byteBuffer) + jZza;
        }
        throw new RuntimeException("I don't know how to deal with UInt64! long is not sufficient and I don't want to use BigInt");
    }

    public static double zze(ByteBuffer byteBuffer) {
        byte[] bArr = new byte[4];
        byteBuffer.get(bArr);
        int i2 = bArr[0] << 24;
        int i8 = bArr[1] << 16;
        int i9 = bArr[2] << 8;
        return ((double) ((((i2 & ViewCompat.MEASURED_STATE_MASK) | (i8 & 16711680)) | (65280 & i9)) | (bArr[3] & 255))) / 65536.0d;
    }

    public static double zzf(ByteBuffer byteBuffer) {
        byte[] bArr = new byte[4];
        byteBuffer.get(bArr);
        int i2 = bArr[0] << 24;
        int i8 = bArr[1] << 16;
        int i9 = bArr[2] << 8;
        return ((double) ((((i2 & ViewCompat.MEASURED_STATE_MASK) | (i8 & 16711680)) | (65280 & i9)) | (bArr[3] & 255))) / 1.073741824E9d;
    }
}
