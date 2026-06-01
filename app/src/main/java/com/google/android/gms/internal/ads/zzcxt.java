package com.google.android.gms.internal.ads;

import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes4.dex */
public final class zzcxt implements zzifh {
    private final zzifq zza;
    private final zzifq zzb;
    private final zzifq zzc;
    private final zzifq zzd;
    private final zzifq zze;
    private final zzifq zzf;
    private final zzifq zzg;
    private final zzifq zzh;
    private final zzifq zzi;
    private final zzifq zzj;
    private final zzifq zzk;
    private final zzifq zzl;

    private zzcxt(zzifq zzifqVar, zzifq zzifqVar2, zzifq zzifqVar3, zzifq zzifqVar4, zzifq zzifqVar5, zzifq zzifqVar6, zzifq zzifqVar7, zzifq zzifqVar8, zzifq zzifqVar9, zzifq zzifqVar10, zzifq zzifqVar11, zzifq zzifqVar12, zzifq zzifqVar13) {
        this.zza = zzifqVar;
        this.zzb = zzifqVar2;
        this.zzc = zzifqVar3;
        this.zzd = zzifqVar4;
        this.zze = zzifqVar6;
        this.zzf = zzifqVar7;
        this.zzg = zzifqVar8;
        this.zzh = zzifqVar9;
        this.zzi = zzifqVar10;
        this.zzj = zzifqVar11;
        this.zzk = zzifqVar12;
        this.zzl = zzifqVar13;
    }

    public static zzcxt zzc(zzifq zzifqVar, zzifq zzifqVar2, zzifq zzifqVar3, zzifq zzifqVar4, zzifq zzifqVar5, zzifq zzifqVar6, zzifq zzifqVar7, zzifq zzifqVar8, zzifq zzifqVar9, zzifq zzifqVar10, zzifq zzifqVar11, zzifq zzifqVar12, zzifq zzifqVar13) {
        return new zzcxt(zzifqVar, zzifqVar2, zzifqVar3, zzifqVar4, zzifqVar5, zzifqVar6, zzifqVar7, zzifqVar8, zzifqVar9, zzifqVar10, zzifqVar11, zzifqVar12, zzifqVar13);
    }

    @Override // com.google.android.gms.internal.ads.zzifw, com.google.android.gms.internal.ads.zzifv
    /* JADX INFO: renamed from: zza, reason: merged with bridge method [inline-methods] */
    public final zzcxs zzb() {
        return new zzcxs((zzfks) this.zza.zzb(), ((zzckk) this.zzb).zza(), (ApplicationInfo) this.zzc.zzb(), ((zzeaq) this.zzd).zzb(), zzeth.zzc(), (PackageInfo) this.zze.zzb(), zzifg.zzc(this.zzf), ((zzcjq) this.zzg).zzb(), (String) this.zzh.zzb(), ((zzeye) this.zzi).zzb(), ((zzcyf) this.zzj).zza(), (zzdeh) this.zzk.zzb(), ((Integer) this.zzl.zzb()).intValue());
    }
}
