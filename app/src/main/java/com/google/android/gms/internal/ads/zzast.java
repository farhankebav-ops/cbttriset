package com.google.android.gms.internal.ads;

import java.util.ArrayList;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes4.dex */
public final class zzast {
    public final ArrayList zza = new ArrayList();
    public int zzb = 0;

    public zzast(int i2) {
    }

    public final int zza(long j) throws zzasr {
        long j3;
        int[] iArr = {2001100545, 2130723407, 140753313, -149863858, -2003236720, 202391198, 23353437, 1141616124, 84353895};
        int i2 = iArr[0];
        int i8 = iArr[1];
        int i9 = iArr[2];
        int i10 = iArr[3];
        int i11 = iArr[4];
        int i12 = iArr[5];
        int i13 = iArr[6];
        int i14 = iArr[7];
        int iC = com.google.android.gms.ads.internal.client.a.c((i8 & (~i2)) | i9, (i2 & i10) | i11, i12, i13);
        int i15 = i14 % 84353895;
        long[] jArr = {269441500, 1994078854, 158128940, -158130045, -1992289935, 556430036, 8936987, 2147469841, 438792350};
        long j8 = jArr[0];
        long j9 = jArr[1];
        long j10 = jArr[2];
        long j11 = jArr[3];
        long j12 = jArr[4];
        long j13 = jArr[5];
        long j14 = jArr[6];
        long j15 = jArr[7];
        long j16 = (((((~j8) & j9) | j10) + ((j8 & j11) | j12)) - j13) + j14;
        long j17 = j15 % 438792350;
        if (j >= 0) {
            j3 = ((long) (this.zzb + (iC ^ i15))) - j;
        } else {
            j3 = (j16 ^ j17) + (-j);
        }
        if (j3 < 0 || j3 >= this.zzb) {
            throw new zzasr();
        }
        return (int) j3;
    }

    public final void zzb(zzatc zzatcVar) throws zzass {
        int[] iArr = {524133589, 740889625, 408955079, 621796408, 24562149, 1207357565, 297783268, 1066077375, 937558955};
        int i2 = iArr[0];
        int i8 = iArr[1];
        int i9 = iArr[2];
        int i10 = iArr[3];
        int i11 = iArr[4];
        int i12 = iArr[5];
        int i13 = iArr[6];
        int i14 = iArr[7];
        int iC = com.google.android.gms.ads.internal.client.a.c((i8 & (~i2)) | i9, (i2 & i10) | i11, i12, i13);
        int i15 = this.zzb;
        if (i15 >= ((i14 % 937558955) ^ iC)) {
            throw new zzass();
        }
        ArrayList arrayList = this.zza;
        if (i15 == arrayList.size()) {
            arrayList.add(zzatcVar);
        } else {
            arrayList.set(this.zzb, zzatcVar);
        }
        this.zzb++;
    }

    public final zzatc zzc() throws zzasr {
        int[] iArr = {91119157, 1459677288, 586253619, -183145911, -1567288443, 919325394, 146725508, 787086305, 459541652};
        int i2 = iArr[0];
        int i8 = iArr[1];
        int i9 = iArr[2];
        int i10 = iArr[3];
        int i11 = iArr[4];
        int i12 = iArr[5];
        int i13 = iArr[6];
        int i14 = iArr[7];
        int iC = com.google.android.gms.ads.internal.client.a.c((i8 & (~i2)) | i9, (i2 & i10) | i11, i12, i13);
        int i15 = i14 % 459541652;
        int i16 = this.zzb;
        if (i16 <= 0) {
            throw new zzasr();
        }
        int i17 = i15 ^ iC;
        ArrayList arrayList = this.zza;
        zzatc zzatcVar = (zzatc) arrayList.get(i16 + i17);
        arrayList.set(this.zzb + i17, null);
        this.zzb += i17;
        return zzatcVar;
    }

    public final zzatc zzd(long j) throws zzasr {
        return (zzatc) this.zza.get(zza(j));
    }

    public final void zze(long j, zzatc zzatcVar) throws zzasr {
        this.zza.set(zza(j), zzatcVar);
    }
}
