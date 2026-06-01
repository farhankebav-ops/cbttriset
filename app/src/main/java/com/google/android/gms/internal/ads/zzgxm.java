package com.google.android.gms.internal.ads;

import java.security.GeneralSecurityException;
import java.security.InvalidAlgorithmParameterException;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes4.dex */
public final class zzgxm {
    private Integer zza = null;
    private Integer zzb = null;
    private Integer zzc = null;
    private Integer zzd = null;
    private zzgxn zze = null;
    private zzgxo zzf = zzgxo.zzc;

    private zzgxm() {
    }

    public final zzgxm zza(int i2) throws GeneralSecurityException {
        if (i2 != 16 && i2 != 24 && i2 != 32) {
            throw new InvalidAlgorithmParameterException(String.format("Invalid key size %d; only 16-byte, 24-byte and 32-byte AES keys are supported", Integer.valueOf(i2)));
        }
        this.zza = Integer.valueOf(i2);
        return this;
    }

    public final zzgxm zzb(int i2) throws GeneralSecurityException {
        if (i2 < 16) {
            throw new InvalidAlgorithmParameterException(String.format("Invalid key size in bytes %d; HMAC key must be at least 16 bytes", Integer.valueOf(i2)));
        }
        this.zzb = Integer.valueOf(i2);
        return this;
    }

    public final zzgxm zzc(int i2) throws GeneralSecurityException {
        if (i2 < 12 || i2 > 16) {
            throw new GeneralSecurityException(String.format("Invalid IV size in bytes %d; IV size must be between 12 and 16 bytes", Integer.valueOf(i2)));
        }
        this.zzc = Integer.valueOf(i2);
        return this;
    }

    public final zzgxm zzd(int i2) throws GeneralSecurityException {
        if (i2 < 10) {
            throw new GeneralSecurityException(String.format("Invalid tag size in bytes %d; must be at least 10 bytes", Integer.valueOf(i2)));
        }
        this.zzd = Integer.valueOf(i2);
        return this;
    }

    public final zzgxm zze(zzgxo zzgxoVar) {
        this.zzf = zzgxoVar;
        return this;
    }

    public final zzgxm zzf(zzgxn zzgxnVar) {
        this.zze = zzgxnVar;
        return this;
    }

    public final zzgxp zzg() throws GeneralSecurityException {
        if (this.zza == null) {
            throw new GeneralSecurityException("AES key size is not set");
        }
        if (this.zzb == null) {
            throw new GeneralSecurityException("HMAC key size is not set");
        }
        if (this.zzc == null) {
            throw new GeneralSecurityException("iv size is not set");
        }
        Integer num = this.zzd;
        if (num == null) {
            throw new GeneralSecurityException("tag size is not set");
        }
        if (this.zze == null) {
            throw new GeneralSecurityException("hash type is not set");
        }
        if (this.zzf == null) {
            throw new GeneralSecurityException("variant is not set");
        }
        int iIntValue = num.intValue();
        zzgxn zzgxnVar = this.zze;
        if (zzgxnVar == zzgxn.zza) {
            if (iIntValue > 20) {
                throw new GeneralSecurityException(String.format("Invalid tag size in bytes %d; can be at most 20 bytes for SHA1", num));
            }
        } else if (zzgxnVar == zzgxn.zzb) {
            if (iIntValue > 28) {
                throw new GeneralSecurityException(String.format("Invalid tag size in bytes %d; can be at most 28 bytes for SHA224", num));
            }
        } else if (zzgxnVar == zzgxn.zzc) {
            if (iIntValue > 32) {
                throw new GeneralSecurityException(String.format("Invalid tag size in bytes %d; can be at most 32 bytes for SHA256", num));
            }
        } else if (zzgxnVar == zzgxn.zzd) {
            if (iIntValue > 48) {
                throw new GeneralSecurityException(String.format("Invalid tag size in bytes %d; can be at most 48 bytes for SHA384", num));
            }
        } else {
            if (zzgxnVar != zzgxn.zze) {
                throw new GeneralSecurityException("unknown hash type; must be SHA1, SHA224, SHA256, SHA384 or SHA512");
            }
            if (iIntValue > 64) {
                throw new GeneralSecurityException(String.format("Invalid tag size in bytes %d; can be at most 64 bytes for SHA512", num));
            }
        }
        return new zzgxp(this.zza.intValue(), this.zzb.intValue(), this.zzc.intValue(), this.zzd.intValue(), this.zzf, this.zze, null);
    }

    public /* synthetic */ zzgxm(byte[] bArr) {
    }
}
