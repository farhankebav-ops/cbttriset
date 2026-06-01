package com.google.android.gms.internal.ads;

import java.security.GeneralSecurityException;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes4.dex */
public final class zzgyy {
    public static final /* synthetic */ int zza = 0;
    private static final zzhfp zzb = zzhfp.zzd(zzgyx.zza, zzgzd.class, zzgvm.class);
    private static final zzgvu zzc = zzhef.zze("type.googleapis.com/google.crypto.tink.KmsAeadKey", zzgvm.class, zzhkw.REMOTE, zzhlm.zze());
    private static final zzheq zzd = zzgyw.zza;

    public static void zza(boolean z2) throws GeneralSecurityException {
        if (!zzhcy.zza(1)) {
            throw new GeneralSecurityException("Registering KMS AEAD is not supported in FIPS mode");
        }
        int i2 = zzgzk.zza;
        zzgzk.zza(zzhfb.zza());
        zzhey.zza().zzb(zzb);
        zzhes.zza().zzb(zzd, zzgzf.class);
        zzhdw.zza().zzb(zzc, true);
    }
}
