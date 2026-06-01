package com.google.android.gms.internal.ads;

import java.security.GeneralSecurityException;
import java.security.NoSuchAlgorithmException;
import java.security.spec.ECParameterSpec;
import java.util.Arrays;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes4.dex */
public final class zzhrt {
    public static byte[] zza(byte[] bArr) throws GeneralSecurityException {
        byte[] bArr2;
        int i2;
        int length = bArr.length;
        if ((length & 1) != 0 || length == 0 || length > 132) {
            throw new GeneralSecurityException("Invalid IEEE_P1363 encoding");
        }
        int i8 = length >> 1;
        byte[] bArrZzc = zzc(Arrays.copyOf(bArr, i8));
        byte[] bArrZzc2 = zzc(Arrays.copyOfRange(bArr, i8, length));
        int length2 = bArrZzc.length;
        int length3 = bArrZzc2.length;
        int i9 = length2 + 4 + length3;
        if (i9 >= 128) {
            bArr2 = new byte[i9 + 3];
            bArr2[0] = 48;
            bArr2[1] = -127;
            bArr2[2] = (byte) i9;
            i2 = 3;
        } else {
            bArr2 = new byte[i9 + 2];
            bArr2[0] = 48;
            bArr2[1] = (byte) i9;
            i2 = 2;
        }
        int i10 = i2 + 1;
        bArr2[i2] = 2;
        int i11 = i2 + 2;
        bArr2[i10] = (byte) length2;
        System.arraycopy(bArrZzc, 0, bArr2, i11, length2);
        int i12 = i11 + length2;
        bArr2[i12] = 2;
        bArr2[i12 + 1] = (byte) length3;
        System.arraycopy(bArrZzc2, 0, bArr2, i12 + 2, length3);
        return bArr2;
    }

    public static ECParameterSpec zzb(zzhrr zzhrrVar) throws NoSuchAlgorithmException {
        int iOrdinal = zzhrrVar.ordinal();
        if (iOrdinal == 0) {
            return zzhdn.zza;
        }
        if (iOrdinal == 1) {
            return zzhdn.zzb;
        }
        if (iOrdinal == 2) {
            return zzhdn.zzc;
        }
        throw new NoSuchAlgorithmException("curve not implemented:".concat(zzhrrVar.toString()));
    }

    private static byte[] zzc(byte[] bArr) {
        int length;
        int i2 = 0;
        while (true) {
            length = bArr.length;
            if (i2 >= length || bArr[i2] != 0) {
                break;
            }
            i2++;
        }
        if (i2 == length) {
            i2 = length - 1;
        }
        int i8 = (bArr[i2] & 128) == 128 ? 1 : 0;
        int i9 = length - i2;
        byte[] bArr2 = new byte[i9 + i8];
        System.arraycopy(bArr, i2, bArr2, i8, i9);
        return bArr2;
    }
}
