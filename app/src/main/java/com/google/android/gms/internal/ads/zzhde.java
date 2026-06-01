package com.google.android.gms.internal.ads;

import java.util.Arrays;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes4.dex */
class zzhde {
    final long[] zza;
    final long[] zzb;
    final long[] zzc;

    public zzhde(long[] jArr, long[] jArr2, long[] jArr3) {
        this.zza = jArr;
        this.zzb = jArr2;
        this.zzc = jArr3;
    }

    public void zza(long[] jArr, long[] jArr2) {
        System.arraycopy(jArr2, 0, jArr, 0, 10);
    }

    public final void zzb(zzhde zzhdeVar, int i2) {
        zzhdd.zza(this.zza, zzhdeVar.zza, i2);
        zzhdd.zza(this.zzb, zzhdeVar.zzb, i2);
        zzhdd.zza(this.zzc, zzhdeVar.zzc, i2);
    }

    public zzhde() {
        this(new long[10], new long[10], new long[10]);
    }

    public zzhde(zzhde zzhdeVar) {
        this.zza = Arrays.copyOf(zzhdeVar.zza, 10);
        this.zzb = Arrays.copyOf(zzhdeVar.zzb, 10);
        this.zzc = Arrays.copyOf(zzhdeVar.zzc, 10);
    }
}
