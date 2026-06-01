package com.google.android.gms.internal.ads;

import java.util.Objects;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes4.dex */
final class zzdxk extends zzbnz {
    final /* synthetic */ Object zza;
    final /* synthetic */ String zzb;
    final /* synthetic */ long zzc;
    final /* synthetic */ zzflc zzd;
    final /* synthetic */ zzcca zze;
    final /* synthetic */ zzdxt zzf;

    public zzdxk(zzdxt zzdxtVar, Object obj, String str, long j, zzflc zzflcVar, zzcca zzccaVar) {
        this.zza = obj;
        this.zzb = str;
        this.zzc = j;
        this.zzd = zzflcVar;
        this.zze = zzccaVar;
        Objects.requireNonNull(zzdxtVar);
        this.zzf = zzdxtVar;
    }

    @Override // com.google.android.gms.internal.ads.zzboa
    public final void zze() {
        synchronized (this.zza) {
            zzdxt zzdxtVar = this.zzf;
            String str = this.zzb;
            zzdxtVar.zzm(str, true, "", (int) (com.google.android.gms.ads.internal.zzt.zzk().elapsedRealtime() - this.zzc));
            zzdxtVar.zzr().zzb(str);
            zzdxtVar.zzs().zzb(str);
            zzflp zzflpVarZzt = zzdxtVar.zzt();
            zzflc zzflcVar = this.zzd;
            zzflcVar.zzd(true);
            zzflpVarZzt.zzb(zzflcVar.zzm());
            this.zze.zzc(Boolean.TRUE);
        }
    }

    @Override // com.google.android.gms.internal.ads.zzboa
    public final void zzf(String str) {
        synchronized (this.zza) {
            zzdxt zzdxtVar = this.zzf;
            String str2 = this.zzb;
            zzdxtVar.zzm(str2, false, str, (int) (com.google.android.gms.ads.internal.zzt.zzk().elapsedRealtime() - this.zzc));
            zzdxtVar.zzr().zzc(str2, "error");
            zzdxtVar.zzs().zzc(str2, "error");
            zzflp zzflpVarZzt = zzdxtVar.zzt();
            zzflc zzflcVar = this.zzd;
            zzflcVar.zzk(str);
            zzflcVar.zzd(false);
            zzflpVarZzt.zzb(zzflcVar.zzm());
            this.zze.zzc(Boolean.FALSE);
        }
    }
}
