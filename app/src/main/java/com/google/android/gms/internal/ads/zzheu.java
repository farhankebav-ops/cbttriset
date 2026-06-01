package com.google.android.gms.internal.ads;

import java.security.GeneralSecurityException;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes4.dex */
public final class zzheu {
    private static final zzheu zzb = new zzheu();
    private final Map zza = new HashMap();

    public static zzheu zza() {
        return zzb;
    }

    public final synchronized void zzb(zzhet zzhetVar, Class cls) throws GeneralSecurityException {
        try {
            Map map = this.zza;
            zzhet zzhetVar2 = (zzhet) map.get(cls);
            if (zzhetVar2 != null && !zzhetVar2.equals(zzhetVar)) {
                throw new GeneralSecurityException("Different key creator for parameters class already inserted");
            }
            map.put(cls, zzhetVar);
        } catch (Throwable th) {
            throw th;
        }
    }
}
