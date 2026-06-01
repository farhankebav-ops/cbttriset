package com.google.android.gms.internal.ads;

import java.util.Objects;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes4.dex */
final class zzfdw implements zzguf {
    final /* synthetic */ zzepi zza;
    final /* synthetic */ zzflm zzb;
    final /* synthetic */ zzflc zzc;
    final /* synthetic */ zzdjd zzd;
    final /* synthetic */ zzfdy zze;

    public zzfdw(zzfdy zzfdyVar, zzepi zzepiVar, zzflm zzflmVar, zzflc zzflcVar, zzdjd zzdjdVar) {
        this.zza = zzepiVar;
        this.zzb = zzflmVar;
        this.zzc = zzflcVar;
        this.zzd = zzdjdVar;
        Objects.requireNonNull(zzfdyVar);
        this.zze = zzfdyVar;
    }

    @Override // com.google.android.gms.internal.ads.zzguf
    public final void zza(Throwable th) {
        zzflm zzflmVar;
        if (((Boolean) com.google.android.gms.ads.internal.client.zzbd.zzc().zzd(zzbeu.zzgq)).booleanValue()) {
            com.google.android.gms.ads.internal.util.zze.zzb("Interstitial ad failed to load", th);
        }
        zzdjd zzdjdVar = this.zzd;
        final com.google.android.gms.ads.internal.client.zze zzeVarZzg = zzdjdVar.zzb().zzg(th);
        zzfdy zzfdyVar = this.zze;
        synchronized (zzfdyVar) {
            try {
                zzfdyVar.zzi(null);
                zzdjdVar.zza().zzdN(zzeVarZzg);
                if (((Boolean) com.google.android.gms.ads.internal.client.zzbd.zzc().zzd(zzbeu.zzjb)).booleanValue()) {
                    zzfdyVar.zze().execute(new Runnable() { // from class: com.google.android.gms.internal.ads.zzfdt
                        @Override // java.lang.Runnable
                        public final /* synthetic */ void run() {
                            this.zza.zze.zzf().zzdN(zzeVarZzg);
                        }
                    });
                    zzfdyVar.zze().execute(new Runnable() { // from class: com.google.android.gms.internal.ads.zzfdu
                        @Override // java.lang.Runnable
                        public final /* synthetic */ void run() {
                            this.zza.zze.zzg().zzdN(zzeVarZzg);
                        }
                    });
                }
                zzfhk.zza(zzeVarZzg.zza, th, "InterstitialAdLoader.onFailure");
                this.zza.zza();
                if (!((Boolean) zzbgn.zzc.zze()).booleanValue() || (zzflmVar = this.zzb) == null) {
                    zzflp zzflpVarZzh = zzfdyVar.zzh();
                    zzflc zzflcVar = this.zzc;
                    zzflcVar.zzh(zzeVarZzg);
                    zzflcVar.zzj(th);
                    zzflcVar.zzd(false);
                    zzflpVarZzh.zzb(zzflcVar.zzm());
                } else {
                    zzflmVar.zzf(zzeVarZzg);
                    zzflc zzflcVar2 = this.zzc;
                    zzflcVar2.zzj(th);
                    zzflcVar2.zzd(false);
                    zzflmVar.zza(zzflcVar2);
                    zzflmVar.zzh();
                }
            } catch (Throwable th2) {
                throw th2;
            }
        }
    }

    @Override // com.google.android.gms.internal.ads.zzguf
    public final /* bridge */ /* synthetic */ void zzb(Object obj) {
        zzflm zzflmVar;
        zzfdy zzfdyVar = this.zze;
        zzdhw zzdhwVar = (zzdhw) obj;
        synchronized (zzfdyVar) {
            if (zzdhwVar != null) {
                try {
                    zzdhwVar.zzt();
                } catch (Throwable th) {
                    throw th;
                }
            }
            zzfdyVar.zzi(null);
            zzbel zzbelVar = zzbeu.zzjb;
            if (((Boolean) com.google.android.gms.ads.internal.client.zzbd.zzc().zzd(zzbelVar)).booleanValue()) {
                zzdce zzdceVarZzq = zzdhwVar.zzq();
                zzdceVarZzq.zza(zzfdyVar.zzf());
                zzdceVarZzq.zzd(zzfdyVar.zzg());
            }
            this.zza.zzb(zzdhwVar);
            if (((Boolean) com.google.android.gms.ads.internal.client.zzbd.zzc().zzd(zzbelVar)).booleanValue()) {
                zzfdyVar.zze().execute(new Runnable() { // from class: com.google.android.gms.internal.ads.zzfdv
                    @Override // java.lang.Runnable
                    public final /* synthetic */ void run() {
                        this.zza.zze.zzf().zzg();
                    }
                });
                zzfdyVar.zze().execute(new Runnable() { // from class: com.google.android.gms.internal.ads.zzfds
                    @Override // java.lang.Runnable
                    public final /* synthetic */ void run() {
                        this.zza.zze.zzg().zzg();
                    }
                });
            }
            if (!((Boolean) zzbgn.zzc.zze()).booleanValue() || (zzflmVar = this.zzb) == null) {
                zzflp zzflpVarZzh = zzfdyVar.zzh();
                zzflc zzflcVar = this.zzc;
                zzflcVar.zzg(zzdhwVar.zzr().zzb);
                zzflcVar.zzi(zzdhwVar.zzn().zze());
                zzflcVar.zzd(true);
                zzflpVarZzh.zzb(zzflcVar.zzm());
            } else {
                zzflmVar.zze(zzdhwVar.zzr().zzb);
                zzflmVar.zzg(zzdhwVar.zzn().zze());
                zzflc zzflcVar2 = this.zzc;
                zzflcVar2.zzd(true);
                zzflmVar.zza(zzflcVar2);
                zzflmVar.zzh();
            }
        }
    }
}
