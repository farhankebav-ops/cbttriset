package com.google.android.gms.internal.ads;

import java.util.Objects;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes4.dex */
final class zzfit implements zzguf {
    final /* synthetic */ zzfiw zza;
    final /* synthetic */ zzfiy zzb;

    public zzfit(zzfiy zzfiyVar, zzfiw zzfiwVar) {
        this.zza = zzfiwVar;
        Objects.requireNonNull(zzfiyVar);
        this.zzb = zzfiyVar;
    }

    @Override // com.google.android.gms.internal.ads.zzguf
    public final void zza(Throwable th) {
        zzfiy zzfiyVar = this.zzb;
        synchronized (zzfiyVar) {
            zzfiyVar.zzf(null);
        }
    }

    @Override // com.google.android.gms.internal.ads.zzguf
    public final /* bridge */ /* synthetic */ void zzb(Object obj) {
        zzfiy zzfiyVar = this.zzb;
        synchronized (zzfiyVar) {
            try {
                zzfiyVar.zzf(null);
                zzfiyVar.zze().addFirst(this.zza);
                if (zzfiyVar.zzg() == 1) {
                    zzfiyVar.zzd();
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }
}
