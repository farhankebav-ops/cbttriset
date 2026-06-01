package com.google.android.gms.internal.ads;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes4.dex */
public final class zzacg implements zzaed {
    private final zzacj zza;
    private final long zzb;
    private final long zzc;
    private final long zzd;
    private final long zze;
    private final long zzf;

    public zzacg(zzacj zzacjVar, long j, long j3, long j8, long j9, long j10, long j11) {
        this.zza = zzacjVar;
        this.zzb = j;
        this.zzc = j8;
        this.zzd = j9;
        this.zze = j10;
        this.zzf = j11;
    }

    @Override // com.google.android.gms.internal.ads.zzaed
    public final long zza() {
        return this.zzb;
    }

    @Override // com.google.android.gms.internal.ads.zzaed
    public final boolean zzb() {
        return true;
    }

    @Override // com.google.android.gms.internal.ads.zzaed
    public final zzaeb zzc(long j) {
        zzaee zzaeeVar = new zzaee(j, zzaci.zza(this.zza.zza(j), 0L, this.zzc, this.zzd, this.zze, this.zzf));
        return new zzaeb(zzaeeVar, zzaeeVar);
    }

    public final long zzd(long j) {
        return this.zza.zza(j);
    }

    public final /* synthetic */ long zze() {
        return this.zzc;
    }

    public final /* synthetic */ long zzf() {
        return this.zzd;
    }

    public final /* synthetic */ long zzg() {
        return this.zze;
    }

    public final /* synthetic */ long zzh() {
        return this.zzf;
    }
}
