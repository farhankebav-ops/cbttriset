package com.google.android.gms.internal.ads;

import java.math.RoundingMode;
import java.util.Arrays;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes4.dex */
final class zzgru {
    final int zza;
    final int zzb;
    final int zzc;
    final int zzd;
    private final String zze;
    private final char[] zzf;
    private final byte[] zzg;
    private final boolean[] zzh;
    private final boolean zzi;

    /* JADX WARN: Illegal instructions before constructor call */
    public zzgru(String str, char[] cArr) {
        byte[] bArr = new byte[128];
        Arrays.fill(bArr, (byte) -1);
        for (int i2 = 0; i2 < cArr.length; i2++) {
            char c7 = cArr[i2];
            boolean z2 = true;
            zzgmd.zzc(c7 < 128, "Non-ASCII character: %s", c7);
            if (bArr[c7] != -1) {
                z2 = false;
            }
            zzgmd.zzc(z2, "Duplicate character: %s", c7);
            bArr[c7] = (byte) i2;
        }
        this(str, cArr, bArr, false);
    }

    public final boolean equals(Object obj) {
        if (obj instanceof zzgru) {
            zzgru zzgruVar = (zzgru) obj;
            if (this.zzi == zzgruVar.zzi && Arrays.equals(this.zzf, zzgruVar.zzf)) {
                return true;
            }
        }
        return false;
    }

    public final int hashCode() {
        return Arrays.hashCode(this.zzf) + (true != this.zzi ? 1237 : 1231);
    }

    public final String toString() {
        return this.zze;
    }

    public final char zza(int i2) {
        return this.zzf[i2];
    }

    public final boolean zzb(int i2) {
        return this.zzh[i2 % this.zzc];
    }

    public final int zzc(char c7) throws zzgrx {
        if (c7 > 127) {
            throw new zzgrx("Unrecognized character: 0x".concat(String.valueOf(Integer.toHexString(c7))));
        }
        byte b8 = this.zzg[c7];
        if (b8 != -1) {
            return b8;
        }
        if (c7 <= ' ' || c7 == 127) {
            throw new zzgrx("Unrecognized character: 0x".concat(String.valueOf(Integer.toHexString(c7))));
        }
        throw new zzgrx(a1.a.e(c7, "Unrecognized character: ", new StringBuilder(String.valueOf(c7).length() + 24)));
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r5v11 */
    public final zzgru zzd() {
        boolean z2;
        int i2 = 0;
        while (true) {
            char[] cArr = this.zzf;
            int length = cArr.length;
            if (i2 >= length) {
                return this;
            }
            if (zzglm.zzd(cArr[i2])) {
                int i8 = 0;
                while (true) {
                    if (i8 >= length) {
                        z2 = false;
                        break;
                    }
                    if (zzglm.zzc(cArr[i8])) {
                        z2 = true;
                        break;
                    }
                    i8++;
                }
                zzgmd.zzi(!z2, "Cannot call lowerCase() on a mixed-case alphabet");
                char[] cArr2 = new char[cArr.length];
                for (int i9 = 0; i9 < cArr.length; i9++) {
                    char c7 = cArr[i9];
                    if (zzglm.zzd(c7)) {
                        c7 ^= 32;
                    }
                    cArr2[i9] = (char) c7;
                }
                zzgru zzgruVar = new zzgru(this.zze.concat(".lowerCase()"), cArr2);
                if (!this.zzi || zzgruVar.zzi) {
                    return zzgruVar;
                }
                byte[] bArr = zzgruVar.zzg;
                byte[] bArrCopyOf = Arrays.copyOf(bArr, bArr.length);
                for (int i10 = 65; i10 <= 90; i10++) {
                    int i11 = i10 | 32;
                    byte b8 = bArr[i10];
                    byte b9 = bArr[i11];
                    if (b8 == -1) {
                        bArrCopyOf[i10] = b9;
                    } else {
                        char c8 = (char) i10;
                        char c9 = (char) i11;
                        if (b9 != -1) {
                            throw new IllegalStateException(zzgmu.zzd("Can't ignoreCase() since '%s' and '%s' encode different values", Character.valueOf(c8), Character.valueOf(c9)));
                        }
                        bArrCopyOf[i11] = b8;
                    }
                }
                return new zzgru(zzgruVar.zze.concat(".ignoreCase()"), zzgruVar.zzf, bArrCopyOf, true);
            }
            i2++;
        }
    }

    public final boolean zze(char c7) {
        byte[] bArr = this.zzg;
        return bArr.length > 61 && bArr[61] != -1;
    }

    public final /* synthetic */ char[] zzf() {
        return this.zzf;
    }

    private zzgru(String str, char[] cArr, byte[] bArr, boolean z2) {
        this.zze = str;
        cArr.getClass();
        this.zzf = cArr;
        try {
            int length = cArr.length;
            int iZza = zzgsm.zza(length, RoundingMode.UNNECESSARY);
            this.zzb = iZza;
            int iNumberOfTrailingZeros = Integer.numberOfTrailingZeros(iZza);
            int i2 = 1 << (3 - iNumberOfTrailingZeros);
            this.zzc = i2;
            this.zzd = iZza >> iNumberOfTrailingZeros;
            this.zza = length - 1;
            this.zzg = bArr;
            boolean[] zArr = new boolean[i2];
            for (int i8 = 0; i8 < this.zzd; i8++) {
                zArr[zzgsm.zzb(i8 * 8, this.zzb, RoundingMode.CEILING)] = true;
            }
            this.zzh = zArr;
            this.zzi = z2;
        } catch (ArithmeticException e) {
            int length2 = cArr.length;
            throw new IllegalArgumentException(androidx.camera.core.processing.util.a.m(new StringBuilder(String.valueOf(length2).length() + 24), "Illegal alphabet length ", length2), e);
        }
    }
}
