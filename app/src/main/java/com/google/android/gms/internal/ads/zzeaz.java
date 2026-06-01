package com.google.android.gms.internal.ads;

import java.util.Objects;
import java.util.regex.Matcher;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes4.dex */
final class zzeaz implements zzguf {
    final /* synthetic */ zzebc zza;

    public zzeaz(zzebc zzebcVar) {
        Objects.requireNonNull(zzebcVar);
        this.zza = zzebcVar;
    }

    @Override // com.google.android.gms.internal.ads.zzguf
    public final void zza(Throwable th) {
        if (((Boolean) com.google.android.gms.ads.internal.client.zzbd.zzc().zzd(zzbeu.zzgL)).booleanValue()) {
            Matcher matcher = zzebc.zzh.matcher(th.getMessage());
            if (matcher.matches()) {
                String strGroup = matcher.group(1);
                zzebc zzebcVar = this.zza;
                zzebcVar.zzc().zzc(Integer.parseInt(strGroup));
            }
        }
    }

    @Override // com.google.android.gms.internal.ads.zzguf
    public final /* bridge */ /* synthetic */ void zzb(Object obj) {
        zzfgf zzfgfVar = (zzfgf) obj;
        if (((Boolean) com.google.android.gms.ads.internal.client.zzbd.zzc().zzd(zzbeu.zzgL)).booleanValue()) {
            zzebc zzebcVar = this.zza;
            zzffx zzffxVar = zzfgfVar.zzb.zzb;
            zzebcVar.zzc().zzc(zzffxVar.zzf);
            zzebcVar.zzc().zze(zzffxVar.zzg);
        }
    }
}
