package com.google.android.gms.internal.ads;

import java.util.Objects;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes4.dex */
final class zzcbf extends com.google.android.gms.ads.internal.util.zzb {
    final /* synthetic */ zzcbj zza;

    public zzcbf(zzcbj zzcbjVar) {
        Objects.requireNonNull(zzcbjVar);
        this.zza = zzcbjVar;
    }

    @Override // com.google.android.gms.ads.internal.util.zzb
    public final void zza() {
        zzcbj zzcbjVar = this.zza;
        zzbex zzbexVar = new zzbex(zzcbjVar.zzy(), zzcbjVar.zzz().afmaVersion);
        synchronized (zzcbjVar.zzx()) {
            try {
                com.google.android.gms.ads.internal.zzt.zzm();
                zzbfa.zza(zzcbjVar.zzA(), zzbexVar);
            } catch (IllegalArgumentException e) {
                int i2 = com.google.android.gms.ads.internal.util.zze.zza;
                com.google.android.gms.ads.internal.util.client.zzo.zzj("Cannot config CSI reporter.", e);
            }
        }
    }
}
