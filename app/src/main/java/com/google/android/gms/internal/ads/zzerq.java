package com.google.android.gms.internal.ads;

import android.content.Context;
import android.os.Bundle;
import java.util.Map;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes4.dex */
public final class zzerq implements zzeya {
    final Context zza;
    private final String zzb;
    private final String zzc;
    private final long zzd;
    private final zzcve zze;
    private final zzfhv zzf;
    private final zzfgn zzg;
    private final com.google.android.gms.ads.internal.util.zzg zzh = com.google.android.gms.ads.internal.zzt.zzh().zzo();
    private final zzdvc zzi;
    private final zzcvs zzj;

    public zzerq(Context context, String str, String str2, zzcve zzcveVar, zzfhv zzfhvVar, zzfgn zzfgnVar, zzdvc zzdvcVar, zzcvs zzcvsVar, long j) {
        this.zza = context;
        this.zzb = str;
        this.zzc = str2;
        this.zze = zzcveVar;
        this.zzf = zzfhvVar;
        this.zzg = zzfgnVar;
        this.zzi = zzdvcVar;
        this.zzj = zzcvsVar;
        this.zzd = j;
    }

    @Override // com.google.android.gms.internal.ads.zzeya
    public final j2.q zza() {
        Bundle bundle = new Bundle();
        zzdvc zzdvcVar = this.zzi;
        Map mapZzc = zzdvcVar.zzc();
        String str = this.zzb;
        mapZzc.put("seq_num", str);
        if (((Boolean) com.google.android.gms.ads.internal.client.zzbd.zzc().zzd(zzbeu.zzcv)).booleanValue()) {
            zzdvcVar.zzd("tsacc", String.valueOf(com.google.android.gms.ads.internal.zzt.zzk().currentTimeMillis() - this.zzd));
            com.google.android.gms.ads.internal.zzt.zzc();
            zzdvcVar.zzd("foreground", true != com.google.android.gms.ads.internal.util.zzs.zzK(this.zza) ? "1" : "0");
        }
        zzcve zzcveVar = this.zze;
        zzfgn zzfgnVar = this.zzg;
        zzcveVar.zzi(zzfgnVar.zzd);
        bundle.putAll(this.zzf.zzc());
        return zzgui.zza(new zzerr(this.zza, bundle, str, this.zzc, this.zzh, zzfgnVar.zzg, this.zzj));
    }

    @Override // com.google.android.gms.internal.ads.zzeya
    public final int zzb() {
        return 12;
    }
}
