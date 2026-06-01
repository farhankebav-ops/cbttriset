package com.google.android.gms.internal.ads;

import java.util.Objects;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes4.dex */
final class zzeke implements zzguf {
    final /* synthetic */ zzffu zza;
    final /* synthetic */ zzekf zzb;

    public zzeke(zzekf zzekfVar, zzffu zzffuVar) {
        this.zza = zzffuVar;
        Objects.requireNonNull(zzekfVar);
        this.zzb = zzekfVar;
    }

    @Override // com.google.android.gms.internal.ads.zzguf
    public final void zza(Throwable th) {
        zzekf zzekfVar = this.zzb;
        synchronized (zzekfVar) {
            try {
                zzekg zzekgVarZzc = zzekfVar.zzc();
                zzffu zzffuVar = this.zza;
                zzekgVarZzc.zzc(th, zzffuVar);
                zzffu zzffuVarZza = zzekfVar.zzc().zza();
                if (zzffuVar.zzav) {
                    while (zzffuVarZza != null) {
                        zzekfVar.zzb(zzffuVarZza);
                        zzffuVarZza = zzekfVar.zzc().zza();
                    }
                } else if (zzffuVarZza != null) {
                    zzekfVar.zzb(zzffuVarZza);
                }
            } catch (Throwable th2) {
                throw th2;
            }
        }
    }

    @Override // com.google.android.gms.internal.ads.zzguf
    public final /* bridge */ /* synthetic */ void zzb(Object obj) {
        zzekf zzekfVar = this.zzb;
        zzekw zzekwVar = (zzekw) obj;
        synchronized (zzekfVar) {
            try {
                zzekfVar.zzc().zzb(zzekwVar, this.zza);
                zzffu zzffuVarZza = zzekfVar.zzc().zza();
                if (zzffuVarZza != null) {
                    zzekfVar.zzb(zzffuVarZza);
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }
}
