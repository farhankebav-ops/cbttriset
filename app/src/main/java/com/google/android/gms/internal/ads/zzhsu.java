package com.google.android.gms.internal.ads;

import java.math.BigInteger;
import java.security.GeneralSecurityException;
import java.security.MessageDigest;
import java.security.interfaces.RSAPublicKey;
import java.util.Arrays;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes4.dex */
final class zzhsu implements zzgwm {
    private final RSAPublicKey zza;
    private final zzhsi zzb;
    private final zzhsi zzc;
    private final int zzd;
    private final byte[] zze;
    private final byte[] zzf;

    public /* synthetic */ zzhsu(RSAPublicKey rSAPublicKey, zzhsi zzhsiVar, zzhsi zzhsiVar2, int i2, byte[] bArr, byte[] bArr2, byte[] bArr3) throws GeneralSecurityException {
        if (zzhcz.zza()) {
            throw new GeneralSecurityException("Can not use RSA PSS in FIPS-mode, as BoringCrypto module is not available.");
        }
        zzhsx.zzb(zzhsiVar);
        if (!zzhsiVar.equals(zzhsiVar2)) {
            throw new GeneralSecurityException("sigHash and mgf1Hash must be the same");
        }
        zzhsx.zzc(rSAPublicKey.getModulus().bitLength());
        zzhsx.zzd(rSAPublicKey.getPublicExponent());
        this.zza = rSAPublicKey;
        this.zzb = zzhsiVar;
        this.zzc = zzhsiVar2;
        this.zzd = i2;
        this.zze = bArr;
        this.zzf = bArr2;
    }

    private final void zzb(byte[] bArr, byte[] bArr2) throws GeneralSecurityException {
        RSAPublicKey rSAPublicKey = this.zza;
        BigInteger publicExponent = rSAPublicKey.getPublicExponent();
        BigInteger modulus = rSAPublicKey.getModulus();
        int iBitLength = modulus.bitLength() + 7;
        int iBitLength2 = modulus.bitLength() + 6;
        if (iBitLength / 8 != bArr.length) {
            throw new GeneralSecurityException("invalid signature's length");
        }
        BigInteger bigInteger = new BigInteger(1, bArr);
        if (bigInteger.compareTo(modulus) >= 0) {
            throw new GeneralSecurityException("signature out of range");
        }
        byte[] bArrZzb = zzhdb.zzb(bigInteger.modPow(publicExponent, modulus), iBitLength2 / 8);
        int iBitLength3 = modulus.bitLength() - 1;
        zzhsi zzhsiVar = this.zzb;
        zzhsx.zzb(zzhsiVar);
        zzhrz zzhrzVar = zzhrz.zzd;
        MessageDigest messageDigest = (MessageDigest) zzhrzVar.zzb(zzhsw.zzb(zzhsiVar));
        messageDigest.update(bArr2);
        byte[] bArr3 = this.zzf;
        if (bArr3.length != 0) {
            messageDigest.update(bArr3);
        }
        byte[] bArrDigest = messageDigest.digest();
        int digestLength = messageDigest.getDigestLength();
        int length = bArrZzb.length;
        int i2 = this.zzd;
        if (length < digestLength + i2 + 2) {
            throw new GeneralSecurityException("inconsistent");
        }
        if (bArrZzb[length - 1] != -68) {
            throw new GeneralSecurityException("inconsistent");
        }
        int i8 = length - digestLength;
        int i9 = i8 - 1;
        byte[] bArrCopyOf = Arrays.copyOf(bArrZzb, i9);
        int length2 = bArrCopyOf.length;
        byte[] bArrCopyOfRange = Arrays.copyOfRange(bArrZzb, length2, length2 + digestLength);
        int i10 = 0;
        while (true) {
            long j = (((long) length) * 8) - ((long) iBitLength3);
            if (i10 < j) {
                if (((bArrCopyOf[i10 / 8] >> (7 - (i10 % 8))) & 1) != 0) {
                    throw new GeneralSecurityException("inconsistent");
                }
                i10++;
            } else {
                MessageDigest messageDigest2 = (MessageDigest) zzhrzVar.zzb(zzhsw.zzb(this.zzc));
                int digestLength2 = messageDigest2.getDigestLength();
                byte[] bArr4 = new byte[i9];
                int i11 = 0;
                int i12 = 0;
                while (i11 <= (i8 - 2) / digestLength2) {
                    messageDigest2.reset();
                    messageDigest2.update(bArrCopyOfRange);
                    int i13 = i2;
                    messageDigest2.update(zzhdb.zzb(BigInteger.valueOf(i11), 4));
                    byte[] bArrDigest2 = messageDigest2.digest();
                    int length3 = bArrDigest2.length;
                    System.arraycopy(bArrDigest2, 0, bArr4, i12, Math.min(length3, i9 - i12));
                    i12 += length3;
                    i11++;
                    i2 = i13;
                    messageDigest2 = messageDigest2;
                }
                int i14 = i2;
                byte[] bArr5 = new byte[i9];
                for (int i15 = 0; i15 < i9; i15++) {
                    bArr5[i15] = (byte) (bArr4[i15] ^ bArrCopyOf[i15]);
                }
                for (int i16 = 0; i16 <= j; i16++) {
                    int i17 = i16 / 8;
                    bArr5[i17] = (byte) ((~(1 << (7 - (i16 % 8)))) & bArr5[i17]);
                }
                int i18 = 0;
                while (true) {
                    int i19 = (i8 - i14) - 2;
                    if (i18 >= i19) {
                        if (bArr5[i19] != 1) {
                            throw new GeneralSecurityException("inconsistent");
                        }
                        byte[] bArrCopyOfRange2 = Arrays.copyOfRange(bArr5, i9 - i14, i9);
                        int i20 = digestLength + 8;
                        byte[] bArr6 = new byte[i20 + i14];
                        System.arraycopy(bArrDigest, 0, bArr6, 8, bArrDigest.length);
                        System.arraycopy(bArrCopyOfRange2, 0, bArr6, i20, bArrCopyOfRange2.length);
                        if (!MessageDigest.isEqual(messageDigest.digest(bArr6), bArrCopyOfRange)) {
                            throw new GeneralSecurityException("inconsistent");
                        }
                        return;
                    }
                    if (bArr5[i18] != 0) {
                        throw new GeneralSecurityException("inconsistent");
                    }
                    i18++;
                }
            }
        }
    }

    @Override // com.google.android.gms.internal.ads.zzgwm
    public final void zza(byte[] bArr, byte[] bArr2) throws GeneralSecurityException {
        byte[] bArr3 = this.zze;
        int length = bArr3.length;
        if (length == 0) {
            zzb(bArr, bArr2);
        } else {
            if (!zzhgi.zze(bArr3, bArr)) {
                throw new GeneralSecurityException("Invalid signature (output prefix mismatch)");
            }
            zzb(Arrays.copyOfRange(bArr, length, bArr.length), bArr2);
        }
    }
}
