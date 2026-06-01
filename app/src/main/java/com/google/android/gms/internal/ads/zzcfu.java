package com.google.android.gms.internal.ads;

import android.net.Uri;
import java.io.IOException;
import java.util.Map;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes4.dex */
final class zzcfu implements zzgb {
    private final zzgb zza;
    private final long zzb;
    private final zzgb zzc;
    private long zzd;
    private Uri zze;

    public zzcfu(zzgb zzgbVar, int i2, zzgb zzgbVar2) {
        this.zza = zzgbVar;
        this.zzb = i2;
        this.zzc = zzgbVar2;
    }

    @Override // com.google.android.gms.internal.ads.zzj
    public final int zza(byte[] bArr, int i2, int i8) throws IOException {
        int i9;
        long j = this.zzd;
        long j3 = this.zzb;
        if (j < j3) {
            int iZza = this.zza.zza(bArr, i2, (int) Math.min(i8, j3 - j));
            long j8 = this.zzd + ((long) iZza);
            this.zzd = j8;
            i9 = iZza;
            j = j8;
        } else {
            i9 = 0;
        }
        if (j < j3) {
            return i9;
        }
        int iZza2 = this.zzc.zza(bArr, i2 + i9, i8 - i9);
        int i10 = i9 + iZza2;
        this.zzd += (long) iZza2;
        return i10;
    }

    @Override // com.google.android.gms.internal.ads.zzgb
    public final long zzb(zzgf zzgfVar) throws IOException {
        Uri uri;
        zzgf zzgfVar2;
        Uri uri2 = zzgfVar.zza;
        this.zze = uri2;
        long j = zzgfVar.zze;
        long j3 = this.zzb;
        zzgf zzgfVar3 = null;
        if (j >= j3) {
            uri = uri2;
            zzgfVar2 = null;
        } else {
            long j8 = zzgfVar.zzf;
            long jMin = j3 - j;
            if (j8 != -1) {
                jMin = Math.min(j8, jMin);
            }
            uri = uri2;
            zzgfVar2 = new zzgf(uri, j, jMin, null);
        }
        long j9 = zzgfVar.zzf;
        if (j9 == -1 || j + j9 > j3) {
            zzgfVar3 = new zzgf(uri, Math.max(j3, j), j9 != -1 ? Math.min(j9, (j + j9) - j3) : -1L, null);
        }
        long jZzb = zzgfVar2 != null ? this.zza.zzb(zzgfVar2) : 0L;
        long jZzb2 = zzgfVar3 != null ? this.zzc.zzb(zzgfVar3) : 0L;
        this.zzd = j;
        if (jZzb == -1 || jZzb2 == -1) {
            return -1L;
        }
        return jZzb + jZzb2;
    }

    @Override // com.google.android.gms.internal.ads.zzgb
    public final Uri zzc() {
        return this.zze;
    }

    @Override // com.google.android.gms.internal.ads.zzgb
    public final void zzd() throws IOException {
        this.zza.zzd();
        this.zzc.zzd();
    }

    @Override // com.google.android.gms.internal.ads.zzgb
    public final Map zzj() {
        return zzgph.zza();
    }

    @Override // com.google.android.gms.internal.ads.zzgb
    public final void zze(zzgz zzgzVar) {
    }
}
