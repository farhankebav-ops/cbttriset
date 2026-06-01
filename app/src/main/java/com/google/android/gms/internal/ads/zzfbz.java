package com.google.android.gms.internal.ads;

import java.util.Objects;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes4.dex */
final class zzfbz implements zzepi {
    final /* synthetic */ zzfcc zza;

    public zzfbz(zzfcc zzfccVar) {
        Objects.requireNonNull(zzfccVar);
        this.zza = zzfccVar;
    }

    @Override // com.google.android.gms.internal.ads.zzepi
    public final void zza() {
        zzfcc zzfccVar = this.zza;
        synchronized (zzfccVar) {
            zzfccVar.zza = null;
        }
    }

    @Override // com.google.android.gms.internal.ads.zzepi
    public final /* bridge */ /* synthetic */ void zzb(Object obj) {
        zzcra zzcraVar = (zzcra) obj;
        zzfcc zzfccVar = this.zza;
        synchronized (zzfccVar) {
            try {
                zzcra zzcraVar2 = zzfccVar.zza;
                if (zzcraVar2 != null) {
                    zzcraVar2.zzd();
                }
                zzfccVar.zza = zzcraVar;
                zzcraVar.zza(zzfccVar);
                zzfccVar.zzN().zzs(new zzcrb(zzcraVar, zzfccVar, zzfccVar.zzN(), zzfccVar.zzO()));
                zzcraVar.zzj();
            } catch (Throwable th) {
                throw th;
            }
        }
    }
}
