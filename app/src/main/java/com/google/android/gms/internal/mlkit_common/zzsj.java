package com.google.android.gms.internal.mlkit_common;

import com.google.mlkit.common.sdkinternal.ModelType;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes4.dex */
public abstract class zzsj {
    public static zzsi zzh() {
        zzrv zzrvVar = new zzrv();
        zzrvVar.zzg("NA");
        zzrvVar.zzf(false);
        zzrvVar.zze(false);
        zzrvVar.zzd(ModelType.UNKNOWN);
        zzrvVar.zzb(zzmu.NO_ERROR);
        zzrvVar.zza(zzna.UNKNOWN_STATUS);
        zzrvVar.zzc(0);
        return zzrvVar;
    }

    public abstract int zza();

    public abstract ModelType zzb();

    public abstract zzmu zzc();

    public abstract zzna zzd();

    public abstract String zze();

    public abstract boolean zzf();

    public abstract boolean zzg();
}
