package com.google.android.gms.internal.ads;

import java.util.Objects;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes4.dex */
final class zzbpl implements zzccc {
    final /* synthetic */ zzbqa zza;
    final /* synthetic */ zzflc zzb;
    final /* synthetic */ zzbqb zzc;

    public zzbpl(zzbqb zzbqbVar, zzbqa zzbqaVar, zzflc zzflcVar) {
        this.zza = zzbqaVar;
        this.zzb = zzflcVar;
        Objects.requireNonNull(zzbqbVar);
        this.zzc = zzbqbVar;
    }

    @Override // com.google.android.gms.internal.ads.zzccc
    public final void zza() {
        com.google.android.gms.ads.internal.util.zze.zza("loadNewJavascriptEngine (failure): Trying to acquire lock");
        zzbqb zzbqbVar = this.zzc;
        synchronized (zzbqbVar.zzf()) {
            try {
                com.google.android.gms.ads.internal.util.zze.zza("loadNewJavascriptEngine (failure): Lock acquired");
                zzbqbVar.zzk(1);
                com.google.android.gms.ads.internal.util.zze.zza("Failed loading new engine. Marking new engine destroyable.");
                this.zza.zzc();
                if (((Boolean) zzbgn.zzd.zze()).booleanValue() && zzbqbVar.zzg() != null) {
                    zzflp zzflpVarZzg = zzbqbVar.zzg();
                    zzflc zzflcVar = this.zzb;
                    zzflcVar.zzk("Failed loading new engine");
                    zzflcVar.zzd(false);
                    zzflpVarZzg.zzb(zzflcVar.zzm());
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        com.google.android.gms.ads.internal.util.zze.zza("loadNewJavascriptEngine (failure): Lock released");
    }
}
