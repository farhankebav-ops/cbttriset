package com.google.android.gms.internal.ads;

import java.security.GeneralSecurityException;
import java.security.InvalidAlgorithmParameterException;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes4.dex */
public final class zzhgp {
    private Integer zza = null;
    private Integer zzb = null;
    private zzhgq zzc = zzhgq.zzd;

    private zzhgp() {
    }

    public final zzhgp zza(int i2) throws GeneralSecurityException {
        if (i2 != 16 && i2 != 32) {
            throw new InvalidAlgorithmParameterException(String.format("Invalid key size %d; only 128-bit and 256-bit AES keys are supported", Integer.valueOf(i2 * 8)));
        }
        this.zza = Integer.valueOf(i2);
        return this;
    }

    public final zzhgp zzb(int i2) throws GeneralSecurityException {
        if (i2 < 10 || i2 > 16) {
            throw new GeneralSecurityException(androidx.camera.core.processing.util.a.m(new StringBuilder(String.valueOf(i2).length() + 40), "Invalid tag size for AesCmacParameters: ", i2));
        }
        this.zzb = Integer.valueOf(i2);
        return this;
    }

    public final zzhgp zzc(zzhgq zzhgqVar) {
        this.zzc = zzhgqVar;
        return this;
    }

    public final zzhgr zzd() throws GeneralSecurityException {
        Integer num = this.zza;
        if (num == null) {
            throw new GeneralSecurityException("key size not set");
        }
        if (this.zzb == null) {
            throw new GeneralSecurityException("tag size not set");
        }
        if (this.zzc != null) {
            return new zzhgr(num.intValue(), this.zzb.intValue(), this.zzc, null);
        }
        throw new GeneralSecurityException("variant not set");
    }

    public /* synthetic */ zzhgp(byte[] bArr) {
    }
}
