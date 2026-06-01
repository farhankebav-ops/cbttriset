package com.google.android.gms.internal.ads;

import java.security.GeneralSecurityException;
import java.security.Provider;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes4.dex */
public final class zzhia implements zzhgs {
    public zzhia(zzhgk zzhgkVar) {
    }

    public static zzhgs zza(zzhgk zzhgkVar) throws GeneralSecurityException {
        if (!zzhcy.zza(1)) {
            throw new GeneralSecurityException("Cannot use AES-CMAC in FIPS-mode.");
        }
        Provider providerZza = zzhdc.zza();
        if (providerZza != null) {
            try {
                return zzhhz.zza(zzhgkVar, providerZza);
            } catch (GeneralSecurityException unused) {
            }
        }
        return new zzhia(zzhgkVar);
    }
}
