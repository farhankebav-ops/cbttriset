package com.google.android.gms.internal.measurement;

import sun.misc.Unsafe;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes4.dex */
final class zzom extends zzoo {
    public zzom(Unsafe unsafe) {
        super(unsafe);
    }

    @Override // com.google.android.gms.internal.measurement.zzoo
    public final void zza(Object obj, long j, byte b8) {
        if (zzop.zzb) {
            zzop.zzD(obj, j, b8);
        } else {
            zzop.zzE(obj, j, b8);
        }
    }

    @Override // com.google.android.gms.internal.measurement.zzoo
    public final boolean zzb(Object obj, long j) {
        return zzop.zzb ? zzop.zzu(obj, j) : zzop.zzv(obj, j);
    }

    @Override // com.google.android.gms.internal.measurement.zzoo
    public final void zzc(Object obj, long j, boolean z2) {
        if (zzop.zzb) {
            zzop.zzD(obj, j, z2 ? (byte) 1 : (byte) 0);
        } else {
            zzop.zzE(obj, j, z2 ? (byte) 1 : (byte) 0);
        }
    }

    @Override // com.google.android.gms.internal.measurement.zzoo
    public final float zzd(Object obj, long j) {
        return Float.intBitsToFloat(this.zza.getInt(obj, j));
    }

    @Override // com.google.android.gms.internal.measurement.zzoo
    public final void zze(Object obj, long j, float f4) {
        this.zza.putInt(obj, j, Float.floatToIntBits(f4));
    }

    @Override // com.google.android.gms.internal.measurement.zzoo
    public final double zzf(Object obj, long j) {
        return Double.longBitsToDouble(this.zza.getLong(obj, j));
    }

    @Override // com.google.android.gms.internal.measurement.zzoo
    public final void zzg(Object obj, long j, double d8) {
        this.zza.putLong(obj, j, Double.doubleToLongBits(d8));
    }
}
