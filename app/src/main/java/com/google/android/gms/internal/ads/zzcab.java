package com.google.android.gms.internal.ads;

import android.content.Context;
import com.google.android.gms.common.util.Clock;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes4.dex */
final class zzcab extends zzcag {
    final zzifq zza;
    final zzifq zzb;
    final zzifq zzc;
    final zzifq zzd;
    final zzifq zze;
    final zzifq zzf;
    final zzifq zzg;
    final zzifq zzh;
    private final Clock zzj;

    public zzcab(Context context, Clock clock, com.google.android.gms.ads.internal.util.zzg zzgVar, zzcaf zzcafVar) {
        this.zzj = clock;
        zzifh zzifhVarZza = zzifi.zza(context);
        this.zza = zzifhVarZza;
        zzifh zzifhVarZza2 = zzifi.zza(zzgVar);
        this.zzb = zzifhVarZza2;
        this.zzc = zzifg.zza(zzbzv.zza(zzifhVarZza, zzifhVarZza2));
        zzifh zzifhVarZza3 = zzifi.zza(clock);
        this.zzd = zzifhVarZza3;
        zzifh zzifhVarZza4 = zzifi.zza(zzcafVar);
        this.zze = zzifhVarZza4;
        zzifq zzifqVarZza = zzifg.zza(zzbzx.zza(zzifhVarZza3, zzifhVarZza2, zzifhVarZza4));
        this.zzf = zzifqVarZza;
        zzbzz zzbzzVarZzc = zzbzz.zzc(zzifhVarZza3, zzifqVarZza);
        this.zzg = zzbzzVarZzc;
        this.zzh = zzifg.zza(zzcam.zza(zzifhVarZza, zzbzzVarZzc));
    }

    @Override // com.google.android.gms.internal.ads.zzcag
    public final zzbzy zza() {
        return new zzbzy(this.zzj, (zzbzw) this.zzf.zzb());
    }
}
