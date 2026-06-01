package com.google.android.gms.internal.ads;

import libcore.io.Memory;
import sun.misc.Unsafe;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes4.dex */
final class zzhzh extends zzhzi {
    public zzhzh(Unsafe unsafe) {
        super(unsafe);
    }

    @Override // com.google.android.gms.internal.ads.zzhzi
    public final void zza(Object obj, long j, byte b8) {
        if (zzhzj.zzb) {
            zzhzj.zzG(obj, j, b8);
        } else {
            zzhzj.zzH(obj, j, b8);
        }
    }

    @Override // com.google.android.gms.internal.ads.zzhzi
    public final boolean zzb(Object obj, long j) {
        return zzhzj.zzb ? zzhzj.zzx(obj, j) : zzhzj.zzy(obj, j);
    }

    /* JADX WARN: Failed to inline method: com.google.android.gms.internal.ads.zzhzj.zzA(java.lang.Object, long, boolean):void */
    /* JADX WARN: Failed to inline method: com.google.android.gms.internal.ads.zzhzj.zzz(java.lang.Object, long, boolean):void */
    /* JADX WARN: Unknown register number '(r5v0 'z2' boolean)' in method call: com.google.android.gms.internal.ads.zzhzj.zzA(java.lang.Object, long, boolean):void */
    /* JADX WARN: Unknown register number '(r5v0 'z2' boolean)' in method call: com.google.android.gms.internal.ads.zzhzj.zzz(java.lang.Object, long, boolean):void */
    @Override // com.google.android.gms.internal.ads.zzhzi
    public final void zzc(Object obj, long j, boolean z2) {
        if (zzhzj.zzb) {
            zzhzj.zzz(obj, j, z2);
        } else {
            zzhzj.zzA(obj, j, z2);
        }
    }

    @Override // com.google.android.gms.internal.ads.zzhzi
    public final float zzd(Object obj, long j) {
        return Float.intBitsToFloat(this.zza.getInt(obj, j));
    }

    @Override // com.google.android.gms.internal.ads.zzhzi
    public final void zze(Object obj, long j, float f4) {
        this.zza.putInt(obj, j, Float.floatToIntBits(f4));
    }

    @Override // com.google.android.gms.internal.ads.zzhzi
    public final double zzf(Object obj, long j) {
        return Double.longBitsToDouble(this.zza.getLong(obj, j));
    }

    @Override // com.google.android.gms.internal.ads.zzhzi
    public final void zzg(Object obj, long j, double d8) {
        this.zza.putLong(obj, j, Double.doubleToLongBits(d8));
    }

    @Override // com.google.android.gms.internal.ads.zzhzi
    public final byte zzh(long j) {
        return Memory.peekByte(j);
    }

    @Override // com.google.android.gms.internal.ads.zzhzi
    public final void zzi(long j, byte[] bArr, long j3, long j8) {
        Memory.peekByteArray(j, bArr, (int) j3, (int) j8);
    }
}
