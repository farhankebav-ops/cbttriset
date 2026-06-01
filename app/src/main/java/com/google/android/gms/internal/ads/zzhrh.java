package com.google.android.gms.internal.ads;

import java.security.GeneralSecurityException;
import javax.crypto.AEADBadTagException;
import javax.crypto.Cipher;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes4.dex */
public final class zzhrh implements zzgvm {
    private static final ThreadLocal zza = new zzhrg();
    private final byte[] zzb;
    private final zzhik zzc;
    private final SecretKeySpec zzd;
    private final int zze;

    private zzhrh(byte[] bArr, int i2, byte[] bArr2) throws GeneralSecurityException {
        if (!zzhcy.zza(1)) {
            throw new GeneralSecurityException("Can not use AES-EAX in FIPS-mode.");
        }
        if (i2 != 12 && i2 != 16) {
            throw new IllegalArgumentException("IV size should be either 12 or 16 bytes");
        }
        this.zze = i2;
        int length = bArr.length;
        zzhsx.zza(length);
        this.zzd = new SecretKeySpec(bArr, "AES");
        this.zzc = zzhsm.zzb(zzhii.zzc(zzhij.zzb(length), zzhtb.zza(bArr, zzgvr.zza())));
        this.zzb = bArr2;
    }

    public static zzgvm zzb(zzgxr zzgxrVar) throws GeneralSecurityException {
        if (!zzhcy.zza(1)) {
            throw new GeneralSecurityException("Can not use AES-EAX in FIPS-mode.");
        }
        zzgxrVar.zzf();
        return new zzhrh(zzgxrVar.zze().zzc(zzgvr.zza()), zzgxrVar.zzf().zzd(), zzgxrVar.zzc().zzc());
    }

    private final byte[] zzc(int i2, byte[] bArr, int i8, int i9) throws GeneralSecurityException {
        byte[] bArr2 = new byte[i9 + 16];
        bArr2[15] = (byte) i2;
        System.arraycopy(bArr, i8, bArr2, 16, i9);
        return this.zzc.zza(bArr2, 16);
    }

    @Override // com.google.android.gms.internal.ads.zzgvm
    public final byte[] zza(byte[] bArr, byte[] bArr2) throws GeneralSecurityException {
        byte[] bArr3 = this.zzb;
        int length = bArr.length;
        int length2 = bArr3.length;
        int i2 = this.zze;
        int i8 = ((length - length2) - i2) - 16;
        if (i8 < 0) {
            throw new GeneralSecurityException("ciphertext too short");
        }
        if (!zzhgi.zze(bArr3, bArr)) {
            throw new GeneralSecurityException("Decryption failed (OutputPrefix mismatch).");
        }
        byte[] bArrZzc = zzc(0, bArr, length2, i2);
        if (bArr2 == null) {
            bArr2 = new byte[0];
        }
        byte[] bArrZzc2 = zzc(1, bArr2, 0, bArr2.length);
        byte[] bArrZzc3 = zzc(2, bArr, length2 + i2, i8);
        int i9 = length - 16;
        byte b8 = 0;
        for (int i10 = 0; i10 < 16; i10++) {
            b8 = (byte) (b8 | (((bArr[i9 + i10] ^ bArrZzc2[i10]) ^ bArrZzc[i10]) ^ bArrZzc3[i10]));
        }
        if (b8 != 0) {
            throw new AEADBadTagException("tag mismatch");
        }
        Cipher cipher = (Cipher) zza.get();
        cipher.init(1, this.zzd, new IvParameterSpec(bArrZzc));
        return cipher.doFinal(bArr, bArr3.length + i2, i8);
    }
}
