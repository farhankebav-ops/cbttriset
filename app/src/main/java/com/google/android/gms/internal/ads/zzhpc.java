package com.google.android.gms.internal.ads;

import java.math.BigInteger;
import java.security.GeneralSecurityException;
import java.security.InvalidAlgorithmParameterException;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes4.dex */
public final class zzhpc {
    private static final BigInteger zzg;
    private static final BigInteger zzh;
    private Integer zza = null;
    private BigInteger zzb = zzhpf.zza;
    private zzhpd zzc = null;
    private zzhpd zzd = null;
    private Integer zze = null;
    private zzhpe zzf = zzhpe.zzd;

    static {
        BigInteger bigIntegerValueOf = BigInteger.valueOf(2L);
        zzg = bigIntegerValueOf;
        zzh = bigIntegerValueOf.pow(256);
    }

    private zzhpc() {
    }

    public final zzhpc zza(int i2) {
        this.zza = Integer.valueOf(i2);
        return this;
    }

    public final zzhpc zzb(BigInteger bigInteger) {
        this.zzb = bigInteger;
        return this;
    }

    public final zzhpc zzc(zzhpe zzhpeVar) {
        this.zzf = zzhpeVar;
        return this;
    }

    public final zzhpc zzd(zzhpd zzhpdVar) {
        this.zzc = zzhpdVar;
        return this;
    }

    public final zzhpc zze(zzhpd zzhpdVar) {
        this.zzd = zzhpdVar;
        return this;
    }

    public final zzhpc zzf(int i2) throws GeneralSecurityException {
        if (i2 < 0) {
            throw new GeneralSecurityException(String.format("Invalid salt length in bytes %d; salt length must be positive", Integer.valueOf(i2)));
        }
        this.zze = Integer.valueOf(i2);
        return this;
    }

    public final zzhpf zzg() throws GeneralSecurityException {
        Integer num = this.zza;
        if (num == null) {
            throw new GeneralSecurityException("key size is not set");
        }
        if (this.zzb == null) {
            throw new GeneralSecurityException("publicExponent is not set");
        }
        if (this.zzc == null) {
            throw new GeneralSecurityException("signature hash type is not set");
        }
        if (this.zzd == null) {
            throw new GeneralSecurityException("mgf1 hash type is not set");
        }
        if (this.zzf == null) {
            throw new GeneralSecurityException("variant is not set");
        }
        if (this.zze == null) {
            throw new GeneralSecurityException("salt length is not set");
        }
        if (num.intValue() < 2048) {
            throw new InvalidAlgorithmParameterException(String.format("Invalid key size in bytes %d; must be at least %d bits", this.zza, 2048));
        }
        if (this.zzc != this.zzd) {
            throw new GeneralSecurityException("MGF1 hash is different from signature hash");
        }
        BigInteger bigInteger = this.zzb;
        int iCompareTo = bigInteger.compareTo(zzhpf.zza);
        if (iCompareTo != 0) {
            if (iCompareTo < 0) {
                throw new InvalidAlgorithmParameterException("Public exponent must be at least 65537.");
            }
            if (bigInteger.mod(zzg).equals(BigInteger.ZERO)) {
                throw new InvalidAlgorithmParameterException("Invalid public exponent");
            }
            if (bigInteger.compareTo(zzh) > 0) {
                throw new InvalidAlgorithmParameterException("Public exponent cannot be larger than 2^256.");
            }
        }
        return new zzhpf(this.zza.intValue(), this.zzb, this.zzf, this.zzc, this.zzd, this.zze.intValue(), null);
    }

    public /* synthetic */ zzhpc(byte[] bArr) {
    }
}
