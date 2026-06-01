package com.google.android.gms.internal.ads;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.Callable;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes4.dex */
public final class zzeqc implements zzeya {
    private final zzgus zza;
    private final zzfgn zzb;
    private final int zzc;

    public zzeqc(zzgus zzgusVar, zzfgn zzfgnVar, zzfhd zzfhdVar, int i2) {
        this.zza = zzgusVar;
        this.zzb = zzfgnVar;
        this.zzc = i2;
    }

    @Override // com.google.android.gms.internal.ads.zzeya
    public final j2.q zza() {
        return this.zza.zzc(new Callable() { // from class: com.google.android.gms.internal.ads.zzeqb
            @Override // java.util.concurrent.Callable
            public final /* synthetic */ Object call() {
                return this.zza.zzc();
            }
        });
    }

    @Override // com.google.android.gms.internal.ads.zzeya
    public final int zzb() {
        return 5;
    }

    public final /* synthetic */ zzeqd zzc() {
        List listAsList;
        String strZza = null;
        if (((Boolean) com.google.android.gms.ads.internal.client.zzbd.zzc().zzd(zzbeu.zzhB)).booleanValue()) {
            zzfgn zzfgnVar = this.zzb;
            if (this.zzc != 2) {
                String strZzc = com.google.android.gms.ads.nonagon.signalgeneration.zzaa.zzc(zzfgnVar.zzd);
                if (((Boolean) com.google.android.gms.ads.internal.client.zzbd.zzc().zzd(zzbeu.zzhD)).booleanValue()) {
                    listAsList = Arrays.asList(((String) com.google.android.gms.ads.internal.client.zzbd.zzc().zzd(zzbeu.zzhE)).split(","));
                } else {
                    listAsList = Arrays.asList(((String) com.google.android.gms.ads.internal.client.zzbd.zzc().zzd(zzbeu.zzhC)).split(","));
                }
                if (listAsList.contains(com.google.android.gms.ads.nonagon.signalgeneration.zzaa.zzb(strZzc))) {
                    strZza = zzfhd.zza();
                }
            }
        }
        return new zzeqd(strZza);
    }
}
