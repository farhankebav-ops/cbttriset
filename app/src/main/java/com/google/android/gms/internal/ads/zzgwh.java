package com.google.android.gms.internal.ads;

import java.security.GeneralSecurityException;
import java.util.concurrent.CopyOnWriteArrayList;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes4.dex */
public final class zzgwh {
    private static final CopyOnWriteArrayList zza = new CopyOnWriteArrayList();

    public static zzgwg zza(String str) throws GeneralSecurityException {
        for (zzgwg zzgwgVar : zza) {
            if (zzgwgVar.zza()) {
                return zzgwgVar;
            }
        }
        throw new GeneralSecurityException("No KMS client does support: ".concat(String.valueOf(str)));
    }
}
