package com.google.android.gms.internal.ads;

import java.util.concurrent.Executor;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes4.dex */
public final class zzfcz implements zzfdm {
    private final zzfic zza;
    private final Executor zzb;
    private final zzguf zzc = new zzfcw(this);

    public zzfcz(zzfic zzficVar, Executor executor) {
        this.zza = zzficVar;
        this.zzb = executor;
    }

    public final j2.q zza(zzfdn zzfdnVar, zzfdl zzfdlVar, final zzcxv zzcxvVar) {
        zzfic zzficVar = this.zza;
        Executor executor = this.zzb;
        return (zzgua) zzgui.zzg((zzgua) zzgui.zzj(zzgua.zzw(new zzfdi(zzficVar, zzcxvVar, executor).zza()), new zzgtq() { // from class: com.google.android.gms.internal.ads.zzfcx
            @Override // com.google.android.gms.internal.ads.zzgtq
            public final /* synthetic */ j2.q zza(Object obj) {
                return this.zza.zzb(zzcxvVar, (zzfdg) obj);
            }
        }, executor), Exception.class, new zzfcv(this), executor);
    }

    public final /* synthetic */ j2.q zzb(zzcxv zzcxvVar, zzfdg zzfdgVar) {
        zzfic zzficVar = this.zza;
        zzfim zzfimVar = zzfdgVar.zzb;
        zzbxj zzbxjVar = zzfdgVar.zza;
        zzfil zzfilVarZza = zzficVar.zza(zzfimVar);
        if (zzfilVarZza != null && zzbxjVar != null) {
            zzgui.zzr(zzcxvVar.zza().zzf(zzbxjVar), this.zzc, this.zzb);
        }
        return zzgui.zza(new zzfcy(zzfimVar, zzbxjVar, zzfilVarZza));
    }

    @Override // com.google.android.gms.internal.ads.zzfdm
    public final /* bridge */ /* synthetic */ j2.q zzc(zzfdn zzfdnVar, zzfdl zzfdlVar, Object obj) {
        return zza(zzfdnVar, zzfdlVar, null);
    }

    @Override // com.google.android.gms.internal.ads.zzfdm
    public final /* bridge */ /* synthetic */ Object zzd() {
        return null;
    }
}
