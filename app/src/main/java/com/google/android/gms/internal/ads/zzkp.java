package com.google.android.gms.internal.ads;

import androidx.annotation.Nullable;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes4.dex */
final class zzkp {
    public final zzus zza;
    public final Object zzb;
    public final zzwk[] zzc;
    public boolean zzd;
    public boolean zze;
    public boolean zzf;
    public zzkq zzg;
    public boolean zzh;
    private final boolean[] zzi;
    private final zzlp[] zzj;
    private final zzyr zzk;
    private final zzle zzl;

    @Nullable
    private zzkp zzm;
    private zzwv zzn;
    private zzys zzo;
    private long zzp;

    public zzkp(zzlp[] zzlpVarArr, long j, zzyr zzyrVar, zzyv zzyvVar, zzle zzleVar, zzkq zzkqVar, zzys zzysVar, long j3) {
        this.zzj = zzlpVarArr;
        this.zzp = j;
        this.zzk = zzyrVar;
        this.zzl = zzleVar;
        zzuu zzuuVar = zzkqVar.zza;
        this.zzb = zzuuVar.zza;
        this.zzg = zzkqVar;
        this.zzn = zzwv.zza;
        this.zzo = zzysVar;
        this.zzc = new zzwk[2];
        this.zzi = new boolean[2];
        long j8 = zzkqVar.zzb;
        long j9 = zzkqVar.zzd;
        zzus zzusVarZze = zzleVar.zze(zzuuVar, zzyvVar, j8);
        this.zza = j9 != -9223372036854775807L ? new zzty(zzusVarZze, true, 0L, j9) : zzusVarZze;
    }

    private final void zzu() {
        if (!zzw()) {
            return;
        }
        int i2 = 0;
        while (true) {
            zzys zzysVar = this.zzo;
            if (i2 >= zzysVar.zza) {
                return;
            }
            zzysVar.zza(i2);
            zzyk zzykVar = this.zzo.zzc[i2];
            i2++;
        }
    }

    private final void zzv() {
        if (!zzw()) {
            return;
        }
        int i2 = 0;
        while (true) {
            zzys zzysVar = this.zzo;
            if (i2 >= zzysVar.zza) {
                return;
            }
            zzysVar.zza(i2);
            zzyk zzykVar = this.zzo.zzc[i2];
            i2++;
        }
    }

    private final boolean zzw() {
        return this.zzm == null;
    }

    public final long zza() {
        return this.zzp;
    }

    public final void zzb(long j) {
        this.zzp = j;
    }

    public final long zzc() {
        return this.zzg.zzb + this.zzp;
    }

    public final boolean zzd() {
        if (this.zze) {
            return !this.zzf || this.zza.zzi() == Long.MIN_VALUE;
        }
        return false;
    }

    public final boolean zze() {
        if (this.zze) {
            return zzd() || zzf() - this.zzg.zzb >= -9223372036854775807L;
        }
        return false;
    }

    public final long zzf() {
        if (!this.zze) {
            return this.zzg.zzb;
        }
        long jZzi = this.zzf ? this.zza.zzi() : Long.MIN_VALUE;
        return jZzi == Long.MIN_VALUE ? this.zzg.zze : jZzi;
    }

    public final long zzg() {
        if (this.zze) {
            return this.zza.zzl();
        }
        return 0L;
    }

    public final void zzh(float f4, zzbf zzbfVar, boolean z2) throws zzib {
        this.zze = true;
        this.zzn = this.zza.zzd();
        zzys zzysVarZzk = zzk(f4, zzbfVar, z2);
        zzkq zzkqVar = this.zzg;
        long jMax = zzkqVar.zzb;
        long j = zzkqVar.zze;
        if (j != -9223372036854775807L && jMax >= j) {
            jMax = Math.max(0L, j - 1);
        }
        long jZzl = zzl(zzysVarZzk, jMax, false);
        long j3 = this.zzp;
        zzkq zzkqVar2 = this.zzg;
        this.zzp = (zzkqVar2.zzb - jZzl) + j3;
        this.zzg = zzkqVar2.zza(jZzl);
    }

    public final void zzi(long j) {
        zzgmd.zzh(zzw());
        if (this.zze) {
            this.zza.zzg(j - this.zzp);
        }
    }

    public final void zzj(zzkn zzknVar) {
        zzgmd.zzh(zzw());
        this.zza.zzm(zzknVar);
    }

    public final zzys zzk(float f4, zzbf zzbfVar, boolean z2) throws zzib {
        zzwv zzwvVar = this.zzn;
        zzuu zzuuVar = this.zzg.zza;
        zzyr zzyrVar = this.zzk;
        zzlp[] zzlpVarArr = this.zzj;
        zzys zzysVarZzq = zzyrVar.zzq(zzlpVarArr, zzwvVar, zzuuVar, zzbfVar);
        for (int i2 = 0; i2 < zzysVarZzq.zza; i2++) {
            if (zzysVarZzq.zza(i2)) {
                if (zzysVarZzq.zzc[i2] == null) {
                    zzlpVarArr[i2].zza();
                    z = false;
                }
                zzgmd.zzh(z);
            } else {
                zzgmd.zzh(zzysVarZzq.zzc[i2] == null);
            }
        }
        for (zzyk zzykVar : zzysVarZzq.zzc) {
        }
        return zzysVarZzq;
    }

    public final long zzl(zzys zzysVar, long j, boolean z2) {
        return zzm(zzysVar, j, false, new boolean[2]);
    }

    public final long zzm(zzys zzysVar, long j, boolean z2, boolean[] zArr) {
        zzlp[] zzlpVarArr;
        int i2 = 0;
        while (true) {
            boolean z7 = true;
            if (i2 >= zzysVar.zza) {
                break;
            }
            boolean[] zArr2 = this.zzi;
            if (z2 || !zzysVar.zzb(this.zzo, i2)) {
                z7 = false;
            }
            zArr2[i2] = z7;
            i2++;
        }
        int i8 = 0;
        while (true) {
            zzlpVarArr = this.zzj;
            if (i8 >= 2) {
                break;
            }
            zzlpVarArr[i8].zza();
            i8++;
        }
        zzv();
        this.zzo = zzysVar;
        zzu();
        zzus zzusVar = this.zza;
        zzyk[] zzykVarArr = zzysVar.zzc;
        boolean[] zArr3 = this.zzi;
        zzwk[] zzwkVarArr = this.zzc;
        long jZze = zzusVar.zze(zzykVarArr, zArr3, zzwkVarArr, zArr, j);
        for (int i9 = 0; i9 < 2; i9++) {
            zzlpVarArr[i9].zza();
        }
        this.zzf = false;
        for (int i10 = 0; i10 < 2; i10++) {
            if (zzwkVarArr[i10] != null) {
                zzgmd.zzh(zzysVar.zza(i10));
                zzlpVarArr[i10].zza();
                this.zzf = true;
            } else {
                zzgmd.zzh(zzykVarArr[i10] == null);
            }
        }
        return jZze;
    }

    public final void zzn() {
        zzv();
        zzus zzusVar = this.zza;
        try {
            boolean z2 = zzusVar instanceof zzty;
            zzle zzleVar = this.zzl;
            if (z2) {
                zzleVar.zzf(((zzty) zzusVar).zza);
            } else {
                zzleVar.zzf(zzusVar);
            }
        } catch (RuntimeException e) {
            zzdt.zzf("MediaPeriodHolder", "Period release failed.", e);
        }
    }

    public final void zzo(@Nullable zzkp zzkpVar) {
        if (zzkpVar == this.zzm) {
            return;
        }
        zzv();
        this.zzm = zzkpVar;
        zzu();
    }

    @Nullable
    public final zzkp zzp() {
        return this.zzm;
    }

    public final zzwv zzq() {
        return this.zzn;
    }

    public final zzys zzr() {
        return this.zzo;
    }

    public final void zzs() {
        zzus zzusVar = this.zza;
        if (zzusVar instanceof zzty) {
            long j = this.zzg.zzd;
            if (j == -9223372036854775807L) {
                j = Long.MIN_VALUE;
            }
            ((zzty) zzusVar).zza(0L, j);
        }
    }

    public final void zzt(zzur zzurVar, long j) {
        this.zzd = true;
        this.zza.zzb(zzurVar, j);
    }
}
