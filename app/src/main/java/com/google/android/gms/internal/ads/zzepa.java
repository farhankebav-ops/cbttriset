package com.google.android.gms.internal.ads;

import java.util.Objects;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes4.dex */
final class zzepa implements zzepi {
    final /* synthetic */ zzepb zza;

    public zzepa(zzepb zzepbVar) {
        Objects.requireNonNull(zzepbVar);
        this.zza = zzepbVar;
    }

    @Override // com.google.android.gms.internal.ads.zzepi
    public final void zza() {
        zzepb zzepbVar = this.zza;
        synchronized (zzepbVar) {
            zzepbVar.zzM(null);
        }
    }

    @Override // com.google.android.gms.internal.ads.zzepi
    public final /* bridge */ /* synthetic */ void zzb(Object obj) {
        zzepb zzepbVar = this.zza;
        zzdhw zzdhwVar = (zzdhw) obj;
        synchronized (zzepbVar) {
            zzepbVar.zzM(zzdhwVar);
            zzepbVar.zzL().zzj();
        }
    }
}
