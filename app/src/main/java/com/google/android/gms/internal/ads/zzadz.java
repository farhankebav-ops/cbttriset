package com.google.android.gms.internal.ads;

import com.unity3d.services.UnityAdsConstants;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes4.dex */
public final class zzadz {
    public static List zza(byte[] bArr) {
        long jZze = zze(bArr);
        ArrayList arrayList = new ArrayList(3);
        arrayList.add(bArr);
        arrayList.add(zzh(zzi(jZze)));
        arrayList.add(zzh(zzi(3840L)));
        return arrayList;
    }

    public static int zzb(ByteBuffer byteBuffer) {
        int i2;
        if ((byteBuffer.get(5) & 2) == 0) {
            i2 = 0;
        } else {
            byte b8 = byteBuffer.get(26);
            int i8 = 28;
            int i9 = 28;
            for (int i10 = 0; i10 < b8; i10++) {
                i9 += byteBuffer.get(i10 + 27);
            }
            byte b9 = byteBuffer.get(i9 + 26);
            for (int i11 = 0; i11 < b9; i11++) {
                i8 += byteBuffer.get(i9 + 27 + i11);
            }
            i2 = i9 + i8;
        }
        int i12 = byteBuffer.get(i2 + 26) + 27 + i2;
        return (int) ((zzg(byteBuffer.get(i12), byteBuffer.limit() - i12 > 1 ? byteBuffer.get(i12 + 1) : (byte) 0) * 48000) / 1000000);
    }

    public static int zzc(ByteBuffer byteBuffer) {
        return (int) ((zzg(byteBuffer.get(0), byteBuffer.limit() > 1 ? byteBuffer.get(1) : (byte) 0) * 48000) / 1000000);
    }

    public static long zzd(byte[] bArr) {
        return zzg(bArr[0], bArr.length > 1 ? bArr[1] : (byte) 0);
    }

    public static int zze(byte[] bArr) {
        return (bArr[10] & 255) | ((bArr[11] & 255) << 8);
    }

    public static boolean zzf(long j, long j3) {
        return j - j3 <= zzi(3840L) / 1000;
    }

    private static long zzg(byte b8, byte b9) {
        int i2;
        int i8 = b8 & 255;
        int i9 = b8 & 3;
        if (i9 != 0) {
            i2 = 2;
            if (i9 != 1 && i9 != 2) {
                i2 = b9 & 63;
            }
        } else {
            i2 = 1;
        }
        int i10 = i8 >> 3;
        int i11 = i10 & 3;
        return ((long) i2) * ((long) (i10 >= 16 ? UnityAdsConstants.RequestPolicy.RETRY_MAX_INTERVAL << i11 : i10 >= 12 ? 10000 << (i10 & 1) : i11 == 3 ? 60000 : 10000 << i11));
    }

    private static byte[] zzh(long j) {
        return ByteBuffer.allocate(8).order(ByteOrder.nativeOrder()).putLong(j).array();
    }

    private static long zzi(long j) {
        return (j * 1000000000) / 48000;
    }
}
