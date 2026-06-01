package com.google.android.gms.internal.ads;

import java.util.Arrays;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes4.dex */
public final class zzdu {
    private int zza;
    private long[] zzb;

    public zzdu() {
        this(32);
    }

    public final void zza(long j) {
        int i2 = this.zza;
        long[] jArr = this.zzb;
        if (i2 == jArr.length) {
            this.zzb = Arrays.copyOf(jArr, i2 + i2);
        }
        long[] jArr2 = this.zzb;
        int i8 = this.zza;
        this.zza = i8 + 1;
        jArr2[i8] = 0;
    }

    public final void zzb(long[] jArr) {
        int i2 = this.zza;
        int length = jArr.length;
        int i8 = i2 + length;
        long[] jArr2 = this.zzb;
        int length2 = jArr2.length;
        if (i8 > length2) {
            this.zzb = Arrays.copyOf(jArr2, Math.max(length2 + length2, i8));
        }
        System.arraycopy(jArr, 0, this.zzb, this.zza, length);
        this.zza = i8;
    }

    public final long zzc(int i2) {
        if (i2 >= 0 && i2 < this.zza) {
            return this.zzb[i2];
        }
        int i8 = this.zza;
        throw new IndexOutOfBoundsException(a1.a.f(i2, i8, "Invalid index ", ", size is ", new StringBuilder(String.valueOf(i2).length() + 24 + String.valueOf(i8).length())));
    }

    public final int zzd() {
        return this.zza;
    }

    public zzdu(int i2) {
        this.zzb = new long[i2];
    }
}
