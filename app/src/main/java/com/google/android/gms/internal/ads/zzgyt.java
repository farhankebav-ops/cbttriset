package com.google.android.gms.internal.ads;

import java.security.GeneralSecurityException;
import java.util.Collections;
import java.util.HashMap;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes4.dex */
public final class zzgyt {
    public static final /* synthetic */ int zza = 0;
    private static final zzhfp zzb = zzhfp.zzd(zzgys.zza, zzgyq.class, zzgvm.class);
    private static final zzheq zzc = zzgyr.zza;
    private static final zzgvu zzd = zzhef.zze("type.googleapis.com/google.crypto.tink.ChaCha20Poly1305Key", zzgvm.class, zzhkw.SYMMETRIC, zzhjv.zze());

    public static void zza(boolean z2) throws GeneralSecurityException {
        if (!zzhcy.zza(1)) {
            throw new GeneralSecurityException("Registering ChaCha20Poly1305 is not supported in FIPS mode");
        }
        int i2 = zzhbw.zza;
        zzhbw.zza(zzhfb.zza());
        zzhey.zza().zzb(zzb);
        zzhes.zza().zzb(zzc, zzgyv.class);
        zzhex zzhexVarZza = zzhex.zza();
        HashMap map = new HashMap();
        map.put("CHACHA20_POLY1305", zzgyv.zzb(zzgyu.zza));
        map.put("CHACHA20_POLY1305_RAW", zzgyv.zzb(zzgyu.zzc));
        zzhexVarZza.zzd(Collections.unmodifiableMap(map));
        zzhdw.zza().zzb(zzd, true);
    }
}
