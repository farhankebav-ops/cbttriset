package com.google.android.gms.internal.ads;

import java.io.IOException;
import java.math.RoundingMode;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes4.dex */
final class zzaol implements zzaok {
    private final zzadd zza;
    private final zzaem zzb;
    private final zzaoo zzc;
    private final zzv zzd;
    private final int zze;
    private long zzf;
    private int zzg;
    private long zzh;

    public zzaol(zzadd zzaddVar, zzaem zzaemVar, zzaoo zzaooVar, String str, int i2) throws zzat {
        this.zza = zzaddVar;
        this.zzb = zzaemVar;
        this.zzc = zzaooVar;
        int i8 = zzaooVar.zzb * zzaooVar.zze;
        int i9 = zzaooVar.zzd;
        int i10 = i8 / 8;
        if (i9 != i10) {
            throw zzat.zzb(a1.a.f(i10, i9, "Expected block size: ", "; got: ", new StringBuilder(String.valueOf(i10).length() + 28 + String.valueOf(i9).length())), null);
        }
        int i11 = zzaooVar.zzc * i10;
        int i12 = i11 * 8;
        int iMax = Math.max(i10, i11 / 10);
        this.zze = iMax;
        zzt zztVar = new zzt();
        zztVar.zzl("audio/wav");
        zztVar.zzm(str);
        zztVar.zzh(i12);
        zztVar.zzi(i12);
        zztVar.zzn(iMax);
        zztVar.zzE(zzaooVar.zzb);
        zztVar.zzF(zzaooVar.zzc);
        zztVar.zzG(i2);
        this.zzd = zztVar.zzM();
    }

    @Override // com.google.android.gms.internal.ads.zzaok
    public final void zza(long j) {
        this.zzf = j;
        this.zzg = 0;
        this.zzh = 0L;
    }

    @Override // com.google.android.gms.internal.ads.zzaok
    public final void zzb(int i2, long j) {
        this.zza.zzw(new zzaor(this.zzc, 1, i2, j));
        this.zzb.zzu(this.zzd);
    }

    @Override // com.google.android.gms.internal.ads.zzaok
    public final boolean zzc(zzadb zzadbVar, long j) throws IOException {
        int i2;
        int i8;
        long j3 = j;
        while (j3 > 0 && (i2 = this.zzg) < (i8 = this.zze)) {
            int iZzy = this.zzb.zzy(zzadbVar, (int) Math.min(i8 - i2, j3), true);
            if (iZzy == -1) {
                j3 = 0;
            } else {
                this.zzg += iZzy;
                j3 -= (long) iZzy;
            }
        }
        zzaoo zzaooVar = this.zzc;
        int i9 = this.zzg;
        int i10 = zzaooVar.zzd;
        int i11 = i9 / i10;
        if (i11 > 0) {
            long jZzt = this.zzf + zzep.zzt(this.zzh, 1000000L, zzaooVar.zzc, RoundingMode.DOWN);
            int i12 = i11 * i10;
            int i13 = this.zzg - i12;
            this.zzb.zzx(jZzt, 1, i12, i13, null);
            this.zzh += (long) i11;
            this.zzg = i13;
        }
        return j3 <= 0;
    }
}
