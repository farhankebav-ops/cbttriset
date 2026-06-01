package com.google.android.gms.internal.ads;

import androidx.annotation.Nullable;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes4.dex */
public final class zzfdc implements zzfdm {

    @Nullable
    private zzcxv zza;

    @Override // com.google.android.gms.internal.ads.zzfdm
    @Nullable
    /* JADX INFO: renamed from: zza, reason: merged with bridge method [inline-methods] */
    public final synchronized zzcxv zzd() {
        return this.zza;
    }

    public final synchronized j2.q zzb(zzfdn zzfdnVar, zzfdl zzfdlVar, @Nullable zzcxv zzcxvVar) {
        zzcus zzcusVarZza;
        try {
            if (zzcxvVar != null) {
                this.zza = zzcxvVar;
            } else {
                this.zza = (zzcxv) zzfdlVar.zza(zzfdnVar.zzb).zzh();
            }
            zzcusVarZza = this.zza.zza();
        } catch (Throwable th) {
            throw th;
        }
        return zzcusVarZza.zzc(zzcusVarZza.zzb());
    }

    @Override // com.google.android.gms.internal.ads.zzfdm
    public final /* bridge */ /* synthetic */ j2.q zzc(zzfdn zzfdnVar, zzfdl zzfdlVar, @Nullable Object obj) {
        return zzb(zzfdnVar, zzfdlVar, null);
    }
}
