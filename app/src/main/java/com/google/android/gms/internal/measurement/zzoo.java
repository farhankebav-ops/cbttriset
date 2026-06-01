package com.google.android.gms.internal.measurement;

import sun.misc.Unsafe;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes4.dex */
abstract class zzoo {
    final Unsafe zza;

    public zzoo(Unsafe unsafe) {
        this.zza = unsafe;
    }

    public abstract void zza(Object obj, long j, byte b8);

    public abstract boolean zzb(Object obj, long j);

    public abstract void zzc(Object obj, long j, boolean z2);

    public abstract float zzd(Object obj, long j);

    public abstract void zze(Object obj, long j, float f4);

    public abstract double zzf(Object obj, long j);

    public abstract void zzg(Object obj, long j, double d8);
}
