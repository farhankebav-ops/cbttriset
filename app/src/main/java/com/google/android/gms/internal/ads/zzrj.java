package com.google.android.gms.internal.ads;

import java.math.RoundingMode;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes4.dex */
public final class zzrj implements zzqo {
    public zzrj(zzri zzriVar) {
    }

    public static int zza(int i2, int i8, int i9) {
        return zzgst.zza(((((long) i2) * ((long) i8)) * ((long) i9)) / 1000000);
    }

    public static final int zzb(int i2, int i8, int i9, int i10, int i11, int i12) {
        int i13 = 250000;
        if (i9 == 0) {
            int iZza = zza(250000, i11, i10);
            int iZza2 = zza(750000, i11, i10);
            String str = zzep.zza;
            return Math.max(iZza, Math.min(i2 * 4, iZza2));
        }
        if (i9 == 1) {
            return zzgst.zza((((long) zzc(i8)) * 50000000) / 1000000);
        }
        if (i8 == 5) {
            i13 = 500000;
        } else if (i8 == 8) {
            i13 = 1000000;
            i8 = 8;
        }
        return zzgst.zza((((long) i13) * ((long) (i12 != -1 ? zzgsm.zzb(i12, 8, RoundingMode.CEILING) : zzc(i8)))) / 1000000);
    }

    private static int zzc(int i2) {
        int iZzf = zzade.zzf(i2);
        zzgmd.zzh(iZzf != -2147483647);
        return iZzf;
    }
}
