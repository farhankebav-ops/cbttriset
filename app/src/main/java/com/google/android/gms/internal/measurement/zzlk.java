package com.google.android.gms.internal.measurement;

import java.io.IOException;
import java.util.Locale;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes4.dex */
final class zzlk extends zzlm {
    private final byte[] zzc;
    private final int zzd;
    private int zze;

    public zzlk(byte[] bArr, int i2, int i8) {
        super(null);
        int length = bArr.length;
        if (((length - i8) | i8) < 0) {
            Locale locale = Locale.US;
            throw new IllegalArgumentException(androidx.camera.core.processing.util.a.i("Array range is invalid. Buffer.length=", length, ", offset=0, length=", i8));
        }
        this.zzc = bArr;
        this.zze = 0;
        this.zzd = i8;
    }

    @Override // com.google.android.gms.internal.measurement.zzlm
    public final void zza(int i2, int i8) throws IOException {
        zzr((i2 << 3) | i8);
    }

    @Override // com.google.android.gms.internal.measurement.zzlm
    public final void zzb(int i2, int i8) throws IOException {
        zzr(i2 << 3);
        zzq(i8);
    }

    @Override // com.google.android.gms.internal.measurement.zzlm
    public final void zzc(int i2, int i8) throws IOException {
        zzr(i2 << 3);
        zzr(i8);
    }

    @Override // com.google.android.gms.internal.measurement.zzlm
    public final void zzd(int i2, int i8) throws IOException {
        zzr((i2 << 3) | 5);
        zzs(i8);
    }

    @Override // com.google.android.gms.internal.measurement.zzlm
    public final void zze(int i2, long j) throws IOException {
        zzr(i2 << 3);
        zzt(j);
    }

    @Override // com.google.android.gms.internal.measurement.zzlm
    public final void zzf(int i2, long j) throws IOException {
        zzr((i2 << 3) | 1);
        zzu(j);
    }

    @Override // com.google.android.gms.internal.measurement.zzlm
    public final void zzg(int i2, boolean z2) throws IOException {
        zzr(i2 << 3);
        zzp(z2 ? (byte) 1 : (byte) 0);
    }

    @Override // com.google.android.gms.internal.measurement.zzlm
    public final void zzh(int i2, String str) throws IOException {
        zzr((i2 << 3) | 2);
        zzx(str);
    }

    @Override // com.google.android.gms.internal.measurement.zzlm
    public final void zzi(int i2, zzlh zzlhVar) throws IOException {
        zzr((i2 << 3) | 2);
        zzj(zzlhVar);
    }

    @Override // com.google.android.gms.internal.measurement.zzlm
    public final void zzj(zzlh zzlhVar) throws IOException {
        zzr(zzlhVar.zzc());
        zzlhVar.zzf(this);
    }

    @Override // com.google.android.gms.internal.measurement.zzlm
    public final void zzk(byte[] bArr, int i2, int i8) throws IOException {
        zzr(i8);
        zzv(bArr, 0, i8);
    }

    @Override // com.google.android.gms.internal.measurement.zzlm
    public final void zzl(int i2, zznm zznmVar, zznx zznxVar) throws IOException {
        zzr((i2 << 3) | 2);
        zzr(((zzks) zznmVar).zzcd(zznxVar));
        zznxVar.zzf(zznmVar, this.zza);
    }

    @Override // com.google.android.gms.internal.measurement.zzlm
    public final void zzm(int i2, zznm zznmVar) throws IOException {
        zzr(11);
        zzc(2, i2);
        zzr(26);
        zzo(zznmVar);
        zzr(12);
    }

    @Override // com.google.android.gms.internal.measurement.zzlm
    public final void zzn(int i2, zzlh zzlhVar) throws IOException {
        zzr(11);
        zzc(2, i2);
        zzi(3, zzlhVar);
        zzr(12);
    }

    @Override // com.google.android.gms.internal.measurement.zzlm
    public final void zzo(zznm zznmVar) throws IOException {
        zzr(zznmVar.zzcn());
        zznmVar.zzcB(this);
    }

    @Override // com.google.android.gms.internal.measurement.zzlm
    public final void zzp(byte b8) throws IOException {
        int i2;
        int i8 = this.zze;
        try {
            i2 = i8 + 1;
        } catch (IndexOutOfBoundsException e) {
            e = e;
        }
        try {
            this.zzc[i8] = b8;
            this.zze = i2;
        } catch (IndexOutOfBoundsException e4) {
            e = e4;
            i8 = i2;
            throw new zzll(i8, this.zzd, 1, e);
        }
    }

    @Override // com.google.android.gms.internal.measurement.zzlm
    public final void zzq(int i2) throws IOException {
        if (i2 >= 0) {
            zzr(i2);
        } else {
            zzt(i2);
        }
    }

    @Override // com.google.android.gms.internal.measurement.zzlm
    public final void zzr(int i2) throws IOException {
        int i8;
        IndexOutOfBoundsException indexOutOfBoundsException;
        int i9 = this.zze;
        while ((i2 & (-128)) != 0) {
            try {
                i8 = i9 + 1;
            } catch (IndexOutOfBoundsException e) {
                indexOutOfBoundsException = e;
                throw new zzll(i9, this.zzd, 1, indexOutOfBoundsException);
            }
            try {
                this.zzc[i9] = (byte) (i2 | 128);
                i2 >>>= 7;
                i9 = i8;
            } catch (IndexOutOfBoundsException e4) {
                indexOutOfBoundsException = e4;
                i9 = i8;
                throw new zzll(i9, this.zzd, 1, indexOutOfBoundsException);
            }
        }
        i8 = i9 + 1;
        this.zzc[i9] = (byte) i2;
        this.zze = i8;
    }

    @Override // com.google.android.gms.internal.measurement.zzlm
    public final void zzs(int i2) throws IOException {
        int i8 = this.zze;
        try {
            byte[] bArr = this.zzc;
            bArr[i8] = (byte) i2;
            bArr[i8 + 1] = (byte) (i2 >> 8);
            bArr[i8 + 2] = (byte) (i2 >> 16);
            bArr[i8 + 3] = (byte) (i2 >> 24);
            this.zze = i8 + 4;
        } catch (IndexOutOfBoundsException e) {
            throw new zzll(i8, this.zzd, 4, e);
        }
    }

    @Override // com.google.android.gms.internal.measurement.zzlm
    public final void zzt(long j) throws IOException {
        int i2;
        IndexOutOfBoundsException indexOutOfBoundsException;
        int i8;
        boolean z2 = zzlm.zzd;
        int i9 = this.zze;
        if (!z2 || this.zzd - i9 < 10) {
            while ((j & (-128)) != 0) {
                try {
                    i8 = i9 + 1;
                } catch (IndexOutOfBoundsException e) {
                    indexOutOfBoundsException = e;
                }
                try {
                    this.zzc[i9] = (byte) (((int) j) | 128);
                    j >>>= 7;
                    i9 = i8;
                } catch (IndexOutOfBoundsException e4) {
                    indexOutOfBoundsException = e4;
                    i9 = i8;
                    throw new zzll(i9, this.zzd, 1, indexOutOfBoundsException);
                }
            }
            i2 = i9 + 1;
            try {
                this.zzc[i9] = (byte) j;
            } catch (IndexOutOfBoundsException e8) {
                indexOutOfBoundsException = e8;
                i9 = i2;
                throw new zzll(i9, this.zzd, 1, indexOutOfBoundsException);
            }
        } else {
            while ((j & (-128)) != 0) {
                zzop.zzp(this.zzc, i9, (byte) (((int) j) | 128));
                j >>>= 7;
                i9++;
            }
            i2 = i9 + 1;
            zzop.zzp(this.zzc, i9, (byte) j);
        }
        this.zze = i2;
    }

    @Override // com.google.android.gms.internal.measurement.zzlm
    public final void zzu(long j) throws IOException {
        int i2 = this.zze;
        try {
            byte[] bArr = this.zzc;
            bArr[i2] = (byte) j;
            bArr[i2 + 1] = (byte) (j >> 8);
            bArr[i2 + 2] = (byte) (j >> 16);
            bArr[i2 + 3] = (byte) (j >> 24);
            bArr[i2 + 4] = (byte) (j >> 32);
            bArr[i2 + 5] = (byte) (j >> 40);
            bArr[i2 + 6] = (byte) (j >> 48);
            bArr[i2 + 7] = (byte) (j >> 56);
            this.zze = i2 + 8;
        } catch (IndexOutOfBoundsException e) {
            throw new zzll(i2, this.zzd, 8, e);
        }
    }

    public final void zzv(byte[] bArr, int i2, int i8) throws IOException {
        try {
            System.arraycopy(bArr, 0, this.zzc, this.zze, i8);
            this.zze += i8;
        } catch (IndexOutOfBoundsException e) {
            throw new zzll(this.zze, this.zzd, i8, e);
        }
    }

    @Override // com.google.android.gms.internal.measurement.zzlm
    public final void zzw(byte[] bArr, int i2, int i8) throws IOException {
        zzv(bArr, 0, i8);
    }

    @Override // com.google.android.gms.internal.measurement.zzlm
    public final void zzx(String str) throws IOException {
        int i2 = this.zze;
        try {
            int iZzz = zzlm.zzz(str.length() * 3);
            int iZzz2 = zzlm.zzz(str.length());
            if (iZzz2 != iZzz) {
                zzr(zzos.zzb(str));
                byte[] bArr = this.zzc;
                int i8 = this.zze;
                this.zze = zzos.zzc(str, bArr, i8, this.zzd - i8);
                return;
            }
            int i9 = i2 + iZzz2;
            this.zze = i9;
            int iZzc = zzos.zzc(str, this.zzc, i9, this.zzd - i9);
            this.zze = i2;
            zzr((iZzc - i2) - iZzz2);
            this.zze = iZzc;
        } catch (zzor e) {
            this.zze = i2;
            zzF(str, e);
        } catch (IndexOutOfBoundsException e4) {
            throw new zzll(e4);
        }
    }

    @Override // com.google.android.gms.internal.measurement.zzlm
    public final int zzy() {
        return this.zzd - this.zze;
    }
}
