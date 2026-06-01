package com.google.android.gms.internal.ads;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes4.dex */
final class zzxr implements Comparable {
    private final boolean zza;
    private final boolean zzb;

    public zzxr(zzv zzvVar, int i2) {
        this.zza = 1 == (zzvVar.zze & 1);
        this.zzb = h0.c(i2, false);
    }

    @Override // java.lang.Comparable
    /* JADX INFO: renamed from: zza, reason: merged with bridge method [inline-methods] */
    public final int compareTo(zzxr zzxrVar) {
        return zzgot.zzg().zzd(this.zzb, zzxrVar.zzb).zzd(this.zza, zzxrVar.zza).zze();
    }
}
