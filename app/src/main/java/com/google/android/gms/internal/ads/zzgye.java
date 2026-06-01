package com.google.android.gms.internal.ads;

import java.security.GeneralSecurityException;
import java.security.InvalidAlgorithmParameterException;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes4.dex */
public final class zzgye {
    private Integer zza = null;
    private Integer zzb = null;
    private Integer zzc = null;
    private zzgyf zzd = zzgyf.zzc;

    private zzgye() {
    }

    public final zzgye zza(int i2) throws GeneralSecurityException {
        if (i2 != 16 && i2 != 24 && i2 != 32) {
            throw new InvalidAlgorithmParameterException(String.format("Invalid key size %d; only 16-byte, 24-byte and 32-byte AES keys are supported", Integer.valueOf(i2)));
        }
        this.zza = Integer.valueOf(i2);
        return this;
    }

    public final zzgye zzb(int i2) throws GeneralSecurityException {
        this.zzb = 12;
        return this;
    }

    public final zzgye zzc(int i2) throws GeneralSecurityException {
        this.zzc = 16;
        return this;
    }

    public final zzgye zzd(zzgyf zzgyfVar) {
        this.zzd = zzgyfVar;
        return this;
    }

    public final zzgyg zze() throws GeneralSecurityException {
        Integer num = this.zza;
        if (num == null) {
            throw new GeneralSecurityException("Key size is not set");
        }
        if (this.zzd == null) {
            throw new GeneralSecurityException("Variant is not set");
        }
        if (this.zzb == null) {
            throw new GeneralSecurityException("IV size is not set");
        }
        if (this.zzc == null) {
            throw new GeneralSecurityException("Tag size is not set");
        }
        int iIntValue = num.intValue();
        this.zzb.getClass();
        this.zzc.getClass();
        return new zzgyg(iIntValue, 12, 16, this.zzd, null);
    }

    public /* synthetic */ zzgye(byte[] bArr) {
    }
}
