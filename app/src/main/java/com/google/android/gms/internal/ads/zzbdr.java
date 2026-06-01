package com.google.android.gms.internal.ads;

import java.io.InputStream;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes4.dex */
public final class zzbdr {
    private final InputStream zza;
    private final boolean zzb;
    private final boolean zzc;
    private final long zzd;
    private final boolean zze;

    private zzbdr(InputStream inputStream, boolean z2, boolean z7, long j, boolean z8) {
        this.zza = inputStream;
        this.zzb = z2;
        this.zzc = z7;
        this.zzd = j;
        this.zze = z8;
    }

    public static zzbdr zza(InputStream inputStream, boolean z2, boolean z7, long j, boolean z8) {
        return new zzbdr(inputStream, z2, z7, j, z8);
    }

    public final InputStream zzb() {
        return this.zza;
    }

    public final boolean zzc() {
        return this.zzb;
    }

    public final boolean zzd() {
        return this.zzc;
    }

    public final long zze() {
        return this.zzd;
    }

    public final boolean zzf() {
        return this.zze;
    }
}
