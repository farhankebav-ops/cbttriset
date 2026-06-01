package com.google.android.gms.internal.ads;

import java.io.IOException;
import java.util.Locale;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes4.dex */
final class zzhvq extends zzhvt {
    private final byte[] zza;
    private final int zzb;
    private int zzc;

    public zzhvq(byte[] bArr, int i2, int i8) {
        super(null);
        int length = bArr.length;
        if (((length - i8) | i8) < 0) {
            Locale locale = Locale.US;
            throw new IllegalArgumentException(androidx.camera.core.processing.util.a.i("Array range is invalid. Buffer.length=", length, ", offset=0, length=", i8));
        }
        this.zza = bArr;
        this.zzc = 0;
        this.zzb = i8;
    }

    @Override // com.google.android.gms.internal.ads.zzhvt
    public final void zzJ(int i2, int i8) throws IOException {
        zzs((i2 << 3) | i8);
    }

    @Override // com.google.android.gms.internal.ads.zzhvt
    public final void zzK(int i2, int i8) throws IOException {
        zzs(i2 << 3);
        zzr(i8);
    }

    @Override // com.google.android.gms.internal.ads.zzhvt
    public final void zzL(int i2, int i8) throws IOException {
        zzs(i2 << 3);
        zzs(i8);
    }

    @Override // com.google.android.gms.internal.ads.zzhvt
    public final void zzM(int i2, int i8) throws IOException {
        zzs((i2 << 3) | 5);
        zzt(i8);
    }

    @Override // com.google.android.gms.internal.ads.zzhvt
    public final void zzN(int i2, long j) throws IOException {
        zzs(i2 << 3);
        zzu(j);
    }

    @Override // com.google.android.gms.internal.ads.zzhvt, com.google.android.gms.internal.ads.zzhuz
    public final void zza(byte[] bArr, int i2, int i8) throws IOException {
        zzw(bArr, i2, i8);
    }

    @Override // com.google.android.gms.internal.ads.zzhvt
    public final int zzb() {
        return this.zzb - this.zzc;
    }

    @Override // com.google.android.gms.internal.ads.zzhvt
    public final void zzh(int i2, long j) throws IOException {
        zzs((i2 << 3) | 1);
        zzv(j);
    }

    @Override // com.google.android.gms.internal.ads.zzhvt
    public final void zzi(int i2, boolean z2) throws IOException {
        zzs(i2 << 3);
        zzq(z2 ? (byte) 1 : (byte) 0);
    }

    @Override // com.google.android.gms.internal.ads.zzhvt
    public final void zzj(int i2, String str) throws IOException {
        zzs((i2 << 3) | 2);
        zzx(str);
    }

    @Override // com.google.android.gms.internal.ads.zzhvt
    public final void zzk(int i2, zzhvi zzhviVar) throws IOException {
        zzs((i2 << 3) | 2);
        zzl(zzhviVar);
    }

    @Override // com.google.android.gms.internal.ads.zzhvt
    public final void zzl(zzhvi zzhviVar) throws IOException {
        zzs(zzhviVar.zzc());
        zzhviVar.zzk(this);
    }

    @Override // com.google.android.gms.internal.ads.zzhvt
    public final void zzm(byte[] bArr, int i2, int i8) throws IOException {
        zzs(i8);
        zzw(bArr, 0, i8);
    }

    @Override // com.google.android.gms.internal.ads.zzhvt
    public final void zzn(int i2, zzhxz zzhxzVar) throws IOException {
        zzs(11);
        zzL(2, i2);
        zzs(26);
        zzp(zzhxzVar);
        zzs(12);
    }

    @Override // com.google.android.gms.internal.ads.zzhvt
    public final void zzo(int i2, zzhvi zzhviVar) throws IOException {
        zzs(11);
        zzL(2, i2);
        zzk(3, zzhviVar);
        zzs(12);
    }

    @Override // com.google.android.gms.internal.ads.zzhvt
    public final void zzp(zzhxz zzhxzVar) throws IOException {
        zzs(zzhxzVar.zzbr());
        zzhxzVar.zzdc(this);
    }

    @Override // com.google.android.gms.internal.ads.zzhvt
    public final void zzq(byte b8) throws IOException {
        int i2;
        int i8 = this.zzc;
        try {
            i2 = i8 + 1;
        } catch (IndexOutOfBoundsException e) {
            e = e;
        }
        try {
            this.zza[i8] = b8;
            this.zzc = i2;
        } catch (IndexOutOfBoundsException e4) {
            e = e4;
            i8 = i2;
            throw new zzhvr(i8, this.zzb, 1, e);
        }
    }

    @Override // com.google.android.gms.internal.ads.zzhvt
    public final void zzr(int i2) throws IOException {
        if (i2 >= 0) {
            zzs(i2);
        } else {
            zzu(i2);
        }
    }

    @Override // com.google.android.gms.internal.ads.zzhvt
    public final void zzs(int i2) throws IOException {
        int i8;
        IndexOutOfBoundsException indexOutOfBoundsException;
        int i9 = this.zzc;
        while ((i2 & (-128)) != 0) {
            try {
                i8 = i9 + 1;
            } catch (IndexOutOfBoundsException e) {
                indexOutOfBoundsException = e;
                throw new zzhvr(i9, this.zzb, 1, indexOutOfBoundsException);
            }
            try {
                this.zza[i9] = (byte) (i2 | 128);
                i2 >>>= 7;
                i9 = i8;
            } catch (IndexOutOfBoundsException e4) {
                indexOutOfBoundsException = e4;
                i9 = i8;
                throw new zzhvr(i9, this.zzb, 1, indexOutOfBoundsException);
            }
        }
        i8 = i9 + 1;
        this.zza[i9] = (byte) i2;
        this.zzc = i8;
    }

    @Override // com.google.android.gms.internal.ads.zzhvt
    public final void zzt(int i2) throws IOException {
        int i8 = this.zzc;
        try {
            byte[] bArr = this.zza;
            bArr[i8] = (byte) i2;
            bArr[i8 + 1] = (byte) (i2 >> 8);
            bArr[i8 + 2] = (byte) (i2 >> 16);
            bArr[i8 + 3] = (byte) (i2 >> 24);
            this.zzc = i8 + 4;
        } catch (IndexOutOfBoundsException e) {
            throw new zzhvr(i8, this.zzb, 4, e);
        }
    }

    @Override // com.google.android.gms.internal.ads.zzhvt
    public final void zzu(long j) throws IOException {
        int i2;
        IndexOutOfBoundsException indexOutOfBoundsException;
        int i8;
        boolean z2 = zzhvt.zzb;
        int i9 = this.zzc;
        if (!z2 || this.zzb - i9 < 10) {
            while ((j & (-128)) != 0) {
                try {
                    i8 = i9 + 1;
                } catch (IndexOutOfBoundsException e) {
                    indexOutOfBoundsException = e;
                }
                try {
                    this.zza[i9] = (byte) (((int) j) | 128);
                    j >>>= 7;
                    i9 = i8;
                } catch (IndexOutOfBoundsException e4) {
                    indexOutOfBoundsException = e4;
                    i9 = i8;
                    throw new zzhvr(i9, this.zzb, 1, indexOutOfBoundsException);
                }
            }
            i2 = i9 + 1;
            try {
                this.zza[i9] = (byte) j;
            } catch (IndexOutOfBoundsException e8) {
                indexOutOfBoundsException = e8;
                i9 = i2;
                throw new zzhvr(i9, this.zzb, 1, indexOutOfBoundsException);
            }
        } else {
            while ((j & (-128)) != 0) {
                zzhzj.zzp(this.zza, i9, (byte) (((int) j) | 128));
                j >>>= 7;
                i9++;
            }
            i2 = i9 + 1;
            zzhzj.zzp(this.zza, i9, (byte) j);
        }
        this.zzc = i2;
    }

    @Override // com.google.android.gms.internal.ads.zzhvt
    public final void zzv(long j) throws IOException {
        int i2 = this.zzc;
        try {
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
        } catch (IndexOutOfBoundsException e) {
            throw new zzhvr(i2, this.zzb, 8, e);
        }
    }

    public final void zzw(byte[] bArr, int i2, int i8) throws IOException {
        try {
            System.arraycopy(bArr, i2, this.zza, this.zzc, i8);
            this.zzc += i8;
        } catch (IndexOutOfBoundsException e) {
            throw new zzhvr(this.zzc, this.zzb, i8, e);
        }
    }

    @Override // com.google.android.gms.internal.ads.zzhvt
    public final void zzx(String str) throws IOException {
        int i2 = this.zzc;
        try {
            int iZzA = zzhvt.zzA(str.length() * 3);
            int iZzA2 = zzhvt.zzA(str.length());
            if (iZzA2 != iZzA) {
                zzs(zzhzo.zzc(str));
                byte[] bArr = this.zza;
                int i8 = this.zzc;
                this.zzc = zzhzo.zzd(str, bArr, i8, this.zzb - i8);
                return;
            }
            int i9 = i2 + iZzA2;
            this.zzc = i9;
            int iZzd = zzhzo.zzd(str, this.zza, i9, this.zzb - i9);
            this.zzc = i2;
            zzs((iZzd - i2) - iZzA2);
            this.zzc = iZzd;
        } catch (zzhzn e) {
            this.zzc = i2;
            zzF(str, e);
        } catch (IndexOutOfBoundsException e4) {
            throw new zzhvr(e4);
        }
    }

    @Override // com.google.android.gms.internal.ads.zzhvt
    public final void zzy() {
    }
}
