package com.google.android.gms.internal.ads;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes4.dex */
abstract class zzafr {
    protected final zzaem zza;

    public zzafr(zzaem zzaemVar) {
        this.zza = zzaemVar;
    }

    public abstract boolean zza(zzeg zzegVar) throws zzat;

    public abstract boolean zzb(zzeg zzegVar, long j) throws zzat;

    public final boolean zzf(zzeg zzegVar, long j) throws zzat {
        return zza(zzegVar) && zzb(zzegVar, j);
    }
}
