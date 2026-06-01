package com.google.android.gms.internal.ads;

import androidx.annotation.Nullable;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes4.dex */
final class zzahv implements zzahu {
    private final long[] zza;
    private final long[] zzb;
    private final long zzc;
    private final long zzd;
    private final int zze;

    private zzahv(long[] jArr, long[] jArr2, long j, long j3, long j8, int i2) {
        this.zza = jArr;
        this.zzb = jArr2;
        this.zzc = j;
        this.zzd = j8;
        this.zze = i2;
    }

    @Nullable
    public static zzahv zzd(long j, long j3, zzadw zzadwVar, zzeg zzegVar) {
        int iZzs;
        zzeg zzegVar2 = zzegVar;
        zzegVar2.zzk(6);
        int iZzB = zzegVar2.zzB();
        long j8 = zzadwVar.zzc;
        long j9 = iZzB;
        if (zzegVar2.zzB() <= 0) {
            return null;
        }
        long jZzr = zzep.zzr((((long) r4) * ((long) zzadwVar.zzg)) - 1, zzadwVar.zzd);
        int iZzt = zzegVar2.zzt();
        int iZzt2 = zzegVar2.zzt();
        int iZzt3 = zzegVar2.zzt();
        zzegVar2.zzk(2);
        long[] jArr = new long[iZzt];
        long[] jArr2 = new long[iZzt];
        int i2 = 0;
        long j10 = j3 + ((long) zzadwVar.zzc);
        while (i2 < iZzt) {
            long j11 = j8;
            jArr[i2] = (((long) i2) * jZzr) / ((long) iZzt);
            jArr2[i2] = j10;
            if (iZzt3 == 1) {
                iZzs = zzegVar2.zzs();
            } else if (iZzt3 == 2) {
                iZzs = zzegVar2.zzt();
            } else if (iZzt3 == 3) {
                iZzs = zzegVar2.zzx();
            } else {
                if (iZzt3 != 4) {
                    return null;
                }
                iZzs = zzegVar2.zzH();
            }
            j10 += ((long) iZzs) * ((long) iZzt2);
            i2++;
            zzegVar2 = zzegVar;
            iZzt = iZzt;
            j8 = j11;
        }
        long j12 = j3 + j8;
        long jMax = j12 + j9;
        if (j != -1 && j != jMax) {
            StringBuilder sb = new StringBuilder(String.valueOf(j).length() + 27 + String.valueOf(jMax).length());
            androidx.camera.core.processing.util.a.y(sb, "VBRI data size mismatch: ", j, ", ");
            sb.append(jMax);
            zzdt.zzc("VbriSeeker", sb.toString());
        }
        if (jMax != j10) {
            StringBuilder sb2 = new StringBuilder(String.valueOf(j10).length() + String.valueOf(jMax).length() + 43 + 28);
            androidx.camera.core.processing.util.a.y(sb2, "VBRI bytes and ToC mismatch (using max): ", jMax, ", ");
            sb2.append(j10);
            sb2.append("\nSeeking will be inaccurate.");
            zzdt.zzc("VbriSeeker", sb2.toString());
            jMax = Math.max(jMax, j10);
        }
        return new zzahv(jArr, jArr2, jZzr, j12, jMax, zzadwVar.zzf);
    }

    @Override // com.google.android.gms.internal.ads.zzaed
    public final long zza() {
        return this.zzc;
    }

    @Override // com.google.android.gms.internal.ads.zzaed
    public final boolean zzb() {
        return true;
    }

    @Override // com.google.android.gms.internal.ads.zzaed
    public final zzaeb zzc(long j) {
        long[] jArr = this.zza;
        int iZzm = zzep.zzm(jArr, j, true, true);
        long j3 = jArr[iZzm];
        long[] jArr2 = this.zzb;
        zzaee zzaeeVar = new zzaee(j3, jArr2[iZzm]);
        if (zzaeeVar.zzb >= j || iZzm == jArr.length - 1) {
            return new zzaeb(zzaeeVar, zzaeeVar);
        }
        int i2 = iZzm + 1;
        return new zzaeb(zzaeeVar, new zzaee(jArr[i2], jArr2[i2]));
    }

    @Override // com.google.android.gms.internal.ads.zzahu
    public final long zze(long j) {
        return this.zza[zzep.zzm(this.zzb, j, true, true)];
    }

    @Override // com.google.android.gms.internal.ads.zzahu
    public final long zzf() {
        return this.zzd;
    }

    @Override // com.google.android.gms.internal.ads.zzahu
    public final int zzg() {
        return this.zze;
    }
}
