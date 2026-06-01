package com.google.android.gms.internal.ads;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes4.dex */
public final class zzaeo {
    private final byte[] zza;
    private final int zzb;
    private int zzc;
    private int zzd;

    public zzaeo(byte[] bArr) {
        this.zza = bArr;
        this.zzb = bArr.length;
    }

    public final boolean zza() {
        int i2 = (this.zza[this.zzc] & 255) >> this.zzd;
        zzc(1);
        return 1 == (i2 & 1);
    }

    public final int zzb(int i2) {
        int i8 = this.zzc;
        int i9 = 8 - this.zzd;
        int i10 = i8 + 1;
        byte[] bArr = this.zza;
        int iMin = Math.min(i2, i9);
        int i11 = ((bArr[i8] & 255) >> this.zzd) & (255 >> (8 - iMin));
        while (iMin < i2) {
            i11 |= (bArr[i10] & 255) << iMin;
            iMin += 8;
            i10++;
        }
        int i12 = i11 & ((-1) >>> (32 - i2));
        zzc(i2);
        return i12;
    }

    public final void zzc(int i2) {
        int i8;
        int i9 = i2 / 8;
        int i10 = this.zzc + i9;
        this.zzc = i10;
        int i11 = (i2 - (i9 * 8)) + this.zzd;
        this.zzd = i11;
        if (i11 > 7) {
            i10++;
            this.zzc = i10;
            i11 -= 8;
            this.zzd = i11;
        }
        boolean z2 = false;
        if (i10 >= 0 && (i10 < (i8 = this.zzb) || (i10 == i8 && i11 == 0))) {
            z2 = true;
        }
        zzgmd.zzh(z2);
    }

    public final int zzd() {
        return (this.zzc * 8) + this.zzd;
    }
}
