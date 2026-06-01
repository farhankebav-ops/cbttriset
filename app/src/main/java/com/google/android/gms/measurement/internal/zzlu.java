package com.google.android.gms.measurement.internal;

import androidx.annotation.Nullable;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes4.dex */
public final class zzlu {

    @Nullable
    public final String zza;

    @Nullable
    public final String zzb;
    public final long zzc;
    boolean zzd;
    public final boolean zze;
    public final long zzf;

    public zzlu(@Nullable String str, @Nullable String str2, long j, boolean z2, long j3) {
        this.zza = str;
        this.zzb = str2;
        this.zzc = j;
        this.zzd = false;
        this.zze = z2;
        this.zzf = j3;
    }

    public zzlu(@Nullable String str, @Nullable String str2, long j) {
        this(str, str2, j, false, 0L);
    }
}
