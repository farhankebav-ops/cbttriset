package com.google.android.gms.internal.ads;

import java.security.GeneralSecurityException;
import java.security.InvalidAlgorithmParameterException;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes4.dex */
public final class zzgxv {
    private Integer zza = null;
    private Integer zzb = null;
    private Integer zzc = null;
    private zzgxw zzd = zzgxw.zzc;

    private zzgxv() {
    }

    public final zzgxv zza(int i2) throws GeneralSecurityException {
        if (i2 != 16 && i2 != 24 && i2 != 32) {
            throw new InvalidAlgorithmParameterException(String.format("Invalid key size %d; only 16-byte, 24-byte and 32-byte AES keys are supported", Integer.valueOf(i2)));
        }
        this.zza = Integer.valueOf(i2);
        return this;
    }

    public final zzgxv zzb(int i2) throws GeneralSecurityException {
        if (i2 != 12 && i2 != 16) {
            throw new GeneralSecurityException(String.format("Invalid IV size in bytes %d; acceptable values have 12 or 16 bytes", Integer.valueOf(i2)));
        }
        this.zzb = Integer.valueOf(i2);
        return this;
    }

    public final zzgxv zzc(int i2) throws GeneralSecurityException {
        this.zzc = 16;
        return this;
    }

    public final zzgxv zzd(zzgxw zzgxwVar) {
        this.zzd = zzgxwVar;
        return this;
    }

    public final zzgxx zze() throws GeneralSecurityException {
        Integer num = this.zza;
        if (num == null) {
            throw new GeneralSecurityException("Key size is not set");
        }
        if (this.zzb == null) {
            throw new GeneralSecurityException("IV size is not set");
        }
        if (this.zzd == null) {
            throw new GeneralSecurityException("Variant is not set");
        }
        if (this.zzc == null) {
            throw new GeneralSecurityException("Tag size is not set");
        }
        int iIntValue = num.intValue();
        int iIntValue2 = this.zzb.intValue();
        this.zzc.getClass();
        return new zzgxx(iIntValue, iIntValue2, 16, this.zzd, null);
    }

    public /* synthetic */ zzgxv(byte[] bArr) {
    }
}
