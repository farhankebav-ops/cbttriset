package com.google.android.gms.internal.ads;

import java.util.concurrent.Callable;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes4.dex */
public final class zzesu implements zzeya {
    private final zzgus zza;
    private final zzdtd zzb;
    private final String zzc;
    private final zzfgn zzd;

    public zzesu(zzgus zzgusVar, zzdtd zzdtdVar, zzfgn zzfgnVar, String str) {
        this.zza = zzgusVar;
        this.zzb = zzdtdVar;
        this.zzd = zzfgnVar;
        this.zzc = str;
    }

    @Override // com.google.android.gms.internal.ads.zzeya
    public final j2.q zza() {
        return this.zza.zzc(new Callable() { // from class: com.google.android.gms.internal.ads.zzest
            @Override // java.util.concurrent.Callable
            public final /* synthetic */ Object call() {
                return this.zza.zzc();
            }
        });
    }

    @Override // com.google.android.gms.internal.ads.zzeya
    public final int zzb() {
        return 17;
    }

    public final /* synthetic */ zzesv zzc() {
        zzfgn zzfgnVar = this.zzd;
        zzdtd zzdtdVar = this.zzb;
        return new zzesv(zzdtdVar.zzb(zzfgnVar.zzg, this.zzc), zzdtdVar.zzc());
    }
}
