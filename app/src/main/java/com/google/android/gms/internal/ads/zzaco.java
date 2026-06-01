package com.google.android.gms.internal.ads;

import java.util.Arrays;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes4.dex */
public final class zzaco implements zzaed {
    public final int zza;
    public final int[] zzb;
    public final long[] zzc;
    public final long[] zzd;
    public final long[] zze;
    private final long zzf;

    public zzaco(int[] iArr, long[] jArr, long[] jArr2, long[] jArr3) {
        this.zzb = iArr;
        this.zzc = jArr;
        this.zzd = jArr2;
        this.zze = jArr3;
        int length = iArr.length;
        this.zza = length;
        if (length <= 0) {
            this.zzf = 0L;
        } else {
            int i2 = length - 1;
            this.zzf = jArr2[i2] + jArr3[i2];
        }
    }

    public final String toString() {
        long[] jArr = this.zzd;
        long[] jArr2 = this.zze;
        long[] jArr3 = this.zzc;
        String string = Arrays.toString(this.zzb);
        String string2 = Arrays.toString(jArr3);
        String string3 = Arrays.toString(jArr2);
        String string4 = Arrays.toString(jArr);
        int i2 = this.zza;
        int length = String.valueOf(i2).length();
        int length2 = String.valueOf(string).length();
        int length3 = String.valueOf(string2).length();
        StringBuilder sb = new StringBuilder(length + 26 + length2 + 10 + length3 + 9 + String.valueOf(string3).length() + 14 + String.valueOf(string4).length() + 1);
        sb.append("ChunkIndex(length=");
        sb.append(i2);
        sb.append(", sizes=");
        sb.append(string);
        androidx.camera.core.processing.util.a.A(sb, ", offsets=", string2, ", timeUs=", string3);
        return a1.a.s(sb, ", durationsUs=", string4, ")");
    }

    @Override // com.google.android.gms.internal.ads.zzaed
    public final long zza() {
        return this.zzf;
    }

    @Override // com.google.android.gms.internal.ads.zzaed
    public final boolean zzb() {
        return true;
    }

    @Override // com.google.android.gms.internal.ads.zzaed
    public final zzaeb zzc(long j) {
        long[] jArr = this.zze;
        int iZzm = zzep.zzm(jArr, j, true, true);
        long j3 = jArr[iZzm];
        long[] jArr2 = this.zzc;
        zzaee zzaeeVar = new zzaee(j3, jArr2[iZzm]);
        if (zzaeeVar.zzb >= j || iZzm == this.zza - 1) {
            return new zzaeb(zzaeeVar, zzaeeVar);
        }
        int i2 = iZzm + 1;
        return new zzaeb(zzaeeVar, new zzaee(jArr[i2], jArr2[i2]));
    }
}
