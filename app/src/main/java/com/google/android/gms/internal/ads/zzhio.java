package com.google.android.gms.internal.ads;

import java.security.GeneralSecurityException;
import java.security.InvalidAlgorithmParameterException;
import java.util.Arrays;
import javax.crypto.Cipher;
import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes4.dex */
public final class zzhio implements zzhik {
    private static final ThreadLocal zzd = new zzhin();
    private final SecretKey zza;
    private final byte[] zzb;
    private final byte[] zzc;

    private zzhio(byte[] bArr) throws GeneralSecurityException {
        zzhsx.zza(bArr.length);
        SecretKeySpec secretKeySpec = new SecretKeySpec(bArr, "AES");
        this.zza = secretKeySpec;
        Cipher cipherZzc = zzc();
        cipherZzc.init(1, secretKeySpec);
        byte[] bArrZza = zzhhy.zza(cipherZzc.doFinal(new byte[16]));
        this.zzb = bArrZza;
        this.zzc = zzhhy.zza(bArrZza);
    }

    public static zzhik zzb(zzhii zzhiiVar) throws GeneralSecurityException {
        return new zzhio(zzhiiVar.zzd().zzc(zzgvr.zza()));
    }

    private static Cipher zzc() throws GeneralSecurityException {
        if (zzhcy.zza(1)) {
            return (Cipher) zzd.get();
        }
        throw new GeneralSecurityException("Can not use AES-CMAC in FIPS-mode.");
    }

    private static void zzd(byte[] bArr, byte[] bArr2, int i2, byte[] bArr3) {
        for (int i8 = 0; i8 < 16; i8++) {
            bArr3[i8] = (byte) (bArr[i8] ^ bArr2[i8 + i2]);
        }
    }

    @Override // com.google.android.gms.internal.ads.zzhik
    public final byte[] zza(byte[] bArr, int i2) throws GeneralSecurityException {
        byte[] bArrZzb;
        if (i2 > 16) {
            throw new InvalidAlgorithmParameterException("outputLength too large, max is 16 bytes");
        }
        SecretKey secretKey = this.zza;
        Cipher cipherZzc = zzc();
        cipherZzc.init(1, secretKey);
        int length = bArr.length;
        int i8 = length != 0 ? 1 + ((length - 1) >> 4) : 1;
        int i9 = i8 - 1;
        int i10 = i9 * 16;
        if (i8 * 16 == length) {
            bArrZzb = zzhrm.zzb(bArr, i10, this.zzb, 0, 16);
        } else {
            byte[] bArrCopyOfRange = Arrays.copyOfRange(bArr, i10, length);
            int length2 = bArrCopyOfRange.length;
            if (length2 >= 16) {
                throw new IllegalArgumentException("x must be smaller than a block.");
            }
            byte[] bArrCopyOf = Arrays.copyOf(bArrCopyOfRange, 16);
            bArrCopyOf[length2] = -128;
            byte[] bArr2 = this.zzc;
            if (bArrCopyOf.length != 16) {
                throw new IllegalArgumentException("The lengths of x and y should match.");
            }
            bArrZzb = zzhrm.zzb(bArrCopyOf, 0, bArr2, 0, 16);
        }
        byte[] bArr3 = new byte[16];
        byte[] bArr4 = new byte[16];
        for (int i11 = 0; i11 < i9; i11++) {
            zzd(bArr3, bArr, i11 * 16, bArr4);
            if (cipherZzc.doFinal(bArr4, 0, 16, bArr3) != 16) {
                throw new IllegalStateException("Cipher didn't write full block");
            }
        }
        zzd(bArr3, bArrZzb, 0, bArr4);
        if (cipherZzc.doFinal(bArr4, 0, 16, bArr3) == 16) {
            return i2 == 16 ? bArr3 : Arrays.copyOf(bArr3, i2);
        }
        throw new IllegalStateException("Cipher didn't write full block");
    }
}
