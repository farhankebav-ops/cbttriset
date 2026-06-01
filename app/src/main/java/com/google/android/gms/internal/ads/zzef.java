package com.google.android.gms.internal.ads;

import androidx.core.view.MotionEventCompat;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes4.dex */
public final class zzef {
    public byte[] zza;
    private int zzb;
    private int zzc;
    private int zzd;

    public zzef(byte[] bArr, int i2) {
        this.zza = bArr;
        this.zzd = i2;
    }

    private final void zzq() {
        int i2;
        int i8 = this.zzb;
        boolean z2 = false;
        if (i8 >= 0 && (i8 < (i2 = this.zzd) || (i8 == i2 && this.zzc == 0))) {
            z2 = true;
        }
        zzgmd.zzh(z2);
    }

    public final void zza(zzeg zzegVar) {
        zzb(zzegVar.zzi(), zzegVar.zze());
        zzf(zzegVar.zzg() * 8);
    }

    public final void zzb(byte[] bArr, int i2) {
        this.zza = bArr;
        this.zzb = 0;
        this.zzc = 0;
        this.zzd = i2;
    }

    public final int zzc() {
        return ((this.zzd - this.zzb) * 8) - this.zzc;
    }

    public final int zzd() {
        return (this.zzb * 8) + this.zzc;
    }

    public final int zze() {
        zzgmd.zzh(this.zzc == 0);
        return this.zzb;
    }

    public final void zzf(int i2) {
        int i8 = i2 / 8;
        this.zzb = i8;
        this.zzc = i2 - (i8 * 8);
        zzq();
    }

    public final void zzg() {
        int i2 = this.zzc + 1;
        this.zzc = i2;
        if (i2 == 8) {
            this.zzc = 0;
            this.zzb++;
        }
        zzq();
    }

    public final void zzh(int i2) {
        int i8 = i2 / 8;
        int i9 = this.zzb + i8;
        this.zzb = i9;
        int i10 = (i2 - (i8 * 8)) + this.zzc;
        this.zzc = i10;
        if (i10 > 7) {
            this.zzb = i9 + 1;
            this.zzc = i10 - 8;
        }
        zzq();
    }

    public final boolean zzi() {
        int i2 = this.zza[this.zzb] & (128 >> this.zzc);
        zzg();
        return i2 != 0;
    }

    public final int zzj(int i2) {
        int i8;
        if (i2 == 0) {
            return 0;
        }
        this.zzc += i2;
        int i9 = 0;
        while (true) {
            i8 = this.zzc;
            if (i8 <= 8) {
                break;
            }
            int i10 = i8 - 8;
            this.zzc = i10;
            byte[] bArr = this.zza;
            int i11 = this.zzb;
            this.zzb = i11 + 1;
            i9 |= (bArr[i11] & 255) << i10;
        }
        byte[] bArr2 = this.zza;
        int i12 = this.zzb;
        int i13 = i9 | ((bArr2[i12] & 255) >> (8 - i8));
        int i14 = 32 - i2;
        if (i8 == 8) {
            this.zzc = 0;
            this.zzb = i12 + 1;
        }
        int i15 = ((-1) >>> i14) & i13;
        zzq();
        return i15;
    }

    public final long zzk(int i2) {
        if (i2 <= 32) {
            int iZzj = zzj(i2);
            String str = zzep.zza;
            return 4294967295L & ((long) iZzj);
        }
        int iZzj2 = zzj(i2 - 32);
        int iZzj3 = zzj(32);
        String str2 = zzep.zza;
        return (4294967295L & ((long) iZzj3)) | ((((long) iZzj2) & 4294967295L) << 32);
    }

    public final void zzl(byte[] bArr, int i2, int i8) {
        int i9;
        int i10 = 0;
        while (true) {
            i9 = i8 >> 3;
            if (i10 >= i9) {
                break;
            }
            byte[] bArr2 = this.zza;
            int i11 = this.zzb;
            int i12 = i11 + 1;
            this.zzb = i12;
            byte b8 = bArr2[i11];
            int i13 = this.zzc;
            byte b9 = (byte) (b8 << i13);
            bArr[i10] = b9;
            bArr[i10] = (byte) (((bArr2[i12] & 255) >> (8 - i13)) | b9);
            i10++;
        }
        int i14 = i8 & 7;
        if (i14 == 0) {
            return;
        }
        byte b10 = (byte) (bArr[i9] & (255 >> i14));
        bArr[i9] = b10;
        int i15 = this.zzc;
        if (i15 + i14 > 8) {
            byte[] bArr3 = this.zza;
            int i16 = this.zzb;
            this.zzb = i16 + 1;
            b10 = (byte) (b10 | ((bArr3[i16] & 255) << i15));
            bArr[i9] = b10;
            i15 -= 8;
        }
        int i17 = i15 + i14;
        this.zzc = i17;
        byte[] bArr4 = this.zza;
        int i18 = this.zzb;
        bArr[i9] = (byte) (((byte) (((255 & bArr4[i18]) >> (8 - i17)) << (8 - i14))) | b10);
        if (i17 == 8) {
            this.zzc = 0;
            this.zzb = i18 + 1;
        }
        zzq();
    }

    public final void zzm() {
        if (this.zzc == 0) {
            return;
        }
        this.zzc = 0;
        this.zzb++;
        zzq();
    }

    public final void zzn(byte[] bArr, int i2, int i8) {
        zzgmd.zzh(this.zzc == 0);
        System.arraycopy(this.zza, this.zzb, bArr, 0, i8);
        this.zzb += i8;
        zzq();
    }

    public final void zzo(int i2) {
        zzgmd.zzh(this.zzc == 0);
        this.zzb += i2;
        zzq();
    }

    public final void zzp(int i2, int i8) {
        int iMin = Math.min(8 - this.zzc, 14);
        int i9 = this.zzc;
        int i10 = (8 - i9) - iMin;
        int i11 = MotionEventCompat.ACTION_POINTER_INDEX_MASK >> i9;
        byte[] bArr = this.zza;
        int i12 = this.zzb;
        byte b8 = (byte) ((i11 | ((1 << i10) - 1)) & bArr[i12]);
        bArr[i12] = b8;
        int i13 = 14 - iMin;
        int i14 = i2 & 16383;
        bArr[i12] = (byte) (b8 | ((i14 >>> i13) << i10));
        int i15 = i12 + 1;
        while (i13 > 8) {
            i13 -= 8;
            this.zza[i15] = (byte) (i14 >>> i13);
            i15++;
        }
        byte[] bArr2 = this.zza;
        byte b9 = (byte) (bArr2[i15] & ((1 << r0) - 1));
        bArr2[i15] = b9;
        bArr2[i15] = (byte) (((i14 & ((1 << i13) - 1)) << (8 - i13)) | b9);
        zzh(14);
        zzq();
    }

    public zzef() {
        this.zza = zzep.zzb;
    }
}
