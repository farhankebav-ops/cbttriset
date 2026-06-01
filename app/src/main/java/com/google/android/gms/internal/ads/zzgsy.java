package com.google.android.gms.internal.ads;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes4.dex */
final class zzgsy extends zzgta {
    public zzgsy(j2.q qVar, Class cls, zzgtq zzgtqVar) {
        super(qVar, cls, zzgtqVar);
    }

    @Override // com.google.android.gms.internal.ads.zzgta
    public final /* synthetic */ void zze(Object obj) {
        zzk((j2.q) obj);
    }

    @Override // com.google.android.gms.internal.ads.zzgta
    public final /* bridge */ /* synthetic */ Object zzf(Object obj, Throwable th) throws Exception {
        zzgtq zzgtqVar = (zzgtq) obj;
        j2.q qVarZza = zzgtqVar.zza(th);
        zzgmd.zzl(qVarZza, "AsyncFunction.apply returned null instead of a Future. Did you mean to return immediateFuture(null)? %s", zzgtqVar);
        return qVarZza;
    }
}
