package com.google.android.gms.internal.ads;

import java.io.EOFException;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.util.Arrays;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes4.dex */
final class zzwe {
    private final zzyv zza;
    private final zzeg zzb = new zzeg(32);
    private zzwd zzc;
    private zzwd zzd;
    private zzwd zze;
    private long zzf;

    public zzwe(zzyv zzyvVar) {
        this.zza = zzyvVar;
        zzwd zzwdVar = new zzwd(0L, 65536);
        this.zzc = zzwdVar;
        this.zzd = zzwdVar;
        this.zze = zzwdVar;
    }

    private final int zzi(int i2) {
        zzwd zzwdVar = this.zze;
        if (zzwdVar.zzc == null) {
            zzyt zzytVarZza = this.zza.zza();
            zzwd zzwdVar2 = new zzwd(this.zze.zzb, 65536);
            zzwdVar.zzc = zzytVarZza;
            zzwdVar.zzd = zzwdVar2;
        }
        return Math.min(i2, (int) (this.zze.zzb - this.zzf));
    }

    private final void zzj(int i2) {
        long j = this.zzf + ((long) i2);
        this.zzf = j;
        zzwd zzwdVar = this.zze;
        if (j == zzwdVar.zzb) {
            this.zze = zzwdVar.zzd;
        }
    }

    private static zzwd zzk(zzwd zzwdVar, zzhh zzhhVar, zzwf zzwfVar, zzeg zzegVar) {
        zzwd zzwdVarZzm;
        if (zzhhVar.zzk()) {
            long j = zzwfVar.zzb;
            int iZzt = 1;
            zzegVar.zza(1);
            zzwd zzwdVarZzm2 = zzm(zzwdVar, j, zzegVar.zzi(), 1);
            long j3 = j + 1;
            byte b8 = zzegVar.zzi()[0];
            int i2 = b8 & 128;
            int i8 = b8 & 127;
            zzhe zzheVar = zzhhVar.zzb;
            byte[] bArr = zzheVar.zza;
            if (bArr == null) {
                zzheVar.zza = new byte[16];
            } else {
                Arrays.fill(bArr, (byte) 0);
            }
            boolean z2 = i2 != 0;
            zzwdVarZzm = zzm(zzwdVarZzm2, j3, zzheVar.zza, i8);
            long j8 = j3 + ((long) i8);
            if (z2) {
                zzegVar.zza(2);
                zzwdVarZzm = zzm(zzwdVarZzm, j8, zzegVar.zzi(), 2);
                j8 += 2;
                iZzt = zzegVar.zzt();
            }
            int i9 = iZzt;
            int[] iArr = zzheVar.zzd;
            if (iArr == null || iArr.length < i9) {
                iArr = new int[i9];
            }
            int[] iArr2 = iArr;
            int[] iArr3 = zzheVar.zze;
            if (iArr3 == null || iArr3.length < i9) {
                iArr3 = new int[i9];
            }
            int[] iArr4 = iArr3;
            if (z2) {
                int i10 = i9 * 6;
                zzegVar.zza(i10);
                zzwdVarZzm = zzm(zzwdVarZzm, j8, zzegVar.zzi(), i10);
                j8 += (long) i10;
                zzegVar.zzh(0);
                for (int i11 = 0; i11 < i9; i11++) {
                    iArr2[i11] = zzegVar.zzt();
                    iArr4[i11] = zzegVar.zzH();
                }
            } else {
                iArr2[0] = 0;
                iArr4[0] = zzwfVar.zza - ((int) (j8 - zzwfVar.zzb));
            }
            zzael zzaelVar = zzwfVar.zzc;
            String str = zzep.zza;
            zzheVar.zza(i9, iArr2, iArr4, zzaelVar.zzb, zzheVar.zza, zzaelVar.zza, zzaelVar.zzc, zzaelVar.zzd);
            long j9 = zzwfVar.zzb;
            int i12 = (int) (j8 - j9);
            zzwfVar.zzb = j9 + ((long) i12);
            zzwfVar.zza -= i12;
        } else {
            zzwdVarZzm = zzwdVar;
        }
        if (!zzhhVar.zze()) {
            zzhhVar.zzj(zzwfVar.zza);
            return zzl(zzwdVarZzm, zzwfVar.zzb, zzhhVar.zzc, zzwfVar.zza);
        }
        zzegVar.zza(4);
        zzwd zzwdVarZzm3 = zzm(zzwdVarZzm, zzwfVar.zzb, zzegVar.zzi(), 4);
        int iZzH = zzegVar.zzH();
        zzwfVar.zzb += 4;
        zzwfVar.zza -= 4;
        zzhhVar.zzj(iZzH);
        zzwd zzwdVarZzl = zzl(zzwdVarZzm3, zzwfVar.zzb, zzhhVar.zzc, iZzH);
        zzwfVar.zzb += (long) iZzH;
        int i13 = zzwfVar.zza - iZzH;
        zzwfVar.zza = i13;
        ByteBuffer byteBuffer = zzhhVar.zzf;
        if (byteBuffer == null || byteBuffer.capacity() < i13) {
            zzhhVar.zzf = ByteBuffer.allocate(i13);
        } else {
            zzhhVar.zzf.clear();
        }
        return zzl(zzwdVarZzl, zzwfVar.zzb, zzhhVar.zzf, zzwfVar.zza);
    }

    private static zzwd zzl(zzwd zzwdVar, long j, ByteBuffer byteBuffer, int i2) {
        zzwd zzwdVarZzn = zzn(zzwdVar, j);
        while (i2 > 0) {
            int iMin = Math.min(i2, (int) (zzwdVarZzn.zzb - j));
            byteBuffer.put(zzwdVarZzn.zzc.zza, zzwdVarZzn.zzb(j), iMin);
            i2 -= iMin;
            j += (long) iMin;
            if (j == zzwdVarZzn.zzb) {
                zzwdVarZzn = zzwdVarZzn.zzd;
            }
        }
        return zzwdVarZzn;
    }

    private static zzwd zzm(zzwd zzwdVar, long j, byte[] bArr, int i2) {
        zzwd zzwdVarZzn = zzn(zzwdVar, j);
        int i8 = i2;
        while (i8 > 0) {
            int iMin = Math.min(i8, (int) (zzwdVarZzn.zzb - j));
            System.arraycopy(zzwdVarZzn.zzc.zza, zzwdVarZzn.zzb(j), bArr, i2 - i8, iMin);
            i8 -= iMin;
            j += (long) iMin;
            if (j == zzwdVarZzn.zzb) {
                zzwdVarZzn = zzwdVarZzn.zzd;
            }
        }
        return zzwdVarZzn;
    }

    private static zzwd zzn(zzwd zzwdVar, long j) {
        while (j >= zzwdVar.zzb) {
            zzwdVar = zzwdVar.zzd;
        }
        return zzwdVar;
    }

    public final void zza() {
        zzwd zzwdVar = this.zzc;
        if (zzwdVar.zzc != null) {
            this.zza.zzc(zzwdVar);
            zzwdVar.zzc();
        }
        this.zzc.zza(0L, 65536);
        zzwd zzwdVar2 = this.zzc;
        this.zzd = zzwdVar2;
        this.zze = zzwdVar2;
        this.zzf = 0L;
        this.zza.zzd();
    }

    public final void zzb() {
        this.zzd = this.zzc;
    }

    public final void zzc(zzhh zzhhVar, zzwf zzwfVar) {
        this.zzd = zzk(this.zzd, zzhhVar, zzwfVar, this.zzb);
    }

    public final void zzd(zzhh zzhhVar, zzwf zzwfVar) {
        zzk(this.zzd, zzhhVar, zzwfVar, this.zzb);
    }

    public final void zze(long j) {
        zzwd zzwdVar;
        if (j != -1) {
            while (true) {
                zzwdVar = this.zzc;
                if (j < zzwdVar.zzb) {
                    break;
                }
                this.zza.zzb(zzwdVar.zzc);
                this.zzc = this.zzc.zzc();
            }
            if (this.zzd.zza < zzwdVar.zza) {
                this.zzd = zzwdVar;
            }
        }
    }

    public final long zzf() {
        return this.zzf;
    }

    public final int zzg(zzj zzjVar, int i2, boolean z2) throws IOException {
        int iZzi = zzi(i2);
        zzwd zzwdVar = this.zze;
        int iZza = zzjVar.zza(zzwdVar.zzc.zza, zzwdVar.zzb(this.zzf), iZzi);
        if (iZza != -1) {
            zzj(iZza);
            return iZza;
        }
        if (z2) {
            return -1;
        }
        throw new EOFException();
    }

    public final void zzh(zzeg zzegVar, int i2) {
        while (i2 > 0) {
            int iZzi = zzi(i2);
            zzwd zzwdVar = this.zze;
            zzegVar.zzm(zzwdVar.zzc.zza, zzwdVar.zzb(this.zzf), iZzi);
            i2 -= iZzi;
            zzj(iZzi);
        }
    }
}
