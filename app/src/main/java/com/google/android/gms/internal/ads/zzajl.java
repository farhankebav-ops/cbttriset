package com.google.android.gms.internal.ads;

import androidx.annotation.Nullable;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes4.dex */
final class zzajl implements zzajs {
    private final zzajr zza;
    private final long zzb;
    private final long zzc;
    private final zzajw zzd;
    private int zze;
    private long zzf;
    private long zzg;
    private long zzh;
    private long zzi;
    private long zzj;
    private long zzk;
    private long zzl;

    public zzajl(zzajw zzajwVar, long j, long j3, long j8, long j9, boolean z2) {
        zzgmd.zza(j >= 0 && j3 > j);
        this.zzd = zzajwVar;
        this.zzb = j;
        this.zzc = j3;
        if (j8 == j3 - j || z2) {
            this.zzf = j9;
            this.zze = 4;
        } else {
            this.zze = 0;
        }
        this.zza = new zzajr();
    }

    /* JADX WARN: Removed duplicated region for block: B:39:0x00bb A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:40:0x00bc  */
    @Override // com.google.android.gms.internal.ads.zzajs
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final long zza(com.google.android.gms.internal.ads.zzadb r25) throws java.io.IOException {
        /*
            Method dump skipped, instruction units count: 346
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzajl.zza(com.google.android.gms.internal.ads.zzadb):long");
    }

    @Override // com.google.android.gms.internal.ads.zzajs
    public final void zzb(long j) {
        long j3 = this.zzf - 1;
        String str = zzep.zza;
        this.zzh = Math.max(0L, Math.min(j, j3));
        this.zze = 2;
        this.zzi = this.zzb;
        this.zzj = this.zzc;
        this.zzk = 0L;
        this.zzl = this.zzf;
    }

    @Override // com.google.android.gms.internal.ads.zzajs
    @Nullable
    public final /* bridge */ /* synthetic */ zzaed zzc() {
        byte[] bArr = null;
        if (this.zzf != 0) {
            return new zzajk(this, bArr);
        }
        return null;
    }

    public final /* synthetic */ long zzd() {
        return this.zzb;
    }

    public final /* synthetic */ long zze() {
        return this.zzc;
    }

    public final /* synthetic */ zzajw zzf() {
        return this.zzd;
    }

    public final /* synthetic */ long zzg() {
        return this.zzf;
    }
}
