package com.google.android.gms.internal.ads;

import java.io.IOException;
import java.io.OutputStream;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes4.dex */
final class zzhvs extends zzhvp {
    private final OutputStream zzg;

    public zzhvs(OutputStream outputStream, int i2) {
        super(i2);
        if (outputStream == null) {
            throw new NullPointerException("out");
        }
        this.zzg = outputStream;
    }

    private final void zzH(int i2) throws IOException {
        if (this.zzb - this.zzc < i2) {
            zzI();
        }
    }

    private final void zzI() throws IOException {
        this.zzg.write(this.zza, 0, this.zzc);
        this.zzc = 0;
    }

    @Override // com.google.android.gms.internal.ads.zzhvt
    public final void zzJ(int i2, int i8) throws IOException {
        zzs((i2 << 3) | i8);
    }

    @Override // com.google.android.gms.internal.ads.zzhvt
    public final void zzK(int i2, int i8) throws IOException {
        zzH(20);
        zzd(i2 << 3);
        if (i8 >= 0) {
            zzd(i8);
        } else {
            zze(i8);
        }
    }

    @Override // com.google.android.gms.internal.ads.zzhvt
    public final void zzL(int i2, int i8) throws IOException {
        zzH(20);
        zzd(i2 << 3);
        zzd(i8);
    }

    @Override // com.google.android.gms.internal.ads.zzhvt
    public final void zzM(int i2, int i8) throws IOException {
        zzH(14);
        zzd((i2 << 3) | 5);
        zzf(i8);
    }

    @Override // com.google.android.gms.internal.ads.zzhvt
    public final void zzN(int i2, long j) throws IOException {
        zzH(20);
        zzd(i2 << 3);
        zze(j);
    }

    @Override // com.google.android.gms.internal.ads.zzhvt, com.google.android.gms.internal.ads.zzhuz
    public final void zza(byte[] bArr, int i2, int i8) throws IOException {
        zzw(bArr, i2, i8);
    }

    @Override // com.google.android.gms.internal.ads.zzhvt
    public final void zzh(int i2, long j) throws IOException {
        zzH(18);
        zzd((i2 << 3) | 1);
        zzg(j);
    }

    @Override // com.google.android.gms.internal.ads.zzhvt
    public final void zzi(int i2, boolean z2) throws IOException {
        zzH(11);
        zzd(i2 << 3);
        zzc(z2 ? (byte) 1 : (byte) 0);
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
        if (this.zzc == this.zzb) {
            zzI();
        }
        zzc(b8);
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
        zzH(5);
        zzd(i2);
    }

    @Override // com.google.android.gms.internal.ads.zzhvt
    public final void zzt(int i2) throws IOException {
        zzH(4);
        zzf(i2);
    }

    @Override // com.google.android.gms.internal.ads.zzhvt
    public final void zzu(long j) throws IOException {
        zzH(10);
        zze(j);
    }

    @Override // com.google.android.gms.internal.ads.zzhvt
    public final void zzv(long j) throws IOException {
        zzH(8);
        zzg(j);
    }

    public final void zzw(byte[] bArr, int i2, int i8) throws IOException {
        int i9 = this.zzb;
        int i10 = this.zzc;
        int i11 = i9 - i10;
        if (i11 >= i8) {
            System.arraycopy(bArr, i2, this.zza, i10, i8);
            this.zzc += i8;
            this.zzd += i8;
            return;
        }
        byte[] bArr2 = this.zza;
        System.arraycopy(bArr, i2, bArr2, i10, i11);
        int i12 = i2 + i11;
        this.zzc = i9;
        this.zzd += i11;
        zzI();
        int i13 = i8 - i11;
        if (i13 <= i9) {
            System.arraycopy(bArr, i12, bArr2, 0, i13);
            this.zzc = i13;
        } else {
            this.zzg.write(bArr, i12, i13);
        }
        this.zzd += i13;
    }

    @Override // com.google.android.gms.internal.ads.zzhvt
    public final void zzx(String str) throws IOException {
        int iZzc;
        try {
            int length = str.length() * 3;
            int iZzA = zzhvt.zzA(length);
            int i2 = iZzA + length;
            int i8 = this.zzb;
            if (i2 > i8) {
                byte[] bArr = new byte[length];
                int iZzd = zzhzo.zzd(str, bArr, 0, length);
                zzs(iZzd);
                zzw(bArr, 0, iZzd);
                return;
            }
            if (i2 > i8 - this.zzc) {
                zzI();
            }
            int iZzA2 = zzhvt.zzA(str.length());
            int i9 = this.zzc;
            try {
                if (iZzA2 == iZzA) {
                    int i10 = i9 + iZzA2;
                    this.zzc = i10;
                    int iZzd2 = zzhzo.zzd(str, this.zza, i10, i8 - i10);
                    this.zzc = i9;
                    iZzc = (iZzd2 - i9) - iZzA2;
                    zzd(iZzc);
                    this.zzc = iZzd2;
                } else {
                    iZzc = zzhzo.zzc(str);
                    zzd(iZzc);
                    this.zzc = zzhzo.zzd(str, this.zza, this.zzc, iZzc);
                }
                this.zzd += iZzc;
            } catch (zzhzn e) {
                this.zzd -= this.zzc - i9;
                this.zzc = i9;
                throw e;
            } catch (ArrayIndexOutOfBoundsException e4) {
                throw new zzhvr(e4);
            }
        } catch (zzhzn e8) {
            zzF(str, e8);
        }
    }

    @Override // com.google.android.gms.internal.ads.zzhvt
    public final void zzy() throws IOException {
        if (this.zzc > 0) {
            zzI();
        }
    }
}
