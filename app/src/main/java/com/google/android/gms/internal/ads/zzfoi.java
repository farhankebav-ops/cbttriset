package com.google.android.gms.internal.ads;

import java.util.Objects;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes4.dex */
final class zzfoi implements Runnable {
    final /* synthetic */ long zza;
    final /* synthetic */ com.google.android.gms.ads.internal.client.zzea zzb;
    final /* synthetic */ zzfom zzc;

    public zzfoi(zzfom zzfomVar, long j, com.google.android.gms.ads.internal.client.zzea zzeaVar) {
        this.zza = j;
        this.zzb = zzeaVar;
        Objects.requireNonNull(zzfomVar);
        this.zzc = zzfomVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        zzfom zzfomVar = this.zzc;
        if (zzfomVar.zzA() != null) {
            zzfnv zzfnvVarZzA = zzfomVar.zzA();
            long j = this.zza;
            com.google.android.gms.ads.internal.client.zzea zzeaVar = this.zzb;
            zzfnvVarZzA.zzi(j, zzfom.zzQ(zzeaVar), zzfomVar.zzC(), zzfomVar.zze.zzd, zzfomVar.zzn(), zzfomVar.zzz());
        }
    }
}
