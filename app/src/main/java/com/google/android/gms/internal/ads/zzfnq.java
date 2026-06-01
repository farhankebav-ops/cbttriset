package com.google.android.gms.internal.ads;

import com.google.android.gms.common.internal.Preconditions;
import java.util.Random;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes4.dex */
public final class zzfnq {
    private final long zza;
    private final long zzb;
    private long zze;
    private long zzd = 5;
    private final Random zzf = new Random();
    private long zzc = 0;

    public zzfnq(long j, double d8, long j3, double d9) {
        this.zza = j;
        this.zzb = j3;
        zza();
    }

    public final void zza() {
        this.zze = this.zza;
        this.zzc = 0L;
    }

    public final long zzb() {
        double d8 = this.zze;
        double d9 = 0.2d * d8;
        long j = (long) (d8 + d9);
        return ((long) (d8 - d9)) + ((long) (this.zzf.nextDouble() * ((j - r0) + 1)));
    }

    public final void zzc() {
        double d8 = this.zze;
        this.zze = Math.min((long) (d8 + d8), this.zzb);
        this.zzc++;
    }

    public final boolean zzd() {
        zzbel zzbelVar = zzbeu.zzG;
        return ((Integer) com.google.android.gms.ads.internal.client.zzbd.zzc().zzd(zzbelVar)).intValue() >= 0 && this.zzc > Math.max(this.zzd, (long) ((Integer) com.google.android.gms.ads.internal.client.zzbd.zzc().zzd(zzbelVar)).intValue()) && this.zze >= this.zzb;
    }

    public final synchronized void zze(int i2) {
        Preconditions.checkArgument(i2 > 0);
        this.zzd = i2;
    }
}
