package com.google.android.gms.internal.ads;

import androidx.annotation.Nullable;
import androidx.core.location.LocationRequestCompat;
import java.io.IOException;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes4.dex */
public final class zzty implements zzus, zzur {
    public final zzus zza;
    long zzb;

    @Nullable
    private zzur zzc;
    private zztx[] zzd = new zztx[0];
    private long zze = 0;

    public zzty(zzus zzusVar, boolean z2, long j, long j3) {
        this.zza = zzusVar;
        this.zzb = j3;
    }

    private static long zzq(long j, long j3, long j8) {
        long jMax = Math.max(j, j3);
        return j8 != Long.MIN_VALUE ? Math.min(jMax, j8) : jMax;
    }

    public final void zza(long j, long j3) {
        this.zzb = j3;
    }

    @Override // com.google.android.gms.internal.ads.zzus
    public final void zzb(zzur zzurVar, long j) {
        this.zzc = zzurVar;
        this.zza.zzb(this, j);
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
        int length = zzwkVarArr.length;
        this.zzd = new zztx[length];
        zzwk[] zzwkVarArr2 = new zzwk[length];
        int i2 = 0;
        while (true) {
            zzwk zzwkVar = null;
            if (i2 >= zzwkVarArr.length) {
                break;
            }
            zztx[] zztxVarArr = this.zzd;
            zztx zztxVar = (zztx) zzwkVarArr[i2];
            zztxVarArr[i2] = zztxVar;
            if (zztxVar != null) {
                zzwkVar = zztxVar.zza;
            }
            zzwkVarArr2[i2] = zzwkVar;
            i2++;
        }
        long jZze = this.zza.zze(zzykVarArr, zArr, zzwkVarArr2, zArr2, j);
        long jZzq = zzq(jZze, j, this.zzb);
        long j3 = -9223372036854775807L;
        if (zzo()) {
            if (jZze < j) {
                j3 = jZzq;
                break;
            }
            if (jZze != 0) {
                for (zzyk zzykVar : zzykVarArr) {
                    if (zzykVar != null) {
                        zzv zzvVarZzc = zzykVar.zzc();
                        if (!zzas.zzd(zzvVarZzc.zzo, zzvVarZzc.zzk)) {
                            j3 = jZzq;
                            break;
                        }
                    }
                }
            }
        }
        this.zze = j3;
        for (int i8 = 0; i8 < zzwkVarArr.length; i8++) {
            zzwk zzwkVar2 = zzwkVarArr2[i8];
            if (zzwkVar2 == null) {
                this.zzd[i8] = null;
            } else {
                zztx[] zztxVarArr2 = this.zzd;
                zztx zztxVar2 = zztxVarArr2[i8];
                if (zztxVar2 == null || zztxVar2.zza != zzwkVar2) {
                    zztxVarArr2[i8] = new zztx(this, zzwkVar2);
                }
            }
            zzwkVarArr[i8] = this.zzd[i8];
        }
        return jZzq;
    }

    @Override // com.google.android.gms.internal.ads.zzus
    public final void zzf(long j, boolean z2) {
        this.zza.zzf(j, false);
    }

    @Override // com.google.android.gms.internal.ads.zzus, com.google.android.gms.internal.ads.zzwm
    public final void zzg(long j) {
        this.zza.zzg(j);
    }

    @Override // com.google.android.gms.internal.ads.zzus
    public final long zzh() {
        if (zzo()) {
            long j = this.zze;
            this.zze = -9223372036854775807L;
            long jZzh = zzh();
            return jZzh != -9223372036854775807L ? jZzh : j;
        }
        long jZzh2 = this.zza.zzh();
        if (jZzh2 == -9223372036854775807L) {
            return -9223372036854775807L;
        }
        return zzq(jZzh2, 0L, this.zzb);
    }

    @Override // com.google.android.gms.internal.ads.zzus, com.google.android.gms.internal.ads.zzwm
    public final long zzi() {
        long jZzi = this.zza.zzi();
        if (jZzi != Long.MIN_VALUE) {
            long j = this.zzb;
            if (j == Long.MIN_VALUE || jZzi < j) {
                return jZzi;
            }
        }
        return Long.MIN_VALUE;
    }

    @Override // com.google.android.gms.internal.ads.zzus
    public final long zzj(long j) {
        this.zze = -9223372036854775807L;
        for (zztx zztxVar : this.zzd) {
            if (zztxVar != null) {
                zztxVar.zza();
            }
        }
        return zzq(this.zza.zzj(j), 0L, this.zzb);
    }

    @Override // com.google.android.gms.internal.ads.zzus
    public final long zzk(long j, zzlv zzlvVar) {
        if (j == 0) {
            return 0L;
        }
        long j3 = zzlvVar.zzd;
        String str = zzep.zza;
        long jMax = Math.max(0L, Math.min(j3, j));
        long j8 = zzlvVar.zze;
        long j9 = this.zzb;
        long jMax2 = Math.max(0L, Math.min(j8, j9 == Long.MIN_VALUE ? LocationRequestCompat.PASSIVE_INTERVAL : j9 - j));
        if (jMax != j3 || jMax2 != j8) {
            zzlvVar = new zzlv(jMax, jMax2);
        }
        return this.zza.zzk(j, zzlvVar);
    }

    @Override // com.google.android.gms.internal.ads.zzus, com.google.android.gms.internal.ads.zzwm
    public final long zzl() {
        long jZzl = this.zza.zzl();
        if (jZzl != Long.MIN_VALUE) {
            long j = this.zzb;
            if (j == Long.MIN_VALUE || jZzl < j) {
                return jZzl;
            }
        }
        return Long.MIN_VALUE;
    }

    @Override // com.google.android.gms.internal.ads.zzus, com.google.android.gms.internal.ads.zzwm
    public final boolean zzm(zzkn zzknVar) {
        return this.zza.zzm(zzknVar);
    }

    @Override // com.google.android.gms.internal.ads.zzus, com.google.android.gms.internal.ads.zzwm
    public final boolean zzn() {
        return this.zza.zzn();
    }

    public final boolean zzo() {
        return this.zze != -9223372036854775807L;
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
