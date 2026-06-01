package com.google.android.gms.internal.ads;

import java.io.IOException;
import java.util.Arrays;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes4.dex */
final class zzafb {
    private final zzafa zza;
    private final zzaem zzb;
    private final int zzc;
    private final int zzd;
    private final long zze;
    private int zzf;
    private int zzg;
    private int zzh;
    private int zzi;
    private int zzj;
    private int zzk;
    private long zzl;
    private long[] zzm;
    private int[] zzn;

    public zzafb(int i2, zzafa zzafaVar, zzaem zzaemVar) {
        this.zza = zzafaVar;
        int iZzc = zzafaVar.zzc();
        boolean z2 = true;
        if (iZzc != 1) {
            if (iZzc == 2) {
                iZzc = 2;
            } else {
                z2 = false;
            }
        }
        zzgmd.zza(z2);
        this.zzc = zzj(i2, iZzc == 2 ? 1667497984 : 1651965952);
        this.zze = zzafaVar.zzd();
        this.zzb = zzaemVar;
        this.zzd = iZzc == 2 ? zzj(i2, 1650720768) : -1;
        this.zzl = -1L;
        this.zzm = new long[512];
        this.zzn = new int[512];
        this.zzf = zzafaVar.zzd;
    }

    private final long zzh(int i2) {
        return (this.zze * ((long) i2)) / ((long) this.zzf);
    }

    private final zzaee zzi(int i2) {
        return new zzaee(((long) this.zzn[i2]) * zzh(1), this.zzm[i2]);
    }

    private static int zzj(int i2, int i8) {
        return (((i2 % 10) + 48) << 8) | ((i2 / 10) + 48) | i8;
    }

    public final void zza(long j, boolean z2) {
        if (this.zzl == -1) {
            this.zzl = j;
        }
        if (z2) {
            if (this.zzk == this.zzn.length) {
                long[] jArr = this.zzm;
                this.zzm = Arrays.copyOf(jArr, (jArr.length * 3) / 2);
                int[] iArr = this.zzn;
                this.zzn = Arrays.copyOf(iArr, (iArr.length * 3) / 2);
            }
            long[] jArr2 = this.zzm;
            int i2 = this.zzk;
            jArr2[i2] = j;
            this.zzn[i2] = this.zzj;
            this.zzk = i2 + 1;
        }
        this.zzj++;
    }

    public final void zzb() {
        int i2;
        this.zzm = Arrays.copyOf(this.zzm, this.zzk);
        this.zzn = Arrays.copyOf(this.zzn, this.zzk);
        if ((this.zzc & 1651965952) != 1651965952 || this.zza.zzf == 0 || (i2 = this.zzk) <= 0) {
            return;
        }
        this.zzf = i2;
    }

    public final boolean zzc(int i2) {
        return this.zzc == i2 || this.zzd == i2;
    }

    public final void zzd(int i2) {
        this.zzg = i2;
        this.zzh = i2;
    }

    public final boolean zze(zzadb zzadbVar) throws IOException {
        int i2 = this.zzh;
        zzaem zzaemVar = this.zzb;
        int iZzy = i2 - zzaemVar.zzy(zzadbVar, i2, false);
        this.zzh = iZzy;
        boolean z2 = iZzy == 0;
        if (z2) {
            if (this.zzg > 0) {
                zzaemVar.zzx(zzh(this.zzi), Arrays.binarySearch(this.zzn, this.zzi) >= 0 ? 1 : 0, this.zzg, 0, null);
            }
            this.zzi++;
        }
        return z2;
    }

    public final void zzf(long j) {
        if (this.zzk == 0) {
            this.zzi = 0;
        } else {
            this.zzi = this.zzn[zzep.zzm(this.zzm, j, true, true)];
        }
    }

    public final zzaeb zzg(long j) {
        if (this.zzk == 0) {
            zzaee zzaeeVar = new zzaee(0L, this.zzl);
            return new zzaeb(zzaeeVar, zzaeeVar);
        }
        int iZzh = (int) (j / zzh(1));
        int iZzl = zzep.zzl(this.zzn, iZzh, true, true);
        if (this.zzn[iZzl] == iZzh) {
            zzaee zzaeeVarZzi = zzi(iZzl);
            return new zzaeb(zzaeeVarZzi, zzaeeVarZzi);
        }
        zzaee zzaeeVarZzi2 = zzi(iZzl);
        int i2 = iZzl + 1;
        return i2 < this.zzm.length ? new zzaeb(zzaeeVarZzi2, zzi(i2)) : new zzaeb(zzaeeVarZzi2, zzaeeVarZzi2);
    }
}
