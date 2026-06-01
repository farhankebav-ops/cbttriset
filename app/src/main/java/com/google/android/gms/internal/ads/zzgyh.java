package com.google.android.gms.internal.ads;

import java.security.GeneralSecurityException;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes4.dex */
public final class zzgyh {
    private zzgyp zza = null;
    private zzhtb zzb = null;
    private Integer zzc = null;

    private zzgyh() {
    }

    public final zzgyh zza(zzgyp zzgypVar) {
        this.zza = zzgypVar;
        return this;
    }

    public final zzgyh zzb(zzhtb zzhtbVar) {
        this.zzb = zzhtbVar;
        return this;
    }

    public final zzgyh zzc(Integer num) {
        this.zzc = num;
        return this;
    }

    public final zzgyi zzd() throws GeneralSecurityException {
        zzhtb zzhtbVar;
        zzhsz zzhszVarZzb;
        zzgyp zzgypVar = this.zza;
        if (zzgypVar == null || (zzhtbVar = this.zzb) == null) {
            throw new GeneralSecurityException("Cannot build without parameters and/or key material");
        }
        if (zzgypVar.zzc() != zzhtbVar.zzd()) {
            throw new GeneralSecurityException("Key size mismatch");
        }
        if (zzgypVar.zza() && this.zzc == null) {
            throw new GeneralSecurityException("Cannot create key without ID requirement with parameters with ID requirement");
        }
        if (!this.zza.zza() && this.zzc != null) {
            throw new GeneralSecurityException("Cannot create key with ID requirement with parameters without ID requirement");
        }
        if (this.zza.zzd() == zzgyo.zzc) {
            zzhszVarZzb = zzhfc.zza;
        } else if (this.zza.zzd() == zzgyo.zzb) {
            zzhszVarZzb = zzhfc.zza(this.zzc.intValue());
        } else {
            if (this.zza.zzd() != zzgyo.zza) {
                throw new IllegalStateException("Unknown AesGcmSivParameters.Variant: ".concat(String.valueOf(this.zza.zzd())));
            }
            zzhszVarZzb = zzhfc.zzb(this.zzc.intValue());
        }
        return new zzgyi(this.zza, this.zzb, zzhszVarZzb, this.zzc, null);
    }

    public /* synthetic */ zzgyh(byte[] bArr) {
    }
}
