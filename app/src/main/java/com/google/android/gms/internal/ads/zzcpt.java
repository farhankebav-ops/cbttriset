package com.google.android.gms.internal.ads;

import java.util.Map;
import java.util.Objects;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes4.dex */
final class zzcpt implements zzblx {
    final /* synthetic */ zzcpw zza;

    public zzcpt(zzcpw zzcpwVar) {
        Objects.requireNonNull(zzcpwVar);
        this.zza = zzcpwVar;
    }

    @Override // com.google.android.gms.internal.ads.zzblx
    public final void zza(Object obj, Map map) {
        zzcpw zzcpwVar = this.zza;
        if (zzcpwVar.zze(map)) {
            zzcpwVar.zzf().execute(new Runnable() { // from class: com.google.android.gms.internal.ads.zzcps
                @Override // java.lang.Runnable
                public final /* synthetic */ void run() {
                    this.zza.zza.zzg().zzl();
                }
            });
        }
    }
}
