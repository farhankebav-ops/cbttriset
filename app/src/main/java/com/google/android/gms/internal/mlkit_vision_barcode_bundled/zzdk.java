package com.google.android.gms.internal.mlkit_vision_barcode_bundled;

import java.io.IOException;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes4.dex */
final class zzdk extends zzdn {
    private final byte[] zzb;
    private final int zzc;
    private int zzd;

    public zzdk(byte[] bArr, int i2, int i8) {
        super(null);
        int length = bArr.length;
        if (((length - i8) | i8) < 0) {
            throw new IllegalArgumentException(String.format("Array range is invalid. Buffer.length=%d, offset=%d, length=%d", Integer.valueOf(length), 0, Integer.valueOf(i8)));
        }
        this.zzb = bArr;
        this.zzd = 0;
        this.zzc = i8;
    }

    @Override // com.google.android.gms.internal.mlkit_vision_barcode_bundled.zzdn
    public final int zza() {
        return this.zzc - this.zzd;
    }

    @Override // com.google.android.gms.internal.mlkit_vision_barcode_bundled.zzdn
    public final void zzb(byte b8) throws IOException {
        try {
            byte[] bArr = this.zzb;
            int i2 = this.zzd;
            this.zzd = i2 + 1;
            bArr[i2] = b8;
        } catch (IndexOutOfBoundsException e) {
            throw new zzdl(String.format("Pos: %d, limit: %d, len: %d", Integer.valueOf(this.zzd), Integer.valueOf(this.zzc), 1), e);
        }
    }

    public final void zzc(byte[] bArr, int i2, int i8) throws IOException {
        try {
            System.arraycopy(bArr, i2, this.zzb, this.zzd, i8);
            this.zzd += i8;
        } catch (IndexOutOfBoundsException e) {
            throw new zzdl(String.format("Pos: %d, limit: %d, len: %d", Integer.valueOf(this.zzd), Integer.valueOf(this.zzc), Integer.valueOf(i8)), e);
        }
    }

    @Override // com.google.android.gms.internal.mlkit_vision_barcode_bundled.zzdn
    public final void zzd(int i2, boolean z2) throws IOException {
        zzt(i2 << 3);
        zzb(z2 ? (byte) 1 : (byte) 0);
    }

    @Override // com.google.android.gms.internal.mlkit_vision_barcode_bundled.zzdn
    public final void zze(int i2, zzdf zzdfVar) throws IOException {
        zzt((i2 << 3) | 2);
        zzt(zzdfVar.zzd());
        zzdfVar.zzm(this);
    }

    @Override // com.google.android.gms.internal.mlkit_vision_barcode_bundled.zzdn
    public final void zzf(int i2, int i8) throws IOException {
        zzt((i2 << 3) | 5);
        zzg(i8);
    }

    @Override // com.google.android.gms.internal.mlkit_vision_barcode_bundled.zzdn
    public final void zzg(int i2) throws IOException {
        try {
            byte[] bArr = this.zzb;
            int i8 = this.zzd;
            int i9 = i8 + 1;
            this.zzd = i9;
            bArr[i8] = (byte) (i2 & 255);
            int i10 = i8 + 2;
            this.zzd = i10;
            bArr[i9] = (byte) ((i2 >> 8) & 255);
            int i11 = i8 + 3;
            this.zzd = i11;
            bArr[i10] = (byte) ((i2 >> 16) & 255);
            this.zzd = i8 + 4;
            bArr[i11] = (byte) ((i2 >> 24) & 255);
        } catch (IndexOutOfBoundsException e) {
            throw new zzdl(String.format("Pos: %d, limit: %d, len: %d", Integer.valueOf(this.zzd), Integer.valueOf(this.zzc), 1), e);
        }
    }

    @Override // com.google.android.gms.internal.mlkit_vision_barcode_bundled.zzdn
    public final void zzh(int i2, long j) throws IOException {
        zzt((i2 << 3) | 1);
        zzi(j);
    }

    @Override // com.google.android.gms.internal.mlkit_vision_barcode_bundled.zzdn
    public final void zzi(long j) throws IOException {
        try {
            byte[] bArr = this.zzb;
            int i2 = this.zzd;
            int i8 = i2 + 1;
            this.zzd = i8;
            bArr[i2] = (byte) (((int) j) & 255);
            int i9 = i2 + 2;
            this.zzd = i9;
            bArr[i8] = (byte) (((int) (j >> 8)) & 255);
            int i10 = i2 + 3;
            this.zzd = i10;
            bArr[i9] = (byte) (((int) (j >> 16)) & 255);
            int i11 = i2 + 4;
            this.zzd = i11;
            bArr[i10] = (byte) (((int) (j >> 24)) & 255);
            int i12 = i2 + 5;
            this.zzd = i12;
            bArr[i11] = (byte) (((int) (j >> 32)) & 255);
            int i13 = i2 + 6;
            this.zzd = i13;
            bArr[i12] = (byte) (((int) (j >> 40)) & 255);
            int i14 = i2 + 7;
            this.zzd = i14;
            bArr[i13] = (byte) (((int) (j >> 48)) & 255);
            this.zzd = i2 + 8;
            bArr[i14] = (byte) (((int) (j >> 56)) & 255);
        } catch (IndexOutOfBoundsException e) {
            throw new zzdl(String.format("Pos: %d, limit: %d, len: %d", Integer.valueOf(this.zzd), Integer.valueOf(this.zzc), 1), e);
        }
    }

    @Override // com.google.android.gms.internal.mlkit_vision_barcode_bundled.zzdn
    public final void zzj(int i2, int i8) throws IOException {
        zzt(i2 << 3);
        zzk(i8);
    }

    @Override // com.google.android.gms.internal.mlkit_vision_barcode_bundled.zzdn
    public final void zzk(int i2) throws IOException {
        if (i2 >= 0) {
            zzt(i2);
        } else {
            zzv(i2);
        }
    }

    @Override // com.google.android.gms.internal.mlkit_vision_barcode_bundled.zzdn
    public final void zzl(byte[] bArr, int i2, int i8) throws IOException {
        zzc(bArr, 0, i8);
    }

    @Override // com.google.android.gms.internal.mlkit_vision_barcode_bundled.zzdn
    public final void zzm(int i2, zzfm zzfmVar, zzge zzgeVar) throws IOException {
        zzt((i2 << 3) | 2);
        zzt(((zzcq) zzfmVar).zzB(zzgeVar));
        zzgeVar.zzi(zzfmVar, this.zza);
    }

    @Override // com.google.android.gms.internal.mlkit_vision_barcode_bundled.zzdn
    public final void zzn(int i2, zzfm zzfmVar) throws IOException {
        zzt(11);
        zzs(2, i2);
        zzt(26);
        zzt(zzfmVar.zzF());
        zzfmVar.zzab(this);
        zzt(12);
    }

    @Override // com.google.android.gms.internal.mlkit_vision_barcode_bundled.zzdn
    public final void zzo(int i2, zzdf zzdfVar) throws IOException {
        zzt(11);
        zzs(2, i2);
        zze(3, zzdfVar);
        zzt(12);
    }

    @Override // com.google.android.gms.internal.mlkit_vision_barcode_bundled.zzdn
    public final void zzp(int i2, String str) throws IOException {
        zzt((i2 << 3) | 2);
        zzq(str);
    }

    public final void zzq(String str) throws IOException {
        int i2 = this.zzd;
        try {
            int iZzA = zzdn.zzA(str.length() * 3);
            int iZzA2 = zzdn.zzA(str.length());
            if (iZzA2 != iZzA) {
                zzt(zzhe.zze(str));
                byte[] bArr = this.zzb;
                int i8 = this.zzd;
                this.zzd = zzhe.zzd(str, bArr, i8, this.zzc - i8);
                return;
            }
            int i9 = i2 + iZzA2;
            this.zzd = i9;
            int iZzd = zzhe.zzd(str, this.zzb, i9, this.zzc - i9);
            this.zzd = i2;
            zzt((iZzd - i2) - iZzA2);
            this.zzd = iZzd;
        } catch (zzhd e) {
            this.zzd = i2;
            zzD(str, e);
        } catch (IndexOutOfBoundsException e4) {
            throw new zzdl(e4);
        }
    }

    @Override // com.google.android.gms.internal.mlkit_vision_barcode_bundled.zzdn
    public final void zzr(int i2, int i8) throws IOException {
        zzt((i2 << 3) | i8);
    }

    @Override // com.google.android.gms.internal.mlkit_vision_barcode_bundled.zzdn
    public final void zzs(int i2, int i8) throws IOException {
        zzt(i2 << 3);
        zzt(i8);
    }

    @Override // com.google.android.gms.internal.mlkit_vision_barcode_bundled.zzdn
    public final void zzt(int i2) throws IOException {
        while ((i2 & (-128)) != 0) {
            try {
                byte[] bArr = this.zzb;
                int i8 = this.zzd;
                this.zzd = i8 + 1;
                bArr[i8] = (byte) ((i2 | 128) & 255);
                i2 >>>= 7;
            } catch (IndexOutOfBoundsException e) {
                throw new zzdl(String.format("Pos: %d, limit: %d, len: %d", Integer.valueOf(this.zzd), Integer.valueOf(this.zzc), 1), e);
            }
        }
        byte[] bArr2 = this.zzb;
        int i9 = this.zzd;
        this.zzd = i9 + 1;
        bArr2[i9] = (byte) i2;
    }

    @Override // com.google.android.gms.internal.mlkit_vision_barcode_bundled.zzdn
    public final void zzu(int i2, long j) throws IOException {
        zzt(i2 << 3);
        zzv(j);
    }

    @Override // com.google.android.gms.internal.mlkit_vision_barcode_bundled.zzdn
    public final void zzv(long j) throws IOException {
        if (!zzdn.zzc || this.zzc - this.zzd < 10) {
            while ((j & (-128)) != 0) {
                try {
                    byte[] bArr = this.zzb;
                    int i2 = this.zzd;
                    this.zzd = i2 + 1;
                    bArr[i2] = (byte) ((((int) j) | 128) & 255);
                    j >>>= 7;
                } catch (IndexOutOfBoundsException e) {
                    throw new zzdl(String.format("Pos: %d, limit: %d, len: %d", Integer.valueOf(this.zzd), Integer.valueOf(this.zzc), 1), e);
                }
            }
            byte[] bArr2 = this.zzb;
            int i8 = this.zzd;
            this.zzd = i8 + 1;
            bArr2[i8] = (byte) j;
            return;
        }
        while (true) {
            int i9 = (int) j;
            if ((j & (-128)) == 0) {
                byte[] bArr3 = this.zzb;
                int i10 = this.zzd;
                this.zzd = i10 + 1;
                zzgz.zzn(bArr3, i10, (byte) i9);
                return;
            }
            byte[] bArr4 = this.zzb;
            int i11 = this.zzd;
            this.zzd = i11 + 1;
            zzgz.zzn(bArr4, i11, (byte) ((i9 | 128) & 255));
            j >>>= 7;
        }
    }
}
