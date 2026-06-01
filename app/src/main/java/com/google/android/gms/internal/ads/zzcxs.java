package com.google.android.gms.internal.ads;

import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.os.Bundle;
import androidx.annotation.Nullable;
import com.google.android.gms.ads.internal.util.client.VersionInfoParcel;
import java.util.List;
import java.util.Objects;
import java.util.concurrent.Callable;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes4.dex */
public final class zzcxs {
    private final zzfks zza;
    private final VersionInfoParcel zzb;
    private final ApplicationInfo zzc;
    private final String zzd;
    private final List zze;
    private final PackageInfo zzf;
    private final zzifb zzg;
    private final String zzh;
    private final zzeyd zzi;
    private final com.google.android.gms.ads.internal.util.zzg zzj;
    private final zzfgn zzk;
    private final int zzl;
    private final zzdeh zzm;

    public zzcxs(zzfks zzfksVar, VersionInfoParcel versionInfoParcel, ApplicationInfo applicationInfo, String str, List list, @Nullable PackageInfo packageInfo, zzifb zzifbVar, com.google.android.gms.ads.internal.util.zzg zzgVar, String str2, zzeyd zzeydVar, zzfgn zzfgnVar, zzdeh zzdehVar, int i2) {
        this.zza = zzfksVar;
        this.zzb = versionInfoParcel;
        this.zzc = applicationInfo;
        this.zzd = str;
        this.zze = list;
        this.zzf = packageInfo;
        this.zzg = zzifbVar;
        this.zzh = str2;
        this.zzi = zzeydVar;
        this.zzj = zzgVar;
        this.zzk = zzfgnVar;
        this.zzm = zzdehVar;
        this.zzl = i2;
    }

    public final j2.q zza(Bundle bundle) {
        this.zzm.zza();
        zzfkm zzfkmVar = zzfkm.SIGNALS;
        zzfks zzfksVar = this.zza;
        Objects.requireNonNull(zzfksVar);
        return zzfkd.zza(this.zzi.zza(new zzcxq(new Bundle(), new Bundle()), bundle, this.zzl == 2), zzfkmVar, zzfksVar).zzi();
    }

    public final j2.q zzb() {
        final Bundle bundle = new Bundle();
        if (((Boolean) com.google.android.gms.ads.internal.client.zzbd.zzc().zzd(zzbeu.zzcv)).booleanValue()) {
            Bundle bundle2 = this.zzk.zzt;
            if (bundle2 != null) {
                bundle.putAll(bundle2);
            }
            bundle.putBoolean("ls", false);
        }
        final j2.q qVarZza = zza(bundle);
        return this.zza.zzb(zzfkm.REQUEST_PARCEL, qVarZza, (j2.q) this.zzg.zzb()).zza(new Callable() { // from class: com.google.android.gms.internal.ads.zzcxr
            @Override // java.util.concurrent.Callable
            public final /* synthetic */ Object call() {
                return this.zza.zzc(qVarZza, bundle);
            }
        }).zzi();
    }

    public final /* synthetic */ zzbxj zzc(j2.q qVar, Bundle bundle) {
        zzcxq zzcxqVar = (zzcxq) qVar.get();
        Bundle bundle2 = zzcxqVar.zza;
        String str = (String) ((j2.q) this.zzg.zzb()).get();
        boolean z2 = false;
        if (((Boolean) com.google.android.gms.ads.internal.client.zzbd.zzc().zzd(zzbeu.zzhA)).booleanValue() && this.zzj.zzx()) {
            z2 = true;
        }
        boolean z7 = z2;
        String str2 = this.zzh;
        PackageInfo packageInfo = this.zzf;
        List list = this.zze;
        String str3 = this.zzd;
        return new zzbxj(bundle2, this.zzb, this.zzc, str3, list, packageInfo, str, str2, null, null, z7, this.zzk.zza(), bundle, zzcxqVar.zzb, this.zzl);
    }
}
