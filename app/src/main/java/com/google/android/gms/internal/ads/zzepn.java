package com.google.android.gms.internal.ads;

import java.util.Objects;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes4.dex */
final class zzepn implements zzguf {
    final /* synthetic */ zzepi zza;
    final /* synthetic */ zzflm zzb;
    final /* synthetic */ zzflc zzc;
    final /* synthetic */ zzdjz zzd;
    final /* synthetic */ zzepq zze;

    public zzepn(zzepq zzepqVar, zzepi zzepiVar, zzflm zzflmVar, zzflc zzflcVar, zzdjz zzdjzVar) {
        this.zza = zzepiVar;
        this.zzb = zzflmVar;
        this.zzc = zzflcVar;
        this.zzd = zzdjzVar;
        Objects.requireNonNull(zzepqVar);
        this.zze = zzepqVar;
    }

    @Override // com.google.android.gms.internal.ads.zzguf
    public final void zza(Throwable th) {
        zzflm zzflmVar;
        if (((Boolean) com.google.android.gms.ads.internal.client.zzbd.zzc().zzd(zzbeu.zzgq)).booleanValue()) {
            com.google.android.gms.ads.internal.util.zze.zzb("Native ad failed to load", th);
        }
        zzdjz zzdjzVar = this.zzd;
        final com.google.android.gms.ads.internal.client.zze zzeVarZzg = zzdjzVar.zza().zzg(th);
        zzdjzVar.zzb().zzdN(zzeVarZzg);
        zzepq zzepqVar = this.zze;
        zzepqVar.zze().zzb().execute(new Runnable() { // from class: com.google.android.gms.internal.ads.zzepl
            @Override // java.lang.Runnable
            public final /* synthetic */ void run() {
                this.zza.zze.zzf().zze().zzdN(zzeVarZzg);
            }
        });
        zzfhk.zza(zzeVarZzg.zza, th, "NativeAdLoader.onFailure");
        this.zza.zza();
        if (!((Boolean) zzbgn.zzc.zze()).booleanValue() || (zzflmVar = this.zzb) == null) {
            zzflp zzflpVarZzg = zzepqVar.zzg();
            zzflc zzflcVar = this.zzc;
            zzflcVar.zzh(zzeVarZzg);
            zzflcVar.zzj(th);
            zzflcVar.zzd(false);
            zzflpVarZzg.zzb(zzflcVar.zzm());
            return;
        }
        zzflmVar.zzf(zzeVarZzg);
        zzflc zzflcVar2 = this.zzc;
        zzflcVar2.zzj(th);
        zzflcVar2.zzd(false);
        zzflmVar.zza(zzflcVar2);
        zzflmVar.zzh();
    }

    @Override // com.google.android.gms.internal.ads.zzguf
    public final /* bridge */ /* synthetic */ void zzb(Object obj) {
        zzflm zzflmVar;
        zzepq zzepqVar = this.zze;
        zzcto zzctoVar = (zzcto) obj;
        synchronized (zzepqVar) {
            if (zzctoVar != null) {
                try {
                    zzctoVar.zzt();
                } catch (Throwable th) {
                    throw th;
                }
            }
            zzctoVar.zzq().zza(zzepqVar.zzf().zzc());
            this.zza.zzb(zzctoVar);
            zzepqVar.zze().zzb().execute(new Runnable() { // from class: com.google.android.gms.internal.ads.zzepm
                @Override // java.lang.Runnable
                public final /* synthetic */ void run() {
                    this.zza.zze.zzf().zzd().zzg();
                }
            });
            if (!((Boolean) zzbgn.zzc.zze()).booleanValue() || (zzflmVar = this.zzb) == null) {
                zzflp zzflpVarZzg = zzepqVar.zzg();
                zzflc zzflcVar = this.zzc;
                zzflcVar.zzg(zzctoVar.zzr().zzb);
                zzflcVar.zzi(zzctoVar.zzn().zze());
                zzflcVar.zzd(true);
                zzflpVarZzg.zzb(zzflcVar.zzm());
            } else {
                zzflmVar.zze(zzctoVar.zzr().zzb);
                zzflmVar.zzg(zzctoVar.zzn().zze());
                zzflc zzflcVar2 = this.zzc;
                zzflcVar2.zzd(true);
                zzflmVar.zza(zzflcVar2);
                zzflmVar.zzh();
            }
        }
    }
}
