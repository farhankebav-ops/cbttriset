package com.google.android.gms.internal.ads;

import java.security.GeneralSecurityException;
import java.security.InvalidAlgorithmParameterException;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes4.dex */
public final class zzgyn {
    private Integer zza = null;
    private zzgyo zzb = zzgyo.zzc;

    private zzgyn() {
    }

    public final zzgyn zza(int i2) throws GeneralSecurityException {
        if (i2 != 16 && i2 != 32) {
            throw new InvalidAlgorithmParameterException(String.format("Invalid key size %d; only 16-byte and 32-byte AES keys are supported", Integer.valueOf(i2)));
        }
        this.zza = Integer.valueOf(i2);
        return this;
    }

    public final zzgyn zzb(zzgyo zzgyoVar) {
        this.zzb = zzgyoVar;
        return this;
    }

    public final zzgyp zzc() throws GeneralSecurityException {
        Integer num = this.zza;
        if (num == null) {
            throw new GeneralSecurityException("Key size is not set");
        }
        if (this.zzb != null) {
            return new zzgyp(num.intValue(), this.zzb, null);
        }
        throw new GeneralSecurityException("Variant is not set");
    }

    public /* synthetic */ zzgyn(byte[] bArr) {
    }
}
