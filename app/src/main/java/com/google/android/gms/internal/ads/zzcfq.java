package com.google.android.gms.internal.ads;

import androidx.annotation.VisibleForTesting;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes4.dex */
public final class zzcfq implements zzkl {
    private final zzzb zza = new zzzb(true, 65536);
    private long zzb = 15000000;
    private long zzc = 30000000;
    private long zzd = 2500000;
    private long zze = 5000000;
    private int zzf;
    private boolean zzg;

    @Override // com.google.android.gms.internal.ads.zzkl
    public final void zza(zzpc zzpcVar) {
        zzo(false);
    }

    @Override // com.google.android.gms.internal.ads.zzkl
    public final void zzb(zzkk zzkkVar, zzwv zzwvVar, zzyk[] zzykVarArr) {
        int i2;
        this.zzf = 0;
        for (zzyk zzykVar : zzykVarArr) {
            if (zzykVar != null) {
                int i8 = this.zzf;
                int i9 = zzykVar.zza().zzc;
                if (i9 == 0) {
                    i2 = 144310272;
                } else if (i9 == 1) {
                    i2 = 13107200;
                } else if (i9 != 2) {
                    i2 = 131072;
                    if (i9 != 3 && i9 != 5 && i9 != 6) {
                        throw new IllegalArgumentException();
                    }
                } else {
                    i2 = 131072000;
                }
                this.zzf = i8 + i2;
            }
        }
        this.zza.zzf(this.zzf);
    }

    @Override // com.google.android.gms.internal.ads.zzkl
    public final void zzc(zzpc zzpcVar) {
        zzo(true);
    }

    @Override // com.google.android.gms.internal.ads.zzkl
    public final void zzd(zzpc zzpcVar) {
        zzo(true);
    }

    @Override // com.google.android.gms.internal.ads.zzkl
    public final zzyv zze(zzpc zzpcVar) {
        return this.zza;
    }

    @Override // com.google.android.gms.internal.ads.zzkl
    public final long zzf(zzpc zzpcVar) {
        return 0L;
    }

    @Override // com.google.android.gms.internal.ads.zzkl
    public final boolean zzg(zzpc zzpcVar) {
        return false;
    }

    @Override // com.google.android.gms.internal.ads.zzkl
    public final boolean zzh(zzkk zzkkVar) {
        long j = zzkkVar.zze;
        boolean z2 = true;
        char c7 = j > this.zzc ? (char) 0 : j < this.zzb ? (char) 2 : (char) 1;
        int iZzg = this.zza.zzg();
        int i2 = this.zzf;
        if (c7 != 2 && (c7 != 1 || !this.zzg || iZzg >= i2)) {
            z2 = false;
        }
        this.zzg = z2;
        return z2;
    }

    @Override // com.google.android.gms.internal.ads.zzkl
    public final boolean zzi(zzkk zzkkVar) {
        long j = zzkkVar.zzg ? this.zze : this.zzd;
        return j <= 0 || zzkkVar.zze >= j;
    }

    @Override // com.google.android.gms.internal.ads.zzkl
    public final /* synthetic */ boolean zzj(zzpc zzpcVar, zzbf zzbfVar, zzuu zzuuVar, long j) {
        return e0.i(this, zzpcVar, zzbfVar, zzuuVar, j);
    }

    public final synchronized void zzk(int i2) {
        this.zzb = ((long) i2) * 1000;
    }

    public final synchronized void zzl(int i2) {
        this.zzc = ((long) i2) * 1000;
    }

    public final synchronized void zzm(int i2) {
        this.zzd = ((long) i2) * 1000;
    }

    public final synchronized void zzn(int i2) {
        this.zze = ((long) i2) * 1000;
    }

    @VisibleForTesting
    public final void zzo(boolean z2) {
        this.zzf = 0;
        this.zzg = false;
        if (z2) {
            this.zza.zze();
        }
    }
}
