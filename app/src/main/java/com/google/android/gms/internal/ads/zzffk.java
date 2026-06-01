package com.google.android.gms.internal.ads;

import java.util.Objects;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes4.dex */
final class zzffk implements zzepi {
    final /* synthetic */ zzffl zza;

    public zzffk(zzffl zzfflVar) {
        Objects.requireNonNull(zzfflVar);
        this.zza = zzfflVar;
    }

    @Override // com.google.android.gms.internal.ads.zzepi
    public final void zza() {
        zzffl zzfflVar = this.zza;
        synchronized (zzfflVar) {
            zzfflVar.zzw(null);
        }
    }

    @Override // com.google.android.gms.internal.ads.zzepi
    public final /* bridge */ /* synthetic */ void zzb(Object obj) {
        zzffl zzfflVar = this.zza;
        zzdri zzdriVar = (zzdri) obj;
        synchronized (zzfflVar) {
            try {
                zzfflVar.zzw(zzdriVar);
                if (((Boolean) com.google.android.gms.ads.internal.client.zzbd.zzc().zzd(zzbeu.zzec)).booleanValue()) {
                    zzdriVar.zzh().zza = zzfflVar.zzu();
                }
                zzfflVar.zzv().zzj();
            } catch (Throwable th) {
                throw th;
            }
        }
    }
}
