package com.google.android.gms.ads;

import androidx.annotation.VisibleForTesting;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes3.dex */
@VisibleForTesting
public final class zzc {
    public static AdSize zza(int i2, int i8, String str) {
        return new AdSize(i2, i8, str);
    }

    public static AdSize zzb(int i2, int i8) {
        AdSize adSize = new AdSize(i2, i8);
        adSize.zzc(true);
        adSize.zzd(i8);
        return adSize;
    }

    public static AdSize zzc(int i2, int i8) {
        AdSize adSize = new AdSize(i2, i8);
        adSize.zzg(true);
        adSize.zzi(i8);
        return adSize;
    }

    public static boolean zzd(AdSize adSize) {
        return adSize.zzf();
    }

    public static int zze(AdSize adSize) {
        return adSize.zzh();
    }

    public static boolean zzf(AdSize adSize) {
        return adSize.zza();
    }

    public static boolean zzg(AdSize adSize) {
        return adSize.zzb();
    }

    public static int zzh(AdSize adSize) {
        return adSize.zze();
    }
}
