package com.google.android.gms.internal.ads;

import androidx.annotation.Nullable;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes4.dex */
public final class zzfdd implements zzfdm {
    private final zzfdm zza;

    @Nullable
    private zzcxv zzb;

    public zzfdd(zzfdm zzfdmVar) {
        this.zza = zzfdmVar;
    }

    @Override // com.google.android.gms.internal.ads.zzfdm
    @Nullable
    /* JADX INFO: renamed from: zza, reason: merged with bridge method [inline-methods] */
    public final synchronized zzcxv zzd() {
        return this.zzb;
    }

    public final synchronized j2.q zzb(zzfdn zzfdnVar, zzfdl zzfdlVar, @Nullable zzcxv zzcxvVar) {
        zzbxj zzbxjVar;
        this.zzb = zzcxvVar;
        if (zzcxvVar == null || (zzbxjVar = zzfdnVar.zza) == null) {
            return ((zzfdc) this.zza).zzb(zzfdnVar, zzfdlVar, zzcxvVar);
        }
        zzcus zzcusVarZza = zzcxvVar.zza();
        return zzcusVarZza.zzc(zzcusVarZza.zza(zzgui.zza(zzbxjVar)));
    }

    @Override // com.google.android.gms.internal.ads.zzfdm
    public final /* bridge */ /* synthetic */ j2.q zzc(zzfdn zzfdnVar, zzfdl zzfdlVar, @Nullable Object obj) {
        return zzb(zzfdnVar, zzfdlVar, null);
    }
}
