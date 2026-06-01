package com.google.android.gms.internal.ads;

import java.util.Objects;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes4.dex */
final class zzenx implements zzepi {
    final /* synthetic */ zzeny zza;

    public zzenx(zzeny zzenyVar) {
        Objects.requireNonNull(zzenyVar);
        this.zza = zzenyVar;
    }

    @Override // com.google.android.gms.internal.ads.zzepi
    public final void zza() {
        zzeny zzenyVar = this.zza;
        synchronized (zzenyVar) {
            zzenyVar.zzN(null);
        }
    }

    @Override // com.google.android.gms.internal.ads.zzepi
    public final /* bridge */ /* synthetic */ void zzb(Object obj) {
        zzeny zzenyVar = this.zza;
        zzcrg zzcrgVar = (zzcrg) obj;
        synchronized (zzenyVar) {
            try {
                if (zzenyVar.zzM() != null) {
                    if (zzcrgVar.zzo() != null && zzenyVar.zzM().zzo() != null) {
                        zzcrgVar.zzo().zzb(zzenyVar.zzM().zzo().zza());
                    }
                    zzenyVar.zzM().zzd();
                }
                zzenyVar.zzN(zzcrgVar);
                zzenyVar.zzM().zzj();
            } catch (Throwable th) {
                throw th;
            }
        }
    }
}
