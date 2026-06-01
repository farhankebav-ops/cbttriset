package com.google.android.gms.internal.ads;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes4.dex */
final class zzghw implements zzght {
    private final zzgjd zza;
    private final long zzb;

    public zzghw(zzfxa zzfxaVar, zzgjd zzgjdVar, long j) {
        this.zza = zzgjdVar;
        this.zzb = j;
    }

    @Override // com.google.android.gms.internal.ads.zzght
    public final boolean zza(zzgaa zzgaaVar) {
        if (zzgaaVar == null || zzgaaVar.equals(zzgaa.zze())) {
            this.zza.zzb(20202);
            return true;
        }
        boolean z2 = zzgaaVar.zzb().zzb() - System.currentTimeMillis() <= this.zzb;
        if (z2) {
            this.zza.zzb(20203);
        }
        return z2;
    }

    @Override // com.google.android.gms.internal.ads.zzght
    public final boolean zzb(zzgaa zzgaaVar) {
        if (zzgaaVar != null && !zzgaaVar.equals(zzgaa.zze())) {
            return true;
        }
        this.zza.zzb(20204);
        return false;
    }
}
