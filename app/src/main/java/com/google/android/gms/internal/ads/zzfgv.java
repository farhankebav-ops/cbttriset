package com.google.android.gms.internal.ads;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes4.dex */
final class zzfgv implements zzguf {
    final /* synthetic */ zzcgy zza;
    final /* synthetic */ zzcpe zzb;
    final /* synthetic */ zzfng zzc;
    final /* synthetic */ zzefy zzd;

    public zzfgv(zzcgy zzcgyVar, zzcpe zzcpeVar, zzfng zzfngVar, zzefy zzefyVar) {
        this.zza = zzcgyVar;
        this.zzb = zzcpeVar;
        this.zzc = zzfngVar;
        this.zzd = zzefyVar;
    }

    @Override // com.google.android.gms.internal.ads.zzguf
    public final /* bridge */ /* synthetic */ void zzb(Object obj) {
        zzcpe zzcpeVar;
        String str = (String) obj;
        zzcgy zzcgyVar = this.zza;
        zzffu zzffuVarZzC = zzcgyVar.zzC();
        if (zzffuVarZzC != null && !zzffuVarZzC.zzai) {
            com.google.android.gms.ads.internal.util.client.zzv zzvVar = zzffuVarZzC.zzax;
            if (((Boolean) com.google.android.gms.ads.internal.client.zzbd.zzc().zzd(zzbeu.zzlb)).booleanValue() && (zzcpeVar = this.zzb) != null && zzcpe.zzc(str)) {
                zzcpeVar.zza(str, this.zzc, com.google.android.gms.ads.internal.client.zzbb.zze(), zzvVar);
                return;
            } else {
                this.zzc.zzb(str, zzvVar, null, null);
                return;
            }
        }
        zzffx zzffxVarZzaC = zzcgyVar.zzaC();
        if (zzffxVarZzaC == null) {
            com.google.android.gms.ads.internal.zzt.zzh().zzg(new IllegalArgumentException("Common configuration cannot be null"), "BufferingGmsgHandlers.getBufferingClickGmsgHandler");
            return;
        }
        long jCurrentTimeMillis = com.google.android.gms.ads.internal.zzt.zzk().currentTimeMillis();
        boolean zZzs = com.google.android.gms.ads.internal.zzt.zzh().zzs(zzcgyVar.getContext());
        boolean z2 = false;
        boolean z7 = ((Boolean) com.google.android.gms.ads.internal.client.zzbd.zzc().zzd(zzbeu.zzgN)).booleanValue() && zzffuVarZzC != null && zzffuVarZzC.zzS;
        if (zzffuVarZzC != null && zzffuVarZzC.zzad != null) {
            z2 = true;
        }
        this.zzd.zze(new zzega(jCurrentTimeMillis, zzffxVarZzaC.zzb, str, (zZzs || z7 || z2) ? 2 : 1));
    }

    @Override // com.google.android.gms.internal.ads.zzguf
    public final void zza(Throwable th) {
    }
}
