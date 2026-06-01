package com.google.android.gms.internal.ads;

import java.util.Objects;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes4.dex */
final class zzbpk implements zzcce {
    final /* synthetic */ zzbqa zza;
    final /* synthetic */ zzflc zzb;
    final /* synthetic */ zzbqb zzc;

    public zzbpk(zzbqb zzbqbVar, zzbqa zzbqaVar, zzflc zzflcVar) {
        this.zza = zzbqaVar;
        this.zzb = zzflcVar;
        Objects.requireNonNull(zzbqbVar);
        this.zzc = zzbqbVar;
    }

    @Override // com.google.android.gms.internal.ads.zzcce
    public final /* bridge */ /* synthetic */ void zza(Object obj) {
        com.google.android.gms.ads.internal.util.zze.zza("loadNewJavascriptEngine (success): Trying to acquire lock");
        zzbqb zzbqbVar = this.zzc;
        synchronized (zzbqbVar.zzf()) {
            try {
                com.google.android.gms.ads.internal.util.zze.zza("loadNewJavascriptEngine (success): Lock acquired");
                zzbqbVar.zzk(0);
                if (zzbqbVar.zzh() != null && this.zza != zzbqbVar.zzh()) {
                    com.google.android.gms.ads.internal.util.zze.zza("New JS engine is loaded, marking previous one as destroyable.");
                    zzbqbVar.zzh().zzc();
                }
                zzbqbVar.zzi(this.zza);
                if (((Boolean) zzbgn.zzd.zze()).booleanValue() && zzbqbVar.zzg() != null) {
                    zzflp zzflpVarZzg = zzbqbVar.zzg();
                    zzflc zzflcVar = this.zzb;
                    zzflcVar.zzd(true);
                    zzflpVarZzg.zzb(zzflcVar.zzm());
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        com.google.android.gms.ads.internal.util.zze.zza("loadNewJavascriptEngine (success): Lock released");
    }
}
