package com.google.android.gms.internal.ads;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes4.dex */
public class zzaec implements zzaed {
    private final long zza;
    private final zzaeb zzb;

    public zzaec(long j, long j3) {
        this.zza = j;
        zzaee zzaeeVar = j3 == 0 ? zzaee.zza : new zzaee(0L, j3);
        this.zzb = new zzaeb(zzaeeVar, zzaeeVar);
    }

    @Override // com.google.android.gms.internal.ads.zzaed
    public final long zza() {
        return this.zza;
    }

    @Override // com.google.android.gms.internal.ads.zzaed
    public final boolean zzb() {
        return false;
    }

    @Override // com.google.android.gms.internal.ads.zzaed
    public final zzaeb zzc(long j) {
        return this.zzb;
    }
}
