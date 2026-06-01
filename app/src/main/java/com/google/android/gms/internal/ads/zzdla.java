package com.google.android.gms.internal.ads;

import java.util.Objects;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes4.dex */
final class zzdla implements zzbau {
    final /* synthetic */ String zza;
    final /* synthetic */ zzdll zzb;

    public zzdla(zzdll zzdllVar, String str) {
        this.zza = str;
        Objects.requireNonNull(zzdllVar);
        this.zzb = zzdllVar;
    }

    @Override // com.google.android.gms.internal.ads.zzbau
    public final void zzdo(zzbat zzbatVar) {
        if (((Boolean) com.google.android.gms.ads.internal.client.zzbd.zzc().zzd(zzbeu.zzca)).booleanValue()) {
            synchronized (this) {
                try {
                    if (zzbatVar.zzj) {
                        zzdll zzdllVar = this.zzb;
                        if (zzdllVar.zzaa() != null) {
                            zzdllVar.zzab().put(this.zza, Boolean.TRUE);
                            if (zzdllVar.zzaa() == null) {
                                return;
                            } else {
                                zzdllVar.zzu(zzdllVar.zzaa().zzdJ(), zzdllVar.zzaa().zzj(), zzdllVar.zzaa().zzk(), true);
                            }
                        }
                    }
                    return;
                } catch (Throwable th) {
                    throw th;
                }
            }
        }
        if (zzbatVar.zzj) {
            zzdll zzdllVar2 = this.zzb;
            if (zzdllVar2.zzaa() != null) {
                zzdllVar2.zzab().put(this.zza, Boolean.TRUE);
                if (zzdllVar2.zzaa() == null) {
                    return;
                }
                zzdllVar2.zzu(zzdllVar2.zzaa().zzdJ(), zzdllVar2.zzaa().zzj(), zzdllVar2.zzaa().zzk(), true);
            }
        }
    }
}
