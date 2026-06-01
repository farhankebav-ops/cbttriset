package com.google.android.gms.internal.ads;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes4.dex */
final class zzghu implements zzght {
    private final zzifb zza;
    private final zzgjd zzb;
    private final long zzc;

    public zzghu(zzifb zzifbVar, zzgjd zzgjdVar, zzfxa zzfxaVar, long j) {
        this.zza = zzifbVar;
        this.zzb = zzgjdVar;
        this.zzc = j;
    }

    @Override // com.google.android.gms.internal.ads.zzght
    public final boolean zza(zzgaa zzgaaVar) {
        if (zzgaaVar == null || zzgaaVar.equals(zzgaa.zze())) {
            this.zzb.zzb(15104);
            return true;
        }
        if (zzgaaVar.zzc() != this.zza.zzb()) {
            this.zzb.zzb(15105);
            return true;
        }
        boolean z2 = (zzgaaVar.zza().zzc() * 1000) - System.currentTimeMillis() <= this.zzc;
        if (z2) {
            this.zzb.zzb(15106);
        }
        return z2;
    }

    @Override // com.google.android.gms.internal.ads.zzght
    public final boolean zzb(zzgaa zzgaaVar) {
        if (zzgaaVar == null || zzgaaVar.equals(zzgaa.zze())) {
            this.zzb.zzb(15102);
            return false;
        }
        if (zzgaaVar.zzc() == this.zza.zzb()) {
            return true;
        }
        this.zzb.zzb(15103);
        return false;
    }
}
