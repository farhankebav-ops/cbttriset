package com.google.android.gms.internal.ads;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes4.dex */
abstract class zzhvp extends zzhvt {
    final byte[] zza;
    final int zzb;
    int zzc;
    int zzd;

    public zzhvp(int i2) {
        super(null);
        if (i2 < 0) {
            throw new IllegalArgumentException("bufferSize must be >= 0");
        }
        byte[] bArr = new byte[Math.max(i2, 20)];
        this.zza = bArr;
        this.zzb = bArr.length;
    }

    @Override // com.google.android.gms.internal.ads.zzhvt
    public final int zzb() {
        throw new UnsupportedOperationException("spaceLeft() can only be called on CodedOutputStreams that are writing to a flat array or ByteBuffer.");
    }

    public final void zzc(byte b8) {
        byte[] bArr = this.zza;
        int i2 = this.zzc;
        bArr[i2] = b8;
        this.zzc = i2 + 1;
        this.zzd++;
    }

    public final void zzd(int i2) {
        if (!zzhvt.zzb) {
            while ((i2 & (-128)) != 0) {
                byte[] bArr = this.zza;
                int i8 = this.zzc;
                this.zzc = i8 + 1;
                bArr[i8] = (byte) (i2 | 128);
                this.zzd++;
                i2 >>>= 7;
            }
            byte[] bArr2 = this.zza;
            int i9 = this.zzc;
            this.zzc = i9 + 1;
            bArr2[i9] = (byte) i2;
            this.zzd++;
            return;
        }
        long j = this.zzc;
        while ((i2 & (-128)) != 0) {
            byte[] bArr3 = this.zza;
            int i10 = this.zzc;
            this.zzc = i10 + 1;
            zzhzj.zzp(bArr3, i10, (byte) (i2 | 128));
            i2 >>>= 7;
        }
        byte[] bArr4 = this.zza;
        int i11 = this.zzc;
        this.zzc = i11 + 1;
        zzhzj.zzp(bArr4, i11, (byte) i2);
        this.zzd += (int) (((long) this.zzc) - j);
    }

    public final void zze(long j) {
        if (zzhvt.zzb) {
            long j3 = this.zzc;
            while (true) {
                int i2 = (int) j;
                if ((j & (-128)) == 0) {
                    byte[] bArr = this.zza;
                    int i8 = this.zzc;
                    this.zzc = i8 + 1;
                    zzhzj.zzp(bArr, i8, (byte) i2);
                    this.zzd += (int) (((long) this.zzc) - j3);
                    return;
                }
                byte[] bArr2 = this.zza;
                int i9 = this.zzc;
                this.zzc = i9 + 1;
                zzhzj.zzp(bArr2, i9, (byte) (i2 | 128));
                j >>>= 7;
            }
        } else {
            while (true) {
                int i10 = (int) j;
                if ((j & (-128)) == 0) {
                    byte[] bArr3 = this.zza;
                    int i11 = this.zzc;
                    this.zzc = i11 + 1;
                    bArr3[i11] = (byte) i10;
                    this.zzd++;
                    return;
                }
                byte[] bArr4 = this.zza;
                int i12 = this.zzc;
                this.zzc = i12 + 1;
                bArr4[i12] = (byte) (i10 | 128);
                this.zzd++;
                j >>>= 7;
            }
        }
    }

    public final void zzf(int i2) {
        int i8 = this.zzc;
        byte[] bArr = this.zza;
        bArr[i8] = (byte) i2;
        bArr[i8 + 1] = (byte) (i2 >> 8);
        bArr[i8 + 2] = (byte) (i2 >> 16);
        bArr[i8 + 3] = (byte) (i2 >> 24);
        this.zzc = i8 + 4;
        this.zzd += 4;
    }

    public final void zzg(long j) {
        int i2 = this.zzc;
        byte[] bArr = this.zza;
        bArr[i2] = (byte) j;
        bArr[i2 + 1] = (byte) (j >> 8);
        bArr[i2 + 2] = (byte) (j >> 16);
        bArr[i2 + 3] = (byte) (j >> 24);
        bArr[i2 + 4] = (byte) (j >> 32);
        bArr[i2 + 5] = (byte) (j >> 40);
        bArr[i2 + 6] = (byte) (j >> 48);
        bArr[i2 + 7] = (byte) (j >> 56);
        this.zzc = i2 + 8;
        this.zzd += 8;
    }
}
