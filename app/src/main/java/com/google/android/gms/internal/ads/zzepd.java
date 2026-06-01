package com.google.android.gms.internal.ads;

import java.util.Objects;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes4.dex */
final class zzepd implements zzepi {
    final /* synthetic */ zzepe zza;

    public zzepd(zzepe zzepeVar) {
        Objects.requireNonNull(zzepeVar);
        this.zza = zzepeVar;
    }

    @Override // com.google.android.gms.internal.ads.zzepi
    public final void zza() {
        synchronized (this.zza) {
        }
    }

    @Override // com.google.android.gms.internal.ads.zzepi
    public final /* bridge */ /* synthetic */ void zzb(Object obj) {
        zzcto zzctoVar = (zzcto) obj;
        zzepe zzepeVar = this.zza;
        synchronized (zzepeVar) {
            zzepeVar.zze(zzctoVar.zzn());
            zzctoVar.zzj();
        }
    }
}
