package com.google.android.gms.internal.ads;

import java.io.IOException;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes4.dex */
final class zzanm {
    private boolean zzc;
    private boolean zzd;
    private boolean zze;
    private final zzem zza = new zzem(0);
    private long zzf = -9223372036854775807L;
    private long zzg = -9223372036854775807L;
    private long zzh = -9223372036854775807L;
    private final zzeg zzb = new zzeg();

    public static long zze(zzeg zzegVar) {
        int iZzg = zzegVar.zzg();
        if (zzegVar.zzd() < 9) {
            return -9223372036854775807L;
        }
        byte[] bArr = new byte[9];
        zzegVar.zzm(bArr, 0, 9);
        zzegVar.zzh(iZzg);
        byte b8 = bArr[0];
        if ((b8 & 196) != 68) {
            return -9223372036854775807L;
        }
        byte b9 = bArr[2];
        if ((b9 & 4) != 4) {
            return -9223372036854775807L;
        }
        byte b10 = bArr[4];
        if ((b10 & 4) != 4 || (bArr[5] & 1) != 1 || (bArr[8] & 3) != 3) {
            return -9223372036854775807L;
        }
        long j = b8;
        long j3 = b9;
        long j8 = (248 & j3) >> 3;
        long j9 = (bArr[1] & 255) << 20;
        long j10 = (j3 & 3) << 13;
        return j10 | j9 | ((j & 3) << 28) | (((j & 56) >> 3) << 30) | (j8 << 15) | ((((long) bArr[3]) & 255) << 5) | ((((long) b10) & 248) >> 3);
    }

    private final int zzf(zzadb zzadbVar) {
        byte[] bArr = zzep.zzb;
        int length = bArr.length;
        this.zzb.zzb(bArr, 0);
        this.zzc = true;
        zzadbVar.zzl();
        return 0;
    }

    private static final int zzg(byte[] bArr, int i2) {
        return (bArr[i2 + 3] & 255) | ((bArr[i2] & 255) << 24) | ((bArr[i2 + 1] & 255) << 16) | ((bArr[i2 + 2] & 255) << 8);
    }

    public final boolean zza() {
        return this.zzc;
    }

    public final zzem zzb() {
        return this.zza;
    }

    public final int zzc(zzadb zzadbVar, zzaea zzaeaVar) throws IOException {
        long j = -9223372036854775807L;
        if (!this.zze) {
            long jZzo = zzadbVar.zzo();
            int iMin = (int) Math.min(20000L, jZzo);
            long j3 = jZzo - ((long) iMin);
            if (zzadbVar.zzn() != j3) {
                zzaeaVar.zza = j3;
                return 1;
            }
            zzeg zzegVar = this.zzb;
            zzegVar.zza(iMin);
            zzadbVar.zzl();
            zzadbVar.zzi(zzegVar.zzi(), 0, iMin);
            int iZzg = zzegVar.zzg();
            int iZze = zzegVar.zze() - 4;
            while (true) {
                if (iZze < iZzg) {
                    break;
                }
                if (zzg(zzegVar.zzi(), iZze) == 442) {
                    zzegVar.zzh(iZze + 4);
                    long jZze = zze(zzegVar);
                    if (jZze != -9223372036854775807L) {
                        j = jZze;
                        break;
                    }
                }
                iZze--;
            }
            this.zzg = j;
            this.zze = true;
            return 0;
        }
        if (this.zzg == -9223372036854775807L) {
            zzf(zzadbVar);
            return 0;
        }
        if (this.zzd) {
            long j8 = this.zzf;
            if (j8 == -9223372036854775807L) {
                zzf(zzadbVar);
                return 0;
            }
            zzem zzemVar = this.zza;
            this.zzh = zzemVar.zzf(this.zzg) - zzemVar.zze(j8);
            zzf(zzadbVar);
            return 0;
        }
        int iMin2 = (int) Math.min(20000L, zzadbVar.zzo());
        if (zzadbVar.zzn() != 0) {
            zzaeaVar.zza = 0L;
            return 1;
        }
        zzeg zzegVar2 = this.zzb;
        zzegVar2.zza(iMin2);
        zzadbVar.zzl();
        zzadbVar.zzi(zzegVar2.zzi(), 0, iMin2);
        int iZzg2 = zzegVar2.zzg();
        int iZze2 = zzegVar2.zze();
        while (true) {
            if (iZzg2 >= iZze2 - 3) {
                break;
            }
            if (zzg(zzegVar2.zzi(), iZzg2) == 442) {
                zzegVar2.zzh(iZzg2 + 4);
                long jZze2 = zze(zzegVar2);
                if (jZze2 != -9223372036854775807L) {
                    j = jZze2;
                    break;
                }
            }
            iZzg2++;
        }
        this.zzf = j;
        this.zzd = true;
        return 0;
    }

    public final long zzd() {
        return this.zzh;
    }
}
