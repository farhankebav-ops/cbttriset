package com.google.android.gms.internal.ads;

import java.io.IOException;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes4.dex */
final class zzws implements zzus, zzur {
    private final zzus zza;
    private final long zzb;
    private zzur zzc;

    public zzws(zzus zzusVar, long j) {
        this.zza = zzusVar;
        this.zzb = j;
    }

    public final zzus zza() {
        return this.zza;
    }

    @Override // com.google.android.gms.internal.ads.zzus
    public final void zzb(zzur zzurVar, long j) {
        this.zzc = zzurVar;
        this.zza.zzb(this, j - this.zzb);
    }

    @Override // com.google.android.gms.internal.ads.zzus
    public final void zzc() throws IOException {
        this.zza.zzc();
    }

    @Override // com.google.android.gms.internal.ads.zzus
    public final zzwv zzd() {
        return this.zza.zzd();
    }

    @Override // com.google.android.gms.internal.ads.zzus
    public final long zze(zzyk[] zzykVarArr, boolean[] zArr, zzwk[] zzwkVarArr, boolean[] zArr2, long j) {
        zzwk[] zzwkVarArr2 = new zzwk[zzwkVarArr.length];
        int i2 = 0;
        while (true) {
            zzwk zzwkVarZza = null;
            if (i2 >= zzwkVarArr.length) {
                break;
            }
            zzwr zzwrVar = (zzwr) zzwkVarArr[i2];
            if (zzwrVar != null) {
                zzwkVarZza = zzwrVar.zza();
            }
            zzwkVarArr2[i2] = zzwkVarZza;
            i2++;
        }
        zzus zzusVar = this.zza;
        long j3 = this.zzb;
        long jZze = zzusVar.zze(zzykVarArr, zArr, zzwkVarArr2, zArr2, j - j3);
        for (int i8 = 0; i8 < zzwkVarArr.length; i8++) {
            zzwk zzwkVar = zzwkVarArr2[i8];
            if (zzwkVar == null) {
                zzwkVarArr[i8] = null;
            } else {
                zzwk zzwkVar2 = zzwkVarArr[i8];
                if (zzwkVar2 == null || ((zzwr) zzwkVar2).zza() != zzwkVar) {
                    zzwkVarArr[i8] = new zzwr(zzwkVar, j3);
                }
            }
        }
        return jZze + j3;
    }

    @Override // com.google.android.gms.internal.ads.zzus
    public final void zzf(long j, boolean z2) {
        this.zza.zzf(j - this.zzb, false);
    }

    @Override // com.google.android.gms.internal.ads.zzus, com.google.android.gms.internal.ads.zzwm
    public final void zzg(long j) {
        this.zza.zzg(j - this.zzb);
    }

    @Override // com.google.android.gms.internal.ads.zzus
    public final long zzh() {
        long jZzh = this.zza.zzh();
        if (jZzh == -9223372036854775807L) {
            return -9223372036854775807L;
        }
        return jZzh + this.zzb;
    }

    @Override // com.google.android.gms.internal.ads.zzus, com.google.android.gms.internal.ads.zzwm
    public final long zzi() {
        long jZzi = this.zza.zzi();
        if (jZzi == Long.MIN_VALUE) {
            return Long.MIN_VALUE;
        }
        return jZzi + this.zzb;
    }

    @Override // com.google.android.gms.internal.ads.zzus
    public final long zzj(long j) {
        long j3 = this.zzb;
        return this.zza.zzj(j - j3) + j3;
    }

    @Override // com.google.android.gms.internal.ads.zzus
    public final long zzk(long j, zzlv zzlvVar) {
        long j3 = this.zzb;
        return this.zza.zzk(j - j3, zzlvVar) + j3;
    }

    @Override // com.google.android.gms.internal.ads.zzus, com.google.android.gms.internal.ads.zzwm
    public final long zzl() {
        long jZzl = this.zza.zzl();
        if (jZzl == Long.MIN_VALUE) {
            return Long.MIN_VALUE;
        }
        return jZzl + this.zzb;
    }

    @Override // com.google.android.gms.internal.ads.zzus, com.google.android.gms.internal.ads.zzwm
    public final boolean zzm(zzkn zzknVar) {
        long j = zzknVar.zza;
        long j3 = this.zzb;
        zzkm zzkmVarZza = zzknVar.zza();
        zzkmVarZza.zza(j - j3);
        return this.zza.zzm(zzkmVarZza.zzd());
    }

    @Override // com.google.android.gms.internal.ads.zzus, com.google.android.gms.internal.ads.zzwm
    public final boolean zzn() {
        return this.zza.zzn();
    }

    @Override // com.google.android.gms.internal.ads.zzur
    public final void zzp(zzus zzusVar) {
        zzur zzurVar = this.zzc;
        zzurVar.getClass();
        zzurVar.zzp(this);
    }

    @Override // com.google.android.gms.internal.ads.zzwl
    public final /* bridge */ /* synthetic */ void zzs(zzwm zzwmVar) {
        zzur zzurVar = this.zzc;
        zzurVar.getClass();
        zzurVar.zzs(this);
    }
}
