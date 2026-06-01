package com.google.android.gms.internal.ads;

import java.security.GeneralSecurityException;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes4.dex */
public final class zzhpo {
    static {
        int i2 = zzhlv.zza;
        try {
            zza();
        } catch (GeneralSecurityException e) {
            throw new ExceptionInInitializerError(e);
        }
    }

    public static void zza() throws GeneralSecurityException {
        zzhol.zzc();
        zzhop.zzc();
        zzhnj.zza(true);
        zzhpb.zza(true);
        zzhpn.zza(true);
        if (zzhcz.zza()) {
            return;
        }
        zzhnr.zza(true);
    }
}
