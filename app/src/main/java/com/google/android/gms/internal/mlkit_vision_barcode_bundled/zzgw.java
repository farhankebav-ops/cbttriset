package com.google.android.gms.internal.mlkit_vision_barcode_bundled;

import sun.misc.Unsafe;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes4.dex */
final class zzgw extends zzgy {
    public zzgw(Unsafe unsafe) {
        super(unsafe);
    }

    @Override // com.google.android.gms.internal.mlkit_vision_barcode_bundled.zzgy
    public final double zza(Object obj, long j) {
        return Double.longBitsToDouble(this.zza.getLong(obj, j));
    }

    @Override // com.google.android.gms.internal.mlkit_vision_barcode_bundled.zzgy
    public final float zzb(Object obj, long j) {
        return Float.intBitsToFloat(this.zza.getInt(obj, j));
    }

    @Override // com.google.android.gms.internal.mlkit_vision_barcode_bundled.zzgy
    public final void zzc(Object obj, long j, boolean z2) {
        if (zzgz.zzb) {
            zzgz.zzD(obj, j, z2 ? (byte) 1 : (byte) 0);
        } else {
            zzgz.zzE(obj, j, z2 ? (byte) 1 : (byte) 0);
        }
    }

    @Override // com.google.android.gms.internal.mlkit_vision_barcode_bundled.zzgy
    public final void zzd(Object obj, long j, byte b8) {
        if (zzgz.zzb) {
            zzgz.zzD(obj, j, b8);
        } else {
            zzgz.zzE(obj, j, b8);
        }
    }

    @Override // com.google.android.gms.internal.mlkit_vision_barcode_bundled.zzgy
    public final void zze(Object obj, long j, double d8) {
        this.zza.putLong(obj, j, Double.doubleToLongBits(d8));
    }

    @Override // com.google.android.gms.internal.mlkit_vision_barcode_bundled.zzgy
    public final void zzf(Object obj, long j, float f4) {
        this.zza.putInt(obj, j, Float.floatToIntBits(f4));
    }

    @Override // com.google.android.gms.internal.mlkit_vision_barcode_bundled.zzgy
    public final boolean zzg(Object obj, long j) {
        return zzgz.zzb ? zzgz.zzt(obj, j) : zzgz.zzu(obj, j);
    }
}
