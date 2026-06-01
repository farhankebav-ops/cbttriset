package com.google.android.gms.internal.ads;

import java.util.Objects;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes4.dex */
final class zzffp implements zzepi {
    final /* synthetic */ zzffr zza;

    public zzffp(zzffr zzffrVar) {
        Objects.requireNonNull(zzffrVar);
        this.zza = zzffrVar;
    }

    @Override // com.google.android.gms.internal.ads.zzepi
    public final void zza() {
        zzffr zzffrVar = this.zza;
        synchronized (zzffrVar) {
            zzffrVar.zzx(null);
        }
    }

    @Override // com.google.android.gms.internal.ads.zzepi
    public final /* bridge */ /* synthetic */ void zzb(Object obj) {
        zzffr zzffrVar = this.zza;
        zzdri zzdriVar = (zzdri) obj;
        synchronized (zzffrVar) {
            try {
                zzffrVar.zzx(zzdriVar);
                if (((Boolean) com.google.android.gms.ads.internal.client.zzbd.zzc().zzd(zzbeu.zzec)).booleanValue()) {
                    zzdriVar.zzh().zza = zzffrVar.zzv();
                }
                zzffrVar.zzw().zzj();
            } catch (Throwable th) {
                throw th;
            }
        }
    }
}
