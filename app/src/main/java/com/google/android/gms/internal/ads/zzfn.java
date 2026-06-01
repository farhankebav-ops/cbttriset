package com.google.android.gms.internal.ads;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes4.dex */
public final class zzfn {
    private byte[] zza;
    private int zzb;
    private int zzc;
    private int zzd = 0;

    public zzfn(byte[] bArr, int i2, int i8) {
        this.zza = bArr;
        this.zzc = i2;
        this.zzb = i8;
        zzk();
    }

    private final int zzi() {
        int i2 = 0;
        while (!zze()) {
            i2++;
        }
        return ((1 << i2) - 1) + (i2 > 0 ? zzf(i2) : 0);
    }

    private final boolean zzj(int i2) {
        if (i2 < 2 || i2 >= this.zzb) {
            return false;
        }
        byte[] bArr = this.zza;
        return bArr[i2] == 3 && bArr[i2 + (-2)] == 0 && bArr[i2 + (-1)] == 0;
    }

    private final void zzk() {
        int i2;
        int i8 = this.zzc;
        boolean z2 = false;
        if (i8 >= 0 && (i8 < (i2 = this.zzb) || (i8 == i2 && this.zzd == 0))) {
            z2 = true;
        }
        zzgmd.zzh(z2);
    }

    public final void zza() {
        int i2 = this.zzd + 1;
        this.zzd = i2;
        if (i2 == 8) {
            this.zzd = 0;
            int i8 = this.zzc;
            this.zzc = i8 + (true == zzj(i8 + 1) ? 2 : 1);
        }
        zzk();
    }

    public final void zzb(int i2) {
        int i8 = this.zzc;
        int i9 = i2 / 8;
        int i10 = i8 + i9;
        this.zzc = i10;
        int i11 = (i2 - (i9 * 8)) + this.zzd;
        this.zzd = i11;
        if (i11 > 7) {
            this.zzc = i10 + 1;
            this.zzd = i11 - 8;
        }
        while (true) {
            i8++;
            if (i8 > this.zzc) {
                zzk();
                return;
            } else if (zzj(i8)) {
                this.zzc++;
                i8 += 2;
            }
        }
    }

    public final void zzc() {
        int i2 = this.zzd;
        if (i2 > 0) {
            zzb(8 - i2);
        }
    }

    public final boolean zzd(int i2) {
        int i8 = this.zzc;
        int i9 = i2 / 8;
        int i10 = i8 + i9;
        int i11 = (this.zzd + i2) - (i9 * 8);
        if (i11 > 7) {
            i10++;
            i11 -= 8;
        }
        while (true) {
            i8++;
            if (i8 > i10 || i10 >= this.zzb) {
                break;
            }
            if (zzj(i8)) {
                i10++;
                i8 += 2;
            }
        }
        int i12 = this.zzb;
        if (i10 >= i12) {
            return i10 == i12 && i11 == 0;
        }
        return true;
    }

    public final boolean zze() {
        int i2 = this.zza[this.zzc] & (128 >> this.zzd);
        zza();
        return i2 != 0;
    }

    public final int zzf(int i2) {
        int i8;
        this.zzd += i2;
        int i9 = 0;
        while (true) {
            i8 = this.zzd;
            if (i8 <= 8) {
                break;
            }
            int i10 = i8 - 8;
            this.zzd = i10;
            byte[] bArr = this.zza;
            int i11 = this.zzc;
            i9 |= (bArr[i11] & 255) << i10;
            if (true != zzj(i11 + 1)) {
                i = 1;
            }
            this.zzc = i11 + i;
        }
        byte[] bArr2 = this.zza;
        int i12 = this.zzc;
        int i13 = i9 | ((bArr2[i12] & 255) >> (8 - i8));
        int i14 = 32 - i2;
        if (i8 == 8) {
            this.zzd = 0;
            this.zzc = i12 + (true != zzj(i12 + 1) ? 1 : 2);
        }
        int i15 = ((-1) >>> i14) & i13;
        zzk();
        return i15;
    }

    public final int zzg() {
        return zzi();
    }

    public final int zzh() {
        int iZzi = zzi();
        int i2 = iZzi % 2;
        return ((iZzi + 1) / 2) * (i2 == 0 ? -1 : 1);
    }
}
