package com.google.android.gms.internal.ads;

import java.io.IOException;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes4.dex */
final class zzanw {
    private boolean zzc;
    private boolean zzd;
    private boolean zze;
    private final zzem zza = new zzem(0);
    private long zzf = -9223372036854775807L;
    private long zzg = -9223372036854775807L;
    private long zzh = -9223372036854775807L;
    private final zzeg zzb = new zzeg();

    public zzanw(int i2) {
    }

    private final int zze(zzadb zzadbVar) {
        byte[] bArr = zzep.zzb;
        int length = bArr.length;
        this.zzb.zzb(bArr, 0);
        this.zzc = true;
        zzadbVar.zzl();
        return 0;
    }

    public final boolean zza() {
        return this.zzc;
    }

    public final int zzb(zzadb zzadbVar, zzaea zzaeaVar, int i2) throws IOException {
        if (i2 <= 0) {
            zze(zzadbVar);
            return 0;
        }
        long j = -9223372036854775807L;
        if (this.zze) {
            if (this.zzg == -9223372036854775807L) {
                zze(zzadbVar);
                return 0;
            }
            if (this.zzd) {
                long j3 = this.zzf;
                if (j3 == -9223372036854775807L) {
                    zze(zzadbVar);
                    return 0;
                }
                zzem zzemVar = this.zza;
                this.zzh = zzemVar.zzf(this.zzg) - zzemVar.zze(j3);
                zze(zzadbVar);
                return 0;
            }
            int iMin = (int) Math.min(112800L, zzadbVar.zzo());
            if (zzadbVar.zzn() != 0) {
                zzaeaVar.zza = 0L;
                return 1;
            }
            zzeg zzegVar = this.zzb;
            zzegVar.zza(iMin);
            zzadbVar.zzl();
            zzadbVar.zzi(zzegVar.zzi(), 0, iMin);
            int iZzg = zzegVar.zzg();
            int iZze = zzegVar.zze();
            while (true) {
                if (iZzg >= iZze) {
                    break;
                }
                if (zzegVar.zzi()[iZzg] == 71) {
                    long jZzb = zzaog.zzb(zzegVar, iZzg, i2);
                    if (jZzb != -9223372036854775807L) {
                        j = jZzb;
                        break;
                    }
                }
                iZzg++;
            }
            this.zzf = j;
            this.zzd = true;
            return 0;
        }
        long jZzo = zzadbVar.zzo();
        int iMin2 = (int) Math.min(112800L, jZzo);
        long j8 = jZzo - ((long) iMin2);
        if (zzadbVar.zzn() != j8) {
            zzaeaVar.zza = j8;
            return 1;
        }
        zzeg zzegVar2 = this.zzb;
        zzegVar2.zza(iMin2);
        zzadbVar.zzl();
        zzadbVar.zzi(zzegVar2.zzi(), 0, iMin2);
        int iZzg2 = zzegVar2.zzg();
        int iZze2 = zzegVar2.zze();
        int i8 = iZze2 - 188;
        while (true) {
            if (i8 < iZzg2) {
                break;
            }
            byte[] bArrZzi = zzegVar2.zzi();
            int i9 = -4;
            int i10 = 0;
            while (true) {
                if (i9 > 4) {
                    break;
                }
                int i11 = (i9 * 188) + i8;
                if (i11 < iZzg2 || i11 >= iZze2 || bArrZzi[i11] != 71) {
                    i10 = 0;
                } else {
                    i10++;
                    if (i10 == 5) {
                        long jZzb2 = zzaog.zzb(zzegVar2, i8, i2);
                        if (jZzb2 != -9223372036854775807L) {
                            j = jZzb2;
                            break;
                        }
                    }
                }
                i9++;
            }
            i8--;
        }
        this.zzg = j;
        this.zze = true;
        return 0;
    }

    public final long zzc() {
        return this.zzh;
    }

    public final zzem zzd() {
        return this.zza;
    }
}
