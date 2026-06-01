package com.google.android.gms.internal.ads;

import java.util.NoSuchElementException;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes4.dex */
public final class zzdv {
    private int zza;
    private int zzb;
    private int zzc;
    private long[] zzd;
    private int zze;

    public zzdv() {
        throw null;
    }

    public final void zza(long j) {
        int i2 = this.zzc;
        long[] jArr = this.zzd;
        int length = jArr.length;
        if (i2 == length) {
            int i8 = length + length;
            if (i8 < 0) {
                throw new IllegalStateException();
            }
            long[] jArr2 = new long[i8];
            int i9 = this.zza;
            int i10 = length - i9;
            System.arraycopy(jArr, i9, jArr2, 0, i10);
            System.arraycopy(this.zzd, 0, jArr2, i10, i9);
            this.zza = 0;
            this.zzb = this.zzc - 1;
            this.zzd = jArr2;
            this.zze = jArr2.length - 1;
            jArr = jArr2;
        }
        int i11 = (this.zzb + 1) & this.zze;
        this.zzb = i11;
        jArr[i11] = j;
        this.zzc++;
    }

    public final long zzb() {
        int i2 = this.zzc;
        if (i2 == 0) {
            throw new NoSuchElementException();
        }
        long[] jArr = this.zzd;
        int i8 = this.zza;
        long j = jArr[i8];
        this.zza = this.zze & (i8 + 1);
        this.zzc = i2 - 1;
        return j;
    }

    public final long zzc() {
        if (this.zzc != 0) {
            return this.zzd[this.zza];
        }
        throw new NoSuchElementException();
    }

    public final boolean zzd() {
        return this.zzc == 0;
    }

    public final void zze() {
        this.zza = 0;
        this.zzb = -1;
        this.zzc = 0;
    }

    public zzdv(int i2) {
        int i8 = 16;
        if (Integer.bitCount(16) != 1) {
            int iHighestOneBit = Integer.highestOneBit(15);
            i8 = iHighestOneBit + iHighestOneBit;
        }
        this.zza = 0;
        this.zzb = -1;
        this.zzc = 0;
        this.zzd = new long[i8];
        this.zze = r3.length - 1;
    }
}
