package com.google.android.gms.internal.ads;

import java.util.Objects;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes4.dex */
final class zzfce implements zzguf {
    final /* synthetic */ zzflm zza;
    final /* synthetic */ zzflc zzb;
    final /* synthetic */ zzcsl zzc;
    final /* synthetic */ zzfci zzd;

    public zzfce(zzfci zzfciVar, zzflm zzflmVar, zzflc zzflcVar, zzcsl zzcslVar) {
        this.zza = zzflmVar;
        this.zzb = zzflcVar;
        this.zzc = zzcslVar;
        Objects.requireNonNull(zzfciVar);
        this.zzd = zzfciVar;
    }

    @Override // com.google.android.gms.internal.ads.zzguf
    public final void zza(Throwable th) {
        zzflm zzflmVar;
        if (((Boolean) com.google.android.gms.ads.internal.client.zzbd.zzc().zzd(zzbeu.zzgq)).booleanValue()) {
            com.google.android.gms.ads.internal.util.zze.zzb("Banner ad failed to load", th);
        }
        zzfci zzfciVar = this.zzd;
        synchronized (zzfciVar) {
            try {
                zzcsl zzcslVar = this.zzc;
                com.google.android.gms.ads.internal.client.zze zzeVarZzg = zzcslVar.zzc().zzg(th);
                zzfciVar.zzs(zzeVarZzg);
                zzcslVar.zzb().zzdN(zzeVarZzg);
                zzfhk.zza(zzeVarZzg.zza, th, "BannerAdLoader.onFailure");
                if (zzfciVar.zzr()) {
                    zzfciVar.zzn();
                    zzfciVar.zzo().zzd(zzfciVar.zzq().zzc());
                }
                if (!((Boolean) zzbgn.zzc.zze()).booleanValue() || (zzflmVar = this.zza) == null) {
                    zzflp zzflpVarZzp = zzfciVar.zzp();
                    zzflc zzflcVar = this.zzb;
                    zzflcVar.zzh(zzeVarZzg);
                    zzflcVar.zzj(th);
                    zzflcVar.zzd(false);
                    zzflpVarZzp.zzb(zzflcVar.zzm());
                } else {
                    zzflmVar.zzf(zzeVarZzg);
                    zzflc zzflcVar2 = this.zzb;
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
        zzfci zzfciVar = this.zzd;
        zzcrg zzcrgVar = (zzcrg) obj;
        synchronized (zzfciVar) {
            if (zzcrgVar != null) {
                try {
                    zzcrgVar.zzt();
                } catch (Throwable th) {
                    throw th;
                }
            }
            if (zzfciVar.zzr()) {
                zzfciVar.zzc();
            }
            if (!((Boolean) zzbgn.zzc.zze()).booleanValue() || (zzflmVar = this.zza) == null) {
                zzflp zzflpVarZzp = zzfciVar.zzp();
                zzflc zzflcVar = this.zzb;
                zzflcVar.zzg(zzcrgVar.zzr().zzb);
                zzflcVar.zzi(zzcrgVar.zzn().zze());
                zzflcVar.zzd(true);
                zzflpVarZzp.zzb(zzflcVar.zzm());
            } else {
                zzflmVar.zze(zzcrgVar.zzr().zzb);
                zzflmVar.zzg(zzcrgVar.zzn().zze());
                zzflc zzflcVar2 = this.zzb;
                zzflcVar2.zzd(true);
                zzflmVar.zza(zzflcVar2);
                zzflmVar.zzh();
            }
        }
    }
}
