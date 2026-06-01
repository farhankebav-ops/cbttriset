package com.google.android.gms.internal.ads;

import androidx.annotation.VisibleForTesting;
import java.util.PriorityQueue;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes4.dex */
public final class zzbcd {
    public static void zza(String[] strArr, int i2, int i8, PriorityQueue priorityQueue) {
        int length = strArr.length;
        if (length < 6) {
            zzb(i2, zze(strArr, 0, length), zzc(strArr, 0, length), length, priorityQueue);
            return;
        }
        long jZze = zze(strArr, 0, 6);
        zzb(i2, jZze, zzc(strArr, 0, 6), 6, priorityQueue);
        int i9 = 1;
        while (true) {
            int length2 = strArr.length;
            if (i9 >= length2 - 5) {
                return;
            }
            long jZza = zzbca.zza(strArr[i9 - 1]);
            long jZza2 = zzbca.zza(strArr[i9 + 5]);
            String strZzc = zzc(strArr, i9, 6);
            jZze = (((jZza2 + 2147483647L) % 1073807359) + (((((jZze + 1073807359) - ((((jZza + 2147483647L) % 1073807359) * zzd(16785407L, 5)) % 1073807359)) % 1073807359) * 16785407) % 1073807359)) % 1073807359;
            zzb(i2, jZze, strZzc, length2, priorityQueue);
            i9++;
        }
    }

    @VisibleForTesting
    public static void zzb(int i2, long j, String str, int i8, PriorityQueue priorityQueue) {
        zzbcc zzbccVar = new zzbcc(j, str, i8);
        if ((priorityQueue.size() != i2 || (((zzbcc) priorityQueue.peek()).zzc <= zzbccVar.zzc && ((zzbcc) priorityQueue.peek()).zza <= zzbccVar.zza)) && !priorityQueue.contains(zzbccVar)) {
            priorityQueue.add(zzbccVar);
            if (priorityQueue.size() > i2) {
                priorityQueue.poll();
            }
        }
    }

    @VisibleForTesting
    public static String zzc(String[] strArr, int i2, int i8) {
        int i9 = i8 + i2;
        if (strArr.length < i9) {
            int i10 = com.google.android.gms.ads.internal.util.zze.zza;
            com.google.android.gms.ads.internal.util.client.zzo.zzf("Unable to construct shingle");
            return "";
        }
        StringBuilder sb = new StringBuilder();
        while (true) {
            int i11 = i9 - 1;
            if (i2 >= i11) {
                sb.append(strArr[i11]);
                return sb.toString();
            }
            sb.append(strArr[i2]);
            sb.append(' ');
            i2++;
        }
    }

    @VisibleForTesting
    public static long zzd(long j, int i2) {
        if (i2 == 1) {
            return j;
        }
        int i8 = i2 >> 1;
        long j3 = (j * j) % 1073807359;
        return (i2 & 1) == 0 ? zzd(j3, i8) % 1073807359 : ((zzd(j3, i8) % 1073807359) * j) % 1073807359;
    }

    private static long zze(String[] strArr, int i2, int i8) {
        long jZza = (((long) zzbca.zza(strArr[0])) + 2147483647L) % 1073807359;
        for (int i9 = 1; i9 < i8; i9++) {
            jZza = (((((long) zzbca.zza(strArr[i9])) + 2147483647L) % 1073807359) + ((jZza * 16785407) % 1073807359)) % 1073807359;
        }
        return jZza;
    }
}
