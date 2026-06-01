package com.google.android.gms.internal.ads;

import java.util.Objects;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes4.dex */
final class zzgvf extends zzgup {
    final /* synthetic */ zzgvh zza;
    private final zzgtp zzb;

    public zzgvf(zzgvh zzgvhVar, zzgtp zzgtpVar) {
        Objects.requireNonNull(zzgvhVar);
        this.zza = zzgvhVar;
        this.zzb = zzgtpVar;
    }

    @Override // com.google.android.gms.internal.ads.zzgup
    public final /* bridge */ /* synthetic */ Object zza() throws Exception {
        zzgtp zzgtpVar = this.zzb;
        j2.q qVarZza = zzgtpVar.zza();
        zzgmd.zzl(qVarZza, "AsyncCallable.call returned null instead of a Future. Did you mean to return immediateFuture(null)? %s", zzgtpVar);
        return qVarZza;
    }

    @Override // com.google.android.gms.internal.ads.zzgup
    public final String zzc() {
        return this.zzb.toString();
    }

    @Override // com.google.android.gms.internal.ads.zzgup
    public final boolean zzd() {
        return this.zza.isDone();
    }

    @Override // com.google.android.gms.internal.ads.zzgup
    public final /* synthetic */ void zzf(Object obj) {
        this.zza.zzk((j2.q) obj);
    }

    @Override // com.google.android.gms.internal.ads.zzgup
    public final void zzg(Throwable th) {
        this.zza.zzb(th);
    }
}
