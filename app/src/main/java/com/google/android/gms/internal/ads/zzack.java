package com.google.android.gms.internal.ads;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes4.dex */
public final class zzack {
    public static final zzack zza = new zzack(-3, -9223372036854775807L, -1);
    private final int zzb;
    private final long zzc;
    private final long zzd;

    private zzack(int i2, long j, long j3) {
        this.zzb = i2;
        this.zzc = j;
        this.zzd = j3;
    }

    public static zzack zza(long j, long j3) {
        return new zzack(-1, j, j3);
    }

    public static zzack zzb(long j, long j3) {
        return new zzack(-2, j, j3);
    }

    public static zzack zzc(long j) {
        return new zzack(0, -9223372036854775807L, j);
    }

    public final /* synthetic */ int zzd() {
        return this.zzb;
    }

    public final /* synthetic */ long zze() {
        return this.zzc;
    }

    public final /* synthetic */ long zzf() {
        return this.zzd;
    }
}
