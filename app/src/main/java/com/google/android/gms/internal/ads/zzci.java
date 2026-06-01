package com.google.android.gms.internal.ads;

import java.nio.ShortBuffer;
import java.util.Arrays;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes4.dex */
final class zzci {
    private final int zza;
    private final int zzb;
    private final float zzc;
    private final float zzd;
    private final float zze;
    private final int zzf;
    private final int zzg;
    private final int zzh;
    private final short[] zzi;
    private short[] zzj;
    private int zzk;
    private short[] zzl;
    private int zzm;
    private short[] zzn;
    private int zzo;
    private int zzp;
    private int zzq;
    private int zzr;
    private int zzs;
    private int zzt;
    private int zzu;
    private int zzv;
    private double zzw;

    public zzci(int i2, int i8, float f4, float f8, int i9) {
        this.zza = i2;
        this.zzb = i8;
        this.zzc = f4;
        this.zzd = f8;
        this.zze = i2 / i9;
        this.zzf = i2 / 400;
        int i10 = i2 / 65;
        this.zzg = i10;
        int i11 = i10 + i10;
        this.zzh = i11;
        this.zzi = new short[i11];
        int i12 = i11 * i8;
        this.zzj = new short[i12];
        this.zzl = new short[i12];
        this.zzn = new short[i12];
    }

    private final short[] zzg(short[] sArr, int i2, int i8) {
        int length = sArr.length;
        int i9 = this.zzb;
        int i10 = length / i9;
        return i2 + i8 <= i10 ? sArr : Arrays.copyOf(sArr, (((i10 * 3) / 2) + i8) * i9);
    }

    private final void zzh(short[] sArr, int i2, int i8) {
        short[] sArrZzg = zzg(this.zzl, this.zzm, i8);
        this.zzl = sArrZzg;
        int i9 = this.zzm;
        int i10 = this.zzb;
        System.arraycopy(sArr, i2 * i10, sArrZzg, i9 * i10, i8 * i10);
        this.zzm += i8;
    }

    private final void zzi(short[] sArr, int i2, int i8) {
        int i9;
        for (int i10 = 0; i10 < this.zzh / i8; i10++) {
            int i11 = 0;
            int i12 = 0;
            while (true) {
                int i13 = this.zzb;
                i9 = i13 * i8;
                if (i11 < i9) {
                    i12 += sArr[(i9 * i10) + (i13 * i2) + i11];
                    i11++;
                }
            }
            this.zzi[i10] = (short) (i12 / i9);
        }
    }

    private final int zzj(short[] sArr, int i2, int i8, int i9) {
        int i10 = 1;
        int i11 = 255;
        int i12 = 0;
        int i13 = 0;
        while (i8 <= i9) {
            int iAbs = 0;
            for (int i14 = 0; i14 < i8; i14++) {
                int i15 = this.zzb * i2;
                iAbs += Math.abs(sArr[i15 + i14] - sArr[(i15 + i8) + i14]);
            }
            int i16 = iAbs * i12;
            int i17 = i10 * i8;
            if (i16 < i17) {
                i10 = iAbs;
            }
            if (i16 < i17) {
                i12 = i8;
            }
            int i18 = iAbs * i11;
            int i19 = i13 * i8;
            if (i18 > i19) {
                i13 = iAbs;
            }
            if (i18 > i19) {
                i11 = i8;
            }
            i8++;
        }
        this.zzu = i10 / i12;
        this.zzv = i13 / i11;
        return i12;
    }

    /* JADX WARN: Removed duplicated region for block: B:27:0x0086  */
    /* JADX WARN: Removed duplicated region for block: B:39:0x00a6  */
    /* JADX WARN: Removed duplicated region for block: B:42:0x00ae  */
    /* JADX WARN: Removed duplicated region for block: B:52:0x00c3  */
    /* JADX WARN: Removed duplicated region for block: B:55:0x00d5  */
    /* JADX WARN: Removed duplicated region for block: B:60:0x012c  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private final void zzk() {
        /*
            Method dump skipped, instruction units count: 676
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzci.zzk():void");
    }

    private static void zzl(int i2, int i8, short[] sArr, int i9, short[] sArr2, int i10, short[] sArr3, int i11) {
        for (int i12 = 0; i12 < i8; i12++) {
            int i13 = (i10 * i8) + i12;
            int i14 = (i11 * i8) + i12;
            int i15 = (i9 * i8) + i12;
            for (int i16 = 0; i16 < i2; i16++) {
                sArr[i15] = (short) com.google.android.gms.ads.internal.client.a.w(sArr3[i14], i16, (i2 - i16) * sArr2[i13], i2);
                i15 += i8;
                i13 += i8;
                i14 += i8;
            }
        }
    }

    public final int zza() {
        int i2 = this.zzk * this.zzb;
        return i2 + i2;
    }

    public final void zzb(ShortBuffer shortBuffer) {
        int iRemaining = shortBuffer.remaining();
        int i2 = this.zzb;
        int i8 = iRemaining / i2;
        int i9 = i8 * i2;
        short[] sArrZzg = zzg(this.zzj, this.zzk, i8);
        this.zzj = sArrZzg;
        shortBuffer.get(sArrZzg, this.zzk * i2, (i9 + i9) / 2);
        this.zzk += i8;
        zzk();
    }

    public final void zzc(ShortBuffer shortBuffer) {
        zzgmd.zzh(this.zzm >= 0);
        int iRemaining = shortBuffer.remaining();
        int i2 = this.zzb;
        int iMin = Math.min(iRemaining / i2, this.zzm);
        int i8 = iMin * i2;
        shortBuffer.put(this.zzl, 0, i8);
        int i9 = this.zzm - iMin;
        this.zzm = i9;
        short[] sArr = this.zzl;
        System.arraycopy(sArr, i8, sArr, 0, i9 * i2);
    }

    public final void zzd() {
        int i2 = this.zzk;
        int i8 = this.zzr;
        int i9 = this.zzm;
        float f4 = this.zzc;
        float f8 = this.zzd;
        int i10 = i9 + ((int) ((((((((double) (i2 - i8)) / ((double) (f4 / f8))) + ((double) i8)) + this.zzw) + ((double) this.zzo)) / ((double) (this.zze * f8))) + 0.5d));
        this.zzw = 0.0d;
        int i11 = this.zzh;
        int i12 = i11 + i11;
        this.zzj = zzg(this.zzj, i2, i2 + i12);
        int i13 = 0;
        while (true) {
            int i14 = this.zzb;
            if (i13 >= i12 * i14) {
                break;
            }
            this.zzj[(i14 * i2) + i13] = 0;
            i13++;
        }
        this.zzk += i12;
        zzk();
        if (this.zzm > i10) {
            this.zzm = Math.max(i10, 0);
        }
        this.zzk = 0;
        this.zzr = 0;
        this.zzo = 0;
    }

    public final void zze() {
        this.zzk = 0;
        this.zzm = 0;
        this.zzo = 0;
        this.zzp = 0;
        this.zzq = 0;
        this.zzr = 0;
        this.zzs = 0;
        this.zzt = 0;
        this.zzu = 0;
        this.zzv = 0;
        this.zzw = 0.0d;
    }

    public final int zzf() {
        zzgmd.zzh(this.zzm >= 0);
        int i2 = this.zzm * this.zzb;
        return i2 + i2;
    }
}
