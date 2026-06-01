package com.google.android.gms.internal.ads;

import java.security.GeneralSecurityException;
import java.security.NoSuchAlgorithmException;
import java.security.Provider;
import javax.crypto.Mac;
import javax.crypto.spec.SecretKeySpec;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes4.dex */
public final class zzhhz implements zzhgs {
    private zzhhz(zzhgk zzhgkVar, Provider provider) throws GeneralSecurityException {
        if (!zzhcy.zza(1)) {
            throw new GeneralSecurityException("Cannot use AES-CMAC in FIPS-mode.");
        }
        try {
            Mac.getInstance("AESCMAC", provider);
            zzhgkVar.zze().zzc();
            zzhgkVar.zzf();
            new SecretKeySpec(zzhgkVar.zzd().zzc(zzgvr.zza()), "AES");
        } catch (NoSuchAlgorithmException e) {
            throw new GeneralSecurityException("AES-CMAC not available.", e);
        }
    }

    public static zzhgs zza(zzhgk zzhgkVar, Provider provider) throws GeneralSecurityException {
        return new zzhhz(zzhgkVar, provider);
    }
}
